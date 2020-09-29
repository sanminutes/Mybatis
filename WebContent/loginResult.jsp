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
		<c:when test="${param.RESULT == 'YES' }">
			<h3 align="center">로그인 되었습니다.</h3>
		</c:when>
		<c:when test="${param.RESULT == 'NOPWD' }">
			<h3 align="center">로그인 되지 않았습니다.</h3>
			<h3 align="center">암호를 확인하세요.</h3>
		</c:when>
		<c:when test="${param.RESULT == 'NOID' }">
			<h3 align="center">로그인 되지 않았습니다.</h3>
			<h3 align="center">계정이 존재하지 않습니다.</h3>
		</c:when>
	</c:choose>
</body>
</html>