<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2 align="left">
		<font size="4">플러스 상품</font>
	</h2>
	<hr>
	<div align="center">
		<table class="item_main" border="1">
			<c:forEach var="item" items="${ITEM_LIST }">
				<tr>
					
					<td>${item.code }</td>
					<td>${item.name }</td>
					<td><fmt:formatNumber groupingUsed="true">${item.price }</fmt:formatNumber></td>
					<td>${item.origin }</td>
					<td><a href="#"
						onClick="window.open('../cart/addCart.html?CODE=${item.code }','cart','width=200,height=200').focus(),'seach()'">장바구니
							담기</a></td>
				</tr>
			</c:forEach>
		</table>
		<c:forEach begin="1" end="${COUNT }" var="page">
			<a href="../read/read.html?pageNo=${page }">${page }</a>
		</c:forEach>
	</div>
</body>


</html>