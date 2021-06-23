<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="resources/css/main.css">
</head>
<body>
	<h1 align="center">My news</h1>

	<form class="floated" action="controllerForward" method="post">
		<input type="hidden" name="button" value="registration" />
		<button class="button">Регистрация</button>
	</form>

	<form class="floated" action="controllerForward" method="post">
		<input type="hidden" name="button" value="authorization" />
		<button class="button">Авторизация</button>
	</form>

</body>
</html>