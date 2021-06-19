package config;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class Conexao {
    public Connection getConexao() {
        try {
            return DriverManager.getConnection("jdbc:sqlite:.\\db\\business_schedule.db");
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }
}
