<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${param.R == 'OK' }">
			<h3 align="center">상품이 등록되었습니다.</h3>
		</c:when>
		<c:otherwise>
			<h3 align="center">상품 등록 중 문제가 발생했습니다.</h3>
			<h3 align="center">관리자에게 문의해 주세요.</h3>
		</c:otherwise>
	</c:choose>
</body>
</html>