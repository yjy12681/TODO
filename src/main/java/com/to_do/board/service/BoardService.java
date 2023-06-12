package com.to_do.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.to_do.board.model.BoardVO;

public interface BoardService {
	
	List<BoardVO> getList(HttpServletRequest request, HttpServletResponse response);
	
	List<BoardVO> getList(String id);
	
	int getCount(String id);
	
	int getCount1(String id);
}
