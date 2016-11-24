/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import DAO.GerenteDAO;
import DTO.GerenteDTO;
import java.util.List;

/**
 *
 * @author 111000353
 */
public class GerenteBO {
   public boolean inserir(GerenteDTO gerenteDTO){
        if (existe(gerenteDTO) != true) {
            GerenteDAO gerenteDAO = new GerenteDAO();
            return gerenteDAO.inserir(gerenteDTO);
        }
        return false;
    }

    public boolean alterar(GerenteDTO gerenteDTO){
        GerenteDAO gerenteDAO = new GerenteDAO();
        return gerenteDAO.alterar(gerenteDTO);
    }

    public boolean excluir(GerenteDTO gerenteDTO){
        GerenteDAO gerenteDAO = new GerenteDAO();
        return gerenteDAO.excluir(gerenteDTO);
    }

  

    public boolean existe(GerenteDTO gerenteDTO){
        GerenteDAO gerenteDAO = new GerenteDAO();
        return gerenteDAO.existe(gerenteDTO);
    }

}
