/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author daser
 */
public class Conexion {
    Connection conexion;
    
    private String URL = "jdbc:postgresql://ec2-54-145-110-118.compute-1.amazonaws.com:5432/d3affqm0uqaj4q?sslmode=require";
    private String user = "fahckhnpnrmusw";
    private String password = "19f7ad0b156c4f2bb9b3c6bcc122ba1ff519f0057a59551a350a603d87374028";
    
    public Connection Conexion(){
        try {
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(URL, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error SQL "+ ex.getMessage());
        }  
        return conexion;
    }
}
