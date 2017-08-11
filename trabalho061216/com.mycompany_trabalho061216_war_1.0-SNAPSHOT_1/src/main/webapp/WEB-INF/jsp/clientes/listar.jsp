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
                <c:if test="${!empty sessionScope.atendenteLogado}">                        
                    <h1 id="homeHeading">Lista de Clientes</h1>                        
                </c:if>                    
            </div>
        </div>
    </header>

    <section class="bg-primary" id="about">
        <div class="container">
            <h2>Clientes</h2>                
            <div class="table-responsive">                          
                <c:forEach var="cliente" items="${vetCliente}">    
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Nome</th>                                  
                                <th>CPF</th>    
                                <th> </th>
                                <th> </th>
                            </tr>
                            <tr>
                                <td>${cliente.nome}</td>
                                <td>${cliente.cpf}</td>                                
                                <c:if test="${!empty sessionScope.atendenteLogado}">                    
                                    <td><a href="deletar?id=${cliente.id}"><button>Deletar</button></a></td>
                                    <td><a href="alterar?id=${cliente.id}&nome=${cliente.nome}&cpf=${cliente.cpf}"><button>Alterar</button></a></td></tr>                    
                                </c:if>  
                            </tr>
                        </thead>                        
                    </table>
                </c:forEach>
            </div>
        </div>
    </section>

