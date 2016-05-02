<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="errors">
		<ul>
			<c:forEach items="${errors}" var="error">
				<li>${error.category }-${error.message }</li>
			</c:forEach>
		</ul>
	</div>
	<form action="<c:url value="/games"/>" method="post">
		<fieldset>
			<legend>Adicionar Produto</legend>

			<label for="title">Título:</label> <input id="title" type="text"
				name="game.title" value="${game.title }" /> <label for="price">Preço:</label>
			<input id="price" type="text" name="game.price"
				value="${game.price }" />

			<button type="submit">Enviar</button>
		</fieldset>
	</form>
</body>
</html>