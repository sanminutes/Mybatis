<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>


	<h5 style="margin-top: 10px; margin-left: 44px">판매상점
		>${TITLE[0].title}</h5>
	<table>
		<tr>
			<%!int cnt = 0;%>
			<c:forEach var="t" items="${TITLE }">
				<td width="40"></td>
				<td width="150" height="150"><img alt=""
					src="../img/${t.writing_id }.jpeg" width="200" height="200" /><br />
					<a href="javascript:goView(${t.writing_id })"
					style="word-break: break-all;"><font color="black" size="4">${t.writer_name }</font></a><br />
					<b><font size="5"><fmt:formatNumber value="${t.price }" />원</font>
				</b><br /> <font size="3"><c:if test="${t.charge_price != 0}">배송비 <fmt:formatNumber
								value="${t.charge_price }" />원</c:if> <c:if
							test="${t.charge_price == 0}">무료배송</c:if></font><br /></td>
				<%
					cnt++;
				%>
				<%
					if (cnt == 5) {
							cnt = 0;
				%>
			
		</tr>
		<tr>
			<%
					}
				%>

			</c:forEach>
			<%
					cnt = 0;
				%>
		</tr>
	</table>

	<script type="text/javascript">
			function goPage(page, category) {
				document.move.action = "../write/writeList.html";
				document.move.PAGE_NUM.value = page;
				document.move.category.value = category;
				document.move.submit();
			}
			function goView(no) {
				document.move.id.value = no;
				document.move.action = "../read/readImage.html";
				document.move.submit();
			}
		</script>
	<form name="move" method="post">
		<input type="hidden" name="id" /><input type="hidden" name="category"
			value="${category }" /> <input type="hidden" name="PAGE_NUM"
			value="${currentPage }" />
	</form>
</body>
</html>