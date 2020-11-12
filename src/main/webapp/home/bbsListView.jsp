
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
	background-color: black;
	color: white;
	height: 30px;
}

.bbs_td {
	border: 1px solid gray;
	font-size: 20px;
	height: 25px;
}

.bbs_table {
	font-size: 20px;
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
			<c:if test="${loginLevel==2||loginLevel==3 }">
				<a href="../home/bbsForm.html"><font color="black">공지사항
						쓰기</font></a>
			</c:if>



			<table class="bbs_main">
				<tr>
					<th class="bbs_th" width="10%">NO</th>
					<th class="bbs_th" width="20%">공지분류</th>
					<th class="bbs_th" width="20%">공지일자</th>
					<th class="bbs_th" width="50%">공지내용</th>

				</tr>
				<c:forEach var="bbs" items="${BBS_LIST }" varStatus="status">
					<tr>
						<td class="bbs_td" width="10%" align="center">${bbs.seqno }</td>
						<td class="bbs_td" width="20%" align="center">${bbs.id }</td>
						<td class="bbs_td" width="20%" align="center">${bbs.bbs_date }</td>
						<td class="bbs_td" width="20%" align="center"><span id="test"
							style="cursor: pointer;"
							onclick="javascript:popup(${bbs.seqno});">${bbs.title }<br /></span>
							<!--if(test${bbs.seqno }.style.display=='none') { test${bbs.seqno }.style.display='';} 
				else {test${bbs.seqno }.style.display='none';}  --></td>
					</tr>

					<tr id="test${bbs.seqno }" style="display: none;">

						<td colspan="4"
							style="background-color: #F6F6F6; font-size: 16px;">${COUNT}<pre>${CONTENT[status.index].content}</pre>

						</td>

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

	<script type="text/javascript">
		function popup(seqno){
				if(document.getElementById("test"+seqno).style.display=='none'){
					if(document.getElementsByClassName("on")[0]){
						popDown();
					}
					document.getElementById("test"+seqno).setAttribute('class','on');
					document.getElementById("test"+seqno).style.display='';
					
				}else{
					document.getElementById("test"+seqno).style.display='none';
		
				}
			
		}
		
		function popDown(){
			document.getElementsByClassName("on")[0].style.display ="none"; 
			document.getElementsByClassName("on")[0].setAttribute('class','');

		}
		</script>
</body>
</html>