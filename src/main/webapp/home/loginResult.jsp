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
	<c:choose>
		<c:when test="${sessionScope.loginUser != null}">
			<script type="text/javascript">
				alert("로그인 되었습니다. 환영합니다. [${sessionScope.loginUser }]님");
				location.href = "../home/index.jsp";
				self.close();
				opener.location.reload();
			</script>


		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				alert("로그인 되지 않았습니다. 암호를 확인해주세요.");
				history.go(-1);
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>