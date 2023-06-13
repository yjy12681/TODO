package com.to_do.user.service;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.to_do.user.model.UserDAO;
import com.to_do.user.model.UserVO;

public class UserServiceImpl implements UserService{

	@Override
	public int join(HttpServletRequest request, HttpServletResponse response) {				
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phoneNumber = request.getParameter("phoneNumber");
		String email = request.getParameter("email");

		UserDAO dao = UserDAO.getInstance();
		int result = dao.idCheck(id);

		if(result == 1) {
			return 1;
		}else {
			UserVO vo = new UserVO(id,pw,name,phoneNumber,email);
			dao.join(vo);
			return 0;
		}
		
		
		
	}

	@Override
	public UserVO login(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		UserDAO dao = UserDAO.getInstance();
		UserVO vo = dao.login(id, pw);
		
		return vo;
	}
	
	//회원 정보 가져오는 메서드
	@Override
	public UserVO getInfo(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("user_id");
		
		UserDAO dao = UserDAO.getInstance();
		UserVO vo = dao.getInfo(id);
		
		
		return vo;
	} // getInfo 끝

	// 회원 정보 수정
	@Override
	public int updateInfo(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phoneNumber = request.getParameter("phoneNumber");
		String email = request.getParameter("email");

		UserVO vo = new UserVO(id,pw,name,phoneNumber,email);
		UserDAO dao = UserDAO.getInstance();
		
		int result = dao.updateInfo(vo);
		
		return result;
	}

	@Override
	public int deleteInfo(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();

		String id = (String) session.getAttribute("user_id");

		UserDAO dao = UserDAO.getInstance();
		
		int result = dao.deleteInfo(id);

		return result;
	}
}
