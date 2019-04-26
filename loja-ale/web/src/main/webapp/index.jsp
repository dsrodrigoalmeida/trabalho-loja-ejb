<html>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<head>
<title>Loja</title>
</head>

<body bgcolor="white">

	<form method=post
		action="${pageContext.request.contextPath}/carrinho">

		<br> <br>  Escolha o produto para ser adicionado ao carrinho: <select name="item">
		<br>
			<option value=1>O Temor do Sabio - 50R$
			<option value=2>Senhor dos Aneis - 108R$
			<option value=3>Hobbit - 38R$
			<option value=4>O Nome do Vento - 42R$
			<option value=5>The Legend of Zelda: Breath of the
				Wild-Creating a Champion - 133 R$
			<option value=6>Box As Cronicas de Gelo e Fogo - 180 R$
			<option value=7>The Legend of Zelda: Hyrule Historia - 113
				R$
			<option value=8>Fogo E Sangue - Volume 1 - 56 R$
			<option value=9>Trilogia dos Espinhos - 81 R$
		</select> 
		<input type="text" name="qtd" /> <br> <br>
		<br> <input type=submit name="submit" value="add">

	</form>
		<form method=get
		action="${pageContext.request.contextPath}/estoque">
		<input type=submit name="submit" value="Listar Estoque ">
		<input type=submit name="submit" value="Finalizar Compra ">
		</form>
</body>
</html>
