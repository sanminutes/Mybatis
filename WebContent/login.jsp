<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="right">
		<a href="template.jsp?BODY=userentry.jsp">가입하기</a>
	</div>
	<form action="login.do" method="post">
		아이디 : <input type="text" name="ID" size="12" placeholder="계정" /> <br />
		암　호 : <input type="password" name="PWD" size="12" /> <br /> <input
			type="submit" value="로그인" /> <input type="reset" value="취소" />

	</form>
</body>
</html>