<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	<form id="usersForm" action="<c:url value="/users"/>" method="post">
		<fieldset>
			<legend>Criar novo usuário</legend>

			<label for="name">Nome:</label> <input id="name" class="required"
				type="text" name="user.name" value="${user.name }" /> <label
				for="login">Login:</label> <input id="login" class="required"
				type="text" name="user.login" value="${user.login }" /> <label
				for="password">Senha:</label> <input id="password" class="required"
				type="password" name="user.password" /> <label for="confirm">Confirme
				a senha:</label> <input id="confirm" equalTo="#password" type="password" />
			<button type="submit">Enviar</button>
		</fieldset>
	</form>
	<script type="text/javascript">
		$('#usersForm').validate();
	</script>
</body>
</html>