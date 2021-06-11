package businessschedule;

import classes.Funcionario;
import classes.dao.FuncionarioDAO;

/**
 *
 * @author moura
 */
public class BusinessSchedule {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        Funcionario funcionario = new Funcionario(1, "Andre", "andre@teste.com", "123", "Op Audio");
        
        funcionarioDAO.inserir(funcionario);
    }
    
}
