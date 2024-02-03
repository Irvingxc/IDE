/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Irving Calix
 */
public class Consultas_Catalogo {
    
    private static conexion.Conexion con = new Conexion();
    private static Connection conexion = con.getConexion();
    private  static PreparedStatement ps = null;
    
    public static boolean PruductoValidateImpuesto(String id_producto){
                String sql = "select Excento from Catalogo_Productos where id =?;";
                try{        
            Statement st = conexion.createStatement();
            
            ps = conexion.prepareStatement(sql);
            ps.setString(1, id_producto);
            ResultSet rs = ps.executeQuery();
            boolean valor =false;
            
            if(rs.next()){
                
                valor = rs.getBoolean(1);
                //JOptionPane.showMessageDialog(null,valor);
//            }
                
            }
            return valor;
        }catch (SQLException ex){
            Logger.getLogger(Consultas_Catalogo.class.getName()).log(Level.SEVERE, null, ex);
           return false;
            
        }
             }
    
}
