<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="./formularioLoginModal.jsp"/>

<nav id="mainNav" class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->

        <div class="navbar-header">    
            <a class="navbar-brand page-scroll" href="http://localhost:8084/mavenproject1/">Index</a>                                    

            <c:if test="${!empty sessionScope.atendenteLogado}">
                <a class="navbar-brand page-scroll" href="/mavenproject1/atendente/logout">Logout</a>                          
            </c:if>

            <c:if test="${!fn:endsWith(pageContext.request.requestURI, 'formulario-login.jsp')}">   
                <c:if test="${empty sessionScope.atendenteLogado}">
                    <a class="navbar-brand page-scroll" data-toggle="modal" data-target="#myModal">Login</a>
                    <!--<a class="navbar-brand page-scroll" href="/mavenproject1/atendente/efetuaLogin">Login</a>-->  
                </c:if>
                <a class="navbar-brand page-scroll" href="http://localhost:8084/mavenproject1/atendente/selecionarCliente">Listar Compras/ Nova Compra</a>               
            </c:if> 
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">                

                <c:if test="${!fn:endsWith(pageContext.request.requestURI, 'formulario-login.jsp')}">
                    <li>
                        <a class="page-scroll" href="atendente/cadastroAtendente">Novo Atendente</a>
                    </li>       
                    <li>
                        <a class="page-scroll" href="cliente/listarClientes">Gerenciar Clientes</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="produto/listarProdutos">Gerenciar Produtos</a>
                    </li>
                </c:if> 

            </ul>
        </div>                
    </div>
</nav>