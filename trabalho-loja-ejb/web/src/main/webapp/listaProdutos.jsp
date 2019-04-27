<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Estoque</title>
</head>
<body>

<table>
			<tr>
				<td>Quantidade</td>
				<td>Nome</td>
				<td>Preço</td>
			</tr>
			<c:forEach var="estoque" items="${estoques}">
				<tr>
					<td>${estoque.qtdEstoque}</td>
					<td>${estoque.produto.nome}</td>
					<td>${estoque.produto.preco}</td>
				</tr>
			</c:forEach>
		</table>
		<br>
	 <a href="${pageContext.request.contextPath}/index.jsp">Voltar para a pagina inicial</a>

</body>
</html>






