<%@ include file="/WEB-INF/jspf/header.jspf"%>
<div class="container">
	<c:if test="${userWeb.logged }">
		<form action="<c:url value="/games/new"/>" method="get">
			<p>
				<button class="btn btn-default" type="submit">Novo Jogo</button>
			</p>
		</form>
	</c:if>
</div>
<div class="container">
	<div class="table-responsive">
		<table class="table">
			<thead>
				<tr>
					<th></th>
					<th>Título</th>
					<th>Preço</th>
					<th>Comprar</th>
					<c:if test="${userWeb.logged }">
						<th>Editar</th>
					</c:if>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${gameList}" var="game" varStatus="g">
					<tr>
						<td><img src="<c:url value="/games/${game.id}/image"/>"
							width="100" height="100" /></td>
						<td>${game.title }</td>
						<td>${game.price }</td>
						<td><c:if test="${!userWeb.logged}">
								<form action="<c:url value="/login"/>">
									<button type="submit" class="btn btn-default">Faça
										login para efetuar uma compra</button>
								</form>
							</c:if> <c:if test="${userWeb.logged}">
								<c:forEach items="${cart.items }" var="itemAdded">
									<c:set var="items" value="${itemAdded }" />
									<c:if test="${items.game.id eq game.id}">
										<c:set var="contains" value="true" />
									</c:if>
								</c:forEach>
								<c:choose>
									<c:when test="${!contains}">
										<form action="<c:url value="/cart"/>" method="post">
											<input type="hidden" name="item.game.id" value="${game.id }" />
											<button type="submit" class="btn btn-default">Adicionar
												ao carrinho</button>
										</form>
									</c:when>
									<c:otherwise>
										<c:forEach items="${cart.items }" var="item">
											<c:set var="contains" value="false" />
											<c:if test="${item.game.id eq game.id and !contains}">
												<button class="btn btn-default disabled">Jogo já
													adicionado</button>
											</c:if>
										</c:forEach>
									</c:otherwise>
								</c:choose>

							</c:if></td>
						<c:if test="${userWeb.logged }">
							<td>
								<form action="<c:url value="/games/${game.id}"/>">
									<button type="submit" class="btn btn-default">Editar
										jogo</button>
								</form>
							</td>
						</c:if>

					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
</div>
<%@ include file="/WEB-INF/jspf/footer.jspf"%>