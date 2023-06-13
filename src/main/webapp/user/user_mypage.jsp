<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<section>
	<div align="center">
		<h3>마이 페이지</h3>
			
			
			${sessionScope.user_name }님 어서오세요 <br>						
			
			<a href="user_modify.user">회원수정</a>						
			<a href="user_logout.user">로그아웃</a>
			<a href="user_delete.user">회원탈퇴</a>
			
	
</section>

<%@ include file="../include/footer.jsp" %>
