package interfaz_usuario.backing.reportes;

import interfaz_usuario.util.generar_reporte;
import interfaz_usuario.util.reporteParams;

import java.io.File;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;



import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;

import net.sf.jasperreports.engine.xml.JRXmlLoader;


/*
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.engine.design.JasperDesign;
*/


import pkg_util_base_datos.interfaz_DB;


import oracle.adf.view.faces.component.html.HtmlHead;
import oracle.adf.view.faces.component.html.HtmlHtml;

public class Imp_contrato {

    private HtmlHtml html1;
    private HtmlHead head1;

    public Imp_contrato(){
    generar_reporte reporteContrato;
    HashMap parametros=new HashMap();

    reporteContrato=new generar_reporte();
    Object vOpcion2=1;

    if (reporteParams.getParametros()!=null && reporteParams.getParametros().size()>0){
        reporteContrato.setParametros(reporteParams.getParametros());
        parametros=reporteParams.getParametros();
        vOpcion2=parametros.get("opcion");
        
        if(parametros.containsKey("opcion")){
             parametros.remove("opcion");
        }
        if(vOpcion2.toString().compareTo("1")==0){
            reporteContrato.generarReportePDF(FacesContext.getCurrentInstance(),"nombramientos.jasper");
        }else{ //Opcion seria 2
            reporteContrato.generarReportePDF(FacesContext.getCurrentInstance(),"nombramientosSICOIN.jasper");
        }
    }
}


    public void setHtml1(HtmlHtml html1) {
        this.html1 = html1;
    }

    public HtmlHtml getHtml1() {
        return html1;
    }

    public void setHead1(HtmlHead head1) {
        this.head1 = head1;
    }

    public HtmlHead getHead1() {
        return head1;
    }


    public String commandButton1_action() {
        // Add event code here...
        return null;
    }


}
