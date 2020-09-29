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
	<script type="text/javascript">
function idOK(){
	opener.document.registerFrm.ID.value = document.frm.USER.value;
	opener.document.registerFrm.IDCHK.value = 'YES';
	self.close();
}
</script>
	<h2 align="center">아이디 중복 확인</h2>
	<form action="idCheck.do" name="frm">
		아이디 : <input type="text" name="USER" value="${ID }" /> <input
			type="submit" value="중복 검사" /><br />
		<c:if test="${requestScope.DUP =='NO' }">
			${ID }는 사용 가능합니다.
			<input type="button" value="사용" onClick="idOK()" />
		</c:if>
		<c:if test="${requestScope.DUP =='YES' }">
			<h3 align="center">${ID }는이미 사용중입니다.</h3>
			<script type="text/javascript">
			opener.document.registerFrm.ID.value = '';
			</script>
		</c:if>
	</form>

</body>
</html>