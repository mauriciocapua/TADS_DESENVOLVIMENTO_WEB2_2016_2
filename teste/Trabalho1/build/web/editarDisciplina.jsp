<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Atualiza Disciplina</title>
</head>
<body>

<form action="atualizaDisciplina" method="post">

	<input type="hidden" name="codigoDisciplina" value="${disciplina.codigoDisciplina}">
	<input type="hidden" name="idProfessor" value="${disciplina.idProfessor}">

	Nome Disciplina<input type="text" name="discilpinaNome" value="${disciplina.discilpinaNome}">


	<input type="submit" value="atualiza">
</form>
<a href="index.jsp">Volte</a>
</body>
</html>