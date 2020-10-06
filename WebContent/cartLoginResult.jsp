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
	<c:choose>
		<c:when test="${param.RESULT == 'YES' }">
			<script type="text/javascript">
				self.close();
				opener.window.location.reload();
			</script>
		</c:when>

		<c:otherwise>
			로그인되지 않았습니다. 계정과 암호를 확인하세요.
			</c:otherwise>
	</c:choose>
</body>
</html>