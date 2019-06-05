<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Cliente</title>
</head>
<body>

	<h3>Digite o nome de usuario e o nome verdadeiro para fazer o cadastro de um novo cliente</h3>

	<form action="/qualquercoisa/cadastracliente" method="POST">
		Nome de Usuario: <input type="text" name="nomeusuario">
		<br /> 
		Nome Verdadeiro: <input type="text" name="nomecliente">
		<br /> 
		
		<input type="submit"
			value="Submit">
	</form>
	<br />
	<br />
	<a href="/qualquercoisa/">Voltar</a>
</body>
</html>