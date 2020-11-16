<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� ��� ȭ��</title>
<link rel="stylesheet" type="text/css" href="css/3-2.css">
</head>
<body>
<div align="center" class="body">
	<h2>���� ��� ȭ��</h2>
	<table border="1">
		<tr class="header">
			<th align="center" width="80">��ǰ��ȣ</th>
			<th align="center" width="320">��ǰ�̸�</th>
			<th align="center" width="100">�� ��</th>	</tr>
		<c:forEach var="item" items="${itemList }">
		<tr class="record">
			<td align="center">${item.item_id }</td>
			<td align="center">
			<a href="detail.html?itemId=${item.item_id }">${item.itemName }</a></td>
			<td align="center">${item.price }</td>
		</tr>
		</c:forEach>
	</table>
</div>
</body>





</html>