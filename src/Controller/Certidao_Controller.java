/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Certidao_Dao;
import Model.Certidao_Model;
import javax.swing.JOptionPane;

/**
 *
 * @author Andre
 */
public class Certidao_Controller {

    /**
     * Metodo responsavel em salvar dados da nova certidao
     *
     * @param certidao
     * @return int id_certidao
     */
    public int salvar_nova_certidao(Certidao_Model certidao) {

        int id_certidao = 0;

        // instanciando objeto DAO
        Certidao_Dao nova = new Certidao_Dao();

        // passando dados da certidao como parametro
        // capturando o ID da certidao
        id_certidao = nova.gravar_nova_certidao(certidao);

        return id_certidao;
    }

    /**
     * Metodo que ira ler dados de uma determinada certidao, para preenchimento
     * de formularios
     *
     * @param id_certidao
     * @return Certidao_Model
     */
    public Certidao_Model capturarDadosCertidao(String id_certidao) {

        Certidao_Dao certidao = new Certidao_Dao();
        Certidao_Model dadosCertidao = new Certidao_Model();

        dadosCertidao = certidao.capturarDadosCertidao(id_certidao);

        return dadosCertidao;
    }

    /**
     * Metodo para salvar atualizações em certidoes fornecidas por pessoas no
     * registro de nascimento
     *
     * @param cert
     * @param id_certidao
     */
    public void salvarAlteracaoCertidao(Certidao_Model cert, int id_certidao) {

        Certidao_Dao dao = new Certidao_Dao();
        dao.alterarDadosCertidaoPessoa(cert, id_certidao);

    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * METODO NOVO Metodo responsavel em salvar dados de uma certidao
     * apresentada por um cliente
     *
     * @param certidao
     * @return int id_certidao
     */
    public int Cadastrar_Nova_Certidao(Certidao_Model certidao) {

        int id_certidao = 0;

        if (certidao.getCidade_registro().isEmpty() || certidao.getEstado_reg().isEmpty() || certidao.getNome_cartorio().isEmpty()) {

            //mensagem de erro
            JOptionPane.showMessageDialog(null, "Atenção os campos referente a certidao não estao preenchidos", "Campos não preenchidos", JOptionPane.ERROR_MESSAGE);
        } else {
            //msge de confirmação
            int opt = JOptionPane.showConfirmDialog(null, "Confirma a inclusao desta certidao na base de dados?", "Confirmação", JOptionPane.YES_NO_OPTION);

            // verifica condicao escolhida
            if (opt == 0) {
                // instanciando objeto DAO
                Certidao_Dao nova = new Certidao_Dao();

                // passando dados da certidao como parametro
                // capturando o ID da certidao
                id_certidao = nova.gravar_nova_certidao(certidao);
            } else {
                //msge de confirmação
               JOptionPane.showMessageDialog(null, "Certidão não foi cadastrada na base de dados", "Mensagem", JOptionPane.YES_NO_OPTION);

            }
        }
        return id_certidao;
    }

}
