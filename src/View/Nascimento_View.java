package View;

import Controller.Certidao_Controller;
import Controller.Enderecos_Controller;
import Controller.Lancamento_Controller;
import Controller.Localizar_Controller;
import Controller.Nascimento_Controller;
import Controller.Pessoas_Controller;
import Controller.Selos_Controller;
import Model.Certidao_Model;
import Model.Enderecos_Model;
import Model.Pessoas_Model;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jederson Andre
 */
public class Nascimento_View extends javax.swing.JFrame {

    private int id_registrando;
    private int id_pai;
    private int id_mae;
    private String pai_presente = "S";
    private int id_endereco_pai, id_endereco_mae;
    private int id_certidao_pai, id_certidao_mae;

    /**
     * Creates new form FormCertNascimento
     */
    public Nascimento_View() {
        initComponents();
    }

    /**
     * Metodo que simplesmente verifica se os campos id_mae e id_registrando
     * estão preenchidos somente assim o botao sera ativado
     */
    private void AtivarSalvarCertidao() {

        if (this.id_mae != 0 && this.id_registrando != 0) {
            btnSalvarCertidao.setEnabled(true);
        } else {
            btnSalvarCertidao.setEnabled(false);
        }
    }

    private void limparCamposCertidaoPai() {
        campoLivroPai.setText("");
        campoFolhaPai.setText("");
        campoTermoPai.setText("");
        campoCartorioPai.setText("");
        campoCidadRegPai.setText("");
    }

    private void limparCamposCertidaoMae() {
        checkInserirCertidaoMae.setSelected(false);
        comboTpCertidaoMae.setEnabled(false);
        campoLivroMae.setEnabled(false);
        campoFolhaMae.setEnabled(false);
        campoTermoMae.setEnabled(false);
        campoCidadRegMae.setEnabled(false);
        comboEstadoRegMae.setEnabled(false);
        campoCartorioMae.setEnabled(false);

    }

    /**
     * Metodo que preenche os campos referente a aba PAI
     *
     * @param id String
     */
    private void preencherCamposPai(String id) {

        // instanciando objeto controller, para acesser metodo da camada DAO
        Localizar_Controller dados_pai = new Localizar_Controller();
        Certidao_Controller dados_cert = new Certidao_Controller();
        Enderecos_Controller dados_end = new Enderecos_Controller();

        // objetos Model
        Pessoas_Model pai;
        Certidao_Model cert;
        Enderecos_Model endereco;

        // chamando metodo que ira capturar as informações de um determinado pai
        pai = dados_pai.capturarDadosPessoaSelecionada(id);

        // chamando metodo que ira ler dados da tabela enderecos
        String id_endereco = String.valueOf(pai.getId_endereco());
        this.id_endereco_pai = pai.getId_endereco();
        endereco = dados_end.capturarDadosEndereco(id_endereco);

        // verificando se o PAI apresentou certidao ao registro
        if (pai.getId_certidao() != 0) {
            // cast de int para string
            String id_cert = String.valueOf(pai.getId_certidao());
            this.id_certidao_pai = pai.getId_certidao();

            // chamando metodo que ira ler os dados da certidao do pai escolhido, caso ele tenha apresentado uma certidao
            cert = dados_cert.capturarDadosCertidao(id_cert);

            // formatador de data
            // criando objeto que ira formatar a data, indicamos  padrao da data
            DateTimeFormatter formt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            // objeto date
            LocalDate dataFormat;

            // formatando data
            dataFormat = LocalDate.parse(pai.getDataExpedicao());
            campoDataEmissaoIdentidade_pai.setText(String.valueOf(formt.format(dataFormat)));

            // formatando data
            dataFormat = LocalDate.parse(pai.getNascimento());
            campoDataNascimento_pai.setText(String.valueOf(formt.format(dataFormat)));

            campoNomePai.setText(pai.getNome());
            comboSexo_pai.setSelectedItem(pai.getSexo());
            comboNacionalPai.setSelectedItem(pai.getNacionalidade());
            comboEstCivilPai.setSelectedItem(pai.getEst_civil());
            campoIdentidadePai.setText(pai.getDocIdentidade());
            campoOrgExpPai.setText(pai.getOrgaoExpeditor());
            campoProfissao_Pai.setText(pai.getProfissao());
            campoCpfPai.setText(pai.getCpf());
            campoCidadeNascimento_pai.setText(pai.getCidade_nasc());
            comboEstadoNascimento_pai.setSelectedItem(pai.getEstado_nasc());

            campoCidadePai.setText(endereco.getCidade_residencia());
            campoEnderecoPai.setText(endereco.getNome_rua());
            campoBairroPai.setText(endereco.getBairro());
            campoComplementoResid_Pai.setText(endereco.getComplemento());
            comboEstResidPai.setSelectedItem(endereco.getEstado_residencia());

            // verificando se o check
            if (pai.getPai().equals("Não Declarado")) {
                checkAvoMascPai.setSelected(true);
                campoAvoMascPai.setText("Não Declarado");
            } else {
                campoAvoMascPai.setText(pai.getPai());
            }
            campoAvoFemPai.setText(pai.getMae());

            // ativa os campos certidao e preenche
            ativaCamposCertidaoPai();
            checkInserirCertidaoPai.setSelected(true);
            comboTpCertidaoPai.setSelectedItem(cert.getTipo_certidao());
            campoLivroPai.setText(String.valueOf(cert.getLivro()));
            campoFolhaPai.setText(String.valueOf(cert.getFolha()));
            campoTermoPai.setText(String.valueOf(cert.getTermo()));
            campoCidadRegPai.setText(cert.getCidade_registro());
            comboEstResidPai.setSelectedItem(cert.getEstado_reg());
            campoCartorioPai.setText(cert.getNome_cartorio());

        } else {

            // formatador de data
            // criando objeto que ira formatar a data, indicamos  padrao da data
            DateTimeFormatter formt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            // objeto date
            LocalDate dataFormat;

            // formatando data
            dataFormat = LocalDate.parse(pai.getDataExpedicao());
            campoDataEmissaoIdentidade_pai.setText(String.valueOf(formt.format(dataFormat)));

            // formatando data
            dataFormat = LocalDate.parse(pai.getNascimento());
            campoDataNascimento_pai.setText(String.valueOf(formt.format(dataFormat)));

            campoNomePai.setText(pai.getNome());
            comboSexo_pai.setSelectedItem(pai.getSexo());
            comboNacionalPai.setSelectedItem(pai.getNacionalidade());
            comboEstCivilPai.setSelectedItem(pai.getEst_civil());
            campoIdentidadePai.setText(pai.getDocIdentidade());
            campoOrgExpPai.setText(pai.getOrgaoExpeditor());
            campoProfissao_Pai.setText(pai.getProfissao());
            campoCpfPai.setText(pai.getCpf());
            campoCidadeNascimento_pai.setText(pai.getCidade_nasc());
            comboEstadoNascimento_pai.setSelectedItem(pai.getEstado_nasc());

            campoCidadePai.setText(endereco.getCidade_residencia());
            campoEnderecoPai.setText(endereco.getNome_rua());
            campoBairroPai.setText(endereco.getBairro());
            campoComplementoResid_Pai.setText(endereco.getComplemento());
            comboEstResidPai.setSelectedItem(endereco.getEstado_residencia());

            // verificando se o check
            if (pai.getPai().equals("Não Declarado")) {
                checkAvoMascPai.setSelected(true);
                campoAvoMascPai.setText("Não Declarado");
            } else {
                campoAvoMascPai.setText(pai.getPai());
            }
            campoAvoFemPai.setText(pai.getMae());

            limparCamposCertidaoPai();
            desativaCampoCertidaoPai();
        }

    }

    /**
     * Metodo responsavel preencher os campos da aba MAE
     *
     * @param id
     */
    private void preencherCamposMae(String id) {

        // instanciando objeto controller, para acesser metodo da camada DAO
        Localizar_Controller dados_mae = new Localizar_Controller();
        Certidao_Controller dados_cert = new Certidao_Controller();
        Enderecos_Controller dados_end = new Enderecos_Controller();

        // objetos Model
        Pessoas_Model mae;
        Certidao_Model cert;
        Enderecos_Model endereco;

        mae = dados_mae.capturarDadosPessoaSelecionada(id);

        // capturando endereco
        String id_end = String.valueOf(mae.getId_endereco());
        this.id_endereco_mae = mae.getId_endereco();
        endereco = dados_end.capturarDadosEndereco(id_end);

        // verificando se há uma certidao para essa pessoa
        if (mae.getId_certidao() != 0) {

            // cast de int para string
            String id_cert = String.valueOf(mae.getId_certidao());
            this.id_certidao_mae = mae.getId_certidao();

            // chamando metodo que ira ler os dados da certidao escolhido, caso ele tenha apresentado uma certidao
            cert = dados_cert.capturarDadosCertidao(id_cert);

            // formatador de data
            // criando objeto que ira formatar a data, indicamos  padrao da data
            DateTimeFormatter formt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            // objeto date
            LocalDate dataFormat;

            // formatando data
            dataFormat = LocalDate.parse(mae.getDataExpedicao());
            campoDataEmissaoIdentidade_mae.setText(String.valueOf(formt.format(dataFormat)));

            dataFormat = LocalDate.parse(mae.getNascimento());
            campoDataNascimento_mae.setText(String.valueOf(formt.format(dataFormat)));

            campoNomeMae.setText(mae.getNome());
            comboSexo_mae.setSelectedItem(mae.getSexo());
            comboNacionalMae.setSelectedItem(mae.getNacionalidade());
            comboEstCivilMae.setSelectedItem(mae.getEst_civil());
            campoIdentidadeMae.setText(mae.getDocIdentidade());
            campoOrgExpMae.setText(mae.getOrgaoExpeditor());
            campoProfissao_mae.setText(mae.getProfissao());
            campoCidadeNascimento_mae.setText(mae.getCidade_nasc());
            comboEstadoNascimento_mae.setSelectedItem(mae.getEstado_nasc());
            campoEnderecoMae.setText(endereco.getNome_rua());
            campoBairroMae.setText(endereco.getBairro());
            campoCidadeMae.setText(endereco.getCidade_residencia());
            comboEstResidMae.setSelectedItem(endereco.getEstado_residencia());
            campoComplementoResid_mae.setText(endereco.getComplemento());

            if (mae.getPai().equals("Não Declarado")) {
                checkAvoMascMae.setSelected(true);
                campoAvoMascMae.setText("Não Declarado");
            } else {
                campoAvoMascMae.setText(mae.getPai());
            }
            campoAvoFemMae.setText(mae.getMae());

            // preenchendo campoas da certidao
            ativaCamposCertidaoMae();
            checkInserirCertidaoMae.setSelected(true);
            comboTpCertidaoMae.setSelectedItem(cert.getTipo_certidao());
            campoLivroMae.setText(String.valueOf(cert.getLivro()));
            campoFolhaMae.setText(String.valueOf(cert.getFolha()));
            campoTermoMae.setText(String.valueOf(cert.getTermo()));
            campoCidadRegMae.setText(cert.getCidade_registro());
            comboEstadoRegMae.setSelectedItem(cert.getEstado_reg());
            campoCartorioMae.setText(cert.getNome_cartorio());

            // ativando/desativando botoes
            btnSalvarMae.setEnabled(false);
            btnSalvarAlteracaoMae.setEnabled(true);

        } else {

            // formatador de data
            // criando objeto que ira formatar a data, indicamos  padrao da data
            DateTimeFormatter formt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            // objeto date
            LocalDate dataFormat;

            // formatando data
            dataFormat = LocalDate.parse(mae.getDataExpedicao());
            campoDataEmissaoIdentidade_mae.setText(String.valueOf(formt.format(dataFormat)));

            dataFormat = LocalDate.parse(mae.getNascimento());
            campoDataNascimento_mae.setText(String.valueOf(formt.format(dataFormat)));
            campoNomeMae.setText(mae.getNome());
            comboSexo_mae.setSelectedItem(mae.getSexo());
            comboNacionalMae.setSelectedItem(mae.getNacionalidade());
            comboEstCivilMae.setSelectedItem(mae.getEst_civil());
            campoIdentidadeMae.setText(mae.getDocIdentidade());
            campoOrgExpMae.setText(mae.getOrgaoExpeditor());
            campoCpfMae.setText(mae.getCpf());
            campoProfissao_mae.setText(mae.getProfissao());
            campoCidadeNascimento_mae.setText(mae.getCidade_nasc());
            comboEstadoNascimento_mae.setSelectedItem(mae.getEstado_nasc());
            campoEnderecoMae.setText(endereco.getNome_rua());
            campoBairroMae.setText(endereco.getBairro());
            campoCidadeMae.setText(endereco.getCidade_residencia());
            comboEstResidMae.setSelectedItem(endereco.getEstado_residencia());
            campoComplementoResid_mae.setText(endereco.getComplemento());

            if (mae.getPai().equals("Não Declarado")) {
                checkAvoMascMae.setSelected(true);
                campoAvoMascMae.setText("Não Declarado");
            } else {
                campoAvoMascMae.setText(mae.getPai());
            }
            campoAvoFemMae.setText(mae.getMae());

            desativaCamposCertidaoMae();
            limparCamposCertidaoMae();

            // ativando/desativando botoes
            btnSalvarMae.setEnabled(false);
            btnSalvarAlteracaoMae.setEnabled(true);
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
        jToolBar1 = new javax.swing.JToolBar();
        btnSalvarCertidao = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnSair = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        painelPai = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        campoAvoFemPai = new javax.swing.JTextField();
        campoAvoMascPai = new javax.swing.JTextField();
        checkAvoMascPai = new javax.swing.JCheckBox();
        jPanel8 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        campoComplementoResid_Pai = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        campoCidadePai = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        comboEstResidPai = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        campoEnderecoPai = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        campoBairroPai = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        comboEstadoNascimento_pai = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        campoCidadeNascimento_pai = new javax.swing.JTextField();
        comboNacionalPai = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        comboEstCivilPai = new javax.swing.JComboBox<>();
        jLabel63 = new javax.swing.JLabel();
        campoDataEmissaoIdentidade_pai = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        campoCpfPai = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        campoNomePai = new javax.swing.JTextField();
        campoProfissao_Pai = new javax.swing.JTextField();
        campoIdentidadePai = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        campoDataNascimento_pai = new javax.swing.JFormattedTextField();
        campoOrgExpPai = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        comboSexo_pai = new javax.swing.JComboBox<>();
        painelCertidaoPai = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        comboTpCertidaoPai = new javax.swing.JComboBox<>();
        jLabel43 = new javax.swing.JLabel();
        campoLivroPai = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        campoFolhaPai = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        campoTermoPai = new javax.swing.JTextField();
        campoCidadRegPai = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        campoCartorioPai = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        comboEstadoRegPai = new javax.swing.JComboBox<>();
        checkPaiAusente = new javax.swing.JCheckBox();
        checkInserirCertidaoPai = new javax.swing.JCheckBox();
        jPanel10 = new javax.swing.JPanel();
        btnBuscarPai = new javax.swing.JButton();
        btnSalvarPai = new javax.swing.JButton();
        btnSalvarAlteracaoPai = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        painelCertidaoMae = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        comboTpCertidaoMae = new javax.swing.JComboBox<>();
        jLabel51 = new javax.swing.JLabel();
        campoLivroMae = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        campoFolhaMae = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        campoTermoMae = new javax.swing.JTextField();
        campoCidadRegMae = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        campoCartorioMae = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        comboEstadoRegMae = new javax.swing.JComboBox<>();
        checkInserirCertidaoMae = new javax.swing.JCheckBox();
        btnSalvarMae = new javax.swing.JButton();
        btnBuscarMae = new javax.swing.JButton();
        btnSalvarAlteracaoMae = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        painelMae = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        campoNomeMae = new javax.swing.JTextField();
        comboNacionalMae = new javax.swing.JComboBox<>();
        comboEstCivilMae = new javax.swing.JComboBox<>();
        campoIdentidadeMae = new javax.swing.JTextField();
        campoOrgExpMae = new javax.swing.JTextField();
        campoCpfMae = new javax.swing.JFormattedTextField();
        jLabel64 = new javax.swing.JLabel();
        campoDataEmissaoIdentidade_mae = new javax.swing.JFormattedTextField();
        jLabel65 = new javax.swing.JLabel();
        campoProfissao_mae = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        campoDataNascimento_mae = new javax.swing.JFormattedTextField();
        jLabel67 = new javax.swing.JLabel();
        campoCidadeNascimento_mae = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        comboEstadoNascimento_mae = new javax.swing.JComboBox<>();
        jLabel72 = new javax.swing.JLabel();
        comboSexo_mae = new javax.swing.JComboBox<>();
        jPanel11 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        campoEnderecoMae = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        campoCidadeMae = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        comboEstResidMae = new javax.swing.JComboBox<>();
        jLabel69 = new javax.swing.JLabel();
        campoBairroMae = new javax.swing.JTextField();
        campoComplementoResid_mae = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        campoAvoMascMae = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        campoAvoFemMae = new javax.swing.JTextField();
        checkAvoMascMae = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        painelRegistrando = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        campoNomeRegis = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        campoCidadeNasc = new javax.swing.JTextField();
        campoLocalNasc = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        campoCidadeRegis = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        comboEstadoRegis = new javax.swing.JComboBox<>();
        comboEstadoNasc = new javax.swing.JComboBox<>();
        comboSexo_registrando = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        comboGemeo = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        campoMatriculaGemeo = new javax.swing.JTextField();
        campoHoraNasc = new javax.swing.JFormattedTextField();
        campoDataNasc = new javax.swing.JFormattedTextField();
        btnSalvarRegistrando = new javax.swing.JButton();
        btnSalvarAlteracaoRegistrando = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        campoNumLivro = new javax.swing.JTextField();
        campoNumFolha = new javax.swing.JTextField();
        campoNumTermo = new javax.swing.JTextField();
        campoMatricula = new javax.swing.JTextField();
        campoDataLavratura = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        campoDeclNascVivo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        campoProximoSelo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        campoCustas = new javax.swing.JFormattedTextField();
        jLabel41 = new javax.swing.JLabel();
        campoUltimoSelo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nova Certidão de Nascimento");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setPreferredSize(new java.awt.Dimension(751, 76));

        btnSalvarCertidao.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnSalvarCertidao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/success.png"))); // NOI18N
        btnSalvarCertidao.setText("Salvar nova Certidao");
        btnSalvarCertidao.setEnabled(false);
        btnSalvarCertidao.setFocusable(false);
        btnSalvarCertidao.setIconTextGap(5);
        btnSalvarCertidao.setInheritsPopupMenu(true);
        btnSalvarCertidao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarCertidaoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSalvarCertidao);
        btnSalvarCertidao.getAccessibleContext().setAccessibleDescription("");

        jToolBar1.add(jSeparator1);

        btnSair.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/stop_pequeno.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.setFocusable(false);
        btnSair.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSair);

        jTabbedPane1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        painelPai.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        painelPai.setEnabled(false);
        painelPai.setPreferredSize(new java.awt.Dimension(1018, 289));

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel19.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel19.setText("Pai:");

        jLabel20.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel20.setText("Mãe:");

        checkAvoMascPai.setText("Não Declarado");
        checkAvoMascPai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkAvoMascPaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20))
                .addGap(63, 63, 63)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(campoAvoMascPai)
                    .addComponent(campoAvoFemPai, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(checkAvoMascPai)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(campoAvoMascPai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkAvoMascPai))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(campoAvoFemPai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel58.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel58.setText("Complemento:");

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel13.setText("Cidade resid:");

        jLabel14.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel14.setText("Estado:");

        comboEstResidPai.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        comboEstResidPai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" }));

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel9.setText("Residencia:");

        jLabel57.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel57.setText("Bairro:");

        campoBairroPai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoBairroPaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoEnderecoPai, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel58)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoCidadePai, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoComplementoResid_Pai, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(26, 26, 26)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboEstResidPai, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel57)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoBairroPai, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(campoEnderecoPai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel57)
                    .addComponent(campoBairroPai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(campoCidadePai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(comboEstResidPai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(campoComplementoResid_Pai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        comboEstadoNascimento_pai.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        comboEstadoNascimento_pai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" }));

        jLabel15.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel15.setText("Nacionalidade:");

        comboNacionalPai.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        comboNacionalPai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Brasileiro", "Outro" }));

        jLabel16.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel16.setText("Est.Civil:");

        comboEstCivilPai.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        comboEstCivilPai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Solteiro", "Casado", "Convivente", "Divorciado", "Viuvo" }));

        jLabel63.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel63.setText("Data emissao:");

        try {
            campoDataEmissaoIdentidade_pai.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel8.setText("Nome:");

        try {
            campoCpfPai.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel10.setText("Doc. Identidade:");

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel11.setText("CPF:");

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel12.setText("Orgao exp:");

        jLabel59.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel59.setText("Profissão:");

        jLabel60.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel60.setText("Data de nascimento:");

        try {
            campoDataNascimento_pai.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel61.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel61.setText("Cidade Nasc:");

        jLabel62.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel62.setText("Estado Nasc:");

        jLabel71.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel71.setText("Sexo:");

        comboSexo_pai.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        comboSexo_pai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino" }));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoNomePai, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboNacionalPai, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboEstCivilPai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel71)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboSexo_pai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoIdentidadePai, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(campoCpfPai, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoOrgExpPai, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel63)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoDataEmissaoIdentidade_pai, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoProfissao_Pai, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel60)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoDataNascimento_pai, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel61)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoCidadeNascimento_pai, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel62)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboEstadoNascimento_pai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(campoNomePai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(comboNacionalPai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(comboEstCivilPai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel71)
                    .addComponent(comboSexo_pai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel59)
                        .addComponent(campoProfissao_Pai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoDataEmissaoIdentidade_pai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(campoIdentidadePai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)
                        .addComponent(campoOrgExpPai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel63)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoCpfPai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel60)
                    .addComponent(campoDataNascimento_pai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel61)
                    .addComponent(campoCidadeNascimento_pai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel62)
                    .addComponent(comboEstadoNascimento_pai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout painelPaiLayout = new javax.swing.GroupLayout(painelPai);
        painelPai.setLayout(painelPaiLayout);
        painelPaiLayout.setHorizontalGroup(
            painelPaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPaiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelPaiLayout.setVerticalGroup(
            painelPaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPaiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        painelCertidaoPai.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        painelCertidaoPai.setEnabled(false);

        jLabel49.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel49.setText("Registro tipo:");

        comboTpCertidaoPai.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        comboTpCertidaoPai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Certidao Nascimento", "Certidao Casamento" }));
        comboTpCertidaoPai.setEnabled(false);

        jLabel43.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel43.setText("Livro:");

        campoLivroPai.setEnabled(false);

        jLabel44.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel44.setText("Folha:");

        campoFolhaPai.setEnabled(false);

        jLabel45.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel45.setText("Termo:");

        campoTermoPai.setEnabled(false);

        campoCidadRegPai.setEnabled(false);

        jLabel48.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel48.setText("Cidade registro:");

        campoCartorioPai.setEnabled(false);

        jLabel46.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel46.setText("Cartorio:");

        jLabel47.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel47.setText("Estado registro:");

        comboEstadoRegPai.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        comboEstadoRegPai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" }));
        comboEstadoRegPai.setEnabled(false);

        checkPaiAusente.setForeground(new java.awt.Color(255, 0, 0));
        checkPaiAusente.setText("Pai NAO PRESENTE");
        checkPaiAusente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkPaiAusenteActionPerformed(evt);
            }
        });

        checkInserirCertidaoPai.setForeground(new java.awt.Color(255, 0, 0));
        checkInserirCertidaoPai.setText("Inserir Certidão");
        checkInserirCertidaoPai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkInserirCertidaoPaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelCertidaoPaiLayout = new javax.swing.GroupLayout(painelCertidaoPai);
        painelCertidaoPai.setLayout(painelCertidaoPaiLayout);
        painelCertidaoPaiLayout.setHorizontalGroup(
            painelCertidaoPaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCertidaoPaiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelCertidaoPaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelCertidaoPaiLayout.createSequentialGroup()
                        .addComponent(jLabel46)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoCartorioPai, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(checkPaiAusente))
                    .addGroup(painelCertidaoPaiLayout.createSequentialGroup()
                        .addGroup(painelCertidaoPaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelCertidaoPaiLayout.createSequentialGroup()
                                .addGroup(painelCertidaoPaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelCertidaoPaiLayout.createSequentialGroup()
                                        .addComponent(jLabel48)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoCidadRegPai))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelCertidaoPaiLayout.createSequentialGroup()
                                        .addComponent(jLabel43)
                                        .addGap(18, 18, 18)
                                        .addComponent(campoLivroPai, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(42, 42, 42)
                                        .addComponent(jLabel44)
                                        .addGap(18, 18, 18)
                                        .addComponent(campoFolhaPai, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel45)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(painelCertidaoPaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(campoTermoPai))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboEstadoRegPai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painelCertidaoPaiLayout.createSequentialGroup()
                                .addComponent(jLabel49)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboTpCertidaoPai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(checkInserirCertidaoPai)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painelCertidaoPaiLayout.setVerticalGroup(
            painelCertidaoPaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCertidaoPaiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelCertidaoPaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(comboTpCertidaoPai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkInserirCertidaoPai))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelCertidaoPaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(campoLivroPai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44)
                    .addComponent(campoFolhaPai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45)
                    .addComponent(campoTermoPai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelCertidaoPaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(campoCidadRegPai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel47)
                    .addComponent(comboEstadoRegPai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelCertidaoPaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(campoCartorioPai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkPaiAusente))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnBuscarPai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Consulta_LOCALIZAR.png"))); // NOI18N
        btnBuscarPai.setToolTipText("Buscar pessoa cadastrada");
        btnBuscarPai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPaiActionPerformed(evt);
            }
        });

        btnSalvarPai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/button_ok_pequeno.png"))); // NOI18N
        btnSalvarPai.setToolTipText("Salvar informações desse PAI");
        btnSalvarPai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarPaiActionPerformed(evt);
            }
        });

        btnSalvarAlteracaoPai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/document_save_as.png"))); // NOI18N
        btnSalvarAlteracaoPai.setToolTipText("Salvar alterações no cadastro");
        btnSalvarAlteracaoPai.setEnabled(false);
        btnSalvarAlteracaoPai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarAlteracaoPaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscarPai)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnSalvarAlteracaoPai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvarPai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSalvarPai)
                .addGap(18, 18, 18)
                .addComponent(btnSalvarAlteracaoPai)
                .addGap(18, 18, 18)
                .addComponent(btnBuscarPai)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(painelCertidaoPai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelPai, javax.swing.GroupLayout.DEFAULT_SIZE, 1013, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(130, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelPai, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelCertidaoPai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        jTabbedPane1.addTab("Pai", jPanel4);

        painelCertidaoMae.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        painelCertidaoMae.setEnabled(false);

        jLabel50.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel50.setText("Registro tipo:");

        comboTpCertidaoMae.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        comboTpCertidaoMae.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Certidao Nascimento", "Certidao Casamento" }));
        comboTpCertidaoMae.setEnabled(false);

        jLabel51.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel51.setText("Livro:");

        campoLivroMae.setEnabled(false);

        jLabel52.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel52.setText("Folha:");

        campoFolhaMae.setEnabled(false);

        jLabel53.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel53.setText("Termo:");

        campoTermoMae.setEnabled(false);

        campoCidadRegMae.setEnabled(false);

        jLabel54.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel54.setText("Cidade registro:");

        campoCartorioMae.setEnabled(false);

        jLabel55.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel55.setText("Cartorio:");

        jLabel56.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel56.setText("Estado registro:");

        comboEstadoRegMae.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        comboEstadoRegMae.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" }));
        comboEstadoRegMae.setEnabled(false);

        checkInserirCertidaoMae.setForeground(new java.awt.Color(255, 0, 0));
        checkInserirCertidaoMae.setText("Inserir Certidão");
        checkInserirCertidaoMae.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkInserirCertidaoMaeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelCertidaoMaeLayout = new javax.swing.GroupLayout(painelCertidaoMae);
        painelCertidaoMae.setLayout(painelCertidaoMaeLayout);
        painelCertidaoMaeLayout.setHorizontalGroup(
            painelCertidaoMaeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCertidaoMaeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelCertidaoMaeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelCertidaoMaeLayout.createSequentialGroup()
                        .addGroup(painelCertidaoMaeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelCertidaoMaeLayout.createSequentialGroup()
                                .addComponent(jLabel54)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoCidadRegMae))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelCertidaoMaeLayout.createSequentialGroup()
                                .addComponent(jLabel51)
                                .addGap(18, 18, 18)
                                .addComponent(campoLivroMae, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(jLabel52)
                                .addGap(18, 18, 18)
                                .addComponent(campoFolhaMae, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel53)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelCertidaoMaeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelCertidaoMaeLayout.createSequentialGroup()
                                .addComponent(jLabel56)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboEstadoRegMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(campoTermoMae, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(painelCertidaoMaeLayout.createSequentialGroup()
                        .addComponent(jLabel50)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboTpCertidaoMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(checkInserirCertidaoMae))
                    .addGroup(painelCertidaoMaeLayout.createSequentialGroup()
                        .addComponent(jLabel55)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoCartorioMae, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelCertidaoMaeLayout.setVerticalGroup(
            painelCertidaoMaeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCertidaoMaeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelCertidaoMaeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(comboTpCertidaoMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkInserirCertidaoMae))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelCertidaoMaeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(campoLivroMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52)
                    .addComponent(campoFolhaMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53)
                    .addComponent(campoTermoMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelCertidaoMaeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(campoCidadRegMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56)
                    .addComponent(comboEstadoRegMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelCertidaoMaeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(campoCartorioMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        btnSalvarMae.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/button_ok_pequeno.png"))); // NOI18N
        btnSalvarMae.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarMaeActionPerformed(evt);
            }
        });

        btnBuscarMae.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Consulta_LOCALIZAR.png"))); // NOI18N
        btnBuscarMae.setToolTipText("Buscar pessoa cadastrada");
        btnBuscarMae.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarMaeActionPerformed(evt);
            }
        });

        btnSalvarAlteracaoMae.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/document_save_as.png"))); // NOI18N
        btnSalvarAlteracaoMae.setToolTipText("Salvar alterações no cadastro");
        btnSalvarAlteracaoMae.setEnabled(false);
        btnSalvarAlteracaoMae.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarAlteracaoMaeActionPerformed(evt);
            }
        });

        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        painelMae.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        painelMae.setEnabled(false);
        painelMae.setPreferredSize(new java.awt.Dimension(1018, 289));

        jLabel21.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel21.setText("Nome:");

        jLabel22.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel22.setText("Nacionalidade:");

        jLabel23.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel23.setText("Est.Civil:");

        jLabel24.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel24.setText("Doc. Identidade:");

        jLabel34.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel34.setText("Orgao Exp.:");

        jLabel35.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel35.setText("CPF:");

        comboNacionalMae.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        comboNacionalMae.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Brasileiro" }));

        comboEstCivilMae.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        comboEstCivilMae.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Solteira", "Casada", "Convivente", "Divorciada", "Viuva" }));

        try {
            campoCpfMae.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel64.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel64.setText("Data emissao:");

        try {
            campoDataEmissaoIdentidade_mae.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel65.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel65.setText("Profissão:");

        jLabel66.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel66.setText("Data de nascimento:");

        try {
            campoDataNascimento_mae.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel67.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel67.setText("Cidade Nasc:");

        jLabel68.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel68.setText("Estado Nasc:");

        comboEstadoNascimento_mae.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        comboEstadoNascimento_mae.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" }));

        jLabel72.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel72.setText("Sexo:");

        comboSexo_mae.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        comboSexo_mae.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Feminino", "Masculino" }));

        javax.swing.GroupLayout painelMaeLayout = new javax.swing.GroupLayout(painelMae);
        painelMae.setLayout(painelMaeLayout);
        painelMaeLayout.setHorizontalGroup(
            painelMaeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelMaeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelMaeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelMaeLayout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoIdentidadeMae, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoOrgExpMae, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel64)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoDataEmissaoIdentidade_mae, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoProfissao_mae, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(505, 505, 505))
                    .addGroup(painelMaeLayout.createSequentialGroup()
                        .addGroup(painelMaeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelMaeLayout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoNomeMae, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboNacionalMae, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboEstCivilMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel72)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboSexo_mae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painelMaeLayout.createSequentialGroup()
                                .addComponent(jLabel35)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoCpfMae, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel66)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoDataNascimento_mae, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel67)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoCidadeNascimento_mae, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel68)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboEstadoNascimento_mae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        painelMaeLayout.setVerticalGroup(
            painelMaeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelMaeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelMaeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelMaeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel23)
                        .addComponent(comboEstCivilMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel72)
                        .addComponent(comboSexo_mae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelMaeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21)
                        .addComponent(campoNomeMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(painelMaeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(comboNacionalMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelMaeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelMaeLayout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(11, 11, 11)
                        .addGroup(painelMaeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(campoCpfMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(painelMaeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel66)
                                .addComponent(campoDataNascimento_mae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel67)
                                .addComponent(campoCidadeNascimento_mae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel68)
                                .addComponent(comboEstadoNascimento_mae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(painelMaeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painelMaeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoIdentidadeMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34)
                            .addComponent(campoOrgExpMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(painelMaeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel65)
                            .addComponent(campoDataEmissaoIdentidade_mae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel64)
                            .addComponent(campoProfissao_mae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel36.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel36.setText("Residencia:");

        jLabel37.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel37.setText("Cidade Resid:");

        campoCidadeMae.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCidadeMaeActionPerformed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel38.setText("Estado:");

        comboEstResidMae.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        comboEstResidMae.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" }));

        jLabel69.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel69.setText("Bairro:");

        campoBairroMae.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoBairroMaeActionPerformed(evt);
            }
        });

        jLabel70.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel70.setText("Complemento:");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel70)
                        .addGap(18, 18, 18)
                        .addComponent(campoComplementoResid_mae, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addGap(18, 18, 18)
                                .addComponent(campoEnderecoMae, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addGap(18, 18, 18)
                                .addComponent(campoCidadeMae, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel38)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboEstResidMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel69)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoBairroMae, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(campoEnderecoMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel69)
                    .addComponent(campoBairroMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(comboEstResidMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37)
                    .addComponent(campoCidadeMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel70)
                    .addComponent(campoComplementoResid_mae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel39.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel39.setText("Pai:");

        jLabel40.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel40.setText("Mãe:");

        checkAvoMascMae.setText("Nao Declarado");
        checkAvoMascMae.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkAvoMascMaeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39)
                            .addComponent(jLabel40))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoAvoMascMae, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoAvoFemMae, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(522, 522, 522)
                        .addComponent(checkAvoMascMae)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(campoAvoMascMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkAvoMascMae))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(campoAvoFemMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelMae, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelMae, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(painelCertidaoMae, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscarMae)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnSalvarAlteracaoMae, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvarMae, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnSalvarMae)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSalvarAlteracaoMae)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscarMae))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelCertidaoMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Mãe", jPanel5);

        painelRegistrando.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel27.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel27.setText("Horário Nasc:");

        jLabel28.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel28.setText("Nome registrando:");

        jLabel29.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel29.setText("Cidade nascimento:");

        jLabel30.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel30.setText("Estado:");

        jLabel31.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel31.setText("Local Nascimento:");

        jLabel32.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel32.setText("Sexo:");

        jLabel33.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel33.setText("Estado:");

        jLabel25.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel25.setText("Cidade registro:");

        jLabel26.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel26.setText("Data Nascimento:");

        comboEstadoRegis.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        comboEstadoRegis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" }));

        comboEstadoNasc.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        comboEstadoNasc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" }));

        comboSexo_registrando.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        comboSexo_registrando.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino" }));

        jLabel17.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel17.setText("Gemeo:");

        comboGemeo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        comboGemeo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));

        jLabel18.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel18.setText("Matricula Gemeo:");

        campoMatriculaGemeo.setText("*  *  *");

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

        javax.swing.GroupLayout painelRegistrandoLayout = new javax.swing.GroupLayout(painelRegistrando);
        painelRegistrando.setLayout(painelRegistrandoLayout);
        painelRegistrandoLayout.setHorizontalGroup(
            painelRegistrandoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelRegistrandoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(painelRegistrandoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelRegistrandoLayout.createSequentialGroup()
                        .addGroup(painelRegistrandoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(jLabel25))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoCidadeRegis, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboEstadoRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelRegistrandoLayout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addGap(5, 5, 5)
                        .addGroup(painelRegistrandoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoNomeRegis, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(painelRegistrandoLayout.createSequentialGroup()
                                .addComponent(campoDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoHoraNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(painelRegistrandoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelRegistrandoLayout.createSequentialGroup()
                            .addComponent(jLabel17)
                            .addGap(18, 18, 18)
                            .addComponent(comboGemeo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel18)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(campoMatriculaGemeo))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelRegistrandoLayout.createSequentialGroup()
                            .addGroup(painelRegistrandoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(painelRegistrandoLayout.createSequentialGroup()
                                    .addComponent(jLabel29)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(campoCidadeNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(painelRegistrandoLayout.createSequentialGroup()
                                    .addComponent(jLabel31)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(campoLocalNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(34, 34, 34)
                            .addGroup(painelRegistrandoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel30)
                                .addComponent(jLabel32))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(painelRegistrandoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(comboSexo_registrando, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboEstadoNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelRegistrandoLayout.setVerticalGroup(
            painelRegistrandoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelRegistrandoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelRegistrandoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(campoCidadeRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33)
                    .addComponent(comboEstadoRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelRegistrandoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27)
                    .addComponent(campoHoraNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(painelRegistrandoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(campoNomeRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelRegistrandoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelRegistrandoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel29)
                        .addComponent(campoCidadeNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelRegistrandoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel30)
                        .addComponent(comboEstadoNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(painelRegistrandoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelRegistrandoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel32)
                        .addComponent(comboSexo_registrando, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoLocalNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(painelRegistrandoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(comboGemeo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(campoMatriculaGemeo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSalvarRegistrando.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/button_ok_pequeno.png"))); // NOI18N
        btnSalvarRegistrando.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarRegistrandoActionPerformed(evt);
            }
        });

        btnSalvarAlteracaoRegistrando.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/document_save_as.png"))); // NOI18N
        btnSalvarAlteracaoRegistrando.setEnabled(false);
        btnSalvarAlteracaoRegistrando.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarAlteracaoRegistrandoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(261, 261, 261)
                .addComponent(painelRegistrando, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnSalvarAlteracaoRegistrando, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalvarRegistrando, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(324, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelRegistrando, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnSalvarRegistrando)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvarAlteracaoRegistrando)))
                .addContainerGap(283, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Registrando", jPanel2);

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setText("Numero livro:");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("Folha:");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setText("Termo:");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setText("Matricula:");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setText("Data lavratura:");

        campoNumLivro.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        campoNumFolha.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        campoNumTermo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        campoDataLavratura.setEditable(false);
        campoDataLavratura.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoDataLavratura.setToolTipText("Campo não editavel");

        jLabel42.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel42.setText("Decl.Nasc. Vivo:");

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setText("Proximo Selo:");

        campoProximoSelo.setEditable(false);
        campoProximoSelo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel7.setText("Custas:");

        campoCustas.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        campoCustas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoCustas.setText("0,00");

        jLabel41.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel41.setText("Ultimo Selo:");

        campoUltimoSelo.setEditable(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(campoDataLavratura, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoUltimoSelo, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoProximoSelo, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoCustas, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(58, 58, 58))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoNumLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(19, 19, 19)))
                                .addGap(14, 14, 14)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(jLabel2)
                                        .addGap(63, 63, 63)
                                        .addComponent(jLabel3))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(campoNumFolha, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(campoNumTermo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(155, 155, 155)
                                .addComponent(jLabel4))
                            .addComponent(campoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(campoDeclNascVivo, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(jLabel5))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jLabel42)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoNumLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoNumFolha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoNumTermo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campoDataLavratura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campoDeclNascVivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel41))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoProximoSelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoCustas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoUltimoSelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(358, 358, 358))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(190, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Certidão", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1251, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 1262, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1280, 688));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo responsavel em desativar os campos referente a aba Certidão
     */
    private void desativarCamposCertidao() {
        campoNumLivro.setEnabled(false);
        campoNumFolha.setEnabled(false);
        campoNumTermo.setEnabled(false);
        campoDataLavratura.setEnabled(false);
        campoMatricula.setEnabled(false);
        campoProximoSelo.setEnabled(false);
        campoCustas.setEnabled(false);
        campoDeclNascVivo.setEnabled(false);

    }

    /**
     * Metodo responsavel em desativar campos do registrando
     */
    private void desativaCamposRegistrando() {
        campoCidadeRegis.setEnabled(false);
        comboEstadoRegis.setEnabled(false);
        campoCidadeNasc.setEnabled(false);
        campoDataNasc.setEnabled(false);
        campoHoraNasc.setEnabled(false);
        campoNomeRegis.setEnabled(false);
        campoCidadeRegis.setEnabled(false);
        comboEstadoNasc.setEnabled(false);
        campoLocalNasc.setEnabled(false);
        comboSexo_registrando.setEnabled(false);
        comboGemeo.setEnabled(false);
        campoMatriculaGemeo.setEnabled(false);
        btnSalvarRegistrando.setEnabled(false);
        painelRegistrando.setEnabled(false);

    }

    /**
     * Metodo responsavel em ativar os campos referente a aba Pai
     */
    private void ativarCamposPai() {

        painelPai.setEnabled(true);
        painelCertidaoPai.setEnabled(true);
        campoNomePai.setEnabled(true);
        comboNacionalPai.setEnabled(true);
        comboEstCivilPai.setEnabled(true);
        campoIdentidadePai.setEnabled(true);
        campoOrgExpPai.setEnabled(true);
        campoCpfPai.setEnabled(true);
        campoEnderecoPai.setEnabled(true);
        campoCidadePai.setEnabled(true);
        comboEstResidPai.setEnabled(true);
        campoAvoMascPai.setEnabled(true);
        campoAvoFemPai.setEnabled(true);
        checkAvoMascPai.setEnabled(true);
        checkPaiAusente.setEnabled(true);
        btnSalvarPai.setEnabled(true);
        painelPai.setEnabled(true);
        checkInserirCertidaoPai.setEnabled(true);

        campoDataNascimento_pai.setEnabled(true);
        campoDataEmissaoIdentidade_pai.setEnabled(true);
        comboEstadoNascimento_pai.setEnabled(true);
        campoComplementoResid_Pai.setEnabled(true);
        campoProfissao_Pai.setEnabled(true);
        campoBairroPai.setEnabled(true);
        campoCidadeNascimento_pai.setEnabled(true);
        btnBuscarPai.setEnabled(true);

    }

    /**
     * Metodo que desativa os campos referente a aba PAI
     */
    private void desativarCamposPai() {

        campoNomePai.setEnabled(false);
        comboNacionalPai.setEnabled(false);
        comboEstCivilPai.setEnabled(false);
        campoIdentidadePai.setEnabled(false);
        campoOrgExpPai.setEnabled(false);
        campoCpfPai.setEnabled(false);
        campoEnderecoPai.setEnabled(false);
        campoCidadePai.setEnabled(false);
        comboEstResidPai.setEnabled(false);
        campoAvoMascPai.setEnabled(false);
        campoAvoFemPai.setEnabled(false);
        checkAvoMascPai.setEnabled(false);
//        checkPaiAusente.setEnabled(false);
        btnSalvarPai.setEnabled(false);
        painelPai.setEnabled(false);
        checkInserirCertidaoPai.setEnabled(false);
        campoDataNascimento_pai.setEnabled(false);
        campoDataEmissaoIdentidade_pai.setEnabled(false);
        comboEstadoNascimento_pai.setEnabled(false);
        campoComplementoResid_Pai.setEnabled(false);
        campoProfissao_Pai.setEnabled(false);
        campoBairroPai.setEnabled(false);
        campoCidadeNascimento_pai.setEnabled(false);
        btnBuscarPai.setEnabled(false);

    }

    /**
     * Metodo responsavel em
     */
    private void desativaCamposCertidaoMae() {
        comboTpCertidaoMae.setEnabled(false);
        campoLivroMae.setEnabled(false);
        campoFolhaMae.setEnabled(false);
        campoTermoMae.setEnabled(false);
        campoCidadRegMae.setEnabled(false);
        comboEstadoRegMae.setEnabled(false);
        campoCartorioMae.setEnabled(false);
    }

    /**
     * Metodo que desativa os campos referente aos campos de certidao na aba PAI
     */
    private void desativaCampoCertidaoPai() {

        comboTpCertidaoPai.setEnabled(false);
        campoLivroPai.setEnabled(false);
        campoFolhaPai.setEnabled(false);
        campoTermoPai.setEnabled(false);
        campoCidadRegPai.setEnabled(false);
        campoCartorioPai.setEnabled(false);
        comboEstadoRegPai.setEnabled(false);
        //checkInserirCertidaoPai.setEnabled(false);
    }

    /**
     * Metodo responsavel em ativar campos de certidao na aba PAI
     */
    private void ativaCamposCertidaoPai() {
        comboTpCertidaoPai.setEnabled(true);
        campoLivroPai.setEnabled(true);
        campoFolhaPai.setEnabled(true);
        campoTermoPai.setEnabled(true);
        campoCartorioPai.setEnabled(true);
        campoCidadRegPai.setEnabled(true);
        comboEstadoRegPai.setEnabled(true);
        campoCartorioPai.setEnabled(true);

    }

    /**
     * Metodo responsavel em ativar os campos referente a Certidao_Model na aba
     * MAE
     */
    private void ativaCamposCertidaoMae() {
        comboTpCertidaoMae.setEnabled(true);
        campoLivroMae.setEnabled(true);
        campoFolhaMae.setEnabled(true);
        campoTermoMae.setEnabled(true);
        campoCidadRegMae.setEnabled(true);
        comboEstadoRegMae.setEnabled(true);
        campoCartorioMae.setEnabled(true);
    }

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // saindo tela de registro 
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void checkAvoMascPaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkAvoMascPaiActionPerformed
        if (checkAvoMascPai.isSelected() == true) {
            campoAvoMascPai.setText("Não Declarado");
        } else {
            campoAvoMascPai.setText("");
        }
    }//GEN-LAST:event_checkAvoMascPaiActionPerformed

    private void checkPaiAusenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkPaiAusenteActionPerformed
        // caso o PAI NAO ESTEJA PRESENTE SERA DESABIBLITADO TODOS OS CAMPOS
        if (checkPaiAusente.isSelected()) {

            // exibindo uma informação ao usuario
            JOptionPane.showMessageDialog(this, "Esta opção deve ser marcada, quando o pai do registrando não está presente no ato", "Mensagem", JOptionPane.OK_OPTION);

            desativarCamposPai();
            desativaCampoCertidaoPai();
            //eckInserirCertidaoPai.setEnabled(false);

            // essa opção será incluida na tabela registrando
            this.pai_presente = "N";

        } else {
            ativarCamposPai();

            this.pai_presente = "S";
        }
    }//GEN-LAST:event_checkPaiAusenteActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // capturando selo
        Selos_Controller capt_selo = new Selos_Controller();

        // instanciando vetor para amarzenar o retorno do metodo que captura o selo
        String[] selo = capt_selo.capturarSelo();

        // preenchendo campos com os valores recuperados da tabela selos
        campoUltimoSelo.setText(selo[0] + selo[1]); // valor do ultimo selo
        campoProximoSelo.setText(selo[0] + selo[2]); // valor do proximo selo

        // capturando a data atual
        LocalDate dataAtual = LocalDate.now();

        // instanciando formatador de datas com padrao
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // preenchendo campo com a data
        campoDataLavratura.setText(format.format(dataAtual));

    }//GEN-LAST:event_formWindowOpened

    private void btnSalvarCertidaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarCertidaoActionPerformed

        // instanciando objetos de acesso a Controller e Models
        Selos_Controller selo = new Selos_Controller();
        Certidao_Model cert = new Certidao_Model();
        Nascimento_Controller salvar_Cert = new Nascimento_Controller();
        Lancamento_Controller lancamento = new Lancamento_Controller();

        // dados que serao utilizados na tabela lançamento, coluna Data_lancamento
        LocalDate data = LocalDate.now();
        int mes = data.getMonthValue();
        int ano = data.getYear();
        String competencia = String.valueOf(mes) + "/" + String.valueOf(ano);

        // verificando se os campos referente ao certidão estão preenchidos
        if (campoDataLavratura.getText().isEmpty() || campoMatricula.getText().isEmpty() || campoNumFolha.getText().isEmpty() || campoNumLivro.getText().isEmpty() || campoNumTermo.getText().isEmpty() || campoDeclNascVivo.getText().isEmpty() || campoProximoSelo.getText().isEmpty() || campoCustas.getText().isEmpty()) {

            //menssage erro ao usuario
            JOptionPane.showMessageDialog(null, "Atenção verifique se todos campos estão preenchidos", "Mensagem", JOptionPane.ERROR_MESSAGE);
        } else {

            // capturando dados referente a Certidao
            cert.setLivro(Integer.parseInt(campoNumLivro.getText()));
            cert.setFolha(Integer.parseInt(campoNumFolha.getText()));
            cert.setTermo(Integer.parseInt(campoNumTermo.getText()));
            cert.setMatricula(campoMatricula.getText());
            cert.setDecl_nasc_vivo(campoDeclNascVivo.getText());

            // capturando o ultimo selo da tabela
            String seloUtilizado[] = selo.capturarSelo();

            // capturando valor referente a custas
            Double custo = Double.parseDouble(campoCustas.getText().replace(",", "."));

            // chamando metodo que faz a gravação do selo utilizado e retorna o ID utilizado
            // posição[0]= letras
            // posição[2]= seq. de numero
            int id_selo = selo.gravarSelo(seloUtilizado[0], seloUtilizado[2], custo);

            // verificando se o PAI do registrado esta PRESENTE OU NÃO
            if (pai_presente.equals("S")) {

                // chamando o metodo que faz a gravação da certidao quando pai presente
                // e capturando o id do ato da tabela nascimento, que sera utilizado na tabela LANCAMENTOS
                int id_ato = salvar_Cert.salvarCertidaoNascimento(cert, id_registrando, id_mae, id_pai, id_selo);

                // salvando dados na tabela LANCAMENTOS
                lancamento.salvarNovoLancamento(id_selo, 18, "Certidao de Nascimento", custo, id_ato);
            } else {

                // chamando o metodo que faz a gravação da certidao quando pai não presente
                int id_ato = salvar_Cert.salvarCertidaoNascimento(cert, id_registrando, id_mae, id_selo);
                // salvando dados na tabela LANCAMENTOS
                lancamento.salvarNovoLancamento(id_selo, 18, "Certidao de Nascimento", custo, id_ato);
            }

        }
    }//GEN-LAST:event_btnSalvarCertidaoActionPerformed

    private void btnSalvarPaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarPaiActionPerformed

        Pessoas_Controller salvar_pai = new Pessoas_Controller();
        Pessoas_Model pai = new Pessoas_Model();
        Certidao_Model cert = new Certidao_Model();
        Certidao_Controller nova_cert = new Certidao_Controller();
        Enderecos_Model end = new Enderecos_Model();
        Enderecos_Controller novo_end = new Enderecos_Controller();

        if (campoNomePai.getText().isEmpty() || campoEnderecoPai.getText().isEmpty() || campoCidadePai.getText().isEmpty() || campoIdentidadePai.getText().isEmpty() || campoOrgExpPai.getText().isEmpty() || campoCpfPai.getText().isEmpty() || campoAvoMascPai.getText().isEmpty() || campoAvoFemPai.getText().isEmpty() || campoEnderecoPai.getText().isEmpty() || campoCidadePai.getText().isEmpty() || campoComplementoResid_Pai.getText().isEmpty() || campoBairroPai.getText().isEmpty() || campoProfissao_Pai.getText().isEmpty()) {

            // mensagem de erro
            JOptionPane.showMessageDialog(this, "Preencha todos os campos referente ao PAI", "Mensagem", JOptionPane.ERROR_MESSAGE);

            // caso o check esteja marcado, incluimos na captura os dados da certidão, caso nao esteja marcado nao incluimos na captura dos dados
        } else if (checkInserirCertidaoPai.isSelected()) {

            // verificando os campos da certidao estao preenchidos
            if (campoLivroPai.getText().isEmpty() || campoFolhaPai.getText().isEmpty() || campoTermoPai.getText().isEmpty() || campoCartorioPai.getText().isEmpty() || campoCidadRegPai.getText().isEmpty()) {

                // msg de erro
                JOptionPane.showMessageDialog(this, "Preencha todos os campos referente a Certidao", "Mensagem", JOptionPane.ERROR_MESSAGE);

            } else {

                pai.setNome(campoNomePai.getText());
                pai.setSexo(comboSexo_pai.getSelectedItem().toString());
                pai.setNacionalidade(comboNacionalPai.getSelectedItem().toString());
                pai.setEst_civil(comboEstCivilPai.getSelectedItem().toString());
                pai.setDocIdentidade(campoIdentidadePai.getText());
                pai.setDataExpedicao(campoDataEmissaoIdentidade_pai.getText());
                pai.setOrgaoExpeditor(campoOrgExpPai.getText());
                pai.setCpf(campoCpfPai.getText());
                pai.setProfissao(campoProfissao_Pai.getText());
                pai.setNascimento(campoDataNascimento_pai.getText());
                pai.setEstado_nasc(comboEstadoNascimento_pai.getSelectedItem().toString());
                pai.setCidade_nasc(campoCidadeNascimento_pai.getText());
                end.setNome_rua(campoEnderecoPai.getText());
                end.setBairro(campoBairroPai.getText());
                end.setComplemento(campoComplementoResid_Pai.getText());
                end.setCidade_residencia(campoCidadePai.getText());
                end.setEstado_residencia(comboEstResidPai.getSelectedItem().toString());
                pai.setPai(campoAvoMascPai.getText());
                pai.setMae(campoAvoFemPai.getText());

                // capturando dados referente a CERTIDAO
                cert.setLivro(Integer.parseInt(campoLivroPai.getText()));
                cert.setFolha(Integer.parseInt(campoFolhaPai.getText()));
                cert.setTermo(Integer.parseInt(campoTermoPai.getText()));
                cert.setTipo_certidao(comboTpCertidaoPai.getSelectedItem().toString());
                cert.setCidade_registro(campoCidadRegPai.getText());
                cert.setEstado_reg(comboEstadoRegPai.getSelectedItem().toString());
                cert.setNome_cartorio(campoCartorioPai.getText());

                // salvando os dados referente ao ENDERECO do pai
                this.id_endereco_pai = novo_end.salvar_Endereco(end);

                // salvando os dados referente a CERTIDAO do pai
                this.id_certidao_pai = nova_cert.salvar_nova_certidao(cert);

                // chamando metodo de gravação
                this.id_pai = salvar_pai.gravarNovaPessoa(pai, id_endereco_pai, id_certidao_pai);

                btnSalvarAlteracaoPai.setEnabled(true);
            }

        } else {

            pai.setNome(campoNomePai.getText());
            pai.setSexo(comboSexo_pai.getSelectedItem().toString());
            pai.setNacionalidade(comboNacionalPai.getSelectedItem().toString());
            pai.setEst_civil(comboEstCivilPai.getSelectedItem().toString());
            pai.setDocIdentidade(campoIdentidadePai.getText());
            pai.setDataExpedicao(campoDataEmissaoIdentidade_pai.getText());
            pai.setOrgaoExpeditor(campoOrgExpPai.getText());
            pai.setCpf(campoCpfPai.getText());
            pai.setProfissao(campoProfissao_Pai.getText());
            pai.setNascimento(campoDataNascimento_pai.getText());
            pai.setEstado_nasc(comboEstadoNascimento_pai.getSelectedItem().toString());
            pai.setCidade_nasc(campoCidadeNascimento_pai.getText());
            end.setNome_rua(campoEnderecoPai.getText());
            end.setBairro(campoBairroPai.getText());
            end.setComplemento(campoComplementoResid_Pai.getText());
            end.setCidade_residencia(campoCidadePai.getText());
            end.setEstado_residencia(comboEstResidPai.getSelectedItem().toString());
            pai.setPai(campoAvoMascPai.getText());
            pai.setMae(campoAvoFemPai.getText());

            // salvando dados do endereço
            this.id_endereco_pai = novo_end.salvar_Endereco(end);

            // chamando metodo de gravaçao
            this.id_pai = salvar_pai.gravarNovaPessoa(pai, id_endereco_pai);

            btnSalvarPai.setEnabled(true);
        }

    }//GEN-LAST:event_btnSalvarPaiActionPerformed

    private void checkInserirCertidaoPaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkInserirCertidaoPaiActionPerformed
        // caso selecionado ativa os campos da certidao
        if (checkInserirCertidaoPai.isSelected()) {

            ativaCamposCertidaoPai();

        } else {

            desativaCampoCertidaoPai();
        }
    }//GEN-LAST:event_checkInserirCertidaoPaiActionPerformed

    private void checkInserirCertidaoMaeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkInserirCertidaoMaeActionPerformed
        if (checkInserirCertidaoMae.isSelected()) {
            ativaCamposCertidaoMae();
        } else {
            desativaCamposCertidaoMae();
        }
    }//GEN-LAST:event_checkInserirCertidaoMaeActionPerformed

    private void btnSalvarMaeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarMaeActionPerformed

        Pessoas_Controller salvar_mae = new Pessoas_Controller();
        Pessoas_Model mae = new Pessoas_Model();
        Certidao_Model cert = new Certidao_Model();
        Certidao_Controller nova_cert = new Certidao_Controller();
        Enderecos_Model end = new Enderecos_Model();
        Enderecos_Controller novo_end = new Enderecos_Controller();

        // verificando campos
        if (campoNomeMae.getText().isEmpty() || campoIdentidadeMae.getText().isEmpty() || campoOrgExpMae.getText().isEmpty() || campoCpfMae.getText().isEmpty() || campoEnderecoMae.getText().isEmpty() || campoCidadeMae.getText().isEmpty() || campoAvoFemMae.getText().isEmpty() || campoAvoMascMae.getText().isEmpty() || campoDataEmissaoIdentidade_mae.getText().isEmpty() || campoProfissao_mae.getText().isEmpty() || campoDataNascimento_mae.getText().isEmpty() || campoCidadeNascimento_mae.getText().isEmpty()) {

            // mensagem erro
            JOptionPane.showMessageDialog(this, "Atenção verifique se todos os campos estão preenchidos", "Erro", JOptionPane.ERROR_MESSAGE);

        } else if (checkInserirCertidaoMae.isSelected()) {

            if (campoLivroMae.getText().isEmpty() || campoFolhaMae.getText().isEmpty() || campoTermoMae.getText().isEmpty() || campoCidadRegMae.getText().isEmpty() || campoCartorioMae.getText().isEmpty()) {

                // mensagem de erro ao usuario
                JOptionPane.showMessageDialog(this, "Verifique os campos referente a certidao", "Erro", JOptionPane.ERROR_MESSAGE);

            } else {

                mae.setNome(campoNomeMae.getText());
                mae.setSexo(comboSexo_mae.getSelectedItem().toString());
                mae.setNacionalidade(comboNacionalMae.getSelectedItem().toString());
                mae.setEst_civil(comboEstCivilMae.getSelectedItem().toString());
                mae.setDocIdentidade(campoIdentidadeMae.getText());
                mae.setOrgaoExpeditor(campoOrgExpMae.getText());
                mae.setDataExpedicao(campoDataEmissaoIdentidade_mae.getText());
                mae.setProfissao(campoProfissao_mae.getText());
                mae.setNascimento(campoDataNascimento_mae.getText());
                mae.setCidade_nasc(campoCidadeNascimento_mae.getText());
                mae.setEstado_nasc(comboEstadoNascimento_mae.getSelectedItem().toString());
                mae.setCpf(campoCpfMae.getText());
                mae.setPai(campoAvoMascMae.getText());
                mae.setMae(campoAvoFemMae.getText());

                end.setNome_rua(campoEnderecoMae.getText());
                end.setBairro(campoBairroMae.getText());
                end.setCidade_residencia(campoCidadeMae.getText());
                end.setEstado_residencia(comboEstResidMae.getSelectedItem().toString());
                end.setComplemento(campoComplementoResid_mae.getText());

                cert.setLivro(Integer.parseInt(campoLivroMae.getText()));
                cert.setFolha(Integer.parseInt(campoFolhaMae.getText()));
                cert.setTermo(Integer.parseInt(campoTermoMae.getText()));
                cert.setTipo_certidao(comboTpCertidaoMae.getSelectedItem().toString());
                cert.setCidade_registro(campoCidadRegMae.getText());
                cert.setEstado_reg(comboEstadoRegMae.getSelectedItem().toString());
                cert.setNome_cartorio(campoCartorioMae.getText());

                this.id_endereco_mae = novo_end.salvar_Endereco(end);
                this.id_certidao_mae = nova_cert.salvar_nova_certidao(cert);
                this.id_mae = salvar_mae.gravarNovaPessoa(mae, id_endereco_mae, id_certidao_mae);

                btnSalvarAlteracaoMae.setEnabled(true);
                btnSalvarMae.setEnabled(false);

                // verificando se os IDs obrigatorios estao preenchidos, para poder liberar o botao salvar certidao
                AtivarSalvarCertidao();

            }
        } else {

            mae.setNome(campoNomeMae.getText());
            mae.setSexo(comboSexo_mae.getSelectedItem().toString());
            mae.setNacionalidade(comboNacionalMae.getSelectedItem().toString());
            mae.setEst_civil(comboEstCivilMae.getSelectedItem().toString());
            mae.setDocIdentidade(campoIdentidadeMae.getText());
            mae.setOrgaoExpeditor(campoOrgExpMae.getText());
            mae.setDataExpedicao(campoDataEmissaoIdentidade_mae.getText());
            mae.setProfissao(campoProfissao_mae.getText());
            mae.setNascimento(campoDataNascimento_mae.getText());
            mae.setCidade_nasc(campoCidadeNascimento_mae.getText());
            mae.setEstado_nasc(comboEstadoNascimento_mae.getSelectedItem().toString());
            mae.setCpf(campoCpfMae.getText());
            mae.setPai(campoAvoMascMae.getText());
            mae.setMae(campoAvoFemMae.getText());

            end.setNome_rua(campoEnderecoMae.getText());
            end.setBairro(campoBairroMae.getText());
            end.setCidade_residencia(campoCidadeMae.getText());
            end.setEstado_residencia(comboEstResidMae.getSelectedItem().toString());
            end.setComplemento(campoComplementoResid_mae.getText());

            this.id_endereco_mae = novo_end.salvar_Endereco(end);
            this.id_mae = salvar_mae.gravarNovaPessoa(mae, id_endereco_mae);

            btnSalvarAlteracaoMae.setEnabled(true);
            btnSalvarMae.setEnabled(false);

        }
    }//GEN-LAST:event_btnSalvarMaeActionPerformed

    private void btnSalvarRegistrandoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarRegistrandoActionPerformed

        Pessoas_Model reg = new Pessoas_Model();
        Nascimento_Controller gravar = new Nascimento_Controller();
        Certidao_Model cert = new Certidao_Model();

        // verificando campos
        if (campoNomeRegis.getText().isEmpty() || campoCidadeRegis.getText().isEmpty() || campoDataNasc.getText().isEmpty() || campoHoraNasc.getText().isEmpty() || campoCidadeNasc.getText().isEmpty() || campoLocalNasc.getText().isEmpty() || campoMatriculaGemeo.getText().isEmpty()) {

            // mensagem de erro
            JOptionPane.showMessageDialog(null, "Preencha todos os campos do registrando", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {

            // formatador de data
            DateTimeFormatter formt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            // aqui ele passa a ser formatado com padrao "yyyy-MM-dd"
            LocalDate data = LocalDate.parse(campoDataNasc.getText(), formt);

            cert.setCidade_registro(campoCidadeRegis.getText());
            cert.setEstado_reg(comboEstadoRegis.getSelectedItem().toString());
            cert.setHora_nasc(campoHoraNasc.getText());
            cert.setData_nasc(data.toString());
            reg.setNome(campoNomeRegis.getText());
            cert.setCidade_nasc(campoCidadeNasc.getText());
            cert.setEstado_nasc(comboEstadoNasc.getSelectedItem().toString());
            cert.setLocal_nasc(campoLocalNasc.getText());
            cert.setSexo(comboSexo_registrando.getSelectedItem().toString());
            cert.setGemeos(comboGemeo.getSelectedItem().toString());
            cert.setMatricula_gemeo(campoMatriculaGemeo.getText());

            // chamando metodo que faz a gravação na base de dados
            // passando como parametros objetos
            this.id_registrando = gravar.gravarNovoRegistrando(reg, cert);

            // verificando se os IDs obrigatorios estao preenchidos, para poder liberar o botao salvar certidao
            AtivarSalvarCertidao();
        }
    }//GEN-LAST:event_btnSalvarRegistrandoActionPerformed

    private void btnBuscarPaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPaiActionPerformed
        // chamando a tela localizar Pessoas
        // o parametro 0 indica que iremos buscar somente pessoas do sexo MASCULINO na tabela pessoas
        Localizar_Pessoas_View buscar = new Localizar_Pessoas_View(this, true, 0);
        buscar.setVisible(true);

        // cpturando o id escolhido na tela de buscas
        String id_pai_selecionado = buscar.id_selecionado;

        if (id_pai_selecionado != null) {

            // definindo do id_pai, de acordo com a pessoa selecionada
            this.id_pai = Integer.parseInt(id_pai_selecionado);
            // desativando a oção INSERIR CERTIDAO, motivo: na alteração não é possivel inserir um nova certidao
            checkInserirCertidaoPai.setEnabled(false);

            // preenche os campos referente ao PAI
            preencherCamposPai(id_pai_selecionado);

            // ativa\desativa botoes
            btnSalvarPai.setEnabled(false);
            btnSalvarAlteracaoPai.setEnabled(true);
            checkPaiAusente.setEnabled(false);

        } else {
            // exibe msg
            JOptionPane.showMessageDialog(this, "Nenhuma pessoa foi selecionada", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            // ativa\desativa botoes
            btnSalvarAlteracaoPai.setEnabled(false);
            btnSalvarPai.setEnabled(true);
        }

    }//GEN-LAST:event_btnBuscarPaiActionPerformed

    private void btnBuscarMaeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarMaeActionPerformed
        // chamando a tela localizar Pessoas
        // o parametro 2 indica que iremos buscar somente pessoas do sexo FEMININO na tabela pessoas
        Localizar_Pessoas_View buscar = new Localizar_Pessoas_View(this, true, 2);
        buscar.setVisible(true);

        // capturando o id escolhido na tela de busca
        String id_selecionado = buscar.id_selecionado;

        if (id_selecionado != null) {

            this.id_mae = Integer.parseInt(id_selecionado);

            // chamando metodo que ira preencher os campos referente a MAE, passando como parametro o id escolhido na tela de buscas
            preencherCamposMae(id_selecionado);

            // desativando a oção INSERIR CERTIDAO, motivo: na alteração não é possivel inserir um nova certidao
            checkInserirCertidaoMae.setEnabled(false);

            // verificando se os IDs obrigatorios estao preenchidos, para poder liberar o botao salvar certidao
            AtivarSalvarCertidao();

        } else {
            JOptionPane.showMessageDialog(this, "Nenhuma pessoa foi selecionada", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            btnSalvarAlteracaoMae.setEnabled(false);
            btnSalvarMae.setEnabled(true);
        }

    }//GEN-LAST:event_btnBuscarMaeActionPerformed

    private void btnSalvarAlteracaoMaeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarAlteracaoMaeActionPerformed

        Pessoas_Model mae = new Pessoas_Model();
        Certidao_Model cert = new Certidao_Model();
        Enderecos_Model end = new Enderecos_Model();

        Pessoas_Controller alterar_Pessoa = new Pessoas_Controller();
        Certidao_Controller alterar_certidao = new Certidao_Controller();
        Enderecos_Controller alterar_endereco = new Enderecos_Controller();

        // verificando campos
        if (campoNomeMae.getText().isEmpty() || campoIdentidadeMae.getText().isEmpty() || campoOrgExpMae.getText().isEmpty() || campoCpfMae.getText().isEmpty() || campoEnderecoMae.getText().isEmpty() || campoCidadeMae.getText().isEmpty() || campoAvoFemMae.getText().isEmpty() || campoAvoMascMae.getText().isEmpty() || campoDataEmissaoIdentidade_mae.getText().isEmpty() || campoProfissao_mae.getText().isEmpty() || campoDataNascimento_mae.getText().isEmpty() || campoCidadeNascimento_mae.getText().isEmpty()) {
            // mensagem erro
            JOptionPane.showMessageDialog(this, "Atenção verifique se todos os campos estão preenchidos", "Erro", JOptionPane.ERROR_MESSAGE);

        } else if (checkInserirCertidaoMae.isSelected()) {

            if (campoLivroMae.getText().isEmpty() || campoFolhaMae.getText().isEmpty() || campoTermoMae.getText().isEmpty() || campoCidadRegMae.getText().isEmpty() || campoCartorioMae.getText().isEmpty()) {

                // mensagem de erro ao usuario
                JOptionPane.showMessageDialog(this, "Verifique os campos referente a certidao", "Erro", JOptionPane.ERROR_MESSAGE);

            } else {

                mae.setNome(campoNomeMae.getText());
                mae.setSexo(comboSexo_mae.getSelectedItem().toString());
                mae.setNacionalidade(comboNacionalMae.getSelectedItem().toString());
                mae.setEst_civil(comboEstCivilMae.getSelectedItem().toString());
                mae.setDocIdentidade(campoIdentidadeMae.getText());
                mae.setOrgaoExpeditor(campoOrgExpMae.getText());
                mae.setDataExpedicao(campoDataEmissaoIdentidade_mae.getText());
                mae.setProfissao(campoProfissao_mae.getText());
                mae.setNascimento(campoDataNascimento_mae.getText());
                mae.setCidade_nasc(campoCidadeNascimento_mae.getText());
                mae.setEstado_nasc(comboEstadoNascimento_mae.getSelectedItem().toString());
                mae.setCpf(campoCpfMae.getText());
                mae.setPai(campoAvoMascMae.getText());
                mae.setMae(campoAvoFemMae.getText());

                end.setNome_rua(campoEnderecoMae.getText());
                end.setBairro(campoBairroMae.getText());
                end.setCidade_residencia(campoCidadeMae.getText());
                end.setEstado_residencia(comboEstResidMae.getSelectedItem().toString());
                end.setComplemento(campoComplementoResid_mae.getText());

                cert.setLivro(Integer.parseInt(campoLivroMae.getText()));
                cert.setFolha(Integer.parseInt(campoFolhaMae.getText()));
                cert.setTermo(Integer.parseInt(campoTermoMae.getText()));
                cert.setTipo_certidao(comboTpCertidaoMae.getSelectedItem().toString());
                cert.setCidade_registro(campoCidadRegMae.getText());
                cert.setEstado_reg(comboEstadoRegMae.getSelectedItem().toString());
                cert.setNome_cartorio(campoCartorioMae.getText());

                alterar_Pessoa.salvarAlteracao(mae, id_mae);
                alterar_endereco.salvarAlteracaoEndereco(end, id_endereco_mae);
                alterar_certidao.salvarAlteracaoCertidao(cert, id_certidao_mae);
            }
        } else {

            mae.setNome(campoNomeMae.getText());
            mae.setSexo(comboSexo_mae.getSelectedItem().toString());
            mae.setNacionalidade(comboNacionalMae.getSelectedItem().toString());
            mae.setEst_civil(comboEstCivilMae.getSelectedItem().toString());
            mae.setDocIdentidade(campoIdentidadeMae.getText());
            mae.setOrgaoExpeditor(campoOrgExpMae.getText());
            mae.setDataExpedicao(campoDataEmissaoIdentidade_mae.getText());
            mae.setProfissao(campoProfissao_mae.getText());
            mae.setNascimento(campoDataNascimento_mae.getText());
            mae.setCidade_nasc(campoCidadeNascimento_mae.getText());
            mae.setEstado_nasc(comboEstadoNascimento_mae.getSelectedItem().toString());
            mae.setCpf(campoCpfMae.getText());
            mae.setPai(campoAvoMascMae.getText());
            mae.setMae(campoAvoFemMae.getText());

            end.setNome_rua(campoEnderecoMae.getText());
            end.setBairro(campoBairroMae.getText());
            end.setCidade_residencia(campoCidadeMae.getText());
            end.setEstado_residencia(comboEstResidMae.getSelectedItem().toString());
            end.setComplemento(campoComplementoResid_mae.getText());

            // metodos que irao alterar os dados
            alterar_Pessoa.salvarAlteracao(mae, id_mae);
            alterar_endereco.salvarAlteracaoEndereco(end, id_endereco_mae);
        }
    }//GEN-LAST:event_btnSalvarAlteracaoMaeActionPerformed

    private void btnSalvarAlteracaoPaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarAlteracaoPaiActionPerformed

        Pessoas_Model pai = new Pessoas_Model();
        Certidao_Model cert = new Certidao_Model();
        Enderecos_Model end = new Enderecos_Model();

        Pessoas_Controller alterar_Pessoa = new Pessoas_Controller();
        Certidao_Controller alterar_certidao = new Certidao_Controller();
        Enderecos_Controller alterar_endereco = new Enderecos_Controller();

        if (campoNomePai.getText().isEmpty() || campoEnderecoPai.getText().isEmpty() || campoCidadePai.getText().isEmpty() || campoIdentidadePai.getText().isEmpty() || campoOrgExpPai.getText().isEmpty() || campoCpfPai.getText().isEmpty() || campoAvoMascPai.getText().isEmpty() || campoAvoFemPai.getText().isEmpty() || campoEnderecoPai.getText().isEmpty() || campoCidadePai.getText().isEmpty() || campoComplementoResid_Pai.getText().isEmpty() || campoBairroPai.getText().isEmpty() || campoProfissao_Pai.getText().isEmpty()) {

            // mensagem de erro
            JOptionPane.showMessageDialog(this, "Preencha todos os campos referente ao PAI", "Mensagem", JOptionPane.ERROR);

            // caso o check esteja marcado, incluimos na captura os dados da certidão, caso nao esteja marcado nao incluimos na captura dos dados
        } else if (checkInserirCertidaoPai.isSelected()) {

            // verificando os campos da certidao estao preenchidos
            if (campoLivroPai.getText().isEmpty() || campoFolhaPai.getText().isEmpty() || campoTermoPai.getText().isEmpty() || campoCartorioPai.getText().isEmpty() || campoCidadRegPai.getText().isEmpty()) {

                // msg de erro
                JOptionPane.showMessageDialog(this, "Preencha todos os campos referente a Certidao", "Mensagem", JOptionPane.ERROR_MESSAGE);

            } else {

                pai.setNome(campoNomePai.getText());
                pai.setSexo(comboSexo_pai.getSelectedItem().toString());
                pai.setNacionalidade(comboNacionalPai.getSelectedItem().toString());
                pai.setEst_civil(comboEstCivilPai.getSelectedItem().toString());
                pai.setDocIdentidade(campoIdentidadePai.getText());
                pai.setDataExpedicao(campoDataEmissaoIdentidade_pai.getText());
                pai.setOrgaoExpeditor(campoOrgExpPai.getText());
                pai.setCpf(campoCpfPai.getText());
                pai.setProfissao(campoProfissao_Pai.getText());
                pai.setNascimento(campoDataNascimento_pai.getText());
                pai.setEstado_nasc(comboEstadoNascimento_pai.getSelectedItem().toString());
                pai.setCidade_nasc(campoCidadeNascimento_pai.getText());
                end.setNome_rua(campoEnderecoPai.getText());
                end.setBairro(campoBairroPai.getText());
                end.setComplemento(campoComplementoResid_Pai.getText());
                end.setCidade_residencia(campoCidadePai.getText());
                end.setEstado_residencia(comboEstResidPai.getSelectedItem().toString());
                pai.setPai(campoAvoMascPai.getText());
                pai.setMae(campoAvoFemPai.getText());

                // capturando dados referente a CERTIDAO
                cert.setLivro(Integer.parseInt(campoLivroPai.getText()));
                cert.setFolha(Integer.parseInt(campoFolhaPai.getText()));
                cert.setTermo(Integer.parseInt(campoTermoPai.getText()));
                cert.setTipo_certidao(comboTpCertidaoPai.getSelectedItem().toString());
                cert.setCidade_registro(campoCidadRegPai.getText());
                cert.setEstado_reg(comboEstadoRegPai.getSelectedItem().toString());
                cert.setNome_cartorio(campoCartorioPai.getText());

                // chamando metodo qu ira atualizar as informações
                alterar_Pessoa.salvarAlteracao(pai, id_pai);
                alterar_endereco.salvarAlteracaoEndereco(end, id_endereco_pai);
                alterar_certidao.salvarAlteracaoCertidao(cert, id_certidao_pai);

            }

        } else {

            pai.setNome(campoNomePai.getText());
            pai.setSexo(comboSexo_pai.getSelectedItem().toString());
            pai.setNacionalidade(comboNacionalPai.getSelectedItem().toString());
            pai.setEst_civil(comboEstCivilPai.getSelectedItem().toString());
            pai.setDocIdentidade(campoIdentidadePai.getText());
            pai.setDataExpedicao(campoDataEmissaoIdentidade_pai.getText());
            pai.setOrgaoExpeditor(campoOrgExpPai.getText());
            pai.setCpf(campoCpfPai.getText());
            pai.setProfissao(campoProfissao_Pai.getText());
            pai.setNascimento(campoDataNascimento_pai.getText());
            pai.setEstado_nasc(comboEstadoNascimento_pai.getSelectedItem().toString());
            pai.setCidade_nasc(campoCidadeNascimento_pai.getText());
            end.setNome_rua(campoEnderecoPai.getText());
            end.setBairro(campoBairroPai.getText());
            end.setComplemento(campoComplementoResid_Pai.getText());
            end.setCidade_residencia(campoCidadePai.getText());
            end.setEstado_residencia(comboEstResidPai.getSelectedItem().toString());
            pai.setPai(campoAvoMascPai.getText());
            pai.setMae(campoAvoFemPai.getText());

            // chamando metodo qu ira atualizar as informações
            alterar_Pessoa.salvarAlteracao(pai, id_pai);
            alterar_endereco.salvarAlteracaoEndereco(end, id_endereco_pai);

        }

    }//GEN-LAST:event_btnSalvarAlteracaoPaiActionPerformed

    private void btnSalvarAlteracaoRegistrandoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarAlteracaoRegistrandoActionPerformed
//        Pessoas_Model reg = new Pessoas_Model();
//        Nascimento_Controller atualizar = new Nascimento_Controller();
//        Certidao_Model cert = new Certidao_Model();
//
//        // verificando campos
//        if (campoNomeRegis.getText().isEmpty() || campoCidadeRegis.getText().isEmpty() || campoDataNasc.getText().isEmpty() || campoHoraNasc.getText().isEmpty() || campoCidadeNasc.getText().isEmpty() || campoLocalNasc.getText().isEmpty() || campoMatriculaGemeo.getText().isEmpty()) {
//
//            // mensagem de erro
//            JOptionPane.showMessageDialog(null, "Preencha todos os campos do registrando", "Erro", JOptionPane.ERROR_MESSAGE);
//        } else {
//
//            cert.setCidade_registro(campoCidadeRegis.getText());
//            cert.setEstado_reg(comboEstadoRegis.getSelectedItem().toString());
//            cert.setHora_nasc(campoHoraNasc.getText());
//            cert.setData_nasc(campoDataNasc.getText());
//            reg.setNome(campoNomeRegis.getText());
//            cert.setCidade_nasc(campoCidadeNasc.getText());
//            cert.setEstado_nasc(comboEstadoNasc.getSelectedItem().toString());
//            cert.setLocal_nasc(campoLocalNasc.getText());
//            cert.setSexo(comboSexo_registrando.getSelectedItem().toString());
//            cert.setGemeos(comboGemeo.getSelectedItem().toString());
//            cert.setMatricula_gemeo(campoMatriculaGemeo.getText());
//
//            atualizar.atualizarDadosRegistrado(id_registrando, reg, cert);
//        }
    }//GEN-LAST:event_btnSalvarAlteracaoRegistrandoActionPerformed

    private void campoBairroPaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoBairroPaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoBairroPaiActionPerformed

    private void campoCidadeMaeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCidadeMaeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoCidadeMaeActionPerformed

    private void campoBairroMaeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoBairroMaeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoBairroMaeActionPerformed

    private void checkAvoMascMaeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkAvoMascMaeActionPerformed
        // TODO add your handling code here:
        if (checkAvoMascMae.isSelected()) {
            campoAvoMascMae.setText("Não Declarado");
        } else {
            campoAvoMascMae.setText("");
        }
    }//GEN-LAST:event_checkAvoMascMaeActionPerformed

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
            java.util.logging.Logger.getLogger(Nascimento_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Nascimento_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Nascimento_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Nascimento_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Nascimento_View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarMae;
    private javax.swing.JButton btnBuscarPai;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvarAlteracaoMae;
    private javax.swing.JButton btnSalvarAlteracaoPai;
    private javax.swing.JButton btnSalvarAlteracaoRegistrando;
    private javax.swing.JButton btnSalvarCertidao;
    private javax.swing.JButton btnSalvarMae;
    private javax.swing.JButton btnSalvarPai;
    private javax.swing.JButton btnSalvarRegistrando;
    private javax.swing.JTextField campoAvoFemMae;
    private javax.swing.JTextField campoAvoFemPai;
    private javax.swing.JTextField campoAvoMascMae;
    private javax.swing.JTextField campoAvoMascPai;
    private javax.swing.JTextField campoBairroMae;
    private javax.swing.JTextField campoBairroPai;
    private javax.swing.JTextField campoCartorioMae;
    private javax.swing.JTextField campoCartorioPai;
    private javax.swing.JTextField campoCidadRegMae;
    private javax.swing.JTextField campoCidadRegPai;
    private javax.swing.JTextField campoCidadeMae;
    private javax.swing.JTextField campoCidadeNasc;
    private javax.swing.JTextField campoCidadeNascimento_mae;
    private javax.swing.JTextField campoCidadeNascimento_pai;
    private javax.swing.JTextField campoCidadePai;
    private javax.swing.JTextField campoCidadeRegis;
    private javax.swing.JTextField campoComplementoResid_Pai;
    private javax.swing.JTextField campoComplementoResid_mae;
    private javax.swing.JFormattedTextField campoCpfMae;
    private javax.swing.JFormattedTextField campoCpfPai;
    private javax.swing.JFormattedTextField campoCustas;
    private javax.swing.JFormattedTextField campoDataEmissaoIdentidade_mae;
    private javax.swing.JFormattedTextField campoDataEmissaoIdentidade_pai;
    private javax.swing.JTextField campoDataLavratura;
    private javax.swing.JFormattedTextField campoDataNasc;
    private javax.swing.JFormattedTextField campoDataNascimento_mae;
    private javax.swing.JFormattedTextField campoDataNascimento_pai;
    private javax.swing.JTextField campoDeclNascVivo;
    private javax.swing.JTextField campoEnderecoMae;
    private javax.swing.JTextField campoEnderecoPai;
    private javax.swing.JTextField campoFolhaMae;
    private javax.swing.JTextField campoFolhaPai;
    private javax.swing.JFormattedTextField campoHoraNasc;
    private javax.swing.JTextField campoIdentidadeMae;
    private javax.swing.JTextField campoIdentidadePai;
    private javax.swing.JTextField campoLivroMae;
    private javax.swing.JTextField campoLivroPai;
    private javax.swing.JTextField campoLocalNasc;
    private javax.swing.JTextField campoMatricula;
    private javax.swing.JTextField campoMatriculaGemeo;
    private javax.swing.JTextField campoNomeMae;
    private javax.swing.JTextField campoNomePai;
    private javax.swing.JTextField campoNomeRegis;
    private javax.swing.JTextField campoNumFolha;
    private javax.swing.JTextField campoNumLivro;
    private javax.swing.JTextField campoNumTermo;
    private javax.swing.JTextField campoOrgExpMae;
    private javax.swing.JTextField campoOrgExpPai;
    private javax.swing.JTextField campoProfissao_Pai;
    private javax.swing.JTextField campoProfissao_mae;
    private javax.swing.JTextField campoProximoSelo;
    private javax.swing.JTextField campoTermoMae;
    private javax.swing.JTextField campoTermoPai;
    private javax.swing.JTextField campoUltimoSelo;
    private javax.swing.JCheckBox checkAvoMascMae;
    private javax.swing.JCheckBox checkAvoMascPai;
    private javax.swing.JCheckBox checkInserirCertidaoMae;
    private javax.swing.JCheckBox checkInserirCertidaoPai;
    private javax.swing.JCheckBox checkPaiAusente;
    private javax.swing.JComboBox<String> comboEstCivilMae;
    private javax.swing.JComboBox<String> comboEstCivilPai;
    private javax.swing.JComboBox<String> comboEstResidMae;
    private javax.swing.JComboBox<String> comboEstResidPai;
    private javax.swing.JComboBox<String> comboEstadoNasc;
    private javax.swing.JComboBox<String> comboEstadoNascimento_mae;
    private javax.swing.JComboBox<String> comboEstadoNascimento_pai;
    private javax.swing.JComboBox<String> comboEstadoRegMae;
    private javax.swing.JComboBox<String> comboEstadoRegPai;
    private javax.swing.JComboBox<String> comboEstadoRegis;
    private javax.swing.JComboBox<String> comboGemeo;
    private javax.swing.JComboBox<String> comboNacionalMae;
    private javax.swing.JComboBox<String> comboNacionalPai;
    private javax.swing.JComboBox<String> comboSexo_mae;
    private javax.swing.JComboBox<String> comboSexo_pai;
    private javax.swing.JComboBox<String> comboSexo_registrando;
    private javax.swing.JComboBox<String> comboTpCertidaoMae;
    private javax.swing.JComboBox<String> comboTpCertidaoPai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel painelCertidaoMae;
    private javax.swing.JPanel painelCertidaoPai;
    private javax.swing.JPanel painelMae;
    private javax.swing.JPanel painelPai;
    private javax.swing.JPanel painelRegistrando;
    // End of variables declaration//GEN-END:variables
}
