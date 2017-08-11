<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Atualiza Professor</title>
</head>
<body>

<h1>Atualize seu Nome  </h1>



<form action="atualizaProfessor" method="post">
<input type="hidden" name="id" value="${professor.idProfessor}">
Nome<input type="text" name="nomeProssefor" value="${professor.nomeProssefor}">
	
	<input type="submit" value="atualiza">
</form>
<a href="index.jsp">Volte</a>
</body>
</html>