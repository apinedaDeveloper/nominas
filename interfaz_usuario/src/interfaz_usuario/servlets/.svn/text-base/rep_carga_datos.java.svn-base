package interfaz_usuario.servlets;

import interfaz_usuario.util.JSFUtils;

import java.io.IOException;
import java.io.PrintWriter;

import java.math.BigDecimal;

import java.sql.Date;

import java.text.DateFormat;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.faces.context.FacesContext;

import javax.servlet.*;
import javax.servlet.http.*;

import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import net.sf.jasperreports.engine.export.JExcelApiExporter;
import net.sf.jasperreports.engine.export.JExcelApiExporterParameter;

import oracle.jbo.JboException;

import pkg_util_base_datos.interfaz_DB;

public class rep_carga_datos extends HttpServlet {
    private static final String CONTENT_HTML ="text/html; charset=windows-1252";
    private static final String CONTENT_PDF="application/pdf";
    private static final String CONTENT_XLS="application/vnd.ms-excel";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request, 
                      HttpServletResponse response) throws ServletException, IOException {
        String vParametro1,vParametro2,vStr_directorioRep,pDefReporte,vParametro3,vParametro4,vParametro5,vNombreArchivo;
        vParametro1=request.getParameter("id");
        vParametro2=request.getParameter("rep");
        vParametro3="";
        interfaz_DB conexion = new interfaz_DB();
        JasperPrint vReporteListo;
        Map parametrosReporte = new HashMap();
        ServletOutputStream outstream;
        int vNumeroPaginasReporte;
        JExcelApiExporter vRepExcel;
        Object vUsuario;
        
        vStr_directorioRep=request.getSession().getServletContext().getInitParameter("DIRECTORIO_REPORTES");
        parametrosReporte.put("SUBREPORT_DIR",vStr_directorioRep);
        parametrosReporte.put("REPORT_LOCALE",new java.util.Locale("es","GT"));
        java.util.Date fecha1, fecha2;
        pDefReporte="";
        outstream = response.getOutputStream();
        
        if (vParametro1!=null&&vParametro2!=null){
            if (vParametro2.equals("BANCO")){
                pDefReporte="Rep_carga_bancos.jasper";
                parametrosReporte.put("pIdCarga",new BigDecimal(vParametro1));
            }
            else if (vParametro2.equals("ARCH_DESCAPLICADO")){
                vParametro3=request.getParameter("p");
                vParametro4=request.getParameter("a");
                pDefReporte="arch_descuentos_aplicados.jasper";
                parametrosReporte.put("pIdCargaArchivoDatos",new BigDecimal(vParametro1));
                parametrosReporte.put("pPeriodo",new BigDecimal(vParametro3));
                parametrosReporte.put("pAnio",new BigDecimal(vParametro4));
            }
            else if (vParametro2.equals("ARCH_DESCAPLICADOPLAN")){
                vParametro3=request.getParameter("p");
                vParametro4=request.getParameter("a");
                pDefReporte="arch_descuentos_aplicados_plan.jasper";
                parametrosReporte.put("pIdCargaArchivoDatos",new BigDecimal(vParametro1));
                parametrosReporte.put("pPeriodo",new BigDecimal(vParametro3));
                parametrosReporte.put("pAnio",new BigDecimal(vParametro4));
            }
            else if(vParametro2.equals("ARCH_CH_ANUL")){
                vParametro3=request.getParameter("u");
                vParametro4=request.getParameter("fi");
                vParametro5=request.getParameter("ff");
                
                vUsuario=request.getParameter("op");
               // vUsuario="true";
                
                if (vUsuario!=null && vUsuario.toString().equals("true")){
                
                   // pDefReporte="cheques_anuldesc_banco_plan.jasper";
                    pDefReporte="arch_desc_aplicadosplan_anul.jasper";
                    
                }else
                {
                
                    pDefReporte="cheques_anulados_desc_banco.jasper";
                
                }
                
                parametrosReporte.put("pUsuario",vParametro3);
                parametrosReporte.put("p_fecha_ini",vParametro4);
                parametrosReporte.put("p_fecha_fin",vParametro5);
                

            }
            else if (vParametro2.equals("ARCH_INCONSISTENCIAS")){
                vParametro3=request.getParameter("p");
                vParametro4=request.getParameter("a");
                pDefReporte="arch_descuentos_inconsistencias.jasper";
                parametrosReporte.put("pIdCargaArchivoDatos",new BigDecimal(vParametro1));
                parametrosReporte.put("pPeriodo",new BigDecimal(vParametro3));
                parametrosReporte.put("pAnio",new BigDecimal(vParametro4));
                parametrosReporte.put(JRParameter.IS_IGNORE_PAGINATION, Boolean.TRUE);    
            }
            
            try {
            vReporteListo   = JasperFillManager.fillReport(vStr_directorioRep+pDefReporte,parametrosReporte,conexion.get_Coneccion());
            
            if(vParametro2.equals("BANCO")){
                byte[] pdfasbytes = JasperExportManager.exportReportToPdf(vReporteListo);
                
                vNumeroPaginasReporte=vReporteListo.getPages().size();
                
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
            }
            else if(vParametro2.equals("ARCH_DESCAPLICADO") || vParametro2.equals("ARCH_DESCAPLICADOPLAN")){
            
                vRepExcel= new JExcelApiExporter();
                vRepExcel.setParameter(JExcelApiExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS,true);
                vRepExcel.setParameter(JExcelApiExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,true);
                vRepExcel.setParameter(JExcelApiExporterParameter.IS_WHITE_PAGE_BACKGROUND,false);
                vRepExcel.setParameter(JExcelApiExporterParameter.IS_DETECT_CELL_TYPE,true);
                vRepExcel.setParameter(JExcelApiExporterParameter.JASPER_PRINT,vReporteListo);
                vRepExcel.setParameter(JExcelApiExporterParameter.OUTPUT_STREAM,outstream);
                
                vNumeroPaginasReporte=vReporteListo.getPages().size();
                vNombreArchivo="cod_"+vParametro1+"_descuentos_aplicados.xls";
                
                
                if (vNumeroPaginasReporte>0){
                    response.setContentType(CONTENT_XLS);
                    response.setHeader ("Content-Disposition", "attachment;filename=\"" + vNombreArchivo + "\""); 
                    vRepExcel.exportReport();
                }else {
                response.setContentType(CONTENT_HTML);
                outstream.write(new String("<b>El reporte no tiene datos</b>").getBytes());
                
                }
            }            
            else if(vParametro2.equals("ARCH_CH_ANUL")){
            
                vRepExcel= new JExcelApiExporter();
                vRepExcel.setParameter(JExcelApiExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS,true);
                vRepExcel.setParameter(JExcelApiExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,true);
                vRepExcel.setParameter(JExcelApiExporterParameter.IS_WHITE_PAGE_BACKGROUND,false);
                vRepExcel.setParameter(JExcelApiExporterParameter.IS_DETECT_CELL_TYPE,true);
                vRepExcel.setParameter(JExcelApiExporterParameter.JASPER_PRINT,vReporteListo);
                vRepExcel.setParameter(JExcelApiExporterParameter.OUTPUT_STREAM,outstream);
                
                vNumeroPaginasReporte=vReporteListo.getPages().size();
                vNombreArchivo=vParametro3+"_cheques_anulados.xls";
                
                
                if (vNumeroPaginasReporte>0){
                    response.setContentType(CONTENT_XLS);
                    response.setHeader ("Content-Disposition", "attachment;filename=\"" + vNombreArchivo + "\""); 
                    vRepExcel.exportReport();
                }else {
                response.setContentType(CONTENT_HTML);
                outstream.write(new String("<b>El reporte no tiene datos</b>").getBytes());
                
                }
            }
            else if(vParametro2.equals("ARCH_INCONSISTENCIAS")){
            
                vRepExcel= new JExcelApiExporter();
                vRepExcel.setParameter(JExcelApiExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS,true);
                vRepExcel.setParameter(JExcelApiExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,true);
                vRepExcel.setParameter(JExcelApiExporterParameter.IS_WHITE_PAGE_BACKGROUND,false);
                vRepExcel.setParameter(JExcelApiExporterParameter.IS_DETECT_CELL_TYPE,true);
                vRepExcel.setParameter(JExcelApiExporterParameter.JASPER_PRINT,vReporteListo);                
                vRepExcel.setParameter(JExcelApiExporterParameter.OUTPUT_STREAM,outstream);
                
                
                
             //   byte[] pdfasbytes = JasperExportManager.exportReportToPdf(vReporteListo);
              
                vNombreArchivo=vParametro1+"_arch_inconsist.xls";
                vNumeroPaginasReporte=vReporteListo.getPages().size();
                
                    if (vNumeroPaginasReporte>0){
                        response.setContentType(CONTENT_XLS);
                        response.setHeader ("Content-Disposition", "attachment;filename=\"" + vNombreArchivo + "\""); 
                        vRepExcel.exportReport();
                    }else {
                    response.setContentType(CONTENT_HTML);
                    outstream.write(new String("<b>El reporte no tiene datos</b>").getBytes());
                    
                    }
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
