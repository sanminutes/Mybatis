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
		<h3>본 서비스를 이용하시려면, 로그인하세요~</h3>
		<form action="login.do" method="post">
			<input type="hidden" name="CART" value="CART" /> 아이디:<input
				type="text" name="ID" size="12" placeholder="계정" /><br /> 암호:<input
				type="password" name="PWD" size="12" /><br /> <input type="submit"
				value="로그인" /><input type="reset" value="취소" />
		</form>
	</div>

</body>
</html>