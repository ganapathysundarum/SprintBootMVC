<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
	<form:form method="post" modelAttribute="book">
		<form:hidden path="id"/>
		<form:hidden path="borrower"/>
		<fieldset class="form-group">
			<form:label path="bookName">Book Name</form:label>
			<form:input path="bookName" type="text" class="form-control" required="required"/>
			<form:errors path="bookName" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="bookAuthor">Book Author</form:label>
			<form:input path="bookAuthor" type="text" class="form-control" required="required"/>
		</fieldset>
		<fieldset class="form-group">
			<form:label path="publisherName">Publisher Name</form:label>
			<form:input path="publisherName" type="text" class="form-control" required="required"/>
		</fieldset>
		<fieldset class="form-group">
				<form:label path="publishedDate">Published Date</form:label>
				<form:input path="publishedDate" type="text" class="form-control"
					required="required" />
				<form:errors path="publishedDate" cssClass="text-warning" />
			</fieldset>
		<fieldset class="form-group">
			<form:label path="bookPrice">Book Price</form:label>
			<form:input path="bookPrice" type="text" class="form-control" required="required"/>
			<form:errors path="bookPrice" cssClass="text-warning" />
		</fieldset>
		<br>
		<button type="submit" class="btn btn-success">Add Book</button>		
	</form:form>
	</div>
	
<%@ include file="common/footer.jspf" %>