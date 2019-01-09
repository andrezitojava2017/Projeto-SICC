/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cartorio.testes;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andre
 */
public class Manipulando_Arquivos {

    public static void main(String[] args) {

        try {
            // define o nome do arquivo a ser criado     
            File arquivo = new File("\\local\\teste.txt");        
            
            // metodo retorna um boolean se foi ou nao criado o arquivo
            boolean arquivo_criado = arquivo.createNewFile(); 
            
            // verifica se o arquivo existe ou nao
            boolean existe = arquivo.exists();
            
            String nome_arq = arquivo.getName();
            String caminho_arq = arquivo.getAbsolutePath();
            // deleta o arquivo existente
            //arquivo.delete();
//            
//            System.out.println("Arquivo criado? " + arquivo_criado);
//            System.out.println("Existe? " + existe);
//            System.out.println("Nome do arquivo é: " + nome_arq);
//            System.out.println("Caminho do arquivo: " + caminho_arq);
            
            System.out.println("caminho: " + caminho_arq);
        } catch (IOException ex) {
            Logger.getLogger(Manipulando_Arquivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
