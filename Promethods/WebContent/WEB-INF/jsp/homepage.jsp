<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h2>Spring MVC and List Example</h2>

	<c:if test="${not empty productList}">

		<table>
			<tr>
				<th>ID</th>
				<th>Product</th>
				<th>Company</th>
				<th>Category</th>
				<th>Buy Price</th>
				<th>Selling Price</th>
				<th>Quantity</th>
			</tr>

			<c:forEach var="product" items="${productList}">
				<tr>
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${product.company}</td>
					<td>${product.type}</td>
					<td>${product.buyPrice}</td>
					<td>${product.sellingPrice}</td>
					<td>${product.quantity}</td>
				</tr>
			</c:forEach>

		</table>


	</c:if>
</body>
</html>