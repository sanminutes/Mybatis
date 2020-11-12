<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
@import url(//fonts.googleapis.com/earlyaccess/nanumgothic.css);

.sell {
	border: 1px solid black;
	border-collapse: collapse;
	font-family: 'Nanum Gothic', sans-serif;
}

th {
	background-color: #BDBDBD;
	font-size: 20px;
	height: 40px;
}

td {
	font-size: 18px;
}
</style>
</head>
<body>
	<h3 align="center">판매상품 정보 입력</h3>
	<!-- file은 enctype가 꼭 있어야함  -->
	<form:form modelAttribute="auctionItem" action="../write/atwrite.html"
		method="post" enctype="multipart/form-data">
		<table class="sell" border="1" align="center" width="90%"
			height="100%">
			<tr>
				<th>상품명</th>
				<td><form:input path="a_name" size="40" /></td>
			</tr>
			<tr>
				<th>즉시결제가</th>
				<td><form:input path="a_direct_p" size="40" /></td>
			</tr>
			<tr>
				<th>시작가</th>
				<td><form:input path="a_price" size="40" /></td>
			</tr>
			<tr>
				<th>이미지1</th>
				<td><input type="file" name="imageA" size="40" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="등 록" /></td>
			</tr>
		</table>
	</form:form>
	<br />
</body>

</html>