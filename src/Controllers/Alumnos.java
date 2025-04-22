/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.DefaultComboBoxModel;
import Models.Encargados;
import Views.Matricula;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyectomp.Funciones;
import java.sql.Statement;
import java.sql.ResultSet;
import Models.Alumno;
import Views.Cobranza;
import Views.MostrarFacturas;
import Views.SeleccionarAlumno;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.sql.CallableStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Irving Calix
 */
public class Alumnos {
    private static conexion.Conexion con = new Conexion();
    private static Connection conexion = con.getConexion();
    private  static PreparedStatement ps = null;
    
    public static boolean isRegisterAlumno(Alumno s){
        String REGISTRAR = "INSERT INTO Alumnos("
            +"Identidad,"+"Nombres,"+"Apellidos,"+"Cliente,"+"Grado,"+"ValorMatricula,"+"ValorMensualidad,"+"FechaMatricula)"
            +"VALUES(?,?,?,?,?,?,?,?)";
        String sql = REGISTRAR;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setString(1, s.getIdentidad());
        ps.setString(2, s.getNombres());
        ps.setString(3, s.getApellidos());
        ps.setInt(4, s.getIdCliente());
        ps.setString(5, s.getGrado());
        ps.setInt(6, s.getValorMatricula());
        ps.setInt(7, s.getValorMensualidad());
        ps.setString(8, s.getFechaMatricula());
        
        
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
             Logger.getLogger(Alumnos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static DefaultComboBoxModel<Encargados> CargarEncargados(){
        DefaultComboBoxModel<Encargados> comboBoxModel = new DefaultComboBoxModel<>();

        // Conectar a la base de datos y recuperar datos
        try {
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id, Nombres, Apellidos FROM Clientes");

            // Crear objetos Persona y agregarlos al modelo
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("Nombres");
                String apellido = resultSet.getString("Apellidos");
                Encargados encargados = new Encargados(id, nombre, apellido);
                comboBoxModel.addElement(encargados);
            }
            
            // Cerrar recursos
            resultSet.close();
            statement.close();
            return comboBoxModel;
        } catch (SQLException e) {
             Logger.getLogger(Alumnos.class.getName()).log(Level.SEVERE, null, e);
             return null;
        }
    }
    
    
    public static void setListarAlumnos(Alumno s) {
        String LISTARCEL = "SELECT * FROM Alumnos WHERE Identidad=?";
        String sql = LISTARCEL;
        try {

            Statement st = conexion.createStatement();

            ps = conexion.prepareStatement(sql);
            ps.setString(1, s.getIdentidad());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                s.setNombres(rs.getString(2));
                s.setApellidos(rs.getString(3));
                s.setGrado(rs.getString(5));
                s.setValorMensualidad(rs.getInt(7));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Alumnos.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public static void setListarAlumnos(String nombre) {
        DefaultTableModel modelo = (DefaultTableModel) SeleccionarAlumno.tblAlumnos.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);

        }
        String consulta = "SELECT CONCAT(Nombres, ' ', Apellidos) Nombre, Identidad, Grado FROM Alumnos\n"
                + "where Alumnos.Nombres like '%" + nombre + "%' or Alumnos.Apellidos like '%" + nombre+
        "%' order by Identidad";

        String datos[] = new String[3];

        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            while (rs.next()) {
                datos[0] = rs.getString("Nombre");
                datos[1] = rs.getString("Identidad");
                datos[2] = rs.getString("Grado");
                modelo.addRow(datos);
            }
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.RIGHT);
            SeleccionarAlumno.tblAlumnos.setModel(modelo);
            // MOSTRARCARGO.tblCa.setModel(modelo);//la tabla se actualiza. HacerCalculos(r);
        } catch (SQLException ex) {

            Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    
    
    public static void setListarAlumnosPorEstado(String nombre, int anio, String fecha) {
        DefaultTableModel modelo = (DefaultTableModel) Cobranza.tblPagos.getModel();
    while (modelo.getRowCount() > 0) {
        modelo.removeRow(0);
    }

    String datos[] = new String[4];

    try {
        
        CallableStatement cs = conexion.prepareCall("{ call sp_AlumnosSinPagoAntesDeFecha(?, ?, ?) }"); 
        cs.setInt(1, anio); // por ejemplo: 2024
        cs.setString(2, fecha); 
        cs.setString(3, nombre);

        ResultSet rs = cs.executeQuery();
        while (rs.next()) {
            datos[0] = rs.getString("N_Alumno");
            datos[1] = rs.getString("Identidad");
            datos[2] = rs.getString("Grado");
            datos[3] = rs.getString("N_Cliente");
            modelo.addRow(datos);
        }
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.RIGHT);
        Cobranza.tblPagos.setModel(modelo);

    } catch (SQLException ex) {
        Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    
}
