<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<section>
<div align="center" class="div_center">
    <h3>할 일 수정 페이지</h3>
    <hr>
    <%--	필요한 데이터를 update해준다 --%>
    <form action="board_update.board" method="post">

        <input type="hidden" name="bno" value="${vo.bno}">
        <table border="1" width="500">

            <tr>
                <td>할 일</td>
                <td>
                    <input type="text" name="title" value="${vo.title}">
                </td>
            </tr>
            <tr>
                <td>상세 내용</td>
                <td>
					<textarea rows="10" style="width: 95%;" name="content">${vo.content}
                    </textarea>
                </td>
            </tr>
            <tr>
                <td>날짜 설정</td>
                <td>
                    <input type="date" id="myDate" min="" name="regdate">
                    <script>
                        var today = new Date().toISOString().split('T')[0];

                        document.getElementById("myDate").value = today;
                    </script>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="수정 하기">&nbsp;&nbsp;
                    <input type="button" value="목록" onclick="location.href='/index.board'">
                </td>
            </tr>

        </table>
    </form>

</div>
</section>
<%@ include file="../include/footer.jsp" %>