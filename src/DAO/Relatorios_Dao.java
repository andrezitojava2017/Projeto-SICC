/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author rh
 */
public class Relatorios_Dao {

    Connection con;
    PreparedStatement stm;
    ResultSet rs;

    ;
    
    /**
     * Captura uma conexao com o banco de dados
     *
     * @return conexao
     */
    public Connection imprimirFicha() {
        Connection con = null;
        try {
            con = ConexaoBD.ConexaoDB.getconection();
        } catch (SQLException ex) {
            Logger.getLogger(Abertura_Assinaturas_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return con;
    }
    
    public void imprimir_selos_recon_firma(File local_relatorio, int selos_selecionados[], int cod_ato) {

        try {
            con = ConexaoBD.ConexaoDB.getconection();
            String caminho = String.valueOf(local_relatorio);
     
            Map parametros = new HashMap();
            parametros.put("01_subRel", selos_selecionados[0]);
            parametros.put("02_subRel", selos_selecionados[1]);
            parametros.put("03_subRel", selos_selecionados[2]);
            parametros.put("04_subRel", selos_selecionados[3]);

            JasperPrint imprimir = JasperFillManager.fillReport(caminho, parametros, con);
            JasperViewer tela = new JasperViewer(imprimir, false);
            tela.setTitle("Reconhecimento de Assinaturas");
            tela.setVisible(true);
    
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na tentativa de abrir o relatorio\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        } catch (JRException ex) {
            Logger.getLogger(Relatorios_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
        /**
     * Metodo para imprimir o selo de um determinada autenticação
     *
     * @param id_autenticacao
     * @param cod_cartorio
     * @param endereco_rel
     */
    public void imprimir_carimbo_autenticacao(int id_autenticacao, int cod_cartorio, InputStream endereco_rel) {

        try {
            con = ConexaoBD.ConexaoDB.getconection();
            String caminho_rel = String.valueOf(endereco_rel);

            System.out.println("Local relatorio: " + caminho_rel);
            
            Map parametros = new HashMap();
            parametros.put("codigo_cartorio", cod_cartorio);
            parametros.put("id_autenticacao", id_autenticacao);

            JasperPrint imprimir_rel = JasperFillManager.fillReport(caminho_rel, parametros, con);
            JasperViewer tela = new JasperViewer(imprimir_rel, false);
            tela.setTitle("Cartão de Assinatura");
            tela.setVisible(true);

        } catch (SQLException e) {
        } catch (JRException ex) {
            Logger.getLogger(Autenticacao_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
