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
	<c:if test="${empty writing }">
존재하지 않는 글입니다.
</c:if>
	<c:if test="${!empty writing }">
		<table border="1" width="100%" align="center">
			<tr>
				<td>글제목</td>
				<td>${writing.title }</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${writing.writer_name }</td>
			</tr>
			<tr>
				<td cospan="2"><img alt="" src="upload/${writing.image_name }"
					width="350" height="350"></td>
			</tr>
			<tr>
				<td>글내용</td>
				<td>${writing.content }</td>
			</tr>
			<tr>
				<td colspan="2"><a href="">[답글]</a><a href="">[수정]</a> <a
					href="">[삭제]</a><a href="">[목록]</a></td>
			</tr>


		</table>
	</c:if>
</body>
</html>