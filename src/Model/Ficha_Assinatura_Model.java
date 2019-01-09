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
public class Ficha_Assinatura_Model {
    
    private int numero_ficha, id_ficha;
    private String local_ficha;

    public int getNumero_ficha() {
        return numero_ficha;
    }

    public void setNumero_ficha(int numero_ficha) {
        this.numero_ficha = numero_ficha;
    }

    public int getId_ficha() {
        return id_ficha;
    }

    public void setId_ficha(int id_ficha) {
        this.id_ficha = id_ficha;
    }

    public String getLocal_ficha() {
        return local_ficha;
    }

    public void setLocal_ficha(String local_ficha) {
        this.local_ficha = local_ficha;
    }
}
