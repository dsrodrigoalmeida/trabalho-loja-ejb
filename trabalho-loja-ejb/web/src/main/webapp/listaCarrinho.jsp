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
	<form method=POST
		action="${pageContext.request.contextPath}/carrinho">
		
		<table>
			<tr>
				<td>Quantidade</td>
				<td>Nome</td>
				<td>Preço</td>
			</tr>
			<c:forEach var="carrinho" items="${carrinhos}">
				<tr>
					<td>${carrinho.qtdCarrinho}</td>
					<td>${carrinho.produto.nome}</td>
					<td>${carrinho.produto.preco}</td>
					<td><input type="radio" name="radio" value=${carrinho.produto.id}></td>
				</tr>
			
			</c:forEach>
		</table>
		 
		<input type=submit name="submit" value="Remover">
		
	</form>
	<br>
	 <a href="${pageContext.request.contextPath}/index.jsp">Voltar para a pagina inicial</a>
</body>
</html>