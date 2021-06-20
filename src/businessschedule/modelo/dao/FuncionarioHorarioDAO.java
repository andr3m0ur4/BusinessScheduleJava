package businessschedule.modelo.dao;

import businessschedule.modelo.classes.FuncionarioHorario;
import businessschedule.util.Conexao;
import lib.DataHora;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lib.DataHora;

public class FuncionarioHorarioDAO {
    
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    public FuncionarioHorarioDAO() {
        con = new Conexao().getConexao();
    }
    
    public List<FuncionarioHorario> listar() {
        List<FuncionarioHorario> funcionarioHorarios = new ArrayList<>();
        String sql = "SELECT * FROM funcionarioHorario";
        
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                FuncionarioHorario funcionarioHorario = new FuncionarioHorario(
                        rs.getInt("id"), rs.getString("horario_inicio"), rs.getString("horario_fim"), rs.getString("data")
                );
                funcionarioHorarios.add(funcionarioHorario);
            }
            
            rs.close();
            stmt.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        
        return funcionarioHorarios;
    }
    
    public FuncionarioHorario buscar(int id) {
        FuncionarioHorario funcionarioHorario = null;
        String sql = "SELECT * FROM funcionarioHorario WHERE id = ?";
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                funcionarioHorario = new FuncionarioHorario(
                       rs.getInt("id"), rs.getString("horario_inicio"), rs.getString("horario_fim"), rs.getString("data")
                );
            }
            
            rs.close();
            stmt.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        
        return funcionarioHorario;
    }
    
    public void inserir(FuncionarioHorario funcionarioHorario) {
        String sql = "INSERT INTO funcionarioHorario VALUES(?, ?, ?, ?)";
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, funcionarioHorario.getId());
            stmt.setString(2, DataHora.personalizarHora(funcionarioHorario.getHorarioInicio()));
            stmt.setString(3, DataHora.personalizarHora(funcionarioHorario.getHorarioFim()));
            stmt.setString(4, DataHora.personalizarData(funcionarioHorario.getData()));
            stmt.execute();
            stmt.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public void alterar(FuncionarioHorario funcionarioHorario) {
        String sql = "UPDATE funcionarioHorario SET  horario_inicio = ?, horario_fim = ?, data = ? WHERE id = ?";
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, DataHora.personalizarHora(funcionarioHorario.getHorarioInicio()));
            stmt.setString(2, DataHora.personalizarHora(funcionarioHorario.getHorarioFim()));
            stmt.setString(3, DataHora.personalizarData(funcionarioHorario.getData()));
            stmt.setInt(4, funcionarioHorario.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public void excluir(FuncionarioHorario funcionarioHorario) {
        String sql = "DELETE FROM funcionarioHorario WHERE id = ?";
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, funcionarioHorario.getId());
            stmt.execute();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public int lastId() {
        int id = 0;
        String sql = "SELECT max(id) FROM funcionarioHorario";
        
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
