/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Conexao.Conexao;

/**
 *
 * @author 111000353
 */
public class Main {
    
    private static Main Instance;
    
    public static Main getInstance() {
        return Instance;
    }
    
    public static void main(String[] args) {
        new Main();
    }
    
    private Conexao conexao;
    
    //
    public Main() {
        Instance = this;
        this.conexao = new Conexao();
    }
    
    //
    
    public Conexao getConexao() {
        return this.conexao;
    }
    
}
