<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!-- //tu esqueceu de adicionar essa taglib	também -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!--  -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="ListarDependentes" method="POST">
		Cliente: <select name="idCliente">
			<c:forEach var="cliente" items="${vetCliente}">
				<option value="${cliente.id}">${cliente.nome}</option>
			</c:forEach>			
			<br> Informe o nome do dependente: <input type="text" name="nomedependente"></br>
			 
		</select> <input type="submit" value="Carregar" />
	</form>
</body>
</html>