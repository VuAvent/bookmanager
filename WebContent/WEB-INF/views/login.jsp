<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <jsp:include page="header.jsp"></jsp:include>
   <div class="container">
   
	<h1>LOG IN</h1>
	
	<form action="${pageContext.request.contextPath}/login" method="post" >
	<div style="color:red">${errorMessage}</div>
	<label>Username</label><br>	
	<input type="text" name="username"><br>
	<label>Password</label><br>
	<input type="password" name="password"><br>
	<input type="submit" value="login" >
	</form>
	 
	</div>

		<a href="${pageContext.request.contextPath}/register">Register</a>
	
</body>
</html>