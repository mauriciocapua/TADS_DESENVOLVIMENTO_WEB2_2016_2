<%-- 
    Document   : formulario-login
    Created on : 08/11/2016, 16:35:33
    Author     : Mauricio Capua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <h2>Página de Login</h2>
        <form action="efetuaLogin" method="post">
            Login: <input type="text" name="login" /> <br /> 
            Senha: <input type="password" name="senha" /> <br />
            <input type="submit" value="Entrar" /> 
        </form>
    </body>
</html>
