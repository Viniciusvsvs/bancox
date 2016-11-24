/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import DAO.CartaoDAO;
import DTO.CartaoDTO;
import java.util.List;

/**
 *
 * @author 111000353
 */
public class CartaoBO {
    
    public boolean inserir(CartaoDTO cartaoDTO){
        if (existe(cartaoDTO) != true) {
            CartaoDAO cartaoDAO = new CartaoDAO();
            return cartaoDAO.inserir(cartaoDTO);
        }
        return false;
    }

    public boolean alterar(CartaoDTO cartaoDTO){
        CartaoDAO cartaoDAO = new CartaoDAO();
        return cartaoDAO.alterar(cartaoDTO);
    }

    public boolean excluir(CartaoDTO cartaoDTO){
        CartaoDAO cartaoDAO = new CartaoDAO();
        return cartaoDAO.excluir(cartaoDTO);
    }

    

    public boolean existe(CartaoDTO cartaoDTO){
        CartaoDAO cartaoDAO = new CartaoDAO();
        return cartaoDAO.existe(cartaoDTO);
    }

    
    
}
