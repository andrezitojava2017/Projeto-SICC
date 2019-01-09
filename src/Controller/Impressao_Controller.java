/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Autenticacao_Dao;
import DAO.Relatorios_Dao;
import DAO.Selos_Dao;
import java.io.File;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Andre
 */
public class Impressao_Controller {

    /**
     * Metodo utilizado para imprimir o selo de autenticação
     *
     * @param id_autenticacao
     * @param cod_cartorio
     * @param posicao
     * @param localizacao
     */
    public void imprimir_carimbo_autenticacao(int id_autenticacao, int cod_cartorio, String posicao, String localizacao) {
        if (posicao.equalsIgnoreCase("Esquerdo")) {
            if (localizacao.equalsIgnoreCase("Superior")) {

                InputStream esquerdo = getClass().getResourceAsStream("/Relatorios/Auten_cabec_Ld-esquerdo.jasper");
//                    File esquerdo = new File(getClass().getResource("/Relatorios/Auten_cabec_Ld-esquerdo.jasper").toURI());
                Relatorios_Dao dao = new Relatorios_Dao();
                dao.imprimir_carimbo_autenticacao(id_autenticacao, cod_cartorio, esquerdo);

                System.out.println("Local relatorio: " + String.valueOf(esquerdo));
//                Selos_Dao alterarCampo = new Selos_Dao();
//                alterarCampo.alterar_campo_impresso(id_autenticacao);

            } else if (localizacao.equalsIgnoreCase("Inferior")) {

//                    File esquerdo = new File(getClass().getResource("/Relatorios/Auten_rodp_Ld-esquerdo.jasper").toURI());
//                    Relatorios_Dao dao = new Relatorios_Dao();
//                    dao.imprimir_carimbo_autenticacao(id_autenticacao, cod_cartorio, esquerdo);
//
//                    Selos_Dao alterarCampo = new Selos_Dao();
//                    alterarCampo.alterar_campo_impresso(id_autenticacao);
            } else if (localizacao.equalsIgnoreCase("Meio da Pagina")) {

//                    File esquerdo = new File(getClass().getResource("/Relatorios/Auten_meio_Ld-esquerdo.jasper").toURI());
//                    Relatorios_Dao dao = new Relatorios_Dao();
//                    dao.imprimir_carimbo_autenticacao(id_autenticacao, cod_cartorio, esquerdo);
//
//                    Selos_Dao alterarCampo = new Selos_Dao();
//                    alterarCampo.alterar_campo_impresso(id_autenticacao);
            }

        } else {
            if (posicao.equalsIgnoreCase("Direito")) {
                if (localizacao.equalsIgnoreCase("Superior")) {
//
//                        File esquerdo = new File(getClass().getResource("/Relatorios/Auten_cabec_Ld-direito.jasper").toURI());
//                        Relatorios_Dao dao = new Relatorios_Dao();
//                        dao.imprimir_carimbo_autenticacao(id_autenticacao, cod_cartorio, esquerdo);
//
//                        Selos_Dao alterarCampo = new Selos_Dao();
//                        alterarCampo.alterar_campo_impresso(id_autenticacao);
//
                } else if (localizacao.equalsIgnoreCase("Inferior")) {
//
//                        File esquerdo = new File(getClass().getResource("/Relatorios/Auten_rodp_Ld-direito.jasper").toURI());
//                        Relatorios_Dao dao = new Relatorios_Dao();
//                        dao.imprimir_carimbo_autenticacao(id_autenticacao, cod_cartorio, esquerdo);
//
//                        Selos_Dao alterarCampo = new Selos_Dao();
//                        alterarCampo.alterar_campo_impresso(id_autenticacao);

                } else if (localizacao.equalsIgnoreCase("Meio da Pagina")) {
//
//                        File esquerdo = new File(getClass().getResource("/Relatorios/Auten_meio_Ld-direito.jasper").toURI());
//                        Relatorios_Dao dao = new Relatorios_Dao();
//                        dao.imprimir_carimbo_autenticacao(id_autenticacao, cod_cartorio, esquerdo);
//
//                        Selos_Dao alterarCampo = new Selos_Dao();
//                        alterarCampo.alterar_campo_impresso(id_autenticacao);
                }
            }
        }
        Autenticacao_Dao dao = new Autenticacao_Dao();
//        dao.imprimir_carimbo_autenticacao(id_autenticacao, cod_cartorio);
    }

    /**
     * Metodo que chama o relatorio responsavel em mostras o selo utilizado em
     * uma determinada reconhecimento de assinatura
     *
     * @param selos_selecionados
     * @param localizacao
     * @param cod_ato
     */
    public void imprimir_reconhecimento_assinatura(int selos_selecionados[], String localizacao, int cod_ato) {

        if (localizacao.equalsIgnoreCase("Superior")) {

            try {
                File caminho = new File(getClass().getResource("/Relatorios/Recon_firma_01.jasper").toURI());
                Relatorios_Dao dao = new Relatorios_Dao();
                dao.imprimir_selos_recon_firma(caminho, selos_selecionados, cod_ato);

                // iremos alterar o valor do campo IMPRESSO da tabela de selos, indicndo se o selo ja foi ou nao impresso
                // primeiro iremos verificar se o valor é diferente de ZERO, para evitar erros na execução
                for (int i = 0; i < selos_selecionados.length; i++) {
                    if (selos_selecionados[i] != 0) {
                        Selos_Dao alterarCampo = new Selos_Dao();
                        alterarCampo.alterar_campo_impresso(selos_selecionados[i]);
                    }
                }

            } catch (URISyntaxException ex) {
                JOptionPane.showMessageDialog(null, "Erro na tentativa de abrir o relatorio\n" + ex, "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else if (localizacao.equalsIgnoreCase("Inferior")) {

            try {
                File caminho = new File(getClass().getResource("/Relatorios/Recon_firma_2_rodape.jasper").toURI());
                Relatorios_Dao dao = new Relatorios_Dao();
                dao.imprimir_selos_recon_firma(caminho, selos_selecionados, cod_ato);

                // iremos alterar o valor do campo IMPRESSO da tabela de selos, indicndo se o selo ja foi ou nao impresso
                // primeiro iremos verificar se o valor é diferente de ZERO, para evitar erros na execução
                for (int i = 0; i < selos_selecionados.length; i++) {
                    if (selos_selecionados[i] != 0) {
                        Selos_Dao alterarCampo = new Selos_Dao();
                        alterarCampo.alterar_campo_impresso(selos_selecionados[i]);
                    }
                }
            } catch (URISyntaxException ex) {
                JOptionPane.showMessageDialog(null, "Erro na tentativa de abrir o relatorio\n" + ex, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
