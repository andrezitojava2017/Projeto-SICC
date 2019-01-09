/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Ficha_Assinatura_Model;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Andre
 */
public class Ficha_Assinatura_Dao {

    Connection con;
    PreparedStatement stm;
    ResultSet rs;

    /**
     * Metodo que faz gravaçao na tabela de ficha de assinatura
     *
     * @param id_pessoa
     * @param ficha
     */
    public int Salvar_Nova_Ficha(int id_pessoa, Ficha_Assinatura_Model ficha) {

        int id_ficha = 0;
        try {
            String sql = "insert into cadastro.tblfichaassinatura(numero_ficha, local_ficha, id_pessoa) values(?,?,?)";
            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);

            stm.setInt(1, ficha.getNumero_ficha());
            stm.setString(2, ficha.getLocal_ficha());
            stm.setInt(3, id_pessoa);

            int retorno = stm.executeUpdate();

            if (retorno != 0) {

                // mensagem ao usuario
                JOptionPane.showMessageDialog(null, "Nova ficha foi gravada com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);

                id_ficha = Ler_Id_Ficha_Assinatura();
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possivel a inserção da nova ficha de assinatura\n", "Mensagem", JOptionPane.ERROR_MESSAGE);
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar inserir a nova ficha de assinatura\n" + e, "Error", JOptionPane.ERROR_MESSAGE);

        } finally {
            ConexaoBD.ConexaoDB.fecharConexao(con, stm);
        }

        return id_ficha;
    }

    /**
     * Metodo que faz a leitura o ultimo ID inserido na tabela de fichas
     *
     * @return int id_ficha
     */
    public int Ler_Id_Ficha_Assinatura() {

        int id_ficha = 0;

        try {
            String sql = "select max(id) from cadastro.tblfichaassinatura";
            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {

                id_ficha = rs.getInt(1);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar ler a tabela ficha de assinatura\n" + e, "Error", JOptionPane.ERROR_MESSAGE);

        } finally {
            ConexaoBD.ConexaoDB.fecharConexao(con, stm);
        }
        return id_ficha;
    }

    
    /**
     * Metodo que faz a captura de ficha de uma determinada pessoa
     * @param id_pessoa
     * @return ficha_numero
     */
    public int Capturar_Sequencia_Ficha(int id_pessoa) {

        int ficha_numero = 0;

        try {
            String sql = "select numero_ficha from cadastro.tblfichaassinatura where id_pessoa=" + id_pessoa;
            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                ficha_numero = rs.getInt(1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar ler a tabela ficha de assinatura\n" + e, "Error", JOptionPane.ERROR_MESSAGE);

        } finally {
            ConexaoBD.ConexaoDB.fecharConexao(con, stm);
        }
        return ficha_numero;
    }
    
    

    /**
     * Metodo para capturar todos os dados da tabela ficha de assinatura
     * @param id_pessoa
     * @return Ficha_Assinatura_Model
     */
    public Ficha_Assinatura_Model Capturar_Dados_Ficha_Assinatura(int id_pessoa) {

        Ficha_Assinatura_Model ficha =  new Ficha_Assinatura_Model();
        
        try {
            String sql = "select * from cadastro.tblfichaassinatura where id_pessoa=" + id_pessoa;
            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                
                ficha.setId_ficha(rs.getInt("id"));
                ficha.setNumero_ficha(rs.getInt("numero_ficha"));
                ficha.setLocal_ficha(rs.getString("local_ficha"));

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar ler a tabela ficha de assinatura\n" + e, "Error", JOptionPane.ERROR_MESSAGE);

        } finally {
            ConexaoBD.ConexaoDB.fecharConexao(con, stm);
        }
        return ficha;
    }
}
