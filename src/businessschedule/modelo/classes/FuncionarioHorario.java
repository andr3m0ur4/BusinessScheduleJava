package businessschedule.modelo.classes;

import java.util.Date;

import lib.DataHora;
import lib.Execoes;

public class FuncionarioHorario {
    private int id;
    private String horarioInicio;
    private String horarioFim;
    private String data;
    
    public FuncionarioHorario() {
    }
    
    public FuncionarioHorario(int id, String horarioInicio, String horarioFim, String data) {
        
        setId(id);
        setHorarioInicio(horarioInicio);
        setHorarioFim(horarioFim);
        setData(data);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        Execoes.menorQueZero("Id", id);
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

    @Override
    public String toString() {
        return "Id: " + id + " - Horario Inicio: " + horarioInicio + " - Horario Fim: " +
                horarioFim + " - Data: " + data;
    }
    
}
