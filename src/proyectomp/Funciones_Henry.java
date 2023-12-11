/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectomp;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author espin
 */
public class Funciones_Henry {
    private static conexion.Conexion con = new Conexion();
    private static Connection conexion = con.getConexion();
    private  static PreparedStatement ps = null;
    
    //Lo que muestra los proveedore para seleccionarlo en la compra
        public static void setListarPro(String buscar){
            DefaultTableModel modelo = (DefaultTableModel)MostrarProveedores.tblPro.getModel();
  
            while(modelo.getRowCount() > 0 ){
                modelo.removeRow(0);
                
            }
            
            String sql = "";
            if(buscar.equals("")){
                sql = Sentencias_Henry.LISTAR_PROVEEDORES;
                
            } 
            else{
                sql = "SELECT * FROM PROVEEDOR WHERE ("
                        + "Id_Pro LIKE'"+buscar+"%' OR "
                        + "Nombre_Pro LIKE'"+buscar+"%' OR "
                        + "Telefono_Pro LIKE'"+buscar+"%' OR "
                        + "EMail_Pro LIKE'"+buscar+"%' OR "
                        + "RTN_Pro LIKE'"+buscar+"%'"
                       + ")";
            }
            
        
        String datos[] = new String[5];
        
        try{
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0] = rs.getString("Id_Pro");
                datos[1] = rs.getString("Nombre_Pro");
                datos[2] = rs.getString("Telefono_Pro");
                datos[3] = rs.getString("EMail_Pro");
                datos[4] = rs.getString("RTN_Pro");
                modelo.addRow(datos);
                
            }
        }catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            }
        
        //Lo que muestra los productos del inventario para la compra
        public static void setListarInventario(String buscar){
            DefaultTableModel modelo = (DefaultTableModel)COMPRA_MATERIA_PRIMA.tblInventario.getModel();
            while(modelo.getRowCount() > 0 ){
                
                
                modelo.removeRow(0); 
            }
            
            String sql = "";
            if(buscar.equals("")){
                sql = Sentencias_Henry.LISTAR_INVENTARIOS;
                
            } 
            else{
                sql = "SELECT * FROM INVENTARIO WHERE ("
                        + "Id_IMP LIKE'"+buscar+"%' OR "
                        + "Marca_IMP LIKE'"+buscar+"%' OR "
                        + "Unidad_Medida_IMP LIKE'"+buscar+"%' OR "
                        + "Nombre_IMP LIKE'"+buscar+"%' OR "
                        + "Existencia_IMP LIKE'"+buscar+"%'"
                       + ")";
            }
            
        
        String datos[] = new String[5];
        
        try{
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0] = rs.getString("Id_IMP");
                datos[1] = rs.getString("Marca_IMP");
                datos[2] = rs.getString("Unidad_Medida_IMP");
                datos[3] = rs.getString("Nombre_IMP");
                datos[4] = rs.getString("Existencia_IMP");
                modelo.addRow(datos);
                
            }
        }catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            }
        
        
         public static void setListarInventarioupdate(String buscar){
            DefaultTableModel modelo = (DefaultTableModel)COMPRA_MATERIA_PRIMA_UPDATE.tblInventario.getModel();
            while(modelo.getRowCount() > 0 ){
                
                
                modelo.removeRow(0); 
            }
            
            String sql = "";
            if(buscar.equals("")){
                sql = Sentencias_Henry.LISTAR_INVENTARIOS;
                
            } 
            else{
                sql = "SELECT * FROM INVENTARIO WHERE ("
                        + "Id_IMP LIKE'"+buscar+"%' OR "
                        + "Marca_IMP LIKE'"+buscar+"%' OR "
                        + "Unidad_Medida_IMP LIKE'"+buscar+"%' OR "
                        + "Nombre_IMP LIKE'"+buscar+"%' OR "
                        + "Existencia_IMP LIKE'"+buscar+"%'"
                       + ")";
            }
            
        
        String datos[] = new String[5];
        
        try{
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0] = rs.getString("Id_IMP");
                datos[1] = rs.getString("Marca_IMP");
                datos[2] = rs.getString("Unidad_Medida_IMP");
                datos[3] = rs.getString("Nombre_IMP");
                datos[4] = rs.getString("Existencia_IMP");
                modelo.addRow(datos);
                
            }
        }catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            }
    
     //FUNCIONES PROVEEDORES
        public static boolean isRegisterProveedor(Sentencias_Henry s){
        String sql = Sentencias_Henry.REGISTRAR_PROVEEDOR;
        
        try{
        ps = conexion.prepareStatement(sql);
        
        ps.setInt(1, s.getId_Pro());
        ps.setString(2, s.getNombre_Pro());
        ps.setString(3, s.getDireccion_Pro());
        ps.setString(4, s.getTelefono_Pro());
        ps.setString(5, s.getEMail_Pro());
        ps.setString(6, s.getRTN_Pro());
        ps.setString(7, s.getTipo_Pro());
        ps.setString(8, s.getContacto_Pro());
        ps.setString(9, s.getCel_Contacto_Pro());
        
        
        
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            return false;
//            
        }
    }
    
      public static boolean isUpdateProveedor(Sentencias_Henry s){
        String sql = Sentencias_Henry.UPDATE_PROVEEDOR;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setString(1, s.getNombre_Pro());
        ps.setString(2, s.getDireccion_Pro());
        ps.setString(3, s.getTelefono_Pro());
        ps.setString(4, s.getEMail_Pro());
        ps.setString(5, s.getRTN_Pro());
        ps.setString(6, s.getTipo_Pro());
        ps.setString(7, s.getContacto_Pro());
        ps.setString(8, s.getCel_Contacto_Pro());
        ps.setInt(9, s.getId_Pro());
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
      
        public static boolean isDeleteProveedor(Sentencias_Henry s){
        String sql = Sentencias_Henry.ELIMINAR_PROVEEDOR;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setInt(1, s.getId_Pro());
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            return false;
       }
    }
    
        
        public static void setListarProveedor(String buscar){
            DefaultTableModel modelo = (DefaultTableModel)PROVEEDOR.tblPro.getModel();
  
            while(modelo.getRowCount() > 0 ){
                modelo.removeRow(0);
                
            }
            
            String sql = "";
            if(buscar.equals("")){
                sql = Sentencias_Henry.LISTAR_PROVEEDORES;
                
            } 
            else{
                sql = "SELECT * FROM PROVEEDOR WHERE ("
                        + "Id_Pro LIKE'"+buscar+"%' OR "
                        + "Nombre_Pro LIKE'"+buscar+"%' OR "
                        + "Direccion_Pro LIKE'"+buscar+"%' OR "
                        + "Telefono_Pro LIKE'"+buscar+"%' OR "
                        + "EMail_Pro LIKE'"+buscar+"%' OR "
                        + "RTN_Pro LIKE'"+buscar+"%' OR "
                        + "Tipo_Pro LIKE'"+buscar+"%' OR "
                        + "Contacto_Pro LIKE'"+buscar+"%' OR "
                        + "Cel_Contacto_Pro LIKE'"+buscar+"%'"
                       + ")";
            }
            
        
        String datos[] = new String[9];
        
        try{
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0] = rs.getString("Id_Pro");
                datos[1] = rs.getString("Nombre_Pro");
                datos[2] = rs.getString("Direccion_Pro");
                datos[3] = rs.getString("Telefono_Pro");
                datos[4] = rs.getString("EMail_Pro");
                datos[5] = rs.getString("RTN_Pro");
                datos[6] = rs.getString("Tipo_Pro");
                datos[7] = rs.getString("Contacto_Pro");
                datos[8] = rs.getString("Cel_Contacto_Pro");
                modelo.addRow(datos);
                
            }
        }catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            }
        
        public static String extraerIdMaxProveedor(){
            
            String sql = "SELECT MAX(Id_Pro)FROM PROVEEDOR";
            int Id_Pro=0;
            
            try{
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                Id_Pro = rs.getInt(1);    
            }
            if(Id_Pro == 0){
                Id_Pro =1;
            }else{
                Id_Pro = Id_Pro +1;
                
            }
            
            return String.valueOf(Id_Pro);
        }catch (SQLException ex){
            return null;
            
        }
    }
        
        
        
        //COMPRAS
        public static boolean isRegisterCompra(Sentencias_Henry s){
        String sql = Sentencias_Henry.REGISTRAR_COMPRA;
        
        try{
        ps = conexion.prepareStatement(sql);
        
        ps.setInt(1, s.getId_CM());
        ps.setString(2, s.getFecha_CM());
        ps.setString(3, s.getFecha_Regis_CM());
        ps.setString(4, s.getNo_Factura_CM());
        ps.setInt(5, s.getFK_Id_Pro());
        
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            return false;
//            
        }
    }
        
        //Lo de las compras
        public static void setListarCompras(String buscar){
            DefaultTableModel modelo = (DefaultTableModel)Mostrar_Compras.tblCompras.getModel();
            while(modelo.getRowCount() > 0 ){
                modelo.removeRow(0); 
            }
            
            String sql = "";
            if(buscar.equals("")){
                sql = Sentencias_Henry.LISTAR_COMPRAS;
                
            } 
            else{
                sql = "SELECT * FROM COMPRA_MATERIA_PRIMA WHERE ("
                        + "Id_CM LIKE'"+buscar+"%' OR "
                        + "Fecha_CM LIKE'"+buscar+"%' OR "
                        + "Fecha_Regis_CM LIKE'"+buscar+"%' OR "
                        + "No_Factura_CM LIKE'"+buscar+"%'"
                       + ")";
            }
                
         String datos[] = new String[9];
        
        try{
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0] = rs.getString("Id_CM");
                datos[1] = rs.getString("Fecha_CM");
                datos[2] = rs.getString("Fecha_Regis_CM");
                datos[3] = rs.getString("No_Factura_CM");
                datos[4] = rs.getString("Nombre_Pro");
                datos[5] = rs.getString("Id_Pro");
                datos[6] = rs.getString("Telefono_Pro");
                datos[7] = rs.getString("EMail_Pro");
                datos[8] = rs.getString("RTN_Pro");
                modelo.addRow(datos);
                
            }
        }catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
     }
        
        public static String extraerIdMaxCompra(){
            
            String sql = "SELECT MAX(Id_CM)FROM COMPRA_MATERIA_PRIMA";
            int Id_CM=0;
            
            try{
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                Id_CM = rs.getInt(1);    
            }
            if(Id_CM == 0){
                Id_CM =1;
            }else{
                Id_CM = Id_CM +1;
                
            }
            
            return String.valueOf(Id_CM);
        }catch (SQLException ex){
            return null;
            
        }
        }
        
        
        
        //Detalles Compra
         public static void isBuscarDetalles(Sentencias_Henry s){
          String sql = Sentencias_Henry.BUSCAR_DETALLES;
          try{
            
              ps = conexion.prepareStatement(sql);
              ps.setInt(1, s.getId_CM());
              ResultSet rs = ps.executeQuery();
              
              while (rs.next()) {  
                  s.setId_Compra(rs.getInt(1));
              }
          } catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
      }

         
         
        
        public static boolean isRegisterDetalleCompra(Sentencias_Henry s){
        String sql = Sentencias_Henry.REGISTRAR_DETALLE_COMPRA;
        
        try{
        ps = conexion.prepareStatement(sql);
        
        ps.setInt(1, s.getId_DE());
        ps.setDouble(2, s.getCantidad_DE());
        ps.setDouble(3, s.getPrecio_DE());
        ps.setDouble(4, s.getTotal_DE());
        ps.setInt(5, s.getFK_Id_CM());
        ps.setInt(6, s.getFK_Id_IMP());
        
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            return false;
//            
        }
    }
        
        
      
      
        //Agregar las compras al inventario
      public static void isUpdateInventario(Sentencias_Henry s){
          String sql = Sentencias_Henry.Obtener_Existencia;
          try{
              
             // Statement st = conexion.createStatement();
           // ResultSet rs = st.executeQuery(sql);
            
            
              ps = conexion.prepareStatement(sql);
              ps.setInt(1, s.getId_IMP());
              ResultSet rs = ps.executeQuery();
              //ps.executeUpdate();
              
              while (rs.next()) {  
                  s.setExistencia_IMP(rs.getInt(1));
                  
                  
                  
              }
          } catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
          
         
      }
      
      
       public static boolean isUpdateInventa(Sentencias_Henry s){
        String sql = Sentencias_Henry.UPDATE_Inventario;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setDouble(1, s.getExistencia_IMP());
        ps.setInt(2, s.getId_IMP());
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
       
       
       
           public static void setListarDetalleCompra(String Id_Pla){
            DefaultTableModel modelo = (DefaultTableModel)COMPRA_MATERIA_PRIMA_UPDATE.tblDetalleCompra.getModel();
            
            //modelo.fireTableDataChanged();
 
            
            while(modelo.getRowCount() > 0 ){
                modelo.removeRow(0);
                
            }
            
            
               String sql = "Select Id_DE, Nombre_IMP, Id_IMP, Cantidad_DE, Precio_DE, Total_DE "
                + "from INVENTARIO "
                + "inner join DETALLE_COMPRA "
                + "on FK_Id_IMP = ID_IMP "
                + "inner join COMPRA_MATERIA_PRIMA "
                + "on FK_Id_CM = Id_CM "
                + "where Id_CM = '" +Id_Pla+ "' ";
            
            
        
        String datos[] = new String[6];
        
        try{
 Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0] = rs.getString("Id_DE");
                datos[1] = rs.getString("Nombre_IMP");
                datos[2] = rs.getString("Id_IMP");
                datos[3] = rs.getString("Cantidad_DE");
                datos[4] = rs.getString("Precio_DE");
                datos[5] = rs.getString("Total_DE");
                modelo.addRow(datos);
                
            }
           // MOSTRARCARGO.tblCa.setModel(modelo);//la tabla se actualiza. HacerCalculos(r);
        }catch (SQLException ex){
            
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
           
    public static boolean isDeleteCompra(Sentencias_Henry s){
        String sql = Sentencias_Henry.BORRAR_COMPRA;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setInt(1, s.getId_CM());
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            return false;
       }
    }
    public static boolean isDeleteDETALLECOMPRA(Sentencias_Henry s){
        String sql = Sentencias_Henry.BORRAR_DETALLE_COMPRA;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setInt(1, s.getFK_Id_CM());
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            return false;
       }
    }
    
    public static String extraerIdMaxLocal(){
            
            String sql = "SELECT MAX(Id_L)FROM LOCAL_MP";
            int Id_L=0;
            
            try{
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                Id_L = rs.getInt(1);    
            }
            if(Id_L == 0){
                Id_L =1;
            }else{
                Id_L = Id_L;
                
            }
            
            return String.valueOf(Id_L);
        }catch (SQLException ex){
            return null;
            
        }   
}
    
    public static String extraerIdMaxSAR(){
            
            String sql = "SELECT MAX(Id_sar)FROM SAR";
            int Id_sar=0;
            
            try{
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                Id_sar = rs.getInt(1);    
            }
            if(Id_sar == 0){
                Id_sar =1;
            }else{
                Id_sar = Id_sar;
                
            }
            
            return String.valueOf(Id_sar);
        }catch (SQLException ex){
            return null;
            
        }   
}
           
}