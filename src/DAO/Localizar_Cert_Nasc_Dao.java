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
public class Localizar_Cert_Nasc_Dao {

    Connection con;
    PreparedStatement stm;
    ResultSet rs;

    /**
     * Metodo que faz a leitura da tabela Casamento para preencher a tabela de
     * certidao
     *
     * @param sql_tabela
     * @return Certidao_Model
     */
    public List<Certidao_Model> Localizar_Certidao_Casamento(String sql_tabela) {

        List<Certidao_Model> certidoes = new ArrayList<>();

        try {
            String sql = "select id, livro, folha, termo, matricula, data_lavratura from cadastro.tblcasamento" + sql_tabela;
            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                Certidao_Model nasc = new Certidao_Model();

                nasc.setId_certidao(rs.getInt(1));
                nasc.setLivro(rs.getInt(2));
                nasc.setFolha(rs.getInt(3));
                nasc.setTermo(rs.getInt(4));
                nasc.setMatricula(rs.getString(5));
                nasc.setData_lavratura(rs.getString(6));

                certidoes.add(nasc);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Atenção ocorreu um erro na tentativa de leitura da tabela\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        }

        return certidoes;
    }
    
    /**
     * Metodo que faz a leitura da tabela nascimento para preencher a tabela de
     * certidao
     *
     * @param sql_tabela
     * @return Certidao_Model
     */
    public List<Certidao_Model> localizarCertNascimento(String sql_tabela) {

        List<Certidao_Model> certidoes = new ArrayList<>();

        try {
            String sql = "select id, livro, folha, termo, matricula, data_lavratura from cadastro.tblnascimento" + sql_tabela;
            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                Certidao_Model nasc = new Certidao_Model();

                nasc.setId_certidao(rs.getInt(1));
                nasc.setLivro(rs.getInt(2));
                nasc.setFolha(rs.getInt(3));
                nasc.setTermo(rs.getInt(4));
                nasc.setMatricula(rs.getString(5));
                nasc.setData_lavratura(rs.getString(6));

                certidoes.add(nasc);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Atenção ocorreu um erro na tentativa de leitura da tabela\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        }

        return certidoes;
    }

    /**
     * Metodo que ira ler uma determinada tabela, conforme opção escolhida na
     * tela de busca de certidao
     *
     * @param sql
     * @return Pessoas_Model pessoas
     */
    public List<Pessoas_Model> localizarNascimento(String sql) {

        List<Pessoas_Model> pessoa = new ArrayList<>();

        try {

            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {

                Pessoas_Model infoPai = new Pessoas_Model();
                infoPai.setId(rs.getInt(1));
                infoPai.setNome(rs.getString(2));

                pessoa.add(infoPai);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Atenção ocorreu um erro na tentativa de leitura da tabela escolhida\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally{
            ConexaoBD.ConexaoDB.fecharConexao(con, stm, rs);
        }

        return pessoa;
    }

    /**
     * Este metodo tem por objetivo, verficar na tabela de nascimento, se o
     * campo ID_PAI não esta ´NULO caso seja NULO uma outra determinada sql e
     * executada, para não ocorrer erros na leitura das informações do banco
     *
     * @param id_certidao
     * @return 
     */
    public boolean verificarCertidaoIdPai(String id_certidao) {

        boolean id_existe = false;
        try {
            String sql = "select id_pai from cadastro.tblnascimento where id=" + id_certidao;
            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while(rs.next()){
                
                // captura o conteudo da coluna especificadA
                int id_capt = rs.getInt(1);
                
                // VERIFICAMOS SE ESTA PREENCHIDO OU NAO
                if(id_capt != 0){
                    id_existe = true;
                } else {
                    id_existe = false;
                }
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Atenção ocorreu um erro na tentativa de leitura da tabela escolhida\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally{
            ConexaoBD.ConexaoDB.fecharConexao(con, stm, rs);
        }
        return id_existe;
    }

    
    /**
     * Metodo que faz a leitura da tabela nascimento, registrado, pai e mae para
     * preencher a tela de visualização da certidao
     *
     * @param id_certidao
     * @return
     */
    public List<Object> visualizarCertidao(String id_certidao) {

        List<Object> dadosCertidao = new ArrayList<>();

        try {
            String sql = "select cadastro.tblnascimento.livro, cadastro.tblnascimento.folha, cadastro.tblnascimento.termo, cadastro.tblnascimento.matricula, cadastro.tblnascimento.data_lavratura, cadastro.tblnascimento.decl_nasc_vivo,\n"
                    + "cadastro.tblregistrando.cidade_registro, cadastro.tblregistrando.estado_registro, cadastro.tblregistrando.data_nascimento,\n"
                    + "cadastro.tblregistrando.hora_nascimento,cadastro.tblregistrando.cidade_nascimento, cadastro.tblregistrando.estado_nasci, cadastro.tblregistrando.local_nasci, cadastro.tblregistrando.sexo,\n"
                    + "cadastro.tblregistrando.gemeos, cadastro.tblregistrando.matricula_gemeo,\n"
                    + "cadastro.tblpessoas.nome_pessoa, cadastro.tblpessoas.nome_pai, cadastro.tblpessoas.nome_mae,\n"
                    + "cadastro.tblpessoas.nome_pessoa, cadastro.tblpessoas.nome_pai, cadastro.tblpessoas.nome_mae,\n"
                    + "cadastro.tblregistrando.nome\n"
                    + "from cadastro.tblnascimento\n"
                    + "inner join cadastro.tblregistrando on cadastro.tblregistrando.id = cadastro.tblnascimento.id_registrando\n"
                    + "inner join cadastro.tblpessoas pai on pai.id = cadastro.tblnascimento.id_pai\n"
                    + "inner join cadastro.tblpessoas mae on mae.id = cadastro.tblnascimento.id_mae\n"
                    + "where cadastro.tblnascimento.id =" + id_certidao;

            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                Certidao_Model certidao = new Certidao_Model();
                Pessoas_Model registrado = new Pessoas_Model();
                Pessoas_Model infoPai = new Pessoas_Model();
                Pessoas_Model infoMae = new Pessoas_Model();

                certidao.setLivro(rs.getInt(1));
                certidao.setFolha(rs.getInt(2));
                certidao.setTermo(rs.getInt(3));
                certidao.setMatricula(rs.getString(4));
                certidao.setData_lavratura(rs.getString(5));
                certidao.setDecl_nasc_vivo(rs.getString(6));
                certidao.setCidade_registro(rs.getString(7));
                certidao.setEstado_reg(rs.getString(8));
                certidao.setData_nasc(rs.getString(9));
                certidao.setHora_nasc(rs.getString(10));
                certidao.setCidade_nasc(rs.getString(11));
                certidao.setEstado_nasc(rs.getString(12));
                certidao.setLocal_nasc(rs.getString(13));
                certidao.setSexo(rs.getString(14));
                certidao.setGemeos(rs.getString(15));
                certidao.setMatricula_gemeo(rs.getString(16));
                dadosCertidao.add(certidao); // POSICAO [0] - DADOS CERTIDAO

                infoPai.setNome(rs.getString(17));
                infoPai.setPai(rs.getString(18));
                infoPai.setMae(rs.getString(19));
                dadosCertidao.add(infoPai); // POSICAO [1] - DADOS PAI

                infoMae.setNome(rs.getString(20));
                infoMae.setPai(rs.getString(21));
                infoMae.setMae(rs.getString(22));
                dadosCertidao.add(infoMae); // POSICAO [2] - DADOS MAE

                registrado.setNome(rs.getString(23));
                dadosCertidao.add(registrado);// POSICAO [3] - DADOS REGISTRANDO

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Atenção ocorreu um erro na tentativa de leitura da tabela escolhida\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally{
            ConexaoBD.ConexaoDB.fecharConexao(con, stm, rs);
        }
        return dadosCertidao;
    }
    
    
    
    
    /**
     * Metodo que faz a leitura da tabela nascimento, registrado e mae para
     * preencher a tela de visualização da certidao, esta metodo é utilizado QUANDO O PAI NAO ESTA PRESENTE NA CERTIDAO
     * quando o campo ID_PAI da tabela NASCIMENTO não esta preenchido
     *
     * @param id_certidao
     * @return
     */
    public List<Object> visualizarCertidaoSemPai(String id_certidao) {

        List<Object> dadosCertidao = new ArrayList<>();

        try {
            String sql = "select cadastro.tblnascimento.livro, cadastro.tblnascimento.folha, cadastro.tblnascimento.termo, cadastro.tblnascimento.matricula, cadastro.tblnascimento.data_lavratura, cadastro.tblnascimento.decl_nasc_vivo,\n"
                    + "cadastro.tblregistrando.cidade_registro, cadastro.tblregistrando.estado_registro, cadastro.tblregistrando.data_nascimento,\n"
                    + "cadastro.tblregistrando.hora_nascimento,cadastro.tblregistrando.cidade_nascimento, cadastro.tblregistrando.estado_nasci, cadastro.tblregistrando.local_nasci, cadastro.tblregistrando.sexo,\n"
                    + "cadastro.tblregistrando.gemeos, cadastro.tblregistrando.matricula_gemeo,\n"
                    + "cadastro.tblpessoas.nome_pessoa, cadastro.tblpessoas.nome_pai, cadastro.tblpessoas.nome_mae,\n"
                    + "cadastro.tblregistrando.nome\n"
                    + "from cadastro.tblnascimento\n"
                    + "inner join cadastro.tblregistrando on cadastro.tblregistrando.id = cadastro.tblnascimento.id_registrando\n"
                    + "inner join cadastro.tblpessoas on cadastro.tblpessoas.id = cadastro.tblnascimento.id_mae\n"
                    + "where cadastro.tblnascimento.id =" + id_certidao;

            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                Certidao_Model certidao = new Certidao_Model();
                Pessoas_Model registrado = new Pessoas_Model();
                Pessoas_Model infoMae = new Pessoas_Model();

                certidao.setLivro(rs.getInt(1));
                certidao.setFolha(rs.getInt(2));
                certidao.setTermo(rs.getInt(3));
                certidao.setMatricula(rs.getString(4));
                certidao.setData_lavratura(rs.getString(5));
                certidao.setDecl_nasc_vivo(rs.getString(6));
                certidao.setCidade_registro(rs.getString(7));
                certidao.setEstado_reg(rs.getString(8));
                certidao.setData_nasc(rs.getString(9));
                certidao.setHora_nasc(rs.getString(10));
                certidao.setCidade_nasc(rs.getString(11));
                certidao.setEstado_nasc(rs.getString(12));
                certidao.setLocal_nasc(rs.getString(13));
                certidao.setSexo(rs.getString(14));
                certidao.setGemeos(rs.getString(15));
                certidao.setMatricula_gemeo(rs.getString(16));
                dadosCertidao.add(certidao); // POSICAO [0] - DADOS CERTIDAO
                
                infoMae.setNome(rs.getString(17));
                infoMae.setPai(rs.getString(18));
                infoMae.setMae(rs.getString(19));
                dadosCertidao.add(infoMae); // POSICAO [1] - DADOS MAE

                registrado.setNome(rs.getString(20));
                dadosCertidao.add(registrado);// POSICAO [2] - DADOS REGISTRANDO

            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "Atenção ocorreu um erro na tentativa de leitura da tabela escolhida\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally{
            ConexaoBD.ConexaoDB.fecharConexao(con, stm, rs);
        }

        return dadosCertidao;
    }
}
