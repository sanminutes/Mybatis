<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		function codeOK() {
			opener.document.register.CODE.value = document.frm.CODE.value;
			opener.document.register.codeChecked.value = 'YES';
			self.close();
		}
	</script>
	<h2 align="center">상품코드 중복 확인</h2>
	<form action="codeCheck" name="frm">

		상품 코드 : <input type="text" name="CODE" value="${CODE }"> <input
			type="submit" value="중복 검사" /><br />
		<c:if test="${requestScope.CUP =='NO' }">
			<h3 align="center">상품 코드 ${CODE }는 사용되고 있습니다.</h3>
			<script type="text/javascript">
				opener.document.register.CODE.value = '';
			</script>
		</c:if>
		<c:if test="${requestScope.CUP =='YES' }">
			<div align="center">
				${CODE }는 사용 가능합니다. <input type="button" value="사용"
					onClick="codeOK()" />
			</div>
		</c:if>
	</form>
</body>
</html>