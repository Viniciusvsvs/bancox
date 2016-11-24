/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author 111000353
 */
public class Conexao {
    
    public static Connection conectar(String nomeDoBanco) {
    	try {
    	    Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/" + nomeDoBanco;
            return DriverManager.getConnection(url,"root","");
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return null;
        }
    }
    
}
