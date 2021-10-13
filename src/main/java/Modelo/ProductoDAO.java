/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author robin
 */
public class ProductoDAO {

    Conexion con = new Conexion();
    Connection conex;
    PreparedStatement ps;
    ResultSet res;
    int r;
    
    public List Listar() {
        String SQL = "SELECT * FROM producto";
        List<Producto> lista = new ArrayList<>();

        try {
            conex = con.Conexion();
            ps = conex.prepareStatement(SQL);
            res = ps.executeQuery();

            while (res.next()) {
                Producto pro = new Producto();
                pro.setId(res.getInt(1));
                pro.setNombres(res.getNString(2));
                pro.setPrecio(res.getInt(3));
                pro.setStock(res.getInt(4));
                pro.setEstado(res.getString(5));
                
                lista.add(pro);
            }
        } catch (SQLException e) {
            System.out.println("Error Listar" + e.getMessage());
        }
        return lista;
    }

    public int Agregar(Producto e) {
        String SQL = "INSERT INTO producto(nombres, precio, stock,estado) VALUES(?, ?, ?, ?)";
        try {

            conex = con.Conexion();
            ps = conex.prepareStatement(SQL);            
            ps.setString(1, e.getNombres());
            ps.setDouble(2, e.getPrecio());
            ps.setInt(3, e.getStock());
            ps.setString(4, e.getEstado());
            ps.executeUpdate();
        } catch (Exception ex) {
        }
        return r;
    }

    public Producto ListarId(int id) {
        Producto pro = new Producto();

        String SQL = "SELECT * FROM producto WHERE idproducto=" + id;

        try {
            conex = con.Conexion();
            ps = conex.prepareStatement(SQL);
            res = ps.executeQuery();

            while (res.next()) {
                pro.setId(res.getInt(1));
                pro.setNombres(res.getString(2));
                pro.setPrecio(res.getDouble(3));
                pro.setStock(res.getInt(4));
                pro.setEstado(res.getString(5));
            }
        } catch (Exception e) {
        }
        return pro;
    }

    public int Editar(Producto e) {
        String SQL = "UPDATE producto SET nombres=?, precio=?, stock=?, estado=? WHERE idproducto=?";
        try {
            conex = con.Conexion();
            ps = conex.prepareStatement(SQL);
            ps.setString(1, e.getNombres());
            ps.setDouble(2, e.getPrecio());
            ps.setInt( 3, e.getStock());
            ps.setString(4, e.getEstado());
            ps.setInt(5, e.getId());
            ps.executeUpdate();
        } catch (Exception ex) {
        }
        return r;
    }

    public void Eliminar(int id) {
        String SQL = "DELETE FROM producto WHERE idproducto=" + id;

        try {
            conex = con.Conexion();
            ps = conex.prepareStatement(SQL);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    public int actualizarStock(int id, int stock){
        String SQL = "UPDATE producto SET stock=? WHERE idproducto=?";
        
        try {
            conex = con.Conexion();
            ps = conex.prepareStatement(SQL);
            
            ps.setInt(1, stock);
            ps.setInt(2, id);
            
            ps.executeUpdate();
        } catch (SQLException e) {
        }
        return r;
    }
}
