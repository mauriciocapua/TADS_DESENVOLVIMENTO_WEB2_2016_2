<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>

<jsp:include page="../base.jsp"/>

<body id="page-top">
     <jsp:include page="./headerProdutos.jsp"/>

    <header>
        <div class="header-content">
            <div class="header-content-inner">
                <c:if test="${!empty sessionScope.atendenteLogado}">                        
                    <h1 id="homeHeading">Lista de Produtos</h1>                        
                </c:if>                    
            </div>
        </div>
    </header>

    <section class="bg-primary" id="about">
        <div class="container">
            <h2>Produtos</h2>                
            <div class="table-responsive">                          
                <c:forEach var="produto" items="${vetProduto}">    
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Código</th>
                                <th>Descrição</th>
                                <th>Preço</th>
                                <th>Quantidade em estoque</th>
                                <th> </th>
                                <th> </th>
                            </tr>
                            <tr>
                                <td>${produto.id}</td>                                                
                                <td>${produto.descricao}</td>                                                
                                <td>${produto.precoUnit}</td>                                               
                                <td>${produto.quantEstoque}</td>                                                  
                                <c:if test="${!empty sessionScope.atendenteLogado}">                    
                                    <td><a href="deletar?id=${produto.id}"><button>Deletar</button></a></td>
                                    <td><a href="alterar?id=${produto.id}&descricao=${produto.descricao}&precoUnit=${produto.precoUnit}&quantEstoque=${produto.quantEstoque}"><button>Alterar</button></a></td></tr>                    

                            </c:if>  
                            </tr>
                        </thead>                        
                    </table>
                </c:forEach>
            </div>
        </div>
    </section>
