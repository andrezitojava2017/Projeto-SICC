package Model;

import java.util.Calendar;

/**
 *
 * @author Andre
 */
public class Pessoas_Model {

    private String nome, docIdentidade, orgaoExpeditor, dataExpedicao, cpf, nacionalidade, nascimento, est_civil, pai, mae, endereco, bairro, complemento, cidade, estado, localFicha, profissao, ficha, cidade_nasc, estado_nasc, sexo, cor;
    private int id, id_endereco, id_certidao;

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(int id_endereco) {
        this.id_endereco = id_endereco;
    }

    public int getId_certidao() {
        return id_certidao;
    }

    public void setId_certidao(int id_certidao) {
        this.id_certidao = id_certidao;
    }

    public String getEstado_nasc() {
        return estado_nasc;
    }

    public void setEstado_nasc(String estado_nasc) {
        this.estado_nasc = estado_nasc;
    }

    public String getCidade_nasc() {
        return cidade_nasc;
    }

    public void setCidade_nasc(String cidade_nasc) {
        this.cidade_nasc = cidade_nasc;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }
    private Calendar data;

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public String getEst_civil() {
        return est_civil;
    }

    public void setEst_civil(String est_civil) {
        this.est_civil = est_civil;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocalFicha() {
        return localFicha;
    }

    public void setLocalFicha(String localFicha) {
        this.localFicha = localFicha;
    }

    public void setFicha(String ficha) {
        this.ficha = ficha;
    }

    public String getFicha() {
        return ficha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDocIdentidade(String docIdentidade) {
        this.docIdentidade = docIdentidade;
    }

    public void setOrgaoExpeditor(String orgaoExpeditor) {
        this.orgaoExpeditor = orgaoExpeditor;
    }

    public void setDataExpedicao(String dataExpedicao) {
        this.dataExpedicao = dataExpedicao;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNome() {
        return nome;
    }

    public String getDocIdentidade() {
        return docIdentidade;
    }

    public String getOrgaoExpeditor() {
        return orgaoExpeditor;
    }

    public String getDataExpedicao() {
        return dataExpedicao;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public String getNascimento() {
        return nascimento;
    }

    public String getPai() {
        return pai;
    }

    public String getMae() {
        return mae;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public String getComplemento() {
        return complemento;
    }

}
