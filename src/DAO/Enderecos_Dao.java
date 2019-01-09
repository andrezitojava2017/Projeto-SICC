/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Enderecos_Model;
import java.awt.HeadlessException;
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
public class Enderecos_Dao {

    Connection con;
    PreparedStatement stm;
    ResultSet rs;

    /**
     * Metodo que salva um NOVO ENDERECO na tabela
     *
     * @param endereco
     * @return int id_endereco
     */
    public int salvarEndereco(Enderecos_Model endereco) {

        int id_endereco = 0;

        try {
            String sql = "insert into cadastro.tblenderecos (endereco, bairro, complemento, cidade, estado) values (?,?,?,?,?)";

            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);

            stm.setString(1, endereco.getNome_rua());
            stm.setString(2, endereco.getBairro());
            stm.setString(3, endereco.getComplemento());
            stm.setString(4, endereco.getCidade_residencia());
            stm.setString(5, endereco.getEstado_residencia());

            int opt = stm.executeUpdate();

            if (opt != 0) {

                // capturando o ID do endereço salvo
                id_endereco = ler_id_endereco();

                // mensagem ao usuario
                JOptionPane.showMessageDialog(null, "Endereco salvo com sucesso", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // error
                JOptionPane.showMessageDialog(null, "Não foi possivel salvar este endereco", "Mensagem", JOptionPane.ERROR_MESSAGE);
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao salvar dados na tabela endereco\n" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConexaoBD.ConexaoDB.fecharConexao(con, stm);
        }

        return id_endereco;
    }

    /**
     * Metodo responsavel em ler o MAIOR id da tabela enderecos
     *
     * @return int id_end
     */
    public int ler_id_endereco() {

        int id_end = 0;
        try {
            String sql = "select max(id) from cadastro.tblenderecos";

            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                id_end = rs.getInt(1);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao ler dados na tabela endereco\n" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConexaoBD.ConexaoDB.fecharConexao(con, stm, rs);
        }

        return id_end;
    }

    /**
     * Metodo que responsavel em ler dados de um determinado endereco
     *
     * @param id_selecionado
     * @return Enderecos_Model
     */
    public Enderecos_Model capturarDadosEndereco(String id_selecionado) {

        Enderecos_Model endereco = new Enderecos_Model();
        try {
            String sql = "select * from cadastro.tblenderecos where id=" + id_selecionado;

            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                endereco.setId_endereco(rs.getInt("id"));
                endereco.setNome_rua(rs.getString("endereco"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setComplemento(rs.getString("complemento"));
                endereco.setCidade_residencia(rs.getString("cidade"));
                endereco.setEstado_residencia(rs.getString("estado"));

            }

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na leitura dos dados na tabela endereco\n" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConexaoBD.ConexaoDB.fecharConexao(con, stm, rs);
        }

        return endereco;
    }

    /**
     * Metodo que salva as alterações referente ao enderecos de usuarios
     *
     * @param endereco
     * @param id_endereco
     */
    public void salvarAlteracaoEndereco(Enderecos_Model endereco, int id_endereco) {

        try {
            String sql = "update cadastro.tblenderecos set endereco=?, bairro=?, complemento=?, cidade=?, estado=? where id=" + id_endereco;

            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);

            stm.setString(1, endereco.getNome_rua());
            stm.setString(2, endereco.getBairro());
            stm.setString(3, endereco.getComplemento());
            stm.setString(4, endereco.getCidade_residencia());
            stm.setString(5, endereco.getEstado_residencia());

            int ret = stm.executeUpdate();

            if (ret != 0) {
                // mensagem ao usuario
                JOptionPane.showMessageDialog(null, "Endereco foi atualizado com sucesso", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // error
                JOptionPane.showMessageDialog(null, "Não foi possivel atualizar este endereco", "Mensagem", JOptionPane.ERROR_MESSAGE);
            }
        } catch (HeadlessException | SQLException e) {
            // error
            JOptionPane.showMessageDialog(null, "Erro na tentativa de atualizar dados do endereco\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConexaoBD.ConexaoDB.fecharConexao(con, stm);
        }
    }

    /**
     * Metodo que faz captura de dados referente a tabela enderecos
     *
     * @param descricao
     * @return List<Enderecos_Model>
     */
    public List<Enderecos_Model> Localizar_Enderecos(String descricao) {
        List<Enderecos_Model> lista_enderecos = new ArrayList<>();

        try {
            String sql = "select * from cadastro.tblenderecos where endereco like '%" + descricao + "%'";
            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                Enderecos_Model end = new Enderecos_Model();
                
                end.setId_endereco(rs.getInt("id"));
                end.setBairro(rs.getString("bairro"));
                end.setCidade_residencia(rs.getString("cidade"));
                end.setComplemento(rs.getString("complemento"));
                end.setEstado_residencia(rs.getString("estado"));
                end.setNome_rua(rs.getString("endereco"));

                lista_enderecos.add(end);
            }
        } catch (SQLException e) {
            // error
            JOptionPane.showMessageDialog(null, "Erro na tentativa leitura da tabela enderecos\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConexaoBD.ConexaoDB.fecharConexao(con, stm, rs);
        }
        return lista_enderecos;
    }
    
    
    
    /**
     * Metodo que faz captura de dados de um DETERMINADO ENDERECO para prencher formulario
     *
     * @param id_endereco
     * @return 
     */
    public Enderecos_Model Capturar_Endereco(int id_endereco) {
        Enderecos_Model end = new Enderecos_Model();

        try {
            String sql = "select * from cadastro.tblenderecos where id=" + id_endereco;
            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {

                end.setId_endereco(rs.getInt("id"));
                end.setBairro(rs.getString("bairro"));
                end.setCidade_residencia(rs.getString("cidade"));
                end.setComplemento(rs.getString("complemento"));
                end.setEstado_residencia(rs.getString("estado"));
                end.setNome_rua(rs.getString("endereco"));

            }
        } catch (SQLException e) {
            // error
            JOptionPane.showMessageDialog(null, "Erro na tentativa leitura da tabela enderecos\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConexaoBD.ConexaoDB.fecharConexao(con, stm, rs);
        }
        return end;
    }
}
