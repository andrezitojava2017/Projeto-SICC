/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Obitos_Dao;
import Model.Certidao_Model;
import Model.Obitos_Model;
import Model.Pessoas_Model;

/**
 *
 * @author Andre
 */
public class Obito_Controller {
    
    /**
     * Inserir novo regisro de obito na base de dados
     * @param id_falecido
     * @param dados_obito
     * @param certidao
     * @param id_selo 
     * @return  
     */
    public int gravar_novo_obito(int id_falecido, Obitos_Model dados_obito, Certidao_Model certidao, int id_selo) {
        
        int id_ato = 0;
        Obitos_Dao dao = new Obitos_Dao();
        id_ato = dao.gravar_novo_obito(id_falecido, dados_obito, certidao, id_selo);
        
        return id_ato;
    }
    
    
    /**
     * Metodo para inserir uma nova pessoa falecida na base de dados
     * @param falecido
     * @param obito
     * @param id_endereco
     * @return 
     */
    public int gravar_novo_pessoa_falecida(Pessoas_Model falecido, Obitos_Model obito, int id_endereco){
        int id_falecido = 0;
        
        Obitos_Dao dao = new Obitos_Dao();
        id_falecido = dao.gravar_novo_pessoa_falecido(falecido, obito, id_endereco);
        
        return id_falecido;
    }
}
