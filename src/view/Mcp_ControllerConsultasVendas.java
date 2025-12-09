/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.McpVendas;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Marcos
 */
public class Mcp_ControllerConsultasVendas extends AbstractTableModel {

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
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        McpVendas produtos = (McpVendas) lstVendas.get( rowIndex);
        if ( columnIndex == 0 ){
            return produtos.getMcpIdVenda();
        } else if (columnIndex ==1) {
            return produtos.getMcpFormaPagamento();        
        } else if (columnIndex ==2) {
            return produtos.getMcpTotal();
        } 
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Forma de pagamento";         
        } else if ( columnIndex == 2) {
            return "Total";
        } 
        return "";
    }
}
