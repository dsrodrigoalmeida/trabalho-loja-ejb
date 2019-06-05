<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Estoque</title>
</head>
<body>
<h3> Essa lista contém os dados de todos produtos no estoque</h3>
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
				</tr>
			</table>


			<br />
		</c:forEach>
		
	<br />
	<br />
	<a href="/qualquercoisa/">Voltar</a>


</body>
</html>