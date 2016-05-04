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
	<fieldset>
		<legend>Editar Produto</legend>
		<form action="<c:url value="/games/${game.id }"/>" method="post">
			<img src="<c:url value="/games/${game.id}/image"/>" width="100"
				height="100" /> <label for="title">T�tulo:</label> <input
				id="title" type="text" name="game.title" value="${game.title }" />
			<label for="price">Pre�o:</label> <input id="price" type="text"
				name="game.price" value="${game.price }" />
			<button type="submit" name="_method" value="put">Alterar</button>
			<button type="submit" name="_method" value="delete">Apagar</button>
		</form>
		<form action="<c:url value="/games/${game.id }/image"/>" method="post"
			enctype="multipart/form-data">
			<fieldset>
				<legend>Upload de imagem</legend>
				<input type="file" name="image" />
				<button type="submit">Enviar</button>
			</fieldset>
		</form>
	</fieldset>
</body>
</html>