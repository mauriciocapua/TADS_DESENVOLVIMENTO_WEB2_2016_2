/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.Connection;
import java.util.List;
import model.Cliente;
import model.Dependente;
import model.ClienteDAO;

public class ControllerCliente extends Controller {

    public String carregarPagina() throws Exception {
        Connection con = (Connection) this.request.getAttribute("connection");

        List<Cliente> vetCliente = new ClienteDAO(con).listarTodos();
        this.request.setAttribute("vetCliente", vetCliente);

        return "paginainicial";
    }

    public String listarDependentes() throws Exception {
        Connection con = (Connection) this.request.getAttribute("connection");
        int idCliente = Integer.parseInt(this.request.getParameter("idCliente"));

        Cliente cliente = new Cliente();
        cliente.setId(idCliente);
        cliente = new ClienteDAO(con).listarCliente(cliente);
        //this.request.setAttribute("connection", con);

        ControllerDependente controllerDependente = new ControllerDependente();
        controllerDependente.setRequest(request);
        controllerDependente.setResponse(response);

        cliente.setDependentes(controllerDependente.retornarDependentes(cliente));
        this.request.setAttribute("Cliente", cliente);

        return "paginadependentes";
    }

    public String adicionarDependente() throws Exception {
        Connection con = (Connection) this.request.getAttribute("connection");
        int idCliente = Integer.parseInt(this.request.getParameter("idCliente"));

        if (this.request.getParameter("idCliente") != null && (this.request.getParameter("nomeDependente") != null && !this.request.getParameter("nomeDependente").isEmpty())) {
            Cliente cliente = new Cliente();
            cliente.setId(idCliente);
            Dependente dependente = new Dependente();
            dependente.setNome(this.request.getParameter("nomeDependente"));
            ControllerDependente controllerDependente = new ControllerDependente();
            controllerDependente.setRequest(request);
            controllerDependente.setResponse(response);
            controllerDependente.adicionarDependente(cliente, dependente);
        }
        this.request.setAttribute("idCliente", idCliente);
        return listarDependentes();
    }

    public String deletarDependente() throws Exception {
        Connection con = (Connection) request.getAttribute("connection");
        int idCliente = Integer.parseInt(this.request.getParameter("idCliente"));

        if (request.getParameter("idDependente") != null) {
            Dependente dependente = new Dependente();
            dependente.setId(Integer.parseInt(this.request.getParameter("idDependente")));
            ControllerDependente controllerDependente = new ControllerDependente();
            controllerDependente.setRequest(request);
            controllerDependente.setResponse(response);
            controllerDependente.deletarDependente(dependente);
        }
        this.request.setAttribute("idCliente", idCliente);
        return listarDependentes();
    }

    public String alterarDependente() throws Exception {
        Connection con = (Connection) request.getAttribute("connection");
        int idCliente = Integer.parseInt(this.request.getParameter("idCliente"));
        String pagina = null;

        if (this.request.getParameter("idDependente") == null) {
            pagina = listarDependentes();
        } else {
            if ((this.request.getParameter("novonomeDependente") != null
                    && !this.request.getParameter("novonomeDependente").isEmpty())) {

                Dependente dependente = new Dependente(Integer.parseInt(this.request.getParameter("idDependente")),
                        this.request.getParameter("novonomeDependente"));
                ControllerDependente controllerDependente = new ControllerDependente();
                controllerDependente.setRequest(request);
                controllerDependente.setResponse(response);
                controllerDependente.alterarDependente(dependente);
                pagina = listarDependentes();
            } else {

                this.request.setAttribute("idDependente", request.getParameter("idDependente"));
                pagina = "alterardependente";
//            RequestDispatcher rd = request.getRequestDispatcher("/alterardependente.jsp");
//            rd.forward(request, response);
            }
        }

        this.request.setAttribute(
                "idCliente", idCliente);
        return pagina;
    }

}
