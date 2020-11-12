<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/css.css">
</head>
<body>
	<script type="text/javascript">
alert("판매 상품이 등록 되었습니다");
location.href="../write/writeList.html?SEQNO=" + ${param.SEQNO} +"&category="+${param.category};
</script>
</body>
</html>