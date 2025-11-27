package view;

import bean.McpVendasProdutos;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class Mcp_ControllerVendasProdutos extends AbstractTableModel {

    private List lstVendasProdutos;

    public void setList(List lstVendasProdutos) {
        this.lstVendasProdutos = lstVendasProdutos;
        this.fireTableDataChanged();
    }
    
    public McpVendasProdutos getBean(int rowIndex) {
        return (McpVendasProdutos) lstVendasProdutos.get(rowIndex);
    }

    public void addBean(McpVendasProdutos vendasProdutos) {
        lstVendasProdutos.add(vendasProdutos);
        this.fireTableDataChanged();
    }
    
    public void removeBean(int rowIndex) {
        lstVendasProdutos.remove(rowIndex);
        this.fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return lstVendasProdutos.size();                
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        McpVendasProdutos vendasProdutos = (McpVendasProdutos) lstVendasProdutos.get(rowIndex);
        if (columnIndex == 0) {
            return vendasProdutos.getMcpProdutos().getMcpIdProdutos();
        } else if (columnIndex == 1) {
            return vendasProdutos.getMcpProdutos().getMcpNome();
        } else if (columnIndex == 2) {
            return vendasProdutos.getMcpQuantidade();
        } else if (columnIndex == 3) {
            return vendasProdutos.getMcpValorUnitario();
        } else if (columnIndex == 4) {
            return vendasProdutos.getMcpValorUnitario() * vendasProdutos.getMcpQuantidade();
        }
        return ""; 
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Código";
        } else if (columnIndex == 1) {
            return "Produto";         
        } else if (columnIndex == 2) {
            return "Quantidade";
        } else if (columnIndex == 3) {
            return "Valor Unitário";
        } else if (columnIndex == 4) {
            return "Total";
        } 
        return "";
    }
}