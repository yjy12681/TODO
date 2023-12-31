package com.to_do.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.to_do.board.model.BoardVO;

public interface BoardService {

	void write(HttpServletRequest request, HttpServletResponse response); // 일 작성

	void update(HttpServletRequest request, HttpServletResponse response); // 일 수정

	void delete(HttpServletRequest request, HttpServletResponse response); // 일 삭제

	BoardVO getContent(HttpServletRequest request, HttpServletResponse response); // 임시 컨텐츠 가져오기

	List<BoardVO> getList(HttpServletRequest request, HttpServletResponse response);

	List<BoardVO> getOverList(HttpServletRequest request, HttpServletResponse response);

	List<BoardVO> getListY(HttpServletRequest request, HttpServletResponse response);//완료한일 조회
	
	int getCount(String id);
	
	int getCount1(String id);

	void complete(HttpServletRequest request, HttpServletResponse response); // 완료 처리

	void deleteAll(HttpServletRequest request, HttpServletResponse response); //아이디 기준으로 리스트삭제
}
