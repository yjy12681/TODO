<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="../include/header.jsp"%>

 <div class="container">
 
	<table class="table table-bordered">
	<thead>
		<tr>
			<th style="width: 100px;">미달성갯수: ${count }</th>
			<th style="width: 10px;">달성갯수: ${count1 }</th>
		</tr>
	</thead>
</table>
 </div>


<div class="container">
	<h3>List</h3><br>
	
	


	<table class="table table-bordered">
		<thead>
			<tr>
				<th>제목</th>
				<th>내용</th>
				<th>달성여부?</th>
				<th>등록일</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="vo" items="${list}" varStatus="x">
				<tr>
					<td><a href="board_content.board?bno=${vo.bno}">${vo.title}</a></td>
					<td>${vo.content}</td>
					<td>${vo.check_yn}</td>
					<td><fmt:formatDate value="${vo.regdate}"
							pattern="yyyy-MM-dd (E) hh시mm분" /></td>
					<td><a href="../board/board_modify.board?bno=${ vo.bno }">수정</a></td>
					<td><a href="../board/board_delete.board?bno=${ vo.bno }">삭제</a> </td>
				</tr>
			</c:forEach>
		</tbody>

		<tbody>
			<tr>
				<td colspan="6" align="right">
					<form action="" class="form-inline">
						<div class="form-group">


							<input type="button" value="글 작성" class="btn btn-default"
								onclick="location.href='/board/board_write.board'">
						</div>
					</form>
				</td>
			</tr>
		</tbody>


	</table>
</div>


<%@ include file="../include/footer.jsp"%>

