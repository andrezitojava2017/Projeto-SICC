/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.CadUsuario_View;

/**
 *
 * @author rh
 */
public class Permissoes_Model {
    
    private String novo_user, autenticacao, recon_firma, cert_nascimento, cert_casamento, cert_obito, procuracao, abert_firma, alterar_selo;
    
    private int id_permissao;

    public int getId_permissao() {
        return id_permissao;
    }

    public void setId_permissao(int id_permissao) {
        this.id_permissao = id_permissao;
    }

    public String getAlterar_selo() {
        return alterar_selo;
    }

    public void setAlterar_selo(String alterar_selo) {
        this.alterar_selo = alterar_selo;
    }

    public String getNovo_user() {
        return novo_user;
    }

    public void setNovo_user(String novo_user) {
        this.novo_user = novo_user;
    }


    public String getAutenticacao() {
        return autenticacao;
    }

    public void setAutenticacao(String autenticacao) {
        this.autenticacao = autenticacao;
    }

    public String getRecon_firma() {
        return recon_firma;
    }

    public void setRecon_firma(String recon_firma) {
        this.recon_firma = recon_firma;
    }

    public String getCert_nascimento() {
        return cert_nascimento;
    }

    public void setCert_nascimento(String cert_nascimento) {
        this.cert_nascimento = cert_nascimento;
    }

    public String getCert_casamento() {
        return cert_casamento;
    }

    public void setCert_casamento(String cert_casamento) {
        this.cert_casamento = cert_casamento;
    }

    public String getCert_obito() {
        return cert_obito;
    }

    public void setCert_obito(String cert_obito) {
        this.cert_obito = cert_obito;
    }

    public String getProcuracao() {
        return procuracao;
    }

    public void setProcuracao(String procuracao) {
        this.procuracao = procuracao;
    }

    public String getAbert_firma() {
        return abert_firma;
    }

    public void setAbert_firma(String abert_firma) {
        this.abert_firma = abert_firma;
    }


    
    public int gravarPermissoes(CadUsuario_View permissao){
        int id_permissao = 0;
        
        
        return id_permissao;
    }
    
}
