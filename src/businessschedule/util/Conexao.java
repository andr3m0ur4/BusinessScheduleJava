package businessschedule.util;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class Conexao {
    public Connection getConexao() {
        try {
            String path = "db/business_schedule.db";
            //String path = "lib/business_schedule.db";
            return DriverManager.getConnection("jdbc:sqlite:" + path);
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }
}
