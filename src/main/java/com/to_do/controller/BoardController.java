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
    	doAction(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doAction(request,response);
    }
    
    protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");

		String uri = request.getRequestURI();
		String conPath = request.getContextPath();		
		String command = uri.substring(conPath.length());

		System.out.println(command);
		
		BoardService service = new BoardServiceImpl();
		
		if(command.equals("/index.user")) {
			List<BoardVO> list = service.getList(request, response);
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
    }
}
