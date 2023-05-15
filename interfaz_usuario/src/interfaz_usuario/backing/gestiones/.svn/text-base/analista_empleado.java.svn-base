package interfaz_usuario.backing.gestiones;

import enlace_datos.util.resulOp;

import interfaz_usuario.util.JSFUtils;
import interfaz_usuario.util.utils;

import java.util.Calendar;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.faces.component.core.input.CoreInputText;
import oracle.adf.view.faces.component.core.input.CoreSelectOneChoice;

public class analista_empleado {
    public boolean selecUnidad = false;
    public boolean selecPartida = false;
    private boolean selecPlazaU=false;
    private boolean selecDep=false;
    private CoreInputText anio;
    private CoreSelectOneChoice cmbUnidad;
    private CoreInputText empleado;
    private CoreInputText plaza;
    public boolean selecUnidad2 = false;

    public analista_empleado() {
    }
    
    public boolean getSelecDep(){        
           return selecDep;
    }
    
    public boolean getSelecUnidad(){        
            return selecUnidad;
    }
    
    public boolean getSelecPartida(){        
            return selecPartida;
    }
    
    public boolean getSelecPlazaU(){        
            return selecPlazaU;
    }
    public boolean getSelecUnidad2(){        
            return selecUnidad;
    }
    
    
    public void calculo_anio(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        //if (this.anio.getValue() == null | this.anio.getValue().equals("")) {
            int varanio;
            Calendar varFecha = Calendar.getInstance();
            varanio = varFecha.get(Calendar.YEAR);
            this.anio.setSubmittedValue(varanio);
            this.anio.setValue(varanio);
            
            
            
            
            
       // }
    }

    public void seleccionarDependencia(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue() ){
            //System.out.println("esto trae el old"+ valueChangeEvent.getOldValue());
            //System.out.println("esto trae el new"+ valueChangeEvent.getNewValue());
            this.selecDep=true;
            this.selecUnidad=true;
            this.selecPlazaU=true;
            int varanio;
            Calendar varFecha = Calendar.getInstance();
            varanio = varFecha.get(Calendar.YEAR);
            this.anio.setSubmittedValue(varanio);
            this.anio.setValue(varanio);
        }
    }

    public void setAnio(CoreInputText anio) {
        this.anio = anio;
    }

    public CoreInputText getAnio() {
        return anio;
    }

    public void setCmbUnidad(CoreSelectOneChoice cmbUnidad) {
        this.cmbUnidad = cmbUnidad;
    }

    public CoreSelectOneChoice getCmbUnidad() {
        return cmbUnidad;
    }

    public void seleccionarUnidad(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
         if(valueChangeEvent.getOldValue() != valueChangeEvent.getNewValue()){
             selecPartida = true;
             this.selecUnidad=true;
             this.selecPlazaU=true;
             int varanio;
             Calendar varFecha = Calendar.getInstance();
             varanio = varFecha.get(Calendar.YEAR);
             this.anio.setSubmittedValue(varanio);
             this.anio.setValue(varanio);
            // System.out.println("esto trae el old"+ valueChangeEvent.getOldValue());
             //System.out.println("esto trae el new"+ valueChangeEvent.getNewValue());
         }
    }

    public String btnReporte_action() {
        // Add event code here...
       /*
        if (this.anio.getValue()== null) {
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Debe ingresar el año para el cual quiere genera el reporte "));
        }    
        else if (this.plaza.getValue() == null) {
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Debe ingresar un número de  plaza"));
        }
        else if (this.empleado.getValue() == null){
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Debe ingresar un Registro de Empleado "));
        }
        */
        
        return null;
    }

    public void setEmpleado(CoreInputText empleado) {
        this.empleado = empleado;
    }

    public CoreInputText getEmpleado() {
        return empleado;
    }

    public void setPlaza(CoreInputText plaza) {
        this.plaza = plaza;
    }

    public CoreInputText getPlaza() {
        return plaza;
    }

    public void cmb_selc_dependencia(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
         // Add event code here...
         if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue() ){
             //System.out.println("esto trae el old"+ valueChangeEvent.getOldValue());
             //System.out.println("esto trae el new"+ valueChangeEvent.getNewValue());
             
             this.selecDep=true;
             this.selecUnidad=true;
             this.selecPlazaU=true;
             
             int varanio;
             Calendar varFecha = Calendar.getInstance();
             varanio = varFecha.get(Calendar.YEAR);
           //  System.out.println("Se ha seleccionado la dependencia ");
          //   this.anio.setSubmittedValue(varanio);
           //  this.anio.setValue(varanio);
         }
        
    }

    public String btn_agregarComentario() {
        // Add event code here...
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"setSelFilas"))
        {
        
           JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"AgregarComen");
            
        }
        
        return null;
    }

    public String btn_guardarComent() {
        // Add event code here...
        
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit")){
        
            JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"setSelFilas");
            utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Se han guardado los comentarios"));
        }
        return null;
    }

    public void cmb_plazaXU_sel(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        
         if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue() ){
         
           this.selecPlazaU=true;
        //   System.out.println("Se ha seleccionado la plaza");
          
         }
    }

    public String btn_cancelar_action() {
         if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Rollback")){
         
             JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"setSelFilas");
             
         }
    return null;
    }

    public void cmb_subprograma_sel(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
         if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue() ){
         
           this.selecUnidad=true;
           this.selecPlazaU=true;
          // System.out.println("Se ha seleccionado la unidad");
          
         }
    }

    public String cmd_editar_fila() {
        // Add event code here...
        
        JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"setSelFilas");
        JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"setComent");
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.isSelecionado.inputValue}",true);
        
        return null;
    }
}
