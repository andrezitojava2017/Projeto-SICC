/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

/**
 *
 * @author rh
 */
public class Casamento_Dao {

    Connection con;
    PreparedStatement stm;
    ResultSet rs;


    /**
     * Metodo responsavel gravar o processo na tabela tblprocesso_casa
     *
     * @param processo
     * @param edital Sequencia do edital informado pelo usuario
     * @param id_noivo
     * @param id_noiva
     * @param id_testemunhas
     * @return numProc numero do processo salvo na tabela
     */
    public boolean gravarProcessoCasamento(int processo, int edital, int id_noivo, int id_noiva, int id_testemunhas[]) {

        boolean retornoProc = false;

        try {
            String sql = "INSERT INTO cadastro.tblprocesso_casamento(numero_processo, edital_proc, data_processo, id_esposa, id_marido, id_testemunha1, id_testemunha2) values(?,?,?,?,?,?,?)";

            LocalDateTime data = LocalDateTime.now();
            
            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareCall(sql);

            stm.setInt(1, processo);
            stm.setInt(2, edital);
            stm.setString(3, String.valueOf(data));
            stm.setInt(4, id_noiva);
            stm.setInt(5, id_noivo);
            stm.setInt(6, id_testemunhas[0]);
            stm.setInt(7, id_testemunhas[1]);

            int retorno = stm.executeUpdate();

            // mensagem de confirmação
            if (retorno != 0) {
                JOptionPane.showMessageDialog(null, "Processo de casamento inserido com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);

                retornoProc = true;
            } else {
                JOptionPane.showMessageDialog(null, "Informações deste Processo de Casamento não foram salvar", "Mensagem", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar dados do PROCESSO DE CASAMENTO\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConexaoBD.ConexaoDB.fecharConexao(con, stm);
        }

        // retornando o atributo retornoProcess que indica q os dados foram todos salvos com sucesso
        return retornoProc;
    }
}
