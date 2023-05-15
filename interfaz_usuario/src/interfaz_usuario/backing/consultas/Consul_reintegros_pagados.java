package interfaz_usuario.backing.consultas;

import enlace_datos.util.resulOp;

import interfaz_usuario.util.JSFUtils;

import interfaz_usuario.util.utils;

import javax.faces.application.FacesMessage;
import javax.faces.component.UINamingContainer;

import javax.faces.context.FacesContext;

import oracle.adf.view.faces.component.core.CoreForm;
import oracle.adf.view.faces.component.core.data.CoreTable;
import oracle.adf.view.faces.component.core.input.CoreInputText;
import oracle.adf.view.faces.component.core.input.CoreSelectInputDate;
import oracle.adf.view.faces.component.core.layout.CorePanelForm;
import oracle.adf.view.faces.component.core.nav.CoreCommandButton;
import oracle.adf.view.faces.component.core.nav.CoreCommandLink;
import oracle.adf.view.faces.component.core.nav.CoreCommandMenuItem;
import oracle.adf.view.faces.component.core.nav.CorePage;
import oracle.adf.view.faces.component.core.output.CoreMessages;
import oracle.adf.view.faces.component.html.HtmlBody;
import oracle.adf.view.faces.component.html.HtmlHead;
import oracle.adf.view.faces.component.html.HtmlHtml;

import oracle.jbo.domain.Date;
import oracle.jbo.uicli.binding.JUIteratorBinding;

public class Consul_reintegros_pagados {
    private HtmlHtml html1;
    private HtmlHead head1;
    private HtmlBody body1;
    private CoreMessages messages1;
    private UINamingContainer logo;
    private CoreCommandMenuItem cmdMenuItem;
    private CoreForm form1;
    private CorePage page1;
    private CorePanelForm panelForm1;
    private CoreMessages messages2;
    private CoreTable tbl_reintegros;
    private CoreInputText inptCui;
    private CoreInputText inptRegistroEmpleado;
    private CoreCommandButton btnBuscar;
    private CoreCommandButton btnLimpiar;
    private CoreCommandButton btnVerOrdenPago;
    private CoreCommandLink cmdLinkIdReintegro;
    private CoreSelectInputDate slctInputDateFechaInicio;
    private CoreSelectInputDate slctInputDateFechaFin;

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

    public void setPage1(CorePage page1) {
        this.page1 = page1;
    }

    public CorePage getPage1() {
        return page1;
    }

    public void setPanelForm1(CorePanelForm panelForm1) {
        this.panelForm1 = panelForm1;
    }

    public CorePanelForm getPanelForm1() {
        return panelForm1;
    }

    public void setMessages2(CoreMessages messages2) {
        this.messages2 = messages2;
    }

    public CoreMessages getMessages2() {
        return messages2;
    }

    public void setTbl_reintegros(CoreTable tbl_reintegros) {
        this.tbl_reintegros = tbl_reintegros;
    }

    public CoreTable getTbl_reintegros() {
        return tbl_reintegros;
    }

    public void setInptCui(CoreInputText inptCui) {
        this.inptCui = inptCui;
    }

    public CoreInputText getInptCui() {
        return inptCui;
    }

    public void setInptRegistroEmpleado(CoreInputText inptRegistroEmpleado) {
        this.inptRegistroEmpleado = inptRegistroEmpleado;
    }

    public CoreInputText getInptRegistroEmpleado() {
        return inptRegistroEmpleado;
    }

    public void setBtnBuscar(CoreCommandButton btnBuscar) {
        this.btnBuscar = btnBuscar;
    }

    public CoreCommandButton getBtnBuscar() {
        return btnBuscar;
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
    
    //Método que invocará al procedimiento BuscarPorFiltro del View Object Consulta_reintegros_vw
    private void realizarBusquedaPorFiltro() {
        String mensaje;
        JUIteratorBinding ib;
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"busquedaPorFiltro");
        ib = (JUIteratorBinding) JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.consul_reintegros_vw1Iterator}");
        if ( ib.getEstimatedRowCount() <= 0) {
            mensaje = "No se encontraron registros con la información ingresada en su Ubicación asignada.";
            mensaje(mensaje, 1); // tipo INFO
        } else {
            long cantidad = ib.getEstimatedRowCount();
            mensaje = "- " + cantidad + " - registros encontrados (Se muestras únicamente los PAGADOS)";
            mensaje(mensaje, 1); // tipo INFO
        }
    }
    
    //Método que invocará al procedimiento  del View Object Consulta_reintegros_vw
    private void reiniciarTablaDeResultados() {
        String mensaje;
        JUIteratorBinding ib;
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Ejecutar");
        ib = (JUIteratorBinding) JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.consul_reintegros_vw1Iterator}");
        if ( ib.getEstimatedRowCount() <= 0) {
            mensaje = "Sin registros encontrados en su Ubicación asignada.";
            mensaje(mensaje, 1); // tipo INFO
        } else {
            long cantidad = ib.getEstimatedRowCount();
            mensaje = "- " + cantidad + " - registros encontrados (Se muestras únicamente los PAGADOS)";
            mensaje(mensaje, 1); // tipo INFO
        }
    }
    
    public String btnBuscar_action() {
        String mensaje;
        Object cuiObj, registroObj, fechaInicioObj, fechaFinObj;
        fechaInicioObj = this.getSlctInputDateFechaInicio().getValue();
        fechaFinObj = this.getSlctInputDateFechaFin().getValue();
        if( fechaInicioObj != null && fechaFinObj != null ) {
            //Verificando que la fecha de inicio sea menor o igual a la fecha fin
            Date fechaInicio =  utils.getFechaOracle(utils.getFechaFormato3("dd/MM/yyyy", fechaInicioObj));
            Date fechaFin = utils.getFechaOracle(utils.getFechaFormato3("dd/MM/yyyy", fechaFinObj));
            if( fechaInicio.compareTo(fechaFin) > 0 ) {
                mensaje = "La Fecha de Inicio es mayor que la Fecha Fin.";
                mensaje(mensaje, 3); // tipo ERROR
            } else {
                realizarBusquedaPorFiltro();
            }    
        } else {
            cuiObj = this.getInptCui().getValue();
            registroObj = this.getInptRegistroEmpleado().getValue();
            if ( cuiObj == null && registroObj == null && fechaInicioObj == null && fechaFinObj == null ) {
                reiniciarTablaDeResultados();
            } else {
                realizarBusquedaPorFiltro();
            }
        }
        return null;
    }

    public void setBtnLimpiar(CoreCommandButton btnLimpiar) {
        this.btnLimpiar = btnLimpiar;
    }

    public CoreCommandButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public String btnLimpiar_action() {
        this.getInptCui().setValue("");
        this.getInptRegistroEmpleado().setValue("");
        this.getSlctInputDateFechaInicio().setValue("");
        this.getSlctInputDateFechaFin().setValue("");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Limpiar");
        return null;
    }

    public void setBtnVerOrdenPago(CoreCommandButton btnVerOrdenPago) {
        this.btnVerOrdenPago = btnVerOrdenPago;
    }

    public CoreCommandButton getBtnVerOrdenPago() {
        return btnVerOrdenPago;
    }

    public void setCmdLinkIdReintegro(CoreCommandLink cmdLinkIdReintegro) {
        this.cmdLinkIdReintegro = cmdLinkIdReintegro;
    }

    public CoreCommandLink getCmdLinkIdReintegro() {
        return cmdLinkIdReintegro;
    }

    public void setSlctInputDateFechaInicio(CoreSelectInputDate slctInputDateFechaInicio) {
        this.slctInputDateFechaInicio = slctInputDateFechaInicio;
    }

    public CoreSelectInputDate getSlctInputDateFechaInicio() {
        return slctInputDateFechaInicio;
    }

    public void setSlctInputDateFechaFin(CoreSelectInputDate slctInputDateFechaFin) {
        this.slctInputDateFechaFin = slctInputDateFechaFin;
    }

    public CoreSelectInputDate getSlctInputDateFechaFin() {
        return slctInputDateFechaFin;
    }
}
