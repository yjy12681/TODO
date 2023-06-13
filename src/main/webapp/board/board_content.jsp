<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ include file="../include/header.jsp"%>

<div align="center" class="div_center">
	<h3>할 일 상세보기</h3>
	<hr>
	<table border="1" width="500">
		<tr>
			<td width="20%">달성여부</td>
			<td width="30%">${vo.check_yn }</td>
			
			<td width="20%">마감일</td>
			<td width="30%"><fmt:formatDate value="${ vo.regdate }" pattern="yyyy-MM-dd" /></td>
		</tr>
	
		<tr>
			<td width="20%">글제목</td>
			<td colspan="3">${vo.title }</td>
		</tr>
		<tr>
			<td width="20%">글내용</td>
			<td colspan="3" height="120px">${vo.content }</td>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<input type="button" value="목록" onclick="location.href='/index.board'">&nbsp;&nbsp;
				<input type="button" value="수정" onclick="location.href='/board/board_modify.board?bno=${vo.bno}'">&nbsp;&nbsp;
				<input type="button" value="삭제" onclick="location.href='/board/board_delete.board?bno=${vo.bno}'">&nbsp;&nbsp;
				<input type="button" value="완료" onclick="location.href='/board/board_complete.board?bno=${vo.bno}'">
			</td>
		</tr>
	</table>

</div>




<%@ include file="../include/footer.jsp"%>