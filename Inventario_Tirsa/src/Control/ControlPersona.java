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
public class ControlPersona {
    
    Persistencia p = new Persistencia();
    
    public boolean insertarPersona(int codigoPersona, int numDocumento, String nombresPersona, String apellidosPersona,
            String correoPersona, String fechaNacimiento){
        
        boolean inserto = false;
        String sql = "Insert into persona (cod_persona, num_documento, nombres_persona, apellidos_persona,"
                + "correo_persona, fecha_nac_persona) values ("+codigoPersona+", "+numDocumento+", "
                + "'"+nombresPersona+"', '"+apellidosPersona+"', '"+correoPersona+"', '"+fechaNacimiento+"')";
        inserto = p.ejecutarDML(sql);
        return inserto;        
    } 
    
    public boolean eliminarPersonaDocumento(int documentoPersona){
        boolean elimino = false;
        String sql = "Delete from persona where num_documento = " + documentoPersona;
        elimino = p.ejecutarDML(sql);
        return elimino;
    }    
    
    public boolean actualizarPersona(int codigoPersona, int numDocumento, String nombresPersona, String apellidosPersona,
            String correoPersona, String fechaNacimiento){
        boolean actualizo = false;
        String sql = "Update persona set "
                + "num_documento = "+numDocumento
                + "nombres_persona = '"+nombresPersona
                + "', apellidos_persona = '"+apellidosPersona
                + "', correo_persona = '"+correoPersona   
                + "', fecha_nac_persona = '"+fechaNacimiento                 
                + " where cod_persona = "+codigoPersona;
        actualizo = p.ejecutarDML(sql);
        return actualizo;
    }   

    public int contarCategorias(){
        
        int numero = 0;
        String sql = "Select count(cod_categoria) num from categoria";
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
    
    public Object[][] consultarCategoriaCodigo(int codigo){

        Object data[][] = new Object[this.contarCategorias()][2];
        ResultSet datos = null;
        String sql = "Select cod_categoria, nombre_categoria from categoria "
                + "where cod_categoria = "+codigo;
        datos = p.ejecutarConsulta(sql);

        try {
            int i = 0;
            while(datos.next()){
                data[0][0] = datos.getInt("cod_categoria");
                data[0][1] = datos.getString("nombre_categoria");
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlCategorias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }     
      
    public Object[][] consultarCategoriaNombre(String nombre){

        Object data[][] = new Object[this.contarCategorias()][2];
        ResultSet datos = null;
        String sql = "Select cod_categoria, nombre_categoria from categoria "
                + "where nombre_categoria = '"+nombre+"'";
        datos = p.ejecutarConsulta(sql);

        try {
            int i = 0;
            while(datos.next()){
                data[0][0] = datos.getInt("cod_categoria");
                data[0][1] = datos.getString("nombre_categoria");
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlCategorias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    public Object[][] consultarCategoria(){

        Object data[][] = new Object[this.contarCategorias()][2];
        ResultSet datos = null;
        String sql = "Select * from categoria";
        datos = p.ejecutarConsulta(sql);

        try {
            int i = 0;
            while(datos.next()){
                data[i][0] = datos.getInt("cod_categoria");
                data[i][1] = datos.getString("nombre_categoria");
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlCategorias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
}
