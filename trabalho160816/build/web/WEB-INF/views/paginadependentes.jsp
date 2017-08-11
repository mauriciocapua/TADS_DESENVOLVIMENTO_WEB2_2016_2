<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--<link rel="stylesheet" type="text/css" href="../newcss.css">-->
        <title>JSP Page</title>
    </head>
    <body>
        <a href="FrontController?controller=ControllerCliente&metodo=carregarPagina"><button>Página Inicial</button></a>
        <br></br>
        <table border="1">   
            <tr><td colspan = "1">Cliente</td></tr>            
            <td> Nome Cliente </td>
            <tr>
                <td>${Cliente.nome}</td>
            </tr>
        </table>
        <br>

        <form action="FrontController" method="POST" id="front">
            <table border="1">          
                <tr><td colspan = "1">Lista de Dependentes</td></tr>         
                <td> Nome Dependentes </td>
                <c:forEach var="dependente" items="${Cliente.dependentes}">
                    <tr>                       
                        <td><input type=text name=nome value="${dependente.nome}"></td>                                                
                        <td><input type=radio name=idDependente value="${dependente.id}"></td>
                    </tr>
                </c:forEach>
            </table>           
            <button type="submit" form="front" name="metodo" value="deletarDependente">Deletar Dependentes</button>
            <button type="submit" form="front" name="metodo" value="alterarDependente">Alterar Dependentes</button>
            <input type="hidden" name="controller" value="ControllerCliente" />
            <input type="hidden" name="idCliente" value="${Cliente.id}">            
            <!--<button type="submit" form="form1" name="metodo" value="carregarPagina">Index</button>-->
            <!--            <input type="submit" name="metodo" value="deletarDependente" />
                       <input type="submit" name="metodo" value="alterarDependente" />-->
        </form>

        <!--<form method="POST" action="FrontController" id="form1">-->
        <!--<input type="submit" name="metodo" value="carregarPagina" />-->
        <!--<input type="hidden" name="controller" value="ControllerCliente" />-->
        <!--</form>-->

    </body>
</html>
