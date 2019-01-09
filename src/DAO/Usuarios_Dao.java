package DAO;

import Model.Usuarios_Model;
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
 * @author rh
 */
public class Usuarios_Dao {

    Connection con;
    PreparedStatement stm;
    ResultSet rs;

    /**
     * Metodo responsavel em gravar novo usuario na tabela usuarios e suas
     * permissoes
     *
     * @param usuario
     * @param id_permissao
     * @return
     */
    public boolean InserirNovoUsuario(Usuarios_Model usuario, int id_permissao) {

        boolean retorno = false;

        try {

            String sql = "insert into cadastro.tbusuarios(nome, cargo, login, senha, permissao, situacao) values(?,?,?,?,?,?)";
            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);

            stm.setString(1, usuario.getNome());
            stm.setString(2, usuario.getCargo());
            stm.setString(3, usuario.getLogin());
            stm.setString(4, usuario.getSenha());
            stm.setInt(5, id_permissao);
            stm.setString(6, usuario.getSituacao());

            int confirma = stm.executeUpdate();

            if (confirma != 0) {

                retorno = true; // linha inserida

            }

            return retorno;
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }

    /**
     * Metodo que le nomes da tabela usuarios
     *
     * @return Lista<String>;
     */
    public List<String> lerUsuarios() {
        List<String> usuarios = new ArrayList<>();
        ArrayList<String> nomes = new ArrayList<>();

        try {
            String sql = "select nome from cadastro.tbusuarios";

            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                usuarios.add(rs.getString("nome"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Usuarios_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }

    /**
     * Metodo responsavel em capturar as permissoes de determinado usuario
     *
     * @param nomeUsuario
     * @return
     */
    public int lerIdPermissaoUsuario(String nomeUsuario) {

        int id_selecionado = 0;

        try {
            String sql = "select permissao from cadastro.tbusuarios where nome = '" + nomeUsuario + "'";

            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                id_selecionado = rs.getInt(1);
            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi possivel capturar o ID da permisao deste usuario", "Atenção", JOptionPane.ERROR_MESSAGE);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel capturar o ID da permisao deste usuario", "Atenção", JOptionPane.ERROR_MESSAGE);
        }

        return id_selecionado;
    }

    /**
     * Metodo responsavel em capturar todos o dados referente a cadastro de
     * usuario
     *
     * @param nomeUsuario
     * @return Usuarios_Model
     */
    public Usuarios_Model capturarUsuarios(String nomeUsuario) {

        Usuarios_Model dados = new Usuarios_Model();

        try {
            String sql = "select * from cadastro.tbusuarios where nome = '" + nomeUsuario + "'";

            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                dados.setId_user(rs.getInt("id"));
                dados.setNome(rs.getString("nome"));
                dados.setCargo(rs.getString("cargo"));
                dados.setLogin(rs.getString("login"));
                dados.setSenha(rs.getString("senha"));
                dados.setSituacao(rs.getString("situacao"));
            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi possivel fazer a leitura do usuario na base de dados", "Atenção", JOptionPane.ERROR_MESSAGE);

        }

        return dados;
    }

    /**
     * Metodo responsavel em fazer a atualização de dados do usuario no banco de
     * dados
     *
     * @param usuario
     * @return
     */
    public boolean atualizarDadosUsuario(Usuarios_Model usuario) {

        boolean retAtualizacao = false;

        try {
            String sql = "update cadastro.tbusuarios set nome=?, cargo=?, login=?, senha=?, situacao=? where id='" + usuario.getId_user() + "'";

            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);

            stm.setString(1, usuario.getNome());
            stm.setString(2, usuario.getCargo());
            stm.setString(3, usuario.getLogin());
            stm.setString(4, usuario.getSenha());
            stm.setString(5, usuario.getSituacao());

            int ret = stm.executeUpdate();

            if (ret != 0) {

                retAtualizacao = true;

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi possivel atulizar dados deste usuario", "Atenção", JOptionPane.ERROR_MESSAGE);

        }

        return retAtualizacao;
    }
}
