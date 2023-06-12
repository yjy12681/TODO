package com.to_do.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.to_do.board.model.BoardDAO;
import com.to_do.board.model.BoardVO;

public class BoardServiceImpl implements BoardService{

	@Override
	public List<BoardVO> getList(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		BoardDAO dao = BoardDAO.getInstance();

		List<BoardVO> list = dao.getList(id);

		return list;
	}

	@Override
	public List<BoardVO> getList(String id) {

		BoardDAO dao = BoardDAO.getInstance();

		List<BoardVO> list = dao.getList(id);
		return list;
	}

	@Override
	public int getCount(String id) {

		BoardDAO dao = BoardDAO.getInstance();

		int count = dao.getCount(id);

		return count;
	}

	@Override
	public int getCount1(String id) {
		BoardDAO dao = BoardDAO.getInstance();

		int count = dao.getCount1(id);

		return count;
		
	}



}
