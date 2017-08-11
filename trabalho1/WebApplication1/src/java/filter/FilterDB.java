/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import persistencia.ConnectionFactory;

/**
 *
 * @author Mauricio Capua
 */
public class FilterDB implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//       Connection connection = null;
//        try {
//            ConnectionFactory conexao = new ConnectionFactory();
//            connection = conexao.getConnection();
//            request.setAttribute("connection", connection);
//            System.out.println("Iniciando conexão com o banco");
//            chain.doFilter(request, response);
//            System.out.println("Fechando conexão com o banco");
//            connection.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        Connection connection = null;
        try {
            connection = new ConnectionFactory().getConnection();
        } catch (Exception ex) {
            Logger.getLogger(FilterDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("connection", connection);
        chain.doFilter(request, response);
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(FilterDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
