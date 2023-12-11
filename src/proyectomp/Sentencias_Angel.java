/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectomp;

import java.io.InputStream;
import java.util.Date;

/**
 *
 * @author angel
 */
public class Sentencias_Angel {
     public static String LISTAR = "SELECT * FROM CLIENTES";
     public static String LISTARCEL = "SELECT * FROM CLIENTES WHERE Telefono=?";
     private String Telefono_CL_C;

    public String getTelefono_CL_C() {
        return Telefono_CL_C;
    }

    public void setTelefono_CL_C(String Telefono_CL_C) {
        this.Telefono_CL_C = Telefono_CL_C;
    }
     
    public static String REGISTRAR = "INSERT INTO CLIENTES("
            +"Telefono,"+"Nombres,"+"Apellidos,"+"Direccion,"+"RTN,"+"Identidad)"
            +"VALUES(?,?,?,?,?,?)";
//     public static String UPDATE = "UPDATE CARGOS SET("
//            +"Tipo_ca,"+"Nombre_ca,"+"Funciones_ca,"+"Sueldos_ca,"+"WHERE Id_ca)"
//            +"VALUES(?,?,?,?,?)";
    public static String UPDATE = "UPDATE CLIENTES SET "
             +"Nombres =?,"
           +"Apellidos=?,"
           +"Telefono=?,"
           +"RTN=?,"
           +"Direccion=? "
            +"WHERE Telefono=?"; 
   // public static String UPDATE =("UPDATE personal SET Nombre='"+"' , Apellidos= '"+"',Telefono= '"+"', Email= '"+"' WHERE Identificador="+"?");
    
    public static String ELIMINAR = "DELETE FROM CLIENTES WHERE Telefono_CL=?";
    
    
    private String Telefono_CL;
    private String RTN;
    private String Segunda_Direccion;
    private String Nombre_CL;
    private String Apellidos_CL;
    private String Direccion_CL;
    private String Identidad_CL;
    private String Rtn_CL;

    public String getIdentidad_CL() {
        return Identidad_CL;
    }

    public void setIdentidad_CL(String Identidad_CL) {
        this.Identidad_CL = Identidad_CL;
    }

    public String getRtn_CL() {
        return Rtn_CL;
    }

    public void setRtn_CL(String Rtn_CL) {
        this.Rtn_CL = Rtn_CL;
    }
    
    

//    public Sentencias_Angel() {
//        this.Telefono_CL = Telefono_CL;
//        this.Nombre_CL = Nombre_CL;
//        this.Apellidos_CL = Apellidos_CL;
//        this.Direccion_CL = Direccion_CL;
//    }

    public String getRTN() {
        return RTN;
    }

    public void setRTN(String RTN) {
        this.RTN = RTN;
    }

    public String getSegunda_Direccion() {
        return Segunda_Direccion;
    }

    public void setSegunda_Direccion(String Segunda_Direccion) {
        this.Segunda_Direccion = Segunda_Direccion;
    }
    

    public String getTelefono_CL() {
        return Telefono_CL;
    }

    public void setTelefono_CL(String Telefono_CL) {
        this.Telefono_CL = Telefono_CL;
    }

    public String getNombre_CL() {
        return Nombre_CL;
    }

    public void setNombre_CL(String Nombre_CL) {
        this.Nombre_CL = Nombre_CL;
    }

    public String getApellidos_CL() {
        return Apellidos_CL;
    }

    public void setApellidos_CL(String Apellidos_CL) {
        this.Apellidos_CL = Apellidos_CL;
    }

    public String getDireccion_CL() {
        return Direccion_CL;
    }

    public void setDireccion_CL(String Direccion_CL) {
        this.Direccion_CL = Direccion_CL;
    }           
    
    
    
    //sentencias productos
    
      public static String LISTAR_P = "SELECT * FROM PRODUCTOS";
    public static String REGISTRAR_P = "INSERT INTO PRODUCTOS("
            +"Id_P,"+"Nombre_P,"+"Precio_P,"+"Descripcion_P,"+"Tamanio_P,"+"Num_Piezas_P,"+"Existencia_P)"
            +"VALUES(?,?,?,?,?,?,?)";
//     public static String UPDATE = "UPDATE CARGOS SET("
//            +"Tipo_ca,"+"Nombre_ca,"+"Funciones_ca,"+"Sueldos_ca,"+"WHERE Id_ca)"
//            +"VALUES(?,?,?,?,?)";
   public static String UPDATE_P = "UPDATE PRODUCTOS SET "
             +"Nombre_P =?,"
           +"Precio_P=?,"
           +"Descripcion_P=?,"
           +"Tamanio_P=?,"
           +"Num_Piezas_P=? "
            +"WHERE Id_P=?"; 
   // public static String UPDATE =("UPDATE personal SET Nombre='"+"' , Apellidos= '"+"',Telefono= '"+"', Email= '"+"' WHERE Identificador="+"?");
    
    public static String ELIMINAR_P = "DELETE FROM PRODUCTOS WHERE Id_P=?";
    
    private int Id_P;
    private String Nombre_P;
    private double Precio_P;
    private String Descripcion_P;
    private String Tamanio_P;
    private String Num_Piezas_P;
    private int Existencia_P;

    public int getId_P() {
        return Id_P;
    }

    public void setId_P(int Id_P) {
        this.Id_P = Id_P;
    }

    public String getNombre_P() {
        return Nombre_P;
    }

    public void setNombre_P(String Nombre_P) {
        this.Nombre_P = Nombre_P;
    }

    public double getPrecio_P() {
        return Precio_P;
    }

    public void setPrecio_P(double Precio_P) {
        this.Precio_P = Precio_P;
    }

    public String getDescripcion_P() {
        return Descripcion_P;
    }

    public void setDescripcion_P(String Descripcion_P) {
        this.Descripcion_P = Descripcion_P;
    }

    public String getTamanio_P() {
        return Tamanio_P;
    }

    public void setTamanio_P(String Tamanio_P) {
        this.Tamanio_P = Tamanio_P;
    }

    public String getNum_Piezas_P() {
        return Num_Piezas_P;
    }

    public void setNum_Piezas_P(String Num_Piezas_P) {
        this.Num_Piezas_P = Num_Piezas_P;
    }

    public int getExistencia_P() {
        return Existencia_P;
    }

    public void setExistencia_P(int Existencia_P) {
        this.Existencia_P = Existencia_P;
    }
    

   
//    Sentencias_Angel Empleados
    private String usu;

    public String getUsu() {
        return usu;
    }

    public void setUsu(String usu) {
        this.usu = usu;
    }
    
    
      public static String LISTAR_EM = "SELECT * FROM EMPLEADOS INNER JOIN CARGOS "
              + "ON Id_ca = FK_Id_ca";
    public static String REGISTRAR_EM = "INSERT INTO EMPLEADOS("
            +"Nombres_E,"+"Apellidos_E,"+"Identidad_E,"+"Telefono_E,"+"Direccion_E,"+"Genero_E,"+"Tipo_Contrato_E,"+"Estado_E,"+"Referencia_E,"+"Telefono_Referencia_E,"+"Fecha_Nacimiento_E,"+"Fecha_Registro_E,"+"Fecha_Inicio_E,"+"FK_Id_ca,"+"Foto,"+"Tipo_Cargo,"+"usuario)"
            +"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
   public static String UPDATE_EM = "UPDATE EMPLEADOS SET "
           +"Nombres_E=?,"
           +"Apellidos_E=?,"
           +"Identidad_E=?,"
           +"Telefono_E=?,"
           +"Direccion_E=?,"
           +"Genero_E=?,"
           +"Tipo_Contrato_E=?,"
           +"Estado_E=?,"
           +"Referencia_E=?,"
           +"Telefono_Referencia_E=?,"
           +"Fecha_Nacimiento_E=?,"
           +"Fecha_Registro_E=?,"
           +"Fecha_Inicio_E=?,"
           +"FK_Id_ca=?,"
           + "Foto=?,"
           + "Tipo_Cargo=?,"
           + "usuario=? "
            +"WHERE Id_E=?"; 
   // public static String UPDATE =("UPDATE personal SET Nombre='"+"' , Apellidos= '"+"',Telefono= '"+"', Email= '"+"' WHERE Identificador="+"?");
    public static String DistintoTipo ="SELECT DISTINCT Tipo_ca FROM CARGOS";
   
   
   public static String ELIMINAR_EM = "DELETE FROM EMPLEADOS WHERE Id_E=?";
    
    private int Id_E;
    private String Nombres_E;
    private String Apellidos_E;
    private String Identidad_E;
    private String Telefono_E;
    private String Direcion_E;
    private String Genero_E;
    private String Tipo_Contrato_E;
    private String Estado_E;
    private String Referencia_E;
    private String Telefono_Referencia_E;
    private String Fecha_Nac_E;
    private String Fecha_Reg_E;
    private String Fecha_Inicio_E;
//    private String Foto_E;
    private InputStream Foto_E;
    private int FK_Id_ca;
    private String Foto;
    private String Tipo_Cargo;

    public int getId_E() {
        return Id_E;
    }

    public void setId_E(int Id_E) {
        this.Id_E = Id_E;
    }

    public String getNombres_E() {
        return Nombres_E;
    }

    public void setNombres_E(String Nombres_E) {
        this.Nombres_E = Nombres_E;
    }

    public String getApellidos_E() {
        return Apellidos_E;
    }

    public void setApellidos_E(String Apellidos_E) {
        this.Apellidos_E = Apellidos_E;
    }

    public String getIdentidad_E() {
        return Identidad_E;
    }

    public void setIdentidad_E(String Identidad_E) {
        this.Identidad_E = Identidad_E;
    }

    public String getTelefono_E() {
        return Telefono_E;
    }

    public void setTelefono_E(String Telefono_E) {
        this.Telefono_E = Telefono_E;
    }

    public String getDirecion_E() {
        return Direcion_E;
    }

    public void setDirecion_E(String Direcion_E) {
        this.Direcion_E = Direcion_E;
    }

    public String getGenero_E() {
        return Genero_E;
    }

    public void setGenero_E(String Genero_E) {
        this.Genero_E = Genero_E;
    }

    public String getTipo_Contrato_E() {
        return Tipo_Contrato_E;
    }

    public void setTipo_Contrato_E(String Tipo_Contrato_E) {
        this.Tipo_Contrato_E = Tipo_Contrato_E;
    }

    public String getEstado_E() {
        return Estado_E;
    }

    public void setEstado_E(String Estado_E) {
        this.Estado_E = Estado_E;
    }

    public String getReferencia_E() {
        return Referencia_E;
    }

    public void setReferencia_E(String Referencia_E) {
        this.Referencia_E = Referencia_E;
    }

    public String getTelefono_Referencia_E() {
        return Telefono_Referencia_E;
    }

    public void setTelefono_Referencia_E(String Telefono_Referencia_E) {
        this.Telefono_Referencia_E = Telefono_Referencia_E;
    }

    public String getFecha_Nac_E() {
        return Fecha_Nac_E;
    }

    public void setFecha_Nac_E(String Fecha_Nac_E) {
        this.Fecha_Nac_E = Fecha_Nac_E;
    }

    public String getFecha_Reg_E() {
        return Fecha_Reg_E;
    }

    public void setFecha_Reg_E(String Fecha_Reg_E) {
        this.Fecha_Reg_E = Fecha_Reg_E;
    }

    public String getFecha_Inicio_E() {
        return Fecha_Inicio_E;
    }

    public void setFecha_Inicio_E(String Fecha_Inicio_E) {
        this.Fecha_Inicio_E = Fecha_Inicio_E;
    }

    public InputStream getFoto_E() {
        return Foto_E;
    }

    public void setFoto_E(InputStream Foto_E) {
        this.Foto_E = Foto_E;
    }

    public int getFK_Id_ca() {
        return FK_Id_ca;
    }

    public void setFK_Id_ca(int FK_Id_ca) {
        this.FK_Id_ca = FK_Id_ca;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String Foto) {
        this.Foto = Foto;
    }

    public String getTipo_Cargo() {
        return Tipo_Cargo;
    }

    public void setTipo_Cargo(String Tipo_Cargo) {
        this.Tipo_Cargo = Tipo_Cargo;
    }
    
    
    
    public static String LISTARSAR = "SELECT * FROM SAR";
    public static String REGISTRAR_SAR = "INSERT INTO SAR("
            +"Rango_Del,"+"Rango_Al,"+"CAI,"+"Fecha_Lim,"+"Impuesto_Sar,"+"Secuencia_Sar)"
            +"VALUES(?,?,?,?,?,?)";
            
       public static String UPDATE_SAR = "UPDATE SAR SET "
           +"Secuencia_Sar=? "
            +"WHERE Id_Sar=?";
       
              public static String UPDATE_SARR = "UPDATE SAR SET "
           +"Rango_Del= ?,"
           +"Rango_Al=?,"
           +"CAI=?,"
           +"Fecha_Lim=?,"
           +"Impuesto_Sar=?,"
           +"Secuencia_Sar=? "
            +"WHERE Id_Sar=?";
       
       //public static String DELETE_LOCAL = "DELETE FROM LOCAL_MP WHERE Id_L=?";
        public static String ELIMINAR_SAR = "DELETE FROM SAR WHERE Id_Sar=?";
           
       
       private int Id_Sar;
       private double Impuesto_Sar;
       private String Rango_Del;
       private String Rango_Al;
       private String CAI;
       private String Fecha_Lim;
       private String Num_Factura;

    public double getImpuesto_Sar() {
        return Impuesto_Sar;
    }

    public void setImpuesto_Sar(double Impuesto_Sar) {
        this.Impuesto_Sar = Impuesto_Sar;
    }
       
       

    public int getId_Sar() {
        return Id_Sar;
    }

    public void setId_Sar(int Id_Sar) {
        this.Id_Sar = Id_Sar;
    }

    

    public String getRango_Del() {
        return Rango_Del;
    }

    public void setRango_Del(String Rango_Del) {
        this.Rango_Del = Rango_Del;
    }

    public String getRango_Al() {
        return Rango_Al;
    }

    public void setRango_Al(String Rango_Al) {
        this.Rango_Al = Rango_Al;
    }

    public String getCAI() {
        return CAI;
    }

    public void setCAI(String CAI) {
        this.CAI = CAI;
    }

    public String getFecha_Lim() {
        return Fecha_Lim;
    }

    public void setFecha_Lim(String Fecha_Lim) {
        this.Fecha_Lim = Fecha_Lim;
    }

    public String getNum_Factura() {
        return Num_Factura;
    }

    public void setNum_Factura(String Num_Factura) {
        this.Num_Factura = Num_Factura;
    }

    
 public static String LISTARINVE = "SELECT * FROM INVENTARIO";
    public static String REGISTRAR_INVE = "INSERT INTO INVENTARIO("
            +"Marca_IMP,"+"Unidad_Medida_IMP,"+"Nombre_IMP,"+"Existencia_IMP)"
            +"VALUES(?,?,?,?)";
            
       public static String UPDATE_INVE = "UPDATE INVENTARIO SET "
           +"Marca_IMP=?,"
           +"Unidad_Medida_IMP=?,"
           +"Nombre_IMP=?,"
           +"Existencia_IMP=? "
            +"WHERE Id_IMP=?";
       
       //public static String DELETE_LOCAL = "DELETE FROM LOCAL_MP WHERE Id_L=?";
        public static String ELIMINAR_INVE = "DELETE FROM INVENTARIO WHERE Id_IMP=?";
           
       
       private int Id_IMP;
       private String Marca_IMP;
       private String Unidad_Medida_IMP;
       private String Nombre_IMP;
       private int Existencia_IMP;

    public int getId_IMP() {
        return Id_IMP;
    }

    public void setId_IMP(int Id_IMP) {
        this.Id_IMP = Id_IMP;
    }

    public String getMarca_IMP() {
        return Marca_IMP;
    }

    public void setMarca_IMP(String Marca_IMP) {
        this.Marca_IMP = Marca_IMP;
    }

    public String getUnidad_Medida_IMP() {
        return Unidad_Medida_IMP;
    }

    public void setUnidad_Medida_IMP(String Unidad_Medida_IMP) {
        this.Unidad_Medida_IMP = Unidad_Medida_IMP;
    }

    public String getNombre_IMP() {
        return Nombre_IMP;
    }

    public void setNombre_IMP(String Nombre_IMP) {
        this.Nombre_IMP = Nombre_IMP;
    }

    public int getExistencia_IMP() {
        return Existencia_IMP;
    }

    public void setExistencia_IMP(int Existencia_IMP) {
        this.Existencia_IMP = Existencia_IMP;
    }

  








 public static String LISTARING = "SELECT * FROM INGRESOS";
    public static String REGISTRAR_ING = "INSERT INTO INGRESOS("
            +"Nombre_Ing,"+"Monto_Ing,"+"Fecha_Ing,"+"Descripcion_Ing)"
            +"VALUES(?,?,?,?)";
            
       public static String UPDATE_ING = "UPDATE INGRESOS SET "
           +"Nombre_Ing=?,"
           +"Monto_Ing=?,"
           +"Fecha_Ing=?,"
           +"Descripcion_Ing=? "
            +"WHERE Id_Ing=?";
       
       //public static String DELETE_LOCAL = "DELETE FROM LOCAL_MP WHERE Id_L=?";
        public static String ELIMINAR_ING = "DELETE FROM INGRESOS WHERE Id_Ing=?";
           
       
       private int Id_Ing;
       private String Nombre_Ing;
       private Double Monto_Ing;
       private String Fecha_Ing;
       private String Descripcion_Ing;

    public int getId_Ing() {
        return Id_Ing;
    }

    public void setId_Ing(int Id_Ing) {
        this.Id_Ing = Id_Ing;
    }

    public String getNombre_Ing() {
        return Nombre_Ing;
    }

    public void setNombre_Ing(String Nombre_Ing) {
        this.Nombre_Ing = Nombre_Ing;
    }

    public Double getMonto_Ing() {
        return Monto_Ing;
    }

    public void setMonto_Ing(Double Monto_Ing) {
        this.Monto_Ing = Monto_Ing;
    }

    public String getFecha_Ing() {
        return Fecha_Ing;
    }

    public void setFecha_Ing(String Fecha_Ing) {
        this.Fecha_Ing = Fecha_Ing;
    }

    public String getDescripcion_Ing() {
        return Descripcion_Ing;
    }

    public void setDescripcion_Ing(String Descripcion_Ing) {
        this.Descripcion_Ing = Descripcion_Ing;
    }
    
        
    
       
     public static String LISTAREGR = "SELECT * FROM EGRESOS_R";
    public static String REGISTRAR_EGR = "INSERT INTO EGRESOS_R("
            +"Nombre_Egr,"+"Mont_Egr,"+"Fecha_Egr,"+"Descripcion_Egr)"
            +"VALUES(?,?,?,?)";
            
       public static String UPDATE_EGR = "UPDATE EGRESOS_R SET "
           +"Nombre_Egr=?,"
           +"Mont_Egr=?,"
           +"Fecha_Egr=?,"
           +"Descripcion_Egr=? "
            +"WHERE Id_Egr=?";
       
       //public static String DELETE_LOCAL = "DELETE FROM LOCAL_MP WHERE Id_L=?";
        public static String ELIMINAR_EGR = "DELETE FROM EGRESOS_R WHERE Id_Egr=?";
           
       
       private int Id_Egre;
       private String Nombre_Egre;
       private Double Monto_Egre;
       private String Fecha_Egre;
       private String Descripcion_Egre;       

    public int getId_Egre() {
        return Id_Egre;
    }

    public void setId_Egre(int Id_Egre) {
        this.Id_Egre = Id_Egre;
    }

    public String getNombre_Egre() {
        return Nombre_Egre;
    }

    public void setNombre_Egre(String Nombre_Egre) {
        this.Nombre_Egre = Nombre_Egre;
    }

    public Double getMonto_Egre() {
        return Monto_Egre;
    }

    public void setMonto_Egre(Double Monto_Egre) {
        this.Monto_Egre = Monto_Egre;
    }

    public String getFecha_Egre() {
        return Fecha_Egre;
    }

    public void setFecha_Egre(String Fecha_Egre) {
        this.Fecha_Egre = Fecha_Egre;
    }

    public String getDescripcion_Egre() {
        return Descripcion_Egre;
    }

    public void setDescripcion_Egre(String Descripcion_Egre) {
        this.Descripcion_Egre = Descripcion_Egre;
    }
    
       
       
      

public static String LISTAR_USU = "SELECT * FROM USUARIOS";
    public static String REGISTRAR_USU = "INSERT INTO USUARIOS("
            +"Nombre_Usu,"+"Contrasenia_Usu,"+"Id_E,"+"TipoUsuario,"+"Boni_Usu,"+"Cargos_Usu,"+"Cliente_Usu,"+"Compras_Usu,"+"Deducc_Usu,"
            +"Egres_Usu,"+"Empleado_Usu,"+"Horario_Usu,"+"Ingres_Usu,"+"Invent_Usu,"+"Local_Usu,"+"Planilla_Usu,"+"Producto_Usu,"+"Proveedor_Usu,"
            +"Sar_Usu,"+"Ventas_Usu,"+"Usuarios_Usu)"
            +"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//     public static String UPDATE = "UPDATE CARGOS SET("
//            +"Tipo_ca,"+"Nombre_ca,"+"Funciones_ca,"+"Sueldos_ca,"+"WHERE Id_ca)"
//            +"VALUES(?,?,?,?,?)";
   public static String UPDATE_USU = "UPDATE USUARIOS SET "
           +"Nombre_Usu=?,"
           +"Contrasenia_Usu=?,"
           +"Id_E=?,"
           +"TipoUsuario=?,"
           +"Boni_Usu=?,"
           +"Cargos_Usu=?,"
           +"Cliente_Usu=?,"
           +"Compras_Usu=?,"
           +"Deducc_Usu=?,"
           +"Egres_Usu=?,"
           +"Empleado_Usu=?,"
           +"Horario_Usu=?,"
           +"Ingres_Usu=?,"
           +"Invent_Usu=?,"
           +"Local_Usu=?,"
           +"Planilla_Usu=?,"
           +"Producto_Usu=?,"
           +"Proveedor_Usu=?,"
           +"Sar_Usu=?,"
           +"Ventas_Usu=?,"
           +"Usuarios_Usu=? "
            +"WHERE Id_Usu=?";
//   // public static String UPDATE =("UPDATE personal SET Nombre='"+"' , Apellidos= '"+"',Telefono= '"+"', Email= '"+"' WHERE Identificador="+"?");
//    public static String DistintoTipo ="SELECT DISTINCT Tipo_ca FROM CARGOS";
   
   
   public static String ELIMINAR_USU = "DELETE FROM USUARIOS WHERE Id_Usu=?";
    
    private int Id_Usu;
    private String Nombre_Usu;
    private String Contrasenia_Usu;
    private int Id_EE;
    private String TipoUsuario;
    private String Boni_Usu;
    private String Cargos_Usu;
    private String Cliente_Usu;
    private String Compras_Usu;
    private String Deducc_Usu;
    private String Egres_Usu;
    private String Empleado_Usu;
    private String Horario_Usu;
    private String Ingres_Usu;
    private String Invent_Usu;
    private String Local_Usu;
    private String Planilla_Usu;
    private String Producto_Usu;
    private String Proveedor_Usu;
    private String Sar_Usu;
    private String Ventas_Usu;
    private String Usuarios_Usu;

    public int getId_Usu() {
        return Id_Usu;
    }

    public void setId_Usu(int Id_Usu) {
        this.Id_Usu = Id_Usu;
    }

    public String getNombre_Usu() {
        return Nombre_Usu;
    }

    public void setNombre_Usu(String Nombre_Usu) {
        this.Nombre_Usu = Nombre_Usu;
    }

    public String getContrasenia_Usu() {
        return Contrasenia_Usu;
    }

    public void setContrasenia_Usu(String Contrasenia_Usu) {
        this.Contrasenia_Usu = Contrasenia_Usu;
    }

    public int getId_EE() {
        return Id_EE;
    }

    public void setId_EE(int Id_EE) {
        this.Id_EE = Id_EE;
    }

    public String getTipoUsuario() {
        return TipoUsuario;
    }

    public void setTipoUsuario(String TipoUsuario) {
        this.TipoUsuario = TipoUsuario;
    }

    public String getBoni_Usu() {
        return Boni_Usu;
    }

    public void setBoni_Usu(String Boni_Usu) {
        this.Boni_Usu = Boni_Usu;
    }

    public String getCargos_Usu() {
        return Cargos_Usu;
    }

    public void setCargos_Usu(String Cargos_Usu) {
        this.Cargos_Usu = Cargos_Usu;
    }

    public String getCliente_Usu() {
        return Cliente_Usu;
    }

    public void setCliente_Usu(String Cliente_Usu) {
        this.Cliente_Usu = Cliente_Usu;
    }

    public String getCompras_Usu() {
        return Compras_Usu;
    }

    public void setCompras_Usu(String Compras_Usu) {
        this.Compras_Usu = Compras_Usu;
    }

    public String getDeducc_Usu() {
        return Deducc_Usu;
    }

    public void setDeducc_Usu(String Deducc_Usu) {
        this.Deducc_Usu = Deducc_Usu;
    }

    public String getEgres_Usu() {
        return Egres_Usu;
    }

    public void setEgres_Usu(String Egres_Usu) {
        this.Egres_Usu = Egres_Usu;
    }

    public String getEmpleado_Usu() {
        return Empleado_Usu;
    }

    public void setEmpleado_Usu(String Empleado_Usu) {
        this.Empleado_Usu = Empleado_Usu;
    }

    public String getHorario_Usu() {
        return Horario_Usu;
    }

    public void setHorario_Usu(String Horario_Usu) {
        this.Horario_Usu = Horario_Usu;
    }

    public String getIngres_Usu() {
        return Ingres_Usu;
    }

    public void setIngres_Usu(String Ingres_Usu) {
        this.Ingres_Usu = Ingres_Usu;
    }

    public String getInvent_Usu() {
        return Invent_Usu;
    }

    public void setInvent_Usu(String Invent_Usu) {
        this.Invent_Usu = Invent_Usu;
    }

    public String getLocal_Usu() {
        return Local_Usu;
    }

    public void setLocal_Usu(String Local_Usu) {
        this.Local_Usu = Local_Usu;
    }

    public String getPlanilla_Usu() {
        return Planilla_Usu;
    }

    public void setPlanilla_Usu(String Planilla_Usu) {
        this.Planilla_Usu = Planilla_Usu;
    }

    public String getProducto_Usu() {
        return Producto_Usu;
    }

    public void setProducto_Usu(String Producto_Usu) {
        this.Producto_Usu = Producto_Usu;
    }

    public String getProveedor_Usu() {
        return Proveedor_Usu;
    }

    public void setProveedor_Usu(String Proveedor_Usu) {
        this.Proveedor_Usu = Proveedor_Usu;
    }

    public String getSar_Usu() {
        return Sar_Usu;
    }

    public void setSar_Usu(String Sar_Usu) {
        this.Sar_Usu = Sar_Usu;
    }

    public String getVentas_Usu() {
        return Ventas_Usu;
    }

    public void setVentas_Usu(String Ventas_Usu) {
        this.Ventas_Usu = Ventas_Usu;
    }

    public String getUsuarios_Usu() {
        return Usuarios_Usu;
    }

    public void setUsuarios_Usu(String Usuarios_Usu) {
        this.Usuarios_Usu = Usuarios_Usu;
    }
    
    public static String LISTAcargo = "SELECT Nombre_ca, Tipo_ca FROM CARGOS WHERE Id_ca=?";
    
    private  static String nom_ca;

    public static String getNom_ca() {
        return nom_ca;
    }

    public static void setNom_ca(String nom_ca) {
        Sentencias_Angel.nom_ca = nom_ca;
    }

    
    
    
    
    
    public static String VER_PRIVILEGIOS = "Select * from USUARIOS where "; 
}