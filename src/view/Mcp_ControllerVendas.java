package view;

import bean.McpVendas;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class Mcp_ControllerVendas extends AbstractTableModel {

    private List lstVendas;

    public void setList(List lstVendas) {
        this.lstVendas = lstVendas;
        this.fireTableDataChanged();
    }
    
    public McpVendas getBean(int rowIndex) {
        return (McpVendas) lstVendas.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstVendas.size();                
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        McpVendas vendas = (McpVendas) lstVendas.get(rowIndex);
        if (columnIndex == 0) {
            return vendas.getMcpIdVenda();
        } else if (columnIndex == 1) {
            return vendas.getMcpDataVenda();        
        } else if (columnIndex == 2) {
            return vendas.getMcpTotal();
        } else if (columnIndex == 3) {
            return vendas.getMcpClientes().getMcpNome();
        }
        return ""; 
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Código";
        } else if (columnIndex == 1) {
            return "Data";         
        } else if (columnIndex == 2) {
            return "Total";
        } else if (columnIndex == 3) {
            return "Cliente";
        } 
        return "";
    }
}