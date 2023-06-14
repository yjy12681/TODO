<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../include/header.jsp" %>
<section style="background-color: rgba(249, 232, 213, 0.2);">
<div style="display: flex; justify-content: center;">
    <div style="margin-right: 100px;">
        <!-- 첫 번째 리스트 -->
        <table class="table table-bordered">
            <h3>완료한 일</h3>
            <thead>
            <tr>
                <th>제목</th>
                <th>기한</th>
                <th>삭제</th>
            </tr>
            </thead>
            <tbody>
            <!-- 첫 번째 리스트의 항목들 -->
            <c:forEach var="vo" items="${list }">
            <tr>
                <td width="150"><a href="/board/board_content.board?bno=${vo.bno }">${vo.title }</a></td>
                <td width="150"><fmt:formatDate value="${vo.regdate}" pattern="yyyy-MM-dd"/></td>
                <td width="100"><a href="/board/board_delete.board?bno=${vo.bno}">삭제</a></td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
  
</div>
</section>

    <%@ include file="../include/footer.jsp" %>