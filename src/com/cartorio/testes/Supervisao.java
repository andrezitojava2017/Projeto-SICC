/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cartorio.testes;

import com.sun.java.accessibility.util.AWTEventMonitor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Andre
 */
public class Supervisao {

    Boolean info = true;

    public void teste() {

        while (info != false) {
            AWTEventMonitor.addKeyListener(new KeyAdapter() {

                public void key(KeyEvent tecla) {
                    int codigo = tecla.getKeyCode();
//                        System.out.println("Iniciado");
                    System.out.println("Retorno da tecla pressionada: " + codigo);

                }
            });
        }

    }

    public static void main(String[] args) {
        Supervisao sup = new Supervisao();

        sup.teste();
    }
}
