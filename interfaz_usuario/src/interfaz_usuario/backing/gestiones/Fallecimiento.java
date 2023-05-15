package interfaz_usuario.backing.gestiones;

import enlace_datos.util.resulOp;

import interfaz_usuario.usuario;

import interfaz_usuario.util.JSFUtils;
import interfaz_usuario.util.utils;

import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.component.UINamingContainer;
import javax.faces.component.UISelectItems;
import javax.faces.component.UIViewRoot;
import javax.faces.component.html.HtmlOutputLink;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlPanelGroup;
import javax.faces.context.FacesContext;

import oracle.adf.view.faces.component.core.CoreForm;
import oracle.adf.view.faces.component.core.data.CoreColumn;
import oracle.adf.view.faces.component.core.data.CoreTable;
import oracle.adf.view.faces.component.core.data.CoreTableSelectOne;
import oracle.adf.view.faces.component.core.input.CoreInputText;
import oracle.adf.view.faces.component.core.input.CoreSelectInputDate;
import oracle.adf.view.faces.component.core.input.CoreSelectItem;
import oracle.adf.view.faces.component.core.input.CoreSelectOneChoice;
import oracle.adf.view.faces.component.core.layout.CorePanelBox;
import oracle.adf.view.faces.component.core.layout.CorePanelForm;
import oracle.adf.view.faces.component.core.layout.CorePanelHeader;
import oracle.adf.view.faces.component.core.layout.CorePanelHorizontal;
import oracle.adf.view.faces.component.core.layout.CoreShowDetailItem;
import oracle.adf.view.faces.component.core.layout.CoreShowOneTab;
import oracle.adf.view.faces.component.core.nav.CoreCommandButton;
import oracle.adf.view.faces.component.core.nav.CoreCommandLink;
import oracle.adf.view.faces.component.core.nav.CoreCommandMenuItem;
import oracle.adf.view.faces.component.core.nav.CorePage;
import oracle.adf.view.faces.component.core.output.CoreMessages;
import oracle.adf.view.faces.component.core.output.CoreObjectSpacer;
import oracle.adf.view.faces.component.core.output.CoreOutputFormatted;
import oracle.adf.view.faces.component.core.output.CoreOutputText;
import oracle.adf.view.faces.component.html.HtmlBody;
import oracle.adf.view.faces.component.html.HtmlHead;
import oracle.adf.view.faces.component.html.HtmlHtml;
import oracle.adf.view.faces.context.AdfFacesContext;
import oracle.adf.view.faces.event.LaunchEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;


public class Fallecimiento {
    private CoreMessages messages1;
    private HtmlBody body1;
    private HtmlHead head1;
    private HtmlHtml html1;
    private Object vResultadoEjecucion;
    private UISelectItems selectItems2;
    private CoreForm form1;
    private CorePage page1;
    private CoreCommandMenuItem commandMenuItem1;
    private UINamingContainer info1;
    private UINamingContainer menuSwt;
    private UINamingContainer logo;
    private CorePanelBox panelBox1;
    private CoreShowOneTab showOneTab1;
    private CoreShowDetailItem showDetailItem2;
    private CorePanelForm panelForm1;
    private CoreSelectInputDate selectInputDate1;
    private CoreInputText inputText1;
    private CoreObjectSpacer objectSpacer5;
    private CorePanelHorizontal panelHorizontal2;
    private CoreCommandButton btnGuardarFallecimiento;
    private CoreCommandButton btnCancelarFallecimiento;
    private CoreCommandButton btnAutorizacion;
    private CoreObjectSpacer objectSpacer4;
    private CoreShowDetailItem showDetailItem1;
    private CoreObjectSpacer objectSpacer3;
    private CoreTable table1;
    private CoreTableSelectOne tableSelectOne1;
    private CoreOutputText outputText4;
    private CoreColumn column3;
    private HtmlOutputLink outputLink1;
    private HtmlOutputText outputText3;
    private CoreColumn column2;
    private CoreOutputText outputText2;
    private CoreColumn column1;
    private CoreOutputText outputText1;
    private CoreObjectSpacer objectSpacer2;
    private CorePanelHorizontal panelHorizontal1;
    private CoreCommandButton btnAdjuntarArchivo;
    private CoreCommandButton btnActualizar;
    private CoreObjectSpacer objectSpacer1;
    private CoreShowDetailItem showDetailItem3;
    private CorePanelBox panelBox2;
    private CoreCommandLink commandLink1;
    private CoreOutputText outputText15;
    private CoreTable table2;
    private CoreTableSelectOne tableSelectOne2;
    private CoreCommandLink commandButton1;
    private HtmlPanelGroup panelGroup2;
    private CoreCommandButton commandButton5;
    private CoreCommandButton commandButton3;
    private CoreColumn column4111;
    private CoreOutputText outputText16;
    private CoreColumn column411;
    private CoreOutputText outputText12;
    private CoreColumn column51;
    private CoreOutputText outputText9;
    private CoreColumn column6;
    private CoreOutputText outputText14;
    private CoreColumn column7;
    private CoreOutputText outputText13;
    private CoreColumn column8;
    private CoreOutputText outputText8;
    private CoreColumn column9;
    private CoreOutputText outputText11;
    private CoreColumn column10;
    private CoreOutputText outputText18;
    private CoreColumn column11;
    private CoreOutputText outputText5;
    private CoreColumn column12;
    private CoreOutputText outputText6;
    private CoreColumn column5;
    private CoreOutputText outputText91;
    private CorePanelHeader panelHeader1;
    private CoreOutputText outputText17;
    private CorePanelForm panelForm2;
    private CoreInputText inputText2;
    private CoreInputText inputText3;
    private CoreInputText inputText4;
    private CoreInputText inputText5;
    private CorePanelHorizontal panelHorizontal4;
    private CoreInputText inputText6;
    private CoreObjectSpacer objectSpacer6;
    private CoreInputText inputText7;
    private CoreInputText inputText12;
    private CoreObjectSpacer objectSpacer8;
    private CoreInputText inputText8;
    private CoreInputText inputText9;
    private CoreInputText inputText10;
    private CorePanelHorizontal panelHorizontal3;
    private CoreSelectOneChoice selectOneChoice1;
    private UISelectItems selectItems1;
    private CoreObjectSpacer objectSpacer7;
    private CoreSelectOneChoice selectOneChoice2;
    private CoreSelectItem selectItem2;
    private CoreSelectItem selectItem1;
    private CoreSelectInputDate selectInputDate2;
    private CoreInputText inputText11;
    private HtmlPanelGroup panelGroup1;
    private CoreCommandButton commandButton2;
    private CoreCommandButton commandButton6;
    private CorePanelHorizontal panelHorizontal5;
    private CoreOutputFormatted outputFormatted1;
    private CoreInputText inptText_primerNombre;
    private CoreInputText inptText_segundoNombre;
    private CoreInputText inptText_tercerNombre;
    private CoreInputText inptText_primerApellido;
    private CoreInputText inptText_segundoApellido;
    private CoreCommandButton cmdBtn_cancelar_beneficiario;
    private CoreCommandButton cmdBtn_guardar_beneficiario;
    private CoreCommandButton cmdBtn_confirmar_beneficiario;


    public void setMessages1(CoreMessages messages1) {
        this.messages1 = messages1;
    }

    public CoreMessages getMessages1() {
        return messages1;
    }

    public void setBody1(HtmlBody body1) {
        this.body1 = body1;
    }

    public HtmlBody getBody1() {
        return body1;
    }

    public void setHead1(HtmlHead head1) {
        this.head1 = head1;
    }

    public HtmlHead getHead1() {
        return head1;
    }

    public void setHtml1(HtmlHtml html1) {
        this.html1 = html1;
    }

    public HtmlHtml getHtml1() {
        return html1;
    }

    /* ****************************************************************************/
    /* ****************************************************************************/
    /* ****************************************************************************/


    private boolean ejecutar_action(String pNombreAccion) {
        BindingContainer vBnd_binding;
        OperationBinding operationBinding;
        vBnd_binding = 
                (BindingContainer)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                                             "#{bindings}");
        operationBinding = vBnd_binding.getOperationBinding(pNombreAccion);
        vResultadoEjecucion = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return false;
        } else {

            return true;
        }
    }

    public String btnAdjuntarArchivo_action() {
        // Add event code here...
        FacesContext context = FacesContext.getCurrentInstance();
        ViewHandler vh = context.getApplication().getViewHandler();
        // el jspx que se mostrara en forma de  ventana emergente  
        UIViewRoot dialog = 
            vh.createView(context, "/util/adjuntar_archivo.jspx");
        AdfFacesContext a = AdfFacesContext.getCurrentInstance();
        // fijamos el ancho y el alto de la ventana emergente  
        Map windowProperties = new HashMap();
        windowProperties.put("width", new Integer(450));
        windowProperties.put("height", new Integer(350));
        //añadimos mas paremetros que seran recogidos en la jspx ventana  
        Map dialogParameters = new HashMap();
        dialogParameters.put("IdSolicitud", 
                             JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                                        "#{bindings.IdSolicitud.inputValue}").toString());
        dialogParameters.put("Opcion", 2);
        a.launchDialog(dialog, dialogParameters, null, true, windowProperties);
        return null;
    }

    public void Autorizar_Launch_Listener(LaunchEvent launchEvent) {
        // Add event code here...
        Object vValor;
        vValor = 
                JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), "#{bindings.IdSolicitud.inputValue}");
        launchEvent.getDialogParameters().put("IdSolicitud", vValor);
        launchEvent.getDialogParameters().put("IdGestionX", vValor);
        launchEvent.getDialogParameters().put("Gestion", "FALLECIMIENTO");
        launchEvent.getDialogParameters().put("RefreshVw", "licencia");

        vValor = 
                JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), "#{bindings.IdEstado.inputValue}");
        launchEvent.getDialogParameters().put("Estado", vValor);

        launchEvent.getDialogParameters().put("IdProceso", null);
        launchEvent.getDialogParameters().put("IdContrato", null);


    }

    public void setSelectItems2(UISelectItems selectItems2) {
        this.selectItems2 = selectItems2;
    }

    public UISelectItems getSelectItems2() {
        return selectItems2;
    }

    public String borrarBeneficiario_action() {
        boolean vResultado;
        resulOp vMensaResul = new resulOp();
        vResultado = ejecutar_action("Delete");
        if (vResultado == true) {
            vMensaResul.setMensajeError("Se eliminó el beneficiario correctamente.");
            vMensaResul.setCodigoResultado(resulOp.OPE_OK);
            utils.setADFMensaje(vMensaResul);
        }
        return null;
    }

    public String btnGuardarFallecimiento_action() {
        boolean vResultado;
        resulOp vMensaResul = new resulOp();
        vResultado = ejecutar_action("Confirmar");
        if (vResultado == true) {
            usuario.set_opciones(usuario.VISTA_FALLECIMIENTO, 1);
            vMensaResul.setMensajeError("Datos de Fallecimiento guardados correctamente");
            vMensaResul.setCodigoResultado(resulOp.OPE_OK);
            utils.setADFMensaje(vMensaResul);
            ejecutar_action("setCurrentRowWithKey"); //Coloca el puntero en la solicitud actual
        }
        return null;
    }

    public String btnAutorizacion_action() {
        return "dialog:auto_sol";
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

    public void setCommandMenuItem1(CoreCommandMenuItem commandMenuItem1) {
        this.commandMenuItem1 = commandMenuItem1;
    }

    public CoreCommandMenuItem getCommandMenuItem1() {
        return commandMenuItem1;
    }

    public void setInfo1(UINamingContainer info1) {
        this.info1 = info1;
    }

    public UINamingContainer getInfo1() {
        return info1;
    }

    public void setMenuSwt(UINamingContainer menuSwt) {
        this.menuSwt = menuSwt;
    }

    public UINamingContainer getMenuSwt() {
        return menuSwt;
    }

    public void setLogo(UINamingContainer logo) {
        this.logo = logo;
    }

    public UINamingContainer getLogo() {
        return logo;
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

    public void setShowDetailItem2(CoreShowDetailItem showDetailItem2) {
        this.showDetailItem2 = showDetailItem2;
    }

    public CoreShowDetailItem getShowDetailItem2() {
        return showDetailItem2;
    }

    public void setPanelForm1(CorePanelForm panelForm1) {
        this.panelForm1 = panelForm1;
    }

    public CorePanelForm getPanelForm1() {
        return panelForm1;
    }

    public void setSelectInputDate1(CoreSelectInputDate selectInputDate1) {
        this.selectInputDate1 = selectInputDate1;
    }

    public CoreSelectInputDate getSelectInputDate1() {
        return selectInputDate1;
    }

    public void setInputText1(CoreInputText inputText1) {
        this.inputText1 = inputText1;
    }

    public CoreInputText getInputText1() {
        return inputText1;
    }

    public void setObjectSpacer5(CoreObjectSpacer objectSpacer5) {
        this.objectSpacer5 = objectSpacer5;
    }

    public CoreObjectSpacer getObjectSpacer5() {
        return objectSpacer5;
    }

    public void setPanelHorizontal2(CorePanelHorizontal panelHorizontal2) {
        this.panelHorizontal2 = panelHorizontal2;
    }

    public CorePanelHorizontal getPanelHorizontal2() {
        return panelHorizontal2;
    }

    public void setBtnGuardarFallecimiento(CoreCommandButton btnGuardarFallecimiento) {
        this.btnGuardarFallecimiento = btnGuardarFallecimiento;
    }

    public CoreCommandButton getBtnGuardarFallecimiento() {
        return btnGuardarFallecimiento;
    }

    public void setBtnCancelarFallecimiento(CoreCommandButton btnCancelarFallecimiento) {
        this.btnCancelarFallecimiento = btnCancelarFallecimiento;
    }

    public CoreCommandButton getBtnCancelarFallecimiento() {
        return btnCancelarFallecimiento;
    }

    public void setBtnAutorizacion(CoreCommandButton btnAutorizacion) {
        this.btnAutorizacion = btnAutorizacion;
    }

    public CoreCommandButton getBtnAutorizacion() {
        return btnAutorizacion;
    }

    public void setObjectSpacer4(CoreObjectSpacer objectSpacer4) {
        this.objectSpacer4 = objectSpacer4;
    }

    public CoreObjectSpacer getObjectSpacer4() {
        return objectSpacer4;
    }

    public void setShowDetailItem1(CoreShowDetailItem showDetailItem1) {
        this.showDetailItem1 = showDetailItem1;
    }

    public CoreShowDetailItem getShowDetailItem1() {
        return showDetailItem1;
    }

    public void setObjectSpacer3(CoreObjectSpacer objectSpacer3) {
        this.objectSpacer3 = objectSpacer3;
    }

    public CoreObjectSpacer getObjectSpacer3() {
        return objectSpacer3;
    }

    public void setTable1(CoreTable table1) {
        this.table1 = table1;
    }

    public CoreTable getTable1() {
        return table1;
    }

    public void setTableSelectOne1(CoreTableSelectOne tableSelectOne1) {
        this.tableSelectOne1 = tableSelectOne1;
    }

    public CoreTableSelectOne getTableSelectOne1() {
        return tableSelectOne1;
    }

    public void setOutputText4(CoreOutputText outputText4) {
        this.outputText4 = outputText4;
    }

    public CoreOutputText getOutputText4() {
        return outputText4;
    }

    public void setColumn3(CoreColumn column3) {
        this.column3 = column3;
    }

    public CoreColumn getColumn3() {
        return column3;
    }

    public void setOutputLink1(HtmlOutputLink outputLink1) {
        this.outputLink1 = outputLink1;
    }

    public HtmlOutputLink getOutputLink1() {
        return outputLink1;
    }

    public void setOutputText3(HtmlOutputText outputText3) {
        this.outputText3 = outputText3;
    }

    public HtmlOutputText getOutputText3() {
        return outputText3;
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

    public void setObjectSpacer2(CoreObjectSpacer objectSpacer2) {
        this.objectSpacer2 = objectSpacer2;
    }

    public CoreObjectSpacer getObjectSpacer2() {
        return objectSpacer2;
    }

    public void setPanelHorizontal1(CorePanelHorizontal panelHorizontal1) {
        this.panelHorizontal1 = panelHorizontal1;
    }

    public CorePanelHorizontal getPanelHorizontal1() {
        return panelHorizontal1;
    }

    public void setBtnAdjuntarArchivo(CoreCommandButton btnAdjuntarArchivo) {
        this.btnAdjuntarArchivo = btnAdjuntarArchivo;
    }

    public CoreCommandButton getBtnAdjuntarArchivo() {
        return btnAdjuntarArchivo;
    }

    public void setBtnActualizar(CoreCommandButton btnActualizar) {
        this.btnActualizar = btnActualizar;
    }

    public CoreCommandButton getBtnActualizar() {
        return btnActualizar;
    }

    public void setObjectSpacer1(CoreObjectSpacer objectSpacer1) {
        this.objectSpacer1 = objectSpacer1;
    }

    public CoreObjectSpacer getObjectSpacer1() {
        return objectSpacer1;
    }

    public void setShowDetailItem3(CoreShowDetailItem showDetailItem3) {
        this.showDetailItem3 = showDetailItem3;
    }

    public CoreShowDetailItem getShowDetailItem3() {
        return showDetailItem3;
    }

    public void setPanelBox2(CorePanelBox panelBox2) {
        this.panelBox2 = panelBox2;
    }

    public CorePanelBox getPanelBox2() {
        return panelBox2;
    }

    public void setCommandLink1(CoreCommandLink commandLink1) {
        this.commandLink1 = commandLink1;
    }

    public CoreCommandLink getCommandLink1() {
        return commandLink1;
    }

    public void setOutputText15(CoreOutputText outputText15) {
        this.outputText15 = outputText15;
    }

    public CoreOutputText getOutputText15() {
        return outputText15;
    }

    public void setTable2(CoreTable table2) {
        this.table2 = table2;
    }

    public CoreTable getTable2() {
        return table2;
    }

    public void setTableSelectOne2(CoreTableSelectOne tableSelectOne2) {
        this.tableSelectOne2 = tableSelectOne2;
    }

    public CoreTableSelectOne getTableSelectOne2() {
        return tableSelectOne2;
    }

    public void setCommandButton1(CoreCommandLink commandButton1) {
        this.commandButton1 = commandButton1;
    }

    public CoreCommandLink getCommandButton1() {
        return commandButton1;
    }

    public void setPanelGroup2(HtmlPanelGroup panelGroup2) {
        this.panelGroup2 = panelGroup2;
    }

    public HtmlPanelGroup getPanelGroup2() {
        return panelGroup2;
    }

    public void setCommandButton5(CoreCommandButton commandButton5) {
        this.commandButton5 = commandButton5;
    }

    public CoreCommandButton getCommandButton5() {
        return commandButton5;
    }

    public void setCommandButton3(CoreCommandButton commandButton3) {
        this.commandButton3 = commandButton3;
    }

    public CoreCommandButton getCommandButton3() {
        return commandButton3;
    }

    public void setColumn4111(CoreColumn column4111) {
        this.column4111 = column4111;
    }

    public CoreColumn getColumn4111() {
        return column4111;
    }

    public void setOutputText16(CoreOutputText outputText16) {
        this.outputText16 = outputText16;
    }

    public CoreOutputText getOutputText16() {
        return outputText16;
    }

    public void setColumn411(CoreColumn column411) {
        this.column411 = column411;
    }

    public CoreColumn getColumn411() {
        return column411;
    }

    public void setOutputText12(CoreOutputText outputText12) {
        this.outputText12 = outputText12;
    }

    public CoreOutputText getOutputText12() {
        return outputText12;
    }

    public void setColumn51(CoreColumn column51) {
        this.column51 = column51;
    }

    public CoreColumn getColumn51() {
        return column51;
    }

    public void setOutputText9(CoreOutputText outputText9) {
        this.outputText9 = outputText9;
    }

    public CoreOutputText getOutputText9() {
        return outputText9;
    }

    public void setColumn6(CoreColumn column6) {
        this.column6 = column6;
    }

    public CoreColumn getColumn6() {
        return column6;
    }

    public void setOutputText14(CoreOutputText outputText14) {
        this.outputText14 = outputText14;
    }

    public CoreOutputText getOutputText14() {
        return outputText14;
    }

    public void setColumn7(CoreColumn column7) {
        this.column7 = column7;
    }

    public CoreColumn getColumn7() {
        return column7;
    }

    public void setOutputText13(CoreOutputText outputText13) {
        this.outputText13 = outputText13;
    }

    public CoreOutputText getOutputText13() {
        return outputText13;
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

    public void setOutputText11(CoreOutputText outputText11) {
        this.outputText11 = outputText11;
    }

    public CoreOutputText getOutputText11() {
        return outputText11;
    }

    public void setColumn10(CoreColumn column10) {
        this.column10 = column10;
    }

    public CoreColumn getColumn10() {
        return column10;
    }

    public void setOutputText18(CoreOutputText outputText18) {
        this.outputText18 = outputText18;
    }

    public CoreOutputText getOutputText18() {
        return outputText18;
    }

    public void setColumn11(CoreColumn column11) {
        this.column11 = column11;
    }

    public CoreColumn getColumn11() {
        return column11;
    }

    public void setOutputText5(CoreOutputText outputText5) {
        this.outputText5 = outputText5;
    }

    public CoreOutputText getOutputText5() {
        return outputText5;
    }

    public void setColumn12(CoreColumn column12) {
        this.column12 = column12;
    }

    public CoreColumn getColumn12() {
        return column12;
    }

    public void setOutputText6(CoreOutputText outputText6) {
        this.outputText6 = outputText6;
    }

    public CoreOutputText getOutputText6() {
        return outputText6;
    }

    public void setColumn5(CoreColumn column5) {
        this.column5 = column5;
    }

    public CoreColumn getColumn5() {
        return column5;
    }

    public void setOutputText91(CoreOutputText outputText91) {
        this.outputText91 = outputText91;
    }

    public CoreOutputText getOutputText91() {
        return outputText91;
    }

    public void setPanelHeader1(CorePanelHeader panelHeader1) {
        this.panelHeader1 = panelHeader1;
    }

    public CorePanelHeader getPanelHeader1() {
        return panelHeader1;
    }

    public void setOutputText17(CoreOutputText outputText17) {
        this.outputText17 = outputText17;
    }

    public CoreOutputText getOutputText17() {
        return outputText17;
    }

    public void setPanelForm2(CorePanelForm panelForm2) {
        this.panelForm2 = panelForm2;
    }

    public CorePanelForm getPanelForm2() {
        return panelForm2;
    }

    public void setInputText2(CoreInputText inputText2) {
        this.inputText2 = inputText2;
    }

    public CoreInputText getInputText2() {
        return inputText2;
    }

    public void setInputText3(CoreInputText inputText3) {
        this.inputText3 = inputText3;
    }

    public CoreInputText getInputText3() {
        return inputText3;
    }

    public void setInputText4(CoreInputText inputText4) {
        this.inputText4 = inputText4;
    }

    public CoreInputText getInputText4() {
        return inputText4;
    }

    public void setInputText5(CoreInputText inputText5) {
        this.inputText5 = inputText5;
    }

    public CoreInputText getInputText5() {
        return inputText5;
    }

    public void setPanelHorizontal4(CorePanelHorizontal panelHorizontal4) {
        this.panelHorizontal4 = panelHorizontal4;
    }

    public CorePanelHorizontal getPanelHorizontal4() {
        return panelHorizontal4;
    }

    public void setInputText6(CoreInputText inputText6) {
        this.inputText6 = inputText6;
    }

    public CoreInputText getInputText6() {
        return inputText6;
    }

    public void setObjectSpacer6(CoreObjectSpacer objectSpacer6) {
        this.objectSpacer6 = objectSpacer6;
    }

    public CoreObjectSpacer getObjectSpacer6() {
        return objectSpacer6;
    }

    public void setInputText7(CoreInputText inputText7) {
        this.inputText7 = inputText7;
    }

    public CoreInputText getInputText7() {
        return inputText7;
    }

    public void setInputText12(CoreInputText inputText12) {
        this.inputText12 = inputText12;
    }

    public CoreInputText getInputText12() {
        return inputText12;
    }

    public void setObjectSpacer8(CoreObjectSpacer objectSpacer8) {
        this.objectSpacer8 = objectSpacer8;
    }

    public CoreObjectSpacer getObjectSpacer8() {
        return objectSpacer8;
    }

    public void setInputText8(CoreInputText inputText8) {
        this.inputText8 = inputText8;
    }

    public CoreInputText getInputText8() {
        return inputText8;
    }

    public void setInputText9(CoreInputText inputText9) {
        this.inputText9 = inputText9;
    }

    public CoreInputText getInputText9() {
        return inputText9;
    }

    public void setInputText10(CoreInputText inputText10) {
        this.inputText10 = inputText10;
    }

    public CoreInputText getInputText10() {
        return inputText10;
    }

    public void setPanelHorizontal3(CorePanelHorizontal panelHorizontal3) {
        this.panelHorizontal3 = panelHorizontal3;
    }

    public CorePanelHorizontal getPanelHorizontal3() {
        return panelHorizontal3;
    }

    public void setSelectOneChoice1(CoreSelectOneChoice selectOneChoice1) {
        this.selectOneChoice1 = selectOneChoice1;
    }

    public CoreSelectOneChoice getSelectOneChoice1() {
        return selectOneChoice1;
    }

    public void setSelectItems1(UISelectItems selectItems1) {
        this.selectItems1 = selectItems1;
    }

    public UISelectItems getSelectItems1() {
        return selectItems1;
    }

    public void setObjectSpacer7(CoreObjectSpacer objectSpacer7) {
        this.objectSpacer7 = objectSpacer7;
    }

    public CoreObjectSpacer getObjectSpacer7() {
        return objectSpacer7;
    }

    public void setSelectOneChoice2(CoreSelectOneChoice selectOneChoice2) {
        this.selectOneChoice2 = selectOneChoice2;
    }

    public CoreSelectOneChoice getSelectOneChoice2() {
        return selectOneChoice2;
    }

    public void setSelectItem2(CoreSelectItem selectItem2) {
        this.selectItem2 = selectItem2;
    }

    public CoreSelectItem getSelectItem2() {
        return selectItem2;
    }

    public void setSelectItem1(CoreSelectItem selectItem1) {
        this.selectItem1 = selectItem1;
    }

    public CoreSelectItem getSelectItem1() {
        return selectItem1;
    }

    public void setSelectInputDate2(CoreSelectInputDate selectInputDate2) {
        this.selectInputDate2 = selectInputDate2;
    }

    public CoreSelectInputDate getSelectInputDate2() {
        return selectInputDate2;
    }

    public void setInputText11(CoreInputText inputText11) {
        this.inputText11 = inputText11;
    }

    public CoreInputText getInputText11() {
        return inputText11;
    }

    public void setPanelGroup1(HtmlPanelGroup panelGroup1) {
        this.panelGroup1 = panelGroup1;
    }

    public HtmlPanelGroup getPanelGroup1() {
        return panelGroup1;
    }

    public void setCommandButton2(CoreCommandButton commandButton2) {
        this.commandButton2 = commandButton2;
    }

    public CoreCommandButton getCommandButton2() {
        return commandButton2;
    }

    public void setCommandButton6(CoreCommandButton commandButton6) {
        this.commandButton6 = commandButton6;
    }

    public CoreCommandButton getCommandButton6() {
        return commandButton6;
    }


    public void setPanelHorizontal5(CorePanelHorizontal panelHorizontal5) {
        this.panelHorizontal5 = panelHorizontal5;
    }

    public CorePanelHorizontal getPanelHorizontal5() {
        return panelHorizontal5;
    }

    public void setOutputFormatted1(CoreOutputFormatted outputFormatted1) {
        this.outputFormatted1 = outputFormatted1;
    }

    public CoreOutputFormatted getOutputFormatted1() {
        return outputFormatted1;
    }

    //Procedimiento que muestra un mensaje en la pantalla de tipo: 1=INFO, 2=ADVERTENCIA y 3=ERROR

    private void mensaje(String messageText, int tipoAlerta) {
        FacesMessage fm = new FacesMessage(messageText);
        if (tipoAlerta == 1) {
            fm.setSeverity(FacesMessage.SEVERITY_INFO);
        } else if (tipoAlerta == 2) {
            fm.setSeverity(FacesMessage.SEVERITY_WARN);
        } else {
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
        }
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage("El control", fm);
    }

    //Función que verifica si el trabajado fallecido tiene cheques en trámite

    private boolean verificar_cheque_en_tramite() {
        boolean si_procede = false;
        Object en_tramite = 
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                     "verificarChequeTramite");
        if (en_tramite != null && 
            Integer.parseInt(en_tramite.toString()) <= 0) {
            si_procede = true;
        }
        return si_procede;
    }

    public String cmdBtn_guardar_beneficiario_action() {
        if (verificar_cheque_en_tramite()) {
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                     "guardarBeneficiario");
        } else {
            mensaje("No se puede grabar debido a que el colaborador fallecido tiene un pago pendiente de emisión.", 
                    3);
            ejecutar_action("Rollback");
        }
        String bind = "#{bindings.vValidarCuenta.inputValue}";
        FacesContext f = FacesContext.getCurrentInstance();
        JSFUtils.setExpressionValue(f, bind, Boolean.parseBoolean("false"));
        return null;
    }

    public void setInptText_primerNombre(CoreInputText inptText_primerNombre) {
        this.inptText_primerNombre = inptText_primerNombre;
    }

    public CoreInputText getInptText_primerNombre() {
        return inptText_primerNombre;
    }

    public void setInptText_segundoNombre(CoreInputText inptText_segundoNombre) {
        this.inptText_segundoNombre = inptText_segundoNombre;
    }

    public CoreInputText getInptText_segundoNombre() {
        return inptText_segundoNombre;
    }

    public void setInptText_tercerNombre(CoreInputText inptText_tercerNombre) {
        this.inptText_tercerNombre = inptText_tercerNombre;
    }

    public CoreInputText getInptText_tercerNombre() {
        return inptText_tercerNombre;
    }

    public void setInptText_primerApellido(CoreInputText inptText_primerApellido) {
        this.inptText_primerApellido = inptText_primerApellido;
    }

    public CoreInputText getInptText_primerApellido() {
        return inptText_primerApellido;
    }

    public void setInptText_segundoApellido(CoreInputText inptText_segundoApellido) {
        this.inptText_segundoApellido = inptText_segundoApellido;
    }

    public CoreInputText getInptText_segundoApellido() {
        return inptText_segundoApellido;
    }

    public void setCmdBtn_cancelar_beneficiario(CoreCommandButton cmdBtn_cancelar_beneficiario) {
        this.cmdBtn_cancelar_beneficiario = cmdBtn_cancelar_beneficiario;
    }

    public CoreCommandButton getCmdBtn_cancelar_beneficiario() {
        return cmdBtn_cancelar_beneficiario;
    }

    public void setCmdBtn_guardar_beneficiario(CoreCommandButton cmdBtn_guardar_beneficiario) {
        this.cmdBtn_guardar_beneficiario = cmdBtn_guardar_beneficiario;
    }

    public CoreCommandButton getCmdBtn_guardar_beneficiario() {
        return cmdBtn_guardar_beneficiario;
    }

    /*public String cmdBtn_cancelar_beneficario_action() {
        //ejecutar_action("Rollback");
        String bind = "#{bindings.vValidarCuenta.inputValue}";
        FacesContext f = FacesContext.getCurrentInstance();
        JSFUtils.setExpressionValue(f, bind, Boolean.parseBoolean("false"));
        mensaje("Procedimiento cancelado correctamente.", 1); // 1 = tipo INFO
        return null;
    }*/

    public void setCmdBtn_confirmar_beneficiario(CoreCommandButton cmdBtn_confirmar_beneficiario) {
        this.cmdBtn_confirmar_beneficiario = cmdBtn_confirmar_beneficiario;
    }

    public CoreCommandButton getCmdBtn_confirmar_beneficiario() {
        return cmdBtn_confirmar_beneficiario;
    }

    public String cmdBtn_confirmar_beneficiario_action() {
        String mensaje = "Beneficiario confirmado correctamente!!";
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                 "confirmarBeneficiario");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                 "EjecutarBeneficiarios");
        mensaje(mensaje, 1); // 1 = tipo INFO
        return null;
    }
}
