/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import negocio.Cliente;
import negocio.Dependente;

public class CarregarIndex extends Controller {

    public String carregarPagina() {
        List<Cliente> vetCliente = null;
        try {
            vetCliente = Cliente.listarTodos();
            this.request.setAttribute("vetCliente", vetCliente);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Falha ao listar");
        }
        return "paginainicial";
    }

    public String adicionarDependente() throws Exception {
        if (request.getParameter("idCliente") != null && (request.getParameter("nomeDependente") != null && !request.getParameter("nomeDependente").isEmpty())) {
            int idCliente = Integer.parseInt(request.getParameter("idCliente"));
            String nomeDependente = request.getParameter("nomeDependente");
            Cliente.adicionarDependente(nomeDependente, idCliente);
            try {
                request.setAttribute("idCliente", idCliente);
                //request.getRequestDispatcher("FrontController?controller=CarregarIndex&metodo=listarDependentes").forward(request, response);
                return listarDependentes();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            //request.getRequestDispatcher("FrontController?controller=CarregarIndex&metodo=carregarPagina").forward(request, response);
            return listarDependentes();
        }
        return listarDependentes();
    }

    public String listarDependentes() {
        int idCliente = -1;
        if (this.request.getParameter("idCliente") != null) {
            idCliente = Integer.parseInt(request.getParameter("idCliente"));
        }
        Cliente cliente = null;
        List<Dependente> vetDependente = null;
        try {
            cliente = Cliente.listarCliente(idCliente);
            vetDependente = Cliente.listarDependentes(idCliente);
            this.request.setAttribute("Cliente", cliente);
            this.request.setAttribute("vetDependente", vetDependente);
            //RequestDispatcher rd = request.getRequestDispatcher("/paginadependentes.jsp");
            //rd.forward(request, response);
            return "paginadependentes";
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Listar dependentes falhou");
        }
        return "paginadependentes";
    }

    public String deletarDependente() throws Exception {
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        if (request.getParameter("idDependente") != null) {
            int idDependente = Integer.parseInt(request.getParameter("idDependente"));
            try {
                Cliente.deletarDependente(idDependente);
                request.setAttribute("idCliente", idCliente);
                //request.getRequestDispatcher("FrontController?controller=CarregarIndex&metodo=listarDependentes").forward(request, response);
                return listarDependentes();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            request.setAttribute("idCliente", idCliente);
            //request.getRequestDispatcher("FrontController?controller=CarregarIndex&metodo=listarDependentes").forward(request, response);
            return listarDependentes();
        }
        return listarDependentes();
    }

    public String alterarDependente() throws Exception {
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        if (request.getParameter("idDependente") != null
                && (request.getParameter("novonomeDependente") != null
                && !request.getParameter("novonomeDependente").isEmpty())) {
            int idDependente = Integer.parseInt(request.getParameter("idDependente"));
            String nomeDependente = request.getParameter("novonomeDependente");
            try {
                Cliente.alterarDependente(idDependente, nomeDependente);
                request.setAttribute("idCliente", idCliente);
                //request.getRequestDispatcher("FrontController?controller=CarregarIndex&metodo=listarDependentes").forward(request, response);
                return listarDependentes();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            request.setAttribute("idCliente", idCliente);
            request.setAttribute("idDependente", request.getParameter("idDependente"));
            //RequestDispatcher rd = request.getRequestDispatcher("/alterardependente.jsp");
            //rd.forward(request, response);
            //request.getRequestDispatcher("FrontController?controller=CarregarIndex&metodo=listarDependentes").forward(request, response);
            return "alterardependente";
        }
        return listarDependentes();
    }
}
