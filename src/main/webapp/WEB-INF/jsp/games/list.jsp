<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%@ include file="/WEB-INF/jspf/header.jspf"%>
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
				<td>
					<form action="<c:url value="/cart"/>" method="post">
						<input type="hidden" name="item.game.id" value="${game.id }" /> <input
							class="qtde" name="item.quantity" value="1" />
						<button type="submit">Adicionar</button>
					</form>
				</td>
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
</html>