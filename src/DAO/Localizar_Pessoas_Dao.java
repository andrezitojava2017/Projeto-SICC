/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Certidao_Model;
import Model.Pessoas_Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Andre
 */
public class Localizar_Pessoas_Dao {

    Connection con;
    PreparedStatement stm;
    ResultSet rs;

//    /**
//     * Metodo responsavel em ler determinada tabela sql informada por parametro
//     *
//     * @param sql
//     * @return
//     */
//    public List<Pessoas_Model> buscarContraentes(String sql) {
//
//        List<Pessoas_Model> lista = new ArrayList<>();
//
//        try {
//            con = ConexaoBD.ConexaoDB.getconection();
//            stm = con.prepareStatement(sql);
//            rs = stm.executeQuery();
//
//            while (rs.next()) {
//
//                Pessoas_Model nvo = new Pessoas_Model();
//                nvo.setId(rs.getInt(1));
//                nvo.setNome(rs.getString(2));
//
//                lista.add(nvo);
//            }
//
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Não foi possivel a leitura da tabela", "Atenção", JOptionPane.ERROR_MESSAGE);
//
//        } finally {
//
//            ConexaoBD.ConexaoDB.fecharConexao(con, stm, rs);
//        }
//
//        return lista;
//    }

    
    /**
     * Metodo responsavel em ler os dados pessoais da tabela PESSOAS
     * utilizado para preencher o formulario de nascimento(PAI/MAE) quando
     * necessario alterar alguma informação. A condição fornecida como parametro
     * indica se é Masculino ou Feminino
     *
     * @param nome
     * @param condicao
     * @return Pessoas_Model pessoa
     */
    public List<Pessoas_Model> capturarDadosPessoa(String nome, String condicao) {

        List<Pessoas_Model> lista = new ArrayList<>();
        try {

            String sql = "select * from cadastro.tblpessoas where nome_pessoa like '" + nome +"%' and sexo='" + condicao + "'";

            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {

                Pessoas_Model pessoa = new Pessoas_Model();
                
                pessoa.setId(rs.getInt("id"));
                pessoa.setNome(rs.getString("nome_pessoa"));
                pessoa.setNacionalidade(rs.getString("nacionalidade"));
                pessoa.setEst_civil(rs.getString("estado_civil"));
                pessoa.setDocIdentidade(rs.getString("doc_identidade"));
                pessoa.setOrgaoExpeditor(rs.getString("orgao_expeditor"));
                pessoa.setDataExpedicao(rs.getString("data_expedicao"));
                pessoa.setCpf(rs.getString("cpf"));
                pessoa.setProfissao(rs.getString("profissao"));
                pessoa.setNascimento(rs.getDate("data_nascimento").toString());
                pessoa.setCidade_nasc(rs.getString("cidade_nascimento"));
                pessoa.setEstado_nasc(rs.getString("estado_nascimento"));
                pessoa.setPai(rs.getString("nome_pai"));
                pessoa.setMae(rs.getString("nome_mae"));
                pessoa.setId_endereco(rs.getInt("id_endereco"));
                pessoa.setId_certidao(rs.getInt("id_certidao"));
                
                lista.add(pessoa);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel a leitura das informações da pessoa selecionada\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {

            ConexaoBD.ConexaoDB.fecharConexao(con, stm, rs);
        }

        return lista;
    }

    /**
     * Metodo responsavel em ler os dados pessoais da tabela PESSOAS
     * utilizado para preencher o formulario de testemunha(processo de casamento)
     *
     * @param nome
     * @return Pessoas_Model pessoa
     */
    public List<Pessoas_Model> Capturar_Dados_Pessoa(String nome) {

        List<Pessoas_Model> lista = new ArrayList<>();
        try {

            String sql = "select * from cadastro.tblpessoas where nome_pessoa like '" + nome +"%'";

            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {

                Pessoas_Model pessoa = new Pessoas_Model();
                
                pessoa.setId(rs.getInt("id"));
                pessoa.setNome(rs.getString("nome_pessoa"));
                pessoa.setNacionalidade(rs.getString("nacionalidade"));
                pessoa.setEst_civil(rs.getString("estado_civil"));
                pessoa.setDocIdentidade(rs.getString("doc_identidade"));
                pessoa.setOrgaoExpeditor(rs.getString("orgao_expeditor"));
                pessoa.setDataExpedicao(rs.getString("data_expedicao"));
                pessoa.setCpf(rs.getString("cpf"));
                pessoa.setProfissao(rs.getString("profissao"));
                pessoa.setNascimento(rs.getDate("data_nascimento").toString());
                pessoa.setCidade_nasc(rs.getString("cidade_nascimento"));
                pessoa.setEstado_nasc(rs.getString("estado_nascimento"));
                pessoa.setPai(rs.getString("nome_pai"));
                pessoa.setMae(rs.getString("nome_mae"));
                pessoa.setId_endereco(rs.getInt("id_endereco"));
                pessoa.setId_certidao(rs.getInt("id_certidao"));
                
                lista.add(pessoa);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel a leitura das informações da pessoa selecionada\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {

            ConexaoBD.ConexaoDB.fecharConexao(con, stm, rs);
        }

        return lista;
    }
    
    /**
     * Metodo que faz a busca na tabela REGISTRANDO, para preenche a tela de pesquisa de registrando
     * @param nome
     * @return 
     */
    public List<Pessoas_Model> pesquisarRegistrando(String nome) {

        List<Pessoas_Model> lista = new ArrayList<>();
        try {

            String sql = "select id, nome from cadastro.tblregistrando where nome like '" + nome +"%'";

            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                // objetos model
                Pessoas_Model pessoa = new Pessoas_Model();

                // capturando dados
                pessoa.setId(rs.getInt("id"));
                pessoa.setNome(rs.getString("nome"));                
  
                // add a lista
                lista.add(pessoa); 
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na leitura das informações da pessoa selecionada\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {

            ConexaoBD.ConexaoDB.fecharConexao(con, stm, rs);
        }

        return lista;
    }
    
    
    
    /**
     * Metodo que ira capturar as informações de uma determinada pessoa, previamente escolhida atraves da tela
     * de Localizar pessoas, para preencher formularios
     * @param id_pessoa_selecionada
     * @return Pessoas_Model
     */
    public Pessoas_Model capturarPessoaSelecionada(String id_pessoa_selecionada){
        
        Pessoas_Model dadosPessoas = new Pessoas_Model();
         try {

            String sql = "select * from cadastro.tblpessoas where id=" + id_pessoa_selecionada;

            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                
                dadosPessoas.setId(rs.getInt("id"));
                dadosPessoas.setNome(rs.getString("nome_pessoa"));
                dadosPessoas.setSexo(rs.getString("sexo"));
                dadosPessoas.setNacionalidade(rs.getString("nacionalidade"));
                dadosPessoas.setEst_civil(rs.getString("estado_civil"));
                dadosPessoas.setDocIdentidade(rs.getString("doc_identidade"));
                dadosPessoas.setOrgaoExpeditor(rs.getString("orgao_expeditor"));
                dadosPessoas.setDataExpedicao(rs.getString("data_expedicao"));
                dadosPessoas.setCpf(rs.getString("cpf"));
                dadosPessoas.setProfissao(rs.getString("profissao"));
                dadosPessoas.setNascimento(rs.getDate("data_nascimento").toString());
                dadosPessoas.setCidade_nasc(rs.getString("cidade_nascimento"));
                dadosPessoas.setEstado_nasc(rs.getString("estado_nascimento"));
                dadosPessoas.setPai(rs.getString("nome_pai"));
                dadosPessoas.setMae(rs.getString("nome_mae"));
                dadosPessoas.setId_endereco(rs.getInt("id_endereco"));
                dadosPessoas.setId_certidao(rs.getInt("id_certidao"));
                
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel a leitura das informações da pessoa selecionada\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {

            ConexaoBD.ConexaoDB.fecharConexao(con, stm, rs);
        }
        
        return dadosPessoas;
    }
    
    
    /**
     * Metodo utilizado para preencher tabela pessoas, da View Imprimir_Recon_Assinatura
     * possibilitando assim a impressao de um determinado carimbo de reconhecimento
     * @param id_selo
     * @return 
     */
    public List<Pessoas_Model> buscar_pessoa(String id_selo) {

        List<Pessoas_Model> lista = new ArrayList<>();
        try {

            String sql = "select cadastro.tblpessoas.id, cadastro.tblpessoas.nome_pessoa, cadastro.tblpessoas.cpf from cadastro.tblpessoas"
                    + " inner join cadastro.tblreconfirma on cadastro.tblreconfirma.id_pessoa = cadastro.tblpessoas.id where cadastro.tblreconfirma.id_selo =" + id_selo;

            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                // objetos model
                Pessoas_Model pessoa = new Pessoas_Model();

                // capturando dados
                pessoa.setId(rs.getInt("id"));
                pessoa.setNome(rs.getString("nome_pessoa"));  
                pessoa.setCpf(rs.getString("cpf"));
  
                // add a lista
                lista.add(pessoa); 
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na leitura das informações da pessoa selecionada\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {

            ConexaoBD.ConexaoDB.fecharConexao(con, stm, rs);
        }

        return lista;
    }
}
