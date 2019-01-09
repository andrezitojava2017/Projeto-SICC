/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Localizar_Pessoas_Dao;
import DAO.Reconhecer_Assinatura_Dao;
import DAO.Selos_Dao;
import Model.Pessoas_Model;
import Model.Selos_Model;
import java.util.List;

/**
 *
 * @author Andre
 */
public class Reconhecer_Assinatura_Controller {

    /**
     * Gravar reconhecimento na tabela Reconhecimento de assinatura
     *
     * @param id_Pessoa
     * @param id_selo
     * @param tipo_assinatura
     * @return
     */
    public int Gravar_reconhecimento_assinatura(int id_Pessoa, int id_selo, String tipo_assinatura) {
        int retorno = 0;
        Reconhecer_Assinatura_Dao dao = new Reconhecer_Assinatura_Dao();
        retorno = dao.gravar_reconhecimento_assinatura(id_Pessoa, id_selo, tipo_assinatura);

        return retorno;
    }

    /**
     * Metodo que faz a captura dos todos os selos que foram utilizados no ato 
     * de reconhecimento de assinatura.
     * Preenchendo a tabela de impressao
     * @param sql
     * @return 
     */
    public List<Selos_Model> buscar_selos_utilizado_recon_firma(String sql) {

        Selos_Dao dao = new Selos_Dao();
        List<Selos_Model> info_selos = dao.buscar_selos_por_ato(sql);
        
        return info_selos;
    }
    
    /**
     * Metodo utilizado para buscar uma determinada pessoa vinculada
     * ao ato de reconhecimento de assinatura
     * preenche a tabela pessoas da View Imprimir_Recon_Assinatura
     * @param id_selo
     * @return 
     */
    public List<Pessoas_Model> buscar_pessoa_recon_firma(String id_selo){
        
        Localizar_Pessoas_Dao dao = new Localizar_Pessoas_Dao();
        List<Pessoas_Model>dados = dao.buscar_pessoa(id_selo);
        
        return dados;
    }
    
    /**
     * Metodo utilizado para capturar dados de um determinado selo escolhido para preencher
     * a tabela selos_selecionados da View Imprimir_Recon_assinatura
     * @param sql
     * @return 
     */
    public Selos_Model preencher_tabela_selos_selecionados(String sql){
        
        Selos_Dao dao = new Selos_Dao();
        Selos_Model selo_selecionado = dao.capturar_info_selos_selecionado(sql);
        
        return selo_selecionado;
    }
}
