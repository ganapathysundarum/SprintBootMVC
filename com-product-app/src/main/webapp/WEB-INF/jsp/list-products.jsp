<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>	

	<div class="container">
		<table class="table table-striped">
			<caption>Products List</caption>
			<thead>
				<tr>
					<th>Product Name</th>
					<th>Product Type</th>
					<th>Product Brand</th>
					<th>Retail Price</th>
					<th>Weight</th>
					<th>Unit/Size</th>
					<th>Manufactured Date</th>
					<th>Expiry Date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${products}" var="product">
					<tr>
						<td>${product.name}</td>
						<td>${product.type}</td>
						<td>${product.brand}</td>
						<td>${product.retailPrice}</td>
						<td>${product.weight}</td>
						<td>${product.size}</td>
						<td><fmt:formatDate value="${product.manufactured}" pattern="dd/MM/yyyy"/></td>
						<td><fmt:formatDate value="${product.expiry}" pattern="dd/MM/yyyy"/></td>						
						<td><a type="button" class="btn btn-success" href="/update-product?id=${product.id}">Update</a></td>
						<td><a type="button" class="btn btn-warning" href="/delete-product?id=${product.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<!-- <div>
			<a class="button" href="/add-product">Add a Product</a>
		</div>
		 -->
<%@ include file="common/footer.jspf" %>

