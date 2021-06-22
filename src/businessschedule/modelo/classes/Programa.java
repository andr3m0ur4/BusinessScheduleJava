package businessschedule.modelo.classes;

import java.util.Date;
import lib.DataHora;
import lib.Excecoes;

public class Programa {
    private int id;
    private String nome;
    private String horarioInicio;
    private String horarioFim;
    private String tipo;
    private String data;
    
    Switcher switcher;
    Estudio estudio;
    
    public Programa() {
    }
    
    public Programa(int id, String nome, String horarioInicio, String horarioFim, String tipo, String data, Switcher switcher, Estudio estudio) {
        setId(id);
        setNome(nome);
        setHorarioInicio(horarioInicio);
        setHorarioFim(horarioFim);
        setTipo(tipo);
        setData(data);
        setSwitcher(switcher);
        setEstudio(estudio);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        Excecoes.menorQueZero("Id", id);
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        Excecoes.isNulo("Nome", nome);
        this.nome = nome;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        Excecoes.isNulo("Tipo", tipo);
        this.tipo = tipo;
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

    public Switcher getSwitcher() {
        return switcher;
    }

    public void setSwitcher(Switcher switcher) {
        this.switcher = switcher;
    }

    public Estudio getEstudio() {
        return estudio;
    }

    public void setEstudio(Estudio estudio) {
        this.estudio = estudio;
    }
    
    @Override
    public String toString() {
        return "ID: " + id + " - Nome: " + nome + " - Horario de Inicio: " + getHorarioInicio() + " - Horario de Fim: " 
             + horarioFim + " - Tipo: " + tipo + " - Data: " + data + " - Switcher: " + switcher + " - Estudio: " + estudio;
        
    }
    
    
    
    
}
