package Controller;

import DAO.Localizar_Pessoas_Dao;
import Model.Pessoas_Model;
import java.util.List;

/**
 *
 * @author rh
 */
public class Localizar_Controller {


    /**
     * Metodo que ira chamaar a classe Dao para capturar dados da tabela pessoas pelo SEXO
     *
     * @param dadoPesquisa
     * @return Pessoas_Model
     */
    public List<Pessoas_Model> LocalizardadosPessoa(String dadoPesquisa, String condicao) {
        List<Pessoas_Model> dados;
        Localizar_Pessoas_Dao localizar = new Localizar_Pessoas_Dao();

        dados = localizar.capturarDadosPessoa(dadoPesquisa, condicao);

        return dados;
    }

    /**
     * Metodo que ira chamaar a classe Dao para capturar dados da tabela registrando
     *
     * @param dadoPesquisa
     * @return Pessoas_Model
     */
    public List<Pessoas_Model> pesquisarDadosRegistrando(String dadoPesquisa) {
        List<Pessoas_Model> dados;
        Localizar_Pessoas_Dao localizar = new Localizar_Pessoas_Dao();

        dados = localizar.pesquisarRegistrando(dadoPesquisa);

        return dados;
    }
    
    
    /**
     * Metodo que ira chamaar a classe Dao para capturar dados da tabela Pessoas, esse
     * é utilizado no preenchimento de informações no formulario de testemunhas(Processo casamento)
     *
     * @param dadoPesquisa
     * @return Pessoas_Model
     */
    public List<Pessoas_Model> Buscar_Pessoa_testemunha(String dadoPesquisa) {
        List<Pessoas_Model> dados;
        Localizar_Pessoas_Dao localizar = new Localizar_Pessoas_Dao();

        dados = localizar.Capturar_Dados_Pessoa(dadoPesquisa);

        return dados;
    }

    /**
     * Metodo que faz a capturada de informaações de determinada pessoa
     * selecionada na tela de Localizar pessoas, utilizado para preencher
     * formularios
     *
     * @param id_pessoa_selecionada
     * @return Pessoas_Model
     */
    public Pessoas_Model capturarDadosPessoaSelecionada(String id_pessoa_selecionada) {
        Localizar_Pessoas_Dao pessoas = new Localizar_Pessoas_Dao();
        Pessoas_Model dadosPessoa;

        dadosPessoa = pessoas.capturarPessoaSelecionada(id_pessoa_selecionada);

        return dadosPessoa;
    }

}
