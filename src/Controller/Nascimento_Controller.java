/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Localizar_Pessoas_Dao;
import DAO.Nascimento_Dao;
import Model.Certidao_Model;
import Model.Pessoas_Model;
import Model.Selos_Model;
import java.util.ArrayList;

/**
 *
 * @author Andre
 */
public class Nascimento_Controller {

    
//        /**
//     * Metodo responsavel em atualizar informações referent a pessoas da tabela PAI/MAE
//     * Sql define qual tabela sera atualizada
//     * @param pessoa
//     * @param sql_tabela 
//     */
//    public void atualizarDadosPessoas(Pessoas_Model pessoa,  String sql_tabela){
//        
//        Nascimento_Dao atualizar = new Nascimento_Dao();
//        
//        // chamando metodo DAO responsavel em salvar as alterações
//        // passamos como parametro a string sql que sera utilizada
//        atualizar.atualizarDadosPessoa(pessoa, sql_tabela);
//    }

    
    /**
     * Metodo responsavel em gravar o novo registrando
     * @param pessoa Pessoas_Model
     * @param certidao Certidao_Model
     * @return id_registrado int
     */
    public int gravarNovoRegistrando(Pessoas_Model pessoa, Certidao_Model certidao){
        int id_registrado;
        
        Nascimento_Dao gravar = new Nascimento_Dao();
        id_registrado = gravar.salvarRegistrando(pessoa, certidao);
        
        return id_registrado;
    }
    
    /**
     * Metodo que faz captura de informações da tabela registrando para preenchimento
     * dos campos da aba REGISTRANDO
     * @param id_selecionado
     * @return 
     */
    public ArrayList<Object> capturarDadosRegistrado(String id_selecionado){
        
       Nascimento_Dao buscar = new Nascimento_Dao();
        ArrayList<Object> dadosRegistrado = buscar.capturarDadosRegistrando(id_selecionado);
        
        return dadosRegistrado;
    }
    
    /**
     * Metodo responsavel em atualizar as informações da tabela registrando
     * @param id_selecionado String
     * @param pessoa Pessoas_Model
     * @param certidao Certidao_Model
     */
    public void atualizarDadosRegistrado(String id_selecionado, Pessoas_Model pessoa, Certidao_Model certidao){
        
        Nascimento_Dao atualizar = new Nascimento_Dao();
        atualizar.atualizarDadosRegistrado(id_selecionado, certidao, pessoa);
        
    }
    
    /**
     * Metodo utilizado simplesmente na busca de registrandos da base de dados
     * para preenchimento da tabela de tela localizar registrandos
     * @param nome_pesquisa
     * @return 
     */
    public ArrayList<Pessoas_Model> localizar_registrando(String nome_pesquisa){
        
        Nascimento_Dao dao = new Nascimento_Dao();
        ArrayList<Pessoas_Model> nomes = dao.localizar_registrando(nome_pesquisa);
        
        return nomes;
    }
    
    /**
     * Metodo responsavel em gravar certidao na tabela nascimento, quando o PAI ESTA PRESENTE
     * @param certidao
     * @param id_registrado
     * @param id_mae
     * @param id_pai
     * @param id_selo 
     * @return  
     */
    public int salvarCertidaoNascimento(Certidao_Model certidao, int id_registrado, int id_mae, int id_pai, int id_selo){

        int id_ato = 0;
        Nascimento_Dao salvarCertidao = new Nascimento_Dao();
        id_ato = salvarCertidao.salvarCertidaoNascimento(certidao, id_selo, id_mae, id_pai, id_registrado);
        
        return id_ato;
    }
    
        /**
     * Metodo responsavel em gravar certidao na tabela nascimento, quando o PAI NÃO ESTA PRESENTE
     * @param certidao
     * @param id_registrado
     * @param id_mae
     * @param id_selo 
     * @return  
     */
    public int salvarCertidaoNascimento(Certidao_Model certidao, int id_registrado, int id_mae, int id_selo){

        int id_ato =0;
        Nascimento_Dao salvarCertidao = new Nascimento_Dao();
        id_ato = salvarCertidao.salvarCertidaoNascimento(certidao, id_selo, id_mae, id_registrado);
        
        return id_ato;
    }
}
