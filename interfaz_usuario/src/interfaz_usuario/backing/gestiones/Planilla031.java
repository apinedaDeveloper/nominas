package interfaz_usuario.backing.gestiones;

import enlace_datos.consultas.QUERRYSImpl;

import enlace_datos.consultas.complementos.ComplementoPersonalVImpl;
import enlace_datos.consultas.gestiones.ContratosParaTE031Lista_vwImpl;
import enlace_datos.consultas.gestiones.ContratosParaTE031_vwImpl;

import enlace_datos.util.resulOp;

import interfaz_usuario.util.JSFUtils;

import javax.faces.application.FacesMessage;
import javax.faces.component.UINamingContainer;


import javax.faces.component.UISelectItems;
import javax.faces.component.html.HtmlPanelGroup;

import javax.faces.context.FacesContext;

import javax.faces.el.ValueBinding;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCDataControl;
import oracle.adf.view.faces.component.core.CoreForm;
import oracle.adf.view.faces.component.core.data.CoreColumn;
import oracle.adf.view.faces.component.core.data.CoreTable;
import oracle.adf.view.faces.component.core.data.CoreTableSelectOne;
import oracle.adf.view.faces.component.core.input.CoreInputText;
import oracle.adf.view.faces.component.core.input.CoreSelectBooleanCheckbox;
import oracle.adf.view.faces.component.core.input.CoreSelectInputDate;
import oracle.adf.view.faces.component.core.input.CoreSelectItem;
import oracle.adf.view.faces.component.core.input.CoreSelectOneChoice;
import oracle.adf.view.faces.component.core.layout.CorePanelForm;
import oracle.adf.view.faces.component.core.layout.CorePanelHeader;
import oracle.adf.view.faces.component.core.layout.CoreShowDetailItem;
import oracle.adf.view.faces.component.core.layout.CoreShowOneTab;
import oracle.adf.view.faces.component.core.nav.CoreCommandButton;
import oracle.adf.view.faces.component.core.nav.CoreCommandLink;
import oracle.adf.view.faces.component.core.nav.CoreCommandMenuItem;
import oracle.adf.view.faces.component.core.nav.CorePage;
import oracle.adf.view.faces.component.core.output.CoreMessages;
import oracle.adf.view.faces.component.core.output.CoreObjectImage;
import oracle.adf.view.faces.component.core.output.CoreOutputText;
import oracle.adf.view.faces.component.html.HtmlBody;
import oracle.adf.view.faces.component.html.HtmlHead;
import oracle.adf.view.faces.component.html.HtmlHtml;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import enlace_datos.util.utils_DB;

import interfaz_usuario.util.utils;

import java.sql.ResultSet;

import java.util.ArrayList;


import pkg_util_base_datos.interfaz_DB;

public class Planilla031 {
    private boolean vCambioDep=false;
    private boolean vCambioDep2=false;
    private boolean vCambioTipoNomina=false;
    private HtmlHtml html1;
    private HtmlHead head1;
    private HtmlBody body1;
    private CoreForm form1;
    private CorePage page1;
    private CoreCommandMenuItem commandMenuItem1;
    private UINamingContainer info1;
    private UINamingContainer menuSwt;
    private UINamingContainer logo;
    private CoreShowOneTab showOneTab1;
    private CoreShowDetailItem showHistorial;
    private CoreShowDetailItem showPlanilla;
    private CorePanelHeader panelHeader1;
    private CorePanelHeader panelHeader2;
    private CoreMessages messages1;
    private CorePanelForm panelForm1;
    private CoreInputText inputText1;
    private CoreInputText inputText2;
    private CoreInputText inputText3;
    private CoreSelectInputDate selectInputDate1;
    private CoreInputText inpIdPartida;
    private CoreInputText inputText6;
    private CoreInputText inputText7;
    private CoreInputText inputText8;
    private CoreInputText inputText10;
    private CoreInputText inputText11;
    private CoreInputText inputText12;
    private CoreInputText inputText13;
    private CoreInputText inputText14;
    private CoreInputText inputText15;
    private CoreCommandButton commandButton1;
    private HtmlPanelGroup panelGroup1;
    private CoreCommandButton btnNuevaPlanilla;
    private CoreCommandButton btnGuardarPlanilla;
    private CoreCommandButton btnCancelar;
    private CoreTable tblPlanillaDet;
    private CoreColumn column1;
    private CoreInputText inputText16;
    private CoreColumn column2;
    private CoreInputText inputText17;
    private CoreColumn column3;
    private CoreInputText inputText18;
    private CoreColumn inpDiasLab;
    private CoreColumn column5;
    private CoreInputText inpSalarioDario;
    private CoreColumn column6;
    private CoreColumn column7;
    private CoreInputText inpBonificacion;
    private CoreColumn column8;
    private CoreInputText inpDescISR;
    private CoreColumn column9;
    private CoreTableSelectOne tableSelectOne1;
    private CoreCommandButton commandButton5;
    private CoreColumn column10;
    private CoreOutputText outputText2;
    private CoreCommandButton btnEditarDet;
    private CoreCommandButton btnCancelarEdicionDet;
    private CoreCommandButton btnGuardarDet;
    private CoreColumn column11;
    private CoreOutputText outputText3;
    private CoreColumn column12;
    private CoreOutputText outputText4;
    private CoreSelectOneChoice cmbDependencia;
    private UISelectItems selectItems1;
    private CoreSelectOneChoice cmbPartida;
    private UISelectItems selectItems2;
    private CorePanelHeader panelHeader3;
    private CoreTable table2;
    private CoreColumn column13;
    private CoreColumn column16;
    private CoreOutputText outputText8;
    private CoreColumn column17;
    private CoreOutputText outputText9;
    private CoreColumn column19;
    private CoreOutputText outputText11;
    private CoreColumn column20;
    private CoreOutputText outputText12;
    private CoreColumn column21;
    private CoreOutputText outputText13;
    private CoreColumn column22;
    private CoreOutputText outputText14;
    private CoreColumn column23;
    private CoreOutputText outputText15;
    private CoreColumn column25;
    private CoreOutputText outputText17;
    private CoreColumn column26;
    private CoreOutputText outputText18;
    private CoreColumn column27;
    private CoreOutputText outputText19;
    private CoreColumn column28;
    private CoreOutputText outputText20;
    private CoreCommandLink lnkIDisr;
    private BindingContainer bindings;
    private CoreCommandLink lnkImprimir;
    private CoreObjectImage objectImage1;
    private CoreColumn column261;
    private CoreOutputText outputText181;
    private CoreColumn column262;
    private CoreOutputText outputText182;
    private CoreCommandLink lnkTrasladar;
    private CoreObjectImage objectImage3;
    private CoreCommandButton commandButton2;
    private CoreCommandButton btnGenerarISR;
    private CoreCommandButton btnEliminarDet;
    private CoreOutputText outputText6;
    private CoreInputText inpDiasLabProy;
    private CoreColumn column4;
    private CoreOutputText outputText1;
    private CoreInputText inpTotDevProy;
    private CoreCommandButton btnGenDetPlanilla;
    private CoreCommandButton commandButton3;
    private CoreColumn column61;
    private CoreInputText inpTotDevProy1;
    private CoreColumn column14;
    private CoreInputText inpBonificacionProy;
    private CoreShowDetailItem showTE;
    private CorePanelHeader panelHeader4;
    private CorePanelHeader panelHeader5;
    private CorePanelHeader panelHeader6;
    private CoreTable table1;
    private CoreColumn column15;
    private CoreOutputText outputText5;
    private CoreColumn column18;
    private CoreOutputText outputText7;
    private CoreColumn column24;
    private CoreOutputText outputText10;
    private CoreColumn column29;
    private CoreOutputText outputText16;
    private CoreColumn column30;
    private CoreOutputText outputText21;
    private CoreColumn column31;
    private CoreOutputText outputText22;
    private CoreColumn column32;
    private CoreOutputText outputText23;
    private CoreColumn column33;
    private CoreOutputText outputText24;
    private CoreColumn column34;
    private CoreOutputText outputText25;
    private CoreColumn column35;
    private CoreOutputText outputText26;
    private CoreColumn column36;
    private CoreOutputText outputText27;
    private CoreTable table3;
    private CoreColumn column38;
    private CoreOutputText outputText29;
    private CoreColumn column39;
    private CoreOutputText outputText30;
    private CoreColumn column40;
    private CoreOutputText outputText31;
    private CoreColumn column41;
    private CoreOutputText outputText32;
    private CoreColumn column42;
    private CoreOutputText outputText33;
    private CoreColumn column43;
    private CoreOutputText outputText34;
    private CoreColumn column37;
    private CoreSelectBooleanCheckbox outputText161;
    private CoreColumn column44;
    private CoreSelectBooleanCheckbox outputText1611;
    private CoreCommandButton btnAgretarTE;
    private CoreCommandButton btnQuitarTE;
    private HtmlPanelGroup panelGroup2;
    private CoreCommandButton btnGenerarTE;
    private CoreCommandButton btnVaciarTE;
    private CorePanelForm panelForm2;
    private CoreInputText inputText19;
    private CoreInputText inputText20;
    private CoreInputText inputText22;
    private CoreCommandButton btnBuscar;
    private CoreSelectOneChoice cmbDependencia2;
    private UISelectItems selectItems3;
    private CoreSelectOneChoice cmbPartida2;
    private UISelectItems selectItems4;
    private CoreSelectOneChoice inputText21;
    private CoreSelectItem selectItem20;
    private CoreSelectItem selectItem21;
    private CoreSelectItem selectItem22;
    private CoreSelectItem selectItem23;
    private CoreSelectItem selectItem24;
    private CoreSelectItem selectItem25;
    private CoreSelectItem selectItem26;
    private CoreSelectItem selectItem27;
    private CoreSelectItem selectItem28;
    private CoreSelectItem selectItem29;
    private CoreSelectItem selectItem30;
    private CoreSelectItem selectItem31;
    private CoreSelectItem selectItem32;
    private CoreColumn column45;
    private CoreOutputText outputText110;
    private CoreInputText inputText4;
    private CoreSelectOneChoice selectOneChoice1;
    private UISelectItems selectItems5;
    private CoreSelectOneChoice cmbTipoNomina;
    private CoreSelectItem selectItem14;
    private CoreSelectItem selectItem17;
    private CoreSelectItem selectItem15;
    private CoreSelectItem selectItem19;
    private CoreSelectItem selectItem16;
    private CoreSelectItem selectItem18;

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


    public void setShowOneTab1(CoreShowOneTab showOneTab1) {
        this.showOneTab1 = showOneTab1;
    }

    public CoreShowOneTab getShowOneTab1() {
        return showOneTab1;
    }

    public void setShowHistorial(CoreShowDetailItem showDetailItem1) {
        this.showHistorial = showDetailItem1;
    }

    public CoreShowDetailItem getShowHistorial() {
        return showHistorial;
    }

    public void setShowPlanilla(CoreShowDetailItem showDetailItem2) {
        this.showPlanilla = showDetailItem2;
    }

    public CoreShowDetailItem getShowPlanilla() {
        return showPlanilla;
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


    public void setMessages1(CoreMessages messages1) {
        this.messages1 = messages1;
    }

    public CoreMessages getMessages1() {
        return messages1;
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

    public void setSelectInputDate1(CoreSelectInputDate selectInputDate1) {
        this.selectInputDate1 = selectInputDate1;
    }

    public CoreSelectInputDate getSelectInputDate1() {
        return selectInputDate1;
    }


    public void setInpIdPartida(CoreInputText inputText5) {
        this.inpIdPartida = inputText5;
    }

    public CoreInputText getInpIdPartida() {
        return inpIdPartida;
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

    public void setCommandButton1(CoreCommandButton commandButton1) {
        this.commandButton1 = commandButton1;
    }

    public CoreCommandButton getCommandButton1() {
        return commandButton1;
    }

    public void setPanelGroup1(HtmlPanelGroup panelGroup1) {
        this.panelGroup1 = panelGroup1;
    }

    public HtmlPanelGroup getPanelGroup1() {
        return panelGroup1;
    }

    public void setBtnNuevaPlanilla(CoreCommandButton commandButton2) {
        this.btnNuevaPlanilla = commandButton2;
    }

    public CoreCommandButton getBtnNuevaPlanilla() {
        return btnNuevaPlanilla;
    }

    public void setBtnGuardarPlanilla(CoreCommandButton commandButton3) {
        this.btnGuardarPlanilla = commandButton3;
    }

    public CoreCommandButton getBtnGuardarPlanilla() {
        return btnGuardarPlanilla;
    }

    public void setBtnCancelar(CoreCommandButton commandButton4) {
        this.btnCancelar = commandButton4;
    }

    public CoreCommandButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setTblPlanillaDet(CoreTable table1) {
        this.tblPlanillaDet = table1;
    }

    public CoreTable getTblPlanillaDet() {
        return tblPlanillaDet;
    }

    public void setColumn1(CoreColumn column1) {
        this.column1 = column1;
    }

    public CoreColumn getColumn1() {
        return column1;
    }

    public void setInputText16(CoreInputText inputText16) {
        this.inputText16 = inputText16;
    }

    public CoreInputText getInputText16() {
        return inputText16;
    }

    public void setColumn2(CoreColumn column2) {
        this.column2 = column2;
    }

    public CoreColumn getColumn2() {
        return column2;
    }

    public void setInputText17(CoreInputText inputText17) {
        this.inputText17 = inputText17;
    }

    public CoreInputText getInputText17() {
        return inputText17;
    }

    public void setColumn3(CoreColumn column3) {
        this.column3 = column3;
    }

    public CoreColumn getColumn3() {
        return column3;
    }

    public void setInputText18(CoreInputText inputText18) {
        this.inputText18 = inputText18;
    }

    public CoreInputText getInputText18() {
        return inputText18;
    }

    public void setInpDiasLab(CoreColumn column4) {
        this.inpDiasLab = column4;
    }

    public CoreColumn getInpDiasLab() {
        return inpDiasLab;
    }


    public void setColumn5(CoreColumn column5) {
        this.column5 = column5;
    }

    public CoreColumn getColumn5() {
        return column5;
    }

    public void setInpSalarioDario(CoreInputText inputText20) {
        this.inpSalarioDario = inputText20;
    }

    public CoreInputText getInpSalarioDario() {
        return inpSalarioDario;
    }

    public void setColumn6(CoreColumn column6) {
        this.column6 = column6;
    }

    public CoreColumn getColumn6() {
        return column6;
    }


    public void setColumn7(CoreColumn column7) {
        this.column7 = column7;
    }

    public CoreColumn getColumn7() {
        return column7;
    }

    public void setInpBonificacion(CoreInputText inputText22) {
        this.inpBonificacion = inputText22;
    }

    public CoreInputText getInpBonificacion() {
        return inpBonificacion;
    }

    public void setColumn8(CoreColumn column8) {
        this.column8 = column8;
    }

    public CoreColumn getColumn8() {
        return column8;
    }

    public void setInpDescISR(CoreInputText inputText23) {
        this.inpDescISR = inputText23;
    }

    public CoreInputText getInpDescISR() {
        return inpDescISR;
    }

    public void setColumn9(CoreColumn column9) {
        this.column9 = column9;
    }

    public CoreColumn getColumn9() {
        return column9;
    }


    public void setTableSelectOne1(CoreTableSelectOne tableSelectOne1) {
        this.tableSelectOne1 = tableSelectOne1;
    }

    public CoreTableSelectOne getTableSelectOne1() {
        return tableSelectOne1;
    }

    public void setCommandButton5(CoreCommandButton commandButton5) {
        this.commandButton5 = commandButton5;
    }

    public CoreCommandButton getCommandButton5() {
        return commandButton5;
    }

    public void setColumn10(CoreColumn column10) {
        this.column10 = column10;
    }

    public CoreColumn getColumn10() {
        return column10;
    }

    public void setOutputText2(CoreOutputText outputText2) {
        this.outputText2 = outputText2;
    }

    public CoreOutputText getOutputText2() {
        return outputText2;
    }

    public void setBtnEditarDet(CoreCommandButton commandButton6) {
        this.btnEditarDet = commandButton6;
    }

    public CoreCommandButton getBtnEditarDet() {
        return btnEditarDet;
    }

    public void setBtnCancelarEdicionDet(CoreCommandButton commandButton6) {
        this.btnCancelarEdicionDet = commandButton6;
    }

    public CoreCommandButton getBtnCancelarEdicionDet() {
        return btnCancelarEdicionDet;
    }

    public void setBtnGuardarDet(CoreCommandButton commandButton6) {
        this.btnGuardarDet = commandButton6;
    }

    public CoreCommandButton getBtnGuardarDet() {
        return btnGuardarDet;
    }
/* **************************************************************************** */
/* **************************************************************************** */
/* **************************************************************************** */
     //Método que muestra un mensaje en la pantalla. Tipos de Alerta: 1=INFO, 2=ADVERTENCIA y 3=ERROR
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

     public boolean getCambioDep(){        
         return vCambioDep ;
     }

    public boolean getCambioDep2(){        
        return vCambioDep2;
    }
    
    public boolean getCambioTipoNomina(){
        return vCambioTipoNomina;
    }

    public void cmbDependencia(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (valueChangeEvent.getOldValue()!=valueChangeEvent.getNewValue()){
            //System.out.println("Cambio valor de combo");
            vCambioDep=true;
        }
    }

    public void cmbDependencia2(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (valueChangeEvent.getOldValue()!=valueChangeEvent.getNewValue()){
            //System.out.println("Cambio valor de combo, anterior:="+valueChangeEvent.getOldValue()+", actual:="+valueChangeEvent.getNewValue());
            vCambioDep2=true;
        }
    }

    public void cmbTipoNomina(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (valueChangeEvent.getOldValue()!=valueChangeEvent.getNewValue()){
            //System.out.println("Cambio valor de combo, anterior:="+valueChangeEvent.getOldValue()+", actual:="+valueChangeEvent.getNewValue());
            vCambioTipoNomina=true;
        }
    }

    public String btnCancelar_action() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = 
            bindings.getOperationBinding("Rollback");
        Object result = operationBinding.execute();
        this.tblPlanillaDet.setRendered(true);
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        this.getShowHistorial().setDisclosed(true);
        this.getShowPlanilla().setDisclosed(false);
        this.getShowHistorial().setDisabled(false);
        this.getShowPlanilla().setDisabled(true);
        return null;
    }

    public String btnNuevaPlanilla_action() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding =bindings.getOperationBinding("Create");
        Object result = operationBinding.execute();
        this.tblPlanillaDet.setRendered(false);
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        return null;
    }

    public String btnGuardarPlanilla_action() {
        BindingContainer bindings = getBindings();
        //BindingContainer bindings;
        String mensaje;
        OperationBinding operationBinding; 
        interfaz_DB conec;
        conec= new interfaz_DB();
        try {
            String vQuery;
            Object vIdPartida;
            Object vIdTipoNomina;
            Object vRenglon;
            Object vPrograma;
            ResultSet vResultado;

            vIdPartida=null;
            vIdTipoNomina=null;
            vRenglon=null;
            vPrograma=null;
            vResultado=null;

            vIdPartida=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdPartida.inputValue}");
            vIdTipoNomina=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdTipoNomina.inputValue}");
            if (vIdTipoNomina.equals("1")){
                vRenglon=31;    //Renglon normal
            }else if (vIdTipoNomina.equals("2") || vIdTipoNomina.equals("3")){
                vRenglon=75;    //Renglon para Diferidos (12% y 50%)
            }else if (vIdTipoNomina.equals("5")){
                vRenglon=72;    //Renglon para Bono14
            }else if (vIdTipoNomina.equals("6")){
                vRenglon=71;    //Renglon para Aguinaldo
            };
            vQuery="select d1||d2 Programa from partida where id_partida="+vIdPartida;
            vResultado = conec.Bol_ejecutar_sentencia(vQuery);
            
            if (vResultado.next()){
                //System.out.println("Programa:="+vResultado.getString("Programa"));
                vPrograma = vResultado.getString("Programa");
            };
            //vPrograma=41; //solo para ver que si funcionan los queries
            if (vPrograma.equals("41")){
                if (vIdTipoNomina.equals("2") || vIdTipoNomina.equals("3") || vIdTipoNomina.equals("5") || vIdTipoNomina.equals("6")){
                    vQuery="select id_partida from partida "
                    +"where d1=4 and d2=2 and d3d4=1 and d5=1 and d6=0 and d7=1 "
                    +"and d8=0 and d9d10="+vRenglon;
                }else{
                    if(vIdTipoNomina.equals("11")){
                        vIdPartida=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdPartida.inputValue}");
                        vQuery="select p2.id_partida from partida p1, partida p2 "
                        +"where p1.id_partida="+vIdPartida
                        +"and p1.d1=p2.d1 and p1.d2=p2.d2 and p1.d3d4=p2.d3d4 and p1.d5=p2.d5 and p1.d6=p2.d6 and p1.d7=p2.d7 "
                        +"and p2.d8=0 and p2.d9d10="+vRenglon;
                    }
                }
            }else{
                vIdPartida=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdPartida.inputValue}");
                vQuery="select p2.id_partida from partida p1, partida p2 "
                +"where p1.id_partida="+vIdPartida
                +"and p1.d1=p2.d1 and p1.d2=p2.d2 and p1.d3d4=p2.d3d4 and p1.d5=p2.d5 and p1.d6=p2.d6 and p1.d7=p2.d7 "
                +"and p2.d8=0 and p2.d9d10="+vRenglon;
            };

            vResultado = conec.Bol_ejecutar_sentencia(vQuery);
            
            if (vResultado.next()){
                //System.out.println("partida obtenida:= "+vResultado.getInt("Id_Partida"));
                operationBinding= bindings.getOperationBinding("Commit");
                Object result = operationBinding.execute();
                if (operationBinding.getErrors().isEmpty()) {
                    operationBinding= bindings.getOperationBinding("genDetallePlanilla");
                    result = operationBinding.execute();
                    if (operationBinding.getErrors().isEmpty()) {
                        //operationBinding= bindings.getOperationBinding("RefrescarPlanilla");
                        //result = operationBinding.execute();
                        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                                 "EjecutarDetallePlanilla"); //Refresh al Detalle Seleccionado
                        this.tblPlanillaDet.setRendered(true);
                        mensaje = "Información Guardada Éxitosamente!!";
                        mensaje(mensaje, 1); // 1 = tipo INFO
                    } else {
                        mensaje = "Ha ocurrido un error inesperado. Por favor revise.";
                        mensaje(mensaje, 3); // 3 = tipo ERROR
                    }
                }
                
            }else{
                utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"NO EXISTE PARTIDA RELACIONADA AL TIPO DE NOMINA SELECCIONADA"));
            } //fin del if (vResultado.next()){
            return null;
        }catch (Exception e) {
            conec.cn_Cerrar_coneccion();
            e.printStackTrace();
            return null;
        }
    }


    public String btnGenDetPlanilla_action() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("genDetallePlanilla");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        return null;
    }

    public String btnEditarDet_action() {
        // Add event code here...
        Object pIdTipoNomina;
        pIdTipoNomina=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdTipoNomina.inputValue}");
        //System.out.println("pIdTipoNomina:= "+pIdTipoNomina);
        if ( Integer.parseInt(pIdTipoNomina.toString()) == 1){
            this.inpDiasLabProy.setDisabled(false);
            this.inpDescISR.setDisabled(false);
            //this.inpBonificacion.setDisabled(false);
            this.inpBonificacionProy.setDisabled(false);
        }else{
            this.inpDiasLabProy.setDisabled(false);
            this.inpTotDevProy.setDisabled(false);
            this.inpSalarioDario.setDisabled(false);
        }
        this.btnEditarDet.setDisabled(true);
        this.btnCancelarEdicionDet.setDisabled(false);
        this.btnGuardarDet.setDisabled(false);
        this.btnEliminarDet.setDisabled(false);
        return null;
    }

    public String btnCancelarEdicionDet_action() {
        // Add event code here...
         this.inpDiasLabProy.setDisabled(true);
         this.inpTotDevProy.setDisabled(true);
         this.inpSalarioDario.setDisabled(true);
         this.inpDescISR.setDisabled(true);
         //this.inpBonificacion.setDisabled(true);
         this.inpBonificacionProy.setDisabled(true);
         this.btnEditarDet.setDisabled(false);
         this.btnCancelarEdicionDet.setDisabled(true);
         this.btnGuardarDet.setDisabled(true);
         this.btnEliminarDet.setDisabled(true);
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                 "EjecutarDetallePlanilla"); //Refresh al Detalle Seleccionado
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                 "setCurrentRowWithKeyDet"); //Apunta a última la fila seleccionada
        return null;
    }

    public String btnGuardarDet_action() {
        // Add event code here...
        String mensaje;
        OperationBinding operationBinding; 
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit")){
            this.inpDiasLabProy.setDisabled(true);
            this.inpTotDevProy.setDisabled(true);
            this.inpSalarioDario.setDisabled(true);
            this.inpDescISR.setDisabled(true);
            //this.inpBonificacion.setDisabled(true);
            this.inpBonificacionProy.setDisabled(true);
            this.btnEditarDet.setDisabled(false);
            this.btnCancelarEdicionDet.setDisabled(true);
            this.btnGuardarDet.setDisabled(true);
            this.btnEliminarDet.setDisabled(true);
            //operationBinding= bindings.getOperationBinding("RefrescarPlanilla");
            //operationBinding.execute();
             JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                      "EjecutarDetallePlanilla"); //Refresh al Detalle Seleccionado
             JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                      "setCurrentRowWithKeyDet"); //Apunta a última la fila seleccionada
            mensaje = "Información Guardada Éxitosamente!!";
            mensaje(mensaje, 1); // 1 = tipo INFO
        } else {
            mensaje = "Ha ocurrido un error inesperado. Por favor revise.";
            mensaje(mensaje, 3); // 3 = tipo ERROR
        }
        return null;
    }

    public String btnGenerarISR_action() {
        BindingContainer bindings = getBindings();
        String mensaje;
        OperationBinding operationBinding = bindings.getOperationBinding("generarDescuentoISR");
        Object result = operationBinding.execute();
        if (operationBinding.getErrors().isEmpty()) {
            mensaje = "Información Guardada Éxitosamente!!";
            mensaje(mensaje, 1); // 1 = tipo INFO
        } else {
            mensaje = "Ha ocurrido un error inesperado. Por favor revise.";
            mensaje(mensaje, 3); // 3 = tipo ERROR
        }
        return null;
    }
    
    public String btnAgretarTE_action() {
        // Add event code here...
         interfaz_DB conec;
         conec= new interfaz_DB();
         try {
            int FilasContratos=0;
            int FilasListado=0;
            int i=0;
            int j=0;
            boolean vEncontrado=false;
            FacesContext ctx = FacesContext.getCurrentInstance();
            //ExternalContext ectx = ctx.getExternalContext();
            ValueBinding vb = ctx.getApplication().createValueBinding("#{data}");
            BindingContext bc = (BindingContext)vb.getValue(ctx);
            DCDataControl dc  = bc.findDataControl("QUERRYSDataControl");
            ApplicationModule am = (ApplicationModule)dc.getDataProvider();
            QUERRYSImpl service    = (QUERRYSImpl)am;
    
            ContratosParaTE031_vwImpl Contratos = service.getContratosParaTE031_vw();
            ContratosParaTE031Lista_vwImpl Listado = service.getContratosParaTE031Lista_vw();
            FilasContratos = Contratos.getFetchedRowCount();
            Row rContratos=null;
            Row rListado=null;
            Row rListado2=null;
            
            Contratos.first();
            for(i=0; i<FilasContratos; i++){
                rContratos = Contratos.getCurrentRow();
                if(rContratos!=null && rContratos.getAttribute("Seleccionar").equals(true)){
                    FilasListado = Listado.getFetchedRowCount();
                    Listado.first();
                    for(j=0; j<FilasListado; j++){
                        rListado2 = Listado.getCurrentRow();
                        if(rContratos.getAttribute("IdContrato") == rListado2.getAttribute("IdContrato")){
                            vEncontrado=true;
                            j=FilasListado; //Esto solo para que finalice el ciclo
                        }   
                        Listado.next();
                    }//Fin del for(j=0; i<FilasListado; i++){

                    if (vEncontrado){
                        mensaje("Uno de los CONTRATOS Seleccionados ya está agregado al listado", 3); // 1 = tipo INFO, 3 = tipo ERROR
                        vEncontrado=false; //Para reiniciar otro recorrido
                    }else{
                        rListado = Listado.createRow();
                        rListado.setAttribute("IdContrato",rContratos.getAttribute("IdContrato"));
                        rListado.setAttribute("RegistroEmpleado",rContratos.getAttribute("RegistroEmpleado"));
                        rListado.setAttribute("NombreEmpleado",rContratos.getAttribute("Nombrecompleto"));
                        rListado.setAttribute("NombrePuesto",rContratos.getAttribute("NombrePuesto"));
                        rListado.setAttribute("FechaInicio",rContratos.getAttribute("FechaInicio"));
                        rListado.setAttribute("FechaFin",rContratos.getAttribute("FechaFin"));
                        Listado.insertRow(rListado);
                    }
                }
                Contratos.next();
            }
            conec.cn_Cerrar_coneccion();
        }catch (Exception e) {
            conec.cn_Cerrar_coneccion();
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public String btnQuitarTE_action() {
        // Add event code here...
         int FilasContratos=0;
         int i=0;
         FacesContext ctx = FacesContext.getCurrentInstance();
         //ExternalContext ectx = ctx.getExternalContext();
         ValueBinding vb = ctx.getApplication().createValueBinding("#{data}");
         BindingContext bc = (BindingContext)vb.getValue(ctx);
         DCDataControl dc  = bc.findDataControl("QUERRYSDataControl");
         ApplicationModule am = (ApplicationModule)dc.getDataProvider();
         QUERRYSImpl service    = (QUERRYSImpl)am;
         
         ContratosParaTE031Lista_vwImpl Listado = service.getContratosParaTE031Lista_vw();
         FilasContratos = Listado.getFetchedRowCount();
         Row rListado=null;
         
         Listado.first();
         for(i=0; i<FilasContratos; i++){
             rListado = Listado.getCurrentRow();
             if(rListado!=null && rListado.getAttribute("Seleccionar").equals(true)){
                 Listado.removeCurrentRow();
             }else{
                 Listado.next();
             }
         }
        
        return null;
    }

    public String btnVaciarTE_action() {
        // Add event code here...
         FacesContext ctx = FacesContext.getCurrentInstance();
         //ExternalContext ectx = ctx.getExternalContext();
         ValueBinding vb = ctx.getApplication().createValueBinding("#{data}");
         BindingContext bc = (BindingContext)vb.getValue(ctx);
         DCDataControl dc  = bc.findDataControl("QUERRYSDataControl");
         ApplicationModule am = (ApplicationModule)dc.getDataProvider();
         QUERRYSImpl service    = (QUERRYSImpl)am;
         
         ContratosParaTE031Lista_vwImpl Listado = service.getContratosParaTE031Lista_vw();
         Listado.executeQuery();
         
        return null;
    }

    public String btnGenerarTE_action() {
        // Add event code here...
        interfaz_DB conec;
        conec= new interfaz_DB();
        try {
            int Filas=0;
            int i=0;
            boolean vExito;
            String vQuery;
            Object vIdPartida;
            ResultSet vResultado;
            //Creando el binding container
            FacesContext ctx = FacesContext.getCurrentInstance();
            //ExternalContext ectx = ctx.getExternalContext();
            ValueBinding vb = ctx.getApplication().createValueBinding("#{data}");
            BindingContext bc = (BindingContext)vb.getValue(ctx);
            DCDataControl dc  = bc.findDataControl("QUERRYSDataControl");
            ApplicationModule am = (ApplicationModule)dc.getDataProvider();
            QUERRYSImpl service    = (QUERRYSImpl)am;


            vIdPartida=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.pIdPartida.inputValue}");
            vQuery="select p2.id_partida, (p2.d1||p2.d2||'.'||Lpad(p2.d3d4,2,'00')||'.'||p2.d5||p2.d6||p2.d7||'.'||p2.d8||p2.d9d10) Partida "
            +" from partida p1, partida p2 where p1.id_partida= "+vIdPartida
            +"and p1.d1=p2.d1 and p1.d2=p2.d2 and p1.d3d4=p2.d3d4 and p1.d5=p2.d5 and p1.d6=p2.d6 and p1.d7=p2.d7 "
            +"and p2.d8=0 and p2.d9d10=43";

            vResultado = conec.Bol_ejecutar_sentencia(vQuery);
            
            if (vResultado.next()) {
                System.out.println("id_partida:= "+vResultado.getInt("Id_partida"));
                System.out.println("Partida:= "+vResultado.getString("Partida"));
                ContratosParaTE031Lista_vwImpl ListaTE = service.getContratosParaTE031Lista_vw();
                Filas = ListaTE.getFetchedRowCount();
                if(Filas > 0){
                    Object pIdIsr;
                    Object pDiasLaborados;
                    Object pSalarioDario;
                    Object pBonificacion;
                    Row rListaTE=null;
                    ListaTE.first();
    
                    rListaTE = ListaTE.getCurrentRow();
                    JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"crearPlanilla031");
                    JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Commit");
                    pIdIsr=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdIsr.inputValue}");
                    if (pIdIsr != null) {
                        vExito=true;
                        ArrayList vParametros;
                        for(i=0; i<Filas; i++){
                            rListaTE = ListaTE.getCurrentRow();
                            vParametros= new ArrayList();
                            pDiasLaborados=0;
                            pSalarioDario=0;
                            pBonificacion=0;
                            vParametros.add(pIdIsr);
                            vParametros.add(rListaTE.getAttribute("RegistroEmpleado"));
                            vParametros.add(rListaTE.getAttribute("IdContrato"));
                            vParametros.add(pDiasLaborados); //Dias laborados
                            vParametros.add(pSalarioDario); //Salario diario
                            vParametros.add(pBonificacion); //Bonificacion
                            if (!conec.Bol_ejecutar_procedimiento("SIS_PKG_CALCULOS.GenerarPlanilla031_Det(?,?,?,?,?,?)",vParametros)){
                                vExito=false;
                            }
                            ListaTE.next();
                        }//Fin del for(i=0; i<Filas; i++)
    
                        if (vExito){
                            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Commit");
                            ListaTE.executeQuery();  //Para limpiar el listado de trabajadora para generar TE 
                            utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Se ha calculado exitosamente la operacion"));
                            this.showTE.setDisclosed(false);
                            this.showPlanilla.setDisclosed(true);
                            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                                     "EjecutarDetallePlanilla"); //Refresh al Detalle Seleccionado
                            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                                     "setCurrentRowWithKeyDet"); //Apunta a última la fila seleccionada
                    }else{
                            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Rollback");
                            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Ha ocurrido un error, por favor revisar."));
                            vExito=false;
                        }
                        conec.cn_Cerrar_coneccion();
                    }else{
                        utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Ha ocurrido un error al intentar generar la Planilla"));
                    }
                }else{
                    utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"No se ha seleccionado ningun contrato para generar Tiempo Extraodinario"));
                }
            }else {
                utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"NO EXISTE PARTIDA RELACIONADA A PAGO DE TIEMPO EXTRAORDINARIO"));
            }
            
            return null;
        }catch (Exception e) {
            conec.cn_Cerrar_coneccion();
            e.printStackTrace();
            return null;
        }
    }


/* **************************************************************************** */ 
/* **************************************************************************** */ 
/* **************************************************************************** */ 

    public void setColumn11(CoreColumn column11) {
        this.column11 = column11;
    }

    public CoreColumn getColumn11() {
        return column11;
    }

    public void setOutputText3(CoreOutputText outputText3) {
        this.outputText3 = outputText3;
    }

    public CoreOutputText getOutputText3() {
        return outputText3;
    }

    public void setColumn12(CoreColumn column12) {
        this.column12 = column12;
    }

    public CoreColumn getColumn12() {
        return column12;
    }

    public void setOutputText4(CoreOutputText outputText4) {
        this.outputText4 = outputText4;
    }

    public CoreOutputText getOutputText4() {
        return outputText4;
    }

    public void setCmbDependencia(CoreSelectOneChoice selectOneChoice1) {
        this.cmbDependencia = selectOneChoice1;
    }

    public CoreSelectOneChoice getCmbDependencia() {
        return cmbDependencia;
    }

    public void setSelectItems1(UISelectItems selectItems1) {
        this.selectItems1 = selectItems1;
    }

    public UISelectItems getSelectItems1() {
        return selectItems1;
    }

    public void setCmbPartida(CoreSelectOneChoice selectOneChoice1) {
        this.cmbPartida = selectOneChoice1;
    }

    public CoreSelectOneChoice getCmbPartida() {
        return cmbPartida;
    }

    public void setSelectItems2(UISelectItems selectItems2) {
        this.selectItems2 = selectItems2;
    }

    public UISelectItems getSelectItems2() {
        return selectItems2;
    }

    public void setPanelHeader3(CorePanelHeader panelHeader3) {
        this.panelHeader3 = panelHeader3;
    }

    public CorePanelHeader getPanelHeader3() {
        return panelHeader3;
    }

    public void setTable2(CoreTable table2) {
        this.table2 = table2;
    }

    public CoreTable getTable2() {
        return table2;
    }

    public void setColumn13(CoreColumn column13) {
        this.column13 = column13;
    }

    public CoreColumn getColumn13() {
        return column13;
    }


    public void setColumn16(CoreColumn column16) {
        this.column16 = column16;
    }

    public CoreColumn getColumn16() {
        return column16;
    }

    public void setOutputText8(CoreOutputText outputText8) {
        this.outputText8 = outputText8;
    }

    public CoreOutputText getOutputText8() {
        return outputText8;
    }

    public void setColumn17(CoreColumn column17) {
        this.column17 = column17;
    }

    public CoreColumn getColumn17() {
        return column17;
    }

    public void setOutputText9(CoreOutputText outputText9) {
        this.outputText9 = outputText9;
    }

    public CoreOutputText getOutputText9() {
        return outputText9;
    }


    public void setColumn19(CoreColumn column19) {
        this.column19 = column19;
    }

    public CoreColumn getColumn19() {
        return column19;
    }

    public void setOutputText11(CoreOutputText outputText11) {
        this.outputText11 = outputText11;
    }

    public CoreOutputText getOutputText11() {
        return outputText11;
    }

    public void setColumn20(CoreColumn column20) {
        this.column20 = column20;
    }

    public CoreColumn getColumn20() {
        return column20;
    }

    public void setOutputText12(CoreOutputText outputText12) {
        this.outputText12 = outputText12;
    }

    public CoreOutputText getOutputText12() {
        return outputText12;
    }

    public void setColumn21(CoreColumn column21) {
        this.column21 = column21;
    }

    public CoreColumn getColumn21() {
        return column21;
    }

    public void setOutputText13(CoreOutputText outputText13) {
        this.outputText13 = outputText13;
    }

    public CoreOutputText getOutputText13() {
        return outputText13;
    }

    public void setColumn22(CoreColumn column22) {
        this.column22 = column22;
    }

    public CoreColumn getColumn22() {
        return column22;
    }

    public void setOutputText14(CoreOutputText outputText14) {
        this.outputText14 = outputText14;
    }

    public CoreOutputText getOutputText14() {
        return outputText14;
    }

    public void setColumn23(CoreColumn column23) {
        this.column23 = column23;
    }

    public CoreColumn getColumn23() {
        return column23;
    }

    public void setOutputText15(CoreOutputText outputText15) {
        this.outputText15 = outputText15;
    }

    public CoreOutputText getOutputText15() {
        return outputText15;
    }


    public void setColumn25(CoreColumn column25) {
        this.column25 = column25;
    }

    public CoreColumn getColumn25() {
        return column25;
    }

    public void setOutputText17(CoreOutputText outputText17) {
        this.outputText17 = outputText17;
    }

    public CoreOutputText getOutputText17() {
        return outputText17;
    }

    public void setColumn26(CoreColumn column26) {
        this.column26 = column26;
    }

    public CoreColumn getColumn26() {
        return column26;
    }

    public void setOutputText18(CoreOutputText outputText18) {
        this.outputText18 = outputText18;
    }

    public CoreOutputText getOutputText18() {
        return outputText18;
    }

    public void setColumn27(CoreColumn column27) {
        this.column27 = column27;
    }

    public CoreColumn getColumn27() {
        return column27;
    }

    public void setOutputText19(CoreOutputText outputText19) {
        this.outputText19 = outputText19;
    }

    public CoreOutputText getOutputText19() {
        return outputText19;
    }

    public void setColumn28(CoreColumn column28) {
        this.column28 = column28;
    }

    public CoreColumn getColumn28() {
        return column28;
    }

    public void setOutputText20(CoreOutputText outputText20) {
        this.outputText20 = outputText20;
    }

    public CoreOutputText getOutputText20() {
        return outputText20;
    }

    public void setLnkIDisr(CoreCommandLink commandLink1) {
        this.lnkIDisr = commandLink1;
    }

    public CoreCommandLink getLnkIDisr() {
        return lnkIDisr;
    }

    public BindingContainer getBindings() {
        return this.bindings;
    }

    public void setBindings(BindingContainer bindings) {
        this.bindings = bindings;
    }

    public String lnkIDisr_action() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = 
            bindings.getOperationBinding("setCurrentRowWithKey");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        this.showHistorial.setDisclosed(false);
        this.showPlanilla.setDisclosed(true);
        return null;
    }

    public void setLnkImprimir(CoreCommandLink commandLink1) {
        this.lnkImprimir = commandLink1;
    }

    public CoreCommandLink getLnkImprimir() {
        return lnkImprimir;
    }


    public void setObjectImage1(CoreObjectImage objectImage1) {
        this.objectImage1 = objectImage1;
    }

    public CoreObjectImage getObjectImage1() {
        return objectImage1;
    }


    public void setColumn261(CoreColumn column261) {
        this.column261 = column261;
    }

    public CoreColumn getColumn261() {
        return column261;
    }

    public void setOutputText181(CoreOutputText outputText181) {
        this.outputText181 = outputText181;
    }

    public CoreOutputText getOutputText181() {
        return outputText181;
    }

    public void setColumn262(CoreColumn column262) {
        this.column262 = column262;
    }

    public CoreColumn getColumn262() {
        return column262;
    }

    public void setOutputText182(CoreOutputText outputText182) {
        this.outputText182 = outputText182;
    }

    public CoreOutputText getOutputText182() {
        return outputText182;
    }


    public void setLnkTrasladar(CoreCommandLink lnkTrasladar) {
        this.lnkTrasladar = lnkTrasladar;
    }

    public CoreCommandLink getLnkTrasladar() {
        return lnkTrasladar;
    }

    public void setObjectImage3(CoreObjectImage objectImage3) {
        this.objectImage3 = objectImage3;
    }

    public CoreObjectImage getObjectImage3() {
        return objectImage3;
    }


    public void setCommandButton2(CoreCommandButton commandButton2) {
        this.commandButton2 = commandButton2;
    }

    public CoreCommandButton getCommandButton2() {
        return commandButton2;
    }

    public void setBtnGenerarISR(CoreCommandButton commandButton3) {
        this.btnGenerarISR = commandButton3;
    }

    public CoreCommandButton getBtnGenerarISR() {
        return btnGenerarISR;
    }

    public void setBtnEliminarDet(CoreCommandButton commandButton3) {
        this.btnEliminarDet = commandButton3;
    }

    public CoreCommandButton getBtnEliminarDet() {
        return btnEliminarDet;
    }


    public void setOutputText6(CoreOutputText outputText6) {
        this.outputText6 = outputText6;
    }

    public CoreOutputText getOutputText6() {
        return outputText6;
    }


    public void setInpDiasLabProy(CoreInputText inputText201) {
        this.inpDiasLabProy = inputText201;
    }

    public CoreInputText getInpDiasLabProy() {
        return inpDiasLabProy;
    }

    public void setColumn4(CoreColumn column4) {
        this.column4 = column4;
    }

    public CoreColumn getColumn4() {
        return column4;
    }

    public void setOutputText1(CoreOutputText outputText1) {
        this.outputText1 = outputText1;
    }

    public CoreOutputText getOutputText1() {
        return outputText1;
    }


    public void setInpTotDevProy(CoreInputText inputText201) {
        this.inpTotDevProy = inputText201;
    }

    public CoreInputText getInpTotDevProy() {
        return inpTotDevProy;
    }

    public void setBtnGenDetPlanilla(CoreCommandButton commandButton3) {
        this.btnGenDetPlanilla = commandButton3;
    }

    public CoreCommandButton getBtnGenDetPlanilla() {
        return btnGenDetPlanilla;
    }

    public void setCommandButton3(CoreCommandButton commandButton3) {
        this.commandButton3 = commandButton3;
    }

    public CoreCommandButton getCommandButton3() {
        return commandButton3;
    }


    public void setColumn61(CoreColumn column61) {
        this.column61 = column61;
    }

    public CoreColumn getColumn61() {
        return column61;
    }

    public void setInpTotDevProy1(CoreInputText inpTotDevProy1) {
        this.inpTotDevProy1 = inpTotDevProy1;
    }

    public CoreInputText getInpTotDevProy1() {
        return inpTotDevProy1;
    }


    public void setColumn14(CoreColumn column14) {
        this.column14 = column14;
    }

    public CoreColumn getColumn14() {
        return column14;
    }

    public void setInpBonificacionProy(CoreInputText inputText4) {
        this.inpBonificacionProy = inputText4;
    }

    public CoreInputText getInpBonificacionProy() {
        return inpBonificacionProy;
    }

    public void setShowTE(CoreShowDetailItem showDetailItem1) {
        this.showTE = showDetailItem1;
    }

    public CoreShowDetailItem getShowTE() {
        return showTE;
    }

    public void setPanelHeader4(CorePanelHeader panelHeader4) {
        this.panelHeader4 = panelHeader4;
    }

    public CorePanelHeader getPanelHeader4() {
        return panelHeader4;
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


    public void setTable1(CoreTable table1) {
        this.table1 = table1;
    }

    public CoreTable getTable1() {
        return table1;
    }

    public void setColumn15(CoreColumn column15) {
        this.column15 = column15;
    }

    public CoreColumn getColumn15() {
        return column15;
    }

    public void setOutputText5(CoreOutputText outputText5) {
        this.outputText5 = outputText5;
    }

    public CoreOutputText getOutputText5() {
        return outputText5;
    }

    public void setColumn18(CoreColumn column18) {
        this.column18 = column18;
    }

    public CoreColumn getColumn18() {
        return column18;
    }

    public void setOutputText7(CoreOutputText outputText7) {
        this.outputText7 = outputText7;
    }

    public CoreOutputText getOutputText7() {
        return outputText7;
    }

    public void setColumn24(CoreColumn column24) {
        this.column24 = column24;
    }

    public CoreColumn getColumn24() {
        return column24;
    }

    public void setOutputText10(CoreOutputText outputText10) {
        this.outputText10 = outputText10;
    }

    public CoreOutputText getOutputText10() {
        return outputText10;
    }

    public void setColumn29(CoreColumn column29) {
        this.column29 = column29;
    }

    public CoreColumn getColumn29() {
        return column29;
    }

    public void setOutputText16(CoreOutputText outputText16) {
        this.outputText16 = outputText16;
    }

    public CoreOutputText getOutputText16() {
        return outputText16;
    }

    public void setColumn30(CoreColumn column30) {
        this.column30 = column30;
    }

    public CoreColumn getColumn30() {
        return column30;
    }

    public void setOutputText21(CoreOutputText outputText21) {
        this.outputText21 = outputText21;
    }

    public CoreOutputText getOutputText21() {
        return outputText21;
    }

    public void setColumn31(CoreColumn column31) {
        this.column31 = column31;
    }

    public CoreColumn getColumn31() {
        return column31;
    }

    public void setOutputText22(CoreOutputText outputText22) {
        this.outputText22 = outputText22;
    }

    public CoreOutputText getOutputText22() {
        return outputText22;
    }

    public void setColumn32(CoreColumn column32) {
        this.column32 = column32;
    }

    public CoreColumn getColumn32() {
        return column32;
    }

    public void setOutputText23(CoreOutputText outputText23) {
        this.outputText23 = outputText23;
    }

    public CoreOutputText getOutputText23() {
        return outputText23;
    }

    public void setColumn33(CoreColumn column33) {
        this.column33 = column33;
    }

    public CoreColumn getColumn33() {
        return column33;
    }

    public void setOutputText24(CoreOutputText outputText24) {
        this.outputText24 = outputText24;
    }

    public CoreOutputText getOutputText24() {
        return outputText24;
    }

    public void setColumn34(CoreColumn column34) {
        this.column34 = column34;
    }

    public CoreColumn getColumn34() {
        return column34;
    }

    public void setOutputText25(CoreOutputText outputText25) {
        this.outputText25 = outputText25;
    }

    public CoreOutputText getOutputText25() {
        return outputText25;
    }

    public void setColumn35(CoreColumn column35) {
        this.column35 = column35;
    }

    public CoreColumn getColumn35() {
        return column35;
    }

    public void setOutputText26(CoreOutputText outputText26) {
        this.outputText26 = outputText26;
    }

    public CoreOutputText getOutputText26() {
        return outputText26;
    }

    public void setColumn36(CoreColumn column36) {
        this.column36 = column36;
    }

    public CoreColumn getColumn36() {
        return column36;
    }

    public void setOutputText27(CoreOutputText outputText27) {
        this.outputText27 = outputText27;
    }

    public CoreOutputText getOutputText27() {
        return outputText27;
    }


    public void setTable3(CoreTable table3) {
        this.table3 = table3;
    }

    public CoreTable getTable3() {
        return table3;
    }

    public void setColumn38(CoreColumn column38) {
        this.column38 = column38;
    }

    public CoreColumn getColumn38() {
        return column38;
    }

    public void setOutputText29(CoreOutputText outputText29) {
        this.outputText29 = outputText29;
    }

    public CoreOutputText getOutputText29() {
        return outputText29;
    }

    public void setColumn39(CoreColumn column39) {
        this.column39 = column39;
    }

    public CoreColumn getColumn39() {
        return column39;
    }

    public void setOutputText30(CoreOutputText outputText30) {
        this.outputText30 = outputText30;
    }

    public CoreOutputText getOutputText30() {
        return outputText30;
    }

    public void setColumn40(CoreColumn column40) {
        this.column40 = column40;
    }

    public CoreColumn getColumn40() {
        return column40;
    }

    public void setOutputText31(CoreOutputText outputText31) {
        this.outputText31 = outputText31;
    }

    public CoreOutputText getOutputText31() {
        return outputText31;
    }

    public void setColumn41(CoreColumn column41) {
        this.column41 = column41;
    }

    public CoreColumn getColumn41() {
        return column41;
    }

    public void setOutputText32(CoreOutputText outputText32) {
        this.outputText32 = outputText32;
    }

    public CoreOutputText getOutputText32() {
        return outputText32;
    }

    public void setColumn42(CoreColumn column42) {
        this.column42 = column42;
    }

    public CoreColumn getColumn42() {
        return column42;
    }

    public void setOutputText33(CoreOutputText outputText33) {
        this.outputText33 = outputText33;
    }

    public CoreOutputText getOutputText33() {
        return outputText33;
    }

    public void setColumn43(CoreColumn column43) {
        this.column43 = column43;
    }

    public CoreColumn getColumn43() {
        return column43;
    }

    public void setOutputText34(CoreOutputText outputText34) {
        this.outputText34 = outputText34;
    }

    public CoreOutputText getOutputText34() {
        return outputText34;
    }


    public void setColumn37(CoreColumn column37) {
        this.column37 = column37;
    }

    public CoreColumn getColumn37() {
        return column37;
    }


    public void setOutputText161(CoreSelectBooleanCheckbox outputText161) {
        this.outputText161 = outputText161;
    }

    public CoreSelectBooleanCheckbox getOutputText161() {
        return outputText161;
    }


    public void setColumn44(CoreColumn column44) {
        this.column44 = column44;
    }

    public CoreColumn getColumn44() {
        return column44;
    }


    public void setOutputText1611(CoreSelectBooleanCheckbox outputText1611) {
        this.outputText1611 = outputText1611;
    }

    public CoreSelectBooleanCheckbox getOutputText1611() {
        return outputText1611;
    }

    public void setBtnAgretarTE(CoreCommandButton commandButton6) {
        this.btnAgretarTE = commandButton6;
    }

    public CoreCommandButton getBtnAgretarTE() {
        return btnAgretarTE;
    }

    public void setBtnQuitarTE(CoreCommandButton commandButton7) {
        this.btnQuitarTE = commandButton7;
    }

    public CoreCommandButton getBtnQuitarTE() {
        return btnQuitarTE;
    }


    public void setPanelGroup2(HtmlPanelGroup panelGroup2) {
        this.panelGroup2 = panelGroup2;
    }

    public HtmlPanelGroup getPanelGroup2() {
        return panelGroup2;
    }

    public void setBtnGenerarTE(CoreCommandButton btnGenerarTE) {
        this.btnGenerarTE = btnGenerarTE;
    }

    public CoreCommandButton getBtnGenerarTE() {
        return btnGenerarTE;
    }

    public void setBtnVaciarTE(CoreCommandButton commandButton4) {
        this.btnVaciarTE = commandButton4;
    }

    public CoreCommandButton getBtnVaciarTE() {
        return btnVaciarTE;
    }


    public void setPanelForm2(CorePanelForm panelForm2) {
        this.panelForm2 = panelForm2;
    }

    public CorePanelForm getPanelForm2() {
        return panelForm2;
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


    public void setInputText22(CoreInputText inputText22) {
        this.inputText22 = inputText22;
    }

    public CoreInputText getInputText22() {
        return inputText22;
    }


    public void setBtnBuscar(CoreCommandButton btnBuscar) {
        this.btnBuscar = btnBuscar;
    }

    public CoreCommandButton getBtnBuscar() {
        return btnBuscar;
    }

    public void setCmbDependencia2(CoreSelectOneChoice selectOneChoice1) {
        this.cmbDependencia2 = selectOneChoice1;
    }

    public CoreSelectOneChoice getCmbDependencia2() {
        return cmbDependencia2;
    }

    public void setSelectItems3(UISelectItems selectItems3) {
        this.selectItems3 = selectItems3;
    }

    public UISelectItems getSelectItems3() {
        return selectItems3;
    }


    public void setCmbPartida2(CoreSelectOneChoice selectOneChoice1) {
        this.cmbPartida2 = selectOneChoice1;
    }

    public CoreSelectOneChoice getCmbPartida2() {
        return cmbPartida2;
    }

    public void setSelectItems4(UISelectItems selectItems4) {
        this.selectItems4 = selectItems4;
    }

    public UISelectItems getSelectItems4() {
        return selectItems4;
    }


    public void setInputText21(CoreSelectOneChoice inputText21) {
        this.inputText21 = inputText21;
    }

    public CoreSelectOneChoice getInputText21() {
        return inputText21;
    }

    public void setSelectItem20(CoreSelectItem selectItem20) {
        this.selectItem20 = selectItem20;
    }

    public CoreSelectItem getSelectItem20() {
        return selectItem20;
    }

    public void setSelectItem21(CoreSelectItem selectItem21) {
        this.selectItem21 = selectItem21;
    }

    public CoreSelectItem getSelectItem21() {
        return selectItem21;
    }

    public void setSelectItem22(CoreSelectItem selectItem22) {
        this.selectItem22 = selectItem22;
    }

    public CoreSelectItem getSelectItem22() {
        return selectItem22;
    }

    public void setSelectItem23(CoreSelectItem selectItem23) {
        this.selectItem23 = selectItem23;
    }

    public CoreSelectItem getSelectItem23() {
        return selectItem23;
    }

    public void setSelectItem24(CoreSelectItem selectItem24) {
        this.selectItem24 = selectItem24;
    }

    public CoreSelectItem getSelectItem24() {
        return selectItem24;
    }

    public void setSelectItem25(CoreSelectItem selectItem25) {
        this.selectItem25 = selectItem25;
    }

    public CoreSelectItem getSelectItem25() {
        return selectItem25;
    }

    public void setSelectItem26(CoreSelectItem selectItem26) {
        this.selectItem26 = selectItem26;
    }

    public CoreSelectItem getSelectItem26() {
        return selectItem26;
    }

    public void setSelectItem27(CoreSelectItem selectItem27) {
        this.selectItem27 = selectItem27;
    }

    public CoreSelectItem getSelectItem27() {
        return selectItem27;
    }

    public void setSelectItem28(CoreSelectItem selectItem28) {
        this.selectItem28 = selectItem28;
    }

    public CoreSelectItem getSelectItem28() {
        return selectItem28;
    }

    public void setSelectItem29(CoreSelectItem selectItem29) {
        this.selectItem29 = selectItem29;
    }

    public CoreSelectItem getSelectItem29() {
        return selectItem29;
    }

    public void setSelectItem30(CoreSelectItem selectItem30) {
        this.selectItem30 = selectItem30;
    }

    public CoreSelectItem getSelectItem30() {
        return selectItem30;
    }

    public void setSelectItem31(CoreSelectItem selectItem31) {
        this.selectItem31 = selectItem31;
    }

    public CoreSelectItem getSelectItem31() {
        return selectItem31;
    }

    public void setSelectItem32(CoreSelectItem selectItem32) {
        this.selectItem32 = selectItem32;
    }

    public CoreSelectItem getSelectItem32() {
        return selectItem32;
    }

    public void setColumn45(CoreColumn column45) {
        this.column45 = column45;
    }

    public CoreColumn getColumn45() {
        return column45;
    }

    public void setOutputText110(CoreOutputText outputText110) {
        this.outputText110 = outputText110;
    }

    public CoreOutputText getOutputText110() {
        return outputText110;
    }

    public void setInputText4(CoreInputText inputText4) {
        this.inputText4 = inputText4;
    }

    public CoreInputText getInputText4() {
        return inputText4;
    }

    public void setSelectOneChoice1(CoreSelectOneChoice selectOneChoice1) {
        this.selectOneChoice1 = selectOneChoice1;
    }

    public CoreSelectOneChoice getSelectOneChoice1() {
        return selectOneChoice1;
    }

    public void setSelectItems5(UISelectItems selectItems5) {
        this.selectItems5 = selectItems5;
    }

    public UISelectItems getSelectItems5() {
        return selectItems5;
    }

    public void setCmbTipoNomina(CoreSelectOneChoice inputText81) {
        this.cmbTipoNomina = inputText81;
    }

    public CoreSelectOneChoice getCmbTipoNomina() {
        return cmbTipoNomina;
    }

    public void setSelectItem14(CoreSelectItem selectItem14) {
        this.selectItem14 = selectItem14;
    }

    public CoreSelectItem getSelectItem14() {
        return selectItem14;
    }

    public void setSelectItem17(CoreSelectItem selectItem17) {
        this.selectItem17 = selectItem17;
    }

    public CoreSelectItem getSelectItem17() {
        return selectItem17;
    }

    public void setSelectItem15(CoreSelectItem selectItem15) {
        this.selectItem15 = selectItem15;
    }

    public CoreSelectItem getSelectItem15() {
        return selectItem15;
    }

    public void setSelectItem19(CoreSelectItem selectItem19) {
        this.selectItem19 = selectItem19;
    }

    public CoreSelectItem getSelectItem19() {
        return selectItem19;
    }

    public void setSelectItem16(CoreSelectItem selectItem16) {
        this.selectItem16 = selectItem16;
    }

    public CoreSelectItem getSelectItem16() {
        return selectItem16;
    }

    public void setSelectItem18(CoreSelectItem selectItem18) {
        this.selectItem18 = selectItem18;
    }

    public CoreSelectItem getSelectItem18() {
        return selectItem18;
    }
}
