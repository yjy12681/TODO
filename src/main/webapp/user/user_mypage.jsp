<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<section>
	<div align="center">
		<h3>My page</h3>
			
			<br><br><br><br><br>
			<h4>${sessionScope.user_name } 님 어서오세요</h4> <br>						
			<br><br><br><br><br>
			
			<a href="user_modify.user" 
			   style="border-radius:8px; background:#15A34A; color:#fff;  height:60px; font-size:1.4em; padding:0.2em 0.5em;">회원수정</a>	&nbsp;&nbsp;					
			<a href="user_logout.user"
			   style="border-radius:8px; background:#15A34A; color:#fff;  height:60px; font-size:1.4em; padding:0.2em 0.5em;">로그아웃</a>&nbsp;&nbsp;
			<a href="user_delete.user"
			   style="border-radius:8px; background:#15A34A; color:#fff;  height:60px; font-size:1.4em; padding:0.2em 0.5em;">회원탈퇴</a>&nbsp;&nbsp;



</section>

<%@ include file="../include/footer.jsp" %>
