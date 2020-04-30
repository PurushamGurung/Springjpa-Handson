<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="container">
<h1>Result</h1>
<table class="table">
	<thead>
		<tr><th>Code</th>
			<th>Country Name</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${countries}" var="country">
		<tr><td>${country.code}</td>
			<td>${country.name}</td></tr>
		</c:forEach>
	</tbody>
</table></div>
</body>
</html>