/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConexaoBD.ConexaoDB;
import Controller.Principal_Controller;
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
public class Login_Dao {

    Connection con;
    PreparedStatement stm;
    ResultSet rs;

    /**
     *  metodo que faz a autenticação de usuarios
     * @param usuario
     * @param senha  
     * @return   
     */
    public boolean Autenticar(String usuario, String senha) {
        
        boolean autorizar = false;
        
        //instancia objeto camada Model
        Permissoes_Model prmAutorizado = new Permissoes_Model();
        
        String sql = "select*from cadastro.tbusuarios where login=? and senha=?";
        int id_permissao;

        try {

            con = ConexaoDB.getconection();
            stm = con.prepareStatement(sql);

            // As linhas abaixo pega os valores dos campos de usuario e senha
            // e atribui ao login e senha da linha sql
            stm.setString(1, usuario);
            stm.setString(2, senha);

            rs = stm.executeQuery();

            if (rs.next()) {
                
                // indica que esta autorizado a acessar a tela principal
                autorizar = true;
                
                //obtendo o conteudo da coluna permissao, que na posicao 6 na tabela usuarios;
                id_permissao = rs.getInt(6);
                
                // instanciando objeto Dao para acessar metodos DAO
                Permissao_Dao prmUsuario = new Permissao_Dao();
                
                // atributo que armazena o retorno do metodo
                prmAutorizado = prmUsuario.lerPermissoesUsuario(id_permissao);
                               
                // abrindo a tela principal
                Principal_Controller verifcarPermissoes = new Principal_Controller();
                verifcarPermissoes.abrirTelaPrincipal(prmAutorizado);

            } else {
                JOptionPane.showMessageDialog(null, "Usuario ou senha invalida!");

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar ler tabela Usuarios\n " + ex);
        }

       return autorizar;
    }

}
