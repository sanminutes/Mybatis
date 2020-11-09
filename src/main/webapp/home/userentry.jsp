<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function idCheck() {
		//1.ID가 입력되었는지 확인한다.
		if (document.registerFrm.id.value == '') {
			alert("ID를 입력하세요.");
			document.registerFrm.id.focus();
			return;//함수 종료
		}
		//2. 팝업창을 띄워서 중복검사의 결과를 보여준다.
		window.open("../idcheck/idcheck.html?USER=" + document.registerFrm.id.value,
				"_blank", "width=450, height=300")
		//window.open(내용, 식별자, 크기)

	}
	function formCheck(frm) {
		if (frm.IDCHK.value == '') {
			alert("ID중복검사를 해주세요.");
			return false;
		}
		if (frm.name.value == '') {
			alert("이름을 입력하세요.");
			return false;
		}
		if (frm.id.value == '') {
			alert("아이디를 입력하세요.");
			return false;
		}
		if (frm.password.value == '') {
			alert("암호를 입력하세요.");
			return false;
		}
		if (frm.password.value != frm.CONFIRM.value) {
			alert("암호가 일치하지 않습니다.");
			return false;
		}
		if (frm.job.selectedIndex < 1) {
			alert("직업을 선택하세요.");
			return false;
		}
		if (!frm.gender[0].checked && !frm.gender[1].checked) {
			alert("성별을 입력하세요.");
			return false;
		}
		if (confirm("입력한 내용이 맞습니까?")) {

		} else {
			return false;
		}
	}
</script>
</head>
<body>
	<div align="center">
		<h2 align="center">개인정보 입력</h2>
		<form:form action="../entry/entry.html" method="post"
			modelAttribute="guest" name="registerFrm"
			onSubmit="return formCheck(this)">
			<input type="hidden" name="IDCHK" />
			<table>
				<tr>
					<td>이 름 :</td>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<td>아이디:</td>
					<td><form:input path="id" /><input type="button" value="중복검사"
						onClick="idCheck()" /></td>
				</tr>
				<tr>
					<td>암호:</td>
					<td><form:password path="password" name="PWD" /></td>
				</tr>
				<tr>
					<td>암호 확인:</td>
					<td><input type="password" name="CONFIRM" /></td>
				</tr>
				<tr>
					<td>성별</td>
					<td>남<form:radiobutton path="gender" value="M" /> 여 <form:radiobutton
							path="gender" value="F" /></td>

				</tr>
				<tr>
					<td>이메일 :</td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td>주소:</td>
					<td><form:input path="addr" /></td>
				</tr>
				<tr>
					<td>직업 :</td>
					<td><form:select path="job">
							<form:option value="--선택하세요--" />
							<form:option value="회사원" />
							<form:option value="학생" />
							<form:option value="기타" />
						</form:select>
				</tr>
			</table>

			<br />
			<input type="submit" value="회원가입" />
			<input type="reset" value="취 소" />
			<br />
		</form:form>
	</div>
</body>
</html>