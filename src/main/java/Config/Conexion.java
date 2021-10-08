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
    
    private String URL = "jdbc:mysql://localhost:3306/sventas";
    private String user = "root";
    private String password = "";
    
    public Connection Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error SQL "+ ex.getMessage());
        }  
        return conexion;
    }
}
