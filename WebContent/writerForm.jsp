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
	<script type="text/javascript">
		function validate(frm) {
			if (frm.title.value == '') {
				alert("제목을 입력하세요.");
				return false;
			} else {
				if (frm.title.value.length > 40) {
					alert("제목은 40자 이내로 작성하세요.");
					return false;
				}
			}
			if (frm.writer_name.value == '') {
				alert("닉네임을 입력하세요.");
				return false;
			}
			if (frm.password.value == '') {
				alert("암호를 입력하세요. 글 삭제나 수정시 필요합니다.");
				return false;
			}
			if (frm.imagename.value == '') {
				alert("이미지를 선택하세요.");
				return false;
			}
			var r = confirm("정말로 저장하시겠습니까?");
			if (r == false)
				return false;

		}
	</script>


	<h3 align="center">이미지 게시글 작성</h3>
	<!-- file은 enctype가 꼭 있어야함  -->
	<form action="write.do" method="post" enctype="multipart/form-data"
		onSubmit="return validate(this)">
		<input type="hidden" name="orderno" value="${writing.order_no + 1 }" />
		<c:if test="${ ! empty writing.group_id }">
			<input type="hidden" name="groupid" value="${writing.group_id }"/ >
		</c:if>
		<c:if test="${!empty writing.parent_id }">
			<input type="hidden" name="parentid" value="${writing.parent_id }" />
		</c:if>


		<table border="1" align="center">
			<tr>
				<th>글제목</th>
				<td><input type="text" name="title" size="40" value="${title }" /></td>
			</tr>
			<tr>
				<th>닉네임</th>
				<td><input type="text" name="writer_name" size="20" /></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="email" size="20" /></td>
			</tr>
			<tr>
				<th>암호</th>
				<td><input type="password" name="password" size="20" /></td>
			</tr>
			<tr>
				<th>이미지</th>
				<td><input type="file" name="imagename" size="20" /></td>
			</tr>
			<tr>
				<th>글내용</th>
				<td><textarea rows="8" cols="80" name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="등 록" /></td>
			</tr>

		</table>
	</form>
</body>
</html>