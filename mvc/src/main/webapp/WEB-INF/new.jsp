<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- form tag library -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Template</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>New Book</h1>
		<form:form action="/books" method="post" modelAttribute="book">
			<div class="form-group">
				<form:label path="title"> Title </form:label>
				<form:errors path="title" class="text-danger"/>
				<form:input path="title" class="form-control" />

			</div>
			<div class="form-group">
				<form:label path="description"> Description  </form:label>
				<form:errors path="description" class="text-danger"/>
				<form:input path="description" class="form-control" />

			</div>
			<div class="form-group">
				<form:label path="language"> Language </form:label>
				<form:errors path="language" class="text-danger"/>
				<form:input path="language" class="form-control" />
			</div>
			<div class="form-group">
				<form:label path="numberOfPages"> Pages </form:label>
				<form:errors path="numberOfPages" class="text-danger"/>
				<form:input path="numberOfPages" class="form-control" />
			</div>
			<input type="submit" value="Submit" class="btn btn-primary mt-3" />
		</form:form>
	</div>

</body>
</html>