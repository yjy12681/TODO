package com.to_do.board.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.to_do.board.model.BoardDAO;
import com.to_do.board.model.BoardVO;

public class BoardServiceImpl implements BoardService{


	// 일 작성
	@Override
	public void write(HttpServletRequest request, HttpServletResponse response) {
		// id는 세션에서 가져온다
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("user_id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String regdateStr = request.getParameter("regdate");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Timestamp regdate = null;

		try {
			Date parsedDate = dateFormat.parse(regdateStr);
			regdate = new Timestamp(parsedDate.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}

		BoardDAO dao = BoardDAO.getInstance();

		dao.write(id, title, content, regdate);
	} //write 끝
	
	// 일 수정
	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) {
		int bno = Integer.parseInt(request.getParameter("bno"));
		String title = request.getParameter("title"); // 제목
		String content = request.getParameter("content"); // 상세 내용

		String regdateStr = request.getParameter("regdate"); // 날짜
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Timestamp regdate = null;

		try {
			Date parsedDate = dateFormat.parse(regdateStr);
			regdate = new Timestamp(parsedDate.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}

		BoardDAO dao = BoardDAO.getInstance();
		dao.update(bno, title, content, regdate);

	} // update 끝

	//일 삭제
	@Override
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		int bno = Integer.parseInt(request.getParameter("bno"));

		BoardDAO dao = BoardDAO.getInstance();
		dao.delete(bno);
	} // delete 끝

	// 임시 컨텐츠 가져오기
	@Override
	public BoardVO getContent(HttpServletRequest request, HttpServletResponse response) {
		String bno = request.getParameter("bno");

		BoardDAO dao = BoardDAO.getInstance();
		BoardVO vo = dao.getContent(bno);

		return vo;
	}
	
	@Override
	public List<BoardVO> getList(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();

		String id = (String) session.getAttribute("user_id");
//		String id = request.getParameter("id");
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
	// 완료 X인 일 개수
	@Override
	public int getCount(String id) {

		BoardDAO dao = BoardDAO.getInstance();

		int count = dao.getCount(id);

		return count;
	}

	//완료한 일 개수
	@Override
	public int getCount1(String id) {
		BoardDAO dao = BoardDAO.getInstance();
		int count = dao.getCount1(id);

		return count;
		
	}



}
