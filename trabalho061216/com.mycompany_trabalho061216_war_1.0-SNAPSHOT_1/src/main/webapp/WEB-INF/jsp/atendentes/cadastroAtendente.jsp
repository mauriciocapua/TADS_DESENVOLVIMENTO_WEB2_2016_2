<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>

<jsp:include page="../base.jsp"/>

<body id="page-top">
    <nav id="mainNav" class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid">        
            <div class="navbar-header">                
                <a class="navbar-brand page-scroll" href="<c:url value="/"/>">Index</a>                               
            </div>        
        </div>        
    </nav>

    <header>
        <div class="header-content">
            <div class="header-content-inner">                
                <form action="adicionar" method="POST" id="1">
                    <h3>Descreva os dados do atendente:</h3>
                    <div class="form-group">
                        <label for="nome">Nome:</label>  
                        <form:errors path="atendente.nome"></form:errors>   <br>                                             
                        <input type="text" class="form-control" name="nome" value="${atendente.nome}"/>
                    </div>
                    <div class="form-group">
                        <label for="login">Login:</label>  
                        <form:errors path="atendente.login"></form:errors>   <br>                                             
                        <input type="text" class="form-control" name="login" value="${atendente.login}"/>
                    </div>
                    <div class="form-group">
                        <label for="senha">Senha:</label>
                        <form:errors path="atendente.senha"></form:errors>   <br>                                             
                        <input type="password" class="form-control" name="senha" value="">
                    </div>                    

                    <button type="submit" class="btn btn-default">Submit</button>
                </form>
            </div>
        </div>
    </header>


