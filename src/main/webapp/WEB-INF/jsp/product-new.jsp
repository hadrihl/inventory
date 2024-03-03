<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="US-ASCII">
<title>Inventory System | Product</title>
</head>
<body>
	<div class="container">
		<h1>${product.name}</h1>
		
		<form action="/products/new" method="post" modelattribute="product">
			<div class="form-group">
				<label for="name">Name</label>
				<input type="text" id="name" name="name" value="${product.name}" />
			</div>
			
			<div class="form-group" style="margin-top: 5px;">a
				<label for="description">Description</label>
				<input type="text" id="description" name="description" value="${product.description}" />
			</div>
			
			<div class="form-group" style="margin-top: 5px;">
				<label for="category">Category</label>
				<input type="text" id="category" name="category" value="${product.category}" />
			</div>
			
			<div class="form-group" style="margin-top: 5px;">
				<label for="ppu">Price Per Unit (MYR)</label>
				<input type="number" id="ppu" name="ppu" value="${product.ppu}" />
			</div>
			
			<div class="form-group" style="margin-top: 5px;">
				<label for="quantity">Quantity</label>
				<input type="number" id="quantity" name="quantity" value="${product.quantity}" />
			</div>
			
			<c:if test="${not empty msg}">
			<div class="form-group">
				<p style="color: green;">${msg}</p>
			</div>
			</c:if>
			
			<div class="form-group" style="margin-top: 20px;">
				<button><a href="http://localhost:8080/products">Cancel</a></button>
				<button type="submit">Create</button>
			</div>
		</form>
	</div>
</body>
</html>