/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Localizar_Cert_Nasc_Dao;
import DAO.Localizar_Pessoas_Dao;
import DAO.Relatorios_Dao;
import Model.Certidao_Model;
import Model.Pessoas_Model;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Andre
 */
public class Localizar_Cert_Nasc_Controller {

    /**
     * Metodo responsavel em instanciar objeto DAO para acessar a tabela
     * nascimento para preencher a tabela de consulta de Nascimentos
     *
     * @param sql
     * @return List<Certidao_Model>
     */
    public List<Certidao_Model> localizarCertNascimento(String sql) {

        Localizar_Cert_Nasc_Dao certidao = new Localizar_Cert_Nasc_Dao();
        List<Certidao_Model> nascimento;

        nascimento = certidao.localizarCertNascimento(sql);

        return nascimento;
    }

    
    /**
     * Metodo que faz a leitura da tabela Casamento e retorna uma lista com
     * os dados de um determinado pessoa selecionado
     * @param sql
     * @return 
     */
    public List<Certidao_Model> Localizar_Certidao_Casamento(String sql) {
        
        Localizar_Cert_Nasc_Dao certidao = new Localizar_Cert_Nasc_Dao();
        List<Certidao_Model> casamento;

        casamento = certidao.Localizar_Certidao_Casamento(sql);

        return casamento;
    }

//    /**
//     * Metodo que pode fazer a captura de informações das tabela:: PAI, MAE,
//     * REGISTRANDO e preencher a tabela PESSOA da tela de consulta
//     *
//     * @param sql String
//     * @return Pessoas_Model
//     */
//    public List<Pessoas_Model> localizarPessoa(String sql) {
//
//        Localizar_Pessoas_Dao certidao = new Localizar_Pessoas_Dao();
//        List<Pessoas_Model> dadosPessoa;
//
//        dadosPessoa = certidao.buscarContraentes(sql);
//
//        return dadosPessoa;
//    }
    /**
     * Metodo que faz a captura de informações na base de dados, na tabela
     * nascimento retorna uma lista de objetos, sendo dados das tabelas
     * NASCIMENTO, PAI, MAE, REGISTRANDO
     *
     * @param id_cert_selec
     * @return
     */
    public List<Object> dadosCertidao(String id_cert_selec) {

        List<Object> certidao;
        boolean id_pai_existe = false;

        // instanciando objeto DAO
        Localizar_Cert_Nasc_Dao buscar = new Localizar_Cert_Nasc_Dao();

        // chamando metodo que ira verificar na tabela de nascimentos, se o ID_PAI esta preenchido
        // para podermos determinar qual sql ira utilizar, assim evitamos erro na execução
        id_pai_existe = buscar.verificarCertidaoIdPai(id_cert_selec);

        if (id_pai_existe == true) {

            // se o campo ID_PAI estiver preenchido, sera capturado todas as informações
            certidao = buscar.visualizarCertidao(id_cert_selec);

        } else {
            // se o campo ID_PAI NÃO ESTIVER PREENCHIDOS
            certidao = buscar.visualizarCertidaoSemPai(id_cert_selec);
        }

        return certidao;
    }

    public void imprimirCertidaoNascimento(String id_certidao) {

        Relatorios_Dao conexao = new Relatorios_Dao();

        try {
            Connection con = conexao.imprimirFicha();

            String local = "D:\\workspace\\com.cartorio.sicc\\com.cartorio.sicc\\src\\Relatorios\\Cert_Nasc_1_via.jasper";

            Map parametros = new HashMap();
            parametros.put("id_certidao", id_certidao);

            JasperPrint relatorio = JasperFillManager.fillReport(local, parametros, con);

            JasperViewer tela = new JasperViewer(relatorio, false);
            tela.setVisible(true);

//            System.out.println("local: " + local);
        } catch (JRException e) {
            System.err.println(e);
        }
    }
}
