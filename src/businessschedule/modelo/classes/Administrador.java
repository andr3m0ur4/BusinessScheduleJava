package businessschedule.modelo.classes;

import businessschedule.modelo.dao.AdministradorDAO;

public class Administrador extends Usuario {
    
     public Administrador() {
    }

    public Administrador(int id, String nome, String email, String senha, String funcao) {
        super(id, nome, email, senha, funcao);
    }
    
     public void login(String email, String senha) {
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
}
