<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width="500" border="1">
	<tr>
		<td>번호</td>
		<td>작성자</td>
		<td>내용</td>
		<td>삭제</td>
	</tr>
	<c:forEach items="${NoteList}" var="NoteDTO">
	<tr>
		<td>${NoteDTO.id}</td>
		<td>${NoteDTO.writer}</td>
		<td>${NoteDTO.content}</td>
		<td><a href="delete?id=${NoteDTO.id}">X</a></td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="5"><a href="NoteForm">글작성</a></td>
	</tr>
</table>
</body>
</html>