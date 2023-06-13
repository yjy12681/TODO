<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../include/header.jsp" %>

<div class="container" align="right">
    <table class="table table-bordered" style="max-width: 250px;">
        <thead>
            <tr>
                <th style="padding: 5px 10px; max-width: 5px;">미달성갯수: ${count }</th>
                <th style="width: 110px; padding: 5px;">달성갯수: ${count1 }</th>
            </tr>
        </thead>
    </table>
</div>

<div style="display: flex; justify-content: center;">
    <div style="margin-right: 100px;">
        <!-- 첫 번째 리스트 -->
        <table class="table table-bordered">
            <h3>할 일</h3>
            <thead>
            <tr>
                <th>제목</th>
                <th>기한</th>
                <th>수정</th>
                <th>삭제</th>
            </tr>
            </thead>
            <tbody>
            <!-- 첫 번째 리스트의 항목들 -->
            <c:forEach var="todo" items="${todo }">
            <tr>
                <td><a href="/board/board_content.board?bno=${todo.bno }">${todo.title }</a></td>
                <td><fmt:formatDate value="${todo.regdate}" pattern="yyyy-MM-dd"/></td>
                <td><a href="/board/board_modify.board?bno=${todo.bno}">수정</a></td>
                <td><a href="/board/board_delete.board?bno=${todo.bno}">삭제</a></td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div>
        <!-- 두 번째 리스트 -->
        <table class="table table-bordered">
            <h3>마감기한 지난 일</h3>
            <thead>
            <tr>
                <th>제목</th>
                <th>기한</th>
                <th>삭제</th>
            </tr>
            </thead>
            <tbody>
            <!-- 두 번째 리스트의 항목들 -->
            <c:forEach var="over" items="${over }">
            <tr>
                <td><a href="/board/board_content.board?bno=${over.bno }">${over.title }</a></td>
                <td><fmt:formatDate value="${over.regdate}" pattern="yyyy-MM-dd"/></td>
                <td><a href="/board/board_delete.board?bno=${over.bno}">삭제</a></td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>


    <%@ include file="../include/footer.jsp" %>

