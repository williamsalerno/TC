<%@ include file="/WEB-INF/jspf/header.jspf"%>
<div id="errors">
	<ul>
		<c:forEach items="${errors}" var="error">
			<li>${error.category }-${error.message }</li>
		</c:forEach>
	</ul>
</div>
<div class="containerLogin">
	<div class="content">
		<div class="login">
			<form class="escondido form-horizontal" role="form" id="usersForm"
				action="<c:url value="/users"/>" method="post">
				<br>
				<h2 id="h2Form" style="text-align: center; color: #FFC277">
					Cadastre-se<br> <small style="font-size: 15px">Todos
						os campos s�o obrigat�rios</small>
				</h2>
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon1"><span
						class="glyphicon glyphicon-user" aria-hidden="true"></span></span> <input
						type="text" class="form-control" id="name" name="user.name"
						value="${user.name }" placeholder="Primeiro nome"
						aria-describedby="basic-addon1" required="required">
				</div>
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon1"><span
						class="glyphicon glyphicon-user" aria-hidden="true"></span></span><input
						type="text" class="form-control" id="lastName"
						name="user.LastName" value="${user.lastName }"
						placeholder="Sobrenome" aria-describedby="basic-addon1"
						required="required">
				</div>
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon1"><span
						class="glyphicon glyphicon-user" aria-hidden="true"></span></span> <input
						type="text" class="form-control" id="cpf" name="user.cpf"
						value="${user.cpf }" placeholder="CPF" required="required">
				</div>
				<br>
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon1">@</span><input
						type="email" class="form-control" id="email" name="user.email"
						value="${user.email }" placeholder="exemplo@exemplo.com"
						required="required">
				</div>
				<br>
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon1"><span
						class="glyphicon glyphicon-earphone" aria-hidden="true"></span></span><input
						type="text" class="form-control" id="ddd" name="user.phone.ddd"
						value="${user.phone.ddd }" placeholder="DDD" required="required">
				</div>
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon1"><span
						class="glyphicon glyphicon-earphone" aria-hidden="true"></span></span> <select
						class="form-control" id="phoneType" name="user.phone.phoneType"
						value="${user.phone.phoneType }" required="required">
						<option selected="selected">Tipo de telefone</option>
						<option>HOME</option>
						<option>MOBILE</option>
					</select>

				</div>
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon1"><span
						class="glyphicon glyphicon-earphone" aria-hidden="true"></span></span><input
						type="text" class="form-control" id="number"
						name="user.phone.number" value="${user.phone.number }"
						placeholder="Somente n�meros" required="required">

				</div>
				<br>
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon1"><span
						class="glyphicon glyphicon-home" aria-hidden="true"></span></span><input
						type="text" class="form-control" id="cep" name="user.address.cep"
						value="${user.address.cep }" placeholder="CEP" required="required">
				</div>
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon1"><span
						class="glyphicon glyphicon-home" aria-hidden="true"></span></span><input
						type="text" class="form-control" id="city"
						name="user.address.city" value="${user.address.city }"
						placeholder="Cidade" required="required">

				</div>
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon1"><span
						class="glyphicon glyphicon-home" aria-hidden="true"></span></span><input
						type="text" class="form-control" id="state"
						name="user.address.state" value="${user.address.state }"
						placeholder="Estado" required="required">
				</div>
				<br>
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
						placeholder="Senha (entre 6 e 10 d�gitos alfanum�ricos)"
						required="required">
				</div>
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon1"><span
						class="glyphicon glyphicon-asterisk" aria-hidden="true"></span></span><input
						type="password" class="form-control" id="confirm"
						equalTo="#password" placeholder="Confirme a senha"
						required="required">

				</div>
				<div class="btnForm">
					<button type="submit" class="btn btn-default">Confirmar</button>
				</div>
				<br>
			</form>
		</div>
	</div>
</div>
<script type="text/javascript">
	//$('#usersForm').validate();
</script>
<%@ include file="/WEB-INF/jspf/footer.jspf"%>