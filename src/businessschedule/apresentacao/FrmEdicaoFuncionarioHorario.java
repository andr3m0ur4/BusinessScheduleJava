package businessschedule.apresentacao;

import businessschedule.modelo.classes.Escala;
import businessschedule.modelo.classes.Funcionario;
import businessschedule.modelo.classes.FuncionarioHorario;
import businessschedule.modelo.dao.EscalaDAO;
import businessschedule.modelo.dao.FuncionarioDAO;
import businessschedule.modelo.dao.FuncionarioHorarioDAO;

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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;
import lib.DataHora;

public class FrmEdicaoFuncionarioHorario extends JFrame {
    private JButton btnHome;
    private JButton btnLimpar;
    private JButton btnCadastro;
    private JButton btnEdicao;
    private JButton btnPesquisar;
    private JButton btnSair;
    private JButton btnSalvar;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JScrollPane jScrollPane1;
    private JTable table;
    private JTextField txtHoraInicial;
    private JTextField txtHoraFinal;
    private JTextField txtData;
    private JTextField txtPesquisa;
    private JComboBox<Funcionario> cbFuncionario;
    private JComboBox<Escala> cbEscala;
    private int id;
    private MaskFormatter frmHora;
    private MaskFormatter frmHora2;
    private MaskFormatter frmData;

    public FrmEdicaoFuncionarioHorario() {
        super("Business Schedule - Editar Horario");
        initComponents();
    }

    private void initComponents() {

        
        try {
            frmHora = new MaskFormatter("##:##");
            frmHora2 = new MaskFormatter("##:##");
            frmData = new MaskFormatter("##/##/####");
        } catch (ParseException erro) {
            erro.printStackTrace();
        }
        
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        btnSalvar = new JButton();
        btnLimpar = new JButton();
        jScrollPane1 = new JScrollPane();
        table = new JTable();
        btnSair = new JButton();
        btnHome = new JButton();
        btnCadastro = new JButton();
        btnEdicao = new JButton();
        txtPesquisa = new JTextField();
        btnPesquisar = new JButton();
        cbFuncionario = new JComboBox<>();
        cbEscala = new JComboBox<>();
        txtHoraInicial = new JFormattedTextField(frmHora);
        txtHoraFinal = new JFormattedTextField(frmHora2);
        txtData = new JFormattedTextField(frmData);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new ImageIcon(getClass().getResource("/businessschedule/apresentacao/img/logo.png")));

        jLabel2.setFont(new Font("Segoe UI", 0, 24));
        jLabel2.setText("Edite um horário");

        jLabel3.setFont(new Font("Segoe UI", 0, 18));
        jLabel3.setText("Funcionário:");

        jLabel4.setFont(new Font("Segoe UI", 0, 18));
        jLabel4.setText("Escala:");

        jLabel5.setFont(new Font("Segoe UI", 0, 18));
        jLabel5.setText("Horário Inicial:");

        jLabel6.setFont(new Font("Segoe UI", 0, 18));
        jLabel6.setText("Horarário Final:");
        
        jLabel7.setFont(new Font("Segoe UI", 0, 18));
        jLabel7.setText("Data:");
        

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new SalvarListener());

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new LimparListener());

        table.setModel(new ModeloGrade(
                new FuncionarioHorarioDAO().carregarGrade(),
                new String[] {
                    "Código", "Horario Inicio", "Horario Final", "Data", "Funcionario", "Email", "Função","Data inicio","Data fim","Ano"
                }
        ));
        table.setToolTipText("Escolha um horário de um funcionário para editar");
        table.setCursor(new Cursor(Cursor.HAND_CURSOR));
        table.addMouseListener(new TableMouseListener());
        jScrollPane1.setViewportView(table);

        btnSair.setText("Sair");
        btnSair.addActionListener(new SairListener());

        btnHome.setText("Home");
        btnHome.addActionListener(new HomeListener());

        btnCadastro.setText("Menu de Cadastro");
        btnCadastro.addActionListener(new MenuCadastroListener());

        btnEdicao.setText("Menu de Edição");
        btnEdicao.addActionListener(new MenuEdicaoListener());

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new PesquisarListener());
        
        ajustarColunas();
        preencherComboBoxFuncionario();
        preencherComboBoxEscala();

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
        txtHoraInicial.setText("");
        txtHoraFinal.setText("");
        txtData.setText("");
        btnSalvar.setEnabled(true);
    }

    private void preencherComboBoxFuncionario() {
        List<Funcionario> lista = new ArrayList<>();

        for (Funcionario funcionario : new FuncionarioDAO().listar()) {
            lista.add(funcionario);
        }

        Funcionario[] funcionarios = lista.toArray(new Funcionario[lista.size()]);
        cbFuncionario.setModel(new DefaultComboBoxModel<>(funcionarios));
    }

    private void preencherComboBoxEscala() {
        List<Escala> lista = new ArrayList<>();

        for (Escala escala : new EscalaDAO().listar()) {
            lista.add(escala);
        }
        
        Escala[] escalas = lista.toArray(new Escala[lista.size()]);
        cbEscala.setModel(new DefaultComboBoxModel<>(escalas));
    }
    
    public boolean verificarCampos() {
        if (txtHoraInicial.getText().equals("") || txtHoraFinal.getText().equals("") || txtData.getText().equals("")) {
            return false;
        }

        return true;
    }

    private void pesquisar(String valor) {
        table.setModel(new ModeloGrade(
            new FuncionarioHorarioDAO().pesquisarPor(valor),
            new String[] {
                   "Código", "Horario Inicio", "Horario Final", "Data", "Funcionario", "Email", "Função","Data inicio","Data fim","Ano"
            }
        ));
    }

    private void ajustarColunas() {
        FuncionarioHorario funcionarioHorario;

        for (int i = 0; i < table.getRowCount(); i++) {
            funcionarioHorario = new FuncionarioHorario(table.getValueAt(i, 3).toString());
            table.setValueAt(DataHora.personalizarDataParaBrasileiro(funcionarioHorario.getData()), i, 3);

            funcionarioHorario.setData(table.getValueAt(i, 7).toString());
            table.setValueAt(DataHora.personalizarDataParaBrasileiro(funcionarioHorario.getData()), i, 7);

            funcionarioHorario.setData(table.getValueAt(i, 8).toString());
            table.setValueAt(DataHora.personalizarDataParaBrasileiro(funcionarioHorario.getData()), i, 8);
        }
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
            txtHoraInicial.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
            txtHoraFinal.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
            txtData.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
            
            Funcionario funcionario = new Funcionario(table.getValueAt(table.getSelectedRow(), 4).toString());
            cbFuncionario.setSelectedItem(funcionario);

            String dataInicio = DataHora.converterData(table.getValueAt(table.getSelectedRow(), 7).toString());
            String dataFim = DataHora.converterData(table.getValueAt(table.getSelectedRow(), 8).toString());
            Escala escala = new Escala(dataInicio, dataFim);
            cbEscala.setSelectedItem(escala);
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
                Funcionario funcionario = (Funcionario) cbFuncionario.getSelectedItem();
                Escala escala = (Escala) cbEscala.getSelectedItem();

                FuncionarioHorarioDAO dao = new FuncionarioHorarioDAO();
                FuncionarioHorario funcionarioHorario = new FuncionarioHorario(
                    id, txtHoraInicial.getText() + ":00", txtHoraFinal.getText() + ":00", DataHora.converterData(txtData.getText()), funcionario, escala
                );
                dao.alterar(funcionarioHorario);
                JOptionPane.showMessageDialog(null, "Horario alterado com sucesso!", "Mensagem de Sucesso", JOptionPane.INFORMATION_MESSAGE);
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
            .addGroup(layout.createSequentialGroup()
                .addGap(418, 418, 418)
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(99, 99, 99))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 575, GroupLayout.PREFERRED_SIZE)
                    .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(txtPesquisa, GroupLayout.PREFERRED_SIZE, 444, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisar, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(10, 10, 10)
                        .addComponent(cbFuncionario, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(10, 10, 10)
                        .addComponent(txtHoraInicial))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtHoraFinal, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtData, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbEscala, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnHome, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCadastro)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEdicao, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                .addGap(222, 222, 222))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHome, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastro, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdicao, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisa, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 345, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(cbFuncionario, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(cbEscala, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtHoraInicial, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtHoraFinal, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtData, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        pack();
    }
}
