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
public class ProdutoDAO {

    private Connection connection;

    @Autowired
    public ProdutoDAO(DataSource dataSource) {
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Produto> listarTodos() throws Exception {
        try {
            List<Produto> vetProduto = new ArrayList<>();
            String sql = "SELECT * FROM produto order by id";
            PreparedStatement sqlSelect = connection.prepareStatement(sql);
            ResultSet rs = sqlSelect.executeQuery();
            Produto produto;
            while (rs.next()) {
                produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPrecoUnit(rs.getFloat("preco_unit"));
                produto.setQuantEstoque(rs.getInt("quant_estoque"));
                vetProduto.add(produto);
            }
            sqlSelect.close();
            return vetProduto;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Produto> listarTodosDisponiveis() throws Exception {
        try {
            List<Produto> vetProduto = new ArrayList<>();
            String sql = "SELECT * FROM produto where quant_estoque != 0 order by id";
            PreparedStatement sqlSelect = connection.prepareStatement(sql);
            ResultSet rs = sqlSelect.executeQuery();
            Produto produto;
            while (rs.next()) {
                produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPrecoUnit(rs.getFloat("preco_unit"));
                produto.setQuantEstoque(rs.getInt("quant_estoque"));
                vetProduto.add(produto);
            }
            sqlSelect.close();
            return vetProduto;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Produto listarProduto(Produto produto) {
        try {
            String sql = "SELECT * FROM produto where id = ?";
            PreparedStatement sqlSelect = connection.prepareStatement(sql);
            sqlSelect.setInt(1, produto.getId());
            ResultSet rs = sqlSelect.executeQuery();
            Produto produto_retorno = null;
            while (rs.next()) {
                produto_retorno = new Produto();
                produto_retorno.setId(rs.getInt("id"));
                produto_retorno.setDescricao(rs.getString("descricao"));
                produto_retorno.setPrecoUnit(rs.getInt("preco_unit"));
                produto_retorno.setQuantEstoque(rs.getInt("quant_estoque"));
                produto_retorno.setImagem(rs.getString("imagem"));
            }
            sqlSelect.close();
            return produto_retorno;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void inserir(Produto produto) {
        try {
            String sql = "INSERT INTO produto (descricao,preco_unit,quant_estoque) VALUES (?,?,?)";
            PreparedStatement sqlInsert = connection.prepareStatement(sql);
            sqlInsert.setString(1, produto.getDescricao());
            sqlInsert.setFloat(2, produto.getPrecoUnit());
            sqlInsert.setInt(3, produto.getQuantEstoque());
            sqlInsert.execute();
            sqlInsert.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletarProduto(Produto produto) {
        try {
            String sql = "DELETE FROM produto WHERE id = ?;";
            PreparedStatement sqlDelete = connection.prepareStatement(sql);
            sqlDelete.setInt(1, produto.getId());
            sqlDelete.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void alterarProduto(Produto produto) {
        try {
            String sql = "update produto set descricao = ? ,preco_unit = ? , quant_estoque = ? where id = ?;";
            PreparedStatement sqlUpdate = connection.prepareStatement(sql);
            sqlUpdate.setString(1, produto.getDescricao());
            sqlUpdate.setFloat(2, produto.getPrecoUnit());
            sqlUpdate.setInt(3, produto.getQuantEstoque());
            sqlUpdate.setInt(4, produto.getId());
            sqlUpdate.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
