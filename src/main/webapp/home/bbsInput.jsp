<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2 align="center">공지사항 작성</h2>
	<form:form modelAttribute="bbs" method="post"
		action="../home/write.html">
		<table border="1" align="center" style="border: 1px solid black; border-collapse: collapse; background-color: #F6F6F6" width="700" height="500">
			<tr>
				<td align="center"><font size="2px">제 목 : </font><form:input path="title" placeholder="반드시 작성해야 합니다" size="81"/>
					<br /> <br /> <font color="red"><form:errors path="title" /></font>
					<br /> <form:textarea rows="20" cols="80" path="content"
						placeholder="글 내용을 입력하세요"></form:textarea> <br /> <font
					color="red"><form:errors path="content" /></font>
					<div align="center">
						<input type="submit" value="글 올리기" /> <input type="reset"
							value="취소" />
					</div>
				</td>
			</tr>
		</table>

	</form:form>
			<br/>
</body>
</html>