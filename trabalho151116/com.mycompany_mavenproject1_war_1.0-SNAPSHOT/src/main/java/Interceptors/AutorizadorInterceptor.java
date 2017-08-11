/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interceptors;

import java.util.logging.Handler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author Mauricio Capua
 */
public class AutorizadorInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller) throws Exception {
        //caminhos que podem ser acessados sem login
        String uri = request.getRequestURI();
        System.out.println(uri);
        if (uri.endsWith("loginForm")
                || uri.endsWith("efetuaLogin")
                || uri.contains("resources") || uri.endsWith("/mavenproject1/produto/listarProdutos")
                || uri.endsWith("/mavenproject1/cliente/listarClientes")) {
            //response.sendRedirect("listarProdutos");
            return true;
        }
        if (request.getSession().getAttribute("usuarioLogado") != null) {
            return true;
        }
        response.sendRedirect("/mavenproject1/login/efetuaLogin");
        return false;
    }
}
