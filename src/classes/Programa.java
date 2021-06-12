package classes;

import java.sql.Date;
import java.sql.Time;

public class Programa {
    private int id;
    private String nome;
    private String horarioInicio;
    private String horarioFim;
    private String tipo;
    private String data;
    
    Switcher switcher = new Switcher();
    Estudio estudio = new Estudio();
    
    public Programa() {
    }
    
    public Programa(int id, String nome, String horarioInicio, String horarioFim, String tipo, String data,Switcher switcher, Estudio estudio) {
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
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(String horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public String getHorarioFim() {
        return horarioFim;
    }

    public void setHorarioFim(String horarioFim) {
        this.horarioFim = horarioFim;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
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
        return "ID: " + id + "Nome: " + nome + "Horario de Inicio: " + horarioInicio + "Horario de Fim: " 
             + horarioFim + "Tipo: " + tipo + "Data: " + data + "Switcher: " + switcher + "Estudio: " + estudio;
        
    }
    
    
}
