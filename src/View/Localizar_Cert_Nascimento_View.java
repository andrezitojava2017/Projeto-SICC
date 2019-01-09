/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Localizar_Cert_Nasc_Controller;
import Controller.Localizar_Controller;
import Model.Certidao_Model;
import Model.Pessoas_Model;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Andre
 */
public class Localizar_Cert_Nascimento_View extends javax.swing.JFrame {

    // atributos globais desta classe
    private String sql, nomePesquisar, id_Pessoa, sql_certidao, id_certidao_selecionada;

    /**
     * Creates new form Localizar_Cert_Nascimento_View
     */
    public Localizar_Cert_Nascimento_View() {
        initComponents();

        GroupNascimento.add(check_mae);
        GroupNascimento.add(check_pai);
        GroupNascimento.add(check_registrado);

        GroupCasamento.add(check_marido);
        GroupCasamento.add(check_esposa);
    }

    /**
     * Metodo que ira preencher a tabela PESSOA
     *
     * @param infoPessoas List<>
     */
    private void preencherTabelaPessoa(List<Pessoas_Model> infoPessoas) {

        DefaultTableModel tblconsulta = (DefaultTableModel) tblPessoasConsulta.getModel();
        tblconsulta.setNumRows(0);

        int qtdObjt = infoPessoas.size();

        if (qtdObjt != 0) {

            for (Pessoas_Model info : infoPessoas) {

                tblconsulta.addRow(new Object[]{
                    info.getId(),
                    info.getNome()
                });
            }
        } else {
            JOptionPane.showMessageDialog(this, "Não foi encontrado nenhum registro", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Metodo responsavel em preencher a tabela certidao
     *
     * @param infoCertidao
     */
    private void preencherTabelaCertidao(List<Certidao_Model> infoCertidao) {

        DefaultTableModel tblcert = (DefaultTableModel) tblCertidao.getModel();
        tblcert.setNumRows(0);

        // capturando a qtd de objeto no List
        int qtdCert = infoCertidao.size();

        // se houver objetos, entao quer dizer q foi capturado informações
        //caso contrario nao houve informação
        if (qtdCert != 0) {

            // modificando texto da label mensagem
            lblMensagem.setText("");

            // preenchendo a tabela
            for (Certidao_Model certidao : infoCertidao) {

                tblcert.addRow(new Object[]{
                    certidao.getId_certidao(),
                    certidao.getLivro(),
                    certidao.getFolha(),
                    certidao.getTermo(),
                    certidao.getData_lavratura(),
                    certidao.getMatricula()

                });
            }
        } else {
            lblMensagem.setText("Não foi encontrado Registros!");
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

        GroupTipoCertidao = new javax.swing.ButtonGroup();
        GroupNascimento = new javax.swing.ButtonGroup();
        GroupCasamento = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCertidao = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        campoNomePesquisa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnLocalizar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPessoasConsulta = new javax.swing.JTable();
        lblMensagem = new javax.swing.JLabel();
        btnImprimirCertidao = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        check_nascimento = new javax.swing.JCheckBox();
        check_casamento = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        check_pai = new javax.swing.JRadioButton();
        check_mae = new javax.swing.JRadioButton();
        check_registrado = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        check_marido = new javax.swing.JRadioButton();
        check_esposa = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Localizar Certidao");
        setResizable(false);

        tblCertidao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nº Livro", "Nº Folha", "Nº Termo", "Lavratura", "Matricula"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCertidao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCertidaoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCertidao);
        if (tblCertidao.getColumnModel().getColumnCount() > 0) {
            tblCertidao.getColumnModel().getColumn(0).setMinWidth(10);
            tblCertidao.getColumnModel().getColumn(0).setMaxWidth(50);
            tblCertidao.getColumnModel().getColumn(1).setMinWidth(40);
            tblCertidao.getColumnModel().getColumn(1).setMaxWidth(120);
            tblCertidao.getColumnModel().getColumn(2).setMinWidth(40);
            tblCertidao.getColumnModel().getColumn(2).setMaxWidth(120);
            tblCertidao.getColumnModel().getColumn(3).setMinWidth(40);
            tblCertidao.getColumnModel().getColumn(3).setMaxWidth(120);
            tblCertidao.getColumnModel().getColumn(4).setMinWidth(50);
            tblCertidao.getColumnModel().getColumn(4).setMaxWidth(120);
            tblCertidao.getColumnModel().getColumn(5).setMinWidth(100);
            tblCertidao.getColumnModel().getColumn(5).setMaxWidth(200);
        }

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        campoNomePesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoNomePesquisaKeyPressed(evt);
            }
        });

        jLabel1.setText("Nome:");

        btnLocalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Consulta_LOCALIZAR.png"))); // NOI18N
        btnLocalizar.setEnabled(false);
        btnLocalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(campoNomePesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnLocalizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoNomePesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(btnLocalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tblPessoasConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPessoasConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPessoasConsultaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPessoasConsulta);
        if (tblPessoasConsulta.getColumnModel().getColumnCount() > 0) {
            tblPessoasConsulta.getColumnModel().getColumn(0).setMinWidth(20);
            tblPessoasConsulta.getColumnModel().getColumn(0).setMaxWidth(50);
            tblPessoasConsulta.getColumnModel().getColumn(1).setMinWidth(100);
            tblPessoasConsulta.getColumnModel().getColumn(1).setMaxWidth(400);
        }

        lblMensagem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblMensagem.setForeground(new java.awt.Color(255, 0, 0));

        btnImprimirCertidao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/impressora.png"))); // NOI18N
        btnImprimirCertidao.setText("Imprimir");
        btnImprimirCertidao.setEnabled(false);
        btnImprimirCertidao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirCertidaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnImprimirCertidao)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(171, 171, 171))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImprimirCertidao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Escolha uma Certidao"));
        jPanel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        check_nascimento.setText("Nascimento");
        check_nascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_nascimentoActionPerformed(evt);
            }
        });

        check_casamento.setText("Casamento");
        check_casamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_casamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(check_nascimento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(check_casamento)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(check_nascimento)
                    .addComponent(check_casamento))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Nascimento"));
        jPanel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        check_pai.setText("Pai");
        check_pai.setEnabled(false);
        check_pai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                check_paiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                check_paiMouseEntered(evt);
            }
        });
        check_pai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_paiActionPerformed(evt);
            }
        });

        check_mae.setText("Mae");
        check_mae.setEnabled(false);
        check_mae.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                check_maeMouseClicked(evt);
            }
        });

        check_registrado.setText("Registrado");
        check_registrado.setEnabled(false);
        check_registrado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                check_registradoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(check_pai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(check_mae)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(check_registrado)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(check_pai)
                    .addComponent(check_mae)
                    .addComponent(check_registrado)))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Casamento"));
        jPanel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        check_marido.setText("Marido");
        check_marido.setEnabled(false);
        check_marido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                check_maridoMouseClicked(evt);
            }
        });

        check_esposa.setText("Esposa");
        check_esposa.setEnabled(false);
        check_esposa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                check_esposaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(check_marido)
                    .addComponent(check_esposa))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(check_marido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(check_esposa)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(171, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void check_nascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_nascimentoActionPerformed
        // verificando se esta marcado
        if (check_nascimento.isSelected()) {

            check_casamento.setSelected(false);
            check_marido.setEnabled(false);
            check_esposa.setEnabled(false);

            //ativando botoes
            check_mae.setEnabled(true);
            check_pai.setEnabled(true);
            check_registrado.setEnabled(true);
        } else if (check_nascimento.isSelected() == false) {
            // desativando botoes
            check_mae.setEnabled(false);
            check_pai.setEnabled(false);
            check_registrado.setEnabled(false);
        }
    }//GEN-LAST:event_check_nascimentoActionPerformed

    private void check_casamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_casamentoActionPerformed
        // verificando
        if (check_casamento.isSelected()) {

            check_nascimento.setSelected(false);
            check_mae.setEnabled(false);
            check_pai.setEnabled(false);
            check_registrado.setEnabled(false);

            // ativando botoes
            check_marido.setEnabled(true);
            check_esposa.setEnabled(true);
        } else {
            check_marido.setEnabled(false);
            check_esposa.setEnabled(false);
        }
    }//GEN-LAST:event_check_casamentoActionPerformed

    private void check_paiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_check_paiMouseClicked

        // essa string sera completada quando o usuario escolher  A PESSOA(tabela),
        // ao clicar em uma opção da tabela, sera copiado esta string e add o id_pessoa selecinado, dpois
        // enviada para o metodo que ira ler a tabela nascimento
        this.sql_certidao = " where id_pai=";
    }//GEN-LAST:event_check_paiMouseClicked

    private void check_maeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_check_maeMouseClicked

        // essa string sera completada quando o usuario escolher  A PESSOA(tabela),
        // ao clicar em uma opção da tabela, sera copiado esta string e add o id_pessoa selecinado, dpois
        // enviada para o metodo que ira ler a tabela nascimento
        this.sql_certidao = " where id_mae=";
    }//GEN-LAST:event_check_maeMouseClicked

    private void check_registradoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_check_registradoMouseClicked

        // essa string sera completada quando o usuario escolher  A PESSOA(tabela),
        // ao clicar em uma opção da tabela, sera copiado esta string e add o id_pessoa selecinado, dpois
        // enviada para o metodo que ira ler a tabela nascimento
        this.sql_certidao = " where id_registrando=";
    }//GEN-LAST:event_check_registradoMouseClicked

    private void btnLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizarActionPerformed
        // verificando campo não esta em brnco
        if (campoNomePesquisa.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ops! Preencha o campo para busca", "Mensagem", JOptionPane.ERROR_MESSAGE);
        } else {

            // capturando informação inserida no campo de pesquisa
            String pesquisar = campoNomePesquisa.getText();

            // verificamos que tipo de certidao iremos buscar, em Nascimentos ou Casamentos
            if (check_nascimento.isSelected()) {

                // aqui iremos verificar qual opção esta marcada: Pai, Mae ou Registrando
                // caso Pai ou Mae, a busca sao realizadas na tabela Pessoa
                // caso registrado, a busca sera realizada na tabela Registrando, portanto é utilizada outro Metodo da classe DAO
                if (check_pai.isSelected() || check_mae.isSelected()) {

                    // como Pai e Mae são dados da tabela Pessoas, podemos fazer uma busca por sexo
                    if (check_pai.isSelected()) {
                        Localizar_Controller localizar_pai = new Localizar_Controller();

                        List<Pessoas_Model> Pessoas_Retorno = localizar_pai.LocalizardadosPessoa(pesquisar, "Masculino");

                        // passando o objeto lista para o metodo que preenche a tabela pessoa
                        preencherTabelaPessoa(Pessoas_Retorno);

                    } else if (check_mae.isSelected()) {

                        // caso a opção Mae esteja selecionado, iremos buscar na Tabela Pessoas, 
                        // somente pessoas do sexo Feminino
                        Localizar_Controller localizar_mae = new Localizar_Controller();
                        List<Pessoas_Model> Pessoas_Retorno = localizar_mae.LocalizardadosPessoa(pesquisar, "Feminino");

                        // passando o objeto lista para o metodo que preenche a tabela pessoa
                        preencherTabelaPessoa(Pessoas_Retorno);
                    }
                } else if (check_registrado.isSelected()) {

                    // caso a opção Registrado esteja selecionado, iremos fazer a busca na tabela Registrado
                    Localizar_Controller localizar_registrado = new Localizar_Controller();

                    List<Pessoas_Model> Pessoas_Retorno = localizar_registrado.pesquisarDadosRegistrando(pesquisar);

                    // passando o objeto lista para o metodo que preenche a tabela pessoa
                    preencherTabelaPessoa(Pessoas_Retorno);
                }

            } else if (check_casamento.isSelected()) {

                // verificando se o check MARIDO esta marcado
                if (check_marido.isSelected()) {

                    Localizar_Controller localizar_marido = new Localizar_Controller();

                    // capturando todos pessas do sexo masculino da tabela pessoa
                    List<Pessoas_Model> pessoas_retorno = localizar_marido.LocalizardadosPessoa(pesquisar, "Masculino");

                    // passando o objeto lista para o metodo que preenche a tabela pessoa
                    preencherTabelaPessoa(pessoas_retorno);
                } else if (check_esposa.isSelected()) {

                    Localizar_Controller localizar_marido = new Localizar_Controller();

                    // capturando todos pessas do sexo masculino da tabela pessoa
                    List<Pessoas_Model> pessoas_retorno = localizar_marido.LocalizardadosPessoa(pesquisar, "Feminino");

                    // passando o objeto lista para o metodo que preenche a tabela pessoa
                    preencherTabelaPessoa(pessoas_retorno);

                }
            }
        }
    }//GEN-LAST:event_btnLocalizarActionPerformed

    private void campoNomePesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNomePesquisaKeyPressed
        // TODO add your handling code here:
        btnLocalizar.setEnabled(true);
    }//GEN-LAST:event_campoNomePesquisaKeyPressed

    private void check_paiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_paiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_check_paiActionPerformed

    private void tblPessoasConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPessoasConsultaMouseClicked
        // Capturando o id da pessoa selecionada
        int linha = tblPessoasConsulta.getSelectedRow();
        this.id_Pessoa = tblPessoasConsulta.getValueAt(linha, 0).toString();

        // verificando qual opção de certidao foi selecionado na busca
        // assin definimos qual tabela(Nascimento ou Casamento) iremos percorrer
        if (check_nascimento.isSelected()) {

            // essa sera a string que ira para o metodo de busca da camada DAO
            String nova_sql = this.sql_certidao + id_Pessoa;

            // instanciando objeto controller
            Localizar_Cert_Nasc_Controller DAO = new Localizar_Cert_Nasc_Controller();

            // instanciando objeto tipo Certidao_Model, para armazenar o retorno do metodo
            List<Certidao_Model> infoCertidao;

            // chamando metodo e armazenando o retorno da busca
            infoCertidao = DAO.localizarCertNascimento(nova_sql);

            // passando os dados capturados para o metodo responsavel em preencher a tabela de certidao
            preencherTabelaCertidao(infoCertidao);
            
        } else if(check_casamento.isSelected()){
            
            // essa sera a string que ira para o metodo de busca da camada DAO
            String nova_sql = this.sql_certidao + id_Pessoa;

            // instanciando objeto controller
            Localizar_Cert_Nasc_Controller DAO = new Localizar_Cert_Nasc_Controller();

            // instanciando objeto tipo Certidao_Model, para armazenar o retorno do metodo
            List<Certidao_Model> infoCertidao;

            // chamando metodo e armazenando o retorno da busca
            infoCertidao = DAO.Localizar_Certidao_Casamento(nova_sql);

            // passando os dados capturados para o metodo responsavel em preencher a tabela de certidao
            preencherTabelaCertidao(infoCertidao);
        }
    }//GEN-LAST:event_tblPessoasConsultaMouseClicked

    private void check_paiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_check_paiMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_check_paiMouseEntered

    private void tblCertidaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCertidaoMouseClicked
        // capturando id da certidao que sera visualizada
        int linha = tblCertidao.getSelectedRow();
        this.id_certidao_selecionada = tblCertidao.getValueAt(linha, 0).toString();
        //ativado botao imprimir
        btnImprimirCertidao.setEnabled(true);

//        System.out.println("Id certidao selecionada: " + id_certidao_selecionada);
    }//GEN-LAST:event_tblCertidaoMouseClicked

    private void btnImprimirCertidaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirCertidaoActionPerformed

        Localizar_Cert_Nasc_Controller imprimir = new Localizar_Cert_Nasc_Controller();
        imprimir.imprimirCertidaoNascimento(id_certidao_selecionada);
    }//GEN-LAST:event_btnImprimirCertidaoActionPerformed

    private void check_maridoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_check_maridoMouseClicked
        // essa string sera completada quando o usuario escolher  A PESSOA(tabela),
        // ao clicar em uma opção da tabela, sera copiado esta string e add o id_pessoa selecinado, dpois
        // enviada para o metodo que ira ler a tabela nascimento
        this.sql_certidao = " where id_marido=";
    }//GEN-LAST:event_check_maridoMouseClicked

    private void check_esposaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_check_esposaMouseClicked
        // essa string sera completada quando o usuario escolher  A PESSOA(tabela),
        // ao clicar em uma opção da tabela, sera copiado esta string e add o id_pessoa selecinado, dpois
        // enviada para o metodo que ira ler a tabela nascimento
        this.sql_certidao = " where id_esposa=";
    }//GEN-LAST:event_check_esposaMouseClicked

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
            java.util.logging.Logger.getLogger(Localizar_Cert_Nascimento_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Localizar_Cert_Nascimento_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Localizar_Cert_Nascimento_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Localizar_Cert_Nascimento_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Localizar_Cert_Nascimento_View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GroupCasamento;
    private javax.swing.ButtonGroup GroupNascimento;
    private javax.swing.ButtonGroup GroupTipoCertidao;
    private javax.swing.JButton btnImprimirCertidao;
    private javax.swing.JButton btnLocalizar;
    private javax.swing.JTextField campoNomePesquisa;
    private javax.swing.JCheckBox check_casamento;
    private javax.swing.JRadioButton check_esposa;
    private javax.swing.JRadioButton check_mae;
    private javax.swing.JRadioButton check_marido;
    private javax.swing.JCheckBox check_nascimento;
    private javax.swing.JRadioButton check_pai;
    private javax.swing.JRadioButton check_registrado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblMensagem;
    private javax.swing.JTable tblCertidao;
    private javax.swing.JTable tblPessoasConsulta;
    // End of variables declaration//GEN-END:variables
}
