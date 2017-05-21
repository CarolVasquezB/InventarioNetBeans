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
public class ControlProducto {
    //prueba 1
    
    Persistencia p = new Persistencia();
    
    public boolean insertarProducto(int cod_producto,String nombre,String descr_producto,float val_compra,float val_venta_max,int stock,int cod_categoria,float val_venta_min,String fecha){
        
        boolean inserto = false;

        String sql = "Insert into producto(cod_producto,nombre_producto,descr_producto,valor_compra,valor_venta_max,stock_producto,"
                + "cod_categoria,valor_venta_min,fecha_compra) "
                + "values("+cod_producto+",'"+nombre+"','"+descr_producto+"',"+val_compra+","+val_venta_max+","+stock+","+cod_categoria+","+val_venta_min+",'"+fecha+"');";

        inserto = p.ejecutarDML(sql);
        return inserto;        
    } 
    
    public boolean eliminarProducto(int codigoproducto){
        boolean elimino = false;
        String sql = "Delete from producto where cod_producto = " + codigoproducto;
        elimino = p.ejecutarDML(sql);
        return elimino;
    }    
    
    public boolean eliminarproductoxNombre(String nombreproducto){
        boolean elimino = false;
        String sql = "Delete from producto where nombre_producto = '" + nombreproducto + "'";
        elimino = p.ejecutarDML(sql);
        return elimino;
    }    
    
    public boolean actualizarProducto(int cod_producto,String nombre_producto,String descr_producto,float val_compra,float val_venta_max,int stock,int cod_categoria,float val_venta_min,String fecha){
        boolean actualizo = false;
        String sql = "Update producto set "
                + "nombre_producto = " + "'"+nombre_producto +"',descr_producto= '"+descr_producto+"',valor_compra="+val_compra+",valor_venta_max="+val_venta_max+
                ",stock_producto="+stock+",cod_categoria="+cod_categoria+",valor_venta_min="+val_venta_min+",fecha_compra= '"+fecha+
                "' where cod_producto = "+cod_producto;
        actualizo = p.ejecutarDML(sql);
        return actualizo;
    }   

    public int contarproductos(){
        
        int numero = 0;
        String sql = "Select count(cod_producto) num from producto";
        ResultSet res = p.ejecutarConsulta(sql);
        
        try {
          
            while(res.next()){
                numero = res.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlProducto.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return numero;
    }
    
    public Object[][] consultarproductoCodigo(int codigo){

        Object data[][] = new Object[this.contarproductos()][9];
        ResultSet datos = null;
        String sql = "Select cod_producto, nombre_producto,descr_producto,valor_compra,valor_venta_max,stock_producto,"
                + "cod_categoria,valor_venta_min,fecha_compra from producto "
                + "where cod_producto = "+codigo;
        datos = p.ejecutarConsulta(sql);

        try {
            int i = 0;
            while(datos.next()){
                data[0][0] = datos.getInt("cod_producto");
                data[0][1] = datos.getString("nombre_producto");
                data[0][2] = datos.getString("descr_producto");
                data[0][3] = datos.getFloat("valor_compra");
                data[0][4] = datos.getFloat("valor_venta_max");
                data[0][5] = datos.getInt("stock_producto");
                data[0][6] = datos.getInt("cod_categoria");
                data[0][7] = datos.getFloat("valor_venta_min");
                data[0][8] = datos.getString("fecha_compra");
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }     
      
    /*public Object[][] consultarCategoriaNombre(String nombre){

        //Object data[][] = new Object[this.contarCategorias()][2];
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
    }*/
    /*
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
    */
    public static void main(String[] args) {
        ControlProducto cp = new ControlProducto(); 

//        boolean inserto=cp.insertarProducto(123,"reloj","prueba descripcion",150000,170000,10,1,160000,"2017/05/20");
//        if (inserto) {
//            System.out.println("inserto...");
//        }
//        else{
//            System.out.println("error...");
//    }
//        boolean elimino=cp.eliminarProducto(123);
//        if (elimino) {
//            System.out.println("eliminado");
//        }else{
//            System.out.println("error...");
//        }

        
//       boolean eliminoXnombre=cp.eliminarproductoxNombre("reloj");
//        if (eliminoXnombre) {
//            System.out.println("elimino por nombre");
//        }else{
//            System.out.println("error...");
//        }
//        boolean actualizo=cp.actualizarProducto(123,"pulsera","material plata tejido nuevo",80000,100000,5,1,90000, "2017/05/20");
//        if(actualizo){
//            System.out.println("actualizo...");
//        }else{
//            System.out.println("error...");
//        }
        
        
        int aux=cp.contarproductos();
        System.out.println("el numero de productos es : "+aux);
        
        
        
        //cc.insertarCategoria(10, "Prueba");
        //cc.eliminarCategoriaNombre("prueba");
        //Object[][] dato = cc.consultarCategoriaCodigo(2);
        //System.out.println("Codigo: "+ dato[0][0]+ " Nombre: "+dato[0][1]); 
        //Object[][] dato1 = cc.consultarCategoriaNombre("Buso");
        //System.out.println("Codigo: "+ dato1[0][0]+ " Nombre: "+dato1[0][1]); 

//        Object[][] dato = cc.consultarCategoria();        
//        for (int i = 0; i < cc.contarCategorias(); i++) {
//            System.out.println("Nombre: "+dato[i][1]+" Codigo: "+dato[i][0]);
//        }
        
        //Prueba
//        Object[][] dato = cc.consultarCategoria();        
//        for (int i = 0; i < cc.contarCategorias(); i++) {
//            System.out.println("Nombre: "+dato[i][1]+" Codigo: "+dato[i][0]);
//        }
    }
    
    //nnnn
}
