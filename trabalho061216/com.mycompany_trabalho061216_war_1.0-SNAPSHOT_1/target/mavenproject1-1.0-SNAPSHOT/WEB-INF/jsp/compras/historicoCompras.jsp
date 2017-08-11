<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>

<jsp:include page="../base.jsp"/>

<body id="page-top">

    <jsp:include page="./headerCompras.jsp"/>

    <header>
        <div class="header-content">
            <div class="header-content-inner">
                <c:if test="${!empty sessionScope.atendenteLogado}">                        
                    <h1 id="homeHeading">Lista de compras do cliente: ${vetCompra[0].cliente.nome}</h1>                        
                </c:if>                    
            </div>
        </div>
    </header>

    <section class="bg-primary" id="about">
        <div class="container">
            <h2>Compras</h2>                
            <div class="table-responsive">          
                <c:if test="${empty vetCompra}">
                    <h1 id="homeHeading">Ainda não efetuou compras</h1></c:if>
                <c:forEach var="compra" items="${vetCompra}">    
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Data da compra
                                <td>${compra.data}</td>
                                </th>                                    
                            </tr>
                            <tr>
                                <th>Produto</th>
                                <th>Preco</th>
                                <th>Quantidade vendida</th>                               
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="item" items="${compra.itens}">                
                                <tr>
                                    <td>${item.produto.descricao}</td>
                                    <td>${item.precoCompra}</td>                                               
                                    <td>${item.quantidadeCompra}</td>                                               
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:forEach>
            </div>
        </div>

    </section>