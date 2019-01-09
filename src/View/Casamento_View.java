/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Casamento_Controller;
import Controller.Enderecos_Controller;
import Controller.Localizar_Controller;
import Controller.Pessoas_Controller;
import Model.Enderecos_Model;
import Model.Pessoas_Model;
import java.awt.Color;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author Andre
 */
public class Casamento_View extends javax.swing.JFrame {

    private int id_noivo, id_noiva;
    private int id_endereco_noivo, id_endereco_noiva;
    private int id_certidao_noivo, id_certidao_noiva;
    private int id_endereco_testemunha;
    private int id_testemunhas[] = new int[2];
    private int id_test;
    private int contador = 0;

    /**
     * Creates new form Casamento_View2
     */
    public Casamento_View() {
        initComponents();
    }

    /**
     * Metodo que verifica se os IDs dos Noivos e testemunhas estão todos
     * preenchidos, assim ativamos o botao para Salvar o Novo Processo
     */
    private void Ativar_Botao_Salvar_Processo() {

        if (id_noivo != 0 && id_noiva != 0 && id_testemunhas[0] != 0 && id_testemunhas[1] != 0) {
            btnSalvarProcesso.setEnabled(true);
        } else {
            btnSalvarProcesso.setEnabled(false);
        }

    }

    /**
     * Mtodo para limpar o formulario de cdastro da noiva
     */
    private void Limpar_Campos_Noiva() {

        campoIdentificadorNoiva.setText("");
        campoNomeNoiva.setText("");
        campoNomeNoiva.requestFocus();
        comboSexoNoiva.setSelectedItem(null);
        campoIdentidadeNoiva.setText("");
        campoOrgaoExpNoiva.setText("");
        campoDataExpedicaoNoiva.setText(null);
        campoNascNoiva.setText(null);
        campoCpfNoiva.setText(null);
        campoProfNoiva.setText("");
        campoPaiNoiva.setText("");
        campoMaeNoiva.setText("");
        campoCidadNascNoiva.setText("");
        comboEstaNascNoiva.setSelectedItem(null);
        campoCidadResidNoiva.setText("");
        campoResidNoiva.setText("");
        comboEstResidNoiva.setSelectedItem(null);
        campoBairroNoiva.setText("");
        campoComplementoNoiva.setText("");
        campoVinculoContraente2.setText("");
    }

    /**
     * LImpando o formulario com as informações do NOIVO
     */
    private void Limpar_Campos_Noivo() {

        campoIdentificadorNoivo.setText("");
        campoNomeNoivo.setText("");
        campoNomeNoivo.requestFocus();
        comboSexoNoivo.setSelectedItem(null);
        comboNacioNoivo.setSelectedItem(null);
        comboEstCivilNoivo.setSelectedItem("");
        campoIdentNoivo.setText("");
        campoOrgaoExpNoivo.setText("");
        campoDataExpedicaoNoivo.setText(null);
        campoNascNoivo.setText(null);
        campoCpfNoivo.setText("");
        campoProfNoivo.setText("");
        campoPaiNoivo.setText("");
        campoMaeNoivo.setText("");
        campoCidadNascNoivo.setText("");
        campoCidaResidNoivo.setText("");
        campoResidNoivo.setText("");
        campoComplementoNoivo.setText("");
        campoBairroNoivo.setText("");
        checkPaiNaoDeclNoivo.setSelected(false);
        campoVinculoContraente1.setText("");

    }

    /**
     * Metodo que simplesmente verifica o valor do contador utilizado no vetor
     * que armazena os IDs das testemunhas que serão vinculadas. O valor maximo
     * do vetor é 2 posições assim, evitamos de erros de excessao na execução do
     * sistema
     */
    private void Verificar_Valor_Contador() {
        if (contador == 2 || contador > 2) {
            btnSalvarTestm1.setEnabled(false);
            btnBuscarTest1.setEnabled(false);
            btnAtualizaçãoTest1.setEnabled(false);
            btnConfirmarTestemunha.setEnabled(false);

            JOptionPane.showMessageDialog(this, "Verificamos que a quantidade total de testemunhas necessária para o\nprocesso de casamento já foi incluso", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Ainda é possivel o lançamento de uma nova testemunha a este processo", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Preenche os campos referente ao endereco
     *
     * @param id_endereco
     */
    private void Preencher_Campos_Enderecos_Noivo(int id_endereco) {

        Enderecos_Controller control = new Enderecos_Controller();
        Enderecos_Model endereco = control.Preenche_Formulario_Enderecos(id_endereco);

        campoBairroNoivo.setText(endereco.getBairro());
        campoResidNoivo.setText(endereco.getNome_rua());
        campoCidaResidNoivo.setText(endereco.getCidade_residencia());
        comboEstResidNoivo.setSelectedItem(endereco.getEstado_residencia());
        campoComplementoNoivo.setText(endereco.getComplemento());

    }

    /**
     * Desativa a opção EDITAR DOS CAMPOS
     */
    private void Desativar_Campos_Enderecos_Noivo() {
        campoBairroNoivo.setEditable(false);
        campoResidNoivo.setEditable(false);
        campoCidaResidNoivo.setEditable(false);
        comboEstResidNoivo.setEditable(false);
        campoComplementoNoivo.setEditable(false);

    }

    /**
     * Desativa a opção EDITAR DOS CAMPOS
     */
    private void Desativar_Campos_Enderecos_Testemunha() {
        campoBairroNoivo.setEditable(false);
        campoResidNoivo.setEditable(false);
        campoCidaResidNoivo.setEditable(false);
        comboEstResidNoivo.setEditable(false);
        campoComplementoNoivo.setEditable(false);

    }

    /**
     * Preenche os campos referente ao endereco
     *
     * @param id_endereco
     */
    private void Preencher_Campos_Enderecos_Noiva(int id_endereco) {

        Enderecos_Controller control = new Enderecos_Controller();
        Enderecos_Model endereco = control.Preenche_Formulario_Enderecos(id_endereco);

        campoCidadResidNoiva.setText(endereco.getCidade_residencia());
        campoResidNoiva.setText(endereco.getNome_rua());
        comboEstResidNoiva.setSelectedItem(endereco.getEstado_residencia());
        campoBairroNoiva.setText(endereco.getBairro());
        campoComplementoNoiva.setText(endereco.getComplemento());
    }

    /**
     * Preenche os campos referente ao endereco
     *
     * @param id_endereco
     */
    private void Preencher_Campos_Enderecos_Testemunha(int id_endereco) {

        Enderecos_Controller control = new Enderecos_Controller();
        Enderecos_Model endereco = control.Preenche_Formulario_Enderecos(id_endereco);

        campoCidadeResidTest1.setText(endereco.getCidade_residencia());
        campoResidTest1.setText(endereco.getNome_rua());
        comboEstResidTest1.setSelectedItem(endereco.getEstado_residencia());
        campoBairroTestemunha.setText(endereco.getBairro());
        campoComplementoTestemunha.setText(endereco.getComplemento());
    }

    /**
     * Desativa campos Endereco Noiva
     */
    private void Desativar_Campos_Enderecos_Noiva() {
        campoCidadResidNoiva.setEditable(false);
        campoResidNoiva.setEditable(false);
        comboEstResidNoiva.setEditable(false);
        campoBairroNoiva.setEditable(false);
        campoComplementoNoiva.setEditable(false);
    }

    /**
     * Preenche os campos referente a testemunha
     *
     * @param id_selecionado
     */
    private void preencher_campos_testemunha(String id_selecionado) {
        Pessoas_Model pessoaSelec;
        Enderecos_Model endereco;

        Localizar_Controller buscar = new Localizar_Controller();
        Enderecos_Controller buscar_end = new Enderecos_Controller();

        pessoaSelec = buscar.capturarDadosPessoaSelecionada(id_selecionado);
        endereco = buscar_end.Preenche_Formulario_Enderecos(pessoaSelec.getId_endereco());

        DateTimeFormatter formt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data;

        campoIdentificadorTest1.setText(String.valueOf(pessoaSelec.getId()));
        campoNomeTest1.setText(pessoaSelec.getNome());
        comboSexo_testemunha.setSelectedItem(pessoaSelec.getSexo());
        comboNacionTest1.setSelectedItem(pessoaSelec.getNacionalidade());
        comboEstCivilTest1.setSelectedItem(pessoaSelec.getEst_civil());
        campoIdentTest1.setText(pessoaSelec.getDocIdentidade());
        campoOrgaoExpTest1.setText(pessoaSelec.getOrgaoExpeditor());
        data = LocalDate.parse(pessoaSelec.getDataExpedicao());
        campoDataExpedicao_testemunha.setText(formt.format(data));
        campoCpfTest1.setText(pessoaSelec.getCpf());
        data = LocalDate.parse(pessoaSelec.getNascimento());
        campoNascTest1.setText(formt.format(data));
        campoProfTest1.setText(pessoaSelec.getProfissao());
        if (pessoaSelec.getPai().equals("Não Declarado") || pessoaSelec.getPai().equals("Não declarado")) {
            checkPaiNaoDeclaradoTestemunha.setSelected(true);
            campoPaiTestemunha.setText(pessoaSelec.getPai());
        } else {
            campoPaiTestemunha.setText(pessoaSelec.getPai());
        }
        campoMaeTestemunha.setText(pessoaSelec.getMae());
        campoCidadNascTestemunha.setText(pessoaSelec.getCidade_nasc());
        campoCidadeResidTest1.setText(endereco.getCidade_residencia());
        campoResidTest1.setText(endereco.getNome_rua());
        comboEstResidTest1.setSelectedItem(endereco.getEstado_residencia());
        campoBairroTestemunha.setText(endereco.getBairro());
        campoComplementoTestemunha.setText(endereco.getComplemento());
        // chamando metodo que ira preencher o ultimo formulario da guia PROCESSO
        preencherPessoasVinculadas();

        // verificando se todos os IDs estão preenchidos para salvar o processo
        Ativar_Botao_Salvar_Processo();
    }

    /**
     * Metodo responsavel em preencher os campos referente ao noivo e noiva para
     * alteração de dados ou atualização
     *
     * @param id_selecionado
     * @param buscaTabela
     */
    private void preencherFormularioContraentes(String id_selecionado, String Tabela) {

        Pessoas_Model pessoaSelec;
        Enderecos_Model endereco;

        Localizar_Controller buscar = new Localizar_Controller();
        Enderecos_Controller buscar_end = new Enderecos_Controller();

        pessoaSelec = buscar.capturarDadosPessoaSelecionada(id_selecionado);
        endereco = buscar_end.Preenche_Formulario_Enderecos(pessoaSelec.getId_endereco());

        DateTimeFormatter formt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data;

        if (Tabela.equals("noivo")) {

            campoIdentificadorNoivo.setText(id_selecionado);
            campoNomeNoivo.setText(pessoaSelec.getNome());
            comboSexoNoivo.setSelectedItem(pessoaSelec.getSexo());
            comboNacioNoivo.setSelectedItem(pessoaSelec.getNacionalidade());
            comboEstCivilNoivo.setSelectedItem(pessoaSelec.getEst_civil());
            campoIdentNoivo.setText(pessoaSelec.getDocIdentidade());
            campoOrgaoExpNoivo.setText(pessoaSelec.getOrgaoExpeditor());
            data = LocalDate.parse(pessoaSelec.getDataExpedicao());
            campoDataExpedicaoNoivo.setText(String.valueOf(formt.format(data)));
            data = LocalDate.parse(pessoaSelec.getNascimento());
            campoNascNoivo.setText(String.valueOf(formt.format(data)));
            campoCpfNoivo.setText(pessoaSelec.getCpf());
            campoProfNoivo.setText(pessoaSelec.getProfissao());
            campoPaiNoivo.setText(pessoaSelec.getPai());
            campoMaeNoivo.setText(pessoaSelec.getMae());
            campoCidadNascNoivo.setText(pessoaSelec.getCidade_nasc());
            comboEstNascNoivo.setSelectedItem(pessoaSelec.getEstado_nasc());
            campoCidaResidNoivo.setText(endereco.getCidade_residencia());
            campoResidNoivo.setText(endereco.getNome_rua());
            comboEstResidNoivo.setSelectedItem(endereco.getEstado_residencia());
            campoComplementoNoivo.setText(endereco.getComplemento());
            campoBairroNoivo.setText(endereco.getBairro());

            if (pessoaSelec.getPai().equals("Não Declarado")) {
                checkPaiNaoDeclNoivo.setSelected(true);
            }

            // aqui iremos verificar se o usuario que esta cadastrado possui uma certidao vinculada
            // caso nao possua sera exibido uma mensagem ao usuario
            // abrira o formulario para cadastrar uma certidao e retornara o id da certidao apos o cadastramento
            if (pessoaSelec.getId_certidao() != 0) {

                this.id_certidao_noivo = pessoaSelec.getId_certidao();

                // desativando botao de INSERIR CERTIDAO
                btnInserirCertidao_Noivo.setEnabled(false);

                // chamando o metodo que preenche o formulario da GUIA PROCESSO
                preencherPessoasVinculadas();
            } else {

                JOptionPane.showMessageDialog(this, "Atenção: este usuario não possui nenhuma certidão cadastrada, para o processo\nde casamento deverá vincular uma certidão.", "Certidão não vinculada", JOptionPane.OK_OPTION);

                // formulario de cadastro de certidao
                Cadastrar_Certidao_View cadastrar_novaCert = new Cadastrar_Certidao_View(this, true);
                cadastrar_novaCert.setVisible(true);

                // verificando se a certidao foi cadastrada, e atribuirmo ao id_certidao_noivo
                if (cadastrar_novaCert.id_certidao != 0) {
                    this.id_certidao_noivo = cadastrar_novaCert.id_certidao;

                    // agora iremos atualizar as informa~ções da pessa selecionado
                    // add o ID da certidao na tabela pessoas
                    Pessoas_Controller atualizar_cad_pessoa = new Pessoas_Controller();
                    boolean retorno = atualizar_cad_pessoa.Atualizar_Pessoa_Inserir_id_certidao(id_certidao_noivo, id_noivo);

                    // se torno for verdadeiro, indica que os dados foram atualizados
                    // caso contrario, os campos são limpos
                    if (retorno == true) {
                        // chamando o metodo que preenche o formulario da GUIA PROCESSO
                        preencherPessoasVinculadas();
                    } else {

                        // limpando o formulario NOIVO
                        Limpar_Campos_Noivo();

                        // ativao botao inserir noivo
                        btnConfNoivo.setEnabled(true);
                    }

                } else {

                    JOptionPane.showMessageDialog(this, "Atenção: nenhuma certidao foi vinculada, não sera possivel dar\nprocedimento ao processo de casamento.", "Certidão não vinculada", JOptionPane.ERROR_MESSAGE);

                    // metodo que ira limpar os campos referente ao NOIVO
                    Limpar_Campos_Noivo();

                    // ativao botao inserir noivo
                    btnConfNoivo.setEnabled(true);
                }
            }

        } else if (Tabela.equals("noiva")) {
            pessoaSelec = buscar.capturarDadosPessoaSelecionada(id_selecionado);

            campoIdentificadorNoiva.setText(id_selecionado);
            campoNomeNoiva.setText(pessoaSelec.getNome());
            comboSexoNoiva.setSelectedItem(pessoaSelec.getSexo());
            comboNacionNoiva.setSelectedItem(pessoaSelec.getNacionalidade());
            comboEstCivilNoiva.setSelectedItem(pessoaSelec.getEst_civil());
            campoIdentidadeNoiva.setText(pessoaSelec.getDocIdentidade());
            campoOrgaoExpNoiva.setText(pessoaSelec.getOrgaoExpeditor());
            data = LocalDate.parse(pessoaSelec.getDataExpedicao());
            campoDataExpedicaoNoiva.setText(formt.format(data));
            data = LocalDate.parse(pessoaSelec.getNascimento());
            campoNascNoiva.setText(formt.format(data));
            campoCpfNoiva.setText(pessoaSelec.getCpf());
            campoProfNoiva.setText(pessoaSelec.getProfissao());
            campoPaiNoiva.setText(pessoaSelec.getPai());
            campoMaeNoiva.setText(pessoaSelec.getMae());
            campoCidadNascNoiva.setText(pessoaSelec.getCidade_nasc());
            comboEstaNascNoiva.setSelectedItem(pessoaSelec.getEstado_nasc());

            campoCidadResidNoiva.setText(endereco.getCidade_residencia());
            campoResidNoiva.setText(endereco.getNome_rua());
            comboEstResidNoiva.setSelectedItem(endereco.getEstado_residencia());
            campoBairroNoiva.setText(endereco.getBairro());
            campoComplementoNoiva.setText(endereco.getComplemento());

            if (pessoaSelec.getPai().equals("Não Declarado")) {
                checkPaiNaoDeclNoiva.setSelected(true);
            }

            // aqui iremos verificar se o usuario que esta cadastrado possui uma certidao vinculada
            // caso nao possua sera exibido uma mensagem ao usuario
            // abrira o formulario para cadastrar uma certidao e retornara o id da certidao apos o cadastramento
            if (pessoaSelec.getId_certidao() != 0) {
                this.id_certidao_noiva = pessoaSelec.getId_certidao();

                // desativando botao de INSERIR CERTIDAO
                btnInserirCertidao_Noiva.setEnabled(false);

                // chamando o metodo que preenche o formulario da GUIA PROCESSO
                preencherPessoasVinculadas();
            } else {

                JOptionPane.showMessageDialog(this, "Atenção: este usuario não possui nenhuma certidão cadastrada, para o processo\nde casamento deverá vincular uma certidão.", "Certidão não vinculada", JOptionPane.OK_OPTION);

                // formulario de cadastro de certidao
                Cadastrar_Certidao_View cadastrar_novaCert = new Cadastrar_Certidao_View(this, true);
                cadastrar_novaCert.setVisible(true);

                // verificando se a certidao foi cadastrada, e atribuirmo ao id_certidao_noivo
                if (cadastrar_novaCert.id_certidao != 0) {
                    this.id_certidao_noiva = cadastrar_novaCert.id_certidao;

                    Pessoas_Controller atualizar_cad_pessoa = new Pessoas_Controller();
                    boolean retorno = atualizar_cad_pessoa.Atualizar_Pessoa_Inserir_id_certidao(id_certidao_noiva, id_noiva);

                    // se torno for verdadeiro, indica que os dados foram atualizados
                    // caso contrario, os campos são limpos
                    if (retorno == true) {
                        // chamando o metodo que preenche o formulario da GUIA PROCESSO
                        preencherPessoasVinculadas();
                    } else {

                        // limpando o formulario NOIVO
                        Limpar_Campos_Noiva();

                        // ativao botao inserir noivo
                        btnConfNoiva.setEnabled(true);
                    }

                } else {

                    JOptionPane.showMessageDialog(this, "Atenção: nenhuma certidao foi vinculada, não sera possivel dar\nprocedimento ao processo de casamento.", "Certidão não vinculada", JOptionPane.ERROR_MESSAGE);

                    // limpando o formulario NOIVO
                    Limpar_Campos_Noiva();

                    // ativao botao inserir noivo
                    btnConfNoiva.setEnabled(true);

                }
            }
        }

    }

    /**
     * Metodo para preencher dados da guia PROCESSO, este metodo ira servir para
     * manter o controle de qual sera o noivo ou noiva e testemunhas que serão
     * vinculadas a este processo de casamento, CASO O PROCESSO NAO TENHA SIDO
     * SALVO POR COMPLETO
     */
    private void preencherPessoasVinculadas() {

        Localizar_Controller Buscar_Pessoa = new Localizar_Controller();

        // instanciando objeto tpo Localizar para buscar os dados referente aos contraentes e testemunhas
        // para preenchimento do formulario da guia PROCESSO
        if (id_noivo != 0) {
            String noivo = String.valueOf(id_noivo);
            Pessoas_Model marido;
            marido = Buscar_Pessoa.capturarDadosPessoaSelecionada(noivo);
            campoVinculoContraente1.setText(marido.getNome());

        }
        if (id_noiva != 0) {
            int id = this.id_noiva;
            Pessoas_Model esposa;
            String noiva = String.valueOf(id_noiva);
            esposa = Buscar_Pessoa.capturarDadosPessoaSelecionada(noiva);
            campoVinculoContraente2.setText(esposa.getNome());

        }
        if (id_testemunhas[0] != 0) {
            String id_test1 = String.valueOf(id_testemunhas[0]);
            Pessoas_Model testemunha1;
            testemunha1 = Buscar_Pessoa.capturarDadosPessoaSelecionada(id_test1);
            campoVinculoTestemunha1.setText(testemunha1.getNome());

        }
        if (id_testemunhas[1] != 0) {
            String id_test2 = String.valueOf(id_testemunhas[1]);
            Pessoas_Model testemunha2;
            testemunha2 = Buscar_Pessoa.capturarDadosPessoaSelecionada(id_test2);
            campoVinculoTestemunha2.setText(testemunha2.getNome());

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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        btnSalvarProcesso = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        campoNomeNoivo = new javax.swing.JTextField();
        comboNacioNoivo = new javax.swing.JComboBox();
        comboEstCivilNoivo = new javax.swing.JComboBox();
        campoIdentNoivo = new javax.swing.JTextField();
        campoOrgaoExpNoivo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        campoProfNoivo = new javax.swing.JTextField();
        campoCpfNoivo = new javax.swing.JFormattedTextField();
        campoNascNoivo = new javax.swing.JFormattedTextField();
        jLabel56 = new javax.swing.JLabel();
        campoIdentificadorNoivo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        comboSexoNoivo = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        campoDataExpedicaoNoivo = new javax.swing.JFormattedTextField();
        jLabel47 = new javax.swing.JLabel();
        campoCidadNascNoivo = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        comboEstNascNoivo = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        campoResidNoivo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        comboEstResidNoivo = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        campoBairroNoivo = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        campoComplementoNoivo = new javax.swing.JTextField();
        campoCidaResidNoivo = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        campoPaiNoivo = new javax.swing.JTextField();
        campoMaeNoivo = new javax.swing.JTextField();
        checkPaiNaoDeclNoivo = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        btnConfNoivo = new javax.swing.JButton();
        btnBuscarNoivo = new javax.swing.JButton();
        btnSalvarAtualNoivo = new javax.swing.JButton();
        btnInserirCertidao_Noivo = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        campoNomeNoiva = new javax.swing.JTextField();
        comboNacionNoiva = new javax.swing.JComboBox();
        comboEstCivilNoiva = new javax.swing.JComboBox();
        campoIdentidadeNoiva = new javax.swing.JTextField();
        campoOrgaoExpNoiva = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        campoProfNoiva = new javax.swing.JTextField();
        campoCpfNoiva = new javax.swing.JFormattedTextField();
        campoNascNoiva = new javax.swing.JFormattedTextField();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        campoCidadNascNoiva = new javax.swing.JTextField();
        comboEstaNascNoiva = new javax.swing.JComboBox<>();
        jLabel57 = new javax.swing.JLabel();
        campoIdentificadorNoiva = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        comboSexoNoiva = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        campoDataExpedicaoNoiva = new javax.swing.JFormattedTextField();
        btnConfNoiva = new javax.swing.JButton();
        btnBuscarNoiva = new javax.swing.JButton();
        btnSalvarAtualNoiva = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        campoCidadResidNoiva = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        campoResidNoiva = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        comboEstResidNoiva = new javax.swing.JComboBox();
        jLabel31 = new javax.swing.JLabel();
        campoBairroNoiva = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        campoComplementoNoiva = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        campoPaiNoiva = new javax.swing.JTextField();
        campoMaeNoiva = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        checkPaiNaoDeclNoiva = new javax.swing.JCheckBox();
        btnInserirCertidao_Noiva = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        campoIdentTest1 = new javax.swing.JTextField();
        campoOrgaoExpTest1 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        comboNacionTest1 = new javax.swing.JComboBox();
        comboEstCivilTest1 = new javax.swing.JComboBox();
        jLabel41 = new javax.swing.JLabel();
        campoNomeTest1 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        campoProfTest1 = new javax.swing.JTextField();
        campoCpfTest1 = new javax.swing.JFormattedTextField();
        campoNascTest1 = new javax.swing.JFormattedTextField();
        jLabel58 = new javax.swing.JLabel();
        campoIdentificadorTest1 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        campoDataExpedicao_testemunha = new javax.swing.JFormattedTextField();
        jLabel46 = new javax.swing.JLabel();
        comboSexo_testemunha = new javax.swing.JComboBox<>();
        jLabel65 = new javax.swing.JLabel();
        campoCidadNascTestemunha = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        comboEstNascTest1 = new javax.swing.JComboBox<>();
        jPanel13 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        campoCidadeResidTest1 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        comboEstResidTest1 = new javax.swing.JComboBox();
        jLabel33 = new javax.swing.JLabel();
        campoResidTest1 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        campoBairroTestemunha = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        campoComplementoTestemunha = new javax.swing.JTextField();
        btnSalvarTestm1 = new javax.swing.JButton();
        btnBuscarTest1 = new javax.swing.JButton();
        btnAtualizaçãoTest1 = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        campoPaiTestemunha = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        campoMaeTestemunha = new javax.swing.JTextField();
        checkPaiNaoDeclaradoTestemunha = new javax.swing.JCheckBox();
        btnConfirmarTestemunha = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        campoEditalProcesso = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        campoDataProcesso = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        campoNumeroProcesso = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        campoVinculoContraente1 = new javax.swing.JTextField();
        campoVinculoContraente2 = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        campoVinculoTestemunha1 = new javax.swing.JTextField();
        campoVinculoTestemunha2 = new javax.swing.JTextField();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inserir Novo Processo de Casamento");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setBorderPainted(false);

        btnSalvarProcesso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/document_save_as.png"))); // NOI18N
        btnSalvarProcesso.setText("Salvar Processo");
        btnSalvarProcesso.setEnabled(false);
        btnSalvarProcesso.setFocusable(false);
        btnSalvarProcesso.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnSalvarProcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarProcessoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSalvarProcesso);
        jToolBar1.add(jSeparator1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/stop_pequeno.png"))); // NOI18N
        jButton2.setText("Sair");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jTabbedPane1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jTabbedPane2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setText("Nome:");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("Nacionalidade");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setText("Estado Civil:");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setText("Doc. Identidade:");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setText("Orgão Exp:");

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel7.setText("CPF:");

        campoNomeNoivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoNomeNoivoMouseClicked(evt);
            }
        });
        campoNomeNoivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoNomeNoivoKeyReleased(evt);
            }
        });

        comboNacioNoivo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        comboNacioNoivo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Brasileiro", "Estrangeiro" }));

        comboEstCivilNoivo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        comboEstCivilNoivo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Casado", "Solteiro", "Convivente", "Divorciado", "Viuvo(a)" }));

        campoIdentNoivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoIdentNoivoMouseClicked(evt);
            }
        });
        campoIdentNoivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoIdentNoivoKeyReleased(evt);
            }
        });

        campoOrgaoExpNoivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoOrgaoExpNoivoMouseClicked(evt);
            }
        });
        campoOrgaoExpNoivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoOrgaoExpNoivoKeyReleased(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel12.setText("Data Nasc:");

        jLabel50.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel50.setText("Profissão:");

        campoProfNoivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoProfNoivoMouseClicked(evt);
            }
        });
        campoProfNoivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoProfNoivoKeyReleased(evt);
            }
        });

        try {
            campoCpfNoivo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoCpfNoivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoCpfNoivoMouseClicked(evt);
            }
        });
        campoCpfNoivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoCpfNoivoKeyReleased(evt);
            }
        });

        try {
            campoNascNoivo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoNascNoivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoNascNoivoMouseClicked(evt);
            }
        });

        jLabel56.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel56.setText("Identificador:");

        campoIdentificadorNoivo.setEditable(false);

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel13.setText("Sexo:");

        comboSexoNoivo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        comboSexoNoivo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino" }));

        jLabel16.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel16.setText("Data Exp:");

        try {
            campoDataExpedicaoNoivo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel47.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel47.setText("Natural de:");

        campoCidadNascNoivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoCidadNascNoivoMouseClicked(evt);
            }
        });
        campoCidadNascNoivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoCidadNascNoivoKeyReleased(evt);
            }
        });

        jLabel49.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel49.setText("Estado:");

        comboEstNascNoivo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        comboEstNascNoivo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoIdentNoivo))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoCpfNoivo, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoOrgaoExpNoivo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoDataExpedicaoNoivo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboSexoNoivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel50)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoProfNoivo, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoNascNoivo, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel56)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoIdentificadorNoivo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoNomeNoivo, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(6, 6, 6)
                        .addComponent(comboNacioNoivo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboEstCivilNoivo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel47)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoCidadNascNoivo, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel49)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboEstNascNoivo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(65, 65, 65))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(campoIdentificadorNoivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoNomeNoivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(comboNacioNoivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(comboEstCivilNoivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(comboSexoNoivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(campoIdentNoivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(campoOrgaoExpNoivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16)
                        .addComponent(campoDataExpedicaoNoivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(campoCpfNoivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel50)
                    .addComponent(campoProfNoivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(campoNascNoivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(campoCidadNascNoivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49)
                    .addComponent(comboEstNascNoivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel8.setText("Cidade:");

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setText("Residencia:");

        campoResidNoivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoResidNoivoMouseClicked(evt);
            }
        });
        campoResidNoivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoResidNoivoKeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel9.setText("Estado:");

        comboEstResidNoivo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        comboEstResidNoivo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" }));

        jLabel14.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel14.setText("Bairro:");

        jLabel15.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel15.setText("Complemento:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campoComplementoNoivo, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoCidaResidNoivo, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoResidNoivo, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(37, 37, 37)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboEstResidNoivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoBairroNoivo, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(comboEstResidNoivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoCidaResidNoivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(campoResidNoivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(campoBairroNoivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(campoComplementoNoivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel11.setText("Mãe:");

        campoPaiNoivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoPaiNoivoMouseClicked(evt);
            }
        });
        campoPaiNoivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoPaiNoivoKeyReleased(evt);
            }
        });

        campoMaeNoivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoMaeNoivoMouseClicked(evt);
            }
        });
        campoMaeNoivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoMaeNoivoKeyReleased(evt);
            }
        });

        checkPaiNaoDeclNoivo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        checkPaiNaoDeclNoivo.setText("Não Declarado");
        checkPaiNaoDeclNoivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkPaiNaoDeclNoivoActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel10.setText("Pai:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(campoMaeNoivo))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(campoPaiNoivo, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(checkPaiNaoDeclNoivo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(checkPaiNaoDeclNoivo)
                .addGap(46, 46, 46))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(campoPaiNoivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(campoMaeNoivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        btnConfNoivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/button_ok_pequeno.png"))); // NOI18N
        btnConfNoivo.setToolTipText("Confirmar Noivo");
        btnConfNoivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfNoivoActionPerformed(evt);
            }
        });

        btnBuscarNoivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Consulta_LOCALIZAR.png"))); // NOI18N
        btnBuscarNoivo.setToolTipText("Buscar Noivo");
        btnBuscarNoivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarNoivoActionPerformed(evt);
            }
        });

        btnSalvarAtualNoivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/document_save_as.png"))); // NOI18N
        btnSalvarAtualNoivo.setToolTipText("Salvar alterações");
        btnSalvarAtualNoivo.setEnabled(false);
        btnSalvarAtualNoivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarAtualNoivoActionPerformed(evt);
            }
        });

        btnInserirCertidao_Noivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/diploma.png"))); // NOI18N
        btnInserirCertidao_Noivo.setToolTipText("Inserir Certidao");
        btnInserirCertidao_Noivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirCertidao_NoivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConfNoivo)
                    .addComponent(btnBuscarNoivo)
                    .addComponent(btnSalvarAtualNoivo)
                    .addComponent(btnInserirCertidao_Noivo)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnConfNoivo)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarNoivo)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvarAtualNoivo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInserirCertidao_Noivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Informações Noivo", jPanel3);

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel17.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel17.setText("Nome:");

        jLabel18.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel18.setText("Doc. identidade:");

        jLabel19.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel19.setText("Orgão Exp:");

        jLabel20.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel20.setText("CPF:");

        jLabel26.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel26.setText("Nacionalidade:");

        jLabel27.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel27.setText("Estado Civil:");

        jLabel28.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel28.setText("Data Nasc:");

        campoNomeNoiva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoNomeNoivaMouseClicked(evt);
            }
        });
        campoNomeNoiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoNomeNoivaKeyReleased(evt);
            }
        });

        comboNacionNoiva.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        comboNacionNoiva.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Brasileira", "Estrangeiro" }));

        comboEstCivilNoiva.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        comboEstCivilNoiva.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Casado", "Solteiro", "Convivente", "Divorciado", "Viuvo(a)" }));

        campoIdentidadeNoiva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoIdentidadeNoivaMouseClicked(evt);
            }
        });
        campoIdentidadeNoiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoIdentidadeNoivaKeyReleased(evt);
            }
        });

        campoOrgaoExpNoiva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoOrgaoExpNoivaMouseClicked(evt);
            }
        });
        campoOrgaoExpNoiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoOrgaoExpNoivaKeyReleased(evt);
            }
        });

        jLabel51.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel51.setText("Profissão:");

        campoProfNoiva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoProfNoivaMouseClicked(evt);
            }
        });
        campoProfNoiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoProfNoivaKeyReleased(evt);
            }
        });

        try {
            campoCpfNoiva.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoCpfNoiva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoCpfNoivaMouseClicked(evt);
            }
        });
        campoCpfNoiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoCpfNoivaKeyReleased(evt);
            }
        });

        try {
            campoNascNoiva.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoNascNoiva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoNascNoivaMouseClicked(evt);
            }
        });
        campoNascNoiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoNascNoivaKeyReleased(evt);
            }
        });

        jLabel54.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel54.setText("Natural de:");

        jLabel55.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel55.setText("Estado:");

        campoCidadNascNoiva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoCidadNascNoivaMouseClicked(evt);
            }
        });
        campoCidadNascNoiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoCidadNascNoivaKeyReleased(evt);
            }
        });

        comboEstaNascNoiva.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        comboEstaNascNoiva.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" }));

        jLabel57.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel57.setText("Identificador:");

        campoIdentificadorNoiva.setEditable(false);

        jLabel29.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel29.setText("Sexo:");

        comboSexoNoiva.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        comboSexoNoiva.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Feminino", "Masculino" }));

        jLabel30.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel30.setText("Data exp:");

        try {
            campoDataExpedicaoNoiva.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel57)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoIdentificadorNoiva, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel54)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoCidadNascNoiva, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel55)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboEstaNascNoiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(18, 18, 18)
                        .addComponent(campoCpfNoiva, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel51)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoProfNoiva, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel28)
                        .addGap(2, 2, 2)
                        .addComponent(campoNascNoiva, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoIdentidadeNoiva, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoOrgaoExpNoiva, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoDataExpedicaoNoiva, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoNomeNoiva, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboNacionNoiva, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboEstCivilNoiva, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboSexoNoiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(campoIdentificadorNoiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel26)
                    .addComponent(campoNomeNoiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboNacionNoiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(comboEstCivilNoiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel29)
                        .addComponent(comboSexoNoiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(campoIdentidadeNoiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19)
                        .addComponent(campoOrgaoExpNoiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel30)
                        .addComponent(campoDataExpedicaoNoiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel51)
                    .addComponent(campoProfNoiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoCpfNoiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(campoNascNoiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(jLabel55)
                    .addComponent(campoCidadNascNoiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboEstaNascNoiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnConfNoiva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/button_ok_pequeno.png"))); // NOI18N
        btnConfNoiva.setToolTipText("Confirmar Noiva");
        btnConfNoiva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfNoivaActionPerformed(evt);
            }
        });

        btnBuscarNoiva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Consulta_LOCALIZAR.png"))); // NOI18N
        btnBuscarNoiva.setToolTipText("Buscar Noiva");
        btnBuscarNoiva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarNoivaActionPerformed(evt);
            }
        });

        btnSalvarAtualNoiva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/document_save_as.png"))); // NOI18N
        btnSalvarAtualNoiva.setToolTipText("Salvar alterações");
        btnSalvarAtualNoiva.setEnabled(false);
        btnSalvarAtualNoiva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarAtualNoivaActionPerformed(evt);
            }
        });

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel22.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel22.setText("Cidade:");

        campoCidadResidNoiva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoCidadResidNoivaMouseClicked(evt);
            }
        });
        campoCidadResidNoiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoCidadResidNoivaKeyReleased(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel21.setText("Residencia:");

        campoResidNoiva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoResidNoivaMouseClicked(evt);
            }
        });
        campoResidNoiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoResidNoivaKeyReleased(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel23.setText("Estado:");

        comboEstResidNoiva.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        comboEstResidNoiva.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" }));

        jLabel31.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel31.setText("Bairro:");

        jLabel32.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel32.setText("Complemento:");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoComplementoNoiva))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoCidadResidNoiva, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoResidNoiva)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboEstResidNoiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addGap(18, 18, 18)
                        .addComponent(campoBairroNoiva, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(76, 76, 76))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(campoCidadResidNoiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(comboEstResidNoiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(campoResidNoiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(campoBairroNoiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(campoComplementoNoiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel24.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel24.setText("Pai:");

        campoPaiNoiva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoPaiNoivaMouseClicked(evt);
            }
        });
        campoPaiNoiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoPaiNoivaKeyReleased(evt);
            }
        });

        campoMaeNoiva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoMaeNoivaMouseClicked(evt);
            }
        });
        campoMaeNoiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoMaeNoivaKeyReleased(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel25.setText("Mãe:");

        checkPaiNaoDeclNoiva.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        checkPaiNaoDeclNoiva.setText("Não Declarado");
        checkPaiNaoDeclNoiva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkPaiNaoDeclNoivaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoPaiNoiva, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(checkPaiNaoDeclNoiva))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoMaeNoiva, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(campoPaiNoiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkPaiNaoDeclNoiva))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(campoMaeNoiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnInserirCertidao_Noiva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/diploma.png"))); // NOI18N
        btnInserirCertidao_Noiva.setToolTipText("Inserir Certidao");
        btnInserirCertidao_Noiva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirCertidao_NoivaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnBuscarNoiva)
                        .addComponent(btnConfNoiva)
                        .addComponent(btnSalvarAtualNoiva))
                    .addComponent(btnInserirCertidao_Noiva))
                .addGap(112, 112, 112))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnConfNoiva)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarNoiva)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvarAtualNoiva)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInserirCertidao_Noiva))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        jTabbedPane2.addTab("Informações Noiva", jPanel4);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1058, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jTabbedPane1.addTab("Contraentes", jPanel2);

        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        campoIdentTest1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoIdentTest1MouseClicked(evt);
            }
        });
        campoIdentTest1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoIdentTest1KeyReleased(evt);
            }
        });

        campoOrgaoExpTest1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoOrgaoExpTest1MouseClicked(evt);
            }
        });
        campoOrgaoExpTest1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoOrgaoExpTest1KeyReleased(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel36.setText("Doc.Identidade:");

        jLabel37.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel37.setText("Orgão Exp:");

        jLabel38.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel38.setText("Data Nasc:");

        jLabel39.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel39.setText("CPF:");

        jLabel40.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel40.setText("Nacionalidade:");

        comboNacionTest1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        comboNacionTest1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Brasileiro", "Estrangeiro" }));

        comboEstCivilTest1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        comboEstCivilTest1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Casado", "Solteiro", "Convivente", "Divorciado", "Viuvo(a)" }));

        jLabel41.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel41.setText("Estado civil:");

        campoNomeTest1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoNomeTest1MouseClicked(evt);
            }
        });
        campoNomeTest1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoNomeTest1KeyReleased(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel42.setText("Nome:");

        jLabel52.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel52.setText("Profissão:");

        campoProfTest1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoProfTest1MouseClicked(evt);
            }
        });
        campoProfTest1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoProfTest1KeyReleased(evt);
            }
        });

        try {
            campoCpfTest1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoCpfTest1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoCpfTest1MouseClicked(evt);
            }
        });

        try {
            campoNascTest1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoNascTest1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoNascTest1ClickMouse(evt);
            }
        });
        campoNascTest1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoNascTest1KeyRelease(evt);
            }
        });

        jLabel58.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel58.setText("Identificador:");

        campoIdentificadorTest1.setEditable(false);

        jLabel45.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel45.setText("Data exp:");

        try {
            campoDataExpedicao_testemunha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel46.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel46.setText("Sexo:");

        comboSexo_testemunha.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        comboSexo_testemunha.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino" }));

        jLabel65.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel65.setText("Natural de:");

        campoCidadNascTestemunha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoCidadNascTestemunhaMouseClicked(evt);
            }
        });
        campoCidadNascTestemunha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoCidadNascTestemunhaKeyReleased(evt);
            }
        });

        jLabel66.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel66.setText("Estado:");

        comboEstNascTest1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        comboEstNascTest1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" }));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoIdentTest1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel37)
                                .addGap(2, 2, 2)
                                .addComponent(campoOrgaoExpTest1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel45)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoDataExpedicao_testemunha, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel46)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboSexo_testemunha, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel42)
                                .addGap(18, 18, 18)
                                .addComponent(campoNomeTest1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel40)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboNacionTest1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel41)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(comboEstCivilTest1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel58)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoIdentificadorTest1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel39)
                        .addGap(18, 18, 18)
                        .addComponent(campoCpfTest1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel52)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoProfTest1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoNascTest1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel65)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoCidadNascTestemunha, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel66)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboEstNascTest1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(campoIdentificadorTest1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(campoNomeTest1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40)
                    .addComponent(comboNacionTest1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41)
                    .addComponent(comboEstCivilTest1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(campoIdentTest1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37)
                    .addComponent(campoOrgaoExpTest1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45)
                    .addComponent(campoDataExpedicao_testemunha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46)
                    .addComponent(comboSexo_testemunha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(jLabel52)
                    .addComponent(campoProfTest1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoCpfTest1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38)
                    .addComponent(campoNascTest1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel65)
                    .addComponent(campoCidadNascTestemunha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel66)
                    .addComponent(comboEstNascTest1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel34.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel34.setText("Cidade:");

        campoCidadeResidTest1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoCidadeResidTest1MouseClicked(evt);
            }
        });
        campoCidadeResidTest1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoCidadeResidTest1KeyReleased(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel35.setText("Estado:");

        comboEstResidTest1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        comboEstResidTest1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" }));

        jLabel33.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel33.setText("Residencia:");

        campoResidTest1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoResidTest1MouseClicked(evt);
            }
        });
        campoResidTest1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoResidTest1KeyReleased(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel43.setText("Bairro:");

        jLabel44.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel44.setText("Complemento:");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoComplementoTestemunha, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoCidadeResidTest1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboEstResidTest1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoResidTest1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel43)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoBairroTestemunha, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(campoCidadeResidTest1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35)
                    .addComponent(comboEstResidTest1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(campoResidTest1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43)
                    .addComponent(campoBairroTestemunha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(campoComplementoTestemunha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnSalvarTestm1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Testemunhas.png"))); // NOI18N
        btnSalvarTestm1.setToolTipText("Cadastrar Nova Pessoa");
        btnSalvarTestm1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarTestm1ActionPerformed(evt);
            }
        });

        btnBuscarTest1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Consulta_LOCALIZAR.png"))); // NOI18N
        btnBuscarTest1.setToolTipText("Buscar testemunha");
        btnBuscarTest1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarTest1ActionPerformed(evt);
            }
        });

        btnAtualizaçãoTest1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/document_save_as.png"))); // NOI18N
        btnAtualizaçãoTest1.setToolTipText("Salvar alterações");
        btnAtualizaçãoTest1.setEnabled(false);
        btnAtualizaçãoTest1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizaçãoTest1ActionPerformed(evt);
            }
        });

        jPanel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel63.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel63.setText("Pai:");

        campoPaiTestemunha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoPaiTestemunhaMouseClicked(evt);
            }
        });
        campoPaiTestemunha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoPaiTestemunhaKeyReleased(evt);
            }
        });

        jLabel64.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel64.setText("Mãe:");

        campoMaeTestemunha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoMaeTestemunhaMouseClicked(evt);
            }
        });
        campoMaeTestemunha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoMaeTestemunhaKeyReleased(evt);
            }
        });

        checkPaiNaoDeclaradoTestemunha.setText("Não Declarado");
        checkPaiNaoDeclaradoTestemunha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkPaiNaoDeclaradoTestemunhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel63)
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel17Layout.createSequentialGroup()
                            .addComponent(jLabel64)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(campoMaeTestemunha))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel17Layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(campoPaiTestemunha, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(checkPaiNaoDeclaradoTestemunha)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(checkPaiNaoDeclaradoTestemunha)
                .addGap(46, 46, 46))
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63)
                    .addComponent(campoPaiTestemunha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel64)
                    .addComponent(campoMaeTestemunha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        btnConfirmarTestemunha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/button_ok_pequeno.png"))); // NOI18N
        btnConfirmarTestemunha.setToolTipText("Confirmar testemunha");
        btnConfirmarTestemunha.setEnabled(false);
        btnConfirmarTestemunha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarTestemunhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalvarTestm1)
                    .addComponent(btnBuscarTest1)
                    .addComponent(btnAtualizaçãoTest1)
                    .addComponent(btnConfirmarTestemunha))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(btnSalvarTestm1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscarTest1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAtualizaçãoTest1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnConfirmarTestemunha)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Testemunhas", jPanel11);

        jPanel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel48.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel48.setText("Edital de Proclamas nº:");

        campoEditalProcesso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoEditalProcessoMouseClicked(evt);
            }
        });

        jLabel53.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel53.setText("Data do Processo:");

        campoDataProcesso.setEditable(false);
        campoDataProcesso.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel59.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel59.setText("Processo nº:");

        campoNumeroProcesso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoNumeroProcessoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel53))
                            .addComponent(campoNumeroProcesso)
                            .addComponent(campoEditalProcesso)
                            .addComponent(campoDataProcesso)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel59)))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel59)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campoNumeroProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel48)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campoEditalProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel53)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campoDataProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
        );

        jPanel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel60.setText("Pessoas vinculadas a este processo");

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel61.setText("Contraentes");

        campoVinculoContraente1.setEditable(false);

        campoVinculoContraente2.setEditable(false);

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel62.setText("Testemunhas");

        campoVinculoTestemunha1.setEditable(false);

        campoVinculoTestemunha2.setEditable(false);
        campoVinculoTestemunha2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoVinculoTestemunha2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel60))
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel16Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(campoVinculoTestemunha2, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel16Layout.createSequentialGroup()
                            .addGap(86, 86, 86)
                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(campoVinculoContraente1)
                                .addComponent(campoVinculoContraente2)
                                .addComponent(campoVinculoTestemunha1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addComponent(jLabel61))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(jLabel62)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel61)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campoVinculoContraente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campoVinculoContraente2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campoVinculoTestemunha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campoVinculoTestemunha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(155, 155, 155))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jTabbedPane1.addTab("Processo de Casamento", jPanel14);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1073, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarAtualNoivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarAtualNoivoActionPerformed

        Pessoas_Controller Atualizar_Dados_Pessoa = new Pessoas_Controller();
        Pessoas_Model gNoivo = new Pessoas_Model();

        // coletando os dados referente ao NOIVO
        gNoivo.setNome(campoNomeNoivo.getText());
        gNoivo.setDocIdentidade(campoIdentNoivo.getText());
        gNoivo.setOrgaoExpeditor(campoOrgaoExpNoivo.getText());
        gNoivo.setDataExpedicao(campoDataExpedicaoNoivo.getText());
        gNoivo.setSexo(comboSexoNoivo.getSelectedItem().toString());
        gNoivo.setNascimento(campoNascNoivo.getText());
        gNoivo.setCpf(campoCpfNoivo.getText());
        gNoivo.setNacionalidade(comboNacioNoivo.getSelectedItem().toString());
        gNoivo.setEst_civil(comboEstCivilNoivo.getSelectedItem().toString());
        gNoivo.setProfissao(campoProfNoivo.getText());
        gNoivo.setEstado_nasc(comboEstNascNoivo.getSelectedItem().toString());
        gNoivo.setCidade_nasc(campoCidadNascNoivo.getText());
        gNoivo.setMae(campoMaeNoivo.getText());
        gNoivo.setPai(campoPaiNoivo.getText());

        Atualizar_Dados_Pessoa.salvarAlteracao(gNoivo, id_noivo);

    }//GEN-LAST:event_btnSalvarAtualNoivoActionPerformed

    private void btnBuscarNoivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarNoivoActionPerformed
        // chamando tela de dialogo localizar uma pessoa
        // valor ZERO indica MASCULINO da tabela pessoa
        Localizar_Pessoas_View localizar = new Localizar_Pessoas_View(this, true, 0);
        localizar.setVisible(true);

        if (localizar.id_selecionado == null) {
            JOptionPane.showMessageDialog(this, "Nenhum noivo foi selecionado", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else {

            btnSalvarAtualNoivo.setEnabled(true);
            btnConfNoivo.setEnabled(false);

            // modificando o valor do atributo id_noivo, assim preenchemos o formulario da GUIA PROCESSO
            this.id_noivo = Integer.parseInt(localizar.id_selecionado);
            String id = String.valueOf(this.id_noivo);

            preencherFormularioContraentes(id, "noivo");
        }
    }//GEN-LAST:event_btnBuscarNoivoActionPerformed

    private void btnConfNoivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfNoivoActionPerformed

        // verificamos OBRIGATORIAMENTE se a certidao foi vinculada, caso NÃO SEJA, não e possivel a gravação
        if (this.id_certidao_noivo != 0) {
            // instanciando objetos para gravação de dados do NOIVO
            Pessoas_Model gNoivo = new Pessoas_Model();
            Enderecos_Model endereco = new Enderecos_Model();

            // objeto controller
            Pessoas_Controller inserir_Pessoa = new Pessoas_Controller();

            // verificamos se o endereco foi selecionado ou foi informado NOVO
            if (id_endereco_noivo != 0) {

                // coletando os dados referente ao NOIVO
                gNoivo.setNome(campoNomeNoivo.getText());
                gNoivo.setDocIdentidade(campoIdentNoivo.getText());
                gNoivo.setOrgaoExpeditor(campoOrgaoExpNoivo.getText());
                gNoivo.setDataExpedicao(campoDataExpedicaoNoivo.getText());
                gNoivo.setSexo(comboSexoNoivo.getSelectedItem().toString());
                gNoivo.setNascimento(campoNascNoivo.getText());
                gNoivo.setCpf(campoCpfNoivo.getText());
                gNoivo.setNacionalidade(comboNacioNoivo.getSelectedItem().toString());
                gNoivo.setEst_civil(comboEstCivilNoivo.getSelectedItem().toString());
                gNoivo.setProfissao(campoProfNoivo.getText());
                gNoivo.setEstado_nasc(comboEstNascNoivo.getSelectedItem().toString());
                gNoivo.setCidade_nasc(campoCidadNascNoivo.getText());
                gNoivo.setMae(campoMaeNoivo.getText());
                gNoivo.setPai(campoPaiNoivo.getText());

                // chamando metodo que ira inserir nova pessoa na tabela pessoas, 
                // retornado um id da pessoa
                this.id_noivo = inserir_Pessoa.Inserir_Novo_Cadastro_Pessoa(gNoivo, id_endereco_noivo, id_certidao_noivo);

                // verificamos se a gravação ocorreu, e retornou o ID do usuario
                if (this.id_noivo != 0) {

                    // chamando metodo que ira preencher o ultimo formulario da guia PROCESSO
                    preencherPessoasVinculadas();

                    // Desativamos o botao que confirma a inclusao, pois não precisaremos 
                    btnConfNoivo.setEnabled(false);
                    btnSalvarAtualNoivo.setEnabled(false);
                    btnBuscarNoivo.setEnabled(false);
                    btnInserirCertidao_Noivo.setEnabled(false);
                } else {

                    // caso nao retorno o ID da pessoa, deixamo os botoes ativados
                    btnConfNoivo.setEnabled(true);
                    btnSalvarAtualNoivo.setEnabled(false);
                    btnBuscarNoivo.setEnabled(true);
                    btnInserirCertidao_Noivo.setEnabled(true);

                }

            } else {
                // coletando os dados referente ao NOIVO
                gNoivo.setNome(campoNomeNoivo.getText());
                gNoivo.setDocIdentidade(campoIdentNoivo.getText());
                gNoivo.setOrgaoExpeditor(campoOrgaoExpNoivo.getText());
                gNoivo.setDataExpedicao(campoDataExpedicaoNoivo.getText());
                gNoivo.setSexo(comboSexoNoivo.getSelectedItem().toString());
                gNoivo.setNascimento(campoNascNoivo.getText());
                gNoivo.setCpf(campoCpfNoivo.getText());
                gNoivo.setNacionalidade(comboNacioNoivo.getSelectedItem().toString());
                gNoivo.setEst_civil(comboEstCivilNoivo.getSelectedItem().toString());
                gNoivo.setProfissao(campoProfNoivo.getText());
                gNoivo.setEstado_nasc(comboEstNascNoivo.getSelectedItem().toString());
                gNoivo.setCidade_nasc(campoCidadNascNoivo.getText());
                gNoivo.setMae(campoMaeNoivo.getText());
                gNoivo.setPai(campoPaiNoivo.getText());

                endereco.setNome_rua(campoResidNoivo.getText());
                endereco.setBairro(campoBairroNoivo.getText());
                endereco.setComplemento(campoComplementoNoivo.getText());
                endereco.setCidade_residencia(campoCidaResidNoivo.getText());
                endereco.setEstado_residencia(comboEstResidNoivo.getSelectedItem().toString());

                // inserir primeiro o novo endereco, e logo apos indicar o ID de retorno para o atributo especifico
                Enderecos_Controller salvar_endereco = new Enderecos_Controller();
                this.id_endereco_noivo = salvar_endereco.inserir_Novo_Endereco(endereco);

                // se o endereço foi devidament inserido, fazemos a gravação da pessoa na tabela pessoas
                // caso contrario nao inserimos a pessoa
                if (id_endereco_noivo != 0) {
                    // chamando metodo que insere  um novo cadastro de pessoa
                    // capturando de retorno o ID da pessoa
                    this.id_noivo = inserir_Pessoa.Inserir_Novo_Cadastro_Pessoa(gNoivo, id_endereco_noivo, id_certidao_noivo);

                    // verificamos se a gravação ocorreu, e retornou o ID do usuario
                    if (this.id_noivo != 0) {

                        // chamando metodo que ira preencher o ultimo formulario da guia PROCESSO
                        preencherPessoasVinculadas();

                        // Desativamos o botao que confirma a inclusao, pois não precisaremos 
                        btnConfNoivo.setEnabled(false);
                        btnSalvarAtualNoivo.setEnabled(false);
                        btnBuscarNoivo.setEnabled(false);
                        btnInserirCertidao_Noivo.setEnabled(false);
                    } else {

                        // caso nao retorno o ID da pessoa, deixamo os botoes ativados
                        btnConfNoivo.setEnabled(true);
                        btnSalvarAtualNoivo.setEnabled(false);
                        btnBuscarNoivo.setEnabled(true);
                        btnInserirCertidao_Noivo.setEnabled(true);

                    }

                } else {
                    campoCidaResidNoivo.requestFocus();
                }
            }
        } else {
            // caso o usuario nao vincule uma certidao ao processo desativamos o botao inserir e exibimos a MENSAGEM na tela
            btnConfNoivo.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Atenção: para a inserção de pessoa ao processo de casamento,\ndeverá ser vinculada uma Certidao", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            btnInserirCertidao_Noivo.requestFocus();
        }

    }//GEN-LAST:event_btnConfNoivoActionPerformed

    private void checkPaiNaoDeclNoivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkPaiNaoDeclNoivoActionPerformed
        // TODO add your handling code here:

        if (checkPaiNaoDeclNoivo.isSelected()) {
            campoPaiNoivo.setText("Não declarado");
        } else {
            campoPaiNoivo.setText("");
        }
    }//GEN-LAST:event_checkPaiNaoDeclNoivoActionPerformed

    private void campoMaeNoivoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoMaeNoivoKeyReleased
        // TODO add your handling code here:
        campoMaeNoivo.setBackground(Color.WHITE);

        if (campoMaeNoivo.getText().isEmpty()) {
            campoMaeNoivo.setBackground(new Color(255, 64, 64));
        }
    }//GEN-LAST:event_campoMaeNoivoKeyReleased

    private void campoMaeNoivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoMaeNoivoMouseClicked
        // TODO add your handling code here:
        campoMaeNoivo.setBackground(new Color(102, 205, 170));
    }//GEN-LAST:event_campoMaeNoivoMouseClicked

    private void campoPaiNoivoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPaiNoivoKeyReleased
        // TODO add your handling code here:
        campoPaiNoivo.setBackground(Color.WHITE);

        if (campoPaiNoivo.getText().isEmpty()) {
            campoPaiNoivo.setBackground(new Color(255, 64, 64));
        }
    }//GEN-LAST:event_campoPaiNoivoKeyReleased

    private void campoPaiNoivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoPaiNoivoMouseClicked
        // TODO add your handling code here:
        campoPaiNoivo.setBackground(new Color(102, 205, 170));
    }//GEN-LAST:event_campoPaiNoivoMouseClicked

    private void campoResidNoivoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoResidNoivoKeyReleased
        // TODO add your handling code here:
        campoResidNoivo.setBackground(Color.WHITE);

        if (campoResidNoivo.getText().isEmpty()) {
            campoResidNoivo.setBackground(new Color(255, 64, 64));
        }
    }//GEN-LAST:event_campoResidNoivoKeyReleased

    private void campoResidNoivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoResidNoivoMouseClicked
        // TODO add your handling code here:
        campoResidNoivo.setBackground(new Color(102, 205, 170));
    }//GEN-LAST:event_campoResidNoivoMouseClicked

    private void campoCidadNascNoivoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCidadNascNoivoKeyReleased
        // TODO add your handling code here:
        campoCidadNascNoivo.setBackground(Color.WHITE);

        if (campoCidadNascNoivo.getText().isEmpty()) {
            campoCidadNascNoivo.setBackground(new Color(255, 64, 64));
        }
    }//GEN-LAST:event_campoCidadNascNoivoKeyReleased

    private void campoCidadNascNoivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoCidadNascNoivoMouseClicked
        // TODO add your handling code here:
        campoCidadNascNoivo.setBackground(new Color(102, 205, 170));
    }//GEN-LAST:event_campoCidadNascNoivoMouseClicked

    private void campoNascNoivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoNascNoivoMouseClicked
        // TODO add your handling code here:
        campoNascNoivo.setBackground(new Color(102, 205, 170));
    }//GEN-LAST:event_campoNascNoivoMouseClicked

    private void campoCpfNoivoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCpfNoivoKeyReleased
        // TODO add your handling code here:
        campoCpfNoivo.setBackground(Color.WHITE);

        if (campoCpfNoivo.getText().isEmpty()) {
            campoCpfNoivo.setBackground(new Color(255, 64, 64));
        }
    }//GEN-LAST:event_campoCpfNoivoKeyReleased

    private void campoCpfNoivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoCpfNoivoMouseClicked
        // TODO add your handling code here:
        campoCpfNoivo.setBackground(new Color(102, 205, 170));
    }//GEN-LAST:event_campoCpfNoivoMouseClicked

    private void campoProfNoivoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoProfNoivoKeyReleased
        // TODO add your handling code here:
        campoProfNoivo.setBackground(Color.WHITE);

        if (campoProfNoivo.getText().isEmpty()) {
            campoProfNoivo.setBackground(new Color(255, 64, 64));
        }
    }//GEN-LAST:event_campoProfNoivoKeyReleased

    private void campoProfNoivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoProfNoivoMouseClicked
        // TODO add your handling code here:
        campoProfNoivo.setBackground(new Color(102, 205, 170));
    }//GEN-LAST:event_campoProfNoivoMouseClicked

    private void campoOrgaoExpNoivoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoOrgaoExpNoivoKeyReleased
        // TODO add your handling code here:
        campoOrgaoExpNoivo.setBackground(Color.WHITE);

        if (campoOrgaoExpNoivo.getText().isEmpty()) {
            campoOrgaoExpNoivo.setBackground(new Color(255, 64, 64));
        }
    }//GEN-LAST:event_campoOrgaoExpNoivoKeyReleased

    private void campoOrgaoExpNoivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoOrgaoExpNoivoMouseClicked
        // TODO add your handling code here:
        campoOrgaoExpNoivo.setBackground(new Color(102, 205, 170));
    }//GEN-LAST:event_campoOrgaoExpNoivoMouseClicked

    private void campoIdentNoivoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoIdentNoivoKeyReleased
        // TODO add your handling code here:
        campoIdentNoivo.setBackground(Color.WHITE);

        if (campoIdentNoivo.getText().isEmpty()) {
            campoIdentNoivo.setBackground(new Color(255, 64, 64));
        }
    }//GEN-LAST:event_campoIdentNoivoKeyReleased

    private void campoIdentNoivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoIdentNoivoMouseClicked
        // TODO add your handling code here:
        campoIdentNoivo.setBackground(new Color(102, 205, 170));
    }//GEN-LAST:event_campoIdentNoivoMouseClicked

    private void campoNomeNoivoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNomeNoivoKeyReleased
        // TODO add your handling code here:
        campoNomeNoivo.setBackground(Color.WHITE);

        if (campoNomeNoivo.getText().isEmpty()) {
            campoNomeNoivo.setBackground(new Color(255, 64, 64));
        }
    }//GEN-LAST:event_campoNomeNoivoKeyReleased

    private void campoNomeNoivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoNomeNoivoMouseClicked
        // TODO add your handling code here:
        campoNomeNoivo.setBackground(new Color(102, 205, 170));
    }//GEN-LAST:event_campoNomeNoivoMouseClicked

    private void campoNomeNoivaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoNomeNoivaMouseClicked
        // TODO add your handling code here:
        campoNomeNoiva.setBackground(new Color(102, 205, 170));
    }//GEN-LAST:event_campoNomeNoivaMouseClicked

    private void campoNomeNoivaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNomeNoivaKeyReleased
        // TODO add your handling code here:
        campoNomeNoiva.setBackground(Color.WHITE);

        if (campoNomeNoiva.getText().isEmpty()) {
            campoNomeNoiva.setBackground(new Color(255, 64, 64));
        }
    }//GEN-LAST:event_campoNomeNoivaKeyReleased

    private void campoIdentidadeNoivaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoIdentidadeNoivaMouseClicked
        // TODO add your handling code here:
        campoIdentidadeNoiva.setBackground(new Color(102, 205, 170));
    }//GEN-LAST:event_campoIdentidadeNoivaMouseClicked

    private void campoIdentidadeNoivaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoIdentidadeNoivaKeyReleased
        // TODO add your handling code here:
        campoIdentidadeNoiva.setBackground(Color.WHITE);

        if (campoIdentidadeNoiva.getText().isEmpty()) {
            campoIdentidadeNoiva.setBackground(new Color(255, 64, 64));
        }
    }//GEN-LAST:event_campoIdentidadeNoivaKeyReleased

    private void campoOrgaoExpNoivaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoOrgaoExpNoivaMouseClicked
        // TODO add your handling code here:
        campoOrgaoExpNoiva.setBackground(new Color(102, 205, 170));
    }//GEN-LAST:event_campoOrgaoExpNoivaMouseClicked

    private void campoOrgaoExpNoivaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoOrgaoExpNoivaKeyReleased
        // TODO add your handling code here:
        campoOrgaoExpNoiva.setBackground(Color.WHITE);

        if (campoOrgaoExpNoiva.getText().isEmpty()) {
            campoOrgaoExpNoiva.setBackground(new Color(255, 64, 64));
        }
    }//GEN-LAST:event_campoOrgaoExpNoivaKeyReleased

    private void campoResidNoivaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoResidNoivaMouseClicked
        // TODO add your handling code here:
        campoResidNoiva.setBackground(new Color(102, 205, 170));
    }//GEN-LAST:event_campoResidNoivaMouseClicked

    private void campoResidNoivaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoResidNoivaKeyReleased
        // TODO add your handling code here:
        campoResidNoiva.setBackground(Color.WHITE);

        if (campoResidNoiva.getText().isEmpty()) {
            campoResidNoiva.setBackground(new Color(255, 64, 64));
        }
    }//GEN-LAST:event_campoResidNoivaKeyReleased

    private void campoCidadResidNoivaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoCidadResidNoivaMouseClicked
        // TODO add your handling code here:
        campoCidadResidNoiva.setBackground(new Color(102, 205, 170));
    }//GEN-LAST:event_campoCidadResidNoivaMouseClicked

    private void campoCidadResidNoivaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCidadResidNoivaKeyReleased
        // TODO add your handling code here:
        campoCidadResidNoiva.setBackground(Color.WHITE);

        if (campoCidadResidNoiva.getText().isEmpty()) {
            campoCidadResidNoiva.setBackground(new Color(255, 64, 64));
        }
    }//GEN-LAST:event_campoCidadResidNoivaKeyReleased

    private void campoPaiNoivaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoPaiNoivaMouseClicked
        // TODO add your handling code here:
        campoPaiNoiva.setBackground(new Color(102, 205, 170));
    }//GEN-LAST:event_campoPaiNoivaMouseClicked

    private void campoPaiNoivaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPaiNoivaKeyReleased
        // TODO add your handling code here:
        campoPaiNoiva.setBackground(Color.WHITE);

        if (campoPaiNoiva.getText().isEmpty()) {
            campoPaiNoiva.setBackground(new Color(255, 64, 64));
        }
    }//GEN-LAST:event_campoPaiNoivaKeyReleased

    private void campoMaeNoivaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoMaeNoivaMouseClicked
        // TODO add your handling code here:
        campoMaeNoiva.setBackground(new Color(102, 205, 170));
    }//GEN-LAST:event_campoMaeNoivaMouseClicked

    private void campoMaeNoivaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoMaeNoivaKeyReleased
        // TODO add your handling code here:
        campoMaeNoiva.setBackground(Color.WHITE);

        if (campoMaeNoiva.getText().isEmpty()) {
            campoMaeNoiva.setBackground(new Color(255, 64, 64));
        }
    }//GEN-LAST:event_campoMaeNoivaKeyReleased

    private void checkPaiNaoDeclNoivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkPaiNaoDeclNoivaActionPerformed
        // TODO add your handling code here:
        if (checkPaiNaoDeclNoiva.isSelected()) {
            campoPaiNoiva.setText("Não declarado");
        } else {
            campoPaiNoiva.setText("");
        }
    }//GEN-LAST:event_checkPaiNaoDeclNoivaActionPerformed

    private void campoProfNoivaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoProfNoivaMouseClicked
        // TODO add your handling code here:
        campoProfNoiva.setBackground(new Color(102, 205, 170));
    }//GEN-LAST:event_campoProfNoivaMouseClicked

    private void campoProfNoivaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoProfNoivaKeyReleased
        // TODO add your handling code here:
        campoProfNoiva.setBackground(Color.WHITE);

        if (campoProfNoiva.getText().isEmpty()) {
            campoProfNoiva.setBackground(new Color(255, 64, 64));
        }
    }//GEN-LAST:event_campoProfNoivaKeyReleased

    private void campoCpfNoivaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoCpfNoivaMouseClicked
        // TODO add your handling code here:
        campoCpfNoiva.setBackground(new Color(102, 205, 170));
    }//GEN-LAST:event_campoCpfNoivaMouseClicked

    private void campoCpfNoivaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCpfNoivaKeyReleased
        // TODO add your handling code here:
        campoCpfNoiva.setBackground(Color.WHITE);

        if (campoCpfNoiva.getText().isEmpty()) {
            campoCpfNoiva.setBackground(new Color(255, 64, 64));
        }
    }//GEN-LAST:event_campoCpfNoivaKeyReleased

    private void campoNascNoivaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoNascNoivaMouseClicked
        // TODO add your handling code here:
        campoNascNoiva.setBackground(new Color(102, 205, 170));
    }//GEN-LAST:event_campoNascNoivaMouseClicked

    private void campoNascNoivaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNascNoivaKeyReleased
        // TODO add your handling code here:
        campoNascNoiva.setBackground(Color.WHITE);

        if (campoNascNoiva.getText().isEmpty()) {
            campoNascNoiva.setBackground(new Color(255, 64, 64));
        }
    }//GEN-LAST:event_campoNascNoivaKeyReleased

    private void campoCidadNascNoivaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoCidadNascNoivaMouseClicked
        // TODO add your handling code here:
        campoCidadNascNoiva.setBackground(new Color(102, 205, 170));
    }//GEN-LAST:event_campoCidadNascNoivaMouseClicked

    private void campoCidadNascNoivaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCidadNascNoivaKeyReleased
        // TODO add your handling code here:
        campoCidadNascNoiva.setBackground(Color.WHITE);

        if (campoCidadNascNoiva.getText().isEmpty()) {
            campoCidadNascNoiva.setBackground(new Color(255, 64, 64));
        }
    }//GEN-LAST:event_campoCidadNascNoivaKeyReleased

    private void btnConfNoivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfNoivaActionPerformed

        if (id_certidao_noiva != 0) {

            Enderecos_Model endereco = new Enderecos_Model();
            Pessoas_Model gNoiva = new Pessoas_Model();
            Pessoas_Controller inserir_Pessoa = new Pessoas_Controller();

            if (id_endereco_noiva != 0) {
                // capturando as informações da NOIVA
                gNoiva.setNome(campoNomeNoiva.getText());
                gNoiva.setCpf(campoCpfNoiva.getText());
                gNoiva.setSexo(comboSexoNoiva.getSelectedItem().toString());
                gNoiva.setDocIdentidade(campoIdentidadeNoiva.getText());
                gNoiva.setOrgaoExpeditor(campoOrgaoExpNoiva.getText());
                gNoiva.setDataExpedicao(campoDataExpedicaoNoiva.getText());
                gNoiva.setNacionalidade(comboNacionNoiva.getSelectedItem().toString());
                gNoiva.setEst_civil(comboEstCivilNoiva.getSelectedItem().toString());
                gNoiva.setNascimento(campoNascNoiva.getText());
                gNoiva.setCidade_nasc(campoCidadNascNoiva.getText());
                gNoiva.setEstado_nasc(comboEstaNascNoiva.getSelectedItem().toString());
                gNoiva.setPai(campoPaiNoiva.getText());
                gNoiva.setMae(campoMaeNoiva.getText());
                gNoiva.setProfissao(campoProfNoiva.getText());

                this.id_noiva = inserir_Pessoa.Inserir_Novo_Cadastro_Pessoa(gNoiva, id_endereco_noiva, id_certidao_noiva);

                // verificando se retornou o ID da noiva, assim preenchemos o ultimo formulario
                if (this.id_noiva != 0) {

                    // chamando metodo que ira preencher o ultimo formulario da guia PROCESSO
                    preencherPessoasVinculadas();

                    // Desativamos o botao que confirma a inclusao, pois não precisaremos 
                    btnSalvarAtualNoiva.setEnabled(false);
                    btnBuscarNoiva.setEnabled(false);
                    btnConfNoiva.setEnabled(false);
                    btnInserirCertidao_Noiva.setEnabled(false);
                } else {

                    // Desativamos o botao que confirma a inclusao, pois não precisaremos 
                    btnSalvarAtualNoiva.setEnabled(false);
                    btnBuscarNoiva.setEnabled(false);
                    btnConfNoiva.setEnabled(false);
                    btnInserirCertidao_Noiva.setEnabled(false);
                }

            } else {
                // capturando as informações da NOIVA
                gNoiva.setNome(campoNomeNoiva.getText());
                gNoiva.setCpf(campoCpfNoiva.getText());
                gNoiva.setSexo(comboSexoNoiva.getSelectedItem().toString());
                gNoiva.setDocIdentidade(campoIdentidadeNoiva.getText());
                gNoiva.setOrgaoExpeditor(campoOrgaoExpNoiva.getText());
                gNoiva.setDataExpedicao(campoDataExpedicaoNoiva.getText());
                gNoiva.setNacionalidade(comboNacionNoiva.getSelectedItem().toString());
                gNoiva.setEst_civil(comboEstCivilNoiva.getSelectedItem().toString());
                gNoiva.setNascimento(campoNascNoiva.getText());
                gNoiva.setCidade_nasc(campoCidadNascNoiva.getText());
                gNoiva.setEstado_nasc(comboEstaNascNoiva.getSelectedItem().toString());
                gNoiva.setPai(campoPaiNoiva.getText());
                gNoiva.setMae(campoMaeNoiva.getText());
                gNoiva.setProfissao(campoProfNoiva.getText());

                endereco.setNome_rua(campoResidNoiva.getText());
                endereco.setCidade_residencia(campoCidadResidNoiva.getText());
                endereco.setEstado_residencia(comboEstResidNoiva.getSelectedItem().toString());
                endereco.setBairro(campoBairroNoiva.getText());
                endereco.setComplemento(campoComplementoNoiva.getText());

                Enderecos_Controller Novo_end = new Enderecos_Controller();
                this.id_endereco_noiva = Novo_end.inserir_Novo_Endereco(endereco);

                // se o endereço foi devidament inserido, fazemos a gravação da pessoa na tabela pessoas
                // caso contrario nao inserimos a pessoa
                if (id_endereco_noiva != 0) {
                    // chamando metodo que insere  um novo cadastro de pessoa
                    // capturando de retorno o ID da pessoa
                    this.id_noiva = inserir_Pessoa.Inserir_Novo_Cadastro_Pessoa(gNoiva, id_endereco_noiva, id_certidao_noiva);

                    // verificamos se a gravação ocorreu, e retornou o ID do usuario
                    if (this.id_noiva != 0) {

                        // chamando metodo que ira preencher o ultimo formulario da guia PROCESSO
                        preencherPessoasVinculadas();

                        // Desativamos o botao que confirma a inclusao, pois não precisaremos 
                        btnConfNoiva.setEnabled(false);
                        btnSalvarAtualNoiva.setEnabled(false);
                        btnBuscarNoiva.setEnabled(false);
                        btnInserirCertidao_Noiva.setEnabled(false);
                    } else {

                        // caso nao retorno o ID da pessoa, deixamo os botoes ativados
                        btnConfNoiva.setEnabled(true);
                        btnSalvarAtualNoiva.setEnabled(false);
                        btnBuscarNoiva.setEnabled(true);
                        btnInserirCertidao_Noiva.setEnabled(true);

                    }
                }
            }
        } else {

            // caso o usuario nao vincule uma certidao ao processo desativamos o botao inserir e exibimos a MENSAGEM na tela
            btnConfNoiva.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Atenção: para a inserção de pessoa ao processo de casamento,\ndeverá ser vinculada uma Certidao", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            btnInserirCertidao_Noiva.requestFocus();

        }

    }//GEN-LAST:event_btnConfNoivaActionPerformed

    private void btnBuscarNoivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarNoivaActionPerformed
        // chamando tela de dialogo localizar contraentes
        Localizar_Pessoas_View buscar = new Localizar_Pessoas_View(this, true, 2);
        buscar.setVisible(true);

        if (buscar.id_selecionado == null) {
            JOptionPane.showMessageDialog(this, "Nenhuma noiva foi selecionado", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else {

            btnSalvarAtualNoiva.setEnabled(true);
            btnConfNoiva.setEnabled(false);

            // alterando o valor do atributo do id_noiva
            this.id_noiva = Integer.parseInt(buscar.id_selecionado);
            String id = String.valueOf(id_noiva);

            // preenchendo o formulario da noiva, para possiel alterações de informações
            preencherFormularioContraentes(id, "noiva");

        }
    }//GEN-LAST:event_btnBuscarNoivaActionPerformed

    private void btnSalvarAtualNoivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarAtualNoivaActionPerformed

        Pessoas_Model gNoiva = new Pessoas_Model();
        Pessoas_Controller Atualizar_Dados_Pessoa = new Pessoas_Controller();

        // capturando as informações da NOIVA
        gNoiva.setNome(campoNomeNoiva.getText());
        gNoiva.setCpf(campoCpfNoiva.getText());
        gNoiva.setSexo(comboSexoNoiva.getSelectedItem().toString());
        gNoiva.setDocIdentidade(campoIdentidadeNoiva.getText());
        gNoiva.setOrgaoExpeditor(campoOrgaoExpNoiva.getText());
        gNoiva.setDataExpedicao(campoDataExpedicaoNoiva.getText());
        gNoiva.setNacionalidade(comboNacionNoiva.getSelectedItem().toString());
        gNoiva.setEst_civil(comboEstCivilNoiva.getSelectedItem().toString());
        gNoiva.setNascimento(campoNascNoiva.getText());
        gNoiva.setCidade_nasc(campoCidadNascNoiva.getText());
        gNoiva.setEstado_nasc(comboEstaNascNoiva.getSelectedItem().toString());
        gNoiva.setPai(campoPaiNoiva.getText());
        gNoiva.setMae(campoMaeNoiva.getText());
        gNoiva.setProfissao(campoProfNoiva.getText());

        Atualizar_Dados_Pessoa.salvarAlteracao(gNoiva, id_noiva);
    }//GEN-LAST:event_btnSalvarAtualNoivaActionPerformed

    private void campoIdentTest1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoIdentTest1MouseClicked
        // TODO add your handling code here:
        campoIdentTest1.setBackground(new Color(102, 205, 170));
    }//GEN-LAST:event_campoIdentTest1MouseClicked

    private void campoIdentTest1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoIdentTest1KeyReleased
        // TODO add your handling code here:
        campoIdentTest1.setBackground(Color.WHITE);

        if (campoIdentTest1.getText().isEmpty()) {
            campoIdentTest1.setBackground(new Color(255, 64, 64));
        }
    }//GEN-LAST:event_campoIdentTest1KeyReleased

    private void campoOrgaoExpTest1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoOrgaoExpTest1MouseClicked
        // TODO add your handling code here:
        campoOrgaoExpTest1.setBackground(new Color(102, 205, 170));
    }//GEN-LAST:event_campoOrgaoExpTest1MouseClicked

    private void campoOrgaoExpTest1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoOrgaoExpTest1KeyReleased
        // TODO add your handling code here:
        campoOrgaoExpTest1.setBackground(Color.WHITE);
        if (campoOrgaoExpTest1.getText().isEmpty()) {
            campoOrgaoExpTest1.setBackground(new Color(255, 64, 64));
        }
    }//GEN-LAST:event_campoOrgaoExpTest1KeyReleased

    private void campoResidTest1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoResidTest1MouseClicked
        // TODO add your handling code here:
        campoResidTest1.setBackground(new Color(102, 205, 170));
    }//GEN-LAST:event_campoResidTest1MouseClicked

    private void campoResidTest1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoResidTest1KeyReleased
        // TODO add your handling code here:
        campoResidTest1.setBackground(Color.WHITE);

        if (campoResidTest1.getText().isEmpty()) {
            campoResidTest1.setBackground(new Color(255, 64, 64));
        }
    }//GEN-LAST:event_campoResidTest1KeyReleased

    private void campoCidadeResidTest1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoCidadeResidTest1MouseClicked
        // TODO add your handling code here:
        campoCidadeResidTest1.setBackground(new Color(102, 205, 170));
    }//GEN-LAST:event_campoCidadeResidTest1MouseClicked

    private void campoCidadeResidTest1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCidadeResidTest1KeyReleased
        // TODO add your handling code here:
        campoCidadeResidTest1.setBackground(Color.WHITE);

        if (campoCidadeResidTest1.getText().isEmpty()) {
            campoCidadeResidTest1.setBackground(new Color(255, 64, 64));
        }
    }//GEN-LAST:event_campoCidadeResidTest1KeyReleased

    private void campoNomeTest1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoNomeTest1MouseClicked
        // TODO add your handling code here:
        campoNomeTest1.setBackground(new Color(102, 205, 170));
    }//GEN-LAST:event_campoNomeTest1MouseClicked

    private void campoNomeTest1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNomeTest1KeyReleased
        // TODO add your handling code here:
        campoNomeTest1.setBackground(Color.WHITE);

        if (campoNomeTest1.getText().isEmpty()) {
            campoNomeTest1.setBackground(new Color(255, 64, 64));
        }
    }//GEN-LAST:event_campoNomeTest1KeyReleased

    private void campoProfTest1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoProfTest1MouseClicked
        // TODO add your handling code here:
        campoProfTest1.setBackground(new Color(102, 205, 170));
    }//GEN-LAST:event_campoProfTest1MouseClicked

    private void campoProfTest1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoProfTest1KeyReleased
        // TODO add your handling code here:
        campoProfTest1.setBackground(Color.WHITE);

        if (campoProfTest1.getText().isEmpty()) {
            campoProfTest1.setBackground(new Color(255, 64, 64));
        }
    }//GEN-LAST:event_campoProfTest1KeyReleased

    private void campoCpfTest1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoCpfTest1MouseClicked
        // TODO add your handling code here:
        campoCpfTest1.setBackground(new Color(102, 205, 170));
    }//GEN-LAST:event_campoCpfTest1MouseClicked

    private void campoNascTest1ClickMouse(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoNascTest1ClickMouse
        // TODO add your handling code here:
        campoNascTest1.setBackground(new Color(102, 205, 170));
    }//GEN-LAST:event_campoNascTest1ClickMouse

    private void campoNascTest1KeyRelease(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNascTest1KeyRelease
        // TODO add your handling code here:
        campoNascTest1.setBackground(Color.WHITE);
        if (campoNascTest1.getText().isEmpty()) {
            campoNascTest1.setBackground(new Color(255, 64, 64));
        }
    }//GEN-LAST:event_campoNascTest1KeyRelease

    private void btnSalvarTestm1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarTestm1ActionPerformed
        // instanciando objeto tipo Pessoas_Model
        Pessoas_Model testemunha = new Pessoas_Model();
        Enderecos_Model endereco = new Enderecos_Model();
        Enderecos_Controller Inserir_Novo_Endereco = new Enderecos_Controller();
        Pessoas_Controller Inserir_Pessoa = new Pessoas_Controller();

        if (id_endereco_testemunha != 0) {

            // capturando informações da primeira testemunha
            testemunha.setNome(campoNomeTest1.getText());
            testemunha.setSexo(comboSexo_testemunha.getSelectedItem().toString());
            testemunha.setNacionalidade(comboNacionTest1.getSelectedItem().toString());
            testemunha.setEst_civil(comboEstCivilTest1.getSelectedItem().toString());
            testemunha.setDocIdentidade(campoIdentTest1.getText());
            testemunha.setOrgaoExpeditor(campoOrgaoExpTest1.getText());
            testemunha.setDataExpedicao(campoDataExpedicao_testemunha.getText());
            testemunha.setCpf(campoCpfTest1.getText());
            testemunha.setNascimento(campoNascTest1.getText());
            testemunha.setCidade_nasc(campoCidadNascTestemunha.getText());
            testemunha.setEstado_nasc(comboEstNascTest1.getSelectedItem().toString());
            testemunha.setProfissao(campoProfTest1.getText());
            testemunha.setPai(campoPaiTestemunha.getText());
            testemunha.setMae(campoMaeTestemunha.getText());

            // inserindo os dados da nova pessoa
            int id_Nova_test = Inserir_Pessoa.Inserir_Novo_Cadastro_Pessoa(testemunha, id_endereco_testemunha);

            // verificando se o metodo retornou o ID para testemunha
            if (id_Nova_test != 0) {

                // incluindo no vetor o id da testemunha
                id_testemunhas[contador] = id_Nova_test;
                contador++;

                // chamando metodo que ira preencher o ultimo formulario da guia PROCESSO
                preencherPessoasVinculadas();

                // atribuimos o valor zero ao atributo id_endereco_test para que o proximo testemunha seja verificado 
                // o endereco, caso seja um endereco cadastrado ou um novo lançamento
                id_endereco_testemunha = 0;
                Verificar_Valor_Contador();

            } else {
                campoNomeTest1.requestFocus();
            }

        } else {

//             capturando informações da primeira testemunha
            testemunha.setNome(campoNomeTest1.getText());
            testemunha.setSexo(comboSexo_testemunha.getSelectedItem().toString());
            testemunha.setNacionalidade(comboNacionTest1.getSelectedItem().toString());
            testemunha.setEst_civil(comboEstCivilTest1.getSelectedItem().toString());
            testemunha.setDocIdentidade(campoIdentTest1.getText());
            testemunha.setOrgaoExpeditor(campoOrgaoExpTest1.getText());
            testemunha.setDataExpedicao(campoDataExpedicao_testemunha.getText());
            testemunha.setCpf(campoCpfTest1.getText());
            testemunha.setNascimento(campoNascTest1.getText());
            testemunha.setProfissao(campoProfTest1.getText());
            testemunha.setPai(campoPaiTestemunha.getText());
            testemunha.setMae(campoMaeTestemunha.getText());
            testemunha.setCidade_nasc(campoCidadNascTestemunha.getText());
            testemunha.setEstado_nasc(comboEstCivilTest1.getSelectedItem().toString());

            endereco.setCidade_residencia(campoCidadeResidTest1.getText());
            endereco.setNome_rua(campoResidTest1.getText());
            endereco.setEstado_residencia(comboEstResidTest1.getSelectedItem().toString());
            endereco.setBairro(campoBairroTestemunha.getText());
            endereco.setComplemento(campoComplementoTestemunha.getText());

//             inseridno o endereco do novo usuario
            id_endereco_testemunha = Inserir_Novo_Endereco.inserir_Novo_Endereco(endereco);

            // verificamos se o endereço foi salvo corretamente
            if (id_endereco_testemunha != 0) {
                // inserindo os dados da nova pessoa
                int id_nova_test = Inserir_Pessoa.Inserir_Novo_Cadastro_Pessoa(testemunha, id_endereco_testemunha);

                // verifcamos se os dados da nova testemunha foram salvos
                if (id_nova_test != 0) {

                    // incluindo no vetor o id da testemunha
                    id_testemunhas[contador] = id_nova_test;

                    // chamando metodo que ira preencher o ultimo formulario da guia PROCESSO
                    preencherPessoasVinculadas();

                    // verificamos o valor do contador, utilizado para indicar a posicao do vetor
                    Verificar_Valor_Contador();
                } else {
                    campoNomeTest1.requestFocus();
                }

            } else {
                campoCidadeResidTest1.requestFocus();
            }
        }
    }//GEN-LAST:event_btnSalvarTestm1ActionPerformed

    private void btnBuscarTest1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarTest1ActionPerformed

        // chamando a tela de busca_Pessoas
        // o parametro busca, sera utilizado na View para verificar em qual tabela sera feito a busca
        Localizar_Pessoas_View bscr = new Localizar_Pessoas_View(this, true, 1);
        bscr.setVisible(true);

        if (bscr.id_selecionado == null) {
            // mensg ao usuario
            JOptionPane.showMessageDialog(this, "Nenhuma testemunha foi selecionado", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // desativando e ativando botoes
            btnSalvarTestm1.setEnabled(false);
            btnAtualizaçãoTest1.setEnabled(true);
            btnConfirmarTestemunha.setEnabled(true);

            // capturando o ID
            id_test = Integer.parseInt(bscr.id_selecionado);

            // preenchendo formulario
            preencher_campos_testemunha(bscr.id_selecionado);
        }
    }//GEN-LAST:event_btnBuscarTest1ActionPerformed

    private void btnAtualizaçãoTest1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizaçãoTest1ActionPerformed
        //exibe msge ao usuario para confirmar atualização
        int opt = JOptionPane.showConfirmDialog(this, "Confirma a atualização desta testemunha?", "Confirmação", JOptionPane.YES_NO_OPTION);

        // verifica a resposta do usuario
        if (opt == 0) {

            // instanciando objeto tipo PEssoas_Model
            Pessoas_Model Test1 = new Pessoas_Model();

            // capturando informações da primeira testemunha
            Test1.setId(Integer.parseInt(campoIdentificadorTest1.getText()));
            Test1.setNome(campoNomeTest1.getText());
            Test1.setNacionalidade(comboNacionTest1.getSelectedItem().toString());
            Test1.setEst_civil(comboEstCivilTest1.getSelectedItem().toString());
            Test1.setDocIdentidade(campoIdentTest1.getText());
            Test1.setOrgaoExpeditor(campoOrgaoExpTest1.getText());
            Test1.setCpf(campoCpfTest1.getText());
            Test1.setNascimento(campoNascTest1.getText());
            Test1.setProfissao(campoProfTest1.getText());
            Test1.setCidade(campoCidadeResidTest1.getText());
            Test1.setEndereco(campoResidTest1.getText());
            Test1.setEstado(comboEstResidTest1.getSelectedItem().toString());

        } else {

            btnBuscarTest1.requestFocus();
        }
    }//GEN-LAST:event_btnAtualizaçãoTest1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void campoEditalProcessoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoEditalProcessoMouseClicked
        // TODO add your handling code here:
        campoEditalProcesso.setBackground(new Color(102, 205, 170));
    }//GEN-LAST:event_campoEditalProcessoMouseClicked

    private void campoNumeroProcessoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoNumeroProcessoMouseClicked
        // TODO add your handling code here:
        campoNumeroProcesso.setBackground(new Color(102, 205, 170));
    }//GEN-LAST:event_campoNumeroProcessoMouseClicked

    private void campoVinculoTestemunha2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoVinculoTestemunha2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoVinculoTestemunha2ActionPerformed

    private void campoPaiTestemunhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoPaiTestemunhaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_campoPaiTestemunhaMouseClicked

    private void campoPaiTestemunhaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPaiTestemunhaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_campoPaiTestemunhaKeyReleased

    private void campoMaeTestemunhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoMaeTestemunhaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_campoMaeTestemunhaMouseClicked

    private void campoMaeTestemunhaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoMaeTestemunhaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_campoMaeTestemunhaKeyReleased

    private void checkPaiNaoDeclaradoTestemunhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkPaiNaoDeclaradoTestemunhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkPaiNaoDeclaradoTestemunhaActionPerformed

    private void campoCidadNascTestemunhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoCidadNascTestemunhaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_campoCidadNascTestemunhaMouseClicked

    private void campoCidadNascTestemunhaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCidadNascTestemunhaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_campoCidadNascTestemunhaKeyReleased

    private void btnInserirCertidao_NoivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirCertidao_NoivoActionPerformed
        // formulario que cadastra uma certidao
        Cadastrar_Certidao_View certidao = new Cadastrar_Certidao_View(this, true);
        certidao.setVisible(true);

        // apos a gravação, verificamos se o atributo esta com o valor do id
        if (certidao.id_certidao != 0) {
            // definomos como id_certidao do NOIVO
            this.id_certidao_noivo = certidao.id_certidao;
            btnConfNoivo.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma certidao foi inserida", "Mensagem", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnInserirCertidao_NoivoActionPerformed

    private void btnInserirCertidao_NoivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirCertidao_NoivaActionPerformed
        // formulario que cadastra uma certidao
        Cadastrar_Certidao_View certidao = new Cadastrar_Certidao_View(this, true);
        certidao.setVisible(true);

        // apos a gravação, verificamos se o atributo esta com o valor do id
        if (certidao.id_certidao != 0) {
            // definomos como id_certidao do NOIVO
            this.id_certidao_noiva = certidao.id_certidao;
            btnConfNoiva.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma certidao foi inserida", "Mensagem", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnInserirCertidao_NoivaActionPerformed

    private void btnConfirmarTestemunhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarTestemunhaActionPerformed
        // este botao irao ativar a opção salvar testemunha, assim poderemos inserir tanto um novo cadastro de pessoa
        // como também localizar uma nova pessoa
        btnSalvarTestm1.setEnabled(true);

        // inserir ID no vetor de testemunhas
        id_testemunhas[contador] = id_test;
        contador++;

        // verificamos o valor do contador, q indica a quantidade de posições no vetor
        Verificar_Valor_Contador();

        // chamando metodo que ira preencher o ultimo formulario da guia PROCESSO
        preencherPessoasVinculadas();

        // verificando se todos os IDs estão preenchidos para salvar o processo
        Ativar_Botao_Salvar_Processo();

        // Desativa este botao
        btnConfirmarTestemunha.setEnabled(false);
    }//GEN-LAST:event_btnConfirmarTestemunhaActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // definindo a data no campo DATA DO PROCESSO
        LocalDate data = LocalDate.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // preenchendo campo data
        campoDataProcesso.setText(format.format(data));
    }//GEN-LAST:event_formWindowOpened

    private void btnSalvarProcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarProcessoActionPerformed

        int processo = Integer.parseInt(campoNumeroProcesso.getText());
        int edital = Integer.parseInt(campoEditalProcesso.getText());

        // objeto controller
        Casamento_Controller Salvar_Novo_Processo = new Casamento_Controller();
        boolean retorno = Salvar_Novo_Processo.salvarProcesso(processo, edital, id_noivo, id_noiva, id_testemunhas);
        
        if(retorno == true){
            btnSalvarProcesso.setEnabled(false);
            campoNumeroProcesso.setEnabled(false);
            campoEditalProcesso.setEnabled(false);
        } else {
            
        }
    }//GEN-LAST:event_btnSalvarProcessoActionPerformed

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
            java.util.logging.Logger.getLogger(Casamento_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Casamento_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Casamento_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Casamento_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Casamento_View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizaçãoTest1;
    private javax.swing.JButton btnBuscarNoiva;
    private javax.swing.JButton btnBuscarNoivo;
    private javax.swing.JButton btnBuscarTest1;
    private javax.swing.JButton btnConfNoiva;
    private javax.swing.JButton btnConfNoivo;
    private javax.swing.JButton btnConfirmarTestemunha;
    private javax.swing.JButton btnInserirCertidao_Noiva;
    private javax.swing.JButton btnInserirCertidao_Noivo;
    private javax.swing.JButton btnSalvarAtualNoiva;
    private javax.swing.JButton btnSalvarAtualNoivo;
    private javax.swing.JButton btnSalvarProcesso;
    private javax.swing.JButton btnSalvarTestm1;
    private javax.swing.JTextField campoBairroNoiva;
    private javax.swing.JTextField campoBairroNoivo;
    private javax.swing.JTextField campoBairroTestemunha;
    private javax.swing.JTextField campoCidaResidNoivo;
    private javax.swing.JTextField campoCidadNascNoiva;
    private javax.swing.JTextField campoCidadNascNoivo;
    private javax.swing.JTextField campoCidadNascTestemunha;
    private javax.swing.JTextField campoCidadResidNoiva;
    private javax.swing.JTextField campoCidadeResidTest1;
    private javax.swing.JTextField campoComplementoNoiva;
    private javax.swing.JTextField campoComplementoNoivo;
    private javax.swing.JTextField campoComplementoTestemunha;
    private javax.swing.JFormattedTextField campoCpfNoiva;
    private javax.swing.JFormattedTextField campoCpfNoivo;
    private javax.swing.JFormattedTextField campoCpfTest1;
    private javax.swing.JFormattedTextField campoDataExpedicaoNoiva;
    private javax.swing.JFormattedTextField campoDataExpedicaoNoivo;
    private javax.swing.JFormattedTextField campoDataExpedicao_testemunha;
    private javax.swing.JTextField campoDataProcesso;
    private javax.swing.JTextField campoEditalProcesso;
    private javax.swing.JTextField campoIdentNoivo;
    private javax.swing.JTextField campoIdentTest1;
    private javax.swing.JTextField campoIdentidadeNoiva;
    private javax.swing.JTextField campoIdentificadorNoiva;
    private javax.swing.JTextField campoIdentificadorNoivo;
    private javax.swing.JTextField campoIdentificadorTest1;
    private javax.swing.JTextField campoMaeNoiva;
    private javax.swing.JTextField campoMaeNoivo;
    private javax.swing.JTextField campoMaeTestemunha;
    private javax.swing.JFormattedTextField campoNascNoiva;
    private javax.swing.JFormattedTextField campoNascNoivo;
    private javax.swing.JFormattedTextField campoNascTest1;
    private javax.swing.JTextField campoNomeNoiva;
    private javax.swing.JTextField campoNomeNoivo;
    private javax.swing.JTextField campoNomeTest1;
    private javax.swing.JTextField campoNumeroProcesso;
    private javax.swing.JTextField campoOrgaoExpNoiva;
    private javax.swing.JTextField campoOrgaoExpNoivo;
    private javax.swing.JTextField campoOrgaoExpTest1;
    private javax.swing.JTextField campoPaiNoiva;
    private javax.swing.JTextField campoPaiNoivo;
    private javax.swing.JTextField campoPaiTestemunha;
    private javax.swing.JTextField campoProfNoiva;
    private javax.swing.JTextField campoProfNoivo;
    private javax.swing.JTextField campoProfTest1;
    private javax.swing.JTextField campoResidNoiva;
    private javax.swing.JTextField campoResidNoivo;
    private javax.swing.JTextField campoResidTest1;
    private javax.swing.JTextField campoVinculoContraente1;
    private javax.swing.JTextField campoVinculoContraente2;
    private javax.swing.JTextField campoVinculoTestemunha1;
    private javax.swing.JTextField campoVinculoTestemunha2;
    private javax.swing.JCheckBox checkPaiNaoDeclNoiva;
    private javax.swing.JCheckBox checkPaiNaoDeclNoivo;
    private javax.swing.JCheckBox checkPaiNaoDeclaradoTestemunha;
    private javax.swing.JComboBox comboEstCivilNoiva;
    private javax.swing.JComboBox comboEstCivilNoivo;
    private javax.swing.JComboBox comboEstCivilTest1;
    private javax.swing.JComboBox<String> comboEstNascNoivo;
    private javax.swing.JComboBox<String> comboEstNascTest1;
    private javax.swing.JComboBox comboEstResidNoiva;
    private javax.swing.JComboBox comboEstResidNoivo;
    private javax.swing.JComboBox comboEstResidTest1;
    private javax.swing.JComboBox<String> comboEstaNascNoiva;
    private javax.swing.JComboBox comboNacioNoivo;
    private javax.swing.JComboBox comboNacionNoiva;
    private javax.swing.JComboBox comboNacionTest1;
    private javax.swing.JComboBox<String> comboSexoNoiva;
    private javax.swing.JComboBox<String> comboSexoNoivo;
    private javax.swing.JComboBox<String> comboSexo_testemunha;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
