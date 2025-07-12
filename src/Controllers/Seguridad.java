/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;
import Views.Bitacora;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.CallableStatement;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;

/**
 *
 * @author Irving Calix
 */
public class Seguridad {
    
    private static conexion.Conexion con = new Conexion();
    private static Connection conexion = con.getConexion();
    private  static PreparedStatement ps = null;
    
     public static boolean isRegisterBitacora(int user, int idaccion, String accion, String modulo) {
    String sql = "{CALL sp_InsertarBitacoraSeguridad(?, ?, ?, ?)}";

    try {
        CallableStatement cs = conexion.prepareCall(sql);
        cs.setInt(1, user);
        cs.setInt(2, idaccion);
        cs.setString(3, accion);
        cs.setString(4, modulo);

        cs.execute();
        return true;
    } catch (SQLException ex) {
        Logger.getLogger(Seguridad.class.getName()).log(Level.SEVERE, null, ex);
        return false;
    }
}
     
     public static void setListarBitacoraFlexible(java.util.Date fechaInicio, java.util.Date fechaFin, String modulo) {
         DefaultTableModel modelo = (DefaultTableModel) Bitacora.tblBitacora.getModel();
    while (modelo.getRowCount() > 0) {
        modelo.removeRow(0);
    }

    String datos[] = new String[5]; // id, usuario, accion, fecha, id_accion, modulo

    try {
        String sql = "SELECT id, usuario, accion, fecha, id_accion, modulo " +
                     "FROM dbo.fn_BitacoraFlexible(?, ?, ?)";

        PreparedStatement ps = conexion.prepareStatement(sql);

        if (fechaInicio != null) {
            ps.setTimestamp(1, new java.sql.Timestamp(fechaInicio.getTime()));
        } else {
            ps.setNull(1, java.sql.Types.TIMESTAMP);
        }

        if (fechaFin != null) {
            ps.setTimestamp(2, new java.sql.Timestamp(fechaFin.getTime()));
        } else {
            ps.setNull(2, java.sql.Types.TIMESTAMP);
        }

        if (modulo != null && !modulo.trim().isEmpty()) {
            ps.setString(3, modulo);
        } else {
            ps.setNull(3, java.sql.Types.VARCHAR);
        }

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            datos[0] = rs.getString("id_accion");
            datos[1] = rs.getString("accion");
            datos[2] = rs.getString("modulo");
            datos[4] = rs.getString("fecha");
            datos[3] = rs.getString("usuario");
            modelo.addRow(datos);
        }

        Bitacora.tblBitacora.setModel(modelo);

    } catch (SQLException ex) {
        Logger.getLogger(Seguridad.class.getName()).log(Level.SEVERE, null, ex);
    }
}


    
}
