<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		function validate(frm) {
			if (frm.password.value == '') {
				alert("암호를 입력하세요.");
				return false;
			}
			var r = confirm("정말로 삭제하시겠습니까?");
			if (r == false)
				return false;
		}
	</script>
	<form action="delete.do" method="post" onSubmit="return validate(this)">
		<input type="hidden" name="id" value="${writing.writing_id }" />
		<table width="100%" border="1">
			<tr>
				<td>글제목</td>
				<td>${writing.title }</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${writing.writer_name }</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>${writing.email }</td>
			</tr>
			<tr>
				<td>암호</td>
				<td><input type="password" name="password" size="20" /></td>
			</tr>
			<tr>
				<td>이미지</td>
				<td><img alt="" src="upload/${writing.image_name }" width="350"
					height="350" border="0"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="삭제" /> <input
					type="button" value="취소" onclick="javascript:history.go(-1)" /></td>
			</tr>
		</table>
	</form>
</body>
</html>