<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<form action="form">
	<table>
		<thead>
			<tr>
				<th>Nome</th>
				<th>Preço</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${gameList}" var="game">
				<tr>
					<td>${game.title }</td>
					<td>${game.price }</td>
					<td><a href="edit?id=${game.id }">Editar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>
		<button type="submit">Novo Jogo</button>
	</p>
</form>
</html>