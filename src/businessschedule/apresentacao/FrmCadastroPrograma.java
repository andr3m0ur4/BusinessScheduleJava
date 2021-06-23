package businessschedule.apresentacao;

import businessschedule.modelo.classes.Estudio;
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

import businessschedule.modelo.classes.Programa;
import businessschedule.modelo.classes.Switcher;
import businessschedule.modelo.dao.EstudioDAO;
import businessschedule.modelo.dao.ProgramaDAO;
import businessschedule.modelo.dao.SwitcherDAO;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;
import lib.DataHora;

public class FrmCadastroPrograma extends JFrame {
    private JButton btnCadastro;
    private JButton btnEdicao;
    private JButton btnHome;
    private JButton btnSair;
    private JButton btnLimpar;
    private JButton btnSalvar;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JTextField txtNome;
    private JTextField txtHorarioInicial;
    private JTextField txtHorarioFinal;
    private JTextField txtTipo;
    private JTextField txtData;
    private JComboBox<Switcher> cbSwitcher;
    private JComboBox<Estudio> cbEstudio;
    private MaskFormatter frmHoraInicial;
    private MaskFormatter frmData;
    private MaskFormatter frmHoraFinal;
    

    public FrmCadastroPrograma() {
        super("Business Schedule - Cadastrar Programa");
        initComponents();
    }

    private void initComponents() {

        try {
            frmHoraInicial = new MaskFormatter("##:##");
            frmHoraFinal = new MaskFormatter("##:##");
            frmData = new MaskFormatter("##/##/####");
        } catch (ParseException erro) {
            erro.printStackTrace();
        }
        
        btnSair = new JButton();
        btnHome = new JButton();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        txtNome = new JTextField();
        txtTipo = new JTextField();
        btnSalvar = new JButton();
        btnLimpar = new JButton();
        btnCadastro = new JButton();
        btnEdicao = new JButton();
        cbSwitcher = new JComboBox<>();
        cbEstudio = new JComboBox<>();
        txtHorarioInicial = new JFormattedTextField(frmHoraInicial);
        txtHorarioFinal = new JFormattedTextField(frmHoraFinal);
        txtData = new JFormattedTextField(frmData);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        btnSair.setText("Sair");
        btnSair.addActionListener(new SairListener());

        btnHome.setText("Home");
        btnHome.addActionListener(new HomeListener());

        jLabel1.setIcon(new ImageIcon(getClass().getResource("/businessschedule/apresentacao/img/logo.png")));

        jLabel2.setFont(new Font("Segoe UI", 0, 24));
        jLabel2.setText("Cadastre um Programa");

        jLabel3.setFont(new Font("Segoe UI", 0, 18));
        jLabel3.setText("Nome:");

        jLabel4.setFont(new Font("Segoe UI", 0, 18));
        jLabel4.setText("Hora Inicial:");

        jLabel5.setFont(new Font("Segoe UI", 0, 18));
        jLabel5.setText("Hora Final:");

        jLabel6.setFont(new Font("Segoe UI", 0, 18));
        jLabel6.setText("Tipo:");
        
        jLabel7.setFont(new Font("Segoe UI", 0, 18));
        jLabel7.setText("Data:");
        
        jLabel8.setFont(new Font("Segoe UI", 0, 18));
        jLabel8.setText("Switcher:");
        
        jLabel9.setFont(new Font("Segoe UI", 0, 18));
        jLabel9.setText("Estudio:");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new SalvarListener());

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new LimparListener());

        btnCadastro.setText("Menu de Cadastro");
        btnCadastro.addActionListener(new MenuCadastroListener());

        btnEdicao.setText("Menu de Edição");
        btnEdicao.addActionListener(new MenuEdicaoListener());
        
        preencherComboBoxSwitcher();
        preencherComboBoxEstudio();

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
        txtHorarioInicial.setText("");
        txtHorarioFinal.setText("");
        txtNome.setText("");
        txtData.setText("");
        txtTipo.setText("");
        btnCadastro.setEnabled(true);
    }
    
    private void preencherComboBoxSwitcher() {
        List<Switcher> lista = new ArrayList<>();

        for (Switcher switcher : new SwitcherDAO().listar()) {
            lista.add(switcher);
        }

        Switcher[] switcher = lista.toArray(new Switcher[lista.size()]);
        cbSwitcher.setModel(new DefaultComboBoxModel<>(switcher));
    }
    
        private void preencherComboBoxEstudio() {
        List<Estudio> lista = new ArrayList<>();

        for (Estudio estudio : new EstudioDAO().listar()) {
            lista.add(estudio);
        }

        Estudio[] estudio = lista.toArray(new Estudio[lista.size()]);
        cbEstudio.setModel(new DefaultComboBoxModel<>(estudio));
    }
        
    public boolean verificarCampos() {
        if (txtNome.getText().equals("") || txtHorarioFinal.getText().equals("") || txtHorarioInicial.getText().equals("") || txtTipo.getText().equals("") || txtData.getText().equals("")) {
            //falta CB
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
            if(verificarCampos()) {
                
            Switcher switcher = (Switcher) cbSwitcher.getSelectedItem();
            Estudio estudio = (Estudio) cbEstudio.getSelectedItem();
               
            ProgramaDAO dao = new ProgramaDAO();
            Programa programa = new Programa(
                dao.lastId(), txtNome.getText(), txtHorarioInicial.getText() + ":00", txtHorarioFinal.getText()  + ":00", txtTipo.getText(), DataHora.converterData(txtData.getText()), switcher, estudio
            );
                dao.inserir(programa);
                dao.close();
                JOptionPane.showMessageDialog(null, "Programa cadastrado com sucesso!", "Mensagem de Sucesso", JOptionPane.INFORMATION_MESSAGE);
                limpar();
            } else {
                JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
            }      
        }
    }

    private void setLayout() {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtHorarioFinal, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtHorarioInicial))
                                    .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtData)
                                    .addGap(2, 2, 2))
                                .addComponent(txtTipo, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cbEstudio, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cbSwitcher, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)))
                            .addGap(2, 2, 2)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(192, 192, 192)
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnHome, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCadastro)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEdicao, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHome, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastro, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdicao, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtHorarioInicial, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtHorarioFinal, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTipo, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtData, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbSwitcher, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbEstudio, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        pack();
    }
}
