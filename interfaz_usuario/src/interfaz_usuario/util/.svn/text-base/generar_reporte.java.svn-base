package interfaz_usuario.util;

import interfaz_usuario.backing.reportes.dts.fill_data;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import net.sf.jasperreports.engine.base.JRBasePrintPage;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;
import net.sf.jasperreports.engine.export.JRTextExporter;
import net.sf.jasperreports.engine.export.JRTextExporterParameter;

import net.sf.jasperreports.engine.fill.JRTemplateElement;
import net.sf.jasperreports.engine.fill.JRTemplatePrintText;

import net.sf.jasperreports.engine.fill.JRTemplateText;

import pkg_util_base_datos.interfaz_DB;

public class generar_reporte {
    private String vStr_directorioRep;
    private Map parametrosReporte;
    private long numero_de_paginas;
    private String vError,vDebug;
    
    public generar_reporte() {   
       try{
        vStr_directorioRep=FacesContext.getCurrentInstance().getExternalContext().getInitParameter("DIRECTORIO_REPORTES");
       }catch(Exception exep){
       //    vStr_directorioRep="C:/checkOuts/SISDesaMarzo2012\\interfaz_usuario\\public_html\\reportes\\def_reportes\\";   
          vStr_directorioRep="";
       }
         parametrosReporte = new HashMap();
         numero_de_paginas=0;
    }
    
    public String getError(){
        return vError;
    }
    
    public long getNumPaginas(){
        return this.numero_de_paginas;
    }
    
    public void addParametros(Object pKey, Object pValor){
        parametrosReporte.put(pKey,pValor);
    }
    
    public void setParametros(HashMap pParametros){
         this.parametrosReporte=pParametros;
    }
    
    public void generarReportePDF(FacesContext pContexto, String pDefReporte){   
    interfaz_DB conexion = new interfaz_DB();
    ExternalContext vExterna = pContexto.getExternalContext();
    HttpServletResponse vSrvltResponse=(HttpServletResponse)vExterna.getResponse();
    JasperPrint vReporteListo;
    this.parametrosReporte.put("SUBREPORT_DIR",vStr_directorioRep);
    this.parametrosReporte.put("REPORT_LOCALE",new java.util.Locale("es","GT"));
    try {
    vReporteListo   = JasperFillManager.fillReport(vStr_directorioRep+pDefReporte,parametrosReporte,conexion.get_Coneccion());
    byte[] pdfasbytes = JasperExportManager.exportReportToPdf(vReporteListo);
    ServletOutputStream outstream = vSrvltResponse.getOutputStream();
    vSrvltResponse.setContentType("application/pdf");
    vSrvltResponse.setContentLength(pdfasbytes.length);
    vSrvltResponse.setHeader("Content-disposition",
    "inline; filename=\"Reporte.pdf\"");
    outstream.write(pdfasbytes);
    outstream.flush();
    outstream.close();
    conexion.cn_Cerrar_coneccion();
       
    } catch (Exception ex) {
        ex.printStackTrace();
                        }
    }
  
  
  
    public boolean generarReporteTextoCheque( String pDefReporte,String path,String archivoSalida,int vCharWidth, int vCharHeight){
        boolean r=false;
        this.parametrosReporte.put("SUBREPORT_DIR",vStr_directorioRep);
        this.parametrosReporte.put("REPORT_LOCALE",new java.util.Locale("es","GT"));
        interfaz_DB conexion = new interfaz_DB();
        JRTextExporter rt=new JRTextExporter();     
        int vtamHojas;
        //rt.setParameters( parametrosReporte);
        try {
            vError=null;
            
            if (pDefReporte.equals("Cheques.jasper") || pDefReporte.equals("Cheques_dts.jasper")){
            
                parametrosReporte.put(JRParameter.IS_IGNORE_PAGINATION, Boolean.TRUE);    
                
            }else{
                
                parametrosReporte.put(JRParameter.IS_IGNORE_PAGINATION, Boolean.FALSE);     
            }
            
            
            
            JasperPrint reporteListo = JasperFillManager.fillReport(vStr_directorioRep+pDefReporte,parametrosReporte,conexion.get_Coneccion());
            rt.setParameter(JRTextExporterParameter.CHARACTER_HEIGHT,vCharHeight); 
            rt.setParameter(JRTextExporterParameter.CHARACTER_WIDTH,vCharWidth);
            rt.setParameter(JRTextExporterParameter.LINE_SEPARATOR,new String(new char[]{13,10}));
            rt.setParameter(JRTextExporterParameter.BETWEEN_PAGES_TEXT,new String(new char[]{12}));
            rt.setParameter(JRTextExporterParameter.JASPER_PRINT,reporteListo);         
            rt.setParameter(JRTextExporterParameter.OUTPUT_FILE_NAME,path+archivoSalida);
            rt.setParameter(JRTextExporterParameter.CHARACTER_ENCODING,"CP1252"); 
            
           
            
            
            JRBasePrintPage vPaginaVacia,vPaginaActual;
            List <JRBasePrintPage> vPaginasReporte;
            int vIndicePagina=0,vDiferenciaCheques;
            BigDecimal vNumChequeActual=null,vNumChequeAnt=null;
            
           
            vPaginasReporte=reporteListo.getPages();
            
                    
                    
                  /*  FUNCIONA CUANDO EXISTE PAGINACION EL NUEVO REPORTE DE CHEQUE NO TIENE PAGINACION  
                   while (vIndicePagina<vPaginasReporte.size()){
                      
                     vPaginaActual=vPaginasReporte.get(vIndicePagina);
                     vPaginaActual.getElements();
                     JRTemplatePrintText vElemento,vElemento2=null;            
                     vElemento=(JRTemplatePrintText)vPaginaActual.getElements().get(0);
                     vNumChequeActual=new BigDecimal(vElemento.getText());
                     
                     if (vNumChequeAnt==null){
                         vNumChequeAnt=vNumChequeActual;
                     }else if (vNumChequeAnt!=null){
                        vNumChequeAnt=vNumChequeAnt.add(new BigDecimal(1));
                        if (vNumChequeAnt.compareTo(vNumChequeActual)<0){
                         vDiferenciaCheques=vNumChequeActual.subtract(vNumChequeAnt).intValue();
                           for (int vContador=0;vContador<vDiferenciaCheques;vContador++)
                           {
                               vPaginaVacia=new JRBasePrintPage();
                               //vPaginaVacia.
                               try{ 
                                
                                   JRTemplateText da = new JRTemplateText(vElemento.getOrigin(),vElemento.getDefaultStyleProvider());
                                   vElemento2=new JRTemplatePrintText(da);
                                   vElemento2.setText(vNumChequeAnt.toString()+" - ANULADO FORMULARIOS STANDARD");
                                   vElemento2.setWidth(350);
                                   vElemento2.setHeight(12);
                                   vElemento2.setX(103);
                                   vElemento2.setY(65);
                                   
                                   
                               }catch(Exception exep){
                                   exep.printStackTrace();
                               }
                               vPaginaVacia.addElement(vElemento2);
                               reporteListo.getPages().add(vIndicePagina,vPaginaVacia);
                               vNumChequeAnt=vNumChequeAnt.add(new BigDecimal(1));
                               vIndicePagina++;  
                           }
                          
                           vNumChequeAnt=vNumChequeAnt.subtract(new BigDecimal(1)); 
                           vIndicePagina--;  
                        }
                     }
                    vIndicePagina++;  
                   }
                  
                  */
                  
               
           // tempo=new JRBasePrintPage();
           // vReporteListo.getPages().add(5,tempo);
            numero_de_paginas=reporteListo.getPages().size();
            
            if(reporteListo.getPages().size()>0){
                rt.exportReport();
                r=true;    
            }
           
            
            rt.reset();
            conexion.cn_Cerrar_coneccion();
            
        } catch (Exception ex) {
            conexion.cn_Cerrar_coneccion();
            vError=ex.getMessage();
            ex.printStackTrace();
        }
        return r;
       
    }

    
    public boolean generarReporteTexto( String pDefReporte,String path,String archivoSalida,int vCharWidth, int vCharHeight){
           boolean r=false;
           this.parametrosReporte.put("SUBREPORT_DIR",vStr_directorioRep);
           this.parametrosReporte.put("REPORT_LOCALE",new java.util.Locale("es","GT"));
           interfaz_DB conexion = new interfaz_DB();
           JRTextExporter rt=new JRTextExporter();                      
           //rt.setParameters( parametrosReporte);
           try {
           
               if (pDefReporte.equals("Cheques.jasper") || pDefReporte.equals("Cheques_dts.jasper")){
               
                   parametrosReporte.put(JRParameter.IS_IGNORE_PAGINATION, Boolean.TRUE);    
                   
               }else{
                   
                   parametrosReporte.put(JRParameter.IS_IGNORE_PAGINATION, Boolean.FALSE);     
               }

           
               vError=null;
               JasperPrint reporteListo = JasperFillManager.fillReport(vStr_directorioRep+pDefReporte,parametrosReporte,conexion.get_Coneccion());
               rt.setParameter(JRTextExporterParameter.CHARACTER_HEIGHT,vCharHeight); 
               //rt.setParameter(JRTextExporterParameter.CHARACTER_ENCODING,"CP1252"); 
                rt.setParameter(JRTextExporterParameter.CHARACTER_ENCODING,"ISO-8859-1"); 
                
               rt.setParameter(JRTextExporterParameter.LINE_SEPARATOR,new String(new char[]{13,10}));             
               rt.setParameter(JRTextExporterParameter.CHARACTER_WIDTH,vCharWidth);
               
               if (pDefReporte.equals("Det_pagos_Desc.jasper")){                
               rt.setParameter(JRTextExporterParameter.BETWEEN_PAGES_TEXT,new String(new char[]{13,10}));    
               }else{
               rt.setParameter(JRTextExporterParameter.BETWEEN_PAGES_TEXT,new String(new char[]{12}));
               }
               rt.setParameter(JRTextExporterParameter.JASPER_PRINT,reporteListo);         
               rt.setParameter(JRTextExporterParameter.OUTPUT_FILE_NAME,path+archivoSalida);
               
               numero_de_paginas=reporteListo.getPages().size();
               
               if(reporteListo.getPages().size()>0){
                   rt.exportReport();
                   r=true;    
               }
              
              
               rt.reset();
               conexion.cn_Cerrar_coneccion();
               
           } catch (Exception ex) {
               conexion.cn_Cerrar_coneccion();
               vError=ex.getMessage();
               ex.printStackTrace();
           }
           return r;
          
       }


    public void insertar_archivo_generado(String Tiporeporte,String path,String archivoSalida){
        try{
        interfaz_DB conexion = new interfaz_DB();
        conexion.Crear_sentencia("insert into sis_reporte_generado (id_reporte_generado,id_tipo_reporte,path,nombre_archivo) values (sis_reporte_generado_sq.nextval,(select id_tipo_reporte from sis_tipo_reporte where nombre_tipo_reporte=?),?,? )");
        conexion.setParametrosSentencia(1,Tiporeporte);
        conexion.setParametrosSentencia(2,path);
        conexion.setParametrosSentencia(3,archivoSalida);
        conexion.ejecutar_update(true);
        conexion.cn_Cerrar_coneccion();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
 
 
public boolean generarReporteTextoChequeDTS( String pDefReporte,String path,String archivoSalida,int vCharWidth, int vCharHeight){
boolean r=false;
this.parametrosReporte.put("SUBREPORT_DIR",vStr_directorioRep);
this.parametrosReporte.put("REPORT_LOCALE",new java.util.Locale("es","GT"));
interfaz_DB conexion = new interfaz_DB();
JRTextExporter rt=new JRTextExporter();     
fill_data vDatosReport= new fill_data();
ArrayList vCheques=null;


   try {
       vError=null;
            
            
       parametrosReporte.put(JRParameter.IS_IGNORE_PAGINATION, Boolean.TRUE);    
                
       vCheques=vDatosReport.getCheques((BigDecimal)parametrosReporte.get("IdProceso"));

       vDebug=vDatosReport.getDebug();                        
            
       JasperPrint reporteListo = JasperFillManager.fillReport(vStr_directorioRep+pDefReporte,parametrosReporte,new JRBeanCollectionDataSource(vCheques));
       rt.setParameter(JRTextExporterParameter.CHARACTER_HEIGHT,vCharHeight); 
       rt.setParameter(JRTextExporterParameter.CHARACTER_WIDTH,vCharWidth);
       rt.setParameter(JRTextExporterParameter.LINE_SEPARATOR,new String(new char[]{13,10}));
       rt.setParameter(JRTextExporterParameter.BETWEEN_PAGES_TEXT,new String(new char[]{12}));
       rt.setParameter(JRTextExporterParameter.JASPER_PRINT,reporteListo);         
       rt.setParameter(JRTextExporterParameter.OUTPUT_FILE_NAME,path+archivoSalida);
       rt.setParameter(JRTextExporterParameter.CHARACTER_ENCODING,"CP1252"); 
            
                  
            numero_de_paginas=vCheques.size();
            
            if(reporteListo.getPages().size()>0){
                rt.exportReport();
                r=true;    
            }
           
            rt.reset();
            conexion.cn_Cerrar_coneccion();
            if (vDatosReport.isIsError()){
                vError="Fallo en la generacion de cheques";
                r=false;                    
            }
            
        } catch (Exception ex) {
            conexion.cn_Cerrar_coneccion();
            vError=ex.getMessage();
            ex.printStackTrace();
        }
        return r;
       
    }


    public String getDebug() {
        return vDebug;
    }
    
    
    public boolean generarReportesRemesa( String pRemesa, String pRemesaActual, String pDefReporte, String vStr_directorioRe1,String path,String archivoSalida,int vCharWidth, int vCharHeight){
        boolean r=false;
        Map parametrosReporte = new HashMap();
        interfaz_DB conexion = new interfaz_DB();
        JRTextExporter rt=new JRTextExporter();                      
        String nuevaLinea;
            
        //rt.setParameters( parametrosReporte);
        try {
            parametrosReporte.put("SUBREPORT_DIR",vStr_directorioRe1);
            parametrosReporte.put("REPORT_LOCALE",new java.util.Locale("es","GT"));
                          
            /*   VALORES POR DEFECTO  */
            nuevaLinea=new String(new char[]{12}); //cambio planilla igss
             
            parametrosReporte.put("pRemesaActual",new BigDecimal(pRemesaActual));
            parametrosReporte.put("pRemesa",new BigDecimal(pRemesa));
       //     vNombreArch="complementaria_08_rem_"+pRemesa+".txt";
            
            JasperPrint reporteListo = JasperFillManager.fillReport(vStr_directorioRe1+pDefReporte,parametrosReporte,conexion.get_Coneccion());
            rt.setParameter(JRTextExporterParameter.CHARACTER_HEIGHT,vCharHeight); 
            rt.setParameter(JRTextExporterParameter.CHARACTER_ENCODING,"CP1252"); 
            rt.setParameter(JRTextExporterParameter.CHARACTER_WIDTH,vCharWidth);
            nuevaLinea="";
            rt.setParameter(JRTextExporterParameter.BETWEEN_PAGES_TEXT,nuevaLinea); //cambio planilla igss
            rt.setParameter(JRTextExporterParameter.LINE_SEPARATOR,new String(new char[]{13,10}));             
            rt.setParameter(JRTextExporterParameter.JASPER_PRINT,reporteListo);         
            rt.setParameter(JRTextExporterParameter.OUTPUT_FILE_NAME,path+archivoSalida);
            
           
            if(reporteListo.getPages().size()>0){
                rt.exportReport();
                r=true;    
            } 
            else {
            //outstream.write(new String("<b>El reporte no tiene datos</b>").getBytes());
            
            }
            rt.reset();
            conexion.cn_Cerrar_coneccion();
       //     outstream.close();
            
           
            
        } catch (Exception ex) {
            conexion.cn_Cerrar_coneccion();
            vError=ex.getMessage();
            ex.printStackTrace();
        }
        return r;
       
    }


    public boolean generarReportesRemesaTXT( String pRemesa, String pRemesaActual, String pDefReporte, String vStr_directorioRe1,String path,String archivoSalida,int vCharWidth, int vCharHeight, int pTipoReporte){
        boolean r=false;
        Map parametrosReporte = new HashMap();
        interfaz_DB conexion = new interfaz_DB();                 
        String nuevaLinea;
        int vNumeroPaginasReporte;
             
        try {
            parametrosReporte.put("SUBREPORT_DIR",vStr_directorioRe1);
            parametrosReporte.put("REPORT_LOCALE",new java.util.Locale("es","GT")); 
             nuevaLinea=new String(new char[]{12}); //cambio planilla igss
             
            parametrosReporte.put("pIdRemesaActual",new BigDecimal(pRemesaActual));
            parametrosReporte.put("pIdRemesa",new BigDecimal(pRemesa)); 
            
           
                                                                  
            if (pTipoReporte == 0){      
            
                JasperPrint reporteListo = JasperFillManager.fillReport(vStr_directorioRe1+
                                                                        pDefReporte
                                                                      ,parametrosReporte
                                                                      ,conexion.get_Coneccion());
                JRTextExporter rt=new JRTextExporter();     
                rt.setParameter(JRTextExporterParameter.CHARACTER_HEIGHT,vCharHeight); 
                rt.setParameter(JRTextExporterParameter.CHARACTER_ENCODING,"CP1252"); 
                rt.setParameter(JRTextExporterParameter.CHARACTER_WIDTH,vCharWidth); 
                rt.setParameter(JRTextExporterParameter.BETWEEN_PAGES_TEXT,nuevaLinea); //cambio planilla igss
                rt.setParameter(JRTextExporterParameter.LINE_SEPARATOR,new String(new char[]{13,10}));             
                rt.setParameter(JRTextExporterParameter.JASPER_PRINT,reporteListo);         
                rt.setParameter(JRTextExporterParameter.OUTPUT_FILE_NAME,path+archivoSalida);
                
                if(reporteListo.getPages().size()>0){
                    rt.exportReport();
                    r=true;    
                } 
                else {
                    System.out.println("ERROR NO SE GENERO ARCHIVO");
                }
                rt.reset();
                
            }else if (pTipoReporte == 2){                
                JasperPrint reporteListo = JasperFillManager.fillReport(vStr_directorioRe1+
                                                                        pDefReporte
                                                                      ,parametrosReporte
                                                                      ,conexion.get_Coneccion());
                try {
                    JRPdfExporter vPDFGen = new JRPdfExporter();
                    vPDFGen.setParameter(JRPdfExporterParameter.JASPER_PRINT, reporteListo);
                    vPDFGen.setParameter(JRPdfExporterParameter.OUTPUT_FILE_NAME,path+archivoSalida+".pdf");
                    vPDFGen.setParameter(JRPdfExporterParameter.CHARACTER_ENCODING, "CP1252");
                   
                    
                    vNumeroPaginasReporte = reporteListo.getPages().size();
                    
                    if(reporteListo.getPages().size()>0){
                        vPDFGen.exportReport();
                        r=true;    
                    } 
                    else {
                        System.out.println("ERROR NO SE GENERO ARCHIVO");
                    }
                
                }catch (Exception ex) {
                    ex.printStackTrace();
                
                }
                
            }
           
            
            conexion.cn_Cerrar_coneccion();  
            
        } catch (Exception ex) {
            conexion.cn_Cerrar_coneccion();
            vError=ex.getMessage();
            ex.printStackTrace();
        }
        return r;
       
    }

    
    public boolean generarReportesRemesaInv( String pRemesaActual, String pPeriodo, String pCorrelativo, String pDefReporte, String vStr_directorioRe1,String path,String archivoSalida,int vCharWidth, int vCharHeight){
        boolean r=false;
        Map parametrosReporte = new HashMap();
        interfaz_DB conexion = new interfaz_DB();
        JRTextExporter rt=new JRTextExporter();                      
        String nuevaLinea;
            
        //rt.setParameters( parametrosReporte);
        try {
            parametrosReporte.put("SUBREPORT_DIR",vStr_directorioRe1);
            parametrosReporte.put("REPORT_LOCALE",new java.util.Locale("es","GT"));
                          
            /*   VALORES POR DEFECTO  */
            nuevaLinea=new String(new char[]{12}); //cambio planilla igss
             
            parametrosReporte.put("pRemesaActual",new BigDecimal(pRemesaActual));
            parametrosReporte.put("pCorrelativo",new BigDecimal(pCorrelativo));
            parametrosReporte.put("pPeriodo",new BigDecimal(pPeriodo));
       //     vNombreArch="complementaria_08_rem_"+pRemesa+".txt";
            
            JasperPrint reporteListo = JasperFillManager.fillReport(vStr_directorioRe1+pDefReporte,parametrosReporte,conexion.get_Coneccion());
            rt.setParameter(JRTextExporterParameter.CHARACTER_HEIGHT,vCharHeight); 
            rt.setParameter(JRTextExporterParameter.CHARACTER_ENCODING,"CP1252"); 
            rt.setParameter(JRTextExporterParameter.CHARACTER_WIDTH,vCharWidth);
            nuevaLinea="";
            rt.setParameter(JRTextExporterParameter.BETWEEN_PAGES_TEXT,nuevaLinea); //cambio planilla igss
            rt.setParameter(JRTextExporterParameter.LINE_SEPARATOR,new String(new char[]{13,10}));             
            rt.setParameter(JRTextExporterParameter.JASPER_PRINT,reporteListo);         
            rt.setParameter(JRTextExporterParameter.OUTPUT_FILE_NAME,path+archivoSalida);
            
           
            if(reporteListo.getPages().size()>0){
                rt.exportReport();
                r=true;    
            } 
            else {
            //outstream.write(new String("<b>El reporte no tiene datos</b>").getBytes());
            
            }
            rt.reset();
            conexion.cn_Cerrar_coneccion();
       //     outstream.close();
            
           
            
        } catch (Exception ex) {
            conexion.cn_Cerrar_coneccion();
            vError=ex.getMessage();
            ex.printStackTrace();
        }
        return r;
       
    }

}
