<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
	</head> 
	<body>
		<form action="Validating" method="POST">
		<center><h1>WELCOME TO LOGIN</h1><br><br><br>
		Username:<input type="text" name="user"><br> <br>
		Password:<input type="password" name="pass"><br> <br>
		<input type="submit" value="login">
		</center>
	</form>
	</body>
</html>
