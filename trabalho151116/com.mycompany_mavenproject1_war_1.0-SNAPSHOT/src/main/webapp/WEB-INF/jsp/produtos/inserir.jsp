<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="adicionar" method="POST" id="1" enctype="multipart/form-data">


            <h3>Descreva o novo produto:</h3>
            Descricao: <input type=text name=descricao value="${produto.descricao}">            
            <form:errors path="produto.descricao"></form:errors>   <br>                                             
            Preço: <input type=text name=precoUnit value="${produto.precoUnit}">            
            <form:errors path="produto.precoUnit"></form:errors>   <br>                                             
            Quantidade:<input type=number name=quantEstoque min="0" max="100" value="${produto.quantEstoque}">            
            <form:errors path="produto.quantEstoque"></form:errors>   <br>                                             
            <br>
            Imagem: <input type="file" name="file"/><br>

            <input type="submit" name="inserir"><input type="reset">
        </form>
    </body>
</html>
