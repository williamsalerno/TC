<%@ include file="/WEB-INF/jspf/header.jspf"%>
<div class="containerLogin">
	<div class="content">
		<div class="login">
			<h2>Login Cliente</h2>
			<hr>
			<div class="form">
				<form action="<c:url value="/login"/>" method="POST">
					<input id="login" type="text" name="user.login"
						placeholder="Nome de usuário" /><input id="password"
						type="password" name="user.password" placeholder="senha" />
					<button type="submit">Entrar</button>
				</form>
			</div>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/jspf/footer.jspf"%>