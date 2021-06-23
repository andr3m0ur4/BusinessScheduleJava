package businessschedule;

import businessschedule.apresentacao.FrmHome;
import businessschedule.apresentacao.FrmLogin;

public class BusinessSchedule {
    public static boolean usuario;
    
    public static void main(String[] args) {
        FrmLogin login = new FrmLogin();
        login.setVisible(true);
    }
}
