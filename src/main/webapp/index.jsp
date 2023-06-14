<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../include/header.jsp" %>

<section id="index_section" style="background-color: rgba(249, 232, 213, 0.2);">
    <div class="container" align="center">
        <table class="table table-bordered" style="max-width: 300px; background-color: rgba(140,180,253, 0.2);
                                                    border-radius: 5px; border-width: 3px; border-color: rgba(140,180,253, 0.2)">
            <thead>
            <tr>
                <th style="padding: 5px 10px; width: auto; text-align: center;">전체 할 일: ${count }</th>
                <th style="width: auto; padding: 5px; text-align: center;">달성 갯수: ${count1 }</th>
                <th style="width: auto; padding: 5px; text-align: center;">달성률: <c:choose><c:when test="${count == 0}">0%
                </c:when><c:otherwise><fmt:formatNumber value="${(count1/count)*100 }" maxFractionDigits="1"/>%
                </c:otherwise></c:choose></th>

            </tr>
            </thead>
        </table>
    </div>

    <div style="display: flex; justify-content: space-evenly;">
        <div style="margin-right: 100px;">
            <!-- 첫 번째 리스트 -->

            <table class="table-bordered" style="border-radius: 20px; border-width: 3px; border-color: rgba(38,100,207, 0.7)">
                <h3 style="text-align: center">할 일</h3>
                <!-- 첫 번째 리스트의 항목들 -->
                <c:forEach var="todo" items="${todo}">
                <tr style="border-color: white;">
                    <td style="padding: 10px"><a href="/board/board_content.board?bno=${todo.bno }">${todo.title }</a></td>
                    <td style="padding: 10px"><fmt:formatDate value="${todo.regdate}" pattern="yyyy-MM-dd"/>까지</td>
                    <td style="padding: 10px"><a href="/board/board_modify.board?bno=${todo.bno}">수정</a></td>
                    <td style="padding: 10px"><a href="/board/board_delete.board?bno=${todo.bno}">삭제</a></td>
                    <td style="padding: 10px"><a href="/board/board_complete.board?bno=${todo.bno}">완료</a></td>
                </tr>
                </c:forEach>

            </table>
        </div>

        <div>
            <!-- 두 번째 리스트 -->
            <table class="table table-bordered" style="border-radius: 20px; border-width: 3px; border-color: rgba(38,100,207, 0.7)">
                <h3 style="text-align: center;">기간 만료</h3>
                <!-- 두 번째 리스트의 항목들 -->
                <c:forEach var="over" items="${over}">
                <tr>
                    <td><a href="/board/board_content.board?bno=${over.bno }" >${over.title }</a></td>
                    <td><fmt:formatDate value="${over.regdate}" pattern="yyyy-MM-dd"/></td>
                    <td><a href="/board/board_delete.board?bno=${over.bno}">삭제</a></td>
                </tr>
                </c:forEach>
            </table>
        </div>
    </div>

    <div class="button-container">
        <c:choose>
            <c:when test="${count == 0}">
                <div>
                    <a href="/board/board_write.board"
                       style="text-decoration: none; color: whitesmoke; font-size: 15px; text-align: center;">추가</a>
                </div>
            </c:when>

            <c:otherwise>
                <div>
                    <a href="/board/board_write.board"
                       style="text-decoration: none; color: whitesmoke; font-size: 15px; text-align: center;">추가</a>
                </div>
                <div>
                    <a href="/board/delete_allList.board"
                       style="text-decoration: none; color: whitesmoke; font-size: 15px; text-align: center;">비우기</a>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</section>

<%@ include file="../include/footer.jsp" %>

