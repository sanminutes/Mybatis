<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function idCheck() {
		//1.ID가 입력되었는지 확인한다.
		if (document.registerFrm.ID.value == '') {
			alert("ID를 입력하세요.");
			document.registerFrm.ID.focus();
			return;//함수 종료
		}
		//2. 팝업창을 띄워서 중복검사의 결과를 보여준다.
		window.open("idCheck.do?USER=" + document.registerFrm.ID.value,
				"_blank", "width=450, height=300")
		//window.open(내용, 식별자, 크기)

	}
	function formCheck(frm) {
		if (frm.IDCHK.value == '') {
			alert("ID중복검사를 해주세요.");
			return false;
		}
		if (frm.NAME.value == '') {
			alert("이름을 입력하세요.");
			return false;
		}
		if (frm.ID.value == '') {
			alert("아이디를 입력하세요.");
			return false;
		}
		if (frm.PWD.value == '') {
			alert("암호를 입력하세요.");
			return false;
		}
		if (frm.PWD.value != frm.CONFIRM.value) {
			alert("암호가 일치하지 않습니다.");
			return false;
		}
		if (frm.JOB.selectedIndex < 1) {
			alert("직업을 선택하세요.");
			return false;
		}
		if (!frm.GENDER[0].checked && !frm.GENDER[1].checked) {
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
		<form action="register" method="post" name="registerFrm"
			onSubmit="return formCheck(this)">
			<input type="hidden" name="IDCHK" />
			<table>
				<tr>
					<td>이　름 :</td>
					<td><input type="text" name="NAME" /></td>
				</tr>
				<tr>
					<td>아이디:</td>
					<td><input type="text" name="ID" /><input type="button"
						value="중복검사" onClick="idCheck()" /></td>
				</tr>
				<tr>
					<td>암호:</td>
					<td><input type="password" name="PWD" /></td>
				</tr>
				<tr>
					<td>암호 확인:</td>
					<td><input type="password" name="CONFIRM" /></td>
				</tr>
				<tr>
					<td>성별</td>
					<td>남<input type="radio" name="GENDER" value="M" /> 여 <input
						type="radio" name="GENDER" value="F" /></td>

				</tr>
				<tr>
					<td>이메일 :</td>
					<td><input type="text" name="EMAIL" /></td>
				</tr>
				<tr>
					<td>주소:</td>
					<td><input type="text" name="ADDR" /></td>
				</tr>
				<tr>
					<td>직업 :</td>
					<td><select name="JOB"><option>--선택하세요--</option>
							<option>회사원</option>
							<option>학생</option>
							<option>자영업</option>
							<option>주부</option>
							<option>기타</option></select></td>
				</tr>
			</table>

			<br /> <input type="submit" value="회원가입" /> <input
				type="reset" value="취 소" /> <br />
		</form>
	</div>
</body>
</html>