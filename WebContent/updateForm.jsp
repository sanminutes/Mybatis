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
			if (frm.title.value == '') {
				alert("제목을 입력하세요.");
				return false;
			}
			if (frm.name.value == '') {
				alert("닉네임을 입력하세요.");
				return false;
			}
			if (frm.password.value == '') {
				alert("암호를 입력하세요.");
				return false;
			}
			if (frm.content.value == '') {
				alert("내용을 입력하세요.");
				return false;
			}
			var r = confirm("정말로 변경하시겠습니까?");
			if (r == false)
				return false;
		}
	</script>
	<form action="update.do" method="post" enctype="multipart/form-data"
		onSubmit="reutrn validate(this)">
		<input type="hidden" name="id" value="${writing.writing_id }" />
		<table width="100%" border="1" align="center">
			<tr>
				<td>글제목</td>
				<td><input type="text" name="title" size="20"
					value="${writing.title} " /></td>
			</tr>
			<tr>
				<td>닉네임</td>
				<td><input type="text" name="name" size="20"
					value="${writing.writer_name} " /></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email" size="30"
					value="${writing.email} " /></td>
			</tr>
			<tr>
				<td>암 호</td>
				<td><input type="password" name="password" size="20" /></td>
			</tr>
			<tr>
				<td>이미지</td>
				<td><input type="file" name="image_name" /><br /> <img alt=""
					src="upload/${writing.image_name }" width="350" height="350"
					border="0"></td>
			</tr>
			<tr>
				<td>글내용</td>
				<td><textarea rows="8" cols="40" name="content">${writing.content }</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="수정" /> <input
					type="button" value="취소" onClick="javascript:history.go(-1)" /></td>
			</tr>
		</table>
	</form>
</body>
</html>