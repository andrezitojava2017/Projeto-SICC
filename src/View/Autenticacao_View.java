/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Autenticacao_Controller;
import Controller.Lancamento_Controller;
import Controller.Selos_Controller;
import Model.Codigo_Atos_Model;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author andresito
 */
public class Autenticacao_View extends javax.swing.JFrame {

    /**
     * Creates new form FormAutenticacao
     */
    public Autenticacao_View() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaTexto = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        campoUltimoSelo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        campoCusto = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        campoProximoSelo = new javax.swing.JTextField();
        jToolBar1 = new javax.swing.JToolBar();
        btnGravarAto = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btnSair = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        lblData = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Autenticação");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mensagem", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N

        areaTexto.setEditable(false);
        areaTexto.setColumns(20);
        areaTexto.setLineWrap(true);
        areaTexto.setRows(5);
        areaTexto.setText("Certifico e dou fé de que é copia fiel do documento que me foi apresentado.\nSão Jose do Xingu-MT.\n");
        jScrollPane1.setViewportView(areaTexto);

        jLabel1.setText("Ultimo selo:");

        campoUltimoSelo.setEditable(false);

        jLabel2.setText("Custo:");

        campoCusto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));

        jLabel3.setText("Proximo selo:");

        campoProximoSelo.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoUltimoSelo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoProximoSelo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoUltimoSelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(campoCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(campoProximoSelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jToolBar1.setFloatable(false);
        jToolBar1.setBorderPainted(false);

        btnGravarAto.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnGravarAto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/success.png"))); // NOI18N
        btnGravarAto.setText("Salvar");
        btnGravarAto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarAtoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnGravarAto);
        jToolBar1.add(jSeparator4);

        btnSair.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/stop_pequeno.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSair);
        jToolBar1.add(jSeparator3);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        lblData.setText("Data:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblData))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGravarAtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarAtoActionPerformed
        // instanciando objeto pra capturar selo
        Selos_Controller salvarSelo = new Selos_Controller();
        String letras[];

        // capturando sequencia de letras e numeros na tabela selos
        letras = salvarSelo.capturarSelo();

        // capturando o custo do ato
        if (campoCusto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Campo custo nao pode ser embranco", "Atençaão", JOptionPane.ERROR_MESSAGE);
        } else {

            double custo = Double.parseDouble(campoCusto.getText().replace(",", "."));

            // gravando o selo utilizado  e recuperando o ID  
            //letras[0] = letras, letras[1] = ultimoSelo, letras[2] = proximoSelo
            int id_selo = salvarSelo.gravarSelo(letras[0], letras[2], custo);

            // verifica se o IDSELO foi capturado
            if (id_selo != 0) {

                // instanceia objeto controller para acessar metodos
                Autenticacao_Controller gravarAutn = new Autenticacao_Controller();

                // chmanando metodo que faz a gravação na tabela autenticação
                // enviando como parametro o ID do selo utilizado
                int id_ato = gravarAutn.gravarAutenticacao(id_selo);
                
//                System.out.println("id do ato: " + id_ato);

                if (id_ato != 0) {
                    
                    Lancamento_Controller lancamento = new Lancamento_Controller();
                    lancamento.salvarNovoLancamento(id_selo,Codigo_Atos_Model.CODIGO_AUTENTICACAO, "Autenticação", custo, id_ato);
                    
                } else {
                      btnGravarAto.requestFocus();
                }
            } else {
                //msg de erro caso idselo esteja zerado
                JOptionPane.showMessageDialog(null, "Autenticação não foi salva", "Mensagem", JOptionPane.INFORMATION_MESSAGE);

            }
        }

    }//GEN-LAST:event_btnGravarAtoActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // objeto tipo selo_controller para capturar o selos
        Selos_Controller captSelo = new Selos_Controller();

        //armazenando o retorno do metodo com valores dos selos
        String selos[] = captSelo.capturarSelo();

        // preenchendo campos referente aos ultimo e proximo selo
        campoUltimoSelo.setText(selos[0] + selos[1]);
        campoProximoSelo.setText(selos[0] + selos[2]);

        Date dta = new Date();
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
        lblData.setText(df.format(dta));

    }//GEN-LAST:event_formWindowActivated

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed

        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

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
            java.util.logging.Logger.getLogger(Autenticacao_View.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Autenticacao_View.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Autenticacao_View.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Autenticacao_View.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Autenticacao_View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaTexto;
    private javax.swing.JButton btnGravarAto;
    private javax.swing.JButton btnSair;
    private javax.swing.JFormattedTextField campoCusto;
    private javax.swing.JTextField campoProximoSelo;
    private javax.swing.JTextField campoUltimoSelo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblData;
    // End of variables declaration//GEN-END:variables
}