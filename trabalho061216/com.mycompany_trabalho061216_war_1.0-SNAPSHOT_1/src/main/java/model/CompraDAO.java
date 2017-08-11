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
public class CompraDAO {

    private Connection connection;

    @Autowired
    public CompraDAO(DataSource dataSource) {
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Compra inserir(Compra compra) {
        try {
            String sql = "INSERT INTO compra (id_cliente) VALUES (?) RETURNING id, data_compra;";
            PreparedStatement sqlInsert = connection.prepareStatement(sql);
            sqlInsert.setInt(1, compra.getCliente().getId());
            ResultSet rs = sqlInsert.executeQuery();
            if (rs.next()) {
                compra.setId(rs.getInt("id"));
                compra.setData(rs.getTimestamp("data_compra"));
            }
            rs.close();
            return compra;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void inserirItem(Compra compra, Item item) {
        try {
            String sql = "INSERT INTO item (id_compra, id_produto, preco_compra, quantidade_compra) VALUES (?,?,?,?)";
            PreparedStatement sqlInsert = connection.prepareStatement(sql);
            sqlInsert.setInt(1, compra.getId());
            sqlInsert.setInt(2, item.getProduto().getId());
            sqlInsert.setFloat(3, item.getProduto().getPrecoUnit());
            sqlInsert.setInt(4, item.getQuantidadeCompra());
            sqlInsert.execute();
            sqlInsert.close();
            atualizaEstoqueProduto(item.getProduto(), item.getQuantidadeCompra());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizaEstoqueProduto(Produto produto, int quantidadeComprada) {
        try {
            String sql = "update produto set quant_estoque = ? where id = ?;";
            PreparedStatement sqlUpdate = connection.prepareStatement(sql);
            sqlUpdate.setInt(1, produto.getQuantEstoque() - quantidadeComprada);
            sqlUpdate.setInt(2, produto.getId());
            sqlUpdate.executeUpdate();
            sqlUpdate.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Compra> listarCompras(Cliente cliente) {
        try {
            List<Compra> vetCompra = new ArrayList<>();
            String sql = "SELECT * FROM compra where id_cliente = ?";
            PreparedStatement sqlSelect = connection.prepareStatement(sql);
            sqlSelect.setInt(1, cliente.getId());
            ResultSet rs = sqlSelect.executeQuery();
            Compra compra = null;
            while (rs.next()) {
                compra = new Compra();
                compra.setId(rs.getInt("id"));
                compra.setData(rs.getTimestamp("data_compra"));
                vetCompra.add(compra);
            }
            sqlSelect.close();
            return vetCompra;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Item> listarItens(Compra compra) {
        try {
            List<Item> vetItem = new ArrayList<>();
            String sql = "select item.preco_compra, item.quantidade_compra, produto.descricao, produto.imagem from item inner join produto on (item.id_produto = produto.id) inner join compra on (item.id_compra = compra.id) where compra.id = ?";
            PreparedStatement sqlSelect = connection.prepareStatement(sql);
            sqlSelect.setInt(1, compra.getId());
            ResultSet rs = sqlSelect.executeQuery();
            Item item = null;
            Produto produto = null;
            while (rs.next()) {
                item = new Item();
                produto = new Produto();
                produto.setDescricao(rs.getString("descricao"));
                produto.setImagem(rs.getString("imagem"));
                item.setProduto(produto);
                item.setPrecoCompra(rs.getInt("preco_compra"));
                item.setQuantidadeCompra(rs.getInt("quantidade_compra"));
                vetItem.add(item);
            }
            sqlSelect.close();
            return vetItem;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
