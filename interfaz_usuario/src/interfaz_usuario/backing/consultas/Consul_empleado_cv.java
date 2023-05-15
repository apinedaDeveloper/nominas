package interfaz_usuario.backing.consultas;

import enlace_datos.util.resulOp;

import interfaz_usuario.util.JSFUtils;
import interfaz_usuario.util.utils;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UINamingContainer;

import javax.faces.context.FacesContext;

import oracle.adf.model.BindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.faces.component.core.CoreForm;
import oracle.adf.view.faces.component.core.data.CoreTable;
import oracle.adf.view.faces.component.core.input.CoreInputText;
import oracle.adf.view.faces.component.core.input.CoreSelectBooleanRadio;
import oracle.adf.view.faces.component.core.layout.CorePanelBox;
import oracle.adf.view.faces.component.core.layout.CorePanelHorizontal;
import oracle.adf.view.faces.component.core.nav.CoreCommandButton;
import oracle.adf.view.faces.component.core.nav.CoreCommandMenuItem;
import oracle.adf.view.faces.component.core.nav.CorePage;
import oracle.adf.view.faces.component.core.output.CoreMessages;

import oracle.jbo.Row;
import oracle.jbo.uicli.binding.JUIteratorBinding;

public class Consul_empleado_cv {
    private CorePage page1;
    private UINamingContainer logo;
    private CoreCommandMenuItem cmdMenuItem;
    private CoreForm form1;
    private CorePanelHorizontal panelHorizontal1;
    private CorePanelBox panelBox1;
    private CoreCommandButton btn_buscar;
    private CoreInputText inptRegistroPersonal;
    private CoreInputText inptCui;
    private CoreTable tbl_empleados;
    private CoreCommandButton btn_cancelar;
    private CoreMessages messages1;

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

    public void setForm1(CoreForm form1) {
        this.form1 = form1;
    }

    public CoreForm getForm1() {
        return form1;
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

    public void setBtn_buscar(CoreCommandButton btn_buscar) {
        this.btn_buscar = btn_buscar;
    }

    public CoreCommandButton getBtn_buscar() {
        return btn_buscar;
    }

    //Procedimiento que muestra un mensaje en la pantalla de tipo: 1=INFO, 2=ADVERTENCIA o 3=ERROR
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
    
    public String btn_buscar_action() {
        String mensaje;
        if ( this.getInptCui().getValue() != null || this.getInptRegistroPersonal().getValue() != null ) {
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Limpiar"); //primero limpiamos
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ConsultaEmpleado"); //consultamos
            JUIteratorBinding ib;
            ib = (JUIteratorBinding) JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.Consulta_CV_VwIterator}"); 
            if ( ib.getEstimatedRowCount() <= 0) {
                mensaje = "No se encontró empleado con la información ingresada.";
                mensaje(mensaje, 1); // 1 = tipo INFO
            }
        } else {
            mensaje = "Ingrese CUI o Registro de Empleado por favor.";
            mensaje(mensaje, 3); // 3 = tipo ERROR
        }
        return null;
    }

    public void setInptRegistroPersonal(CoreInputText inptRegistroPersonal) {
        this.inptRegistroPersonal = inptRegistroPersonal;
    }

    public CoreInputText getInptRegistroPersonal() {
        return inptRegistroPersonal;
    }

    public void setInptCui(CoreInputText inptCui) {
        this.inptCui = inptCui;
    }

    public CoreInputText getInptCui() {
        return inptCui;
    }

    public void setTbl_empleados(CoreTable tbl_empleados) {
        this.tbl_empleados = tbl_empleados;
    }

    public CoreTable getTbl_empleados() {
        return tbl_empleados;
    }

    public String cmlnk_reg_empleado_action() {
        // Add event code here...
        return "ver_empleado_cv";
    }

    public void setBtn_cancelar(CoreCommandButton btn_cancelar) {
        this.btn_cancelar = btn_cancelar;
    }

    public CoreCommandButton getBtn_cancelar() {
        return btn_cancelar;
    }

    public String btn_cancelar_action() {
        this.getInptCui().setValue("");
        this.getInptRegistroPersonal().setValue("");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Limpiar");
        return null;
    }

    public void setMessages1(CoreMessages messages1) {
        this.messages1 = messages1;
    }

    public CoreMessages getMessages1() {
        return messages1;
    }
}
