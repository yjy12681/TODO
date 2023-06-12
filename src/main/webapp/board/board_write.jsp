<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<div align="center" class="div_center">
	<h3>할 일 작성 페이지</h3>
	<hr>
	
	<form action="writeForm.board" method="post">
		<table border="1" width="500">
			<tr>
				<td>할 일</td>
				<td>
					<input type="text" name="title" required>
				</td>
			</tr>
			<tr>
				<td>상세 내용</td>
				<td>
					<textarea rows="10" style="width: 95%;" name="content" ></textarea>
				</td>
			</tr>
			<tr>
				<td>날짜 설정</td>
				<td>
					<input type="date" id="myDate" min="" name="regdate">
					<script>
						var today = new Date().toISOString().split('T')[0];

						document.getElementById("myDate").value = today;
						document.getElementById("myDate").min = today;
					</script>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="작성 완료" >
					&nbsp;&nbsp;
					<input type="button" value="목록" onclick="location.href='board_list.board'">
				</td>
			</tr>
			
		</table>
	</form>
	
</div>

<%@ include file="../include/footer.jsp"%>