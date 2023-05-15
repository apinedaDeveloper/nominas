package interfaz_usuario.servlets;

import interfaz_usuario.util.JSFUtils;
import interfaz_usuario.util.utils;

import java.io.IOException;

import java.math.BigDecimal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import javax.faces.context.FacesContext;

import javax.servlet.*;
import javax.servlet.http.*;

import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import pkg_util_base_datos.interfaz_DB;


public class verReportePDFd extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=windows-1252";
    private static final String CONTENT_HTML ="text/html; charset=windows-1252";
    private static final String CONTENT_PDF="application/pdf";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request, 
                      HttpServletResponse response) throws ServletException, IOException {response.setContentType(CONTENT_TYPE);
        String vParametro1,vParametro2,vStr_directorioRep,pDefReporte,vParametro3,vParametro4,vParametro5;
        vParametro1=request.getParameter("rep");
        vParametro2=request.getParameter("var1");
        vParametro3=request.getParameter("var2");
        vParametro4=request.getParameter("var3");
        vParametro5=request.getParameter("var4");



        interfaz_DB conexion = new interfaz_DB();
        JasperPrint vReporteListo;
        Map parametrosReporte = new HashMap();
        ServletOutputStream outstream;
        PreparedStatement vStatement=null;
        JRResultSetDataSource vResultSetDataSource=null;
        ResultSet vDatos=null;
        int vNumeroPaginasReporte;
        byte[] pdfasbytes=null;
        BigDecimal vAnioReporte;
        
        vStr_directorioRep=request.getSession().getServletContext().getInitParameter("DIRECTORIO_REPORTES");
        parametrosReporte.put("SUBREPORT_DIR",vStr_directorioRep);
        parametrosReporte.put("REPORT_LOCALE",new java.util.Locale("es","GT"));
        pDefReporte="";
        outstream = response.getOutputStream();
        
        //System.out.println("debug "+vParametro4);
        
        if (vParametro1!=null){
        try {
        
          
            if (vParametro1.equals("PLAZASTESO")){
            
                pDefReporte="RepPlazasTesorero.jasper";
                parametrosReporte.put("pAnio",new Integer(JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.anioActual").toString()));
                
                if (vParametro2.equals("") && vParametro3.equals("") && vParametro4.equals("0")){ //Ningun filtro
                    vStatement = conexion.get_Coneccion().prepareStatement(consultasPDF.getConsultaTeso(-1));
                    vStatement.setString(1,JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.anioActual").toString()); //anio
                    vStatement.setString(2,utils.getUsuario()); //usuario
                    vStatement.setString(3,utils.getUsuario()); //usuario
                }else if (!vParametro2.equals("") && vParametro3.equals("") && vParametro4.equals("0")){
                    vStatement = conexion.get_Coneccion().prepareStatement(consultasPDF.getConsultaTeso(1));
                    vStatement.setString(1,JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.anioActual").toString()); //anio
                    vStatement.setString(2,utils.getUsuario()); //usuario
                    vStatement.setString(3,utils.getUsuario()); //usuario
                    vStatement.setString(4,vParametro2); //partida
                }else if (vParametro2.equals("") && !vParametro3.equals("") && vParametro4.equals("0")){
                    vStatement = conexion.get_Coneccion().prepareStatement(consultasPDF.getConsultaTeso(2));
                    vStatement.setString(1,JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.anioActual").toString()); //anio
                    vStatement.setString(2,utils.getUsuario()); //usuario
                    vStatement.setString(3,utils.getUsuario()); //usuario
                    vStatement.setInt(4,utils.getInteger(vParametro3)); //numero plaza
                }
                else if (!vParametro2.equals("") && !vParametro3.equals("") && vParametro4.equals("0")){
                    vStatement = conexion.get_Coneccion().prepareStatement(consultasPDF.getConsultaTeso(3));
                    vStatement.setString(1,JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.anioActual").toString()); //anio
                    vStatement.setString(2,utils.getUsuario()); //usuario
                    vStatement.setString(3,utils.getUsuario()); //usuario
                    vStatement.setString(4,vParametro2); //partida
                    vStatement.setInt(5,utils.getInteger(vParametro3)); //numero plaza
                    
                }else if (!vParametro4.equals("0")){
                    vStatement = conexion.get_Coneccion().prepareStatement(consultasPDF.getConsultaTeso(4));
                    vStatement.setString(1,JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.anioActual").toString()); //anio
                    vStatement.setString(2,utils.getUsuario()); //usuario
                    vStatement.setString(3,utils.getUsuario()); //usuario      
                    vStatement.setString(4,vParametro4); //id_Dependencia
                }
                             
            }else if (vParametro1.equals("PLAZASTESOAPER")) 
            {
                
                 pDefReporte="RepPlazasTesoreroApertura.jasper";
                 vAnioReporte = new BigDecimal(JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.anioActual").toString());
                 
                 parametrosReporte.put("pAnio",vAnioReporte);
                 
                 if (vParametro2.equals("") && vParametro3.equals("") && vParametro4.equals("0")){ //Ningun filtro
                     vStatement = conexion.get_Coneccion().prepareStatement(consultasPDF.getConsultaTesoAper(-1));
                     vStatement.setInt(1,vAnioReporte.intValue());
                     vStatement.setString(2,utils.getUsuario()); //usuario
                     vStatement.setString(3,utils.getUsuario()); //usuario
                 }else if (!vParametro2.equals("") && vParametro3.equals("") && vParametro4.equals("0")){
                     vStatement = conexion.get_Coneccion().prepareStatement(consultasPDF.getConsultaTesoAper(1));
                     vStatement.setInt(1,vAnioReporte.intValue());
                     vStatement.setString(2,utils.getUsuario()); //usuario
                     vStatement.setString(3,utils.getUsuario()); //usuario
                     vStatement.setString(4,vParametro2); //partida
                 }else if (vParametro2.equals("") && !vParametro3.equals("") && vParametro4.equals("0")){
                     vStatement = conexion.get_Coneccion().prepareStatement(consultasPDF.getConsultaTesoAper(2));
                     vStatement.setInt(1,vAnioReporte.intValue());
                     vStatement.setString(2,utils.getUsuario()); //usuario
                     vStatement.setString(3,utils.getUsuario()); //usuario
                     vStatement.setInt(4,utils.getInteger(vParametro3)); //numero plaza
                 }
                 else if (!vParametro2.equals("") && !vParametro3.equals("") && vParametro4.equals("0")){
                     vStatement = conexion.get_Coneccion().prepareStatement(consultasPDF.getConsultaTesoAper(3));
                     vStatement.setInt(1,vAnioReporte.intValue());
                     vStatement.setString(2,utils.getUsuario()); //usuario
                     vStatement.setString(3,utils.getUsuario()); //usuario
                     vStatement.setString(4,vParametro2); //partida
                     vStatement.setInt(5,utils.getInteger(vParametro3)); //numero plaza
                     
                }else if ( !vParametro4.equals("0"))
                {
                    vStatement = conexion.get_Coneccion().prepareStatement(consultasPDF.getConsultaTesoAper(4));
                    vStatement.setInt(1,vAnioReporte.intValue());
                    vStatement.setString(2,utils.getUsuario()); //usuario
                    vStatement.setString(3,utils.getUsuario()); //usuario
                    vStatement.setString(4,vParametro4); //id_Dependencia
                }
                
             }else if (vParametro1.equals("PLAZASTESOAPERSICOIN")) 
            {
                
                 pDefReporte="RepPlazasTeso_SICOIN.jasper";
                 vAnioReporte = new BigDecimal(JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.anioActual").toString());
                 
                 parametrosReporte.put("pAnio",vAnioReporte);
                 
                 if (vParametro2.equals("") && vParametro3.equals("") && vParametro4.equals("0")){ //Ningun filtro
                     vStatement = conexion.get_Coneccion().prepareStatement(consultasPDF.getConsultaTesoSICOIN(-1));
                     vStatement.setInt(1,vAnioReporte.intValue());
                     vStatement.setInt(2,vAnioReporte.intValue());
                     vStatement.setString(3,utils.getUsuario()); //usuario 
                 }else if ( !vParametro4.equals("0"))
                {
                    vStatement = conexion.get_Coneccion().prepareStatement(consultasPDF.getConsultaTesoSICOIN(4));
                    System.out.println(vAnioReporte.intValue());
                    vStatement.setInt(1,vAnioReporte.intValue());
                    vStatement.setInt(2,vAnioReporte.intValue());
                    vStatement.setString(3,utils.getUsuario()); //usuario 
                    vStatement.setString(4,vParametro4); //id_Dependencia
                }
                
             }

                if (vStatement!=null && vStatement.execute()){
                
                    vResultSetDataSource = new JRResultSetDataSource(vStatement.getResultSet());  
                    vReporteListo   = JasperFillManager.fillReport(vStr_directorioRep+pDefReporte,parametrosReporte,vResultSetDataSource);
                    pdfasbytes = JasperExportManager.exportReportToPdf(vReporteListo);
                    vNumeroPaginasReporte=vReporteListo.getPages().size();
                                 
                    
                }else{
                
                    vNumeroPaginasReporte=0;
                }
               
                            
            
            if (vNumeroPaginasReporte>0){
                    response.setContentType(CONTENT_PDF);
                    response.setContentLength(pdfasbytes.length);
                    response.setHeader("Content-disposition",
                    "inline; filename=\"Reporte.pdf\"");
        
                    outstream.write(pdfasbytes);
            }else {
                response.setContentType(CONTENT_HTML);
                outstream.write(new String("<b>El reporte no tiene datos</b>").getBytes());
                
            }
            outstream.flush();
            outstream.close();
            conexion.cn_Cerrar_coneccion();

            } catch (Exception ex) {
              ex.printStackTrace();
            conexion.cn_Cerrar_coneccion();  
            outstream.write(new String("No se pudo generar el reporte!!").getBytes());
            outstream.close();   
                                }

        }else {
            conexion.cn_Cerrar_coneccion();  
            outstream.write(new String("No se pudo generar el reporte!!").getBytes()); 
            outstream.close();
        }
    }
}
