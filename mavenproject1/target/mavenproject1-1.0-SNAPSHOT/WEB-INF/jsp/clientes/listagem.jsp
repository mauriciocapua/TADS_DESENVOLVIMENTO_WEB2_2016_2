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
        <c:forEach var="cliente" items="${vetCliente}">
        <tr>                       
            <td><input type=text name=nome value="${cliente.nome}"></td>                                                
            <!--<td><input type=radio name=idDependente value="${cliente.id}"></td>-->
            <td><a href="deletar?idCliente=${cliente.id}"><button>Deletar</button></a></td>
            <td><a href="alterar?idCliente=${cliente.id}"><button>Alterar</button></a></td>
        <br>
    </tr>
</c:forEach>

</form>

<!--<a href="listar"><button>Listar</button></a>-->
</body>
</html>
