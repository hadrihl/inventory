<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="US-ASCII">
<title>Inventory System | KA</title>
</head>
<body>
	<div class="container">
		<h1>Products</h1>
		
		<c:if test="${not empty products}">
		<table>
			<thead>
				<tr>
					<th>#</th>
					<th>Product Name</th>
					<th>Description</th>
					<th>Category</th>
					<th>Price Per Unit (MYR)</th>
					<th>Quantity</th>
					<th>#Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="product" items="${products}" varStatus="row">
				<tr>
					<td>${row.index+1}</td>
					<td><a href="/products/${product.id}">${product.name}</a></td>
					<td>${product.description}</td>
					<td>${product.category}</td>
					<td>${product.ppu}</td>
					<td>${product.quantity}</td>
					<th><a href="/products/${product.id}/delete">Delete</a></th>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		</c:if>
		
		<c:if test="${empty products}">
		<p>No product(s) found.</p>
		</c:if>
	</div>
	
	<div class="container">
		<p><a href="/products/new">Add new product</a></p>
	</div>
</body>
</html>