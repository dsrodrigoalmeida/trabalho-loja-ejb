<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Carrinho de Compras</title>
</head>
<body>
	<h3>Para remover um produto do carrinho, so selecionar o produto
		clicando no botão ao lado do nome e em seguida clique em remover</h3>
	<form method=POST action="/qualquercoisa/removecarrinho">
		<c:forEach var="produto" items="${carrinho}">
			<table>
				<tr>
					<td>Nome</td>
					<td>Quantidade</td>
					<td>Valor</td>
				</tr>

				<tr>
					<td>${produto.nome }</td>
					<td>${produto.quantidade }</td>
					<td>${produto.valor }</td>
					<td><input type="radio" name="radio" value=${produto.nome}></td>
				</tr>
			</table>


			<br />
		</c:forEach>
		<br /> <br /> <input type="submit" value="Remover">
	</form>
	<br />
	<br />
	<a href="/qualquercoisa/finalizapedido">Finalizar Pedido</a>

	<br />
	<br />
	<a href="/qualquercoisa/index">Voltar para a pagina inicial</a>


</body>
</html>