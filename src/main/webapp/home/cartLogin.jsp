<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<c:choose>
			<c:when test="${RESULT == 'nocartlogin' }">
				<h3 align="center">상품을 담으려면 로그인을 해야합니다.</h3>
			</c:when>
		</c:choose>
		<form:form action="../cart/login.html" modelAttribute="guest"
			method="post">
			<table width="340" height="280" align="center"
				style="background-color: #E7E7E7; border-collapse: collapse;">
				<tr>
					<td><table width="320" height="220" align="center"
							style="background-color: white; border-collapse: collapse; border: black;">
							<tr>

								<td colspan="2" width="10" height="10"></td>
							</tr>
							<tr>
								<td width="10" height="10" style="background-color: red;"></td>
								<td>로그인</td>
							</tr>
							<tr>
								<td></td>
								<td width="10" height="10">아이디 : <form:input path="id"
										size="30" placeholder="계정을 입력하세요" /> <font color="red"
									style="font-size: 12px;"><br /> <form:errors path="id" /></font></td>
							</tr>

							<tr>
								<td></td>
								<td width="10" height="10">암&nbsp;&nbsp;&nbsp;호 : <form:password
										path="password" size="30" placeholder="암호를 입력하세요" /> <font
									color="red" style="font-size: 12px;"><br /> <form:errors
											path="password" /></font>
								</td>
							</tr>
							<tr>

								<td colspan="2" width="10" height="10"></td>
							</tr>
							<tr>
								<td colspan="2" width="10" height="10" align="center"><input
									type="submit" value="로그인" /> <input type="reset" value="취소" /></td>
							</tr>

						</table></td>

				</tr>
				<tr>
					<td width="10" height="10" align="center"><a
						href="../home/userentry.html"><font color="black" size="2px">아이디
								찾기</font></a>│<a href="../home/userentry.html"><font color="black"
							size="2px">비밀번호 찾기</font></a>│<a href="../home/userentry.html"><font
							color="black" size="2px">회원가입</font></a></td>


				</tr>
				<tr></tr>
			</table>
		</form:form>
	</div>

</body>
</html>