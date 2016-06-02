<style>
body {
	background-color: #ace2ae;
}

h1 {
	margin-top: 200px;
}

h1, h2 {
	text-align: center;
	margin-bottom: 34px;
}

.telaLogin {
	background-color: rgba(0, 0, 0, 0.2);
	margin-top: 125px;
	border: 1px solid rgba(0, 0, 0, 0);
	width: 320px;
	margin: 0 auto;
	border-radius: 8px;
}

.formLogin {
	text-align: center;
}

input {
	height: 24px;
}

.input-group {
	margin-bottom: 3px;
}

.btn {
	margin-top: 35px;
	width: 90px;
	height: 40px;
}
</style>
<div class="container">
	<h1>ONG Jovens Ambientalistas</h1>
	<section class="telaLogin">
		<h2>Login</h2>
		<div class="formLogin">
			<div class="input-group">
				<span class="input-group-addon" id="basic-addon1"><span
					class="glyphicon glyphicon-log-in" aria-hidden="true"></span></span><input
					type="text" class="form-control" id="login" name="user.login"
					value="${user.login }" placeholder="Nome de usuário"
					required="required">
			</div>
			<div class="input-group">
				<span class="input-group-addon" id="basic-addon1"><span
					class="glyphicon glyphicon-asterisk" aria-hidden="true"></span></span> <input
					type="password" class="form-control" id="password"
					name="user.password" value="${user.password }" placeholder="Senha"
					required="required">
			</div>
			<div class="btnForm" style="padding-bottom: 30px;">
				<button type="submit" class="btn btn-default">Entrar</button>
			</div>
		</div>
	</section>
</div>
