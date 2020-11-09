<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${NOCART== 'yes' }">
		<h3 align="center">장바구니 목록을 보려면 로그인 해야합니다</h3>
	</c:when>
	<c:when test="${NOTITEM == 'yes' }">
		<h3 align="center">상품을 등록하시려면 로그인 해야합니다</h3>
	</c:when>
	<c:when test="${NOLOGIN == 'yes' }">
		<h3 align="center">글을 올리려면 로그인 해야합니다</h3>
	</c:when>
</c:choose>
<form:form modelAttribute="guest" method="post" action="../login/index.html">
계 정 : <form:input path="id" size="12"/>
<font color="red"><form:errors path="id"/></font><br/>
암 호 : <form:password path="password" size="12"/>
<font color="red"><form:errors path="password"/></font><br/>
<input type="submit" value="로그인"/>
<input type="reset" value="취소"/>
</form:form>
<div align="right"><a href="../home/userentry.html">가입하기</a></div>
</body>
</html>