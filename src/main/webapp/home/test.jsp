<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<HEAD>
<title>경매종료시간</title>
<SCRIPT type="text/javascript">

function reverse_counter(){
today = new Date();
d_day = new Date("2020/11/12 22:58:30");
days = (d_day - today) / 1000 / 60 / 60 / 24;
alert(days);
daysRound = Math.floor(days);
hours = (d_day - today) / 1000 / 60 / 60 - (24 * daysRound);
hoursRound = Math.floor(hours);
minutes = (d_day - today) / 1000 /60 - (24 * 60 * daysRound) - (60 * hoursRound);
minutesRound = Math.floor(minutes);
seconds = (d_day - today) / 1000 - (24 * 60 * 60 * daysRound) - (60 * 60 * hoursRound) -
 (60 * minutesRound);
secondsRound = Math.round(seconds);
sec = " 초."
min = " 분, "
hr = " 시간, "
dy = " 일, "
document.counter.counter_box.value = "  홈페이지 개장일까지 남은 시간 :   " + daysRound  +
dy + hoursRound + hr + minutesRound + min + secondsRound + sec;
newtime = window.setTimeout("reverse_counter();", 1000);
}

</script>
</HEAD>
<BODY onLoad="reverse_counter()">

	<center>
		<form name="counter">
			<input type="text" name="counter_box" size="55">
		</form>
	</center>
</body>
</html>