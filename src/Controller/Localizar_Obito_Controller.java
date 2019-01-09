/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Localizar_Obito_Dao;
import Model.Pessoas_Model;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andre
 */
public class Localizar_Obito_Controller {

    /**
     * Metodo para buscar na tabela de falecidos, dados de um determinado obito
     * salvo na base de dados Preenche a tabela da View Localizar Falecido
     *
     * @param nome
     * @return
     */
    public List<Pessoas_Model> buscar_pessoa_falecida(String nome) {

        List<Pessoas_Model> falecidos = new ArrayList<>();

        Localizar_Obito_Dao pessoa = new Localizar_Obito_Dao();
        falecidos = pessoa.capturar_dados_pessoa_falecida(nome);

        return falecidos;
    }

    /**
     * Metodo que captura informações de um determinado obito selecionado da
     * tabela da View Localizar_Obitos
     *
     * @param id_selecionado
     * @return
     */
    public List<Object> capturar_dados_obito(int id_selecionado) {
        Localizar_Obito_Dao dao = new Localizar_Obito_Dao();
        List<Object> dados_falecido = dao.caputrar_dados_falecido(id_selecionado);

        return dados_falecido;
    }

    /**
     * Metodo que captura informações de um falecido
     *
     * @param id_selecionado
     * @return
     */
    public Object[] pessoa_falecida(int id_selecionado) {

        Object dados_registro[] = new Object[3];

        Localizar_Obito_Dao pessoa = new Localizar_Obito_Dao();
        dados_registro = pessoa.dados_pessoa_falecida(id_selecionado);

        return dados_registro;
    }

    /**
     * Metodo utilizado para capturar dados de um determinado falecido
     * para preencher os campos do formulario para alterar obitos
     * @param id_falecido
     * @return 
     */
    public Object[] dados_falecido(int id_falecido) {

        Localizar_Obito_Dao dao = new Localizar_Obito_Dao();

        Object dados_falecido[] = dao.dados_pessoa_falecida(id_falecido);

        return dados_falecido;
    }
}
