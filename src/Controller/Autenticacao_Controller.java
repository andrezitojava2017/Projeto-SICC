package Controller;

import DAO.Autenticacao_Dao;
import DAO.Selos_Dao;
import Model.Selos_Model;
import java.io.File;
import java.net.URISyntaxException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rh
 */
public class Autenticacao_Controller {

    /**
     * Metodo responsavel e gravar o nova autenticao e o ID do selo utilizado na
     * tabela autenticacao
     *
     * @param id_selo
     * @return
     */
    public int gravarAutenticacao(int id_selo) {

        int ret;

        Autenticacao_Dao salvar = new Autenticacao_Dao();
        ret = salvar.gravarAutenticacao(id_selo);

        return ret;
    }
    
    /**
     * Metodo utilizado para capturar informações da tabela autenticações para
     * mostrar na tela de Impressao de autenticação os selos não impressos e ja
     * impressos
     *
     * @param sql
     * @return
     */
    public List<Selos_Model> buscar_autenticacao(String sql) {

        Selos_Dao dao = new Selos_Dao();
        List<Selos_Model> autenticacoes = dao.buscar_selos_por_ato(sql);

        return autenticacoes;
    }
}
