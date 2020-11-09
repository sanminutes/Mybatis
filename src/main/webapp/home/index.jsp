<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[KAUCTION] Shopping</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<link rel="stylesheet" type="text/css" href="../css/search.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<style>
@import url(//fonts.googleapis.com/earlyaccess/hanna.css);

.main {
	font-family: 'Hanna', sans-serif;
	color: white;
	text-align: center;
}
</style>
<style type="text/css">
a:link {
	color: white;
	text-decoration: none;
}

a:visited {
	color: white;
	text-decoration: none;
}

a:hover {
	/* background-color: #FFFFFF; */
	text-decoration: none;
	opacity: 0.6;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		$('.bxslider').bxSlider({
			auto : true, // 자동으로 애니메이션 시작
			speed : 500, // 애니메이션 속도
			pause : 5000, // 애니메이션 유지 시간 (1000은 1초)
			mode : 'horizontal', // 슬라이드 모드 ('fade', 'horizontal', 'vertical' 이 있음)
			pager : false,
		});
	});
</script>
</head>
<body>
	<table width="100%" height="70">
		<tr>
			<td width="14%"><a href="../home/index.html"><img
					src="../img/logo.jpg" height="70px"></a></td>
			<td width="52%">
				<div id="drop_the_text">
					<input type="text" placeholder="키워드 검색" id="write_list">
				</div>
			</td>
			<td width="4%" height="60"><input type="button" class="button-add" /></td>

			<td width="5%" height="60" align="center"><a href="../read/read.html"><img
					src="../img/sub.png" width="25px" height="25px" alt="" title="공지사항"><br />
					<font color="black" size="2">공지사항</font></a></td>
			<td width="5%" align="center"><a href="../cart/show.html"><img
					src="../img/cart.png" width="25px" height="25px" alt=""
					title="장바구니"><br /> <font color="black" size="2">장바구니</font></a></td>
			<td width="5%" align="center"><a href="#"><img
					src="../img/history.png" width="25px" height="25px" alt=""
					title="최근본상품"><br /> <font color="black" size="2">최근본상품</font></a></td>
			<td width="5%" align="center"><a href="#"><img
					src="../img/star.png" width="25px" height="25px" alt=""
					title="위시리스트"><br /> <font color="black" size="2">위시리스트</font></a></td>
			<td width="5%" align="center"><a href="#"><img
					src="../img/coupon.png" width="25px" height="25px" alt=""
					title="쿠폰"><br /> <font color="black" size="2">쿠폰</font></a></td>
			<td width="5%" align="center">

				<div id="login">
					<c:choose>
						<c:when test="${sessionScope.loginUser == null}">
							<a href="../login/login.html"> <img src="../img/user.png"
								width="25px" height="25px" alt="" title="내정보"><br /> <font
								color="black" size="2">로그인</font></a>

						</c:when>
						<%-- 				<c:when test="${LOGIN != null }"> --%>
						<%-- 					<jsp:include page="${LOGIN }" /> --%>
						<%-- 				</c:when> --%>
						<c:otherwise>
							<a href="../logout/index.html"> <img src="../img/user-logout.png" width="25px"
								height="25px" alt="" title="내정보"><br /> <font
								color="black" size="2">로그아웃</font></a>
						</c:otherwise>
					</c:choose>
				</div>

			</td>
		</tr>
	</table>

	<div>
		<ul class="bxslider">
			<li><a href="#"><img src="../img/name1.gif" alt=""
					title="이미지1" width="100%" height="200px"></a></li>
			<li><a href="#"><img src="../img/name2.jpg" alt=""
					title="이미지2" width="100%" height="200px"></a></li>
			<li><a href="#"><img src="../img/name3.jpg" alt=""
					title="이미지3" width="100%" height="200px"></a></li>
			<li><a href="#"><img src="../img/name4.gif" alt=""
					title="이미지4" width="100%" height="200px"></a></li>
		</ul>
	</div>
	<table width="100%"
		style="border-collapse: collapse; margin-top: -50px;">
		<tr>
			<td width="200" height="60" style="background-color: #DB0000;"
				class="main"><font size="6">전체 카테고리</font><br /> <br /></td>
			<td rowspan="11" id="content"><font color="black" size="5"><c:choose>
						<c:when test="${BODY != null }">
							<jsp:include page="${BODY }" />
						</c:when>
						<c:otherwise>
				지금 제일 잘 나가는 상품
			</c:otherwise>
					</c:choose></font></td>
		</tr>

		<tr class="main">
			<td width="200" height="40"
				style="background-color: #DB0000; border: 1px solid #FF5A5A;"><font
				size="5"><a href="../write/writeList.html?category=1">브랜드패션</a></font></td>
		</tr>
		<tr class="main">
			<td width="200" height="40"
				style="background-color: #DB0000; border: 1px solid #FF5A5A;"><font
				size="5"><a href="../write/writeList.html?category=2">패션의류·잡화·뷰티</a></font></td>
		</tr>
		<tr class="main">
			<td width="200" height="40"
				style="background-color: #DB0000; border: 1px solid #FF5A5A;"><font
				size="5"><a href="../write/writeList.html?category=3">유아동</a></font></td>
		</tr>
		<tr class="main">
			<td width="200" height="40"
				style="background-color: #DB0000; border: 1px solid #FF5A5A;"><font
				size="5"><a href="../write/writeList.html?category=4">식품·생필품</a></font></td>
		</tr>
		<tr class="main">
			<td width="200" height="40"
				style="background-color: #DB0000; border: 1px solid #FF5A5A;"><font
				size="5"><a href="../write/writeList.html?category=5">홈데코·문구·취미·반려</a></font></td>
		</tr>
		<tr class="main">
			<td width="200" height="40"
				style="background-color: #DB0000; border: 1px solid #FF5A5A;"><font
				size="5"><a href="../write/writeList.html?category=6">컴퓨터·디지털·가전</a></font></td>
		</tr>
		<tr class="main">
			<td width="200" height="40"
				style="background-color: #DB0000; border: 1px solid #FF5A5A;"><font
				size="5"><a href="../write/writeList.html?category=7">스포츠·건강·렌탈</a></font></td>
		</tr>
		<tr class="main">
			<td width="200" height="40"
				style="background-color: #DB0000; border: 1px solid #FF5A5A;"><font
				size="5"><a href="../write/writeList.html?category=8">자동차·공구</a></font></td>
		</tr>
		<tr class="main">
			<td width="200" height="40"
				style="background-color: #DB0000; border: 1px solid #FF5A5A;"><font
				size="5"><a href="../write/writeList.html?category=9">여행·도서·티켓·e쿠폰</a></font></td>
		</tr>
		<tr>
			<td></td>
		</tr>

	</table>

	<hr>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>