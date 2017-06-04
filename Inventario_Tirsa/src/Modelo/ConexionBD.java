/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;
import Control.ControlReporte;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 1061785255
 */
public class ConexionBD {
    static String bd = "inventario";
    static String login = "root";
    static String password = "mysql";
    static String url = "jdbc:mysql://localhost/"+bd;
    
    Connection con = null;
    
    public ConexionBD(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            con = DriverManager.getConnection(url, login, password);
            if(con != null){
                System.out.println("Conexión Establecida");
            }
        }
        catch(SQLException e){
            System.out.println(e.toString());
        }
        catch(ClassNotFoundException e){
            System.out.println(e.toString());
        }
    }
    
     public CallableStatement llamado_procedimiento_Reporte(){
            
              CallableStatement cst=null;
        try {
          
            con = DriverManager.getConnection("jdbc:mysql://localhost/inventario", "root","mysql");
           cst = con.prepareCall("{call Reporte_Fechas (?,?,?,?,?,?,?,?)}");
        } catch (SQLException ex) {
            Logger.getLogger(ControlReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cst;
           
    }
    
    
    
    public Connection getConnection(){
        return con;
    }
    
    public void desconectar(){
        con = null;
    }

    public static void main(String args[]){
        ConexionBD cBD = new ConexionBD();
        cBD.getConnection();
    }
    
}
