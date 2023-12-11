/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectomp;

import conexion.Conexion;
import static conexion.Conexion.conection;
import java.awt.Event;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import static proyectomp.EMPLEADOSS_CREAR.labelID;
import static proyectomp.EMPLEADOSS_CREAR.oculto;
import static proyectomp.EMPLEADOSS_CREAR.txareDirect;
import static proyectomp.EMPLEADOSS_CREAR.txtApell;
import static proyectomp.EMPLEADOSS_CREAR.txtNombre;
import static proyectomp.EMPLEADOSS_CREAR.txtRef;

/**
 *
 * @author Calix
 */
public class EMPLEADOSS_Update extends javax.swing.JFrame {
    
    

    /**
     * Creates new form EMPLEADOSS
     */
    
    int contador=0;
    int i = 0;
    public EMPLEADOSS_Update() {
        initComponents();
        
         this.setResizable(false);
        
        txareDirect.setLineWrap(true);

        
        InputMap map3 = txtNombre.getInputMap(JTextField.WHEN_FOCUSED); 
    map3.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
    
     InputMap map = txtApell.getInputMap(JTextField.WHEN_FOCUSED); 
    map.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
        
     InputMap map1 = txtRef.getInputMap(JTextField.WHEN_FOCUSED); 
    map1.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
    
     InputMap map2 = txareDirect.getInputMap(JTextField.WHEN_FOCUSED); 
    map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
    
    ((JTextField)this.calendarInic.getDateEditor()).setEditable(false);
    
    ((JTextField)this.jDateChooser1.getDateEditor()).setEditable(false);
       
        
        oculto.setVisible(false);
         JButton cal = jDateChooser1.getCalendarButton();
        cal.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                
                i=0;
            
                super.mouseEntered(e); //To change body of generated methods, choose Tools | Templates.
            }
});
        
        final JTextField ff =  (JTextField) jDateChooser1.getDateEditor();
        
        ff.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                
                i=0;
             
                super.mouseEntered(e); //To change body of generated methods, choose Tools | Templates.
            }
            
            
});
        
        
        ff.addPropertyChangeListener(new PropertyChangeListener() {

            
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                i++;
                
                if(i == 1){
                    
                
                 try {
            
        
        DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
         
       LocalDate F = LocalDate.parse(ff.getText().substring(0,10),date);
       
                    
       
        LocalDate FA = LocalDate.now();
        
        Period periodo = Period.between(F, FA);
        
        String result = (periodo.getYears() + " años");
        int compare = (periodo.getYears());
            if (compare<16) {
            
                JOptionPane.showMessageDialog(null, "El empleado debe ser mayor de 16");
                
                edadob.setText(null);
               
                
            }else{
               edadob.setText(result);  
            }
        
         
        
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
             
                }
//               throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        this.url.setVisible(false);
       Sentencias_Angel s = new Sentencias_Angel();      
        txareDirect.setLineWrap(true);
        
        
//        DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate FN = LocalDate.parse(calendarNac.getText(), date);
//        LocalDate FA = LocalDate.now();
//        
//        Period periodo = Period.between(FN, FA);
//        String result = (periodo.getYears() + " años");
//        edadob.setText(result);
      
        this.setLocationRelativeTo(this);    
        
    }
    
  
//     public void insetarFecha(){
//       String sql = "INSERT INTO EMPLEADOS("
//            +"Fecha_Nacimiento_E)"
//            +"VALUES(?)";
//         try {
//        
//             PreparedStatement pst = conexion.Conexion.conection.prepareStatement(sql);
//             
//             pst.setString(11, ((JTextField)calendarNac.getDateEditor().getUiComponent()).getText());
//             
//             pst.execute();
//             
//             JOptionPane.showConfirmDialog(null, "Fecha agregada");
//         } catch (Exception e) {
//             
//             JOptionPane.showConfirmDialog(null, "Error" + e.getMessage());
//         }
//     }
//    private void Fechas(){
//    int ano = calendarNac.getCalendar().get(Calendar.YEAR);
//    int mes = calendarNac.getCalendar().get(Calendar.MONTH)+1;
//    int dia = calendarNac.getCalendar().get(Calendar.DAY_OF_MONTH);
//    
//}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        oculto = new javax.swing.JTextField();
        btnTomarFoto = new javax.swing.JButton();
        cargarFoto = new javax.swing.JLabel();
        comboTipoCarg = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        buscar = new javax.swing.JButton();
        calendarInic = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtApell = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        combGen = new javax.swing.JComboBox<String>();
        jLabel6 = new javax.swing.JLabel();
        txtRef = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        combEstado = new javax.swing.JComboBox<String>();
        jLabel14 = new javax.swing.JLabel();
        comTipCont = new javax.swing.JComboBox<String>();
        jLabel15 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        labelID = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        comboCargo = new javax.swing.JComboBox<String>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txareDirect = new javax.swing.JTextArea();
        jLabel18 = new javax.swing.JLabel();
        labefechReg = new javax.swing.JLabel();
        CheckUsuario = new javax.swing.JCheckBox();
        txtTele = new javax.swing.JFormattedTextField();
        edadob = new javax.swing.JLabel();
        txtTelRef = new javax.swing.JFormattedTextField();
        txtIden = new javax.swing.JFormattedTextField();
        jLabel20 = new javax.swing.JLabel();
        url = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setForeground(new java.awt.Color(51, 0, 51));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jDateChooser1.setDateFormatString("yyy-MM-dd");
        panel.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, 330, -1));

        oculto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ocultoActionPerformed(evt);
            }
        });
        panel.add(oculto, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, 60, -1));

        btnTomarFoto.setText("TOMAR FOTO");
        btnTomarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTomarFotoActionPerformed(evt);
            }
        });
        panel.add(btnTomarFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 110, 110, -1));

        cargarFoto.setBackground(new java.awt.Color(255, 255, 255));
        cargarFoto.setForeground(new java.awt.Color(255, 255, 255));
        cargarFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cargarFotoMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cargarFotoMouseReleased(evt);
            }
        });
        panel.add(cargarFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 160, 90, 100));

        comboTipoCarg.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrativo", "Tecnico", "Operativo", "Servicios" }));
        comboTipoCarg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoCargActionPerformed(evt);
            }
        });
        panel.add(comboTipoCarg, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 120, 150, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Tipo de Cargo");
        panel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 120, -1, -1));

        buscar.setText("BUSCAR FOTO");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        panel.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 80, -1, -1));

        calendarInic.setDateFormatString("yyy-MM-dd");
        panel.add(calendarInic, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 416, 330, -1));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel5.setText("ACTUALIZAR  EMPLEADOS");
        panel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 440, 33));

        lblId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblId.setText("Id");
        panel.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 55, 76, 14));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Apellidos:");
        panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 119, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("No Identidad");
        panel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 197, -1, -1));

        txtApell.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtApellKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellKeyTyped(evt);
            }
        });
        panel.add(txtApell, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 119, 330, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Teléfono");
        panel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 159, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Género");
        panel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 80, -1, -1));

        combGen.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "F", "M" }));
        combGen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combGenActionPerformed(evt);
            }
        });
        panel.add(combGen, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 80, 150, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Referencias");
        panel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 239, -1, -1));

        txtRef.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRefKeyTyped(evt);
            }
        });
        panel.add(txtRef, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 239, 330, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Teléfono Referencia");
        panel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 280, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Edad");
        panel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 315, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Fecha de Nacimiento");
        panel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 352, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Fecha de Registro");
        panel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Fecha de Inicio Operaciones");
        panel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 419, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Estado");
        panel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 200, -1, -1));

        combEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ACTIVO", "INACTIVO" }));
        panel.add(combEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 200, 150, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Tipo de Contrato");
        panel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 240, -1, -1));

        comTipCont.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Permanente", "Temporal" }));
        panel.add(comTipCont, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 240, 150, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Direccion");
        panel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 280, -1, -1));

        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        panel.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 410, 139, 36));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Nombre");
        panel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 78, -1, -1));

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        panel.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 78, 330, -1));

        labelID.setText("1");
        panel.add(labelID, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 57, 330, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Cargo del Empleado");
        panel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 160, -1, -1));

        comboCargo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboCargoMouseClicked(evt);
            }
        });
        comboCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCargoActionPerformed(evt);
            }
        });
        panel.add(comboCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 160, 150, -1));

        txareDirect.setColumns(20);
        txareDirect.setRows(5);
        txareDirect.setNextFocusableComponent(CheckUsuario);
        txareDirect.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txareDirectKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txareDirectKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txareDirect);

        panel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 280, 286, -1));

        jLabel18.setEnabled(false);
        panel.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(595, 483, 330, -1));

        labefechReg.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        panel.add(labefechReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 380, 330, 17));

        CheckUsuario.setText("Usuario");
        panel.add(CheckUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 380, -1, -1));

        try {
            txtTele.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        panel.add(txtTele, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 159, 330, -1));
        panel.add(edadob, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 317, 330, 17));

        try {
            txtTelRef.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        panel.add(txtTelRef, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 277, 330, -1));

        try {
            txtIden.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####-#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        panel.add(txtIden, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 197, 330, -1));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo2.jpg"))); // NOI18N
        panel.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 500));
        panel.add(url, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 20, 150, -1));

        getContentPane().add(panel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void combGenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combGenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combGenActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
 //       FileImputStream foto;
        if(txtNombre.getText().length()==0 || 
                this.txtApell.getText().length()==0 ||
                this.txtTele.getText().equals("    -    ") ||
                this.txtIden.getText().equals("    -    -     ") ||
                this.txtRef.getText().length()==0 ||
                this.txtTelRef.equals("    -    ") ||
                this.calendarInic.getDate()==null ||
 //               this.calendarNac.getDate().equals(0) ||
   //             this.calendarInic.getDate().equals(0) ||
                this.txareDirect.getText().length()==0){
                JOptionPane.showMessageDialog(this, "Debe Ingresar Todos Los Datos", "Datos Incompletos", JOptionPane.ERROR_MESSAGE);
        
        }else if (oculto.getText().length()==0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un cargo");
        } else{
        
     
            Sentencias_Angel s = new Sentencias_Angel();
            s.setId_E(Integer.parseInt(this.labelID.getText()));
            s.setNombres_E(this.txtNombre.getText());
            s.setApellidos_E(this.txtApell.getText());
            s.setIdentidad_E(this.txtIden.getText());
            s.setTelefono_E(this.txtTele.getText());
            s.setDirecion_E(this.txareDirect.getText());
            s.setGenero_E(this.combGen.getSelectedItem().toString());
            s.setTipo_Contrato_E(this.comTipCont.getSelectedItem().toString());
            s.setEstado_E(this.combEstado.getSelectedItem().toString());
            s.setReferencia_E(this.txtRef.getText());
            s.setTelefono_Referencia_E(this.txtTelRef.getText());
            s.setFecha_Nac_E(((JTextField)this.jDateChooser1.getDateEditor().getUiComponent()).getText());
//            s.setFecha_Nac_E(((JTextField)this.calendarNac.getDateEditor().getUiComponent()).getText());
            s.setFecha_Reg_E(this.labefechReg.getText());
//            s.setFecha_Inicio_E(this.calendarInic.getText());
            s.setFecha_Inicio_E(((JTextField)this.calendarInic.getDateEditor().getUiComponent()).getText());
  //          foto = new FileImputStream(labelfoto.getText());
  //         s.setFoto_E(foto);
            s.setFK_Id_ca(Integer.parseInt(this.oculto.getText()));
           s.setFoto(this.url.getText()); 
           s.setTipo_Cargo(this.comboTipoCarg.getSelectedItem().toString());
           if(CheckUsuario.isSelected()){
                    CREAR_USUARIOS u = new CREAR_USUARIOS();
                    s.setUsu("1");
           
                }else{
                  s.setUsu("0");
              }

           
            if(Funciones_Angel.isUpdate_EM(s)){
               // Funciones.setListar("");
            JOptionPane.showMessageDialog(this, "Actualizacion Correcta");
              if(CheckUsuario.isSelected()){
                    CREAR_USUARIOS u = new CREAR_USUARIOS();
                    //u.oculto.setText(labelID.getText());
                    u.NombreLab.setText(txtNombre.getText());
                   
                   // u.oculto.setText(Funciones_Angel.extraerIdMaxEM());
                    u.oculto.setText(labelID.getText());
                    u.setVisible(true);
           
                }
            Funciones_Angel.setListar_EM("");
            dispose();
            }else{
                JOptionPane.showMessageDialog(this, "Fallo el Registro");
                
            }
          
        }     
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void comboCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCargoActionPerformed
String tipoCargo = (String) comboTipoCarg.getSelectedItem();
        try {
             if(this.contador>0){
                 Connection con=DriverManager.getConnection("jdbc:sqlserver://192.168.0.11:1433;databaseName=PROYECTO_MP", "Irvingx", "Iopteamop12");
             Statement sent = con.createStatement();
                 
            ResultSet rs = sent.executeQuery("select * from CARGOS where Nombre_ca = '"+this.comboCargo.getSelectedItem() 
                    +"' AND Tipo_ca = '"+ tipoCargo +"' ");
            rs.next();
                
               this.oculto.setText(String.valueOf(rs.getInt("Id_ca")));
              
               
            
             }
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_comboCargoActionPerformed

    private void ocultoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ocultoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_ocultoActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
       //txtNombre.setText(txtNombre.getText().trim());
        
        int tam = txtNombre.getText().length();
        if(tam>=30){
            evt.consume();
        }
        
        txtNombre.setText(txtNombre.getText().replaceAll("( )+", " "));
        if (txtNombre.getText().length()==0 && evt.getKeyChar()==KeyEvent.VK_SPACE) {
            evt.consume();          
        }
        
       txtNombre.setText(txtNombre.getText().replaceAll("( )+", " "));
      // txtApell.getText().replaceAll(null, null);
//        String xd = txtNombre.getText();
//        xd = xd.trim().replaceAll(" +", " ");
         char l = evt.getKeyChar();
         
        if(Character.isDigit(l)){
            getToolkit().beep();
            evt.consume();
        }
        else if((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47
                ||(int)evt.getKeyChar()>=58 && (int)evt.getKeyChar()<=64
                ||(int)evt.getKeyChar()>=91 && (int)evt.getKeyChar()<=96
                ||(int)evt.getKeyChar()>=123 && (int)evt.getKeyChar()<=163
                ||(int)evt.getKeyChar()>=166 && (int)evt.getKeyChar()<=255){
             getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApellKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellKeyTyped

        txtApell.setText(txtApell.getText().replaceAll("( )+", " "));
        if (txtApell.getText().length()==0 && evt.getKeyChar()==KeyEvent.VK_SPACE) {
            evt.consume();          
        }
        
        int tam = txtApell.getText().length();
        if(tam>=30){
            evt.consume();
        } 
        char l = evt.getKeyChar();
     
         
        if(Character.isDigit(l)){
            getToolkit().beep();
            evt.consume();
        }
        else if((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47
                ||(int)evt.getKeyChar()>=58 && (int)evt.getKeyChar()<=64
                ||(int)evt.getKeyChar()>=91 && (int)evt.getKeyChar()<=96
                ||(int)evt.getKeyChar()>=123 && (int)evt.getKeyChar()<=163
                ||(int)evt.getKeyChar()>=166 && (int)evt.getKeyChar()<=255){
             getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtApellKeyTyped

    private void txtRefKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRefKeyTyped
        // TODO add your handling code here:
        int tam = txtRef.getText().length();
        if(tam>=30){
            evt.consume();
        }
        
        txtRef.setText(txtRef.getText().replaceAll("( )+", " "));
        if (txtRef.getText().length()==0 && evt.getKeyChar()==KeyEvent.VK_SPACE) {
            evt.consume();          
        }
        
         char l = evt.getKeyChar();
         
        if(Character.isDigit(l)){
            getToolkit().beep();
            evt.consume();
        }
        else if((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47
                ||(int)evt.getKeyChar()>=58 && (int)evt.getKeyChar()<=64
                ||(int)evt.getKeyChar()>=91 && (int)evt.getKeyChar()<=96
                ||(int)evt.getKeyChar()>=123 && (int)evt.getKeyChar()<=163
                ||(int)evt.getKeyChar()>=166 && (int)evt.getKeyChar()<=255){
             getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtRefKeyTyped

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        // TODO add your handling code here:
        int resultado;

        equipo Buscador = new equipo();

        FileNameExtensionFilter file = new FileNameExtensionFilter("JPG, PNG& GIF", "jpg", "png", "gif");
        Buscador.JFCBuscarImg.setFileFilter(file);
        resultado = Buscador.JFCBuscarImg.showOpenDialog(null);

        if(JFileChooser.APPROVE_OPTION == resultado){
            File archivo = Buscador.JFCBuscarImg.getSelectedFile();
            url.setText(archivo.getAbsolutePath());

            try {
                ImageIcon ImgIcon = new ImageIcon(archivo.toString());
                Icon icono = new ImageIcon(ImgIcon.getImage().getScaledInstance(cargarFoto.getWidth(), cargarFoto.getHeight(), Image.SCALE_DEFAULT));
                cargarFoto.setIcon(icono);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al abrir");
            }
        }

    }//GEN-LAST:event_buscarActionPerformed

    private void cargarFotoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cargarFotoMouseReleased
        // TODO add your handling code here:
      
        
    }//GEN-LAST:event_cargarFotoMouseReleased

    private void cargarFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cargarFotoMouseClicked

     
    }//GEN-LAST:event_cargarFotoMouseClicked

    private void comboTipoCargActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoCargActionPerformed
 String tipoCargo = (String) comboTipoCarg.getSelectedItem();
        try {
            try {
                Connection con=DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=PROYECTO_MP", "sa", "123");
             Statement sent = con.createStatement();
             ResultSet rs = sent.executeQuery("Select * from CARGOS where Tipo_ca = '" +tipoCargo+ "' ");
             this.comboCargo.removeAllItems();
             while(rs.next()){
                 
                 this.comboCargo.addItem(rs.getString("Nombre_ca"));
             
               
                
             }
             contador++;
                
            } catch (Exception e) {
                Connection con=DriverManager.getConnection("jdbc:sqlserver://192.168.0.11:1433;databaseName=PROYECTO_MP", "Irvingx", "Iopteamop12");
             Statement sent = con.createStatement();
             ResultSet rs = sent.executeQuery("Select * from CARGOS where Tipo_ca = '" +tipoCargo+ "' ");
             this.comboCargo.removeAllItems();
             while(rs.next()){
                 
                 this.comboCargo.addItem(rs.getString("Nombre_ca"));
             
               
                
             }
             contador++;
            }
             
             
        } catch (Exception ex) {
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        
        
                String tipoCargos = (String) comboTipoCarg.getSelectedItem();
        try {
            try {
                Connection con=DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=PROYECTO_MP", "sa", "123");
             Statement sent = con.createStatement();
             ResultSet rse = sent.executeQuery("Select * from CARGOS where Tipo_ca = '" +tipoCargos+ "' ");
           //  this.comboCargo.removeAllItems();
             if (rse.next()) {
                 oculto.setText(String.valueOf(rse.getInt("Id_ca")));
                
            }
             
             //oculto.setText("");
             contador++;
                
            } catch (Exception e) {
                Connection con=DriverManager.getConnection("jdbc:sqlserver://192.168.0.11:1433;databaseName=PROYECTO_MP", "Irvingx", "Iopteamop12");
             Statement sent = con.createStatement();
             ResultSet rse = sent.executeQuery("Select * from CARGOS where Tipo_ca = '" +tipoCargos+ "' ");
           //  this.comboCargo.removeAllItems();
             if (rse.next()) {
                 oculto.setText(String.valueOf(rse.getInt("Id_ca")));
                
            }
             
             //oculto.setText("");
             contador++;
            }
             
        } catch (Exception ex) {
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }//GEN-LAST:event_comboTipoCargActionPerformed

    private void comboCargoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboCargoMouseClicked
        // TODO add your handling code here:
         
    }//GEN-LAST:event_comboCargoMouseClicked

    private void btnTomarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTomarFotoActionPerformed
        // TODO add your handling code here:
        FOTOS_ACTUAL w = new FOTOS_ACTUAL();
       w.setVisible(true);
    }//GEN-LAST:event_btnTomarFotoActionPerformed

    private void txtApellKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellKeyReleased
     
    }//GEN-LAST:event_txtApellKeyReleased

    private void txareDirectKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txareDirectKeyTyped
        txareDirect.setText(txareDirect.getText().replaceAll("( )+", " "));
        
            int tam = txareDirect.getText().length();
        if(tam>=300){
            evt.consume();
        }  
    }//GEN-LAST:event_txareDirectKeyTyped

    private void txareDirectKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txareDirectKeyPressed
        // TODO add your handling code here:
         if (evt.getKeyCode() == KeyEvent.VK_TAB) {
                    if (evt.getModifiers() > 0) {
                        txareDirect.transferFocusBackward();
                    } else {
                        txareDirect.transferFocus();
                    }
                    evt.consume();
                }

    }//GEN-LAST:event_txareDirectKeyPressed

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
            java.util.logging.Logger.getLogger(EMPLEADOSS_Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EMPLEADOSS_Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EMPLEADOSS_Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EMPLEADOSS_Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new EMPLEADOSS_Update().setVisible(true);
                    
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(EMPLEADOSS_Update.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JCheckBox CheckUsuario;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnTomarFoto;
    private javax.swing.JButton buscar;
    public static com.toedter.calendar.JDateChooser calendarInic;
    public static javax.swing.JLabel cargarFoto;
    public static javax.swing.JComboBox<String> comTipCont;
    public static javax.swing.JComboBox<String> combEstado;
    public static javax.swing.JComboBox<String> combGen;
    public static javax.swing.JComboBox<String> comboCargo;
    public static javax.swing.JComboBox comboTipoCarg;
    private javax.swing.JLabel edadob;
    public static com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel labefechReg;
    public static javax.swing.JLabel labelID;
    private javax.swing.JLabel lblId;
    public static javax.swing.JTextField oculto;
    private javax.swing.JPanel panel;
    public static javax.swing.JTextArea txareDirect;
    public static javax.swing.JTextField txtApell;
    public static javax.swing.JFormattedTextField txtIden;
    public static javax.swing.JTextField txtNombre;
    public static javax.swing.JTextField txtRef;
    public static javax.swing.JFormattedTextField txtTelRef;
    public static javax.swing.JFormattedTextField txtTele;
    public static javax.swing.JTextField url;
    // End of variables declaration//GEN-END:variables
}
