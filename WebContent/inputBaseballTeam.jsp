<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2 align="center">야구 구단 등록</h2>
	<form action="putBaseballTeam" method="post" onSubmit="return check()"
		name="team">
		<fieldset>
			<legend>상세 정보 입력</legend>
			팀 이름 : <input type="text" name="NAME" /><br /> 연고 지역 : <select
				name="TOWN">
				<option>선택하세요</option>

				<c:forEach var="name" items="${TOWN }">
					<option>${name	}</option>

				</c:forEach>

			</select><br /> 구단주 이름 : <input type="text" name="OWNER" /><br /> 창단일 : <input
				type="date" name="BIRTH" /><br /> 구단 소개(아래) :<br />
			<textarea rows="5" cols="80" name="INTRO"></textarea>
		</fieldset>
		<div align="center">
			<input type="submit" value="등록" /> <input type="reset" value="취소" /><br />

		</div>


	</form>
	<script type="text/javascript">
		function check() {
			if (document.team.NAME.value == '') {
				alert("구단 이름을 입력하세요.");
				return false;
			}
			if (document.team.TOWN.selectedIndex < 1) {
				alert("연고지를 선택하세요.");
				return false;
			}
			if (document.team.OWNER.value == '') {
				alert("구단주 이름을 입력하세요.");
				return false;
			}
			if (document.team.BIRTH.value == '') {
				alert("창단일을 선택하세요.");
				return false;
			}
			if (document.team.INTRO.value == '') {
				alert("구단 소개를 입력하세요.");
				return false;
			}
			if (confirm("입력한 내용이 맞습니까?")) {

			} else {
				return false;
			}
		}
	</script>
</body>
</html>