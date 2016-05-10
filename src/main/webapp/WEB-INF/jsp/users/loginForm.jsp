<%@ include file="/WEB-INF/jspf/header.jspf"%>
<form action="<c:url value="/login"/>" method="POST">
		<fieldset>
			<legend>Efetue o login</legend>

			<label for="login">Login:</label> <input id="login" type="text"
				name="user.login" /> <label for="password">Senha:</label> <input
				id="password" type="password" name="user.password" />

			<button type="submit">Login</button>
		</fieldset>
	</form>
<%@ include file="/WEB-INF/jspf/footer.jspf"%>