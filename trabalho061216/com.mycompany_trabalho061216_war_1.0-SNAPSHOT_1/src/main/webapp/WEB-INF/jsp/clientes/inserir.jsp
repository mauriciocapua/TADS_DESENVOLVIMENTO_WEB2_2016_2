<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>

<jsp:include page="../base.jsp"/>

<body id="page-top">
    <jsp:include page="./headerClientes.jsp"/>


    <header>
        <div class="header-content">
            <div class="header-content-inner">                
                <form action="adicionar" method="POST" id="1">
                    <h3>Descreva os dados do cliente:</h3>
                    <div class="form-group">
                        <label for="nome">Nome:</label>  
                        <form:errors path="cliente.nome"></form:errors>   <br>                                             
                        <input type="text" class="form-control" name="nome" value="${cliente.nome}"/>
                    </div>
                    <div class="form-group">
                        <label for="cpf">CPF:</label>
                        <form:errors path="cliente.cpf"></form:errors>   <br>                                             
                        <input type="text" class="form-control" name="cpf" value="${cliente.cpf}">
                    </div>                    
                    <input type="hidden" name="id" value="${cliente.id}" /> 
                    <button type="submit" class="btn btn-default">Submit</button>
                </form>
            </div>
        </div>
    </header>


