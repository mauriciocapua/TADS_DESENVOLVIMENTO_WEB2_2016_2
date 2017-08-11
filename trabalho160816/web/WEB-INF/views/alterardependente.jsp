<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--<link rel="stylesheet" type="text/css" href="newcss.css">-->
        <title>JSP Page</title>
    </head>
    <body>
        <form action="FrontController" method="POST">            
            Informe o novo nome do dependente: <input type="text" name="novonomeDependente">
            <input type="hidden" name="idDependente" value="${idDependente}" />
            <input type="hidden" name="idCliente" value="${idCliente}" />
            <input type="hidden" name="controller" value="ControllerCliente" />
            <!--<input type="submit" name="metodo" value="alterarDependente" />-->  
            <button type="submit" name="metodo" value="alterarDependente">Alterar Dependente</button>
        </form>

    </body>
</html>
