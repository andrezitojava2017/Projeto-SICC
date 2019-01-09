/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Pessoas_Dao;
import Model.Pessoas_Model;
import javax.swing.JOptionPane;

/**
 *
 * @author Andre
 */
public class AberturaAssinatura_Controller {

    public void verificarCamposPreenchidos(Pessoas_Model usuario) {

        // boolean retorno = false;
        // verificando se os valores capturados nao estao em brancos
        if (usuario.getNome() == null || usuario.getDocIdentidade() == null || usuario.getDataExpedicao() == null || usuario.getOrgaoExpeditor() == null || usuario.getCpf() == null || usuario.getNacionalidade() == null || usuario.getNascimento() == null || usuario.getPai() == null || usuario.getMae() == null || usuario.getEndereco() == null || usuario.getBairro() == null || usuario.getComplemento() == null || usuario.getCidade() == null || usuario.getEstado() == null) {

            // msge erro
            JOptionPane.showMessageDialog(null, "Verifique se todos os campos estão preenchidos", "Atenção ", JOptionPane.ERROR_MESSAGE);

        } else {

            int opt = JOptionPane.showConfirmDialog(null, "Confirma a inclusao de novo ficha de assinatura?", "Confirmação", JOptionPane.YES_NO_OPTION);

            if (opt == 0) {
                
                // instanceia objeto para chamar metodo que faz a gravacao dos dados na tabela pessoa
                Pessoas_Dao novoUsuario = new Pessoas_Dao();
                novoUsuario.gravarPessoas(usuario);

            } else {
                
                  JOptionPane.showMessageDialog(null, "Não foi possivel a gravação dos dados de : " + usuario.getNome() + ", na base de dados") ;                
            }

            //retorno = true;
        }

    }

}
