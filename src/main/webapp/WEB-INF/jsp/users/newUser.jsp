<%@ include file="/WEB-INF/jspf/header.jspf"%>
<div id="errors">
	<ul>
		<c:forEach items="${errors}" var="error">
			<li>${error.category }-${error.message }</li>
		</c:forEach>
	</ul>
</div>
<div class="container">
	<h2>Cadastre-se</h2>
	<form class="form-horizontal" role="form" id="usersForm"
		action="<c:url value="/users"/>" method="post">
		<div class="form-group">
			<label class="control-label col-sm-2" for="name">Nome:</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="name" name="user.name"
					value="${user.name }" placeholder="Primeiro nome">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="lastName">Sobrenome:</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="lastName"
					name="user.lastName" value="${user.lastName }"
					placeholder="Último nome">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="cpf">CPF:</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="cpf" name="user.cpf"
					value="${user.cpf }" placeholder="Somente números">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="email">Email:</label>
			<div class="col-sm-5">
				<input type="email" class="form-control" id="email"
					name="user.email" value="${user.email }"
					placeholder="exemplo@exemplo.com">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="ddd">DDD:</label>
			<div class="col-sm-1">
				<input type="text" class="form-control" id="ddd"
					name="user.phone.ddd" value="${user.phone.ddd }">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="phoneType">Tipo de
				telefone:</label>
			<div class="col-sm-2">
				<select class="form-control" id="phoneType"
					name="user.phone.phoneType" value="${user.phone.phoneType }">
					<option selected="selected">Escolha um tipo</option>
					<option>HOME</option>
					<option>MOBILE</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="number">Número:</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="number"
					name="user.phone.number" value="${user.phone.number }"
					placeholder="Somente números">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="cep">CEP:</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="cep"
					name="user.address.cep" value="${user.address.cep }"
					placeholder="Somente números">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="city">Cidade:</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="city"
					name="user.address.city" value="${user.address.city }">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="state">Estado:</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="state"
					name="user.address.state" value="${user.address.state }">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="login">Login:</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="login" name="user.login"
					value="${user.login }">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="password">Senha:</label>
			<div class="col-sm-3">
				<input type="password" class="form-control" id="password"
					name="user.password" value="${user.password }"
					placeholder="Entre 6 e 10 dígitos alfanuméricos.">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="confirm">Confirme
				a senha:</label>
			<div class="col-sm-3">
				<input type="password" class="form-control" id="confirm"
					equalTo="#password">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-4">
				<button type="submit" class="btn btn-default">Confirmar</button>
			</div>
		</div>
	</form>
</div>
<script type="text/javascript">
	$('#usersForm').validate();
</script>
<%@ include file="/WEB-INF/jspf/footer.jspf"%>