package interfaz_usuario.backing.gestiones;

import enlace_datos.consultas.gestiones.Sis_ajustes_mod_simple2RowImpl;

import interfaz_usuario.util.JSFUtils;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.faces.component.core.input.CoreInputHidden;
import oracle.adf.view.faces.component.core.input.CoreInputText;
import oracle.adf.view.faces.component.core.input.CoreSelectInputDate;

public class mod_descuentos {
    private CoreInputText inpt_valor;
    private CoreInputHidden inp_hidden_valor;
    private CoreInputText inptPorcentaje;
    private CoreSelectInputDate inptFechaMod;

    public mod_descuentos() {
    }

    public void cmb_ajuste_change_value(ValueChangeEvent valueChangeEvent) {
        Object vValor,vAtributo; 
        
        if (valueChangeEvent.getOldValue()!=valueChangeEvent.getNewValue())
        {
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.Sis_ajustes_mod_simple2_vwIterator.allRowsInRange}");
       
        if (vValor!=null)
         {
        
            vAtributo=JSFUtils.getAtributoIterador(vValor,Integer.valueOf(valueChangeEvent.getNewValue().toString()),"Valor");
            this.getInpt_valor().setValue(vAtributo);
            this.getInpt_valor().setSubmittedValue(vAtributo);
           
            vAtributo=JSFUtils.getAtributoIterador(vValor,Integer.valueOf(valueChangeEvent.getNewValue().toString()),"Porcentaje");
            this.getInptPorcentaje().setValue(vAtributo);
            this.getInptPorcentaje().setSubmittedValue(vAtributo);
           
           
            vAtributo=JSFUtils.getAtributoIterador(vValor,Integer.valueOf(valueChangeEvent.getNewValue().toString()),"FechaFin");
            this.getInptFechaMod().setValue(vAtributo);
            this.getInptFechaMod().setSubmittedValue(vAtributo);
            
           }
        
        }
        
    }

    public void setInpt_valor(CoreInputText inpt_valor) {
        this.inpt_valor = inpt_valor;
    }

    public CoreInputText getInpt_valor() {
        return inpt_valor;
    }

    public void inpt_valor(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
    }

    public void inpt_valor_change(ValueChangeEvent valueChangeEvent) {
       String  otros;
       otros="asdasd";
       System.out.println(otros);
        // Add event code here...
    }

    public void setInptPorcentaje(CoreInputText inptPorcentaje) {
        this.inptPorcentaje = inptPorcentaje;
    }

    public CoreInputText getInptPorcentaje() {
        return inptPorcentaje;
    }

    public void setInptFechaMod(CoreSelectInputDate inptFechaMod) {
        this.inptFechaMod = inptFechaMod;
    }

    public CoreSelectInputDate getInptFechaMod() {
        return inptFechaMod;
    }
}
