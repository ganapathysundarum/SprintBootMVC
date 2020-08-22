<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>	

	<div class="container">
		<table class="table table-striped">
			<caption>Your Books are</caption>
			<thead>
				<tr>
					<th>Book Name</th>
					<th>Author Name</th>
					<th>Publisher</th>
					<th>Published Date</th>
					<th>Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${books}" var="book">
					<tr>
						<td>${book.bookName}</td>
						<td>${book.bookAuthor}</td>
						<td>${book.publisherName}</td>
						<td><fmt:formatDate value="${book.publishedDate}" pattern="dd/MM/yyyy"/></td>
						<td>${book.bookPrice}</td>
						<td><a type="button" class="btn btn-success" href="/update-book?id=${book.id}">Update</a></td>
						<td><a type="button" class="btn btn-warning" href="/delete-book?id=${book.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a class="button" href="/add-book">Add a Book</a>
		</div>
		
<%@ include file="common/footer.jspf" %>
