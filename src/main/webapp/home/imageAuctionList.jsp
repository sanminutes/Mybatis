<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
@import url(//fonts.googleapis.com/earlyaccess/nanumgothic.css);

.item {
	font-family: 'Nanum Gothic', sans-serif;
}
</style>
</head>
<body>
	<c:if test="${loginLevel==2||loginLevel==3 }">
		<a href="../write/writeForm.html"><font color="black">상품추가(테스트)</font></a>
	</c:if>
	<h2 style="margin-top: -10px; margin-left: 45px;">
		<font size="4">상품정보</font>
	</h2>
	<c:if test="${empty AuctionItem }">
		<div align="center">등록된 게시글이 존재하지 않습니다.</div>
	</c:if>
	<c:if test="${ ! empty AuctionItem }">
		<table class="item" style="margin-top: -20px;">
			<tr>
				<%!int cnt = 0;%>
				<c:forEach var="atItem" items="${AuctionItem }">
					<td width="40"></td>
					<td width="150" height="150"><img alt=""
						src="../img/${atItem.a_num }.jpeg" width="200" height="200" /><br />
						<a href="javascript:goView(${atItem.a_num })"
						style="word-break: break-all;"><font color="black" size="4">${atItem.a_name }</font></a><br />
						<b><font size="5"><fmt:formatNumber
									value="${atItem.a_price }" />원</font> </b><br /> <font size="3"><c:if
								test="${atItem.a_price != 0}">배송비 <fmt:formatNumber
									value="${atItem.a_price }" />원</c:if> <c:if
								test="${atItem.a_price == 0}">무료배송</c:if></font><br /></td>
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
		</c:if>
		<%-- <div align="center">
			<c:set var="startPage"
				value="${currentPage-(currentPage%10 == 0? 10:(currentPage%10)) +1 }" />
			<c:set var="endPage" value="${startPage + 9 }" />
			<c:if test="${endPage > pageCount }">
				<c:set var="endPage" value="${pageCount }" />
			</c:if>
			<c:if test="${startPage > 10 }">
				<a href="javascript:goPage(${startPage -1 },${category })">[이전]</a>
			</c:if>

			<c:forEach var="pageNo" begin="${startPage }" end="${endPage }">
				<c:if test="${currentPage == pageNo }">

				</c:if>
				<a href="javascript:goPage(${pageNo },${category })"><font
					color="black" size="4">${pageNo }</font></a>
				<c:if test="${currentPage == pageNo }">

				</c:if>
			</c:forEach>
			<c:if test="${endPage < pageCount}">
				<a href="javascript:goPage(${endPage + 1 },${category })">[다음]</a>
			</c:if>
	</c:if>
	</div> --%>
	 <script type="text/javascript">
		function goPage(page, category) {
			document.move.action = "../write/writeList.html";
			document.move.PAGE_NUM.value = page;
			document.move.category.value = category;
			document.move.submit();
		}
		function goView(no) {
			document.move.id.value = no;
			document.move.action = "../read/readAuction.html";
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