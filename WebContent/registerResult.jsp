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
		<c:when test="${param.R=='OK' }">
			<h2 align="center">가입을 축하합니다~</h2>
		</c:when>
		<c:otherwise>
			<h2 align="center">가입되지 않았습니다.</h2>
			<h2 align="center">관리자에게 문의바랍니다.</h2>
		</c:otherwise>
	</c:choose>
</body>
</html>