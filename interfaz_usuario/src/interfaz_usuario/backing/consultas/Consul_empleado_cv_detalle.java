package interfaz_usuario.backing.consultas;

import interfaz_usuario.util.JSFUtils;

import javax.faces.application.FacesMessage;
import javax.faces.component.UINamingContainer;

import javax.faces.context.FacesContext;

import oracle.adf.view.faces.component.core.CoreForm;
import oracle.adf.view.faces.component.core.data.CoreTable;
import oracle.adf.view.faces.component.core.layout.CorePanelBox;
import oracle.adf.view.faces.component.core.layout.CorePanelHorizontal;
import oracle.adf.view.faces.component.core.nav.CoreCommandButton;
import oracle.adf.view.faces.component.core.nav.CoreCommandMenuItem;
import oracle.adf.view.faces.component.core.nav.CorePage;
import oracle.adf.view.faces.component.core.output.CoreMessages;
import oracle.adf.view.faces.component.html.HtmlHtml;

public class Consul_empleado_cv_detalle {
    private HtmlHtml html1;
    private CoreForm form1;
    private CorePage page1;
    private UINamingContainer logo;
    private CoreCommandMenuItem cmdMenuItem;
    private CoreTable sis_foto_empleado_table;
    private CoreCommandButton btn_retornar;
    private CoreTable sis_documentos_adjuntos_table;
    private CoreMessages messages1;
    private CoreCommandButton btn_ver_cv;
    private CorePanelHorizontal panelHorizontal1;
    private CorePanelBox panelBox1;
    private CoreTable sis_boleto_ornato_table;

    public void setHtml1(HtmlHtml html1) {
        this.html1 = html1;
    }

    public HtmlHtml getHtml1() {
        return html1;
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

    public void setLogo(UINamingContainer logo) {
        this.logo = logo;
    }

    public UINamingContainer getLogo() {
        return logo;
    }

    public void setCmdMenuItem(CoreCommandMenuItem cmdMenuItem) {
        this.cmdMenuItem = cmdMenuItem;
    }

    public CoreCommandMenuItem getCmdMenuItem() {
        return cmdMenuItem;
    }

    public void setSis_foto_empleado_table(CoreTable sis_foto_empleado_table) {
        this.sis_foto_empleado_table = sis_foto_empleado_table;
    }

    public CoreTable getSis_foto_empleado_table() {
        return sis_foto_empleado_table;
    }

    public void setBtn_retornar(CoreCommandButton btn_retornar) {
        this.btn_retornar = btn_retornar;
    }

    public CoreCommandButton getBtn_retornar() {
        return btn_retornar;
    }

    public String btn_retornar_action() {
        // Add event code here...
        return "retornar_consul_empleado_cv";
    }

    public void setSis_documentos_adjuntos_table(CoreTable sis_documentos_adjuntos_table) {
        this.sis_documentos_adjuntos_table = sis_documentos_adjuntos_table;
    }

    public CoreTable getSis_documentos_adjuntos_table() {
        return sis_documentos_adjuntos_table;
    }

    //Procedimiento que muestra un mensaje en la pantalla de tipo: 1=INFO, 2=ADVERTENCIA y 3=ERROR
    private void mensaje(String messageText, int tipoAlerta) {
        FacesMessage fm = new FacesMessage(messageText);
        if ( tipoAlerta == 1) {
            fm.setSeverity(FacesMessage.SEVERITY_INFO);
        } else if ( tipoAlerta == 2) {
            fm.setSeverity(FacesMessage.SEVERITY_WARN);
        } else {
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
        }
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, fm);
    }
    
    public String btn_revertir_confirmacion_foto_action() {
        String mensaje = "Operación realizada correctamente!!";
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"RevertirConfirmacionFoto");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ExeFotoEmpleado");
        mensaje(mensaje, 1); // 1 = tipo INFO
        return null;
    }

    public String btn_revertir_confirmacion_documento_action() {
        String mensaje = "Operación realizada correctamente!!";
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"RevertirConfirmacionDocumento");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ExeDocumentosAdjuntos");
        mensaje(mensaje, 1); // 1 = tipo INFO
        return null;
    }

    public void setMessages1(CoreMessages messages1) {
        this.messages1 = messages1;
    }

    public CoreMessages getMessages1() {
        return messages1;
    }

    public void setBtn_ver_cv(CoreCommandButton btn_ver_cv) {
        this.btn_ver_cv = btn_ver_cv;
    }

    public CoreCommandButton getBtn_ver_cv() {
        return btn_ver_cv;
    }

    public void setPanelHorizontal1(CorePanelHorizontal panelHorizontal1) {
        this.panelHorizontal1 = panelHorizontal1;
    }

    public CorePanelHorizontal getPanelHorizontal1() {
        return panelHorizontal1;
    }

    public void setPanelBox1(CorePanelBox panelBox1) {
        this.panelBox1 = panelBox1;
    }

    public CorePanelBox getPanelBox1() {
        return panelBox1;
    }

    public void setSis_boleto_ornato_table(CoreTable sis_boleto_ornato_table) {
        this.sis_boleto_ornato_table = sis_boleto_ornato_table;
    }

    public CoreTable getSis_boleto_ornato_table() {
        return sis_boleto_ornato_table;
    }
}
