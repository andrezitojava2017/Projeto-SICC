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
import java.time.LocalDate;
import javax.swing.JOptionPane;


/**
 *
 * @author Andre
 */
public class Lancamento_Dao {
    
    Connection con;
    PreparedStatement stm;
    ResultSet rs;
    
    /**
     * Metodo que salva os lançamentos de novos atos realizados na serventia
     * na tabela lancamentos
     * @param id_selo
     * @param codigo_ato
     * @param descricao
     * @param custo_ato
     * @param id_ato 
     */
    public void salvarLancamento(int id_selo, int codigo_ato, String descricao, double custo_ato, int id_ato){
        
        int ano = LocalDate.now().getYear();
        int mes = LocalDate.now().getMonthValue();
        
        String competencia = String.valueOf(mes + "/" + ano);
        
        try {
            String sql = "insert into cadastro.tbllancamentos(data_lanc, competencia_lanc, id_selo, codigo_ato, descricao_ato, custo_ato, id_ato) values(?,?,?,?,?,?,?)";
            
            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            
            // capturando a data atual
            LocalDate data_lanc = LocalDate.now();
            
            
            stm.setString(1, String.valueOf(data_lanc));
            stm.setString(2, competencia);
            stm.setInt(3, id_selo);
            stm.setInt(4, codigo_ato);
            stm.setString(5, descricao);
            stm.setDouble(6, custo_ato);
            stm.setInt(7, id_ato);
            
            int opt = stm.executeUpdate();
            
            if(opt != 0){
                JOptionPane.showMessageDialog(null, "Lançamento foi gravado com sucesso", "Mensagem", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(null, "Novo lançamento não foram inseridos na base de dados", "Mensagem", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Atenção ocrreu um erro na tentativa de gravar novo lançamento\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConexaoBD.ConexaoDB.fecharConexao(con, stm);
        }
        
    }
    
}
