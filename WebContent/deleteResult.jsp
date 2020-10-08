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
	<c:if test="${!empty param.id }">
		<script type="text/javascript">
			alert("삭제되지 않았습니다. 암호가 일치하지 않습니다.");
			location.href = "imageRead?id=" + ${param.id}; //삭제되지 않았으므로, 상세페이지로 전환
		</script>
	</c:if>
	<c:if test="${empty param.id }">
		<script type="text/javascript">
			alert("삭제되었습니다.");
			location.href = "imageList"; //삭제한 후 목록으로 전환
		</script>

	</c:if>



</body>
</html>