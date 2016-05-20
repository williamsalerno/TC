<%@ include file="/WEB-INF/jspf/header.jspf"%>
<div class="containerLogin">
	<div class="content">
		<div class="login">
			<div class="escondido">
				<h2>Login</h2>
				<form class="form-horizontal" action="<c:url value="/login"/>"
					method="POST">
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1"><span
							class="glyphicon glyphicon-log-in" aria-hidden="true"></span></span><input
							type="text" class="form-control" id="login" name="user.login"
							value="${user.login }" placeholder="Nome de usu�rio"
							required="required">
					</div>
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1"><span
							class="glyphicon glyphicon-asterisk" aria-hidden="true"></span></span> <input
							type="password" class="form-control" id="password"
							name="user.password" value="${user.password }"
							placeholder="Senha" required="required">
					</div>
					<div class="btnForm" style="padding-bottom: 50px;">
						<button type="submit" class="btn btn-default">Entrar</button>
					</div>
				</form>
				<div class=bLogin>
					<a id="newAcc" href="<c:url value= "/users/new"/>">N�o tem uma
						conta? <br>Cadastre-se
					</a>
				</div>
				<div class=aLogin>
					<a href="<c:url value= "/users/new"/>">Esqueci minha senha </a>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/jspf/footer.jspf"%>