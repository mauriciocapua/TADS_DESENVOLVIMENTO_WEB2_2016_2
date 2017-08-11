<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--<link rel="stylesheet" type="text/css" href="../newcss.css">-->
        <title>JSP Page</title>
    </head>
    <body>      
        <a href="<c:url value="/" />"><button>INDEX</button></a> 
        <c:if test="${!empty sessionScope.usuarioLogado}">                    
            <h2>Bem vindo ${sessionScope.usuarioLogado.nome} <a href="/mavenproject1/login/logout"><button>LOGOUT</button></a></h2> 
            <a href="redirect?url=inserir"><button>Adicionar novo cliente</button></a>            
        </c:if>

        <table border="3">
            <tr><td>CLIENTE</td></tr>  
            <td>NOME</td>
            <td>CPF</td>
            <td>LOGIN</td>

            <c:forEach var="cliente" items="${vetCliente}">                
                <tr>
                    <td>${cliente.nome}</td>                                                
                    <td>${cliente.cpf}</td>                                               
                    <td>${cliente.login}</td>
                    <c:if test="${!empty sessionScope.usuarioLogado}">                    
                        <td><a href="deletar?id=${cliente.id}"><button>Deletar</button></a></td>
                        <td><a href="alterar?id=${cliente.id}&nome=${cliente.nome}&cpf=${cliente.cpf}&login=${cliente.login}"><button>Alterar</button></a></td></tr>                    

                </c:if> 
            </c:forEach>
            <c:if test="${empty sessionScope.usuarioLogado}">
                <tr><a href="/mavenproject1/login/efetuaLogin"><button>LOGIN</button></a></td></tr>
            </c:if>
</table>
</body>
</html>
