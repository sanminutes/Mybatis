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
			if (frm.TITLE.value == '') {
				alert("제목을 입력하세요");
				return false;
			}
			if (frm.CONTENT.value == '') {
				alert("글 내용을 입력하세요.");
				return false;
			}
			var r = confirm("글을 올리시겠습니까?");
			if (r == false)
				return false;
		}
	</script>
	<h2 align="center">게시판 글쓰기</h2>
	<form action="bbsPost" method="post" onSubmit="return validate(this)">
		<table align="center" width="90%">
			<tr>
				<td>제 목 :</td>
				<td><input type="text" name="TITLE" style="width: 100%" /></td>
			</tr>
			<tr>
				<td colspan="2"><textarea rows="5" name="CONTENT"
						style="width: 100%"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="글 올리기" /> <input type="reset" value="취 소" /></td>
			</tr>
		</table>

	</form>

</body>
</html>