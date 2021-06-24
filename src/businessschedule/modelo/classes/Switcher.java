package businessschedule.modelo.classes;

import java.util.Objects;
import lib.Excecoes;

public class Switcher {
    private int id;
    private String nome;
    
    public Switcher() {
    }
    
     public Switcher( String nome) {
        setNome(nome);
    }
    
    public Switcher(int id, String nome) {
        setId(id);
        setNome(nome);
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
        final Switcher other = (Switcher) obj;
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
