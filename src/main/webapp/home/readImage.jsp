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

#cartbutton {
	font-size: 20px;
	height: 50px;
	width: 267px;
	background-color: #F15F5F;
	border: 1px solid #D5D5D5;
	color: white;
}

#buybutton {
	font-size: 20px;
	height: 50px;
	width: 267px;
	background-color: white;
	border: 1px solid #D5D5D5;
}

#sh {
	border-radius: 10px 10px 10px 10px;
	border: 1px solid #B1B1B1;
	width: 80px;
	height: 30px;
	background-color: #B1B1B1;
	font-size: 14px;
	color: white;
}
</Style>
</head>
<body>
	<c:if test="${empty writing }">
존재하지 않는 글입니다.
</c:if>
	<c:if test="${!empty writing }">
		<br />
		<table width="1100px" align="center"
			style="font-family: 'Nanum Gothic', sans-serif;">
			<tr>
				<td colspan="2" width="500" align="center"
					style="table-layout: fixed;"><img alt=""
					src="../img/${writing.writing_id }.jpeg" width="500" height="500"></td>
				<td colspan="2" width="500"><div>
						<div style="float: left">
							<a href="../write/titlelist.html?title=${writing.title }"><font color="black">${writing.title }</font></a>
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
					<div style="line-height: 10px">
						<select id="itemselect1" name="itemselect1"
							style="width: 540px; height: 40px; font-size: 16px;">
							<c:forTokens var="options1" items="${writing.options1 }"
								delims=",">
								<option value="${fn:trim(options1)}"><c:out
										value="${fn:trim(options1)}" /></option>
							</c:forTokens>
						</select><br /> <br /> <select id="itemselect2" name="itemselect2"
							style="width: 540px; height: 40px; font-size: 16px;">
							<c:forTokens var="options2" items="${writing.options2 }"
								delims=",">
								<option value="${fn:trim(options2)}"><c:out
										value="${fn:trim(options2)}" /></option>
							</c:forTokens>
						</select><br /> <br /> <a href="#" onClick="javascript:button1_click(); "><input
							type="button" value="장바구니" id="cartbutton"></a> <input
							type="button" value="구매하기" id="buybutton">
					</div></td>
			</tr>
			<tr height="20px">
				<td></td>
			</tr>


			<tr>
				<td colspan="4" height="40" style="background-color: #D5D5D5;">&nbsp;&nbsp;<input
					type="button" value="상세설명" id="sh"> <input type="button"
					value="상품평" id="sh"> <input type="button" value="상품문의"
					id="sh"> <input type="button" value="교환/반품" id="sh"></td>
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