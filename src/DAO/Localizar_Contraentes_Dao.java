/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
public class Localizar_Contraentes_Dao {

    Connection con;
    PreparedStatement stm;
    ResultSet rs;

    /**
     * Metodo responsavel em ler determinada tabela de contraentes sql informada
     * por parametro
     *
     * @param sql
     * @return
     */
    public List<Pessoas_Model> buscarContraentes(String sql) {

        List<Pessoas_Model> lista = new ArrayList<>();

        try {
            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {

                Pessoas_Model nvo = new Pessoas_Model();
                nvo.setId(rs.getInt("id"));
                nvo.setNome(rs.getString("nome"));

                lista.add(nvo);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel a leitura da tabela", "Atenção", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConexaoBD.ConexaoDB.fecharConexao(con, stm, rs);
        }

        return lista;
    }

    /**
     * Metodo responsavel em ler determinada tabela de contraentes sql informada
     * por parametro Responsavelm em preencher campos de contraentes ou
     * testemunhas
     *
     * @param sql
     * @return
     */
    public Pessoas_Model localizarPessoas(String sql) {

        Pessoas_Model lista = new Pessoas_Model();

        try {
            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {

                lista.setId(rs.getInt("id"));
                lista.setNome(rs.getString("nome"));
                lista.setNacionalidade(rs.getString("nacionalidade"));
                lista.setEst_civil(rs.getString("est_civil"));
                lista.setProfissao(rs.getString("profissao"));
                lista.setDocIdentidade(rs.getString("identidade"));
                lista.setOrgaoExpeditor(rs.getString("orgao_exp"));
                lista.setCpf(rs.getString("cpf"));
                lista.setNascimento(rs.getString("data_nasc"));
                lista.setCidade_nasc(rs.getString("cidade_nasc"));
                lista.setEstado_nasc(rs.getString("estado_nasc"));
                lista.setEndereco(rs.getString("residencia"));
                lista.setCidade(rs.getString("cidade_resid"));
                lista.setEstado(rs.getString("estado_resid"));
                lista.setPai(rs.getString("pai"));
                lista.setMae(rs.getString("mae"));

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel a leitura da tabela de contraentes", "Atenção", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConexaoBD.ConexaoDB.fecharConexao(con, stm, rs);
        }

        return lista;
    }

    /**
     * Metodo que faz a captura das informações de uma determinada testemunha
     *
     * @param sql
     * @return
     */
    public Pessoas_Model localizarTestemunha(String sql) {

        Pessoas_Model lista = new Pessoas_Model();

        try {
            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {

                lista.setId(rs.getInt("id"));
                lista.setNome(rs.getString("nome"));
                lista.setNacionalidade(rs.getString("nacionalidade"));
                lista.setEst_civil(rs.getString("estado_civil"));
                lista.setProfissao(rs.getString("profissao"));
                lista.setDocIdentidade(rs.getString("identidade"));
                lista.setOrgaoExpeditor(rs.getString("orgao_exp"));
                lista.setCpf(rs.getString("cpf"));
                lista.setNascimento(rs.getString("data_nasc"));
                lista.setEndereco(rs.getString("residencia"));
                lista.setCidade(rs.getString("cidade_resid"));
                lista.setEstado(rs.getString("estado_resid"));
                lista.setProfissao(rs.getString("profissao"));

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel a leitura da tabela de testemunhas", "Atenção", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConexaoBD.ConexaoDB.fecharConexao(con, stm, rs);
        }

        return lista;
    }
}
