/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Nascimento_Controller;
import Model.Certidao_Model;
import Model.Pessoas_Model;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Andre
 */
public class Alterar_Registrando_View extends javax.swing.JDialog {

    private String selecionado;
    /**
     * Creates new form Alterar_Registrando_View
     */
    public Alterar_Registrando_View(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * Metodo responsavel em preencher os campos da aba REGISTRANDO
     *
     * @param id
     */
    private void preencherCamposRegistrando(String id) {

        Nascimento_Controller dados_registrando = new Nascimento_Controller();
        ArrayList<Object> registrado = dados_registrando.capturarDadosRegistrado(id);

        // capturando os objeto do array
        // Posicao [0] sempre sera Certidao_Model
        // Posicao [1] sempre sera Pessoas_Model
        Certidao_Model certidao = (Certidao_Model) registrado.get(0);
        Pessoas_Model pessoa = (Pessoas_Model) registrado.get(1);

        DateTimeFormatter formt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse(certidao.getData_nasc());
        campoCidadeRegis.setText(certidao.getCidade_registro());
        comboEstadoRegis.setSelectedItem(certidao.getEstado_reg());
        campoDataNasc.setText(String.valueOf(formt.format(data)));
        campoHoraNasc.setText(certidao.getHora_nasc());
        campoNomeRegis.setText(pessoa.getNome());
        campoCidadeNasc.setText(certidao.getCidade_nasc());
        comboEstadoNasc.setSelectedItem(certidao.getEstado_nasc());
        campoLocalNasc.setText(certidao.getLocal_nasc());
        comboSexo_registrando.setSelectedItem(certidao.getSexo());
        comboGemeo.setSelectedItem(certidao.getGemeos());
        campoMatriculaGemeo.setText(certidao.getMatricula_gemeo());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboEstadoRegis = new javax.swing.JComboBox<>();
        campoCidadeNasc = new javax.swing.JTextField();
        comboEstadoNasc = new javax.swing.JComboBox<>();
        campoLocalNasc = new javax.swing.JTextField();
        comboSexo_registrando = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        comboGemeo = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        campoMatriculaGemeo = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        campoHoraNasc = new javax.swing.JFormattedTextField();
        campoCidadeRegis = new javax.swing.JTextField();
        campoDataNasc = new javax.swing.JFormattedTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        campoNomeRegis = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnSalvarAteracao = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnLocalizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alterar dados do registrado");

        comboEstadoRegis.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        comboEstadoRegis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" }));

        comboEstadoNasc.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        comboEstadoNasc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" }));

        comboSexo_registrando.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        comboSexo_registrando.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino" }));

        jLabel29.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel29.setText("Cidade nascimento:");

        jLabel17.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel17.setText("Gemeo:");

        jLabel30.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel30.setText("Estado:");

        comboGemeo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        comboGemeo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));

        jLabel31.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel31.setText("Local Nascimento:");

        jLabel18.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel18.setText("Matricula Gemeo:");

        jLabel32.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel32.setText("Sexo:");

        campoMatriculaGemeo.setText("*  *  *");

        jLabel33.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel33.setText("Estado:");

        try {
            campoHoraNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            campoDataNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel27.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel27.setText("Horário Nasc:");

        jLabel25.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel25.setText("Cidade registro:");

        jLabel26.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel26.setText("Data Nascimento:");

        jLabel28.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel28.setText("Nome registrando:");

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setText("ALTERAR DADOS DO REGISTRADO");

        btnSalvarAteracao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/document_save_as.png"))); // NOI18N
        btnSalvarAteracao.setText("Salvar alteração");
        btnSalvarAteracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarAteracaoActionPerformed(evt);
            }
        });

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/stop_pequeno.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnLocalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Consulta_LOCALIZAR.png"))); // NOI18N
        btnLocalizar.setText("Localizar");
        btnLocalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(jLabel25))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoCidadeRegis, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboEstadoRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoNomeRegis, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(campoDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoHoraNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnSair)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(18, 18, 18)
                                .addComponent(comboGemeo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoMatriculaGemeo))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel29)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoCidadeNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel31)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoLocalNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(jLabel30)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(comboEstadoNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(jLabel32)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(comboSexo_registrando, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSalvarAteracao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLocalizar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(campoCidadeRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33)
                    .addComponent(comboEstadoRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27)
                    .addComponent(campoHoraNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(campoNomeRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel29)
                        .addComponent(campoCidadeNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel30)
                        .addComponent(comboEstadoNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel32)
                        .addComponent(comboSexo_registrando, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoLocalNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(comboGemeo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(campoMatriculaGemeo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvarAteracao)
                    .addComponent(btnSair)
                    .addComponent(btnLocalizar))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnSalvarAteracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarAteracaoActionPerformed
        Pessoas_Model reg = new Pessoas_Model();
        Nascimento_Controller atualizar = new Nascimento_Controller();
        Certidao_Model cert = new Certidao_Model();

        // verificando campos
        if (campoNomeRegis.getText().isEmpty() || campoCidadeRegis.getText().isEmpty() || campoDataNasc.getText().isEmpty() || campoHoraNasc.getText().isEmpty() || campoCidadeNasc.getText().isEmpty() || campoLocalNasc.getText().isEmpty() || campoMatriculaGemeo.getText().isEmpty()) {

            // mensagem de erro
            JOptionPane.showMessageDialog(null, "Preencha todos os campos do registrando", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {

            int opt = JOptionPane.showConfirmDialog(this, "Confirma a alteração de informações do registrado " + campoNomeRegis.getText(), "Confirmação", JOptionPane.YES_NO_OPTION);
            
//            System.out.println(opt);

            if (opt == 0) {

                cert.setCidade_registro(campoCidadeRegis.getText());
                cert.setEstado_reg(comboEstadoRegis.getSelectedItem().toString());
                cert.setHora_nasc(campoHoraNasc.getText());
                cert.setData_nasc(campoDataNasc.getText());
                reg.setNome(campoNomeRegis.getText());
                cert.setCidade_nasc(campoCidadeNasc.getText());
                cert.setEstado_nasc(comboEstadoNasc.getSelectedItem().toString());
                cert.setLocal_nasc(campoLocalNasc.getText());
                cert.setSexo(comboSexo_registrando.getSelectedItem().toString());
                cert.setGemeos(comboGemeo.getSelectedItem().toString());
                cert.setMatricula_gemeo(campoMatriculaGemeo.getText());

                atualizar.atualizarDadosRegistrado(selecionado, reg, cert);
            } else {
                btnSair.requestFocus();                
            }
        }

    }//GEN-LAST:event_btnSalvarAteracaoActionPerformed

    private void btnLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizarActionPerformed

        Localizar_Pessoas_View localizar = new Localizar_Pessoas_View(null, true, 1);
        localizar.setVisible(true);

        if (localizar.id_selecionado != null) {
            
            selecionado = localizar.id_selecionado;
            preencherCamposRegistrando(localizar.id_selecionado);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum registro foi selecionado", "Mensagem", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnLocalizarActionPerformed

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
            java.util.logging.Logger.getLogger(Alterar_Registrando_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Alterar_Registrando_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Alterar_Registrando_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Alterar_Registrando_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Alterar_Registrando_View dialog = new Alterar_Registrando_View(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnLocalizar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvarAteracao;
    private javax.swing.JTextField campoCidadeNasc;
    private javax.swing.JTextField campoCidadeRegis;
    private javax.swing.JFormattedTextField campoDataNasc;
    private javax.swing.JFormattedTextField campoHoraNasc;
    private javax.swing.JTextField campoLocalNasc;
    private javax.swing.JTextField campoMatriculaGemeo;
    private javax.swing.JTextField campoNomeRegis;
    private javax.swing.JComboBox<String> comboEstadoNasc;
    private javax.swing.JComboBox<String> comboEstadoRegis;
    private javax.swing.JComboBox<String> comboGemeo;
    private javax.swing.JComboBox<String> comboSexo_registrando;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    // End of variables declaration//GEN-END:variables
}
