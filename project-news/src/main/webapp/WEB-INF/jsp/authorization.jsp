<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="resources/css/main.css">
</head>
<body>
<form action="controllerLogging" method="post">
		<input type="hidden" name="button" value="authorization" />
		Enter login:<br />
		<input type="text" name="login" value="" /><br /> 
		Enter password:<br />
		<input type="password" name="password" value="" /><br /> 
		<button class="button">Авторизация</button>
	</form>
</body>
</html>