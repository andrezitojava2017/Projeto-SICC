/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Certidao_Model;
import Model.Enderecos_Model;
import Model.Obitos_Model;
import Model.Pessoas_Model;
import Model.Selos_Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Andre
 */
public class Localizar_Obito_Dao {

    Connection con;
    PreparedStatement stm;
    ResultSet rs;

    /**
     * Captura dados da tabela falecidos e retorna uma lista de objeto do tipo
     * Pessoas_Model Utilizado para preencher a tabela da view
     * Localzar_Obito_View
     *
     * @param nome
     * @return
     */
    public List<Pessoas_Model> capturar_dados_pessoa_falecida(String nome) {

        List<Pessoas_Model> lista_falecidos = new ArrayList<>();

        try {
            String sql = "select * from cadastro.tblfalecido where nome_pessoa like '" + nome + "%'";
            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                Pessoas_Model pessoa = new Pessoas_Model();
                pessoa.setId(rs.getInt("id"));
                pessoa.setNome(rs.getString("nome_pessoa"));
                pessoa.setDocIdentidade(rs.getString("doc_identidade"));
                pessoa.setDataExpedicao(rs.getString("data_expedicao"));
                pessoa.setOrgaoExpeditor(rs.getString("orgao_expeditor"));
                pessoa.setCpf(rs.getString("cpf"));
                pessoa.setEst_civil(rs.getString("estado_civil"));
                pessoa.setNacionalidade(rs.getString("nacionalidade"));
                pessoa.setProfissao(rs.getString("profissao_pessoa"));
                pessoa.setNascimento(rs.getString("data_nascimento"));
                pessoa.setCidade_nasc(rs.getString("cidade_nascimento"));
                pessoa.setEstado_nasc("estado_nascimento");
                pessoa.setPai(rs.getString("nome_pai"));
                pessoa.setMae(rs.getString("nome_mae"));
                pessoa.setCor(rs.getString("cor"));
                pessoa.setId_endereco(rs.getInt("id_endereco"));

                lista_falecidos.add(pessoa);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na tentativa de buscar dados da tabela falecidos\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConexaoBD.ConexaoDB.fecharConexao(con, stm, rs);
        }

        return lista_falecidos;
    }

    /**
     * Metodo que captura informaçoes de um determinado obito,selecionado na
     * tabela da View Localizar Falecidos
     *
     * @param id_selecionado
     * @return
     */
    public List<Object> caputrar_dados_falecido(int id_selecionado) {

        List<Object> dados_falecido = new ArrayList<>();

        try {

            String sql = "select cadastro.tblobito.id, cadastro.tblobito.livro, cadastro.tblobito.folha, cadastro.tblobito.termo, cadastro.tblselos.letras, cadastro.tblselos.selos from cadastro.tblobito inner join cadastro.tblselos on cadastro.tblselos.id = cadastro.tblobito.id_selo where cadastro.tblobito.id_falecido = " + id_selecionado;

            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {

                Certidao_Model certidao = new Certidao_Model();
                Selos_Model selo = new Selos_Model();

                certidao.setId_certidao(rs.getInt(1));
                certidao.setLivro(rs.getInt(2));
                certidao.setFolha(rs.getInt(3));
                certidao.setTermo(rs.getInt(4));

                selo.setseqLetras(rs.getString(5));
                selo.setSeqNumeros(rs.getInt(6));

                dados_falecido.add(certidao); // Posição[0] = dados da Certidao
                dados_falecido.add(selo); // Posição[1] = dados do Selo utilizado
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na tentativa de capturar dados da tabela de obitos\n" + e, "Erros", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConexaoBD.ConexaoDB.fecharConexao(con, stm, rs);
        }

        return dados_falecido;
    }

    /**
     * Metodo que captura informações de um determinado falecido utilizado para
     * preencher o formulario da View Localizar_Obito
     *
     * @param id_selecionado
     * @return
     */
    public Object[] dados_pessoa_falecida(int id_selecionado) {

        Object dados_registro[] = new Object[3];

        try {

            String sql = "select cadastro.tblfalecido.*, cadastro.tblobito.*, cadastro.tblenderecos.* from cadastro.tblfalecido inner join cadastro.tblobito on cadastro.tblobito.id_falecido = cadastro.tblfalecido.id inner join cadastro.tblenderecos on cadastro.tblenderecos.id = cadastro.tblfalecido.id_endereco where cadastro.tblfalecido.id =" + id_selecionado;

            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {

                Pessoas_Model pessoa = new Pessoas_Model();
                Obitos_Model obito = new Obitos_Model();
                Enderecos_Model endereco = new Enderecos_Model();
                
                pessoa.setId(rs.getInt("id"));
                pessoa.setNome(rs.getString("nome_pessoa"));
                pessoa.setDocIdentidade(rs.getString("doc_identidade"));
                pessoa.setDataExpedicao(rs.getString("data_expedicao"));
                pessoa.setOrgaoExpeditor(rs.getString("orgao_expeditor"));
                pessoa.setCpf(rs.getString("cpf"));
                pessoa.setEst_civil(rs.getString("estado_civil"));
                pessoa.setNacionalidade(rs.getString("nacionalidade"));
                pessoa.setProfissao(rs.getString("profissao_pessoa"));
                pessoa.setNascimento(rs.getString("data_nascimento"));
                pessoa.setCidade_nasc(rs.getString("cidade_nascimento"));
                pessoa.setEstado_nasc("estado_nascimento");
                pessoa.setPai(rs.getString("nome_pai"));
                pessoa.setMae(rs.getString("nome_mae"));
                pessoa.setCor(rs.getString("cor"));
                pessoa.setId_endereco(rs.getInt("id_endereco"));

                obito.setLocal_falecimento(rs.getString("local_falecimento"));
                obito.setHorario_falecimento(rs.getString("horario_falecimento"));
                obito.setData_obito(rs.getString("data_obito"));
                obito.setCausa_morte(rs.getString("causa_morte"));
                obito.setLocal_sepultamento(rs.getString("local_sepultamento"));
                obito.setMedico(rs.getString("nome_medico"));
                obito.setCrm(rs.getString("crm_medico"));
                obito.setDeclarante(rs.getString("declarante"));
                obito.setEleitor(rs.getString("eleitor"));
                obito.setDeclaracao_obito(rs.getString("declaracao_obito"));
                
                endereco.setNome_rua(rs.getString("endereco"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setComplemento(rs.getString("complemento"));
                endereco.setCidade_residencia(rs.getString("cidade"));
                endereco.setEstado_residencia(rs.getString("estado"));
                
                dados_registro[0] = pessoa;
                dados_registro[1] = obito;
                dados_registro[2] = endereco;

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na tentativa de buscar dados da tabela falecidos\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConexaoBD.ConexaoDB.fecharConexao(con, stm, rs);
        }

        return dados_registro;
    }
}
