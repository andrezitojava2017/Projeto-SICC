/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Localizar_Cert_Nasc_Controller;
import Model.Certidao_Model;
import Model.Pessoas_Model;
import java.util.List;

/**
 *
 * @author Andre
 */
public class Exibir_Cert_Nascimento_View extends javax.swing.JDialog {

    /**
     * Creates new form Exibir_Cert_Nascimento_View
     */
    public Exibir_Cert_Nascimento_View(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * Metodo construto que recebe o ID da certidao, e faz a chamada do metodo preencherCertidaoMoelo()
     * para preencher todos os campos
     * @param parent
     * @param modal
     * @param id_cert_selec 
     */
    public Exibir_Cert_Nascimento_View(java.awt.Frame parent, boolean modal, String id_cert_selec) {
        super(parent, modal);
        initComponents();

        preencherCertidaoModelo(id_cert_selec);

    }

    /**
     * Metodo responsavem em preencher os campos da tela Exibir certidao View
     * @param id_cert 
     */
    private void preencherCertidaoModelo(String id_cert) {
    
        // instanciando objetos que serão utilizados
        Certidao_Model certidao;
        Pessoas_Model registrado;
        Pessoas_Model pai;
        Pessoas_Model mae;

        // instanciando objeto da camada CONTROLLER
        Localizar_Cert_Nasc_Controller buscar = new Localizar_Cert_Nasc_Controller();
        
        // atributo que ira armazenar a List de objetos retornados
        List<Object> dadosCertidao;

        // chamando metodo da camda DAO
        // cpaturando o valor de retorno, que é uma List de objetos, do tpo Pessoas_Model, Certidao_model
        dadosCertidao = buscar.dadosCertidao(id_cert);


        // capturando a qtd de objetos dentro do List
        int qtd_obj = dadosCertidao.size();

//        System.out.println("quantidade objetos: " + qtd_obj);
        
        // verificando a quantidade de objetos dentro da List, caso seja 4, entao foi lido as tabelas: NASCIMENTO, PAI, MAE e REGISTRANDO
        if (qtd_obj == 4) {

            certidao = (Certidao_Model) dadosCertidao.get(0);
            pai = (Pessoas_Model) dadosCertidao.get(1);
            mae = (Pessoas_Model) dadosCertidao.get(2);
            registrado = (Pessoas_Model) dadosCertidao.get(3);

            lblMatricula.setText(certidao.getMatricula());
            lblNomeRegistrando.setText(registrado.getNome());
            lblDataNormal.setText(certidao.getData_nasc());
            lblHoraNascimento.setText(certidao.getHora_nasc());
            lblCidadeNascimento.setText(certidao.getCidade_nasc() + "-" + certidao.getEstado_nasc());
            lblCidadeRegistro.setText(certidao.getCidade_registro() + "-" + certidao.getEstado_reg());
            lblLocalNascimento.setText(certidao.getLocal_nasc());
            lblSexo.setText(certidao.getSexo());
            lblNomePai.setText(pai.getNome());
            lblNomeMae.setText(mae.getNome());
            lblAvosPaternos.setText(pai.getPai() + " e " + pai.getMae());
            lblAvosMaternos.setText(mae.getPai() + " e " + mae.getMae());
            lblGemeo.setText(certidao.getGemeos());
            lblMatriculaGemeo.setText(certidao.getMatricula_gemeo());
            lblDecNascidoVivo.setText(certidao.getDecl_nasc_vivo());

        } else {

            // se for diferente de 4, provavelmente <4, indica que a tabela PAI não esta incluida
            // indicando que a certidao não houve PAI PRESENTE
            
            certidao = (Certidao_Model) dadosCertidao.get(0); // CAST do 1º objeto em Certidao_Model
            mae = (Pessoas_Model) dadosCertidao.get(1);         // CAST do 2º objeto em Pessoas_Model
            registrado = (Pessoas_Model) dadosCertidao.get(2);  // CAST do 3º objeto em PESSOAS_MODEL

            lblMatricula.setText(certidao.getMatricula());
            lblNomeRegistrando.setText(registrado.getNome());
            lblDataNormal.setText(certidao.getData_nasc());
            lblHoraNascimento.setText(certidao.getHora_nasc());
            lblCidadeNascimento.setText(certidao.getCidade_nasc() + "-" + certidao.getEstado_nasc());
            lblCidadeRegistro.setText(certidao.getCidade_registro() + "-" + certidao.getEstado_reg());
            lblLocalNascimento.setText(certidao.getLocal_nasc());
            lblSexo.setText(certidao.getSexo());
            lblNomePai.setText("Não declarado");
            lblNomeMae.setText(mae.getNome());
            lblAvosPaternos.setText("Não declarados");
            lblAvosMaternos.setText(mae.getPai() + " e " + mae.getMae());
            lblGemeo.setText(certidao.getGemeos());
            lblMatriculaGemeo.setText(certidao.getMatricula_gemeo());
            lblDecNascidoVivo.setText(certidao.getDecl_nasc_vivo());
             
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

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblMatricula = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblNomeRegistrando = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblDataExtenso = new javax.swing.JLabel();
        lblDataNormal = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblHoraNascimento = new javax.swing.JLabel();
        lblCidadeNascimento = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lblCidadeRegistro = new javax.swing.JLabel();
        lblLocalNascimento = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblNomePai = new javax.swing.JLabel();
        lblNomeMae = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        lblAvosPaternos = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        lblAvosMaternos = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblGemeo = new javax.swing.JLabel();
        lblMatriculaGemeo = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        lblDataRegistro = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        lblDecNascidoVivo = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Visualizador");

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel6.setText("CERTIDÃO DE NASCIMENTO");

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel7.setText("MATRICULA:");

        lblMatricula.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        lblMatricula.setText("XXXXX");

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel9.setText("NOME:");

        lblNomeRegistrando.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        lblNomeRegistrando.setText("nome");

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jLabel11.setText("Data de Nascimento:");

        lblDataExtenso.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        lblDataExtenso.setText("data extenso");
        lblDataExtenso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblDataNormal.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        lblDataNormal.setText("dd/MM/yyyy");
        lblDataNormal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel17.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jLabel17.setText("Hora:");

        jLabel18.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jLabel18.setText("Municipio e UF");

        lblHoraNascimento.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        lblHoraNascimento.setText("hh:mm");
        lblHoraNascimento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblCidadeNascimento.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        lblCidadeNascimento.setText("so jose do xing-MT");
        lblCidadeNascimento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel21.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jLabel21.setText("Municipio de Registro e UF");

        jLabel22.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jLabel22.setText("Local de Nascimento");

        jLabel23.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jLabel23.setText("Sexo");

        lblCidadeRegistro.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        lblCidadeRegistro.setText("jLabel24");
        lblCidadeRegistro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblLocalNascimento.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        lblLocalNascimento.setText("jLabel25");
        lblLocalNascimento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblSexo.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        lblSexo.setText("jLabel26");
        lblSexo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel27.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jLabel27.setText("Filiação");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblNomePai.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        lblNomePai.setText("Pai");

        lblNomeMae.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        lblNomeMae.setText("Mae:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNomePai, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNomeMae, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblNomePai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNomeMae)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel30.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jLabel30.setText("Avos");

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel31.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jLabel31.setText("Paternos:");

        lblAvosPaternos.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        lblAvosPaternos.setText("jLabel32");

        jLabel33.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jLabel33.setText("Maternos:");

        lblAvosMaternos.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        lblAvosMaternos.setText("jLabel34");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAvosPaternos, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblAvosMaternos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(lblAvosPaternos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(lblAvosMaternos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jLabel2.setText("Gemeo");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jLabel3.setText("Matricula Gemeo");

        lblGemeo.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        lblGemeo.setText("jLabel4");
        lblGemeo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblMatriculaGemeo.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        lblMatriculaGemeo.setText("jLabel5");
        lblMatriculaGemeo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel35.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jLabel35.setText("Data registro");

        lblDataRegistro.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        lblDataRegistro.setText("07 de agosto de 2016");
        lblDataRegistro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel37.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jLabel37.setText("Declaração de Nascido Vivo");

        lblDecNascidoVivo.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        lblDecNascidoVivo.setText("xxxxxx");
        lblDecNascidoVivo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel39.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jLabel39.setText("Observação/Averbação");

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextPane1.setEditable(false);
        jScrollPane1.setViewportView(jTextPane1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(195, 195, 195)
                                .addComponent(jLabel6))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblNomeRegistrando, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblHoraNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblCidadeNascimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(lblCidadeRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel27))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel22)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(lblLocalNascimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(lblGemeo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(lblMatriculaGemeo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel35)
                                    .addComponent(lblDataRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel39))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel37)
                                    .addComponent(lblDecNascidoVivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addGap(34, 34, 34)
                                        .addComponent(jLabel18))
                                    .addComponent(jLabel30))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblDataExtenso, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblDataNormal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(80, 80, 80))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblMatricula))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblNomeRegistrando))
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDataExtenso)
                    .addComponent(lblDataNormal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHoraNascimento)
                    .addComponent(lblCidadeNascimento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCidadeRegistro)
                    .addComponent(lblLocalNascimento)
                    .addComponent(lblSexo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblGemeo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMatriculaGemeo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(jLabel37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDataRegistro)
                    .addComponent(lblDecNascidoVivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 38, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Exibir_Cert_Nascimento_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Exibir_Cert_Nascimento_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Exibir_Cert_Nascimento_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Exibir_Cert_Nascimento_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Exibir_Cert_Nascimento_View dialog = new Exibir_Cert_Nascimento_View(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel lblAvosMaternos;
    private javax.swing.JLabel lblAvosPaternos;
    private javax.swing.JLabel lblCidadeNascimento;
    private javax.swing.JLabel lblCidadeRegistro;
    private javax.swing.JLabel lblDataExtenso;
    private javax.swing.JLabel lblDataNormal;
    private javax.swing.JLabel lblDataRegistro;
    private javax.swing.JLabel lblDecNascidoVivo;
    private javax.swing.JLabel lblGemeo;
    private javax.swing.JLabel lblHoraNascimento;
    private javax.swing.JLabel lblLocalNascimento;
    private javax.swing.JLabel lblMatricula;
    private javax.swing.JLabel lblMatriculaGemeo;
    private javax.swing.JLabel lblNomeMae;
    private javax.swing.JLabel lblNomePai;
    private javax.swing.JLabel lblNomeRegistrando;
    private javax.swing.JLabel lblSexo;
    // End of variables declaration//GEN-END:variables
}
