<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	margin-bottom: 18px;
}

h4 {
	text-align: center;
}

hr {
	width: 280px;
	margin-bottom: 25px;
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
	height: 100%;
	margin-left: 290px;
}

.telaLogin {
	background-color: rgba(0, 0, 0, 0.2);
	border: 1px solid rgba(0, 0, 0, 0);
	width: 350px;
	margin: 130px auto;
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
	<h4>Olá, Paola!</h4>
	<br>
	<div class="itensPainel">
		<p>Adicionar colaborador</p>
		<p>Verificar colaborador</p>
		<p style="background: #6de06d; border: 1px solid #32af32;">Verificar
			caixa</p>
		<p>Controle de projetos</p>
		<p>Estoque de brinquedos</p>
	</div>

</div>
<div class="tela1">
	<section class="telaLogin">
		<h2>Caixa da ONG</h2>
		<hr></hr>
		<div class="formLogin">
			<div class="input-group">
				<h3>Total de vendas:</h3>
				<c:set var="vendas" value="${12047.68 }" />
				<fmt:formatNumber type="currency" value="${vendas }" />
			</div>
			<br>
			<div class="input-group">
				<h3>Total de doações:</h3>
				<c:set var="doacoes" value="${8856.23 }" />
				<fmt:formatNumber type="currency" value="${doacoes }" />
			</div>
			<br>
			<div class="input-group">
				<h3>Total de custos:</h3>
				<c:set var="custos" value="${6209.40 }" />
				<fmt:formatNumber type="currency" value="${custos }" />
			</div>
			<br>
			<hr></hr>
			<div class="btnForm" style="padding-bottom: 30px;">
				<h3>Total geral:</h3>
				<c:set var="total" value="${vendas + doacoes - custos }" />
				<fmt:formatNumber type="currency" value="${total }" />
			</div>
		</div>
	</section>
</div>