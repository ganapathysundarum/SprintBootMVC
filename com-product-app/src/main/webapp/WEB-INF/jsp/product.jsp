<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
	<form:form method="post" modelAttribute="product">
		<form:hidden path="id"/>		
		<fieldset class="form-group">
			<form:label path="name">Product Name</form:label>
			<form:input path="name" type="text" class="form-control" required="required"/>
			<form:errors path="name" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="type">Product Type</form:label>
			<form:input path="type" type="text" class="form-control" required="required"/>
		</fieldset>
		<fieldset class="form-group">
			<form:label path="brand">Product Brand</form:label>
			<form:input path="brand" type="text" class="form-control" required="required"/>
		</fieldset>
		<fieldset class="form-group">
			<form:label path="retailPrice">Retail Price</form:label>
			<form:input path="retailPrice" type="text" class="form-control" required="required"/>
			<form:errors path="retailPrice" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="weight">Weight</form:label>
			<form:input path="weight" type="text" class="form-control" required="required"/>
		</fieldset>
		<fieldset class="form-group">
			<form:label path="size">Size</form:label>
			<form:input path="size" type="text" class="form-control" required="required"/>
		</fieldset>
		<fieldset class="form-group">
				<form:label path="manufactured">Manufactured Date</form:label>
				<form:input path="manufactured" type="text" class="form-control"
					required="required" />				
		</fieldset>
		<fieldset class="form-group">
				<form:label path="expiry">Expiry Date</form:label>
				<form:input path="expiry" type="text" class="form-control"
					required="required" />				
		</fieldset>
		<br>
		<button type="submit" class="btn btn-success">Add Product</button>		
	</form:form>
	</div>
	
<%@ include file="common/footer.jspf" %>