package DAO;

import Model.Ficha_Assinatura_Model;
import Model.Pessoas_Model;
import Model.Selos_Model;
import java.io.File;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
 * @author jederson
 */
public class Abertura_Assinaturas_Dao {

    Connection con;
    PreparedStatement stm;
    ResultSet rs;

    /**
     * Metodo responsavel em gravar na tabela abertura de firmas os IDs do selo
     * usado e da pessoa cadastrada.
     *
     * @param idselo
     * @param idpessoa
     */
    public int gravarNovoFirma(int idselo, int idpessoa) {
        con = null;
        stm = null;

        int id_abertura = 0;

        String sql = "insert into cadastro.tblaberturafirmas(id_selo, id_pessoa) values(?,?)";

        try {
            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);

            stm.setInt(1, idselo);
            stm.setInt(2, idpessoa);

            int ret = stm.executeUpdate();

            if (ret != 0) {
                JOptionPane.showMessageDialog(null, "Abertura de Ficha lançada com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                id_abertura = ler_id_abertura_firmas();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar dados da tabela abertura de firmas\n" + ex);
        } finally {
            ConexaoBD.ConexaoDB.fecharConexao(con, stm);
        }

        return id_abertura;
    }

    /**
     * Metodo que ira ler o maior ID da tabela abertura de assinaturas
     *
     * @return
     */
    public int ler_id_abertura_firmas() {

        String sql = "select max(id) from cadastro.tblaberturafirmas";

        int id_abertura = 0;

        try {
            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                id_abertura = rs.getInt(1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar dados da tabela abertura de firmas\n" + ex);
        } finally {
            ConexaoBD.ConexaoDB.fecharConexao(con, stm, rs);
        }

        return id_abertura;
    }

    /**
     * Captura uma conexao com o banco de dados
     *
     * @param numero_ficha
     * @param idPessoa
     * @return conexao
     */
    public Connection imprimirFicha(int numero_ficha, int idPessoa) {

        try {
            con = ConexaoBD.ConexaoDB.getconection();
            File end = new File(getClass().getResource("/Relatorios/ficha_assinatura.jasper").toURI());

            String local = String.valueOf(end);
//            System.out.println(local);
////                    getResource("Relatorios\\ficha_assinatura.jasper").toString();
            Map parametros = new HashMap();
            parametros.put("numero_ficha", numero_ficha);
            parametros.put("id_pessoa", idPessoa);

            JasperPrint relatorio = JasperFillManager.fillReport(local, parametros, con);

            JasperViewer tela = new JasperViewer(relatorio, false);
            tela.setTitle("Cartão de Assinatura");
            tela.setVisible(true);
        } catch (SQLException | URISyntaxException | JRException ex) {
            JOptionPane.showMessageDialog(null, "Erro na tentativa de imprimir a ficha de assinatura\n" + ex, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConexaoBD.ConexaoDB.fecharConexao(con);
        }

        return con;
    }

    public List<Object> buscar_pessoa_vinculada_ato_abertura(String id_ato) {

        List<Object> dadosCapturados = new ArrayList<>();

        try {

            String sql = "select cadastro.tblpessoas.nome_pessoa, cadastro.tblselos.letras, cadastro.tblselos.selos, cadastro.tblfichaassinatura.numero_ficha from cadastro.tblaberturafirmas inner join cadastro.tblpessoas on cadastro.tblpessoas.id = cadastro.tblaberturafirmas.id_pessoa inner join cadastro.tblselos on cadastro.tblselos.id = cadastro.tblaberturafirmas.id_selo inner join cadastro.tblfichaassinatura on cadastro.tblfichaassinatura.id_pessoa = cadastro.tblpessoas.id where cadastro.tblaberturafirmas.id =" + id_ato;

            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            
            while(rs.next()){
                Pessoas_Model pessoa = new Pessoas_Model();
                Selos_Model selo = new Selos_Model();
                Ficha_Assinatura_Model ficha = new Ficha_Assinatura_Model();
                
                pessoa.setNome(rs.getString(1));
                selo.setseqLetras(rs.getString(2));
                selo.setSeqNumeros(rs.getInt(3));
                ficha.setNumero_ficha(rs.getInt(4));
                
                dadosCapturados.add(pessoa); //Posicao[0] - Pessoas_Model();
                dadosCapturados.add(selo); //Posicao[1] - Selos_Model();
                dadosCapturados.add(ficha); //Posicao[2] - Ficha_Assinatura_Model();
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error na tentativa de ler dados da tabela de abertura de firmas\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally{
            ConexaoBD.ConexaoDB.fecharConexao(con, stm, rs);
        }
        
        return dadosCapturados;
    }
}
