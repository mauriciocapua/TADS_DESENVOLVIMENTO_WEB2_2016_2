<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--<link rel="stylesheet" type="text/css" href="newcss.css">-->
        <title>Alterar</title>
    </head>
    <body>
        <form action="update" method="POST" id="1">
            <h3>Descreva os novos valores do produto - ${produto.cod}:</h3>
            Descricao: <input type=text name=descricao value="${produto.descricao}">            
            <form:errors path="produto.descricao"></form:errors>   <br>                                             
            Preço: <input type=text name=precoUnit value="${produto.precoUnit}">            
            <form:errors path="produto.precoUnit"></form:errors>   <br>                                             
            Quantidade:<input type=number name=quantEstoque min="0" max="100" value="${produto.quantEstoque}">            
            <form:errors path="produto.quantEstoque"></form:errors>   <br>                                             
                <br>
                <input type="hidden" name="cod" value="${produto.cod}" /> 
            <input type="submit">

        </form>


    </body>
</html>
