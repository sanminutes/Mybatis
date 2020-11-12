<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
 ${ID}
	<script type="text/javascript">
		alert("입찰이 완료되었습니다.");
		location.href = "../read/readAuction.html?id=" + ${ID};
	</script>
</body>
</html>