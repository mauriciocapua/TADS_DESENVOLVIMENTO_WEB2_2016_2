<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../newcss.css">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="FrontController" method="POST">
            Cliente: <select name="idCliente">
                <c:forEach var="cliente" items="${vetCliente}">
                    <option value="${cliente.id}">${cliente.nome}</option>
                </c:forEach><br>
            </select>
            <br> Informe o nome do dependente: <itamanhout type="text" name="nomeDependente"></br>
            <itamanhout type="submit" name="metodo" value="adicionarDependente" />            
            <itamanhout type="submit" name="metodo" value="listarDependentes" />
            <itamanhout type="hidden" name="controller" value="CarregarIndex" />
        </form>

    </body>
</html>
