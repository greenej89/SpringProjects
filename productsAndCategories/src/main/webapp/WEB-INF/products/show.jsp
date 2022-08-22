<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Page</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
   	<div class="container">
   		<h1 class="mb-5 text-center"><c:out value="${product.name}"/></h1>
		<a href="/">Home</a>
		<hr>
		<h2>Categories:</h2>
		<c:forEach var="category" items="${product.categories}">
			<p>- ${category.name}</p>
		</c:forEach>
		<hr>
		<form:form action="/categorize/${product.id}" method="post">
			<div class="row g-3">
				<select name="categoryId" id="categoryId">
					<c:forEach var="category" items="${categoryOptions}">
						<option value="${category.id}">
							<c:out value="${category.name}" />
						</option>
					</c:forEach>
				</select>
			</div>
			<input type="submit" value="Add" class="btn btn-primary mt-3 w-100" />
		</form:form>
	</div>
</body>
</html>