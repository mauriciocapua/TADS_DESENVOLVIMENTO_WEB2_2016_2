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
            //cliente.setId(rs.getInt("id"));
            cliente.setNome(rs.getString("nome"));
        }
        sqlSelect.close();
        return cliente;
    }

}
