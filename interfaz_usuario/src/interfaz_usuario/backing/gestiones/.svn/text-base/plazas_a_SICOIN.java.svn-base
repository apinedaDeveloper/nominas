package interfaz_usuario.backing.gestiones;

import enlace_datos.util.resulOp;
import enlace_datos.util.utils_DB;

import interfaz_usuario.util.JSFUtils;

import interfaz_usuario.util.utils;

import java.sql.ResultSet;

import javax.faces.application.FacesMessage;
import javax.faces.component.UINamingContainer;
import javax.faces.component.UISelectItems;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.faces.component.core.CoreForm;
import oracle.adf.view.faces.component.core.input.CoreInputText;
import oracle.adf.view.faces.component.core.input.CoreSelectInputDate;
import oracle.adf.view.faces.component.core.input.CoreSelectOneChoice;
import oracle.adf.view.faces.component.core.layout.CorePanelForm;
import oracle.adf.view.faces.component.core.layout.CorePanelHeader;
import oracle.adf.view.faces.component.core.nav.CoreCommandButton;
import oracle.adf.view.faces.component.core.nav.CoreCommandMenuItem;
import oracle.adf.view.faces.component.core.nav.CorePage;
import oracle.adf.view.faces.component.core.output.CoreMessages;
import oracle.adf.view.faces.component.core.output.CoreOutputText;
import oracle.adf.view.faces.component.html.HtmlBody;
import oracle.adf.view.faces.component.html.HtmlHead;
import oracle.adf.view.faces.component.html.HtmlHtml;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.JboException;
import oracle.jbo.NameValuePairs;
import oracle.jbo.domain.Number;

import pkg_util_base_datos.interfaz_DB;

public class plazas_a_SICOIN {
    private boolean vCambioDep=false;
    private boolean vCambioUni=false;
    private boolean vCambioPartida=false;
    private boolean vCambioPlaza=false;
    private CorePanelHeader panelHeader1;
    private CorePanelHeader panelHeader2;
    private UISelectItems selectItems1;
    private CoreSelectOneChoice cmdUnidad;
    private CorePanelHeader panelHeader3;
    private UISelectItems selectItems2;
    private CoreSelectOneChoice cmbDependencia;
    private CorePanelHeader panelHeader4;
    private CoreOutputText outputText1;
    private UINamingContainer logo;
    private UINamingContainer menuSwt;
    private UINamingContainer info1;
    private CoreCommandMenuItem commandMenuItem1;
    private CorePage page1;
    private CoreForm form1;
    private CoreMessages messages1;
    private HtmlBody body1;
    private HtmlHead head1;
    private HtmlHtml html1;
    private CoreSelectOneChoice cmbPartida;
    private UISelectItems selectItems3;
    private CorePanelHeader panelHeader5;
    private CorePanelHeader panelHeader6;
    private CoreSelectOneChoice cmbPlazaSiif;
    private UISelectItems selectItems4;
    private CoreSelectOneChoice cmbPartidaSicoin;
    private UISelectItems selectItems5;
    private CoreInputText inpPlazaSicoin;
    private CorePanelForm panelForm1;
    private CoreInputText inputText1;
    private CoreInputText inputText2;
    private CoreInputText inputText3;
    private CoreInputText inputText4;
    private CoreInputText inputText5;
    private CoreInputText inputText6;
    private CoreSelectInputDate selectInputDate1;
    private CoreSelectInputDate selectInputDate2;
    private CoreInputText inputText7;
    private CoreInputText inputText8;
    private CoreInputText inputText9;
    private CoreSelectInputDate selectInputDate3;
    private CoreInputText inputText10;
    private CoreInputText inputText11;
    private CoreInputText inputText12;
    private CoreInputText inputText13;
    private CoreInputText inputText14;
    private CoreInputText inputText15;
    private CoreInputText inputText16;
    private CoreInputText inputText17;
    private CoreInputText inputText18;
    private CoreInputText inputText19;
    private CoreInputText inputText20;
    private CoreInputText inputText21;
    private CoreInputText inputText22;
    private CoreCommandButton btnSubmit;
    private CoreCommandButton commandButton2;
    private CoreCommandButton btnObtenerPlazaSicoin;
    private CoreCommandButton btnGrabarPlaza;
    private BindingContainer bindings;

    public plazas_a_SICOIN() {
    }


    public void setPanelHeader1(CorePanelHeader panelHeader1) {
        this.panelHeader1 = panelHeader1;
    }

    public CorePanelHeader getPanelHeader1() {
        return panelHeader1;
    }

    public void setPanelHeader2(CorePanelHeader panelHeader2) {
        this.panelHeader2 = panelHeader2;
    }

    public CorePanelHeader getPanelHeader2() {
        return panelHeader2;
    }

    public void setSelectItems1(UISelectItems selectItems1) {
        this.selectItems1 = selectItems1;
    }

    public UISelectItems getSelectItems1() {
        return selectItems1;
    }

    public void setCmdUnidad(CoreSelectOneChoice cmdUnidad) {
        this.cmdUnidad = cmdUnidad;
    }

    public CoreSelectOneChoice getCmdUnidad() {
        return cmdUnidad;
    }

    public void setPanelHeader3(CorePanelHeader panelHeader3) {
        this.panelHeader3 = panelHeader3;
    }

    public CorePanelHeader getPanelHeader3() {
        return panelHeader3;
    }

    public void setSelectItems2(UISelectItems selectItems2) {
        this.selectItems2 = selectItems2;
    }

    public UISelectItems getSelectItems2() {
        return selectItems2;
    }

    public void setCmbDependencia(CoreSelectOneChoice cmbDependencia) {
        this.cmbDependencia = cmbDependencia;
    }

    public CoreSelectOneChoice getCmbDependencia() {
        return cmbDependencia;
    }

    public void setPanelHeader4(CorePanelHeader panelHeader4) {
        this.panelHeader4 = panelHeader4;
    }

    public CorePanelHeader getPanelHeader4() {
        return panelHeader4;
    }

    public void setOutputText1(CoreOutputText outputText1) {
        this.outputText1 = outputText1;
    }

    public CoreOutputText getOutputText1() {
        return outputText1;
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

    public void setForm1(CoreForm form1) {
        this.form1 = form1;
    }

    public CoreForm getForm1() {
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


/* ***************************************************************************** */    
/* ***************************************************************************** */    
/* ***************************************************************************** */    
    public boolean getCambioDep(){
        return vCambioDep ;
    }

    public boolean getCambioUni(){
        return vCambioUni;
    }

    public boolean getCambioPartida(){
        return vCambioPartida;
    }

    public boolean getCambioPlaza(){
        return vCambioPlaza;
    }

    public void cmbDependencia(ValueChangeEvent valueChangeEvent){
        // Add event code here...
        if (valueChangeEvent.getOldValue()!=valueChangeEvent.getNewValue()){
            //System.out.println("Cambio valor de combo");
            vCambioDep=true;
        }
    }

    public void cmbUnidad(ValueChangeEvent valueChangeEvent){
        // Add event code here...
        if (valueChangeEvent.getOldValue()!=valueChangeEvent.getNewValue()){
            //System.out.println("Cambio valor de combo");
            vCambioUni=true;
        }
    }

    public void cmbPartida(ValueChangeEvent valueChangeEvent){
        // Add event code here...
        if (valueChangeEvent.getOldValue()!=valueChangeEvent.getNewValue()){
            //System.out.println("Cambio valor de combo");
            vCambioPartida=true;
        }
    }

    public void cmbPlaza(ValueChangeEvent valueChangeEvent){
        // Add event code here...
        if (valueChangeEvent.getOldValue()!=valueChangeEvent.getNewValue()){
            //System.out.println("Cambio valor de combo");
            vCambioPlaza=true;
        }
    }

    public String btnSubmit_action2() {
        // Add event code here...
        Object vIdDep;
        Object vIdUni;
        Object vIdPartida;
        Object vIdPuesto;
        Object vNumeroPlaza;
        Object vCorrelativo;
        Object vIdAnio;
        Object vIdRenglon;
        Object vPlazaSicoin;
        Object vPartidaSicoin;
        vIdDep=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vIdDep1.inputValue}");
        System.out.println("valor obtenido dep:="+vIdDep);
        vIdUni=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vIdUnidad1.inputValue}");
        System.out.println(" Uni="+vIdUni);
        vIdPartida=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vIdPartida1.inputValue}");
        System.out.println("pIdPartida="+vIdPartida);
        vIdPuesto=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vIdPuesto1.inputValue}");
        System.out.println("pIdPuesto="+vIdPuesto);
        vNumeroPlaza=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vPlazaSiif1.inputValue}");
        System.out.println("pNumeroPlaza="+vNumeroPlaza);
        vCorrelativo=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vCorrelativo1.inputValue}");
        System.out.println("pCorrelativo="+vCorrelativo);
        vPlazaSicoin=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vPlazaSicoin1.inputValue}");
        System.out.println("pPlazaSicoin:="+vPlazaSicoin);
        vPartidaSicoin=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vIdPartidaSicoin1.inputValue}");
        System.out.println("id_partida_sicoin:="+vPartidaSicoin);
        vIdAnio=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{flujo_usuario.anioActual}");
        System.out.println("anio:="+vIdAnio);
        vIdRenglon=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vIdRenglon1.inputValue}");
        System.out.println("Renglon:="+vIdRenglon);
        return null;
    }


    public String ObtenerPlazaSicoin_action(){
        String Resultado;
        interfaz_DB conec;
        conec= new interfaz_DB();
        String vQuery;
        Object vIdDep;
        Object vIdAnio;
        Object vPlazaSicoin;
        ResultSet vResultado;
        vResultado=null;
        try {
            Resultado=validadCombos();
            if(Resultado.compareTo("EXITO")==0){ 
                vIdDep=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vIdDep1.inputValue}");
                //System.out.println("valor obtenido dep:="+vIdDep);
                vIdAnio=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{flujo_usuario.anioActual}");
                //System.out.println("anio:="+vIdAnio);
                //vIdAnio=2020;
                vQuery="select Nvl(max(pla.plaza_sicoin),0)+1 vNoPlaza "
                +"from sis_dependencia d, sis_partida p, sis_plaza pla "
                +"where d.id_dependencia="+vIdDep+" and pla.correlativo="+vIdAnio
                +" and d.id_dependencia=p.id_dependencia and p.id_partida=pla.id_partida";
                vResultado = conec.Bol_ejecutar_sentencia(vQuery);
                if (vResultado.next()){
                    vPlazaSicoin = vResultado.getInt("vNoPlaza");
                    JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.vPlazaSicoin1.inputValue}",vPlazaSicoin);
                    this.inpPlazaSicoin.setValue(vPlazaSicoin);
                    //Se habilita el boton para grabar los datos
                    this.btnGrabarPlaza.setDisabled(false);
                }
            }else{
                utils.setADFMensaje(new resulOp(resulOp.OPE_WARN,Resultado));
            }
            conec.cn_Cerrar_coneccion();
            return null;
        }catch (Exception e) {
            //System.out.println("Exception vPlazaSicoin2");
            conec.cn_Cerrar_coneccion();
            //e.printStackTrace();
            return null;
        }
        
    }

    private String validadCombos(){
        String vRespuesta="EXITO";
        Object cmbDep=this.cmbDependencia.getValue();
        Object cmbUnidad=this.cmdUnidad.getValue();
        Object cmbPartida=this.cmbPartida.getValue();
        Object cmbPlazaSiif=this.cmbPlazaSiif.getValue();
        Object cmbPartidaSicoin=this.cmbPartidaSicoin.getValue();
        //if (cmbDep==null || cmbDep.toString().compareTo("0")==0){
        if (cmbDep==null){
            vRespuesta="Debe seleccionar una DEPENDENCIA";
            return vRespuesta;
        }
        //if (cmbUnidad==null || cmbUnidad.toString().compareTo("0")==0){
        if (cmbUnidad==null){
            vRespuesta="Debe seleccionar una UNIDAD";
            return vRespuesta;
        }
        //if (cmbPartida==null || cmbPartida.toString().compareTo("0")==0){
        if (cmbPartida==null){
            vRespuesta="Debe seleccionar una PARTIDA PRESUPUESTAL";
            return vRespuesta;
        }
        //if (cmbPlazaSiif==null || cmbPlazaSiif.toString().compareTo("0")==0){
        if (cmbPlazaSiif==null){
            vRespuesta="Debe seleccionar una PLAZA";
            return vRespuesta;
        }
        //if (cmbPartidaSicoin==null || cmbPartidaSicoin.toString().compareTo("0")==0){
        if (cmbPartidaSicoin==null){
            vRespuesta="Debe seleccionar una PARTIDA RELACIONADO A SICOIN";
            return vRespuesta;
        }
        return vRespuesta;
    }
    public String btnGrabarPlaza_action() {
        Object plaza;
        plaza = this.inpPlazaSicoin.getValue();
        if(plaza == null || plaza.equals(""))  {
            utils.setADFMensaje(new resulOp(resulOp.OPE_WARN,"Es necesario ingresar un numero de plaza"));
        }else{
            BindingContainer bindings = getBindings();
            OperationBinding operationBinding = bindings.getOperationBinding("ActualizarPlazaSicoin");
            Object result = operationBinding.execute();
            if (!operationBinding.getErrors().isEmpty()) {
                utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Ha ocurrido un error inesperado. Por favor revise"));
            }else{
                this.btnGrabarPlaza.setDisabled(true);
                utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Informacion Guardada Éxitosamente!!"));
                this.inpPlazaSicoin.setValue("");
                operationBinding = bindings.getOperationBinding("filtrarPlaza");
                result = operationBinding.execute();
                operationBinding = bindings.getOperationBinding("filtrarPartidaSicoin");
                result = operationBinding.execute();
            }
        }
        return null;
    }



/* ***************************************************************************** */    
/* ***************************************************************************** */    
/* ***************************************************************************** */


    public void setCmbPartida(CoreSelectOneChoice selectOneChoice1) {
        this.cmbPartida = selectOneChoice1;
    }

    public CoreSelectOneChoice getCmbPartida() {
        return cmbPartida;
    }

    public void setSelectItems3(UISelectItems selectItems3) {
        this.selectItems3 = selectItems3;
    }

    public UISelectItems getSelectItems3() {
        return selectItems3;
    }

    public void setPanelHeader5(CorePanelHeader panelHeader5) {
        this.panelHeader5 = panelHeader5;
    }

    public CorePanelHeader getPanelHeader5() {
        return panelHeader5;
    }

    public void setPanelHeader6(CorePanelHeader panelHeader6) {
        this.panelHeader6 = panelHeader6;
    }

    public CorePanelHeader getPanelHeader6() {
        return panelHeader6;
    }

    public void setCmbPlazaSiif(CoreSelectOneChoice selectOneChoice1) {
        this.cmbPlazaSiif = selectOneChoice1;
    }

    public CoreSelectOneChoice getCmbPlazaSiif() {
        return cmbPlazaSiif;
    }

    public void setSelectItems4(UISelectItems selectItems4) {
        this.selectItems4 = selectItems4;
    }

    public UISelectItems getSelectItems4() {
        return selectItems4;
    }

    public void setCmbPartidaSicoin(CoreSelectOneChoice selectOneChoice1) {
        this.cmbPartidaSicoin = selectOneChoice1;
    }

    public CoreSelectOneChoice getCmbPartidaSicoin() {
        return cmbPartidaSicoin;
    }

    public void setSelectItems5(UISelectItems selectItems5) {
        this.selectItems5 = selectItems5;
    }

    public UISelectItems getSelectItems5() {
        return selectItems5;
    }

    public void setInpPlazaSicoin(CoreInputText inputText23) {
        this.inpPlazaSicoin = inputText23;
    }

    public CoreInputText getInpPlazaSicoin() {
        return inpPlazaSicoin;
    }

    public void setPanelForm1(CorePanelForm panelForm1) {
        this.panelForm1 = panelForm1;
    }

    public CorePanelForm getPanelForm1() {
        return panelForm1;
    }

    public void setInputText1(CoreInputText inputText1) {
        this.inputText1 = inputText1;
    }

    public CoreInputText getInputText1() {
        return inputText1;
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

    public void setInputText6(CoreInputText inputText6) {
        this.inputText6 = inputText6;
    }

    public CoreInputText getInputText6() {
        return inputText6;
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

    public void setSelectInputDate3(CoreSelectInputDate selectInputDate3) {
        this.selectInputDate3 = selectInputDate3;
    }

    public CoreSelectInputDate getSelectInputDate3() {
        return selectInputDate3;
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

    public void setInputText12(CoreInputText inputText12) {
        this.inputText12 = inputText12;
    }

    public CoreInputText getInputText12() {
        return inputText12;
    }

    public void setInputText13(CoreInputText inputText13) {
        this.inputText13 = inputText13;
    }

    public CoreInputText getInputText13() {
        return inputText13;
    }

    public void setInputText14(CoreInputText inputText14) {
        this.inputText14 = inputText14;
    }

    public CoreInputText getInputText14() {
        return inputText14;
    }

    public void setInputText15(CoreInputText inputText15) {
        this.inputText15 = inputText15;
    }

    public CoreInputText getInputText15() {
        return inputText15;
    }

    public void setInputText16(CoreInputText inputText16) {
        this.inputText16 = inputText16;
    }

    public CoreInputText getInputText16() {
        return inputText16;
    }

    public void setInputText17(CoreInputText inputText17) {
        this.inputText17 = inputText17;
    }

    public CoreInputText getInputText17() {
        return inputText17;
    }

    public void setInputText18(CoreInputText inputText18) {
        this.inputText18 = inputText18;
    }

    public CoreInputText getInputText18() {
        return inputText18;
    }

    public void setInputText19(CoreInputText inputText19) {
        this.inputText19 = inputText19;
    }

    public CoreInputText getInputText19() {
        return inputText19;
    }

    public void setInputText20(CoreInputText inputText20) {
        this.inputText20 = inputText20;
    }

    public CoreInputText getInputText20() {
        return inputText20;
    }

    public void setInputText21(CoreInputText inputText21) {
        this.inputText21 = inputText21;
    }

    public CoreInputText getInputText21() {
        return inputText21;
    }

    public void setInputText22(CoreInputText inputText22) {
        this.inputText22 = inputText22;
    }

    public CoreInputText getInputText22() {
        return inputText22;
    }

    public void setBtnSubmit(CoreCommandButton commandButton1) {
        this.btnSubmit = commandButton1;
    }

    public CoreCommandButton getBtnSubmit() {
        return btnSubmit;
    }

    public void setCommandButton2(CoreCommandButton commandButton2) {
        this.commandButton2 = commandButton2;
    }

    public CoreCommandButton getCommandButton2() {
        return commandButton2;
    }

    public String btnSubmit_action() {
        // Add event code here...
        return null;
    }

    public void setBtnObtenerPlazaSicoin(CoreCommandButton commandButton1) {
        this.btnObtenerPlazaSicoin = commandButton1;
    }

    public CoreCommandButton getBtnObtenerPlazaSicoin() {
        return btnObtenerPlazaSicoin;
    }

    public void setBtnGrabarPlaza(CoreCommandButton commandButton1) {
        this.btnGrabarPlaza = commandButton1;
    }

    public CoreCommandButton getBtnGrabarPlaza() {
        return btnGrabarPlaza;
    }

    public BindingContainer getBindings() {
        return this.bindings;
    }

    public void setBindings(BindingContainer bindings) {
        this.bindings = bindings;
    }

}
