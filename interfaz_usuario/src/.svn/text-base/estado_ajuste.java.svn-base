//package interfaz_usuario.backing.procesos;

import enlace_datos.util.resulOp;

import interfaz_usuario.util.JSFUtils;
import interfaz_usuario.util.utils;

import javax.faces.context.FacesContext;

import oracle.adf.view.faces.component.core.input.CoreInputHidden;
import oracle.adf.view.faces.component.core.input.CoreInputText;

import oracle.adf.view.faces.component.core.layout.CorePanelForm;

import oracle.adf.view.faces.component.core.output.CoreOutputText;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class estado_ajuste {
    private CoreInputHidden bandera_estado;
    private CoreInputText hidden_estadoAjuste;
    private BindingContainer bindings;
    private CorePanelForm form_detAjuste;
    private CorePanelForm form_detVarNomina_PagModVarNomina;
   
    public estado_ajuste() {
    }

    public void setBandera_estado(CoreInputHidden bandera_estado) {
        this.bandera_estado = bandera_estado;
        bandera_estado.setValue("ALTA");//sirve para indicar que el usuario ha agregado un nuevo ajuste al empleado
        //el No. 1 indica que el estado del ajuste esta de alta
    }

    public CoreInputHidden getBandera_estado() {
        return bandera_estado;
    }

   
    public void setHidden_estadoAjuste(CoreInputText hidden_estadoAjuste) {
        this.hidden_estadoAjuste = hidden_estadoAjuste;
        hidden_estadoAjuste.setValue("ALTA");
    }

    public CoreInputText getHidden_estadoAjuste() {
        return hidden_estadoAjuste;
    }

    public BindingContainer getBindings() {
        return this.bindings;
    }

    public void setBindings(BindingContainer bindings) {
        this.bindings = bindings;
    }

    public String commandButton_action() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = 
            bindings.getOperationBinding("Create1");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        bandera_estado.setValue("ALTA");// PASO EL VALOR 
        return null;
    }

   
    public void setForm_detAjuste(CorePanelForm form_detAjuste) {
        this.form_detAjuste = form_detAjuste;
    }
// maneja el ocultamiento de la subforma del detalle de la variacion del ajuste en la pagina new_varia_nomina
    public CorePanelForm getForm_detAjuste() {
        return form_detAjuste;
    }

    public String commit1() {
    
    /* metodo que al darle clic al boton grabar muestra la subforma del detalle de la vacion del ajuste
     * en la pagina new_varia_nomina*/
    /*
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = 
            bindings.getOperationBinding("Commit");
        Object result = operationBinding.execute();
      */
       // if (operationBinding.getErrors().isEmpty()) {
           form_detAjuste.setRendered(true);
           JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Create1");
           
       // }
        return null;
    }

    public void setForm_detVarNomina_PagModVarNomina(CorePanelForm form_detVarNomina_PagModVarNomina) {
        this.form_detVarNomina_PagModVarNomina = form_detVarNomina_PagModVarNomina;
    }
    // maneja el ocultamiento de la subforma del detalle de la variacion del ajuste en la pagina mod_varia_nomina

    public CorePanelForm getForm_detVarNomina_PagModVarNomina() {
        return form_detVarNomina_PagModVarNomina;
    }

    public String commit_modVarNomina() {
        // Add event code here...
        form_detVarNomina_PagModVarNomina.setRendered(true);
        return null;
    }

    public String btn_commit_newVariaNomina_action() {
         BindingContainer vBnd_binding;
         OperationBinding operationBinding;
         Object result;
         resulOp vResultado=new resulOp();
         boolean vResultadoOp=false;
         vBnd_binding=(BindingContainer)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings}");
         operationBinding=vBnd_binding.getOperationBinding("nuevo_ajuste");
         result=operationBinding.execute();  
         if (!operationBinding.getErrors().isEmpty()){
             return null;
         }else{
             
             vResultado.setMensajeError("Descuento agregado correctamente");
             vResultado.setCodigoResultado(resulOp.OPE_OK);
             utils.setADFMensaje(vResultado);
             return "buscar";
         }
    }
}
