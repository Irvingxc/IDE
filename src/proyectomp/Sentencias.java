/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectomp;

/**
 *
 * @author Calix
 */
public class Sentencias {
    public static String LISTARUSU = "SELECT Nombre_Usu from USUARIOS where Nombre_Usu=?";
    private String name;
    private String nam1;
     private String env;

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }  

    public String getNam1() {
        return nam1;
    }

    public void setNam1(String nam1) {
        this.nam1 = nam1;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public static String DELETE_boni_Pla = "DELETE BONIFICACION WHERE FK_Pla=? and FK_EMPLEADO=?";
    
    public static String DELETE_DETALLE_PLANAILLA = "DELETE DETALLE_PLANILLA WHERE Id_Detalle_Pla=?";
    public static String DELETE_dedu_Pla = "DELETE EGRESO WHERE FK_Pla=? and FK_Empleado=?";
    
    
    public static String DELETE_dedu_Pla_U = "DELETE EGRESO WHERE FK_Pla=? and FK_Empleado=? and FK_Egreso=?";
    public static String DELETE_boni_Pla_U = "DELETE BONIFICACION WHERE FK_Pla=? and FK_EMPLEADO=? and FK_Boni=?";
    
    //TODO ESTO ES DE CARGOS WE, NO TE CONFUNDAS.
    public static String LISTAR = "SELECT * FROM CARGOS";
    public static String REGISTRAR = "INSERT INTO CARGOS("
            +"Tipo_ca,"+"Nombre_ca,"+"Funciones_ca,"+"Sueldos_ca)"
            +"VALUES(?,?,?,?)";
    
//     public static String REGISTRAR = "{call Insertar_Cargo (?,?,?,?)}";
    
    
//     public static String UPDATE = "UPDATE CARGOS SET("
//            +"Tipo_ca,"+"Nombre_ca,"+"Funciones_ca,"+"Sueldos_ca,"+"WHERE Id_ca)"
//            +"VALUES(?,?,?,?,?)";
   public static String UPDATE = "UPDATE CARGOS SET "
             +"Tipo_ca =?,"
           +"Nombre_ca=?,"
           +"Funciones_ca=?,"
           +"Sueldos_ca=? "
            +"WHERE Id_ca=?"; 
   // public static String UPDATE =("UPDATE personal SET Nombre='"+"' , Apellidos= '"+"',Telefono= '"+"', Email= '"+"' WHERE Identificador="+"?");
    
    public static String ELIMINAR = "DELETE FROM CARGOS WHERE Id_ca=?";
    private int Id_ca;
    private String Tipo_ca;
    private String Nombre_ca;
    private String Funciones_ca;
    private double Sueldos_ca;

    public int getId_ca() {
        return Id_ca;
    }

    public void setId_ca(int Id_ca) {
        this.Id_ca = Id_ca;
    }

    

    public String getTipo_ca() {
        return Tipo_ca;
    }

    public void setTipo_ca(String Tipo_ca) {
        this.Tipo_ca = Tipo_ca;
    }

    public String getNombre_ca() {
        return Nombre_ca;
    }

    public void setNombre_ca(String Nombre_ca) {
        this.Nombre_ca = Nombre_ca;
    }

    public String getFunciones_ca() {
        return Funciones_ca;
    }

    public void setFunciones_ca(String Funciones_ca) {
        this.Funciones_ca = Funciones_ca;
    }

    public double getSueldos_ca() {
        return Sueldos_ca;
    }

    public void setSueldos_ca(double Sueldos_ca) {
        this.Sueldos_ca = Sueldos_ca;
    }
    
    
    
    
    
    
    
    
    
    
    //TODO ESTO ES DE LOCAL
    public static String LISTARLOCAL = "SELECT * FROM LOCAL_MP";
    public static String REGISTRAR_LOCAL = "INSERT INTO LOCAL_MP("
            +"Nombre_L,"+"Direccion_L,"+"RTN_L,"+"Telefono_L,"+"Telefono2_L)"
            +"VALUES(?,?,?,?,?)";
            
       public static String UPDATE_LOCAL = "UPDATE LOCAL_MP SET "
           +"Nombre_L= ?,"
           +"Direccion_L=?,"
           +"RTN_L=?,"
           +"Telefono_L=?,"
           +"Telefono2_L=? "
            +"WHERE Id_L=?";
       
       //public static String DELETE_LOCAL = "DELETE FROM LOCAL_MP WHERE Id_L=?";
        public static String ELIMINAR_LOCAL = "DELETE FROM LOCAL_MP WHERE Id_L=?";
           
       
       private int Id_L;
       private String Nombre_L;
       private String Direccion_L;
       private String RTN_L;
       private String Telefono_L;
       private String Telefono2_L;

    public int getId_L() {
        return Id_L;
    }

    public void setId_L(int Id_L) {
        this.Id_L = Id_L;
    }

    public String getNombre_L() {
        return Nombre_L;
    }

    public void setNombre_L(String Nombre_L) {
        this.Nombre_L = Nombre_L;
    }

    public String getDireccion_L() {
        return Direccion_L;
    }

    public void setDireccion_L(String Direccion_L) {
        this.Direccion_L = Direccion_L;
    }

    public String getTelefono_L() {
        return Telefono_L;
    }

    public void setTelefono_L(String Telefono_L) {
        this.Telefono_L = Telefono_L;
    }

    public String getTelefono2_L() {
        return Telefono2_L;
    }

    public void setTelefono2_L(String Telefono2_L) {
        this.Telefono2_L = Telefono2_L;
    }

    public String getRTN_L() {
        return RTN_L;
    }

    public void setRTN_L(String RTN_L) {
        this.RTN_L = RTN_L;
    }
    
    
    
    
    
    //TODO ESTO ES PARA DETALLE PLANILLA, AHORA SI SE VIENE LO CHIDO

     //TODO ESTO ES DE LOCAL
    public static String LISTAREMP = "{call JOINEMPLEADO}";
    public static String LISTARDETALLE = "select Nombres_E, Apellidos_E, Identidad_E, Nombre_ca from EMPLEADOS INNER JOIN CARGOS ON CARGOS.Id_ca = EMPLEADOS.FK_Id_ca";
    public static String LISTARDETALLEEMP  = "SELECT * FROM LOCAL_MP";
   
    
    public static String REGISTRAR_PLANILLA = "INSERT INTO PLANILLA("
            +"Observaciones_Pla,"+"Tipo_Pla,"+"Periodo_Pla,"+"Fecha_Creacion_Pla,"+"Fecha_Pago_Pla)"
            +"VALUES(?,?,?,?,?)";
    
//    public static String REGISTRAR_Deduccion_Detalle = "INSERT INTO EGRESO("
//            +"Fecha_Egr,"+"FK_Egreso"+"FK_Empleado)"
//            +"VALUES(?,?,?)";
    
    public static String REGISTRAR_DETALLE_PLANILLA = "INSERT INTO DETALLE_PLANILLA("
            +"Total_A_Pagar,"+"FK_Empleado,"+"TotalBoni,"+"TotalDedu,"+"FK_Planilla)"
            +"VALUES(?,?,?,?,?)";
    
           public static String UPDATE_PLANILLA = "UPDATE PLANILLA SET "
           +"Observaciones_Pla= ?,"
           +"Tipo_Pla=?,"
           +"Periodo_Pla=?,"
           +"Fecha_Creacion_Pla=?,"
           +"Fecha_Pago_Pla=? "
            +"WHERE Id_Pla=?";
            
       public static String UPDATE_DETALLEPLANILLA = "UPDATE DETALLE_PLANILLA SET "
           +"Total_A_Pagar= ?,"
           +"TotalBoni=?,"
           +"TotalDedu=? "
            +"WHERE Id_Detalle_Pla=?";
       
       //public static String DELETE_LOCAL = "DELETE FROM LOCAL_MP WHERE Id_L=?";
        public static String DETALLE_PLANAILLA = "DELETE FROM LOCAL_MP WHERE Id_L=?";
           
       private double Total_A_Pagar;
       private double TotalBoni;
       private double TotalDedu;
       private int FK_Planilla;
       private int Id_Pla;
       private String Observaciones_Pla;
       private String Tipo_Pla;
       private String Periodo_Pla;
       private String Fecha_Creacion_Pla;
       private String Fecha_Pago_Pla;
        private int Id_Emp;
        private int Id_Detalle_Pla;

    public double getTotalBoni() {
        return TotalBoni;
    }

    public void setTotalBoni(double TotalBoni) {
        this.TotalBoni = TotalBoni;
    }

    public double getTotalDedu() {
        return TotalDedu;
    }

    public void setTotalDedu(double TotalDedu) {
        this.TotalDedu = TotalDedu;
    }
        
        

    public int getId_Detalle_Pla() {
        return Id_Detalle_Pla;
    }

    public void setId_Detalle_Pla(int Id_Detalle_Pla) {
        this.Id_Detalle_Pla = Id_Detalle_Pla;
    }
        
        

    public double getTotal_A_Pagar() {
        return Total_A_Pagar;
    }

    public void setTotal_A_Pagar(double Total_A_Pagar) {
        this.Total_A_Pagar = Total_A_Pagar;
    }

    public int getFK_Planilla() {
        return FK_Planilla;
    }

    public void setFK_Planilla(int FK_Planilla) {
        this.FK_Planilla = FK_Planilla;
    }
        
        

    public int getId_Pla() {
        return Id_Pla;
    }

    public void setId_Pla(int Id_Pla) {
        this.Id_Pla = Id_Pla;
    }

    public String getObservaciones_Pla() {
        return Observaciones_Pla;
    }

    public void setObservaciones_Pla(String Observaciones_Pla) {
        this.Observaciones_Pla = Observaciones_Pla;
    }

    public String getTipo_Pla() {
        return Tipo_Pla;
    }

    public void setTipo_Pla(String Tipo_Pla) {
        this.Tipo_Pla = Tipo_Pla;
    }

    public String getPeriodo_Pla() {
        return Periodo_Pla;
    }

    public void setPeriodo_Pla(String Periodo_Pla) {
        this.Periodo_Pla = Periodo_Pla;
    }

    public String getFecha_Creacion_Pla() {
        return Fecha_Creacion_Pla;
    }

    public void setFecha_Creacion_Pla(String Fecha_Creacion_Pla) {
        this.Fecha_Creacion_Pla = Fecha_Creacion_Pla;
    }

    public String getFecha_Pago_Pla() {
        return Fecha_Pago_Pla;
    }

    public void setFecha_Pago_Pla(String Fecha_Pago_Pla) {
        this.Fecha_Pago_Pla = Fecha_Pago_Pla;
    }

    public int getId_Emp() {
        return Id_Emp;
    }

    public void setId_Emp(int Id_Emp) {
        this.Id_Emp = Id_Emp;
    }

   
        
        
        
        
        
        
        
        //PARA DEDUCCIONES
        public static String LISTARDEDU  = "SELECT * FROM DEDUCCION";
        public static String REGISTRAR_Deduccion_Detall = "INSERT INTO EGRESO("
            +"Fecha_Egr,"+"FK_Egreso,"+"FK_Empleado,"+"FK_Pla)"
            +"VALUES(?,?,?,?)";
        public static String LISTARBONI  = "SELECT * FROM DETALLE_BONIFICACION";
        
        public static String REGISTRAR_BONIFICACION_Detall = "INSERT INTO BONIFICACION("
            +"FK_Boni,"+"Fecha,"+"FK_EMPLEADO,"+"FK_Pla)"
            +"VALUES(?,?,?,?)";
        
           
           public static String LISTARDEDUEMP = "Select Id_De, Nombre_De, Valor_De "
                + "from EMPLEADOS "
                + "inner join EGRESO "
                + "on Id_E = FK_Empleado "
                + "inner join DEDUCCION "
                + "on Id_De_Egr = FK_Egreso "
                + "where Id_E = ?";
//            public static String REGISTRAR = "{call Insertar_Cargo (?,?,?,?)}";
           
           
           
       private String fecha;  
       private int Id_Egr;
       private int Id_Boni;
       private String Fecha_Egr;
       private int FK_Egreso;
       private int FK_Empleado;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
       
       

    public int getId_Egr() {
        return Id_Egr;
    }

    public void setId_Egr(int Id_Egr) {
        this.Id_Egr = Id_Egr;
    }

    public String getFecha_Egr() {
        return Fecha_Egr;
    }

    public void setFecha_Egr(String Fecha_Egr) {
        this.Fecha_Egr = Fecha_Egr;
    }

    public int getFK_Egreso() {
        return FK_Egreso;
    }

    public void setFK_Egreso(int FK_Egreso) {
        this.FK_Egreso = FK_Egreso;
    }

    public int getFK_Empleado() {
        return FK_Empleado;
    }

    public void setFK_Empleado(int FK_Empleado) {
        this.FK_Empleado = FK_Empleado;
    }

    public int getId_Boni() {
        return Id_Boni;
    }

    public void setId_Boni(int Id_Boni) {
        this.Id_Boni = Id_Boni;
    }
    
    
       //BONIFICACIONES
    public static String LISTAR_BONIFICACIONES = "SELECT * FROM DETALLE_BONIFICACION";
    public static String REGISTRAR_BONIFICACION = "INSERT INTO DETALLE_BONIFICACION("
            +"Nombre_De_Boni,"+"Descripcion_De_Boni)"
            +"VALUES(?,?)";
            
       public static String UPDATE_BONIFICACION = "UPDATE DETALLE_BONIFICACION SET "
           +"Nombre_De_Boni= ?,"
           +"Descripcion_De_Boni=? "
           +"WHERE Id_De_Boni=?";
       

       public static String ELIMINAR_BONIFICACION = "DELETE FROM DETALLE_BONIFICACION WHERE Id_De_Boni=?";
           
       
       private int Id_De_Boni;
       private String Nombre_De_Boni;
       private String Descripcion_De_Boni;
       private double Valor_De_Boni;


    public int getId_De_Boni() {
        return Id_De_Boni;
    }

    public void setId_De_Boni(int Id_De_Boni) {
        this.Id_De_Boni = Id_De_Boni;
    }

    public String getNombre_De_Boni() {
        return Nombre_De_Boni;
    }

    public void setNombre_De_Boni(String Nombre_De_Boni) {
        this.Nombre_De_Boni = Nombre_De_Boni;
    }

    public String getDescripcion_De_Boni() {
        return Descripcion_De_Boni;
    }

    public void setDescripcion_De_Boni(String Descripcion_De_Boni) {
        this.Descripcion_De_Boni = Descripcion_De_Boni;
    }

    public double getValor_De_Boni() {
        return Valor_De_Boni;
    }

    public void setValor_De_Boni(double Valor_De_Boni) {
        this.Valor_De_Boni = Valor_De_Boni;
    }
    
    
    
    
    //DEDUCCIONES
    public static String LISTAR_DEDUCCIONES = "SELECT * FROM DEDUCCION";
    public static String REGISTRAR_DEDUCCION = "INSERT INTO DEDUCCION("
            +"Nombre_De,"+"Descripcion_De)"
            +"VALUES(?,?)";
            
       public static String UPDATE_DEDUCCION = "UPDATE DEDUCCION SET "
           +"Nombre_De= ?,"
           +"Descripcion_De=? "
          // +"Valor_De=? "
           +"WHERE Id_De=?";
       

       public static String ELIMINAR_DEDUCCION = "DELETE FROM DEDUCCION WHERE Id_De=?";
           
       
       private int Id_De;
       private String Nombre_De;
       private String Descripcion_De;
       private double Valor_De;


    public int getId_De() {
        return Id_De;
    }

    public void setId_De(int Id_De) {
        this.Id_De = Id_De;
    }

    public String getNombre_De() {
        return Nombre_De;
    }

    public void setNombre_De(String Nombre_De) {
        this.Nombre_De = Nombre_De;
    }

    public String getDescripcion_De() {
        return Descripcion_De;
    }

    public void setDescripcion_De(String Descripcion_De) {
        this.Descripcion_De = Descripcion_De;
    }

    public double getValor_De() {
        return Valor_De;
    }

    public void setValor_De(double Valor_De) {
        this.Valor_De = Valor_De;
    }


        public static String DELETE_PLANILLA = "DELETE FROM PLANILLA WHERE Id_Pla=?";
        
        
        
        
        
        //PRODUCTOS
        public static String productos = "select * from PRODUCTOS";
        
        public static String alumnos = "select * from Catalogo_Productos ";
        
        //DETALLLE PRODUCTTOS
            public static String REGISTRAR_D_PRO = "INSERT INTO DETALLE_PRODUCTO("
            +"Cantidad_De_Pro,"+"FK_IMP,"+"FK_Pro)"
            +"VALUES(?,?,?)";
            
       public static String UPDATE_D_PRO = "UPDATE DETALLE_PRODUCTO SET "
           +"Cantidad_De_Pro= ?,"
           +"FK_IMP=?,"
           +"FK_Pro=? "
           +"WHERE Id_De_Pro=?";
       public static String DELETE_DETALLEPRODUCTO = "DELETE FROM DETALLE_PRODUCTO WHERE Id_De_Pro=?";
       
       public static String DELETE_DETALLEPRODUCTOsxd = "DELETE FROM DETALLE_PRODUCTO WHERE FK_Pro=?";
       
       int Id_De_Pro;
       Double Cantidad_De_Pro;
       int FK_IMP;
       int FK_Pro;

    public int getId_De_Pro() {
        return Id_De_Pro;
    }

    public void setId_De_Pro(int Id_De_Pro) {
        this.Id_De_Pro = Id_De_Pro;
    }

    public Double getCantidad_De_Pro() {
        return Cantidad_De_Pro;
    }

    public void setCantidad_De_Pro(Double Cantidad_De_Pro) {
        this.Cantidad_De_Pro = Cantidad_De_Pro;
    }

    public int getFK_IMP() {
        return FK_IMP;
    }

    public void setFK_IMP(int FK_IMP) {
        this.FK_IMP = FK_IMP;
    }

    public int getFK_Pro() {
        return FK_Pro;
    }

    public void setFK_Pro(int FK_Pro) {
        this.FK_Pro = FK_Pro;
    }
    
    int Id_IMP;
    double Existencia_IMP;

    public double getExistencia_IMP() {
        return Existencia_IMP;
    }

    public void setExistencia_IMP(double Existencia_IMP) {
        this.Existencia_IMP = Existencia_IMP;
    }
    
    

    public int getId_IMP() {
        return Id_IMP;
    }

    public void setId_IMP(int Id_IMP) {
        this.Id_IMP = Id_IMP;
    }
    
       
       
        
        
        
        
        
        
        //INVENTARIO
        public static String inventario = "select Id_IMP, Unidad_Medida_IMP, Nombre_IMP from INVENTARIO";
        
        
        
        //VENTA DE PIZZAS
        //VENTA DE PIZZAS
        //VENTA DE PIZZAS
        
        
          public static String REGISTRAR_Venta = "INSERT INTO Pagos("
            +"Fecha,"+"Alumno,"+"No_Factura,"+"id_sar,"+"impuestogravado,"+"Total )"
            +"VALUES(?,?,?,?,?,?)";
          

          double Impto_V;
          int sar;
          double impuestogravado;

    public double getImpuestogravado() {
        return impuestogravado;
    }

    public void setImpuestogravado(double impuestogravado) {
        this.impuestogravado = impuestogravado;
    }
          
          

    public int getSar() {
        return sar;
    }

    public void setSar(int sar) {
        this.sar = sar;
    }
          double SubTotal_V;
          double Id_VV;
          String Fecha_VV;
          String No_Factura_VV;
          double Gasto_Materiales_V;

    public double getImpto_V() {
        return Impto_V;
    }

    public void setImpto_V(double Impto_V) {
        this.Impto_V = Impto_V;
    }

    public double getSubTotal_V() {
        return SubTotal_V;
    }

    public void setSubTotal_V(double SubTotal_V) {
        this.SubTotal_V = SubTotal_V;
    }
          
          

    public double getGasto_Materiales_V() {
        return Gasto_Materiales_V;
    }

    public void setGasto_Materiales_V(double Gasto_Materiales_V) {
        this.Gasto_Materiales_V = Gasto_Materiales_V;
    }
          
          

    public double getId_VV() {
        return Id_VV;
    }

    public void setId_VV(double Id_VV) {
        this.Id_VV = Id_VV;
    }

    public String getFecha_VV() {
        return Fecha_VV;
    }

    public void setFecha_VV(String Fecha_VV) {
        this.Fecha_VV = Fecha_VV;
    }

    public String getNo_Factura_VV() {
        return No_Factura_VV;
    }

    public void setNo_Factura_VV(String No_Factura_VV) {
        this.No_Factura_VV = No_Factura_VV;
    }
    
    
    public static String Registrar_deta_pago= "INSERT INTO Detalle_Pagos("
                      +"Precio,"+"id_pago,"+"Mes,"+"id_producto,"+"fechaMensualidad )"
                      +"VALUES(?,?,?,?,?)";
    
    String Alumno_id;
        double Precio;
        int Mensualidades;
        int id_pago;

    public int getId_pago() {
        return id_pago;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public String getAlumno_id() {
        return Alumno_id;
    }

    public void setAlumno_id(String Alumno_id) {
        this.Alumno_id = Alumno_id;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public int getMensualidades() {
        return Mensualidades;
    }

    public void setMensualidades(int Mensualidades) {
        this.Mensualidades = Mensualidades;
    }
        
    
    //detalle Venta
    
              public static String REGISTRAR_Venta_Detalle= "INSERT INTO DETALLE_VENTA("
                      +"Cantidad_V,"+"Id_P,"+"FK_VV)"
                      +"VALUES(?,?,?)";
        int Cantidad_V;
        int Id_V;
        double ISV_V;
        double Sub_Total;
        double Total;
        String Tipo_V;
        String Telefon_CL;
        int Id_P;
        int fk_vv;

    public int getFk_vv() {
        return fk_vv;
    }

    public void setFk_vv(int fk_vv) {
        this.fk_vv = fk_vv;
    }
        
        

    public int getId_V() {
        return Id_V;
    }

    public void setId_V(int Id_V) {
        this.Id_V = Id_V;
    }
        
        

    public int getCantidad_V() {
        return Cantidad_V;
    }

    public void setCantidad_V(int Cantidad_V) {
        this.Cantidad_V = Cantidad_V;
    }

    public double getISV_V() {
        return ISV_V;
    }

    public void setISV_V(double ISV_V) {
        this.ISV_V = ISV_V;
    }

    public double getSub_Total() {
        return Sub_Total;
    }

    public void setSub_Total(double Sub_Total) {
        this.Sub_Total = Sub_Total;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    public String getTipo_V() {
        return Tipo_V;
    }

    public void setTipo_V(String Tipo_V) {
        this.Tipo_V = Tipo_V;
    }

    public String getTelefon_CL() {
        return Telefon_CL;
    }

    public void setTelefon_CL(String Telefon_CL) {
        this.Telefon_CL = Telefon_CL;
    }

    public int getId_P() {
        return Id_P;
    }

    public void setId_P(int Id_P) {
        this.Id_P = Id_P;
    }
    
        private String UsuarioVer;

    public String getUsuarioVer() {
        return UsuarioVer;
    }

    public void setUsuarioVer(String UsuarioVer) {
        this.UsuarioVer = UsuarioVer;
    }


    
    public static String DELETE_Orden = "DELETE FROM ORDEN_PEDIDO WHERE Id_Pedido=?";
    
    int id_orden;

    public int getId_orden() {
        return id_orden;
    }

    public void setId_orden(int id_orden) {
        this.id_orden = id_orden;
    }
    
    
      
 }      
    

