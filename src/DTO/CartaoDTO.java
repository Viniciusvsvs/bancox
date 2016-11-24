/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author 111000353
 */
public class CartaoDTO {
    
    private int NumCartao;
    private int AnoCard;
    private String Bandeira;
     
    public int getNumCartao() {
        return NumCartao;
    }

    public void setNumCartao(int NumCartao) {
        this.NumCartao = NumCartao;
    }

    public int getAnoCard() {
        return AnoCard;
    }

    public void setAnoCard(int AnoCard) {
        this.AnoCard = AnoCard;
    }

    public String getBandeira() {
        return Bandeira;
    }

    public void setBandeira(String Bandeira) {
        this.Bandeira = Bandeira;
    }
    
    
}
