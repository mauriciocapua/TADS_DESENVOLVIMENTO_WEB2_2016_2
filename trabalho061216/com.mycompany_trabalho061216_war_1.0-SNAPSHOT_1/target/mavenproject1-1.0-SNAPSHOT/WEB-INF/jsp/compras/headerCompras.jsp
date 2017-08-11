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
            </c:if>

            <c:if test="${empty sessionScope.atendenteLogado}">
                <a class="navbar-brand page-scroll" href="/mavenproject1/atendente/efetuaLogin">Login</a>  
            </c:if>

            <c:if test="${!fn:contains(pageContext.request.requestURI, 'selecionarCliente.jsp')}">   

                <a class="navbar-brand page-scroll" href="http://localhost:8084/mavenproject1/atendente/selecionarCliente">Listar Compras/ Nova Compra</a>               
            </c:if> 
        </div>
    </div>
</nav>