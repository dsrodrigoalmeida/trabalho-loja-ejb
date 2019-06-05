<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Produto</title>
</head>
<body>

	<h1>Digite o nome, a quantidade e o valor para cadastrar um novo produto</h1>

	<form action="/qualquercoisa/cadastraproduto" method="POST">
		Nome: <input type="text" name="nome">
		<br /> 
		Quantidade: <input type="number" name="quantidade">
		<br /> 
		
		Valor: <input type="number" name="valor">
		<br /> 
		<input type="submit"
			value="Submit">
	</form>
	<br />
	<br />
	<a href="/qualquercoisa/">Voltar</a>
</body>
</html>