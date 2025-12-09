/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.McpProdutos;
import bean.McpUsuarios;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Marcos
 */
public class Mcp_ControllerConsultasProdutos extends AbstractTableModel {

    private List lstProdutos;

    public void setList(List lstProdutos) {
        this.lstProdutos = lstProdutos;
        this.fireTableDataChanged();
        
    }
    
    public McpProdutos getBean(int rowIndex) {
        return (McpProdutos) lstProdutos.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstProdutos.size();
                
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        McpProdutos produtos = (McpProdutos) lstProdutos.get( rowIndex);
        if ( columnIndex == 0 ){
            return produtos.getMcpIdProdutos();
        } else if (columnIndex ==1) {
            return produtos.getMcpNome();        
        } else if (columnIndex ==2) {
            return produtos.getMcpPreco();
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
            return "Preço";
        } 
        return "";
    }
}
