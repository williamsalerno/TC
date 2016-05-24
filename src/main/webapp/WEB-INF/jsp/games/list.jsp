<%@ include file="/WEB-INF/jspf/header.jspf"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="container">
	<div class="games">
		<div class="moreInfoGame">
			<div class="imageGame">
				<img data-src="holder.js/100%x200" alt="100%x200"
					src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iMjQyIiBoZWlnaHQ9IjIwMCIgdmlld0JveD0iMCAwIDI0MiAyMDAiIHByZXNlcnZlQXNwZWN0UmF0aW89Im5vbmUiPjwhLS0KU291cmNlIFVSTDogaG9sZGVyLmpzLzEwMCV4MjAwCkNyZWF0ZWQgd2l0aCBIb2xkZXIuanMgMi42LjAuCkxlYXJuIG1vcmUgYXQgaHR0cDovL2hvbGRlcmpzLmNvbQooYykgMjAxMi0yMDE1IEl2YW4gTWFsb3BpbnNreSAtIGh0dHA6Ly9pbXNreS5jbwotLT48ZGVmcz48c3R5bGUgdHlwZT0idGV4dC9jc3MiPjwhW0NEQVRBWyNob2xkZXJfMTU0YmVmN2YwZTEgdGV4dCB7IGZpbGw6I0FBQUFBQTtmb250LXdlaWdodDpib2xkO2ZvbnQtZmFtaWx5OkFyaWFsLCBIZWx2ZXRpY2EsIE9wZW4gU2Fucywgc2Fucy1zZXJpZiwgbW9ub3NwYWNlO2ZvbnQtc2l6ZToxMnB0IH0gXV0+PC9zdHlsZT48L2RlZnM+PGcgaWQ9ImhvbGRlcl8xNTRiZWY3ZjBlMSI+PHJlY3Qgd2lkdGg9IjI0MiIgaGVpZ2h0PSIyMDAiIGZpbGw9IiNFRUVFRUUiLz48Zz48dGV4dCB4PSI4OS44NTkzNzUiIHk9IjEwNS4xIj4yNDJ4MjAwPC90ZXh0PjwvZz48L2c+PC9zdmc+"
					data-holder-rendered="true"
					style="height: 100%; width: 100%; display: block;">
			</div>
			<div class="detailsGame">
				<div class="titleGame">
					<h1>TESTE</h1>
				</div>
				<div class="btnAddCart">
					<c:forEach items="${gameList}" var="game" varStatus="g">
						<div class="priceGame">
							<fmt:formatNumber type="currency" value="${game.price }" />
						</div>
						<c:if test="${userWeb.logged}">
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

						</c:if>
						<c:if test="${userWeb.logged }">

							<form action="<c:url value="/games/${game.id}"/>">
								<button type="submit" class="btn btn-default">Editar
									jogo</button>
							</form>

						</c:if>


					</c:forEach>
				</div>
			</div>
		</div>
		<div class="listGames">
			<c:forEach items="${gameList}" var="game" varStatus="g">
				<div class="thumbnailGame">
					<img src="<c:url value="/games/${game.id}/image"/>" width="100"
						height="100" />
				</div>
			</c:forEach>
		</div>
	</div>
</div>
<div class="container">
	<div>
		<c:if test="${userWeb.logged and userWeb.admin}">
			<form action="<c:url value="/games/new"/>" method="get">
				<p>
					<button class="btn btn-default" type="submit">Novo Jogo</button>
				</p>
			</form>
		</c:if>
		<div class="table-responsive">
			<table class="table">
				<thead>
					<tr>
						<th></th>
						<th>Título</th>
						<th>Preço</th>
						<th>Comprar</th>
						<c:if test="${userWeb.logged and userWeb.admin}">
							<th>Editar</th>
						</c:if>
					</tr>
				</thead>
				<tbody>


				</tbody>
			</table>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/jspf/footer.jspf"%>