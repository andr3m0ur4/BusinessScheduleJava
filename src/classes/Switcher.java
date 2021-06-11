package classes;

public class Switcher {
    private int id;
    private String nome;
    
    public Switcher() {
    }
    
    public Switcher(int id, String nome) {
        setId(id);
        setNome(nome);
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

    @Override
    public String toString() {
        return "Id: " + id + "Nome: " + nome;
    }
    
    
}
