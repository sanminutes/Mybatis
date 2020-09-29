<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	height: 100%
}

table.main {
	width: 90%;
	height: 80%;
	border: 1px solid blue;
	border-collapse: collapse;
	margin-left: 20px;
	margin-right: 20px;
}

td.main {
	border: 1px solid blue;
}

#login {
	width: 80%;
	border: 1px dashed grey;
	padding: 10px;
	margin-top: 10px;
	margin-left: 10px
}

#menus {
	margin-top: 10px;
	margin-left: 20px;
}

#content {
	background-color: orange;
}

a:hover {
	background-color: yellow;
}

td.main {
	background-color: lime;
}

.btn {
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
	background-color: blue;
}

.sub {
	background-color: lightblue
}
</style>
</head>
<body>
	<script type="text/javascript">
		function menu1() {
			location.href = "getBaseballHometown";
		}
		function menu3(){
			location.href="GetBaseballTeam";
		}
	</script>
	<h2 align="center">
		<img alt="" src="imgs/logo.gif"
			OnClick="location.href='http://localhost:8080/FromAtoZuchini/template.jsp'">
	</h2>
	<table class="main sub">
		<tr>
			<td><div align="center">
					<button class="btn" onClick="menu1()">야구구단 등록</button>
					<button class="btn" onClick="menu2()">야구구단 목록</button>
					<button class="btn" onClick="menu3()">야구선수 등록</button>
				</div></td>
		</tr>
	</table>
	<table class="main" width="100%">
		<tr>
			<td class="main" width="20%" height="300" valign="top">
				<div id="login">
					<c:choose>
						<c:when test="${sessionScope.LOGIN==null}">
							<jsp:include page="login.jsp"></jsp:include>
						</c:when>
						<c:otherwise>
							<jsp:include page="logout.jsp"></jsp:include>
						</c:otherwise>
					</c:choose>

				</div> <br />
				<div id="menus">
					<a href="template.jsp?BODY=intro.jsp">소개</a> <br /> <a
						href="template.jsp?BODY=bbsInput.jsp">게시글 쓰기</a><br /> <a
						href="bbsList.do">게시글 목록</a><br /> <a
						href="template.jsp?BODY=penaltyGame.jsp">패널티 게임</a><br /> <a
						href="template.jsp?BODY=inputItem.jsp">상품 등록</a><br /> <a href="itemList.do">상품
						목록</a><br /> <a href="cartList.do">장바구니 보기</a><br /> <a href="">답글 및 이미지
						게시판</a><br /> <a href="">이미지 게시판 목록</a><br />

				</div>
			</td>
			<td id="content"><jsp:include page="${param.BODY}" />
		</tr>

	</table>
	<h3 align="center">CopyLeft 2020. FromAtoZucchini</h3>



</body>
</html>