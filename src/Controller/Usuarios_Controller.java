/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Permissao_Dao;
import DAO.Usuarios_Dao;
import Model.Permissoes_Model;
import Model.Usuarios_Model;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author rh
 */
public class Usuarios_Controller {

    /**
     * Metodo que verifica se todos os campos foram preenchidos e se as pelo
     * menos uma permissao foi concedida
     *
     * @param user
     * @return
     */
    public boolean verificar(Usuarios_Model user) {
        boolean retorno = false;

        if (user.getNome().isEmpty() || user.getCargo().isEmpty() || user.getLogin().isEmpty() || user.getSenha().isEmpty() || user.getSituacao().isEmpty()) {

            // msge ERRO        
            JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Atenção", JOptionPane.ERROR_MESSAGE);

        } else {

            retorno = true;
        }

        return retorno;
    }

    /**
     * Metodo que faz a gravacado do novo usuario na tabela usuarios
     *
     * @param ret_user
     * @param ret_perm
     * @param permissao
     * @param user
     */
    public void gravarUsuario(boolean ret_user, boolean ret_perm, Permissoes_Model permissao, Usuarios_Model user) {

        // instanciando objeto da camada DAO
        Permissao_Dao gravar_permissao = new Permissao_Dao();
        Usuarios_Dao gravar_usuario = new Usuarios_Dao();

        // v erifica os parametros recebidos
        if (ret_user == true && ret_perm == true) {

            // exibe a mensagem de confirmação ao usuario
            int opt = JOptionPane.showConfirmDialog(null, "Confirma a inclusao deste usuario?", "Confirmação ", JOptionPane.YES_NO_OPTION);

            // verifica a opt escolhida pelo usuario
            if (opt == 0) {

                // SIM
                // chamamos o metodo que grava as permissoes e retorna o ID da mesma
                int id_permissao = gravar_permissao.gravarPermissao(permissao);

                // inserção ocorrer tudo bem iniciamos  a gravação do novo usuario na tabela usuarios
                if (id_permissao != 0) {

                    // gravaçao do usuario na tabela usuarios
                    boolean confirma = gravar_usuario.InserirNovoUsuario(user, id_permissao);

                    if (confirma == true) {

                        // mensagem
                        JOptionPane.showMessageDialog(null, "Usuario " + user.getNome() + " foi inserido com sucesso", "Mensagem", JOptionPane.INFORMATION_MESSAGE);

                    } else {

                        // mensagem de erro
                        JOptionPane.showMessageDialog(null, "Não foi possivel inserir novo usuario", "Atenção", JOptionPane.INFORMATION_MESSAGE);

                    }

                }

            }

        } else {

            // mensaem de NÃO GRAVAÇÃO
            JOptionPane.showMessageDialog(null, "Inserção não concluida", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Metodo que le os usuarios cadastrados
     *
     * @return usuarios
     */
    public List<String> lerUsuarios() {

        Usuarios_Dao lerUser = new Usuarios_Dao();
        List<String> usuarios = lerUser.lerUsuarios();

//        for (String usuario : usuarios) {
//            System.out.println(usuario);
//        }
        return usuarios;
    }

    /**
     * METODO QUE IRA LER O ID REFERENTE A PERMISSAO DESTE USUARIO
     *
     * @param nome_user
     * @return
     */
    public int lerIdPermissao(String nome_user) {

        int id_retorno = 0;

        Usuarios_Dao user = new Usuarios_Dao();
        id_retorno = user.lerIdPermissaoUsuario(nome_user);

        return id_retorno;
    }

    /**
     * Metodo q captura todos os dados da tabela usuarios
     *
     * @param nomeUser
     * @return Usuarios_Model
     */
    public Usuarios_Model capturarDadosLogin(String nomeUser) {

        Usuarios_Dao capt = new Usuarios_Dao();

        Usuarios_Model dados = capt.capturarUsuarios(nomeUser);

        return dados;
    }

    /**
     * Metodo responsavel em atualizar dados do usuario
     *
     * @param prm
     * @param usuario
     */
    public void atualizarUsuarios(boolean prm, Usuarios_Model usuario) {

        // instanciando objeto DAO
        Usuarios_Dao atualizar = new Usuarios_Dao();

        // verifica se a permissao foi inserida
        if (prm == true) {

            // capturando o retorno do metodo q atualiza o usuario
            boolean retorno_dao = atualizar.atualizarDadosUsuario(usuario);
            
            // verifica se os dados do usuario foi atualizado
            if (retorno_dao == true) {

                // exibe a mensagem
                JOptionPane.showMessageDialog(null, "Atualização do usuario " + usuario.getNome() + " realizada com sucesso", "Mensagem", JOptionPane.INFORMATION_MESSAGE);

            }

        } else {

            // caso a permissao nao foi atualizada
            JOptionPane.showMessageDialog(null, "Não foi possivel a atualização, verifique", "Atenção", JOptionPane.ERROR_MESSAGE);

        }

    }
}
