/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Ficha_Assinatura_Model;
import Model.Pessoas_Model;
import Model.Selos_Model;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Andre
 */
public class Reconhecer_Assinatura_Dao {

    Connection con;
    PreparedStatement stm;
    ResultSet rs;

    public int gravar_reconhecimento_assinatura(int id_pessoa, int id_selo, String tipo_assinatura) {

        int retorno = 0;
        try {
            String sql = "insert into cadastro.tblreconfirma(id_pessoa, id_selo, data_ato,tipo_reconhecimento) values(?,?,?,?)";
            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);

            LocalDate data = LocalDate.now();
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            stm.setInt(1, id_pessoa);
            stm.setInt(2, id_selo);
            stm.setString(3, String.valueOf(data));
            stm.setString(4, tipo_assinatura);

            int opt = stm.executeUpdate();

            if (opt != 0) {
                JOptionPane.showMessageDialog(null, "Reconhecimento foi salvo com sucesso", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                retorno = ler_id_reconhecimento_assinatura();
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possivel salvar ato de Reconhecimento de assinatura", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar salvar ato de Reconhecimento de assinatura", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        return retorno;
    }

    /**
     * Captura o ultimo ID lançado na tabela reconhecimento de assinatura
     *
     * @return
     */
    public int ler_id_reconhecimento_assinatura() {
        int id_reconhecimento = 0;

        try {
            String sql = "select max(id) from cadastro.tblreconfirma";
            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                id_reconhecimento = rs.getInt(1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na leitura da tabela Reconhecimento de assinatura", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        return id_reconhecimento;
    }

    /**
     * Este metodo faz a captura das informações da pessoa vinculada a este ato
     * juntamente com o selo utilizado no reconhecimento de assinatura
     * Metodo utilizado para preenchimento da tabela de vinculos da view de busca de lancamentos
     * @param id_ato_Recon_Firma
     * @return 
     */
    public List<Object>capturar_dados_pessoa_vinculada(String id_ato_Recon_Firma) {

        List<Object> dadosColetados = new ArrayList<>();

        try {
            String sql = "select cadastro.tblpessoas.nome_pessoa, cadastro.tblselos.letras, cadastro.tblselos.selos, cadastro.tblfichaassinatura.numero_ficha from cadastro.tblreconfirma inner join cadastro.tblpessoas on cadastro.tblpessoas.id = cadastro.tblreconfirma.id_pessoa inner join cadastro.tblselos on cadastro.tblselos.id = cadastro.tblreconfirma.id_selo inner join cadastro.tblfichaassinatura on cadastro.tblfichaassinatura.id_pessoa = cadastro.tblpessoas.id where cadastro.tblreconfirma.id =" + id_ato_Recon_Firma;

            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                Pessoas_Model dados_pessoa = new Pessoas_Model();
                Selos_Model dados_selo = new Selos_Model();
                Ficha_Assinatura_Model ficha = new Ficha_Assinatura_Model();

                dados_pessoa.setNome(rs.getString(1));
                dados_selo.setseqLetras(rs.getString(2));
                dados_selo.setSeqNumeros(rs.getInt(3));
                ficha.setNumero_ficha(rs.getInt(4));

                dadosColetados.add(dados_pessoa); //Posição [0] = Pessoas_Model()
                dadosColetados.add(dados_selo); //Posição [1] = Selos_Model()
                dadosColetados.add(ficha); // Posicao[2] = ficha_assinatura_model()
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na tentativa de leitura de informações dos vinculo a este ato\n" + ex, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConexaoBD.ConexaoDB.fecharConexao(con, stm, rs);
        }

        return dadosColetados;
    }

}
