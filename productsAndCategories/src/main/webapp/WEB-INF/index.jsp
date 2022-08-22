<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1 class="text-center"> Home Page </h1>
		<a href="/products/new">New Product</a>
		<a href="/categories/new" class="d-block">New Category</a>
		<table class="table table-bordered">
		  <thead>
		    <tr>
		      <th scope="col" class="text-center">Products</th>
		      <th scope="col" class="text-center">Categories</th>
		    </tr>
		   </thead>
		   <tbody>
		   		<tr>
		   			<td>
		   				<ul>
		   					<c:forEach var="product" items="${products}">
		   						<li> <a href="/products/${product.id}"><c:out value="${product.name}"/></a></li>
							</c:forEach>
		   				</ul>
		   			</td>
		   			<td>
		   				<ul>
		   					<c:forEach var="category" items="${categories}">
		   						<li> <a href="/categories/${category.id}"><c:out value="${category.name}"/></a></li>
							</c:forEach>
		   				</ul>
		   			</td>
		   		</tr>
		   </tbody>
		</table>
	</div>
</body>
</html>