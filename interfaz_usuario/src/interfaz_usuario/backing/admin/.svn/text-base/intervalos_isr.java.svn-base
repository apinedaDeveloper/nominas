package interfaz_usuario.backing.admin;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import oracle.adf.view.faces.component.core.input.CoreInputText;
import oracle.adf.view.faces.component.core.input.CoreSelectInputDate;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class intervalos_isr {
    private CoreInputText inpt_ingresar_limite_inferior;
    private CoreInputText inpt_limite_superior;
    private CoreInputText impt_importe_fijo;
    private CoreInputText impt_ingresar_porcentaje;
    private CoreInputText impt_ingresar_excedente;
    private CoreSelectInputDate impt_ingresar_fecha_inicio;
    private CoreSelectInputDate impt_ingresar_fecha_fin;
    private BindingContainer bindings;

    public intervalos_isr() {
    }

    public void inputText_limite_inferior(FacesContext facesContext, 
                                          UIComponent uiComponent, 
                                          Object object) {
        // Add event code here...
    }

    public void setInpt_ingresar_limite_inferior(CoreInputText inpt_ingresar_limite_inferior) {
        this.inpt_ingresar_limite_inferior = inpt_ingresar_limite_inferior;
    }

    public CoreInputText getInpt_ingresar_limite_inferior() {
        return inpt_ingresar_limite_inferior;
    }

    public void setInpt_limite_superior(CoreInputText inpt_limite_superior) {
        this.inpt_limite_superior = inpt_limite_superior;
    }

    public CoreInputText getInpt_limite_superior() {
        return inpt_limite_superior;
    }

    
    public CoreInputText getImpt_importe_fijo() {
        return impt_importe_fijo;
    }

    public void setImpt_importe_fijo(CoreInputText impt_importe_fijo) {
        this.impt_importe_fijo = impt_importe_fijo;
    }

    
    public void setImpt_ingresar_porcentaje(CoreInputText impt_ingresar_porcentaje) {
        this.impt_ingresar_porcentaje = impt_ingresar_porcentaje;
    }

    public CoreInputText getImpt_ingresar_porcentaje() {
        return impt_ingresar_porcentaje;
    }

    public void setImpt_ingresar_excedente(CoreInputText impt_ingresar_excedente) {
        this.impt_ingresar_excedente = impt_ingresar_excedente;
    }

    public CoreInputText getImpt_ingresar_excedente() {
        return impt_ingresar_excedente;
    }

    public void setImpt_ingresar_fecha_inicio(CoreSelectInputDate impt_ingresar_fecha_inicio) {
        this.impt_ingresar_fecha_inicio = impt_ingresar_fecha_inicio;
    }

    public CoreSelectInputDate getImpt_ingresar_fecha_inicio() {
        return impt_ingresar_fecha_inicio;
    }

    public void setImpt_ingresar_fecha_fin(CoreSelectInputDate impt_ingresar_fecha_fin) {
        this.impt_ingresar_fecha_fin = impt_ingresar_fecha_fin;
    }

    public CoreSelectInputDate getImpt_ingresar_fecha_fin() {
        return impt_ingresar_fecha_fin;
    }

    public BindingContainer getBindings() {
        return this.bindings;
    }

    public void setBindings(BindingContainer bindings) {
        this.bindings = bindings;
    }

    public String commandButton_Crear() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = 
            bindings.getOperationBinding("Create1");
        Object result = operationBinding.execute();
        if (operationBinding.getErrors().isEmpty()) {
        
         this.inpt_ingresar_limite_inferior.setDisabled(false);
         this.inpt_limite_superior.setDisabled(false);
         this.impt_importe_fijo.setDisabled(false);
         this.impt_ingresar_excedente.setDisabled(false);
         this.impt_ingresar_fecha_fin.setDisabled(false);
         this.impt_ingresar_fecha_inicio.setDisabled(false);
         this.impt_ingresar_porcentaje.setDisabled(false);
        
        }
        return null;
    }

    public String commandButton_commit() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = 
            bindings.getOperationBinding("Commit");
        Object result = operationBinding.execute();
        if (operationBinding.getErrors().isEmpty()) {
            
            this.inpt_ingresar_limite_inferior.setDisabled(true);
            this.inpt_limite_superior.setDisabled(true);
            this.impt_importe_fijo.setDisabled(true);
            this.impt_ingresar_excedente.setDisabled(true);
            this.impt_ingresar_fecha_fin.setDisabled(true);
            this.impt_ingresar_fecha_inicio.setDisabled(true);
            this.impt_ingresar_porcentaje.setDisabled(true);
            
        }
        return null;
    }

    public String commandButton_rollback() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = 
            bindings.getOperationBinding("Rollback");
        Object result = operationBinding.execute();
        if (operationBinding.getErrors().isEmpty()) {
            this.inpt_ingresar_limite_inferior.setDisabled(true);
            this.inpt_limite_superior.setDisabled(true);
            this.impt_importe_fijo.setDisabled(true);
            this.impt_ingresar_excedente.setDisabled(true);
            this.impt_ingresar_fecha_fin.setDisabled(true);
            this.impt_ingresar_fecha_inicio.setDisabled(true);
            this.impt_ingresar_porcentaje.setDisabled(true);
            
        }
        return null;
    }
}
