package interfaz_usuario.backing.procesos;

import interfaz_usuario.util.JSFUtils;

import javax.faces.context.FacesContext;

import oracle.adf.view.faces.component.core.data.CoreTable;
import oracle.adf.view.faces.component.core.input.CoreSelectOneChoice;

import oracle.adf.view.faces.component.core.nav.CoreCommandButton;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class asig_num_cheque {
    private BindingContainer bindings;
    private CoreSelectOneChoice combo_banco;
    private CoreSelectOneChoice combo_proceso;
    private CoreSelectOneChoice combo_periodo;
    private CoreTable detall_cheque;
    private CoreCommandButton btn_crear_cheque;
    private CoreCommandButton btn_guardar_det;

    public asig_num_cheque() {
    }

    public BindingContainer getBindings() {
        return this.bindings;
    }

    public void setBindings(BindingContainer bindings) {
        this.bindings = bindings;
    }

    public String btn_guardar_maestro_action() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = 
            bindings.getOperationBinding("Commit");
        Object result = operationBinding.execute();
        if (operationBinding.getErrors().isEmpty()) {
            combo_banco.setDisabled(true);
            combo_proceso.setDisabled(true);
            combo_periodo.setDisabled(true);
            detall_cheque.setRendered(true);
            this.btn_crear_cheque.setDisabled(false);
            this.btn_guardar_det.setDisabled(false);
            
        }
        
        return null;
    }

    public void setCombo_banco(CoreSelectOneChoice combo_banco) {
        this.combo_banco = combo_banco;
    }

    public CoreSelectOneChoice getCombo_banco() {
        return combo_banco;
    }

    public void setCombo_proceso(CoreSelectOneChoice combo_proceso) {
        this.combo_proceso = combo_proceso;
    }

    public CoreSelectOneChoice getCombo_proceso() {
        return combo_proceso;
    }

    public void setCombo_periodo(CoreSelectOneChoice combo_periodo) {
        this.combo_periodo = combo_periodo;
    }

    public CoreSelectOneChoice getCombo_periodo() {
        return combo_periodo;
    }

    public void setDetall_cheque(CoreTable detall_cheque) {
        this.detall_cheque = detall_cheque;
    }

    public CoreTable getDetall_cheque() {
        return detall_cheque;
    }

    public void setBtn_crear_cheque(CoreCommandButton btn_crear_cheque) {
        this.btn_crear_cheque = btn_crear_cheque;
    }

    public CoreCommandButton getBtn_crear_cheque() {
        return btn_crear_cheque;
    }

    public void setBtn_guardar_det(CoreCommandButton btn_guardar_det) {
        this.btn_guardar_det = btn_guardar_det;
    }

    public CoreCommandButton getBtn_guardar_det() {
        return btn_guardar_det;
    }

    public String btn_crear_detalle_action() {
    
    
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Create1"))
        {
            
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"inicializaCheque");
            
        }
      /*  
       Object vIterador;
       vIterador=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.asignacion_num_chequeIterator.currentRow}");

       if (vIterador==null){
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Create");
       // JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Ejecutar");
        }else{
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Create1");    
        }
       
        */
        return null;
    }

    public String btn_asignarBanco() {
        // Add event code here...
        
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Create");
        return null;
    }

    public String btn_cancelar() {
        // Add event code here...
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Rollback");
        
        return "proc_nomina";
    }
}
