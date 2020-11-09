<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<Style>
@import url(//fonts.googleapis.com/earlyaccess/nanumgothic.css);

.itemhr {
	border: 0px;
	height: 1px;
	background-color: #D5D5D5;
}
</Style>
</head>
<body>
	<c:if test="${empty writing }">
존재하지 않는 글입니다.
</c:if>
	<c:if test="${!empty writing }">
		<table width="90%" align="center"
			style="font-family: 'Nanum Gothic', sans-serif;">
			<tr>
				<td colspan="2" width="500" align="center"
					style="table-layout: fixed;"><img alt=""
					src="../img/${writing.writing_id }.jpeg"
					width="500" height="500"></td>
				<td colspan="2" width="500"><div>
						<div style="float: left">
							<a href="#"><font color="black">${writing.title }</font></a>
						</div>

						<div align="right">

							<font size="3" color="#BDBDBD">상품번호 : ${writing.writing_id }</font>
						</div>
					</div>
					<hr class="itemhr"> <font size="6">
						${writing.writer_name }</font><br /> <font size="6"><b><fmt:formatNumber
								value="${writing.price }" />원</b></font>
					<hr class="itemhr"> <c:if test="${writing.charge_price == 0 }">
						<font size="4"><b>무료배송</b></font>
					</c:if> <c:if test="${writing.charge_price != 0 }">
						<font size="4"><b>배송비 <fmt:formatNumber
									value="${writing.charge_price }" />원
						</b></font>
					</c:if>
					<hr class="itemhr"> <font size="4"><b>원산지 -
							${writing.country }</b></font>
					<hr class="itemhr"> <font size="4"><b>본 상품은
							${writing.delivery }배송 가능합니다.</b></font>
					<hr class="itemhr"> <font size="4"><b>옵션선택</b></font><br /> <br />
					<select id="itemselect1" name="itemselect1"
					style="width: 500px; height: 40px; font-size: 20px;">
						<c:forTokens var="options1" items="${writing.options1 }"
							delims=",">
							<option value="${fn:trim(options1)}"><c:out
									value="${fn:trim(options1)}" /></option>
						</c:forTokens>
				</select><br /> <select id="itemselect2" name="itemselect2"
					style="width: 500px; height: 40px; font-size: 20px;">
						<c:forTokens var="options2" items="${writing.options2 }"
							delims=",">
							<option value="${fn:trim(options2)}"><c:out
									value="${fn:trim(options2)}" /></option>
						</c:forTokens>
				</select><br /> <a href="#" onClick="javascript:button1_click(); "><input
						type="button" value="장바구니"></a> <input type="button"
					value="구매하기"></td>
			</tr>

			<tr>
				<td colspan="4" height="40"><input type="button" value="상세설명">
					<input type="button" value="상품평"> <input type="button"
					value="상품문의"> <input type="button" value="교환/반품"></td>
			</tr>
			<tr>
				<td colspan="4" width="150"></td>
			</tr>





		</table>
	</c:if>
	<script type="text/javascript">
		function button1_click() {
			var op1 = document.getElementById("itemselect1");
			var op2 = document.getElementById("itemselect2");
			if (op1.options[0].selected == true
					|| op2.options[0].selected == true) {
				alert("주문하실 상품의 옵션을 선택하셔야 합니다.");
			} else {
				var val1 = op1.options[op1.selectedIndex].value;
				var val2 = op2.options[op2.selectedIndex].value;
				var url = '../cart/addCart.html?CODE=${writing.writing_id }&SIZE='
						+ val1 + '&NUM=' + val2;
				var ret = window.open(url, 'cart', 'width=400,height=400')
						.focus();

			}

		}
	</script>

</body>
</html>