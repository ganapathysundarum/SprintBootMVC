<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<font color="red">${errorMessage}</font>
	<form method="post" action="/login-product">
		<table>
		<tr><td>Name      </td><td><input type="text" name="username" class="form-control" /></td></tr>		
		<tr><td>Password  </td><td><input type="password" name="password" class="form-control" /></td></tr>		
		<tr><td colspan=2 align=center><input type="submit" value="Login" class="btn btn-success"/></td></tr>
		</table>
	</form>	
</div>
<%@ include file="common/footer.jspf"%>