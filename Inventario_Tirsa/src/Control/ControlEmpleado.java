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
public class ControlEmpleado {
    
    Persistencia p = new Persistencia();
    
    public boolean insertarEmpleado(int codigoEmpleado, String loginEmpleado, String psswdEmpleado){
        
        boolean inserto = false;
        String sql = "Insert into empleado (cod_empleado_persona, login_empleado, password_empleado) "
                + "values ("+codigoEmpleado+", '"+loginEmpleado+"', '"+psswdEmpleado+"')";
        inserto = p.ejecutarDML(sql);
        return inserto;        
    } 

    public boolean eliminarEmpleadoCodigo(int codigoEmpleado){
        boolean elimino = false;
        String sql = "Delete from empleado where cod_empleado = " + codigoEmpleado;
        elimino = p.ejecutarDML(sql);
        return elimino;
    }  
    
    public boolean actualizarEmpleado(int codigoEmpleado, String loginEmpleado, String psswdEmpleado){
        boolean actualizo = false;
        String sql = "Update empleado set login_empleado = '"+loginEmpleado+"', password_empleado = '"+psswdEmpleado+"' where cod_empleado_persona = "+codigoEmpleado;
        actualizo = p.ejecutarDML(sql);
        return actualizo;
    }   

    public int contarEmpleados(){
        
        int numero = 0;
        String sql = "Select count(cod_empleado_persona) num from empleado";
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
    
    public Object[][] consultarEmpleadoCodigo(int codigo){

        Object data[][] = new Object[this.contarEmpleados()][3];
        ResultSet datos = null;
        String sql = "Select cod_empleado_persona, login_empleado, password_empleado from empleado "
                + "where cod_empleado = "+codigo;
        datos = p.ejecutarConsulta(sql);

        try {
            int i = 0;
            while(datos.next()){
                data[i][0] = datos.getInt("cod_empleado_persona");
                data[i][1] = datos.getString("login_empleado");
                data[i][2] = datos.getString("password_empleado");                
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlCategorias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }     
    
    public Object[][] consultarCategoria(){

        Object data[][] = new Object[this.contarEmpleados()][3];
        ResultSet datos = null;
        String sql = "Select * from empleado";
        datos = p.ejecutarConsulta(sql);

        try {
            int i = 0;
            while(datos.next()){
                data[i][0] = datos.getInt("cod_empleado_persona");
                data[i][1] = datos.getString("login_empleado");
                data[i][2] = datos.getString("password_empleado");
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlCategorias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }    
}
