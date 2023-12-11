/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectomp;

import proyectomp.Mostrar_Clientes;
import proyectomp.EMPLEADOS;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author angel
 */
public class Funciones_Angel {
      private static conexion.Conexion con = new Conexion();
    private static Connection conexion = con.getConexion();
    private  static PreparedStatement ps = null;
    
    public static boolean isRegister(Sentencias_Angel s){
        String sql = Sentencias_Angel.REGISTRAR;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setString(1, s.getTelefono_CL());
        ps.setString(2, s.getNombre_CL());
        ps.setString(3, s.getApellidos_CL());
        ps.setString(4, s.getDireccion_CL());
        ps.setString(5, s.getRTN());
        ps.setString(6, s.getIdentidad_CL());
       
        
        
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
                     Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }
    }
    
      public static boolean isUpdate(Sentencias_Angel s){
        String sql = Sentencias_Angel.UPDATE;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setString(3, s.getTelefono_CL());
        ps.setString(1, s.getNombre_CL());
        ps.setString(2, s.getApellidos_CL());
        ps.setString(5, s.getDireccion_CL());
        ps.setString(4, s.getRTN());
        ps.setString(6, s.getTelefono_CL());
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
         Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }
    }
      
        public static boolean isDelete(Sentencias_Angel s){
        String sql = Sentencias_Angel.ELIMINAR;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setString(1, s.getTelefono_CL());
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            return false;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public static void setListar(String buscar){
            DefaultTableModel modelo = (DefaultTableModel)Mostrar_Clientes.jTable1.getModel();
            modelo.fireTableDataChanged();
            
            while(modelo.getRowCount()>0){
                modelo.removeRow(0);
                
            }
            
            String sql = "";
            if(buscar.equals("")){
                sql = Sentencias_Angel.LISTAR;
                
            } 
            else{
                sql = "SELECT * FROM CLIENTES WHERE ("
                      //  + "Id_ca LIKE' "+buscar+"%' OR "
                       // + "Tipo_ca LIKE' "+buscar+"%' OR "
//                        + "Nombre_ca LIKE' "+buscar+"%' OR "
 //                       + "Funciones_ca LIKE' "+buscar+"%' OR "
//                        + "Sueldos_ca LIKE'"+buscar+"%'"
//                        + ")";
                        + "Nombre_CL LIKE'"+buscar+"%'"
                        + ")";
            }
            
        
        String datos[] = new String[5];
        
        try{
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0] = rs.getString("Telefono");
                datos[1] = rs.getString("Nombres");
                datos[2] = rs.getString("Apellidos");
                datos[3] = rs.getString("Direccion");
                modelo.addRow(datos);
                
            }
        }catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            }
        
      /*  public static String extraerIdMax(){
            
            String sql = "SELECT MAX(Id_ca)FROM CARGOS";
            int Id_ca=0;
            
            try{
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                Id_ca = rs.getInt(1);    
            }
            if(Id_ca == 0){
                Id_ca =1;
            }else{
                Id_ca = Id_ca +1;
                
            }
            
            return String.valueOf(Id_ca);
        }catch (SQLException ex){
            return null;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        }*/
        
        

        
        
        
        
        
        //funciones productos
    
         public static boolean isRegister_P(Sentencias_Angel s){
        String sql = Sentencias_Angel.REGISTRAR_P;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setInt(1, s.getId_P());
        ps.setString(2, s.getNombre_P());
        ps.setDouble(3, s.getPrecio_P());
        ps.setString(4, s.getDescripcion_P());
        ps.setString(5, s.getTamanio_P());
        ps.setString(6, s.getNum_Piezas_P());
        ps.setInt(7, s.getExistencia_P());
        
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            return false;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      public static boolean isUpdate_P(Sentencias_Angel s){
        String sql = Sentencias_Angel.UPDATE_P;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setString(1, s.getNombre_P());
        ps.setDouble(2, s.getPrecio_P());
        ps.setString(3, s.getDescripcion_P());
        ps.setString(4, s.getTamanio_P());
        ps.setString(5, s.getNum_Piezas_P());
        //ps.setInt(6, s.getExistencia_P());
        ps.setInt(6, s.getId_P());
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            return false;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
        public static boolean isDelete_P(Sentencias_Angel s){
        String sql = Sentencias_Angel.ELIMINAR_P;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setInt(1, s.getId_P());
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            return false;
            
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        public static boolean isDelete_Detalle(Sentencias_Angel s){
        String sql = "DELETE FROM DETALLE_PRODUCTO WHERE FK_Pro=?";
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setInt(1, s.getId_P());
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            return false;
//            
        }
    }
    
        public static void setListar_P(String buscar){
            DefaultTableModel modelo = (DefaultTableModel)MOSTRAR_PRODUCTOS.jTable1.getModel();
            modelo.fireTableDataChanged();
            
            while(modelo.getRowCount()>0){
                modelo.removeRow(0);
                
            }
            
            String sql = "";
            if(buscar.equals("")){
                sql = Sentencias_Angel.LISTAR_P;
                
            } 
            else{
                sql = "SELECT * FROM PRODUCTOS WHERE ("
                      //  + "Id_ca LIKE' "+buscar+"%' OR "
                       // + "Tipo_ca LIKE' "+buscar+"%' OR "
//                        + "Nombre_ca LIKE' "+buscar+"%' OR "
 //                       + "Funciones_ca LIKE' "+buscar+"%' OR "
//                        + "Sueldos_ca LIKE'"+buscar+"%'"
//                        + ")";
                        + "Nombre_P LIKE'"+buscar+"%'"
                        + ")";
            }
            
        
        String datos[] = new String[7];
        
        try{
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0] = rs.getString("Id_P");
                datos[1] = rs.getString("Nombre_P");
                datos[2] = rs.getString("Precio_P");
                datos[3] = rs.getString("Descripcion_P");
                datos[4] = rs.getString("Tamanio_P");
                datos[5] = rs.getString("Num_Piezas_P");
                datos[6] = rs.getString("Existencia_P");
                modelo.addRow(datos);
                DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
                tcr.setHorizontalAlignment(SwingConstants.RIGHT);
                
                MOSTRAR_PRODUCTOS.jTable1.setModel(modelo);
                MOSTRAR_PRODUCTOS.jTable1.getColumnModel().getColumn(2).setCellRenderer(tcr);
                
            }
        }catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            }
        
        public static String extraerIdMax(){
            
            String sql = "SELECT MAX(Id_P)FROM PRODUCTOS";
            int Id_P=0;
            
            try{
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                Id_P = rs.getInt(1);    
            }
            if(Id_P == 0){
                Id_P =1;
            }else{
                Id_P = Id_P +1;
                
            }
            
            return String.valueOf(Id_P);
        }catch (SQLException ex){
            return null;
//           Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            
        }
            
                
                    
                
            
        
        
        
        
        
//        FUNCIONES EMPLEADOS
          public static boolean isRegister_EM(Sentencias_Angel s){
        String sql = Sentencias_Angel.REGISTRAR_EM;
        
        try{
            
        ps = conexion.prepareStatement(sql);
        ps.setString(1, s.getNombres_E());
        ps.setString(2, s.getApellidos_E());
        ps.setString(3, s.getIdentidad_E());
        ps.setString(4, s.getTelefono_E());
        ps.setString(5, s.getDirecion_E());
        ps.setString(6, s.getGenero_E());
        ps.setString(7, s.getTipo_Contrato_E());
        ps.setString(8, s.getEstado_E());
        ps.setString(9, s.getReferencia_E());
        ps.setString(10, s.getTelefono_Referencia_E());
        ps.setString(11, s.getFecha_Nac_E());
        ps.setString(12, s.getFecha_Reg_E());
        ps.setString(13, s.getFecha_Inicio_E());
        ps.setInt(14, s.getFK_Id_ca());
        ps.setString(15, s.getFoto());
        ps.setString(16, s.getTipo_Cargo());
        ps.setString(17, s.getUsu());
        
         ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
                       Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }
    }
    
      public static boolean isUpdate_EM(Sentencias_Angel s){
        String sql = Sentencias_Angel.UPDATE_EM;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setString(1, s.getNombres_E());
        ps.setString(2, s.getApellidos_E());
        ps.setString(3, s.getIdentidad_E());
        ps.setString(4, s.getTelefono_E());
        ps.setString(5, s.getDirecion_E());
        ps.setString(6, s.getGenero_E());
        ps.setString(7, s.getTipo_Contrato_E());
        ps.setString(8, s.getEstado_E());
        ps.setString(9, s.getReferencia_E());
        ps.setString(10, s.getTelefono_Referencia_E());
        ps.setString(11, s.getFecha_Nac_E());
        ps.setString(12, s.getFecha_Reg_E());
        ps.setString(13, s.getFecha_Inicio_E());
        ps.setInt(14, s.getFK_Id_ca());
      //  ps.setBinaryStream(14, s.getFoto_E()); 
        ps.setString(15, s.getFoto());
        ps.setString(16, s.getTipo_Cargo());
        ps.setString(17, s.getUsu());
        ps.setInt(18, s.getId_E());
       
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
                Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            return false;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
        public static boolean isDelete_EM(Sentencias_Angel s){
        String sql = Sentencias_Angel.ELIMINAR_EM;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setInt(1, s.getId_E());
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            return false;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public static void setListar_EM(String buscar){
            DefaultTableModel modelo = (DefaultTableModel)EMPLEADOS.tblTabla.getModel();
            modelo.fireTableDataChanged();
            
            while(modelo.getRowCount()>0){
                modelo.removeRow(0);
                
            }
            
            String sql = "";
            if(buscar.equals("")){
                sql = Sentencias_Angel.LISTAR_EM;
                
            } 
            else{
                sql = "SELECT * FROM EMPLEADOS WHERE ("
                      //  + "Id_ca LIKE' "+buscar+"%' OR "
                       // + "Tipo_ca LIKE' "+buscar+"%' OR "
//                        + "Nombre_ca LIKE' "+buscar+"%' OR "
 //                       + "Funciones_ca LIKE' "+buscar+"%' OR "
//                        + "Sueldos_ca LIKE'"+buscar+"%'"
//                        + ")";
                        + "Nombres_E LIKE'"+buscar+"%'"
                        + ")";
            }
            
        
        String datos[] = new String[19];
        
        try{
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0] = rs.getString("Id_E");
                datos[1] = rs.getString("Nombres_E");
                datos[2] = rs.getString("Apellidos_E");
                datos[3] = rs.getString("Identidad_E");
                datos[4] = rs.getString("Telefono_E");
                datos[5] = rs.getString("Direccion_E");
                datos[6] = rs.getString("Genero_E");
                datos[7] = rs.getString("Tipo_Contrato_E");
                datos[8] = rs.getString("Estado_E");
                datos[9] = rs.getString("Referencia_E");
                datos[10] = rs.getString("Telefono_Referencia_E");
                datos[11] = rs.getString("Fecha_Nacimiento_E");
                datos[12] = rs.getString("Fecha_Registro_E");
                datos[13] = rs.getString("Fecha_Inicio_E");
                datos[14] = rs.getString("FK_Id_ca");
                datos[15] = rs.getString("Foto");
                datos[16] = rs.getString("Tipo_Cargo");
               // datos[17] = rs.getString("Nombre_ca");
                datos[17] = rs.getString("usuario");
              
                modelo.addRow(datos);
                
            }
        }catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            }
        
        public static void setListar_EMSELECT(String buscar){
            DefaultTableModel modelo = (DefaultTableModel)SELECCIONAR_EMPLEADO.tblTabla.getModel();
            modelo.fireTableDataChanged();
            
            while(modelo.getRowCount()>0){
                modelo.removeRow(0);
                
            }
            
            String sql = "";
            if(buscar.equals("")){
                sql = Sentencias_Angel.LISTAR_EM;
                
            } 
            else{
                sql = "SELECT * FROM EMPLEADOS WHERE ("
                      //  + "Id_ca LIKE' "+buscar+"%' OR "
                       // + "Tipo_ca LIKE' "+buscar+"%' OR "
//                        + "Nombre_ca LIKE' "+buscar+"%' OR "
 //                       + "Funciones_ca LIKE' "+buscar+"%' OR "
//                        + "Sueldos_ca LIKE'"+buscar+"%'"
//                        + ")";
                        + "Nombres_E LIKE'"+buscar+"%'"
                        + ")";
            }
            
        
        String datos[] = new String[17];
        
        try{
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0] = rs.getString("Id_E");
                datos[1] = rs.getString("Nombres_E");
                datos[2] = rs.getString("Apellidos_E");
                datos[3] = rs.getString("Identidad_E");
                datos[4] = rs.getString("Telefono_E");
                datos[5] = rs.getString("Direccion_E");
                datos[6] = rs.getString("Genero_E");
                datos[7] = rs.getString("Tipo_Contrato_E");
                datos[8] = rs.getString("Estado_E");
                datos[9] = rs.getString("Referencia_E");
                datos[10] = rs.getString("Telefono_Referencia_E");
                datos[11] = rs.getString("Fecha_Nacimiento_E");
                datos[12] = rs.getString("Fecha_Registro_E");
                datos[13] = rs.getString("Fecha_Inicio_E");
                datos[14] = rs.getString("FK_Id_ca");
                datos[15] = rs.getString("Foto");
                datos[16] = rs.getString("Tipo_Cargo");
              
                modelo.addRow(datos);
                
            }
        }catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            }
        
        public static String extraerIdMaxEM(){
            
            String sql = "SELECT MAX(Id_E)FROM EMPLEADOS";
            int Id_E=0;
            
            try{
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                Id_E = rs.getInt(1);    
            }
            if(Id_E == 0){
                Id_E =1;
            }else{
                Id_E = Id_E +1;
                
            }
            
            return String.valueOf(Id_E);
        }catch (SQLException ex){
            return null;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        }
            
            public static void setListarCliente(Sentencias_Angel s){
                
                String sql = Sentencias_Angel.LISTARCEL;
                try{
        
            Statement st = conexion.createStatement();
            
            ps = conexion.prepareStatement(sql);
            ps.setString(1, s.getTelefono_CL());
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                s.setTelefono_CL_C(rs.getString(1));
                s.setNombre_CL(rs.getString(2));
                s.setApellidos_CL(rs.getString(3));
                
                
                s.setDireccion_CL(rs.getString(4));
                s.setRTN(rs.getString(5));
                s.setSegunda_Direccion(rs.getString(6));
               
                
            }
        }catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            
            
        
        

     }
            
            
            
            public static boolean isRegisterSar(Sentencias_Angel s){
        String sql = Sentencias_Angel.REGISTRAR_SAR;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setString(1, s.getRango_Del());
        ps.setString(2, s.getRango_Al());
        ps.setString(3, s.getCAI());
        ps.setString(4, s.getFecha_Lim());
        ps.setString(6, s.getNum_Factura());
        ps.setDouble(5, s.getImpuesto_Sar());
        
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
      public static boolean isUpdateSar(Sentencias_Angel s){
        String sql = Sentencias_Angel.UPDATE_SAR;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setString(1, s.getNum_Factura());
        ps.setInt(2, s.getId_Sar());
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
      Logger.getLogger(Funciones_Angel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }      
        }
      
        public static boolean isDeleteSar(Sentencias_Angel s){
        String sql = Sentencias_Angel.ELIMINAR_SAR;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setInt(1, s.getId_Sar());
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            return false;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public static void setListarSar(String buscar){
            DefaultTableModel modelo = (DefaultTableModel)SAR.tblSAR.getModel();
            //modelo.fireTableDataChanged();
            
            
            while(modelo.getRowCount() > 0 ){
                modelo.removeRow(0);
                
            }
            
            String sql = "";
            if(buscar.equals("")){
                sql = Sentencias_Angel.LISTARSAR;
                
            } 
            else{
                sql = "SELECT * FROM LOCAL_MP WHERE ("
                        + "Id_Sar LIKE'"+buscar+"%' OR "
//                        + "Tipo_ca LIKE'"+buscar+"%' OR "
//                        + "Nombre_ca LIKE'"+buscar+"%' OR "
//                       + "Funciones_ca LIKE'"+buscar+"%' OR " 
//                        + "Sueldos_ca LIKE'"+buscar+"%'"
                       + ")";
//                        + "Nombre_ca LIKE'"+buscar+"%'"
//                        + ")";
            }
            
        
        String datos[] = new String[6];
        
        try{
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0] = rs.getString("Id_Sar");
                datos[1] = rs.getString("Rango_Del");
                datos[2] = rs.getString("Rango_Al");
                datos[3] = rs.getString("CAI");
                datos[4] = rs.getString("Fecha_Lim");
                datos[5] = rs.getString("Impuesto_Sar");
                modelo.addRow(datos);
                
            }
           // MOSTRARCARGO.tblCa.setModel(modelo);//la tabla se actualiza. HacerCalculos(r);
        }catch (SQLException ex){
            Logger.getLogger(Funciones_Angel.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            }
        
        public static String extraerIdMaxSar(){
            
            String sql = "SELECT MAX(Id_Sar)FROM SAR";
            int Id_Sar=0;
            
            try{
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                Id_Sar = rs.getInt(1);    
            }
            if(Id_Sar == 0){
                Id_Sar =1;
            }else{
                Id_Sar = Id_Sar +1;
                
            }
            
            return String.valueOf(Id_Sar);
        }catch (SQLException ex){
            return null;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        }
        
 public static boolean isRegisterInve(Sentencias_Angel s){
        String sql = Sentencias_Angel.REGISTRAR_INVE;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setString(3, s.getNombre_IMP());
        ps.setString(1, s.getMarca_IMP());
        ps.setString(2, s.getUnidad_Medida_IMP());
        ps.setInt(4, s.getExistencia_IMP());
        
        
        
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            return false;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      public static boolean isUpdateInve(Sentencias_Angel s){
        String sql = Sentencias_Angel.UPDATE_INVE;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setString(3, s.getNombre_IMP());
        ps.setString(1, s.getMarca_IMP());
        ps.setString(2, s.getUnidad_Medida_IMP());
        ps.setInt(4, s.getExistencia_IMP());
        ps.setInt(5, s.getId_IMP());
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
      Logger.getLogger(Funciones_Angel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }      
        }
      
        public static boolean isDeleteInve(Sentencias_Angel s){
        String sql = Sentencias_Angel.ELIMINAR_INVE;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setInt(1, s.getId_IMP());
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            return false;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public static void setListarInve(String buscar){
            DefaultTableModel modelo = (DefaultTableModel)Mostrar_Inventario.jTable1.getModel();
            //modelo.fireTableDataChanged();
            
            
            while(modelo.getRowCount() > 0 ){
                modelo.removeRow(0);
                
            }
            
            String sql = "";
            if(buscar.equals("")){
                sql = Sentencias_Angel.LISTARINVE;
                
            } 
            else{
                sql = "SELECT * FROM INVENTARIA WHERE ("
                        + "Id_IMP LIKE'"+buscar+"%' OR "
//                        + "Tipo_ca LIKE'"+buscar+"%' OR "
//                        + "Nombre_ca LIKE'"+buscar+"%' OR "
//                       + "Funciones_ca LIKE'"+buscar+"%' OR " 
//                        + "Sueldos_ca LIKE'"+buscar+"%'"
                       + ")";
//                        + "Nombre_ca LIKE'"+buscar+"%'"
//                        + ")";
            }
            
        
        String datos[] = new String[5];
        
        try{
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0] = rs.getString("Id_IMP");
                datos[1] = rs.getString("Marca_IMP");
                datos[3] = rs.getString("Unidad_Medida_IMP");
                datos[2] = rs.getString("Nombre_IMP");
                datos[4] = rs.getString("Existencia_IMP");
                
                modelo.addRow(datos);
                
            }
           // MOSTRARCARGO.tblCa.setModel(modelo);//la tabla se actualiza. HacerCalculos(r);
        }catch (SQLException ex){
            Logger.getLogger(Funciones_Angel.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            }
        
        public static String extraerIdMaxInve(){
            
            String sql = "SELECT MAX(Id_Sar)FROM INVENTARIO";
            int Id_Inve=0;
            
            try{
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                Id_Inve = rs.getInt(1);    
            }
            if(Id_Inve == 0){
                Id_Inve =1;
            }else{
                Id_Inve = Id_Inve +1;
                
            }
            
            return String.valueOf(Id_Inve);
        }catch (SQLException ex){
            return null;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        }
        
       
        
        
         public static boolean isRegisterIng(Sentencias_Angel s){
        String sql = Sentencias_Angel.REGISTRAR_ING;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setString(1, s.getNombre_Ing());
        ps.setDouble(2, s.getMonto_Ing());
        ps.setString(3, s.getFecha_Ing());
        ps.setString(4, s.getDescripcion_Ing());
        
        
        
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            return false;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      public static boolean isUpdateIng(Sentencias_Angel s){
        String sql = Sentencias_Angel.UPDATE_ING;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setString(1, s.getNombre_Ing());
        ps.setDouble(2, s.getMonto_Ing());
        ps.setString(3, s.getFecha_Ing());
        ps.setString(4, s.getDescripcion_Ing());
        ps.setInt(5, s.getId_Ing());
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
      Logger.getLogger(Funciones_Angel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }      
        }
      
        public static boolean isDeleteIng(Sentencias_Angel s){
        String sql = Sentencias_Angel.ELIMINAR_ING;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setInt(1, s.getId_Ing());
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            return false;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public static void setListarIng(String buscar){
            DefaultTableModel modelo = (DefaultTableModel)mostrar_Ingresos.tblING.getModel();
            //modelo.fireTableDataChanged();
            
            
            while(modelo.getRowCount() > 0 ){
                modelo.removeRow(0);
                
            }
            
            String sql = "";
            if(buscar.equals("")){
                sql = Sentencias_Angel.LISTARING;
                
            } 
            else{
                sql = "SELECT * FROM INGRESOS WHERE ("
                      //  + "Nombre_Ing'"+buscar+"%' OR "
//                        + "Tipo_ca LIKE'"+buscar+"%' OR "
//                        + "Nombre_ca LIKE'"+buscar+"%' OR "
//                       + "Funciones_ca LIKE'"+buscar+"%' OR " 
//                        + "Sueldos_ca LIKE'"+buscar+"%'"
                       //+ ")";
                        + "Nombre_Ing LIKE'"+buscar+"%'"
                       + ")";
            }
            
        
        String datos[] = new String[5];
        
        try{
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0] = rs.getString("Id_Ing");
                datos[1] = rs.getString("Nombre_Ing");
                datos[2] = rs.getString("Monto_Ing");
                datos[3] = rs.getString("Fecha_Ing");
                datos[4] = rs.getString("Descripcion_Ing");
                
                modelo.addRow(datos);
                
            }
           // MOSTRARCARGO.tblCa.setModel(modelo);//la tabla se actualiza. HacerCalculos(r);
        }catch (SQLException ex){
            Logger.getLogger(Funciones_Angel.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            }
        
        public static String extraerIdMaxIng(){
            
            String sql = "SELECT MAX(Id_Ing)FROM INGRESOS";
            int Id_Ing=0;
            
            try{
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                Id_Ing = rs.getInt(1);    
            }
            if(Id_Ing == 0){
                Id_Ing =1;
            }else{
                Id_Ing = Id_Ing +1;
                
            }
            
            return String.valueOf(Id_Ing);
        }catch (SQLException ex){
            return null;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        }
        
        public static boolean isRegisterEgre(Sentencias_Angel s){
        String sql = Sentencias_Angel.REGISTRAR_EGR;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setString(1, s.getNombre_Egre());
        ps.setDouble(2, s.getMonto_Egre());
        ps.setString(3, s.getFecha_Egre());
        ps.setString(4, s.getDescripcion_Egre());
        
        
        
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            return false;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      public static boolean isUpdateEgr(Sentencias_Angel s){
        String sql = Sentencias_Angel.UPDATE_EGR;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setString(1, s.getNombre_Egre());
        ps.setDouble(2, s.getMonto_Egre());
        ps.setString(3, s.getFecha_Egre());
        ps.setString(4, s.getDescripcion_Egre());
        ps.setInt(5, s.getId_Egre());
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
      Logger.getLogger(Funciones_Angel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }      
        }
      
        public static boolean isDeleteEgr(Sentencias_Angel s){
        String sql = Sentencias_Angel.ELIMINAR_EGR;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setInt(1, s.getId_Egre());
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            return false;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public static void setListarEgr(String buscar){
            DefaultTableModel modelo = (DefaultTableModel)mostrar_Egresoso.tblEGR.getModel();
            //modelo.fireTableDataChanged();
            
            
            while(modelo.getRowCount() > 0 ){
                modelo.removeRow(0);
                
            }
            
            String sql = "";
            if(buscar.equals("")){
                sql = Sentencias_Angel.LISTAREGR;
                
            } 
            else{
                sql = "SELECT * FROM EGRESOS_R WHERE ("
                      //  + "Nombre_Ing'"+buscar+"%' OR "
//                        + "Tipo_ca LIKE'"+buscar+"%' OR "
//                        + "Nombre_ca LIKE'"+buscar+"%' OR "
//                       + "Funciones_ca LIKE'"+buscar+"%' OR " 
//                        + "Sueldos_ca LIKE'"+buscar+"%'"
                       //+ ")";
                        + "Nombre_Egr LIKE'"+buscar+"%'"
                       + ")";
            }
            
        
        String datos[] = new String[5];
        
        try{
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0] = rs.getString("Id_Egr");
                datos[1] = rs.getString("Nombre_Egr");
                datos[2] = rs.getString("Mont_Egr");
                datos[3] = rs.getString("Fecha_Egr");
                datos[4] = rs.getString("Descripcion_Egr");
                
                modelo.addRow(datos);
                
            }
           // MOSTRARCARGO.tblCa.setModel(modelo);//la tabla se actualiza. HacerCalculos(r);
        }catch (SQLException ex){
            Logger.getLogger(Funciones_Angel.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            }
        
        public static String extraerIdMaxEgre(){
            
            String sql = "SELECT MAX(Id_Egr)FROM EGRESOS_R";
            int Id_Egre=0;
            
            try{
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                Id_Egre = rs.getInt(1);    
            }
            if(Id_Egre == 0){
                Id_Egre =1;
            }else{
                Id_Egre = Id_Egre +1;
                
            }
            
            return String.valueOf(Id_Egre);
        }catch (SQLException ex){
            return null;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        }
        
        public static boolean isRegisterUsu(Sentencias_Angel s){
        String sql = Sentencias_Angel.REGISTRAR_USU;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setString(1, s.getNombre_Usu());
        ps.setString(2, s.getContrasenia_Usu());
        ps.setInt(3, s.getId_EE());
        ps.setString(4, s.getTipoUsuario());
        ps.setString(5, s.getBoni_Usu());
        ps.setString(6, s.getCargos_Usu());
        ps.setString(7, s.getCliente_Usu());
        ps.setString(8, s.getCompras_Usu());
        ps.setString(9, s.getDeducc_Usu());
        ps.setString(10, s.getEgres_Usu());
        ps.setString(11, s.getEmpleado_Usu());
        ps.setString(12, s.getHorario_Usu());
        ps.setString(13, s.getIngres_Usu());
        ps.setString(14, s.getInvent_Usu());
        ps.setString(15, s.getLocal_Usu());
        ps.setString(16, s.getPlanilla_Usu());
        ps.setString(17, s.getProducto_Usu());
        ps.setString(18, s.getProveedor_Usu());
        ps.setString(19, s.getSar_Usu());
        ps.setString(20, s.getVentas_Usu());
        ps.setString(21, s.getUsuarios_Usu());
        
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            return false;
            
        }
    }
    
      public static boolean isUpdateUsu(Sentencias_Angel s){
        String sql = Sentencias_Angel.UPDATE_USU;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setString(1, s.getNombre_Usu());
        ps.setString(2, s.getContrasenia_Usu());
        ps.setInt(3, s.getId_EE());
        ps.setString(4, s.getTipoUsuario());
         ps.setString(5, s.getBoni_Usu());
        ps.setString(6, s.getCargos_Usu());
        ps.setString(7, s.getCliente_Usu());
        ps.setString(8, s.getCompras_Usu());
        ps.setString(9, s.getDeducc_Usu());
        ps.setString(10, s.getEgres_Usu());
        ps.setString(11, s.getEmpleado_Usu());
        ps.setString(12, s.getHorario_Usu());
        ps.setString(13, s.getIngres_Usu());
        ps.setString(14, s.getInvent_Usu());
        ps.setString(15, s.getLocal_Usu());
        ps.setString(16, s.getPlanilla_Usu());
        ps.setString(17, s.getProducto_Usu());
        ps.setString(18, s.getProveedor_Usu());
        ps.setString(19, s.getSar_Usu());
        ps.setString(20, s.getVentas_Usu());
        ps.setString(21, s.getUsuarios_Usu());
        ps.setInt(22, s.getId_Usu());
        
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
      Logger.getLogger(Funciones_Angel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }      
        }
      
        public static boolean isDeleteUsu(Sentencias_Angel s){
        String sql = Sentencias_Angel.ELIMINAR_USU;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setInt(1, s.getId_Usu());
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            return false;
            
        }
    }
    
        public static void setListarUsu(String buscar){
            DefaultTableModel modelo = (DefaultTableModel)USUARIOS.tablaUsu.getModel();
            //modelo.fireTableDataChanged();
            
            
            while(modelo.getRowCount() > 0 ){
                modelo.removeRow(0);
                
            }
            
            String sql = "";
            if(buscar.equals("")){
                sql = Sentencias_Angel.LISTAR_USU;
                
            } 
            else{
                sql = "SELECT * FROM USUARIOS WHERE ("
                        + "Id_Usu LIKE'"+buscar+"%' OR "
//                        + "Tipo_ca LIKE'"+buscar+"%' OR "
//                        + "Nombre_ca LIKE'"+buscar+"%' OR "
//                       + "Funciones_ca LIKE'"+buscar+"%' OR " 
//                        + "Sueldos_ca LIKE'"+buscar+"%'"
                       + ")";
//                        + "Nombre_ca LIKE'"+buscar+"%'"
//                        + ")";
            }
            
        
        String datos[] = new String[22];
        
        try{
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0] = rs.getString("Id_Usu");
                datos[1] = rs.getString("Nombre_Usu");
                datos[2] = rs.getString("Contrasenia_Usu");
               datos[3] = rs.getString("Id_E");
               datos[4] = rs.getString("TipoUsuario");
                datos[5]=rs.getString("Boni_Usu");
                datos[6]=rs.getString("Cargos_Usu");
                datos[7]=rs.getString("Cliente_Usu");
                datos[8]=rs.getString("Compras_Usu");
                datos[9]=rs.getString("Deducc_Usu");
                datos[10]=rs.getString("Egres_Usu");
                datos[11]=rs.getString("Empleado_Usu");
                datos[12]=rs.getString("Horario_Usu");
                datos[13]=rs.getString("Ingres_Usu");
                datos[14]=rs.getString("Invent_Usu");
                datos[15]=rs.getString("Local_Usu");
                datos[16]=rs.getString("Planilla_Usu");
                datos[17]=rs.getString("Producto_Usu");
                datos[18]=rs.getString("Proveedor_Usu");
                datos[19]=rs.getString("Sar_Usu");
                datos[20]=rs.getString("Ventas_Usu");
                datos[21]=rs.getString("Usuarios_Usu");
                
                modelo.addRow(datos);
                
            }
           // MOSTRARCARGO.tblCa.setModel(modelo);//la tabla se actualiza. HacerCalculos(r);
        }catch (SQLException ex){
            Logger.getLogger(Funciones_Angel.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            }
        
        public static String extraerIdMaxUsu(){
            
            String sql = "SELECT MAX(Id_Usu)FROM USUARIOS";
            int Id_Usu=0;
            
            try{
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                Id_Usu = rs.getInt(1);    
            }
            if(Id_Usu == 0){
                Id_Usu =1;
            }else{
                Id_Usu = Id_Usu +1;
                
            }
            
            return String.valueOf(Id_Usu);
        }catch (SQLException ex){
            return null;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        }
        
        
       public static String setListarTipoCargo(Sentencias_Angel s){
                
                String sql = Sentencias_Angel.LISTAcargo;
                try{
        
            Statement st = conexion.createStatement();
            
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, s.getFK_Id_ca());
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                s.setTipo_Cargo(rs.getString(2));
                s.setNom_ca(rs.getString(1));
               // EMPLEADOSS_Update.comboCargo.setSelectedItem(s.getNom_ca());
            }
            return s.getNom_ca();
         
        }catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            return null;
            
        }
       }
       
       
        private String Tipo_Cargo;
        private String Nombre_ca;
        private String FK_Id_ca;

    public String getTipo_Cargo() {
        return Tipo_Cargo;
    }

    public void setTipo_Cargo(String Tipo_Cargo) {
        this.Tipo_Cargo = Tipo_Cargo;
    }

    public String getNombre_ca() {
        return Nombre_ca;
    }

    public void setNombre_ca(String Nombre_ca) {
        this.Nombre_ca = Nombre_ca;
    }
        
        
        
//               public static String xd(String s){
//                
//                String sql = "SELECT Nombre_ca, Tipo_ca FROM CARGOS WHERE Id_ca=?";;
//                try{
//        
//            Statement st = conexion.createStatement();
//            
//            ps = conexion.prepareStatement(sql);
//            ps.setInt(1, s.getFK_Id_ca());
//            ResultSet rs = ps.executeQuery();
//            
//            while(rs.next()){
//                setTipo_Cargo(rs.getString(2));
//                setNom_ca(rs.getString(1));
//               // EMPLEADOSS_Update.comboCargo.setSelectedItem(s.getNom_ca());
//            }
//            return sql;
//         
//        }catch (SQLException ex){
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
//            //return null;
//            
//        }
//       }
}






       



