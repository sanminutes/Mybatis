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
<script type="text/javascript">
var g_Timer = 0;
var g_DBNowTime = new Date(); // 현재시간
	var g_LastTime= new Date(g_DBNowTime); //경매 마감 시간
	g_LastTime.setSeconds(g_LastTime.getSeconds()+10);
/* 	g_LastTime.setDate(g_LastTime.getDate()+1); */

function Countdown() {

	var NowTime = new Date(g_DBNowTime.getTime() + (g_Timer * 1000));

	var iGap = Math
			.floor((g_LastTime.getTime() - NowTime.getTime()) / (1000));
	var strLastTime = "";

	if (iGap > 0) // 종료전
	{
		strLastTime = FormatGap(iGap, "full");

		setTimeout("Countdown()", 1000);
		g_Timer = g_Timer + 1;
	}		
	else // 종료 후
	{
		document.getElementById('a_high_p').disabled = true;
		strLastTime = "이 물품은 경매마감되었습니다.";


	}
	
	if(frm5.diwp.value<=frm5.nowp.value){
		document.getElementById('a_high_p').disabled = true;
		strLastTime = "이 물품은 조기마감 되었습니다다.";

	}


	if (document.getElementById("hdivMessage") != "undefined") {
		document.getElementById("hdivMessage").innerHTML = strLastTime;

	}
}

function FormatGap(iGap, format) {
	var iGapTime = new Date(2000, 0, 1, 0, 0, iGap);
	var strLeftTime = "";

	if (format == "full") {
		if (iGapTime.getMonth() > 0 || iGapTime.getDate() > 1)
			strLeftTime = "<span class='fc'>"
					+ Math.floor(iGap / (60 * 60 * 24)) + "일 </span>";
		return strLeftTime + "<span class='fc'>" + iGapTime.getHours()
				+ "시간 " + iGapTime.getMinutes() + "분 "
				+ iGapTime.getSeconds() + "초 </span>";
	} else {
		return "<span class='fc'>" + iGapTime.getMinutes() + "분 "
				+ iGapTime.getSeconds() + "초 </span>";
	}
	

}
	function ipchal(){
		var tmp = frm5.nowp.value;
		tmp = Number(tmp);
		alert(tmp);

		if(frm5.a_high_p.value==""){
			alert("입찰가를 입력하세요");
			frm5.a_high_p.focus();
			return false;
		}
		else if(isNaN(frm5.a_high_p.value)!=0){
			alert("입찰가를 숫자로 입력하세요");
			frm5.a_high_p.select();
			return false;
		}
		else if(frm5.a_high_p.value<=tmp){
			alert("입찰가가 현재가보다 낮습니다.");
			frm5.a_high_p.select();
			return false;
		}
		else{
			alert("[입찰가] : "+frm5.a_high_p.value+" 입찰되셨습니다.");
			frm5.nowp.value=frm5.a_high_p.value;
			frm5.nowp.disabled=true;
		}
		return true;
	}
</script>
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

.invisible {
	clear: none;
	border: 0px none;
	float: none;
	background-color: #ffffff;
	outline: 0;
}
</Style>
</head>
<body>
	<c:if test="${empty auction }">
존재하지 않는 글입니다.
</c:if>
	<c:if test="${!empty auction}">
		<br />
		<form name="frm5" action="../write/auctioninfo.html" method="post">
			<input type="hidden" name="a_num" value="${auction.a_num }">
			<input type="hidden" name="a_id" value="${sessionScope.loginUser }">
			<table width="1100px" align="center"
				style="font-family: 'Nanum Gothic', sans-serif;">
				<tr>
					<td colspan="2" width="500" align="center"
						style="table-layout: fixed;"><img alt=""
						src="../img/${auction.a_num }.jpeg" width="500" height="500"></td>
					<td colspan="2" width="500"><div>
							<div style="float: left">
								<font size="3" color="#BDBDBD"> 판매자 : ${auction.a_id }</font><br />
							</div>
							<div align="right">

								<font size="3" color="#BDBDBD">상품번호 : ${auction.a_num}</font>
							</div>
						</div>
						<hr class="itemhr"> <font size="6"> ${auction.a_name }</font><br />
						<br /> 즉시결제: <input type="text" name="diwp"
						value="<fmt:formatNumber
						value="${auction.a_direct_p }"  />"
						style="text-align: right" class="invisible">원<br /> <c:choose>
							<c:when test="${auction.a_price >= max }">현재가 :<input
									type="text" name="nowp" style="text-align: right"
									class="invisible"
									value="<fmt:formatNumber
						value="${auction.a_price }"  />">
							</c:when>
							<c:otherwise>현재가 :<input type="text" name="nowp"
									style="text-align: right" class="invisible"
									value="<fmt:formatNumber
						value="${max}"  />">
							</c:otherwise>
						</c:choose>원<br /> 입찰가 : <input type="text" name="a_high_p" id="a_high_p" />
						<br />입찰수: ${cnt }<br />남은 시간 :
						<div class="t_gold" id="hdivMessage" style="float: right"></div> <br />
						<br /> <input type="submit" value="입찰" id="cartbutton"
						onclick="return ipchal()"> <input type="button"
						onClick="reset()" value="취소" id="buybutton"></td>

					<!-- <c:if
							test="${empty max  }">0</c:if><c:if
							test="${empty max  }">0</c:if> -->
				</tr>
			</table>
		</form>
	</c:if>

	<script>
		Countdown();
	</script>
</body>
</html>