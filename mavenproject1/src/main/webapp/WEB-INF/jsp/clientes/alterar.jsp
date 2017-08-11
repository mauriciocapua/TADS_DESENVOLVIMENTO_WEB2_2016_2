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
        <form action="update" method="POST">            
            Informe o novo nome: <input type="text" name="novonome">
            <input type="hidden" name="idCliente" value="${idCliente}" />            
            <button type="submit" name="metodo" value="alterar">Alterar</button>
        </form>

    </body>
</html>
