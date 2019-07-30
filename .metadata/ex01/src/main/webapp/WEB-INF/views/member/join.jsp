<!-- join.jsp -->
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 
아이디 : ${memberDto.id}<br/>
비밀번호 : ${memberDto.pwd}<br/>
이름 : ${memberDto.name}<br/>
이메일 : ${memberDto.email}<br/> --%>
아이디 : ${member.id}<br/>
비밀번호 : ${member.pwd}<br/>
이름 : ${member.name}<br/>
이메일 : ${member.email}<br/>
</body>
</html>