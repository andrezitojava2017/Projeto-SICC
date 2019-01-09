/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Casamento_Dao;
import javax.swing.JOptionPane;

/**
 *
 * @author Jederson Andre
 */
public class Casamento_Controller {


    /**
     * Metod responsavel em salvar o processo na base de dados
     * @param processo
     * @param edital
     * @param id_noivo
     * @param id_noiva
     * @param id_testemunha
     * @return 
     */
    public boolean salvarProcesso(int processo, int edital, int id_noivo, int id_noiva, int id_testemunha[]) {
        
        boolean ret = false;
        
        // verificando campos em brancos
        if (processo != 0 && edital != 0) {
            
            // agora que temos os IDs dos contraentes, das testemunhas e temos o numero do edital
            // vamos chamar o metodo para gravar os ddos na tabela processocasamento
            Casamento_Dao salvar = new Casamento_Dao();
            ret = salvar.gravarProcessoCasamento(processo, edital, id_noivo, id_noiva, id_testemunha);

        } else {

            // msg erro ao usuario
            JOptionPane.showMessageDialog(null, "Campos referente ao Processo estão vazios", "Erro", JOptionPane.ERROR_MESSAGE);

        }
        
        return ret;
    }
}
