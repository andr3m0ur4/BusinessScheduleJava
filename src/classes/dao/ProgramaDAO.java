package classes.dao;

import classes.Programa;
import classes.Switcher;
import classes.Estudio;
import config.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProgramaDAO {
    
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    public ProgramaDAO() {
        con = new Conexao().getConexao();
    }
    
    public List<Programa> listar() {
        List<Programa> programas = new ArrayList<>();      
             String sql = "SELECT p.*, s.nome as nome_switcher, es.nome as nome_estudio\n" +
                    "FROM programa AS p\n" +
                    "INNER JOIN switcher AS s\n" +
                    "ON p.id_switcher = s.id\n" +
                    "INNER JOIN estudio AS es\n" +
                    "ON p.id_estudio = es.id";
        
        
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                 Switcher switcher = new Switcher(
                        rs.getInt("id_switcher"), rs.getString("nome_switcher")
                );
                Estudio estudio = new Estudio(
                        rs.getInt("id_estudio"), rs.getString("nome_estudio")
                );
                Programa programa = new Programa(
                        rs.getInt("id"), rs.getString("nome"), rs.getString("horario_inicio"), rs.getString("horario_fim"), rs.getString("tipo"), rs.getString("data"), switcher, estudio
                );
                programas.add(programa);
            }
            
            rs.close();
            stmt.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        
        return programas;
    }
    
    public Programa buscar(int id) {
        Programa programa = null;
           String sql = "SELECT p.*, s.nome as nome_switcher, es.nome as nome_estudio\n" +
                    "FROM programa AS p\n" +
                    "INNER JOIN switcher AS s\n" +
                    "ON p.id_switcher = s.id\n" +
                    "INNER JOIN estudio AS es\n" +
                    "ON p.id_estudio = es.id\n" +
                    "WHERE p.id = ?";
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            rs.next();
            
             Switcher switcher = new Switcher(
                        rs.getInt("id_switcher"), rs.getString("nome_switcher")
                );
                Estudio estudio = new Estudio(
                        rs.getInt("id_estudio"), rs.getString("nome_estudio")
                );
                 programa = new Programa(
                        rs.getInt("id"), rs.getString("nome"), rs.getString("horario_inicio"), rs.getString("horario_fim"), rs.getString("tipo"), rs.getString("data"), switcher, estudio
                );
            
            rs.close();
            stmt.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        
        return programa;
    }
    
    public void inserir(Programa programa) {
        String sql = "INSERT INTO programa VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, programa.getId());
            stmt.setString(2, programa.getNome());
            stmt.setString(3, programa.getHorarioInicio());
            stmt.setString(4, programa.getHorarioFim());
            stmt.setString(5, programa.getTipo());
            stmt.setString(6, programa.getData());
            stmt.setInt(7, programa.getSwitcher().getId());
            stmt.setInt(8, programa.getEstudio().getId()); 
            stmt.execute();
            stmt.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public void alterar(Programa programa) {
        String sql = "UPDATE programa SET nome = ?, horario_inicio = ?, horario_fim = ?, tipo = ?, data = ?, switcher = ?, estudio = ? WHERE id = ?";
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, programa.getNome());
            stmt.setString(2, programa.getHorarioInicio());
            stmt.setString(3, programa.getHorarioFim());
            stmt.setString(4, programa.getTipo());
            stmt.setString(5, programa.getData());  
            stmt.setInt(6, programa.getSwitcher().getId());
            stmt.setInt(7, programa.getEstudio().getId());
            stmt.setInt(8, programa.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public void excluir(Programa programa) {
        String sql = "DELETE FROM programa WHERE id = ?";
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, programa.getId());
            stmt.execute();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public int lastId() {
        int id = 0;
        String sql = "SELECT max(id) FROM programa";
        
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
