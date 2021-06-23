package businessschedule.apresentacao;

import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import businessschedule.modelo.classes.Switcher;
import businessschedule.modelo.dao.SwitcherDAO;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmCadastroSwitcher extends JFrame {
    private JButton btnCadastro;
    private JButton btnEdicao;
    private JButton btnHome;
    private JButton btnSair;
    private JButton btnLimpar;
    private JButton btnSalvar;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JTextField txtNome;

    public FrmCadastroSwitcher() {
        super("Business Schedule - Cadastrar Switcher");
        initComponents();
    }

    private void initComponents() {

        btnSair = new JButton();
        btnHome = new JButton();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        txtNome = new JTextField();
        btnSalvar = new JButton();
        btnLimpar = new JButton();
        btnCadastro = new JButton();
        btnEdicao = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        btnSair.setText("Sair");
        btnSair.addActionListener(new SairListener());

        btnHome.setText("Home");
        btnHome.addActionListener(new HomeListener());

        jLabel1.setIcon(new ImageIcon(getClass().getResource("/businessschedule/apresentacao/img/logo.png")));

        jLabel2.setFont(new Font("Segoe UI", 0, 24));
        jLabel2.setText("Cadastre um Switcher");

        jLabel3.setFont(new Font("Segoe UI", 0, 18));
        jLabel3.setText("Nome:");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new SalvarListener());

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new LimparListener());

        btnCadastro.setText("Menu de Cadastro");
        btnCadastro.addActionListener(new MenuCadastroListener());

        btnEdicao.setText("Menu de Edição");
        btnEdicao.addActionListener(new MenuEdicaoListener());

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79)))))
                .addContainerGap(117, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(149, 149, 149))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHome, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCadastro, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEdicao, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHome, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastro, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdicao, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
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

    private void limpar() {
        txtNome.setText("");
        btnCadastro.setEnabled(true);
    }
    
    public boolean verificarCampos() {
        if (txtNome.getText().equals("")){
            return false;
        }

        return true;
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

    private class LimparListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            limpar();
        }
    }

    private class MenuCadastroListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            FrmMenuCadastro ini = new FrmMenuCadastro();
            ini.setVisible(true);
            setVisible(false);
        }
    }

    private class MenuEdicaoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            FrmMenuEdicao ini = new FrmMenuEdicao();
            ini.setVisible(true);
            setVisible(false);
        }
    }

    private class SalvarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            if(verificarCampos()){
            SwitcherDAO dao = new SwitcherDAO();
            Switcher switcher = new Switcher(
                dao.lastId(), txtNome.getText()
            );
            dao.inserir(switcher);
            dao.close();

            JOptionPane.showMessageDialog(null, "Switcher cadastrado com sucesso!", "Mensagem de Sucesso", JOptionPane.INFORMATION_MESSAGE);
            limpar();
            }else{
                  JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
