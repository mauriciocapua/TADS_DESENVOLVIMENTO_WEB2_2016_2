<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--<link rel="stylesheet" type="text/css" href="../newcss.css">-->
        <title>JSP Page</title>
    </head>
    <body>        
        <form action="FrontController" method="POST" id="1">
            Cliente: <select name="idCliente">
                <c:forEach var="cliente" items="${vetCliente}">
                    <option value="${cliente.id}">${cliente.nome}</option>
                </c:forEach><br>
            </select>
            <br> Informe o nome do dependente: <input type="text" name="nomeDependente"></br>                       
            <button type="submit" form="1" name="metodo" value="adicionarDependente">Adicionar Dependentes</button>
            <button type="submit" form="1" name="metodo" value="listarDependentes">Listar Dependentes</button>
            <!--<input type="submit" name="metodo" value="adicionarDependente" />-->  
            <!--<input type="submit" name="metodo" value="listarDependentes" />-->            
            <input type="hidden" name="controller" value="ControllerCliente" />
        </form>

    </body>
</html>
