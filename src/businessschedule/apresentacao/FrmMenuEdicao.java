package businessschedule.apresentacao;

import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmMenuEdicao extends JFrame {
    private JButton btnAdministrador;
    private JButton btnHome;
    private JButton btnEscala;
    private JButton btnFuncionario;
    private JButton btnEstudio;
    private JButton btnHorarioFuncionario;
    private JButton btnPrograma;
    private JButton btnSwitcher;
    private JButton btnSair;
    private JLabel jLabel1;
    private JLabel jLabel2;

    public FrmMenuEdicao() {
        super("Business Schedule - Menu de Edição");
        initComponents();
    }

    private void initComponents() {

        btnSair = new JButton();
        btnHome = new JButton();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        btnEstudio = new JButton();
        btnAdministrador = new JButton();
        btnHorarioFuncionario = new JButton();
        btnFuncionario = new JButton();
        btnSwitcher = new JButton();
        btnEscala = new JButton();
        btnPrograma = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        btnSair.setText("Sair");
        btnSair.addActionListener(new SairListener());

        btnHome.setText("Home");
        btnHome.addActionListener(new HomeListener());

        jLabel1.setIcon(new ImageIcon(getClass().getResource("/businessschedule/apresentacao/img/logo.png")));

        jLabel2.setFont(new Font("Segoe UI", 0, 24));
        jLabel2.setText("Escolha o que deseja editar");

        btnEstudio.setText("Estudio");
        btnEstudio.addActionListener(new EstudioListener());

        btnAdministrador.setText("Administrador");
        btnAdministrador.addActionListener(new AdministradorListener());

        btnHorarioFuncionario.setText("Horario Funcionário");
        btnHorarioFuncionario.addActionListener(new HorarioFuncionarioListener());

        btnFuncionario.setText("Funcionário");
        btnFuncionario.addActionListener(new FuncionarioListener());

        btnSwitcher.setText("Switcher");
        btnSwitcher.addActionListener(new SwitcherListener());

        btnEscala.setText("Escala");
        btnEscala.addActionListener(new EscalaListener());

        btnPrograma.setText("Programa");
        btnPrograma.addActionListener(new ProgramaListener());

        setLayout();
        centralizar();
    }

    private void centralizar() {
        Dimension resolucao = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension tamanhoTela = getSize();
        
        int largura = (resolucao.width - tamanhoTela.width) / 2;
        int altura = (resolucao.height - tamanhoTela.height) / 2;
        
        setLocation(largura, altura);
        setResizable(false);
    }

    private class AdministradorListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO add your handling code here:
            FrmEdicaoAdministrador ini = new FrmEdicaoAdministrador();
            ini.setVisible(true);
            setVisible(false);
        }
    }
    
    private class FuncionarioListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
         // TODO add your handling code here:
            FrmEdicaoFuncionario ini = new FrmEdicaoFuncionario();
            ini.setVisible(true);
            setVisible(false);
        }
    }

    private class SwitcherListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO add your handling code here:
            FrmEdicaoSwitcher ini = new FrmEdicaoSwitcher();
            ini.setVisible(true);
            setVisible(false);
        }
    }
        
    private class EstudioListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO add your handling code here:
            FrmEdicaoEstudio ini = new FrmEdicaoEstudio();
            ini.setVisible(true);
            setVisible(false);
        }
    }

    private class EscalaListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO add your handling code here:
            FrmEdicaoEscala ini = new FrmEdicaoEscala();
            ini.setVisible(true);
            setVisible(false);
        }
    }

    private class ProgramaListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO add your handling code here:
            FrmEdicaoPrograma ini = new FrmEdicaoPrograma();
            ini.setVisible(true);
            setVisible(false);
        }
    }

    private class HorarioFuncionarioListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
             // TODO add your handling code here:
            FrmEdicaoFuncionarioHorario ini = new FrmEdicaoFuncionarioHorario();
            ini.setVisible(true);
            setVisible(false);
        }
    }

    private class SairListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO add your handling code here:
            if (JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Mensagem do Programa", JOptionPane.YES_NO_OPTION) == 0) {
                System.exit(0);
            }
        }
    }

    private class HomeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            FrmHome ini = new FrmHome();
            ini.setVisible(true);
            setVisible(false);
        }
    }

    private void setLayout() {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(btnAdministrador, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEstudio, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEscala, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPrograma, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnHome, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(498, GroupLayout.PREFERRED_SIZE))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(220, 220, 220))))
            .addGroup(layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(btnHorarioFuncionario)
                .addGap(18, 18, 18)
                .addComponent(btnFuncionario, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSwitcher, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHome, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEstudio, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEscala, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrograma, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdministrador, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHorarioFuncionario, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSwitcher, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFuncionario, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        pack();
    }
}
