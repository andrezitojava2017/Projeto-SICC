/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Certidao_Model;
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
public class Certidao_Dao {

    Connection con;
    PreparedStatement stm;
    ResultSet rs;

    /**
     * Metodo responsavel em slvar dados referente a CERTIDAO
     *
     * @param certidao
     * @return id_certidao int
     */
    public int gravar_nova_certidao(Certidao_Model certidao) {

        int id_certidao = 0;

        try {
            String sql = "insert into cadastro.tblcertidao(tipo_certidao, livro_cert, folha_cert, termo_cert, nome_cartorio, cidade_cartorio, estado_cartorio) values(?,?,?,?,?,?,?)";

            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);

            stm.setString(1, certidao.getTipo_certidao());
            stm.setInt(2, certidao.getLivro());
            stm.setInt(3, certidao.getFolha());
            stm.setInt(4, certidao.getTermo());
            stm.setString(5, certidao.getNome_cartorio());
            stm.setString(6, certidao.getCidade_registro());
            stm.setString(7, certidao.getEstado_reg());

            int opt = stm.executeUpdate();

            if (opt != 0) {
                // capturando o ID da certidao salva
                id_certidao = ler_id_certidao();

                // mensagem ao usuario
                JOptionPane.showMessageDialog(null, "Informações sobre a certidao foram salvas com sucesso", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // error
                JOptionPane.showMessageDialog(null, "Não foi possivel salvar esta certidao", "Mensagem", JOptionPane.ERROR_MESSAGE);
            }
        } catch (HeadlessException | SQLException e) {
            // error
            JOptionPane.showMessageDialog(null, "Não foi possivel ler dados da tabela certidao", "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return id_certidao;
    }

    /**
     * Metodo que ira ler o MAIOR id da tabela certidao
     *
     * @return int id_certidao
     */
    public int ler_id_certidao() {
        int id_certidao = 0;

        try {
            String sql = "select max(id) from cadastro.tblcertidao";

            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                id_certidao = rs.getInt(1);
            }

        } catch (SQLException e) {
            // error
            JOptionPane.showMessageDialog(null, "Não foi possivel ler dados da tabela certidao", "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConexaoBD.ConexaoDB.fecharConexao(con, stm, rs);
        }

        return id_certidao;
    }

    /**
     * Metodo que ira ler dados de uma determinada certidao
     *
     * @param id_certidao
     * @return Certidao_Model
     */
    public Certidao_Model capturarDadosCertidao(String id_certidao) {

        Certidao_Model certidao = new Certidao_Model();
        try {
            String sql = "select * from cadastro.tblcertidao where id=" + id_certidao;

            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                certidao.setTipo_certidao(rs.getString("tipo_certidao"));
                certidao.setLivro(rs.getInt("livro_cert"));
                certidao.setFolha(rs.getInt("folha_cert"));
                certidao.setTermo(rs.getInt("termo_cert"));
                certidao.setNome_cartorio(rs.getString("nome_cartorio"));
                certidao.setCidade_registro(rs.getString("cidade_cartorio"));
                certidao.setEstado_reg(rs.getString("estado_cartorio"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel ler dados da tabela certidao\n", "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConexaoBD.ConexaoDB.fecharConexao(con, stm, rs);
        }
        return certidao;
    }

    /**
     * Metodo utilizado para salvar alterações de uma deterninada certidao,
     * fonecida nos registros de Nascimentos
     *
     * @param certidao
     * @param id_certidao
     */
    public void alterarDadosCertidaoPessoa(Certidao_Model certidao, int id_certidao) {

        try {
            String sql = "update cadastro.tblcertidao set tipo_certidao=?, livro_cert=?, folha_cert=?, termo_cert=?, nome_cartorio=?, cidade_cartorio=?, estado_cartorio=? where id=" + id_certidao;

            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);

            stm.setString(1, certidao.getTipo_certidao());
            stm.setInt(2, certidao.getLivro());
            stm.setInt(3, certidao.getFolha());
            stm.setInt(4, certidao.getTermo());
            stm.setString(5, certidao.getNome_cartorio());
            stm.setString(6, certidao.getCidade_registro());
            stm.setString(7, certidao.getEstado_reg());

            int retorno = stm.executeUpdate();

            if (retorno != 0) {
                // mensagem ao usuario
                JOptionPane.showMessageDialog(null, "As alterações foram salvas com sucesso", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // error
                JOptionPane.showMessageDialog(null, "Não foi possivel salvar estas alterações no registro de certidao", "Mensagem", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Atenção houve um erro na tentativa de alterar dados da certidao\n", "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConexaoBD.ConexaoDB.fecharConexao(con, stm);
        }

    }
}
