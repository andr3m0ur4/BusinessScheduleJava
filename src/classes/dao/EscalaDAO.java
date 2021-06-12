package classes.dao;

import classes.Escala;
import config.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EscalaDAO {
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    public EscalaDAO() {
        con = new Conexao().getConexao();
    }
    
    public List<Escala> listar() {
        List<Escala> Escalas = new ArrayList<>();
        String sql = "SELECT * FROM escala";
        
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Escala escala = new Escala(
                        
                         /*ERRO: SWITCHER E ESTUDIO NÃO PODE SER CONVERTIDO EM STRING*/
                        rs.getInt("id"), rs.getString("data_inicio"), rs.getString("data_fim"), rs.getString("ano"), rs.getString("funcionario_horario"), rs.getString("funcionario")
                
                );
                Escalas.add(escala);
            }
            
            rs.close();
            stmt.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        
        return Escalas;
    }
    
    public Escala buscar(int id) {
        Escala escala = null;
        String sql = "SELECT * FROM escalas WHERE id = ?";
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            rs.next();
            
            escala = new Escala(
                    
                        /*ERRO: SWITCHER E ESTUDIO NÃO PODE SER CONVERTIDO EM STRING*/
                         rs.getInt("id"), rs.getString("data_inicio"), rs.getString("data_fim"), rs.getString("ano"), rs.getString("funcionario_horario"), rs.getString("funcionario")
            
            );
            
            rs.close();
            stmt.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        
        return escala;
    }
    
    public void inserir(Escala escala) {
        String sql = "INSERT INTO escala VALUES(?, ?, ?, ?, ?, ?)";
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, escala.getId());
            stmt.setString(2, escala.getDataInicio());
            stmt.setString(3, escala.getDataFim());
            stmt.setString(4, escala.getAno());
            
             /*ERRO: SWITCHER E ESTUDIO NÃO PODE SER CONVERTIDO EM STRING*/
            stmt.setString(5, escala.getFuncionarioHorario());
            stmt.setString(6, escala.getUsuario());
            
            stmt.execute();
            stmt.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public void alterar(Escala escala) {
        String sql = "UPDATE escala SET nome = ?, senha = ?, funcao = ? WHERE id = ?";
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, escala.getDataInicio());
            stmt.setString(2, escala.getDataFim());
            stmt.setString(3, escala.getAno());
            
             /*ERRO: SWITCHER E ESTUDIO NÃO PODE SER CONVERTIDO EM STRING*/
            stmt.setString(4, escala.getFuncionarioHorario());
            stmt.setString(5, escala.getUsuario());
            
            stmt.setInt(6, escala.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public void excluir(Escala escala) {
        String sql = "DELETE FROM escala WHERE id = ?";
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, escala.getId());
            stmt.execute();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public int lastId() {
        int id = 0;
        String sql = "SELECT max(id) FROM escala";
        
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
