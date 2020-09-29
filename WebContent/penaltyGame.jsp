<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2 align="center">* 페널티킥 게임 *</h2>
	<div align="center">슛을 날릴 방향을 선택하세요.</div>
	<table align="center">
		<tr>
			<td>
				<form action="shootResult">
					상 : <input type="radio" name="shoot" value="0" /> 하 : <input
						type="radio" name="shoot" value="1" /> 좌 : <input type="radio"
						name="shoot" value="2" /> 우 : <input type="radio" name="shoot"
						value="3" /> 중 : <input type="radio" name="shoot" value="4" /><br />
					<br />

					<div align="center">
						<input type="submit" value="슛!!!" />
					</div>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>