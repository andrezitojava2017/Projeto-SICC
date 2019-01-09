//package com.cartorio.selos;
//
//import ConexaoBD.ConexaoDB;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.text.DecimalFormat;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import javax.swing.JOptionPane;
//
///**
// *
// * @author Jederson Andre
// */
//public class SeqSelos {
//
//    private String seqLetras = null;
//    private Calendar data_ato;
//    private double custo;
//    private int seqNumeros = 0;
//    private int numeroFicha = 0;
//    private int novoSelo = 0;
//    private int novaFicha = 0;
//
//    public double getCusto() {
//        return custo;
//    }
//
//    public void setCusto(double custo) {
//        this.custo = custo;
//    }
//
//    public Calendar getData_ato() {
//        return data_ato;
//    }
//
//    public void setData_ato(Calendar data_ato) {
//        this.data_ato = data_ato;
//    }
//
//    public int getNumeroFicha() {
//        return numeroFicha;
//    }
//
//    public int getseqNumeros() {
//        return this.seqNumeros;
//    }
//
//    public int getnovoSelo() {
//        return this.novoSelo;
//    }
//
//    public String getseqLetras() {
//        return this.seqLetras;
//    }
//
//    public int getNovaFicha() {
//        return novaFicha;
//    }
//
//    public SeqSelos() {
//
////        LerSeqLetras();
//        LerSeqNumeros();
////        LerFicha();
//
//        //LerSeqFinalSelos();
//    }
//
//    Connection conexao = null;
//    PreparedStatement stm = null;
//    ResultSet rs = null;
//
//    /**
//     * Metodo para ler a sequencia de selos
//     *
//     */
//    public void LerSeqNumeros() {
//
//        String sql = "select letras, selos from cadastro.tblselos";
//        try {
//            conexao = ConexaoBD.ConexaoDB.getconection();
//            stm = conexao.prepareStatement(sql);
//            rs = stm.executeQuery();
//
//            while (rs.next()) {
//                this.seqLetras = rs.getString("letras");
//                this.seqNumeros = Integer.parseInt(rs.getString("selos"));
//                this.novoSelo = this.seqNumeros;
//
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Erro ao ler sequencia de selos: classe SeqSelos, pacote Selos" + ex);
//        } finally {
//            ConexaoDB.fecharConexao(conexao, stm, rs);
//
//        }
//
//        this.novoSelo++;
//
//    }
//
//    /**
//     * Metodo para ler a sequencia de FICHA da tabela PESSOA é nesta tabela que
//     * esta armazenada a ultima ficha utilizada.
//     *
//     */
//    public void LerFicha() {
//
//        String sql = "select ficha from cadastro.tblpessoas";
//        try {
//            conexao = ConexaoBD.ConexaoDB.getconection();
//            stm = conexao.prepareCall(sql);
//            rs = stm.executeQuery();
//
//            while (rs.next()) {
//                this.numeroFicha = rs.getInt("ficha");
//                this.novaFicha = this.numeroFicha;
//
//            }
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Erro ao ler sequencia de ficha \nClasse SeqSelos, Pacote Selos");
//        } finally {
//            ConexaoDB.fecharConexao(conexao, stm, rs);
//        }
//        this.novaFicha++;
//
//    }
//
//    /**
//     * metodo que grava a sequencia de selos utilizados, e qual ato foi
//     * utilizado os selos, Este metodo recebe um parametro do tipo SeqSelos e
//     * tipoAtos
//     *
//     * @param s seqSelos
//     */
//    public void gravarSelo(SeqSelos s) {
//
//        try {
//
//            Connection com = ConexaoDB.getconection();
//            String sql = "INSERT INTO cadastro.tblselos(data_ato, letras, selos, custo) VALUES(?,?,?,?)";
//
//            // formatador para decimais
//            DecimalFormat decimal = new DecimalFormat("#,##0.00");
//
//            // definindo o formatdo da data: 2016/12/08;
//            SimpleDateFormat dat = new SimpleDateFormat("yyyy/MM/dd");
//
//            stm = com.prepareStatement(sql);
//
//            stm.setString(1, dat.format(Calendar.getInstance().getTime())); // captura a data do sistema e formata para gravar no BD, e transforma em data
//            stm.setString(2, s.getseqLetras());
//            stm.setString(3, String.valueOf(s.getnovoSelo())); // recupera os valores do atributos para gravar do BD;
//            stm.setString(4, decimal.format(s.getCusto())); // formatando o valor de custo para decimal (parametro aceito pelo BDmysql)
//
//            int ret = stm.executeUpdate(); // atualizada o Bd;
//
//            if (ret != 0) {
//                JOptionPane.showMessageDialog(null, "Selo inserido com sucesso!", "Confirmação", JOptionPane.INFORMATION_MESSAGE); // mensagem de confirmação da gravação
//            }
//
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Erro ao Salvar dados na TABELA SEQUENCIA DE SELOS \n " + ex, "Erro", JOptionPane.ERROR_MESSAGE);
//        } finally {
//            ConexaoDB.fecharConexao(conexao, stm);
//        }
//
//    }
//
//    /**
//     * Metodo responsavel em ler o ID do ultimo selo utilizado
//     *
//     * @return int selo, com o valor incrementado
//     */
//    public int lerIdSelo() {
//        int id = 0;
//        try {
//            String sql = "select max(id) from cadastro.tblselos";
//            Connection con = ConexaoDB.getconection();
//            stm = con.prepareStatement(sql);
//            rs = stm.executeQuery();
//
//            while (rs.next()) {
//                id = rs.getInt(1);
//            }
//
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Erro ao ler o ID da tabela selos\n" + ex);
//        } finally {
//            ConexaoDB.fecharConexao(conexao, stm, rs);
//        }
//        //selo++;
//        return id;
//    }
//}
