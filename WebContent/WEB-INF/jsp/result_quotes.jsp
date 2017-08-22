<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Quotes</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<table>
		<tr>
			<th>ID</th>
			<th>Author</th>
			<th>Content</th>
		</tr>
		<c:forEach items="${quotes}" var="quote" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>${quote.author}</td>
				<td>${quote.content}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>