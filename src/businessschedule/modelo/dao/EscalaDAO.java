package businessschedule.modelo.dao;

import businessschedule.modelo.classes.Escala;
import businessschedule.modelo.classes.Funcionario;
import businessschedule.modelo.classes.FuncionarioHorario;
import businessschedule.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lib.DataHora;

public class EscalaDAO {
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    public EscalaDAO() {
        con = new Conexao().getConexao();
    }
    
    public List<Escala> listar() {
        List<Escala> escalas = new ArrayList<>();
        String sql = "SELECT * FROM escala";
        
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Escala escala = new Escala(
                        rs.getInt("id"), rs.getString("data_inicio"), rs.getString("data_fim"), rs.getString("ano")
                );
                escalas.add(escala);
            }
            
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        
        return escalas;
    }
    
    public Escala buscar(int id) {
        Escala escala = null;
        String sql = "SELECT * FROM escala WHERE id = ?";
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                escala = new Escala(
                        rs.getInt("id"), rs.getString("data_inicio"), rs.getString("data_fim"), rs.getString("ano")
                );
            }
            
        } catch (SQLException erro) {
            erro.printStackTrace();
        } 
        
        return escala;
    }
    
    public void inserir(Escala escala) {
        String sql = "INSERT INTO escala VALUES(?, ?, ?, ?)";
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, escala.getId());
            stmt.setString(2, DataHora.personalizarDataParaAmericano(escala.getDataInicio()));
            stmt.setString(3, DataHora.personalizarDataParaAmericano(escala.getDataFim()));
            stmt.setString(4, escala.getAno());
            
            stmt.execute();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public void alterar(Escala escala) {
        String sql = "UPDATE escala SET data_inicio = ?, data_fim = ?, ano = ? WHERE id = ?";
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, DataHora.personalizarDataParaAmericano(escala.getDataInicio()));
            stmt.setString(2, DataHora.personalizarDataParaAmericano(escala.getDataFim()));
            stmt.setString(3, escala.getAno());
            stmt.setInt(4, escala.getId());
            stmt.execute();
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
    
    
    public ResultSet carregarGrade() {
        String sql = "SELECT id, data_inicio, data_fim, ano FROM escala";
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }

        return rs;
    }

    public ResultSet pesquisarPor(String valor) {
        String sql = "SELECT id, data_inicio, data_fim, ano FROM escala WHERE id = ?";
          
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1,  valor);
            rs = stmt.executeQuery();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }

        return rs;
    }

    public void close() {
        try {
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
}
