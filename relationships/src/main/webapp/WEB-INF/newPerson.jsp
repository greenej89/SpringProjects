<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Driver's Licenses</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container mt-5">
		<h1 class="text-primary">New Person</h1>
		<form:form action="/persons/new" method="post" modelAttribute="person">
 				<div class="w-50 mb-3">
					<ul class="list-unstyled">
						<li ><form:errors path="firstName" class="text-danger"/></li>
						<li ><form:errors path="lastName" class="text-danger"/></li>
					</ul>
				</div>
				<div class="w-50 mb-3 d-flex justify-content-between">
					<form:label path="firstName">First Name: </form:label>
					<form:input path="firstName" class="w-50"/>
				</div>
				<div class="w-50 mb-3 d-flex justify-content-between">
					<form:label path="lastName">Last Name: </form:label>
					<form:input path="lastName" class="w-50"/>
				</div>
				<div class="w-50 mb-3 d-flex">
					<input type="submit" value="Create" class="btn btn-primary" />
				</div>
			</form:form>
		</div>
   
</body>
</html>