/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Permissoes_Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Andre
 */
public class Permissao_Dao {

    Connection con;
    PreparedStatement stm;
    ResultSet rs;

    /**
     * Metodo que faz a gravação das permissoes para determinado usuario
     *
     * @param permissao objeto tipo Model
     * @return int retorno
     */
    public int gravarPermissao(Permissoes_Model permissao) {

        int retorno = 0;

        String sql = "insert into cadastro.tblpermissao(autenticacao, rec_assinatura, abert_firma, procuracao, casamento, nascimento, obito, alterar_selo, novo_user) values(?,?,?,?,?,?,?,?,?)";

        try {
            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);

            stm.setString(1, permissao.getAutenticacao());
            stm.setString(2, permissao.getRecon_firma());
            stm.setString(3, permissao.getAbert_firma());
            stm.setString(4, permissao.getProcuracao());
            stm.setString(5, permissao.getCert_casamento());
            stm.setString(6, permissao.getCert_nascimento());
            stm.setString(7, permissao.getCert_obito());
            stm.setString(8, permissao.getAlterar_selo());
            stm.setString(9, permissao.getNovo_user());

            retorno = stm.executeUpdate();

            // caso seja inserido uma nova linha
            if (retorno != 0) {

                // capturamos o ultimo ID que foi inserido na tabela permissao
                // passamos ao atributo RETORNO
                retorno = ler_id_permissao();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Atenção: as permissoes não foram salvas", "Atenção", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConexaoBD.ConexaoDB.fecharConexao(con, stm);
        }

        return retorno;

    }

    /**
     * Metodo para ler o maior ID da tabela Permissoes
     *
     * @return id - int
     */
    public int ler_id_permissao() {

        int id = 0;

        try {

            String sql = "select max(id) from cadastro.tblpermissao";

            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {

                id = rs.getInt(1);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na leitura da tabela permissoes ", "Erro ", JOptionPane.ERROR_MESSAGE);
        } finally {

            ConexaoBD.ConexaoDB.fecharConexao(con, stm, rs);

        }

        return id;
    }

    
    /**
     * Metodo que lê todas as permissoes de um determinado ID
     *
     * @param id_permissao
     * @return
     */
    public Permissoes_Model lerPermissoesUsuario(int id_permissao) {

        Permissoes_Model prm = new Permissoes_Model();
        
        try {

            String sql = "select * from cadastro.tblpermissao where id=" + id_permissao;
            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            
            while(rs.next()){
                
                prm.setAbert_firma(rs.getString("abert_firma"));
                prm.setAlterar_selo(rs.getString("alterar_selo"));
                prm.setAutenticacao(rs.getString("autenticacao"));
                prm.setCert_casamento(rs.getString("casamento"));
                prm.setCert_nascimento(rs.getString("nascimento"));
                prm.setCert_obito(rs.getString("obito"));
                prm.setNovo_user(rs.getString("novo_user"));
                prm.setProcuracao(rs.getString("procuracao"));
                prm.setRecon_firma(rs.getString("rec_assinatura"));
                
            }

            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na leitura da tabela permissões", "Atenção", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConexaoBD.ConexaoDB.fecharConexao(con, stm, rs);
        }
        
        return prm;
    }
    
    
    /**
     * Metodo que faz a atualizacao das permissoes de determinado usuario
     * @param permissao
     * @param id_permissao
     * @return boolean
     */
    public boolean atualizarPermissoes(Permissoes_Model permissao, int id_permissao) {

        boolean ret = false;

        String sql = "update cadastro.tblpermissao set autenticacao=?, rec_assinatura=?, abert_firma=?, procuracao=?, casamento=?, nascimento=?, obito=?, alterar_selo=?, novo_user=? where id='" + id_permissao + "'";

        try {
            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);

            stm.setString(1, permissao.getAutenticacao());
            stm.setString(2, permissao.getRecon_firma());
            stm.setString(3, permissao.getAbert_firma());
            stm.setString(4, permissao.getProcuracao());
            stm.setString(5, permissao.getCert_casamento());
            stm.setString(6, permissao.getCert_nascimento());
            stm.setString(7, permissao.getCert_obito());
            stm.setString(8, permissao.getAlterar_selo());
            stm.setString(9, permissao.getNovo_user());

            int retorno = stm.executeUpdate();

            // caso seja inserido uma nova linha
            if (retorno != 0) {
                
                ret = true;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Atenção: as permissoes não foram atualizadas", "Atenção", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConexaoBD.ConexaoDB.fecharConexao(con, stm);
        }

        return ret;

    }
    
}
