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
	<div>
		<h1>Criar novo usuário</h1>
		<label>Todos os campos são obrigatórios</label>
		<form id="usersForm" action="<c:url value="/users"/>" method="post">
			<fieldset>
				<legend>Dados pessoais</legend>
				<table>
					<tr>
						<td><label for="name">Nome:</label> <input id="name"
							class="required" type="text" name="user.name"
							value="${user.name }" /></td>
						<td><label for="lastName">Sobrenome:</label> <input
							id="lastName" class="required" type="text" name="user.lastName"
							value="${user.lastName }" /></td>
					</tr>
					<tr>
						<td><label for="cpf">CPF:</label> <input id="cpf"
							class="required" type="text" name="user.cpf" value="${user.cpf }" /></td>
					</tr>
					<tr>
						<td><label for="email">Email:</label> <input id="email"
							class="required" type="text" name="user.email"
							value="${user.email }" /></td>
					</tr>
					<tr>
						<td><label for="ddd">DDD:</label> <input id="ddd"
							class="required" type="text" name="user.phone.ddd"
							value="${user.phone.ddd }" /></td>
						<td><label for="phoneType">Tipo:</label><input id="phoneType"
							class="required" type="text" name="user.phone.phoneType"
							value="${user.phone.phoneType }" /></td>
						<td><label for="number">Número:</label><input id="number"
							class="required" type="text" name="user.phone.number"
							value="${user.phone.number }" /></td>
					</tr>
				</table>
			</fieldset>
			<fieldset>
				<legend>Endereço</legend>
				<table>
					<tr>
						<td><label for="cep">CEP:</label> <input id="cep"
							class="required" type="text" name="user.address.cep"
							value="${user.address.cep }" /></td>
					</tr>
					<tr>
						<td><label for="city">Cidade:</label> <input id="city"
							class="required" type="text" name="user.address.city"
							value="${user.address.city }" /></td>
					</tr>
					<tr>
						<td><label for="state">Estado:</label> <input id="state"
							class="required" type="text" name="user.address.state"
							value="${user.address.state }" /></td>
					</tr>
				</table>
			</fieldset>
			<fieldset>
				<legend>Dados de login</legend>
				<table>
					<tr>
						<td><label for="login"> Login:</label> <input id="login"
							class="required" type="text" name="user.login"
							value="${user.login }" /></td>
					</tr>
					<tr>
						<td><label for="password">Senha:</label> <input id="password"
							class="required" type="password" name="user.password"
							value="${user.password }" /></td>
					</tr>
					<tr>
						<td><label for="confirm">Confirme a senha:</label> <input
							id="confirm" equalTo="#password" type="password" /></td>
					</tr>
					<tr>
						<td><button type="submit">Enviar</button></td>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>
	<script type="text/javascript">
		$('#usersForm').validate();
	</script>
</body>
</html>