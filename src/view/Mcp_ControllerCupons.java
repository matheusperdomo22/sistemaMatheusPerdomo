/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.McpCupons;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class Mcp_ControllerCupons extends AbstractTableModel {

    private List lstCupons;

    public void setList(List lstCupons) {
        this.lstCupons = lstCupons;
    }
    
    public McpCupons getBean(int rowIndex) {
        return (McpCupons) lstCupons.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstCupons.size();
                
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        McpCupons mcpusuarios = (McpCupons) lstCupons.get( rowIndex);
        if ( columnIndex == 0 ){
            return mcpusuarios.getMcpIdCupom();
        } else if (columnIndex ==1) {
            return mcpusuarios.getMcpNome();        
        } else if (columnIndex ==2) {
            return mcpusuarios.getMcpUtilizacoes();
        } else if (columnIndex ==3) {
            return mcpusuarios.getMcpTipoDesconto();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Nome cupom";         
        } else if ( columnIndex == 2) {
            return "Ultilizações";
        } else if ( columnIndex == 3) {
            return "Tipo de Desconto ";
        } 
        return "";
    }
}
 