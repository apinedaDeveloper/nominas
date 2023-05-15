package interfaz_usuario.backing.util;

import enlace_datos.consultas.gestiones.empleado.lista_empleadosRowImpl;

import enlace_datos.util.resulOp;

import interfaz_usuario.util.JSFUtils;

import interfaz_usuario.util.utils;

import javax.faces.context.FacesContext;

import oracle.adf.view.faces.component.core.input.CoreSelectInputText;
import oracle.adf.view.faces.event.ReturnEvent;

public class firmas_contrato {
    private CoreSelectInputText inpt_registro_Empleado;

    public firmas_contrato() {
    }

    public void inp_reg_empleado_listener(ReturnEvent returnEvent) {
        lista_empleadosRowImpl vValor;
        if (returnEvent.getReturnValue()!=null){
           // vValor=(lista_empleadosRowImpl)returnEvent.getReturnValue();
           // this.getInpt_registro_Empleado().setSubmittedValue(null);
            //this.getInpt_registro_Empleado().setValue(vValor.getRegistroEmpleado());
            
        }
        
      //  System.out.println("retorno "+returnEvent.getReturnValue());
        
    }

    public void setInpt_registro_Empleado(CoreSelectInputText inpt_registro_Empleado) {
        this.inpt_registro_Empleado = inpt_registro_Empleado;
    }

    public CoreSelectInputText getInpt_registro_Empleado() {
        return inpt_registro_Empleado;
    }

    public String btn_commit_action() {
      
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit")){
            utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Datos guardados correctamente"));
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.vEstado1.inputValue}","0");
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Ejecutar");
        }
        return null;
    }

    public String cmd_darBaja() {
        
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"darBaja")){
            utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Se ha dado de baja la fila."));
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.vEstado1.inputValue}","0");
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ExAuthContrato");
        }
        return null;
    }
}
