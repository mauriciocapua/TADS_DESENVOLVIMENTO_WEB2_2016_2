<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Todos os Professores</title>
</head>
<body>
${id.id}
<table border='1'>
	<c:forEach var="p" items="${professores}">
		<tr>
			<td>
			<a href="listaDisciplinas?idProfessor=${p.idProfessor}">
						${p.nomeProssefor}
			</a>
			</td>
			<td> <a href="excluirProfessor?id=${p.idProfessor}">Excluir</a></td>
			<td> <a href="editarProfessor?id=${p.idProfessor}">Editar</a></td>
		</tr>
	</c:forEach>
</table>
<a href="index.jsp">Volte</a>
</body>
</html>