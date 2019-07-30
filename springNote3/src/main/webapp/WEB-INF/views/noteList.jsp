<!-- list.jsp -->
<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<c:forEach var="dto" items="${list}" >
	<tr>
		<td>${dto.id}</td>
		<td>${dto.writer}</td>
		<td>${dto.content}</td>
		<td><a href="delete?id=${dto.id}">X</a></td>
	</tr>	
	</c:forEach>
	<tr>
		<td colspan="4"><a href="form">글작성</a></td>
	</tr>
</table>
</body>
</html>





