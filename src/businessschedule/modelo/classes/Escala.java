package businessschedule.modelo.classes;

import java.util.Date;
import java.util.Objects;

import lib.DataHora;
import lib.Excecoes;

public class Escala {
    private int id;
    private String dataInicio;
    private String dataFim;
    private String ano;
    
    public Escala() {
         
    }
     
    public Escala(String dataInicio) {
           setDataInicio(dataInicio);
    }
    
    public Escala(String dataInicio, String dataFim) {
           setDataInicio(dataInicio);
           setDataFim(dataFim);
    }
     
    public Escala(int id, String dataInicio, String dataFim, String ano) {
        setId(id);
        setDataInicio(dataInicio);
        setDataFim(dataFim);
        setAno(ano);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        Excecoes.menorQueZero("Id", id);
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Escala other = (Escala) obj;
        if (!Objects.equals(this.dataInicio, other.dataInicio)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "DE: " + DataHora.personalizarDataParaBrasileiro(getDataInicio()) + " À " + DataHora.personalizarDataParaBrasileiro(getDataFim()) + ", " + ano;
    }
}
