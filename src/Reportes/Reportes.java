/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.commons.collections.map.HashedMap;

/**
 *
 * @author espin
 */
public class Reportes {
    
    private static conexion.Conexion con = new Conexion();
    private static Connection conexion = con.getConexion();
    public void ReportePlanilla(HashMap datos) throws SQLException, JRException{
        Connection a;
        String path = "C:/IDE/src/Reportes/Factura.jasper";
   a=DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=PROYECTO_MP", "sa", "123");
   JasperReport reporte=null;
   reporte=(JasperReport) JRLoader.loadObjectFromFile(path);   
   JasperPrint print=JasperFillManager.fillReport(reporte, datos, conexion);
   JasperViewer ver=new JasperViewer(print, false);
   ver.setTitle("Planilla");
   ver.setVisible(true);
    }
    
    public void ReporteCargos() throws SQLException, JRException{
    Connection a;
    a=DriverManager.getConnection("jdbc:sqlserver://DESKTOP-VRUMJHI;databaseName=PROYECTO_MP", "sa", "1234");
    JasperReport reporte=null;
    reporte=(JasperReport) JRLoader.loadObjectFromFile("C:\\IDE\\src\\Reportes\\Cargo.jasper");
    JasperPrint print=JasperFillManager.fillReport(reporte, null, a);
    JasperViewer ver=new JasperViewer(print, false);
    ver.setTitle("Cargos");
    ver.setVisible(true);
    }
    
    
    public void ReporteVenta(HashMap datos) throws SQLException, JRException{
        Connection a;
        JasperReport reporte=null;
        reporte=(JasperReport) JRLoader.loadObjectFromFile("C:\\IDE\\src\\Reportes\\Factura.jasper");
        a=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1;databaseName=IDE", "sa", "IDE_2023_excellence");
   JasperPrint print=JasperFillManager.fillReport(reporte, datos, a);
//        JasperPrintManager.printReport(print, false);
    JasperViewer ver=new JasperViewer(print, false);
   ver.setTitle("Factura");
   ver.setVisible(true);
   
        /*Connection a = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-VRUMJHI;databaseName=IDE", "sa", "1234");
   JasperReport compilado = JasperCompileManager.compileReport("C:\\IDE\\src\\Reportes\\Factura.jasper");
            JasperPrint relatorio = JasperFillManager.fillReport(compilado, datos, a);

            JFrame tela = new JFrame("Relatório");
            tela.setSize(1000, 500);

            JRViewer painel = new JRViewer(relatorio);
            tela.getContentPane().add(painel);
            tela.setVisible(true);*/
    }
    
    public void FacturaPago(HashMap datos) throws SQLException, JRException{
        Connection a;
   a=DriverManager.getConnection("jdbc:sqlserver://DESKTOP-TBCLTBQ\\IDE;databaseName=IDE", "sa", "1234");
   JasperReport reporte=null;
   reporte=(JasperReport) JRLoader.loadObjectFromFile("C:\\IDE\\src\\Reportes\\Venta.jasper");   
   JasperPrint print=JasperFillManager.fillReport(reporte, datos, a);
        JasperPrintManager.printReport(print, false);
    }    
    
    
       public void ReporteVentas(HashMap datos) throws SQLException, JRException{
        Connection a;
   a=DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=PROYECTO_MP", "sa", "123");
   JasperReport reporte=null;
   reporte=(JasperReport) JRLoader.loadObjectFromFile("C:\\11_MEGAPIZZA\\src\\Reportes\\Venta.jasper");   
   JasperPrint print=JasperFillManager.fillReport(reporte, datos, a);
        //JasperPrintManager.printReport(print, false);
JasperViewer ver=new JasperViewer(print, false);
   ver.setTitle("Venta");
   ver.setVisible(true);
    }
}
