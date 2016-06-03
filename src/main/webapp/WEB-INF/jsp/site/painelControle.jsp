<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><link
	rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" href="<c:url value="/css/style.css"/>">
<link rel="stylesheet" href="<c:url value="/css/full-slider.css"/>">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="<c:url value="/js/jquery.puts.js"/>"></script>
<style>
body {
	background-color: #82D2E4;
}

p {
	margin-bottom: 50px; border: 1px solid; text-align: center;
	background-color: rgba(128, 128, 128, 0.24); padding: 12px;
}

h1 {
	text-align: center; margin-bottom: 25px;
}

h2 {
	text-align: center; margin-bottom: 34px; margin-top: 32px;
}

h4 {
	text-align: center;
}

.painel {
	position: relative; border: 2px solid green;
	background: rgba(0, 0, 0, 0.1);
}

.itensPainel {
	margin-left: 36px; margin-right: 36px;
}

.tela1 {
	border: 2px solid white; border-radius: 10px; height: 100%;
}

.telaLogin {
	background-color: rgba(0, 0, 0, 0.2); margin-top: 20%;
	border: 1px solid rgba(0, 0, 0, 0); width: 350px; margin: 170px auto;
	border-radius: 8px; border: 1px solid rgba(0, 0, 0, 0); width: 350px;
	width: 350px;
}

.formLogin {
	text-align: center;
}

input {
	height: 28px; width: 200px;
}

hr {
	width: 280px; margin-bottom: 25px;
}

.input-group {
	margin-bottom: 6px;
}

.btn {
	margin-top: 35px; width: 90px; height: 40px;
}
</style>

<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<c:url value="/"/>">TimeTrial
				Factory </a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li><a href="#">Sobre</a></li>
				<li><a href="<c:url value="/games"/>">Catálogo de Jogos</a></li>
				<li><a href="#">Contato</a></li>
				<li><a href="#">Suporte</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<c:if test="${userWeb.logged}">
					<li style="padding-top: 14.5px; margin-right: 20px;"><span
						class="userWeb-logged">Olá, ${userWeb.name }!</span></li>
					<li><a href="<c:url value="/cart"/>"><span
							class="glyphicon glyphicon-shopping-cart"></span> Carrinho</a></li>
					<li><a href="<c:url value="/logout"/>"><span
							class="glyphicon glyphicon-log-out"></span> Logout</a></li>
				</c:if>
				<c:if test="${empty userWeb or !userWeb.logged}">
					<li><a id="newUser"
						href="<c:url value="/users/selectCountry"/>"><span
							class="glyphicon glyphicon-user"></span> Cadastre-se</a></li>
					<li><a id="log-in" href="<c:url value="/login"/>"><span
							class="glyphicon glyphicon-log-in"></span> Login</a></li>
				</c:if>
			</ul>
		</div>
	</div>
</nav>
<div class="tela1">
	<section class="telaLogin">
		<h2>Cadastre um novo colaborador</h2>
		<hr>
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