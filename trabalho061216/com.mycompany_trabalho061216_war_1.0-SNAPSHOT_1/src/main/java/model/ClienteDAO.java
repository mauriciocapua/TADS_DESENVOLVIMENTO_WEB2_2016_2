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
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mauricio Capua
 */
@Repository
public class ClienteDAO {

    private Connection connection;

    @Autowired
    public ClienteDAO(DataSource dataSource) {
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Cliente> listarTodos() {
        try {
            List<Cliente> vetCliente = new ArrayList<>();
            String sql = "SELECT * FROM cliente order by id";
            PreparedStatement sqlSelect = connection.prepareStatement(sql);
            ResultSet rs = sqlSelect.executeQuery();
            Cliente cliente;
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                vetCliente.add(cliente);
            }
            sqlSelect.close();
            return vetCliente;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Cliente listarCliente(Cliente cliente) {
        try {
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void inserir(Cliente cliente) {
        try {
            String sql = "INSERT INTO cliente (nome,cpf) VALUES (?,?)";
            PreparedStatement sqlInsert = connection.prepareStatement(sql);
            sqlInsert.setString(1, cliente.getNome());
            sqlInsert.setString(2, cliente.getCpf());
            sqlInsert.execute();
            sqlInsert.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void deletarCliente(Cliente cliente) {
        try {
            String sql = "DELETE FROM cliente WHERE id = ?;";
            PreparedStatement sqlDelete = connection.prepareStatement(sql);
            sqlDelete.setInt(1, cliente.getId());
            sqlDelete.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void alterarCliente(Cliente cliente) {
        try {
            String sql = "update cliente set nome=? , cpf  = ? where id = ?;";
            PreparedStatement sqlUpdate = connection.prepareStatement(sql);
            sqlUpdate.setString(1, cliente.getNome());
            sqlUpdate.setString(2, cliente.getCpf());
            sqlUpdate.setInt(3, cliente.getId());
            sqlUpdate.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
