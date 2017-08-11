<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>

<jsp:include page="./baseHead.jsp"/>
<jsp:include page="./baseScripts.jsp"/>

<body id="page-top">


    <jsp:include page="./navbarHeader.jsp"/>

    <header>
        <div class="header-content">
            <div class="header-content-inner">                
                <form>
                    <div class="form-group">
                        <label for="login">Login:</label>                        
                        <input type="text" class="form-control" name="login" />
                    </div>
                    <div class="form-group">
                        <label for="password">Password:</label>
                        <input type="password" class="form-control" name="senha">
                    </div>                    
                    <button type="submit" class="btn btn-default">Submit</button>
                </form>

            </div>
        </div>
    </header>
</body>