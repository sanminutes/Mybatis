
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>콕션 고객센터 - 공지사항</title>
<style type="text/css">
table.bbs_main {
	border: 1px solid gray;
	width: 90%;
	border-collapse: collapse;
}

.bbs_th {
	border: 1px solid gray;
	background-color: #D5D5D5;
	height: 30px;
}

.bbs_td {
	border: 1px solid gray;
	font-size: 14px;
	height: 25px;
}

.bbs_table {
	font-size: 14px;
}
</style>
</head>
<body>
	<div class="bbs_table" align="center">
		<h2>공지사항</h2>
		<c:if test="${BBS_LIST == null }">
			<h3>등록된 공지사항이 존재하지 않습니다.</h3>
		</c:if>
		<c:if test="${BBS_LIST != null }">
			<table class="bbs_main" >
				<tr>
					<th class="bbs_th" width="10%" >NO</th>
					<th class="bbs_th" width="20%">공지분류</th>
					<th class="bbs_th" width="20%">공지일자</th>
					<th class="bbs_th" width="50%">공지내용</th>

				</tr>
				<c:forEach var="bbs" items="${BBS_LIST }">
					<tr>
						<td class="bbs_td" width="10%" align="center">${bbs.seqno }</td>
						<td class="bbs_td" width="20%" align="center">${bbs.id }</td>
						<td class="bbs_td" width="20%" align="center">${bbs.bbs_date }</td>
						<td class="bbs_td" width="50%"><a
							href="../read/readDetail.html?SEQNO=${bbs.seqno }"><font
								color="black">${bbs.title }</font></a></td>

					</tr>
				</c:forEach>
			</table>
			<br />
			<c:forEach begin="1" end="${pageCount }" var="page">
				<a href="../read/read.html?pageNo=${page }"><font color="black"
					size="3px">${page }</font></a>
			</c:forEach>
		</c:if>
	</div>
</body>
</html>