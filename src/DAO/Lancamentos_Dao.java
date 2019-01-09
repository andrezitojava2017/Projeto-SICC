/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Codigo_Atos_Model;
import Model.Lancamento_Model;
import Model.Selos_Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Andre
 */
public class Lancamentos_Dao {

    Connection con;
    PreparedStatement stm;
    ResultSet rs;

    /**
     * Metodo que faz a busca de lancamentos da tabela de lancamentos utilizada
     * para preencher o formulario de busca de lancamentos
     *
     * @param sql_busca
     * @return
     */
    public List<Lancamento_Model> buscar_lancamentos(String sql_busca) {

        List<Lancamento_Model> lista_lancamento = new ArrayList<>();

        try {
            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql_busca);
            rs = stm.executeQuery();

            while (rs.next()) {

                Lancamento_Model lancamentos = new Lancamento_Model();

                lancamentos.setData_ato(rs.getDate("data_lanc"));
                lancamentos.setCompetencia_ato(rs.getString("competencia_lanc"));
                lancamentos.setId_selo(rs.getInt("id_selo"));
                lancamentos.setCodigo_ato(rs.getInt("codigo_ato"));
                lancamentos.setDescricao_ato(rs.getString("descricao_ato"));
                lancamentos.setId_referencia_ato(rs.getInt("id_ato"));
                lancamentos.setId_lancamento(rs.getInt("id"));

                lista_lancamento.add(lancamentos);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na tentativa de ler a tabela de lancamentos\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConexaoBD.ConexaoDB.fecharConexao(con, stm, rs);
        }

        return lista_lancamento;
    }

    public List<Object> buscar_lancamento_vinculos_ato(String id_lancamento) {

        List<Object> dados_coletados = new ArrayList<>();

        try {
            String sql = "select cadastro.tbllancamentos.codigo_ato, cadastro.tbllancamentos.id_ato from cadastro.tbllancamentos where cadastro.tbllancamentos.id=" + id_lancamento;

            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {

                // aqui iremos verificar se o codigo do ato é correspondente alguma das opções
                // para cada codigo_ato iremos ler uma tabela diferente: Obito, Nascimento, Recon_firma, Abertura de assinatura etc
                // dpois ira preencher um List de objetos que sera retornado ao metodo que a chamou,
                // assim poderemos preencher a tabela de vinculos da view Lancamentos
                switch (rs.getInt("codigo_ato")) {

                    case Codigo_Atos_Model.CODIGO_RECONHECIMENTO:

                        int id_ato = rs.getInt(2);
                        Reconhecer_Assinatura_Dao dao = new Reconhecer_Assinatura_Dao();
                        dados_coletados = dao.capturar_dados_pessoa_vinculada(String.valueOf(id_ato));

                        break;

                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na leitura da base de dados tabela lancamentos\n" + ex, "Error", JOptionPane.ERROR_MESSAGE);
        } finally{
            ConexaoBD.ConexaoDB.fecharConexao(con, stm, rs);
        }

        return dados_coletados;
    }

}
