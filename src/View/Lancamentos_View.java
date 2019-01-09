/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Lancamento_Controller;
import Controller.Lancamentos_Controller;
import Model.Codigo_Atos_Model;
import Model.Ficha_Assinatura_Model;
import Model.Lancamento_Model;
import Model.Pessoas_Model;
import Model.Selos_Model;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Andre
 */
public class Lancamentos_View extends javax.swing.JDialog {

    private String sql_busca;

    /**
     * Creates new form Lancamentos_View
     */
    public Lancamentos_View(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * Metodo que preenche a tabela de lancamentos
     *
     * @param lista_lancamentos
     */
    private void preencher_tabela_lancamentos(List<Lancamento_Model> lista_lancamentos) {

        DefaultTableModel tabela = (DefaultTableModel) tbl_lista_selo.getModel();
        tabela.setNumRows(0);

        for (Lancamento_Model lista_lancamento : lista_lancamentos) {
            tabela.addRow(new Object[]{
                lista_lancamento.getId_lancamento(),
                lista_lancamento.getData_ato(),
                lista_lancamento.getCompetencia_ato(),
                lista_lancamento.getCodigo_ato(),
                lista_lancamento.getDescricao_ato(),
                lista_lancamento.getId_referencia_ato()
            });
        }
    }

    /**
     * Metodo que preenche a tabela descrição dos lancamentos capturados
     *
     * @param id_ato_lancamento
     */
    private void preencher_tabela_descricao_lancamento(String codigo_ato, String ato_referencia) {

        int cod_ato = Integer.parseInt(codigo_ato);
        List<Object> dadosCapturados = new ArrayList<>();

        DefaultTableModel tabelaDescricao = (DefaultTableModel) tbl_descricao_lancamento.getModel();
        tabelaDescricao.setNumRows(0);

        // aqui iremos verificar o tipo de ato que foi realizado
        switch (cod_ato) {

            case Codigo_Atos_Model.CODIGO_RECONHECIMENTO:

                Lancamento_Controller controller = new Lancamento_Controller();

                // capturando os dados da tabela pessoas e o selo utilizado
                dadosCapturados = controller.buscar_vinculos_ato_reconhecimeto_firma(ato_referencia);
                Pessoas_Model pessoa = (Pessoas_Model) dadosCapturados.get(0);
                Selos_Model selo = (Selos_Model) dadosCapturados.get(1);
                Ficha_Assinatura_Model ficha = (Ficha_Assinatura_Model) dadosCapturados.get(2);

                // preenchendo a tabela com valores capturados
                tabelaDescricao.addRow(new Object[]{
                    ato_referencia,
                    pessoa.getNome(),
                    selo.getseqLetras() + selo.getseqNumeros(),
                    ficha.getNumero_ficha()
                });

                break;

            case Codigo_Atos_Model.CODIGO_AUTENTICACAO:

                // capturando dados do ato autenticação
                Lancamento_Controller autenticacao = new Lancamento_Controller();
                dadosCapturados = autenticacao.buscar_vinculos_ato_autenticacao(ato_referencia);

                // realizando CAST
                Selos_Model seloAut = (Selos_Model) dadosCapturados.get(0);
                Integer id_autenticacao = (Integer) dadosCapturados.get(1);

                // preenchendo a tabela com os valores capturados
                tabelaDescricao.addRow(new Object[]{
                    id_autenticacao,
                    "Autenticação",
                    seloAut.getseqLetras() + seloAut.getseqNumeros()
                });
                break;

            case Codigo_Atos_Model.CODIGO_ABERTURA_ASSINATURA:

                Lancamento_Controller abertura = new Lancamento_Controller();
                dadosCapturados = abertura.buscar_vinculos_ato_abertura_assinatura(ato_referencia);

                // realizando Cast
                Pessoas_Model pessoaM = (Pessoas_Model) dadosCapturados.get(0);
                Selos_Model seloM = (Selos_Model) dadosCapturados.get(1);
                Ficha_Assinatura_Model fichaM = (Ficha_Assinatura_Model) dadosCapturados.get(2);
                
                tabelaDescricao.addRow(new Object[]{
                    ato_referencia,
                    pessoaM.getNome(),
                    seloM.getseqLetras() + seloM.getseqNumeros(),
                    fichaM.getNumero_ficha()
                });
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        group_check = new javax.swing.ButtonGroup();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        check_data = new javax.swing.JCheckBox();
        check_todos_lanc = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        campo_data_inicial = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        campo_data_final = new javax.swing.JFormattedTextField();
        btn_buscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_lista_selo = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_descricao_lancamento = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lançamentos");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setBorderPainted(false);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/stop_pequeno.png"))); // NOI18N
        jButton1.setText("Sair");
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Opções", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N

        check_data.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        check_data.setText("Por data");
        check_data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_dataActionPerformed(evt);
            }
        });

        check_todos_lanc.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        check_todos_lanc.setText("Todos lancamentos");
        check_todos_lanc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                check_todos_lancMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setText("Data inicial:");

        try {
            campo_data_inicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campo_data_inicial.setEnabled(false);
        campo_data_inicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campo_data_inicialKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("Data final:");

        try {
            campo_data_final.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campo_data_final.setEnabled(false);
        campo_data_final.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campo_data_finalKeyPressed(evt);
            }
        });

        btn_buscar.setText("Buscar");
        btn_buscar.setEnabled(false);
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(check_data)
                    .addComponent(check_todos_lanc)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(campo_data_final, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                        .addComponent(campo_data_inicial, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(btn_buscar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(check_data)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(check_todos_lanc)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_data_inicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_data_final, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_buscar)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        tbl_lista_selo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tbl_lista_selo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lancamento", "Data lancamento", "Competencia", "Codigo ato", "Descrição", "Ato referencia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_lista_selo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_lista_seloMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_lista_selo);
        if (tbl_lista_selo.getColumnModel().getColumnCount() > 0) {
            tbl_lista_selo.getColumnModel().getColumn(0).setMinWidth(80);
            tbl_lista_selo.getColumnModel().getColumn(0).setMaxWidth(100);
            tbl_lista_selo.getColumnModel().getColumn(1).setMinWidth(80);
            tbl_lista_selo.getColumnModel().getColumn(1).setMaxWidth(120);
            tbl_lista_selo.getColumnModel().getColumn(2).setMinWidth(50);
            tbl_lista_selo.getColumnModel().getColumn(2).setMaxWidth(80);
            tbl_lista_selo.getColumnModel().getColumn(3).setMinWidth(50);
            tbl_lista_selo.getColumnModel().getColumn(3).setMaxWidth(80);
            tbl_lista_selo.getColumnModel().getColumn(4).setMinWidth(100);
            tbl_lista_selo.getColumnModel().getColumn(4).setMaxWidth(200);
            tbl_lista_selo.getColumnModel().getColumn(5).setMinWidth(80);
            tbl_lista_selo.getColumnModel().getColumn(5).setMaxWidth(80);
        }

        tbl_descricao_lancamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descricação", "Selo utilizado", "Ficha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbl_descricao_lancamento);
        if (tbl_descricao_lancamento.getColumnModel().getColumnCount() > 0) {
            tbl_descricao_lancamento.getColumnModel().getColumn(0).setMinWidth(50);
            tbl_descricao_lancamento.getColumnModel().getColumn(0).setMaxWidth(80);
            tbl_descricao_lancamento.getColumnModel().getColumn(1).setMinWidth(150);
            tbl_descricao_lancamento.getColumnModel().getColumn(1).setMaxWidth(250);
            tbl_descricao_lancamento.getColumnModel().getColumn(2).setMinWidth(80);
            tbl_descricao_lancamento.getColumnModel().getColumn(2).setMaxWidth(120);
            tbl_descricao_lancamento.getColumnModel().getColumn(3).setMinWidth(50);
            tbl_descricao_lancamento.getColumnModel().getColumn(3).setMaxWidth(80);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        group_check.add(check_data);
        group_check.add(check_todos_lanc);
    }//GEN-LAST:event_formWindowOpened

    private void check_dataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_dataActionPerformed

        if (check_data.isSelected()) {

            campo_data_final.setEnabled(true);
            campo_data_inicial.setEnabled(true);
            btn_buscar.setEnabled(true);
            campo_data_inicial.requestFocus();

        } else {

            campo_data_final.setEnabled(false);
            campo_data_inicial.setEnabled(false);
        }
    }//GEN-LAST:event_check_dataActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataInicio = LocalDate.parse(campo_data_inicial.getText(), format);
        LocalDate dataFim = LocalDate.parse(campo_data_final.getText(), format);
//        System.out.println(data1);

        sql_busca = "select * from cadastro.tbllancamentos where cadastro.tbllancamentos.data_lanc >=' " + dataInicio + " ' and cadastro.tbllancamentos.data_lanc<=' " + dataFim + " '";

        Lancamento_Controller lancamento = new Lancamento_Controller();
        List<Lancamento_Model> lista_lancamento = new ArrayList<>();

        lista_lancamento = lancamento.buscar_lancamento(sql_busca);

        preencher_tabela_lancamentos(lista_lancamento);
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void tbl_lista_seloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_lista_seloMouseClicked

        int linha = tbl_lista_selo.getSelectedRow();
//        String codLancamento = tbl_lista_selo.getValueAt(linha, 0).toString();
        String cod_ato = tbl_lista_selo.getValueAt(linha, 3).toString();
        String ato_referencia = tbl_lista_selo.getValueAt(linha, 5).toString();

        preencher_tabela_descricao_lancamento(cod_ato, ato_referencia);

//        System.out.println("Linha " + linha +"\n");
//        System.out.println("Codigo ato selecionado: " + cod_ato + "\n");
//        System.out.println("ato de referencia: " + ato_referencia + "\n");

    }//GEN-LAST:event_tbl_lista_seloMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void check_todos_lancMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_check_todos_lancMouseClicked
        if(check_todos_lanc.isSelected()){
            
            sql_busca = "select * from cadastro.tbllancamentos";
            
            Lancamento_Controller lancamento = new Lancamento_Controller();
            List<Lancamento_Model>dados = lancamento.buscar_lancamento(sql_busca);
            
            preencher_tabela_lancamentos(dados);
        } 
    }//GEN-LAST:event_check_todos_lancMouseClicked

    private void campo_data_inicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campo_data_inicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            campo_data_final.requestFocus();
        }
    }//GEN-LAST:event_campo_data_inicialKeyPressed

    private void campo_data_finalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campo_data_finalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btn_buscar.requestFocus();
        }
    }//GEN-LAST:event_campo_data_finalKeyPressed

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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Lancamentos_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lancamentos_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lancamentos_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lancamentos_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Lancamentos_View dialog = new Lancamentos_View(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btn_buscar;
    private javax.swing.JFormattedTextField campo_data_final;
    private javax.swing.JFormattedTextField campo_data_inicial;
    private javax.swing.JCheckBox check_data;
    private javax.swing.JCheckBox check_todos_lanc;
    private javax.swing.ButtonGroup group_check;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tbl_descricao_lancamento;
    private javax.swing.JTable tbl_lista_selo;
    // End of variables declaration//GEN-END:variables
}
