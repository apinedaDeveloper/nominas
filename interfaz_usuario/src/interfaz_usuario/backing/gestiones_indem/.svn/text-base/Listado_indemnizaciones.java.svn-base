package interfaz_usuario.backing.gestiones_indem;

import interfaz_usuario.usuario;

import interfaz_usuario.util.JSFUtils;
import interfaz_usuario.util.utils;

import java.util.List;

import javax.faces.context.FacesContext;

import oracle.adf.view.faces.component.core.CoreForm;
import oracle.adf.view.faces.component.core.data.CoreTable;
import oracle.adf.view.faces.component.core.nav.CoreCommandButton;
import oracle.adf.view.faces.component.core.nav.CoreCommandLink;
import oracle.adf.view.faces.component.core.nav.CorePage;
import oracle.adf.view.faces.component.core.output.CoreMessages;
import oracle.adf.view.faces.component.html.HtmlBody;
import oracle.adf.view.faces.component.html.HtmlHead;
import oracle.adf.view.faces.component.html.HtmlHtml;


public class Listado_indemnizaciones {
    private HtmlHtml html1;
    private HtmlHead head1;
    private HtmlBody body1;
    private CoreMessages messages1;
    private CoreForm form1;
    private CorePage page1;
    private CoreTable tbl_indemnizaciones;
    private CoreCommandButton cmdButton_refrescar;
    private CoreCommandButton cmdButton_nuevaSolicitud;
    private CoreCommandButton cmdButton_refrescar_above;
    private CoreCommandButton cmdButton_nuevaSolicitud_above;

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

    public void setBody1(HtmlBody body1) {
        this.body1 = body1;
    }

    public HtmlBody getBody1() {
        return body1;
    }

    public void setMessages1(CoreMessages messages1) {
        this.messages1 = messages1;
    }

    public CoreMessages getMessages1() {
        return messages1;
    }

    public void setForm1(CoreForm form1) {
        this.form1 = form1;
    }

    public CoreForm getForm1() {
        return form1;
    }

    public void setPage1(CorePage page1) {
        this.page1 = page1;
    }

    public CorePage getPage1() {
        return page1;
    }

    public void setTbl_indemnizaciones(CoreTable tbl_indemnizaciones) {
        this.tbl_indemnizaciones = tbl_indemnizaciones;
    }

    public CoreTable getTbl_indemnizaciones() {
        return tbl_indemnizaciones;
    }

    public void setCmdButton_refrescar(CoreCommandButton cmdButton_refrescar) {
        this.cmdButton_refrescar = cmdButton_refrescar;
    }

    public CoreCommandButton getCmdButton_refrescar() {
        return cmdButton_refrescar;
    }

    public void setCmdButton_nuevaSolicitud(CoreCommandButton cmdButton_nuevaSolicitud) {
        this.cmdButton_nuevaSolicitud = cmdButton_nuevaSolicitud;
    }

    public CoreCommandButton getCmdButton_nuevaSolicitud() {
        return cmdButton_nuevaSolicitud;
    }

    public void setCmdButton_refrescar_above(CoreCommandButton cmdButton_refrescar_above) {
        this.cmdButton_refrescar_above = cmdButton_refrescar_above;
    }

    public CoreCommandButton getCmdButton_refrescar_above() {
        return cmdButton_refrescar_above;
    }

    public void setCmdButton_nuevaSolicitud_above(CoreCommandButton cmdButton_nuevaSolicitud_above) {
        this.cmdButton_nuevaSolicitud_above = cmdButton_nuevaSolicitud_above;
    }

    public CoreCommandButton getCmdButton_nuevaSolicitud_above() {
        return cmdButton_nuevaSolicitud_above;
    }

    //Función que refresca la tabla de solicitudes de indemnización por retiro

    private void Refrescar_tabla() {
        List vErrores;
        vErrores = 
                JSFUtils.EjecutarAcccion3(FacesContext.getCurrentInstance(), "ObtenerSolicitudes");
    }

    //Función que invoca el formulario de Nueva Solicitud de Indemnización por Retiro Definitivo

    private String Invocar_Solicitud_Nueva() {
        usuario.set_opciones(usuario.VISTA_OPERACION, utils.getInteger("1"));
        return "ir_a_detalle_indemnizacion";
    }

    public String cmdButton_refrescar_action() {
        Refrescar_tabla();
        return null;
    }

    public String cmdButton_nuevaSolicitud_action() {
        return Invocar_Solicitud_Nueva();
    }

    public String cmdButton_refrescar_above_action() {
        Refrescar_tabla();
        return null;
    }

    public String cmdButton_nuevaSolicitud_above_action() {
        return Invocar_Solicitud_Nueva();
    }

    public String cmdLinkRegistroPersonal_action() {
        // Add event code here..
        usuario.set_opciones(usuario.VISTA_OPERACION, utils.getInteger("2"));
        return "ir_a_detalle_indemnizacion";
    }
}
