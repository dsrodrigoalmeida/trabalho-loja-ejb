<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Pedidos de Reposicao</title>
</head>
<body>
<h3> Essa lista contém os dados de todos pedidos de reposição</h3>
	<form method=POST action="/qualquercoisa/processareposicao">
		<c:forEach var="reposicao" items="${reposicao}">
			<table>
				<tr>
					<td>Id</td>
					<td>Status</td>
					<td>Produtos</td>
				</tr>

				<tr>
					<td>${reposicao.idReposicao }</td>
					<td>${reposicao.status }</td>
					<td>${reposicao.produtos }</td>
					<td><input type="radio" name="radio"
						value=${reposicao.idReposicao}></td>
				</tr>
			</table>


			<br />
		</c:forEach>

		<br /> 
		<br /> 
		<input type="submit" value="Processar">
	</form>
	<br /> 
	<br />
	<a href="/qualquercoisa/">Voltar</a>

</body>
</html>