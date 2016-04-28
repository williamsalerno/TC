
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/register" method="post">
		<h2>Registre uma nova conta ttf</h2>
		<input type="hidden" name="user.id" value="${user.id}" />
		<ul>
			<li>Nome: <br /> <input type="text" name="user.name"
				value="${user.name}" /></li>
			<li>Sobrenome: <br /> <input type="text" name="user.lastName"
				value="${user.lastName}" /></li>
			<li>Apelido: <br /> <input type="text" name="user.nick"
				value="${user.nick}" /></li>
			<li>Email: <br /> <input type="text" name="user.email"
				value="${user.email}" /></li>
		</ul>
		<input type="submit" value="Salvar" />
	</form>
</body>
</html>