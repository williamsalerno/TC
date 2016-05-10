<%@ include file="/WEB-INF/jspf/header.jspf"%>
<div class="container">
	<table>
		<thead>
			<tr>
				<th>Nome</th>
				<th>Preço</th>
				<th>Comprar</th>
				<th>Editar</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${gameList}" var="game">
				<tr>
					<td><img src="<c:url value="/games/${game.id}/image"/>"
						width="100" height="100" /></td>
					<td>${game.title }</td>
					<td>${game.price }</td>
					<td><c:if test="${userWeb.logged}">
							<c:if test="${item.inCart == true }">
								<button type="submit" class="btn btn-default disabled"
									name="item.inCart">Jogo já adicionado</button>
							</c:if>
							<form action="<c:url value="/cart"/>" method="post">
								<input type="hidden" name="item.game.id" value="${game.id }" />
								<input type="hidden" name="item.inCart" value="true" />
								<button type="submit" class="btn btn-default">Adicionar
									ao carrinho</button>
							</form>

						</c:if></td>
					<c:if test="${userWeb.logged }">
						<td><a href="<c:url value="/games/${game.id }"/>">Editar</a></td>
					</c:if>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${userWeb.logged }">
		<form action="<c:url value="/games/new"/>" method="get">
			<p>
				<button type="submit">Novo Jogo</button>
			</p>
		</form>
	</c:if>
</div>
<%@ include file="/WEB-INF/jspf/footer.jspf"%>