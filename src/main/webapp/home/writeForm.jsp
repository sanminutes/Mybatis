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
	<form:form modelAttribute="itemWriting" action="../write/write.html"
		method="post" enctype="multipart/form-data">
		<table class="sell" border="1" align="center" width="90%"
			height="100%">
			<tr>
				<th>카테고리</th>
				<td><form:select path="category" width="100">
						<c:forEach var="cg" items="${category }">
							<form:option value="${cg.c_num }">${cg.c_name} </form:option>
						</c:forEach>


					</form:select> <font color="red" size="2px"><form:errors path="category" /></font></td>
			</tr>
			<tr>
				<th>판매상점명</th>
				<td><form:input path="title" size="40" /> <font color="red"
					size="2px"><form:errors path="title" /></font></td>
			</tr>
			<tr>
				<th>상품명</th>
				<td><form:input path="writer_name" size="40" /> <font
					color="red" size="2px"> <form:errors path="writer_name" /></font></td>
			</tr>
			<tr>
				<th>상품금액</th>
				<td><form:input path="price" size="40" /><b>원</b></td>
			</tr>
			<tr>
				<th>배송비</th>
				<td><form:input path="charge_price" size="40" /><b>원</b> (무료
					배송인 경우, 0으로 입력하세요.) <font color="red" size="2px"><form:errors
							path="charge_price" /></font></td>
			</tr>
			<tr>
				<th>배송 구분</th>
				<td><form:checkbox path="delivery" value="국내" label="국내" /> <form:checkbox
						path="delivery" value="해외" label="해외" /> <font color="red"
					size="2px"><form:errors path="delivery" /></font></td>
			</tr>
			<tr>
				<th>이미지1</th>
				<td><input type="file" name="imageA" size="40" /></td>
			</tr>
			<tr>
				<th>이미지2</th>
				<td><input type="file" name="imageB" size="40" /></td>
			</tr>

			<tr>
				<th>원산지</th>
				<td><form:input path="country" size="40" /></td>
			</tr>
			<tr>
				<th>옵션1 설정</th>
				<td><form:input path="options1" size="40" /><font size="2px"
					color="red"> <form:errors path="options1" /></font></td>
			</tr>
			<tr>
				<th>옵션2 설정</th>
				<td><form:input path="options2" size="40" /><font size="2px"
					color="red"> <form:errors path="options2" /></font></td>
			</tr>
			<tr>
				<th>상품 정보</th>
				<td><form:textarea rows="8" cols="80" path="comment" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="등 록" /></td>
			</tr>

		</table>
	</form:form>
	<br />
</body>

</html>