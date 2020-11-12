
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		function idOK() {
			opener.document.registerFrm.id.value = document.frm.USER.value;
			opener.document.registerFrm.IDCHK.value = 'YES';
			self.close();
		}
	</script>
	<table align="center">
		<tr>
			<td>
				<h2 align="center">아이디 중복 확인</h2>
			</td>
		</tr>
		<tr>
			<td>
				<form action="../idcheck/idcheck.html" name="frm">
					아이디 : <input type="text" name="USER" value="${ID }" /> <input
						type="submit" value="중복 검사" /><br />
					<c:if test="${DUP =='NO'}">
			${ID }는 사용 가능합니다.
			<input type="button" value="사용" onClick="idOK()" />
					</c:if>
					<c:if test="${DUP =='YES' }">
						${ID }는이미사용중입니다.
						<script type="text/javascript">
							opener.document.registerFrm.id.value = '';
						</script>
					</c:if>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>