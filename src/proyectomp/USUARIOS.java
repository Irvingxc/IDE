/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectomp;

import Reportes.Reportes;
import java.awt.Event;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import static proyectomp.EMPLEADOS.tblTabla;
import static proyectomp.EMPLEADOSS_Update.cargarFoto;
import static proyectomp.EMPLEADOSS_Update.url;

/**
 *
 * @author angel
 */
public class USUARIOS extends javax.swing.JFrame {

    /**
     * Creates new form USUARIOS
     */  

    public USUARIOS() {
        initComponents();
        this.setResizable(false);
        tblTabla.getTableHeader().setReorderingAllowed(false);
        tblTabla.setSelectionMode(NORMAL);
        InputMap map3 = jTextField1.getInputMap(JTextField.WHEN_FOCUSED); 
    map3.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
    
    
        Funciones_Angel.setListarUsu("");
        this.setLocationRelativeTo(null);
        
        
         
        
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnimprimir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsu = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnimprimir.setText("IMPRIMIR");
        btnimprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimprimirActionPerformed(evt);
            }
        });
        jPanel1.add(btnimprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 330, 110, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("LISTA DE USUARIOS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 11, -1, -1));

        jLabel2.setText("BUSCAR");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(373, 42, -1, -1));

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(431, 39, 92, -1));

        tablaUsu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nombre de Usuario", "Contraseña", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12", "Title 13", "Title 14", "Title 15", "Title 16", "Title 17", "Title 18", "Title 19", "Title 20", "Title 21", "Title 22"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaUsu);
        if (tablaUsu.getColumnModel().getColumnCount() > 0) {
            tablaUsu.getColumnModel().getColumn(3).setMinWidth(0);
            tablaUsu.getColumnModel().getColumn(3).setPreferredWidth(0);
            tablaUsu.getColumnModel().getColumn(3).setMaxWidth(0);
            tablaUsu.getColumnModel().getColumn(4).setMinWidth(0);
            tablaUsu.getColumnModel().getColumn(4).setPreferredWidth(0);
            tablaUsu.getColumnModel().getColumn(4).setMaxWidth(0);
            tablaUsu.getColumnModel().getColumn(5).setMinWidth(0);
            tablaUsu.getColumnModel().getColumn(5).setPreferredWidth(0);
            tablaUsu.getColumnModel().getColumn(5).setMaxWidth(0);
            tablaUsu.getColumnModel().getColumn(6).setMinWidth(0);
            tablaUsu.getColumnModel().getColumn(6).setPreferredWidth(0);
            tablaUsu.getColumnModel().getColumn(6).setMaxWidth(0);
            tablaUsu.getColumnModel().getColumn(7).setMinWidth(0);
            tablaUsu.getColumnModel().getColumn(7).setPreferredWidth(0);
            tablaUsu.getColumnModel().getColumn(7).setMaxWidth(0);
            tablaUsu.getColumnModel().getColumn(8).setMinWidth(0);
            tablaUsu.getColumnModel().getColumn(8).setPreferredWidth(0);
            tablaUsu.getColumnModel().getColumn(8).setMaxWidth(0);
            tablaUsu.getColumnModel().getColumn(9).setMinWidth(0);
            tablaUsu.getColumnModel().getColumn(9).setPreferredWidth(0);
            tablaUsu.getColumnModel().getColumn(9).setMaxWidth(0);
            tablaUsu.getColumnModel().getColumn(10).setMinWidth(0);
            tablaUsu.getColumnModel().getColumn(10).setPreferredWidth(0);
            tablaUsu.getColumnModel().getColumn(10).setMaxWidth(0);
            tablaUsu.getColumnModel().getColumn(11).setMinWidth(0);
            tablaUsu.getColumnModel().getColumn(11).setPreferredWidth(0);
            tablaUsu.getColumnModel().getColumn(11).setMaxWidth(0);
            tablaUsu.getColumnModel().getColumn(12).setMinWidth(0);
            tablaUsu.getColumnModel().getColumn(12).setPreferredWidth(0);
            tablaUsu.getColumnModel().getColumn(12).setMaxWidth(0);
            tablaUsu.getColumnModel().getColumn(13).setMinWidth(0);
            tablaUsu.getColumnModel().getColumn(13).setPreferredWidth(0);
            tablaUsu.getColumnModel().getColumn(13).setMaxWidth(0);
            tablaUsu.getColumnModel().getColumn(14).setMinWidth(0);
            tablaUsu.getColumnModel().getColumn(14).setPreferredWidth(0);
            tablaUsu.getColumnModel().getColumn(14).setMaxWidth(0);
            tablaUsu.getColumnModel().getColumn(15).setMinWidth(0);
            tablaUsu.getColumnModel().getColumn(15).setPreferredWidth(0);
            tablaUsu.getColumnModel().getColumn(15).setMaxWidth(0);
            tablaUsu.getColumnModel().getColumn(16).setMinWidth(0);
            tablaUsu.getColumnModel().getColumn(16).setPreferredWidth(0);
            tablaUsu.getColumnModel().getColumn(16).setMaxWidth(0);
            tablaUsu.getColumnModel().getColumn(17).setMinWidth(0);
            tablaUsu.getColumnModel().getColumn(17).setPreferredWidth(0);
            tablaUsu.getColumnModel().getColumn(17).setMaxWidth(0);
            tablaUsu.getColumnModel().getColumn(18).setMinWidth(0);
            tablaUsu.getColumnModel().getColumn(18).setPreferredWidth(0);
            tablaUsu.getColumnModel().getColumn(18).setMaxWidth(0);
            tablaUsu.getColumnModel().getColumn(19).setMinWidth(0);
            tablaUsu.getColumnModel().getColumn(19).setPreferredWidth(0);
            tablaUsu.getColumnModel().getColumn(19).setMaxWidth(0);
            tablaUsu.getColumnModel().getColumn(20).setMinWidth(0);
            tablaUsu.getColumnModel().getColumn(20).setPreferredWidth(0);
            tablaUsu.getColumnModel().getColumn(20).setMaxWidth(0);
            tablaUsu.getColumnModel().getColumn(21).setMinWidth(0);
            tablaUsu.getColumnModel().getColumn(21).setPreferredWidth(0);
            tablaUsu.getColumnModel().getColumn(21).setMaxWidth(0);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 513, 243));

        jButton1.setText("ACTUALIZAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 110, 38));

        jButton2.setText("ELIMINAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 330, 94, 38));

        jButton3.setText("REGISTRAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 331, 101, 38));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo2.jpg"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 380));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int fila = tablaUsu.getSelectedRow();
        
        Sentencias_Angel s = new Sentencias_Angel();
        s.setId_Usu(Integer.parseInt(tablaUsu.getValueAt(fila, 0).toString()));
        
        int a= JOptionPane.showConfirmDialog(null, "esta seguro", "mostrar", JOptionPane.YES_NO_OPTION);
        if (a==JOptionPane.YES_NO_OPTION) {
     
        
        if(Funciones_Angel.isDeleteUsu(s)){
            
            JOptionPane.showMessageDialog(this, "Usuario Eliminado");
            Funciones_Angel.setListarUsu("");
        }else{
            JOptionPane.showMessageDialog(this, "No se a podido eliminar");
            
            
        }
        }else{
            JOptionPane.showMessageDialog(null, "No se realizo el eliminado");
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        CREAR_USUARIOS U = new CREAR_USUARIOS();
        U.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int fila = tablaUsu.getSelectedRow();
        
        
        ACTUALIZAR_USUARIOS EU = new ACTUALIZAR_USUARIOS();
         EU.LabelId.setText(tablaUsu.getValueAt(fila, 0).toString());
       EU.textNombre.setText(tablaUsu.getValueAt(fila, 1).toString());
       EU.TextContra.setText(tablaUsu.getValueAt(fila, 2).toString());
       EU.oculto.setText(tablaUsu.getValueAt(fila, 3).toString());
       EU.comboTip.setSelectedItem(tablaUsu.getValueAt(fila, 4));
       if(tablaUsu.getValueAt(fila, 5).toString().equals("1")){
           EU.checkBoni.setSelected(true);
       }
       if(tablaUsu.getValueAt(fila, 6).toString().equals("1")){
           EU.checkCargos.setSelected(true);
       }
       if(tablaUsu.getValueAt(fila, 7).toString().equals("1")){
           EU.checkCliente.setSelected(true);
       }
       if(tablaUsu.getValueAt(fila, 8).toString().equals("1")){
           EU.checkCompras.setSelected(true);
       }
       if(tablaUsu.getValueAt(fila, 9).toString().equals("1")){
           EU.checkDeduc.setSelected(true);
       }
       if(tablaUsu.getValueAt(fila, 10).toString().equals("1")){
           EU.checkEgreso.setSelected(true);
       }
       if(tablaUsu.getValueAt(fila, 11).toString().equals("1")){
           EU.checkEmplead.setSelected(true);
       }
       if(tablaUsu.getValueAt(fila, 12).toString().equals("1")){
           EU.checkHorario.setSelected(true);
       }
       if(tablaUsu.getValueAt(fila, 13).toString().equals("1")){
           EU.checkIngresos.setSelected(true);
       }
       if(tablaUsu.getValueAt(fila, 14).toString().equals("1")){
           EU.checkInventario.setSelected(true);
       }
       if(tablaUsu.getValueAt(fila, 15).toString().equals("1")){
           EU.checkLocal.setSelected(true);
       }
       if(tablaUsu.getValueAt(fila, 16).toString().equals("1")){
           EU.checkPlanilla.setSelected(true);
       }
       if(tablaUsu.getValueAt(fila, 17).toString().equals("1")){
           EU.checkProductos.setSelected(true);
       }
       if(tablaUsu.getValueAt(fila, 18).toString().equals("1")){
           EU.checkProveedor.setSelected(true);
       }
       if(tablaUsu.getValueAt(fila, 19).toString().equals("1")){
           EU.checkSar.setSelected(true);
       }
       if(tablaUsu.getValueAt(fila, 20).toString().equals("1")){
           EU.checkVenta.setSelected(true);
       }
       
       if(tablaUsu.getValueAt(fila, 21).toString().equals("1")){
           EU.checkUsuarios.setSelected(true);
       }
          
   try {
            
             Connection con=DriverManager.getConnection("jdbc:sqlserver://192.168.0.11:1433;databaseName=PROYECTO_MP", "Irvingx", "Iopteamop12");
             Statement sent = con.createStatement();
             ResultSet rs = sent.executeQuery("Select * from EMPLEADOS where Id_E="+ EU.oculto.getText());
             while(rs.next()){
                 
                 EU.nombreLabel.setText(rs.getString("Nombres_E"));
             
               
                
             }
             
             
        } catch (Exception ex) {
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    
              EU.setVisible(true);
                                          
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimprimirActionPerformed

    }//GEN-LAST:event_btnimprimirActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // TODO add your handling code here:
        jTextField1.setText(jTextField1.getText().replaceAll("( )+", " "));
        if (jTextField1.getText().length()==0 && evt.getKeyChar()==KeyEvent.VK_SPACE) {
            evt.consume();          
        }
    }//GEN-LAST:event_jTextField1KeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(USUARIOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(USUARIOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(USUARIOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(USUARIOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new USUARIOS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnimprimir;
    private javax.swing.JButton jButton1;
    public static javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    public static javax.swing.JTable tablaUsu;
    // End of variables declaration//GEN-END:variables
}