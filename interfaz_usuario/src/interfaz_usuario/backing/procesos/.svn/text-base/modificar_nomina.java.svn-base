package interfaz_usuario.backing.procesos;

import enlace_datos.util.resulOp;

import interfaz_usuario.util.JSFUtils;

import interfaz_usuario.util.utils;

import javax.faces.application.FacesMessage;
import javax.faces.component.UINamingContainer;
import javax.faces.component.UISelectItems;

import javax.faces.context.FacesContext;

import oracle.adf.view.faces.component.core.CoreForm;
import oracle.adf.view.faces.component.core.data.CoreColumn;
import oracle.adf.view.faces.component.core.data.CoreTable;
import oracle.adf.view.faces.component.core.data.CoreTableSelectOne;
import oracle.adf.view.faces.component.core.input.CoreInputHidden;
import oracle.adf.view.faces.component.core.input.CoreInputText;
import oracle.adf.view.faces.component.core.input.CoreSelectBooleanRadio;
import oracle.adf.view.faces.component.core.input.CoreSelectOneChoice;
import oracle.adf.view.faces.component.core.layout.CorePanelBox;
import oracle.adf.view.faces.component.core.layout.CorePanelButtonBar;
import oracle.adf.view.faces.component.core.layout.CorePanelForm;
import oracle.adf.view.faces.component.core.layout.CorePanelHeader;
import oracle.adf.view.faces.component.core.layout.CorePanelHorizontal;
import oracle.adf.view.faces.component.core.layout.CoreShowDetailItem;
import oracle.adf.view.faces.component.core.nav.CoreCommandButton;
import oracle.adf.view.faces.component.core.nav.CoreCommandLink;
import oracle.adf.view.faces.component.core.nav.CoreCommandMenuItem;
import oracle.adf.view.faces.component.core.nav.CorePage;
import oracle.adf.view.faces.component.core.output.CoreMessages;
import oracle.adf.view.faces.component.core.output.CoreObjectImage;
import oracle.adf.view.faces.component.core.output.CoreObjectSpacer;
import oracle.adf.view.faces.component.core.output.CoreOutputText;
import oracle.adf.view.faces.component.html.HtmlBody;
import oracle.adf.view.faces.component.html.HtmlHead;
import oracle.adf.view.faces.component.html.HtmlHtml;

import oracle.adf.view.faces.event.RangeChangeEvent;

import oracle.jbo.Row;
import oracle.jbo.uicli.binding.JUIteratorBinding;

public class modificar_nomina {
    private CoreOutputText outputText1;
    private UINamingContainer logo;
    private UINamingContainer menuSwt;
    private UINamingContainer info1;
    private CoreCommandMenuItem commandMenuItem1;
    private CorePage page1;
    private CoreMessages messages1;
    private CorePanelHeader panelHeader1;
    private CorePanelHeader panelHeader2;
    private CoreInputText inputText1;
    private CoreInputText inputText2;
    private CoreColumn column1;
    private CoreInputText inputText4;
    private CoreColumn column2;
    private CoreInputText inputText5;
    private CoreColumn column4;
    private CoreInputText inputText7;
    private CoreColumn column5;
    private CoreInputText inpSueldoBase;
    private CoreColumn column6;
    private CoreInputText inputText9;
    private CoreColumn column7;
    private CoreInputText inputText10;
    private CoreColumn column8;
    private CoreInputText inpNominal;
    private CoreColumn column9;
    private CoreInputText inputText12;
    private CoreColumn column10;
    private CoreColumn column11;
    private CoreInputText inputText14;
    private CoreColumn column12;
    private CoreInputText inpLiquido;
    private CoreColumn column13;
    private CoreInputText inputText16;
    private CoreColumn column14;
    private CoreInputText inputText17;
    private CoreColumn column15;
    private CoreInputText inputText18;
    private CoreTableSelectOne tableSelectOne1;
    private CoreSelectOneChoice selectOneChoice1;
    private UISelectItems selectItems1;
    private CoreSelectOneChoice navList1;
    private UISelectItems selectItems2;
    private CoreColumn column16;
    private CoreOutputText outputText2;
    private CoreColumn column18;
    private CoreOutputText outputText4;
    private CoreColumn column3;
    private CoreInputText inputText6;
    private CoreColumn column17;
    private CoreOutputText outputText3;
    private CoreObjectSpacer objectSpacer1;
    private CoreTable table2;
    private CoreColumn column20;
    private CoreColumn column25;
    private CoreOutputText outputText11;
    private CoreColumn column29;
    private CoreOutputText outputText15;
    private CoreColumn column21;
    private CoreObjectImage objectImage1;
    private CoreColumn column19;
    private CoreObjectImage objectImage2;
    private CoreOutputText outputText5;
    private CoreOutputText outputText7;
    private CoreColumn column22;
    private CoreOutputText outputText8;
    private CoreInputText outputText6;
    private CorePanelButtonBar panelButtonBar1;
    private CoreObjectImage objectImage3;
    private CorePanelBox panelBox11;
    private CorePanelHeader panelHeader11;
    private CorePanelForm panelForm11;
    private CoreObjectSpacer objectSpacer11;
    private CorePanelHorizontal panelHorizontal1;
    private CoreInputText inputText311;
    private CoreCommandButton commandButton3;
    private CoreObjectSpacer objectSpacer2;
    private CoreTable table3;
    private CoreColumn column23;
    private CoreColumn column24;
    private CoreOutputText outputText9;
    private CoreColumn column26;
    private CoreOutputText outputText10;
    private CoreColumn column27;
    private CoreOutputText outputText12;
    private CoreColumn column28;
    private CoreOutputText outputText13;
    private CoreColumn column30;
    private CoreOutputText outputText14;
    private CoreColumn column31;
    private CoreOutputText outputText16;
    private CoreColumn column32;
    private CoreOutputText outputText17;
    private CoreColumn column33;
    private CoreOutputText outputText18;
    private CoreColumn column34;
    private CoreOutputText outputText19;
    private CoreColumn column35;
    private CoreOutputText outputText20;
    private CoreColumn column36;
    private CoreOutputText outputText21;
    private CoreColumn column37;
    private CoreOutputText outputText22;
    private CoreSelectBooleanRadio selectBooleanRadio1;
    private CoreOutputText outputText23;
    private CorePanelHeader panelHeader111;
    private CorePanelHorizontal panelHorizontal2;
    private CoreTable table4;
    private CoreColumn column38;
    private CoreColumn column39;
    private CoreOutputText outputText25;
    private CoreColumn column40;
    private CoreOutputText outputText26;
    private CoreColumn column41;
    private CoreOutputText outputText27;
    private CoreColumn column42;
    private CoreOutputText outputText28;
    private CoreColumn column43;
    private CoreOutputText outputText29;
    private CoreColumn column44;
    private CoreOutputText outputText30;
    private CoreColumn column45;
    private CoreOutputText outputText31;
    private CoreColumn column46;
    private CoreOutputText outputText32;
    private CoreColumn column47;
    private CoreOutputText outputText33;
    private CoreColumn column48;
    private CoreOutputText outputText34;
    private CoreColumn column49;
    private CoreOutputText outputText35;
    private CoreSelectBooleanRadio selectBooleanRadio2;
    private CorePanelBox panelBox2;
    private CorePanelHorizontal panelHorizontal4;
    private CoreInputText txtBonoMensual;
    private CoreInputText txtObserva;
    private CoreCommandButton btnAgregarNomina;
    private CorePanelHorizontal panelHorizontal3;
    private CoreSelectOneChoice cbProceso;
    private UISelectItems selectItems4;
    private CoreInputText txtSueldoBase;
    private CoreInputText txtComplSal;
    private CoreInputText txtEscalafon;
    private CoreInputText txtDiasLab;
    private CoreTable table5;
    private CoreColumn column50;
    private CoreOutputText outputText24;
    private CoreColumn column51;
    private CoreOutputText outputText36;
    private CoreColumn column52;
    private CoreOutputText outputText37;
    private CoreColumn column53;
    private CoreOutputText outputText38;
    private CoreColumn column54;
    private CoreOutputText outputText39;
    private CoreColumn column55;
    private CoreOutputText outputText40;
    private CoreColumn column56;
    private CoreOutputText outputText41;
    private CoreColumn column57;
    private CoreOutputText outputText42;
    private CoreColumn column58;
    private CoreOutputText outputText43;
    private CoreColumn column59;
    private CoreOutputText outputText44;
    private CoreColumn column60;
    private CoreOutputText outputText45;
    private CoreColumn column61;
    private CoreOutputText outputText46;
    private CoreColumn column62;
    private CoreOutputText outputText47;
    private CoreInputHidden valNomina;
    private CoreInputText inputText8;
    private CoreInputText inputText11;
    private CoreColumn column63;
    private CoreOutputText outputText48;
    private CoreColumn column64;
    private CoreOutputText outputText49;
    private CoreForm form1;
    private HtmlHtml html1;
    private HtmlHead head1;
    private HtmlBody body1;
    private CoreShowDetailItem showDetailModificarNom;
    private CoreShowDetailItem showDetailAgregarNom;
    private CorePanelForm pnlFormModicarNom;
    private CorePanelForm pnlFormOpcionesBusq;
    private CoreTable tbl_listadoNominasModificar;
    private CoreCommandButton btnCancelarPrincipal;
    private CoreInputText inptTxtRegistroEmpl;
    private CoreCommandButton btnFiltrar;
    private CoreCommandLink cmdLinkEditarFila;
    private CoreCommandLink cmdLinkImprimir;

    public modificar_nomina() {
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

    public void setMessages1(CoreMessages messages1) {
        this.messages1 = messages1;
    }

    public CoreMessages getMessages1() {
        return messages1;
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

    public void setColumn1(CoreColumn column1) {
        this.column1 = column1;
    }

    public CoreColumn getColumn1() {
        return column1;
    }

    public void setInputText4(CoreInputText inputText4) {
        this.inputText4 = inputText4;
    }

    public CoreInputText getInputText4() {
        return inputText4;
    }

    public void setColumn2(CoreColumn column2) {
        this.column2 = column2;
    }

    public CoreColumn getColumn2() {
        return column2;
    }

    public void setInputText5(CoreInputText inputText5) {
        this.inputText5 = inputText5;
    }

    public CoreInputText getInputText5() {
        return inputText5;
    }


    public void setColumn4(CoreColumn column4) {
        this.column4 = column4;
    }

    public CoreColumn getColumn4() {
        return column4;
    }

    public void setInputText7(CoreInputText inputText7) {
        this.inputText7 = inputText7;
    }

    public CoreInputText getInputText7() {
        return inputText7;
    }

    public void setColumn5(CoreColumn column5) {
        this.column5 = column5;
    }

    public CoreColumn getColumn5() {
        return column5;
    }

    public void setInpSueldoBase(CoreInputText inputText8) {
        this.inpSueldoBase = inputText8;
    }

    public CoreInputText getInpSueldoBase() {
        return inpSueldoBase;
    }

    public void setColumn6(CoreColumn column6) {
        this.column6 = column6;
    }

    public CoreColumn getColumn6() {
        return column6;
    }

    public void setInputText9(CoreInputText inputText9) {
        this.inputText9 = inputText9;
    }

    public CoreInputText getInputText9() {
        return inputText9;
    }

    public void setColumn7(CoreColumn column7) {
        this.column7 = column7;
    }

    public CoreColumn getColumn7() {
        return column7;
    }

    public void setInputText10(CoreInputText inputText10) {
        this.inputText10 = inputText10;
    }

    public CoreInputText getInputText10() {
        return inputText10;
    }

    public void setColumn8(CoreColumn column8) {
        this.column8 = column8;
    }

    public CoreColumn getColumn8() {
        return column8;
    }

    public void setInpNominal(CoreInputText inputText11) {
        this.inpNominal = inputText11;
    }

    public CoreInputText getInpNominal() {
        return inpNominal;
    }

    public void setColumn9(CoreColumn column9) {
        this.column9 = column9;
    }

    public CoreColumn getColumn9() {
        return column9;
    }

    public void setInputText12(CoreInputText inputText12) {
        this.inputText12 = inputText12;
    }

    public CoreInputText getInputText12() {
        return inputText12;
    }

    public void setColumn10(CoreColumn column10) {
        this.column10 = column10;
    }

    public CoreColumn getColumn10() {
        return column10;
    }


    public void setColumn11(CoreColumn column11) {
        this.column11 = column11;
    }

    public CoreColumn getColumn11() {
        return column11;
    }

    public void setInputText14(CoreInputText inputText14) {
        this.inputText14 = inputText14;
    }

    public CoreInputText getInputText14() {
        return inputText14;
    }

    public void setColumn12(CoreColumn column12) {
        this.column12 = column12;
    }

    public CoreColumn getColumn12() {
        return column12;
    }

    public void setInpLiquido(CoreInputText inputText15) {
        this.inpLiquido = inputText15;
    }

    public CoreInputText getInpLiquido() {
        return inpLiquido;
    }

    public void setColumn13(CoreColumn column13) {
        this.column13 = column13;
    }

    public CoreColumn getColumn13() {
        return column13;
    }

    public void setInputText16(CoreInputText inputText16) {
        this.inputText16 = inputText16;
    }

    public CoreInputText getInputText16() {
        return inputText16;
    }

    public void setColumn14(CoreColumn column14) {
        this.column14 = column14;
    }

    public CoreColumn getColumn14() {
        return column14;
    }

    public void setInputText17(CoreInputText inputText17) {
        this.inputText17 = inputText17;
    }

    public CoreInputText getInputText17() {
        return inputText17;
    }

    public void setColumn15(CoreColumn column15) {
        this.column15 = column15;
    }

    public CoreColumn getColumn15() {
        return column15;
    }

    public void setInputText18(CoreInputText inputText18) {
        this.inputText18 = inputText18;
    }

    public CoreInputText getInputText18() {
        return inputText18;
    }

    public void setTableSelectOne1(CoreTableSelectOne tableSelectOne1) {
        this.tableSelectOne1 = tableSelectOne1;
    }

    public CoreTableSelectOne getTableSelectOne1() {
        return tableSelectOne1;
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
    /* ************************************************************************/
    /* ************************************************************************/
    /* ************************************************************************/

    public String btn_buscar() {
        // Add event code here..

        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(), 
                                      "Empleado")) {

            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                     "paramPlazas");
            this.panelBox2.setRendered(true);
        }
        return null;
    }

    public String btn_agregarNomina() {
        Object vViewObject, vSel;
        Object vIdcontrato = null;
        String vSueldoBase, vCompSal, vEscalafon, vDiasLab, vBonoMensual, vObserva;
        JUIteratorBinding vIterador2;
        Row[] vFilas;
        int vNumeroFilas;
        vViewObject = 
                JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                           "#{bindings.SisPlazasEmpleadoComplVwIterator}");
        if (vViewObject != null) {
            vIterador2 = (JUIteratorBinding)vViewObject;
            vFilas = vIterador2.getAllRowsInRange();
            vNumeroFilas = vFilas.length;


            for (int i = 0; i < vNumeroFilas; i++) {

                vSel = vFilas[i].getAttribute("Seleccionado");

                if (vSel.toString().equals("true")) {

                    if (this.txtSueldoBase.getValue() != null && 
                        !this.txtSueldoBase.getValue().toString().trim().equals("")) {
                        vSueldoBase = this.txtSueldoBase.getValue().toString();

                        if (this.txtComplSal.getValue() != null && 
                            !this.txtComplSal.getValue().toString().trim().equals("")) {
                            vCompSal = this.txtComplSal.getValue().toString();
                        } else {
                            vCompSal = "0";
                        }

                        if (this.txtEscalafon.getValue() != null && 
                            !this.txtEscalafon.getValue().toString().trim().equals("")) {
                            vEscalafon = 
                                    this.txtEscalafon.getValue().toString();
                        } else {
                            vEscalafon = "0";
                        }

                        if (this.txtDiasLab.getValue() != null && 
                            !this.txtDiasLab.getValue().toString().trim().equals("")) {
                            vDiasLab = this.txtDiasLab.getValue().toString();
                        } else {
                            vDiasLab = null;
                        }

                        if (this.txtBonoMensual.getValue() != null && 
                            !this.txtBonoMensual.getValue().toString().trim().equals("")) {
                            vBonoMensual = 
                                    this.txtBonoMensual.getValue().toString();
                        } else {
                            vBonoMensual = "0";
                        }

                        if (this.txtObserva.getValue() != null && 
                            !this.txtObserva.getValue().toString().trim().equals("")) {
                            vObserva = this.txtObserva.getValue().toString();
                        } else {
                            vObserva = null;
                        }

                        vIdcontrato = vFilas[i].getAttribute("IdContrato");

                        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                                    "#{bindings.IdContrato.inputValue}", 
                                                    vIdcontrato);
                        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                                    "#{bindings.SueldoBase.inputValue}", 
                                                    vSueldoBase);
                        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                                    "#{bindings.CompSal.inputValue}", 
                                                    vCompSal);
                        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                                    "#{bindings.Escalafon.inputValue}", 
                                                    vEscalafon);
                        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                                    "#{bindings.DiasLab.inputValue}", 
                                                    vDiasLab);
                        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                                    "#{bindings.BonoMensual.inputValue}", 
                                                    vBonoMensual);
                        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                                    "#{bindings.Observa.inputValue}", 
                                                    vObserva);
                        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                                 "agregarNomina");
                        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                                 "EjecutarListadoAgregarNomina");
                        this.panelBox2.setRendered(false);
                        utils.setADFMensaje(new resulOp(resulOp.OPE_OK, 
                                                        "Datos guardados exitosamente"));
                        this.txtBonoMensual.setValue("");
                        this.txtComplSal.setValue("");
                        this.txtDiasLab.setValue("");
                        this.txtEscalafon.setValue("");
                        this.txtObserva.setValue("");
                        this.txtSueldoBase.setValue("");
                    } else {
                        utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR, 
                                                        "Debe ingresar sueldo base"));
                    }
                }
            }
        }


        return null;
    }

    /*public String btnEditarNomina_action() {
        // Add event code here...
        this.getInpSueldoBase().setReadOnly(false);
        HabilitarNomina();
        return null;
    }*/

    //Botón Cancelar Principal
    /*public String btnCancelar_action() {
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                 "cambiarEstadoTodos");
        this.getBtnGrabar().setDisabled(true);
        this.getBtnFiltrar().setDisabled(false);
        return null;
    }*/

    /*public String btnGrabar_action() {
        String mensaje = "Información grabada exitósamente!!";
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(), 
                                      "Commit")) {
            if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(), 
                                          "recalcularDescuentos")) {
                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                         "Commit"); //Para que guardes el recálculo
                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                         "EjecutarListadoEditarNominas");
                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                         "cambiarEstadoTodos"); //Contrae todas las filas
                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                         "FilaActualNom"); //Resalta la fila editada
                this.getBtnGrabar().setDisabled(true);
                this.getBtnFiltrar().setDisabled(false);
                mensaje(mensaje, 1); // 1 = tipo INFO
            }
        }
        // DeshabilitarNomina();        
        return null;
    }*/

    /*private void HabilitarNomina() {
        this.getInpSueldoBase().setReadOnly(false);
        this.btnGrabar.setDisabled(false);
        //this.btnEditarNomina.setDisabled(true);
        this.btnCancelar.setDisabled(false);
    }*/

    /*private void DeshabilitarNomina(){
        this.getInpSueldoBase().setReadOnly(true);
        this.btnGrabar.setDisabled(true);
        this.btnEditarNomina.setDisabled(false);
        this.btnCancelar.setDisabled(true);
    }*/
    /* ************************************************************************/
    /* ************************************************************************/
    /* ************************************************************************/


    public void setNavList1(CoreSelectOneChoice navList1) {
        this.navList1 = navList1;
    }

    public CoreSelectOneChoice getNavList1() {
        return navList1;
    }

    public void setSelectItems2(UISelectItems selectItems2) {
        this.selectItems2 = selectItems2;
    }

    public UISelectItems getSelectItems2() {
        return selectItems2;
    }


    public void setColumn16(CoreColumn column16) {
        this.column16 = column16;
    }

    public CoreColumn getColumn16() {
        return column16;
    }

    public void setOutputText2(CoreOutputText outputText2) {
        this.outputText2 = outputText2;
    }

    public CoreOutputText getOutputText2() {
        return outputText2;
    }


    public void setColumn18(CoreColumn column18) {
        this.column18 = column18;
    }

    public CoreColumn getColumn18() {
        return column18;
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

    public void setInputText6(CoreInputText inputText6) {
        this.inputText6 = inputText6;
    }

    public CoreInputText getInputText6() {
        return inputText6;
    }

    public void setColumn17(CoreColumn column17) {
        this.column17 = column17;
    }

    public CoreColumn getColumn17() {
        return column17;
    }

    public void setOutputText3(CoreOutputText outputText3) {
        this.outputText3 = outputText3;
    }

    public CoreOutputText getOutputText3() {
        return outputText3;
    }

    public void setObjectSpacer1(CoreObjectSpacer objectSpacer1) {
        this.objectSpacer1 = objectSpacer1;
    }

    public CoreObjectSpacer getObjectSpacer1() {
        return objectSpacer1;
    }

    public void setTable2(CoreTable table2) {
        this.table2 = table2;
    }

    public CoreTable getTable2() {
        return table2;
    }


    public void setColumn20(CoreColumn column20) {
        this.column20 = column20;
    }

    public CoreColumn getColumn20() {
        return column20;
    }


    public void setColumn25(CoreColumn column25) {
        this.column25 = column25;
    }

    public CoreColumn getColumn25() {
        return column25;
    }

    public void setOutputText11(CoreOutputText outputText11) {
        this.outputText11 = outputText11;
    }

    public CoreOutputText getOutputText11() {
        return outputText11;
    }


    public void setColumn29(CoreColumn column29) {
        this.column29 = column29;
    }

    public CoreColumn getColumn29() {
        return column29;
    }

    public void setOutputText15(CoreOutputText outputText15) {
        this.outputText15 = outputText15;
    }

    public CoreOutputText getOutputText15() {
        return outputText15;
    }

    public void setColumn21(CoreColumn column21) {
        this.column21 = column21;
    }

    public CoreColumn getColumn21() {
        return column21;
    }
    
    public String btn_editar_fila() {
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                 "FilaActualNom");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                 "cambiarEstadoTodos"); //Cierra todas las files
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                 "cambiarEstadoActual"); //Expande la fila seleccionada
        this.getCmdLinkEditarFila().setDisabled(true);
        this.getBtnFiltrar().setDisabled(true);
        return null;
    }

    public void setObjectImage1(CoreObjectImage objectImage1) {
        this.objectImage1 = objectImage1;
    }

    public CoreObjectImage getObjectImage1() {
        return objectImage1;
    }

    public void setColumn19(CoreColumn column19) {
        this.column19 = column19;
    }

    public CoreColumn getColumn19() {
        return column19;
    }

    public void setObjectImage2(CoreObjectImage objectImage2) {
        this.objectImage2 = objectImage2;
    }

    public CoreObjectImage getObjectImage2() {
        return objectImage2;
    }

    public String btn_eliminarDesc() {

        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                 "FilaActualDesc");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                 "SuprimirDesc");
        return null;
    }

    public void setOutputText5(CoreOutputText outputText5) {
        this.outputText5 = outputText5;
    }

    public CoreOutputText getOutputText5() {
        return outputText5;
    }

    public void setOutputText7(CoreOutputText outputText7) {
        this.outputText7 = outputText7;
    }

    public CoreOutputText getOutputText7() {
        return outputText7;
    }

    public void setColumn22(CoreColumn column22) {
        this.column22 = column22;
    }

    public CoreColumn getColumn22() {
        return column22;
    }

    public void setOutputText8(CoreOutputText outputText8) {
        this.outputText8 = outputText8;
    }

    public CoreOutputText getOutputText8() {
        return outputText8;
    }

    public void setOutputText6(CoreInputText outputText6) {
        this.outputText6 = outputText6;
    }

    public CoreInputText getOutputText6() {
        return outputText6;
    }

    public void setPanelButtonBar1(CorePanelButtonBar panelButtonBar1) {
        this.panelButtonBar1 = panelButtonBar1;
    }

    public CorePanelButtonBar getPanelButtonBar1() {
        return panelButtonBar1;
    }

    public void setObjectImage3(CoreObjectImage objectImage3) {
        this.objectImage3 = objectImage3;
    }

    public CoreObjectImage getObjectImage3() {
        return objectImage3;
    }

    public void setPanelBox11(CorePanelBox panelBox11) {
        this.panelBox11 = panelBox11;
    }

    public CorePanelBox getPanelBox11() {
        return panelBox11;
    }

    public void setPanelHeader11(CorePanelHeader panelHeader11) {
        this.panelHeader11 = panelHeader11;
    }

    public CorePanelHeader getPanelHeader11() {
        return panelHeader11;
    }

    public void setPanelForm11(CorePanelForm panelForm11) {
        this.panelForm11 = panelForm11;
    }

    public CorePanelForm getPanelForm11() {
        return panelForm11;
    }


    public void setObjectSpacer11(CoreObjectSpacer objectSpacer11) {
        this.objectSpacer11 = objectSpacer11;
    }

    public CoreObjectSpacer getObjectSpacer11() {
        return objectSpacer11;
    }


    public void setPanelHorizontal1(CorePanelHorizontal panelHorizontal1) {
        this.panelHorizontal1 = panelHorizontal1;
    }

    public CorePanelHorizontal getPanelHorizontal1() {
        return panelHorizontal1;
    }

    public void setInputText311(CoreInputText inputText311) {
        this.inputText311 = inputText311;
    }

    public CoreInputText getInputText311() {
        return inputText311;
    }

    public void setCommandButton3(CoreCommandButton commandButton3) {
        this.commandButton3 = commandButton3;
    }

    public CoreCommandButton getCommandButton3() {
        return commandButton3;
    }

    public void setObjectSpacer2(CoreObjectSpacer objectSpacer2) {
        this.objectSpacer2 = objectSpacer2;
    }

    public CoreObjectSpacer getObjectSpacer2() {
        return objectSpacer2;
    }


    public void setTable3(CoreTable table3) {
        this.table3 = table3;
    }

    public CoreTable getTable3() {
        return table3;
    }

    public void setColumn23(CoreColumn column23) {
        this.column23 = column23;
    }

    public CoreColumn getColumn23() {
        return column23;
    }


    public void setColumn24(CoreColumn column24) {
        this.column24 = column24;
    }

    public CoreColumn getColumn24() {
        return column24;
    }

    public void setOutputText9(CoreOutputText outputText9) {
        this.outputText9 = outputText9;
    }

    public CoreOutputText getOutputText9() {
        return outputText9;
    }

    public void setColumn26(CoreColumn column26) {
        this.column26 = column26;
    }

    public CoreColumn getColumn26() {
        return column26;
    }

    public void setOutputText10(CoreOutputText outputText10) {
        this.outputText10 = outputText10;
    }

    public CoreOutputText getOutputText10() {
        return outputText10;
    }

    public void setColumn27(CoreColumn column27) {
        this.column27 = column27;
    }

    public CoreColumn getColumn27() {
        return column27;
    }

    public void setOutputText12(CoreOutputText outputText12) {
        this.outputText12 = outputText12;
    }

    public CoreOutputText getOutputText12() {
        return outputText12;
    }

    public void setColumn28(CoreColumn column28) {
        this.column28 = column28;
    }

    public CoreColumn getColumn28() {
        return column28;
    }

    public void setOutputText13(CoreOutputText outputText13) {
        this.outputText13 = outputText13;
    }

    public CoreOutputText getOutputText13() {
        return outputText13;
    }

    public void setColumn30(CoreColumn column30) {
        this.column30 = column30;
    }

    public CoreColumn getColumn30() {
        return column30;
    }

    public void setOutputText14(CoreOutputText outputText14) {
        this.outputText14 = outputText14;
    }

    public CoreOutputText getOutputText14() {
        return outputText14;
    }

    public void setColumn31(CoreColumn column31) {
        this.column31 = column31;
    }

    public CoreColumn getColumn31() {
        return column31;
    }

    public void setOutputText16(CoreOutputText outputText16) {
        this.outputText16 = outputText16;
    }

    public CoreOutputText getOutputText16() {
        return outputText16;
    }

    public void setColumn32(CoreColumn column32) {
        this.column32 = column32;
    }

    public CoreColumn getColumn32() {
        return column32;
    }

    public void setOutputText17(CoreOutputText outputText17) {
        this.outputText17 = outputText17;
    }

    public CoreOutputText getOutputText17() {
        return outputText17;
    }

    public void setColumn33(CoreColumn column33) {
        this.column33 = column33;
    }

    public CoreColumn getColumn33() {
        return column33;
    }

    public void setOutputText18(CoreOutputText outputText18) {
        this.outputText18 = outputText18;
    }

    public CoreOutputText getOutputText18() {
        return outputText18;
    }

    public void setColumn34(CoreColumn column34) {
        this.column34 = column34;
    }

    public CoreColumn getColumn34() {
        return column34;
    }

    public void setOutputText19(CoreOutputText outputText19) {
        this.outputText19 = outputText19;
    }

    public CoreOutputText getOutputText19() {
        return outputText19;
    }

    public void setColumn35(CoreColumn column35) {
        this.column35 = column35;
    }

    public CoreColumn getColumn35() {
        return column35;
    }

    public void setOutputText20(CoreOutputText outputText20) {
        this.outputText20 = outputText20;
    }

    public CoreOutputText getOutputText20() {
        return outputText20;
    }

    public void setColumn36(CoreColumn column36) {
        this.column36 = column36;
    }

    public CoreColumn getColumn36() {
        return column36;
    }

    public void setOutputText21(CoreOutputText outputText21) {
        this.outputText21 = outputText21;
    }

    public CoreOutputText getOutputText21() {
        return outputText21;
    }

    public void setColumn37(CoreColumn column37) {
        this.column37 = column37;
    }

    public CoreColumn getColumn37() {
        return column37;
    }

    public void setOutputText22(CoreOutputText outputText22) {
        this.outputText22 = outputText22;
    }

    public CoreOutputText getOutputText22() {
        return outputText22;
    }


    public void setSelectBooleanRadio1(CoreSelectBooleanRadio selectBooleanRadio1) {
        this.selectBooleanRadio1 = selectBooleanRadio1;
    }

    public CoreSelectBooleanRadio getSelectBooleanRadio1() {
        return selectBooleanRadio1;
    }


    public void setOutputText23(CoreOutputText outputText23) {
        this.outputText23 = outputText23;
    }

    public CoreOutputText getOutputText23() {
        return outputText23;
    }


    public void setPanelHeader111(CorePanelHeader panelHeader111) {
        this.panelHeader111 = panelHeader111;
    }

    public CorePanelHeader getPanelHeader111() {
        return panelHeader111;
    }


    public void setPanelHorizontal2(CorePanelHorizontal panelHorizontal2) {
        this.panelHorizontal2 = panelHorizontal2;
    }

    public CorePanelHorizontal getPanelHorizontal2() {
        return panelHorizontal2;
    }


    public void setTable4(CoreTable table4) {
        this.table4 = table4;
    }

    public CoreTable getTable4() {
        return table4;
    }

    public void setColumn38(CoreColumn column38) {
        this.column38 = column38;
    }

    public CoreColumn getColumn38() {
        return column38;
    }


    public void setColumn39(CoreColumn column39) {
        this.column39 = column39;
    }

    public CoreColumn getColumn39() {
        return column39;
    }

    public void setOutputText25(CoreOutputText outputText25) {
        this.outputText25 = outputText25;
    }

    public CoreOutputText getOutputText25() {
        return outputText25;
    }

    public void setColumn40(CoreColumn column40) {
        this.column40 = column40;
    }

    public CoreColumn getColumn40() {
        return column40;
    }

    public void setOutputText26(CoreOutputText outputText26) {
        this.outputText26 = outputText26;
    }

    public CoreOutputText getOutputText26() {
        return outputText26;
    }

    public void setColumn41(CoreColumn column41) {
        this.column41 = column41;
    }

    public CoreColumn getColumn41() {
        return column41;
    }

    public void setOutputText27(CoreOutputText outputText27) {
        this.outputText27 = outputText27;
    }

    public CoreOutputText getOutputText27() {
        return outputText27;
    }

    public void setColumn42(CoreColumn column42) {
        this.column42 = column42;
    }

    public CoreColumn getColumn42() {
        return column42;
    }

    public void setOutputText28(CoreOutputText outputText28) {
        this.outputText28 = outputText28;
    }

    public CoreOutputText getOutputText28() {
        return outputText28;
    }

    public void setColumn43(CoreColumn column43) {
        this.column43 = column43;
    }

    public CoreColumn getColumn43() {
        return column43;
    }

    public void setOutputText29(CoreOutputText outputText29) {
        this.outputText29 = outputText29;
    }

    public CoreOutputText getOutputText29() {
        return outputText29;
    }

    public void setColumn44(CoreColumn column44) {
        this.column44 = column44;
    }

    public CoreColumn getColumn44() {
        return column44;
    }

    public void setOutputText30(CoreOutputText outputText30) {
        this.outputText30 = outputText30;
    }

    public CoreOutputText getOutputText30() {
        return outputText30;
    }

    public void setColumn45(CoreColumn column45) {
        this.column45 = column45;
    }

    public CoreColumn getColumn45() {
        return column45;
    }

    public void setOutputText31(CoreOutputText outputText31) {
        this.outputText31 = outputText31;
    }

    public CoreOutputText getOutputText31() {
        return outputText31;
    }

    public void setColumn46(CoreColumn column46) {
        this.column46 = column46;
    }

    public CoreColumn getColumn46() {
        return column46;
    }

    public void setOutputText32(CoreOutputText outputText32) {
        this.outputText32 = outputText32;
    }

    public CoreOutputText getOutputText32() {
        return outputText32;
    }

    public void setColumn47(CoreColumn column47) {
        this.column47 = column47;
    }

    public CoreColumn getColumn47() {
        return column47;
    }

    public void setOutputText33(CoreOutputText outputText33) {
        this.outputText33 = outputText33;
    }

    public CoreOutputText getOutputText33() {
        return outputText33;
    }

    public void setColumn48(CoreColumn column48) {
        this.column48 = column48;
    }

    public CoreColumn getColumn48() {
        return column48;
    }

    public void setOutputText34(CoreOutputText outputText34) {
        this.outputText34 = outputText34;
    }

    public CoreOutputText getOutputText34() {
        return outputText34;
    }

    public void setColumn49(CoreColumn column49) {
        this.column49 = column49;
    }

    public CoreColumn getColumn49() {
        return column49;
    }

    public void setOutputText35(CoreOutputText outputText35) {
        this.outputText35 = outputText35;
    }

    public CoreOutputText getOutputText35() {
        return outputText35;
    }


    public void setSelectBooleanRadio2(CoreSelectBooleanRadio selectBooleanRadio2) {
        this.selectBooleanRadio2 = selectBooleanRadio2;
    }

    public CoreSelectBooleanRadio getSelectBooleanRadio2() {
        return selectBooleanRadio2;
    }


    public void setPanelBox2(CorePanelBox panelBox2) {
        this.panelBox2 = panelBox2;
    }

    public CorePanelBox getPanelBox2() {
        return panelBox2;
    }

    public void setPanelHorizontal4(CorePanelHorizontal panelHorizontal4) {
        this.panelHorizontal4 = panelHorizontal4;
    }

    public CorePanelHorizontal getPanelHorizontal4() {
        return panelHorizontal4;
    }

    public void setTxtBonoMensual(CoreInputText txtBonoMensual) {
        this.txtBonoMensual = txtBonoMensual;
    }

    public CoreInputText getTxtBonoMensual() {
        return txtBonoMensual;
    }

    public void setTxtObserva(CoreInputText txtObserva) {
        this.txtObserva = txtObserva;
    }

    public CoreInputText getTxtObserva() {
        return txtObserva;
    }

    public void setBtnAgregarNomina(CoreCommandButton btnAgregarNomina) {
        this.btnAgregarNomina = btnAgregarNomina;
    }

    public CoreCommandButton getBtnAgregarNomina() {
        return btnAgregarNomina;
    }

    public void setPanelHorizontal3(CorePanelHorizontal panelHorizontal3) {
        this.panelHorizontal3 = panelHorizontal3;
    }

    public CorePanelHorizontal getPanelHorizontal3() {
        return panelHorizontal3;
    }

    public void setCbProceso(CoreSelectOneChoice selectOneChoice12) {
        this.cbProceso = selectOneChoice12;
    }

    public CoreSelectOneChoice getCbProceso() {
        return cbProceso;
    }

    public void setSelectItems4(UISelectItems selectItems4) {
        this.selectItems4 = selectItems4;
    }

    public UISelectItems getSelectItems4() {
        return selectItems4;
    }

    public void setTxtSueldoBase(CoreInputText txtSueldoBase) {
        this.txtSueldoBase = txtSueldoBase;
    }

    public CoreInputText getTxtSueldoBase() {
        return txtSueldoBase;
    }

    public void setTxtComplSal(CoreInputText txtComplSal) {
        this.txtComplSal = txtComplSal;
    }

    public CoreInputText getTxtComplSal() {
        return txtComplSal;
    }

    public void setTxtEscalafon(CoreInputText txtEscalafon) {
        this.txtEscalafon = txtEscalafon;
    }

    public CoreInputText getTxtEscalafon() {
        return txtEscalafon;
    }

    public void setTxtDiasLab(CoreInputText txtDiasLab) {
        this.txtDiasLab = txtDiasLab;
    }

    public CoreInputText getTxtDiasLab() {
        return txtDiasLab;
    }


    public void setTable5(CoreTable table5) {
        this.table5 = table5;
    }

    public CoreTable getTable5() {
        return table5;
    }

    public void setColumn50(CoreColumn column50) {
        this.column50 = column50;
    }

    public CoreColumn getColumn50() {
        return column50;
    }

    public void setOutputText24(CoreOutputText outputText24) {
        this.outputText24 = outputText24;
    }

    public CoreOutputText getOutputText24() {
        return outputText24;
    }

    public void setColumn51(CoreColumn column51) {
        this.column51 = column51;
    }

    public CoreColumn getColumn51() {
        return column51;
    }

    public void setOutputText36(CoreOutputText outputText36) {
        this.outputText36 = outputText36;
    }

    public CoreOutputText getOutputText36() {
        return outputText36;
    }

    public void setColumn52(CoreColumn column52) {
        this.column52 = column52;
    }

    public CoreColumn getColumn52() {
        return column52;
    }

    public void setOutputText37(CoreOutputText outputText37) {
        this.outputText37 = outputText37;
    }

    public CoreOutputText getOutputText37() {
        return outputText37;
    }

    public void setColumn53(CoreColumn column53) {
        this.column53 = column53;
    }

    public CoreColumn getColumn53() {
        return column53;
    }

    public void setOutputText38(CoreOutputText outputText38) {
        this.outputText38 = outputText38;
    }

    public CoreOutputText getOutputText38() {
        return outputText38;
    }

    public void setColumn54(CoreColumn column54) {
        this.column54 = column54;
    }

    public CoreColumn getColumn54() {
        return column54;
    }

    public void setOutputText39(CoreOutputText outputText39) {
        this.outputText39 = outputText39;
    }

    public CoreOutputText getOutputText39() {
        return outputText39;
    }

    public void setColumn55(CoreColumn column55) {
        this.column55 = column55;
    }

    public CoreColumn getColumn55() {
        return column55;
    }

    public void setOutputText40(CoreOutputText outputText40) {
        this.outputText40 = outputText40;
    }

    public CoreOutputText getOutputText40() {
        return outputText40;
    }

    public void setColumn56(CoreColumn column56) {
        this.column56 = column56;
    }

    public CoreColumn getColumn56() {
        return column56;
    }

    public void setOutputText41(CoreOutputText outputText41) {
        this.outputText41 = outputText41;
    }

    public CoreOutputText getOutputText41() {
        return outputText41;
    }

    public void setColumn57(CoreColumn column57) {
        this.column57 = column57;
    }

    public CoreColumn getColumn57() {
        return column57;
    }

    public void setOutputText42(CoreOutputText outputText42) {
        this.outputText42 = outputText42;
    }

    public CoreOutputText getOutputText42() {
        return outputText42;
    }

    public void setColumn58(CoreColumn column58) {
        this.column58 = column58;
    }

    public CoreColumn getColumn58() {
        return column58;
    }

    public void setOutputText43(CoreOutputText outputText43) {
        this.outputText43 = outputText43;
    }

    public CoreOutputText getOutputText43() {
        return outputText43;
    }

    public void setColumn59(CoreColumn column59) {
        this.column59 = column59;
    }

    public CoreColumn getColumn59() {
        return column59;
    }

    public void setOutputText44(CoreOutputText outputText44) {
        this.outputText44 = outputText44;
    }

    public CoreOutputText getOutputText44() {
        return outputText44;
    }

    public void setColumn60(CoreColumn column60) {
        this.column60 = column60;
    }

    public CoreColumn getColumn60() {
        return column60;
    }

    public void setOutputText45(CoreOutputText outputText45) {
        this.outputText45 = outputText45;
    }

    public CoreOutputText getOutputText45() {
        return outputText45;
    }

    public void setColumn61(CoreColumn column61) {
        this.column61 = column61;
    }

    public CoreColumn getColumn61() {
        return column61;
    }

    public void setOutputText46(CoreOutputText outputText46) {
        this.outputText46 = outputText46;
    }

    public CoreOutputText getOutputText46() {
        return outputText46;
    }

    public void setColumn62(CoreColumn column62) {
        this.column62 = column62;
    }

    public CoreColumn getColumn62() {
        return column62;
    }

    public void setOutputText47(CoreOutputText outputText47) {
        this.outputText47 = outputText47;
    }

    public CoreOutputText getOutputText47() {
        return outputText47;
    }


    public void setValNomina(CoreInputHidden inputHidden1) {
        this.valNomina = inputHidden1;
    }

    public CoreInputHidden getValNomina() {
        return valNomina;
    }

    public void setInputText8(CoreInputText inputText8) {
        this.inputText8 = inputText8;
    }

    public CoreInputText getInputText8() {
        return inputText8;
    }

    public void setInputText11(CoreInputText inputText11) {
        this.inputText11 = inputText11;
    }

    public CoreInputText getInputText11() {
        return inputText11;
    }

    public void setColumn63(CoreColumn column63) {
        this.column63 = column63;
    }

    public CoreColumn getColumn63() {
        return column63;
    }

    public void setOutputText48(CoreOutputText outputText48) {
        this.outputText48 = outputText48;
    }

    public CoreOutputText getOutputText48() {
        return outputText48;
    }

    public void setColumn64(CoreColumn column64) {
        this.column64 = column64;
    }

    public CoreColumn getColumn64() {
        return column64;
    }

    public void setOutputText49(CoreOutputText outputText49) {
        this.outputText49 = outputText49;
    }

    public CoreOutputText getOutputText49() {
        return outputText49;
    }

    //Método que muestra un mensaje en la pantalla. Tipos de Alerta: 1=INFO, 2=ADVERTENCIA y 3=ERROR
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
        context.addMessage(null, fm);
    }

    public void setForm1(CoreForm form1) {
        this.form1 = form1;
    }

    public CoreForm getForm1() {
        return form1;
    }

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

    public void setShowDetailModificarNom(CoreShowDetailItem showDetailModificarNom) {
        this.showDetailModificarNom = showDetailModificarNom;
    }

    public CoreShowDetailItem getShowDetailModificarNom() {
        return showDetailModificarNom;
    }

    public void setShowDetailAgregarNom(CoreShowDetailItem showDetailAgregarNom) {
        this.showDetailAgregarNom = showDetailAgregarNom;
    }

    public CoreShowDetailItem getShowDetailAgregarNom() {
        return showDetailAgregarNom;
    }

    public void setPnlFormModicarNom(CorePanelForm pnlFormModicarNom) {
        this.pnlFormModicarNom = pnlFormModicarNom;
    }

    public CorePanelForm getPnlFormModicarNom() {
        return pnlFormModicarNom;
    }

    public void setPnlFormOpcionesBusq(CorePanelForm pnlFormOpcionesBusq) {
        this.pnlFormOpcionesBusq = pnlFormOpcionesBusq;
    }

    public CorePanelForm getPnlFormOpcionesBusq() {
        return pnlFormOpcionesBusq;
    }

    public void setTbl_listadoNominasModificar(CoreTable tbl_listadoNominasModificar) {
        this.tbl_listadoNominasModificar = tbl_listadoNominasModificar;
    }

    public CoreTable getTbl_listadoNominasModificar() {
        return tbl_listadoNominasModificar;
    }

    public void setBtnCancelarPrincipal(CoreCommandButton btnCancelarPrincipal) {
        this.btnCancelarPrincipal = btnCancelarPrincipal;
    }

    public CoreCommandButton getBtnCancelarPrincipal() {
        return btnCancelarPrincipal;
    }

    public String btnCancelarPrincipal_action() {
        this.getInptTxtRegistroEmpl().setValue("");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"LimpiarListadoEditarNominas");
        this.getBtnFiltrar().setDisabled(false);
        this.getCmdLinkEditarFila().setDisabled(false);
        return null;
    }

    public void setInptTxtRegistroEmpl(CoreInputText inptTxtRegistroEmpl) {
        this.inptTxtRegistroEmpl = inptTxtRegistroEmpl;
    }

    public CoreInputText getInptTxtRegistroEmpl() {
        return inptTxtRegistroEmpl;
    }

    public void setBtnFiltrar(CoreCommandButton btnFiltrar) {
        this.btnFiltrar = btnFiltrar;
    }

    public CoreCommandButton getBtnFiltrar() {
        return btnFiltrar;
    }

    public void setCmdLinkEditarFila(CoreCommandLink cmdLinkEditarFila) {
        this.cmdLinkEditarFila = cmdLinkEditarFila;
    }

    public CoreCommandLink getCmdLinkEditarFila() {
        return cmdLinkEditarFila;
    }

    public void setCmdLinkImprimir(CoreCommandLink cmdLinkImprimir) {
        this.cmdLinkImprimir = cmdLinkImprimir;
    }

    public CoreCommandLink getCmdLinkImprimir() {
        return cmdLinkImprimir;
    }

    public String btnFiltrar_action() {
        String mensaje;
        JUIteratorBinding ib;
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"LimpiarListadoEditarNominas"); //primero limpiamos
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarListadoEditarNominas"); //consultamos
        ib = (JUIteratorBinding) JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.modificar_nominavoIterator}"); 
        if ( ib.getEstimatedRowCount() <= 0) {
            mensaje = "No se encontró resultado con la información ingresada. Intente de nuevo por favor.";
            mensaje(mensaje, 1); // 1 = tipo INFO
        }
        return null;
    }

    public void tbl_listadoNominasModificar_rangeChangeListener(RangeChangeEvent rangeChangeEvent) {
        System.out.println("RangeChangeEven, New End: " + rangeChangeEvent.getNewEnd());
        System.out.println("RangeChangeEven, New Start: " + rangeChangeEvent.getNewStart());
        System.out.println("RangeChangeEven, Old End: " + rangeChangeEvent.getOldEnd());
        System.out.println("RangeChangeEven, Old Start" + rangeChangeEvent.getOldStart());
    }

    public String btn_grabar_cambios_action() {
        String mensaje = "Transacción grabada exitósamente!!";
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(), "Commit")) {
            if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(), "recalcularDescuentos")) {
                 JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), "Commit"); //Para que guardes el recálculo
                 JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), "EjecutarDescuentos"); //Refresh a los Descuentos
                 JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), "EjecutarNominas"); //Refresh a las nóminas
                 JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), "cambiarEstadoTodos"); //Contrae todas las filas
                 JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), "FilaActualNom"); //Apunta a última la fila seleccionada
                 this.getBtnFiltrar().setDisabled(false);
                 this.getCmdLinkEditarFila().setDisabled(false);
                 mensaje(mensaje, 1); // 1 = tipo INFO
             }
         }
        return null;
    }

    public String btn_cancelar_fila_action() {
        String mensaje = "Transacción cancelada exitósamente!!";
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), "EjecutarDescuentos"); //Refresh a los Descuentos
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), "EjecutarNominas"); //Refresh a las nóminas
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), "cambiarEstadoTodos"); //Contrae todas las filas
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), "FilaActualNom"); //Apunta a última la fila seleccionada
        this.getBtnFiltrar().setDisabled(false);
        this.getCmdLinkEditarFila().setDisabled(false);
        mensaje(mensaje, 1); // 1 = tipo INFO
        return null;
    }
}
