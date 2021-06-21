package businessschedule;

import businessschedule.apresentacao.FrmHome;
import businessschedule.apresentacao.FrmLogin;
import businessschedule.modelo.classes.Administrador;
import businessschedule.modelo.classes.Funcionario;
import businessschedule.modelo.dao.AdministradorDAO;
import businessschedule.modelo.dao.FuncionarioDAO;

public class BusinessSchedule {
    
    public static void main(String[] args) {
        //FrmLogin login = new FrmLogin();
        //login.setVisible(true);
        
        FrmHome home = new FrmHome();
        home.setVisible(true);

        /* AdministradorDAO dao = new AdministradorDAO();
        for (Administrador funcionario : dao.listar()) {
            System.out.println(funcionario);
        }

        Administrador administrador = new Administrador(dao.lastId(), "teste", "teste", "1233445678999", "teste");
        dao.inserir(administrador);

        System.out.println(dao.lastId());

        administrador = new Administrador(dao.lastId(), "teste2", "teste2", "1233445678999", "teste2");
        dao.inserir(administrador);

        System.out.println("************************");
        dao = new AdministradorDAO();
        for (Administrador funcionario : dao.listar()) {
            System.out.println(funcionario);
        } */
    }
}
