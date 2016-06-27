<div id="wrapper">
	<%@ include file="/WEB-INF/jspf/header.jspf"%>
	<div class="containerLogin">
		<div class="content">
			<section class="login">
				<div class="escondido">
					<h2>Login</h2>
					<form class="form-horizontal" action="<c:url value="/login"/>"
						method="POST">
						<div class="input-group">
							<span class="input-group-addon" id="basic-addon1"><span
								class="glyphicon glyphicon-log-in" aria-hidden="true"></span></span><input
								type="text" class="form-control" id="login" name="user.login"
								value="${user.login }" placeholder="Nome de usuário"
								required="required">
						</div>
						<div class="input-group">
							<span class="input-group-addon" id="basic-addon1"><span
								class="glyphicon glyphicon-asterisk" aria-hidden="true"></span></span>
							<input type="password" class="form-control" id="password"
								name="user.password" value="${user.password }"
								placeholder="Senha" required="required">
						</div>
						<div class="btnForm" style="padding-bottom: 30px;">
							<button type="submit" class="btn btn-default">Entrar</button>
						</div>
						<hr style="margin-bottom: 40px;">
						<c:forEach items="${errors}" var="error">
							<c:set var="messageId" value="1" />
							<c:if test="${error.category eq messageId }">
								<div class="alert alert-success" style="text-align: center;">
									${error.message }</div>
							</c:if>
							<c:if test="${error.category ne messageId }">
								<div class="alert alert-danger" style="text-align: center;">
									<strong>${error.category } </strong>${error.message }
								</div>
							</c:if>
						</c:forEach>
					</form>
					<c:set var="userOk" value="${userOk + 0 }" />
					<c:if test="${userWeb.registerOk and userOk == 0 }">
						<div class="alert alert-success" style="text-align: center;">
							Usuário cadastrado com sucesso!</div>
						<c:set var="userOk" value="${userOk + 1 }" />
					</c:if>
					<div class=bLogin>
						<a id="newAcc" href="<c:url value= "/users/selectCountry"/>">Não
							tem uma conta? <br>Cadastre-se
						</a>
					</div>
					<div class=aLogin>
						<a href="<c:url value= "/users/new"/>">Esqueci minha senha </a>
					</div>
				</div>
			</section>
		</div>
	</div>
	<script>
		var teste = "${userOk }"
		console.log(teste);
	</script>
	<%@ include file="/WEB-INF/jspf/footer.jspf"%>
</div>