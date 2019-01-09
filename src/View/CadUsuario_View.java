/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Permissoes_Controller;
import Controller.Usuarios_Controller;
import Model.Permissoes_Model;
import Model.Usuarios_Model;

/**
 *
 * @author andresito
 */
public class CadUsuario_View extends javax.swing.JFrame {

    // atributo que armazena a situação escolhida
    private String situacao;
//    private String nome_user;
    private int id_permissao;

    // objeto permissoes_Model
    Permissoes_Model permissao = new Permissoes_Model();

    // objeto para chamar o metodos da controler
    Usuarios_Controller lerDados = new Usuarios_Controller();
    Usuarios_Model user = new Usuarios_Model();

    /**
     * Creates new form CadUsuarios
     */
    public CadUsuario_View() {
        initComponents();
        groupSituacao.add(radioAtivo);
        groupSituacao.add(radioInativo);

        iniciar_Permissoes();
    }

    public void carregarListaCombo() {
        // carregamento da lista de usuarios no combobox

        String nome_user;
        //int id_permissao;

        // capturando o retorno e add na lista do comboBox usuarios
        for (String obj : lerDados.lerUsuarios()) {
            listaUsuarios.addItem(obj);
        }

        // capturando o primeiro nome selecionado na lista
        nome_user = listaUsuarios.getSelectedItem().toString();

        // ID capturado
        id_permissao = lerDados.lerIdPermissao(nome_user);

        // capturando dados de usario, login, senha etc
        user = lerDados.capturarDadosLogin(nome_user);

        // preenchendo os campos da view cadastroUsuarios
        preencherCamposUsuario(user);

        // objeto para capturar as permissoes do usuario selecionado
        Permissoes_Controller ler = new Permissoes_Controller();

        // capturando o retorno do metodo que leu as permissoes da tabela permissao
        permissao = ler.lerPermissaoUsuario(id_permissao);

        // passando objto permissao para o metodo desta classe responsavel
        // em preencher os permissoes autorizadas
        this.permissoesLidas(permissao);
    }

    /**
     * iniciando os atributos para que seja gravado alguma valor na tabela
     */
    private void iniciar_Permissoes() {

        permissao.setAbert_firma("N");
        permissao.setAlterar_selo("N");
        permissao.setAutenticacao("N");
        permissao.setCert_casamento("N");
        permissao.setCert_nascimento("N");
        permissao.setCert_obito("N");
        permissao.setNovo_user("N");
        permissao.setProcuracao("N");
        permissao.setRecon_firma("N");

    }

    private void limparCampos() {
        campoNome.setText("");
        campoLogin.setText("");
        campoSenha.setText("");

    }

    /**
     * Preenche os campos do usuarios
     *
     * @param dadosUser
     */
    public void preencherCamposUsuario(Usuarios_Model dadosUser) {

        campoNome.setText(dadosUser.getNome());
        campoCargo.setText(dadosUser.getCargo());
        campoLogin.setText(dadosUser.getLogin());
        campoSenha.setText(dadosUser.getSenha());

        if (dadosUser.getSituacao().equals("S")) {

            this.situacao = "S";
            radioAtivo.setSelected(true);
        } else if (dadosUser.getSituacao().equals("N")) {

            situacao = "N";
            radioInativo.setSelected(true);
        } else {

            radioInativo.setSelected(true);

        }

    }

    /**
     * Preencher campos de permissoes, que foram lidas do banco
     *
     * @param permissao
     */
    private void permissoesLidas(Permissoes_Model permissao) {

        if (permissao.getAbert_firma().equals("S")) {
            check_Abert_Ficha.setSelected(true);
        } else {
            check_Abert_Ficha.setSelected(false);
        }

        if (permissao.getAlterar_selo().equals("S")) {
            check_NovoSelo.setSelected(true);
        } else {
            check_NovoSelo.setSelected(false);
        }

        if (permissao.getAutenticacao().equals("S")) {
            check_Autenticacao.setSelected(true);
        } else {
            check_Autenticacao.setSelected(false);
        }
        if (permissao.getCert_casamento().equals("S")) {
            check_Cert_Casamento.setSelected(true);
        } else {
            check_Cert_Casamento.setSelected(false);
        }

        if (permissao.getCert_nascimento().equals("S")) {
            check_Cert_Nasc.setSelected(true);
        } else {
            check_Cert_Nasc.setSelected(false);
        }

        if (permissao.getCert_obito().equals("S")) {
            check_Obitos.setSelected(true);
        } else {
            check_Obitos.setSelected(false);
        }

        if (permissao.getNovo_user().equals("S")) {
            check_NovoUsuario.setSelected(true);
        } else {
            check_NovoUsuario.setSelected(false);
        }

        if (permissao.getProcuracao().equals("S")) {
            check_procuracao.setSelected(true);
        } else {
            check_procuracao.setSelected(false);
        }

        if (permissao.getRecon_firma().equals("S")) {
            check_ReconAssinatura.setSelected(true);
        } else {
            check_ReconAssinatura.setSelected(false);
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

        groupSituacao = new javax.swing.ButtonGroup();
        PanelSuperior = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        campoLogin = new javax.swing.JTextField();
        campoSenha = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        campoCargo = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        radioAtivo = new javax.swing.JRadioButton();
        radioInativo = new javax.swing.JRadioButton();
        PanelLateral = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        listaUsuarios = new javax.swing.JComboBox<String>();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        check_NovoUsuario = new javax.swing.JCheckBox();
        check_NovoSelo = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        check_ReconAssinatura = new javax.swing.JCheckBox();
        check_Autenticacao = new javax.swing.JCheckBox();
        check_Abert_Ficha = new javax.swing.JCheckBox();
        check_Cert_Nasc = new javax.swing.JCheckBox();
        check_Cert_Casamento = new javax.swing.JCheckBox();
        check_Obitos = new javax.swing.JCheckBox();
        check_procuracao = new javax.swing.JCheckBox();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnGravarUser = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnAtualizarDados = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar novo usuario");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        PanelSuperior.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Nome:");

        jLabel2.setText("Login :");

        jLabel3.setText("Senha:");

        jLabel4.setText("Cargo:");

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText("Situação:");

        radioAtivo.setText("Ativo");
        radioAtivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioAtivoActionPerformed(evt);
            }
        });

        radioInativo.setText("Inativo");
        radioInativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioInativoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(radioAtivo)
                .addGap(18, 18, 18)
                .addComponent(radioInativo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioAtivo)
                    .addComponent(radioInativo)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelSuperiorLayout = new javax.swing.GroupLayout(PanelSuperior);
        PanelSuperior.setLayout(PanelSuperiorLayout);
        PanelSuperiorLayout.setHorizontalGroup(
            PanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelSuperiorLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(campoNome))
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelSuperiorLayout.createSequentialGroup()
                        .addGroup(PanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(PanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelSuperiorLayout.createSequentialGroup()
                                .addComponent(campoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(campoLogin)))
                    .addGroup(PanelSuperiorLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(campoCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(226, 226, 226))
        );
        PanelSuperiorLayout.setVerticalGroup(
            PanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(campoCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelLateral.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setText("Usuarios:");

        listaUsuarios.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                listaUsuariosItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout PanelLateralLayout = new javax.swing.GroupLayout(PanelLateral);
        PanelLateral.setLayout(PanelLateralLayout);
        PanelLateralLayout.setHorizontalGroup(
            PanelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLateralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(listaUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelLateralLayout.setVerticalGroup(
            PanelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLateralLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(PanelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(listaUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Permissões"));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro de Usuario e selos"));

        check_NovoUsuario.setText("Cadastrar novos Usuarios");
        check_NovoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_NovoUsuarioActionPerformed(evt);
            }
        });

        check_NovoSelo.setText("Cadastrar novos selos");
        check_NovoSelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_NovoSeloActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(check_NovoSelo)
                    .addComponent(check_NovoUsuario))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(check_NovoUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(check_NovoSelo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Atos permitidos"));

        check_ReconAssinatura.setText("Reconhecimento Assinatura");
        check_ReconAssinatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_ReconAssinaturaActionPerformed(evt);
            }
        });

        check_Autenticacao.setText("Autenticação");
        check_Autenticacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_AutenticacaoActionPerformed(evt);
            }
        });

        check_Abert_Ficha.setText("Abertura Firma");
        check_Abert_Ficha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_Abert_FichaActionPerformed(evt);
            }
        });

        check_Cert_Nasc.setText("Certidao Nascimento");
        check_Cert_Nasc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_Cert_NascActionPerformed(evt);
            }
        });

        check_Cert_Casamento.setText("Certidao Casamento");
        check_Cert_Casamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_Cert_CasamentoActionPerformed(evt);
            }
        });

        check_Obitos.setText("Certidao Obitos");
        check_Obitos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_ObitosActionPerformed(evt);
            }
        });

        check_procuracao.setText("Procuração");
        check_procuracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_procuracaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(check_ReconAssinatura)
                    .addComponent(check_Autenticacao)
                    .addComponent(check_Abert_Ficha)
                    .addComponent(check_Cert_Nasc)
                    .addComponent(check_Cert_Casamento)
                    .addComponent(check_Obitos)
                    .addComponent(check_procuracao))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(check_ReconAssinatura)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(check_Autenticacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(check_Abert_Ficha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(check_Cert_Nasc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(check_Cert_Casamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(check_Obitos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(check_procuracao)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        jToolBar1.setFloatable(false);
        jToolBar1.setBorderPainted(false);
        jToolBar1.add(jSeparator1);

        btnGravarUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/gravar_User.png"))); // NOI18N
        btnGravarUser.setText("Gravar");
        btnGravarUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarUserActionPerformed(evt);
            }
        });
        jToolBar1.add(btnGravarUser);
        jToolBar1.add(jSeparator3);

        btnAtualizarDados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/success.png"))); // NOI18N
        btnAtualizarDados.setText("Alterar");
        btnAtualizarDados.setFocusable(false);
        btnAtualizarDados.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAtualizarDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarDadosActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAtualizarDados);
        jToolBar1.add(jSeparator4);

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/stop_pequeno.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSair);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelLateral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, 350, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PanelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(PanelLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(625, 439));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGravarUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarUserActionPerformed

        // instanciando objeto da camada MODEL
        Usuarios_Model novoUser = new Usuarios_Model();

        // definindo valores a atributo do objeto
        novoUser.setNome(campoNome.getText());
        novoUser.setCargo(campoCargo.getText());
        novoUser.setLogin(campoLogin.getText());
        novoUser.setSenha(campoSenha.getText());
        novoUser.setSituacao(situacao); // atributo situacao pertence a esta classe View

        // INSTANCIANDO OBJETO DA CAMADA CONTROLLER PAR VERIFICAR OS CAMPOS E PERMISSOES
        Usuarios_Controller controle = new Usuarios_Controller();
        Permissoes_Controller user_permissao = new Permissoes_Controller();

        // RECEBE O RETORNO DOS METODOS
        boolean usuario_retorno = controle.verificar(novoUser);
        boolean permissao_retorno = user_permissao.verificarPermissoes(permissao);

        // chamando metodo gravarUsuario da camada Usuario_Controller
        controle.gravarUsuario(usuario_retorno, permissao_retorno, permissao, novoUser);

    }//GEN-LAST:event_btnGravarUserActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void radioAtivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioAtivoActionPerformed
        // ativo
        this.situacao = "S";
    }//GEN-LAST:event_radioAtivoActionPerformed

    private void radioInativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioInativoActionPerformed
        // inativo
        this.situacao = "N";
    }//GEN-LAST:event_radioInativoActionPerformed

    private void check_NovoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_NovoUsuarioActionPerformed
        // selecionado
        if (check_NovoUsuario.isSelected()) {

            permissao.setNovo_user("S");
        } else {
            permissao.setNovo_user("N");
        }
    }//GEN-LAST:event_check_NovoUsuarioActionPerformed

    private void check_NovoSeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_NovoSeloActionPerformed
        // selecionado
        if (check_NovoSelo.isSelected()) {

            permissao.setAlterar_selo("S");
        } else {
            permissao.setAlterar_selo("N");
        }
    }//GEN-LAST:event_check_NovoSeloActionPerformed

    private void check_ReconAssinaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_ReconAssinaturaActionPerformed
        // selecionado
        if (check_ReconAssinatura.isSelected()) {
            permissao.setRecon_firma("S");
        } else {
            permissao.setRecon_firma("N");
        }
    }//GEN-LAST:event_check_ReconAssinaturaActionPerformed

    private void check_AutenticacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_AutenticacaoActionPerformed
        // selecionado
        if (check_Autenticacao.isSelected()) {
            permissao.setAutenticacao("S");
        } else {
            permissao.setAutenticacao("N");
        }
    }//GEN-LAST:event_check_AutenticacaoActionPerformed

    private void check_Abert_FichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_Abert_FichaActionPerformed
        // selecionado
        if (check_Abert_Ficha.isSelected()) {
            permissao.setAbert_firma("S");
        } else {
            permissao.setAbert_firma("N");
        }
    }//GEN-LAST:event_check_Abert_FichaActionPerformed

    private void check_Cert_NascActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_Cert_NascActionPerformed
        // selecionado
        if (check_Cert_Nasc.isSelected()) {
            permissao.setCert_nascimento("S");
        } else {
            permissao.setCert_nascimento("N");
        }
    }//GEN-LAST:event_check_Cert_NascActionPerformed

    private void check_Cert_CasamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_Cert_CasamentoActionPerformed
        // selecionado
        if (check_Cert_Casamento.isSelected()) {
            permissao.setCert_casamento("S");
        } else {
            permissao.setCert_casamento("N");
        }
    }//GEN-LAST:event_check_Cert_CasamentoActionPerformed

    private void check_ObitosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_ObitosActionPerformed
        // selecionado
        if (check_Obitos.isSelected()) {
            permissao.setCert_obito("S");
        } else {
            permissao.setCert_obito("N");
        }
    }//GEN-LAST:event_check_ObitosActionPerformed

    private void check_procuracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_procuracaoActionPerformed
        // selecionado
        if (check_procuracao.isSelected()) {
            permissao.setProcuracao("S");
        } else {
            permissao.setProcuracao("N");
        }
    }//GEN-LAST:event_check_procuracaoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        // preenchendo o combobox com os usuarios cadastrados
        carregarListaCombo();
    }//GEN-LAST:event_formWindowOpened

    private void listaUsuariosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_listaUsuariosItemStateChanged
        String nome_user;
        //int id_permissao;

        nome_user = listaUsuarios.getSelectedItem().toString();

        // ID capturado
        id_permissao = lerDados.lerIdPermissao(nome_user);

        // capturando dados de usario, login, senha etc
        user = lerDados.capturarDadosLogin(nome_user);

        // preenchendo os campos
        preencherCamposUsuario(user);

        // objeto para capturar as permissoes do usuario selecionado
        Permissoes_Controller ler = new Permissoes_Controller();

        // capturando o retorno do metodo que leu as permissoes da tabela permissao
        permissao = ler.lerPermissaoUsuario(id_permissao);

        // passando objto permissao para o metodo desta classe responsavel
        // em preencher os permissoes autorizadas
        this.permissoesLidas(permissao);
    }//GEN-LAST:event_listaUsuariosItemStateChanged

    private void btnAtualizarDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarDadosActionPerformed
        Usuarios_Controller usuario = new Usuarios_Controller();
        // Usuarios_Model atualizar = new Usuarios_Model();

        user.setCargo(campoCargo.getText());
        user.setLogin(campoLogin.getText());
        user.setNome(campoNome.getText());
        user.setSenha(campoSenha.getText());
        user.setSituacao(situacao);

        Permissoes_Controller prm = new Permissoes_Controller();

        boolean retornoPrm = prm.atualizarPerm(permissao, id_permissao);

        usuario.atualizarUsuarios(retornoPrm, user);
//
//        // preenchendo novamente a lista
//        carregarListaCombo();
        // remeve nomes da lista combobox
//        listaUsuarios.removeAllItems();

//        // capturando o retorno e add na lista do comboBox usuarios
//        for (String obj : lerDados.lerUsuarios()) {
//            listaUsuarios.addItem(obj);
//        }

    }//GEN-LAST:event_btnAtualizarDadosActionPerformed

    public static void main(String arg[]) {
        CadUsuario_View tela = new CadUsuario_View();
        tela.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelLateral;
    private javax.swing.JPanel PanelSuperior;
    private javax.swing.JButton btnAtualizarDados;
    private javax.swing.JButton btnGravarUser;
    private javax.swing.JButton btnSair;
    private javax.swing.JTextField campoCargo;
    private javax.swing.JTextField campoLogin;
    private javax.swing.JTextField campoNome;
    private javax.swing.JPasswordField campoSenha;
    private javax.swing.JCheckBox check_Abert_Ficha;
    private javax.swing.JCheckBox check_Autenticacao;
    private javax.swing.JCheckBox check_Cert_Casamento;
    private javax.swing.JCheckBox check_Cert_Nasc;
    private javax.swing.JCheckBox check_NovoSelo;
    private javax.swing.JCheckBox check_NovoUsuario;
    private javax.swing.JCheckBox check_Obitos;
    private javax.swing.JCheckBox check_ReconAssinatura;
    private javax.swing.JCheckBox check_procuracao;
    private javax.swing.ButtonGroup groupSituacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JComboBox<String> listaUsuarios;
    private javax.swing.JRadioButton radioAtivo;
    private javax.swing.JRadioButton radioInativo;
    // End of variables declaration//GEN-END:variables
}
