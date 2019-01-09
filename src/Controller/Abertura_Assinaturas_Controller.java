package Controller;

import DAO.Abertura_Assinaturas_Dao;
import Model.Abertura_Assinatura_Model;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author rh
 */
public class Abertura_Assinaturas_Controller {

    /**
     * Metodo que abre um arquivo txt e copia o seu conteudo (local onde ira
     * armzenar as fichas de assinaturas)
     *
     * @param destCopia
     * @return String local_ficha
     */
    public String abrirLocalFicha(Abertura_Assinatura_Model destCopia) {

        String local_ficha = null;

        // nome do arquivo que sera lido
        File arquivo = destCopia.destinoCopia;

        try {
            // verifica se o arquivo existe
            // se o arquivo existir ele abre e le o conteudo para atribuir no campo de destino da copia
            if (arquivo.exists()) {

                // chama metodo que abre o arquivo e le o conteudo, retorna o conteudo lido no arquivo
                local_ficha = lerConteudoArquivo(arquivo);

            } else {
                // se não existir cria o arquivo no local indicado
                // abre uma tela JFileSchoser para indicar o local onde ira ser amazenado as copias      
                boolean criar = arquivo.createNewFile();

                // verifica se o arquivo foi criado
                if (criar == true) {

                    local_ficha = gravarLocalEscolhido(arquivo);

                } else {

                    // mensagem de erro
                    JOptionPane.showMessageDialog(null, "Não foi possivel cria arquivo ficha.txt em: \n" + arquivo.getAbsolutePath(), "Mensagem", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro de excessão na criação do arquivo \n" + ex, "Mensagem", JOptionPane.ERROR_MESSAGE);
        }

//        System.out.println("conteudo lido do arquivo: " + local_ficha);
        return local_ficha;
    }

    /**
     * Metodo que ira ler o cnteudo o arquivo ficha, onde se encntra o endereço
     * padrao para salvar as copias das fichas
     *
     * @param arq
     * @return local_ficha
     * @throws FileNotFoundException
     * @throws IOException
     */
    public String lerConteudoArquivo(File arq) throws FileNotFoundException, IOException {

        FileReader ler_arquivo = new FileReader(arq);
        String local_ficha = null;

        try {
            // abre o arquivo e le o conteudo
            // armzena o conteudo lido
            BufferedReader bfReader = new BufferedReader(ler_arquivo);
            // atribui o conteudo a String
            local_ficha = bfReader.readLine();

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error de arquivo não encontrado\n" + ex, "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error IOException\n" + ex, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {

            // lendo o arququivo
            ler_arquivo.close();
        }

        return local_ficha;
    }

    /**
     * Metodo responsavel em gravar no arquivo ficha.txt o caminho onde ficarão
     * salvas as imagens das fichas de assinaturas
     *
     * @param arq
     * @return localEscolhido
     * @throws IOException
     */
    private String gravarLocalEscolhido(File arq) throws IOException {

        String localEscolhido = null;

        File rs = arq;

        // se não existir cria o arquivo no local indicado
        // abre uma tela JFileSchoser para indicar o local onde ira ser amazenado as copias
        // abre caixa para localizar o endereço onde ira armazenar as fichas
        JFileChooser definirLocal = new JFileChooser();

        // ira apenas buscar diretorios
        definirLocal.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        // armazena a opção escolhida pelo usuario
        int opt = definirLocal.showOpenDialog(null);

        // verifica a opção foi SIM ou OK
        if (opt == JFileChooser.APPROVE_OPTION) {

            FileWriter escritor = null;
            try {
                // recupera o caminho e atribui ao File
                File caminho = definirLocal.getCurrentDirectory();

                localEscolhido = caminho.getAbsolutePath();

                // indicando o objeto File que tem referncia do arquivo que sera escrito
                escritor = new FileWriter(rs);

                // escrevendo no arquivo ficha.txt o caminho
                escritor.write(localEscolhido);

                // System.out.println("ATRIBUTO local escolhido: " + localEscolhido);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error IOException\n" + ex, "Error", JOptionPane.ERROR_MESSAGE);
            } finally {

                escritor.flush();
                escritor.close();
            }

        } else {
            // exibe mensagem ao usuario
            JOptionPane.showMessageDialog(null, "Opção escolhida foi NÃO");
        }

        return localEscolhido;
    }

    /**
     * Metodo que faz a gravacao na tabela abertura de firmas
     *
     * @param id_selo
     * @param id_pessoa
     */
    public int inserir_Ato_Abertura_Assinatura(int id_selo, int id_pessoa) {

        int id_abertura = 0;
        // instanciando objeto Dao para chamar metodo de gravar ato abertura de firma
        Abertura_Assinaturas_Dao gravarAbertura = new Abertura_Assinaturas_Dao();

        // chamando metodo e passando parametrospara sem gravados na tabela aberturaFirmas
        id_abertura = gravarAbertura.gravarNovoFirma(id_selo, id_pessoa);

        return id_abertura;
    }

    /**
     * Metodo que abre relatorio para imprimir determinada ficha
     *
     * @param numero_ficha
     * @param idPessoa
     */
    public void imprimirFicha(int numero_ficha, int idPessoa) {
        
        Abertura_Assinaturas_Dao conexao = new Abertura_Assinaturas_Dao();
        Connection con = conexao.imprimirFicha(numero_ficha, idPessoa);

    }
}
