/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Ficha_Assinatura_Dao;
import Model.Ficha_Assinatura_Model;

/**
 *
 * @author Andre
 */
public class Ficha_Assinatura_Controller {

    /**
     * Metodo que faz a gravação na tabela ficha de assinatura
     *
     * @param id_pessoa
     * @param ficha
     */
    public int Salvar_Nova_Ficha_Assinatura(int id_pessoa, Ficha_Assinatura_Model ficha) {

        int id_ficha = 0;
        // instanciando objeto DAO
        Ficha_Assinatura_Dao nova_ficha = new Ficha_Assinatura_Dao();

        // chamando metodo que ira salvar a nova ficha, e
        // capturando o retorno do metodo com o ID da nova ficha
        id_ficha = nova_ficha.Salvar_Nova_Ficha(id_pessoa, ficha);

        return id_ficha;
    }

    /**
     * Metodo que faz a captura de ficha de uma determinada pessoa
     * @param id_pessoa
     * @return ficha_numero
     */
    public int Capturar_Sequencia_Ficha_Assinatura(int id_pessoa) {

        int ficha_numero = 0;
        
        // instanciando objeto DAO
        Ficha_Assinatura_Dao nova_ficha = new Ficha_Assinatura_Dao();

        // chamando metodo que ira ler a  ficha
        ficha_numero = nova_ficha.Capturar_Sequencia_Ficha(id_pessoa);

        return ficha_numero;
    }
    
    /**
     * Metodo que captura todos os campos da tabela ficha de assinatura
     * @param id_pessoa
     * @return Ficha_Assinatura_Model
     */
    public Ficha_Assinatura_Model Capturar_Dados_Ficha_Assinatura(int id_pessoa){
        // instanciando objeto de retorno
        Ficha_Assinatura_Model ficha = new Ficha_Assinatura_Model();
        
        // instanciando objeto DAO
        Ficha_Assinatura_Dao capturar_ficha = new Ficha_Assinatura_Dao();
        
        // capturando as informações de um dterminada pessoa
        ficha = capturar_ficha.Capturar_Dados_Ficha_Assinatura(id_pessoa);
        
        return ficha;
    }
}
