package businessschedule.modelo.classes;

import java.util.Date;

import lib.DataHora;
import lib.Excecoes;

public class FuncionarioHorario {
    private int id;
    private String horarioInicio;
    private String horarioFim;
    private String data;
    private Usuario usuario;
    private Escala escala;
    
    public FuncionarioHorario() {
    }
    
    public FuncionarioHorario(int id, String horarioInicio, String horarioFim, String data, Usuario usuario, Escala escala) {
        
        setId(id);
        setHorarioInicio(horarioInicio);
        setHorarioFim(horarioFim);
        setData(data);
        setUsuario(usuario);
        setEscala(escala);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        Excecoes.menorQueZero("Id", id);
        this.id = id;
    }

    public Date getHorarioInicio() {
        return DataHora.formatarHora(horarioInicio);
    }

    public void setHorarioInicio(String horarioInicio) {
        if (!DataHora.validarHora(horarioInicio)) {
            throw new IllegalArgumentException("Hora inválida");
        }

        this.horarioInicio = horarioInicio;
    }

    public Date getHorarioFim() {
        return DataHora.formatarHora(horarioFim);
    }

    public void setHorarioFim(String horarioFim) {
        if (!DataHora.validarHora(horarioFim)) {
            throw new IllegalArgumentException("Hora inválida");
        }

        this.horarioFim = horarioFim;
    }

    public Date getData() {
        return DataHora.formatarData(data);
    }

    public void setData(String data) {
        if (!DataHora.validarData(data)) {
            throw new IllegalArgumentException("Data inválida");
        }

        this.data = data;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        Excecoes.isNulo("Funcionário", usuario);
        this.usuario = usuario;
    }

    public Escala getEscala() {
        return escala;
    }

    public void setEscala(Escala escala) {
        Excecoes.isNulo("Escala", escala);
        this.escala = escala;
    }

    @Override
    public String toString() {
        return "FuncionarioHorario{" + "id=" + id + ", horarioInicio=" + horarioInicio + ", horarioFim=" + horarioFim + ", data=" + data + ", usuario=" + usuario + ", escala=" + escala + '}';
    }
}
