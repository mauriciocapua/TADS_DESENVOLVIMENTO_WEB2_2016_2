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
public class ProdutoDAO {

    private Connection connection;

    public ProdutoDAO(Connection con) {
        this.connection = con;
    }

    public List<Produto> listarTodos() throws Exception {
        List<Produto> vetProduto = new ArrayList<>();
        String sql = "SELECT * FROM produto order by cod";
        PreparedStatement sqlSelect = connection.prepareStatement(sql);
        ResultSet rs = sqlSelect.executeQuery();
        Produto produto;
        while (rs.next()) {
            produto = new Produto();
            produto.setCod(rs.getInt("cod"));
            produto.setDescricao(rs.getString("descricao"));
            produto.setPrecoUnit(rs.getFloat("preco_unit"));
            produto.setQuantEstoque(rs.getInt("quant_estoque"));
            vetProduto.add(produto);
        }
        sqlSelect.close();
        return vetProduto;
    }

    public Produto listarProduto(Produto produto) throws Exception {
        String sql = "SELECT * FROM produto where cod = ?";
        PreparedStatement sqlSelect = connection.prepareStatement(sql);
        sqlSelect.setInt(1, produto.getCod());
        ResultSet rs = sqlSelect.executeQuery();
        while (rs.next()) {
            //produto = new Produto();
//            produto.setCod(rs.getInt("cod"));
            produto.setDescricao(rs.getString("descricao"));
        }
        sqlSelect.close();
        return produto;
    }

    public void inserir(Produto produto) throws SQLException {
        String sql = "INSERT INTO produto (descricao,preco_unit,quant_estoque) VALUES (?,?,?) RETURNING cod;";
        try (PreparedStatement sqlInsert = connection.prepareStatement(sql)) {
            sqlInsert.setString(1, produto.getDescricao());
            sqlInsert.setFloat(2, produto.getPrecoUnit());
            sqlInsert.setInt(3, produto.getQuantEstoque());
            ResultSet rs = sqlInsert.executeQuery();
//            if (rs.next()) {
//                
//            }
        } catch (RuntimeException e) {
            System.out.println("erro ao inserir");
        }
    }

    public void deletarProduto(Produto produto) throws Exception {
        String sql = "DELETE FROM produto WHERE cod = ?;";
        try (PreparedStatement sqlDelete = connection.prepareStatement(sql)) {
            sqlDelete.setInt(1, produto.getCod());
            sqlDelete.executeUpdate();
        } catch (RuntimeException e) {
            System.out.println("problema ao deletar");
        }
    }

    public void alterarProduto(Produto produto) throws Exception {
        String sql = "update produto set descricao = ? ,preco_unit = ? , quant_estoque = ? where cod = ?;";
        try (PreparedStatement sqlUpdate = connection.prepareStatement(sql)) {
            sqlUpdate.setString(1, produto.getDescricao());
            sqlUpdate.setFloat(2, produto.getPrecoUnit());
            sqlUpdate.setInt(3, produto.getQuantEstoque());
            sqlUpdate.setInt(4, produto.getCod());
            sqlUpdate.executeUpdate();
        }
    }
}
