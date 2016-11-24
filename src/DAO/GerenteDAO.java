/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.Conexao;
import DTO.GerenteDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 111000353
 */
public class GerenteDAO {
    
    final String NOMEDOBANCO = "trabalho";
    final String NOMEDATABELA = "gerente";

    public boolean inserir(GerenteDTO gerenteDTO) {
        try {
            Connection conn = Conexao.conectar(NOMEDOBANCO);
            String sql = "INSERT INTO " + NOMEDATABELA +" (CPF,Nome,AnoNasc,Salario,CgHoraria) VALUES (?,?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,Integer.toString(gerenteDTO.getCPF()));
            ps.setString(2,gerenteDTO.getNome());
            ps.setString(3,Integer.toString(gerenteDTO.getAnoNas()));
            ps.setString(4,Integer.toString(gerenteDTO.getSalario()));
            ps.setString(5,Integer.toString(gerenteDTO.getCgHoraria()));
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

    public boolean alterar(GerenteDTO gerenteDTO) {
        try {
            Connection conn = Conexao.conectar(NOMEDOBANCO);
            String sql = "UPDATE " + NOMEDATABELA +
            " SET  Nome = ?,  AnoNasc = ?, TipoConta = ?, NumConta = ? WHERE CPF = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,gerenteDTO.getNome());
            ps.setString(2,Integer.toString(gerenteDTO.getAnoNas()));
            ps.setString(3,Integer.toString(gerenteDTO.getTipoConta()));
            ps.setString(4,Integer.toString(gerenteDTO.getNumConta()));
            ps.setInt(5, gerenteDTO.getCPF());
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

    public boolean excluir(GerenteDTO gerenteDTO) {
        try {
            Connection conn = Conexao.conectar(NOMEDOBANCO);
            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE CPF = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, gerenteDTO.getCPF());
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



    public boolean existe(GerenteDTO gerenteDTO) {
        try {
            Connection conn = Conexao.conectar(NOMEDOBANCO);
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE Nome = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, gerenteDTO.getNome());
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

    public List<GerenteDTO> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar(NOMEDOBANCO);
            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<GerenteDTO> listObj = montarLista(rs);
            return listObj;
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return null;
        }
    }

    public List<GerenteDTO> montarLista(ResultSet rs) {
        List<GerenteDTO> listObj = new ArrayList<GerenteDTO>();
        try {
            while (rs.next()) {
                GerenteDTO obj = new GerenteDTO();
                obj.setCPF(rs.getInt(1));
                obj.setNome(rs.getString(2));
                obj.setAnoNas(rs.getInt(3));
                obj.setTipoConta(rs.getString(4));
                obj.setNumConta(rs.getString(5));
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