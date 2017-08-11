<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--<link rel="stylesheet" type="text/css" href="../newcss.css">-->
        <title>JSP Page</title>
    </head>
    <body>        
        <form action="adicionar" method="POST" id="1">

            <c:forEach var="cliente" items="${vetCliente}">
                <tr>                       
                    <td><input type=text name=nome_lista value="${cliente.nome}"></td>                                                
                        <form:errors path="cliente.nome"></form:errors>                                                
                    <br>
                            <!--<td><input type=radio name=idDependente value="${cliente.id}"></td>-->
                </tr>
            </c:forEach>
        </form>

        <!--<a href="listar"><button>Listar</button></a>-->
    </body>
</html>
