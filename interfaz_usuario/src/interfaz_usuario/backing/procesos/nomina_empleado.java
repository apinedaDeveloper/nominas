package interfaz_usuario.backing.procesos;

import enlace_datos.util.resulOp;

import interfaz_usuario.util.JSFUtils;
import interfaz_usuario.util.utils;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

public class nomina_empleado {
    private boolean act_combo1=false;
    
    public boolean getActCombo1(){
        return act_combo1;
    }
    
    public nomina_empleado() {
    }

    public void cmb_tipo_proceso(FacesContext facesContext, 
                                 UIComponent uiComponent, Object object) {
        // Add event code here...
    }

    public void cmb_tipo_proceso_change(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        act_combo1=true;
    }

    public String btn_calcular_nomina() {
        resulOp vResultado;
        vResultado=(resulOp)JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"calcular_nomina_empleado");
        if (vResultado!=null && vResultado.getCodigoResultado()!=resulOp.OPE_OK){
           utils.setADFMensaje(vResultado); 
        }else if (vResultado!=null){
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ActContrato");
               
        }
        
        return null;
    }
}
