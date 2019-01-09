/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cartorio.selos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author andresito
 */
public class NovoSelo {

    private String novaSeqLetra;
    private int novaSeqNumero;
    private int inicioSeqSelo;
    private int fimSeqNumero;

    // atributos de conexao ao BD
    Connection con = null;
    PreparedStatement stm = null;
    ResultSet rs = null;

    public String getNovaSeqLetra() {
        return novaSeqLetra;
    }

    public void setNovaSeqLetra(String novaSeqLetra) {
        this.novaSeqLetra = novaSeqLetra;
    }

    public int getNovaSeqNumero() {
        return novaSeqNumero;
    }

    public void setNovaSeqNumero(int novaSeqNumero) {
        this.novaSeqNumero = novaSeqNumero;
    }

    public int getInicioSeqSelo() {
        return inicioSeqSelo;
    }

    public void setInicioSeqSelo(int inicioSeqSelo) {
        this.inicioSeqSelo = inicioSeqSelo;
    }

    public int getFimSeqNumero() {
        return fimSeqNumero;
    }

    public void setFimSeqNumero(int fimSeqNumero) {
        this.fimSeqNumero = fimSeqNumero;
    }

    public NovoSelo() {

    }

// METODOS DA CLASSE NOVO SELOS
    /**
     * Metodo responsavel em gravar a nova sequencia de selos na tabela tblselos
     *
     * @param novo objeto dessa classe
     */
    public void gravarNovoSequencia(NovoSelo novo) {

        try {
            String sql = "insert into cadastro.tblselos(data_ato, letras, selos, custo, obs) values(?,?,?,?,?)";

            // definindo o formatdo da data: 2016/12/08;
            SimpleDateFormat dat = new SimpleDateFormat("yyyy/MM/dd");

            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);

            stm.setString(1, dat.format(Calendar.getInstance().getTime()));
            stm.setString(2, novo.getNovaSeqLetra());
            stm.setInt(3, (novo.getInicioSeqSelo()));
            stm.setString(4, "0.00"); // valor da coluna custo, quando é inclusao de novo selo
            stm.setString(5, "Alteração selos");

            stm.execute();
            JOptionPane.showMessageDialog(null, "Dados gravados com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar nova sequencia do selos - tblselos\n" + ex);
        } finally {
            ConexaoBD.ConexaoDB.fecharConexao(con, stm, rs);
        }

    }

    /**
     * Metodo responsael em gravar o inicio e fim do selos tabela tblNovoSelo.
     */
    public void gravarAlteraSelo(NovoSelo novo) {

        SimpleDateFormat dat = new SimpleDateFormat("yyyy/MM/dd");
        try {
            String sql = "INSERT INTO cadastro.tblNovoSelo(letras, inicio_selo, fim_selo, data_inclusao) values(?,?,?,?)";
            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);

            stm.setString(1, novo.getNovaSeqLetra());
            stm.setInt(2, novo.getInicioSeqSelo());
            stm.setInt(3, novo.getFimSeqNumero());
            stm.setString(4, dat.format(Calendar.getInstance().getTime()));

            stm.execute();
            JOptionPane.showMessageDialog(null, "Dados gravados com sucesso na tabela de Novo Selo");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar dados na tabela de NOVO SELO\n" + ex);
        } finally {
            ConexaoBD.ConexaoDB.fecharConexao(con, stm);
        }

    }

    /**
     * Metodo responsavel em ler a sequencia de selos das tabelas: tblNovoSelo,
     * tblSelos.
     *
     * @return ArrayList<NovoSelo> com valores recuperados do BD.
     */
    public ArrayList<NovoSelo> verSequenciaSelos() {

        ArrayList<NovoSelo> sequencia = new ArrayList<>();
        
        try {
            String sql = "select letras, inicio_selo, fim_selo from cadastro.tblNovoSelo";
            
            con = ConexaoBD.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            
            while(rs.next()){
                NovoSelo retorno = new NovoSelo();
                retorno.setInicioSeqSelo(rs.getInt("inicio_selo"));
                retorno.setFimSeqNumero(rs.getInt("fim_selo"));
                retorno.setNovaSeqLetra(rs.getString("letras"));
                
                sequencia.add(retorno);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler sequencia de selos - tblNovoSelo\n" + ex);
        } finally{
            ConexaoBD.ConexaoDB.fecharConexao(con, stm, rs);
        }

        return sequencia;
    }

}
