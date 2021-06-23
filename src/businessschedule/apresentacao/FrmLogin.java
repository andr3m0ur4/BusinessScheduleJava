package businessschedule.apresentacao;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import businessschedule.BusinessSchedule;
import businessschedule.modelo.dao.AdministradorDAO;
import businessschedule.modelo.dao.FuncionarioDAO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmLogin extends JFrame {
    private JButton btnLogin;
    private JComboBox<String> comboBox;
    private JLabel lbl1;
    private JLabel lbl2;
    private JLabel lbl3;
    private JTextField txtEmail;
    private JTextField txtSenha;
    
    public FrmLogin() {
        initComponents();
    }
    
    private void initComponents() {
        lbl1 = new JLabel();
        lbl2 = new JLabel();
        lbl3 = new JLabel();
        txtEmail = new JTextField();
        txtSenha = new JTextField();
        comboBox = new JComboBox<>();
        btnLogin = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setBackground(UIManager.getDefaults().getColor("Button.default.hoverBackground"));

        lbl1.setIcon(new ImageIcon(getClass().getResource("/businessschedule/apresentacao/img/logo.png")));

        lbl2.setFont(new Font("Segoe UI", 0, 18));
        lbl2.setText("Email:");

        lbl3.setFont(new Font("Segoe UI", 0, 18));
        lbl3.setText("Senha:");

        comboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Administrador", "Funcionário" }));
        comboBox.setToolTipText("");

        btnLogin.setText("Entrar");
        btnLogin.addActionListener(new LoginListener());

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(121, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSenha, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
                            .addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(112, 112, 112))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnLogin)
                        .addGap(187, 187, 187))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbl1, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                        .addGap(149, 149, 149))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lbl1, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl2)
                    .addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl3)
                    .addComponent(txtSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLogin)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
        centralizar();
    }
    
    private void centralizar() {
        Dimension resolucao = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension tamanhoTela = getSize();
        
        int largura = (resolucao.width - tamanhoTela.width) / 2;
        int altura = (resolucao.height - tamanhoTela.height) / 2;
        
        setLocation(largura, altura);
    }

    private class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (comboBox.getSelectedIndex() == 0) {
                AdministradorDAO dao = new AdministradorDAO();
                
                if (dao.login(txtEmail.getText(), txtSenha.getText())) {
                    BusinessSchedule.usuario = true;

                    FrmHome ini = new FrmHome();
                    ini.setVisible(true);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Email e ou senha inválidos!");
                }
            } else {
                FuncionarioDAO dao = new FuncionarioDAO();

                if (dao.login(txtEmail.getText(), txtSenha.getText())) {
                    BusinessSchedule.usuario = false;

                    FrmHome ini = new FrmHome();
                    ini.setVisible(true);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Email e ou senha inválidos!");
                }
            }
        }
    }
}
