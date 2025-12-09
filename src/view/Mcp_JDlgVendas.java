package view;

import bean.McpClientes;
import bean.McpCupons;
import bean.McpVendas;
import bean.McpVendasProdutos;
import dao.Mcp_ClientesDAO;
import dao.Mcp_CuponsDAO;
import dao.Mcp_VendasDAO;
import dao.Mcp_VendasProdutosDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import tools.mcp_util;

public class Mcp_JDlgVendas extends javax.swing.JDialog {

    Mcp_ControllerVendasProdutos controllerVendProd;
    boolean incluir;

    public Mcp_JDlgVendas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Vendas");
       
        mcp_util.habilitar(false, 
        jTxtCodigo, jFmtData, jCboClientes, jCboCupons, 
        jTxtFormadePagamento, jTxtObservacoes, jTxtTotal,
        jBtnConfirmar, jBtnCancelar, jBtnIncluirProd, jBtnAlterarProd, jBtnExcluirProd
    );
    mcp_util.habilitar(true,
        jBtnIncluir, jBtnAlterar, jBtnExcluir, jBtnPesquisar
    );
        
        try {
        javax.swing.text.MaskFormatter mask = new javax.swing.text.MaskFormatter("##/##/####");
        mask.setPlaceholderCharacter('_');
        jFmtData = new javax.swing.JFormattedTextField(mask);
    } catch (java.text.ParseException ex) {
        ex.printStackTrace();
    }
        
        Mcp_ClientesDAO clientesDAO = new Mcp_ClientesDAO();
        List lista = (List) clientesDAO.listAll();
        for (int i = 0; i < lista.size(); i++) {
            jCboClientes.addItem((McpClientes) lista.get(i));
        }

        Mcp_CuponsDAO cuponsDAO = new Mcp_CuponsDAO();
        List listaCupons = (List) cuponsDAO.listAll();
        for (Object object : listaCupons) {
            jCboCupons.addItem((McpCupons) object);
        }
        
        controllerVendProd = new Mcp_ControllerVendasProdutos();
        controllerVendProd.setList(new ArrayList());
        jTable1.setModel(controllerVendProd);
    }
     public JTable getjTable1() {
        return jTable1;
    }  

    public McpVendas viewBean() {
        McpVendas vendas = new McpVendas();
        vendas.setMcpIdVenda(mcp_util.strToInt(jTxtCodigo.getText()));
        vendas.setMcpDataVenda(mcp_util.strToDate(jFmtData.getText()));
        vendas.setMcpTotal(mcp_util.strToDouble(jTxtTotal.getText()));
        vendas.setMcpFormaPagamento(jTxtFormadePagamento.getText());
        vendas.setMcpObservacoes(jTxtObservacoes.getText());
        vendas.setMcpClientes((McpClientes) jCboClientes.getSelectedItem());
        vendas.setMcpCupons((McpCupons) jCboCupons.getSelectedItem());
        return vendas;
    }

    public void beanView(McpVendas vendas) {
        jTxtCodigo.setText(mcp_util.intToStr(vendas.getMcpIdVenda()));
        jFmtData.setText(mcp_util.dateToStr(vendas.getMcpDataVenda()));
        jTxtTotal.setText(mcp_util.doubleToStr(vendas.getMcpTotal()));
        jTxtFormadePagamento.setText(vendas.getMcpFormaPagamento());
        jTxtObservacoes.setText(vendas.getMcpObservacoes());
        jCboClientes.setSelectedItem(vendas.getMcpClientes());
        jCboCupons.setSelectedItem(vendas.getMcpCupons());
        
        Mcp_VendasProdutosDAO vendasProdutosDAO = new Mcp_VendasProdutosDAO();
        List lista = (List) vendasProdutosDAO.listProdutos(vendas);
        controllerVendProd.setList(lista);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBtnIncluir = new javax.swing.JButton();
        jBtnAlterar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnConfirmar = new javax.swing.JButton();
        jBtnPesquisar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jFmtData = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jBtnIncluirProd = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jBtnAlterarProd = new javax.swing.JButton();
        jTxtTotal = new javax.swing.JTextField();
        jBtnExcluirProd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTxtCodigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTxtFormadePagamento = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTxtObservacoes = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jCboCupons = new javax.swing.JComboBox<McpCupons>();
        jCboClientes = new javax.swing.JComboBox<McpClientes>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jBtnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-adicionar-24.png"))); // NOI18N
        jBtnIncluir.setText("Incluir");
        jBtnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluirActionPerformed(evt);
            }
        });

        jBtnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-change-24.png"))); // NOI18N
        jBtnAlterar.setText("Alterar");
        jBtnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterarActionPerformed(evt);
            }
        });

        jBtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-entrada-proibida-24.png"))); // NOI18N
        jBtnExcluir.setText("Excluir");
        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirActionPerformed(evt);
            }
        });

        jBtnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-ok-24.png"))); // NOI18N
        jBtnConfirmar.setText("Confirmar");
        jBtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConfirmarActionPerformed(evt);
            }
        });

        jBtnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-pesquisar-24.png"))); // NOI18N
        jBtnPesquisar.setText("Pesquisar");
        jBtnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPesquisarActionPerformed(evt);
            }
        });

        jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-cancelar-24.png"))); // NOI18N
        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        jLabel2.setText("Data");

        try {
            jFmtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFmtData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFmtDataActionPerformed(evt);
            }
        });

        jLabel3.setText("Clientes");

        jBtnIncluirProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-adicionar-24.png"))); // NOI18N
        jBtnIncluirProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluirProdActionPerformed(evt);
            }
        });

        jLabel5.setText("Total");

        jBtnAlterarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-change-24.png"))); // NOI18N
        jBtnAlterarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterarProdActionPerformed(evt);
            }
        });

        jBtnExcluirProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-cancelar-24.png"))); // NOI18N
        jBtnExcluirProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirProdActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Codigo");

        jLabel4.setText("Forma de Pagamento");

        jLabel6.setText("Observações");

        jLabel7.setText("Codigo do Cupom");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnIncluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnPesquisar))
                    .addComponent(jLabel7)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jFmtData, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCboCupons, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCboClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtFormadePagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(87, 87, 87))
                            .addComponent(jTxtObservacoes))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnAlterarProd, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBtnIncluirProd, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBtnExcluirProd, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFmtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCboClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtFormadePagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtObservacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCboCupons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBtnIncluir)
                            .addComponent(jBtnAlterar)
                            .addComponent(jBtnExcluir)
                            .addComponent(jBtnConfirmar)
                            .addComponent(jBtnCancelar)
                            .addComponent(jBtnPesquisar)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnIncluirProd)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnAlterarProd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnExcluirProd))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirActionPerformed
         mcp_util.habilitar(true, 
        jTxtCodigo, jFmtData, jCboClientes, jCboCupons, 
        jTxtFormadePagamento, jTxtObservacoes, jTxtTotal,
        jBtnConfirmar, jBtnCancelar, 
        jBtnIncluirProd, jBtnAlterarProd, jBtnExcluirProd
    );
    
    mcp_util.habilitar(false,jBtnIncluir, jBtnAlterar, jBtnExcluir, jBtnPesquisar);
    mcp_util.limpar(jTxtCodigo, jFmtData, jTxtFormadePagamento, jTxtObservacoes, jTxtTotal);
    jFmtData.setText(mcp_util.dateToStr(new Date()));
    controllerVendProd.setList(new ArrayList());
    incluir = true;

    }//GEN-LAST:event_jBtnIncluirActionPerformed

    private void jBtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarActionPerformed
       mcp_util.habilitar(true, jFmtData, jCboClientes, jCboCupons, 
        jTxtFormadePagamento, jTxtObservacoes, jTxtTotal,
        jBtnConfirmar, jBtnCancelar, jBtnIncluirProd, jBtnAlterarProd, jBtnExcluirProd);
    mcp_util.habilitar(false, jBtnIncluir, jBtnAlterar, jBtnExcluir, jBtnPesquisar);
    incluir = false;
    }//GEN-LAST:event_jBtnAlterarActionPerformed

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
        if (mcp_util.pergunta("Deseja excluir esta venda?")==true) {
        Mcp_VendasDAO vendasDAO = new Mcp_VendasDAO();       
        Mcp_VendasProdutosDAO vendasProdutosDAO = new Mcp_VendasProdutosDAO();
        
        for (int ind = 0; ind < jTable1.getRowCount(); ind++) {
            McpVendasProdutos vendasProdutos = controllerVendProd.getBean(ind);
            vendasProdutosDAO.delete(vendasProdutos);
        }
        
        vendasDAO.delete(viewBean()); 
    }
         mcp_util.limpar(jTxtCodigo, jFmtData, jTxtFormadePagamento, jTxtObservacoes, jTxtTotal);
        controllerVendProd.setList(new ArrayList());
        JOptionPane.showMessageDialog(this, "Venda excluída com sucesso!");
    }//GEN-LAST:event_jBtnExcluirActionPerformed

    private void jBtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConfirmarActionPerformed
    Mcp_VendasDAO vendasDAO = new Mcp_VendasDAO();
    Mcp_VendasProdutosDAO vendasProdutosDAO = new Mcp_VendasProdutosDAO();
    McpVendas vendas = viewBean();

    if (incluir == true) {
        vendasDAO.insert(vendas);

        for (int ind = 0; ind < jTable1.getRowCount(); ind++) {
            McpVendasProdutos vendasProdutos = controllerVendProd.getBean(ind);
            vendasProdutos.setMcpVendas(vendas);
            vendasProdutosDAO.insert(vendasProdutos);
        }

    } else {
        vendasDAO.update(vendas);

        vendasProdutosDAO.deleteProdutos(vendas);

        for (int ind = 0; ind < jTable1.getRowCount(); ind++) {
            McpVendasProdutos vendasProdutos = controllerVendProd.getBean(ind);
            vendasProdutos.setMcpVendas(vendas);
            vendasProdutosDAO.insert(vendasProdutos);
        }
    }

    mcp_util.habilitar(false, jTxtCodigo, jFmtData, jCboClientes, jCboCupons,
        jTxtFormadePagamento, jTxtObservacoes, jTxtTotal,
        jBtnConfirmar, jBtnCancelar, jBtnIncluirProd, jBtnAlterarProd, jBtnExcluirProd);

    mcp_util.habilitar(true, jBtnIncluir, jBtnAlterar, jBtnExcluir, jBtnPesquisar);

    mcp_util.limpar(jTxtCodigo, jFmtData, jCboClientes, jCboCupons,
                    jTxtFormadePagamento, jTxtObservacoes, jTxtTotal);

    controllerVendProd.setList(new ArrayList<>());

    JOptionPane.showMessageDialog(this, "Venda salva com sucesso!");

    }//GEN-LAST:event_jBtnConfirmarActionPerformed

    private void jBtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPesquisarActionPerformed
        // TODO add your handling code here:
        Mcp_JDlgVendasPesquisar Mcp_jDlgVendasPesquisar = new Mcp_JDlgVendasPesquisar(null, true);
        Mcp_jDlgVendasPesquisar.setTelaAnterior(this);
        Mcp_jDlgVendasPesquisar.setVisible(true);
    }//GEN-LAST:event_jBtnPesquisarActionPerformed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        mcp_util.habilitar(false, 
        jTxtCodigo, jFmtData, jCboClientes, jCboCupons,
        jTxtFormadePagamento, jTxtObservacoes, jTxtTotal,
        jBtnConfirmar, jBtnCancelar,
        jBtnIncluirProd, jBtnAlterarProd, jBtnExcluirProd
    );
    

    mcp_util.habilitar(true, 
        jBtnIncluir, jBtnAlterar, jBtnExcluir, jBtnPesquisar
    );

    mcp_util.limpar(
        jTxtCodigo, jFmtData,jCboClientes, jCboCupons, jTxtFormadePagamento, jTxtObservacoes, jTxtTotal
    );
    
    controllerVendProd.setList(new ArrayList());
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    private void jBtnIncluirProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirProdActionPerformed
        // TODO add your handling code here:
        Mcp_JDlgVendasProdutos jDlgVendasProdutos = new Mcp_JDlgVendasProdutos(null, true);
        jDlgVendasProdutos.setTelaAnterior(this,null);
        jDlgVendasProdutos.setVisible(true);
    }//GEN-LAST:event_jBtnIncluirProdActionPerformed

    private void jBtnAlterarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarProdActionPerformed
        // TODO add your handling code here:
        Mcp_JDlgVendasProdutos jDlgVendasProdutos = new Mcp_JDlgVendasProdutos(null, true);
        McpVendasProdutos vendasProdutos = controllerVendProd.getBean(jTable1.getSelectedRow());
        jDlgVendasProdutos.setTelaAnterior(this, vendasProdutos);
        jDlgVendasProdutos.setVisible(true);
    }//GEN-LAST:event_jBtnAlterarProdActionPerformed

    private void jBtnExcluirProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirProdActionPerformed
        // TODO add your handling code here:
        if (jTable1.getSelectedRow() == -1) {
        mcp_util.mensagem("Selecione um produto para excluir.");
    } else {
        if (mcp_util.pergunta("Deseja excluir o produto?")==true) {
            controllerVendProd.removeBean(jTable1.getSelectedRow());
        }
    }
    }//GEN-LAST:event_jBtnExcluirProdActionPerformed

    private void jFmtDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFmtDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFmtDataActionPerformed

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
            java.util.logging.Logger.getLogger(Mcp_JDlgVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mcp_JDlgVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mcp_JDlgVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mcp_JDlgVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Mcp_JDlgVendas dialog = new Mcp_JDlgVendas(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jBtnAlterar;
    private javax.swing.JButton jBtnAlterarProd;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnConfirmar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnExcluirProd;
    private javax.swing.JButton jBtnIncluir;
    private javax.swing.JButton jBtnIncluirProd;
    private javax.swing.JButton jBtnPesquisar;
    private javax.swing.JComboBox<McpClientes> jCboClientes;
    private javax.swing.JComboBox<McpCupons> jCboCupons;
    private javax.swing.JFormattedTextField jFmtData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTxtCodigo;
    private javax.swing.JTextField jTxtFormadePagamento;
    private javax.swing.JTextField jTxtObservacoes;
    private javax.swing.JTextField jTxtTotal;
    // End of variables declaration//GEN-END:variables
}
