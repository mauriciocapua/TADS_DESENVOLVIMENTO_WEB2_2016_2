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
                <form action="adicionar" method="POST" id="1" enctype="multipart/form-data>
                      <h3>Descreva o novo produto:</h3>
                      <div class="form-group">
                      <label for="descricao">Descrição:</label>                        
                    <form:errors path="produto.descricao"></form:errors>   <br>                                             
                    <input type="text" class="form-control" name="descricao" value="${produto.descricao}"/>
            </div>
            <div class="form-group">
                <label for="precoUnit">Preço:</label>
                <form:errors path="produto.precoUnit"></form:errors>   <br>                                             
                <input type="text" class="form-control" name="precoUnit" value="${produto.precoUnit}">
            </div>                    
            <div class="form-group">
                <label for="quantEstoque">Quantidade Estoque:</label>
                <form:errors path="produto.quantEstoque"></form:errors>   <br>                                             
                <input type="text" class="form-control" name="quantEstoque" value="${produto.quantEstoque}">
            </div>
            <!--            <div class="form-group">
                            <label for="imagem">Imagem:</label>
                            <input type="file" class="form-control" name="file">
                        </div>-->


            <button type="submit" class="btn btn-default">Submit</button>

            </form>
        </div>
    </div>
</header>


