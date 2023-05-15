package interfaz_usuario.servlets;

import interfaz_usuario.util.utils;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRTextExporter;
import net.sf.jasperreports.engine.export.JRTextExporterParameter;

import pkg_util_base_datos.interfaz_DB;

public class verReportTexto extends HttpServlet {
    private static final String CONTENT_HTML = "text/html; charset=windows-1252";
    

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request, 
                      HttpServletResponse response) throws ServletException, IOException 
   {
                      
        Map parametrosReporte = new HashMap();
        ServletOutputStream outstream;
        int vCharHeight,vCharWidth;
        String vStr_directorioRep,pDefReporte;
        interfaz_DB conexion = new interfaz_DB();
        JRTextExporter rt=new JRTextExporter();                      
        String vParametro1,vParametro2,vParametro3,vParametro4,vParametro5,vNombreArch, nuevaLinea;
        
        vStr_directorioRep=request.getSession().getServletContext().getInitParameter("DIRECTORIO_REPORTES");
        parametrosReporte.put("SUBREPORT_DIR",vStr_directorioRep);
        parametrosReporte.put("REPORT_LOCALE",new java.util.Locale("es","GT"));
                      
        /*   VALORES POR DEFECTO  */
        vCharHeight=9;
        vCharWidth=6;   
        nuevaLinea=new String(new char[]{12}); //cambio planilla igss
        pDefReporte="";
        vNombreArch="rep.txt";
        outstream = response.getOutputStream();              
        vParametro1=request.getParameter("id");
        vParametro2=request.getParameter("rep");     
        vParametro3=request.getParameter("var1");     
        vParametro4=request.getParameter("var2");     
        vParametro5=request.getParameter("id2");
        
        //System.out.println("es "+ vParametro2.trim());
                      
        try {
            if (vParametro1!=null&&vParametro2!=null){
                if (vParametro2.equals("REPPAGOISR")){
                    pDefReporte="boleta_pago_isr.jasper";
                    parametrosReporte.put("ANIO",new BigDecimal(vParametro1));  
                    vNombreArch="boletaPagoISR.txt";
                     if (vParametro3!=null && vParametro4!=null){
                         vCharWidth=utils.getInteger(vParametro3);
                         vCharHeight=utils.getInteger(vParametro4);
                     }
                }else if (vParametro2.equals("EMISION_DOC_PAGO")){
                    parametrosReporte.put("pIdProceso",new BigDecimal(vParametro1));
                    parametrosReporte.put("pIdTipoDocumento",new BigDecimal(vParametro5));                                       
                    pDefReporte="emision_de_docs_pago.jasper";
                    vCharHeight=9;
                    vCharWidth=5;   
                    vNombreArch="emision_pago.txt";
                }else if (vParametro2.equals("EMISION_DOC_PAGO_ISR")){
                     parametrosReporte.put("pIdProceso",new BigDecimal(vParametro1));
                     parametrosReporte.put("pIdTipoDocumento",new BigDecimal(vParametro5));                                       
                     pDefReporte="emision_de_docs_pago_isr.jasper";
                     vCharHeight=9;
                     vCharWidth=5;   
                     vNombreArch="emision_pago_isr.txt";
                }else if (vParametro2.equals("POLIZATEX")){
                    parametrosReporte.put("pId_proceso",new BigDecimal(vParametro1.trim()));                    
                    pDefReporte="Poliza_impre.jasper";
                    vCharHeight=9;
                    vCharWidth=5;   
                    vNombreArch="pol_"+vParametro1+".txt";
                }else if (vParametro2.equals("REVCHEQUE")){
                     parametrosReporte.put("pIdProceso",new BigDecimal(vParametro1.trim()));                    
                     pDefReporte="revision_cheques.jasper";
                     vCharHeight=9;
                     vCharWidth=5;   
                     vNombreArch="rev_cheque"+vParametro1+".txt";
                }else if (vParametro2.equals("RES_EMISION")){
                     parametrosReporte.put("pIdProceso",new BigDecimal(vParametro1.trim()));                    
                     parametrosReporte.put("pIdTipoDocumento",new BigDecimal(vParametro5.trim()));                    
                     pDefReporte="resumen_emision_pago_alone.jasper";
                     vCharHeight=9;
                     vCharWidth=5;   
                     vNombreArch="res_emision"+vParametro5.trim()+"_ "+vParametro1+".txt";
                }else if (vParametro2.equals("NOMPRUEBAX")){
                     parametrosReporte.put("pIdProceso",new BigDecimal(vParametro1.trim()));                                                        
                     pDefReporte="nomina_sueldos_pg4.jasper";
                     if (vParametro5==null ||(vParametro5!=null && vParametro5.toString().equals("1"))){
                         vCharHeight=11;
                         vCharWidth=3;   
                     }else if (vParametro5!=null && vParametro5.toString().equals("2")){
                        vCharHeight=11;
                        vCharWidth=6;   
                     }else if (vParametro5!=null && vParametro5.toString().equals("3")){
                         vCharHeight=9;
                         vCharWidth=5;   
                     }
                     vNombreArch="nom."+"txt";
                }else if(vParametro2.equals("REMESA_GENERAL_TEXTO")){
                    vCharHeight=11;
                    vCharWidth=8;   
                    pDefReporte="reporte_detalle_remesa_texto.jasper";
                    if(vParametro1.compareToIgnoreCase("-1") != 0){
                        //System.out.println("vParametro1 es diferente de null texto");
                        parametrosReporte.put("id_ajuste",new BigDecimal(vParametro1));
                        vNombreArch="rem_detalle"+".txt";
                    }else{
                        parametrosReporte.put("id_ajuste",null);
                        vNombreArch="rem_general"+".txt";
                    }
                   parametrosReporte.put("fechainicio",utils.getFecha(vParametro3));  
                   parametrosReporte.put("fechafinal",utils.getFecha(vParametro4));      
                   parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
                }else if(vParametro2.equals("REMESA_GENERAL_TEXTO_C")){
                    vCharHeight=11;
                    vCharWidth=8;   
                    pDefReporte="detalle_remesa_texto_complementaria.jasper";
                    // pDefReporte="reporte_detalle_remesa_texto.jasper";
                    if(vParametro1.compareToIgnoreCase("-1") != 0){
                        //System.out.println("vParametro1 es diferente de null texto");
                        parametrosReporte.put("id_ajuste",new BigDecimal(vParametro1));
                        vNombreArch="rem_"+vParametro5.trim()+"_complemen"+".txt";
                    }else{
                        parametrosReporte.put("id_ajuste",null);
                        vNombreArch="rem_"+vParametro5.trim()+ "_general"+".txt";
                    }
                   parametrosReporte.put("fechainicio",utils.getFecha(vParametro3));  
                   parametrosReporte.put("fechafinal",utils.getFecha(vParametro4));      
                   parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
                }else if(vParametro2.equals("ANUL_MES_ACTUAL")){
                    vCharHeight=11;
                    vCharWidth=8;   
                    pDefReporte="reporte_anulados_mes_actual_texto.jasper";
                    vNombreArch="anul_mes_actual"+".txt";
                    
                   parametrosReporte.put("fechainicio",vParametro3);  
                   parametrosReporte.put("fechafinal",vParametro4);   
                   parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
                }else if(vParametro2.equals("ANUL_MES_ACTUAL_C")){
                    vCharHeight=11;
                    vCharWidth=8;   
                    pDefReporte="complemen_anulados_mes_actual_texto.jasper";
                    vNombreArch="comple_"+vParametro5.trim()+"_anul_mes_actual"+".txt";
                    
                   parametrosReporte.put("fechainicio",vParametro3);  
                   parametrosReporte.put("fechafinal",vParametro4);   
                   parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
                }else if(vParametro2.equals("ANUL_MES_ANT")){
                    vCharHeight=11;
                    vCharWidth=8;   
                    pDefReporte="reporte_anulados_meses_anterior_texto.jasper";
                    vNombreArch="anul_mes_ant"+".txt";
                    
                   parametrosReporte.put("fechainicio",vParametro3);  
                   parametrosReporte.put("fechafinal",vParametro4);     
                   parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
                }else if(vParametro2.equals("ANUL_MES_ANT_C")){
                    vCharHeight=11;
                    vCharWidth=8;   
                    pDefReporte="reporte_anulados_meses_anterior_texto.jasper";
                    vNombreArch="anul_mes_ant"+".txt";
                    
                   parametrosReporte.put("fechainicio",vParametro3);  
                   parametrosReporte.put("fechafinal",vParametro4);     
                   parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
                }else if(vParametro2.equals("ANUL_ANIO_ANT")){
                    vCharHeight=11;
                    vCharWidth=8;   
                    pDefReporte="reporte_anulados_anio_anterior_texto.jasper";
                    vNombreArch="anul_anio_ant"+".txt";
                    
                   parametrosReporte.put("fechainicio",vParametro3);  
                   parametrosReporte.put("fechafinal",vParametro4);  
                   parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
                }else if(vParametro2.equals("ANUL_ANIO_ANT_C")){
                    vCharHeight=11;
                    vCharWidth=8;   
                    pDefReporte="reporte_anulados_anio_anterior_texto.jasper";
                    vNombreArch="anul_anio_ant"+".txt";
                    
                   parametrosReporte.put("fechainicio",vParametro3);  
                   parametrosReporte.put("fechafinal",vParametro4);  
                   parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
                }else if(vParametro2.equals("POLIZA_REMESA")){
                    vCharHeight=11;
                    vCharWidth=8;   
                    pDefReporte="PolizaREMESA_texto.jasper";
                    vNombreArch="poliza_remesa"+".txt";
                    parametrosReporte.put("fechainicial",utils.getFecha(vParametro3));  
                    parametrosReporte.put("fechafinal",utils.getFecha(vParametro4));    
                    parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
                }else if(vParametro2.equals("DOCUMENTOS_ANULADOS_MAC")){
                    vCharHeight=11;
                    vCharWidth=8;   
                    pDefReporte="cheques_anulados_conta_texto.jasper";
                    vNombreArch="cheques_anulados_conta_mes_act"+".txt";
                    parametrosReporte.put("fechainicio",vParametro3);  
                    parametrosReporte.put("fechafinal",vParametro4);
                    parametrosReporte.put("p_periodo","MAC");
                    parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
                }else if(vParametro2.equals("DOCUMENTOS_ANULADOS_MAN")){
                    vCharHeight=11;
                    vCharWidth=8;   
                    pDefReporte="cheques_anulados_conta_texto.jasper";
                    vNombreArch="cheques_anulados_conta_mes_ant"+".txt";
                    parametrosReporte.put("fechainicio",vParametro3);  
                    parametrosReporte.put("fechafinal",vParametro4);
                    parametrosReporte.put("p_periodo","MAN");
                    parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
                }else if(vParametro2.equals("DOCUMENTOS_ANULADOS_AA")){
                    vCharHeight=11;
                    vCharWidth=8;   
                    pDefReporte="cheques_anulados_conta_texto.jasper";
                    vNombreArch="cheques_anulados_conta_anio_ant"+".txt";
                    parametrosReporte.put("fechainicio",vParametro3);  
                    parametrosReporte.put("fechafinal",vParametro4);                   
                    parametrosReporte.put("p_periodo","AA");
                    parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
                }else if(vParametro2.equals("DOCUMENTOS_ANULADOS_PARTIDA_MAC")){
                    vCharHeight=11;
                    vCharWidth=8;   
                    pDefReporte="cheques_anulados_conta2_texto.jasper";
                    vNombreArch="cheques_anulados_conta_part_mes_act"+".txt";
                    parametrosReporte.put("fechainicio",vParametro3);  
                    parametrosReporte.put("fechafinal",vParametro4);                   
                    parametrosReporte.put("p_periodo","MAC");
                    parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
                }else if(vParametro2.equals("DOCUMENTOS_ANULADOS_PARTIDA_MAN")){
                    vCharHeight=11;
                    vCharWidth=8;   
                    pDefReporte="cheques_anulados_conta2_texto.jasper";
                    vNombreArch="cheques_anulados_conta_part_mes_ant"+".txt";
                    parametrosReporte.put("fechainicio",vParametro3);  
                    parametrosReporte.put("fechafinal",vParametro4);                   
                    parametrosReporte.put("p_periodo","MAN");
                    parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
                }else if(vParametro2.equals("DOCUMENTOS_ANULADOS_PARTIDA_AA")){
                    vCharHeight=11;
                    vCharWidth=8;   
                    pDefReporte="cheques_anulados_conta2_texto.jasper";
                    vNombreArch="cheques_anulados_conta_part_anio_ant"+".txt";
                    parametrosReporte.put("fechainicio",vParametro3);  
                    parametrosReporte.put("fechafinal",vParametro4);                   
                    parametrosReporte.put("p_periodo","AA");
                    parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
                }else if(vParametro2.equals("POLIZA_CH_NULOS_MAC")){
                    vCharHeight=11;
                    vCharWidth=8;   
                    pDefReporte="PolizaANULADOS_texto.jasper";
                    vNombreArch="poliza_ch_anulados_mes_act"+".txt";
                    parametrosReporte.put("fechainicio",vParametro3);  
                    parametrosReporte.put("fechafinal",vParametro4);                   
                    parametrosReporte.put("p_periodo","MAC");
                    parametrosReporte.put("pTipoDocumento","CHEQUE");
                    parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
                }else if(vParametro2.equals("POLIZA_CH_NULOS_MAN")){
                    vCharHeight=11;
                    vCharWidth=8;   
                    pDefReporte="PolizaANULADOS_texto.jasper";
                    vNombreArch="poliza_ch_anulados_mes_ant"+".txt";
                    parametrosReporte.put("fechainicio",vParametro3);  
                    parametrosReporte.put("fechafinal",vParametro4);                   
                    parametrosReporte.put("p_periodo","MAN");
                    parametrosReporte.put("pTipoDocumento","CHEQUE");
                    parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
                }else if(vParametro2.equals("POLIZA_CH_NULOS_AA")){
                    vCharHeight=11;
                    vCharWidth=8;   
                    pDefReporte="PolizaANULADOS_texto.jasper";
                    vNombreArch="poliza_ch_anulados_anio_ant"+".txt";
                    parametrosReporte.put("fechainicio",vParametro3);  
                    parametrosReporte.put("fechafinal",vParametro4);                   
                    parametrosReporte.put("p_periodo","AA");
                    parametrosReporte.put("pTipoDocumento","CHEQUE");
                    parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
                }else if(vParametro2.equals("POLIZA_BOL_NULOS_MAC")){
                    vCharHeight=11;
                    vCharWidth=8;   
                    pDefReporte="PolizaANULADOS_texto.jasper";
                    vNombreArch="poliza_bol_anulados_mes_act"+".txt";
                    parametrosReporte.put("fechainicio",vParametro3);  
                    parametrosReporte.put("fechafinal",vParametro4);                   
                    parametrosReporte.put("p_periodo","MAC");
                    parametrosReporte.put("pTipoDocumento","ACREDITACION");
                    parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
                }else if(vParametro2.equals("POLIZA_BOL_NULOS_MAN")){
                    vCharHeight=11;
                    vCharWidth=8;   
                    pDefReporte="PolizaANULADOS_texto.jasper";
                    vNombreArch="poliza_bol_anulados_mes_ant"+".txt";
                    parametrosReporte.put("fechainicio",vParametro3);  
                    parametrosReporte.put("fechafinal",vParametro4);                   
                    parametrosReporte.put("p_periodo","MAN");
                    parametrosReporte.put("pTipoDocumento","ACREDITACION");
                    parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
                }else if(vParametro2.equals("POLIZA_BOL_NULOS_AA")){
                    vCharHeight=11;
                    vCharWidth=8;   
                    pDefReporte="PolizaANULADOS_texto.jasper";
                    vNombreArch="poliza_bol_anulados_anio_ant"+".txt";
                    parametrosReporte.put("fechainicio",vParametro3);  
                    parametrosReporte.put("fechafinal",vParametro4);                   
                    parametrosReporte.put("p_periodo","AA");
                    parametrosReporte.put("pTipoDocumento","ACREDITACION");
                    parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
                }else if(vParametro2.equals("POLIZA_BONO_CH_NULOS_MAC")){
                    vCharHeight=11;
                    vCharWidth=8;   
                    pDefReporte="PolizaBonoANULADOS_texto.jasper";
                    vNombreArch="poliza_bono_ch_anulados_mes_act"+".txt";
                    parametrosReporte.put("fechainicio",vParametro3);  
                    parametrosReporte.put("fechafinal",vParametro4);                   
                    parametrosReporte.put("p_periodo","MAC");
                    parametrosReporte.put("pTipoDocumento","CHEQUE");
                    parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
                }else if(vParametro2.equals("POLIZA_BONO_CH_NULOS_MAN")){
                    vCharHeight=11;
                    vCharWidth=8;   
                    pDefReporte="PolizaBonoANULADOS_texto.jasper";
                    vNombreArch="poliza_bono_ch_anulados_mes_ant"+".txt";
                    parametrosReporte.put("fechainicio",vParametro3);  
                    parametrosReporte.put("fechafinal",vParametro4);                   
                    parametrosReporte.put("p_periodo","MAN");
                    parametrosReporte.put("pTipoDocumento","CHEQUE");
                    parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
                }else if(vParametro2.equals("POLIZA_BONO_CH_NULOS_AA")){
                    vCharHeight=11;
                    vCharWidth=8;   
                    pDefReporte="PolizaBonoANULADOS_texto.jasper";
                    vNombreArch="poliza_bono_ch_anulados_anio_ant"+".txt";
                    parametrosReporte.put("fechainicio",vParametro3);  
                    parametrosReporte.put("fechafinal",vParametro4);                   
                    parametrosReporte.put("p_periodo","AA");
                    parametrosReporte.put("pTipoDocumento","CHEQUE");
                    parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
                }else if(vParametro2.equals("POLIZA_BONO_BOL_NULOS_MAC")){
                    vCharHeight=11;
                    vCharWidth=8;   
                    pDefReporte="PolizaBonoANULADOS_texto.jasper";
                    vNombreArch="poliza_bono_bol_anulados_mes_act"+".txt";
                    parametrosReporte.put("fechainicio",vParametro3);  
                    parametrosReporte.put("fechafinal",vParametro4);                   
                    parametrosReporte.put("p_periodo","MAC");
                    parametrosReporte.put("pTipoDocumento","ACREDITACION");
                    parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
                }else if(vParametro2.equals("POLIZA_BONO_BOL_NULOS_MAN")){
                    vCharHeight=11;
                    vCharWidth=8;   
                    pDefReporte="PolizaBonoANULADOS_texto.jasper";
                    vNombreArch="poliza_bono_bol_anulados_mes_ant"+".txt";
                    parametrosReporte.put("fechainicio",vParametro3);  
                    parametrosReporte.put("fechafinal",vParametro4);                   
                    parametrosReporte.put("p_periodo","MAN");
                    parametrosReporte.put("pTipoDocumento","ACREDITACION");
                    parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
                }else if(vParametro2.equals("POLIZA_BONO_BOL_NULOS_AA")){
                    vCharHeight=11;
                    vCharWidth=8;   
                    pDefReporte="PolizaBonoANULADOS_texto.jasper";
                    vNombreArch="poliza_bono_bol_anulados_anio_ant"+".txt";
                    parametrosReporte.put("fechainicio",vParametro3);  
                    parametrosReporte.put("fechafinal",vParametro4);                   
                    parametrosReporte.put("p_periodo","AA");
                    parametrosReporte.put("pTipoDocumento","ACREDITACION");
                    parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
                }else if(vParametro2.equals("REMESA_DETALLE_TEXTO_41")){
                    vCharHeight=11;
                    vCharWidth=8;   
                    pDefReporte="reporte_detalle_remesa_texto_41_45.jasper";
                    vNombreArch="REMESA_41"+".txt";
                    parametrosReporte.put("fechainicio",utils.getFecha(vParametro3));  
                    parametrosReporte.put("fechafinal",utils.getFecha(vParametro4)); 
                    parametrosReporte.put("id_ajuste",new BigDecimal(vParametro1));
                    parametrosReporte.put("partida_filtrada","41"); 
                    parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
                }else if(vParametro2.equals("REMESA_DETALLE_TEXTO_45")){
                    vCharHeight=11;
                    vCharWidth=8;   
                    pDefReporte="reporte_detalle_remesa_texto_41_45.jasper";
                    vNombreArch="REMESA_45"+".txt";
                    parametrosReporte.put("fechainicio",utils.getFecha(vParametro3));  
                    parametrosReporte.put("fechafinal",utils.getFecha(vParametro4)); 
                    parametrosReporte.put("id_ajuste",new BigDecimal(vParametro1));
                    parametrosReporte.put("partida_filtrada","45"); 
                    parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
                }else if(vParametro2.equals("ENTR_PAPELNOMINA_AUDI")){
                    vCharHeight=9;
                    vCharWidth=5;   
                    pDefReporte="entrega_papel_nomina_auditoria.jasper";
                    vNombreArch="papel_nomina_auditoria"+".txt";
                    parametrosReporte.put("pIdProceso",new BigDecimal(vParametro1));
                    parametrosReporte.put("pIdTipoDocumento",new BigDecimal(vParametro5));                                       
                }else if(vParametro2.equals("GASTOS_DE_REPRESENTACION") || vParametro2.equals("VIATICOS") || vParametro2.equals("HONORARIOS") || vParametro2.equals("BONO_INCENTIVO")){
                    vCharHeight=11;
                    //vCharWidth=8;  
                    pDefReporte="otras_rentas_remesa_texto.jasper";
                    parametrosReporte.put("ID_REMESA",new Integer(vParametro5));
                    parametrosReporte.put("TIPO_RENTA",vParametro2);
                }//cambio planilla igss
                else if(vParametro2.equals("PLANILLA_IGSS")){
                    vCharHeight=22;
                    vCharWidth=4;
                    nuevaLinea="";
                    pDefReporte="reporte_igss_empleados.jasper";
                    parametrosReporte.put("pPeriodo",new BigDecimal(vParametro5));
                    parametrosReporte.put("pRemesa",new BigDecimal(vParametro1));
                    parametrosReporte.put("pFechaInicioPeriodo",vParametro3);
                    parametrosReporte.put("pFechaFinPeriodo",vParametro4);
                }//fin cambio planilla igss
                 //Reporte de la remesa de la planilla electronica
                 else if(vParametro2.equals("REMESA_PLANILLA_IGSS")){
                     vCharHeight=11;
                     vCharWidth=8;
                     //pDefReporte="remesa_planilla_igss_texto.jasper";
                     pDefReporte="remesa_planilla_igss_mes_actual_texto.jasper";
                     parametrosReporte.put("pPeriodo",new BigDecimal(vParametro5));
                     parametrosReporte.put("pIdRemesa",new BigDecimal(vParametro1));
                     parametrosReporte.put("pFechaInicioPeriodo",vParametro3);
                     parametrosReporte.put("pFechaFinPeriodo",vParametro4);
                }else if(vParametro2.equals("PLANILLA_COMP_IGSS")){
                    vCharHeight=22;
                    vCharWidth=4;
                    nuevaLinea="";
                    pDefReporte="reporte_igss_empleados_comp.jasper";                    
                    parametrosReporte.put("pRemesaActual",new BigDecimal(vParametro1));
                    parametrosReporte.put("pRemesa",new BigDecimal(vParametro3));
                    vNombreArch="complementaria_"+vParametro4+"_rem_"+vParametro1+".txt";
                }else if(vParametro2.equals("REMESA_PLANILLA_IGSS_COMP")){
                    vCharHeight=11;
                    vCharWidth=8;
                    pDefReporte="remesa_planilla_igss_complementaria_texto.jasper";
                    parametrosReporte.put("pIdRemesaActual",new BigDecimal(vParametro1));                    
                    parametrosReporte.put("pIdRemesa",new BigDecimal(vParametro3));
                    vNombreArch="remesa_complementaria_"+vParametro4+"_rem_"+vParametro1+".txt";
                }else if(vParametro2.equals("REMESA_GENERAL_TEXTO_031")){
                    vCharHeight=11;
                    vCharWidth=8;   
                    pDefReporte="reporte_detalle_remesa_texto_031.jasper";
                    vNombreArch="rem_general_031"+".txt";
                    //System.out.println("Mi reporte:="+vNombreArch);
                    /*if(vParametro1.compareToIgnoreCase("-1") != 0){
                        //System.out.println("vParametro1 es diferente de null texto");
                        parametrosReporte.put("id_ajuste",new BigDecimal(vParametro1));
                        
                        vNombreArch="rem_detalle"+".txt";
                    }else{
                        parametrosReporte.put("id_ajuste",null);
                        vNombreArch="rem_general"+".txt";
                    }*/
                   //parametrosReporte.put("fechainicio",utils.getFecha(vParametro3));  
                   //parametrosReporte.put("fechafinal",utils.getFecha(vParametro4));  
                   //System.out.println("pIdRemesa:="+vParametro5);
                   parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
                }
                JasperPrint reporteListo = JasperFillManager.fillReport(vStr_directorioRep+pDefReporte,parametrosReporte,conexion.get_Coneccion());
                rt.setParameter(JRTextExporterParameter.CHARACTER_HEIGHT,vCharHeight); 
                rt.setParameter(JRTextExporterParameter.CHARACTER_ENCODING,"CP1252"); 
                rt.setParameter(JRTextExporterParameter.CHARACTER_WIDTH,vCharWidth);
                rt.setParameter(JRTextExporterParameter.BETWEEN_PAGES_TEXT,nuevaLinea); //cambio planilla igss
                rt.setParameter(JRTextExporterParameter.LINE_SEPARATOR,new String(new char[]{13,10}));             
                rt.setParameter(JRTextExporterParameter.JASPER_PRINT,reporteListo);         
                rt.setParameter(JRTextExporterParameter.OUTPUT_STREAM,outstream);
                                
                if(reporteListo.getPages().size()>0){
                    response.setContentType(CONTENT_HTML);
                    response.setHeader ("Content-Disposition", "attachment;filename=\"" + vNombreArch + "\""); 
                    rt.exportReport();
                   // r=true;    
                }else {
                response.setContentType(CONTENT_HTML);
                    outstream.write(new String("<b>El reporte no tiene datos</b>").getBytes());
                }
            rt.reset();
            conexion.cn_Cerrar_coneccion();
            outstream.close();
            }
            else 
            {
              conexion.cn_Cerrar_coneccion();  
              outstream.write(new String("No existe el reporte!.").getBytes()); 
              outstream.close();
            }
            
        } catch (Exception ex) {
           // vError=ex.getMessage();
            ex.printStackTrace();
            conexion.cn_Cerrar_coneccion();
            //outstream.write(new String("No se pudo generar el reporte!! "+ex.getMessage()).getBytes());
            outstream.write(new String("No se pudo generar el reporte!!").getBytes());
            outstream.close();
            
        }
    }
}
