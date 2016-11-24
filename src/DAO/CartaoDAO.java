/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.Conexao;
import DTO.CartaoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 111000353
 */
public class CartaoDAO {
    
    final String NOMEDOBANCO = "trabalho";
    final String NOMEDATABELA = "cartao";

    public boolean inserir(CartaoDTO cartaoDTO) {
        try {
            Connection conn = Conexao.conectar(NOMEDOBANCO);
            String sql = "INSERT INTO " + NOMEDATABELA +" (NumCartao,AnoCard,Bandeira) VALUES (?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,Integer.toString(cartaoDTO.getNumCartao()));
            ps.setString(2,Integer.toString(cartaoDTO.getAnoCard()));
            ps.setString(3,cartaoDTO.getBandeira());
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

    public boolean alterar(CartaoDTO cartaoDTO) {
        try {
            Connection conn = Conexao.conectar(NOMEDOBANCO);
            String sql = "UPDATE " + NOMEDATABELA +
            " SET  NumCartao = ?,  AnoCard = ?, Bandeira = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,Integer.toString(cartaoDTO.getNumCartao()));
            ps.setString(2,Integer.toString(cartaoDTO.getAnoCard()));
            ps.setString(3,cartaoDTO.getBandeira());
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

    public boolean excluir(CartaoDTO cartaoDTO) {
        try {
            Connection conn = Conexao.conectar(NOMEDOBANCO);
            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE NumCartao = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, cartaoDTO.getNumCartao());
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

    
    

    public boolean existe(CartaoDTO cartaoDTO) {
        try {
            Connection conn = Conexao.conectar(NOMEDOBANCO);
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE NumCartao = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,Integer.toString( cartaoDTO.getNumCartao()));
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

    public List<CartaoDTO> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar(NOMEDOBANCO);
            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<CartaoDTO> listObj = montarLista(rs);
            return listObj;
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return null;
        }
    }

    public List<CartaoDTO> montarLista(ResultSet rs) {
        List<CartaoDTO> listObj = new ArrayList<CartaoDTO>();
        try {
            while (rs.next()) {
                CartaoDTO obj = new CartaoDTO();
                obj.setNumCartao(rs.getInt(1));
                obj.setAnoCard(rs.getInt(3));
                obj.setBandeira(rs.getString(4));
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
