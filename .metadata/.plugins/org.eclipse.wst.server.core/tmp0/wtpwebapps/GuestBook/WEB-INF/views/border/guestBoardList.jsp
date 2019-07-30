<%@ page contentType="text/html; charset=UTF-8"%>
<!-- 글쓰기 -->
<%@include file="guestBoard.jsp"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.4.1.min.js"></script>
<script>
	function add(num) {
		console.log("호출됨");
		var txt = "add"+num;
		var e = document.getElementById(txt);
		console.log(txt);
		if(e.style.display == 'none'){
			e.style.display = 'block';
		}
		else{
			e.style.display = 'none';
		}
	}
</script>
<div style="margin-top: 30px;" align="center">
	<table>
		<c:forEach var="dto" items="${list}">
			<tr>
				<td style="width: 250px;">번호 : ${dto.num}</td>
				<td style="width: 250px;" colspan="2">내용</td>
				<td>작성자 : ${dto.guestid}</td>
			</tr>
			<tr>
				<td colspan="4"><a href="commentList?bnum=${dto.num}">${dto.guestcontents}</a></td>
			</tr>
			<tr>
				<td>작성 IP: ${dto.ip}</td>
				<td>${dto.regtime}</td>
				<td colspan="2">수정/삭제</td>
			</tr>
			<tr>
				<td colspan="4"><button onclick="javascript:add(${dto.num})">댓글</button></td>
			</tr>
			<tr>
				<td colspan="4">
					<div id ="add${dto.num}" style="display: none">
						<input type="text" size="70">
					</div>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
<!-- 해당글에 대한 댓글 불러오기 -->
		<c:forEach var="commentlist" items="${commentlist}">
			${commentlist.cnum}<br>
			${commentlist.bnum}<br>
			${commentlist.guestid}<br>
			${commentlist.bcomment}<br>
			${commentlist.cip}<br>
			${commentlist.cregDate}<br>
		</c:forEach>