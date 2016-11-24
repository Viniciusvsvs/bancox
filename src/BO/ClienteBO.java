/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import DAO.ClienteDAO;
import DTO.ClienteDTO;
import java.util.List;

/**
 *
 * @author 111000353
 */
public class ClienteBO {
    public boolean inserir(ClienteDTO clienteDTO){
        if (existe(clienteDTO) != true) {
            ClienteDAO clienteDAO = new ClienteDAO();
            return clienteDAO.inserir(clienteDTO);
        }
        return false;
    }

    public boolean alterar(ClienteDTO clienteDTO){
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.alterar(clienteDTO);
    }

    public boolean excluir(ClienteDTO clienteDTO){
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.excluir(clienteDTO);
    }


    

    public boolean existe(ClienteDTO clienteDTO){
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.existe(clienteDTO);
    }

    
}
