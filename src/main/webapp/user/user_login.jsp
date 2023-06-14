<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<section>
	<div align="center">
		<br><br><br><br>
		<h3>로그인페이지</h3>
		<br>
		<form action="loginForm.user" method="post">
			<input type="text" name = "id" placeholder="아이디"><br>
			<input type="password" name="pw" placeholder="비밀번호"><br><br>
			<input type="submit" value="로그인" 
			       style="border:none; border-radius:5px; background:#15A34A; color:#fff;  height:30px; font-size:1em; padding:0.2em 1.1em;">
			<input type="button" value="가입하기" onclick="location.href='user_join.user'"
			       style="border:none; border-radius:5px; background:#15A34A; color:#fff;  height:30px; font-size:1em; padding:0.2em 1.1em;">
		</form>
		
		 <div>${msg }</div>
	</div>
	
</section>


<%@ include file="../include/footer.jsp" %>
