<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<script language="javascript">
	var g_Timer = 0;
	var g_LastTime = new Date(2020, 11, 12, 03, 21, 59); // 경매마감시간
	var g_DBNowTime = new Date(2020, 11, 12, 03, 21, 52); // 현재시간

	function Countdown() {
		var NowTime = new Date(g_DBNowTime.getTime() + (g_Timer * 1000));
		var iGap = Math
				.floor((g_LastTime.getTime() - NowTime.getTime()) / (1000));
		var strLastTime = "";

		if (iGap > 0) // 현재진행중이라면
		{
			strLastTime = FormatGap(iGap, "full");

			setTimeout("Countdown()", 1000);
			g_Timer = g_Timer + 1;
		} else // 마감이라면...
		{
			strLastTime = "경매종료";
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
</script>
</head>
<body>
	<dd class="t_gold" id="hdivMessage"></dd>
	<script>
		Countdown();
	</script>
</body>
</html>