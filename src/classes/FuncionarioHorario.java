package classes;

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
        this.id = id;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    

    @Override
    public String toString() {
        return "Id: " + id + " - Horario Inicio: " + horarioInicio + " - Horario Fim: " +
                horarioFim + " - Data: " + data;
    }
    
}
