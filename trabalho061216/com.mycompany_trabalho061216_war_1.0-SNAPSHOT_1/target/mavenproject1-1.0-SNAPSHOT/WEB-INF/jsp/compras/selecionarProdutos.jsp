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
                    <h1 id="homeHeading">Efetuar compra do cliente: ${cliente.nome}</h1>                        
                </c:if>                    
            </div>
        </div>
    </header>

    <section class="bg-primary" id="about">
        <div class="container">
            <h2>Produtos</h2>                
            <div class="table-responsive">          
                <c:if test="${empty vetProduto}">
                    <h1 id="homeHeading">Sem produtos disponíveis</h1></c:if>
                    <table class="table">
                        <thead>                        
                            <tr>
                                <th>Código</th>     
                                <th>Descrição</th>  
                                <th>Preço</th>  
                                <th>Quantidade em estoque</th>                                                                 
                                <th> </th>                                                                
                            </tr>
                        </thead>
                        <form action="efetuarCompra">
                        <c:forEach var="produto" items="${vetProduto}">
                            <tr>
                                <td>${produto.id}</td>
                                <td>${produto.descricao}</td>                                                
                                <td>${produto.precoUnit}</td>                                               
                                <td>${produto.quantEstoque}</td>                                        
                                <td><input type="checkbox" name="List" value="${produto.id}"></td>
                            </tr>
                        </c:forEach>
                        <input type="hidden" name="id" value=${cliente.id}>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td><button type="submit" class="btn btn-default">Submit</button></td>
                    </form>
                </table>
            </div>
        </div>

    </section>