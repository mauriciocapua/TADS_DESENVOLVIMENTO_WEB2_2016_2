<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="<c:url value="cliente/listarClientes" />"><button>Clientes</button></a> 
        <a href="<c:url value="produto/listarProdutos" />"><button>Produtos</button></a>               
    </body>
</html>
