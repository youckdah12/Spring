<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<%if (session.getAttribute("guestid") == null){%>
	<div align="right">
		<a href="usersignup">회원가입</a>
		<a href="userLogin">로그인</a>		
	</div>
	<%}else{ %>
	<div align="right">
		<a href="userlogout">로그아웃</a>
	</div>
	<% } %>
	<!-- As a heading -->
	<nav class="navbar navbar-light bg-light">
	  <span class="navbar-brand mb-0 h1">방명록</span>
	</nav>
</body>
</html>