/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cartorio.testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andre
 */
public class atualizar_selo {

    public static void main(String[] args) {

        String sql = "update cadastro.tblselos set custo=2.25";
        Connection con;
        try {
            con = ConexaoBD.ConexaoDB.getconection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(atualizar_selo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
