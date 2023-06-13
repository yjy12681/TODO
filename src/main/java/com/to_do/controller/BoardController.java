package com.to_do.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.to_do.board.model.BoardVO;
import com.to_do.board.service.BoardService;
import com.to_do.board.service.BoardServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet("*.board")
public class BoardController extends HttpServlet {
    private static final long serialVersionUID = 1L;

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

        HttpSession session = request.getSession();
        BoardService service = new BoardServiceImpl();

        // 일 작성 화면 처리
        if (command.equals("/board/board_write.board")) {

            request.getRequestDispatcher("board_write.jsp").forward(request, response);
            // 일 등록
        } else if (command.equals("/board/writeForm.board")) {
            service.write(request, response);

            response.sendRedirect("/index.board");
            // 일 수정 화면
        } else if (command.equals("/board/board_modify.board")) {

            BoardVO vo = service.getContent(request, response);
            request.setAttribute("vo", vo);

            request.getRequestDispatcher("board_modify.jsp").forward(request, response);
            // 	일 수정
        } else if (command.equals("/board/board_update.board")) {

            service.update(request, response);

            response.sendRedirect("/index.user");

            // 일 삭제
        } else if (command.equals("/board/board_delete.board")) {

            service.delete(request, response);

            response.sendRedirect("/index.user");

            // 로그인 시 홈 화면
        } else if (command.equals("/index.board")) {

            List<BoardVO> todo = service.getList(request, response);

            List<BoardVO> over = service.getOverList(request, response);

            request.setAttribute("todo", todo);
            request.setAttribute("over", over);

            request.getRequestDispatcher("index.jsp").forward(request, response);

        } else if (command.equals("/home.board")) {

            String id = (String) session.getAttribute("user_id");

            if (id != null) {
                response.sendRedirect("index.board");
            } else {
                response.sendRedirect("home.jsp");
            }
        }

    }
}
