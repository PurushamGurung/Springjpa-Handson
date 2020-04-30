<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container pt-3">
	<form:form action="/submitPatternMatching" method="post" modelAttribute="country">
	<h1>Type 1</h1>
		<form:label path="code">Enter a Pattern</form:label>
		<form:input path="code" type="text" />
		<input type="submit" name="submit" value="Submit" ><input type="reset" name="reset" value="Clear">
		</form:form>
	
	
	<form:form action="/submitPatternMatchingWithSort" method="post" modelAttribute="country">
	<h1>Type 2</h1>
		<form:label path="code">Enter a Pattern</form:label>
		<form:input path="code" type="text" />
		<input type="submit" name="submit" value="Submit" ><input type="reset" name="reset" value="Clear">
		</form:form>	
		
		</div>
	
</body>
</html>