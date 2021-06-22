package businessschedule.modelo.classes;

import java.util.Objects;
import lib.Excecoes;

public class Estudio {
    private int id;
    private String nome;
    
    public Estudio() {
    }
    
    public Estudio(String nome) {
        setNome(nome);
    }
    
    public Estudio(int id, String nome) {
        setId(id);
        setNome(nome);
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        Excecoes.menorQueZero("id", id);
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        Excecoes.isNulo("Nome", nome);
        this.nome = nome;
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
        final Estudio other = (Estudio) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Id: " + id + " - Nome: " + nome;
    }
    
}
