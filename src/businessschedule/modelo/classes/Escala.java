package businessschedule.modelo.classes;

import java.util.Date;

import lib.DataHora;
import lib.Execoes;

public class Escala {
    private int id;
    private String dataInicio;
    private String dataFim;
    private String ano;
    
    FuncionarioHorario funcionarioHorario;
    Usuario usuario;
    
    public Escala(int id, String dataInicio, String dataFim, String ano, FuncionarioHorario funcionarioHorario, Usuario usuario) {
        setId(id);
        setDataInicio(dataInicio);
        setDataFim(dataFim);
        setAno(ano);
        setFuncionarioHorario(funcionarioHorario);
        setUsuario(usuario);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        Execoes.menorQueZero("Id", id);
        this.id = id;
    }

    public Date getDataInicio() {
        return DataHora.formatarData(dataInicio);
    }

    public void setDataInicio(String dataInicio) {
        if (!DataHora.validarData(dataInicio)) {
            throw new IllegalArgumentException("Data inválida");
        }

        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return DataHora.formatarData(dataFim);
    }

    public void setDataFim(String dataFim) {
        if (!DataHora.validarData(dataFim)) {
            throw new IllegalArgumentException("Data inválida");
        }

        this.dataFim = dataFim;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        if (!DataHora.validarAno(ano)) {
            throw new IllegalArgumentException("Ano inválido");
        }
        
        this.ano = ano;
    }

    public FuncionarioHorario getFuncionarioHorario() {
        return funcionarioHorario;
    }

    public void setFuncionarioHorario(FuncionarioHorario funcionarioHorario) {
        this.funcionarioHorario = funcionarioHorario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
         return "ID: " + id + " - Ano: " + ano + " - Data de Inicio: " + dataInicio + " - Data de Fim: " 
             + dataFim + " - Funcionario: " + usuario 
                + " - Horario do Funcionario: " + funcionarioHorario ;
        
    }
    
    
}
