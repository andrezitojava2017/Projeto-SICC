/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Permissao_Dao;
import Model.Permissoes_Model;
import javax.swing.JOptionPane;

/**
 *
 * @author rh
 */
public class Permissoes_Controller {
    
    /**
     * Metodo que verifica se as permissoes foram selecionadas
     * @param permissao
     * @return 
     */
    public boolean verificarPermissoes(Permissoes_Model permissao){
        
        boolean ret = false;
        
        if (permissao.getAbert_firma() == null && permissao.getAutenticacao()== null && permissao.getCert_casamento()== null && permissao.getCert_nascimento()== null && permissao.getCert_obito()== null && permissao.getAlterar_selo()== null && permissao.getNovo_user()== null && permissao.getProcuracao()== null && permissao.getRecon_firma()== null) {

            // msge ERRO
            JOptionPane.showMessageDialog(null, "Nenhuma PERMISSÃO foi selecionada, verifique", "Atenção", JOptionPane.ERROR_MESSAGE); 
            
        } else {
            ret = true;
        }
        return ret;
    }
    
    
    /**
     * Metodo que ir ler as permissoes de determinado ID
     * @param id
     * @return permissao Permissao_Model
     */
    public Permissoes_Model lerPermissaoUsuario(int id){
        Permissoes_Model permissao;
        
        Permissao_Dao ler = new Permissao_Dao();
        permissao = ler.lerPermissoesUsuario(id);
        
        return permissao;
    }
    
    
    /**
     * Metodo que ira chamar DAO para atualizar dados da permissao
     * @param prm
     * @param id_permissao
     * @return 
     */
    public boolean atualizarPerm(Permissoes_Model prm, int id_permissao){
        
        // atributo de retorno
        boolean ret;
        
        // instanciando objeto tipo DAO da classe permissoes
        Permissao_Dao permissao = new Permissao_Dao();
        
        // capturando retorno do metodo que atualiza as permissoes
        ret = permissao.atualizarPermissoes(prm, id_permissao);
        
        return ret;
    }
}
