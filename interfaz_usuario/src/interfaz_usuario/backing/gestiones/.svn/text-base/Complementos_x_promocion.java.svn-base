package interfaz_usuario.backing.gestiones;

import enlace_datos.util.resulOp;

import interfaz_usuario.util.JSFUtils;

import interfaz_usuario.util.utils;

import javax.faces.application.Application;
import javax.faces.component.UISelectItems;
import javax.faces.component.html.HtmlForm;

import javax.faces.context.FacesContext;

import javax.faces.el.ValueBinding;

import oracle.adf.view.faces.component.core.data.CoreColumn;
import oracle.adf.view.faces.component.core.data.CoreTable;
import oracle.adf.view.faces.component.core.data.CoreTableSelectOne;
import oracle.adf.view.faces.component.core.input.CoreInputText;
import oracle.adf.view.faces.component.core.input.CoreSelectInputDate;
import oracle.adf.view.faces.component.core.input.CoreSelectOneChoice;
import oracle.adf.view.faces.component.core.layout.CorePanelBox;
import oracle.adf.view.faces.component.core.layout.CorePanelButtonBar;
import oracle.adf.view.faces.component.core.layout.CorePanelForm;
import oracle.adf.view.faces.component.core.layout.CorePanelGroup;
import oracle.adf.view.faces.component.core.layout.CorePanelHeader;
import oracle.adf.view.faces.component.core.layout.CorePanelHorizontal;
import oracle.adf.view.faces.component.core.layout.CoreShowDetailItem;
import oracle.adf.view.faces.component.core.layout.CoreShowOneTab;
import oracle.adf.view.faces.component.core.nav.CoreCommandButton;
import oracle.adf.view.faces.component.core.nav.CoreCommandLink;
import oracle.adf.view.faces.component.core.nav.CorePage;
import oracle.adf.view.faces.component.core.output.CoreMessages;
import oracle.adf.view.faces.component.core.output.CoreObjectImage;
import oracle.adf.view.faces.component.core.output.CoreObjectSpacer;
import oracle.adf.view.faces.component.core.output.CoreOutputText;
import oracle.adf.view.faces.component.html.HtmlBody;
import oracle.adf.view.faces.component.html.HtmlHead;
import oracle.adf.view.faces.component.html.HtmlHtml;

import oracle.jbo.Row;
import oracle.jbo.uicli.binding.JUIteratorBinding;

public class Complementos_x_promocion {

    /* Atributos personalizados */
    private CoreShowDetailItem tab_histo;
    private CoreShowDetailItem tab_detalle;
    /* Fin atributos personalizados */
    
    private HtmlHtml html1;
    private HtmlHead head1;
    private HtmlBody body1;
    private HtmlForm form1;
    private CorePage page1;
    private CoreMessages messages1;
    private CorePanelBox panelBox1;
    private CoreShowOneTab showOneTab1;
    private CoreShowDetailItem showDetailItem1;
    private CoreCommandLink btn_nuevo;
    private CoreTable table1;
    private CoreColumn column1;
    private CoreCommandLink cmd_IdComple;
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
    private CoreColumn column8;
    private CoreOutputText outputText8;
    private CoreColumn column7;
    private CoreOutputText outputText7;
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
    private CoreColumn column18;
    private CoreOutputText outputText18;
    private CoreColumn column19;
    private CoreOutputText outputText19;
    private CoreColumn column20;
    private CoreOutputText outputText20;
    private CoreColumn column21;
    private CoreOutputText outputText21;
    private CoreTableSelectOne tableSelectOne1;
    private CoreCommandButton commandButton1;
    private CoreShowDetailItem showDetailItem2;
    private CorePanelHeader panelHeader1;
    private CorePanelForm panelForm1;
    private CorePanelHorizontal panelHorizontal1;
    private CoreInputText inputText1;
    private CoreCommandButton commandButton2;
    private CoreCommandLink cmdRefresh;
    private CorePanelHorizontal panelHorizontal2;
    private CorePanelGroup panelGroup1;
    private CoreSelectInputDate inputText2;
    private CoreSelectInputDate inputText3;
    private CoreObjectSpacer objectSpacer1;
    private CorePanelButtonBar panelButtonBar1;
    private CoreCommandButton commandButton3;
    private CoreCommandLink commandLink1;
    private CoreObjectImage objectImage1;
    private CoreCommandLink commandLink2;
    private CoreObjectImage objectImage2;
    private CoreCommandLink commandLink3;
    private CoreObjectImage objectImage3;
    private CorePanelHorizontal panelHorizontal3;
    private CoreInputText inputText4;
    private CoreSelectOneChoice navList1;
    private UISelectItems selectItems1;
    private CoreObjectSpacer objectSpacer2;
    private CoreObjectSpacer objectSpacer3;
    private CoreOutputText outputText1;
    private CoreOutputText outputText22;
    private CoreInputText inputText5;
    private CoreInputText inputText6;
    private CoreInputText inputText7;
    private CoreInputText inputText8;
    private CoreInputText inputText9;
    private CoreInputText inputText10;
    private CoreInputText inputText11;
    private CoreCommandLink commandLink4;
    private CoreCommandButton commandButton4;


    /* Metodos personalizados */
    public String commandLink_seleccionar() {
        Object pIdComple; 
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"setCurrentRowWithKey");
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pNuevo1.inputValue}","0");    
                
        pIdComple=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdComplemento.inputValue}");
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pIdVar1.inputValue}",pIdComple);        
        
        this.showDetailItem1.setDisclosed(false);
        this.showDetailItem2.setDisclosed(true);
        return null;
    }
    
    public String btn_nuevo_action() {
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Rollback");
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pNuevo1.inputValue}","0");        
        this.showDetailItem1.setDisclosed(false);
        this.showDetailItem2.setDisclosed(true);
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"crearComplemento");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Commit");
        //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarDet");
        
        return null;
    }
    
    public String btn_buscar() {
        // Add event code here..
        
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Empleado")){
            
            //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Contratos");
            
        }
        
        return null;
    }    
    
    
    public String cmdRefresh_action() {
    
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Execute")){
            
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"actualizarVW");
        }
        // Add event code here...
        return null;
    }


    public String btn_GenerarComplemento() {
        // Add event code here...
        Object vViewObject,vSel,vIdcontrato,vNuevo,pIdComple;              
        JUIteratorBinding vIterador2;
        Row [] vFilas;
        int vNumeroFilas;
                
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Puesto"))    {
            //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Contratos");
            
           vNuevo=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.pNuevo1.inputValue}");
              
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"generarComplementoPorPromocion");                   
            
         //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Commit");
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarDet");
         utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Calculo generado exitosamente"));
        
        vViewObject=null;
        }
        return null;
    }


    public String btn_guardarAction() {
        // Add event code here...
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Commit");
        return null;
    }
    
    
    /* Fin de Metodos personalizados */
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

    public void setBtn_nuevo(CoreCommandLink btn_nuevo) {
        this.btn_nuevo = btn_nuevo;
    }

    public CoreCommandLink getBtn_nuevo() {
        return btn_nuevo;
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

    public void setCmd_IdComple(CoreCommandLink cmd_IdComple) {
        this.cmd_IdComple = cmd_IdComple;
    }

    public CoreCommandLink getCmd_IdComple() {
        return cmd_IdComple;
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

    public void setColumn18(CoreColumn column18) {
        this.column18 = column18;
    }

    public CoreColumn getColumn18() {
        return column18;
    }

    public void setOutputText18(CoreOutputText outputText18) {
        this.outputText18 = outputText18;
    }

    public CoreOutputText getOutputText18() {
        return outputText18;
    }

    public void setColumn19(CoreColumn column19) {
        this.column19 = column19;
    }

    public CoreColumn getColumn19() {
        return column19;
    }

    public void setOutputText19(CoreOutputText outputText19) {
        this.outputText19 = outputText19;
    }

    public CoreOutputText getOutputText19() {
        return outputText19;
    }

    public void setColumn20(CoreColumn column20) {
        this.column20 = column20;
    }

    public CoreColumn getColumn20() {
        return column20;
    }

    public void setOutputText20(CoreOutputText outputText20) {
        this.outputText20 = outputText20;
    }

    public CoreOutputText getOutputText20() {
        return outputText20;
    }

    public void setColumn21(CoreColumn column21) {
        this.column21 = column21;
    }

    public CoreColumn getColumn21() {
        return column21;
    }

    public void setOutputText21(CoreOutputText outputText21) {
        this.outputText21 = outputText21;
    }

    public CoreOutputText getOutputText21() {
        return outputText21;
    }

    public void setTableSelectOne1(CoreTableSelectOne tableSelectOne1) {
        this.tableSelectOne1 = tableSelectOne1;
    }

    public CoreTableSelectOne getTableSelectOne1() {
        return tableSelectOne1;
    }

    public void setCommandButton1(CoreCommandButton commandButton1) {
        this.commandButton1 = commandButton1;
    }

    public CoreCommandButton getCommandButton1() {
        return commandButton1;
    }

    public void setShowDetailItem2(CoreShowDetailItem showDetailItem2) {
        this.showDetailItem2 = showDetailItem2;
    }

    public CoreShowDetailItem getShowDetailItem2() {
        return showDetailItem2;
    }

    public void setPanelHeader1(CorePanelHeader panelHeader1) {
        this.panelHeader1 = panelHeader1;
    }

    public CorePanelHeader getPanelHeader1() {
        return panelHeader1;
    }

    public void setPanelForm1(CorePanelForm panelForm1) {
        this.panelForm1 = panelForm1;
    }

    public CorePanelForm getPanelForm1() {
        return panelForm1;
    }


    public void setPanelHorizontal1(CorePanelHorizontal panelHorizontal1) {
        this.panelHorizontal1 = panelHorizontal1;
    }

    public CorePanelHorizontal getPanelHorizontal1() {
        return panelHorizontal1;
    }

    public void setInputText1(CoreInputText inputText1) {
        this.inputText1 = inputText1;
    }

    public CoreInputText getInputText1() {
        return inputText1;
    }

    public void setCommandButton2(CoreCommandButton commandButton2) {
        this.commandButton2 = commandButton2;
    }

    public CoreCommandButton getCommandButton2() {
        return commandButton2;
    }


    public void setCmdRefresh(CoreCommandLink cmdRefresh) {
        this.cmdRefresh = cmdRefresh;
    }

    public CoreCommandLink getCmdRefresh() {
        return cmdRefresh;
    }

    public void setPanelHorizontal2(CorePanelHorizontal panelHorizontal2) {
        this.panelHorizontal2 = panelHorizontal2;
    }

    public CorePanelHorizontal getPanelHorizontal2() {
        return panelHorizontal2;
    }

    public void setPanelGroup1(CorePanelGroup panelGroup1) {
        this.panelGroup1 = panelGroup1;
    }

    public CorePanelGroup getPanelGroup1() {
        return panelGroup1;
    }


    public void setInputText2(CoreSelectInputDate inputText2) {
        this.inputText2 = inputText2;
    }

    public CoreSelectInputDate getInputText2() {
        return inputText2;
    }

    public void setInputText3(CoreSelectInputDate inputText3) {
        this.inputText3 = inputText3;
    }

    public CoreSelectInputDate getInputText3() {
        return inputText3;
    }


    public void setObjectSpacer1(CoreObjectSpacer objectSpacer1) {
        this.objectSpacer1 = objectSpacer1;
    }

    public CoreObjectSpacer getObjectSpacer1() {
        return objectSpacer1;
    }


    public void setPanelButtonBar1(CorePanelButtonBar panelButtonBar1) {
        this.panelButtonBar1 = panelButtonBar1;
    }

    public CorePanelButtonBar getPanelButtonBar1() {
        return panelButtonBar1;
    }

    public void setCommandButton3(CoreCommandButton commandButton3) {
        this.commandButton3 = commandButton3;
    }

    public CoreCommandButton getCommandButton3() {
        return commandButton3;
    }

    public void setCommandLink1(CoreCommandLink commandLink1) {
        this.commandLink1 = commandLink1;
    }

    public CoreCommandLink getCommandLink1() {
        return commandLink1;
    }

    public void setObjectImage1(CoreObjectImage objectImage1) {
        this.objectImage1 = objectImage1;
    }

    public CoreObjectImage getObjectImage1() {
        return objectImage1;
    }

    public void setCommandLink2(CoreCommandLink commandLink2) {
        this.commandLink2 = commandLink2;
    }

    public CoreCommandLink getCommandLink2() {
        return commandLink2;
    }

    public void setObjectImage2(CoreObjectImage objectImage2) {
        this.objectImage2 = objectImage2;
    }

    public CoreObjectImage getObjectImage2() {
        return objectImage2;
    }

    public void setCommandLink3(CoreCommandLink commandLink3) {
        this.commandLink3 = commandLink3;
    }

    public CoreCommandLink getCommandLink3() {
        return commandLink3;
    }

    public void setObjectImage3(CoreObjectImage objectImage3) {
        this.objectImage3 = objectImage3;
    }

    public CoreObjectImage getObjectImage3() {
        return objectImage3;
    }


    public void setPanelHorizontal3(CorePanelHorizontal panelHorizontal3) {
        this.panelHorizontal3 = panelHorizontal3;
    }

    public CorePanelHorizontal getPanelHorizontal3() {
        return panelHorizontal3;
    }


    public void setInputText4(CoreInputText inputText4) {
        this.inputText4 = inputText4;
    }

    public CoreInputText getInputText4() {
        return inputText4;
    }


    public void setNavList1(CoreSelectOneChoice navList1) {
        this.navList1 = navList1;
    }

    public CoreSelectOneChoice getNavList1() {
        return navList1;
    }

    public void setSelectItems1(UISelectItems selectItems1) {
        this.selectItems1 = selectItems1;
    }

    public UISelectItems getSelectItems1() {
        return selectItems1;
    }


    public void setObjectSpacer2(CoreObjectSpacer objectSpacer2) {
        this.objectSpacer2 = objectSpacer2;
    }

    public CoreObjectSpacer getObjectSpacer2() {
        return objectSpacer2;
    }


    public void setObjectSpacer3(CoreObjectSpacer objectSpacer3) {
        this.objectSpacer3 = objectSpacer3;
    }

    public CoreObjectSpacer getObjectSpacer3() {
        return objectSpacer3;
    }

    public void setOutputText1(CoreOutputText outputText1) {
        this.outputText1 = outputText1;
    }

    public CoreOutputText getOutputText1() {
        return outputText1;
    }

    public void setOutputText22(CoreOutputText outputText22) {
        this.outputText22 = outputText22;
    }

    public CoreOutputText getOutputText22() {
        return outputText22;
    }


    public void setInputText5(CoreInputText inputText5) {
        this.inputText5 = inputText5;
    }

    public CoreInputText getInputText5() {
        return inputText5;
    }

    public void setInputText6(CoreInputText inputText6) {
        this.inputText6 = inputText6;
    }

    public CoreInputText getInputText6() {
        return inputText6;
    }

    public void setInputText7(CoreInputText inputText7) {
        this.inputText7 = inputText7;
    }

    public CoreInputText getInputText7() {
        return inputText7;
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

    public void setInputText11(CoreInputText inputText11) {
        this.inputText11 = inputText11;
    }

    public CoreInputText getInputText11() {
        return inputText11;
    }

    public void setCommandLink4(CoreCommandLink commandLink4) {
        this.commandLink4 = commandLink4;
    }

    public CoreCommandLink getCommandLink4() {
        return commandLink4;
    }

    public void setCommandButton4(CoreCommandButton commandButton4) {
        this.commandButton4 = commandButton4;
    }

    public CoreCommandButton getCommandButton4() {
        return commandButton4;
    }


}
