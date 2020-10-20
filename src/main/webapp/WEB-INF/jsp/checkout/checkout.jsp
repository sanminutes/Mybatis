<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/menu_header.jsp"%>
	<div align="center" class="body">
		<h2>구매 화면</h2>
		<font color="red"><b>배송 받을 곳</b></font>
		<table>
			<tr>
				<td>사용자ID</td>
				<td>${loginUser.userId }</td>
			</tr>
			<tr>
				<td>이 름</td>
				<td>${loginUser.userName }님</td>
			</tr>
			<tr>
				<td>주 소</td>
				<td>${loginUser.address }</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>${loginUser.email }</td>
			</tr>


		</table>
		<br /> <br /> <font color="red"><b>구매 목록</b></font>
		<table border="1">
			<tr>
				<th width="200">상품명</th>
				<th width="150">가 격</th>
				<th width="50">갯 수</th>
				<th width="150">소 계</th>
			</tr>
			<c:forEach items="${itemList }" var="itemSet">
				<tr>
					<td align="left">${itemSet.item.itemName }</td>
					<td align="right">${itemSet.item.price }원</td>
					<td align="right">${itemSet.quantity }개</td>
					<td align="right">${itemSet.quantity * itemSet.item.price }원</td>
				</tr>
			</c:forEach>
		</table>
		<br /> <b>총 액 : ${totalAmount }원</b><br />
		<form action="../end/end.html">
			<input type="submit" name="btn" value="구매 확정" />
		</form>
		<a href="../index/index.html">■목록으로 돌아가기</a>
	</div>
</body>
</html>