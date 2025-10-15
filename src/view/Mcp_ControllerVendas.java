/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.McpVendas;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class Mcp_ControllerVendas extends AbstractTableModel {

    private List lstVendas;

    public void setList(List lstVendas) {
        this.lstVendas = lstVendas;
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
        McpVendas mcpvendas = (McpVendas) lstVendas.get( rowIndex);
        if ( columnIndex == 0 ){
            return mcpvendas.getMcpIdVenda();
        } else if (columnIndex ==1) {
            return mcpvendas.getMcpCupons();        
        } else if (columnIndex ==2) {
            return mcpvendas.getMcpObservacoes();
        } else if (columnIndex ==3) {
            return mcpvendas.getMcpTotal();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código da venda";
        } else if ( columnIndex == 1) {
            return "Cupons";         
        } else if ( columnIndex == 2) {
            return "Observações";
        } else if ( columnIndex == 3) {
            return "Total";
        } 
        return "";
    }
}
