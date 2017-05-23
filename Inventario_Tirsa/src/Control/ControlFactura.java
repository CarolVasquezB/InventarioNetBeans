/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Persistencia;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CarolVasquez
 */

//prueba 
//editado por david 
public class ControlFactura {
    
    Persistencia p = new Persistencia();
    
    public boolean insertarFactura(int codigoFactura, float valorFactura, String fechaFactura, int codigoCliente,
        int codigoEmpleado, int codigoAbono){
        
        boolean inserto = false;
        String sql = "Insert into factura (cod_factura, valor_factura, fecha_factura, cod_cliente, cod_empleado, cod_abono) "
                + "values ("+codigoFactura+", "+valorFactura+", '"+fechaFactura+"', "+codigoCliente+", "+codigoEmpleado+","+codigoAbono+")";
        inserto = p.ejecutarDML(sql);
        return inserto;        
    } 
    
    public boolean actualizarFactura(int codigoFactura, float valorFactura, String fechaFactura, int codigoCliente,
        int codigoEmpleado, int codigoAbono){
        boolean actualizo = false;
        String sql = "Update factura set "
                + "valor_factura = " +valorFactura 
                + ", fecha_factura = '"+valorFactura  
                + ", cod_cliente = "+codigoCliente   
                + ", cod_empleado = "+codigoCliente       
                + ", cod_abono = "+codigoAbono                   
                + " where cod_factura = "+codigoFactura;
        actualizo = p.ejecutarDML(sql);
        return actualizo;
    }   

    public int contarFacturas(){
        
        int numero = 0;
        String sql = "Select count(cod_factura) num from factura";
        ResultSet res = p.ejecutarConsulta(sql);
        
        try {
          
            while(res.next()){
                numero = res.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlCategorias.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return numero;
    }
    
    public Object[][] consultarFactura(int codigo){

        Object data[][] = new Object[this.contarFacturas()][5];
        ResultSet datos = null;
        String sql = "Select cod_factura, valor_factura, fecha_factura, cod_cliente, cod_empleado, cod_abono"
                + " from factura where cod_factura = "+codigo;
        datos = p.ejecutarConsulta(sql);

        try {
            int i = 0;
            while(datos.next()){
                data[i][0] = datos.getInt("cod_factura");
                data[i][1] = datos.getFloat("valor_factura");
                data[i][2] = datos.getString("fecha_factura");
                data[i][3] = datos.getInt("cod_cliente");
                data[i][4] = datos.getInt("cod_empleado");
                data[i][5] = datos.getInt("cod_abono");
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlCategorias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }     
         
    public Object[][] consultarFacturas(){

        Object data[][] = new Object[this.contarFacturas()][5];
        ResultSet datos = null;
        String sql = "Select * from factura";
        datos = p.ejecutarConsulta(sql);

        try {
            int i = 0;
            while(datos.next()){
                data[i][0] = datos.getInt("cod_factura");
                data[i][1] = datos.getFloat("valor_factura");
                data[i][2] = datos.getString("fecha_factura");
                data[i][3] = datos.getInt("cod_cliente");
                data[i][4] = datos.getInt("cod_empleado");
                data[i][5] = datos.getInt("cod_abono");
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlCategorias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;    
    }
}
