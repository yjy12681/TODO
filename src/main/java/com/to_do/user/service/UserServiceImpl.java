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
		String birthdate = request.getParameter("birthdate");
		String email = request.getParameter("email");
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Timestamp birthdate1 = null;
		
		try {
			birthdate1 = new Timestamp(dateFormat.parse(birthdate).getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		UserDAO dao = UserDAO.getInstance();
		int result = dao.idCheck(id);
		System.out.println(result);
		if(result == 1) {
			return 1;
		}else {
			UserVO vo = new UserVO(id,pw,name,phoneNumber,birthdate1,email);
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

	@Override
	public UserVO getInfo(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("user_id");
		
		UserDAO dao = UserDAO.getInstance();
		UserVO vo = dao.getInfo(id);
		
		
		return vo;
	}

	@Override
	public int updateInfo(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phoneNumber = request.getParameter("phoneNumber");
		String birthdate = request.getParameter("birthdate");
		String email = request.getParameter("email");
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Timestamp birthdate1 = null;
		
		try {
			birthdate1 = new Timestamp(dateFormat.parse(birthdate).getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		UserVO vo = new UserVO(id,pw,name,phoneNumber,birthdate1,email);
		UserDAO dao = UserDAO.getInstance();
		
		int result = dao.updateInfo(vo);
		
		
		
		return result;
	}

	@Override
	public int deleteInfo(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		
		UserDAO dao = UserDAO.getInstance();
		
		int result = dao.deleteInfo(id);
		return result;
	}
}
