package interfaz_usuario.backing.gestiones;

import enlace_datos.util.resulOp;

import interfaz_usuario.usuario;

import interfaz_usuario.util.JSFUtils;
import interfaz_usuario.util.utils;

import java.util.HashMap;
import java.util.Map;

import javax.faces.application.ViewHandler;
import javax.faces.component.UINamingContainer;
import javax.faces.component.UISelectItems;
import javax.faces.component.UIViewRoot;
import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlOutputLink;
import javax.faces.component.html.HtmlOutputText;

import javax.faces.context.FacesContext;

import oracle.adf.view.faces.component.core.data.CoreColumn;
import oracle.adf.view.faces.component.core.data.CoreTable;
import oracle.adf.view.faces.component.core.data.CoreTableSelectOne;
import oracle.adf.view.faces.component.core.input.CoreInputText;
import oracle.adf.view.faces.component.core.input.CoreSelectInputDate;
import oracle.adf.view.faces.component.core.input.CoreSelectOneChoice;
import oracle.adf.view.faces.component.core.layout.CorePanelBox;
import oracle.adf.view.faces.component.core.layout.CorePanelForm;
import oracle.adf.view.faces.component.core.layout.CorePanelHorizontal;
import oracle.adf.view.faces.component.core.layout.CoreShowDetailItem;
import oracle.adf.view.faces.component.core.layout.CoreShowOneTab;
import oracle.adf.view.faces.component.core.nav.CoreCommandButton;
import oracle.adf.view.faces.component.core.nav.CoreCommandMenuItem;
import oracle.adf.view.faces.component.core.nav.CorePage;
import oracle.adf.view.faces.component.core.output.CoreMessages;
import oracle.adf.view.faces.component.core.output.CoreObjectSpacer;
import oracle.adf.view.faces.component.core.output.CoreOutputText;
import oracle.adf.view.faces.component.html.HtmlBody;
import oracle.adf.view.faces.component.html.HtmlHead;
import oracle.adf.view.faces.component.html.HtmlHtml;

import oracle.adf.view.faces.context.AdfFacesContext;

import oracle.adf.view.faces.event.LaunchEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class retiro_obligatorio {
    private CoreObjectSpacer objectSpacer1;
    private CoreCommandButton btnActualizar;
    private CoreCommandButton btnAdjuntarArchivo;
    private CorePanelHorizontal panelHorizontal1;
    private CoreObjectSpacer objectSpacer2;
    private CoreOutputText outputText1;
    private CoreColumn column1;
    private CoreOutputText outputText2;
    private CoreColumn column2;
    private HtmlOutputText outputText3;
    private HtmlOutputLink outputLink1;
    private CoreColumn column3;
    private CoreOutputText outputText4;
    private CoreTableSelectOne tableSelectOne1;
    private CoreTable table1;
    private CoreObjectSpacer objectSpacer3;
    private CoreShowDetailItem showDetailItem1;
    private CoreCommandButton btnAutorizacion;
    private CoreObjectSpacer objectSpacer4;
    private CoreCommandButton btnCancelarRetiro;
    private CoreCommandButton btnGrabarRetiro;
    private CorePanelHorizontal panelHorizontal2;
    private CoreObjectSpacer objectSpacer5;
    private CoreInputText inputText1;
    private CoreSelectInputDate selectInputDate1;
    private UISelectItems selectItems1;
    private CoreSelectOneChoice selectOneChoice1;
    private CorePanelForm panelForm1;
    private CoreShowDetailItem showDetailItem2;
    private CoreShowOneTab showOneTab1;
    private CorePanelBox panelBox1;
    private UINamingContainer logo;
    private UINamingContainer menuSwt;
    private UINamingContainer info1;
    private CoreCommandMenuItem commandMenuItem1;
    private CorePage page1;
    private HtmlForm form1;
    private CoreMessages messages1;
    private HtmlBody body1;
    private HtmlHead head1;
    private HtmlHtml html1;
    private Object vResultadoEjecucion;

    public retiro_obligatorio() {
    }

    public void setObjectSpacer1(CoreObjectSpacer objectSpacer1) {
        this.objectSpacer1 = objectSpacer1;
    }

    public CoreObjectSpacer getObjectSpacer1() {
        return objectSpacer1;
    }

    public void setBtnActualizar(CoreCommandButton commandButton1) {
        this.btnActualizar = commandButton1;
    }

    public CoreCommandButton getBtnActualizar() {
        return btnActualizar;
    }

    public void setBtnAdjuntarArchivo(CoreCommandButton btn_adjuntarArch) {
        this.btnAdjuntarArchivo = btn_adjuntarArch;
    }

    public CoreCommandButton getBtnAdjuntarArchivo() {
        return btnAdjuntarArchivo;
    }

    public void setPanelHorizontal1(CorePanelHorizontal panelHorizontal1) {
        this.panelHorizontal1 = panelHorizontal1;
    }

    public CorePanelHorizontal getPanelHorizontal1() {
        return panelHorizontal1;
    }

    public void setObjectSpacer2(CoreObjectSpacer objectSpacer2) {
        this.objectSpacer2 = objectSpacer2;
    }

    public CoreObjectSpacer getObjectSpacer2() {
        return objectSpacer2;
    }

    public void setOutputText1(CoreOutputText outputText1) {
        this.outputText1 = outputText1;
    }

    public CoreOutputText getOutputText1() {
        return outputText1;
    }

    public void setColumn1(CoreColumn column1) {
        this.column1 = column1;
    }

    public CoreColumn getColumn1() {
        return column1;
    }

    public void setOutputText2(CoreOutputText outputText2) {
        this.outputText2 = outputText2;
    }

    public CoreOutputText getOutputText2() {
        return outputText2;
    }

    public void setColumn2(CoreColumn column2) {
        this.column2 = column2;
    }

    public CoreColumn getColumn2() {
        return column2;
    }

    public void setOutputText3(HtmlOutputText outputText3) {
        this.outputText3 = outputText3;
    }

    public HtmlOutputText getOutputText3() {
        return outputText3;
    }

    public void setOutputLink1(HtmlOutputLink outputLink1) {
        this.outputLink1 = outputLink1;
    }

    public HtmlOutputLink getOutputLink1() {
        return outputLink1;
    }

    public void setColumn3(CoreColumn column3) {
        this.column3 = column3;
    }

    public CoreColumn getColumn3() {
        return column3;
    }

    public void setOutputText4(CoreOutputText outputText4) {
        this.outputText4 = outputText4;
    }

    public CoreOutputText getOutputText4() {
        return outputText4;
    }

    public void setTableSelectOne1(CoreTableSelectOne tableSelectOne1) {
        this.tableSelectOne1 = tableSelectOne1;
    }

    public CoreTableSelectOne getTableSelectOne1() {
        return tableSelectOne1;
    }

    public void setTable1(CoreTable table1) {
        this.table1 = table1;
    }

    public CoreTable getTable1() {
        return table1;
    }

    public void setObjectSpacer3(CoreObjectSpacer objectSpacer3) {
        this.objectSpacer3 = objectSpacer3;
    }

    public CoreObjectSpacer getObjectSpacer3() {
        return objectSpacer3;
    }

    public void setShowDetailItem1(CoreShowDetailItem showDetailItem1) {
        this.showDetailItem1 = showDetailItem1;
    }

    public CoreShowDetailItem getShowDetailItem1() {
        return showDetailItem1;
    }

    public void setBtnAutorizacion(CoreCommandButton btn_autoriza) {
        this.btnAutorizacion = btn_autoriza;
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

    public void setBtnCancelarRetiro(CoreCommandButton commandButton2) {
        this.btnCancelarRetiro = commandButton2;
    }

    public CoreCommandButton getBtnCancelarRetiro() {
        return btnCancelarRetiro;
    }

    public void setBtnGrabarRetiro(CoreCommandButton commandButton3) {
        this.btnGrabarRetiro = commandButton3;
    }

    public CoreCommandButton getBtnGrabarRetiro() {
        return btnGrabarRetiro;
    }

    public void setPanelHorizontal2(CorePanelHorizontal panelHorizontal2) {
        this.panelHorizontal2 = panelHorizontal2;
    }

    public CorePanelHorizontal getPanelHorizontal2() {
        return panelHorizontal2;
    }

    public void setObjectSpacer5(CoreObjectSpacer objectSpacer5) {
        this.objectSpacer5 = objectSpacer5;
    }

    public CoreObjectSpacer getObjectSpacer5() {
        return objectSpacer5;
    }

    public void setInputText1(CoreInputText inputText1) {
        this.inputText1 = inputText1;
    }

    public CoreInputText getInputText1() {
        return inputText1;
    }

    public void setSelectInputDate1(CoreSelectInputDate selectInputDate1) {
        this.selectInputDate1 = selectInputDate1;
    }

    public CoreSelectInputDate getSelectInputDate1() {
        return selectInputDate1;
    }

    public void setSelectItems1(UISelectItems selectItems1) {
        this.selectItems1 = selectItems1;
    }

    public UISelectItems getSelectItems1() {
        return selectItems1;
    }

    public void setSelectOneChoice1(CoreSelectOneChoice selectOneChoice1) {
        this.selectOneChoice1 = selectOneChoice1;
    }

    public CoreSelectOneChoice getSelectOneChoice1() {
        return selectOneChoice1;
    }

    public void setPanelForm1(CorePanelForm panelForm1) {
        this.panelForm1 = panelForm1;
    }

    public CorePanelForm getPanelForm1() {
        return panelForm1;
    }

    public void setShowDetailItem2(CoreShowDetailItem showDetailItem2) {
        this.showDetailItem2 = showDetailItem2;
    }

    public CoreShowDetailItem getShowDetailItem2() {
        return showDetailItem2;
    }

    public void setShowOneTab1(CoreShowOneTab showOneTab1) {
        this.showOneTab1 = showOneTab1;
    }

    public CoreShowOneTab getShowOneTab1() {
        return showOneTab1;
    }

    public void setPanelBox1(CorePanelBox panelBox1) {
        this.panelBox1 = panelBox1;
    }

    public CorePanelBox getPanelBox1() {
        return panelBox1;
    }

    public void setLogo(UINamingContainer logo) {
        this.logo = logo;
    }

    public UINamingContainer getLogo() {
        return logo;
    }

    public void setMenuSwt(UINamingContainer menuSwt) {
        this.menuSwt = menuSwt;
    }

    public UINamingContainer getMenuSwt() {
        return menuSwt;
    }

    public void setInfo1(UINamingContainer info1) {
        this.info1 = info1;
    }

    public UINamingContainer getInfo1() {
        return info1;
    }

    public void setCommandMenuItem1(CoreCommandMenuItem commandMenuItem1) {
        this.commandMenuItem1 = commandMenuItem1;
    }

    public CoreCommandMenuItem getCommandMenuItem1() {
        return commandMenuItem1;
    }

    public void setPage1(CorePage page1) {
        this.page1 = page1;
    }

    public CorePage getPage1() {
        return page1;
    }

    public void setForm1(HtmlForm form1) {
        this.form1 = form1;
    }

    public HtmlForm getForm1() {
        return form1;
    }

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
    public String btnGrabarRetiro_action() {
        // Add event code here...
         boolean vResultado;
         //System.out.println("Este es el mero mero backingBean");
         resulOp vMensaResul=new resulOp();
          
         vResultado=ejecutar_action("Commit");
          if (vResultado==true){
              usuario.set_opciones(usuario.VISTA_RETIRO,1);
              vMensaResul.setMensajeError("Datos guardados correctamente");
              vMensaResul.setCodigoResultado(resulOp.OPE_OK);
              utils.setADFMensaje(vMensaResul);
          }
          
         return null;
    }

    private boolean ejecutar_action(String pNombreAccion){
        BindingContainer vBnd_binding;
        OperationBinding operationBinding;
        vBnd_binding=(BindingContainer)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings}");
        operationBinding=vBnd_binding.getOperationBinding(pNombreAccion);
        vResultadoEjecucion=operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()){
            return false;
        }else{
           
            return true;
        }
    }

    public String btnAdjuntarArchivo_action() {
        // Add event code here...
        FacesContext context = FacesContext.getCurrentInstance();  
        ViewHandler vh = context.getApplication().getViewHandler();  
        // el jspx que se mostrara en forma de  ventana emergente  
        UIViewRoot dialog = vh.createView(context, "/util/adjuntar_archivo.jspx");  
        AdfFacesContext a = AdfFacesContext.getCurrentInstance();  
        // fijamos el ancho y el alto de la ventana emergente  
        Map windowProperties = new HashMap();  
        windowProperties.put("width", new Integer(450));  
        windowProperties.put("height", new Integer(350));  
        //añadimos mas paremetros que seran recogidos en la jspx ventana  
        Map dialogParameters = new HashMap();  
        dialogParameters.put("IdSolicitud",JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdSolicitud.inputValue}").toString());
        dialogParameters.put("Opcion", 2);
        a.launchDialog(dialog,dialogParameters,null,true,windowProperties);
        return null;
    }

    public void Autorizar_Launch_Listener(LaunchEvent launchEvent) {
        // Add event code here...
         Object vValor;
         vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdSolicitud.inputValue}");   
         launchEvent.getDialogParameters().put("IdSolicitud", vValor); 
         launchEvent.getDialogParameters().put("IdGestionX", vValor); 
         launchEvent.getDialogParameters().put("Gestion", "RETIRO OBLIGATORIO"); 
         launchEvent.getDialogParameters().put("RefreshVw", "licencia"); 
         
         vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdEstado.inputValue}");
         launchEvent.getDialogParameters().put("Estado", vValor); 
                 
         launchEvent.getDialogParameters().put("IdProceso", null); 
         launchEvent.getDialogParameters().put("IdContrato", null); 
    }
    /* ****************************************************************************/
    /* ****************************************************************************/
    /* ****************************************************************************/


}
