/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import Reportes.Reportes;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import proyectomp.Funciones;

/**
 *
 * @author Irving Calix
 */
public class MostrarFacturas extends javax.swing.JPanel {

    /**
     * Creates new form MostrarFacturas
     */
    public MostrarFacturas() {
        initComponents();
        Controllers.Pagos.setListarVentas("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPagos = new javax.swing.JTable();
        txtAlumno = new javax.swing.JTextField();
        alumno = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblPagos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Alumno", "Factura", "Fecha", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPagos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPagosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPagos);
        if (tblPagos.getColumnModel().getColumnCount() > 0) {
            tblPagos.getColumnModel().getColumn(0).setResizable(false);
            tblPagos.getColumnModel().getColumn(1).setResizable(false);
            tblPagos.getColumnModel().getColumn(2).setResizable(false);
            tblPagos.getColumnModel().getColumn(3).setResizable(false);
            tblPagos.getColumnModel().getColumn(4).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 1080, 490));

        txtAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAlumnoKeyReleased(evt);
            }
        });
        add(txtAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 240, -1));

        alumno.setBackground(new java.awt.Color(0, 0, 0));
        alumno.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        alumno.setText("Alumno");
        add(alumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 70, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 630));
    }// </editor-fold>//GEN-END:initComponents

    private void txtAlumnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAlumnoKeyReleased
        Controllers.Pagos.setListarVentas(txtAlumno.getText());
    }//GEN-LAST:event_txtAlumnoKeyReleased

    private void tblPagosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPagosMouseClicked
        if (evt.getClickCount() == 2) {
            int fila = tblPagos.getSelectedRow(); 
            String id = tblPagos.getValueAt(fila, 0).toString();
            
             try {
            Reportes reporte = new Reportes();
             HashMap datos = new HashMap();
             datos.put("pa_id", id);
             reporte.ReporteVenta(datos);
        } catch (JRException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
             catch(SQLException ex){
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_tblPagosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alumno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tblPagos;
    private javax.swing.JTextField txtAlumno;
    // End of variables declaration//GEN-END:variables
}