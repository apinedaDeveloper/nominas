package interfaz_usuario.servlets;

import interfaz_usuario.util.JSFUtils;

import interfaz_usuario.util.utils;

import java.io.IOException;
import java.math.BigDecimal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.faces.context.FacesContext;

import javax.servlet.*;
import javax.servlet.http.*;

import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;


//import net.sf.jasperreports.engine.export.JExcelApiExporter;
//import net.sf.jasperreports.engine.export.JExcelApiExporterParameter;

import net.sf.jasperreports.engine.export.JExcelApiExporter;

import net.sf.jasperreports.engine.export.JExcelApiExporterParameter;

import pkg_util_base_datos.interfaz_DB;

public class verReporteExcel extends HttpServlet {
    private static final String CONTENT_HTML = "text/html; charset=windows-1252";
    private static final String CONTENT_XLS="application/vnd.ms-excel";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request, 
                      HttpServletResponse response) throws ServletException, IOException {
                      //response.setContentType(CONTENT_TYPE);
        
        String vParametro1,vParametro2,vParametro3,vParametro4,vParametro5,vParametro6,vParametro7,vParametro8,vParametro9,vStr_directorioRep,pDefReporte,vNombreArchivo;
        String vAnio;
        String vUsuario;
        BigDecimal vAnioReporte;
        
        String nuevaLinea=new String(new char[]{12});
        vParametro1=request.getParameter("id");
        vParametro2=request.getParameter("rep");
        vParametro3=request.getParameter("var1");
        vParametro4=request.getParameter("var2");
        vParametro5=request.getParameter("id2");
        vParametro6=request.getParameter("inicio");
        vParametro7=request.getParameter("id3");
        vParametro8=request.getParameter("id4");
        vParametro9=request.getParameter("id5");
        
        vAnio=JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.anioActual").toString();
        vAnio=(vAnio==null?utils.getAnioActual():vAnio);
        //Codigo agregado 21/06/2017 por Rolando Anona
        vUsuario=JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.selRegEmpleado_login").toString();
        if (vParametro1==null){
            
            vParametro1=request.getAttribute("id").toString();
        }
        
        if (vParametro2==null){
                              
            vParametro2=request.getAttribute("rep").toString();
        }
        
        if (vParametro3==null){
                                                
            vParametro3=request.getAttribute("var1")!=null?request.getAttribute("var1").toString():"";
        }                  
        
        if (vParametro4==null){
                                                                
            vParametro4=request.getAttribute("var2")!=null?request.getAttribute("var2").toString():"";
         }                  
                          
        
        interfaz_DB conexion = new interfaz_DB();
        JasperPrint vReporteListo;
        Map parametrosReporte = new HashMap();
        ServletOutputStream outstream;
        int vNumeroPaginasReporte;
        JExcelApiExporter vRepExcel;
 
        
        vStr_directorioRep=request.getSession().getServletContext().getInitParameter("DIRECTORIO_REPORTES");
        parametrosReporte.put("SUBREPORT_DIR",vStr_directorioRep);
        parametrosReporte.put("REPORT_LOCALE",new java.util.Locale("es","GT"));
        pDefReporte="";
        outstream = response.getOutputStream();
        
        vNombreArchivo="excel";
        PreparedStatement vStatement=null;
        JRResultSetDataSource vResultSetDataSource=null;
        ResultSet vDatos=null; 
        byte[] pdfasbytes=null;  
        
        if (vParametro1!=null&&vParametro2!=null){
            if (vParametro2.equals("ARCH_ACRE")){
                pDefReporte="arch_acreditacion.jasper";
                parametrosReporte.put("IdProceso",new BigDecimal(vParametro1));
                vNombreArchivo="acreditacion_"+vParametro1+".xls";
                
            }else if (vParametro2.equals("ARCH_ACREANUL")){
                pDefReporte="arch_acreditacion_anulado.jasper";
                parametrosReporte.put("IdProceso",new BigDecimal(vParametro1));
                vNombreArchivo="anulados_acreditacion_"+vParametro1+".xls";
            }
            else if (vParametro2.equals("HIST_SAL_EMPL")){
                            pDefReporte="sueldos_empleado_excel.jasper";
                            parametrosReporte.put("pRegistroEmpleado",new BigDecimal(vParametro1));
                            parametrosReporte.put("pUsuario",vUsuario); //Codigo agregado 24/08/2022
                            vNombreArchivo="hist_sal_"+vParametro1+".xls";
            }
            else if (vParametro2.equals("HIST_SAL_EMPL2")){
                            pDefReporte="sueldos_empleado_excel_v2.jasper";
                            parametrosReporte.put("pRegistroEmpleado",new BigDecimal(vParametro1));
                            parametrosReporte.put("pFechaI",vParametro3);
                            parametrosReporte.put("pFechaF",vParametro4);
                            parametrosReporte.put("pUsuario",vUsuario);  // -- Codigo agregado el 24/08/2022
                            vNombreArchivo="hist_sal_"+vParametro1+".xls";
            }
            else if (vParametro2.equals("POLIZA_DIARIO_EXCEL")){
                            pDefReporte="PolizaDiarioExcel.jasper";
                            parametrosReporte.put("no_poliza_diario",new BigDecimal(vParametro1));
                            vNombreArchivo="poliza_diario_"+vParametro1+".xls";
            }
            else if (vParametro2.equals("POLIZA_DIARIO_EXCEL_ANU")){
                            pDefReporte="PolizaDiarioExcelAnulados.jasper";
                            parametrosReporte.put("no_poliza",new BigDecimal(vParametro1));
                            vNombreArchivo="poliza_diario_anulados_"+vParametro1+".xls";
            } 
            else if(vParametro2.equals("SUELDO_ENERO"))
            {
            
                pDefReporte="audit_sueldoenero_excl.jasper";
                parametrosReporte.put("varDep",new BigDecimal(vParametro1));
                parametrosReporte.put("pAnio",new BigDecimal(vAnio));
                
                
                if (vParametro6!=null && vParametro6.equals("true")){
                    parametrosReporte.put("pFiltro","and n.NOMINAL - ar.SALARIO_BASE-ar.COMPL_SALARIAL-ar.ESCALAFON <>0");                                           
                }else {
                    parametrosReporte.put("pFiltro"," ");                                           
                }
                 
                vNombreArchivo="audit_sueldoenero.xls";                                                   
            } 
            else if(vParametro2.equals("SUELDOS"))
            {
            
               pDefReporte="audit_sueldo_excl.jasper";
               parametrosReporte.put("varDep",new BigDecimal(vParametro1));
               parametrosReporte.put("mes",new BigDecimal(vParametro5));
               parametrosReporte.put("pAnio",new BigDecimal(vAnio));
               
               if (vParametro6!=null && vParametro6.equals("true")){
                   parametrosReporte.put("pFiltro"," and nn.NOMINAL - n.NOMINAL <> 0");                                           
               }else {
                   parametrosReporte.put("pFiltro"," ");                                           
               }
               
            }
            else if (vParametro2.equals("REP_INTEGRACION_PLAN_REM")){
                  pDefReporte="rep_integracion_plan_remesa.jasper";
                  parametrosReporte.put("pFechaInicio",vParametro3);
                  parametrosReporte.put("pFechaFin",vParametro4);
                  parametrosReporte.put("pRemesa", utils.getFecha(vParametro4) );
                  parametrosReporte.put("pIdRemesa",new BigDecimal(vParametro1));
                                     
                  vNombreArchivo="plan_remesa_"+vParametro1+".xls";
            }
            else if(vParametro2.equals("REPCNCEMTDO")){
                pDefReporte="emitido_conciliacion_pdf.jasper";
                parametrosReporte.put("pIdProcesoConciliacion",new BigDecimal(vParametro1));
                vNombreArchivo="cheque_emitido_concilia_"+vParametro1+".xls";
            }
            else if(vParametro2.equals("PAGOREP")){
                pDefReporte="pagos_repetidos_auditoria.jasper";
                parametrosReporte.put("pPeriodo",new BigDecimal(vParametro1));

                parametrosReporte.put("pCorrelativo",new BigDecimal(vParametro3));
                
                if(vParametro4.equals("TODAS")){
                    parametrosReporte.put("pDependencia","");
                }
                else{
                    parametrosReporte.put("pDependencia"," and part.d3d4="+new BigDecimal(vParametro4));
                }
                                
                vNombreArchivo="pagos_repetidos.xls";       
            }
            else if(vParametro2.equals("NOMLIQAUDIEXCEL")){
                pDefReporte="nom_liquidadas_auditoria_excel.jasper";
                parametrosReporte.put("pFechaI",vParametro3);

                parametrosReporte.put("pFechaF",vParametro4);
                
                if(vParametro1.equals("TODAS")){
                    parametrosReporte.put("pDependencia",null);
                }
                else{
                    parametrosReporte.put("pDependencia",new BigDecimal(vParametro1));
                }
                                
                vNombreArchivo="nominas_liquidadas.xls";       
            }
            else if (vParametro2.equals("HIST_SAL_EMPL_AUDI")){
                
                if(vParametro1.equals("TODAS"))
                    vParametro1 = "0";
                if(vParametro5.equals("TODOS"))
                    vParametro5 = "0";                
                if(vParametro7.equals("TODOS")){
                    pDefReporte="sueldos_empl_audit_excel.jasper";
                }
                else{
                    
                }
                
                String cheques = "";
                String chequesMigra = "";
                if(vParametro3!=null && !vParametro3.trim().equals("")){ // verificar si vienen cheques como parametros
                    cheques = "(doc.num_doc_fisico between "+vParametro3+ " and "+vParametro4+"  and doc.id_tipo_documento=1)";
                    chequesMigra = "(cheque between "+vParametro3+ " and "+vParametro4+"  and banco in (1,2,3,4))";
                    
                    if(vParametro6!=null && !vParametro6.trim().equals("")){ // verifica si vienen acreditamientos como parametros
                        cheques = "and ("+cheques+" or (doc.num_doc_fisico between "+vParametro6+ " and "+vParametro8+"  and doc.id_tipo_documento=2))";
                        chequesMigra = "and ("+chequesMigra+" or (cheque between "+vParametro6+ " and "+vParametro8+"  and banco=5))";
                    }
                    else{
                        cheques = "and "+cheques;
                        chequesMigra = "and "+chequesMigra;
                    }
                }
                else{ // solo vienen acreditamientos
                    cheques = "and (doc.num_doc_fisico between "+vParametro6+ " and "+vParametro8+"  and doc.id_tipo_documento=2)";
                    chequesMigra = "and (cheque between "+vParametro6+ " and "+vParametro8+"  and banco=5)";
                }
                
                //System.out.println(cheques);
                //System.out.println(chequesMigra);
                
                parametrosReporte.put("pDependencia",new BigDecimal(vParametro1));
                parametrosReporte.put("pTipoProceso",new BigDecimal(vParametro5));
                parametrosReporte.put("pMigracion",new BigDecimal(vParametro9));
                parametrosReporte.put("pCondicion",cheques);
                parametrosReporte.put("pCondicionMigra",chequesMigra);
                parametrosReporte.put("pUsuario",vUsuario);
                vNombreArchivo="sueldos_empl_excel.xls";
            }
            else if(vParametro2.equals("PAGOPLANPERIODO")){
                pDefReporte="descuento_plan_periodo_anio.jasper";
                parametrosReporte.put("pPeriodo",new BigDecimal(vParametro1));

                parametrosReporte.put("pCorrelativo",new BigDecimal(vParametro3));
                
                if(vParametro4.equals("TODAS")){
                    parametrosReporte.put("pDependencia","");
                }
                else{
                    parametrosReporte.put("pDependencia"," and p.d3d4="+new BigDecimal(vParametro4));
                }
                                
                vNombreArchivo="pagos_plan_con.xls";       
            }
            else if(vParametro2.equals("PAGOSINPLANPERIODO")){
                pDefReporte="sin_descuento_plan_periodo_anio.jasper";
                parametrosReporte.put("pPeriodo",new BigDecimal(vParametro1));

                parametrosReporte.put("pCorrelativo",new BigDecimal(vParametro3));
                
                if(vParametro4.equals("TODAS")){
                    parametrosReporte.put("pDependencia","");
                }
                else{
                    parametrosReporte.put("pDependencia"," and p.d3d4="+new BigDecimal(vParametro4));
                }
                                
                vNombreArchivo="pagos_plan_sin.xls";       
            }
            else if(vParametro2.equals("PAGOPLANNOAFECTO")){
                pDefReporte="descuento_plan_periodo_anio_no_salir.jasper";
                parametrosReporte.put("pPeriodo",new BigDecimal(vParametro1));

                parametrosReporte.put("pCorrelativo",new BigDecimal(vParametro3));
                
                if(vParametro4.equals("TODAS")){
                    parametrosReporte.put("pDependencia","");
                }
                else{
                    parametrosReporte.put("pDependencia"," and p.d3d4="+new BigDecimal(vParametro4));
                }
                                
                vNombreArchivo="pagos_plan_sin.xls";       
            }
            else if(vParametro2.equals("REMESA_GENERAL")){
                pDefReporte="reporte_detalle_remesa_excel.jasper";
                parametrosReporte.put("id_ajuste",new BigDecimal(vParametro1));
                parametrosReporte.put("fechainicio",utils.getFecha(vParametro3));  
                parametrosReporte.put("fechafinal",utils.getFecha(vParametro4)); 
                parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
                vNombreArchivo="detalle_remesa.xls";
            }
            else if(vParametro2.equals("REMESA_GENERAL_AUTO")){
                pDefReporte="reporte_detalle_remesa_auto.jasper";
                vNombreArchivo="detalle_remesa_auto.xls";
                parametrosReporte.put("id_ajuste",new BigDecimal(vParametro1));
                parametrosReporte.put("fechainicio",utils.getFecha(vParametro3));  
                parametrosReporte.put("fechafinal",utils.getFecha(vParametro4)); 
                parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
            } else if (vParametro2.equals("ANULADOS_MES_ACTUAL_AUTO")) { //AUTOFINANCIABLES
                pDefReporte = "reporte_anulados_mes_actual_auto.jasper";
                vNombreArchivo="anulados_mes_actual_auto.xls";
                parametrosReporte.put("id_ajuste", new BigDecimal(vParametro1));
                parametrosReporte.put("fechainicio", vParametro3);
                parametrosReporte.put("fechafinal", vParametro4);
                parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
            } else if (vParametro2.equals("ANULADOS_MESES_ANTERIORES_AUTO")) { //AUTOFINANCIABLES
                pDefReporte = "reporte_anulados_meses_anteriores_auto.jasper";
                vNombreArchivo="anulados_meses_anteriores_auto.xls";
                parametrosReporte.put("id_ajuste", new BigDecimal(vParametro1));
                parametrosReporte.put("fechainicio", vParametro3);
                parametrosReporte.put("fechafinal", vParametro4);
                parametrosReporte.put("pIdRemesa",new BigDecimal(vParametro5));
            } else if (vParametro2.equals("ANULADOS_ANIOS_ANTERIORES_AUTO")) { //AUTOFINANCIABLES
                pDefReporte = "reporte_anulados_anios_anteriores_auto.jasper";
                vNombreArchivo="anulados_anios_anteriores_auto.xls";
                parametrosReporte.put("id_ajuste", new BigDecimal(vParametro1));
                parametrosReporte.put("fechainicio", vParametro3);
                parametrosReporte.put("fechafinal", vParametro4);
                parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
            } else if (vParametro2.equals("PROCCON_CHEQANUL")){
                vNombreArchivo="cheques_anulados.xls";                                                   
                SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");
                Date fecha = null;
                try {         
                    //fecha inicio
                    if(vParametro3!=null && !vParametro3.trim().equals("")){
                        fecha = formatoDelTexto.parse(vParametro3);
                        vParametro3 = formatoDelTexto.format(fecha);
                    }         
                    //fecha fin
                    if(vParametro1!=null && !vParametro1.trim().equals("")){
                        fecha = formatoDelTexto.parse(vParametro1);
                        vParametro1=formatoDelTexto.format(fecha);
                    }
                } catch (ParseException ex) {
                    ex.printStackTrace();
                } 
                pDefReporte="cheques_anulados_concilia.jasper";
                
                parametrosReporte.put("pFecha",vParametro1);
                //parametrosReporte.put("pFechaI",vParametro3);
                parametrosReporte.put("pFechaI",vParametro6);
                parametrosReporte.put("pIdProcesoConciliacion",new BigDecimal(vParametro7));
                  
                if(vParametro5 != null) {
                    parametrosReporte.put("pWhere"," and dep.id_dependencia in ( "+ new BigDecimal(vParametro5)+")");
                }else {
                    parametrosReporte.put("pWhere","");
                }                                                                                        
                
            }else if (vParametro2.equals("PROCCON_CHEQCIR")){
                vNombreArchivo="cheques_circulacion.xls";                                                   
                pDefReporte="circulacion_cheques_concilia.jasper";
                parametrosReporte.put("pFecha",vParametro1);                         
                if(vParametro5 != null) {
                      parametrosReporte.put("pWhere"," and dep.id_dependencia in ( "+ new BigDecimal(vParametro5)+")");
                 }else {
                     parametrosReporte.put("pWhere","");
                }
                
                if(vParametro3 !=null && !vParametro3.equals("")){
                    parametrosReporte.put("pFechaAnul",vParametro3);
                }
                else{
                    parametrosReporte.put("pFechaAnul",vParametro1);
                }
            }else if (vParametro2.equals("REMESA_GENERAL_TEXTO_EXCEL_031")){
                    vNombreArchivo="reporte_det_remesa_excel_031.xls";                                                   
                    pDefReporte="reporte_det_remesa_excel_031.jasper";
                    //System.out.println("Remesa para EXCELvParametro5:= "+vParametro5);
                    parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
            }else if (vParametro2.equals("HIST_SAL_EXCEL")){
                    vNombreArchivo="historial_salarial_excel.xls";                                                   
                    pDefReporte="historial_salarial_excel.jasper";
                    //System.out.println("Remesa para EXCELvParametro5:= "+vParametro5);
                    parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
                    
            }else if (vParametro2.equals("SICOIN_EXCEL")){
                    vNombreArchivo="reporte_sicoin_general.xls";                                                   
                     
                    
                Object varUsuario = "";
                String vTipoReporte = vParametro5.toString();
                vTipoReporte = vTipoReporte.replace(" ","");
                                                     
                varUsuario =  JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                                   "#{roles_usuario.coordinadorDescJud}");
                if (varUsuario.equals(false)) { 
                
                    if (vTipoReporte.equals("GENERAL")){
                        pDefReporte="reporte_sicoin_general.jasper"; 
                    } else if (vTipoReporte.equals("VACACIONES") || vTipoReporte.equals("EXTRAORDINARIO") || vTipoReporte.equals("IGSS") || vTipoReporte.equals("EGRESO981") || vTipoReporte.equals("EGRESO216")){
                        pDefReporte = "reporte_sicoin_otros1.jasper";
                    }else {
                        outstream.write(new String("No se pudo generar el reporte!!").getBytes()); 
                        outstream.close();
                    }
                    
                    parametrosReporte.put("pIdProceso", new BigDecimal(vParametro1));
                    parametrosReporte.put("pUsuario", utils.getUsuario()); 
                    parametrosReporte.put("pTipoReporte", vTipoReporte);
                    
                    
                }
                    
                    
            }else if (vParametro2.equals("SICOINDET_EXCEL")){
                    vNombreArchivo="reporte_sicoin_resumen_"+vParametro1+".xls";                                                   
                     
                    
                Object varUsuario = "";
                String vTipoReporte = vParametro5.toString();
                vTipoReporte = vTipoReporte.replace(" ","");
                                                     
                varUsuario =  JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                                   "#{roles_usuario.coordinadorDescJud}");
                if (varUsuario.equals(false)) { 
                
                    if (vTipoReporte.equals("GENERAL")){
                        pDefReporte = "reporte_sicoin_resumenl.jasper"; 
                    } else if (vTipoReporte.equals("VACACIONES") || vTipoReporte.equals("EXTRAORDINARIO") || vTipoReporte.equals("IGSS") || vTipoReporte.equals("EGRESO981") || vTipoReporte.equals("EGRESO216") ){
                        pDefReporte = "reporte_sicoin_resumenl_otros1.jasper";
                    }else {
                        outstream.write(new String("No se pudo generar el reporte!!").getBytes()); 
                        outstream.close();
                    }
                    
                    parametrosReporte.put("pIdProceso", new BigDecimal(vParametro1));
                    parametrosReporte.put("pUsuario", utils.getUsuario()); 
                    parametrosReporte.put("pTipoReporte", vTipoReporte);
                    
                    
                }
                    
                    
            }else if (vParametro2.equals("SIS25_EXCEL")){
                pDefReporte="sis-25_EXCEL.jasper";
                vNombreArchivo="reporteSIS25_"+vParametro1+".xls";
                
                parametrosReporte.put("IdProceso",new BigDecimal(vParametro1)); 
                   
                    
                    
            }else if (vParametro2.equals("REPPLAZATESO_SICOIN")){
                    vNombreArchivo="reporte_teso_sicoin.xls";                                                   
                    pDefReporte="RepPlazasTeso_SICOIN_excel.jasper";
                    vAnioReporte = new BigDecimal(JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.anioActual").toString());
                    
                    parametrosReporte.put("pAnio",vAnioReporte);
               try    { 
                    if (vParametro3.equals("") && vParametro4.equals("0")){ //Ningun filtro
                        vStatement = conexion.get_Coneccion().prepareStatement(consultasPDF.getConsultaTesoSICOIN(-1));
                        vStatement.setInt(1,vAnioReporte.intValue());
                        vStatement.setInt(2,vAnioReporte.intValue());
                        vStatement.setString(3,utils.getUsuario()); //usuario 
                        
                    }else if ( !vParametro4.equals("0")){
                        vStatement = conexion.get_Coneccion().prepareStatement(consultasPDF.getConsultaTesoSICOIN(4)); 
                        vStatement.setInt(1,vAnioReporte.intValue());
                        vStatement.setInt(2,vAnioReporte.intValue());
                        vStatement.setString(3,utils.getUsuario()); //usuario 
                        vStatement.setString(4,vParametro4); //id_Dependencia
                    }
                    
                         
                    
                } catch (Exception e) {
                    // TODO
                }
            }else if (vParametro2.equals("REPORTEHIST_SAL")){
                    vNombreArchivo="consultaSalarial.xls";                                                   
                    pDefReporte="rep_historial_sal_excel.jasper"; 
                  //  System.out.println(vParametro1);
                    String cond = "1";
                    
                    parametrosReporte.put("cond",new BigDecimal(cond));
                    parametrosReporte.put("pUsuario",vUsuario);
                    
              try    { 
              
                   /* vStatement = conexion.get_Coneccion().prepareStatement(consultasPDF.getConsultaHistSal(4));
                    vStatement.setInt(1,Integer.parseInt(cond)); //cond  
                     vStatement.setString(2,vParametro1);*/
                     
                    if (!vParametro1.equals("")){ //Ningun filtro
                        vStatement = conexion.get_Coneccion().prepareStatement(consultasPDF.getConsultaHistSal(vParametro1));   
                        vStatement.setInt(1,Integer.parseInt(cond)); //cond      
                        vStatement.setString(2,vUsuario); //pUsuario
                        
                    }
                    
                    
                } catch (Exception e) {
                    // TODO
                }
            } else if (vParametro2.equals("DARHSJI2_INDEMNIZACION")) {
                 pDefReporte = "DARHSJI2_indemnizacion_excel.jasper";
                parametrosReporte.put("pRegistroPersonal",  new BigDecimal(vParametro1));
                //parametrosReporte.put("pRegistroPersonal", new BigDecimal("930685"));
                //parametrosReporte.put("pRegistroPersonal", new BigDecimal("19990018"));
                //parametrosReporte.put("pRegistroPersonal", new BigDecimal("20140781"));
                //parametrosReporte.put("pRegistroPersonal", new BigDecimal("20150341"));
                vNombreArchivo = "rel_lab_" + vParametro1 + ".xls";
            }
            
            try {
            
                if (vStatement!=null && vStatement.execute()){
                    vResultSetDataSource = new JRResultSetDataSource(vStatement.getResultSet());  
                    vReporteListo   = JasperFillManager.fillReport(vStr_directorioRep+pDefReporte,parametrosReporte,vResultSetDataSource);
                    vRepExcel= new JExcelApiExporter();
                    vRepExcel.setParameter(JExcelApiExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS,true);
                    vRepExcel.setParameter(JExcelApiExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,true);
                    vRepExcel.setParameter(JExcelApiExporterParameter.IS_WHITE_PAGE_BACKGROUND,false);
                    vRepExcel.setParameter(JExcelApiExporterParameter.JASPER_PRINT,vReporteListo);
                    vRepExcel.setParameter(JExcelApiExporterParameter.OUTPUT_STREAM,outstream);
                    vRepExcel.setParameter(JExcelApiExporterParameter.IS_DETECT_CELL_TYPE,true);
                    vRepExcel.setParameter(JExcelApiExporterParameter.IS_DETECT_CELL_TYPE,true);          
                    
                    vNumeroPaginasReporte=vReporteListo.getPages().size();
                    
                    if (vNumeroPaginasReporte>0){
                            response.setContentType(CONTENT_XLS);
                            response.setHeader ("Content-Disposition", "attachment;filename=\"" + vNombreArchivo + "\""); 
                            vRepExcel.exportReport();
                    }else {       
                            response.setContentType(CONTENT_HTML);
                            outstream.write(new String("<b>El reporte no tiene datos</b>").getBytes());               
                     }
                                 
                
                }else{
            
                    vReporteListo   = JasperFillManager.fillReport(vStr_directorioRep+pDefReporte,parametrosReporte,conexion.get_Coneccion());
           
                    vRepExcel= new JExcelApiExporter();
                    vRepExcel.setParameter(JExcelApiExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS,true);
                    vRepExcel.setParameter(JExcelApiExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,true);
                    vRepExcel.setParameter(JExcelApiExporterParameter.IS_WHITE_PAGE_BACKGROUND,false);
                    vRepExcel.setParameter(JExcelApiExporterParameter.JASPER_PRINT,vReporteListo);
                    vRepExcel.setParameter(JExcelApiExporterParameter.OUTPUT_STREAM,outstream);
                    vRepExcel.setParameter(JExcelApiExporterParameter.IS_DETECT_CELL_TYPE,true);
                    vRepExcel.setParameter(JExcelApiExporterParameter.IS_DETECT_CELL_TYPE,true);            
                                        
                    vNumeroPaginasReporte=vReporteListo.getPages().size();
                      
                    if (vNumeroPaginasReporte>0)
                    {
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
            //vRepExcel.reset();
             

            } catch (Exception ex) {
            ex.printStackTrace();
            outstream.write(new String("No se pudo generar el reporte!!").getBytes());
            outstream.close();   
            conexion.cn_Cerrar_coneccion();
                                }

        }else {
            outstream.write(new String("No se pudo generar el reporte!!").getBytes()); 
            outstream.close();
        }
                      }
}
