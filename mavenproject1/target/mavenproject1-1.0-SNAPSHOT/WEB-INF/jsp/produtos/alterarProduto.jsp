<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--<link rel="stylesheet" type="text/css" href="newcss.css">-->
        <title>Alterar</title>
    </head>
    <body>
        <form action="update" method="POST">            
            Informe a nova descrição: <input type="text" name="descricao" value="${produto.descricao}">
            Informe o novo preço: <input type="text" name="preco" value="${produto.precoUnit}">
            Informe a nova quantidade em estoque: <input type="text" name="estoque" value="${produto.quantEstoque}">
            <input type="hidden" name="id" value="${produto.id}" />            
            <button type="submit" name="metodo" value="alterar">Alterar</button>
        </form>

    </body>
</html>
