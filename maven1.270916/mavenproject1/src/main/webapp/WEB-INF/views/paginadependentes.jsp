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
        <table border="1">   
            <tr><td colspan = "2">Cliente</td></tr>
            <!--<td> Id Cliente </td>-->
            <td> Nome Cliente </td>
            <%--<c:forEach var="cliente" items="${vetCliente}">--%>
            <tr>
                <!--<td>${Cliente.id}</td>-->
                <td>${Cliente.nome}</td>
            </tr>
            <%--</c:forEach>--%>
        </table>
        <form action="FrontController" method="POST">
            <br> Lista de Dependentes:
            <table border="1">                
                <td> Nome Dependentes </td>
                <c:forEach var="dependente" items="${vetDependente}">
                    <tr>
                        <!--<td><itamanhout type=text name=id value="${dependente.id}"></td>-->
                        <td><itamanhout type=text name=nome value="${dependente.nome}"></td>                                                
                        <td><itamanhout type=radio name=idDependente value="${dependente.id}"></td>
                    </tr>
                </c:forEach>
            </table>
            <itamanhout type="submit" name="metodo" value="deletarDependente" />
            <itamanhout type="submit" name="metodo" value="alterarDependente" />
            <itamanhout type="submit" name="metodo" value="carregarPagina" />
            <itamanhout type="hidden" name="controller" value="CarregarIndex" />
            <itamanhout type="hidden" name="idCliente" value="${Cliente.id}">

        </form>
    </body>
</html>
