<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<HEAD>
<title>�������ð�</title>
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
sec = " ��."
min = " ��, "
hr = " �ð�, "
dy = " ��, "
document.counter.counter_box.value = "  Ȩ������ �����ϱ��� ���� �ð� :   " + daysRound  +
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