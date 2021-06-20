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

public class FrmMenuCadastro extends JFrame {
    private JButton btnAdministrador;
    private JButton btnEscala;
    private JButton btnEstudio;
    private JButton btnFuncionario;
    private JButton btnHome;
    private JButton btnHorarioFuncionario;
    private JButton btnPrograma;
    private JButton btnSair;
    private JButton btnSwitcher;
    private JLabel jLabel1;
    private JLabel jLabel2;

    public FrmMenuCadastro() {
        super("Business Schedule - Menu de Cadastro");
        initComponents();
    }

    private void initComponents() {
        jLabel1 = new JLabel();
        btnAdministrador = new JButton();
        btnEscala = new JButton();
        btnFuncionario = new JButton();
        btnEstudio = new JButton();
        btnHorarioFuncionario = new JButton();
        btnPrograma = new JButton();
        btnSwitcher = new JButton();
        jLabel2 = new JLabel();
        btnSair = new JButton();
        btnHome = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new ImageIcon(getClass().getResource("/businessschedule/apresentacao/img/logo.png")));

        btnAdministrador.setText("Administrador");
        btnAdministrador.addActionListener(new AdministradorListener());

        btnEscala.setText("Escala");
        btnEscala.addActionListener(new EscalaListener());

        btnFuncionario.setText("Funcionário");
        btnFuncionario.addActionListener(new FuncionarioListener());

        btnEstudio.setText("Estúdio");
        btnEstudio.addActionListener(new EstudioListener());

        btnHorarioFuncionario.setText("Horário do Funcionário");
        btnHorarioFuncionario.addActionListener(new HorarioFuncionarioListener());

        btnPrograma.setText("Programa");
        btnPrograma.addActionListener(new ProgramaListener());

        btnSwitcher.setText("Switcher");
        btnSwitcher.addActionListener(new SwitcherListener());

        jLabel2.setFont(new Font("Segoe UI", 0, 24));
        jLabel2.setText("Escolha o que deseja cadastrar");

        btnSair.setText("Sair");
        btnSair.addActionListener(new SairListener());

        btnHome.setText("Home");
        btnHome.addActionListener(new HomeListener());

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHome, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(498, GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(btnAdministrador, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEstudio, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEscala, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPrograma, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(btnHorarioFuncionario)
                        .addGap(18, 18, 18)
                        .addComponent(btnFuncionario, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSwitcher, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(37, 37, 37))
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

    private class AdministradorListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO add your handling code here:
            /* EdicaoAdministrador ini = new EdicaoAdministrador();
            ini.setVisible(true);
            setVisible(false); */
        }
    }

    private class EstudioListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            /* EdicaoEstudio ini = new EdicaoEstudio();
            ini.setVisible(true);
            setVisible(false); */
        }
    }

    private class EscalaListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            /* EdicaoEsacala ini = new EdicaoEsacala();
            ini.setVisible(true);
            setVisible(false); */
        }
    }

    private class ProgramaListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            /* EdicaoPrograma ini = new EdicaoPrograma();
            ini.setVisible(true);
            setVisible(false); */
        }
    }

    private class HorarioFuncionarioListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            /* EdicaoHorarioFuncionario ini = new EdicaoHorarioFuncionario();
            ini.setVisible(true);
            setVisible(false); */
        }
    }

    private class FuncionarioListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            /* EdicaoFuncionario ini = new EdicaoFuncionario();
            ini.setVisible(true);
            setVisible(false); */
        }
    }

    private class SwitcherListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            /* EdicaoSwitcher ini = new EdicaoSwitcher();
            ini.setVisible(true);
            setVisible(false); */
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
}
