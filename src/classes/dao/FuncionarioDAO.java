package classes.dao;

import classes.Funcionario;
import config.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FuncionarioDAO {
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    public FuncionarioDAO() {
        con = new Conexao().getConexao();
    }
    
    public void inserir(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario VALUES(?, ?, ?, ?, ?)";
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, funcionario.getId());
            stmt.setString(2, funcionario.getNome());
            stmt.setString(3, funcionario.getEmail());
            stmt.setString(4, funcionario.getSenha());
            stmt.setString(5, funcionario.getFuncao());
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
}
