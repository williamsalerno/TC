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
							<c:choose>
								<c:when test="${item.quantity == 1}">
									<input type="hidden" name="item.game.id" value="${game.id }" />
									<button class="btn btn-default disabled">Jogo já
										adicionado</button>
								</c:when>
								<c:otherwise>
									<form action="<c:url value="/cart"/>" method="post">
										<input type="hidden" name="item.game.id" value="${game.id }" />
										<input class="qtde" name="item.quantity" value="1" />
										<button type="submit" class="btn btn-default">Adicionar
											ao carrinho</button>
									</form>
								</c:otherwise>
							</c:choose>

						</c:if> <c:if test="${userWeb.logged }">
							<td><a href="<c:url value="/games/${game.id }"/>">Editar</a></td>
						</c:if></td>
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