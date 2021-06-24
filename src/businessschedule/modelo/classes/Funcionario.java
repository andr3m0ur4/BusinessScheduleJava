package businessschedule.modelo.classes;

public class Funcionario extends Usuario {

    public Funcionario() {
    }

     public Funcionario( String nome) {
        super(nome);
    }
     
    public Funcionario(int id, String nome, String email, String senha, String funcao) {
        super(id, nome, email, senha, funcao);
    }
    
    public Funcionario(int id, String nome, String email, String funcao) {
        super(id, nome, email, funcao);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    
}
