
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
    int r;
    
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
    
    public String IdVentas(){
        String idVentas = "";
        String SQL = "SELECT max(idventas) FROM ventas";
        
        try {
            conex = con.Conexion();
            ps = conex.prepareStatement(SQL);
            res = ps.executeQuery();
            
            while(res.next()){
                idVentas = res.getString(1);
            }
        } catch (SQLException e) {
        }
        return idVentas;
    }
    
    public int guardarVenta(Venta v){
        String SQL = "INSERT INTO ventas(idcliente, idempleado, numeroserie, fechaventas, monto, estado) VALUES(?,?,?,?,?,?)";
        
        try {
            conex = con.Conexion();
            ps = conex.prepareStatement(SQL);
            ps.setInt(1, v.getIdcliente());
            ps.setInt(2, v.getIdempleado());
            ps.setString(3, v.getNumserie());
            ps.setString(4, v.getFecha());
            ps.setInt(5, (int) v.getMonto());
            ps.setString(6, v.getEstado());
            ps.executeQuery();
            
        } catch (SQLException e) {
        }
        return r;
    }
    
    public int guardarDetalleVenta(Venta venta){
        String SQL = "INSERT INTO detalle_ventas(idventas,idproducto, cantidad, precioventa) VALUES(?,?,?,?)";
        try {
            conex = con.Conexion();
            ps = conex.prepareStatement(SQL);
            
            ps.setInt(1, venta.getId());
            ps.setInt(2, venta.getIdproducto());
            ps.setInt(3, venta.getCantidad());
            ps.setDouble(4, venta.getPrecio());
            ps.executeUpdate();
            
        } catch (SQLException e) {
        }   
        return r;
    }
}
