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
	<h2 align="center">야구 선수 등록</h2>
	<form action="putBaseballPlayer" method="post"
		onSubmit="return check(this)" name="registerPlayer">
		<fieldset>
			<legend>선수 상세 정보</legend>
			<input type="hidden" name="CHECKED" /> 선수번호 : <input type="text"
				name="ID" /> <input type="button" value="중복검사" onClick="checkId()" />
			<br /> 팀번호 및 이름 : <select name="TEAM_ID">
			<option>-선택하세요-</option>
					<c:forEach var="team" items="${TEAM }">
						<option value="${team.id }">${team.name }</option>
					</c:forEach></select> 선수이름 : <input type="text" name="NAME" /><br /> 포지션 : <select
				name="POS"><option>-선택하세요-</option>
				<option>투수</option>
				<option>포수</option>
				<option>1루수</option>
				<option>2루수</option>
				<option>3루수</option>
				<option>유격수</option>
				<option>좌익수</option>
				<option>중견수</option>
				<option>우익수</option>
				<option>지명타자</option></select><br /> 등록일 : <input type="date" name="R_DATE" /><br />
			탈퇴일 : <input type="date" name="E_DATE" /><br /> 성별 : 남<input
				type="radio" name="GEN" value="M" /> 여<input type="radio"
				name="GEN" value="F" /><br /> 주소 : <input type="text" name="ADDR"
				size="30" /><br /> 연락처 : <input type="text" name="TEL" /><br />
			소개글(아래) : <br />
			<textarea rows="5" cols="80" name="INTRO"></textarea>
		</fieldset>
		<div align="center">
			<input type="submit" value="등록" /> <input type="reset" value="취소" />
		</div>


	</form>
</body>
</html>