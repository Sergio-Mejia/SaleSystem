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

/**
 *
 * @author daser
 */
public class EmpleadoDAO {
    
    private static final String SQL_READALL = "SELECT * FROM empleado";
    Conexion con = new Conexion();
    Connection conex;
    PreparedStatement ps;
    ResultSet res;
    
    public Empleado Validar(String User, String DNI){
        Empleado emp = new Empleado();
        String sql = "select * from empleado where Usuario=? and Dni=?";
        try {
            conex = con.Conexion();
            ps = conex.prepareStatement(sql);
            ps.setString(0, User);
            ps.setString(1, DNI);
            res = ps.executeQuery();
            
            while(res.next()){
                emp.setId(res.getInt("Id"));
                emp.setUser(res.getString("Usuario"));
                emp.setDNI(res.getString("Dni"));
                emp.setNombre(res.getString("Nombres"));            
            }
        } catch (Exception e) {
        }
        return emp;
    }
            
}
