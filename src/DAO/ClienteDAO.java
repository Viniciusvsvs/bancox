/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.Conexao;
import DTO.ClienteDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 111000353
 */

public class ClienteDAO {
    
    final String NOMEDOBANCO = "trabalho";
    final String NOMEDATABELA = "cliente";

    public boolean inserir(ClienteDTO clienteDTO) {
        try (Connection conn = Conexao.conectar(NOMEDOBANCO)) {
            String sql = "INSERT INTO " + NOMEDATABELA +" (CPF,Nome,AnoNasc,TipoConta,NumConta) VALUES (?,?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,Integer.toString(clienteDTO.getCPF()));
            ps.setString(2,clienteDTO.getNome());
            ps.setString(3,Integer.toString(clienteDTO.getAnoNas()));
            ps.setString(4,clienteDTO.getTipoConta());
            ps.setString(5,Integer.toString(clienteDTO.getNumConta()));
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean alterar(ClienteDTO clienteDTO) {
        try {
            Connection conn = Conexao.conectar(NOMEDOBANCO);
            String sql = "UPDATE " + NOMEDATABELA +
            " SET  Nome = ?,  AnoNasc = ?, TipoConta = ?, NumConta = ? WHERE CPF = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,clienteDTO.getNome());
            ps.setString(2,Integer.toString(clienteDTO.getAnoNas()));
            ps.setString(3,clienteDTO.getTipoConta());
            ps.setString(4,Integer.toString(clienteDTO.getNumConta()));
            ps.setInt(5, clienteDTO.getCPF());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return false;
        }
    }

    public boolean excluir(ClienteDTO clienteDTO) {
        try {
            Connection conn = Conexao.conectar(NOMEDOBANCO);
            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE CPF = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, clienteDTO.getCPF());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return false;
        }
    }

    

    public boolean existe(ClienteDTO clienteDTO) {
        try {
            Connection conn = Conexao.conectar(NOMEDOBANCO);
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE Nome = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, clienteDTO.getNome());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ps.close();
                rs.close();
                conn.close();
                return true;
            }
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return false;          
        }
        return false;
    }

    public List<ClienteDTO> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar(NOMEDOBANCO);
            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<ClienteDTO> listObj = montarLista(rs);
            return listObj;
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return null;
        }
    }

    public List<ClienteDTO> montarLista(ResultSet rs) {
        List<ClienteDTO> listObj = new ArrayList<ClienteDTO>();
        try {
            while (rs.next()) {
                ClienteDTO obj = new ClienteDTO();
                obj.setCPF(rs.getInt(1));
                obj.setNome(rs.getString(2));
                obj.setAnoNas(rs.getInt(3));
                obj.setTipoConta(rs.getString(4));
                obj.setNumConta(rs.getInt(5));
                listObj.add(obj);
            }
            return listObj;
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return null;
        }
    }
}
