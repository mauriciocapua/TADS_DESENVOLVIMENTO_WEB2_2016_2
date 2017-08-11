/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import persistencia.*;
import java.sql.Connection;
import java.util.List;
import negocio.Cliente;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import persistencia.ClienteDAO;

@Controller
@RequestMapping("/cliente")
public class ControllerCliente {

    @RequestMapping("/")
    public String carregarPagina(Model m) throws Exception {

        Connection con = new ConnectionFactory().getConnection();

        List<Cliente> vetCliente = new ClienteDAO(con).listarTodos();
        m.addAttribute("cliente", vetCliente);

        return "paginainicial";
    }

}
