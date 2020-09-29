<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h2>게시글 읽기</h2>
		<table border="1" width="90%">
			<tr>
				<td width="30%">글번호</td>
				<td>${bbs.seqno }</td>
			</tr>
			<tr>
				<td>글제목</td>
				<td>${bbs.title }</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${bbs.id }</td>
			</tr>
			<tr>
				<td>작성일</td>
				<td>${bbs.bbs_date }</td>

			</tr>
			<tr>
				<td colspan="2" height="100">${bbs.content }</td>
		</table>

	</div>
</body>
</html>