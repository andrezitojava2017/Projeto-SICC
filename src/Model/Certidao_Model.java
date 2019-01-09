/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author jederson Andre
 */
public class Certidao_Model {

    private String tipo_certidao;

    private int livro, folha, termo, id_averbacao, id_certidao;

    private String cidade_registro, estado_reg, hora_nasc, cidade_nasc, data_nasc, estado_nasc, local_nasc, sexo, decl_nasc_vivo, matricula_gemeo, nome_cartorio, data_lavratura, matricula, gemeos;

    public String getData_lavratura() {
        return data_lavratura;
    }

    public void setData_lavratura(String data_lavratura) {
        this.data_lavratura = data_lavratura;
    }

    public int getId_certidao() {
        return id_certidao;
    }

    public void setId_certidao(int id_certidao) {
        this.id_certidao = id_certidao;
    }

    public String getTipo_certidao() {
        return tipo_certidao;
    }

    public void setTipo_certidao(String tipo_certidao) {
        this.tipo_certidao = tipo_certidao;
    }

    public int getId_averbacao() {
        return id_averbacao;
    }

    public void setId_averbacao(int id_averbacao) {
        this.id_averbacao = id_averbacao;
    }

    public String getNome_cartorio() {
        return nome_cartorio;
    }

    public void setNome_cartorio(String nome_cartorio) {
        this.nome_cartorio = nome_cartorio;
    }

    public String getEstado_reg() {
        return estado_reg;
    }

    public void setEstado_reg(String estado_reg) {
        this.estado_reg = estado_reg;
    }

    public String getCidade_registro() {
        return cidade_registro;
    }

    public void setCidade_registro(String cidade_registro) {
        this.cidade_registro = cidade_registro;
    }

    public String getHora_nasc() {
        return hora_nasc;
    }

    public void setHora_nasc(String hora_nasc) {
        this.hora_nasc = hora_nasc;
    }

    public String getCidade_nasc() {
        return cidade_nasc;
    }

    public void setCidade_nasc(String cidade_nasc) {
        this.cidade_nasc = cidade_nasc;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getEstado_nasc() {
        return estado_nasc;
    }

    public void setEstado_nasc(String estado_nasc) {
        this.estado_nasc = estado_nasc;
    }

    public String getLocal_nasc() {
        return local_nasc;
    }

    public void setLocal_nasc(String local_nasc) {
        this.local_nasc = local_nasc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDecl_nasc_vivo() {
        return decl_nasc_vivo;
    }

    public void setDecl_nasc_vivo(String decl_nasc_vivo) {
        this.decl_nasc_vivo = decl_nasc_vivo;
    }

    public String getMatricula_gemeo() {
        return matricula_gemeo;
    }

    public void setMatricula_gemeo(String matricula_gemeo) {
        this.matricula_gemeo = matricula_gemeo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getGemeos() {
        return gemeos;
    }

    public void setGemeos(String gemeos) {
        this.gemeos = gemeos;
    }

    public int getLivro() {
        return livro;
    }

    public void setLivro(int livro) {
        this.livro = livro;
    }

    public int getFolha() {
        return folha;
    }

    public void setFolha(int folha) {
        this.folha = folha;
    }

    public int getTermo() {
        return termo;
    }

    public void setTermo(int termo) {
        this.termo = termo;
    }

}
