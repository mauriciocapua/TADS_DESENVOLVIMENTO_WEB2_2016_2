<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<nav id="mainNav" class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->

        <div class="navbar-header">    
            <a class="navbar-brand page-scroll" href="http://localhost:8084/mavenproject1/">Index</a>                                    

            <c:if test="${!empty sessionScope.atendenteLogado}">
                <a class="navbar-brand page-scroll" href="/mavenproject1/atendente/logout">Logout</a>   
                <c:if test="${fn:contains(pageContext.request.requestURI, 'listar.jsp')}"> 
                    <a class="navbar-brand page-scroll" href="redirect?url=inserir">Adicionar novo Produto</a> 
                </c:if>
            </c:if>

            <c:if test="${empty sessionScope.atendenteLogado}">
                <a class="navbar-brand page-scroll" href="/mavenproject1/atendente/efetuaLogin">Login</a>                  
            </c:if>

            <c:if test="${!fn:contains(pageContext.request.requestURI, 'listar.jsp')}">   
                <a class="navbar-brand page-scroll" href="http://localhost:8084/mavenproject1/produto/listarProdutos">Gerenciar Produtos</a>

            </c:if> 
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">                   
                <li>
                    <a class="page-scroll" href="http://localhost:8084/mavenproject1/cliente/listarClientes">Gerenciar Clientes</a>               
                </li>
            </ul>
        </div> 
    </div>
</nav>