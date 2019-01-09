/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Selos_Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author rh
 */
public class Autenticacao_Dao {

    Connection con;
    PreparedStatement stm;
    ResultSet rs;

    /**
     * Metodo responsavel em gravar dados na tabela de autenticacao
     *
     * @param id_selo int
     * @return boolean
     */
    public int gravarAutenticacao(int id_selo) {

        int id_autenticacao = 0;
        try {

            String sql = "insert into cadastro.tblautenticacao(id_selo) values(?)";
            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);

            stm.setInt(1, id_selo);

            int verificar = stm.executeUpdate();

            if (verificar != 0) {
                id_autenticacao = ler_id_autenticacao();
                System.out.println("Metodo dao - ID ato = " + id_autenticacao);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel a gravação desta autenticacao, verifique", "Atenção", JOptionPane.ERROR_MESSAGE);
        }
        return id_autenticacao;
    }

    /**
     * Metodo que faz a captura do ultimo ID inserido na base d dados da tabela
     * autenticação
     *
     * @return
     */
    public int ler_id_autenticacao() {

        int id_autenticacao = 0;
        try {

            String sql = "select max(id) from cadastro.tblautenticacao";
            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                id_autenticacao = rs.getInt(1);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel a gravação desta autenticacao, verifique", "Atenção", JOptionPane.ERROR_MESSAGE);
        }
        return id_autenticacao;
    }

//    /**
//     * Metodo utilizado para capturar informações da tabela autenticações para
//     * mostrar na tela de Impressao de autenticação os selos não impressos e ja
//     * impressos
//     *
//     * @param sql
//     * @return
//     */
//    public List<Selos_Model> buscar_autenticacao(String sql) {
//        List<Selos_Model> autenticacoes = new ArrayList<>();;
//
//        try {
//            con = ConexaoBD.ConexaoDB.getconection();
//            stm = con.prepareStatement(sql);
//            rs = stm.executeQuery();
//
//            while (rs.next()) {
//                Selos_Model info_selos = new Selos_Model();
//                info_selos.setId_selo(rs.getInt("id"));
//                info_selos.setData_ato(LocalDate.parse(rs.getString("data_ato")));
//                info_selos.setSeqNumeros(rs.getInt("selos"));
//                info_selos.setseqLetras(rs.getString("letras"));
//                info_selos.setSituacao_impresso(rs.getString("impresso"));
//
//                autenticacoes.add(info_selos);
//
//            }
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Erro na tentativa de leitura das informações\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
//        } finally {
//            ConexaoBD.ConexaoDB.fecharConexao(con, stm, rs);
//        }
//        return autenticacoes;
//    }
//    /**
//     * Metodo que faz a alteração do campo IMPRESSO da tabela selos indicando se
//     * o selo já foi impresso ou não
//     *
//     * @param id_selo
//     */
//    public void alterar_campo_impresso(int id_selo) {
//
//        try {
//            String sql = "UPDATE `cadastro`.`tblselos` SET `impresso`=? WHERE `id`=' " + id_selo + " ' ";
//            con = ConexaoBD.ConexaoDB.getconection();
//            stm = con.prepareStatement(sql);
//
//            stm.setString(1, "S");
//
//            stm.executeUpdate();
//
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Erro na tentativa de atualizar o campo impressão da tabela selos\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
//        } finally {
//            ConexaoBD.ConexaoDB.fecharConexao(con, stm);
//        }
//    }
    /**
     * Metodo utilizado para preencher a tabela descrição de atos da view
     * Lancamentos
     *
     * @param id_ato_autenticacao
     * @return
     */
    public List<Object> capturar_dados_autenticacao_vinculada(String id_ato_autenticacao) {

        List<Object> dados_Coletados = new ArrayList<>();

        try {
            String sql = "select cadastro.tblautenticacao.id, cadastro.tblautenticacao.descricao, cadastro.tblselos.letras, cadastro.tblselos.selos from cadastro.tblautenticacao inner join cadastro.tblselos on cadastro.tblselos.id = cadastro.tblautenticacao.id_selo where cadastro.tblautenticacao.id =" + id_ato_autenticacao;

            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            // capturando os dados da referente a autenticação
            while (rs.next()) {

                Selos_Model selo = new Selos_Model();
                int id_autenticacao;

                selo.setseqLetras(rs.getString(3));
                selo.setSeqNumeros(rs.getInt(4));
                id_autenticacao = rs.getInt(1);

                dados_Coletados.add(selo); // Posicão [0] dados do selo
                dados_Coletados.add(id_autenticacao); // Posição [1] dados da id da autenticação
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error na tentativa de leitura da tabela autenticação\n" + e, "Error", JOptionPane.ERROR_MESSAGE);

        } finally {
            ConexaoBD.ConexaoDB.fecharConexao(con, stm, rs);
        }

        return dados_Coletados;

    }
}
