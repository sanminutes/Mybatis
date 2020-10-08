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
	<c:if test="${! empty param.id }">
		<script type="text/javascript">
			alert("변경되지 않았습니다. 암호가 일치하지 않습니다.");
			location.href = "imageRead?id=" + ${param.id};
		</script>
	</c:if>
	<c:if test="${! empty param.seqno }">
		<script type="text/javascript">
			alert("변경되었습니다.");
			location.href="imageList?seqno="+${param.seqno};
		</script>
	</c:if>
</body>
</html>