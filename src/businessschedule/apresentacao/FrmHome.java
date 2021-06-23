package businessschedule.apresentacao;

import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import businessschedule.BusinessSchedule;
import businessschedule.modelo.classes.FuncionarioHorario;
import businessschedule.modelo.dao.FuncionarioHorarioDAO;
import businessschedule.util.ModeloGrade;
import lib.DataHora;

import java.awt.Font;
import java.awt.Toolkit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmHome extends JFrame {
    private JButton btnCadastrar;
    private JButton btnEditar;
    private JButton btnSair;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JScrollPane jScrollPane1;
    private JTable table;

    public FrmHome() {
        super("Business Schedule");
        initComponents();
    }

    private void initComponents() {
        jScrollPane1 = new JScrollPane();
        table = new JTable();
        jLabel1 = new JLabel();
        btnCadastrar = new JButton();
        btnEditar = new JButton();
        btnSair = new JButton();
        jLabel2 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        validarUsuario();

        table.setModel(new ModeloGrade(
            new FuncionarioHorarioDAO().carregarEscalaGrade(),
            new String[] {
                "Nome", "Função", "Horário inicial", "Horário final", "Data", "Data Inicial", "Data Final"
            }
        ));
        jScrollPane1.setViewportView(table);

        jLabel1.setIcon(new ImageIcon(getClass().getResource("/businessschedule/apresentacao/img/logo.png")));

        btnCadastrar.setText("Menu de Cadastro");
        btnCadastrar.addActionListener(new CadastrarListener());

        btnEditar.setText("Menu de Edição");
        btnEditar.addActionListener(new EditarListener());

        btnSair.setText("Sair");
        btnSair.addActionListener(new SairListener());

        jLabel2.setFont(new Font("Segoe UI", 0, 48));
        jLabel2.setText("Escala semanal");

        ajustarColunas();

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

    private void ajustarColunas() {
        FuncionarioHorario funcionarioHorario;

        for (int i = 0; i < table.getRowCount(); i++) {
            funcionarioHorario = new FuncionarioHorario(table.getValueAt(i, 4).toString());
            table.setValueAt(DataHora.personalizarDataParaBrasileiro(funcionarioHorario.getData()), i, 4);

            funcionarioHorario.setData(table.getValueAt(i, 5).toString());
            table.setValueAt(DataHora.personalizarDataParaBrasileiro(funcionarioHorario.getData()), i, 5);

            funcionarioHorario.setData(table.getValueAt(i, 6).toString());
            table.setValueAt(DataHora.personalizarDataParaBrasileiro(funcionarioHorario.getData()), i, 6);
        }
    }

    private void validarUsuario() {
        if (!BusinessSchedule.usuario) {
            btnCadastrar.setEnabled(false);
            btnEditar.setEnabled(false);
        }
    }

    private class CadastrarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO add your handling code here:
            FrmMenuCadastro ini = new FrmMenuCadastro();
            ini.setVisible(true);
            setVisible(false);
        }

    }

    private class EditarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO add your handling code here:
            FrmMenuEdicao ini = new FrmMenuEdicao();
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

    private void setLayout() {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 670, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                        .addGap(123, 123, 123)
                        .addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(85, 85, 85))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        pack();
    }
}
