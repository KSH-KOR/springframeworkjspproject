<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Form</title>
</head>
<body>



<h1>Edit Form</h1>

<form:form modelAttribute="editModelInfo" method="post" action="../editpostok">
	<form:hidden path="id"/>
		<table id="edit">
			<tr><td>Title:</td><td><form:input path="title"/></td></tr>
			<tr><td>Writer:</td><td><form:input path="writer"/></td></tr>
			<tr><td>Rate:</td><td><form:input path="rate"/></td></tr>
			<tr><td>Content:</td><td><form:input path="content"/></td></tr>
			<tr><td colspan="2"><input type="submit" value="Edit Post"/>
				<input type="button" value="Cancel" onclick="history.back()"/></td></tr>
		</table>
</form:form>


</body>
</html>