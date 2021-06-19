package businessschedule;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import classes.Escala;
import java.util.Scanner;
import classes.Funcionario;
import classes.Usuario;
import classes.FuncionarioHorario;
import classes.Programa;
import classes.Switcher;
import classes.Estudio;
//import classes.dao.EscalaDAO;
//import classes.dao.ProgramaDAO;
import classes.dao.SwitcherDAO;
import classes.dao.EstudioDAO;
import classes.dao.FuncionarioDAO;
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
        /* FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        //Funcionario funcionario = new Funcionario(4, "Fulano de Tal", "fulano@teste.com", "fulano", "Op Camera");
        
        for (Funcionario funcionario : funcionarioDAO.listar()) {
            System.out.println(funcionario);
        } */
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
        
        Scanner leia = new Scanner(System.in);
        String nome;
        
        try{
                
             Funcionario funcionario = new Funcionario(1, "rerer","ererer", "4ttrtrtter", "reref");
             System.out.println(funcionario);
            
        }catch (Exception e){
            
            System.out.println(e.getMessage());
            
        }
        
        
        
        
    }
}
