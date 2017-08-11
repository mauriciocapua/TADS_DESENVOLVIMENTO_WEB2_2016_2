<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
<h1>Bem Vindo ${professor.nomeProssefor}</h1>

${professor.idProfessor}

<h2>Listar Disciplinas Ministradas</h2>
<form action="listaDisciplinas">
	<input type="text" name="nomeProssefor" value="${professor.nomeProssefor}">
	<input type="submit" value="Lista">
</form>

<a href="index.jsp">Volte</a>

</body>
</html>