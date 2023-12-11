/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

/**
 *
 * @author angel
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Calix
 */
public class Conexion {
      public static Connection conection = null;
    public Connection getConexion() {
		try {
			
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                      conection=DriverManager.getConnection("jdbc:sqlserver://DESKTOP-VRUMJHI;databaseName=IDE", "sa", "1234");
                      return conection;
                                            // conection=DriverManager.getConnection("jdbc:sqlserver://;database=PROYECTO_MP;integratedSecurity=true;");
                        
                    } 
                       catch (ClassNotFoundException | SQLException ex) {
                           JOptionPane.showMessageDialog(null, ex);
			return null;
			
		}
                

	}
	
    
}
    


