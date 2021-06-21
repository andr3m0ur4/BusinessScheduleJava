package businessschedule.util;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ModeloGrade extends AbstractTableModel {
    private List<String> colunas;
    private List<List<Object>> linhas;
    
    public ModeloGrade() {
        colunas = new ArrayList<>();
        linhas = new ArrayList<>();
    }

    public ModeloGrade(String[] titulos) {
        colunas = new ArrayList<>();
        
        for (String titulo : titulos) {
            colunas.add(titulo);
        }
        
        linhas = new ArrayList<>();
    }
    
    public ModeloGrade(ResultSet rs, String[] titulos) {
        this();
        
        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            
            if (titulos != null) {
                for (String titulo : titulos) {
                    colunas.add(titulo);
                }
            } else {
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    colunas.add(rsmd.getColumnLabel(i));
                }
            }
            
            while (rs.next()) {
                List<Object> linha = new ArrayList<>();
                
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    linha.add(rs.getObject(i));
                }
                
                linhas.add(linha);
            }
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }

    @Override
    public int getColumnCount() {
        return colunas.size();
    }

    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return linhas.get(rowIndex).get(columnIndex);
    }
    
    public List<List<Object>> getLinhas() {
        return linhas;
    }
    
    public void excluirLinha(int linha) {
        linhas.remove(linha);
    }
    
    public void inserirLinha(List<Object> linha) {
        linhas.add(linha);
    }
    
    public void limparLinhas() {
        linhas.clear();
    }

    @Override
    public String getColumnName(int column) {
        return colunas.get(column);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass();
    }
}
