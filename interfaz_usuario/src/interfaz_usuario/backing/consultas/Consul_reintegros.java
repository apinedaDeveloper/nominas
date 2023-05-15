package interfaz_usuario.backing.consultas;


import interfaz_usuario.util.JSFUtils;

import interfaz_usuario.util.utils;

import javax.faces.application.FacesMessage;
import javax.faces.component.UINamingContainer;
import javax.faces.context.FacesContext;

import oracle.adf.view.faces.component.core.CoreForm;
import oracle.adf.view.faces.component.core.data.CoreColumn;
import oracle.adf.view.faces.component.core.data.CoreTable;
import oracle.adf.view.faces.component.core.input.CoreInputText;
import oracle.adf.view.faces.component.core.input.CoreSelectInputDate;
import oracle.adf.view.faces.component.core.layout.CorePanelForm;
import oracle.adf.view.faces.component.core.nav.CoreCommandButton;
import oracle.adf.view.faces.component.core.nav.CoreCommandLink;
import oracle.adf.view.faces.component.core.nav.CoreCommandMenuItem;
import oracle.adf.view.faces.component.core.nav.CorePage;
import oracle.adf.view.faces.component.core.output.CoreMessages;
import oracle.adf.view.faces.component.core.output.CoreOutputText;
import oracle.adf.view.faces.component.html.HtmlBody;
import oracle.adf.view.faces.component.html.HtmlHead;
import oracle.adf.view.faces.component.html.HtmlHtml;

import oracle.jbo.domain.Date;
import oracle.jbo.uicli.binding.JUIteratorBinding;

public class Consul_reintegros {


    private HtmlHtml html1;
    private HtmlHead head1;
    private HtmlBody body1;
    private CoreMessages messages1;
    private CoreForm form1;
    private CorePage page1;
    private CoreTable table1;
    private CoreColumn column1;
    private CoreOutputText outputText1;
    private CoreColumn column2;
    private CoreOutputText outputText2;
    private CoreColumn column3;
    private CoreOutputText outputText3;
    private CoreColumn column4;
    private CoreOutputText outputText4;
    private CoreColumn column5;
    private CoreOutputText outputText5;
    private CoreColumn column6;
    private CoreOutputText outputText6;
    private CoreColumn column7;
    private CoreOutputText outputText7;
    private CoreColumn column8;
    private CoreOutputText outputText8;
    private CoreColumn column9;
    private CoreOutputText outputText9;
    private CoreColumn column10;
    private CoreOutputText outputText10;
    private CoreColumn column11;
    private CoreOutputText outputText11;
    private CoreColumn column12;
    private CoreOutputText outputText12;
    private CoreColumn column13;
    private CoreOutputText outputText13;
    private CoreColumn column14;
    private CoreOutputText outputText14;
    private CoreColumn column15;
    private CoreOutputText outputText15;
    private CoreColumn column16;
    private CoreOutputText outputText16;
    private CoreColumn column17;
    private CoreOutputText outputText17;
    private CorePanelForm panelForm1;
    private CoreCommandButton commandButton1;
    private CoreCommandLink cmdLinkIdReintegro;
    private CoreCommandButton btnCancelar;
    private CoreColumn columnBtn;
    private CoreCommandButton cmdBtnVerOrdenPago;
    private UINamingContainer logo;
    private CoreMessages messages2;
    private CoreCommandMenuItem cmdMenuItem;
    private CoreInputText inptCui;
    private CoreSelectInputDate slctInputDateFechaInicio;
    private CoreSelectInputDate slctInputDateFechaFin;
    private CoreTable tbl_reintegros;
    private CoreInputText inptRegistroEmpleado;

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

    public void setTable1(CoreTable table1) {
        this.table1 = table1;
    }

    public CoreTable getTable1() {
        return table1;
    }

    public void setColumn1(CoreColumn column1) {
        this.column1 = column1;
    }

    public CoreColumn getColumn1() {
        return column1;
    }

    public void setOutputText1(CoreOutputText outputText1) {
        this.outputText1 = outputText1;
    }

    public CoreOutputText getOutputText1() {
        return outputText1;
    }

    public void setColumn2(CoreColumn column2) {
        this.column2 = column2;
    }

    public CoreColumn getColumn2() {
        return column2;
    }

    public void setOutputText2(CoreOutputText outputText2) {
        this.outputText2 = outputText2;
    }

    public CoreOutputText getOutputText2() {
        return outputText2;
    }

    public void setColumn3(CoreColumn column3) {
        this.column3 = column3;
    }

    public CoreColumn getColumn3() {
        return column3;
    }

    public void setOutputText3(CoreOutputText outputText3) {
        this.outputText3 = outputText3;
    }

    public CoreOutputText getOutputText3() {
        return outputText3;
    }

    public void setColumn4(CoreColumn column4) {
        this.column4 = column4;
    }

    public CoreColumn getColumn4() {
        return column4;
    }

    public void setOutputText4(CoreOutputText outputText4) {
        this.outputText4 = outputText4;
    }

    public CoreOutputText getOutputText4() {
        return outputText4;
    }

    public void setColumn5(CoreColumn column5) {
        this.column5 = column5;
    }

    public CoreColumn getColumn5() {
        return column5;
    }

    public void setOutputText5(CoreOutputText outputText5) {
        this.outputText5 = outputText5;
    }

    public CoreOutputText getOutputText5() {
        return outputText5;
    }

    public void setColumn6(CoreColumn column6) {
        this.column6 = column6;
    }

    public CoreColumn getColumn6() {
        return column6;
    }

    public void setOutputText6(CoreOutputText outputText6) {
        this.outputText6 = outputText6;
    }

    public CoreOutputText getOutputText6() {
        return outputText6;
    }

    public void setColumn7(CoreColumn column7) {
        this.column7 = column7;
    }

    public CoreColumn getColumn7() {
        return column7;
    }

    public void setOutputText7(CoreOutputText outputText7) {
        this.outputText7 = outputText7;
    }

    public CoreOutputText getOutputText7() {
        return outputText7;
    }

    public void setColumn8(CoreColumn column8) {
        this.column8 = column8;
    }

    public CoreColumn getColumn8() {
        return column8;
    }

    public void setOutputText8(CoreOutputText outputText8) {
        this.outputText8 = outputText8;
    }

    public CoreOutputText getOutputText8() {
        return outputText8;
    }

    public void setColumn9(CoreColumn column9) {
        this.column9 = column9;
    }

    public CoreColumn getColumn9() {
        return column9;
    }

    public void setOutputText9(CoreOutputText outputText9) {
        this.outputText9 = outputText9;
    }

    public CoreOutputText getOutputText9() {
        return outputText9;
    }

    public void setColumn10(CoreColumn column10) {
        this.column10 = column10;
    }

    public CoreColumn getColumn10() {
        return column10;
    }

    public void setOutputText10(CoreOutputText outputText10) {
        this.outputText10 = outputText10;
    }

    public CoreOutputText getOutputText10() {
        return outputText10;
    }

    public void setColumn11(CoreColumn column11) {
        this.column11 = column11;
    }

    public CoreColumn getColumn11() {
        return column11;
    }

    public void setOutputText11(CoreOutputText outputText11) {
        this.outputText11 = outputText11;
    }

    public CoreOutputText getOutputText11() {
        return outputText11;
    }

    public void setColumn12(CoreColumn column12) {
        this.column12 = column12;
    }

    public CoreColumn getColumn12() {
        return column12;
    }

    public void setOutputText12(CoreOutputText outputText12) {
        this.outputText12 = outputText12;
    }

    public CoreOutputText getOutputText12() {
        return outputText12;
    }

    public void setColumn13(CoreColumn column13) {
        this.column13 = column13;
    }

    public CoreColumn getColumn13() {
        return column13;
    }

    public void setOutputText13(CoreOutputText outputText13) {
        this.outputText13 = outputText13;
    }

    public CoreOutputText getOutputText13() {
        return outputText13;
    }

    public void setColumn14(CoreColumn column14) {
        this.column14 = column14;
    }

    public CoreColumn getColumn14() {
        return column14;
    }

    public void setOutputText14(CoreOutputText outputText14) {
        this.outputText14 = outputText14;
    }

    public CoreOutputText getOutputText14() {
        return outputText14;
    }

    public void setColumn15(CoreColumn column15) {
        this.column15 = column15;
    }

    public CoreColumn getColumn15() {
        return column15;
    }

    public void setOutputText15(CoreOutputText outputText15) {
        this.outputText15 = outputText15;
    }

    public CoreOutputText getOutputText15() {
        return outputText15;
    }

    public void setColumn16(CoreColumn column16) {
        this.column16 = column16;
    }

    public CoreColumn getColumn16() {
        return column16;
    }

    public void setOutputText16(CoreOutputText outputText16) {
        this.outputText16 = outputText16;
    }

    public CoreOutputText getOutputText16() {
        return outputText16;
    }

    public void setColumn17(CoreColumn column17) {
        this.column17 = column17;
    }

    public CoreColumn getColumn17() {
        return column17;
    }

    public void setOutputText17(CoreOutputText outputText17) {
        this.outputText17 = outputText17;
    }

    public CoreOutputText getOutputText17() {
        return outputText17;
    }

    public void setPanelForm1(CorePanelForm panelForm1) {
        this.panelForm1 = panelForm1;
    }

    public CorePanelForm getPanelForm1() {
        return panelForm1;
    }

    public void setCommandButton1(CoreCommandButton commandButton1) {
        this.commandButton1 = commandButton1;
    }

    public CoreCommandButton getCommandButton1() {
        return commandButton1;
    }

    public void setCmdLinkIdReintegro(CoreCommandLink cmdLinkIdReintegro) {
        this.cmdLinkIdReintegro = cmdLinkIdReintegro;
    }

    public CoreCommandLink getCmdLinkIdReintegro() {
        return cmdLinkIdReintegro;
    }

    public void setBtnCancelar(CoreCommandButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public CoreCommandButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setColumnBtn(CoreColumn columnBtn) {
        this.columnBtn = columnBtn;
    }

    public CoreColumn getColumnBtn() {
        return columnBtn;
    }

    public void setCmdBtnVerOrdenPago(CoreCommandButton cmdBtnVerOrdenPago) {
        this.cmdBtnVerOrdenPago = cmdBtnVerOrdenPago;
    }

    public CoreCommandButton getCmdBtnVerOrdenPago() {
        return cmdBtnVerOrdenPago;
    }
    
    public String btnCancelar_action() {
        this.getInptCui().setValue("");
        this.getInptRegistroEmpleado().setValue("");
        this.getSlctInputDateFechaInicio().setValue("");
        this.getSlctInputDateFechaFin().setValue("");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Limpiar");
        return null;
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
            mensaje = "- " + cantidad + " - registros encontrados (Se muestras únicamente los PENDIENTE DE PAGO)";
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

    public void setLogo(UINamingContainer logo) {
        this.logo = logo;
    }

    public UINamingContainer getLogo() {
        return logo;
    }

    public void setMessages2(CoreMessages messages2) {
        this.messages2 = messages2;
    }

    public CoreMessages getMessages2() {
        return messages2;
    }

    public void setCmdMenuItem(CoreCommandMenuItem cmdMenuItem) {
        this.cmdMenuItem = cmdMenuItem;
    }

    public CoreCommandMenuItem getCmdMenuItem() {
        return cmdMenuItem;
    }

    public void setInptCui(CoreInputText inptCui) {
        this.inptCui = inptCui;
    }

    public CoreInputText getInptCui() {
        return inptCui;
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

    public void setTbl_reintegros(CoreTable tbl_reintegros) {
        this.tbl_reintegros = tbl_reintegros;
    }

    public CoreTable getTbl_reintegros() {
        return tbl_reintegros;
    }

    public void setInptRegistroEmpleado(CoreInputText inptRegistroEmpleado) {
        this.inptRegistroEmpleado = inptRegistroEmpleado;
    }

    public CoreInputText getInptRegistroEmpleado() {
        return inptRegistroEmpleado;
    }
}
