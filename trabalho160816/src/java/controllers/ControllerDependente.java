/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import model.Cliente;
import model.Dependente;
import model.DependenteDAO;

public class ControllerDependente extends Controller {

    public List<Dependente> retornarDependentes(Cliente cliente) throws Exception {
        Connection con = (Connection) this.request.getAttribute("connection");

        List<Dependente> vetDependente = null;
        try {
            vetDependente = new DependenteDAO(con).listarDependentes(cliente);
//            this.request.setAttribute("vetDependente", vetDependente);
            //RequestDispatcher rd = request.getRequestDispatcher("/paginadependentes.jsp");
            //rd.forward(request, response);
        } catch (SQLException e) {
            // TODO Auto-generated catch block            
            System.out.println(e);
        }
        return vetDependente;
    }

    public void adicionarDependente(Cliente cliente, Dependente dependente) throws Exception {
        Connection con = (Connection) this.request.getAttribute("connection");
        
        DependenteDAO dependenteDAO = new DependenteDAO(con);
        try {
            dependenteDAO.adicionarDependente(dependente, cliente);
        } catch (SQLException e) {
            System.out.println(e);
//            RuntimeException(e);
        }

    }

    public void deletarDependente(Dependente dependente) throws Exception {
        Connection con = (Connection) this.request.getAttribute("connection");
        
        DependenteDAO dependenteDAO = new DependenteDAO(con);
        try {
            dependenteDAO.deletarDependente(dependente);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void alterarDependente(Dependente dependente) throws Exception {
        Connection con = (Connection) this.request.getAttribute("connection");
        
        DependenteDAO dependenteDAO = new DependenteDAO(con);
        try {
            dependenteDAO.alterarDependente(dependente);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
