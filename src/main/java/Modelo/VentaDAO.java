
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author daser
 */
public class VentaDAO {
    Conexion con = new Conexion();
    Connection conex;
    PreparedStatement ps;
    ResultSet res;
    
    public String GenerarSerie(){
        String numeroSerie = "";
        String SQL = "SELECT max(numeroserie) FROM ventas";
        
        try {
            conex = con.Conexion();
            ps = conex.prepareStatement(SQL);
            res = ps.executeQuery();
            
            while(res.next()){
                numeroSerie = res.getString(1);
            }
        } catch (SQLException e) {
        }
        return numeroSerie;
    }
}
