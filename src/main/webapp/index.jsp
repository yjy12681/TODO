<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../include/header.jsp" %>

<div style="display: flex; justify-content: center;">
    <div style="margin-right: 100px;">
        <!-- 첫 번째 리스트 -->
        <table class="table table-bordered">
            <h3>할 일</h3>
            <thead>
            <tr>
                <th>제목</th>
                <th>내용</th>
                <th>내용</th>
                <th>내용</th>
                <th>내용</th>
            </tr>
            </thead>
            <tbody>
            <!-- 첫 번째 리스트의 항목들 -->
            <tr>
                <td>리스트 항목 1</td>
                <td>리스트 항목 2</td>
                <td>리스트 항목 3</td>
                <td>리스트 항목 4</td>
                <td>리스트 항목 5</td>
            </tr>
            <!-- 나머지 항목들 -->
            </tbody>
        </table>
    </div>
    <div>
        <!-- 두 번째 리스트 -->
        <table class="table table-bordered">
            <h3>마감기한 지난 일</h3>
            <thead>
            <tr>
                <th>리스트 항목 A</th>
                <th>리스트 항목 B</th>
                <th>리스트 항목 C</th>
                <th>리스트 항목 D</th>
                <th>리스트 항목 E</th>
            </tr>
            </thead>
            <tbody>
            <!-- 두 번째 리스트의 항목들 -->
            <tr>
                <td>리스트 항목 1</td>
                <td>리스트 항목 2</td>
                <td>리스트 항목 3</td>
                <td>리스트 항목 4</td>
                <td>리스트 항목 5</td>
            </tr>
            <!-- 나머지 항목들 -->
            </tbody>
        </table>
    </div>
</div>


    <%@ include file="../include/footer.jsp" %>

