/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.Alumno;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import Views.ControlPagos;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Irving Calix
 */
public class Pagos {
    
    private static conexion.Conexion con = new Conexion();
    private static Connection conexion = con.getConexion();
    private  static PreparedStatement ps = null;
    
     public static void setListarDetalleUpdate(String identidad){
            DefaultTableModel modelo = (DefaultTableModel)ControlPagos.tblPagos.getModel();
            
            
            //modelo.fireTableDataChanged();
 
            
            while(modelo.getRowCount() > 0 ){
                modelo.removeRow(0);
                
            }
            String consulta = "SELECT Alumnos.Nombres, Alumnos.Apellidos, Alumnos.Grado, \n" +
                                "MONTH(Control_Pagos.fecha) Mes, YEAR(Control_Pagos.fecha) anio FROM Control_Pagos\n" +
                                "INNER JOIN Pagos on fk_pago = Pagos.id \n" +
                                "INNER JOIN Alumnos on Alumnos.Identidad = Pagos.Alumno\n" +
                                "where Alumnos.Identidad='"+identidad+"'";         
            
        
        String datos[] = new String[12];
        
        try{
 Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            
            datos[0] = "Sin Cancelar";
            datos[1] = "Sin Cancelar";
            datos[2] = "Sin Cancelar";
            datos[3] = "Sin Cancelar";
            datos[4] = "Sin Cancelar";
            datos[5] = "Sin Cancelar";
            datos[6] = "Sin Cancelar";
            datos[7] = "Sin Cancelar";
            datos[8] = "Sin Cancelar";
            datos[9] = "Sin Cancelar";
            datos[10] = "Sin Cancelar";
            datos[11] = "Sin Cancelar";
            while(rs.next()){
                switch (rs.getInt("Mes")) {
            case 1:
                datos[0] = "Pagado";
                break;
            case 2:
                datos[1] = "Pagado";
                break;
            case 3:
                datos[2] = "Pagado";
                break;
            case 4:
                datos[3] = "Pagado";
                break;
            case 5:
                datos[4] = "Pagado";
                break;
            case 6:
                datos[5] = "Pagado";
                break;
            case 7:
                datos[6] = "Pagado";
                break;
            case 8:
                datos[7] = "Pagado";
                break;
            case 9:
                datos[8] = "Pagado";
                break;
            case 10:
                datos[9] = "Pagado";
                break;
            case 11:
                datos[10] = "Pagado";
                break;
            case 12:
                datos[11] = "Pagado";
                break;
            default:
                break;
        }
                modelo.addRow(datos);
                DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
                tcr.setHorizontalAlignment(SwingConstants.RIGHT);
                ControlPagos.tblPagos.setModel(modelo);
                //ControlPagos.tblMostrarEmp.getColumnModel().getColumn(8).setCellRenderer(tcr);
                
            }
           // MOSTRARCARGO.tblCa.setModel(modelo);//la tabla se actualiza. HacerCalculos(r);
        }catch (SQLException ex){
            
            Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            }
}
