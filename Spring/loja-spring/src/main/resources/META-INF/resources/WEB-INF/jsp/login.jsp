<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>


	<form action="/qualquercoisa/login" method="POST">
		Nome: <input type="text" name="nomeusuario">
		<br /> 
		<br /> 
		<input type="submit"
			value="Submit">
	</form>
	<br />
	<br />
		<a href="/qualquercoisa/paginacadastracliente">Cadastrar Novo Cliente</a>
	<br />
	<br />	
		<a href="/qualquercoisa/listareposicao">Processar Reposição</a>
	<br />
	<br />	
		<a href="/qualquercoisa/paginacadastraproduto">Cadastrar Produto no Estoque</a>
	<br />
	<br />	
		<a href="/qualquercoisa/listaprodutoestoque">Lista Produtos do Estoque</a>
	<br />
	<br />	
		<a href="/qualquercoisa/paginaatualizaproduto">Atualiza Produto do Estoque</a>
</body>
</html>