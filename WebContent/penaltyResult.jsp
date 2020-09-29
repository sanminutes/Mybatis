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
	<div align="center">
		<h2 align="center">
			게임의 결과
			<c:choose>
				<c:when test="${param.R == 'YES' }">
					<h3>
						<font color="red">골인!!!</font>
					</h3>
				</c:when>
				<c:otherwise>
					<h3>
						<font color="red">노 골~~~</font>
					</h3>
				</c:otherwise>
			</c:choose>
			<img alt="" src="imgs/${param.IMG }">
	</div>
</body>
</html>