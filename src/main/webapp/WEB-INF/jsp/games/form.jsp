<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript"
	src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.12.3.min.js"></script>
<script type="text/javascript"
	src="http://cdn.jsdelivr.net/jquery.validation/1.15.0/jquery.validate.min.js"></script>
</head>
<body>
	<div id="errors">
		<ul>
			<c:forEach items="${errors}" var="error">
				<li>${error.category }-${error.message }</li>
			</c:forEach>
		</ul>
	</div>
	<div>
		<form id="gamesForm" action="<c:url value="/games"/>" method="post">
			<fieldset>
				<legend>Adicionar Novo Jogo</legend>

				<label for="title">Título:</label> <input id="title"
					class="required" minlength="5" type="text" name="game.title"
					value="${game.title }" /> <label for="price">Preço:</label> <input
					id="price" min="1" type="text" name="game.price"
					value="${game.price }" />

				<button type="submit">Enviar</button>
			</fieldset>
		</form>
	</div>
	<script type="text/javascript">
		$('#gamesForm').validate();
	</script>
</body>
</html>