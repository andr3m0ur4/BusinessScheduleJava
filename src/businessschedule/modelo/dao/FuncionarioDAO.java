package businessschedule.modelo.dao;

import businessschedule.modelo.classes.Funcionario;
import businessschedule.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    public FuncionarioDAO() {
        con = new Conexao().getConexao();
    }
    
    public List<Funcionario> listar() {
        List<Funcionario> funcionarios = new ArrayList<>();
        String sql = "SELECT * FROM funcionario";
        
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Funcionario funcionario = new Funcionario(
                        rs.getInt("id"), rs.getString("nome"), rs.getString("email"), rs.getString("funcao")
                );
                funcionarios.add(funcionario);
            }
            
            rs.close();
            stmt.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        
        return funcionarios;
    }
    
    public Funcionario buscar(int id) {
        Funcionario funcionario = null;
        String sql = "SELECT * FROM funcionario WHERE id = ?";
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            rs.next();
            
            funcionario = new Funcionario(
                    rs.getInt("id"), rs.getString("nome"), rs.getString("email"), rs.getString("senha"), rs.getString("funcao")
            );
            
            rs.close();
            stmt.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        
        return funcionario;
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
            stmt.execute();
            stmt.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public void alterar(Funcionario funcionario) {
        String sql = "UPDATE funcionario SET nome = ?, senha = ?, funcao = ? WHERE id = ?";
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getSenha());
            stmt.setString(3, funcionario.getFuncao());
            stmt.setInt(4, funcionario.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public void excluir(Funcionario funcionario) {
        String sql = "DELETE FROM funcionario WHERE id = ?";
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, funcionario.getId());
            stmt.execute();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public int lastId() {
        int id = 0;
        String sql = "SELECT max(id) FROM funcionario";
        
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            rs.next();
            
            id = rs.getInt(1);
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        
        return id + 1;
    }
    
        public boolean login(String email ,String senha){
         
        boolean validacao = false;
        String sql = "SELECT * FROM funcionario WHERE email = ? AND senha = ?";
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            validacao = rs.next();
            return validacao;
          
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        
         return false;
         
    }
        
       public Funcionario buscarNomeFuncionario(String nome) {
        Funcionario funcionario = null;
        String sql = "SELECT * FROM funcionario WHERE nome = ?";
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            rs = stmt.executeQuery();
            if (rs.next()) {
                funcionario = new Funcionario(
                        rs.getInt("id"), rs.getString("nome"), rs.getString("email"), rs.getString("senha"), rs.getString("funcao")
                );
            }
            
            rs.close();
            stmt.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        
        return funcionario;
    }
}
