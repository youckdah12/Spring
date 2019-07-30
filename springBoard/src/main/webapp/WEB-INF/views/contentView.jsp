<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="modify" method="post">
	<table width="500"  border="1">
			<tr>
				<td> 번호 </td>
				<td><input name="bId" readonly value="${contentView.bId}"></td>
			</tr>
			<tr>
				<td> 히트 </td>
				<td><input name="bHit" readonly value="${contentView.bHit}"></td>
			</tr>
			<tr>
				<td> 이름 </td>
				<td> <input  name="bName" value="${contentView.bName}"></td>
			</tr>
			<tr>
				<td> 제목 </td>
				<td><input name="bTitle" value="${contentView.bTitle}"></td>
			</tr>
			<tr>
				<td> 내용 </td>
				<td><textarea rows="10" name="bContent">${contentView.bContent}</textarea></td>
			</tr>
			<tr >
				<td colspan="2"> <input type="submit" value="수정"> &nbsp;&nbsp; <a href="list">목록보기</a> &nbsp;&nbsp; <a href="delete?bId=${contentView.bId}">삭제</a> &nbsp;&nbsp; </td>
			</tr>
	</table>
	</form>
</body>
</html>