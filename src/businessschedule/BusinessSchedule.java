package businessschedule;

import classes.Escala;
import classes.Funcionario;
import classes.FuncionarioHorario;
import classes.Programa;
import classes.Switcher;
import classes.Estudio;
import classes.dao.EscalaDAO;
import classes.dao.ProgramaDAO;
import classes.dao.SwitcherDAO;
import classes.dao.EstudioDAO;
import classes.dao.FuncionarioDAO;
import classes.dao.FuncionarioHorarioDAO;

/**
 *
 * @author moura
 */
public class BusinessSchedule {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       /* FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        Funcionario funcionario = new Funcionario(4, "Fulano de Tal", "fulano@teste.com", "fulano", "Op Camera");*/
        
        /*for (Funcionario funcionario : funcionarioDAO.listar()) {
            System.out.println(funcionario);
        }*/
        //funcionarioDAO.alterar(funcionario);
        //System.out.println(funcionarioDAO.buscar(4));
        
        //funcionarioDAO.excluir(funcionario);
        //funcionarioDAO.inserir(funcionario);
        //System.out.println( funcionarioDAO.lastId());
        
          ProgramaDAO programaDAO = new ProgramaDAO();

             for (Programa programa : programaDAO.listar()) {
            System.out.println(programa);
        
        
        System.out.println("\n" + programaDAO.buscar(1));
            }
    }
}
