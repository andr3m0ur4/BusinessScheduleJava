package businessschedule;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import businessschedule.modelo.classes.Escala;
import java.util.Scanner;
import businessschedule.modelo.dao.AdministradorDAO;
import businessschedule.modelo.classes.Funcionario;
import businessschedule.modelo.classes.Usuario;
import businessschedule.modelo.classes.FuncionarioHorario;
import businessschedule.modelo.classes.Programa;
import businessschedule.modelo.classes.Switcher;
import businessschedule.modelo.classes.Estudio;
//import classes.dao.EscalaDAO;
//import classes.dao.ProgramaDAO;
import businessschedule.modelo.dao.SwitcherDAO;
import businessschedule.modelo.dao.EstudioDAO;
import businessschedule.modelo.dao.FuncionarioDAO;
//import classes.dao.FuncionarioHorarioDAO;

/**
 *
 * @author moura
 */
public class BusinessSchedule {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        //Funcionario funcionario = new Funcionario(4, "Fulano de Tal", "fulano@teste.com", "fulano", "Op Camera");
        
        for (Funcionario funcionario : funcionarioDAO.listar()) {
            System.out.println(funcionario);
        }*/
        //funcionarioDAO.alterar(funcionario);
        //System.out.println(funcionarioDAO.buscar(4));
        
        //funcionarioDAO.excluir(funcionario);
        //funcionarioDAO.inserir(funcionario);
        //System.out.println( funcionarioDAO.lastId());
        
          /* ProgramaDAO programaDAO = new ProgramaDAO();

             for (Programa programa : programaDAO.listar()) {
            System.out.println(programa);
        
        
        System.out.println("\n" + programaDAO.buscar(1));
            } */

        /* long data = new Date().getTime();
        DateFormat dataFormatada = new SimpleDateFormat("HH:mm:ss");
        System.out.println(dataFormatada.format(data));
        System.out.println(dataFormatada.format(data + 60 * 60)); */
        //System.out.println(new Date());
        /*Switcher switcher = new Switcher(1, "Switcher 1");
        Estudio estudio = new Estudio(1, "Estudio 1");
        Programa programa = new Programa(1, "Saude e Fe", "7:00:00", "8:00:00", "tipo", "2021-06-18", switcher, estudio);
        System.out.println(programa.getData());*/
        
        /*Scanner leia = new Scanner(System.in);
        String nome;
        
        try{
                
             Funcionario funcionario = new Funcionario(1, "rerer","ererer", "4ttrtrtter", "reref");
             System.out.println(funcionario);
            
        }catch (Exception e){
            
            System.out.println(e.getMessage());
            
        }*/
        
        /*AdministradorDAO funcionarioDAO = new AdministradorDAO();
        
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        
        funcionarioDAO.buscarNomeFuncionario("andre");
*/
    }
}
