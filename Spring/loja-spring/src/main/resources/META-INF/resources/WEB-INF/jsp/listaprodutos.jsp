<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Produtos do Estoque</title>
</head>
<body>
	<h3>Selecioe o produto clicando no botão ao lado e em seguida
		digite a quantidade desejada e depois adicione ao carrinho</h3>
	<form method=POST action="/qualquercoisa/adicionacarrinho">
		<c:forEach var="produto" items="${produtos}">
			<table>
				<tr>
					<td>Id</td>
					<td>Nome</td>
					<td>Quantidade</td>
					<td>Valor</td>
				</tr>

				<tr>
					<td>${produto.idProduto }</td>
					<td>${produto.nome }</td>
					<td>${produto.quantidade }</td>
					<td>${produto.valor }</td>
					<td><input type="radio" name="radio" value=${produto.idProduto}></td>

				</tr>
			</table>


			<br />
		</c:forEach>
		Quantidade: <input type="number" name="quantidadecompra"> <br />
		<br /> <input type="submit" value="Adicionar ao Carrinho"> <br /> <br />
	</form>
	<br />
	<br />
	<a href="/qualquercoisa/index">Voltar para a pagina inicial</a>


</body>
</html>