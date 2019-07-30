<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="../../../main.jsp"%>
<div align="center">
	<table cellspacing="0" cellpadding="3">
		<tr>
			<td bgcolor="#F5F5F5"><font size="4"><b>글올리기</b></font></td>
		</tr>
	</table>
	<form name="postFrm" method="post" action="boardinsert">
		<table border="1" bordercolor="#000000" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<table>
						<tr>
							<td height="40" align="center">
							<img src="resources/img/face.bmp" border="0" alt="성명">
								<input title="이름을 적어주세요" name="guestid" size="9" maxlength="20" value="${sessionScope.guestname}" readonly>
							<img src="resources/img/email.bmp" border="0" alt="메일">
								<input title="전자메일 주소를 적는 곳이군요" name="guestEmail" size="20" maxlength="80" value="${sessionScope.guestEmail}" readonly>
						</tr>
						<tr>
							<td align="center">
								<textarea title="좋은 글 남겨주세요" name="guestcontents" cols="60" rows="6" placeholder="해위"></textarea>
							</td>
						</tr>
						<tr>
							<td width="500" height="30" colspan="3" align="center">
								<!-- table start -->
								<input type="submit" value="글올리기"> 
								<input type="reset" value="고치기">
								<input type="checkbox" name="guestsecret" value="1">비밀글 
								<!--table end  -->
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>
</div>