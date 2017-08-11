/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mauricio Capua
 */
public class ClienteDAO {

    private Connection connection;

    public ClienteDAO(Connection con) {
        this.connection = con;
    }

    public List<Cliente> listarTodos() throws Exception {
        List<Cliente> vetCliente = new ArrayList<>();
        String sql = "SELECT * FROM cliente order by id";
        PreparedStatement sqlSelect = connection.prepareStatement(sql);
        ResultSet rs = sqlSelect.executeQuery();
        Cliente cliente;
        while (rs.next()) {
            cliente = new Cliente();
            cliente.setId(rs.getInt("id"));
            cliente.setNome(rs.getString("nome"));
            vetCliente.add(cliente);
        }
        sqlSelect.close();
        return vetCliente;
    }

    public Cliente listarCliente(Cliente cliente) throws Exception {
        String sql = "SELECT * FROM cliente where id = ?";
        PreparedStatement sqlSelect = connection.prepareStatement(sql);
        sqlSelect.setInt(1, cliente.getId());
        ResultSet rs = sqlSelect.executeQuery();
        while (rs.next()) {
            //cliente = new Cliente();
//            cliente.setId(rs.getInt("id"));
            cliente.setNome(rs.getString("nome"));
        }
        sqlSelect.close();
        return cliente;
    }

    public void inserir(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO cliente (nome) VALUES (?) RETURNING id;";
        try (PreparedStatement sqlInsert = connection.prepareStatement(sql)) {
            sqlInsert.setString(1, cliente.getNome());
            ResultSet rs = sqlInsert.executeQuery();
            if (rs.next()) {
            }
        }
    }

    public void deletarCliente(Cliente cliente) throws Exception {
        String sql = "DELETE FROM cliente WHERE id = ?;";
        try (PreparedStatement sqlDelete = connection.prepareStatement(sql)) {
            sqlDelete.setInt(1, cliente.getId());
            sqlDelete.executeUpdate();
        }
    }

    public void alterarCliente(Cliente cliente) throws Exception {
        String sql = "update cliente set nome = ? where id = ?;";
        try (PreparedStatement sqlUpdate = connection.prepareStatement(sql)) {
            sqlUpdate.setString(1, cliente.getNome());
            sqlUpdate.setInt(2, cliente.getId());
            sqlUpdate.executeUpdate();
        }
    }

    public Cliente verificaLogin(Cliente cliente) throws Exception {
        String sql = "SELECT * FROM cliente where login=? and senha=?";
        PreparedStatement sqlSelect = connection.prepareStatement(sql);
        sqlSelect.setString(1, cliente.getLogin());
        sqlSelect.setString(2, cliente.getSenha());
        ResultSet rs = sqlSelect.executeQuery();
        Cliente cli = null;
        while (rs.next()) {
            cli = new Cliente();
            cli.setId(rs.getInt("id"));
            cli.setNome(rs.getString("nome"));
            cli.setLogin(rs.getString("login"));
            cli.setSenha(rs.getString("senha"));
        }
        sqlSelect.close();
        return cli;
    }

}
