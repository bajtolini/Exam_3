<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Zad5 History</title>
</head>
<body>
	Odwiedzałeś:
	<br>
	<c:forEach items="${pages}" var="page">
		<c:out value="${page}" default="No page"/>
		<br>
	</c:forEach>
	<a href="history?clear=true">CLEAR HISTORY</a>
	<br>
	<a href="pages">BACK TO PAGE1</a>
</body>
</html>