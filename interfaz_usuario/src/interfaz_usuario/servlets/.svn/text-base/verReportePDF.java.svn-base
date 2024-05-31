package interfaz_usuario.servlets;

import interfaz_usuario.backing.gestiones.ficha_empleado_censo;

import interfaz_usuario.util.JSFUtils;
import interfaz_usuario.util.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import java.math.BigDecimal;

import java.sql.CallableStatement;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.faces.context.FacesContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;
import net.sf.jasperreports.engine.query.JRXPathQueryExecuterFactory;
import net.sf.jasperreports.engine.util.JRXmlUtils;

import org.w3c.dom.Document;

import pkg_util_base_datos.interfaz_DB;


public class verReportePDF extends HttpServlet {
    private static final String CONTENT_HTML = 
        "text/html; charset=windows-1252";
    private static final String CONTENT_PDF = "application/pdf";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public Document getXml(String vDoc) {
        Document vDocument;
        try {


            vDocument = 
                    JRXmlUtils.parse(new ByteArrayInputStream(vDoc.getBytes("CP1252")));


            /*
           DOMImplementationLS domImplLS = (DOMImplementationLS) vDocument
               .getImplementation();
           LSSerializer serializer = domImplLS.createLSSerializer();
           String str = serializer.writeToString(vDocument);

          System.out.println("consulta:\n"+vDoc);
          System.out.println("XML:\n"+str);
        */
        } catch (Exception exep) {
            vDocument = null;
        }
        return vDocument;
    }

    public void doGet(HttpServletRequest request, 
                      HttpServletResponse response) throws ServletException, 
                                                           IOException {

        String vParametro1, vParametro2, vStr_directorioRep, pDefReporte, vParametro3, vParametro4, vParametro5, vParametro6, vParametro7, vParametro8, vParametro9;
        String vMargenSuperior, vMargenIzquierdo, vAnio, vOrden, vGestionRever;
        String vAnio2;
        String vTipoVisual = "inline";
        String vMensaje = 
            ""; //variable para mostrar el error en pantalla si lo hay.

        vParametro1 = request.getParameter("id");
        vParametro3 = request.getParameter("inicio");
        vParametro2 = request.getParameter("rep");
        vParametro4 = request.getParameter("final");
        vParametro5 = request.getParameter("id2");
        vParametro6 = request.getParameter("anio");
        vParametro7 = request.getParameter("idproceso1");
        vParametro8 = request.getParameter("idproceso2");
        vParametro9 = request.getParameter("usuario");
        vMargenSuperior = request.getParameter("topM");
        vMargenIzquierdo = request.getParameter("leftM");
        interfaz_DB conexion = new interfaz_DB();
        JasperPrint vReporteListo;
        Map parametrosReporte = new HashMap();
        ServletOutputStream outstream;
        int vNumeroPaginasReporte;
        Object vValorSession, vDeclara;
        boolean vXmlSource = false, vGenerarReporte = true;
        Document vXMLData;

        vStr_directorioRep = 
                request.getSession().getServletContext().getInitParameter("DIRECTORIO_REPORTES");
        parametrosReporte.put("SUBREPORT_DIR", vStr_directorioRep);
        parametrosReporte.put("REPORT_LOCALE", 
                              new java.util.Locale("es", "GT"));
        pDefReporte = "";

        //   response.setBufferSize(8192);

        //request.set
        outstream = response.getOutputStream();

        vAnio2 = 
                JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(), "flujo_usuario.anioActual").toString();

        vAnio2 = (vAnio2 == null ? utils.getAnioActual() : vAnio2);

        if (vParametro1 != null && vParametro2 != null) {
            if (vParametro2.equals("POLIZA")) {
                pDefReporte = "Poliza.jasper";
                parametrosReporte.put("pId_proceso", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("ISR_PROYECTADO")) {
                pDefReporte = "reporte_isr.jasper";
                parametrosReporte.put("pPeriodo", new BigDecimal(vParametro1));
                parametrosReporte.put("pAnio", new BigDecimal(vParametro5));
            } else if (vParametro2.equals("DECJURADPAT")) {
                if (Integer.parseInt(vParametro1) < 2013) {
                    pDefReporte = "catsat1101.jasper";
                } else {
                    pDefReporte = "catsat1101_2013.jasper";
                }

                parametrosReporte.put("pRegistroEmpleado", 
                                      new BigDecimal(JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(), 
                                                                                  "flujo_usuario.selRegEmpleado_login").toString()));
                parametrosReporte.put("pAnio", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("DECJURADPAT2")) {
                if (Integer.parseInt(vParametro1) < 2013) {
                    pDefReporte = "catsat1101.jasper";
                } else {
                    pDefReporte = "catsat1101_2013.jasper";
                }

                parametrosReporte.put("pRegistroEmpleado", new BigDecimal(vParametro5));
                parametrosReporte.put("pAnio", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("DETDESCNOMINA")) {
                pDefReporte = "total_descuento_xdep.jasper";
                parametrosReporte.put("id_proceso", new Integer(vParametro1));
            } else if (vParametro2.equals("SIS-24")) {
                pDefReporte = "SIS-24.jasper";
                parametrosReporte.put("IdProceso", new BigDecimal(vParametro1));
                parametrosReporte.put("pUsuario", utils.getUsuario());
            } else if (vParametro2.equals("SIS-25")) {
                pDefReporte = "sis-25.jasper";
                parametrosReporte.put("IdProceso", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("SIS-25R")) {
                pDefReporte = "sis25Reinstalacion.jasper";
                parametrosReporte.put("IdProceso", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("report_judiciales")) {
                pDefReporte = "report_descuendo_judicial.jasper";
                parametrosReporte.put("varSolicitud", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("NOMBRAMIENTO")) {
                pDefReporte = "nombramientos.jasper";
                parametrosReporte.put("contrato", vParametro1.toString());
            } else if (vParametro2.equals("NOMBRAMIENTO_FECHA")) {
                String strfecha = vParametro5.toString();
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

                try {
                    Date dateLimite = df.parse("2011-12-31");
                    Date startDate = df.parse(strfecha);

                    if (startDate.after(dateLimite)) {
                        pDefReporte = "nombramientos.jasper";
                    } else {
                        String vConsulta = 
                            "select count (0) as valor from sis_contrato c\n" + 
                            "inner join sis_autorizacion A on A.id_Contrato = c.id_contrato\n" + 
                            "inner join sis_autorizacion_det ad on ad.id_autorizacion = a.id_autorizacion and id_estado = 4\n" + 
                            "where c.id_contrato = " + vParametro1.toString();
                        int valor = 
                            Integer.parseInt(this.getValorConsulta(vConsulta, "valor").toString());
                        if (valor == 0) {
                            pDefReporte = "nombramientos_fichafisica.jasper";
                        } else {
                            pDefReporte = "nombramientos.jasper";
                        }
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                parametrosReporte.put("contrato", vParametro1.toString());
            } else if (vParametro2.equals("REPORTE_LIQUIDACION_NOMINA")) {
                pDefReporte = "reporte_liquidacion_nomina.jasper";
                parametrosReporte.put("id_liquidacion", new Integer(vParametro1));
            } else if (vParametro2.equals("APERTURAGEN")) {
                pDefReporte = "RepGeneralApertura.jasper";
                parametrosReporte.put("pIdCarga", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("PLAZASTESO")) {
                pDefReporte = "RepPlazasTesorero.jasper";
                parametrosReporte.put("pUsuario", vParametro1);
                parametrosReporte.put("pAnio", 
                                      new Integer(JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(), 
                                                                               "flujo_usuario.anioActual").toString()));
            } else if (vParametro2.equals("ANEXOA")) {
                parametrosReporte.put("varAnexo", new BigDecimal(vParametro1)); 
                String vConsulta = 
                    "select extract (year from fecha_creacion)  anio from sis_anexo where id_anexo = " + vParametro1.toString(); 
                int anio = Integer.parseInt(this.getValorConsulta(vConsulta, "anio").toString());
                if (anio < 2022) { 
                    pDefReporte = "AnexoA.jasper";
                } else {
                    pDefReporte = "AnexoA2.jasper";   
                }
                
            } else if (vParametro2.equals("ANEXOPROMO")) {
                parametrosReporte.put("varAnexo", new BigDecimal(vParametro1));
                String vConsulta = 
                    "select extract (year from fecha_creacion)  anio from sis_anexo where id_anexo = " + vParametro1.toString(); 
                int anio = Integer.parseInt(this.getValorConsulta(vConsulta, "anio").toString());
                if (anio < 2022) { 
                    pDefReporte = "anexo_promocion.jasper";
                } else {
                    pDefReporte = "anexo_promocion2.jasper";   
                }
                
            } else if (vParametro2.equals("ANEXOPROMOSICOIN")) {
                pDefReporte = "reporte_anexo_sicoin.jasper";
                parametrosReporte.put("pIdAnexo", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("ANEXOA_ANALISTA")) {
                pDefReporte = "AnexoA_Analista.jasper";
                parametrosReporte.put("varAnexo", new BigDecimal(vParametro1));
                parametrosReporte.put("varRegistroEmpleado", new BigDecimal(vParametro3));
                parametrosReporte.put("varUsuario", utils.getUsuario().trim());
            } else if (vParametro2.equals("TIEMPO_EXTRA")) {
                pDefReporte = "tiempo_extra.jasper";
                parametrosReporte.put("varHora", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("TIEMPO_EXTRA_RH")) {
                pDefReporte = "Det_Tiempo_Extra_RRHH.jasper";
                parametrosReporte.put("varHora", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("POLAUMENTOPRESU")) {
                pDefReporte = "PolizaAumentoPresu_plAct.jasper";
                parametrosReporte.put("pIdAumento", new BigDecimal(vParametro1));
                parametrosReporte.put("pAnio", new BigDecimal(vParametro5));
            } else if (vParametro2.equals("ACT_TIEMPO_EXTRA")) {
                pDefReporte = "Det_Tiempo_Extra.jasper";
                parametrosReporte.put("varExtra", new BigDecimal(vParametro1));
                parametrosReporte.put("varContrato", new BigDecimal(vParametro5));
            } else if (vParametro2.equals("SOL_TIEMPO_EXTRA")) {
                pDefReporte = "sol_autorizacion_hr_extra.jasper";
                parametrosReporte.put("idHora", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("REP_CATXID")) {
                pDefReporte = "plazas_x_puesto.jasper";
                parametrosReporte.put("pIdPuesto", new BigDecimal(vParametro1.toString().trim()));
                parametrosReporte.put("pAnio", 
                                      new BigDecimal(JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(), 
                                                                                  "flujo_usuario.anioActual").toString()));
            } else if (vParametro2.equals("REP_PLAFC_AUMT")) {
                pDefReporte = "rep_aumento_plaza_fuera.jasper";
                parametrosReporte.put("IdAumento", new BigDecimal(vParametro1));
                parametrosReporte.put("pAnio", new BigDecimal(vParametro5));
            } else if (vParametro2.equals("REP_CAT_PSTS")) {
                pDefReporte = "reportePuestos.jasper";
                parametrosReporte.put("pIdAumento", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("REP_CAT_ACTUAL")) {
                //pDefReporte = "reporte detalle remesa.jasper";
                 pDefReporte = "reportePuestosActual.jasper";
            } else if (vParametro2.equals("REMESA_GENERAL")) {
                pDefReporte = "reporte detalle remesa.jasper";
                parametrosReporte.put("id_ajuste", new BigDecimal(vParametro1));
                parametrosReporte.put("fechainicio", utils.getFecha(vParametro3));
                parametrosReporte.put("fechafinal", utils.getFecha(vParametro4));
                parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
            } else if (vParametro2.equals("REMESA_GENERAL_AUTO")) { //AUTOFINANCIABLES
                pDefReporte = "reporte_detalle_remesa_auto.jasper";
                parametrosReporte.put("id_ajuste", new BigDecimal(vParametro1));
                parametrosReporte.put("fechainicio", utils.getFecha(vParametro3));
                parametrosReporte.put("fechafinal", utils.getFecha(vParametro4));
                parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
            } else if (vParametro2.equals("REMESA_GENERAL_IGSS_MES_ACTUAL")) {
                pDefReporte = "reporte_detalle_remesa_IGSS_actual.jasper";
                if (vParametro1.equals("21") || vParametro1.equals("25") || vParametro1.equals("26")) {
                    parametrosReporte.put("id_ajuste", new BigDecimal(vParametro1));
                    parametrosReporte.put("fechainicio", utils.getFecha(vParametro3));
                    parametrosReporte.put("fechafinal", utils.getFecha(vParametro4));
                    parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
                }else{
                    System.out.println("NO es IGSS");
                };
            } else if (vParametro2.equals("REMESA_GENERAL_C")) {
                pDefReporte = "detalle_remesa_comple_pdf.jasper";
                parametrosReporte.put("id_ajuste", new BigDecimal(vParametro1));
                parametrosReporte.put("fechainicio", utils.getFecha(vParametro3));
                parametrosReporte.put("fechafinal", utils.getFecha(vParametro4));
                parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
            } else if (vParametro2.equals("CUADRE_REMESA")) {
                pDefReporte = "cuadre_remesa.jasper";
                parametrosReporte.put("fechainicio", vParametro3);
                parametrosReporte.put("fechafinal", vParametro4);
                parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
            } else if (vParametro2.equals("ANULADOS_MES_ACTUAL")) {
                pDefReporte = "reporte_anulados_mes_actual.jasper";
                parametrosReporte.put("id_ajuste", new BigDecimal(vParametro1));
                parametrosReporte.put("fechainicio", vParametro3);
                parametrosReporte.put("fechafinal", vParametro4);
                parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
            } else if (vParametro2.equals("ANULADOS_MES_ACTUAL_AUTO")) { //AUTOFINANCIABLES
                pDefReporte = "reporte_anulados_mes_actual_auto.jasper";
                parametrosReporte.put("id_ajuste", new BigDecimal(vParametro1));
                parametrosReporte.put("fechainicio", vParametro3);
                parametrosReporte.put("fechafinal", vParametro4);
                parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
            } else if (vParametro2.equals("ANULADOS_MES_ACTUAL_C")) {
                pDefReporte = "anulados_mes_actual_comple.jasper";
                parametrosReporte.put("id_ajuste", new BigDecimal(vParametro1));
                parametrosReporte.put("fechainicio", vParametro3);
                parametrosReporte.put("fechafinal", vParametro4);
                parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
            } else if (vParametro2.equals("ANULADOS_MESES_ANTERIORES")) {
                pDefReporte = "reporte_anulados_meses_anteriores.jasper";
                parametrosReporte.put("id_ajuste", new BigDecimal(vParametro1));
                parametrosReporte.put("fechainicio", vParametro3);
                parametrosReporte.put("fechafinal", vParametro4);
                parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
            } else if (vParametro2.equals("ANULADOS_MESES_ANTERIORES_AUTO")) { //AUTOFINANCIABLES
                pDefReporte = "reporte_anulados_meses_anteriores_auto.jasper";
                parametrosReporte.put("id_ajuste", new BigDecimal(vParametro1));
                parametrosReporte.put("fechainicio", vParametro3);
                parametrosReporte.put("fechafinal", vParametro4);
                parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
            } else if (vParametro2.equals("ANULADOS_ANIOS_ANTERIORES")) {
                pDefReporte = "reporte_anulados_anios_anteriores.jasper";
                parametrosReporte.put("id_ajuste", new BigDecimal(vParametro1));
                parametrosReporte.put("fechainicio", vParametro3);
                parametrosReporte.put("fechafinal", vParametro4);
                parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
            } else if (vParametro2.equals("ANULADOS_ANIOS_ANTERIORES_AUTO")) { //AUTOFINANCIABLES
                pDefReporte = "reporte_anulados_anios_anteriores_auto.jasper";
                parametrosReporte.put("id_ajuste", new BigDecimal(vParametro1));
                parametrosReporte.put("fechainicio", vParametro3);
                parametrosReporte.put("fechafinal", vParametro4);
                parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
            } else if (vParametro2.equals("RESUMEN_ANULADOS_MES_ACTUAL")) {
                pDefReporte = "resumen_anulados_mes_actual.jasper";
                parametrosReporte.put("fechainicio", vParametro3);
                parametrosReporte.put("fechafinal", vParametro4);
                parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
            } else if (vParametro2.equals("RESUMEN_ANULADOS_MESES_ANTERIORES")) {
                pDefReporte = "resumen_anulados_meses_anteriores.jasper";
                parametrosReporte.put("fechainicio", vParametro3);
                parametrosReporte.put("fechafinal", vParametro4);
                parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
            } else if (vParametro2.equals("RESUMEN_ANULADOS_ANIOS_ANTERIORES")) {
                pDefReporte = "resumen_anulados_anios_anteriores.jasper";
                parametrosReporte.put("fechainicio", vParametro3);
                parametrosReporte.put("fechafinal", vParametro4);
                parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
            } else if (vParametro2.equals("RESUMEN_ANULADOS_IGSS_MES_ACTUAL")) {
                pDefReporte = "resumen_cheques_nulos.jasper";
                parametrosReporte.put("fechainicio", vParametro3);
                parametrosReporte.put("fechafinal", vParametro4);
                parametrosReporte.put("id_ajuste", new BigDecimal("21"));
                parametrosReporte.put("p_periodo", "MAC");
                parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
            } else if (vParametro2.equals("RESUMEN_ANULADOS_IGSS_MES_ACTUAL_C")) {
                pDefReporte = "resumen_cheques_nulos_comple.jasper";
                parametrosReporte.put("fechainicio", vParametro3);
                parametrosReporte.put("fechafinal", vParametro4);
                parametrosReporte.put("id_ajuste", new BigDecimal("21"));
                parametrosReporte.put("p_periodo", "MAC");
                parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
            } else if (vParametro2.equals("RESUMEN_ANULADOS_IGSS_MESES_ANTERIORES")) {
                pDefReporte = "resumen_cheques_nulos.jasper";
                parametrosReporte.put("fechainicio", vParametro3);
                parametrosReporte.put("fechafinal", vParametro4);
                parametrosReporte.put("id_ajuste", new BigDecimal("21"));
                parametrosReporte.put("p_periodo", "MAN");
                parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
            } else if (vParametro2.equals("RESUMEN_ANULADOS_IGSS_ANIOS_ANTERIORES")) {
                pDefReporte = "resumen_cheques_nulos.jasper";
                parametrosReporte.put("fechainicio", vParametro3);
                parametrosReporte.put("fechafinal", vParametro4);
                parametrosReporte.put("id_ajuste", new BigDecimal("21"));
                parametrosReporte.put("p_periodo", "AA");
                parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
            } else if (vParametro2.equals("RESUMEN_DESCUENTOS_IGSS")) {
                pDefReporte = "resumen_descuentos_igss_plan.jasper";
                parametrosReporte.put("fechainicio", vParametro3);
                parametrosReporte.put("fechafinal", vParametro4);
                parametrosReporte.put("id_ajuste", new BigDecimal("21"));
                parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
            } else if (vParametro2.equals("RESUMEN_DESCUENTOS_PLAN")) {
                pDefReporte = "resumen_descuentos_igss_plan.jasper";
                parametrosReporte.put("fechainicio", vParametro3);
                parametrosReporte.put("fechafinal", vParametro4);
                parametrosReporte.put("id_ajuste", new BigDecimal("24"));
                parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
            } else if (vParametro2.equals("DET_RESUMEN_DESCUENTOS_IGSS_OTROS")) {
                pDefReporte = "detalle_resumen_desc_otros_igss_plan.jasper";
                parametrosReporte.put("fechainicio", vParametro3);
                parametrosReporte.put("fechafinal", vParametro4);
                parametrosReporte.put("id_ajuste", new BigDecimal("21"));
                parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
            } else if (vParametro2.equals("DET_RESUMEN_DESCUENTOS_PLAN_OTROS")) {
                pDefReporte = "detalle_resumen_desc_otros_igss_plan.jasper";
                parametrosReporte.put("fechainicio", vParametro3);
                parametrosReporte.put("fechafinal", vParametro4);
                parametrosReporte.put("id_ajuste", new BigDecimal("24"));
                parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
            } else if (vParametro2.equals("POLIZA_REMESA")) {
                pDefReporte = "PolizaREMESA.jasper";
                parametrosReporte.put("fechainicial", utils.getFecha(vParametro3));
                parametrosReporte.put("fechafinal", utils.getFecha(vParametro4));
                parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
            } else if (vParametro2.equals("RESUMEN_ANULADOS_PLAN_MES_ACTUAL")) {
                pDefReporte = "resumen_cheques_nulos.jasper";
                parametrosReporte.put("fechainicio", vParametro3);
                parametrosReporte.put("fechafinal", vParametro4);
                parametrosReporte.put("id_ajuste", new BigDecimal("24"));
                parametrosReporte.put("p_periodo", "MAC");
                parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
            } else if (vParametro2.equals("RESUMEN_ANULADOS_PLAN_MESES_ANTERIORES")) {
                pDefReporte = "resumen_cheques_nulos.jasper";
                parametrosReporte.put("fechainicio", vParametro3);
                parametrosReporte.put("fechafinal", vParametro4);
                parametrosReporte.put("id_ajuste", new BigDecimal("24"));
                parametrosReporte.put("p_periodo", "MAN");
                parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
            } else if (vParametro2.equals("RESUMEN_ANULADOS_PLAN_ANIOS_ANTERIORES")) {
                pDefReporte = "resumen_cheques_nulos.jasper";
                parametrosReporte.put("fechainicio", vParametro3);
                parametrosReporte.put("fechafinal", vParametro4);
                parametrosReporte.put("id_ajuste", new BigDecimal("24"));
                parametrosReporte.put("p_periodo", "AA");
                parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
            } else if (vParametro2.equals("DET_ANULADOS_IGSS_PORCE_OTROS_MES_ACTUAL")) {
                pDefReporte = "detalle_resumen_nulos_otros_igss_plan.jasper";
                parametrosReporte.put("fechainicio", vParametro3);
                parametrosReporte.put("fechafinal", vParametro4);
                parametrosReporte.put("id_ajuste", new BigDecimal("21"));
                parametrosReporte.put("p_periodo", "MAC");
                parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
            } else if (vParametro2.equals("DET_ANULADOS_IGSS_PORCE_OTROS_MESES_ANTERIORES")) {
                pDefReporte = "detalle_resumen_nulos_otros_igss_plan.jasper";
                parametrosReporte.put("fechainicio", vParametro3);
                parametrosReporte.put("fechafinal", vParametro4);
                parametrosReporte.put("id_ajuste", new BigDecimal("21"));
                parametrosReporte.put("p_periodo", "MAN");
                parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
            } else if (vParametro2.equals("DET_ANULADOS_IGSS_PORCE_OTROS_ANIOS_ANTERIORES")) {
                pDefReporte = "detalle_resumen_nulos_otros_igss_plan.jasper";
                parametrosReporte.put("fechainicio", vParametro3);
                parametrosReporte.put("fechafinal", vParametro4);
                parametrosReporte.put("id_ajuste", new BigDecimal("21"));
                parametrosReporte.put("p_periodo", "AA");
                parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
            } else if (vParametro2.equals("DET_ANULADOS_PLAN_PORCE_OTROS_MES_ACTUAL")) {
                pDefReporte = "detalle_resumen_nulos_otros_igss_plan.jasper";
                parametrosReporte.put("fechainicio", vParametro3);
                parametrosReporte.put("fechafinal", vParametro4);
                parametrosReporte.put("id_ajuste", new BigDecimal("24"));
                parametrosReporte.put("p_periodo", "MAC");
                parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
            } else if (vParametro2.equals("DET_ANULADOS_PLAN_PORCE_OTROS_MESES_ANTERIORES")) {
                pDefReporte = "detalle_resumen_nulos_otros_igss_plan.jasper";
                parametrosReporte.put("fechainicio", vParametro3);
                parametrosReporte.put("fechafinal", vParametro4);
                parametrosReporte.put("id_ajuste", new BigDecimal("24"));
                parametrosReporte.put("p_periodo", "MAN");
                parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
            } else if (vParametro2.equals("DET_ANULADOS_PLAN_PORCE_OTROS_ANIOS_ANTERIORES")) {
                pDefReporte = "detalle_resumen_nulos_otros_igss_plan.jasper";
                parametrosReporte.put("fechainicio", vParametro3);
                parametrosReporte.put("fechafinal", vParametro4);
                parametrosReporte.put("id_ajuste", new BigDecimal("24"));
                parametrosReporte.put("p_periodo", "AA");
                parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
            } else if (vParametro2.equals("DOCUMENTOS_ANULADOS")) {
                pDefReporte = "cheques_anulados_conta.jasper";
                parametrosReporte.put("fechainicio", vParametro3);
                parametrosReporte.put("fechafinal", vParametro4);
                parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
            } else if (vParametro2.equals("DOCUMENTOS_ANULADOS_PARTIDA")) {
                pDefReporte = "cheques_anulados_conta2.jasper";
                parametrosReporte.put("fechainicio", vParametro3);
                parametrosReporte.put("fechafinal", vParametro4);
                parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
            } else if (vParametro2.equals("FLUJO_EFECTIVO")) {
                pDefReporte = "graficanchequesuniversidad.jasper";
                parametrosReporte.put("fechainicio", vParametro3);
                parametrosReporte.put("fechafinal", vParametro4);
                parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro5));
            } else if (vParametro2.equals("FLUJO_DOCUMENTOS")) {
                pDefReporte = "graficanchequesuniversidad.jasper";
                parametrosReporte.put("fechainicio", vParametro3);
                parametrosReporte.put("fechafinal", vParametro4);
            } else if (vParametro2.equals("CHKANULFECH")) {
                pDefReporte = "pagos_anulados_dependencia.jasper";
                parametrosReporte.put("pFechaI", utils.getFecha(vParametro3));
                parametrosReporte.put("pFechaF", utils.getFecha(vParametro4));

                if (vParametro5.equals("1")) {
                    vOrden = "  order by sdb.id_tipo_documento,sdb.num_doc_fisico ";
                } else {
                    vOrden = "  order by sdb.id_tipo_documento,sdb.fecha_anulacion asc ";
                }

                if (vParametro1.equals("0")) {
                    parametrosReporte.put("pFiltro", vOrden);
                } else {
                    parametrosReporte.put("pFiltro", "and dep.id_dependencia=" + vParametro1 + vOrden);
                }
            } else if (vParametro2.equals("DOCNOMINAT")) {
                Object varUsuario = "";
                varUsuario = 
                        JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                                   "#{roles_usuario.coordinadorDescJud}");
                if (varUsuario.equals(true)) {
                    pDefReporte = "nomina_sueldos_judicial.jasper";
                    parametrosReporte.put("pIdProceso", new BigDecimal(vParametro1));
                    //parametrosReporte.put("pUsuario",utils.getUsuario());       
                    //parametrosReporte.put("pWhere1","");                     
                } else {
                    pDefReporte = "nomina_sueldos_teso.jasper";
                    parametrosReporte.put("pIdProceso", new BigDecimal(vParametro1));
                    parametrosReporte.put("pUsuario", utils.getUsuario());
                    vValorSession = vParametro5; //se recibirá la dependencia a filtrar
                    if (vValorSession != null) {
                        parametrosReporte.put("pWhere1", " and sis_dependencia.id_dependencia in (" + vValorSession + ")");
                    } else {
                        parametrosReporte.put("pWhere1", "");
                    }
                }
            } else if (vParametro2.equals("DOCNOMINATSICOIN")) {
                Object varUsuario = "";
                String vTipoReporte = vParametro5.toString();
                vTipoReporte = vTipoReporte.replace(" ","");
                                                     
                varUsuario =  JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                                   "#{roles_usuario.coordinadorDescJud}");
                if (varUsuario.equals(false)) { 
                
                    if (vTipoReporte.equals("GENERAL")){
                        pDefReporte = "reporte_sicoin_general.jasper";
                    }else if (vTipoReporte.equals("VACACIONES") || vTipoReporte.equals("EXTRAORDINARIO") || vTipoReporte.equals("IGSS") || vTipoReporte.equals("EGRESO981") || vTipoReporte.equals("EGRESO216") ){
                        pDefReporte = "reporte_sicoin_otros1.jasper";
                    }
                    else{
                        vGenerarReporte = false;
                        vMensaje = "No se pudo generar el reporte solicitado.";
                    }
                    
                    parametrosReporte.put("pIdProceso", new BigDecimal(vParametro1));
                    parametrosReporte.put("pUsuario", utils.getUsuario()); 
                    parametrosReporte.put("pTipoReporte", vTipoReporte);                    
                }
            }else if (vParametro2.equals("DOCACREDSICOINANULADOS")) {
                Object varUsuario = "";
                varUsuario = 
                        JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                                   "#{roles_usuario.coordinadorDescJud}");
                if (varUsuario.equals(false)) { 
                    pDefReporte = "reporte_nomina_anulados_sicoin.jasper";
                    parametrosReporte.put("pIdProceso", new BigDecimal(vParametro1));
                    parametrosReporte.put("pUsuario", utils.getUsuario());
                }
            }else if (vParametro2.equals("SINCUENTABANCO")) {
                Object varUsuario = "";
                varUsuario = 
                        JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                                   "#{roles_usuario.coordinadorDescJud}");
                if (varUsuario.equals(false)) { 
                    pDefReporte = "reporte_nomina_sincuenta.jasper";
                    parametrosReporte.put("pIdProceso", new BigDecimal(vParametro1)); 
                }
            }else if (vParametro2.equals("DetSIS25")) {
                Object varUsuario = "";
                varUsuario = 
                        JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                                   "#{roles_usuario.coordinadorDescJud}");
                if (varUsuario.equals(false)) { 
                    pDefReporte = "sis25_detDescuentos.jasper";
                    parametrosReporte.put("IdProceso", new BigDecimal(vParametro1)); 
                }
            }            
            else if (vParametro2.equals("POLZA_DIARIO")) {
                pDefReporte = "PolizaDiario.jasper";
                parametrosReporte.put("no_poliza_diario", new BigDecimal(vParametro1));

            } else if (vParametro2.equals("POLIZA_DIARIO_ANU")) {
                pDefReporte = "PolizaDiarioAnulados.jasper";
                parametrosReporte.put("no_poliza", new BigDecimal(vParametro1));

            } else if (vParametro2.equals("SIS-04")) {
                //Para obtener la fecha firma del contrato
                String vConsulta =
                "select to_char(case when (select tipo_validez from sis_contrato where id_contrato= "+vParametro1+")='I' and (select fecha_creacion from sis_contrato where id_contrato= "+vParametro1+")<to_date('01/01/'||to_char(sysdate,'yyyy'),'dd/mm/yyyy') "
                +"              then (case when trunc(sysdate) > to_date('30/06/'||to_char(sysdate,'yyyy'),'dd/mm/yyyy') "
                +"                    then to_date('01/07/'||to_char(sysdate,'yyyy'),'dd/mm/yyyy') "
                +"                    else to_date('01/01/'||to_char(sysdate,'yyyy'),'dd/mm/yyyy') end) " 
                //+"else nvl((select fecha_firma from sis_contrato where id_contrato= "+vParametro1+"), sis_pkg_util.GETFECHAFIRMACONTRATO("+vParametro1+")) "
                +"else nvl((select fecha_posesion from sis_contrato where id_contrato= "+vParametro1+"), sis_pkg_util.GETFECHAFIRMACONTRATO("+vParametro1+")) "
                +"end,'dd/mm/yyyy') firma from dual";

                String oFirmaContrato =this.getValorConsulta(vConsulta, "firma").toString();
                //System.out.println("firma del contrato:= "+oFirmaContrato);

                //Si hay que convertirlo a fecha la cadena devuelto por el query
                /*SimpleDateFormat formatoDelTexto2 =  new SimpleDateFormat("dd/MM/yyyy");
                Date fecha2 = null;
                try {
                    fecha2 = formatoDelTexto2.parse(oFirmaContrato.toString());
                }catch (ParseException ex){
                    System.out.println("Error al convertir la fecha ");
                }*/

                parametrosReporte.put("pFirmaContrato",oFirmaContrato);
                parametrosReporte.put("pIdContrato",new BigDecimal(vParametro1));
                vConsulta = 
                    "select case when fecha_creacion>=to_date((select valor_cadena from sis_parametros_aplicacion where nom_parametro='SIN_CEDULA'),'dd/mm/yyyy') " + 
                    "then 1 else 0 end valor from sis_contrato \n" + 
                    "where id_contrato=" + vParametro1;
                int valor = Integer.parseInt(this.getValorConsulta(vConsulta, "valor").toString());

                pDefReporte = "Sis-04.jasper";
                if (valor == 1) {
                    pDefReporte = "Sis-02.jasper";
                }
                //System.out.println("Reporte a llamar:= "+pDefReporte);
                if (vParametro5 == null) {
                    parametrosReporte.put("pRegistro", 
                                          new BigDecimal(JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(), 
                                                                                      "flujo_usuario.selRegEmpleado_login").toString()));
                } else {
                    parametrosReporte.put("pRegistro",new BigDecimal(vParametro5));
                }

                vDeclara = 
                        conexion.getValorConsultaSimpleClob("dec_jurada", "select trim(c.dec_jurada.getclobval()) as dec_jurada from sis_contrato c where c.id_contrato=" + 
                                                            new BigDecimal(vParametro1).toString());

                if (vDeclara != null) {
                    System.out.println("entra");
                    vXmlSource = true;
                    vXMLData = this.getXml(vDeclara.toString());
                    pDefReporte = "Sis-04_xml.jasper";

                    parametrosReporte.put(JRXPathQueryExecuterFactory.PARAMETER_XML_DATA_DOCUMENT,vXMLData);
                    parametrosReporte.put(JRXPathQueryExecuterFactory.XML_DATE_PATTERN,"dd/MM/yyyy");
                    parametrosReporte.put(JRXPathQueryExecuterFactory.XML_NUMBER_PATTERN,"##0");
                    parametrosReporte.put(JRXPathQueryExecuterFactory.XML_LOCALE,new java.util.Locale("es", "GT"));
                    parametrosReporte.put(JRParameter.REPORT_LOCALE,new java.util.Locale("es", "GT"));
                }
            } else if (vParametro2.equals("SIS-06")) {
                pDefReporte = "Sis06_trab.jasper";
                parametrosReporte.put("pRegistroEmpleado", 
                                      new BigDecimal(JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(), 
                                                                                  "flujo_usuario.selRegEmpleado_login").toString()));
                parametrosReporte.put("pAnio", 
                                      new BigDecimal(JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(), 
                                                                                  "flujo_usuario.anioActual").toString()));
            } else if (vParametro2.equals("SIS-21")) {
                pDefReporte = "sis-21.jasper";
                parametrosReporte.put("pIdDocPagoAnulado",new BigDecimal(vParametro1));
                parametrosReporte.put("pReposicion",vParametro5 != null && vParametro5.equals("1") ? true : false);
            } else if (vParametro2.equals("REPPROB")) {
                pDefReporte = "reporte_probidad.jasper";
            } else if (vParametro2.equals("CONISRANUAL")) {
                pDefReporte = "reporte_retension_anual.jasper";
                parametrosReporte.put("anio", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("REPPAGOISR")) {
                pDefReporte = "boleta_pago_isr.jasper";
                parametrosReporte.put("ANIO", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("REPPAGOISR2")) {
                vAnio = 
                        JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(), 
                                                     "flujo_usuario.anioActual").toString();
                if (vAnio != null && Integer.parseInt(vAnio) > 2012) {
                    pDefReporte = "boleta_pago_isr_def_2013.jasper";
                } else {
                    pDefReporte = "boleta_pago_isr2.jasper";
                }
                //  pDefReporte="boleta_pago_isr2.jasper";
                if (vParametro1 != null) {
                    parametrosReporte.put("pFiltro", 
                                          "and sia.registro_empleado = " + 
                                          vParametro1 + 
                                          " and periodo=(select max(periodo) from sis_isr_retencion where registro_empleado=" + 
                                          vParametro1 + " and anio=" + vAnio + 
                                          ")");
                }

                parametrosReporte.put("ANIO", new BigDecimal(vAnio));
                //
                //and periodo=(select max(periodo) from sis_isr_retencion where anio=2011)    
            } else if (vParametro2.equals("REPPAG_ISR")) {
                //  pDefReporte="boleta_pago_isr2.jasper";
                vAnio = vParametro1;

                if (vAnio != null && Integer.parseInt(vAnio) > 2012) {
                    pDefReporte = "boleta_pago_isr_def_2013.jasper";
                } else {
                    pDefReporte = "boleta_pago_isr2.jasper";
                }

                vParametro1 = 
                        JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(), 
                                                     "flujo_usuario.selRegEmpleado_login").toString();
                if (vParametro1 != null) {
                    parametrosReporte.put("pFiltro", 
                                          "and sia.registro_empleado = " + 
                                          vParametro1 + 
                                          " and periodo=(select max(periodo) from sis_isr_retencion where registro_empleado=" + 
                                          vParametro1 + " and anio=" + vAnio + 
                                          ")");
                }

                parametrosReporte.put("ANIO", new BigDecimal(vAnio));
                //--REPPAGOISRMSUL
                //
                //and periodo=(select max(periodo) from sis_isr_retencion where anio=2011)
            } else if (vParametro2.equals("REPPAGOISRMSUL")) {
                vAnio = 
                        JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(), 
                                                     "flujo_usuario.anioActual").toString();
                if (vAnio != null && Integer.parseInt(vAnio) > 2012) {
                    pDefReporte = "boleta_pago_isr_mensual_2013.jasper";
                } else {
                    pDefReporte = "boleta_pago_isr_mensual.jasper";
                }

                if (vParametro1 != null) {
                    parametrosReporte.put("pFiltro", 
                                          "and sia.registro_empleado = " + 
                                          vParametro1 + 
                                          " and periodo=(select max(periodo) from sis_isr_retencion where registro_empleado=" + 
                                          vParametro1 + " and anio=" + vAnio + 
                                          ")");
                }

                parametrosReporte.put("ANIO", new BigDecimal(vAnio));

            } else if (vParametro2.equals("CONTRATACIONES")) {
                pDefReporte = "audit_contratos.jasper";
                parametrosReporte.put("varDep", new BigDecimal(vParametro1));
                parametrosReporte.put("varFechIni", utils.getFecha(vParametro3));
                parametrosReporte.put("varFechFin", utils.getFecha(vParametro4));
            } else if (vParametro2.equals("SUSPENSION_IGSS")) {
                pDefReporte = "suspenciones_Igss.jasper";
                parametrosReporte.put("varDep", new BigDecimal(vParametro1));
                parametrosReporte.put("varFechIni", utils.getFecha(vParametro3));
                parametrosReporte.put("varFechFin", utils.getFecha(vParametro4));
            } else if (vParametro2.equals("LICENCIAS")) {
                pDefReporte = "licencias_sin_sueldo.jasper";
                parametrosReporte.put("varDep", new BigDecimal(vParametro1));
                parametrosReporte.put("varFechIni", utils.getFecha(vParametro3));
                parametrosReporte.put("varFechFin", utils.getFecha(vParametro4));
            } else if (vParametro2.equals("REPPROY_INDEM")) {
                pDefReporte = "provision_indemn.jasper"; 
                parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro1));
                
            }else if (vParametro2.equals("POLIZA_PROVINDEM")) {
                pDefReporte = "provision_indemn_poliza.jasper"; 
                parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro1));
                
            } else if (vParametro2.equals("PROMO_RECLASIFICACION")) {
                pDefReporte = "audit_promo_reclasificacion.jasper";
                parametrosReporte.put("varDep", new BigDecimal(vParametro1));
                parametrosReporte.put("varFechIni", utils.getFecha(vParametro3));
                parametrosReporte.put("varFechFin", utils.getFecha(vParametro4));
            } else if (vParametro2.equals("RENUNCIAS_DESPIDOS")) {
                pDefReporte = "renuncia_despidos.jasper";
                parametrosReporte.put("varDep", new BigDecimal(vParametro1));
                parametrosReporte.put("varFechIni", utils.getFecha(vParametro3));
                parametrosReporte.put("varFechFin", utils.getFecha(vParametro4));
            } else if (vParametro2.equals("CHEQUE_SUSPENSION_IGSS")) {
                //System.out.println("estoy en suspension");
                pDefReporte = "cheques_suspIgss.jasper";
                parametrosReporte.put("varDep", new BigDecimal(vParametro1));
                parametrosReporte.put("varFechIni", utils.getFecha(vParametro3));
                parametrosReporte.put("varFechFin", utils.getFecha(vParametro4));
            } else if (vParametro2.equals("ALZA_BAJA")) {
                //System.out.println("estoy en suspension");
                pDefReporte = "rep_alzas.jasper";
                parametrosReporte.put("depen", new BigDecimal(vParametro1));
                parametrosReporte.put("f1", utils.getFecha(vParametro3));
                parametrosReporte.put("f2", utils.getFecha(vParametro4));
            } else if (vParametro2.equals("DESCUENTO_BAJA")) {
                //System.out.println("estoy en suspension");
                pDefReporte = "rep_descuentosDebaja.jasper";
                parametrosReporte.put("depen", new BigDecimal(vParametro1));
                parametrosReporte.put("f1", utils.getFecha(vParametro3));
                parametrosReporte.put("f2", utils.getFecha(vParametro4));
            } else if (vParametro2.equals("DESCUENTO_ALZA")) {
                //System.out.println("estoy en suspension");
                pDefReporte = "rep_descuentosnuevos.jasper";
                parametrosReporte.put("depen", new BigDecimal(vParametro1));
                parametrosReporte.put("f1", utils.getFecha(vParametro3));
                parametrosReporte.put("f2", utils.getFecha(vParametro4));
            } else if (vParametro2.equals("FALTAS_TRABAJO")) {
                //System.out.println("estoy en suspension");
                pDefReporte = "rep_faltasAlTrabajo.jasper";
                parametrosReporte.put("depen", new BigDecimal(vParametro1));
                parametrosReporte.put("f1", utils.getFecha(vParametro3));
                //parametrosReporte.put("f2",utils.getFecha(vParametro4));                                                                          
            } else if (vParametro2.equals("LICENCIAS_CS")) {
                //System.out.println("estoy en suspension");
                pDefReporte = "rep_licencciaCS.jasper";
                parametrosReporte.put("depen", new BigDecimal(vParametro1));
                parametrosReporte.put("f1", utils.getFecha(vParametro3));
                parametrosReporte.put("f2", utils.getFecha(vParametro4));
            } else if (vParametro2.equals("CONST_ACT_DATOSPER")) {
                Object oRegistroEmpleadoLogueado, oRegistroEmpleadoConstancia;
                oRegistroEmpleadoLogueado = 
                        JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(), 
                                                     "flujo_usuario.selRegEmpleado_login");
                if (oRegistroEmpleadoLogueado != null) {
                    oRegistroEmpleadoConstancia = vParametro1;
                    if (oRegistroEmpleadoConstancia != null) {
                        //System.out.println("El empleado de la constancia es el " + oRegistroEmpleadoConstancia.toString());
                        if (oRegistroEmpleadoConstancia.toString().equalsIgnoreCase(oRegistroEmpleadoLogueado.toString()) == 
                            true) {
                            pDefReporte = "form_act_datos_empl.jasper";
                            //vValorSession=request.getSession().getAttribute("pIdFormulario");
                            //if (vValorSession!=null)
                            //parametrosReporte.put("pNoFormulario",new BigDecimal(vValorSession.toString()));
                            //else
                            parametrosReporte.put("pRegistroEmpleado", 
                                                  new BigDecimal(oRegistroEmpleadoConstancia.toString()));
                        } else {
                            vGenerarReporte = false;
                            vMensaje = "No se pudo generar el reporte! Acceso Denegado.";
                        }
                    } else {
                        vGenerarReporte = false;
                        vMensaje = "No se pudo generar el reporte! Faltan algunos parámetros.";
                    }
                } else {
                    vGenerarReporte = false;
                    vMensaje = "No se pudo generar el reporte! Faltan algunos parámetros.";
                }
            } else if (vParametro2.equals("CONST_ACT_CON")) {
                pDefReporte = "constancia_confronta_actua.jasper";
                vValorSession = request.getSession().getAttribute("pIdFormulario");
                
                if (vValorSession != null)
                    parametrosReporte.put("pIdFormulario", new BigDecimal(vValorSession.toString()));
            } else if (vParametro2.equals("SUELDO_ENERO")) {
                pDefReporte = "audit_sueldo_enero.jasper";
                parametrosReporte.put("varDep", new BigDecimal(vParametro1));
                parametrosReporte.put("pAnio", new BigDecimal(vAnio2));

                if (vParametro3 != null && vParametro3.equals("true")) {
                    parametrosReporte.put("pFiltro", "and n.NOMINAL - ar.SALARIO_BASE-ar.COMPL_SALARIAL-ar.ESCALAFON <>0");
                } else {
                    parametrosReporte.put("pFiltro", " ");
                }
            } else if (vParametro2.equals("SUELDOS")) {
                pDefReporte = "audit_sueldos.jasper";
                parametrosReporte.put("varDep", new BigDecimal(vParametro1));
                parametrosReporte.put("mes", new BigDecimal(vParametro5));
                parametrosReporte.put("pAnio", new BigDecimal(vAnio2));

                if (vParametro3 != null && vParametro3.equals("true")) {
                    parametrosReporte.put("pFiltro", " and nn.NOMINAL - n.NOMINAL <> 0");
                } else {
                    parametrosReporte.put("pFiltro", " ");
                }
            } else if (vParametro2.equals("EMISION_DOC_PAGO")) {
                parametrosReporte.put("pIdProceso", new BigDecimal(vParametro1));
                parametrosReporte.put("pIdTipoDocumento", new BigDecimal(vParametro5));
                pDefReporte = "emision_de_docs_pago.jasper";
            } else if (vParametro2.equals("EMISION_DOC_PAGO_ISR")) {
                parametrosReporte.put("pIdProceso", new BigDecimal(vParametro1));
                parametrosReporte.put("pIdTipoDocumento", new BigDecimal(vParametro5));
                pDefReporte = "emision_de_docs_pago_isr.jasper";
            } else if (vParametro2.equals("ACTAFACSIMIL")) {
                pDefReporte = "acta_facsimil.jasper";
                parametrosReporte.put("vacta", new BigDecimal(vParametro1));
                parametrosReporte.put("vanio", new BigDecimal(vParametro5));
            } else if (vParametro2.equals("SIS-22")) {
                parametrosReporte.put("pIdForm22", new BigDecimal(vParametro1));
                String vConsulta = 
                    "select extract (year from Decode(fecha_documento,null,fecha,fecha_documento)) anio \n" + 
                    "from sis_form22_docpago_anulado \n" + 
                    "where id_form22="+vParametro1.toString();
                int anio = Integer.parseInt(this.getValorConsulta(vConsulta, "anio").toString());
                if (anio < 2020) { 
                    pDefReporte = "formsis_22.jasper";
                } else {//La condición de años anteriores aplica a partir del 2020
                    pDefReporte = "formsis_22.jasper";
                    //vParametro5: 1=año actual, 0=años anteriores
                    if (vParametro5.equals("0")){
                        pDefReporte = "formsis_22_anio_anterior.jasper";
                    }
                }
            } else if (vParametro2.equals("CONST_RECEP22")) {
                pDefReporte = "formsis_22_recep.jasper";
                parametrosReporte.put("pIdForm22", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("CMPLSAL")) {
                pDefReporte = "complementosis04.jasper";
                parametrosReporte.put("pIdComplemento", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("CMPLSALPROM")) {

                pDefReporte = "complementosis04_promo.jasper";
                parametrosReporte.put("pIdComplemento", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("CMPLDUPL")) {
                pDefReporte = "repPagoComplementosDuplicados.jasper";
                parametrosReporte.put("idComplemento", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("SIS10REPO")) {
                pDefReporte = "sis10.jasper";
                parametrosReporte.put("pIdComplemento", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("VARIACION_NOMINA")) {
                pDefReporte = "variacion_nomina.jasper";
                parametrosReporte.put("dep", new BigDecimal(vParametro1));
                parametrosReporte.put("unidad", new BigDecimal(vParametro3));
                parametrosReporte.put("mes", new BigDecimal(vParametro4));
                parametrosReporte.put("anio", new BigDecimal(vParametro5));
                parametrosReporte.put("pUsuario", 
                                      JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(), 
                                                                   "flujo_usuario.nombreUsuarioLogueado").toString());
            } else if (vParametro2.equals("PLAZASTESOAPER")) {
                pDefReporte = "RepPlazasTesoreroApertura.jasper";
                parametrosReporte.put("pUsuario", vParametro1);
                parametrosReporte.put("pAnio", 
                                      new BigDecimal(JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(), 
                                                                                  "flujo_usuario.anioActual").toString()));
            } else if (vParametro2.equals("PLAZASTESOAPERSICOIN")) {
              //  pDefReporte = "RepPlazasTesoreroAperturaSICOIN.jasper";
               pDefReporte = "RepPlazasTeso_SICOIN.jasper"; 
                parametrosReporte.put("pUsuario", utils.getUsuario());
                parametrosReporte.put("pAnio", 
                                      new BigDecimal(JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(), 
                                                                                  "flujo_usuario.anioActual").toString()));
            } else if (vParametro2.equals("ANALISTA_EMPLEADO")) {
                pDefReporte = "Control_Analista_Empleado.jasper";
                parametrosReporte.put("idPartida", new BigDecimal(vParametro1));
                parametrosReporte.put("numPlaza", new BigDecimal(vParametro3));
                parametrosReporte.put("anio1", new BigDecimal(vParametro4));
                parametrosReporte.put("registro", new BigDecimal(vParametro5));
            } else if (vParametro2.equals("ANALISTA_SUBPROGRAMA")) {
                Object varusuario = "";
                String anioActual = utils.getAnioActual();
                varusuario = 
                        JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                                   "#{roles_usuario.auditor}");
                if (varusuario.equals(true)) {
                    if (anioActual.equals(vParametro4)) {
                        //pDefReporte="Control_Auditor_Unidad.jasper";
                        pDefReporte = "Control_unidad_Dependencia.jasper";
                    } else {
                        pDefReporte = "Control_Auditor_Unidad_Anterior.jasper";
                    }

                    parametrosReporte.put("vardep", new BigDecimal(vParametro1));
                    parametrosReporte.put("varuni", new BigDecimal(vParametro3));
                    parametrosReporte.put("anio1", new BigDecimal(vParametro4));
                    parametrosReporte.put("varprogra", new BigDecimal(vParametro5));
                    parametrosReporte.put("pUsuario", utils.getUsuario().trim());
                    parametrosReporte.put("varPlaza", new BigDecimal(vParametro6));
                } else {

                    if (anioActual.equals(vParametro4)) {
                        pDefReporte = "Control_unidad_Dependencia.jasper";
                    } else {
                        pDefReporte = 
                                "Control_unidad_Dependencia_Anterior.jasper";
                    }
                    parametrosReporte.put("vardep", new BigDecimal(vParametro1));
                    parametrosReporte.put("varuni", new BigDecimal(vParametro3));
                    parametrosReporte.put("anio1", new BigDecimal(vParametro4));
                    parametrosReporte.put("varprogra", new BigDecimal(vParametro5));
                    parametrosReporte.put("pUsuario", utils.getUsuario().trim());
                    parametrosReporte.put("varPlaza", new BigDecimal(vParametro6));
                }
            } else if (vParametro2.equals("ANALISTA_DEPENDENCIA")) {
                Object varusuario = "";
                Object varusuario1 = "";
                String anioActual = utils.getAnioActual();

                varusuario = 
                        JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                                   "#{roles_usuario.analistaRecursosHum}");
                if (varusuario.equals(true)) {
                    if (anioActual.equals(vParametro4)) {
                        pDefReporte = "Control_Analista_Dependencia.jasper";
                    } else {
                        pDefReporte = "Control_Analista_Dependencia_Anterior.jasper";
                    }
                    parametrosReporte.put("vardep", new BigDecimal(vParametro1));
                    parametrosReporte.put("anio1", new BigDecimal(vParametro4));
                    parametrosReporte.put("pUsuario", utils.getUsuario().trim());
                } else {
                    varusuario = 
                            JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                                       "#{roles_usuario.tesorero}");
                    varusuario1 = 
                            JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                                       "#{roles_usuario.auxiliarTesoreria}");
                    if (varusuario.equals(true) || varusuario1.equals(true)) {

                        if (anioActual.equals(vParametro4)) {
                            //pDefReporte="Control_Tesorero_Dependencia.jasper";
                            pDefReporte = "Control_Analista_Dependencia.jasper";
                        } else {
                            pDefReporte = "Control_Tesorero_Dependencia_Anterior.jasper";
                        }

                        parametrosReporte.put("vardep", new BigDecimal(vParametro1));
                        parametrosReporte.put("anio1", new BigDecimal(vParametro4));
                        parametrosReporte.put("pUsuario", utils.getUsuario().trim());
                    } else {
                        varusuario = 
                                JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                                           "#{roles_usuario.auditor}");

                        if (varusuario.equals(true)) {
                            if (anioActual.equals(vParametro4)) {
                                //pDefReporte="Control_Auditor_Dependencia.jasper";
                                pDefReporte = "Control_Analista_Dependencia.jasper";
                            } else {
                                pDefReporte = "Control_Auditor_Dependencia_Anterior.jasper";
                            }

                            parametrosReporte.put("vardep", new BigDecimal(vParametro1));
                            parametrosReporte.put("anio1", new BigDecimal(vParametro4));
                            parametrosReporte.put("pUsuario", utils.getUsuario().trim());
                        }
                    }
                }
            } else if (vParametro2.equals("ANALISTA_BONO14")) {
                pDefReporte = "Control_Analista_Bono14.jasper";
                parametrosReporte.put("vardep", new BigDecimal(vParametro1));
                parametrosReporte.put("anio1", new BigDecimal(vParametro4));
                //agregado por el cambio del reporte igual que el de tesoreros
                parametrosReporte.put("pUsuario", utils.getUsuario().trim());
                //agregado para que solo sea por subprograma                                      
                parametrosReporte.put("varuni", new BigDecimal(vParametro3));
                parametrosReporte.put("varprogra", new BigDecimal(vParametro5));
            } else if (vParametro2.equals("NOMINAPRUEBA")) {
                pDefReporte = "contratos_nomina_normal.jasper";
                parametrosReporte.put("pPeriodo", utils.getFecha("01/" + vParametro1 + "/" + utils.getAnioActual()));
                vValorSession = request.getSession().getAttribute("p1Dependencia");
                if (vValorSession != null) {
                    parametrosReporte.put("pWhere1", " and dep.id_dependencia in (" + vValorSession + ")");
                } else {
                    parametrosReporte.put("pWhere1", "");
                }

            } else if (vParametro2.equals("NOMPROC")) {
                pDefReporte = "nomina_sueldos2.jasper";
                //parametrosReporte.put("pIdProceso", new BigDecimal(vParametro1));
                parametrosReporte.put("pIdProceso", utils.getBigDecimal(vParametro1));
                vValorSession = request.getSession().getAttribute("p1Dependencia");

                if (vValorSession != null) {
                    parametrosReporte.put("pWhere1", " and sis_dependencia.id_dependencia in (" + vValorSession + ")");
                } else {
                    parametrosReporte.put("pWhere1", "");
                }

                /** AGREGADO POR JUAN PACHECO
                 * Para el reporte de Diferencias en Nómina **
                 * */
            } else if (vParametro2.equals("DIFNOMINA")) {
                pDefReporte = "rep_diferencias_en_nomina.jasper";
                //parametrosReporte.put("pIdProceso", new BigDecimal(vParametro1));
                parametrosReporte.put("idproceso", new BigDecimal(vParametro1));
                //parametrosReporte.put("idproceso", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("CONTDTSPER")) {
                pDefReporte = "InfDatosPersonales.jasper";
                parametrosReporte.put("pIdContrato", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("LICCSSS")) {
                pDefReporte = "Licencias.jasper";
                parametrosReporte.put("pIdSolicitud", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("LICCSICOIN")) {
                pDefReporte = "Licencias_Sicoin.jasper";
                parametrosReporte.put("pIdSolicitud", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("CONDBANC")) {
                pDefReporte = "carga_conciliacion_bancaria.jasper";
                parametrosReporte.put("pIdCarga", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("CHEQUES EN CIRCULACION")) {
                pDefReporte = "circulacion_cheques.jasper";
                parametrosReporte.put("pFecha", vParametro1);

                if (vParametro5 != null) {
                    parametrosReporte.put("pWhere", 
                                          " and dep.id_dependencia in ( " + 
                                          new BigDecimal(vParametro5) + ")");
                } else {
                    parametrosReporte.put("pWhere", "");
                }

            } else if (vParametro2.equals("CHEQUES ANULADOS")) {
                pDefReporte = "cheques_anulados.jasper";
                parametrosReporte.put("pFecha", vParametro1);
                if (vParametro5 != null) {
                    parametrosReporte.put("pWhere", " and dep.id_dependencia in ( " + new BigDecimal(vParametro5) + ")");
                } else {
                    parametrosReporte.put("pWhere", "");
                }
            } else if (vParametro2.equals("CHEQUES COBRADOS")) {
                pDefReporte = "cheques_cobrados.jasper";
                parametrosReporte.put("pFecha", vParametro1);
                if (vParametro5 != null) {
                    parametrosReporte.put("pWhere", " and dep.id_dependencia in ( " + new BigDecimal(vParametro5) + ")");
                } else {
                    parametrosReporte.put("pWhere", "");
                }
            } else if (vParametro2.equals("CHEQUES INCONSISTENTES")) {
                pDefReporte = "cheques_inconsistentes.jasper";
                parametrosReporte.put("pFecha", vParametro1);
                if (vParametro5 != null) {
                    parametrosReporte.put("pWhere", " and dep.id_dependencia in ( " + new BigDecimal(vParametro5) + ")");
                } else {
                    parametrosReporte.put("pWhere", "");
                }
            } else if (vParametro2.equals("EMPLCHANGES")) {
                pDefReporte = "rep_cambios_empleado.jasper";
                parametrosReporte.put("pRegistroEmpleado", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("CONCILIACIONXCHEQUE")) {
                pDefReporte = "conciliacion_por_cheque.jasper";
                parametrosReporte.put("pNumCheque", new BigDecimal(vParametro1));
                parametrosReporte.put("pBanco", new BigDecimal(vParametro5));
            } else if (vParametro2.equals("CONSCENSOLAB1")) {
                ficha_empleado_censo vData;
                vData = 
                        (ficha_empleado_censo)JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(), 
                                                                           "ficha_empleado_censo");
                pDefReporte = "constancia_censo_laboral.jasper";
                parametrosReporte.put("pRegistroEmpleado", new BigDecimal(vData.getRegistroEmpl()));
            } else if (vParametro2.equals("LICEMPLCSSS")) {
                pDefReporte = "Licencias_empl.jasper";
                parametrosReporte.put("pIdSolicitud", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("SIS-15")) {
                pDefReporte = "complementoSis15.jasper";
                parametrosReporte.put("p_id_complemento", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("CHEQRECIBIDO")) {
                pDefReporte = "cheqAnulFisico_Recibido.jasper";
                parametrosReporte.put("pIdForm22", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("RES_PROCESO_PG")) {
                pDefReporte = "resumenInfoPago.jasper";
                parametrosReporte.put("pIdProceso", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("PARTIDA_NO_EXISTE")) {
                pDefReporte = "partidas_no_existen_conta.jasper";
                parametrosReporte.put("p_fecha_ini", utils.getFecha(vParametro3));
                parametrosReporte.put("p_fecha_fin", utils.getFecha(vParametro4));
            } else if (vParametro2.equals("PARTIDA_ANU_NO_EXISTE")) {
                pDefReporte = "partidas_no_existen_conta_anulados.jasper";
                parametrosReporte.put("p_fecha_ini", utils.getFecha(vParametro3));
                parametrosReporte.put("p_fecha_fin", utils.getFecha(vParametro4));
            } else if (vParametro2.equals("REMESA_GENERAL_TEXTO")) {
                pDefReporte = "reporte_detalle_remesa_texto.jasper";
                if (vParametro1.compareToIgnoreCase("-1") != 0) {
                    //  System.out.println("vParametro1 es diferente de null");
                    parametrosReporte.put("id_ajuste", new BigDecimal(vParametro1));
                }
                parametrosReporte.put("fechainicio", utils.getFecha(vParametro3));
                parametrosReporte.put("fechafinal", utils.getFecha(vParametro4));
            } else if (vParametro2.equals("DIFERENCIAS_EN_NOMINAS")) {
                pDefReporte = "diferencias_en_nomina.jasper";
                //System.out.println("anio: "+parametrosReporte.get("anio").toString());
                //System.out.println("parametros: "+parametrosReporte.get("idproceso1").toString()+" , "+parametrosReporte.get("idproceso2").toString());
                parametrosReporte.put("anio", new BigDecimal(vParametro6));
                parametrosReporte.put("idproceso1", new BigDecimal(vParametro7));
                parametrosReporte.put("idproceso2", new BigDecimal(vParametro8));
            } else if (vParametro2.equals("COMPARACION_ENTRE_NOMINAS")) {
                pDefReporte = "comparacion_entre_nominas.jasper";
                parametrosReporte.put("idproceso1", new BigDecimal(vParametro7));
                parametrosReporte.put("idproceso2", new BigDecimal(vParametro8));
                parametrosReporte.put("usuario", utils.getUsuario());
            } else if (vParametro2.equals("COMPARACION_PLAN_PREST")) {
                pDefReporte = "comparacion_entre_nominas_plan_prest.jasper";
                parametrosReporte.put("idproceso1", new BigDecimal(vParametro7));
                parametrosReporte.put("idproceso2", new BigDecimal(vParametro8));
                parametrosReporte.put("usuario", utils.getUsuario());
            } else if (vParametro2.equals("COMPARACION_ENTRE_NOMINAS_RRHH")) {
                pDefReporte = "comparacion_entre_nominas_ult_ant.jasper";
                //System.out.println("anio: "+parametrosReporte.get("anio").toString());
                //System.out.println("parametros: "+parametrosReporte.get("idproceso1").toString()+" , "+parametrosReporte.get("idproceso2").toString());
                //parametrosReporte.put("anio",new BigDecimal(vParametro6));
                parametrosReporte.put("idproceso1", new BigDecimal(vParametro7));
                parametrosReporte.put("idproceso2", new BigDecimal(vParametro8));
                parametrosReporte.put("usuario", new String(vParametro9));
            } else if (vParametro2.equals("CONCENTRA1") || 
                vParametro2.equals("CONCENTRA2")) {
                pDefReporte = "concentracion_salarios.jasper";
                parametrosReporte.put("dep", new Integer(vParametro1));

                if (vParametro2.equals("CONCENTRA2")) {
                    parametrosReporte.put("p_fecha1", utils.getFecha("01/01/" + utils.getAnioActual()));
                    parametrosReporte.put("p_fecha2", utils.getFecha("31/12/" + utils.getAnioActual()));
                } else {
                    parametrosReporte.put("p_fecha1", utils.getFecha("01/07/" + String.valueOf(new Integer(utils.getAnioActual()) - 1)));
                    parametrosReporte.put("p_fecha2", utils.getFecha("30/06/" + utils.getAnioActual()));
                }
            } else if (vParametro2.equals("REP_PROC_CIRC")) {
                pDefReporte = "proc_circulante.jasper";
            } else if (vParametro2.equals("SIS24I")) {
                pDefReporte = "SIS-24_ID.jasper";
                parametrosReporte.put("pIdForm24", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("REVERGEST")) {
                pDefReporte = "Reversiones.jasper";
                vXmlSource = true;
                vGestionRever = "";

                if (vParametro5 != null && 
                    vParametro5.trim().equals("LICENCIA")) {
                    vGestionRever = "LICENCIA";
                } else if (vParametro5 != null && vParametro5.trim().equals("SUSPENSION IGSS")) {
                    vGestionRever = "SUSP_IGSS";
                } else if (vParametro5 != null && vParametro5.trim().equals("ALTA SUSPENSION IGSS")) {
                    vGestionRever = "ALTA_IGSS";
                } else if (vParametro5 != null && vParametro5.trim().equals("CONTRATO")) {
                    vGestionRever = "CONTRATO";
                } else if (vParametro5 != null && vParametro5.trim().equals("RENUNCIA")) {
                    vGestionRever = "RENUNCIA";
                } else if (vParametro5 != null && vParametro5.trim().equals("RETIRO OBLIGATORIO")) {
                    vGestionRever = "RETIRO_OBLIGATORIO";
                }

                vDeclara = 
                        conexion.getValorConsultaSimpleClob("xmldata", "select sis_xml_util_pkg.GET_MOVS_REVERSION(" + 
                                                            vParametro1 + 
                                                            ",'" + 
                                                            vGestionRever + 
                                                            "').GETCLOBVAL() as xmldata from dual");

                if (vDeclara != null) {

                    vXMLData = this.getXml(vDeclara.toString());

                    parametrosReporte.put(JRXPathQueryExecuterFactory.PARAMETER_XML_DATA_DOCUMENT, vXMLData);
                    parametrosReporte.put(JRXPathQueryExecuterFactory.XML_DATE_PATTERN, "dd/MM/yyyy");
                    parametrosReporte.put(JRXPathQueryExecuterFactory.XML_NUMBER_PATTERN, "##0");
                    parametrosReporte.put(JRXPathQueryExecuterFactory.XML_LOCALE, new java.util.Locale("es", "GT"));
                    parametrosReporte.put(JRParameter.REPORT_LOCALE, new java.util.Locale("es", "GT"));
                    parametrosReporte.put(JRPdfExporterParameter.CHARACTER_ENCODING, "CP1252");
                }
            } else if (vParametro2.equals("SAT-1921")) {
                pDefReporte = "sat-1921.jasper";
                parametrosReporte.put("pAnio", new BigDecimal(vParametro1));
                parametrosReporte.put("pRegistroEmpl", 
                                      new BigDecimal(JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(), 
                                                                                  "flujo_usuario.selRegEmpleado_login").toString()));
            } else if (vParametro2.equals("SAT1921USC")) {
                pDefReporte = "sat-1921_usac.jasper";
                parametrosReporte.put("pAnio", new BigDecimal(vParametro1));
                parametrosReporte.put("pMes", new BigDecimal(vParametro5));
                parametrosReporte.put("pRegistroEmpl", 
                                      new BigDecimal(JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(), 
                                                                                  "flujo_usuario.selRegEmpleado_login").toString()));

            } else if (vParametro2.equals("DISTISR")) {
                pDefReporte = "detalle_dev_isr2.jasper";

                if (vParametro1.toString().equals("E")) {
                    parametrosReporte.put("pOrden", "order by registro_Empleado asc");
                } else if (vParametro1.toString().equals("D")) {
                    parametrosReporte.put("pOrden", "order by total_devolver asc");
                }
                parametrosReporte.put("pAnio", 
                                      new BigDecimal(JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(), 
                                                                                  "flujo_usuario.anioActual").toString()));

            } else if (vParametro2.equals("SIS20BOL")) {
                pDefReporte = "sis20_boleta.jasper";
                parametrosReporte.put("pIdDoc", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("PROCCON_CHEQCIR")) {
                pDefReporte = "circulacion_cheques_concilia.jasper";
                parametrosReporte.put("pFecha", vParametro1);
                if (vParametro5 != null) {
                    parametrosReporte.put("pWhere", " and dep.id_dependencia in ( " + new BigDecimal(vParametro5) + ")");
                } else {
                    parametrosReporte.put("pWhere", "");
                }

                if (vParametro3 != null && !vParametro3.equals("")) {
                    parametrosReporte.put("pFechaAnul", vParametro3);
                } else {
                    parametrosReporte.put("pFechaAnul", vParametro1);
                }

            } else if (vParametro2.equals("PROCCON_CHEQANUL")) {
                /*
                        * se realizo el cambio porque la fecha no venia en el formato correcto 10-03-2014
                        *
                       */
                SimpleDateFormat formatoDelTexto = 
                    new SimpleDateFormat("dd/MM/yyyy");
                Date fecha = null;
                try {
                    //fecha inicio
                    if (vParametro3 != null && 
                        !vParametro3.trim().equals("")) {
                        fecha = formatoDelTexto.parse(vParametro3);
                        vParametro3 = formatoDelTexto.format(fecha);
                    }
                    //fecha fin
                    if (vParametro1 != null && 
                        !vParametro1.trim().equals("")) {
                        fecha = formatoDelTexto.parse(vParametro1);
                        vParametro1 = formatoDelTexto.format(fecha);
                    }

                } catch (ParseException ex) {

                    ex.printStackTrace();

                }
                /*
                        * Fin cambio
                        */
                pDefReporte = "cheques_anulados_concilia.jasper";

                parametrosReporte.put("pFecha", vParametro1);
                parametrosReporte.put("pFechaI", vParametro3);
                parametrosReporte.put("pIdProcesoConciliacion", new BigDecimal(vParametro7));

                if (vParametro5 != null) {
                    parametrosReporte.put("pWhere", " and dep.id_dependencia in ( " + new BigDecimal(vParametro5) + ")");
                } else {
                    parametrosReporte.put("pWhere", "");
                }
            } else if (vParametro2.equals("PROCCON_CHEQINCON")) {
                pDefReporte = "cheques_inconsistentes_concilia.jasper";
                parametrosReporte.put("pIdProcesoConciliacion", new BigDecimal(vParametro7));
                if (vParametro5 != null) {
                    parametrosReporte.put("pWhere", " and dep.id_dependencia in ( " + new BigDecimal(vParametro5) + ")");
                } else {
                    parametrosReporte.put("pWhere", "");
                }

            } else if (vParametro2.equals("REPCNCEMTDO")) {
                pDefReporte = "emitido_conciliacion_pdf.jasper";
                parametrosReporte.put("pIdProcesoConciliacion", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("REPADMONRECORR")) {
                pDefReporte = "rep_recorrido_puesto.jasper";
                parametrosReporte.put("pIdAumento", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("OTRASRENTAS")) {
                //vParametro1 = anio
                //vParametro5 = mes
                String vRegPer = request.getParameter("id3");
                pDefReporte = "detalle_otras_rentas.jasper";
                parametrosReporte.put("p_regEmpleado", new Integer(vRegPer));
                parametrosReporte.put("p_anio", new Integer(vParametro1));
                //parametrosReporte.put("p_mes", new Integer(vParametro5));                    
                parametrosReporte.put("p_mes", new Integer("13"));
            } else if (vParametro2.equals("GASTOS_DE_REPRESENTACION") || vParametro2.equals("VIATICOS") || 
                       vParametro2.equals("HONORARIOS") || vParametro2.equals("BONO_INCENTIVO")) {
                pDefReporte = "otras_rentas_remesa.jasper";
                parametrosReporte.put("ID_REMESA", new Integer(vParametro5));
                parametrosReporte.put("TIPO_RENTA", vParametro2);
            } else if (vParametro2.equals("NOMINA_IGSS")) {
                pDefReporte = "reporte_igss_empleados_nomina.jasper";
                parametrosReporte.put("pRemesa", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("REMESA_PLANILLA_IGSS")) {
                pDefReporte = "remesa_planilla_igss_mes_actual.jasper";
                parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("REMESA_PLANILLA_IGSS_COMP")) {
                pDefReporte = "remesa_planilla_igss_complementaria.jasper";
                parametrosReporte.put("pIdRemesa", new BigDecimal(request.getParameter("var1")));
                parametrosReporte.put("pIdRemesaActual", new BigDecimal(vParametro1));
                vParametro2 = "complementaria_" + request.getParameter("var2") + "_rem_" + vParametro1 + ".txt";
                vTipoVisual = "attachment";
            } else if (vParametro2.equals("SIS24_AUDITORIA")) {
                pDefReporte = "SIS-24_auditoria.jasper";
                parametrosReporte.put("pIdProceso", new BigDecimal(vParametro1));

                if (vParametro3.equals("TODAS")) {
                    parametrosReporte.put("pDependencia", "");
                } else {
                    parametrosReporte.put("pDependencia", " where datos.id_dependencia2=" + new BigDecimal(vParametro3));
                }
            } else if (vParametro2.equals("PROCCON_CHECOBYANUL")) {
                pDefReporte = "cheques_cobrados_y_anulados.jasper";
                parametrosReporte.put("pIdProcCon", new BigDecimal(vParametro7));
            } else if (vParametro2.equals("REMESAPROCSNOMINA")) {
                pDefReporte = "detalle_remesa_proceso_nomina.jasper";
                parametrosReporte.put("pIdRemesa", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("PAGOPLANPERIODO")) {
                pDefReporte = "descuento_plan_periodo_anio.jasper";
                parametrosReporte.put("pPeriodo", new BigDecimal(vParametro1));

                parametrosReporte.put("pCorrelativo", new BigDecimal(vParametro3));

                if (vParametro4.equals("TODAS")) {
                    parametrosReporte.put("pDependencia", "");
                } else {
                    parametrosReporte.put("pDependencia", " and p.d3d4=" + new BigDecimal(vParametro4));
                }
            } else if (vParametro2.equals("PAGOSINPLANPERIODO")) {
                pDefReporte = "sin_descuento_plan_periodo_anio.jasper";
                parametrosReporte.put("pPeriodo", new BigDecimal(vParametro1));

                parametrosReporte.put("pCorrelativo", new BigDecimal(vParametro3));

                if (vParametro4.equals("TODAS")) {
                    parametrosReporte.put("pDependencia", "");
                } else {
                    parametrosReporte.put("pDependencia", " and p.d3d4=" + new BigDecimal(vParametro4));
                }
            } else if (vParametro2.equals("PAGOPLANNOAFECTO")) {
                pDefReporte = "descuento_plan_periodo_anio_no_salir.jasper";
                parametrosReporte.put("pPeriodo", new BigDecimal(vParametro1));

                parametrosReporte.put("pCorrelativo", new BigDecimal(vParametro3));

                if (vParametro4.equals("TODAS")) {
                    parametrosReporte.put("pDependencia", "");
                } else {
                    parametrosReporte.put("pDependencia", " and p.d3d4=" + new BigDecimal(vParametro4));
                }
            } else if (vParametro2.equals("EXCENNOMINA")) {
                pDefReporte = "excesos_en_nomina.jasper";
                parametrosReporte.put("pProceso", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("REP_REINTEGRO")) {
                pDefReporte = "sis-26.jasper";
                parametrosReporte.put("pIdReintegro", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("REP_ORDENPAGO")) {
                pDefReporte = "OrdenDePago1.jasper";
                parametrosReporte.put("pIdReintegro", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("AJUSTEISR")) {
                pDefReporte = "ajuste_isr.jasper";
                parametrosReporte.put("pPeriodo", new BigDecimal(vParametro1));
                parametrosReporte.put("pAnio", new BigDecimal(vParametro5));
            } else if (vParametro2.equals("PROCESO_NOMINAS")) {
                pDefReporte = "nominas_liquidacion.jasper";
                parametrosReporte.put("pProceso", new BigDecimal(vParametro1));
                parametrosReporte.put("pUsuario", utils.getUsuario());

            } else if (vParametro2.equals("REP_ORDENJUD_AUDI")) {
                pDefReporte = "audit_orden_judicial.jasper";
                parametrosReporte.put("pSolicitud", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("EMPLEADO_CURRICULUM_VITAE")) {
                Object oRegistroEmpleado;
                oRegistroEmpleado = 
                        JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(), 
                                                     "flujo_usuario.selRegEmpleado_login");
                if (oRegistroEmpleado != null) {
                    if (vParametro1.equalsIgnoreCase(oRegistroEmpleado.toString()) == 
                        true) {
                        pDefReporte = "form_curriculum_vitae_empl.jasper";
                        parametrosReporte.put("pRegistroEmpleado", new BigDecimal(vParametro1));
                    } else {
                        vGenerarReporte = false;
                        vMensaje = "No se pudo generar el reporte! Acceso Denegado.";
                    }
                } else {
                    vGenerarReporte = false;
                    vMensaje = "No se pudo generar el reporte! Faltan algunos parámetros.";
                }
            } else if (vParametro2.equals("EMPLEADO_CURRICULUM_VITAE_CONSULTA")) {
                pDefReporte = "form_curriculum_vitae_empl.jasper";
                parametrosReporte.put("pRegistroEmpleado", 
                                      new BigDecimal(vParametro1));
            } else if (vParametro2.equals("VISTA_PREVIA_FOTO_EMPLEADO")) {
                Object oRegistroEmpleado;
                oRegistroEmpleado = 
                        JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(), 
                                                     "flujo_usuario.selRegEmpleado_login");
                if (oRegistroEmpleado != null) {
                    if (vParametro1.equalsIgnoreCase(oRegistroEmpleado.toString()) == 
                        true) {
                        pDefReporte = "form_curriculum_vitae_vista_previa_foto.jasper";
                        parametrosReporte.put("pRegistroEmpleado", new BigDecimal(vParametro1));
                    } else {
                        vGenerarReporte = false;
                        vMensaje = "No se pudo generar el reporte! Acceso Denegado.";
                    }
                } else {
                    vGenerarReporte = false;
                    vMensaje = "No se pudo generar el reporte! Faltan algunos parámetros.";
                }
            } else if (vParametro2.equals("PLANILLA031")) {
                pDefReporte = "Planilla031_ISR.jasper";
                parametrosReporte.put("pNumero", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("LIQUIDACION_PLANILLA031")) {
                pDefReporte = "Liquidacion_Planilla031_ISR.jasper";
                parametrosReporte.put("pIdPlanilla", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("SOLICITUD_FALLECIMIENTO")) {
                pDefReporte = "Solicitud_Fallecimiento.jasper";
                parametrosReporte.put("pIdSolicitud", new BigDecimal(vParametro1));

            } else if (vParametro2.equals("AUXCATEDRA")) {
                pDefReporte = "contrato_auxCatedra.jasper";
                parametrosReporte.put("pIdContrato", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("INDEMNIZACION_PRESTACIONES")) {
                pDefReporte = "Indemnizacion_prestaciones_trabajador.jasper";
                parametrosReporte.put("pIdIndemnizacion", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("DARHSJI1_INDEMNIZACION")) {
                pDefReporte = "DARHSJI1_indemnizacion.jasper";
                parametrosReporte.put("pIdIndemnizacion", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("DARHSJI2_INDEMNIZACION")) {
                pDefReporte = "DARHSJI2_indemnizacion.jasper";
                CallableStatement cs;
                String proc = "{CALL SIS_GENERA_RELACION_LABORAL(?)}";
                try {
                    cs = conexion.get_Coneccion().prepareCall(proc);
                    cs.setString(1, vParametro1);
                    //cs.registerOutParameter(2,OracleTypes.NUMBER);
                    cs.execute();
                    cs.close();
                } catch (Exception exep) {
                    exep.printStackTrace();
                }
                parametrosReporte.put("pRegistroPersonal", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("DARHSJI3A_INDEMNIZACION")) {
                pDefReporte = "DARHSJI3A_indemnizacion.jasper";
                parametrosReporte.put("pAnio", new BigDecimal(vParametro1));
                parametrosReporte.put("pCorrelativoAnio", new BigDecimal(vParametro5));
            } else if (vParametro2.equals("DARHPM01_POSTMORTEM")) {
                pDefReporte = "DARHPM01_postmortem.jasper";
                parametrosReporte.put("pIdIndemnizacion", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("DARHPM02_POSTMORTEM")) {
                pDefReporte = "DARHPM02_postmortem.jasper";
                parametrosReporte.put("pIdIndemnizacion", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("DARHPM03_POSTMORTEM")) {
                pDefReporte = "DARHPM03_postmortem.jasper";
                parametrosReporte.put("pIdIndemnizacion", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("DARHPM04_POSTMORTEM")) {
                pDefReporte = "DARHPM04_postmortem.jasper";
                parametrosReporte.put("pIdIndemnizacion", new BigDecimal(vParametro1));
            } else if (vParametro2.equals("REPORTE_PAGOS_MENSUALES")) {
                //System.out.println("El parámetro 6 es [" + vParametro6 + "]");
                parametrosReporte.put("pAnio", new BigDecimal(vParametro6));
                //System.out.println("El parámetro 1 es [" + vParametro1 + "]");
                parametrosReporte.put("pMes", new BigDecimal(vParametro1));
                parametrosReporte.put("pUsuario", utils.getUsuario());
                int tipoReporte = new Integer(vParametro3);
                //System.out.println("El parámetro 3 es [" + tipoReporte + "]");
                String tipoReporteStr = "Undefinied";
                switch (tipoReporte) {
                case 1:
                    pDefReporte = "reporte_nomina_sicoin_mensual.jasper";
                    tipoReporteStr = "GENERAL";
                    break; //SICOÍN
                case 2:
                    pDefReporte = "reporte_nomina_sicoin_mensual_igex.jasper";
                    tipoReporteStr = "IGSS";
                    break; //Complemento IGSS
                case 3:
                    pDefReporte = "reporte_nomina_sicoin_mensual_igex.jasper";
                    tipoReporteStr = "EGRESO216";
                    break; //Provisión de Fondos
                case 4:
                    pDefReporte = "reporte_nomina_sicoin_mensual_igex.jasper";
                    tipoReporteStr = "EGRESO981";
                    break; //Renglón 981
                case 5:
                    pDefReporte = "reporte_nomina_sicoin_mensual_igex.jasper";
                    tipoReporteStr = "VACACIONES";
                    break; //Vacaciones por Retiro
                case 6:
                    pDefReporte = "reporte_nomina_sicoin_mensual.jasper";
                    tipoReporteStr = "REPOSICION";
                    break; //Reposición de Pagos
                case 7:
                    pDefReporte = "reporte_nomina_sicoin_mensual_igex.jasper";
                    tipoReporteStr = "EXTRAORDINARIO";
                    break; //Tiempo Extraordinario
                }
                parametrosReporte.put("pTipoReporte", tipoReporteStr);
            }  else if (vParametro2.equals("REPISR_APLICADO")) {
                Object varUsuario = "";
                varUsuario = 
                        JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), "#{roles_usuario.coordinadorIsr}");
                if (varUsuario.equals(true)) {
                    pDefReporte = "nomina_sueldos_isr.jasper";
                    parametrosReporte.put("pIdProceso", new BigDecimal(vParametro1));
                                
                }
            }  else {
                vGenerarReporte = false;
                vMensaje = "No se pudo generar el reporte! No se encontró el reporte solicitado.";
            }
        } else {
            vGenerarReporte = false;
            vMensaje = "No se pudo generar el reporte! Faltan algunos parámetros.";
        }

        if (vGenerarReporte == true) {
            try {
                ByteArrayOutputStream vBufferBytes = 
                    new ByteArrayOutputStream();
                Number vMargen;
                if (vXmlSource == false)
                    vReporteListo = 
                            JasperFillManager.fillReport(vStr_directorioRep + pDefReporte, parametrosReporte, conexion.get_Coneccion());
                else
                    vReporteListo = JasperFillManager.fillReport(vStr_directorioRep + pDefReporte, parametrosReporte);

                JRPdfExporter vPDFGen = new JRPdfExporter();
                //vPDFGen.setParameter(JRPdfExporterParameter.OFFSET_Y,-25);
                vPDFGen.setParameter(JRPdfExporterParameter.JASPER_PRINT, vReporteListo);
                vPDFGen.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, vBufferBytes);
                vPDFGen.setParameter(JRPdfExporterParameter.CHARACTER_ENCODING, "CP1252");
                // byte[] pdfasbytes = JasperExportManager.exportReportToPdf(vReporteListo);
                // Para modificar los margenes superior e izquierdo del reporte
                if (vMargenSuperior != null || vMargenIzquierdo != null) {
                    vMargen = utils.getNumber(vMargenSuperior);
                    if (vMargen != null) {
                        vPDFGen.setParameter(JRPdfExporterParameter.OFFSET_Y, vMargen.intValue());
                    }
                    vMargen = utils.getNumber(vMargenIzquierdo);
                    if (vMargen != null) {
                        vPDFGen.setParameter(JRPdfExporterParameter.OFFSET_X, vMargen.intValue());
                    }
                }
                vPDFGen.exportReport();
                vNumeroPaginasReporte = vReporteListo.getPages().size();
                if (vNumeroPaginasReporte > 0) {
                    response.setContentType(CONTENT_PDF);
                    // agregado al nombre del reporte el parametro del nombre abreviado del mismo ej:  reporte_SIS-15.pdf
                    String reporte = 
                        vTipoVisual + "; filename=\"Reporte_" + vParametro2.toString() + ".pdf\"";
                    //response.setHeader("Content-disposition","inline; filename=\"Reporte.pdf\"");
                    response.setHeader("Content-disposition", reporte);
                    response.setContentLength(vBufferBytes.size());
                    //outstream.write(vBufferBytes.toByteArray());
                    vBufferBytes.writeTo(outstream);
                } else {
                    response.setContentType(CONTENT_HTML);
                    outstream.write(new String("<h2 align=\"center\"><b>El reporte no tiene datos</b></h2>").getBytes());
                }
                vBufferBytes.flush();
                vBufferBytes.reset();
                vBufferBytes.close();
                vBufferBytes = null;
                // vPDFGen.reset();
                //conexion.cn_Cerrar_coneccion();
                vReporteListo = null;
                vPDFGen = null;
                outstream.flush();
                outstream.close();
            } catch (Exception ex) {
                //ex.printStackTrace();
                outstream.write(new String("No se pudo generar el reporte!!").getBytes());
                outstream.close();
            } finally {
                conexion.cn_Cerrar_coneccion();
            }
        } else {
            conexion.cn_Cerrar_coneccion();
            outstream.write(new String(vMensaje).getBytes());
            outstream.close();
        }
    }

    private Object getValorConsulta(String pConsulta, String pColumna) {

        interfaz_DB datos;
        datos = new interfaz_DB();
        Object valor = datos.getValorConsultaSimple(pColumna, pConsulta);

        return valor;
    }
}
