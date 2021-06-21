package businessschedule.modelo.dao;

import businessschedule.modelo.classes.Switcher;
import businessschedule.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SwitcherDAO {
    
      
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    public SwitcherDAO() {
        con = new Conexao().getConexao();
    }
    
    public List<Switcher> listar() {
        List<Switcher> switchers = new ArrayList<>();
        String sql = "SELECT * FROM switcher";
        
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Switcher switcher = new Switcher(
                        rs.getInt("id"), rs.getString("nome")
                );
                switchers.add(switcher);
            }
            
            rs.close();
            stmt.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        
        return switchers;
    }
    
    public Switcher buscar(int id) {
        Switcher switcher = null;
        String sql = "SELECT * FROM switcher WHERE id = ?";
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                switcher = new Switcher(
                    rs.getInt("id"), rs.getString("nome")
                );
            
            }
            
            rs.close();
            stmt.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        
        return switcher;
    }
    
    public void inserir(Switcher switcher) {
        String sql = "INSERT INTO switcher VALUES(?, ?)";
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, switcher.getId());
            stmt.setString(2, switcher.getNome());
            stmt.execute();
            stmt.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public void alterar(Switcher switcher) {
        String sql = "UPDATE switcher SET nome = ? WHERE id = ?";
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, switcher.getNome());
            stmt.setInt(2, switcher.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public void excluir(Switcher switcher) {
        String sql = "DELETE FROM switcher WHERE id = ?";
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, switcher.getId());
            stmt.execute();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public int lastId() {
        int id = 0;
        String sql = "SELECT max(id) FROM switcher";
        
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
    
        public ResultSet carregarGrade() {
        String sql = "SELECT id, nome funcao FROM switcher";

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }

        return rs;
    }

    public ResultSet pesquisarPor(String valor) {
        String sql = "SELECT id, nome funcao FROM switcher WHERE nome LIKE ?";

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, '%' + valor + '%');
            rs = stmt.executeQuery();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }

        return rs;
    }
    
}
