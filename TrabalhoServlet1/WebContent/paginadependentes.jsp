<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!--  -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>                	
           <c:forEach var="dependente" items="${vetDependente}">
           			<td><input type=text name=nomeCliente value="${cliente.nome}"></td>									
					<td><input type=text name=nomeDependente value="${dependente.nome}"></td>
					<td><input type=text name=idCliente value="${dependente.id_cliente}"></td>
					<td><input type=radio name=codigo value="${dependente.id}"></td>				
			</c:forEach>
    </body>
</html>
