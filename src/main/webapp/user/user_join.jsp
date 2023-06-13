<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../include/header.jsp" %>

<section>
	<div align="center">
	
		<h3>회원가입</h3>
		<form action="joinForm.user" method="post">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="id" required="required" pattern="\w{3,}"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pw" required="required" pattern="\w{4,}"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>폰번호</td>
					<td><input type="text" name="phoneNumber"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="email" name="email"></td>
				</tr>
				
				
			</table>
			
			<div style="color: red">${msg }</div>
			
			<input type="submit" value="가입">
			<input type="reset" value="입력정보지우기" onclick="location.href='user_join.user'">
		
		</form>
		
	
	</div>

</section>




<%@ include file="../include/footer.jsp" %>