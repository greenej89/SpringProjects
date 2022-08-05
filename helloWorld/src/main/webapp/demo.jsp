<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Demo</title>
</head>
<body>
	<h1>Hello World</h1>
	<% for(int i=1; i <= 5; i++){ %>
		<h1><%=i %></h1>
	<% } %>
	<h3> The current time is: <%=new Date() %></h3>
	
	<h2>Two plus two is: </h2>
	<h3> <c:out value="${2+2}"/></h3>
</body>
</html>