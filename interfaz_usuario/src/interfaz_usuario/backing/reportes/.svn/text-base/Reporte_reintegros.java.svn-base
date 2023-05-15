package interfaz_usuario.backing.reportes;

import interfaz_usuario.util.JSFUtils;
import interfaz_usuario.util.utils;

import java.text.SimpleDateFormat;

import javax.faces.component.html.HtmlForm;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import oracle.adf.view.faces.component.core.data.CoreColumn;
import oracle.adf.view.faces.component.core.data.CoreTable;
import oracle.adf.view.faces.component.core.input.CoreSelectInputDate;
import oracle.adf.view.faces.component.core.layout.CorePanelBox;
import oracle.adf.view.faces.component.core.layout.CorePanelHorizontal;
import oracle.adf.view.faces.component.core.layout.CoreShowDetailItem;
import oracle.adf.view.faces.component.core.layout.CoreShowOneTab;
import oracle.adf.view.faces.component.core.nav.CoreCommandButton;
import oracle.adf.view.faces.component.core.nav.CoreCommandLink;
import oracle.adf.view.faces.component.core.nav.CoreCommandMenuItem;
import oracle.adf.view.faces.component.core.nav.CorePage;
import oracle.adf.view.faces.component.core.output.CoreMessages;
import oracle.adf.view.faces.component.core.output.CoreObjectSpacer;
import oracle.adf.view.faces.component.core.output.CoreOutputText;
import oracle.adf.view.faces.component.html.HtmlScript;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.domain.Date;

import pkg_util_base_datos.interfaz_DB;

public class Reporte_reintegros {
    private HtmlForm form1;
    private CorePage page1;
    private CoreMessages messages1;
    private CorePanelHorizontal panelHorizontal1;
    private CorePanelBox panelBox1;
    private CoreShowOneTab showOneTab1;
    private CoreShowDetailItem showDetailItem1;
    private CorePanelHorizontal panelHorizontal2;
    private CoreCommandButton cmdBuscar;
    private CoreTable tbl_reintegros;
    private CoreColumn column1;
    private CoreOutputText outputText1;
    private CoreColumn column2;
    private CoreOutputText outputText2;
    private CoreColumn column3;
    private CoreCommandLink cmdLinkIdReintegro;
    private CoreColumn column4;
    private CoreOutputText outputText3;
    private CoreColumn column5;
    private CoreOutputText outputText4;
    private CoreColumn column6;
    private CoreOutputText outputText5;
    private CoreColumn column7;
    private CoreOutputText outputText6;
    private CoreColumn column8;
    private CoreOutputText outputText7;
    private CoreColumn column9;
    private CoreOutputText outputText8;
    private CoreSelectInputDate selectInputFechaInicio;
    private CoreSelectInputDate selectInputFechaFin;
    private CoreObjectSpacer objectSpacer1;
    private CoreObjectSpacer objectSpacer2;
    private HtmlScript script1;
    private CoreColumn column10;
    private CoreCommandButton cmdBtnVerOrdenPago;
    private CoreOutputText outputTxt_mensaje;
    private CoreObjectSpacer objectSpacer3;
    private BindingContainer bindings;
    private CoreCommandMenuItem cmdMenuItem;

    public void setForm1(HtmlForm form1) {
        this.form1 = form1;
    }

    public HtmlForm getForm1() {
        return form1;
    }

    public void setPage1(CorePage page1) {
        this.page1 = page1;
    }

    public CorePage getPage1() {
        return page1;
    }


    public void setMessages1(CoreMessages messages1) {
        this.messages1 = messages1;
    }

    public CoreMessages getMessages1() {
        return messages1;
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

    public void setShowOneTab1(CoreShowOneTab showOneTab1) {
        this.showOneTab1 = showOneTab1;
    }

    public CoreShowOneTab getShowOneTab1() {
        return showOneTab1;
    }

    public void setShowDetailItem1(CoreShowDetailItem showDetailItem1) {
        this.showDetailItem1 = showDetailItem1;
    }

    public CoreShowDetailItem getShowDetailItem1() {
        return showDetailItem1;
    }


    public void setPanelHorizontal2(CorePanelHorizontal panelHorizontal2) {
        this.panelHorizontal2 = panelHorizontal2;
    }

    public CorePanelHorizontal getPanelHorizontal2() {
        return panelHorizontal2;
    }


    public void setCmdBuscar(CoreCommandButton commandButton1) {
        this.cmdBuscar = commandButton1;
    }

    public CoreCommandButton getCmdBuscar() {
        return cmdBuscar;
    }


    public void setTbl_reintegros(CoreTable table1) {
        this.tbl_reintegros = table1;
    }

    public CoreTable getTbl_reintegros() {
        return tbl_reintegros;
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

    public void setCmdLinkIdReintegro(CoreCommandLink commandLink1) {
        this.cmdLinkIdReintegro = commandLink1;
    }

    public CoreCommandLink getCmdLinkIdReintegro() {
        return cmdLinkIdReintegro;
    }

    public void setColumn4(CoreColumn column4) {
        this.column4 = column4;
    }

    public CoreColumn getColumn4() {
        return column4;
    }

    public void setOutputText3(CoreOutputText outputText3) {
        this.outputText3 = outputText3;
    }

    public CoreOutputText getOutputText3() {
        return outputText3;
    }

    public void setColumn5(CoreColumn column5) {
        this.column5 = column5;
    }

    public CoreColumn getColumn5() {
        return column5;
    }

    public void setOutputText4(CoreOutputText outputText4) {
        this.outputText4 = outputText4;
    }

    public CoreOutputText getOutputText4() {
        return outputText4;
    }

    public void setColumn6(CoreColumn column6) {
        this.column6 = column6;
    }

    public CoreColumn getColumn6() {
        return column6;
    }

    public void setOutputText5(CoreOutputText outputText5) {
        this.outputText5 = outputText5;
    }

    public CoreOutputText getOutputText5() {
        return outputText5;
    }

    public void setColumn7(CoreColumn column7) {
        this.column7 = column7;
    }

    public CoreColumn getColumn7() {
        return column7;
    }

    public void setOutputText6(CoreOutputText outputText6) {
        this.outputText6 = outputText6;
    }

    public CoreOutputText getOutputText6() {
        return outputText6;
    }

    public void setColumn8(CoreColumn column8) {
        this.column8 = column8;
    }

    public CoreColumn getColumn8() {
        return column8;
    }

    public void setOutputText7(CoreOutputText outputText7) {
        this.outputText7 = outputText7;
    }

    public CoreOutputText getOutputText7() {
        return outputText7;
    }

    public void setColumn9(CoreColumn column9) {
        this.column9 = column9;
    }

    public CoreColumn getColumn9() {
        return column9;
    }

    public void setOutputText8(CoreOutputText outputText8) {
        this.outputText8 = outputText8;
    }

    public CoreOutputText getOutputText8() {
        return outputText8;
    }

    public void setSelectInputFechaInicio(CoreSelectInputDate selectInputDate1) {
        this.selectInputFechaInicio = selectInputDate1;
    }

    public CoreSelectInputDate getSelectInputFechaInicio() {
        return selectInputFechaInicio;
    }

    public void setSelectInputFechaFin(CoreSelectInputDate selectInputDate2) {
        this.selectInputFechaFin = selectInputDate2;
    }

    public CoreSelectInputDate getSelectInputFechaFin() {
        return selectInputFechaFin;
    }

    public void setObjectSpacer1(CoreObjectSpacer objectSpacer1) {
        this.objectSpacer1 = objectSpacer1;
    }

    public CoreObjectSpacer getObjectSpacer1() {
        return objectSpacer1;
    }

    public void setObjectSpacer2(CoreObjectSpacer objectSpacer2) {
        this.objectSpacer2 = objectSpacer2;
    }

    public CoreObjectSpacer getObjectSpacer2() {
        return objectSpacer2;
    }

    public void setScript1(HtmlScript script1) {
        this.script1 = script1;
    }

    public HtmlScript getScript1() {
        return script1;
    }

    public void setColumn10(CoreColumn column10) {
        this.column10 = column10;
    }

    public CoreColumn getColumn10() {
        return column10;
    }


    public void setCmdBtnVerOrdenPago(CoreCommandButton outputText9) {
        this.cmdBtnVerOrdenPago = outputText9;
    }

    public CoreCommandButton getCmdBtnVerOrdenPago() {
        return cmdBtnVerOrdenPago;
    }

    public void ExecuteWithParams(ActionEvent actionEvent) {
        // Add event code here...
    }

    public void setOutputTxt_mensaje(CoreOutputText outputText9) {
        this.outputTxt_mensaje = outputText9;
    }

    public CoreOutputText getOutputTxt_mensaje() {
        return outputTxt_mensaje;
    }


    public void setObjectSpacer3(CoreObjectSpacer objectSpacer3) {
        this.objectSpacer3 = objectSpacer3;
    }

    public CoreObjectSpacer getObjectSpacer3() {
        return objectSpacer3;
    }


    public BindingContainer getBindings() {
        return this.bindings;
    }

    public void setBindings(BindingContainer bindings) {
        this.bindings = bindings;
    }

    public String cmdBuscar_action() {
        Object fechaInicialObj, fechaFinalObj;
        String fechaInicial, fechaFinal;
        fechaInicialObj = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.attrFecha_inicio.inputValue}"); 
        if ( fechaInicialObj != null && !fechaInicialObj.toString().equalsIgnoreCase("")) {
            fechaInicial = utils.getFechaFormato3("dd/MM/yyyy",fechaInicialObj);
        } else {
            interfaz_DB interfaz = new interfaz_DB();
            String consulta = "select to_char(sysdate-20,'dd/mm/yyyy') as fecha from dual";
            Object vFecha = interfaz.getValorConsultaSimple("fecha",consulta);
            fechaInicial = vFecha.toString();
            interfaz.cn_Cerrar_coneccion(); //cierro la conexion a la base datos
        }
        fechaFinalObj = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.attrFecha_fin.inputValue}");
        if ( fechaFinalObj != null && !fechaFinalObj.toString().equalsIgnoreCase("")) {
            fechaFinal = utils.getFechaFormato3("dd/MM/yyy",fechaFinalObj);
        } else {
            interfaz_DB interfaz = new interfaz_DB();
            String consulta = "select to_char(sysdate,'dd/mm/yyyy') as fecha from dual";
            Object vFecha = interfaz.getValorConsultaSimple("fecha",consulta);
            fechaFinal = vFecha.toString();
            interfaz.cn_Cerrar_coneccion();//cierro la conexión a la base de datos
        }
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.attrMensaje.inputValue}" , fechaInicial + " al " + fechaFinal + ".");
        return null;
    }

    public void setCmdMenuItem(CoreCommandMenuItem commandMenuItem1) {
        this.cmdMenuItem = commandMenuItem1;
    }

    public CoreCommandMenuItem getCmdMenuItem() {
        return cmdMenuItem;
    }
    }
