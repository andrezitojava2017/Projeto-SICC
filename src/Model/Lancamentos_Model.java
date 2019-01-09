/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Andre
 */
public class Lancamentos_Model {
    
    private String data_lancamento, competencia,descricao_ato;
    private int codigo_ato, id_ato;
    private double custo_ato;
    
    
    public String getData_lancamento() {
        return data_lancamento;
    }

    public void setData_lancamento(String data_lancamento) {
        this.data_lancamento = data_lancamento;
    }

    public String getCompetencia() {
        return competencia;
    }

    public void setCompetencia(String competencia) {
        this.competencia = competencia;
    }

    public String getDescricao_ato() {
        return descricao_ato;
    }

    public void setDescricao_ato(String descricao_ato) {
        this.descricao_ato = descricao_ato;
    }

    public int getCodigo_ato() {
        return codigo_ato;
    }

    public void setCodigo_ato(int codigo_ato) {
        this.codigo_ato = codigo_ato;
    }

    public int getId_ato() {
        return id_ato;
    }

    public void setId_ato(int id_ato) {
        this.id_ato = id_ato;
    }

    public double getCusto_ato() {
        return custo_ato;
    }

    public void setCusto_ato(double custo_ato) {
        this.custo_ato = custo_ato;
    }

    
}
