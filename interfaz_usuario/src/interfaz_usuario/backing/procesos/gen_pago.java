package interfaz_usuario.backing.procesos;

import enlace_datos.util.resulOp;

import interfaz_usuario.util.JSFUtils;

import interfaz_usuario.util.utils;

import java.util.List;

import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;

import javax.faces.event.ValueChangeEvent;

import javax.faces.model.SelectItem;

import oracle.adf.view.faces.component.core.input.CoreInputHidden;
import oracle.adf.view.faces.component.core.input.CoreInputText;

import oracle.adf.view.faces.component.core.input.CoreSelectInputDate;
import oracle.adf.view.faces.component.core.input.CoreSelectOneChoice;
import oracle.adf.view.faces.component.core.input.CoreSelectOneListbox;
import oracle.adf.view.faces.component.core.layout.CorePanelHorizontal;
import oracle.adf.view.faces.component.core.nav.CoreCommandButton;

import oracle.adfinternal.view.faces.model.binding.FacesCtrlListBinding;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.domain.Date;

public class gen_pago {
    private BindingContainer bindings;
    private CoreInputText inpt_tipo_pago;
    private CoreInputHidden hiden_operacion;
    private CoreCommandButton btn_agregar;
    private CoreCommandButton btn_eliminar;
    private CoreCommandButton btn_confirmar;
    private CoreCommandButton btn_guardar;
    private CoreCommandButton btn_descartar;
    private CoreCommandButton btn_nuevo_pago;
    private CoreInputText inpt_observaciones;
    private CorePanelHorizontal panel_boton1;
    private CoreInputText inpt_porcentaje;
    private CoreSelectOneChoice cmb_procesos;
    private UISelectItems cmb_item_proceso;
    private CoreSelectInputDate inpt_fecha;

    public gen_pago() {
    
    }

    public BindingContainer getBindings() {
        return this.bindings;
    }

    public void setBindings(BindingContainer bindings) {
        this.bindings = bindings;
    }

    public String btn_ejecutar_action() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = 
            bindings.getOperationBinding("Commit");
        Object result = operationBinding.execute();
        /*
        // Si no hubo ningun error en la inserccion se ejecuta el proceso
        if (operationBinding.getErrors().isEmpty()){
            bindings=(BindingContainer)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings}");
            operationBinding=bindings.getOperationBinding("generar_pago");
            result=operationBinding.execute();
            // Si el resultado no es nulo muestra el resultado de la operacion
            if (result!=null){
               utils.setADFMensaje(result);
                
            }   
            
           
            this.btn_confirmar.setDisabled(true);
         //   this.btn_eliminar.setDisabled(true);
            this.btn_descartar.setDisabled(true);
            this.btn_guardar.setDisabled(true);
            this.btn_agregar.setDisabled(true);
            this.btn_nuevo_pago.setDisabled(false);
            this.inpt_observaciones.setDisabled(true);
            
        }
        */
        return null;
    }

    public void setInpt_tipo_pago(CoreInputText inpt_tipo_pago) {
        this.inpt_tipo_pago = inpt_tipo_pago;
    }

    public CoreInputText getInpt_tipo_pago() {
       
        return inpt_tipo_pago;
    }

    public void setHiden_operacion(CoreInputHidden hiden_operacion) {
        this.hiden_operacion = hiden_operacion;
        hiden_operacion.setValue("PAGO");
    }

    public CoreInputHidden getHiden_operacion() {
        return hiden_operacion;
    }

    public String commandButton_action() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = 
            bindings.getOperationBinding("Create1");
        Object result = operationBinding.execute();
        if (operationBinding.getErrors().isEmpty()) {
            this.btn_guardar.setDisabled(false);
        }
        return null;
    }

    public void setBtn_agregar(CoreCommandButton btn_agregar) {
        this.btn_agregar = btn_agregar;
    }

    public CoreCommandButton getBtn_agregar() {
        return btn_agregar;
    }

    public void setBtn_eliminar(CoreCommandButton btn_eliminar) {
        this.btn_eliminar = btn_eliminar;
    }

    public CoreCommandButton getBtn_eliminar() {
        return btn_eliminar;
    }

    public void setBtn_confirmar(CoreCommandButton btn_confirmar) {
        this.btn_confirmar = btn_confirmar;
    }

    public CoreCommandButton getBtn_confirmar() {
        return btn_confirmar;
    }

    public void setBtn_guardar(CoreCommandButton btn_guardar) {
        this.btn_guardar = btn_guardar;
    }

    public CoreCommandButton getBtn_guardar() {
        return btn_guardar;
    }

    public void setBtn_descartar(CoreCommandButton btn_descartar) {
        this.btn_descartar = btn_descartar;
    }

    public CoreCommandButton getBtn_descartar() {
        return btn_descartar;
    }

    public void setBtn_nuevo_pago(CoreCommandButton btn_nuevo_pago) {
        this.btn_nuevo_pago = btn_nuevo_pago;
    }

    public CoreCommandButton getBtn_nuevo_pago() {
        return btn_nuevo_pago;
    }

    public void setInpt_observaciones(CoreInputText inpt_observaciones) {
        this.inpt_observaciones = inpt_observaciones;
    }

    public CoreInputText getInpt_observaciones() {
        return inpt_observaciones;
    }

    public String btn_nuevo_action() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = 
            bindings.getOperationBinding("Rollback");
        Object result = operationBinding.execute();
        
        bindings = getBindings();
         operationBinding = 
            bindings.getOperationBinding("Create");
         result = operationBinding.execute();
        
        
        
        if (operationBinding.getErrors().isEmpty()) {
            this.btn_nuevo_pago.setDisabled(true); 
            this.btn_confirmar.setDisabled(false);
          //  this.btn_eliminar.setDisabled(true);
            this.btn_descartar.setDisabled(false);
            this.btn_guardar.setDisabled(true);
            this.btn_agregar.setDisabled(false);
            this.inpt_observaciones.setDisabled(false);
        }
        return null;
    }

    public String btn_cancelar() {
        // Add event code here...
         BindingContainer bindings = getBindings();
         OperationBinding operationBinding = 
             bindings.getOperationBinding("Rollback");
         Object result = operationBinding.execute();
        
        if (operationBinding.getErrors().isEmpty()) {
            this.btn_nuevo_pago.setDisabled(false); 
            this.btn_confirmar.setDisabled(true);
            this.btn_guardar.setDisabled(true);
       //     this.btn_eliminar.setDisabled(true);
            this.btn_agregar.setDisabled(true);
            }
            
        return null;
    }

    public void setPanel_boton1(CorePanelHorizontal panel_boton1) {
        this.panel_boton1 = panel_boton1;
    }

    public CorePanelHorizontal getPanel_boton1() {
        return panel_boton1;
    }

    public void lst_procesos(ValueChangeEvent valueChangeEvent) {
    
                /*
                *  Obteniendo el departamento seleccionado
                */
               Object []vAryl_DatosCombo;
               List <FacesCtrlListBinding> vClb_itemsValue;
               vClb_itemsValue=(List <FacesCtrlListBinding>)this.cmb_item_proceso.getValue(); //binding del <f:selectItems>
               vAryl_DatosCombo=vClb_itemsValue.toArray();
               SelectItem vSlct_seleccionado;
               vSlct_seleccionado=(SelectItem)vAryl_DatosCombo[Integer.parseInt(this.cmb_procesos.getValue().toString())];     
             //  System.out.println("cambiado el departamento" +vSlct_seleccionado.getLabel());

     
     
     try{
        if (vSlct_seleccionado.getLabel().indexOf("AGUINALDO")<=0){
            this.getInpt_porcentaje().setSubmittedValue(null);
            this.getInpt_porcentaje().setValue(100);
        }
     }catch(Exception exep){
         this.getInpt_porcentaje().setSubmittedValue(null);
         this.getInpt_porcentaje().setValue(100);
     }
    
    }

    public void setInpt_porcentaje(CoreInputText inpt_porcentaje) {
        this.inpt_porcentaje = inpt_porcentaje;
    }

    public CoreInputText getInpt_porcentaje() {
        return inpt_porcentaje;
    }

    public void setCmb_procesos(CoreSelectOneChoice cmb_procesos) {
        this.cmb_procesos = cmb_procesos;
    }

    public CoreSelectOneChoice getCmb_procesos() {
        return cmb_procesos;
    }

    public void setCmb_item_proceso(UISelectItems cmb_item_proceso) {
        this.cmb_item_proceso = cmb_item_proceso;
    }

    public UISelectItems getCmb_item_proceso() {
        return cmb_item_proceso;
    }


    public boolean validateFecha(Date  data) {
        long vDiffMeses;
                long Milianio;
                Milianio=24*60*60;
               try{ 
                  if (data!=null){
                  vDiffMeses=new java.util.Date().getTime()- data.getValue().getTime(); 
                  vDiffMeses=vDiffMeses/(1000*Milianio);
                  if (vDiffMeses>30){
                      return false;
                  }
                                }
               }catch(Exception exep){
                exep.printStackTrace();
                 return false;
               }
        return true;
    }
    
    public String btn_siguiente_action() {
        String vOutcome;
        
        vOutcome="new_asig_cheque";
        if (this.getInpt_fecha().getValue()==null){
           utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Por favor ingrese la fecha de pago.")); 
            vOutcome=null ;
        }
        
        if (!validateFecha((Date)this.getInpt_fecha().getValue())){
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Por favor ingrese una fecha de pago válida.")); 
            vOutcome=null ;
        }
        
        return vOutcome;
    }

    public void setInpt_fecha(CoreSelectInputDate inpt_fecha) {
        this.inpt_fecha = inpt_fecha;
    }

    public CoreSelectInputDate getInpt_fecha() {
        return inpt_fecha;
    }
}
