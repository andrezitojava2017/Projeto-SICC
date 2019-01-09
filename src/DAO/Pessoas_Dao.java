/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConexaoBD.ConexaoDB;
import Model.Pessoas_Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author Andre
 */
public class Pessoas_Dao {

    Connection con;
    PreparedStatement stm;
    ResultSet rs;

    /**
     * Metodo responsavel em inserir os dados de uma pessoa, quando essa pessoa
     * nao apresenta uma Certidao_Model como document
     *
     * @param pessoa
     * @param id_endereco int
     * @return
     *
     */
    public int gravarDadosPessoas(Pessoas_Model pessoa, int id_endereco) {

        // id de retorno com o id referente ao pai
        int id_pessoa = 0;

        try {
            String sql = "insert into cadastro.tblpessoas(nome_pessoa, sexo, doc_identidade, data_expedicao, orgao_expeditor, cpf, estado_civil, nacionalidade, profissao, data_nascimento, cidade_nascimento, estado_nascimento, id_endereco, nome_pai, nome_mae) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);

            // criando objeto que ira formatar a data, indicamos como esta vindo o padrao da data
            DateTimeFormatter formt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            // convertendo string em Data padrao: yyyy-MM-dd
            LocalDate Nasc_pai = LocalDate.parse(pessoa.getNascimento(), formt);
            LocalDate exp_ident_pai = LocalDate.parse(pessoa.getDataExpedicao(), formt);
            //aqui convertemos de Date para String, e dpois fazemos a gravação na base de dados
            String dat = String.valueOf(Nasc_pai);
            String exp_ident = String.valueOf(exp_ident_pai);

            stm.setString(1, pessoa.getNome());
            stm.setString(2, pessoa.getSexo());
            stm.setString(3, pessoa.getDocIdentidade());
            stm.setString(4, exp_ident);
            stm.setString(5, pessoa.getOrgaoExpeditor());
            stm.setString(6, pessoa.getCpf());
            stm.setString(7, pessoa.getEst_civil());
            stm.setString(8, pessoa.getNacionalidade());
            stm.setString(9, pessoa.getProfissao());
            stm.setString(10, dat);
            stm.setString(11, pessoa.getCidade_nasc());
            stm.setString(12, pessoa.getEstado_nasc());
            stm.setInt(13, id_endereco);
            stm.setString(14, pessoa.getPai());
            stm.setString(15, pessoa.getMae());

            int retorno = stm.executeUpdate();

            if (retorno != 0) {
                // capturando o ID do pai inserido
                id_pessoa = lerIdPessoa();

                // mensagem de confirmação
                JOptionPane.showMessageDialog(null, "Informações foram inseridos com sucesso", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro de gravação\n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);

        } finally {
            ConexaoBD.ConexaoDB.fecharConexao(con, stm);
        }

        return id_pessoa;
    }

    /**
     * Metodo responsavel em inserir os dados de uma pessoa, quando o mesmo
     * apresenta uma certidao como documento
     *
     * @param pessoa
     * @param id_endereco int
     * @param id_certidao int
     * @return id_pai - int com o valor do ID do pai
     */
    public int gravarDadosPessoas(Pessoas_Model pessoa, int id_endereco, int id_certidao) {

        // id de retorno com o id referente ao pai
        int id_pessoa = 0;

        try {
            String sql = "insert into cadastro.tblpessoas(nome_pessoa, sexo, doc_identidade, data_expedicao, orgao_expeditor, cpf, estado_civil, nacionalidade, profissao, data_nascimento, cidade_nascimento, estado_nascimento, id_endereco, id_certidao, nome_pai, nome_mae) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);

            // criando objeto que ira formatar a data, indicamos como esta vindo o padrao da data
            DateTimeFormatter formt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            // convertendo string em Data padrao: yyyy-MM-dd
            LocalDate dataFormat = LocalDate.parse(pessoa.getNascimento(), formt);
            LocalDate exp_ident_pai = LocalDate.parse(pessoa.getDataExpedicao(), formt);

            //aqui convertemos de Date para String, e dpois fazemos a gravação na base de dados
            String dat = String.valueOf(dataFormat);
            String exp_ident = String.valueOf(exp_ident_pai);

            stm.setString(1, pessoa.getNome());
            stm.setString(2, pessoa.getSexo());
            stm.setString(3, pessoa.getDocIdentidade());
            stm.setString(4, exp_ident);
            stm.setString(5, pessoa.getOrgaoExpeditor());
            stm.setString(6, pessoa.getCpf());
            stm.setString(7, pessoa.getEst_civil());
            stm.setString(8, pessoa.getNacionalidade());
            stm.setString(9, pessoa.getProfissao());
            stm.setString(10, dat);
            stm.setString(11, pessoa.getCidade_nasc());
            stm.setString(12, pessoa.getEstado_nasc());
            stm.setInt(13, id_endereco);
            stm.setInt(14, id_certidao);
            stm.setString(15, pessoa.getPai());
            stm.setString(16, pessoa.getMae());

            int retorno = stm.executeUpdate();

            if (retorno != 0) {
                // capturando o ID do pai inserido
                id_pessoa = lerIdPessoa();

                // mensagem de confirmação
                JOptionPane.showMessageDialog(null, "Informações foram inseridas com sucesso", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro de gravação na tabela pessoas\n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);

        } finally {
            ConexaoBD.ConexaoDB.fecharConexao(con, stm);
        }

        return id_pessoa;
    }

    /**
     * Metodo responsavel em ler o maior ID da tabela pessoas
     *
     * @return int selo com o valor do maior ID
     */
    public int lerIdPessoa() {
        int id_pessoa = 0;

        try {
            // sql lÊ o maior valor da coluna ID da tabela pessoa.
            String sql = "select max(id) from cadastro.tblpessoas";

            con = ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                id_pessoa = rs.getInt(1);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na leitura da tabela Pessoas\n" + ex, "Atenção verifique", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConexaoDB.fecharConexao(con, stm, rs);
        }

        return id_pessoa;
    }
//
//    /**
//     * METODO PUBLICO PARA LER OS DADOS REFENTE AO CADASTRO DE PESSOAS
//     *
//     * @param like
//     * @return uma Lista do tipo Pessoas, que sera lido pelo metodo creat() da
//     * classe FormConsultaPessoa
//     */
//    public List<Pessoas_Model> pesquisarPessoa(String like) {
//
//        //String que possui o comando para ler as colunas nome, documento de
//        //identedade cpf e ficha.
//        String condicao = like;
//        String sql = "select * from cadastro.tblpessoas where nome like '" + condicao + "%'";
//
////         Lista do tipo CadPessoa, formada por um arrayList, que ira armazenar
////         os dados recuperados do BD.         
//        List<Pessoas_Model> Cadastro = new ArrayList<>();
//
//        try {
//
//            // conexao
//            con = ConexaoDB.getconection();
//            stm = con.prepareStatement(sql);
//            rs = stm.executeQuery();
//
//            //laço While que, enquanto houver dados no rs, ele recupera as
//            //informações do rs, e atribui aos atibutos da classe Pessoas_Model().
//            while (rs.next()) {
//                Pessoas_Model pessoa = new Pessoas_Model();
//
//                pessoa.setId(rs.getInt("id"));
//                pessoa.setNome(rs.getString("nome"));
//                pessoa.setDocIdentidade(rs.getString("doc_identidade"));
//                pessoa.setDataExpedicao(rs.getString("data_expedicao"));
//                pessoa.setOrgaoExpeditor(rs.getString("orgao_expeditor"));
//                pessoa.setCpf(rs.getString("cpf"));
//                pessoa.setNacionalidade(rs.getString("nacionalidade"));
//                pessoa.setNascimento(rs.getString("nascimento"));
//                pessoa.setPai(rs.getString("pai"));
//                pessoa.setMae(rs.getString("mae"));
//                pessoa.setEndereco(rs.getString("endereco"));
//                pessoa.setBairro(rs.getString("bairro"));
//                pessoa.setComplemento(rs.getString("complemento"));
//                pessoa.setCidade(rs.getString("cidade"));
//                pessoa.setEstado(rs.getString("estado"));
//
//                //aqui add a lista Cadastro o objeto do tipo CadPessoa, que
//                // devera ser lido na classe FormConsultaPessoa.                 
//                Cadastro.add(pessoa);
//
//            }
//
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Ocorreu algum erro na leitura da tblPessoas" + ex);
//        } finally {
//            ConexaoDB.fecharConexao(con, stm, rs);
//        }
//
//        return Cadastro; // retorno a classe com a lista de dados que foi lida.
//    }

    /**
     * Metodo responsavel em salvar alterações na tabela de pessoas
     *
     * @param pessoas
     * @param id_pessoa
     */
    public void salvarAlteracao(Pessoas_Model pessoas, int id_pessoa) {
        try {
            // realiza a atualização de dados no BD tabela pessoa;

            String sql = "UPDATE cadastro.tblpessoas set nome_pessoa=?, sexo=?, doc_identidade=?, data_expedicao=?, orgao_expeditor=?, cpf=?, estado_civil=?, nacionalidade=?, profissao=?, data_nascimento=?, cidade_nascimento=?, estado_nascimento=?, nome_pai=?, nome_mae=? where id=" + id_pessoa;

            con = ConexaoDB.getconection();
            stm = con.prepareStatement(sql);

            // criando objeto que ira formatar a data, indicamos como esta vindo o padrao da data
            DateTimeFormatter formt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            // convertendo string em Data padrao: yyyy-MM-dd
            LocalDate Nasc_pai = LocalDate.parse(pessoas.getNascimento(), formt);
            LocalDate exp_ident_pai = LocalDate.parse(pessoas.getDataExpedicao(), formt);

            //aqui convertemos de Date para String, e dpois fazemos a gravação na base de dados
            String dat = String.valueOf(Nasc_pai);
            String exp_ident = String.valueOf(exp_ident_pai);

            stm.setString(1, pessoas.getNome());
            stm.setString(2, pessoas.getSexo());
            stm.setString(3, pessoas.getDocIdentidade());
            stm.setString(4, exp_ident);
            stm.setString(5, pessoas.getOrgaoExpeditor());
            stm.setString(6, pessoas.getCpf());
            stm.setString(7, pessoas.getEst_civil());
            stm.setString(8, pessoas.getNacionalidade());
            stm.setString(9, pessoas.getProfissao());
            stm.setString(10, dat);
            stm.setString(11, pessoas.getCidade_nasc());
            stm.setString(12, pessoas.getEstado_nasc());
            stm.setString(13, pessoas.getPai());
            stm.setString(14, pessoas.getMae());

            // capturando retorno do metodo
            int retorno = stm.executeUpdate();
            if (retorno != 0) {

                // msge de confirmação
                JOptionPane.showMessageDialog(null, "Todos os dados da pessoa " + pessoas.getNome() + " foram atualizados com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);

            } else {
                // erro
                JOptionPane.showMessageDialog(null, "Não foi possivel salvar as alterações deste cadastro de pessoas", "Atenção", JOptionPane.ERROR_MESSAGE);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na atualização de dados na tabela Pessoas\n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConexaoDB.fecharConexao(con, stm);
        }

    }

    /**
     * Metodo utilizado no formulario de Processo de casamento, quando na busca de um usuario,
     * é verificado que o mesmo não possui uma certidao vinculada, aqui inserimos no cadastro de pessoa
     * o id da certidao que foi inserida
     * @param id_certidao
     * @param id_pessoa 
     * @return  
     */
    public boolean Atualizar_Pessoa_Inserir_id_certidao(int id_certidao, int id_pessoa) {

        boolean retorno_metodo = false;
        
        try {
            String sql = "update cadastro.tblpessoas set id_certidao=? where id=" + id_pessoa;

            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);

            stm.setInt(1, id_certidao);

            int retorno = stm.executeUpdate();

            if (retorno != 0) {
                // mensagem de confirmação
                JOptionPane.showMessageDialog(null, "Certidao foi vinculada com sucesso", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                
                // alterando o valor do atributo retorno_metodo
                // indicando que o valor foi corretamente atualizado
                retorno_metodo = true;
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possivel realizar a atualização no cadastro da pessoa selecionada.\nCampo certidao da pessoa não atualizou ", "Mensagem", JOptionPane.OK_OPTION);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de gravação na tabela pessoas\n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConexaoBD.ConexaoDB.fecharConexao(con, stm);
        }
        
        return retorno_metodo;
    }

}
