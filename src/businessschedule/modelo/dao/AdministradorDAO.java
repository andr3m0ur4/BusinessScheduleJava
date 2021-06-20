package businessschedule.modelo.dao;

import businessschedule.modelo.classes.Administrador;
import businessschedule.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdministradorDAO {
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    public AdministradorDAO() {
        con = new Conexao().getConexao();
    }
    
    public List<Administrador> listar() {
        List<Administrador> administradores = new ArrayList<>();
        String sql = "SELECT * FROM administrador";
        
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Administrador administrador = new Administrador(
                        rs.getInt("id"), rs.getString("nome"), rs.getString("email"), rs.getString("senha"), rs.getString("funcao")
                );
                administradores.add(administrador);
            }
            
            rs.close();
            stmt.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        
        return administradores;
    }
    
    public Administrador buscar(int id) {
        Administrador administrador = null;
        String sql = "SELECT * FROM administrador WHERE id = ?";
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                administrador = new Administrador(
                        rs.getInt("id"), rs.getString("nome"), rs.getString("email"), rs.getString("senha"), rs.getString("funcao")
                );
            }
            
            rs.close();
            stmt.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        
        return administrador;
    }
    
    public void inserir(Administrador administrador) {
        String sql = "INSERT INTO administrador VALUES(?, ?, ?, ?, ?)";
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, administrador.getId());
            stmt.setString(2, administrador.getNome());
            stmt.setString(3, administrador.getEmail());
            stmt.setString(4, administrador.getSenha());
            stmt.setString(5, administrador.getFuncao());
            stmt.execute();
            stmt.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public void alterar(Administrador administrador) {
        String sql = "UPDATE administrador SET nome = ?, senha = ?, funcao = ? WHERE id = ?";
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, administrador.getNome());
            stmt.setString(2, administrador.getSenha());
            stmt.setString(3, administrador.getFuncao());
            stmt.setInt(4, administrador.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public void excluir(Administrador administrador) {
        String sql = "DELETE FROM administrador WHERE id = ?";
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, administrador.getId());
            stmt.execute();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public int lastId() {
        int id = 0;
        String sql = "SELECT max(id) FROM administrador";
        
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
        String sql = "SELECT * FROM administrador WHERE email = ? AND senha = ?";
           
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
    
        public Administrador buscarNome(String nome) {
        Administrador administrador = null;
        String sql = "SELECT * FROM administrador LIKE nome = ?";
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, '%' + nome + '%');
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                administrador = new Administrador(
                    rs.getInt("id"), rs.getString("nome"), rs.getString("email"), rs.getString("senha"), rs.getString("funcao")
                );
            }
            
            rs.close();
            stmt.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        
        return administrador;
    }
    
}
