<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-idth, initial-scale=1">


<title>Welcome to MyWorld</title>

<!-- Bootstrap Core CSS -->
<link href="<%= request.getContextPath() %>/css/bootstrap.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="<%= request.getContextPath() %>/css/business-casual.css"
	rel="stylesheet">

<!-- Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic"
	rel="stylesheet" type="text/css">

<!-- jQuery -->
<script src="<%= request.getContextPath() %>/js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="<%= request.getContextPath() %>/js/bootstrap.min.js"></script>
<script>
    $('.carousel').carousel({
        interval: 2000 //changes the speed
    })
    </script>
<style>
.abc {
	position: sticky;
	top: 0px;
	width: 100%;
	z-index: 10;
}
@font-face {
	font-family: 'HANAMDAUM';
	src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2304-2@1.0/HANAMDAUM.woff2') format('woff2');
	font-weight: 500;
	font-style: normal;
}
@font-face {
	font-family: 'MBC1961GulimM';
	src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2304-01@1.0/MBC1961GulimM.woff2') format('woff2');
	font-weight: normal;
	font-style: normal;
}
#home_container{
	display: flex;
	flex-direction: column;
	align-items: center;
	height: 100vh;
}
#home_main{
	font-family: 'HANAMDAUM';
	font-size: 45px;
	line-height: 120%;
	width: 300px;
	height: 130px;
	text-align: center;
	padding-bottom: 15px;
}
#home_comment{
	font-size: 20px;
	font-family: 'MBC1961GulimM';
	text-align: center;
	width: 400px;
	padding-bottom: 20px;
}
#home_login_button{
	background-color:#DF483A;
	border-radius: 5px;
	text-decoration: none;
	padding: 10px;
}
a {
	text-decoration: none;
}
section{
	height: 60vh;
}
#index_section{
	display: flex;
	justify-content: space-evenly;
	flex-direction: column;
}
.button-container{
	display: flex;
	flex-direction: row;
	justify-content: center;
	align-items: center;
}
.button-container a {
	background-color: #15A34A;
	border-radius: 5px;
	margin-right: 15px;
	padding: 10px;
	text-decoration: none;
	color: whitesmoke;
	font-size: 15px;
	text-align: center;
}
</style>


</head>

<body>
	<!-- header -->
	<div class="brand">To Do List</div>
	<div class="address-bar">오늘의 할일을 내일로 미루지 말자</div>

	<nav class="navbar navbar-default abc" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>

				<a class="navbar-brand" href="/hong">My First Web</a>
			</div>


			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">


					<c:choose>
						<c:when test="${sessionScope.user_id != null }">
							<li><a href="<%= request.getContextPath()%>/home.board">전체 목록</a></li>
							<li><a href="<%= request.getContextPath()%>/board/board_write.board">할일작성하러가기</a></li>
							<li><a
								href="<%= request.getContextPath()%>/board/board_list_y.board">완료한 일</a>
							</li>
							<li><a
								href="<%= request.getContextPath()%>/user/user_mypage.user">나의정보관리</a>
							</li>
							<li><a href="<%= request.getContextPath()%>/user/user_logout.user"
								style="color: red">로그아웃</a></li>
						</c:when>

						<c:otherwise>
							<li><a href="<%= request.getContextPath()%>/home.board">홈</a></li>
							<li><a
								href="<%= request.getContextPath()%>/user/user_login.user">로그인</a>
							</li>
							<li><a
								href="<%= request.getContextPath()%>/user/user_join.user"
								style="color: red">회원가입</a></li>
						</c:otherwise>

					</c:choose>
				</ul>
			</div>


			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>
	<!-- end header -->