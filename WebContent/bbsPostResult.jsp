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
	<c:if test="${param.RE == 'OK' }">
		<h3 align="center">게시글이 등록되었습니다~</h3>
	</c:if>
	<c:if test="${param.RE == 'NOK' }">
		<h3 align="center">게시글 등록에 문제가 발생했습니다.</h3>
		<h3 align="center">관리자에 문의해주세요.</h3>
	</c:if>

</body>
</html>