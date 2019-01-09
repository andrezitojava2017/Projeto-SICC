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
public class Enderecos_Model {
 
    private String nome_rua, cidade_residencia, estado_residencia, complemento, bairro;
    private int id_endereco;
    
    public int getId_endereco(){
        return id_endereco;
    }
    
    public void setId_endereco(int id_endereco){
        this.id_endereco = id_endereco;
    }
    
    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNome_rua() {
        return nome_rua;
    }

    public void setNome_rua(String nome_rua) {
        this.nome_rua = nome_rua;
    }

    public String getCidade_residencia() {
        return cidade_residencia;
    }

    public void setCidade_residencia(String cidade_residencia) {
        this.cidade_residencia = cidade_residencia;
    }

    public String getEstado_residencia() {
        return estado_residencia;
    }

    public void setEstado_residencia(String estado_residencia) {
        this.estado_residencia = estado_residencia;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
