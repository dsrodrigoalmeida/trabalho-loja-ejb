<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Pedidos</title>
</head>
<body>
<h3> Essa lista contém os dados de todos seus pedidos  </h3>
<form method=POST
		action="/qualquercoisa/cancelapedido">
<c:forEach var="pedido" items="${listapedido}">
	<table>
		<tr>
			<td>Id</td>
			<td>Status </td>
			<td>Cliente</td>
			<td>Produtos</td>
		</tr>
		
			<tr>
				<td>${pedido.idPedido }</td>
				<td>${pedido.status }</td>
				<td>${pedido.cliente }</td>
				<td>${pedido.produtos }</td>
				<td><input type="radio" name="radio" value=${pedido.idPedido}></td>
			</tr>
	</table>

	<br />
</c:forEach>

		<br /> 
		
<input type="submit"
			value="Cancelar Pedido">
<br />
<br />
</form>
<br />
<br />
	<a href="/qualquercoisa/index">Voltar para a pagina inicial</a>


</body>
</html>