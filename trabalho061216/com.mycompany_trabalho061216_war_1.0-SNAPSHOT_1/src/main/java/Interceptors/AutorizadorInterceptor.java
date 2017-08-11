/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Atendente;
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
        
//        Atendente atendente = new Atendente();
//        atendente.setNome("joao");
//        request.getSession().setAttribute("atendenteLogado", atendente);
        if (request.getSession().getAttribute("atendenteLogado") != null) {
            return true;
        }

        if (uri.endsWith("loginForm")
                || uri.endsWith("efetuaLogin")
                || uri.contains("resources") || uri.endsWith("/mavenproject1/produto/listarProdutos")
                || uri.endsWith("/mavenproject1/cliente/listarClientes") || uri.contains("arquivo")
                || uri.contains("resources")) {
            return true;
        }

        response.sendRedirect("/mavenproject1/atendente/efetuaLogin");
        return false;
    }
}
