/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Auxiliar.StringUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mauricio Capua
 */
@Repository
public class AtendenteDAO {

    private Connection connection;

    @Autowired
    public AtendenteDAO(DataSource dataSource) {
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Atendente verificaLogin(Atendente atendente) {
        try {
            String sql = "SELECT * FROM atendente where login=? and senha=?";
            PreparedStatement sqlSelect = connection.prepareStatement(sql);
            sqlSelect.setString(1, atendente.getLogin());
            sqlSelect.setString(2, StringUtil.encripta(atendente.getSenha()));
            ResultSet rs = sqlSelect.executeQuery();
            Atendente aten = null;
            while (rs.next()) {
                aten = new Atendente();
                aten.setId(rs.getInt("id"));
                aten.setNome(rs.getString("nome"));
                aten.setLogin(rs.getString("login"));
                aten.setSenha(rs.getString("senha"));
            }
            sqlSelect.close();
            return aten;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void inserir(Atendente atendente) {
        try {
            String sql = "INSERT INTO atendente (login, senha, nome) VALUES (?,?,?)";
            PreparedStatement sqlInsert = connection.prepareStatement(sql);
            sqlInsert.setString(1, atendente.getLogin());
            sqlInsert.setString(2, StringUtil.encripta(atendente.getSenha()));
            sqlInsert.setString(3, atendente.getNome());
            sqlInsert.execute();
            sqlInsert.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
