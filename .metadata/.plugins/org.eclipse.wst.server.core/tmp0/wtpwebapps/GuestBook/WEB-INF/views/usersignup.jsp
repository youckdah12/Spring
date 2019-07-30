<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../../main.jsp"%>
<div align="center">
	<form action="signup" method="post">
		<div class="form-group col-md-6">
			<label>ID</label>
			<input type="text" class="form-control" name="guestid" placeholder="guestid">
		</div>
		<div class="form-group col-md-6">
			<label>Password</label>
			<input type="password" class="form-control" name="guestpwd" placeholder="Password">
		</div>
		<div class="form-group col-md-6">
			<label>guestName</label>
			<input type="text" class="form-control" name="guestname" placeholder="Password">
		</div>
		<div class="form-group col-md-6">
			<label>Email</label>
			<input type="email"	class="form-control" name="guestEmail" placeholder="Email">
		</div>
		<div class="form-group col-md-12">
			<button  type="submit">회원가입</button>
		</div>
	</form>
</div>