package com.to_do.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.to_do.user.model.UserVO;

public interface UserService {
	
	int join(HttpServletRequest request, HttpServletResponse response);
	
	UserVO login(HttpServletRequest request, HttpServletResponse response);
	
	UserVO getInfo(HttpServletRequest request, HttpServletResponse response);
	
	int updateInfo(HttpServletRequest request, HttpServletResponse response);
	
	int deleteInfo(HttpServletRequest request, HttpServletResponse response);
}
