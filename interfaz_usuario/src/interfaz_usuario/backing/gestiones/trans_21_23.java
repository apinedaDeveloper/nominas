package interfaz_usuario.backing.gestiones;

import interfaz_usuario.util.JSFUtils;
import interfaz_usuario.util.utils;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;

import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.component.html.HtmlPanelGroup;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.faces.component.core.data.CoreColumn;
import oracle.adf.view.faces.component.core.data.CoreTable;
import oracle.adf.view.faces.component.core.data.CoreTableSelectOne;
import oracle.adf.view.faces.component.core.input.CoreInputText;
import oracle.adf.view.faces.component.core.input.CoreSelectInputDate;
import oracle.adf.view.faces.component.core.input.CoreSelectOneChoice;
import oracle.adf.view.faces.component.core.layout.CorePanelForm;
import oracle.adf.view.faces.component.core.layout.CorePanelHeader;
import oracle.adf.view.faces.component.core.nav.CoreCommandButton;
import oracle.adf.view.faces.component.core.output.CoreOutputFormatted;
import oracle.adf.view.faces.component.core.output.CoreOutputText;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class trans_21_23 {
    private boolean vCambioDep=false;
    private boolean vCambioUni=false;
    private boolean vCambioPartida=false;
    private CorePanelHeader pnlDep;
    private CorePanelHeader panelHeader1;
    private CoreCommandButton btnPrueba2;
    private CorePanelHeader panelHeader3;
    private BindingContainer bindings;
    private HtmlPanelGrid panelGrid1;
    private CoreSelectOneChoice cmbDependencia;
    private UISelectItems selectItems1;
    private CoreSelectOneChoice cmdUnidad;
    private UISelectItems selectItems2;
    private CoreSelectOneChoice cmbPartida;
    private UISelectItems selectItems3;
    private CoreCommandButton btnMostrarSaldo;
    private HtmlPanelGrid panelGrid2;
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
    private CoreTable table2;
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
    private CoreTableSelectOne tableSelectOne1;
    private CoreCommandButton commandButton2;
    private CoreOutputFormatted outputFormatted1;
    private CoreOutputFormatted outputFormatted11;
    private CorePanelForm pnlTransferencia;
    private CoreInputText inputText1;
    private CoreSelectInputDate selectInputDate1;
    private CoreInputText inputText3;
    private CoreInputText inputText4;
    private CoreInputText inputText5;
    private CoreSelectInputDate selectInputDate2;
    private CoreInputText inputText6;
    private CoreSelectInputDate selectInputDate3;
    private CoreInputText inpAnio;
    private CoreCommandButton commandButton1;
    private HtmlPanelGroup panelGroup1;
    private CoreCommandButton btnCancelar;
    private CoreCommandButton btnGrabar;
    private CoreCommandButton btnCrearIntra;
    private CoreInputText inpIdPartida;
    private CoreTableSelectOne tableSelectOne2;

    public trans_21_23() {
    }

/* ***************************************************************************** */    
/* ***************************************************************************** */    
/* ***************************************************************************** */    
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

    public boolean getCambioUni(){
        return vCambioUni;
    }

    public boolean getCambioPartida(){
        return vCambioPartida;
    }

    public void cmbDependencia(ValueChangeEvent valueChangeEvent){
        // Add event code here...
        if (valueChangeEvent.getOldValue()!=valueChangeEvent.getNewValue()){
            //System.out.println("Cambio valor de Dependencia");
            pnlTransferencia.setRendered(false);
            vCambioDep=true;
        }
    }

    public void cmbUnidad(ValueChangeEvent valueChangeEvent){
        // Add event code here...
        if (valueChangeEvent.getOldValue()!=valueChangeEvent.getNewValue()){
            //System.out.println("Cambio valor de Unidad");
            vCambioUni=true;
        }
    }

    public void cmbPartida(ValueChangeEvent valueChangeEvent){
        // Add event code here...
        if (valueChangeEvent.getOldValue()!=valueChangeEvent.getNewValue()){
            //System.out.println("Cambio valor de Partida");
            vCambioPartida=true;
            this.btnMostrarSaldo.setDisabled(false); //se habilita el boton mostrar saldo
            //btnMostrarSaldo_action();
        }
    }

    public String RefrescarSaldo() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("filtrarPartida");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        return null;
    }
    public String btnMostrarSaldo_action() {
        BindingContainer bindings = getBindings();
        String mensaje;
        Object vAnioTrabajo;
        Object vAnioActual;
        OperationBinding operationBinding = bindings.getOperationBinding("filtrarPartida");
        Object result = operationBinding.execute();
        if (operationBinding.getErrors().isEmpty()) {
            operationBinding = bindings.getOperationBinding("filtrarTransferencia");  //Para mostrar las INTRAS 
            operationBinding.execute();
            vAnioTrabajo=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{flujo_usuario.anioActual}");
            vAnioActual=utils.getAnioActual();
            btnCancelar_action();
            if (vAnioTrabajo.toString().equals(vAnioActual.toString()) ){
                vAnioTrabajo=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.AnioSaldo.inputValue}");
                if (vAnioTrabajo == null ){
                    mensaje = "No tiene asignado saldo inicial para partida seleccionado";
                    mensaje(mensaje, 1); // 3 = tipo ERROR                
                }
                //Indica que son iguales los años, por lo tanto, si procede habilitar el boton de crear INTRA
                btnCrearIntra.setDisabled(false); //se habilita el boton crear
                btnCancelar.setDisabled(false);
            }else{
                btnCrearIntra.setDisabled(true); //se deshabilita el boton crear
                btnCancelar.setDisabled(true);
                mensaje = "No puede ingresar INTRA con año distinto al año actual";
                mensaje(mensaje, 3); // 3 = tipo ERROR                
            }
            pnlTransferencia.setRendered(true);
            return null;
        }
        return null;
    }

    public String btnActualizar_action() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("setActualizarSaldoAnual");
        Object result = operationBinding.execute();
        String mensaje;

        if (operationBinding.getErrors().isEmpty()) {
            btnMostrarSaldo_action();    
            mensaje = "Información Guardada Éxitosamente!!";
            mensaje(mensaje, 1); // 1 = tipo INFO
            //return null;
        }else{
            //btnMostrarSaldo_action();    
            mensaje = "Ha ocurrido un error inesperado. Por favor revise.";
            mensaje(mensaje, 3); // 3 = tipo ERROR
        }
        return null;
    }

    public String btnCrearIntra_action() {
        Object vIdPartida;
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("Create");
        Object result = operationBinding.execute();
        if (operationBinding.getErrors().isEmpty()) {
            vIdPartida=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vIdPartida1.inputValue}");
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.IdPartida.inputValue}",vIdPartida);
            this.btnCrearIntra.setDisabled(true);  //se deshabilita el boton Crear INTRA
            this.btnGrabar.setDisabled(false);  //se habilita el boton grabar
            return null;
        }
        return null;
    }

    public String btnCancelar_action() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("Rollback");
        Object result = operationBinding.execute();
        if (operationBinding.getErrors().isEmpty()) {
            this.btnCrearIntra.setDisabled(false);  //se habilita el boton Crear INTRA
            this.btnGrabar.setDisabled(true);  //se deshabilita el boton grabar
            return null;
        }
        return null;
    }

    public String btnGrabar_action() {
        String mensaje;
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("Confirmar");
        Object result = operationBinding.execute();
        if (operationBinding.getErrors().isEmpty()) {
            RefrescarSaldo();
            mensaje = "Información Guardada Éxitosamente!!";
            mensaje(mensaje, 1); // 1 = tipo INFO
            this.btnCrearIntra.setDisabled(false);  //se habilita el boton Crear INTRA
            this.btnGrabar.setDisabled(true);  //se deshabilita el boton Grabar
            return null;
        }
        return null;
    }


/* ***************************************************************************** */    
/* ***************************************************************************** */    
/* ***************************************************************************** */

    public void setPnlDep(CorePanelHeader pnlDep) {
        this.pnlDep = pnlDep;
    }

    public CorePanelHeader getPnlDep() {
        return pnlDep;
    }


    public void setPanelHeader1(CorePanelHeader panelHeader1) {
        this.panelHeader1 = panelHeader1;
    }

    public CorePanelHeader getPanelHeader1() {
        return panelHeader1;
    }


    public void setBtnPrueba2(CoreCommandButton commandButton1) {
        this.btnPrueba2 = commandButton1;
    }

    public CoreCommandButton getBtnPrueba2() {
        return btnPrueba2;
    }

    public String commandButton1_action() {
        // Add event code here...
        return null;
    }


    public String commandButton1_action2() {
        // Add event code here...
        return null;
    }


    public void cmbPartida_validator(FacesContext facesContext, 
                                     UIComponent uiComponent, Object object) {
        // Add event code here...
    }

    public String btnPrueba_action() {
        // Add event code here...
        return null;
    }

    public void setPanelHeader3(CorePanelHeader panelHeader3) {
        this.panelHeader3 = panelHeader3;
    }

    public CorePanelHeader getPanelHeader3() {
        return panelHeader3;
    }


    public String btnPrueba2_action() {
        // Add event code here...
        return null;
    }


    public String commandButton3_action() {
        // Add event code here...
        return null;
    }


    public BindingContainer getBindings() {
        return this.bindings;
    }

    public void setBindings(BindingContainer bindings) {
        this.bindings = bindings;
    }


    public void setPanelGrid1(HtmlPanelGrid panelGrid1) {
        this.panelGrid1 = panelGrid1;
    }

    public HtmlPanelGrid getPanelGrid1() {
        return panelGrid1;
    }

    public void setCmbDependencia(CoreSelectOneChoice cmbDependencia) {
        this.cmbDependencia = cmbDependencia;
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

    public void setCmdUnidad(CoreSelectOneChoice cmdUnidad) {
        this.cmdUnidad = cmdUnidad;
    }

    public CoreSelectOneChoice getCmdUnidad() {
        return cmdUnidad;
    }

    public void setSelectItems2(UISelectItems selectItems2) {
        this.selectItems2 = selectItems2;
    }

    public UISelectItems getSelectItems2() {
        return selectItems2;
    }

    public void setCmbPartida(CoreSelectOneChoice cmbPartida) {
        this.cmbPartida = cmbPartida;
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

    public void setBtnMostrarSaldo(CoreCommandButton btnMostrarSaldo) {
        this.btnMostrarSaldo = btnMostrarSaldo;
    }

    public CoreCommandButton getBtnMostrarSaldo() {
        return btnMostrarSaldo;
    }


    public void setPanelGrid2(HtmlPanelGrid panelGrid2) {
        this.panelGrid2 = panelGrid2;
    }

    public HtmlPanelGrid getPanelGrid2() {
        return panelGrid2;
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


    public void setTable2(CoreTable table2) {
        this.table2 = table2;
    }

    public CoreTable getTable2() {
        return table2;
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

    public void setTableSelectOne1(CoreTableSelectOne tableSelectOne1) {
        this.tableSelectOne1 = tableSelectOne1;
    }

    public CoreTableSelectOne getTableSelectOne1() {
        return tableSelectOne1;
    }

    public void setCommandButton2(CoreCommandButton commandButton2) {
        this.commandButton2 = commandButton2;
    }

    public CoreCommandButton getCommandButton2() {
        return commandButton2;
    }

    public void setOutputFormatted1(CoreOutputFormatted outputFormatted1) {
        this.outputFormatted1 = outputFormatted1;
    }

    public CoreOutputFormatted getOutputFormatted1() {
        return outputFormatted1;
    }


    public void setOutputFormatted11(CoreOutputFormatted outputFormatted11) {
        this.outputFormatted11 = outputFormatted11;
    }

    public CoreOutputFormatted getOutputFormatted11() {
        return outputFormatted11;
    }


    public void setPnlTransferencia(CorePanelForm panelForm1) {
        this.pnlTransferencia = panelForm1;
    }

    public CorePanelForm getPnlTransferencia() {
        return pnlTransferencia;
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

    public void setSelectInputDate2(CoreSelectInputDate selectInputDate2) {
        this.selectInputDate2 = selectInputDate2;
    }

    public CoreSelectInputDate getSelectInputDate2() {
        return selectInputDate2;
    }

    public void setInputText6(CoreInputText inputText6) {
        this.inputText6 = inputText6;
    }

    public CoreInputText getInputText6() {
        return inputText6;
    }

    public void setSelectInputDate3(CoreSelectInputDate selectInputDate3) {
        this.selectInputDate3 = selectInputDate3;
    }

    public CoreSelectInputDate getSelectInputDate3() {
        return selectInputDate3;
    }

    public void setInpAnio(CoreInputText inputText7) {
        this.inpAnio = inputText7;
    }

    public CoreInputText getInpAnio() {
        return inpAnio;
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


    public void setBtnCancelar(CoreCommandButton commandButton4) {
        this.btnCancelar = commandButton4;
    }

    public CoreCommandButton getBtnCancelar() {
        return btnCancelar;
    }


    public String commandButton1_action3() {
        // Add event code here...
        return null;
    }

    public void setBtnGrabar(CoreCommandButton btnGrabar) {
        this.btnGrabar = btnGrabar;
    }

    public CoreCommandButton getBtnGrabar() {
        return btnGrabar;
    }

    public void setBtnCrearIntra(CoreCommandButton btnCrearIntra) {
        this.btnCrearIntra = btnCrearIntra;
    }

    public CoreCommandButton getBtnCrearIntra() {
        return btnCrearIntra;
    }

    public void setInpIdPartida(CoreInputText inpIdPartida) {
        this.inpIdPartida = inpIdPartida;
    }

    public CoreInputText getInpIdPartida() {
        return inpIdPartida;
    }

    public void setTableSelectOne2(CoreTableSelectOne tableSelectOne2) {
        this.tableSelectOne2 = tableSelectOne2;
    }

    public CoreTableSelectOne getTableSelectOne2() {
        return tableSelectOne2;
    }
}
