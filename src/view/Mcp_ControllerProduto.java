/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.McpProdutos;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class Mcp_ControllerProduto extends AbstractTableModel {

    private List lstProduto;

    public void setList(List lstProduto) {
        this.lstProduto = lstProduto;
    }
    
    public McpProdutos getBean(int rowIndex) {
        return (McpProdutos) lstProduto.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstProduto.size();
                
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        McpProdutos mcpprodutos = (McpProdutos) lstProduto.get( rowIndex);
        if ( columnIndex == 0 ){
            return mcpprodutos.getMcpIdProdutos();
        } else if (columnIndex ==1) {
            return mcpprodutos.getMcpNome();        
        } else if (columnIndex ==2) {
            return mcpprodutos.getMcpMarca();
        } else if (columnIndex ==3) {
            return mcpprodutos.getMcpTamanho();
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
            return "Marca";
        } else if ( columnIndex == 3) {
            return "Tamanho";
        } 
        return "";
    }
}
