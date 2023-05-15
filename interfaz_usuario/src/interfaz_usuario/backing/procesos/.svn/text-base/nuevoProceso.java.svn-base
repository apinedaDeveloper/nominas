package interfaz_usuario.backing.procesos;

import interfaz_usuario.util.JSFUtils;

import interfaz_usuario.util.utils;

import javax.faces.component.html.HtmlForm;

import javax.faces.context.FacesContext;

import oracle.adf.view.faces.component.core.input.CoreInputText;
import oracle.adf.view.faces.component.core.input.CoreSelectOneChoice;
import oracle.adf.view.faces.component.core.nav.CoreCommandButton;
import oracle.adf.view.faces.component.html.HtmlBody;
import oracle.adf.view.faces.component.html.HtmlHead;
import oracle.adf.view.faces.component.html.HtmlHtml;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class nuevoProceso {

    private CoreCommandButton btn_procesar;
    private CoreCommandButton btn_cancelar;
    private CoreInputText inp_observaciones;
    private CoreSelectOneChoice cmb_tipoProceso;
    private CoreSelectOneChoice cmb_periodo;

    public String btn_procesar_Action() {
        // Add event code here...
        return null;
    }

    public String commandButton_action() {
        // Add event code here...
         BindingContainer vBnd_binding;
         OperationBinding operationBinding;
         Object result;
        this.btn_procesar.setDisabled(true);
        this.btn_cancelar.setDisabled(true);
        this.inp_observaciones.setDisabled(true);
        this.cmb_tipoProceso.setDisabled(true);
        this.cmb_periodo.setDisabled(true);
         vBnd_binding=(BindingContainer)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings}");
         operationBinding=vBnd_binding.getOperationBinding("generar_proceso");
         result=operationBinding.execute();
         this.btn_procesar.setDisabled(true);
         this.btn_cancelar.setDisabled(true);
         this.inp_observaciones.setDisabled(true);
         if (result!=null){
            utils.setADFMensaje(result);
             
         }
        return null;
    }

    public void setBtn_procesar(CoreCommandButton btn_procesar) {
        this.btn_procesar = btn_procesar;
    }

    public CoreCommandButton getBtn_procesar() {
        return btn_procesar;
    }

    public void setBtn_cancelar(CoreCommandButton btn_cancelar) {
        this.btn_cancelar = btn_cancelar;
    }

    public CoreCommandButton getBtn_cancelar() {
        return btn_cancelar;
    }

    public void setInp_observaciones(CoreInputText inp_observaciones) {
        this.inp_observaciones = inp_observaciones;
    }

    public CoreInputText getInp_observaciones() {
        return inp_observaciones;
    }

    public void setCmb_tipoProceso(CoreSelectOneChoice cmb_tipoProceso) {
        this.cmb_tipoProceso = cmb_tipoProceso;
    }

    public CoreSelectOneChoice getCmb_tipoProceso() {
        return cmb_tipoProceso;
    }

    public void setCmb_periodo(CoreSelectOneChoice cmb_periodo) {
        this.cmb_periodo = cmb_periodo;
    }

    public CoreSelectOneChoice getCmb_periodo() {
        return cmb_periodo;
    }
}
