<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="../../main.jsp"%>
<div align="center">
	<form action="login" method="post">
		<div class="form-group col-md-6">
			<label>ID</label>
			<input type="text" class="form-control" name="guestid" placeholder="userid">
		</div>
		<div class="form-group col-md-6">
			<label>Password</label>
			<input type="password" class="form-control" name="guestpwd" placeholder="Password">
		</div>
		<div class="form-group col-md-12">
			<button  type="submit">로그인</button>
		</div>
	</form>
</div>