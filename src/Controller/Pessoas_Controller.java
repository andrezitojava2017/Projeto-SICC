package Controller;

import DAO.Pessoas_Dao;
import Model.Pessoas_Model;
import javax.swing.JOptionPane;

/**
 *
 * @author Andre
 */
public class Pessoas_Controller {

    /**
     * metodo que ira capturar a ultima ficha, que sera incrementada e ira
     * retornar o valor da proxima ficha a ser utilizada
     *
     * @return numero_ficha
     */
//    public int ultimaFicha(){
//        
//        int numero_ficha = 0;
//        
//        Pessoas_Dao captFicha = new Pessoas_Dao();
//        numero_ficha = captFicha.LerFicha();
//        
//        numero_ficha++;
//        
//        return numero_ficha;
//    }
    /**
     * Metodo responsavel em chamar classe Dao para salvar alterações
     *
     * @param dadosAlterar
     * @param id_pessoa
     */
    public void salvarAlteracao(Pessoas_Model dadosAlterar, int id_pessoa) {

        int opt = JOptionPane.showConfirmDialog(null, "Confirma a atualização de informações do(a) Sr(a). " + dadosAlterar.getNome() + " ?", "Confirmação", JOptionPane.YES_NO_OPTION);

        if (opt == 0) {
            // instanciamento de objeto DAO
            Pessoas_Dao alterar = new Pessoas_Dao();

            // armazenar retorno do metodo salvarAlteracao
            alterar.salvarAlteracao(dadosAlterar, id_pessoa);

        } else {
            JOptionPane.showMessageDialog(null, "As informações do(a) Sr(a). " + dadosAlterar.getNome() + " não foram alteradas", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    /**
     * Metodo que faz a gravação de uma nova pessoa na base de dados
     *
     * @param pessoa
     * @param id_endereco
     * @param id_certidao
     * @return int id_pessoa
     */
    public int gravarNovaPessoa(Pessoas_Model pessoa, int id_endereco, int id_certidao) {

        int id_pessoa = 0;

        Pessoas_Dao dao = new Pessoas_Dao();
        id_pessoa = dao.gravarDadosPessoas(pessoa, id_endereco, id_certidao);

        return id_pessoa;
    }

    /**
     * Metodo que faz a gravação de uma nova pessoa na base de dados
     *
     * @param pessoa
     * @param id_endereco
     * @return int id_pessoa
     */
    public int gravarNovaPessoa(Pessoas_Model pessoa, int id_endereco) {

        int id_pessoa = 0;

        Pessoas_Dao dao = new Pessoas_Dao();
        id_pessoa = dao.gravarDadosPessoas(pessoa, id_endereco);

        return id_pessoa;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * METODO NOVO
     *
     * @param pessoa
     * @param id_endereco
     * @param id_certidao
     * @return
     */
    public int Inserir_Novo_Cadastro_Pessoa(Pessoas_Model pessoa, int id_endereco, int id_certidao) {

        int id_pessoa = 0;

        //verificando os cmpos foram todos preenchidos
        if (pessoa.getNome().isEmpty() || pessoa.getNacionalidade().isEmpty() || pessoa.getEst_civil().isEmpty() || pessoa.getProfissao().isEmpty() || pessoa.getDocIdentidade().isEmpty() || pessoa.getOrgaoExpeditor().isEmpty() || pessoa.getCpf().isEmpty() || pessoa.getNascimento().isEmpty() || pessoa.getCidade_nasc().isEmpty() || pessoa.getEstado_nasc().isEmpty() || pessoa.getPai().isEmpty() || pessoa.getMae().isEmpty() || pessoa.getDataExpedicao().isEmpty() || pessoa.getSexo().isEmpty()) {

            //mensagem de erro
            JOptionPane.showMessageDialog(null, "Atenção os campos não estao todos preenchidos", "Campos não preenchidos", JOptionPane.ERROR_MESSAGE);

        } else {

            // mensagem de confirmação ao usuario
            int opt = JOptionPane.showConfirmDialog(null, "Confirma a inclusao de " + pessoa.getNome() + " ?", "Confirmação", JOptionPane.YES_NO_OPTION);

            if (opt == 0) {
                // inserção no banco de dados tabela noivo
                Pessoas_Dao dao = new Pessoas_Dao();
                id_pessoa = dao.gravarDadosPessoas(pessoa, id_endereco, id_certidao);
            } else {

                JOptionPane.showMessageDialog(null, "Não foi possivel salvar as informações", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        return id_pessoa;
    }

    /**
     * METODO NOVO
     *
     * @param pessoa
     * @param id_endereco
     * @return
     */
    public int Inserir_Novo_Cadastro_Pessoa(Pessoas_Model pessoa, int id_endereco) {

        int id_pessoa = 0;

        //verificando os cmpos foram todos preenchidos
        if (pessoa.getNome() == null || pessoa.getNacionalidade()== null || pessoa.getEst_civil()== null || pessoa.getProfissao()== null || pessoa.getDocIdentidade()== null || pessoa.getOrgaoExpeditor()== null || pessoa.getCpf()== null || pessoa.getNascimento()== null || pessoa.getCidade_nasc()== null || pessoa.getEstado_nasc()== null || pessoa.getPai()== null || pessoa.getMae()== null || pessoa.getDataExpedicao()== null || pessoa.getSexo()== null) {

            //mensagem de erro
            JOptionPane.showMessageDialog(null, "Atenção os campos não estao todos preenchidos", "Campos não preenchidos", JOptionPane.ERROR_MESSAGE);

        } else {

            // mensagem de confirmação ao usuario
            int opt = JOptionPane.showConfirmDialog(null, "Confirma a inclusao de " + pessoa.getNome() + " ?", "Confirmação", JOptionPane.YES_NO_OPTION);

            if (opt == 0) {
                // inserção no banco de dados tabela noivo
                Pessoas_Dao dao = new Pessoas_Dao();
                id_pessoa = dao.gravarDadosPessoas(pessoa, id_endereco);
            } else {

                JOptionPane.showMessageDialog(null, "Não foi possivel salvar as informações", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        return id_pessoa;
    }

    /**
     * Metodo NOVO Metodo que insere no cadastro de pessoa, o ID de uma certidao
     * - METODO UTILIZADO NO FORMULARIO DE PROCESSO DE CASAMENTO, QUANDO USUARIO
     * ESCOLHIDO ATRAVES DA BUSCA, NÃO POSSUI CERTIDAO VINCULADA
     *
     * @param id_certidao
     * @param id_pessoa
     * @return boolean retorno_metodo
     */
    public boolean Atualizar_Pessoa_Inserir_id_certidao(int id_certidao, int id_pessoa) {

        boolean retorno_metodo = false;
        
        // instanciamento de objeto DAO
        Pessoas_Dao alterar = new Pessoas_Dao();

        // armazenar retorno do metodo que atualiza a informação na tabela pessoas
        retorno_metodo = alterar.Atualizar_Pessoa_Inserir_id_certidao(id_certidao, id_pessoa);

        return retorno_metodo;
    }
}
