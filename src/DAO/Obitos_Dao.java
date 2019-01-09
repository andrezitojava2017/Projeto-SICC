/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Certidao_Model;
import Model.Obitos_Model;
import Model.Pessoas_Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author Andre
 */
public class Obitos_Dao {

    Connection con;
    PreparedStatement stm;
    ResultSet rs;

    /**
     * Metodo para inserir uma nova certidao de obito na base de dados
     *
     * @param id_falecido
     * @param dados_obito
     * @param certidao
     * @param id_selo
     */
    public int gravar_novo_obito(int id_falecido, Obitos_Model dados_obito, Certidao_Model certidao, int id_selo) {

        int id_ato = 0;
        
        try {
            String sql = "insert into cadastro.tblobito(id_selo, livro, folha, termo, data_lavratura, data_obito, matricula, declaracao_obito, horario_falecimento, local_falecimento, causa_morte, local_sepultamento, declarante, nome_medico, crm_medico, id_falecido) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            // informação irá vir no padrao descrito
            // com o localdate ele converte para o padrao aceito pelo mysql
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate data;

            // conexao
            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stm.setInt(1, id_selo);
            stm.setInt(2, certidao.getLivro());
            stm.setInt(3, certidao.getFolha());
            stm.setInt(4, certidao.getTermo());
            data = LocalDate.parse(certidao.getData_lavratura(), format);
            stm.setString(5, String.valueOf(data));
            data = LocalDate.parse(dados_obito.getData_obito(), format);
            stm.setString(6, String.valueOf(data));
            stm.setString(7, certidao.getMatricula());
            stm.setString(8, dados_obito.getDeclaracao_obito());
            stm.setString(9, dados_obito.getHorario_falecimento());
            stm.setString(10, dados_obito.getLocal_falecimento());
            stm.setString(11, dados_obito.getCausa_morte());
            stm.setString(12, dados_obito.getLocal_sepultamento());
            stm.setString(13, dados_obito.getDeclarante());
            stm.setString(14, dados_obito.getMedico());
            stm.setString(15, dados_obito.getCrm());
            stm.setInt(16, id_falecido);

            int retorno = stm.executeUpdate();

            if (retorno != 0) {
                JOptionPane.showMessageDialog(null, "Nova certidao de obito foi salva com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                rs = stm.getGeneratedKeys();
                if(rs.next()){
                    id_ato = rs.getInt(1);
                }
            } else {
                JOptionPane.showMessageDialog(null, "As informações NÃO foram inseridas na base de dados", "Mensagem", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na tentativa de inserir novo cadastro de obito\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConexaoBD.ConexaoDB.fecharConexao(con, stm);
        }
        
        return id_ato;
    }

    
    /**
     * Metodo para inserir um cadastro de pessoa falecida na base de dados
     * @param falecido
     * @param obito
     * @param id_endereco
     * @return 
     */
    public int gravar_novo_pessoa_falecido(Pessoas_Model falecido, Obitos_Model obito, int id_endereco) {
        int id_falecido = 0;

        try {
            String sql = "insert into cadastro.tblFalecido(nome_pessoa, doc_identidade, data_expedicao, orgao_expeditor, cpf, estado_civil, nacionalidade, profissao_pessoa, data_nascimento, sexo, cidade_nascimento, estado_nascimento, nome_pai, nome_mae, cor, eleitor, id_endereco) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

            DateTimeFormatter formt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate data;

            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stm.setString(1, falecido.getNome());
            stm.setString(2, falecido.getDocIdentidade());
            data = LocalDate.parse(falecido.getDataExpedicao(), formt);
            stm.setString(3, String.valueOf(data));
            stm.setString(4, falecido.getOrgaoExpeditor());
            stm.setString(5, falecido.getCpf());
            stm.setString(6, falecido.getEst_civil());
            stm.setString(7, falecido.getNacionalidade());
            stm.setString(8, falecido.getProfissao());
            data = LocalDate.parse(falecido.getNascimento(), formt);
            stm.setString(9, String.valueOf(data));
            stm.setString(10, falecido.getSexo());
            stm.setString(11, falecido.getCidade_nasc());
            stm.setString(12, falecido.getEstado_nasc());
            stm.setString(13, falecido.getPai());
            stm.setString(14, falecido.getMae());
            stm.setString(15, obito.getCor());
            stm.setString(16, obito.getEleitor());
            stm.setInt(17, id_endereco);

            stm.executeUpdate();

            // iremos capturar o id deste lançamento
            rs = stm.getGeneratedKeys();

            // iremos atribuir ao id_falecido
            if (rs.next()) {
                id_falecido = rs.getInt(1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na tentativa de inserir novo cadastro de obito", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConexaoBD.ConexaoDB.fecharConexao(con, stm, rs);
        }
        
        System.out.println("valor do ID: " + id_falecido);
        return id_falecido;
    }
}
