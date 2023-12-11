/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectomp;

/**
 *
 * @author espin
 */
public class Sentencias_Henry {
    
    
    //Listar productos del inventario
    public static String LISTAR_INVENTARIOS = "SELECT * FROM INVENTARIO";
        //PROVEEDORES
    public static String LISTAR_PROVEEDORES = "SELECT * FROM PROVEEDOR";
    public static String REGISTRAR_PROVEEDOR = "INSERT INTO PROVEEDOR("
            +"Id_Pro,"+"Nombre_Pro,"+"Direccion_Pro,"+"Telefono_Pro,"+"EMail_Pro,"+"RTN_Pro,"+"Tipo_Pro,"+"Contacto_Pro,"+"Cel_Contacto_Pro)"
            +"VALUES(?,?,?,?,?,?,?,?,?)";
          
       public static String UPDATE_PROVEEDOR = "UPDATE PROVEEDOR SET "
           +"Nombre_Pro= ?,"
           +"Direccion_Pro=?,"
           +"Telefono_Pro=?, "
           +"EMail_Pro=?, "
           +"RTN_Pro=?, "
           +"Tipo_Pro=?, "
           +"Contacto_Pro=?, "
           +"Cel_Contacto_Pro=? "
           +"WHERE Id_Pro=?";
       

       public static String ELIMINAR_PROVEEDOR = "DELETE FROM PROVEEDOR WHERE Id_Pro=?";
           
       
       private int Id_Pro;
       private String Nombre_Pro;
       private String Direccion_Pro;
       private String Telefono_Pro;
       private String EMail_Pro;
       private String RTN_Pro;
       private String Tipo_Pro;
       private String Contacto_Pro;
       private String Cel_Contacto_Pro;



    public int getId_Pro() {
        return Id_Pro;
    }

    public void setId_Pro(int Id_Pro) {
        this.Id_Pro = Id_Pro;
    }

    public String getNombre_Pro() {
        return Nombre_Pro;
    }

    public void setNombre_Pro(String Nombre_Pro) {
        this.Nombre_Pro = Nombre_Pro;
    }

    public String getDireccion_Pro() {
        return Direccion_Pro;
    }

    public void setDireccion_Pro(String Direccion_Pro) {
        this.Direccion_Pro = Direccion_Pro;
    }

    public String getTelefono_Pro() {
        return Telefono_Pro;
    }

    public void setTelefono_Pro(String Telefono_Pro) {
        this.Telefono_Pro = Telefono_Pro;
    }
    
     public String getEMail_Pro() {
        return EMail_Pro;
    }

    public void setEMail_Pro(String EMail_Pro) {
        this.EMail_Pro = EMail_Pro;
    }
    
    
    public String getRTN_Pro() {
        return RTN_Pro;
    }

    public void setRTN_Pro(String RTN_Pro) {
        this.RTN_Pro = RTN_Pro;
    } 
    
    public String getTipo_Pro() {
        return Tipo_Pro;
    }

    public void setTipo_Pro(String Tipo_Pro) {
        this.Tipo_Pro = Tipo_Pro;
    } 
    
    public String getContacto_Pro() {
        return Contacto_Pro;
    }

    public void setContacto_Pro(String Contacto_Pro) {
        this.Contacto_Pro = Contacto_Pro;
    } 
    
     public String getCel_Contacto_Pro() {
        return Cel_Contacto_Pro;
    }

    public void setCel_Contacto_Pro(String Cel_Contacto_Pro) {
        this.Cel_Contacto_Pro = Cel_Contacto_Pro;
    } 
    
    
    //Compras
    public static String LISTAR_COMPRAS = "SELECT Id_CM, Fecha_CM, Fecha_Regis_CM, No_Factura_CM, Nombre_Pro, PROVEEDOR.Id_Pro, Telefono_Pro, EMail_Pro, RTN_Pro  from COMPRA_MATERIA_PRIMA INNER JOIN PROVEEDOR ON PROVEEDOR.Id_Pro = COMPRA_MATERIA_PRIMA.Id_Pro";
    public static String REGISTRAR_COMPRA = "INSERT INTO COMPRA_MATERIA_PRIMA("
            +"Id_CM,"+"Fecha_CM,"+"Fecha_Regis_CM,"+"No_Factura_CM,"+"Id_Pro)"
            +"VALUES(?,?,?,?,?)";
    public static String BORRAR_COMPRA = "DELETE FROM COMPRA_MATERIA_PRIMA WHERE Id_CM=?";
    public static String BORRAR_DETALLE_COMPRA = "DELETE FROM DETALLE_COMPRA WHERE FK_Id_CM=?";
             

       
       private int Id_CM;
       private String Fecha_CM;
       private String Fecha_Regis_CM;
       private String No_Factura_CM;
       private int FK_Id_Pro;




    public int getId_CM() {
        return Id_CM;
    }

    public void setId_CM(int Id_CM) {
        this.Id_CM = Id_CM;
    }

    public String getFecha_CM() {
        return Fecha_CM;
    }

    public void setFecha_CM(String Fecha_CM) {
        this.Fecha_CM = Fecha_CM;
    }

    public String getFecha_Regis_CM() {
        return Fecha_Regis_CM;
    }

    public void setFecha_Regis_CM(String Fecha_Regis_CM) {
        this.Fecha_Regis_CM = Fecha_Regis_CM;
    }

    public String getNo_Factura_CM() {
        return No_Factura_CM;
    }

    public void setNo_Factura_CM(String No_Factura_CM) {
        this.No_Factura_CM = No_Factura_CM;
    }
    
     public int getFK_Id_Pro() {
        return FK_Id_Pro;
    }

    public void setFK_Id_Pro(int FK_Id_Pro) {
        this.FK_Id_Pro = FK_Id_Pro;
    }
    
    //Detalle compra
    private int Id_Compra;
     public static String BUSCAR_DETALLES = "SELECT Id_DE, FK_Id_Imp, Cantidad_DE, Precio_DE, Total_DE from DETALLE_COMPRA INNER JOIN COMPRA_MATERIA_PRIMA ON COMPRA_MATERIA_PRIMA.Id_CM = ?";
   
     public int getId_Compra() {
        return Id_Compra;
    }

    public void setId_Compra(int Id_Compra) {
        this.Id_Compra = Id_Compra;
    }
     
     
    public static String REGISTRAR_DETALLE_COMPRA = "INSERT INTO DETALLE_COMPRA("
            +"Id_DE,"+"Cantidad_DE,"+"Precio_DE,"+"Total_DE,"+"FK_Id_CM,"+"FK_Id_IMP)"
            +"VALUES(?,?,?,?,?,?)";
             

       
       private int Id_DE;
       private double Cantidad_DE;
       private double  Precio_DE;
       private double Total_DE;
       private int FK_Id_CM;
       private int FK_Id_IMP;




    public int getId_DE() {
        return Id_DE;
    }

    public void setId_DE(int Id_DE) {
        this.Id_DE = Id_DE;
    }

    public double getCantidad_DE() {
        return Cantidad_DE;
    }

    public void setCantidad_DE(double Cantidad_DE) {
        this.Cantidad_DE = Cantidad_DE;
    }
    
    public double getPrecio_DE() {
        return Precio_DE;
    }

    public void setPrecio_DE(double Precio_DE) {
        this.Precio_DE = Precio_DE;
    }
    
    public double getTotal_DE() {
        return Total_DE;
    }

    public void setTotal_DE(double Total_DE) {
        this.Total_DE = Total_DE;
    }

     public int getFK_Id_CM() {
        return FK_Id_CM;
    }

    public void setFK_Id_CM(int FK_Id_CM) {
        this.FK_Id_CM = FK_Id_CM;
    }
    
    public int getFK_Id_IMP() {
        return FK_Id_IMP;
    }

    public void setFK_Id_IMP(int FK_Id_IMP) {
        this.FK_Id_IMP = FK_Id_IMP;
    }
    
     //Agregar las compras al inventario
    
    private int Id_IMP;
    private double Existencia_IMP;
    private int Cantidad_IMP;
    
    
    public static String BUSCAR_EXISTENCIA = "SELECT Existencia_IMP FROM INVENTARIO WHERE Id_IMP = ?";
    
    
    public static String UPDATE_Inventario = "UPDATE INVENTARIO SET "
           +"Existencia_IMP=? "
           +"WHERE Id_IMP=?";

    public double getExistencia_IMP() {
        return Existencia_IMP;
    }

    public void setExistencia_IMP(double Existencia_IMP) {
        this.Existencia_IMP = Existencia_IMP;
    }
    
    
   

    
    public int getCantidad_IMP() {
        return Cantidad_IMP;
    }

    public void setCantidad_IMP(int Cantidad_IMP) {
        this.Cantidad_IMP = Cantidad_IMP;
    }
    
    public int getId_IMP() {
        return Id_IMP;
    }

    public void setId_IMP(int Id_IMP) {
        this.Id_IMP = Id_IMP;
    }
    
    public static String Obtener_Existencia = "select Existencia_IMP from INVENTARIO where Id_IMP=?";
    
}