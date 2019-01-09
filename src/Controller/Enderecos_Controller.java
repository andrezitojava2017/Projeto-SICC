/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Enderecos_Dao;
import Model.Enderecos_Model;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Andre
 */
public class Enderecos_Controller {

    /**
     * Metodo responsavel em salvar novo endereco na tabela referente a
     * ENDEREÇOS
     *
     * @param novo_endereco int
     * @return int id_endereco
     */
    public int salvar_Endereco(Enderecos_Model novo_endereco) {

        int id_endereco = 0;
        // instanciando objeto DAO
        Enderecos_Dao novo = new Enderecos_Dao();

        // passando como parametro os dados do novo endereco
        // e capturando o ID de retorno
        id_endereco = novo.salvarEndereco(novo_endereco);

        return id_endereco;
    }

    /**
     * Metodo que ira ler dados da tabela enderecos
     *
     * @param id_selecionado
     * @return
     */
    public Enderecos_Model capturarDadosEndereco(String id_selecionado) {

        Enderecos_Model endereco;
        Enderecos_Dao dadosEnd = new Enderecos_Dao();

        endereco = dadosEnd.capturarDadosEndereco(id_selecionado);

        return endereco;
    }

    /**
     * Metodo que atualiza dados do endereço
     *
     * @param endereco
     * @param id_endereco
     */
    public void salvarAlteracaoEndereco(Enderecos_Model endereco, int id_endereco) {
        Enderecos_Dao dao = new Enderecos_Dao();
        dao.salvarAlteracaoEndereco(endereco, id_endereco);
    }

    
    /**
     * Metodo que faz a captura de enderecos da base de dados
     * @param descricao
     * @return 
     */
    public List<Enderecos_Model> Buscar_Endereco(String descricao){
        List<Enderecos_Model> lista_end = new ArrayList<>();
        
        Enderecos_Dao dao = new Enderecos_Dao();
        lista_end = dao.Localizar_Enderecos(descricao);
        
        return lista_end;
    }
    
    
    /**
     * Metodo utilizado para preencher formularios com dados do enderecos selecionado 
     * na janela de Localizar_Enderecos_View
     * @param id_endereco
     * @return 
     */
    public Enderecos_Model Preenche_Formulario_Enderecos(int id_endereco){
        Enderecos_Dao dao = new Enderecos_Dao();
        Enderecos_Model endereco = dao.Capturar_Endereco(id_endereco);
        
        return endereco;
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    /**
     * METODO NOVO
     * @param novo_endereco
     * @return 
     */
    public int inserir_Novo_Endereco(Enderecos_Model novo_endereco) {
        int id_endereco = 0;
        
        if (novo_endereco.getBairro().isEmpty() || novo_endereco.getCidade_residencia().isEmpty() || novo_endereco.getComplemento().isEmpty() || novo_endereco.getEstado_residencia().isEmpty() || novo_endereco.getNome_rua().isEmpty()) {

            // mensagem de erro
            JOptionPane.showMessageDialog(null, "Atenção verifique se todos os campos referente ao ENDEREÇO estão preenchidos", "Campos não preenchidos", JOptionPane.ERROR_MESSAGE);

        } else {
            // instanciando objeto DAO
            Enderecos_Dao novo = new Enderecos_Dao();

            // passando como parametro os dados do novo endereco
            // e capturando o ID de retorno
            id_endereco = novo.salvarEndereco(novo_endereco);
        }

        return id_endereco;
    }
}
