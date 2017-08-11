/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Mauricio Capua
 */
public class ConnectionFactory {

    public Connection getConnection() throws Exception {
        //NecessÃ¡rio adicionar o jar do sgbd no buildpath do projeto

        //string url deve ser modificada para conectar com mysql
        String url = "jdbc:postgresql://localhost/db_cadastro";
        String usuario = "postgres";
        String senha = "123";
        Class.forName("org.postgresql.Driver");

        return DriverManager.getConnection(
                url,
                usuario,
                senha);
    }

}
