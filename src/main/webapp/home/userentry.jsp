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
		window.open("../idcheck/idcheck.html?USER="
				+ document.registerFrm.id.value, "_blank",
				"width=450, height=160")
		//window.open(내용, 식별자, 크기)

	}
	function formCheck(frm) {
		if (frm.id.value == '') {
			alert("아이디를 입력하세요.");
			return false;
		}
		if (frm.IDCHK.value == '') {
			alert("ID중복검사를 해주세요.");
			return false;
		}
		if (frm.password.value == '') {
			alert("비밀번호를 입력하세요.");
			return false;
		}
		if (frm.password.value != frm.CONFIRM.value) {
			alert("비밀번호가 일치하지 않습니다.");
			return false;
		}
		if (frm.name.value == '') {
			alert("이름을 입력하세요.");
			return false;
		}
		if (frm.gender.selectedIndex < 1) {
			alert("성별을 선택하세요.");
			return false;
		}
		if (frm.email.value == '') {
			alert("이메일을 입력하세요.");
			return false;
		}
		if (frm.addr.value == '') {
			alert("주소를 입력하세요.");
			return false;
		}
		if (frm.job.selectedIndex < 1) {
			alert("직업을 선택하세요.");
			return false;
		}

		if (confirm("입력한 내용이 맞습니까?")) {

		} else {
			return false;
		}
	}
</script>
<style>
input[type=text] {
	padding: 10px;
	margin: 0px;
	font-size: 20px;
}

input[type=password] {
	padding: 10px;
	margin: 0px;
	font-size: 20px;
}

select {
	padding: 10px;
	margin: 0px;
	font-size: 20px;
	width: 380px;
}

.login td {
	background-color: #FFC6C6;
	border: 4px solid #FFC6C6;
}

#join {
	width: 190px;
	background-color: #FF5A5A;
	color: white;
	font-size: 20px;
	border: 1px solid;
}

#cancel {
	width: 190px;
	background-color: #FF5A5A;
	color: white;
	font-size: 20px;
	border: 1px solid;
}

#checkk {
	width: 60px;
	background-color: #FF5A5A;
	color: white;
	font-size: 14px;
	border: 1px solid #FF5A5A;
	background-color: #FF5A5A;
}
</style>
</head>
<body>
	<br />
	<div align="center">
		<form:form action="../entry/entry.html" method="post"
			modelAttribute="guest" name="registerFrm"
			onSubmit="return formCheck(this)">
			<input type="hidden" name="IDCHK" />
			<table class="login" border="1" style="border: 0px solid;">
			<form:hidden path="lv" value="1"/>

				<tr>
					<td><font size="4px">아이디</font><input type="button"
						value="CHECK" onClick="idCheck()" id="checkk" /><br /> <form:input
							path="id" size="30" /></td>
				</tr>
				<tr>
					<td><font size="4px">비밀번호</font><br /> <form:password
							path="password" name="PWD" size="30" /></td>
				</tr>
				<tr>
					<td><font size="4px">비밀번호 재확인</font><br /> <input
						type="password" name="CONFIRM" size="30" /></td>
				</tr>
				<tr>
					<td><font size="4px">이름 </font><br /> <form:input path="name"
							size="30"></form:input></td>
				</tr>
				<tr>
					<td><font size="4px">성별</font><br /> <form:select
							path="gender">
							<form:option value="--선택하세요--" />
							<form:option value="남자" />
							<form:option value="여자" />
						</form:select></td>

				</tr>
				<tr>
					<td><font size="4px">이메일</font><br /> <form:input
							path="email" size="30" /></td>
				</tr>
				<tr>
					<td><font size="4px">주소</font><br /> <form:input path="addr"
							size="30" /></td>
				</tr>
				<tr>
					<td><font size="4px">직업</font><br /> <form:select path="job">
							<form:option value="--선택하세요--" />
							<form:option value="회사원" />
							<form:option value="학생" />
							<form:option value="기타" />
						</form:select>
				</tr>
			</table>
			<br />
			<input id="join" type="submit" value="회원가입" />
			<input id="cancel" type="reset" value="취 소" />
			<br />
			<br />
		</form:form>
	</div>
</body>
</html>