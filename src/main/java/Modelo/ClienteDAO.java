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
 * @author jdavid
 */
public class ClienteDAO {
    Conexion con = new Conexion();
    Connection conex;
    PreparedStatement ps;
    ResultSet res;
    int r;
    
    public Cliente Buscar(String DNI) {
        Cliente cli = new Cliente();
        String sql = "select * from cliente where dni= "+"'"+DNI+"'";
        try {
            conex = con.Conexion();
            ps = conex.prepareStatement(sql);
            res = ps.executeQuery();

            while (res.next()) {
                cli.setId(res.getInt(1));
                cli.setDni(res.getString(2));
                cli.setNombres(res.getString(3));
                cli.setDireccion(res.getString(4));
                cli.setEstado(res.getString(5));
            }
        } catch (Exception e) {
        }
        return cli;
    }
    
    
    public List Listar(){
        String SQL = "SELECT * FROM cliente";
        List<Cliente> lista = new ArrayList<>();
         
        try{
            conex = con.Conexion();
            ps = conex.prepareStatement(SQL);
            res = ps.executeQuery();
            
            while(res.next()){
                Cliente cli = new Cliente();
                cli.setId(res.getInt(1));
                cli.setDni(res.getString(2));
                cli.setNombres(res.getString(3));
                cli.setDireccion(res.getString(4));
                cli.setEstado(res.getString(5));
               
                lista.add(cli);
            }
        }catch(Exception e){
            System.out.println("Error Listar" + e.getMessage());
        }
        return lista;
    }
    
    
    public int Agregar(Empleado e){
        String SQL = "INSERT INTO cliente(dni, nombres, telefono, estado, usuario) VALUES(?, ?, ?, ?, ?)";
        try {
            conex = con.Conexion();
            ps = conex.prepareStatement(SQL);
            ps.setString(1,e.getDNI());
            ps.setString(2,e.getNombre());
            ps.setString(3,e.getTel());
            ps.setString(4,e.getEstado());
            ps.setString(5,e.getUser());
            ps.executeUpdate();
        } catch (Exception ex) {
        }
        return r;
    }
    
    public Empleado ListarId(int id){
        Empleado em = new Empleado();
        
        String SQL = "SELECT * FROM empleado WHERE idempleado="+id;
        
        try {
            conex = con.Conexion();
            ps = conex.prepareStatement(SQL);
            res = ps.executeQuery();
            
            while(res.next()){
                em.setDNI(res.getString(2));
                em.setNombre(res.getString(3));
                em.setTel(res.getString(4));
                em.setEstado(res.getString(5));
                em.setUser(res.getString(6));
            }
        } catch (Exception e) {
        }
        return em;
    }
    
    
    public int Editar(Empleado e){
        String SQL = "UPDATE empleado SET dni=?, nombres=?, telefono=?, estado=?, usuario=? WHERE idempleado=?";
        try {
            conex = con.Conexion();
            ps = conex.prepareStatement(SQL);
            ps.setString(1,e.getDNI());
            ps.setString(2,e.getNombre());
            ps.setString(3,e.getTel());
            ps.setString(4,e.getEstado());
            ps.setString(5,e.getUser());
            ps.setInt(6, e.getId());
            ps.executeUpdate();
        } catch (Exception ex) {
        }
        return r;
    }
    
    public void Eliminar(int id){
        String SQL = "DELETE FROM empleado WHERE idempleado="+id;
        
        try {
            conex = con.Conexion();
            ps = conex.prepareStatement(SQL);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}

