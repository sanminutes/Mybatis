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
//86400000ms는 1day를 의미한다.
//1s = 1,000ms
//1m = 60s * 1,000ms = 60,000ms
//1h = 60m * 60,000ms = 3,600,000ms
//1d = 24h * 3,600,000ms = 86,400,000ms
/* 	var g_Timer = 0;
	var g_DBNowTime = new Date(${auction.a_date}); // 현재시간
	var g_LastTime = new Date(${auction.a_date}); //경매 마감 시간
	g_LastTime.setTime(g_LastTime.getTime()+86400000);
	
	var g_location = new Date(); // 실시간 시간
	/* 	g_LastTime.setDate(g_LastTime.getDate()+1); */
 function reverse_counter(){
var today = new Date();
var d_day = new Date('${auction.a_date}');
days = (d_day - today) / 1000 / 60 / 60 / 24;
daysRound = Math.floor(days);
hours = (d_day - today) / 1000 / 60 / 60 - (24 * daysRound);
hoursRound = Math.floor(hours);
minutes = (d_day - today) / 1000 /60 - (24 * 60 * daysRound) - (60 * hoursRound);
minutesRound = Math.floor(minutes);
seconds = (d_day - today) / 1000 - (24 * 60 * 60 * daysRound) - (60 * 60 * hoursRound) -
 (60 * minutesRound);

secondsRound = Math.round(seconds);
sec = " 秒"
min = " 分, "
hr = " 時間, "
dy = " 日, "
	document.getElementById("hdivMessage").innerHTML = daysRound  +
dy + hoursRound + hr + minutesRound + min + secondsRound + sec;
newtime = window.setTimeout("reverse_counter();", 1000);

var pattern = /[^(0-9)]/gi; 
var a = frm5.diwp.value; //즉시결제가
var b = frm5.nowp.value; //현재가
if(pattern.test(a)){
	a = a.replace(pattern,"");
	a = Number(a);
}
if(pattern.test(b)){
	b = b.replace(pattern,"");
	b = Number(b);
}

if(daysRound<0 || a <= b){
	document.getElementById('a_high_p').disabled = true;
	document.getElementById("hdivMessage").innerHTML = "このオークションは終了しています。";
}
	}

	function ipchal() {
		var pattern = /[^(0-9)]/gi; 
		var a = frm5.diwp.value; //즉시결제가
		var b = frm5.nowp.value; //현재가
		var c = frm5.a_high_p.value; //입력가

		a = a.replace(pattern,"");
		a = Number(a);
		b = b.replace(pattern,"");
		b = Number(b);
		c = c.replace(pattern,"");
		c = Number(c);
		
		alert(frm5.a_high_p.value <= b);
		if (frm5.a_high_p.value == "") {
			alert("金額を入力してください");
			frm5.a_high_p.focus();
			return false;
		} else if (isNaN(frm5.a_high_p.value) != 0) {
			alert("金額は数字だけで入力してください");
			frm5.a_high_p.select();
			return false;
		} else if (c <= b) {
			alert("最低入礼額を下回っています");
			frm5.a_high_p.select();
			return false;
		} else if (c>a){
				alert("即決額より入礼額が高いです");
				frm5.a_high_p.select();
				return false;
		} else {
			alert("[入礼額] : " + frm5.a_high_p.value + "円で入礼されました");
			frm5.nowp.value = frm5.a_high_p.value;
			frm5.nowp.disabled = true;
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
<body onLoad="reverse_counter()">
	<c:if test="${empty auction }">
존재하지 않는 글입니다.
</c:if>
	<c:if test="${!empty auction}">
		<br />
		<form name="frm5" action="../write/auctioninfo.html" method="post">
			<input type="hidden" name="a_num" value="${auction.a_num }">
			<table width="1100px" align="center"
				style="font-family: 'Nanum Gothic', sans-serif;">
				<tr>
					<td colspan="2" width="500" align="center"
						style="table-layout: fixed;"><img alt=""
						src="../img/${auction.a_num }.jpeg" width="500" height="500"></td>
					<td colspan="2" width="500"><div>
							<div style="float: left">
								<font size="3" color="#BDBDBD"> 出品者 : ${auction.a_id }</font><br />
							</div>
							<div align="right">

								<font size="3" color="#BDBDBD">オークションID :
									${auction.a_num}</font>
							</div>
						</div>
						<hr class="itemhr"> <font size="6"> ${auction.a_name }</font>（${cnt }件の入礼あり）<br />
						<br /> <c:choose>
							<c:when test="${auction.a_price >= max }">
								<div style="float: left">
									<font size="5" color="#BDBDBD">現在</font>
								</div>
								<div align="right">
									<input type="text" name="nowp"
										style="text-align: right; font-size: 20px;" class="invisible"
										value="<fmt:formatNumber
						value="${auction.a_price }" />"><font
										size="5" color="#BDBDBD">円</font>
								</div>
							</c:when>
							<c:otherwise>
								<div style="float: left">
									<font size="5" color="#BDBDBD">現在</font>
								</div>
								<div align="right">
									<input type="text" name="nowp"
										style="text-align: right; font-size: 20px;" class="invisible"
										value="<fmt:formatNumber
						value="${max}" />"><font
										size="5" color="#BDBDBD">円</font>
								</div>
							</c:otherwise>
						</c:choose><br />
						<div style="float: left; margin-top: -20px;">
							<font size="5" color="#BDBDBD">即決</font>
						</div>
						<div align="right" style="margin-top: -20px;">
							<input type="text" name="diwp"
								value="<fmt:formatNumber
						value="${auction.a_direct_p }" />"
								style="text-align: right; font-size: 20px; color: red;"
								class="invisible"><font size="5" color="#BDBDBD">円</font>
						</div> <br /> 残り
						<div class="t_gold" id="hdivMessage" style="float: right"></div> <br />
						<hr class="itemhr">
						<div style="float: left;">入札額</div>
						<div align="right">
							<input type="text" name="a_high_p" id="a_high_p"
								style="font-size: 20px;" /><font size="5" color="#BDBDBD">円</font>
						</div>
						<hr class="itemhr"> <input type="submit" value="入礼する"
						id="cartbutton" onclick="return ipchal()"> <input
						type="button" onClick="reset()" value="キャンセル" id="buybutton"></td>

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