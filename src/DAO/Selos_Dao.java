/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConexaoBD.ConexaoDB;
import Model.Selos_Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author rh
 */
public class Selos_Dao {

    Connection conexao;
    PreparedStatement stm;
    ResultSet rs;

    /**
     * Metodo para ler a sequencia de selos recebe um parametro tipo Integer,
     * sendo o ultimo ID da tabela selo, somente assim iremos capturar as LETRAS
     * e NUMEROS CORRETAMENTE
     *
     * @param ultimo_id
     * @return ultimo_selo
     */
    public String[] carregarSelos(int ultimo_id) {

        // array de String com valores recuperados da tabela selos
        String ultimoSelo[] = new String[2];

        String sql = "select letras, selos from cadastro.tblselos where id=" + ultimo_id;
        try {
            conexao = ConexaoBD.ConexaoDB.getconection();
            stm = conexao.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                ultimoSelo[0] = rs.getString("letras");
                ultimoSelo[1] = String.valueOf(rs.getInt(2)); // posicao segunda do select(selos)
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel ler a sequencia de selos\n" + ex, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConexaoDB.fecharConexao(conexao, stm, rs);

        }

        return ultimoSelo;
    }

    /**
     * Metodo que ira gravar o selo utilizado na tabela de selos
     *
     * @param letras
     * @param numeroSelo
     * @param custo
     * @return id_selo
     */
    public int gravarSelo(String letras, String numeroSelo, double custo) {

        int id_selo = 0;
        String sql = "INSERT INTO cadastro.tblselos(data_ato, letras, selos, custo) VALUES(?,?,?,?)";

        try {

            conexao = ConexaoDB.getconection();
            stm = conexao.prepareStatement(sql);

            // formatador para decimais
//            DecimalFormat decimal = new DecimalFormat("#,##0.00");

            // definindo o formatdo da data: 2016/12/08;
            DateTimeFormatter formt = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            // captura a data do sistema e formata para gravar no BD, e transforma em data
            stm.setString(1, formt.format(LocalDate.now()));
            stm.setString(2, letras);
            stm.setString(3, numeroSelo);
            stm.setDouble(4, custo);

            // atualizada o Bd;
            int ret = stm.executeUpdate();

            // verifica se foi gravado
            if (ret != 0) {

                // mensagem de confirmação da gravação
                JOptionPane.showMessageDialog(null, "Selo inserido com sucesso!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);

                // ler o ultimo id inserido referente a este selo
                id_selo = lerIdSelo();

            }
        } catch (SQLException ex) {
            // erro
            JOptionPane.showMessageDialog(null, "Não foi possivel a gravação do selo" + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }

        return id_selo;
    }

    /**
     * Metodo responsavel em ler o ID do ultimo selo utilizado
     *
     * @return int id
     */
    public int lerIdSelo() {
        int id = 0;
        try {
            String sql = "select max(id) from cadastro.tblselos";
            Connection con = ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                id = rs.getInt(1);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler o ID da tabela selos\n" + ex);
        } finally {
            ConexaoDB.fecharConexao(conexao, stm, rs);
        }
        //selo++;
        return id;
    }

    /**
     * Metodo utilizado para capturar informações da tabela autenticações,
     * reconhecimento de assinaturas para mostrar na tela de Impressao de
     * autenticação, reconhecimento os selos não impressos e ja impressos
     *
     * @param sql
     * @return
     */
    public List<Selos_Model> buscar_selos_por_ato(String sql) {
        List<Selos_Model> autenticacoes = new ArrayList<>();;

        try {
            conexao = ConexaoBD.ConexaoDB.getconection();
            stm = conexao.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                Selos_Model info_selos = new Selos_Model();
                info_selos.setId_selo(rs.getInt("id"));
                info_selos.setData_ato(LocalDate.parse(rs.getString("data_ato")));
                info_selos.setSeqNumeros(rs.getInt("selos"));
                info_selos.setseqLetras(rs.getString("letras"));
                info_selos.setSituacao_impresso(rs.getString("impresso"));

                autenticacoes.add(info_selos);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na tentativa de leitura das informações\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConexaoBD.ConexaoDB.fecharConexao(conexao, stm, rs);
        }
        return autenticacoes;
    }

    /**
     * Metodo utilizado para ler um determinado ID de selo, e retorna um objeto
     * com as informações necessaria para preencher a tabela selos_selecionados
     * da View Imprimir_Recon_Assinatura
     *
     * @param sql
     * @return
     */
    public Selos_Model capturar_info_selos_selecionado(String sql) {
        Selos_Model info_selos = new Selos_Model();
        try {
            conexao = ConexaoBD.ConexaoDB.getconection();
            stm = conexao.prepareStatement(sql);
            rs = stm.executeQuery();
            
            while (rs.next()) {

                info_selos.setId_selo(rs.getInt("id"));
                info_selos.setSeqNumeros(rs.getInt("selos"));
                info_selos.setseqLetras(rs.getString("letras"));
                info_selos.setCusto(rs.getDouble("custo"));

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na tentativa de leitura das informações\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConexaoBD.ConexaoDB.fecharConexao(conexao, stm, rs);
        }
        return info_selos;
    }
    
     /**
     * Metodo que faz a alteração do campo IMPRESSO da tabela selos indicando se
     * o selo já foi impresso ou não
     *
     * @param id_selo
     */
    public void alterar_campo_impresso(int id_selo) {

        try {
            String sql = "UPDATE `cadastro`.`tblselos` SET `impresso`=? WHERE `id`=' " + id_selo + " ' ";
            conexao = ConexaoBD.ConexaoDB.getconection();
            stm = conexao.prepareStatement(sql);

            stm.setString(1, "S");

            stm.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na tentativa de atualizar o campo impressão da tabela selos\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConexaoBD.ConexaoDB.fecharConexao(conexao, stm);
        }
    }
}
