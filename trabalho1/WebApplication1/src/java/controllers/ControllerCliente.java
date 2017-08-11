/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.Connection;
import java.util.List;
import negocio.Cliente;
import persistencia.ClienteDAO;
import persistencia.ConnectionFactory;

/**
 *
 * @author Mauricio Capua
 */
public class ControllerCliente extends Controller {

    public String carregarPagina() throws Exception {

        Connection con = (Connection) this.request.getAttribute("connection");
       

        List<Cliente> vetCliente = new ClienteDAO(con).listarTodos();
        this.request.setAttribute("vetCliente", vetCliente);

        return "paginainicial";
    }
}
