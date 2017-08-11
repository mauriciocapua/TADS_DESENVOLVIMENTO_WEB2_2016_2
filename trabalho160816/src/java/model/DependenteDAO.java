/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Dependente;

/**
 *
 * @author Mauricio Capua
 */
public class DependenteDAO {

    private Connection connection;

    public DependenteDAO(Connection con) {
        this.connection = con;
    }

    public DependenteDAO() {
    }

    public List<Dependente> listarTodosDependentes() throws Exception {
        List<Dependente> vetDependente = new ArrayList<>();
        String sql = "SELECT * FROM dependente";
        try (PreparedStatement sqlSelect = connection.prepareStatement(sql)) {
            ResultSet rs = sqlSelect.executeQuery();
            Dependente dependente;
            while (rs.next()) {
                dependente = new Dependente();
                dependente.setId(rs.getInt("id"));
                dependente.setNome(rs.getString("nome"));

                vetDependente.add(dependente);
            }
        }
        return vetDependente;
    }

    public List<Dependente> listarDependentes(Cliente cliente) throws Exception {
        List<Dependente> vetDependente = new ArrayList<>();
        String sql = "SELECT * FROM dependente WHERE id_cliente = ?;";
        try (PreparedStatement sqlSelect = connection.prepareStatement(sql)) {
            sqlSelect.setInt(1, cliente.getId());
            ResultSet rs = sqlSelect.executeQuery();
            Dependente dependente;
            while (rs.next()) {
                dependente = new Dependente();
                dependente.setId(rs.getInt("id"));
                dependente.setNome(rs.getString("nome"));

                vetDependente.add(dependente);
            }
        }

        return vetDependente;
    }

    public void adicionarDependente(Dependente dependente, Cliente cliente) throws Exception {

        String sql = "INSERT INTO dependente (nome,id_cliente) VALUES (?,?) RETURNING id;";
        try (PreparedStatement sqlInsert = connection.prepareStatement(sql)) {
            sqlInsert.setString(1, dependente.getNome());
            sqlInsert.setInt(2, cliente.getId());

            ResultSet rs = sqlInsert.executeQuery();
            if (rs.next()) {
            }
        }

    }

    public void deletarDependente(Dependente dependente) throws Exception {
        String sql = "DELETE FROM dependente WHERE id = ?;";
        try (PreparedStatement sqlDelete = connection.prepareStatement(sql)) {
            sqlDelete.setInt(1, dependente.getId());
            sqlDelete.executeUpdate();
        }
    }

    public void alterarDependente(Dependente dependente) throws Exception {
        String sql = "update dependente set nome = ? where id = ?;";
        try (PreparedStatement sqlUpdate = connection.prepareStatement(sql)) {
            sqlUpdate.setString(1, dependente.getNome());
            sqlUpdate.setInt(2, dependente.getId());
            sqlUpdate.executeUpdate();
        }
    }
}
