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
	<c:if test="${param.R == 'OK' }">
		<script type="text/javascript">
			alert("새로운 이미지가 등록되었습니다.");
		</script>
	</c:if>
	<c:if test="${param.R != 'OK'}">
		<script type="text/javascript">
			alert("이미지 등록이 실패했습니다. 관리자에게 문의하세요.");
		</script>
	</c:if>
</body>
</html>