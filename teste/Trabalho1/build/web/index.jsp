<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
</head>
<body>
<h1>Seja Bem Vindo</h1>

<h2>Ir Home</h2>
<!--
<form action="buscaProfessor">
Nome<input type="text" name="nomeProssefor">
<input type="submit" value="busca">

</form>
-->

<h2>Inserir Novo Professor</h2>
<form action="adicionaProfessor" method="post">
	Nome<input type="text" name="nomeProssefor">
	<input type="submit" value="gravar">
</form>

<h2>Listar Professores</h2>
<form action="listaProfessor">
	<input type="submit" value="Lista">
</form>

</body>
</html>