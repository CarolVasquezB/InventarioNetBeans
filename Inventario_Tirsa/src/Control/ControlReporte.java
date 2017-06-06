/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.ConexionBD;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DavidJP
 */
public class ControlReporte {

    Connection con = null;
    

    public Object[][] Generar_reporte(String fecha_inicial, String fecha_final) {
        Object[][] data = null;
        try {

            CallableStatement cst = null;
            con = DriverManager.getConnection("jdbc:mysql://localhost/inventario", "root", "mysql");
            cst = con.prepareCall("{call Reporte_Fechas (?,?,?)}");

            data = new Object[5][5];

            cst.setString("fecha_factura1", fecha_inicial);
            cst.setString("fecha_factura2", fecha_final);
            cst.registerOutParameter("total", java.sql.Types.INTEGER);
//            cst.registerOutParameter(4, java.sql.Types.FLOAT);
//            cst.registerOutParameter(5, java.sql.Types.DATE);
//            cst.registerOutParameter(6, java.sql.Types.INTEGER);
//            cst.registerOutParameter(7, java.sql.Types.INTEGER);
//            cst.registerOutParameter(8, java.sql.Types.INTEGER);

           cst.executeQuery();
            int num_fac = cst.getInt("total");
            System.out.println("" + num_fac);
//            try {
//                int i = 0;
//                while (rs.next()) {
//                    data[i][0] = rs.getInt("cod_factura");
//                    data[i][1] = rs.getFloat("valor_factura");
//                    data[i][2] = rs.getDate("fecha_factura");
//                    data[i][3] = rs.getInt("cod_cliente");
//                    data[i][4] = rs.getInt("cod_empleado");
//                    i++;
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(ControlReporte.class.getName()).log(Level.SEVERE, null, ex);
//            }

        } catch (SQLException ex) {
            Logger.getLogger(ControlReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public Object[][] total_facturas(String fecha_inicial, String fecha_final) {
        int num = 0;
        float total=0;
        Object data[][]=null;
        try {
            CallableStatement cst = null;            
            con = DriverManager.getConnection("jdbc:mysql://localhost/inventario", "root", "mysql");
            cst = con.prepareCall("{call Reporte_Fechas(?,?,?,?)}");
            cst.setString(1, fecha_inicial);
            cst.setString(2, fecha_final);            
            cst.executeQuery();
            num = cst.getInt("total");
            data=new Object[num][2];
            data[0][0]=num;            
            total=cst.getFloat("sum_total_facturas");
            data[0][1]=total;
        } catch (SQLException ex) {
            Logger.getLogger(ControlReporte.class.getName()).log(Level.SEVERE, null, ex);
        }

        return data;
    }

}
