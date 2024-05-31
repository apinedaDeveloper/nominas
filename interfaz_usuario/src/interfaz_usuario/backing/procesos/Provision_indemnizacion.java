package interfaz_usuario.backing.procesos;

import enlace_datos.util.resulOp;

import interfaz_usuario.util.JSFUtils;
import interfaz_usuario.util.utils;

import javax.faces.component.html.HtmlForm;

import javax.faces.context.FacesContext;

import oracle.adf.view.faces.component.core.data.CoreColumn;
import oracle.adf.view.faces.component.core.data.CoreTable;
import oracle.adf.view.faces.component.core.data.CoreTableSelectOne;
import oracle.adf.view.faces.component.core.input.CoreInputText;
import oracle.adf.view.faces.component.core.input.CoreSelectInputDate;
import oracle.adf.view.faces.component.core.layout.CorePanelForm;
import oracle.adf.view.faces.component.core.layout.CorePanelHorizontal;
import oracle.adf.view.faces.component.core.nav.CoreCommandButton;
import oracle.adf.view.faces.component.core.output.CoreMessages;
import oracle.adf.view.faces.component.core.output.CoreObjectSpacer;
import oracle.adf.view.faces.component.core.output.CoreOutputText;

public class Provision_indemnizacion {
    private HtmlForm form1;
    private CorePanelForm panelForm1;
    private CoreSelectInputDate selectInputDate1;
    private CoreSelectInputDate selectInputDate2;
    private CoreMessages messages1;
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
    private CorePanelHorizontal panelHorizontal1;
    private CoreCommandButton commandButton1;
    private CoreTableSelectOne tableSelectOne1;
    private CoreColumn column9;
    private CoreCommandButton commandButton2;
    private CoreCommandButton commandButton3;
    private CoreColumn column10;
    private CoreInputText inputText1;
    private CoreCommandButton commandButton4;
    private CoreCommandButton commandButton5;
    private CoreObjectSpacer objectSpacer1;
    private CoreObjectSpacer objectSpacer3;
    private CoreObjectSpacer objectSpacer2;

    public void setForm1(HtmlForm form1) {
        this.form1 = form1;
    }

    public HtmlForm getForm1() {
        return form1;
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

    public void setSelectInputDate2(CoreSelectInputDate selectInputDate2) {
        this.selectInputDate2 = selectInputDate2;
    }

    public CoreSelectInputDate getSelectInputDate2() {
        return selectInputDate2;
    }


    public void setMessages1(CoreMessages messages1) {
        this.messages1 = messages1;
    }

    public CoreMessages getMessages1() {
        return messages1;
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

    public void setPanelHorizontal1(CorePanelHorizontal panelHorizontal1) {
        this.panelHorizontal1 = panelHorizontal1;
    }

    public CorePanelHorizontal getPanelHorizontal1() {
        return panelHorizontal1;
    }

    public void setCommandButton1(CoreCommandButton commandButton1) {
        this.commandButton1 = commandButton1;
    }

    public CoreCommandButton getCommandButton1() {
        return commandButton1;
    }

    public void setTableSelectOne1(CoreTableSelectOne tableSelectOne1) {
        this.tableSelectOne1 = tableSelectOne1;
    }

    public CoreTableSelectOne getTableSelectOne1() {
        return tableSelectOne1;
    }

    public void setColumn9(CoreColumn column9) {
        this.column9 = column9;
    }

    public CoreColumn getColumn9() {
        return column9;
    }

    public void setCommandButton2(CoreCommandButton commandButton2) {
        this.commandButton2 = commandButton2;
    }

    public CoreCommandButton getCommandButton2() {
        return commandButton2;
    }


    public void setCommandButton3(CoreCommandButton commandButton3) {
        this.commandButton3 = commandButton3;
    }

    public CoreCommandButton getCommandButton3() {
        return commandButton3;
    }

    public void setColumn10(CoreColumn column10) {
        this.column10 = column10;
    }

    public CoreColumn getColumn10() {
        return column10;
    }

    public void setInputText1(CoreInputText inputText1) {
        this.inputText1 = inputText1;
    }

    public CoreInputText getInputText1() {
        return inputText1;
    }

    public void setCommandButton4(CoreCommandButton commandButton4) {
        this.commandButton4 = commandButton4;
    }

    public CoreCommandButton getCommandButton4() {
        return commandButton4;
    }

    public void setCommandButton5(CoreCommandButton commandButton5) {
        this.commandButton5 = commandButton5;
    }

    public CoreCommandButton getCommandButton5() {
        return commandButton5;
    }

    public void setObjectSpacer1(CoreObjectSpacer objectSpacer1) {
        this.objectSpacer1 = objectSpacer1;
    }

    public CoreObjectSpacer getObjectSpacer1() {
        return objectSpacer1;
    }


    public String cmd_generar_poliza() {
        // Add event code here...
         if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"setCurrentRowWithKey"))
         {
                
                JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"generarPoliza");
                utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Poliza de Proyeccion generada!!"));
                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Ejecutar");
             
         }
        return null;
    }


    public void setObjectSpacer3(CoreObjectSpacer objectSpacer3) {
        this.objectSpacer3 = objectSpacer3;
    }

    public CoreObjectSpacer getObjectSpacer3() {
        return objectSpacer3;
    }


    public void setObjectSpacer2(CoreObjectSpacer objectSpacer2) {
        this.objectSpacer2 = objectSpacer2;
    }

    public CoreObjectSpacer getObjectSpacer2() {
        return objectSpacer2;
    }

    public String cmd_aprobarPoliza() {
        // Add event code here...
         String vPolizaContable = null;
         try{
             vPolizaContable = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{row.NoPolizaContable}").toString();
         }
         catch(Exception e){
             vPolizaContable = null;
         }
         
        if(vPolizaContable == null){
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Debe ingresar el número de la póliza contable."));
            return null;
        }
        
        utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Procesando generación de la póliza contable....."));
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"crear_poliza_contable"))
        {
              JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Confirmar");
              utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"La poliza contable se genero correctamente, por favor verifique en el Sistema de Contabilidad."));
              JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Ejecutar");
        }
        
         
         return null;
    }
}
