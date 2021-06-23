package businessschedule.apresentacao;

import businessschedule.modelo.classes.Administrador;
import businessschedule.modelo.dao.AdministradorDAO;

import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import java.awt.Font;
import java.awt.Toolkit;

import businessschedule.util.ModeloGrade;
import java.awt.Cursor;

public class FrmEdicaoAdministrador extends JFrame {
    private JButton btnHome;
    private JButton btnLimpar;
    private JButton btnMenuCadastro;
    private JButton btnMenuEdicao;
    private JButton btnPesquisar;
    private JButton btnSair;
    private JButton btnSalvar;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JScrollPane jScrollPane1;
    private JTable table;
    private JTextField txtEmail;
    private JTextField txtFuncao;
    private JTextField txtNome;
    private JTextField txtPesquisa;
    private JTextField txtSenha;
    private int id;

    public FrmEdicaoAdministrador() {
        super("Business Schedule - Editar Administrador");
        initComponents();
    }

    private void initComponents() {

        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        txtNome = new JTextField();
        jLabel4 = new JLabel();
        txtEmail = new JTextField();
        jLabel5 = new JLabel();
        txtSenha = new JTextField();
        jLabel6 = new JLabel();
        txtFuncao = new JTextField();
        btnSalvar = new JButton();
        btnLimpar = new JButton();
        jScrollPane1 = new JScrollPane();
        table = new JTable();
        btnSair = new JButton();
        btnHome = new JButton();
        btnMenuCadastro = new JButton();
        btnMenuEdicao = new JButton();
        txtPesquisa = new JTextField();
        btnPesquisar = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new ImageIcon(getClass().getResource("/businessschedule/apresentacao/img/logo.png")));

        jLabel2.setFont(new Font("Segoe UI", 0, 24));
        jLabel2.setText("Edite um Administrador");

        jLabel3.setFont(new Font("Segoe UI", 0, 18));
        jLabel3.setText("Nome:");

        jLabel4.setFont(new Font("Segoe UI", 0, 18));
        jLabel4.setText("Email:");

        jLabel5.setFont(new Font("Segoe UI", 0, 18));
        jLabel5.setText("Senha:");

        jLabel6.setFont(new Font("Segoe UI", 0, 18));
        jLabel6.setText("Função:");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new SalvarListener());

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new LimparListener());

        table.setModel(new ModeloGrade(
                new AdministradorDAO().carregarGrade(),
                new String[] {
                    "Código", "Nome", "Email", "Função"
                }
        ));
        table.setToolTipText("Escolha um administrador para editar");
        table.setCursor(new Cursor(Cursor.HAND_CURSOR));
        table.addMouseListener(new TableMouseListener());
        jScrollPane1.setViewportView(table);

        btnSair.setText("Sair");
        btnSair.addActionListener(new SairListener());

        btnHome.setText("Home");
        btnHome.addActionListener(new HomeListener());

        btnMenuCadastro.setText("Menu de Cadastro");
        btnMenuCadastro.addActionListener(new MenuCadastroListener());

        btnMenuEdicao.setText("Menu de Edição");
        btnMenuEdicao.addActionListener(new MenuEdicaoListener());

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new PesquisarListener());

        txtEmail.setEnabled(false);

        setLayout();
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
        txtSenha.setText("");
        txtFuncao.setText("");
        btnSalvar.setEnabled(true);
    }

    public boolean verificarCampos() {
        if (txtNome.getText().equals("") || txtEmail.getText().equals("") || txtSenha.getText().equals("") || txtFuncao.getText().equals("")) {
            return false;
        }

        return true;
    }

    private void pesquisar(String valor) {
        table.setModel(new ModeloGrade(
            new AdministradorDAO().pesquisarPor(valor),
            new String[] {
                "Código", "Nome", "Email", "Função"
            }
        ));
    }

    private class LimparListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            limpar();
        }
    }

    private class SairListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
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

    private class MenuEdicaoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            FrmMenuEdicao ini = new FrmMenuEdicao();
            ini.setVisible(true);
            setVisible(false);
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
    
    private class TableMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {
            id = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
            txtNome.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
            txtEmail.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
            txtFuncao.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
            txtSenha.setText("");
        }
    }

    private class PesquisarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            pesquisar(txtPesquisa.getText());
        }
    }

    private class SalvarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            if (verificarCampos()) {
                AdministradorDAO dao = new AdministradorDAO();
                Administrador administrador = new Administrador(
                    id, txtNome.getText(), txtEmail.getText(), txtSenha.getText(), txtFuncao.getText()
                );
                dao.alterar(administrador);
                JOptionPane.showMessageDialog(null, "Administrador alterado com sucesso!", "Mensagem de Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Todos os campos devem estar preenchidos", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void setLayout() {
        
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(418, 418, 418)
                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 21, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPesquisar, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(25, 25, 25)
                                        .addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtSenha, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtFuncao, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE))))
                        .addGap(28, 28, 28))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(52, 52, 52))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtPesquisa, GroupLayout.PREFERRED_SIZE, 444, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnHome, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnMenuCadastro)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnMenuEdicao, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHome, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMenuCadastro, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMenuEdicao, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisa, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSenha, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFuncao, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 345, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    
    }
}
