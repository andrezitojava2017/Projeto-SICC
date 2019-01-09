/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Localizar_Pessoas_Dao;
import Model.Pessoas_Model;
import java.util.List;

/**
 *
 * @author Andre
 */
public class Localizar_Contraentes_Controller {
    
    /**
     * Metodo que faz a chamada do objeto DAO para acessar o banco de dados com a sql informada como parametro 
     * @param sql string com a SQL informada
     * @return List<Pessoas_Model>
     */
    public List<Pessoas_Model> buscarPessoasCasamento(String sql){
        
        //list de objetos do tipo Pessoas_model
        List<Pessoas_Model> contraentes;
        
        // instanciando objeto tipo DAO para acesso ao BD
        Localizar_Pessoas_Dao buscar = new Localizar_Pessoas_Dao();
        
        // capturando retorno do metodos buscarContraentes
        contraentes = buscar.buscarContraentes(sql);
        
        return contraentes;
    }
    
    
    /**
     * Metodo que ira capturar dados referente a pessoas, podendo ser na tablea marido, esposa ou testemunhas
     * utilizado para preencher campos do formulario de casamento
     * @param sql String
     * @return Pessoas_Model
     */
    public Pessoas_Model capturarDadosPessoa(String sql){
       
        Localizar_Pessoas_Dao cptDados = new Localizar_Pessoas_Dao();
        Pessoas_Model pessoa = cptDados.localizarPessoas(sql);
        
        return pessoa;
    }
    
    /**
     * Metodo que faz a leitura de todos os dados de uma testemunha
     * retornando um objeto tipo Pessoas_Model, utilizado para preencher a tabela Localizar - form casamento
     * @param sql
     * @return 
     */
    public Pessoas_Model capturarDadosTestemunha(String sql){
        
        
        Localizar_Pessoas_Dao bscarTest = new Localizar_Pessoas_Dao();
        
        Pessoas_Model dadosTest = bscarTest.localizarTestemunha(sql);
        
        return dadosTest;
    }
}
