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
    
    
    public static void setListarAlumnos(Alumno s){
                String LISTARCEL = "SELECT * FROM Alumnos WHERE Identidad=?";
                String sql = LISTARCEL;
                try{
        
            Statement st = conexion.createStatement();
            
            ps = conexion.prepareStatement(sql);
            ps.setString(1, s.getIdentidad());
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                s.setNombres(rs.getString(2));
                s.setApellidos(rs.getString(3));
                s.setGrado(rs.getString(5));
                s.setValorMensualidad(rs.getInt(7));
               
                
            }
        }catch (SQLException ex){
            Logger.getLogger(Alumnos.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    
    }
    
}
