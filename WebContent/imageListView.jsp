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
	<c:if test="${empty LIST }">
등록된 게시글이 존재하지 않습니다.
</c:if>
	<c:if test="${ ! empty LIST }">
		<table width="100%">
			<tr>
				<td align="right">${startRow }~${endRow }/${count }</b></td>
			</tr>
		</table>
		<table width="100%" border="1">
			<tr>
				<td>이미지</td>
				<td>글제목</td>
				<td>작성자</td>
				<td>작성일</td>
			</tr>
			<c:forEach var="writing" items="${LIST }">
				<tr>
					<td><img alt="" src="upload/${writing.image_name }" width="50"
						height="50" /></td>
					<td><a href="javascript:goView(${writing.writing_id })">${writing.title }</a></td>
					<td>${writing.writer_name }</td>
					<td>${writing.register_date }</td>
				</tr>
			</c:forEach>
		</table>

		<c:forEach var="pageNo" begin="1" end="${pageCount }">
			<c:if test="${currentPage == pageNo }">
				<font size="5">
			</c:if>
			<a href="imageList?Page=${pageNo }">${pageNo }</a>
			<c:if test="${currentPage == pageNo }">
				</font>
			</c:if>
		</c:forEach>
	</c:if>
	<script type="text/javascript">
		function goView(no) {
			document.move.id.value = no;
			document.move.action = "imageRead";
			document.move.submit();
		}
	</script>
	<form name="move" method="post">
		<input type="hidden" name="id" /> <input type="hidden" name="page"
			value="${currentPage }" />
	</form>
</body>
</html>