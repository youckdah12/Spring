<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:choose>
	<c:when test="${ticketInfo.amount<5}">
	<font color="blue">티켓이 발행되었습니다.</font><br/>
	고객 아이디 : ${ticketInfo.consumerId}<br/> 
	티켓 구매수 : ${ticketInfo.amount}<br/>
	</c:when>
	<c:otherwise>
		<font color="red">카드 결제가 취소 되었습니다.</font>
	</c:otherwise>
	
</c:choose>
<br/>
<a href="buy_ticket">buy_ticket</a>
</body>
</html>