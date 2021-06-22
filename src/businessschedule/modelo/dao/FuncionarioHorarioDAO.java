package businessschedule.modelo.dao;

import businessschedule.modelo.classes.Escala;
import businessschedule.modelo.classes.Funcionario;
import businessschedule.modelo.classes.FuncionarioHorario;
import businessschedule.util.Conexao;
import lib.DataHora;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioHorarioDAO {
    
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    public FuncionarioHorarioDAO() {
        con = new Conexao().getConexao();
    }
    
    public List<FuncionarioHorario> listar() {
        List<FuncionarioHorario> funcionarioHorarios = new ArrayList<>();
         String sql = "SELECT fh.horario_inicio, fh.horario_fim, fh.data, f.nome, f.email, f.funcao, esc.data_inicio, esc.data_fim, esc.ano\n" +
            "FROM funcionarioHorario AS fh\n" +
            "INNER JOIN funcionario AS f\n" +
            "ON fh.id_funcionario = f.id\n" +
            "INNER JOIN escala AS esc\n" +
            "ON fh.id_escala = esc.id\n" +
            "WHERE fh.id = fh.id";
        
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Escala escala = new Escala(rs.getInt("id_escala"), rs.getString("data_inicio"), rs.getString("data_fim"), rs.getString("ano"));
                Funcionario funcionario = new Funcionario(rs.getInt("id_funcionario"), rs.getString("nome"), rs.getString("email"), rs.getString("funcao"));
                FuncionarioHorario funcionarioHorario = new FuncionarioHorario(
                        rs.getInt("id"), rs.getString("horario_inicio"), rs.getString("horario_fim"), rs.getString("data"), funcionario, escala
                );
                funcionarioHorarios.add(funcionarioHorario);
            }
            
        } catch (SQLException erro) {
            erro.printStackTrace();
        } 
        
        return funcionarioHorarios;
    }
    
    public FuncionarioHorario buscar(int id) {
        FuncionarioHorario funcionarioHorario = null;
        String sql = "SELECT fh.horario_inicio, fh.horario_fim, fh.data, f.nome, f.email, f.funcao, esc.data_inicio, esc.data_fim, esc.ano\n" +
            "FROM funcionarioHorario AS fh\n" +
            "INNER JOIN funcionario AS f\n" +
            "ON fh.id_funcionario = f.id\n" +
            "INNER JOIN escala AS esc\n" +
            "ON fh.id_escala = esc.id\n" +
            "WHERE fh.id = ?";
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                    Escala escala = new Escala(rs.getInt("id_escala"), rs.getString("data_inicio"), rs.getString("data_fim"), rs.getString("ano"));
                    Funcionario funcionario = new Funcionario(rs.getInt("id_funcionario"), rs.getString("nome"), rs.getString("email"), rs.getString("funcao"));
                    funcionarioHorario = new FuncionarioHorario(
                        rs.getInt("id"), rs.getString("horario_inicio"), rs.getString("horario_fim"), rs.getString("data"), funcionario, escala
                );
            }
            
        } catch (SQLException erro) {
            erro.printStackTrace();
        } 
        
        return funcionarioHorario;
    }
    
    public void inserir(FuncionarioHorario funcionarioHorario) {
        String sql = "INSERT INTO funcionarioHorario VALUES(?, ?, ?, ?, ?, ?)";
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, funcionarioHorario.getId());
            stmt.setString(2, DataHora.personalizarHora(funcionarioHorario.getHorarioInicio()));
            stmt.setString(3, DataHora.personalizarHora(funcionarioHorario.getHorarioFim()));
            stmt.setString(4, DataHora.personalizarDataParaAmericano(funcionarioHorario.getData()));
            stmt.setInt(5, funcionarioHorario.getUsuario().getId());
            stmt.setInt(6, funcionarioHorario.getEscala().getId());
            stmt.execute();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public void alterar(FuncionarioHorario funcionarioHorario) {
        String sql = "UPDATE funcionarioHorario SET horario_inicio = ?, horario_fim = ?, data = ? WHERE id = ?";
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, DataHora.personalizarHora(funcionarioHorario.getHorarioInicio()));
            stmt.setString(2, DataHora.personalizarHora(funcionarioHorario.getHorarioFim()));
            stmt.setString(3, DataHora.personalizarDataParaAmericano(funcionarioHorario.getData()));
            stmt.setInt(4, funcionarioHorario.getId());
            stmt.execute();
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
    
        public ResultSet carregarGrade() {
        String sql = "SELECT fh.id, fh.horario_inicio, fh.horario_fim, fh.data, f.nome, f.email, f.funcao\n" +
        "FROM funcionarioHorario AS fh\n" +
        "INNER JOIN funcionario AS f\n" +
        "ON fh.id_funcionario = f.id";

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }

        return rs;
    }

    public ResultSet pesquisarPor(String valor) {
        String sql = "SELECT  fh.id, fh.horario_inicio, fh.horario_fim, fh.data, f.nome, f.email, f.funcao\n" +
        "FROM funcionarioHorario AS fh\n" +
        "INNER JOIN funcionario AS f\n" +
        "ON fh.id_funcionario = f.id\n" +
        "WHERE f.nome LIKE ?";

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, '%' + valor + '%');
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
