package com.to_do.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.to_do.board.model.BoardVO;
import com.to_do.board.service.BoardService;
import com.to_do.board.service.BoardServiceImpl;
import com.to_do.user.model.UserVO;
import com.to_do.user.service.UserService;
import com.to_do.user.service.UserServiceImpl;



@WebServlet("*.user")
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public UserController() {
		super();

	}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doAction(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doAction(request, response);
    }
    
    protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());

		System.out.println(command);

		UserService service = new UserServiceImpl();
		HttpSession session = request.getSession();

		if (command.equals("/user/user_join.user")) {//회원가입으로 이동

			request.getRequestDispatcher("/user/user_join.jsp").forward(request, response);

			// 회원가입 처리
		} else if (command.equals("/user/joinForm.user")) {

			int result = service.join(request, response);

			if (result == 1) {//회원가입 실패
				request.setAttribute("msg", "중복된 아이디 입니다");

				request.getRequestDispatcher("user_join.jsp").forward(request, response);
			} else { //회원가입 성공
				response.sendRedirect("user_login.user");
			}

			// 로그인 화면
		} else if (command.equals("/user/user_login.user")) {

			request.getRequestDispatcher("user_login.jsp").forward(request, response);

			// 로그인 처리
		} else if (command.equals("/user/loginForm.user")) {

			UserVO vo = service.login(request, response);

			if (vo == null) {//로그인실패
				request.setAttribute("msg", "아이디 또는 비밀번호를 확인하세요");
				request.getRequestDispatcher("user_login.jsp").forward(request, response);
			} else {//로그인성공
				session.setAttribute("user_id", vo.getId());
				session.setAttribute("user_name", vo.getName());
				response.sendRedirect("/index.board");
			}

			// 마이페이지 화면
		} else if (command.equals("/user/user_mypage.user")) {
			request.getRequestDispatcher("user_mypage.jsp").forward(request, response);

			// 회원 정보 수정 화면
		} else if (command.equals("/user/user_modify.user")) {
			UserVO vo = service.getInfo(request, response);

			request.setAttribute("vo", vo);

			request.getRequestDispatcher("user_modify.jsp").forward(request, response);

			// 회원 정보 수정 처리
		} else if (command.equals("/user/user_update.user")) {

			int result = service.updateInfo(request, response);

			if (result == 1) {
				// 이름 받아서 세션의 user_name 업데이트
				String name = request.getParameter("name");
				session.setAttribute("user_name", name);

				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('회원 정보가 변경되었습니다.')");
				out.println("location.href='user_mypage.user';");
				out.println("</script>");
			} else {
				response.sendRedirect("user_modify.user");
			}

			// 로그 아웃
		} else if (command.equals("/user/user_logout.user")) {

			session.invalidate();
			response.sendRedirect("user_login.user");

			// 회원 탈퇴
		} else if (command.equals("/user/user_delete.user")) {

			int result = service.deleteInfo(request, response);

			if (result == 1) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('회원 정보가 삭제되었습니다.')");
				out.println("location.href='/board/board_deleteAll.board';");
				out.println("</script>");
			} else {
				response.sendRedirect("user_mypage.user");
			}
		}
	}
}
