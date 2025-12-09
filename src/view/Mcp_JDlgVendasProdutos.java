package view;

import bean.McpVendasProdutos;
import bean.McpProdutos;
import dao.Mcp_ProdutosDAO;
import java.util.List;
import javax.swing.JTable;
import tools.mcp_util;

public class Mcp_JDlgVendasProdutos extends javax.swing.JDialog {
    Mcp_JDlgVendas Mcp_JDlgVendas;
    boolean incluir;
    
    public Mcp_JDlgVendasProdutos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Vendas Produtos");
        setLocationRelativeTo(null);
        
        jTxtQuantidade.setText("1");
        Mcp_ProdutosDAO produtosDAO = new Mcp_ProdutosDAO();
        List lista = (List) produtosDAO.listAll();
        for (Object object : lista) {
            jCboProdutos.addItem((McpProdutos) object);
        }
        mcp_util.habilitar(false, jTxtValorUni, jTxtTotal);
    }
    
    public void setTelaAnterior(Mcp_JDlgVendas Mcp_JDlgVendas, McpVendasProdutos vendasProdutos) {
        this.Mcp_JDlgVendas = Mcp_JDlgVendas;
        if (vendasProdutos != null) {
            incluir = false;
            jCboProdutos.setSelectedItem(vendasProdutos.getMcpProdutos());
            jTxtQuantidade.setText(mcp_util.intToStr(vendasProdutos.getMcpQuantidade()));        
        } else {
            incluir = true;
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTxtTotal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jBtnOK = new javax.swing.JButton();
        jBtnCANCELAR = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jCboProdutos = new javax.swing.JComboBox<McpProdutos>();
        jLabel2 = new javax.swing.JLabel();
        jTxtQuantidade = new javax.swing.JTextField();
        jTxtValorUni = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel4.setText("Total");

        jBtnOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-ok-24.png"))); // NOI18N
        jBtnOK.setText("OK");
        jBtnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnOKActionPerformed(evt);
            }
        });

        jBtnCANCELAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-cancelar-24.png"))); // NOI18N
        jBtnCANCELAR.setText("Cancelar");
        jBtnCANCELAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCANCELARActionPerformed(evt);
            }
        });

        jLabel1.setText("Produtos");

        jCboProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCboProdutosActionPerformed(evt);
            }
        });

        jLabel2.setText("Quantidade");

        jTxtQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtQuantidadeActionPerformed(evt);
            }
        });
        jTxtQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTxtQuantidadeKeyReleased(evt);
            }
        });

        jLabel3.setText("Valor Unitário");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jCboProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jTxtQuantidade, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                            .addComponent(jBtnOK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtnCANCELAR)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTxtValorUni, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jTxtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCboProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtValorUni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnCANCELAR)
                    .addComponent(jBtnOK))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnOKActionPerformed
        McpVendasProdutos vendasProdutos = new McpVendasProdutos();
    vendasProdutos.setMcpProdutos((McpProdutos) jCboProdutos.getSelectedItem());
    vendasProdutos.setMcpQuantidade(mcp_util.strToInt(jTxtQuantidade.getText()));
    vendasProdutos.setMcpValorUnitario(mcp_util.strToDouble(jTxtValorUni.getText()));                
    if (incluir == true) {
          Mcp_JDlgVendas.controllerVendProd.addBean(vendasProdutos);
        } else {
            Mcp_JDlgVendas.controllerVendProd.removeBean(Mcp_JDlgVendas.getjTable1().getSelectedRow());
            Mcp_JDlgVendas.controllerVendProd.addBean(vendasProdutos);
        }
        setVisible(false);
    }//GEN-LAST:event_jBtnOKActionPerformed

    private void jBtnCANCELARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCANCELARActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jBtnCANCELARActionPerformed

    private void jCboProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCboProdutosActionPerformed
        // TODO add your handling code here:
         McpProdutos produtos = (McpProdutos) jCboProdutos.getSelectedItem();
    jTxtValorUni.setText(mcp_util.doubleToStr(produtos.getMcpPreco())); 
    int quant = mcp_util.strToInt(jTxtQuantidade.getText()); 
    jTxtTotal.setText(mcp_util.doubleToStr(quant * produtos.getMcpPreco())); 
    }//GEN-LAST:event_jCboProdutosActionPerformed

    private void jTxtQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtQuantidadeActionPerformed
        // TODO add your handling code here:
        //if(jTxtQuantidade.getText().isEmpty() == false){
       // McpProdutos produtos = (McpProdutos) jCboProdutos.getSelectedItem();
       // int quant = mcp_util.strToInt(jTxtQuantidade.getText());
       // jTxtTotal.setText(mcp_util.doubleToStr(quant * produtos.getMcpPreco()));
    //} else {
    //    mcp_util.limpar(jTxtTotal);
    //}
    }//GEN-LAST:event_jTxtQuantidadeActionPerformed

    private void jTxtQuantidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtQuantidadeKeyReleased
        // TODO add your handling code here:
        if(jTxtQuantidade.getText().isEmpty() == false){
        McpProdutos produtos = (McpProdutos) jCboProdutos.getSelectedItem();
        int quant = mcp_util.strToInt(jTxtQuantidade.getText());
        jTxtTotal.setText(mcp_util.doubleToStr(quant * produtos.getMcpPreco()));
    } else {
        mcp_util.limpar(jTxtTotal);
    }
    }//GEN-LAST:event_jTxtQuantidadeKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Mcp_JDlgVendasProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mcp_JDlgVendasProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mcp_JDlgVendasProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mcp_JDlgVendasProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Mcp_JDlgVendasProdutos dialog = new Mcp_JDlgVendasProdutos(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCANCELAR;
    private javax.swing.JButton jBtnOK;
    private javax.swing.JComboBox<McpProdutos> jCboProdutos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTxtQuantidade;
    private javax.swing.JTextField jTxtTotal;
    private javax.swing.JTextField jTxtValorUni;
    // End of variables declaration//GEN-END:variables
}
