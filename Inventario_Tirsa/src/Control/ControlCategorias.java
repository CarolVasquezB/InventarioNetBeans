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
public class ControlCategorias {
    
    Persistencia p = new Persistencia();
    
    public boolean insertarCategoria(int codigoCategoria, String nombreCategoria){
        
        boolean inserto = false;
        String sql = "Insert into categoria (cod_categoria, nombre_categoria) "
                + "values ("+codigoCategoria+", '"+nombreCategoria+"')";
        inserto = p.ejecutarDML(sql);
        return inserto;        
    } 
    
    public boolean eliminarCategoriaCodigo(int codigoCategoria){
        boolean elimino = false;
        String sql = "Delete from categoria where cod_categoria = " + codigoCategoria;
        elimino = p.ejecutarDML(sql);
        return elimino;
    }    
    
    public boolean eliminarCategoriaNombre(String nombreCategoria){
        boolean elimino = false;
        String sql = "Delete from categoria where nombre_categoria = '" + nombreCategoria + "'";
        elimino = p.ejecutarDML(sql);
        return elimino;
    }    
    
    public boolean actualizarPais(int codigoCategoria,String nombreCategoria){
        boolean actualizo = false;
        String sql = "Update categoria set "
                + "nombre_categoria = " + "'"+nombreCategoria +                  
                "' where cod_categoria = "+codigoCategoria;
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
    
    public static void main(String[] args) {
        ControlCategorias cc = new ControlCategorias(); 
        //cc.insertarCategoria(10, "Prueba");
        //cc.eliminarCategoriaNombre("prueba");
        //Object[][] dato = cc.consultarCategoriaCodigo(2);
        //System.out.println("Codigo: "+ dato[0][0]+ " Nombre: "+dato[0][1]); 
        //Object[][] dato1 = cc.consultarCategoriaNombre("Buso");
        //System.out.println("Codigo: "+ dato1[0][0]+ " Nombre: "+dato1[0][1]); 
        
        Object[][] dato = cc.consultarCategoria();        
        for (int i = 0; i < cc.contarCategorias(); i++) {
            System.out.println("Nombre: "+dato[i][1]+" Codigo: "+dato[i][0]);
        }
    }
}
