package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    //retorna um objeto do tipo Connection

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
