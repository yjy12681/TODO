<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<div align="center" class="div_center">
    <h3>할 일 수정 페이지</h3>
    <hr>
    <%--	필요한 데이터를 update해준다 --%>
    <form action="board_update.board" method="post">

        <input type="hidden" name="bno" value="${vo.bno}">
        <table border="1" width="500">
            <%--			화면에서 보여질 필요는 없지만, 데이터는 form으로 전송해야할 때
                            input태그의 hidden 속성을 쓴다  -> 중요 !!!!!!!!  --%>
            <%--
            <tr>
                <td>글 번호</td>
                <td>${vo.bno}</td>
            </tr>
            --%>
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

                        document.getElementById("myDate").value = ${ vo.regdate };
                        document.getElementById("myDate").min = today;
                    </script>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="수정 하기" onclick="location.href='board_content.board'">&nbsp;&nbsp;
                    <input type="button" value="목록" onclick="location.href='board_list.board'">
                </td>
            </tr>

        </table>
    </form>

</div>

<%@ include file="../include/footer.jsp" %>