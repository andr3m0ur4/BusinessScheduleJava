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
        Funcionario funcionario = new Funcionario(4, "Fulano de Tal", "fulano@teste.com", "fulano", "Op Camera");
        
        /*for (Funcionario funcionario : funcionarioDAO.listar()) {
            System.out.println(funcionario);
        }*/
        //funcionarioDAO.alterar(funcionario);
        //System.out.println(funcionarioDAO.buscar(4));
        
        //funcionarioDAO.excluir(funcionario);
        //funcionarioDAO.inserir(funcionario);
        System.out.println( funcionarioDAO.lastId());
    }
    
}
