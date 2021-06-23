package businessschedule;

import businessschedule.apresentacao.FrmHome;
import businessschedule.apresentacao.FrmLogin;

public class BusinessSchedule {
    public static boolean usuario = true;
    
    public static void main(String[] args) {
        //FrmLogin login = new FrmLogin();
        //login.setVisible(true);
        
        new FrmHome().setVisible(true);
    }
}
