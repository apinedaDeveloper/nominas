package interfaz_usuario.backing.gestiones;


import enlace_datos.util.resulOp;

import interfaz_usuario.util.JSFUtils;

import interfaz_usuario.util.utils;

import javax.faces.context.FacesContext;

import oracle.adf.view.faces.component.core.layout.CoreShowDetailItem;
import oracle.adf.view.faces.component.core.nav.CoreCommandButton;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class variaciones {
    private BindingContainer bindings;
    private CoreCommandButton guardar;
    private CoreShowDetailItem tb_modificaciones;
    private CoreCommandButton btn_agregar;

    public variaciones() {
    }

    public BindingContainer getBindings() {
        return this.bindings;
    }

    public void setBindings(BindingContainer bindings) {
        this.bindings = bindings;
    }

    public String btn_guardar() {
        boolean resultado;
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.IngresoManual.inputValue}","SI");
        Object varEmpleado = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.RegistroEmpleado1.inputValue}");
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.RegistroEmpleado.inputValue}",varEmpleado);
        resultado = JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit" );
        if (resultado == true) {
          //  this.guardar.setDisabled(true);
            utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Variación Guardada Correctamente."));
            this.tb_modificaciones.setDisabled(false);
            this.btn_agregar.setDisabled(false);
        }else{ //el detalle del anexo no fue creado con exito.
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Error al Guardar la variación"));       
            }    
        
       
        return null;
    }

    public void setGuardar(CoreCommandButton guardar) {
        this.guardar = guardar;
    }

    public CoreCommandButton getGuardar() {
        return guardar;
    }

    public void setTb_modificaciones(CoreShowDetailItem tb_modificaciones) {
        this.tb_modificaciones = tb_modificaciones;
    }

    public CoreShowDetailItem getTb_modificaciones() {
        return tb_modificaciones;
    }

    public String btn_agregar_variacion() {
    
      if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Create")){
          
          this.tb_modificaciones.setDisabled(true); 
          this.btn_agregar.setDisabled(true);
      }
        // Add event code here...
        return null;
    }

    public void setBtn_agregar(CoreCommandButton btn_agregar) {
        this.btn_agregar = btn_agregar;
    }

    public CoreCommandButton getBtn_agregar() {
        return btn_agregar;
    }

    public String btn_cancelar() {
    
        this.tb_modificaciones.setDisabled(false);
        this.btn_agregar.setDisabled(false);
        // Add event code here...
        return null;
    }
}
