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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import static proyectomp.MostarEmpleadosPlanilla.tblEMP;




/**
 *
 * @author Calix
 */
public class Funciones {

    
    private static conexion.Conexion con = new Conexion();
    private static Connection conexion = con.getConexion();
    private  static PreparedStatement ps = null;
    
      public static void eliminar(){
        DefaultTableModel tb = (DefaultTableModel) DETALLE_PLANILLAS.tblBoni.getModel();
        int a = DETALLE_PLANILLAS.tblBoni.getRowCount()-1;
        for (int i = a; i >= 0; i--) {           
        tb.removeRow(tb.getRowCount()-1);
        } 
      }
      
      public static boolean isUpdateDetalle(Sentencias s){
        String sql = Sentencias.UPDATE;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setString(1, s.getTipo_ca());
        ps.setString(2, s.getNombre_ca());
        ps.setString(3, s.getFunciones_ca());
        ps.setDouble(4, s.getSueldos_ca());
        ps.setInt(5, s.getId_ca());
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            return false;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
      public static void eliminarD(){
        DefaultTableModel tb = (DefaultTableModel) DETALLE_PLANILLAS.tbldedu.getModel();
        int a = DETALLE_PLANILLAS.tbldedu.getRowCount()-1;
        for (int i = a; i >= 0; i--) {           
        tb.removeRow(tb.getRowCount()-1);
        } 
      }
      
      public static void eliminarUPDATE(){
        DefaultTableModel tb = (DefaultTableModel) DETALLE_PLANILLAS_UPDATE.tblBoni.getModel();
        int a = DETALLE_PLANILLAS_UPDATE.tblBoni.getRowCount()-1;
        for (int i = a; i >= 0; i--) {           
        tb.removeRow(tb.getRowCount()-1);
        } 
      }
      
      public static void eliminarDUPDATE(){
        DefaultTableModel tb = (DefaultTableModel) DETALLE_PLANILLAS_UPDATE.tbldedu.getModel();
        int a = DETALLE_PLANILLAS_UPDATE.tbldedu.getRowCount()-1;
        for (int i = a; i >= 0; i--) {           
        tb.removeRow(tb.getRowCount()-1);
        } 
      }
    
    
    
    public static void sumarPLANILLA(){
                     double fila = 0;
                     double total = 0;
                     
                     for(int i=0; i < DETALLE_PLANILLAS.tblMostrarEmp.getRowCount(); i++){
                         fila =Double.parseDouble(DETALLE_PLANILLAS.tblMostrarEmp.getValueAt(i, 7).toString());
                         total += fila;
                     }
                     String res = Double.toString(total);
                     DETALLE_PLANILLAS.lblttl.setText(res);
                     
                     
                     
                 }
    
    public static void sumarPLANILLAUPDATE(){
                     double fila = 0;
                     double total = 0;
                     
                     for(int i=0; i < DETALLE_PLANILLAS_UPDATE.tblMostrarEmp.getRowCount(); i++){
                         fila =Double.parseDouble(DETALLE_PLANILLAS_UPDATE.tblMostrarEmp.getValueAt(i, 7).toString());
                         total += fila;
                     }
                     String res = Double.toString(total);
                     DETALLE_PLANILLAS_UPDATE.lbltlt.setText(res);
                     
                     
                     
                 }
    
    
      public static void repetido(String Id_E){
          for(int i=0; i< DETALLE_PLANILLAS.tblMostrarEmp.getRowCount(); i++){
            if(DETALLE_PLANILLAS.tblMostrarEmp.getValueAt(i,1).equals(Id_E)){
              JOptionPane.showMessageDialog(null, "Ya esta registrado");
            }
            }
        }

        
                    
//        int a = 0;
//        for(int i=0; i< DETALLE_PLANILLAS.tblMostrarEmp.getRowCount(); i++){
//            if(DETALLE_PLANILLAS.tblMostrarEmp.getValueAt(i, 0).toString().equals(Id_E)){
//                a+=1;
//            }
//        }
//        if (a>0) {
//            JOptionPane.showMessageDialog(null, "Ya existe este trabajador");
//            
//            
//        }
                 
    
    public static void setListarDetalleUpdate(String Id_Pla){
            DefaultTableModel modelo = (DefaultTableModel)DETALLE_PLANILLAS_UPDATE.tblMostrarEmp.getModel();
            
            
            //modelo.fireTableDataChanged();
 
            
            while(modelo.getRowCount() > 0 ){
                modelo.removeRow(0);
                
            }
            
            
               String sql = "Select EMPLEADOS.Id_E, Nombres_E, Apellidos_E, Nombre_ca, Sueldos_ca, TotalBoni, TotalDedu, Total_A_Pagar, Id_Detalle_Pla "
                + "from EMPLEADOS "
                + "inner join CARGOS "
                + "on Id_ca = FK_Id_ca "
                + "inner join DETALLE_PLANILLA "
                + "on EMPLEADOS.Id_E = FK_Empleado "
                + "inner join PLANILLA "
                + "on Id_Pla = FK_Planilla "
                + "where FK_Planilla = '" +Id_Pla+ "' ";
            
            
        
        String datos[] = new String[9];
        
        try{
 Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0] = rs.getString("Id_E");
                datos[1] = rs.getString("Nombres_E");
                datos[2] = rs.getString("Apellidos_E");
                datos[3] = rs.getString("Nombre_ca");
                datos[4] = rs.getString("Sueldos_ca");
                datos[5] = rs.getString("TotalBoni");
                datos[6] = rs.getString("TotalDedu");
                datos[7] = rs.getString("Total_A_Pagar");
                datos[8] = rs.getString("Id_Detalle_Pla");
                modelo.addRow(datos);
                DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
                tcr.setHorizontalAlignment(SwingConstants.RIGHT);
                DETALLE_PLANILLAS_UPDATE.tblMostrarEmp.setModel(modelo);
                DETALLE_PLANILLAS_UPDATE.tblMostrarEmp.getColumnModel().getColumn(8).setCellRenderer(tcr);
                
            }
           // MOSTRARCARGO.tblCa.setModel(modelo);//la tabla se actualiza. HacerCalculos(r);
        }catch (SQLException ex){
            
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            }
    
    
    
    public static void setListarDetalle(String Id_Pla){
            DefaultTableModel modelo = (DefaultTableModel)DETALLE_PLANILLAS.tblMostrarEmp.getModel();
            
            //modelo.fireTableDataChanged();
 
            
            while(modelo.getRowCount() > 0 ){
                modelo.removeRow(0);
                
            }
            
            
               String sql = "Select EMPLEADOS.Id_E, Nombres_E, Apellidos_E, Nombre_ca, Sueldos_ca, TotalBoni, TotalDedu, Total_A_Pagar "
                + "from EMPLEADOS "
                + "inner join CARGOS "
                + "on Id_ca = FK_Id_ca "
                + "inner join DETALLE_PLANILLA "
                + "on EMPLEADOS.Id_E = FK_Empleado "
                + "inner join PLANILLA "
                + "on Id_Pla = FK_Planilla "
                + "where FK_Planilla = '" +Id_Pla+ "' ";
            
            
        
        String datos[] = new String[8];
        
        try{
 Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0] = rs.getString("Id_E");
                datos[1] = rs.getString("Nombres_E");
                datos[2] = rs.getString("Apellidos_E");
                datos[3] = rs.getString("Nombre_ca");
                datos[4] = rs.getString("Sueldos_ca");
                datos[5] = rs.getString("TotalBoni");
                datos[6] = rs.getString("TotalDedu");
                datos[7] = rs.getString("Total_A_Pagar");
                modelo.addRow(datos);
                DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
                tcr.setHorizontalAlignment(SwingConstants.RIGHT);
                DETALLE_PLANILLAS.tblMostrarEmp.setModel(modelo);
                DETALLE_PLANILLAS.tblMostrarEmp.getColumnModel().getColumn(7).setCellRenderer(tcr);
                
            }
           // MOSTRARCARGO.tblCa.setModel(modelo);//la tabla se actualiza. HacerCalculos(r);
        }catch (SQLException ex){
            
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            }
    
    
    
    
    
    
    public static void setListarJoinDeduUpdate(String buscar,String num){
            DefaultTableModel modelo = (DefaultTableModel)DETALLE_PLANILLAS_UPDATE.tbldedu.getModel();
            
            //modelo.fireTableDataChanged();
 
            
            while(modelo.getRowCount() > 0 ){
                modelo.removeRow(0);
                
            }
            
            
               String sql = "Select Id_De, Nombre_De, Valor_De "
                + "from EMPLEADOS "
                + "inner join EGRESO "
                + "on Id_E = FK_Empleado "
                + "inner join DEDUCCION "
                + "on Id_De = FK_Egreso "
                + "inner join PLANILLA "
                + "on FK_Pla = Id_Pla "
                + "where EMPLEADOS.Id_E = '" +buscar+ "' AND FK_PLA = '" + num + "' ";
            
            
        
        String datos[] = new String[3];
        
        try{
 Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0] = rs.getString("Id_De");
                datos[1] = rs.getString("Nombre_De");
                datos[2] = rs.getString("Valor_De");
                modelo.addRow(datos);
                
            }
           // MOSTRARCARGO.tblCa.setModel(modelo);//la tabla se actualiza. HacerCalculos(r);
        }catch (SQLException ex){
            
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            }
    
     public static void setListarJoinBoniUpdate(String buscar, String num){
            DefaultTableModel modelo = (DefaultTableModel)DETALLE_PLANILLAS_UPDATE.tblBoni.getModel();
            //modelo.fireTableDataChanged();
 
            
            while(modelo.getRowCount() > 0 ){
                modelo.removeRow(0);
                
            }
            
            
               String sql = "Select Id_De_Boni, Nombre_De_Boni, Valor_De_Boni "
                + "from EMPLEADOS "
                + "inner join BONIFICACION "
                + "on EMPLEADOS.Id_E = FK_EMPLEADO "
                + "inner join DETALLE_BONIFICACION "
                + "on Id_De_Boni = FK_Boni "
                + "inner join PLANILLA "
                + "on Id_Pla = FK_Pla "
                + "where EMPLEADOS.Id_E = '" +buscar+ "' AND FK_PLA = '" + num + "' ";
                
            
            
        
        String datos[] = new String[3];
        
        try{
 Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0] = rs.getString("Id_De_Boni");
                datos[1] = rs.getString("Nombre_De_Boni");
                datos[2] = rs.getString("Valor_De_Boni");
                modelo.addRow(datos);
                
            }
           // MOSTRARCARGO.tblCa.setModel(modelo);//la tabla se actualiza. HacerCalculos(r);
        }catch (SQLException ex){
            
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            }
    
    public static boolean Delete_boni_planilla(Sentencias s){
        String sql = Sentencias.DELETE_boni_Pla;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setInt(1, s.getId_Boni());
        ps.setInt(2, s.getFK_Empleado());
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            return false;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static boolean Delete_boni_planilla_U(Sentencias s){
        String sql = Sentencias.DELETE_boni_Pla_U;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setInt(1, s.getId_Boni());
        ps.setInt(2, s.getFK_Empleado());
        ps.setInt(3, s.getFK_Planilla());
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            return false;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static boolean Delete_dedu_planilla(Sentencias s){
        String sql = Sentencias.DELETE_dedu_Pla;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setInt(1, s.getId_Egr());
        ps.setInt(2, s.getFK_Empleado());
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            return false;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static boolean Delete_dedu_planilla_U(Sentencias s){
        String sql = Sentencias.DELETE_dedu_Pla_U;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setInt(1, s.getId_Egr());
        ps.setInt(2, s.getFK_Empleado());
        ps.setInt(3, s.getFK_Planilla());
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            return false;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
                    public static boolean isDeleteDEP(Sentencias s){
        String sql = Sentencias.DELETE_DETALLE_PLANAILLA;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setInt(1, s.getId_Detalle_Pla());
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            return false;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
                    
             
    
    public static boolean isRegister(Sentencias s){
        String sql = Sentencias.REGISTRAR;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setString(1, s.getTipo_ca());
        ps.setString(2, s.getNombre_ca());
        ps.setString(3, s.getFunciones_ca());
        ps.setDouble(4, s.getSueldos_ca());
        
        
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            return false;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
      public static boolean isUpdate(Sentencias s){
        String sql = Sentencias.UPDATE;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setString(1, s.getTipo_ca());
        ps.setString(2, s.getNombre_ca());
        ps.setString(3, s.getFunciones_ca());
        ps.setDouble(4, s.getSueldos_ca());
        ps.setInt(5, s.getId_ca());
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            return false;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
        public static boolean isDelete(Sentencias s){
        String sql = Sentencias.ELIMINAR;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setInt(1, s.getId_ca());
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            return false;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public static void setListar(String buscar){
            DefaultTableModel modelo = (DefaultTableModel)MOSTRARCARGO.tblCa.getModel();
            //modelo.fireTableDataChanged();
            
            
            while(modelo.getRowCount() > 0 ){
                modelo.removeRow(0);
                
            }
            
            String sql = "";
            if(buscar.equals("")){
                sql = Sentencias.LISTAR;
                
            } 
            else{
                sql = "SELECT * FROM CARGOS WHERE ("
                        + "Id_ca LIKE'"+buscar+"%' OR "
                        + "Tipo_ca LIKE'"+buscar+"%' OR "
                        + "Nombre_ca LIKE'"+buscar+"%' OR "
                       + "Funciones_ca LIKE'"+buscar+"%' OR " 
                        + "Sueldos_ca LIKE'"+buscar+"%'"
                       + ")";
//                        + "Nombre_ca LIKE'"+buscar+"%'"
//                        + ")";
            }
            
        
        String datos[] = new String[5];
        
        try{
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0] = rs.getString("Id_ca");
                datos[1] = rs.getString("Tipo_ca");
                datos[2] = rs.getString("Nombre_ca");
                datos[3] = rs.getString("Funciones_ca");
                datos[4] = rs.getString("Sueldos_ca");
                modelo.addRow(datos);
                DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
                tcr.setHorizontalAlignment(SwingConstants.RIGHT);
                MOSTRARCARGO.tblCa.setModel(modelo);
                MOSTRARCARGO.tblCa.getColumnModel().getColumn(4).setCellRenderer(tcr);
                
                
            }
           // MOSTRARCARGO.tblCa.setModel(modelo);//la tabla se actualiza. HacerCalculos(r);
        }catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            }
        
        
        public static void setListarCargo(Sentencias s){
          
            
            String sql = Sentencias.LISTAR;
        
        
        try{
            int a =0;
            int b =0;
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                s.setId_ca(rs.getInt(1));
                s.setNombre_ca(rs.getString(3));
                s.setTipo_ca(rs.getString(2));
                if (CARGOS_REGISTRO.sexo.getSelectedItem().equals(s.getTipo_ca())) {
                    if (CARGOS_REGISTRO.txtNombre.getText().equals(s.getNombre_ca())) {
                b=1;
                
            }
                
                
            }
//                s.setNombre_ca(rs.getString(3));
//                if (CARGOS_REGISTRO.txtNombre.getText().equals(s.getNombre_ca())) {
//                b=1;
//                
//            }
                s.setFunciones_ca(rs.getString(4));
                s.setSueldos_ca(rs.getInt(5));
               
                
            }
            if (b==1) {
                JOptionPane.showMessageDialog(null, "Este cargo ya existe en este tipo");
                
            } else {
            
           
              s.setNombre_ca(CARGOS_REGISTRO.txtNombre.getText());
            s.setSueldos_ca(Double.parseDouble(CARGOS_REGISTRO.TxtSue.getText()));
            s.setFunciones_ca(CARGOS_REGISTRO.txtFun.getText());
            s.setTipo_ca(CARGOS_REGISTRO.sexo.getSelectedItem().toString());
            
            
            if(Funciones.isRegister(s)){
               // Funciones.setListar("");
                JOptionPane.showMessageDialog(null, "Nuevo cargo creado");
//            JOptionPane.showMessageDialog(this, "Nuevo Cargo Creado");
            Funciones.setListar("");
            
            }else{
                JOptionPane.showMessageDialog(null, "Fallo el Registro");
                
            }
            }
            
           // MOSTRARCARGO.tblCa.setModel(modelo);//la tabla se actualiza. HacerCalculos(r);
        }catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            }
        
        public static void setListarCargoUpdate(Sentencias s){
          
            
            String sql = Sentencias.LISTAR;
        
        
        try{
            int a =0;
            int b =0;
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                s.setId_ca(rs.getInt(1));
                s.setNombre_ca(rs.getString(3));
                s.setTipo_ca(rs.getString(2));
                if (CARGOS_UPDATE.cmdTipo.getSelectedItem().equals(s.getTipo_ca())) {
                    if (CARGOS_UPDATE.txtNombre.getText().equals(s.getNombre_ca())) {
                b=1;
                
            }
                
                
            }
//                s.setNombre_ca(rs.getString(3));
//                if (CARGOS_REGISTRO.txtNombre.getText().equals(s.getNombre_ca())) {
//                b=1;
//                
//            }
                s.setFunciones_ca(rs.getString(4));
                s.setSueldos_ca(rs.getInt(5));
               
                
            }
            if (b==1) {
                JOptionPane.showMessageDialog(null, "Ya existe");
                
            } else {
            
           
             // Sentencias u = new Sentencias();
            s.setTipo_ca(CARGOS_UPDATE.cmdTipo.getSelectedItem().toString());
            s.setNombre_ca(CARGOS_UPDATE.txtNombre.getText());
            s.setSueldos_ca(Double.parseDouble(CARGOS_UPDATE.TxtSue1.getText()));
            s.setFunciones_ca(CARGOS_UPDATE.txtFun.getText());
            s.setId_ca(Integer.parseInt(CARGOS_UPDATE.lblId.getText()));
            
            if(Funciones.isUpdate(s)){
                Funciones.setListar("");
            JOptionPane.showMessageDialog(null, "Datos Actualizados con Exito");
            
            }else{
                JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR");
                
            }
            }
            
           // MOSTRARCARGO.tblCa.setModel(modelo);//la tabla se actualiza. HacerCalculos(r);
        }catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            }
        
        public static String extraerIdMax(){
            
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
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
         public static boolean isRegisterLocal(Sentencias s){
        String sql = Sentencias.REGISTRAR_LOCAL;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setString(1, s.getNombre_L());
        ps.setString(2, s.getDireccion_L());
        ps.setString(3, s.getRTN_L());
        ps.setString(4, s.getTelefono_L());
        ps.setString(5, s.getTelefono2_L());
        
        
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            return false;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      public static boolean isUpdateLocal(Sentencias s){
        String sql = Sentencias.UPDATE_LOCAL;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setString(1, s.getNombre_L());
        ps.setString(2, s.getDireccion_L());
        ps.setString(3, s.getRTN_L());
        ps.setString(4, s.getTelefono_L());
        ps.setString(5, s.getTelefono2_L());
        ps.setInt(6, s.getId_L());
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            return false;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
        public static boolean isDeleteLocal(Sentencias s){
        String sql = Sentencias.ELIMINAR_LOCAL;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setInt(1, s.getId_L());
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            return false;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public static void setListarLocal(String buscar){
            DefaultTableModel modelo = (DefaultTableModel)LOCAL_REGISTRO.tblLocal.getModel();
            //modelo.fireTableDataChanged();
            
            
            while(modelo.getRowCount() > 0 ){
                modelo.removeRow(0);
                
            }
            
            String sql = "";
            if(buscar.equals("")){
                sql = Sentencias.LISTARLOCAL;
                
            } 
            else{
                sql = "SELECT * FROM LOCAL_MP WHERE ("
                        + "Id_ca LIKE'"+buscar+"%' OR "
                        + "Tipo_ca LIKE'"+buscar+"%' OR "
                        + "Nombre_ca LIKE'"+buscar+"%' OR "
                       + "Funciones_ca LIKE'"+buscar+"%' OR " 
                        + "Sueldos_ca LIKE'"+buscar+"%'"
                       + ")";
//                        + "Nombre_ca LIKE'"+buscar+"%'"
//                        + ")";
            }
            
        
        String datos[] = new String[6];
        
        try{
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0] = rs.getString("Id_L");
                datos[1] = rs.getString("Nombre_L");
                datos[2] = rs.getString("RTN_L");
                datos[3] = rs.getString("Telefono_L");
                datos[4] = rs.getString("Telefono2_L");
                datos[5] = rs.getString("Direccion_L");
                modelo.addRow(datos);
                
            }
           // MOSTRARCARGO.tblCa.setModel(modelo);//la tabla se actualiza. HacerCalculos(r);
        }catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
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
                Id_L = Id_L +1;
                
            }
            
            return String.valueOf(Id_L);
        }catch (SQLException ex){
            return null;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
                public static boolean isRegisterDEP(Sentencias s){
        String sql = Sentencias.REGISTRAR_DETALLE_PLANILLA;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setDouble(1, s.getTotal_A_Pagar());
        ps.setInt(2, s.getFK_Empleado());
        ps.setDouble(3, s.getTotalBoni());
        ps.setDouble(4, s.getTotalDedu());
        ps.setInt(5, s.getFK_Planilla());
        
        
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            return false;
            
        }
    }
    
      public static boolean isUpdateDEP(Sentencias s){
        String sql = Sentencias.UPDATE_DETALLEPLANILLA;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setDouble(1, s.getTotal_A_Pagar());
        ps.setDouble(2, s.getTotalBoni());
        ps.setDouble(3, s.getTotalDedu());
        ps.setInt(4, s.getId_Detalle_Pla());
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            return false;
           
        }
    }
      
      
      
              public static void setListarJoinPLANILLA(){
            DefaultTableModel modelo = (DefaultTableModel)MostrarPlanillas.tbl.getModel();
            //modelo.fireTableDataChanged();
 
            
            while(modelo.getRowCount() > 0 ){
                modelo.removeRow(0);
                
            }
            
            
               String sql = "Select * from PLANILLA";
                
                
                
               
               String datos[] = new String[6];
        
        try{
            
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0] = rs.getString("Id_Pla");
                datos[1] = rs.getString("Observaciones_Pla");
                datos[2] = rs.getString("Tipo_Pla");
                datos[3] = rs.getString("Periodo_Pla");
                datos[4] = rs.getString("Fecha_Creacion_Pla");
                datos[5] = rs.getString("Fecha_Pago_Pla");
               // datos[6] = rs.getString("Id_E");
      
                modelo.addRow(datos);
                
            }
           // MOSTRARCARGO.tblCa.setModel(modelo);//la tabla se actualiza. HacerCalculos(r);
        }catch (SQLException ex){
            
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            }
      
       
        
        
        
        
         public static boolean isRegistery_dedu_planilla(Sentencias s){
        String sql = Sentencias.REGISTRAR_Deduccion_Detall;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setString(1, s.getFecha_Egr());
        ps.setInt(2, s.getId_Egr());
        ps.setInt(3, s.getFK_Empleado());
        ps.setInt(4, s.getFK_Planilla());
        
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            return false;
           
        }
    }
         
          public static boolean isRegistery_boni_planilla(Sentencias s){
        String sql = Sentencias.REGISTRAR_BONIFICACION_Detall;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setInt(1, s.getId_Boni());
        ps.setString(2, s.getFecha());
        ps.setInt(3, s.getFK_Empleado());
        ps.setInt(4, s.getFK_Planilla());
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            return false;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
          
          
                     
          
          
          
          
          
           public static void setListarJoinBoni(String buscar, String num){
            DefaultTableModel modelo = (DefaultTableModel)DETALLE_PLANILLAS.tblBoni.getModel();
            //modelo.fireTableDataChanged();
 
            
            while(modelo.getRowCount() > 0 ){
                modelo.removeRow(0);
                
            }
            
            
               String sql = "Select Id_De_Boni, Nombre_De_Boni, Valor_De_Boni "
                + "from EMPLEADOS "
                + "inner join BONIFICACION "
                + "on EMPLEADOS.Id_E = FK_EMPLEADO "
                + "inner join DETALLE_BONIFICACION "
                + "on Id_De_Boni = FK_Boni "
                + "inner join PLANILLA "  
                + "on Id_Pla = FK_Pla "
                + "where EMPLEADOS.Id_E = '" +buscar+ "' AND FK_Pla = '" + num + "' ";
               
            
            
        
        String datos[] = new String[3];
        
        try{
 Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0] = rs.getString("Id_De_Boni");
                datos[1] = rs.getString("Nombre_De_Boni");
                datos[2] = rs.getString("Valor_De_Boni");
                modelo.addRow(datos);
                
            }
           // MOSTRARCARGO.tblCa.setModel(modelo);//la tabla se actualiza. HacerCalculos(r);
        }catch (SQLException ex){
            
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            }
           
           public static void sumarColumnBoni(){
                     double fila = 0;
                     double total = 0;
                     
                     for(int i=0; i < DETALLE_PLANILLAS.tblBoni.getRowCount(); i++){
                         fila =Double.parseDouble(DETALLE_PLANILLAS.tblBoni.getValueAt(i, 2).toString());
                         total += fila;
                     }
                     String res = Double.toString(total);
                     DETALLE_PLANILLAS.lblTotalBoni.setText(res);
                     
                     
                     
                 }
           
                      public static void sumarColumnBoniUpdate(){
                     double fila = 0;
                     double total = 0;
                     
                     for(int i=0; i < DETALLE_PLANILLAS_UPDATE.tblBoni.getRowCount(); i++){
                         fila =Double.parseDouble(DETALLE_PLANILLAS_UPDATE.tblBoni.getValueAt(i, 2).toString());
                         total += fila;
                     }
                     String res = Double.toString(total);
                     DETALLE_PLANILLAS_UPDATE.lblTotalBoni.setText(res);
                     
                     
                     
                 }
           
           public static void sumarTotalAPagar(){
               
               double i= Double.parseDouble(DETALLE_PLANILLAS.lblSue.getText());
               double b= Double.parseDouble(DETALLE_PLANILLAS.lblTotal.getText());
               double c= Double.parseDouble(DETALLE_PLANILLAS.lblTotalBoni.getText());
               
               double total = i-b+c;
               
               DETALLE_PLANILLAS.lblPago.setText("" +total);
                     
                     
                     
                 }
         
                      public static void sumarTotalAPagarUpdate(){
               
               double i= Double.parseDouble(DETALLE_PLANILLAS_UPDATE.lblSue.getText());
               double b= Double.parseDouble(DETALLE_PLANILLAS_UPDATE.lblTotal.getText());
               double c= Double.parseDouble(DETALLE_PLANILLAS_UPDATE.lblTotalBoni.getText());
               
               double total = i-b+c;
               
               DETALLE_PLANILLAS_UPDATE.lblPago.setText("" +total);
                     
                     
                     
                 }
         
         
                
         
         
         
         
         
         
         
         
         
         
         
                 public static void setListarJoinDedu(String buscar, String num){
            DefaultTableModel modelo = (DefaultTableModel)DETALLE_PLANILLAS.tbldedu.getModel();
            //modelo.fireTableDataChanged();
 
            
            while(modelo.getRowCount() > 0 ){
                modelo.removeRow(0);
                
            }
            
            
               String sql = "Select Id_De, Nombre_De, Valor_De "
                + "from EMPLEADOS "
                + "inner join EGRESO "
                + "on EMPLEADOS.Id_E = FK_Empleado "
                + "inner join DEDUCCION "
                + "on Id_De = FK_Egreso "
                + "inner join PLANILLA "
                + "on FK_Pla = Id_Pla "
                + "where EMPLEADOS.Id_E = '" +buscar+ "' AND FK_PLA = '" + num + "' ";
               
//                       "Select Id_Egr, Nombre_De_Egr, Valor_De_Egr "
//                + "from EMPLEADOS "
//                + "inner join EGRESO "
//                + "on Id_E = FK_Empleado "
//                + "inner join DETALLE_EGRESOS "
//                + "on Id_De_Egr = FK_Egreso "
//                + "where FK_Empleado = '" + buscar + "'";
//               
//                        "SELECT * FROM LOCAL_MP WHERE ("
//                        + "Id_ca LIKE'"+buscar+"%' OR "
//                        + "Tipo_ca LIKE'"+buscar+"%' OR "
//                        + "Nombre_ca LIKE'"+buscar+"%' OR "
//                       + "Funciones_ca LIKE'"+buscar+"%' OR " 
//                        + "Sueldos_ca LIKE'"+buscar+"%'"
//                       + ")";
//                        + "Nombre_ca LIKE'"+buscar+"%'"
//                        + ")";
            
            
        
        String datos[] = new String[3];
        
        try{
 Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0] = rs.getString("Id_De");
                datos[1] = rs.getString("Nombre_De");
                datos[2] = rs.getString("Valor_De");
                modelo.addRow(datos);
                
            }
           // MOSTRARCARGO.tblCa.setModel(modelo);//la tabla se actualiza. HacerCalculos(r);
        }catch (SQLException ex){
            
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            }
                 
                 
                 
                 public static void sumarColumn(){
                     double fila = 0;
                     double total = 0;
                     
                     for(int i=0; i < DETALLE_PLANILLAS.tbldedu.getRowCount(); i++){
                         fila =Double.parseDouble(DETALLE_PLANILLAS.tbldedu.getValueAt(i, 2).toString());
                         total += fila;
                     }
                     String res = Double.toString(total);
                     DETALLE_PLANILLAS.lblTotal.setText(res);
                     
                     
                     
                 }
                 
                     public static void sumarColumnUpdate(){
                     double fila = 0;
                     double total = 0;
                     
                     for(int i=0; i < DETALLE_PLANILLAS_UPDATE.tbldedu.getRowCount(); i++){
                         fila =Double.parseDouble(DETALLE_PLANILLAS_UPDATE.tbldedu.getValueAt(i, 2).toString());
                         total += fila;
                     }
                     String res = Double.toString(total);
                     DETALLE_PLANILLAS_UPDATE.lblTotal.setText(res);
                     
                     
                     
                 }
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
       
    
        public static void setListarEmp(String buscar){
           
            DefaultTableModel modelo = (DefaultTableModel)MostarEmpleadosPlanilla.tblEMP.getModel();
            
           
            
            
            
            while(modelo.getRowCount() > 0 ){
                modelo.removeRow(0);
                
            }
            
            String sql = "";
            if(buscar.equals("")){
                sql = Sentencias.LISTAREMP;
                
            } 
            else{
                sql = "SELECT * FROM LOCAL_MP WHERE ("
                        + "Id_ca LIKE'"+buscar+"%' OR "
                        + "Tipo_ca LIKE'"+buscar+"%' OR "
                        + "Nombre_ca LIKE'"+buscar+"%' OR "
                       + "Funciones_ca LIKE'"+buscar+"%' OR " 
                        + "Sueldos_ca LIKE'"+buscar+"%'"
                       + ")";
//                        + "Nombre_ca LIKE'"+buscar+"%'"
//                        + ")";
            }
            
        
        String datos[] = new String[6];
        
        try{
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0] = rs.getString("Id_E");
                datos[1] = rs.getString("Nombres_E");
                datos[2] = rs.getString("Apellidos_E");
                datos[3] = rs.getString("Identidad_E");
                datos[4] = rs.getString("Nombre_Ca");
                datos[5] = rs.getString("Sueldos_Ca");
                modelo.addRow(datos);
                
            }
           // MOSTRARCARGO.tblCa.setModel(modelo);//la tabla se actualiza. HacerCalculos(r);
        }catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            }
        
        public static void setListarEmpUpdate(String buscar){
           
            DefaultTableModel modelo = (DefaultTableModel)MostarEmpleadosPlanilla_Update.tblEMP.getModel();
            
           
            
            
            
            while(modelo.getRowCount() > 0 ){
                modelo.removeRow(0);
                
            }
            
            String sql = "";
            if(buscar.equals("")){
                sql = Sentencias.LISTAREMP;
                
            } 
            else{
                sql = "SELECT * FROM LOCAL_MP WHERE ("
                        + "Id_ca LIKE'"+buscar+"%' OR "
                        + "Tipo_ca LIKE'"+buscar+"%' OR "
                        + "Nombre_ca LIKE'"+buscar+"%' OR "
                       + "Funciones_ca LIKE'"+buscar+"%' OR " 
                        + "Sueldos_ca LIKE'"+buscar+"%'"
                       + ")";
//                        + "Nombre_ca LIKE'"+buscar+"%'"
//                        + ")";
            }
            
        
        String datos[] = new String[6];
        
        try{
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0] = rs.getString("Id_E");
                datos[1] = rs.getString("Nombres_E");
                datos[2] = rs.getString("Apellidos_E");
                datos[3] = rs.getString("Identidad_E");
                datos[4] = rs.getString("Nombre_Ca");
                datos[5] = rs.getString("Sueldos_Ca");
                modelo.addRow(datos);
                
            }
           // MOSTRARCARGO.tblCa.setModel(modelo);//la tabla se actualiza. HacerCalculos(r);
        }catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            }
        
        
        
        
        public static String extraerIdMaxPlanilla(){
            
            String sql = "SELECT MAX(Id_Pla)FROM PLANILLA";
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
                Id_L = Id_L +1;
                
            }
            
            return String.valueOf(Id_L);
        }catch (SQLException ex){
            return null;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        }
        
           public static String extraerIdMaxPlanillaDe(){
            
            String sql = "SELECT MAX(Id_Pla)FROM PLANILLA";
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
                Id_L = Id_L ;
                
            }
            
            return String.valueOf(Id_L);
        }catch (SQLException ex){
            return null;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        }
        
            public static boolean isRegisterPlanilla(Sentencias s){
        String sql = Sentencias.REGISTRAR_PLANILLA;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setString(1, s.getObservaciones_Pla());
        ps.setString(2, s.getTipo_Pla());
        ps.setString(3, s.getPeriodo_Pla());
        ps.setString(4, s.getFecha_Creacion_Pla());
        ps.setString(5, s.getFecha_Pago_Pla());
//        ps.setInt(6, s.getId_Emp());
        
        
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
                       Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }
    }
    
      public static boolean isUpdatePlanilla(Sentencias s){
        String sql = Sentencias.UPDATE_PLANILLA;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setString(1, s.getObservaciones_Pla());
        ps.setString(2, s.getTipo_Pla());
        ps.setString(3, s.getPeriodo_Pla());
        ps.setString(4, s.getFecha_Creacion_Pla());
        ps.setString(5, s.getFecha_Pago_Pla());
        ps.setInt(6, s.getId_Pla());
        
        
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            return false;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
//        public static void Join(String id){
//             DefaultTableModel modelo = (DefaultTableModel)DETALLE_PLANILLAS.tblEmp.getModel();
//             
//                  
//            
//            while(modelo.getRowCount() > 0 ){
//                modelo.removeRow(0);
//                
//            }
//            
//            
//            String sql = "";
//            if (id.equals("")) {
//                System.out.println("nada");
//                
//                
//            }
//           // public static String REGISTRAR = "{call Insertar_Cargo (?,?,?,?)}";
//            else{
//                sql = "{call empld (?)}";
//            }
//            String datos[] = new String[6];
//        
//        try{
//        
//            Statement st = conexion.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            
//            while(rs.next()){
//                
//                datos[0] = rs.getString("Id_E");
//                datos[1] = rs.getString("Nombres_E");
//                datos[2] = rs.getString("Apellidos_E");
//                datos[3] = rs.getString("Identidad_E");
//                datos[4] = rs.getString("Nombre_ca");
//                datos[5] = rs.getString("Sueldos_ca");
//                modelo.addRow(datos);
//                
//            }
//           // MOSTRARCARGO.tblCa.setModel(modelo);//la tabla se actualiza. HacerCalculos(r);
//        }catch (SQLException ex){
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
//            
//        }
//            
//        }
      
      
              public static void setListarDEDUUpdatee(String buscar){
            DefaultTableModel modelo = (DefaultTableModel)SELECCIONAR_DEDUCCION_UPDATE.tblDedu.getModel();
            //modelo.fireTableDataChanged();
            
            
            while(modelo.getRowCount() > 0 ){
                modelo.removeRow(0);
                
            }
            
            String sql = "";
            if(buscar.equals("")){
                sql = Sentencias.LISTARDEDU;
                
        
        String datos[] = new String[4];
        
        try{
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                
                datos[0] = rs.getString("Id_De");
                datos[1] = rs.getString("Nombre_De");
                datos[2] = rs.getString("Descripcion_De");
//                datos[3] = rs.getString("Valor_De");
                modelo.addRow(datos);
                
            }
           // MOSTRARCARGO.tblCa.setModel(modelo);//la tabla se actualiza. HacerCalculos(r);
        }catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            }
              }
      
      
      
        public static void setListarDEDU(String buscar){
            DefaultTableModel modelo = (DefaultTableModel)SELECCIONAR_DEDUCCION.tblDedu.getModel();
            //modelo.fireTableDataChanged();
            
            
            while(modelo.getRowCount() > 0 ){
                modelo.removeRow(0);
                
            }
            
            String sql = "";
            if(buscar.equals("")){
                sql = Sentencias.LISTARDEDU;
                
            } 
            else{
                sql = "SELECT * FROM LOCAL_MP WHERE ("
                        + "Id_ca LIKE'"+buscar+"%' OR "
                        + "Tipo_ca LIKE'"+buscar+"%' OR "
                        + "Nombre_ca LIKE'"+buscar+"%' OR "
                       + "Funciones_ca LIKE'"+buscar+"%' OR " 
                        + "Sueldos_ca LIKE'"+buscar+"%'"
                       + ")";
//                        + "Nombre_ca LIKE'"+buscar+"%'"
//                        + ")";
            }
            
        
        String datos[] = new String[4];
        
        try{
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                
                datos[0] = rs.getString("Id_De");
                datos[1] = rs.getString("Nombre_De");
                datos[2] = rs.getString("Descripcion_De");
               // datos[3] = rs.getString("Valor_De");
                modelo.addRow(datos);
                
            }
           // MOSTRARCARGO.tblCa.setModel(modelo);//la tabla se actualiza. HacerCalculos(r);
        }catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            }
        
         public static void setListarBONI(String buscar){
            DefaultTableModel modelo = (DefaultTableModel)Seleccionar_Bonificacioin.tblBoni.getModel();
            //modelo.fireTableDataChanged();
            
            
            while(modelo.getRowCount() > 0 ){
                modelo.removeRow(0);
                
            }
            
            String sql = "";
            if(buscar.equals("")){
                sql = Sentencias.LISTARBONI;
                
            } 
            else{
                sql = "SELECT * FROM LOCAL_MP WHERE ("
                        + "Id_ca LIKE'"+buscar+"%' OR "
                        + "Tipo_ca LIKE'"+buscar+"%' OR "
                        + "Nombre_ca LIKE'"+buscar+"%' OR "
                       + "Funciones_ca LIKE'"+buscar+"%' OR " 
                        + "Sueldos_ca LIKE'"+buscar+"%'"
                       + ")";
//                        + "Nombre_ca LIKE'"+buscar+"%'"
//                        + ")";
            }
            
        
        String datos[] = new String[4];
        
        try{
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                
                datos[0] = rs.getString("Id_De_Boni");
                datos[1] = rs.getString("Nombre_De_Boni");
                datos[2] = rs.getString("Descripcion_De_Boni");
//                datos[3] = rs.getString("Valor_De_Boni");
                modelo.addRow(datos);
                
            }
           // MOSTRARCARGO.tblCa.setModel(modelo);//la tabla se actualiza. HacerCalculos(r);
        }catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            }
        
         
          public static void setListarBONIUpdate(String buscar){
            DefaultTableModel modelo = (DefaultTableModel)Seleccionar_Bonificacioin_Update.tblBoni.getModel();
            //modelo.fireTableDataChanged();
            
            
            while(modelo.getRowCount() > 0 ){
                modelo.removeRow(0);
                
            }
            
            String sql = "";
            if(buscar.equals("")){
                sql = Sentencias.LISTARBONI;
                
            } 
            else{
                sql = "SELECT * FROM LOCAL_MP WHERE ("
                        + "Id_ca LIKE'"+buscar+"%' OR "
                        + "Tipo_ca LIKE'"+buscar+"%' OR "
                        + "Nombre_ca LIKE'"+buscar+"%' OR "
                       + "Funciones_ca LIKE'"+buscar+"%' OR " 
                        + "Sueldos_ca LIKE'"+buscar+"%'"
                       + ")";
//                        + "Nombre_ca LIKE'"+buscar+"%'"
//                        + ")";
            }
            
        
        String datos[] = new String[4];
        
        try{
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                
                datos[0] = rs.getString("Id_De_Boni");
                datos[1] = rs.getString("Nombre_De_Boni");
                datos[2] = rs.getString("Descripcion_De_Boni");
//                datos[3] = rs.getString("Valor_De_Boni");
                modelo.addRow(datos);
                
            }
           // MOSTRARCARGO.tblCa.setModel(modelo);//la tabla se actualiza. HacerCalculos(r);
        }catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            }
        
           //FUNCIONES BONIFICACIONES
        public static boolean isRegisterBonificacion(Sentencias s){
        String sql = Sentencias.REGISTRAR_BONIFICACION;
        
        try{
        ps = conexion.prepareStatement(sql);
        
        ps.setString(1, s.getNombre_De_Boni());
        ps.setString(2, s.getDescripcion_De_Boni());
       // ps.setDouble(3, s.getValor_De_Boni());
        
        
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
      public static boolean isUpdateBonificacion(Sentencias s){
        String sql = Sentencias.UPDATE_BONIFICACION;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setString(1, s.getNombre_De_Boni());
        ps.setString(2, s.getDescripcion_De_Boni());
        //ps.setDouble(3, s.getValor_De_Boni());
        ps.setInt(3, s.getId_De_Boni());
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
      
        public static boolean isDeleteBonificacion(Sentencias s){
        String sql = Sentencias.ELIMINAR_BONIFICACION;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setInt(1, s.getId_De_Boni());
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            return false;
       }
    }
    
        public static void setListarBonificacion(String buscar){
            DefaultTableModel modelo = (DefaultTableModel)MostrarBonificacione.tblBonii.getModel();
  
            while(modelo.getRowCount() > 0 ){
                modelo.removeRow(0);
                
            }
            
            String sql = "";
            if(buscar.equals("")){
                sql = Sentencias.LISTAR_BONIFICACIONES;
                
            } 
            else{
                sql = "SELECT * FROM DETALLE_BONIFICACION WHERE ("
                        + "Id_De_Boni LIKE'"+buscar+"%' OR "
                        + "Nombre_De_Boni LIKE'"+buscar+"%' OR "
                        + "Descripcion_De_Boni LIKE'"+buscar+"%' OR "
                        + "Valor_De_Boni LIKE'"+buscar+"%'"
                       + ")";
            }
            
        
        String datos[] = new String[4];
        
        try{
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0] = rs.getString("Id_De_Boni");
                datos[1] = rs.getString("Nombre_De_Boni");
                datos[2] = rs.getString("Descripcion_De_Boni");
//                datos[3] = rs.getString("Valor_De_Boni");
                modelo.addRow(datos);
                
            }
        }catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            }
        
        public static String extraerIdMaxBonificacion(){
            
            String sql = "SELECT MAX(Id_De_Boni)FROM DETALLE_BONIFICACION";
            int Id_De_Boni=0;
            
            try{
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                Id_De_Boni = rs.getInt(1);    
            }
            if(Id_De_Boni == 0){
                Id_De_Boni =1;
            }else{
                Id_De_Boni = Id_De_Boni +1;
                
            }
            
            return String.valueOf(Id_De_Boni);
        }catch (SQLException ex){
            return null;
            
        }
        }
        
        
        
        
        
        
        //FUNCIONES DEDUCCIONES
        public static boolean isRegisterDeduccion(Sentencias s){
        String sql = Sentencias.REGISTRAR_DEDUCCION;
        
        try{
        ps = conexion.prepareStatement(sql);
        
        ps.setString(1, s.getNombre_De());
        ps.setString(2, s.getDescripcion_De());
       // ps.setDouble(3, s.getValor_De());
        
        
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            return false;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      public static boolean isUpdateDeduccion(Sentencias s){
        String sql = Sentencias.UPDATE_DEDUCCION;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setString(1, s.getNombre_De());
        ps.setString(2, s.getDescripcion_De());
       // ps.setDouble(3, s.getValor_De());
        ps.setInt(3, s.getId_De());
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
      
        public static boolean isDeleteDeduccion(Sentencias s){
        String sql = Sentencias.ELIMINAR_DEDUCCION;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setInt(1, s.getId_De());
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            return false;
       }
    }
    
        public static void setListarDeduccion(String buscar){
            DefaultTableModel modelo = (DefaultTableModel)MostrarDeduccion.tblDedu.getModel();
  
            while(modelo.getRowCount() > 0 ){
                modelo.removeRow(0);
                
            }
            
            String sql = "";
            if(buscar.equals("")){
                sql = Sentencias.LISTAR_DEDUCCIONES;
                
            } 
            else{
                sql = "SELECT * FROM DEDUCCION WHERE ("
                        + "Id_De LIKE'"+buscar+"%' OR "
                        + "Nombre_De LIKE'"+buscar+"%' OR "
                        + "Descripcion_De LIKE'"+buscar+"%' OR "
                        + "Valor_De LIKE'"+buscar+"%'"
                       + ")";
            }
            
        
        String datos[] = new String[4];
        
        try{
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0] = rs.getString("Id_De");
                datos[1] = rs.getString("Nombre_De");
                datos[2] = rs.getString("Descripcion_De");
//                datos[3] = rs.getString("Valor_De");
                modelo.addRow(datos);
                
            }
        }catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            }
        
        public static String extraerIdMaxDeduccion(){
            
            String sql = "SELECT MAX(Id_De)FROM DEDUCCION";
            int Id_De=0;
            
            try{
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                Id_De = rs.getInt(1);    
            }
            if(Id_De == 0){
                Id_De =1;
            }else{
                Id_De = Id_De +1;
                
            }
            
            return String.valueOf(Id_De);
        }catch (SQLException ex){
            return null;
            
        }
        }
          public static boolean isDeletePlanilla(Sentencias s){
        String sql = Sentencias.DELETE_PLANILLA;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setInt(1, s.getId_Pla());
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            return false;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
          
          
           public static void setListarProductos(String buscar){
            DefaultTableModel modelo = (DefaultTableModel)VENTA.tblProductos.getModel();
  
            while(modelo.getRowCount() > 0 ){
                modelo.removeRow(0);
                
            }
            
            String sql = "";
            if(buscar.equals("")){
                sql = Sentencias.alumnos;
                
            } 
            else{
                sql = "SELECT * FROM Catalogo_Productos "
                        + "WHERE ("
                        + "Nombre LIKE'"+buscar+"%' OR "
                        + "Descripcion LIKE'"+buscar+"%'"
                       + ")";
            }
            
        
        String datos[] = new String[3];
        
        try{
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0] = rs.getString("id");
                datos[1] = rs.getString("Nombre");
                datos[2] = rs.getString("Descripcion");
               
                modelo.addRow(datos);
                VENTA.tblProductos.getColumnModel().getColumn(0).setMaxWidth(0);
                    VENTA.tblProductos.getColumnModel().getColumn(0).setMinWidth(0);
                    VENTA.tblProductos.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
                    VENTA.tblProductos.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
                
            }
        }catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            }
           
           
           
           //INVENTARIO
           public static void setListarInventario(String buscar){
            DefaultTableModel modelo = (DefaultTableModel)REGISTRO_PRODUCTOS.tblInventario.getModel();
  
            while(modelo.getRowCount() > 0 ){
                modelo.removeRow(0);
                
            }
            
            String sql = "";
            if(buscar.equals("")){
                sql = Sentencias.inventario;
                
            } 
            else{
                sql = "SELECT * FROM DEDUCCION WHERE ("
                        + "Id_De LIKE'"+buscar+"%' OR "
                        + "Nombre_De LIKE'"+buscar+"%' OR "
                        + "Descripcion_De LIKE'"+buscar+"%' OR "
                        + "Valor_De LIKE'"+buscar+"%'"
                       + ")";
            }
            
        
        String datos[] = new String[3];
        
        try{
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0] = rs.getString("Id_IMP");
                datos[1] = rs.getString("Nombre_IMP");
                datos[2] = rs.getString("Unidad_Medida_IMP");
                
                modelo.addRow(datos);
                
            }
        }catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            }
                      public static void setListarInventarioUpdate(String buscar){
            DefaultTableModel modelo = (DefaultTableModel)UPDATE_P.tblInventario.getModel();
  
            while(modelo.getRowCount() > 0 ){
                modelo.removeRow(0);
                
            }
            
            String sql = "";
            if(buscar.equals("")){
                sql = Sentencias.inventario;
                
            } 
            else{
                sql = "SELECT * FROM DEDUCCION WHERE ("
                        + "Id_De LIKE'"+buscar+"%' OR "
                        + "Nombre_De LIKE'"+buscar+"%' OR "
                        + "Descripcion_De LIKE'"+buscar+"%' OR "
                        + "Valor_De LIKE'"+buscar+"%'"
                       + ")";
            }
            
        
        String datos[] = new String[3];
        
        try{
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0] = rs.getString("Id_IMP");
                datos[1] = rs.getString("Nombre_IMP");
                datos[2] = rs.getString("Unidad_Medida_IMP");
                
                modelo.addRow(datos);
                
            }
        }catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            }
           
           
           
           
            public static boolean isRegisterDetalle_Pro(Sentencias s){
        String sql = Sentencias.REGISTRAR_D_PRO;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setDouble(1, s.getCantidad_De_Pro());
        ps.setInt(2, s.getFK_IMP());
        ps.setInt(3, s.getFK_Pro());
        
        
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
             Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            return false;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
      public static boolean isUpdateDetalle_Pro(Sentencias s){
        String sql = Sentencias.UPDATE;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setInt(1, s.getId_De_Pro());
        ps.setDouble(2, s.getCantidad_De_Pro());
        ps.setInt(3, s.getFK_IMP());
        ps.setInt(4, s.getFK_Pro());
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            return false;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
        public static boolean isDeleteDetalle_Pro(Sentencias s){
        String sql = Sentencias.ELIMINAR;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setInt(1, s.getId_ca());
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            return false;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
         public static void setListarDetalleInventarioUpdate(String Id_Pla){
            DefaultTableModel modelo = (DefaultTableModel)UPDATE_P.tblPro.getModel();
            
            //modelo.fireTableDataChanged();
 
            
            while(modelo.getRowCount() > 0 ){
                modelo.removeRow(0);
                
            }
            
            
               String sql = "select Id_De_Pro, Id_IMP, Cantidad_De_Pro, Nombre_IMP, Unidad_Medida_IMP "
                       + "from INVENTARIO "
                       + "inner join DETALLE_PRODUCTO "
                       + "ON ID_IMP = FK_IMP "
                       + "where FK_Pro = '" +Id_Pla+ "' ";
        
        String datos[] = new String[5];
        
        try{
 Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0] = rs.getString("Id_IMP");
                datos[1] = rs.getString("Nombre_IMP");
                datos[2] = rs.getString("Cantidad_De_Pro");
                datos[3] = rs.getString("Unidad_Medida_IMP");
                datos[4] = rs.getString("Id_De_Pro");
                modelo.addRow(datos);
                
            }
           // MOSTRARCARGO.tblCa.setModel(modelo);//la tabla se actualiza. HacerCalculos(r);
        }catch (SQLException ex){
            
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            }
         
         public static boolean isDeleteDetalle_Pros(Sentencias s){
        String sql = Sentencias.DELETE_DETALLEPRODUCTO;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setInt(1, s.getId_De_Pro());
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            return false;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
         
 
         
                 public static String extraerVentaMax(){
            
            String sql = "SELECT MAX(id)FROM Pagos";
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
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            return null;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
                 }
         
         
         
          public static boolean isRegisterVenta(Sentencias s){
        String sql = Sentencias.REGISTRAR_Venta;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setString(1, s.getFecha_VV());
        ps.setString(3, s.getNo_Factura_VV());
        ps.setString(2, s.getTelefon_CL());
        ps.setInt(4, s.getSar());
        ps.setDouble(5, s.getImpuestogravado());
        ps.setDouble(6, s.getTotal());
        
        
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
             Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            return false;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
          
                    public static boolean isRegisterDetalle_Venta(Sentencias s){
        String sql = Sentencias.REGISTRAR_Venta_Detalle;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setInt(1, s.getCantidad_V());
        ps.setInt(2, s.getId_P());
        ps.setInt(3, s.getFk_vv());
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
             Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            return false;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
                    
                    
        public static boolean isRegisterDetalle_Pago(int precio, int idpago, String Mes, int idproducto, String fecha){
        String sql = Sentencias.Registrar_deta_pago;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setInt(1, precio);
        ps.setInt(2, idpago);
        ps.setString(3, Mes);
        ps.setInt(4, idproducto);
        ps.setString(5, fecha);
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
             Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            return false;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
                    
                    
          public static void setConsultarDetalle_Producto(Sentencias s){
                
                String sql = "SELECT * FROM DETALLE_PRODUCTO WHERE FK_Pro=?";
                try{
        
            Statement st = conexion.createStatement();
            
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, s.getId_P());
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                s.setId_De_Pro(rs.getInt(1));
                s.setCantidad_De_Pro(rs.getDouble(2));
                
               JOptionPane.showMessageDialog(null, s.getCantidad_De_Pro());
                
            }
        }catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
          }
          
          
           public static boolean isUpdateInventarioVenta(Sentencias s){
        String sql = "UPDATE INVENTARIO SET "
           +"Existencia_IMP=? "
           +"WHERE Id_IMP=?";
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setDouble(1, s.getCantidad_De_Pro());
        ps.setDouble(2, s.getFK_IMP());
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            return false;
           
        }
    }
           
           
           public static void setConsultarExistencia(Sentencias s){
                
                String sql = "SELECT * FROM INVENTARIO WHERE Id_IMP=?";
                try{
        
            Statement st = conexion.createStatement();
            
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, s.getFK_IMP());
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                s.setExistencia_IMP(rs.getInt(5));
               
                
            }
        }catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            
            
        
        

     }
           
           
            public static void setListarVentas(String Inicial, String finall){
            DefaultTableModel modelo = (DefaultTableModel)MostrarVentas.tblMostrarVenta.getModel();
            //modelo.fireTableDataChanged();
 
            
            while(modelo.getRowCount() > 0 ){
                modelo.removeRow(0);
                
            }
            String sql = "";
                if (Inicial.equals("")&& finall.equals("")) {
               
                   
                   sql = "Select Id_VV, Fecha_VV, No_Factura_VV, VENTAS.Telefono_CL, Tipo_VV, Valor_Neto_Factura_V, Nombre_CL, Apellidos_CL, Direccion_CL, RTN_CL, Segunda_Direccion_CL "
                + "from VENTAS "
                + "inner join CLIENTES "
                + "on VENTAS.Telefono_CL = Clientes.Telefono_CL ";
                    
                }else{
            
            
                  sql = sql = "Select Id_VV, Fecha_VV, No_Factura_VV, VENTAS.Telefono_CL, Tipo_VV, Valor_Neto_Factura_V, Nombre_CL, Apellidos_CL, Direccion_CL, RTN_CL, Segunda_Direccion_CL "
                + "from VENTAS "
                + "inner join CLIENTES "
                + "on VENTAS.Telefono_CL = Clientes.Telefono_CL "
                + "where Fecha_VV BETWEEN '"+ Inicial + "' and '" + finall +"'";
               
                }
                
               
//                      
            
            
        
        String datos[] = new String[11];
        
        try{
 Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0] = rs.getString("Id_VV");
                datos[1] = rs.getString("Fecha_VV");
                datos[3] = rs.getString("Telefono_CL");
                datos[2] = rs.getString("Tipo_VV");
                datos[4] = rs.getString("Valor_Neto_Factura_V");
                datos[5] = rs.getString("Nombre_CL");
                datos[6] = rs.getString("Apellidos_CL");
                datos[7] = rs.getString("Direccion_CL");
                datos[8] = rs.getString("RTN_CL");
                datos[9] = rs.getString("Segunda_Direccion_CL");
                datos[10] = rs.getString("No_Factura_VV");
                modelo.addRow(datos);
                DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
                tcr.setHorizontalAlignment(SwingConstants.RIGHT);
                MostrarVentas.tblMostrarVenta.setModel(modelo);
                MostrarVentas.tblMostrarVenta.getColumnModel().getColumn(4).setCellRenderer(tcr);
                
            }
        }catch (SQLException ex){
            
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            }
            
     public static void setListarOrden(){
            DefaultTableModel modelo = (DefaultTableModel)Orden_Pedido.tblOrden_Pedido.getModel();
            //modelo.fireTableDataChanged();
 
            
            while(modelo.getRowCount() > 0 ){
                modelo.removeRow(0);
                
            }
            
            
               String sql = "Select Id_Pedido, Cantidad_Pizza, Nombre_P, Num_Piezas_P, Tamanio_P, No_Factura_VV, Nombre_CL "
                + "from ORDEN_PEDIDO "
                + "inner join PRODUCTOS "
                + "on Id_Pizza = Id_P "
                + "inner join VENTAS "
                + "ON Id_VV = FK_Venta "
                + "inner join CLIENTES "
                + "ON VENTAS.Telefono_CL = CLIENTES.Telefono_CL ";
               
               
//                      
            
            
        
        String datos[] = new String[7];
        
        try{
 Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0] = rs.getString("Id_Pedido");
                datos[2] = rs.getString("Cantidad_Pizza");
                datos[1] = rs.getString("Nombre_P");
                datos[3] = rs.getString("Num_Piezas_P");
                datos[4] = rs.getString("Tamanio_P");
                datos[5] = rs.getString("No_Factura_VV");
                datos[6] = rs.getString("Nombre_CL");
                modelo.addRow(datos);
                
            }
           // MOSTRARCARGO.tblCa.setModel(modelo);//la tabla se actualiza. HacerCalculos(r);
        }catch (SQLException ex){
            
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            }
     
     
     public static String extraerNumerofactura(){
            
            String sql = "SELECT Secuencia_Sar from SAR where Id_sar = (select MAX(Id_sar)FROM SAR)";
            String Id_L=null;
            
            try{
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                Id_L = rs.getString(1);    
            }
            String obtener = Id_L.split("-")[3];
            int res = Integer.parseInt(obtener);
            int total = res+1;
           // int RangoFinal = Integer.parseInt(extraerRangoMaximo());
            
            
                if (total>=0 && total<=9) {
                String secuencia = "0000000"+total;
            String d = String.valueOf(secuencia);
            String a = Id_L.split("-")[0];
            String b = Id_L.split("-")[1];
            String c = Id_L.split("-")[2];
            
            String union = a+"-"+b+"-"+c+"-"+d;
            
            return String.valueOf(union);
                    
                }else if (total>=10 && total<=99) {
                    String secuencia = "000000"+total;
            String d = String.valueOf(secuencia);
            String a = Id_L.split("-")[0];
            String b = Id_L.split("-")[1];
            String c = Id_L.split("-")[2];
            
            String union = a+"-"+b+"-"+c+"-"+d;
            
            return String.valueOf(union);
                    
                }else if (total>=100 && total<=999) {
                    String secuencia = "00000"+total;
            String d = String.valueOf(secuencia);
            String a = Id_L.split("-")[0];
            String b = Id_L.split("-")[1];
            String c = Id_L.split("-")[2];
            
            String union = a+"-"+b+"-"+c+"-"+d;
            
            return String.valueOf(union);
                    
                }else if (total>=1000 && total<=9999) {
                    String secuencia = "0000"+total;
            String d = String.valueOf(secuencia);
            String a = Id_L.split("-")[0];
            String b = Id_L.split("-")[1];
            String c = Id_L.split("-")[2];
            
            String union = a+"-"+b+"-"+c+"-"+d;
            
            return String.valueOf(union);
                    
                }
                else if (total>=10000 && total<=99999) {
                    String secuencia = "000"+total;
            String d = String.valueOf(secuencia);
            String a = Id_L.split("-")[0];
            String b = Id_L.split("-")[1];
            String c = Id_L.split("-")[2];
            
            String union = a+"-"+b+"-"+c+"-"+d;
            
            return String.valueOf(union);
                    
                }
                  else if (total>=100000 && total<=999999) {
                    String secuencia = "00"+total;
            String d = String.valueOf(secuencia);
            String a = Id_L.split("-")[0];
            String b = Id_L.split("-")[1];
            String c = Id_L.split("-")[2];
            
            String union = a+"-"+b+"-"+c+"-"+d;
            
            return String.valueOf(union);
                    
                }
                    else if (total>=1000000 && total<=9999999) {
                    String secuencia = "0"+total;
            String d = String.valueOf(secuencia);
            String a = Id_L.split("-")[0];
            String b = Id_L.split("-")[1];
            String c = Id_L.split("-")[2];
            
            String union = a+"-"+b+"-"+c+"-"+d;
            
            return String.valueOf(union);
                    
                }
                      else if (total>=10000000 && total<=99999999) {
                    String secuencia = ""+total;
            String d = String.valueOf(secuencia);
            String a = Id_L.split("-")[0];
            String b = Id_L.split("-")[1];
            String c = Id_L.split("-")[2];
            
            String union = a+"-"+b+"-"+c+"-"+d;
            
            return String.valueOf(union);
                    
                }
                else{
                    return null; 
                }
                
        }catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            return null;
            
        }
                 }
     
     
          public static String extraerRangoMaximo(){
              String secuencia = extraerNumerofactura();
              String separar = secuencia.split("-")[3];
              int numeroF = Integer.parseInt(separar);
              
              
              String fe = extraerFechaMaxima();
            
            String sql = "SELECT Rango_Al from SAR where Id_sar = (select MAX(Id_sar)FROM SAR)";
            String Id_L=null;
            
            try{
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                Id_L = rs.getString(1);    
            }
            String obtener = Id_L.split("-")[3];
            int res = Integer.parseInt(obtener);
            int resta = res - numeroF;
            
             java.util.Date fecha = new java.util.Date();
               SimpleDateFormat formato = new SimpleDateFormat("yyy-MM-dd");
               //lblFechaSistema.setText(formato.format(fecha));
               String fechas = formato.format(fecha);
               
               
               if (fe.equals(fechas)) {
                    JOptionPane.showMessageDialog(null, "Su fecha maxima expira hoy");
                    return String.valueOf("Registre un nuevo rango, su fecha expira hoy");
               }
               
                
                try {
                      Date hoyy = formato.parse(fechas);
            Date fecha_c = formato.parse(fe);
            
                    if (hoyy.after(fecha_c)) {
                        JOptionPane.showMessageDialog(null, "Debe registrar una nueva fecha limite");
                   VENTA.txtPrecio.setEditable(false);
                    VENTA.txtIdentidad.setEditable(false);
                    VENTA.txtPrecio.setEnabled(false);
                    VENTA.TXTnombre.setEditable(false);
                    VENTA.txtGrado.setEditable(false);                        
                    }
                }
            catch (Exception e) {
                }
            
                if (resta ==-1) {
                   VENTA.txtPrecio.setEditable(false);
                    VENTA.txtIdentidad.setEditable(false);
                    VENTA.txtPrecio.setEnabled(false);
                    VENTA.TXTnombre.setEditable(false);
                    VENTA.txtGrado.setEditable(false);
                }
                if (resta<=50) {
                    JOptionPane.showMessageDialog(null, "Debe registrar un nuevo rango");
                    
                    return String.valueOf("Solo puede generar "+resta+" mas");
                    
                    
                }else{

            
            
            
            return null;
                }
                
        }catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            return null;
            
        }
                 }
          
          
          
          public static String extraerFechaMaxima(){
   
            
            String sql = "SELECT Fecha_Lim from SAR where Id_sar = (select MAX(Id_sar)FROM SAR)";
            String Id_L=null;
            
            try{
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                Id_L = rs.getString(1);    
            }
            
               
            
            
            
            return Id_L;
                
        }catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            return null;
            
        }
                 }
          
          public static String extraerImpuesto(){
   
            
            String sql = "SELECT Impuesto_Sar from SAR where Id_sar = (select MAX(Id_sar)FROM SAR)";
            String Id_L=null;
            
            try{
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                Id_L = rs.getString(1);    
            }
            
               
            
            
            
            return String.valueOf(Id_L);
                
        }catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            return null;
            
        }
                 }
     
     
     public static String extraerIdMaxSAR(){
            
            String sql = "select MAX(Id_sar)FROM SAR";
            int Id_L=0;
            
            try{
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                Id_L = rs.getInt(1);    
            }
            
            return String.valueOf(Id_L);
        }catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            return null;
            
        }
                 }
     
     
     
      public static void setListarMayor(String Inicial){
            DefaultTableModel modelo = (DefaultTableModel)MayorDeAlgo.tblMayor.getModel();
            //modelo.fireTableDataChanged();
 
            
            while(modelo.getRowCount() > 0 ){
                modelo.removeRow(0);
                
            }
            String sql = "";
                if (Inicial.equals("CLIENTE")) {
               
                   
                   sql = "select count(V.Telefono_CL) ee, Nombre_CL, C.Telefono_CL as e "
                           + "from CLIENTES AS C, VENTAS AS V "
                           + "where V.Telefono_CL = C.Telefono_CL "
                           + "group by C.Telefono_CL, Nombre_CL "
                           + "order by ee desc";
                   String datos[] = new String[3];
        
        try{
 Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[2] = rs.getString("ee");
                datos[1] = rs.getString("Nombre_CL");
                datos[0] = rs.getString("e");
                modelo.addRow(datos);
                
            }
        }catch (SQLException ex){
            
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
                    
                }else{
                  String sq = "select count(V.Id_P) ee, Nombre_P, C.Id_P as e "
                           + "from PRODUCTOS AS C, DETALLE_VENTA AS V "
                           + "where V.Id_P = C.Id_P "
                           + "group by C.Id_P, Nombre_P "
                           + "order by ee desc";
                  
                   String datos[] = new String[3];
        
        try{
 Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sq);
            
            while(rs.next()){
                datos[2] = rs.getString("ee");
                datos[1] = rs.getString("Nombre_P");
                datos[0] = rs.getString("e");
                modelo.addRow(datos);
                
            }
        }catch (SQLException ex){
            
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
               
                }
            }
            
           
            
            
             public static boolean isDeleteDetalle_Orden(Sentencias s){
        String sql = Sentencias.DELETE_Orden;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setInt(1, s.getId_orden());
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            return false;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
             
             
             public static void setListarUsu(Sentencias s){
                
                String sql = Sentencias.LISTARUSU;
                try{
        
            Statement st = conexion.createStatement();
            
            ps = conexion.prepareStatement(sql);
            ps.setString(1, s.getName());
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                s.setNam1(rs.getString(1));
               
                
            }
        }catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
             }
             
             
       private String env;

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }         
                 public static void setListarUsuUpdate(String Id_uUsu, Sentencias s){
 
                String sql = "SELECT * FROM USUARIOS WHERE Id_Usu=?";
                try{
        
            Statement st = conexion.createStatement();
            
            ps = conexion.prepareStatement(sql);
            ps.setString(1, Id_uUsu);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                s.setEnv(rs.getString(2));
               
                
            }
        }catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
             }      
                 
                   public static String setListarCargoUpdate(String Id_uUsu){
 
                String sql = "SELECT * FROM CARGOS WHERE Id_ca=?";
                try{
                  String  valor = null;
        
            Statement st = conexion.createStatement();
            
            ps = conexion.prepareStatement(sql);
            ps.setString(1, Id_uUsu);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                valor = rs.getString(2);
//                if(rs.next()){
//                Id_L = rs.getInt(1);    
//            }
                
               
                
            }
            return valor;
        }catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
           return null;
            
        }
             }
           
                   
                     public static String setListarCargoUpdate2(String Id_uUsu){
 
                String sql = "SELECT * FROM CARGOS WHERE Id_ca=?";
                try{
                  String  valor = null;
        
            Statement st = conexion.createStatement();
            
            ps = conexion.prepareStatement(sql);
            ps.setString(1, Id_uUsu);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                valor = rs.getString(3);
//                if(rs.next()){
//                Id_L = rs.getInt(1);    
//            }
                
               
                
            }
            return valor;
        }catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
           return null;
            
        }
             }
         
         
   
         
           public static String PruductoValidate(String Id_uUsu, String num, String Tama){
 
                String sql = "SELECT * FROM PRODUCTOS WHERE Nombre_P=? and Num_Piezas_P=? and Tamanio_P=?";
                try{
                  String  valor = null;
        
            Statement st = conexion.createStatement();
            
            ps = conexion.prepareStatement(sql);
            ps.setString(1, Id_uUsu);
            ps.setString(2, Tama);
            ps.setString(3, num);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                
                //valor = rs.getString(2);
                valor ="1";
//                if(rs.next()){
//                Id_L = rs.getInt(1);    
//            }
                
            }else{
                valor = "0";
            }
            return valor;
        }catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
           return null;
            
        }
             }
           
           
           public static String update_P(String Id_uUsu){
 
                String sql = "SELECT * FROM PRODUCTOS WHERE Id_P=?";
                try{
                  String  valor = null;
        
            Statement st = conexion.createStatement();
            
            ps = conexion.prepareStatement(sql);
            ps.setString(1, Id_uUsu);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                valor = rs.getString(2);
//                if(rs.next()){
//                Id_L = rs.getInt(1);    
//            }
                
               
                
            }
            return valor;
        }catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
           return null;
            
        }
             }
           
           public static String update_P_TA(String Id_uUsu){
 
                String sql = "SELECT * FROM PRODUCTOS WHERE Id_P=?";
                try{
                  String  valor = null;
        
            Statement st = conexion.createStatement();
            
            ps = conexion.prepareStatement(sql);
            ps.setString(1, Id_uUsu);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                valor = rs.getString(5);
//                if(rs.next()){
//                Id_L = rs.getInt(1);    
//            }
                
               
                
            }
            return valor;
        }catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
           return null;
            
        }
             }
           
           
           public static String update_NUM(String Id_uUsu){
 
                String sql = "SELECT * FROM PRODUCTOS WHERE Id_P=?";
                try{
                  String  valor = null;
        
            Statement st = conexion.createStatement();
            
            ps = conexion.prepareStatement(sql);
            ps.setString(1, Id_uUsu);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                valor = rs.getString(6);
//                if(rs.next()){
//                Id_L = rs.getInt(1);    
//            }
                
               
                
            }
            return valor;
        }catch (SQLException ex){
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
           return null;
            
        }
             }
         
  
          
 
        
}
