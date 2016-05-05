<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Itens do seu carrinho de compras</h3>

	<table>
		<thead>
			<tr>
				<th>Título</th>
				<th>Preço</th>
				<th>Qtde</th>
				<th>Total</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${cart.items}" var="item" varStatus="s">
				<tr>
					<td>${item.game.title }</td>
					<td><fmt:formatNumber type="currency"
							value="${item.game.price }" /></td>
					<td>${item.quantity }</td>
					<td><fmt:formatNumber type="currency"
							value="${item.game.price * item.quantity}" /></td>
					<td>
						<form action="<c:url value="/cart/${s.index}"/>" method="post">
							<button class="link" name="_method" value="delete">Remover</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="2"></td>
				<th colspan="2">Total:</th>
				<th><fmt:formatNumber type="currency" value="${cart.total }" /></th>
			</tr>
		</tfoot>
	</table>
	<form action="<c:url value="/games"/>" method="get">
		<button class="link">Voltar</button>
	</form>
</body>
</html>