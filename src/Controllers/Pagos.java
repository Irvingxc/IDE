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
import Views.MostrarFacturas;
import Views.PagosPorAlumnos;
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
    
     public static void setListarDetalleUpdate(String nombre){
            DefaultTableModel modelo = (DefaultTableModel)PagosPorAlumnos.tblPagos.getModel();            
            while(modelo.getRowCount() > 0 ){
                modelo.removeRow(0);
                
            }
            String consulta = "SELECT Alumnos.Nombres, Alumnos.Apellidos, Alumnos.Grado, \n" +
                                "MONTH(Control_Pagos.fecha) Mes, YEAR(Control_Pagos.fecha) anio FROM Control_Pagos\n" +
                                "INNER JOIN Pagos on fk_pago = Pagos.id \n" +
                                "INNER JOIN Alumnos on Alumnos.Identidad = Pagos.Alumno\n" +
                                "where Alumnos.Nombres like '%"+nombre+"%' or Alumnos.Apellidos like '%"+nombre+"%'";  
         consulta = "SELECT\n"
                 + "    Alumnos.Nombres,\n"
                 + "    Alumnos.Apellidos,\n"
                 + "    Alumnos.Grado,\n"
                 + "    SUM(CASE WHEN MONTH(Control_Pagos.fecha) = 1 THEN 1 ELSE 0 END) AS Enero,\n"
                 + "    SUM(CASE WHEN MONTH(Control_Pagos.fecha) = 2 THEN 1 ELSE 0 END) AS Febrero,\n"
                 + "	SUM(CASE WHEN MONTH(Control_Pagos.fecha) = 3 THEN 1 ELSE 0 END) AS Marzo,\n"
                 + "	SUM(CASE WHEN MONTH(Control_Pagos.fecha) = 4 THEN 1 ELSE 0 END) AS Abril,\n"
                 + "	SUM(CASE WHEN MONTH(Control_Pagos.fecha) = 5 THEN 1 ELSE 0 END) AS Mayo,\n"
                 + "	SUM(CASE WHEN MONTH(Control_Pagos.fecha) = 6 THEN 1 ELSE 0 END) AS Junio,\n"
                 + "	SUM(CASE WHEN MONTH(Control_Pagos.fecha) = 7 THEN 1 ELSE 0 END) AS Julio,\n"
                 + "	SUM(CASE WHEN MONTH(Control_Pagos.fecha) = 8 THEN 1 ELSE 0 END) AS Agosto,\n"
                 + "	SUM(CASE WHEN MONTH(Control_Pagos.fecha) = 9 THEN 1 ELSE 0 END) AS Septiembre,\n"
                 + "	SUM(CASE WHEN MONTH(Control_Pagos.fecha) = 10 THEN 1 ELSE 0 END) AS Octubre,\n"
                 + "	SUM(CASE WHEN MONTH(Control_Pagos.fecha) = 11 THEN 1 ELSE 0 END) AS Noviembre,\n"
                 + "	SUM(CASE WHEN MONTH(Control_Pagos.fecha) = 12 THEN 1 ELSE 0 END) AS Diciembre,\n"
                 + "    YEAR(Control_Pagos.fecha) AS Anio\n"
                 + "FROM\n"
                 + "    Control_Pagos\n"
                 + "INNER JOIN Pagos ON fk_pago = Pagos.id\n"
                 + "INNER JOIN Alumnos ON Alumnos.Identidad = Pagos.Alumno\n"
                 + "where Alumnos.Nombres like '%"+nombre+"%' or Alumnos.Apellidos like '%"+nombre+"%'\n"
                 + "GROUP BY\n"
                 + "    Alumnos.Nombres,\n"
                 + "    Alumnos.Apellidos,\n"
                 + "    Alumnos.Grado,\n"
                 + "    YEAR(Control_Pagos.fecha)";
            
        
        String datos[] = new String[14];
        
        try{
 Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(consulta);            
            while(rs.next()){
                datos[0] = rs.getString("Nombres");
                datos[1] = rs.getString("Apellidos");
                datos[2] = rs.getInt("Enero")>=1 ? "Pagado": "Pendiente";
                datos[3] = rs.getInt("Febrero")>=1 ? "Pagado": "Pendiente";
                datos[4] = rs.getInt("Marzo")>=1 ? "Pagado": "Pendiente";
                datos[5] = rs.getInt("Abril")>=1 ? "Pagado": "Pendiente";
                datos[6] = rs.getInt("Mayo")>=1 ? "Pagado": "Pendiente";
                datos[7] = rs.getInt("Junio")>=1 ? "Pagado": "Pendiente";
                datos[8] = rs.getInt("Julio")>=1 ? "Pagado": "Pendiente";
                datos[9] = rs.getInt("Agosto")>=1 ? "Pagado": "Pendiente";
                datos[10] = rs.getInt("Septiembre")>=1 ? "Pagado": "Pendiente";
                datos[11] = rs.getInt("Octubre")>=1 ? "Pagado": "Pendiente";
                datos[12] = rs.getInt("Noviembre")>=1 ? "Pagado": "Pendiente";
                datos[13] = rs.getInt("Diciembre")>=1 ? "Pagado": "Pendiente";
                modelo.addRow(datos);
            }
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
                tcr.setHorizontalAlignment(SwingConstants.RIGHT);
                PagosPorAlumnos.tblPagos.setModel(modelo);
           // MOSTRARCARGO.tblCa.setModel(modelo);//la tabla se actualiza. HacerCalculos(r);
        }catch (SQLException ex){
            
            Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            }
     
     
    public static void setListarVentas(String nombre) {
        DefaultTableModel modelo = (DefaultTableModel) MostrarFacturas.tblPagos.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);

        }
        String consulta = "select id, CONCAT(Nombres, ' ', Apellidos) Nombre, No_Factura, Fecha, Total, Anulada \n"
                + "from Pagos inner join Alumnos on Alumnos.Identidad = Pagos.Alumno\n"
                + "where Alumnos.Nombres like '%" + nombre + "%' or Alumnos.Apellidos like '%" + nombre + "%' order by No_Factura";

        String datos[] = new String[6];

        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            while (rs.next()) {
                datos[0] = rs.getString("id");
                datos[1] = rs.getString("Nombre");
                datos[2] = rs.getString("No_Factura");
                datos[3] = rs.getString("Fecha");
                datos[4] = rs.getString("Total");
                datos[5] = rs.getString("Anulada");
                modelo.addRow(datos);
            }
                    MostrarFacturas.tblPagos.getColumnModel().getColumn(0).setMaxWidth(0);
                    MostrarFacturas.tblPagos.getColumnModel().getColumn(0).setMinWidth(0);
                    MostrarFacturas.tblPagos.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
                    MostrarFacturas.tblPagos.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
                    MostrarFacturas.tblPagos.getColumnModel().getColumn(5).setMaxWidth(0);
                    MostrarFacturas.tblPagos.getColumnModel().getColumn(5).setMinWidth(0);
                    MostrarFacturas.tblPagos.getTableHeader().getColumnModel().getColumn(5).setMaxWidth(0);
                    MostrarFacturas.tblPagos.getTableHeader().getColumnModel().getColumn(5).setMinWidth(0);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.RIGHT);
            MostrarFacturas.tblPagos.setModel(modelo);
            // MOSTRARCARGO.tblCa.setModel(modelo);//la tabla se actualiza. HacerCalculos(r);
        } catch (SQLException ex) {

            Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    
    
    public static boolean AnularFactura(String id_factura){
        String sql = "UPDATE Pagos SET "
           +"Anulada=? "
            +"WHERE id=?";
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setString(1, "1");
        ps.setString(2, id_factura);
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
    
    
    public static void setListarEstadosDeCuenta(String nombre) {
        DefaultTableModel modelo = (DefaultTableModel) MostrarFacturas.tblPagos.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);

        }
        String consulta = "select id, CONCAT(Nombres, ' ', Apellidos) Nombre, No_Factura, Fecha, Total, Anulada \n"
                + "from Pagos inner join Alumnos on Alumnos.Identidad = Pagos.Alumno\n"
                + "where Alumnos.Nombres like '%" + nombre + "%' or Alumnos.Apellidos like '%" + nombre + "%' order by No_Factura";

        String datos[] = new String[6];

        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            while (rs.next()) {
                datos[0] = rs.getString("id");
                datos[1] = rs.getString("Nombre");
                datos[2] = rs.getString("No_Factura");
                datos[3] = rs.getString("Fecha");
                datos[4] = rs.getString("Total");
                datos[5] = rs.getString("Anulada");
                modelo.addRow(datos);
            }
                    MostrarFacturas.tblPagos.getColumnModel().getColumn(0).setMaxWidth(0);
                    MostrarFacturas.tblPagos.getColumnModel().getColumn(0).setMinWidth(0);
                    MostrarFacturas.tblPagos.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
                    MostrarFacturas.tblPagos.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
                    MostrarFacturas.tblPagos.getColumnModel().getColumn(5).setMaxWidth(0);
                    MostrarFacturas.tblPagos.getColumnModel().getColumn(5).setMinWidth(0);
                    MostrarFacturas.tblPagos.getTableHeader().getColumnModel().getColumn(5).setMaxWidth(0);
                    MostrarFacturas.tblPagos.getTableHeader().getColumnModel().getColumn(5).setMinWidth(0);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.RIGHT);
            MostrarFacturas.tblPagos.setModel(modelo);
            // MOSTRARCARGO.tblCa.setModel(modelo);//la tabla se actualiza. HacerCalculos(r);
        } catch (SQLException ex) {

            Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
}
