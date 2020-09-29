<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		function formCheck(frm) {
			if (frm.codeChecked.value == '') {
				alert("중복검사를 해주세요.");
				return false;
			}
			if (frm.CODE.value == '') {
				alert("상품번호를 입력하세요.");
				return false;
			}
			if (frm.NAME.value == '') {
				alert("상품 이름을 입력하세요.");
				return false;
			}
			if (frm.PRICE.value == '') {
				alert("가격을 입력하세요.");
				return false;
			}
			if (frm.ORIGIN.selectedIndex < 0) {
				alert("원산지를 선택하세요.");
				return false;

			}
			if (frm.INFO.value == '') {
				alert("상품 설명을 입력하세요.");
				return false;
			}
			if (confirm("입력한 내용이 맞습니까?")) {

			} else {
				return false;
			}
		}

		function codeCheck() {
			if (document.register.CODE.value == '') {
				alert("상품코드를 입력하세요.");
				return;
			}
			window.open("codeCheck?CODE=" + document.register.CODE.value,
					"_blank", "width=350, height=250")
		}
	</script>
	<h2 align="center">상품 등록</h2>

	<form action="registerItem" method="post"
		onSubmit="return formCheck(this)" name="register">
		<fieldset>
			<legend>상세 정보 입력</legend>
			<input type="hidden" name="codeChecked" /> 상품코드 : <input type="text"
				name="CODE" size="5" /> <input type="button" value="코드 중복 검사"
				onClick="codeCheck()" /><br /> 상품 이름 : <input type="text"
				name="NAME" size="20" /><br /> 상품 가격 : <input type="text"
				name="PRICE" size="10" /><br /> 원산지 : <select name="ORIGIN">
				<option>한국</option>
				<option>일본</option>
				<option>중국</option>
				<option>베트남</option>
				<option>태국</option>
				<option>기타</option>
			</select><br /> 상품설명(아래) : <br />
			<textarea rows="5" cols="80" name="INFO"></textarea>
		</fieldset>
		<div align="center">
			<input type="submit" value="등록" /> <input type="reset" value="취소" />
		</div>
	</form>
</body>
</html>