/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.time.LocalDate;

/**
 *
 * @author Andre
 */
public class Obitos_Model {
    
    private String local_falecimento, horario_falecimento, causa_morte, local_sepultamento, medico, crm, declarante, declaracao_obito, cor, eleitor, data_obito;

    public String getData_obito() {
        return data_obito;
    }

    public void setData_obito(String data_obito) {
        this.data_obito = data_obito;
    }

    public String getEleitor() {
        return eleitor;
    }

    public void setEleitor(String eleitor) {
        this.eleitor = eleitor;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
    
    public String getLocal_falecimento() {
        return local_falecimento;
    }

    public void setLocal_falecimento(String local_falecimento) {
        this.local_falecimento = local_falecimento;
    }

    public String getHorario_falecimento() {
        return horario_falecimento;
    }

    public void setHorario_falecimento(String horario_falecimento) {
        this.horario_falecimento = horario_falecimento;
    }

    public String getCausa_morte() {
        return causa_morte;
    }

    public void setCausa_morte(String causa_morte) {
        this.causa_morte = causa_morte;
    }

    public String getLocal_sepultamento() {
        return local_sepultamento;
    }

    public void setLocal_sepultamento(String local_sepultamento) {
        this.local_sepultamento = local_sepultamento;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getDeclarante() {
        return declarante;
    }

    public void setDeclarante(String declarante) {
        this.declarante = declarante;
    }

    public String getDeclaracao_obito() {
        return declaracao_obito;
    }

    public void setDeclaracao_obito(String declaracao_obito) {
        this.declaracao_obito = declaracao_obito;
    }
}
