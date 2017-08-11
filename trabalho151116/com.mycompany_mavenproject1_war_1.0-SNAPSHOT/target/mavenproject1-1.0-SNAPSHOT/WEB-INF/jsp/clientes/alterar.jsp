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
            <h3>Descreva os novos dados do cliente:</h3>
            Nome: <input type=text name=nome value="${cliente.nome}">            
            <form:errors path="cliente.nome"></form:errors>   <br>                                             
            Cpf: <input type=text name=cpf value="${cliente.cpf}">            
            <form:errors path="cliente.cpf"></form:errors>   <br>   
            Login: <input type=text name=login value="${cliente.login}">            
            <form:errors path="cliente.login"></form:errors>   <br>                   
            Senha: <input type=password name=senha value="${cliente.senha}">            
            <form:errors path="cliente.senha"></form:errors>   <br>   
                <br>
                <input type="hidden" name="id" value="${cliente.id}" /> 
            <input type="submit">

        </form>


    </body>
</html>
