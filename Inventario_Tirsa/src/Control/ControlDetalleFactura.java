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
public class ControlDetalleFactura {
    
    Persistencia p = new Persistencia();
    
    public boolean insertarDetalleFactura(int codigoDetFactura, int codigoFactura, int codigoProducto, int cantidadProducto){
        
        boolean inserto = false;
        String sql = "Insert into detalle_factura (cod_det_factura, cod_factura, cod_producto, cantidad_producto) "
                + "values ("+codigoDetFactura+", "+codigoFactura+", "+codigoProducto+", "+cantidadProducto+")";
        inserto = p.ejecutarDML(sql);
        return inserto;        
    }  
    
    public boolean actualizarDetalleFactura(int codigoDetFactura, int codigoFactura, int codigoProducto, int cantidadProducto){
        boolean actualizo = false;
        String sql = "Update detalle_factura set cantidad_producto = "+cantidadProducto+" where cod_det_factura = "+codigoDetFactura;
        actualizo = p.ejecutarDML(sql);
        return actualizo;
    }   

    public int contarDetalleFactura(){
        
        int numero = 0;
        String sql = "Select count(cod_det_factura) num from detalle_factura";
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
    
    public Object[][] consultarDetFacturaCodigo(int codigo){

        Object data[][] = new Object[this.contarDetalleFactura()][4];
        ResultSet datos = null;
        String sql = "Select cod_det_factura, cod_factura, cod_producto, cantidad_producto from detalle_factura "
                + "where cod_det_factura = "+codigo;
        datos = p.ejecutarConsulta(sql);

        try {
            int i = 0;
            while(datos.next()){
                data[i][0] = datos.getInt("cod_det_factura");
                data[i][1] = datos.getInt("cod_factura");
                data[i][2] = datos.getInt("cod_producto");
                data[i][3] = datos.getInt("cantidad_producto");                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlCategorias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }     
    
    public Object[][] consultarCategoria(){

        Object data[][] = new Object[this.contarDetalleFactura()][4];
        ResultSet datos = null;
        String sql = "Select * from empleado";
        datos = p.ejecutarConsulta(sql);

        try {
            int i = 0;
            while(datos.next()){
                data[i][0] = datos.getInt("cod_det_factura");
                data[i][1] = datos.getInt("cod_factura");
                data[i][2] = datos.getInt("cod_producto");
                data[i][3] = datos.getInt("cantidad_producto");   
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlCategorias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }        
}
