<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resultados da busca</title>
</head>
<body>


	<form action="/qualquercoisa/buscaproduto" method="GET">

		<h3>Digite o nome ou parte do nome do produto que deseja buscar.
			Caso deixe o campo em branco, o sistema irá listar todos os produtos
			disponiveis da loja</h3>
		<br /> Nome: <input type="text" name="nomeproduto"><br>
		<br /> <input type="submit" value="Submit">
	</form>
	<br />
	<br />
	<a href="/qualquercoisa/index">Voltar para a pagina inicial</a>
</body>
</html>