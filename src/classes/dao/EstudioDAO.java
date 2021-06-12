package classes.dao;

import classes.Estudio;
import config.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstudioDAO {
    
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    public EstudioDAO() {
        con = new Conexao().getConexao();
    }
    
    public List<Estudio> listar() {
        List<Estudio> estudios = new ArrayList<>();
        String sql = "SELECT * FROM estudio";
        
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Estudio estudio = new Estudio(
                        rs.getInt("id"), rs.getString("nome")
                );
                estudios.add(estudio);
            }
            
            rs.close();
            stmt.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        
        return estudios;
    }
    
    public Estudio buscar(int id) {
        Estudio estudio = null;
        String sql = "SELECT * FROM estudio WHERE id = ?";
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            rs.next();
            
            estudio = new Estudio(
                    rs.getInt("id"), rs.getString("nome")
            );
            
            rs.close();
            stmt.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        
        return estudio;
    }
    
    public void inserir(Estudio estudio) {
        String sql = "INSERT INTO estudio VALUES(?, ?)";
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, estudio.getId());
            stmt.setString(2, estudio.getNome());
            stmt.execute();
            stmt.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public void alterar(Estudio estudio) {
        String sql = "UPDATE estudio SET nome = ? WHERE id = ?";
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, estudio.getNome());
            stmt.setInt(2, estudio.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public void excluir(Estudio estudio) {
        String sql = "DELETE FROM estudio WHERE id = ?";
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, estudio.getId());
            stmt.execute();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public int lastId() {
        int id = 0;
        String sql = "SELECT max(id) FROM estudio";
        
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
}
