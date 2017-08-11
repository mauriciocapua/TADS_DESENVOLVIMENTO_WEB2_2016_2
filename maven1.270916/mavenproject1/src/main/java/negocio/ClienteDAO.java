/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.sql.Connection;
import persistencia.ConnectionFactory;

/**
 *
 * @author Mauricio Capua
 */
public class ClienteDAO {

    private Connection conexao;

    public ClienteDAO(ConnectionFactory conexao) {
        this.conexao = (Connection) conexao;
    }

    public ClienteDAO() throws Exception {
        conexao = new ConnectionFactory().getConnection();
    }
}
