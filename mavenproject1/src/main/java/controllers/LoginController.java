/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.Connection;
import javax.servlet.http.HttpSession;
import model.Cliente;
import model.ClienteDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import persistencia.ConnectionFactory;

/**
 *
 * @author Mauricio Capua
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("loginForm")
    public String loginForm() {
        return "formulario-login";
    }

    @RequestMapping("efetuaLogin")
    public String efetuaLogin(Cliente usuario, HttpSession session) throws Exception {
        Connection con = new ConnectionFactory().getConnection();

        if (new ClienteDAO(con).verificaLogin(usuario) != null) {
            usuario = new ClienteDAO(con).verificaLogin(usuario);
            session.setAttribute("usuarioLogado", usuario);
            return "redirect:/produto/";
        }
        return "redirect:formulario-login";
    }

    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/produto/";
    }
}
