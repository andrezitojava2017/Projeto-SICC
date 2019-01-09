/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Abertura_Assinaturas_Dao;
import DAO.Autenticacao_Dao;
import DAO.Lancamento_Dao;
import DAO.Lancamentos_Dao;
import DAO.Reconhecer_Assinatura_Dao;
import Model.Lancamento_Model;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andre
 */
public class Lancamento_Controller {

    /**
     * Metodo que salva os lançamentos de novos atos realizados na serventia
     *
     * @param id_selo
     * @param codigo_ato
     * @param descricao
     * @param custo_ato
     * @param id_ato
     */
    public void salvarNovoLancamento(int id_selo, int codigo_ato, String descricao, double custo_ato, int id_ato) {

        Lancamento_Dao dao = new Lancamento_Dao();
        dao.salvarLancamento(id_selo, codigo_ato, descricao, custo_ato, id_ato);

    }

    /**
     * Metodo que faz a busca de todos os registro na tabela lancamentos
     * utilizado para preencher a tabela de consulta de lancamentos
     *
     * @param sql_busca
     * @return
     */
    public List<Lancamento_Model> buscar_lancamento(String sql_busca) {

        List<Lancamento_Model> lancamentos = new ArrayList<>();
        Lancamentos_Dao dao = new Lancamentos_Dao();
        lancamentos = dao.buscar_lancamentos(sql_busca);

        return lancamentos;
    }

    /**
     * Metodo utilizado para preencher a tabela descricao vinculo da view
     * Lancamentos
     *
     * @param id_ato
     * @return
     */
    public List<Object> buscar_vinculos_ato_reconhecimeto_firma(String id_ato) {

        List<Object> dadosColetados = new ArrayList<>();

        Reconhecer_Assinatura_Dao dao = new Reconhecer_Assinatura_Dao();
        dadosColetados = dao.capturar_dados_pessoa_vinculada(id_ato);

        return dadosColetados;
    }

    /**
     * Metodo utilizado para preencher a tabela descricao vinculo da view
     * Lancamentos
     *
     * @param id_ato
     * @return
     */
    public List<Object> buscar_vinculos_ato_autenticacao(String id_ato) {

        List<Object> dadosColetados = new ArrayList<>();

        Autenticacao_Dao dao = new Autenticacao_Dao();
        dadosColetados = dao.capturar_dados_autenticacao_vinculada(id_ato);

        return dadosColetados;
    }

    /**
     * Metodo utilizado para preencher a tabela descricao vinculo da view
     * Lancamentos
     *
     * @param id_ato
     * @return
     */
    public List<Object> buscar_vinculos_ato_abertura_assinatura(String id_ato) {

        List<Object> dadosColetados = new ArrayList<>();

        Abertura_Assinaturas_Dao dao = new Abertura_Assinaturas_Dao();
        dadosColetados = dao.buscar_pessoa_vinculada_ato_abertura(id_ato);

        return dadosColetados;
    }

}
