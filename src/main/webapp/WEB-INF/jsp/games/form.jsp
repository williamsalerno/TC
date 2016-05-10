<%@ include file="/WEB-INF/jspf/header.jspf"%>
<div id="errors">
	<ul>
		<c:forEach items="${errors}" var="error">
			<li>${error.category }-${error.message }</li>
		</c:forEach>
	</ul>
</div>
<div>
	<form id="gamesForm" action="<c:url value="/games"/>" method="post">
		<fieldset>
			<legend>Adicionar Novo Jogo</legend>

			<label for="title">Título:</label> <input id="title" class="required"
				minlength="5" type="text" name="game.title" value="${game.title }" />
			<label for="price">Preço:</label> <input id="price" min="1"
				type="text" name="game.price" value="${game.price }" />

			<button type="submit">Enviar</button>
		</fieldset>
	</form>
</div>
<script type="text/javascript">
	$('#gamesForm').validate();
</script>
<%@ include file="/WEB-INF/jspf/footer.jspf"%>