package classes.dao;

import classes.Programa;
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
        String sql = "SELECT * FROM programa";
        
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Programa programa = new Programa(
                        
                        // Mesmo conceito aqui pra solução, se vc conseguir fazer o da escala, esse será fácil
                        // Dica: teste a consulta no banco antes, lá tem um lugar pra isso.
                        //rs.getInt("id"), rs.getString("nome"), rs.getString("horario_inicio"), rs.getString("horario_fim"), rs.getString("tipo"), rs.getString("data"), rs.getInt("switcher"), rs.getInt("estudio")
                
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
        String sql = "SELECT * FROM programa WHERE id = ?";
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            rs.next();
            
            programa = new Programa(
                        // Outra vez o msm conceito de INNER JOIN, tente vc mesmo construir a consulta
                        //rs.getInt("id"), rs.getString("nome"), rs.getString("horario_inicio"), rs.getString("horario_fim"), rs.getString("tipo"), rs.getString("data"), rs.getInt("switcher"), rs.getInt("estudio")
            
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
            
            /*ERRO: SWITCHER E ESTUDIO NÃO PODE SER CONVERTIDO EM STRING*/
            // Acredito que agora tenha ficado claro como corrigir esse tbm
            //stmt.setString(7, programa.getSwitcher());
            //stmt.setString(8, programa.getEstudio());
            
            
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
            
            /*ERRO: SWITCHER E ESTUDIO NÃO PODE SER CONVERTIDO EM STRING*/
            // Vc consegue
            //stmt.setString(6, programa.getSwitcher());
            //stmt.setString(7, programa.getEstudio());
            
          
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
