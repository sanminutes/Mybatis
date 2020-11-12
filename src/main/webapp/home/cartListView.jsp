<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
.cart {
	border-collapse: collapse;
}

.credit {
	text-align: right;
}

.cart td {
	text-align: center;
}

#carttable {
	background-color: black;
}
</style>
</head>
<body>
	<h2 align="center">장바구니 목록</h2>
	<c:if test="${empty CART_LIST }">
		<h3 align="center">장바구니가 비었습니다.</h3>
	</c:if>
	<c:if test="${!empty CART_LIST }">
		<table class="cart" border="1" align="center" width="90%">
			<tr>
				<th width="80" id="carttable"><font color="white">상품번호</font></th>
				<th width="100" id="carttable"><font color="white">상품이름</font></th>
				<th width="100" id="carttable"><font color="white">상품가격</font></th>
				<th width="100" id="carttable"><font color="white">사이즈</font></th>
				<th width="100" id="carttable"><font color="white">상품갯수</font></th>
				<th width="80" id="carttable"><font color="white">합 계</font></th>
				<th width="100" id="carttable"><font color="white">수정/삭제</font></th>
			</tr>

			<c:forEach var="goods" items="${CART_LIST }">
				<form action="../cart/modify.html" method="post">
					<input type="hidden" value="${goods.code }" name="CODE"> <input
						type="hidden" value="${goods.sizee }" name="SIZEE">
					<tr>
						<td>${goods.code }</td>
						<td><a href="javascript:goView(${goods.code })"><font
								color="black">${goods.name }</font></a></td>
						<td><fmt:formatNumber groupingUsed="true">${goods.price }</fmt:formatNumber></td>
						<td>${goods.sizee }</td>
						<td><input type="text" value="${goods.num }" name="NUM"
							size="3" style=""></td>
						<td><fmt:formatNumber groupingUsed="true">${goods.price * goods.num }</fmt:formatNumber></td>
						<td><input type="submit" value="수정" name="BTN"> <input
							type="submit" value="삭제" name="BTN"></td>
					</tr>
				</form>
			</c:forEach>
		</table>
		<br>
		<table width="90%" align="center">
			<tr>
				<td>
					<form action="#" method="post" class="credit">
						총 합 :
						<fmt:formatNumber groupingUsed="true">${totalAmount }</fmt:formatNumber>
						<input type="hidden" value="TOTAL"><input type="submit"
							value="결제하기">
					</form>
				</td>
			</tr>
		</table>
	</c:if>

	<script type="text/javascript">
		function goView(no) {
			document.move.id.value = no;
			document.move.action = "../read/readImage.html";
			document.move.submit();
		}
	</script>
	<form name="move" method="post">
		<input type="hidden" name="id" />
	</form>
</body>
</html>