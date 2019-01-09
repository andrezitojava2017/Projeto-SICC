/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Certidao_Model;
import Model.Pessoas_Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Andre
 */
public class Nascimento_Dao {

    Connection con;
    PreparedStatement stm;
    ResultSet rs;

    /**
     * Metodo responsavel em gravar as informações referente ao REGISTRADO na
     * tabela registrando
     *
     * @param pessoa Pessoas_Model
     * @param certidao
     * @return id_registrado
     */
    public int salvarRegistrando(Pessoas_Model pessoa, Certidao_Model certidao) {
        int id_registrado = 0;

        try {
            String sql = "insert into cadastro.tblregistrando(cidade_registro, estado_registro, data_nascimento, hora_nascimento, nome, cidade_nascimento, estado_nasci, local_nasci, sexo, gemeos, matricula_gemeo) values(?,?,?,?,?,?,?,?,?,?,?)";

            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);

            stm.setString(1, certidao.getCidade_registro());
            stm.setString(2, certidao.getEstado_reg());
            stm.setString(3, certidao.getData_nasc());
            stm.setString(4, certidao.getHora_nasc());
            stm.setString(5, pessoa.getNome());
            stm.setString(6, certidao.getCidade_nasc());
            stm.setString(7, certidao.getEstado_nasc());
            stm.setString(8, certidao.getLocal_nasc());
            stm.setString(9, certidao.getSexo());
            stm.setString(10, certidao.getGemeos());
            stm.setString(11, certidao.getMatricula_gemeo());

            int opt = stm.executeUpdate();

            if (opt != 0) {
                JOptionPane.showMessageDialog(null, "Dados foram inseridos com sucesso", "Mensagem", JOptionPane.INFORMATION_MESSAGE);

                // capturando o ultimo id lançado
                id_registrado = lerIdRegistrando();

            } else {
                JOptionPane.showMessageDialog(null, "Dados não foram inseridos na base de dados", "Mensagem", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Atenção ocrreu um erro na tentativa de gravar os dados\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConexaoBD.ConexaoDB.fecharConexao(con, stm);
        }

        return id_registrado;
    }

    /**
     * Metodo responsvel em fazer a captura do ultimo ID da tabela de
     * registrando
     *
     * @return id_registrado int
     */
    public int lerIdRegistrando() {
        int id_registrado = 0;

        try {
            String sql = "select max(id) from cadastro.tblregistrando";
            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                id_registrado = rs.getInt(1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Atenção não foi possivel a leitura do ID do registrando\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConexaoBD.ConexaoDB.fecharConexao(con, stm, rs);
        }

        return id_registrado;
    }

    /**
     * Metodo responsavel em atualizar os dados da tabela registrando
     *
     * @param id_selecionado int
     * @param cert
     * @param pessoa
     */
    public void atualizarDadosRegistrado(String id_selecionado, Certidao_Model cert, Pessoas_Model pessoa) {

        try {
            String sql = "update cadastro.tblregistrando set cidade_registro=?, estado_registro=?, data_nascimento=?, hora_nascimento=?, nome=?, cidade_nascimento=?, estado_nasci=?, local_nasci=?, sexo=?, gemeos=?, matricula_gemeo=? where id=" + id_selecionado;

            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);

            DateTimeFormatter formt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate data = LocalDate.parse(cert.getData_nasc(), formt);

            stm.setString(1, cert.getCidade_registro());
            stm.setString(2, cert.getEstado_reg());
            stm.setString(3, String.valueOf(data));
            stm.setString(4, cert.getHora_nasc());
            stm.setString(5, pessoa.getNome());
            stm.setString(6, cert.getCidade_nasc());
            stm.setString(7, cert.getEstado_nasc());
            stm.setString(8, cert.getLocal_nasc());
            stm.setString(9, cert.getSexo());
            stm.setString(10, cert.getGemeos());
            stm.setString(11, cert.getMatricula_gemeo());

            int opt = stm.executeUpdate();

            if (opt != 0) {
                JOptionPane.showMessageDialog(null, "Os dados foram atualizados com sucesso", "Mensagem ", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possivel atualizar as informações", "Mensagem ", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na atualização dos dados\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConexaoBD.ConexaoDB.fecharConexao(con, stm);
        }
    }

    /**
     * Metodo que faz a gravação de dados na tabela nascimento, quando o PAI
     * esta presente
     *
     * @param certidao
     * @param id_selo
     * @param id_mae
     * @param id_pai
     * @param id_registrado
     */
    public int salvarCertidaoNascimento(Certidao_Model certidao, int id_selo, int id_mae, int id_pai, int id_registrado) {

        int id_ato = 0;
        try {
            String sql = "insert into cadastro.tblnascimento(id_selo, livro, folha, termo, matricula, data_lavratura, decl_nasc_vivo, id_registrando, id_mae, id_pai) values(?,?,?,?,?,?,?,?,?,?)";
            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);

            LocalDate dataAtual = LocalDate.now();
            DateTimeFormatter formt = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            stm.setInt(1, id_selo);
            stm.setInt(2, certidao.getLivro());
            stm.setInt(3, certidao.getFolha());
            stm.setInt(4, certidao.getTermo());
            stm.setString(5, certidao.getMatricula());
            stm.setString(6, formt.format(dataAtual));
            stm.setString(7, certidao.getDecl_nasc_vivo());
            stm.setInt(8, id_registrado);
            stm.setInt(9, id_mae);
            stm.setInt(10, id_pai);

            int opt = stm.executeUpdate();

            if (opt != 0) {
                // capturando o ID para este lançamento
                id_ato = ler_id_CertNascimento();
                
                JOptionPane.showMessageDialog(null, "Nova certidao de nascimento foi inserida com sucesso", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Atenção não foi possivel salvar esta certidao", "Mensagem", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Atenção houve um erro na tentativa de inserir nova certidao\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConexaoBD.ConexaoDB.fecharConexao(con, stm);
        }

        return id_ato;
    }

    /**
     * Metodo que captura o ID do ultimo ato salvo na tabela de Nascimentos
     *
     * @return
     */
    public int ler_id_CertNascimento() {

        int id_ato = 0;
        try {
            String sql = "select max(id) from cadastro.tblnascimento";

            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {

                id_ato = rs.getInt(1);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na tentativa de leitura da tabela Nascimento\n", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConexaoBD.ConexaoDB.fecharConexao(con, stm, rs);
        }
        return id_ato;
    }

    /**
     * Metodo que faz a gravação de dados na tabela nascimento, quando o PAI NÃO
     * está presente
     *
     * @param certidao
     * @param id_selo
     * @param id_mae
     * @param id_registrado
     */
    public int salvarCertidaoNascimento(Certidao_Model certidao, int id_selo, int id_mae, int id_registrado) {

        int id_ato = 0;
        try {
            String sql = "insert into cadastro.tblnascimento(id_selo, livro, folha, termo, matricula, data_lavratura, decl_nasc_vivo, id_registrando, id_mae) values(?,?,?,?,?,?,?,?,?)";
            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);

            Date data = Calendar.getInstance().getTime();
            SimpleDateFormat formt = new SimpleDateFormat("yyyy-MM-dd");

            stm.setInt(1, id_selo);
            stm.setInt(2, certidao.getLivro());
            stm.setInt(3, certidao.getFolha());
            stm.setInt(4, certidao.getTermo());
            stm.setString(5, certidao.getMatricula());
            stm.setString(6, formt.format(data));
            stm.setString(7, certidao.getDecl_nasc_vivo());
            stm.setInt(8, id_registrado);
            stm.setInt(9, id_mae);

            int opt = stm.executeUpdate();

            if (opt != 0) {

                // capturando o ID para este lançamento
                id_ato = ler_id_CertNascimento();

                JOptionPane.showMessageDialog(null, "Nova certidao de nascimento foi inserida com sucesso", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Atenção não foi possivel salvar esta certidao", "Mensagem", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nova certidao de nascimento foi inserida com sucesso", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } finally {
            ConexaoBD.ConexaoDB.fecharConexao(con, stm);
        }

        return id_ato;
    }

    /**
     * Metodo que faz a captura determinado informação da tabela REGISTRANDO
     * para preencher o formulario REGISTRANDO
     *
     * @param id_selecionado
     * @return
     */
    public ArrayList<Object> capturarDadosRegistrando(String id_selecionado) {

        ArrayList<Object> lista = new ArrayList<>();
        try {

            String sql = "select * from cadastro.tblregistrando where id=" + id_selecionado;

            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {

                // objetos model
                Pessoas_Model pessoa = new Pessoas_Model();
                Certidao_Model certidao = new Certidao_Model();

                // capturando dados
                pessoa.setId(rs.getInt("id"));
                pessoa.setNome(rs.getString("nome"));
                certidao.setCidade_registro(rs.getString("cidade_registro"));
                certidao.setEstado_reg(rs.getString("estado_registro"));
                certidao.setData_nasc(rs.getString("data_nascimento"));
                certidao.setHora_nasc(rs.getString("hora_nascimento"));
                certidao.setCidade_nasc(rs.getString("cidade_nascimento"));
                certidao.setEstado_nasc(rs.getString("estado_nasci"));
                certidao.setLocal_nasc(rs.getString("local_nasci"));
                certidao.setSexo(rs.getString("sexo"));
                certidao.setGemeos(rs.getString("gemeos"));
                certidao.setMatricula_gemeo(rs.getString("matricula_gemeo"));

                // add a lista
                lista.add(certidao);// posicao [0]
                lista.add(pessoa); // posicao [1]

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na leitura das informações da pessoa selecionada\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {

            ConexaoBD.ConexaoDB.fecharConexao(con, stm, rs);
        }

        return lista;
    }
    
    
    /**
     * Metodo para localizar um registrando na tabela registrados
     * utilizado simplesmente para preencher a tabela de localizar
     * @param nome_registrando
     * @return 
     */
    public ArrayList<Pessoas_Model> localizar_registrando(String nome_registrando) {

        ArrayList<Pessoas_Model> nomes = new ArrayList<>();
        try {

            String sql = "select * from cadastro.tblregistrando where nome like '" + nome_registrando + "%' ";

            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {

                // objetos model
                Pessoas_Model pessoa = new Pessoas_Model();

                // capturando dados
                pessoa.setId(rs.getInt("id"));
                pessoa.setNome(rs.getString("nome"));
                
                nomes.add(pessoa); // posicao [0]

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na leitura das informações da pessoa selecionada \n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {

            ConexaoBD.ConexaoDB.fecharConexao(con, stm, rs);
        }

        return nomes;
    }
}
