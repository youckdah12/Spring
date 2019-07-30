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
		<td>이름</td>
		<td>제목</td>
		<td>날짜</td>
		<td>히트</td>
	</tr>
	<c:forEach items="${list}" var="BoardDTO">
	<tr>
		<td>${BoardDTO.id}</td>
		<td>${BoardDTO.name}</td>
		<td><a href="contentView?id=${BoardDTO.id}">${BoardDTO.title}</a></td>
		<td>${BoardDTO.regdate}</td>
		<td>${BoardDTO.hit}</td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="5"><a href="writeView">글작성</a></td>
	</tr>
</table>
</body>
</html>