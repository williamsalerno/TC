<%@ include file="/WEB-INF/jspf/header.jspf"%>
<div class="containerLogin">
	<div class="content">
		<div class="login">
			<h2>Login</h2>
			<hr class="hr1" id="grad">
			<div class="form">
				<form action="<c:url value="/login"/>" method="POST">
					<input id="login" type="text" name="user.login"
						placeholder="Nome de usuário" /><input id="password"
						type="password" name="user.password" placeholder="senha" />
					<button type="submit">Entrar</button>
				</form>
			</div>
			<hr class="hr2">
			<div class=bLogin>
				<a href="<c:url value= "/users/new"/>">Não tem uma conta? <br>Cadastre-se
				</a>
			</div>
			<div class=aLogin>
				<a href="<c:url value= "/users/new"/>">Esqueci minha senha </a>
			</div>
		</div>

	</div>
</div>
<%@ include file="/WEB-INF/jspf/footer.jspf"%>