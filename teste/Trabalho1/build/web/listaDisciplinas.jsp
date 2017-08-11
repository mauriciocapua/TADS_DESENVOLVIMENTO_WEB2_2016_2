<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista Disciplina</title>
</head>
<body>
<h1>Listar Disciplinas </h1>
<table border='1'>
	<c:forEach var="d" items="${discilpinas}">
		<tr>
			<td>${d.discilpinaNome}</td><br>
			<td>${d.codigoDisciplina}</td>
			
			<td> <a href="excluirDisciplina?id=${d.codigoDisciplina}">Excluir</a></td>
			<td> <a href="editarDisciplina?codigoDisciplina=${d.codigoDisciplina}">Editar</a></td>
			
		</tr>
	</c:forEach>
</table>



<table border='1'>
<%-- <c:forEach var="d" items="${discilpinas}" begin="1" end="1"> --%>
<h2>Inserir Nova Disciplina</h2>
		<form action="adicionaDisciplina" method="post" >
    		Disciplina<input type="text" name="nome">
    		<input type="hidden" name="idProf" value="${idProfessor}">
    		<input type="submit" value="gravar">
		</form>
		</tr>
<%-- </c:forEach> --%>

<a href="index.jsp">Voltar</a>

</body>
</html>