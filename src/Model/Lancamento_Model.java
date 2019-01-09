/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Andre
 */
public class Lancamento_Model {
    
    private String descricao_ato;
    private String competencia_ato;
    private Date data_ato;
    private int id_selo;
    private int codigo_ato;
    private int id_referencia_ato;
    private int id_lancamento;

    public int getId_lancamento() {
        return id_lancamento;
    }

    public void setId_lancamento(int id_lancamento) {
        this.id_lancamento = id_lancamento;
    }

    public String getDescricao_ato() {
        return descricao_ato;
    }

    public void setDescricao_ato(String descricao_ato) {
        this.descricao_ato = descricao_ato;
    }

    public String getCompetencia_ato() {
        return competencia_ato;
    }

    public void setCompetencia_ato(String competencia_ato) {
        this.competencia_ato = competencia_ato;
    }

    public Date getData_ato() {
        return data_ato;
    }

    public void setData_ato(Date data_ato) {
        this.data_ato = data_ato;
    }

    public int getId_selo() {
        return id_selo;
    }

    public void setId_selo(int id_selo) {
        this.id_selo = id_selo;
    }

    public int getCodigo_ato() {
        return codigo_ato;
    }

    public void setCodigo_ato(int codigo_ato) {
        this.codigo_ato = codigo_ato;
    }

    public int getId_referencia_ato() {
        return id_referencia_ato;
    }

    public void setId_referencia_ato(int id_referencia_ato) {
        this.id_referencia_ato = id_referencia_ato;
    }
    
    
}
