/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.McpClientes;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class Mcp_ControllerClientes extends AbstractTableModel {

    private List lstClientes;

    public void setList(List lstClientes) {
        this.lstClientes = lstClientes;
    }
    
    public McpClientes getBean(int rowIndex) {
        return (McpClientes) lstClientes.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstClientes.size();
                
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        McpClientes mcpusuarios = (McpClientes) lstClientes.get( rowIndex);
        if ( columnIndex == 0 ){
            return mcpusuarios.getMcpIdClientes();
        } else if (columnIndex ==1) {
            return mcpusuarios.getMcpNome();        
        } else if (columnIndex ==3) {
            return mcpusuarios.getMcpCpf();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Nome";         
        } else if ( columnIndex == 2) {
            return "Telefone";
        } else if ( columnIndex == 3) {
            return "Cpf";
        } 
        return "";
    }
}
