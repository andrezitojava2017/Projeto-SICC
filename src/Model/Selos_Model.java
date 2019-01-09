/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.time.LocalDate;

/**
 *
 * @author rh
 */
public class Selos_Model {

    private String seqLetras, situacao_impresso;

    private LocalDate data_ato;
    private double custo;
    private int seqNumeros, id_selo;

    private int numeroFicha;
    private int novoSelo;
    private int novaFicha;

    public int getId_selo() {
        return id_selo;
    }

    public void setId_selo(int id_selo) {
        this.id_selo = id_selo;
    }

    public String getSituacao_impresso() {
        return situacao_impresso;
    }

    public void setSituacao_impresso(String situacao_impresso) {
        this.situacao_impresso = situacao_impresso;
    }

    public void setNovoSelo(int novoSelo) {
        this.novoSelo = novoSelo;
    }

    public void setSeqNumeros(int seqNumeros) {
        this.seqNumeros = seqNumeros;
    }

    public double getCusto() {
        return custo;
    }

    public void setseqLetras(String seqLetras) {
        this.seqLetras = seqLetras;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public LocalDate getData_ato() {
        return data_ato;
    }

    public void setData_ato(LocalDate data_ato) {
        this.data_ato = data_ato;
    }

    public int getNumeroFicha() {
        return numeroFicha;
    }

    public int getseqNumeros() {
        return this.seqNumeros;
    }

    public int getnovoSelo() {
        return this.novoSelo;
    }

    public String getseqLetras() {
        return this.seqLetras;
    }

    public int getNovaFicha() {
        return novaFicha;
    }

}
