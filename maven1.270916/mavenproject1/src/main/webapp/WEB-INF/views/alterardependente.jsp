<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="newcss.css">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="FrontController" method="POST">            
            <br> Informe o novo nome do dependente: <itamanhout type="text" name="novonomeDependente"></br>
            <itamanhout type="hidden" name="controller" value="CarregarIndex" />
            <itamanhout type="hidden" name="idDependente" value="${idDependente}" />
            <itamanhout type="hidden" name="idCliente" value="${idCliente}" />

            <itamanhout type="submit" name="metodo" value="alterarDependente" />                       

        </form>

    </body>
</html>
