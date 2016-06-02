<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
body {
	background-color: #ace2ae;
}

p {
	margin-bottom: 50px;
	border: 1px solid;
	text-align: center;
	background-color: rgba(128, 128, 128, 0.24);
	padding: 12px;
}

h1 {
	text-align: center;
	margin-bottom: 25px;
}

h2 {
	text-align: center;
	margin-bottom: 34px;
}

h4 {
	text-align: center;
}

.painel {
	position: relative;
	border: 2px solid green;
	width: 280px;
	height: 100%;
	background: rgba(0, 0, 0, 0.1);
	float: left;
}

.itensPainel {
	margin-left: 36px;
	margin-right: 36px;
}

.tela1 {
	border: 2px solid green;
	height: 688px;
	margin-left: 290px;
	padding-top: 250px;
}

.telaLogin {
	background-color: rgba(0, 0, 0, 0.2);
	margin-top: 125px;
	border: 1px solid rgba(0, 0, 0, 0);
	width: 350px;
	margin: 0 auto;
	border-radius: 8px;
}

.formLogin {
	text-align: center;
}

input {
	height: 28px;
	width: 200px;
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

<div class="painel">
	<h1>Painel de controle</h1>
	<h4>Olá, Aldeglicia!</h4>
	<br>
	<div class="itensPainel">
		<p style="background: #6de06d; border: 1px solid #32af32;">Adicionar
			colaborador</p>
		<p>Verificar colaborador</p>
		<p>Verificar caixa</p>
		<p>Controle de projetos</p>
		<p>Estoque de brinquedos</p>
	</div>

</div>
<div class="tela1">
	<section class="telaLogin">
		<h2>Cadastre um novo colaborador</h2>
		<div class="formLogin">
			<div class="input-group">
				<span class="input-group-addon" id="basic-addon1"><span
					class="glyphicon glyphicon-log-in" aria-hidden="true"></span></span><input
					type="text" class="form-control" id="login" name="user.login"
					value="${user.login }" placeholder="Primeiro nome"
					required="required">
			</div>
			<div class="input-group">
				<span class="input-group-addon" id="basic-addon1"><span
					class="glyphicon glyphicon-log-in" aria-hidden="true"></span></span><input
					type="text" class="form-control" id="login" name="user.login"
					value="${user.login }" placeholder="Sobrenome" required="required">
			</div>
			<div class="input-group">
				<span class="input-group-addon" id="basic-addon1"><span
					class="glyphicon glyphicon-log-in" aria-hidden="true"></span></span><input
					type="text" class="form-control" id="login" name="user.login"
					value="${user.login }" placeholder="Número de identificação"
					required="required">
			</div>
			<div class="input-group">
				<span class="input-group-addon" id="basic-addon1"><span
					class="glyphicon glyphicon-log-in" aria-hidden="true"></span></span><input
					type="text" class="form-control" id="login" name="user.login"
					value="${user.login }" placeholder="Tipo de cargo"
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
				<button type="submit" class="btn btn-default">Cadastrar</button>
			</div>
		</div>
	</section>
</div>