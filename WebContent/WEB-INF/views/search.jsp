<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<h1>Search</h1>
	<form action="${pageContext.request.contextPath}/search" method="post">
		<input type="text" name="textSearch"> 
		<input type="submit" value="search">
	</form>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Author</th>
			<th>Publisher</th>
			<th>Type</th>
			<th>Language</th>
			<th>Description</th>
			<th>Quantity</th>
		</tr>

		<c:forEach items="${bookSearch}" var="book">
			<tr>
				<td>${book.id}</td>
				<td>${book.name }</td>
				<td>${book.author }</td>
				<td>${book.publisher }</td>
				<td>${book.type }</td>
				<td>${book.language }</td>
				<td>${book.description }</td>
				<td>${book.quantity }</td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>