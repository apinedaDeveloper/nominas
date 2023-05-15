package interfaz_usuario.backing.procesos;

import enlace_datos.util.resulOp;

import interfaz_usuario.util.JSFUtils;
import interfaz_usuario.util.utils;

import javax.faces.context.FacesContext;

import oracle.adf.view.faces.component.core.layout.CoreShowDetailItem;

import oracle.adf.view.faces.event.LaunchEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class backing_bean_comun_procesos {
    private CoreShowDetailItem shwDetalle_calenprest;
    private CoreShowDetailItem shwHIstorico_calenprest;

    public backing_bean_comun_procesos() {
    }

    public String btn_commit_chequeDescartado_action() {
        BindingContainer vBnd_binding;
        OperationBinding operationBinding;
        vBnd_binding=(BindingContainer)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings}");
        operationBinding=vBnd_binding.getOperationBinding("Commit");
        operationBinding.execute();
        
        if (operationBinding.getErrors().isEmpty()){
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.estado1.inputValue}","0");
            utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Datos guardados correctamente."));            
        }
        return null;
    }

    public String btn_procesarRetencion() {
        Object vResultado,vPeriodo;
        resulOp vResul;
        
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pTipoP1.inputValue}","RETENCION");
        vPeriodo=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.pPeriodoCombo1.inputValue}");
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pPeriodo1.inputValue}",vPeriodo);
        
        vResultado=JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"procesosISR");
        
        
        
        if (vResultado!=null) {
            vResul=(resulOp)vResultado;            
            utils.setADFMensaje(vResul);                        
        }
        
        return null;
    }

    public String btn_procesar_devolucionISR() {

        Object vResultado; 
        resulOp vResul;
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pTipoP1.inputValue}","DEVOLUCION");        
        vResultado=JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"procesosISR");
        
        
        if (vResultado!=null) {
            vResul=(resulOp)vResultado;            
            utils.setADFMensaje(vResul);  
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"filtrarProcesosAnuales");
         
        }
        
        return null;
    }

    public String btnConciliacionISR() {
        Object vResultado; 
        resulOp vResul;
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pTipoP1.inputValue}","CONCILIACION");        
        vResultado=JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"procesosISR");
        
        
        if (vResultado!=null) {
            vResul=(resulOp)vResultado;            
            utils.setADFMensaje(vResul);                        
        }
        
        return null;
    }

    public String btn_cancelar_calenprest() {
    
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Rollback");
        
        this.shwHIstorico_calenprest.setDisclosed(true);
        this.shwDetalle_calenprest.setDisclosed(false);
        
        // Add event code here...
        return null;
    }

    public void setShwDetalle_calenprest(CoreShowDetailItem shwDetalle_calenprest) {
        this.shwDetalle_calenprest = shwDetalle_calenprest;
    }

    public CoreShowDetailItem getShwDetalle_calenprest() {
        return shwDetalle_calenprest;
    }

    public void setShwHIstorico_calenprest(CoreShowDetailItem shwHIstorico_calenprest) {
        this.shwHIstorico_calenprest = shwHIstorico_calenprest;
    }

    public CoreShowDetailItem getShwHIstorico_calenprest() {
        return shwHIstorico_calenprest;
    }

    public String btnCommit_calenPrest() {
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit")){
            
            utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Datos guardados exitosamente."));
        }
    
        // Add event code here...
        return null;
    }

    public String btn_crearNuevo_Calendar() {
        
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"crearCalenPrestamo")){
            
            this.shwHIstorico_calenprest.setDisclosed(false);
            this.shwDetalle_calenprest.setDisclosed(true);
            
        }
        
        return null;
    }

    public String cmd_calenPrest() {
    
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"PosicionaCalen")){
            
            this.shwHIstorico_calenprest.setDisclosed(false);
            this.shwDetalle_calenprest.setDisclosed(true);
            
        }
        
        // Add event code here...
        return null;
    }

    public String btn_aprob_isr() {
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"aplicarProySR")){
            
            utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Se ha cargado exitosamente la proyección ISR"));
            
        }
        return null;
    }

    public void launch_auto_proc_isr(LaunchEvent launchEvent) {
         Object vValor;        
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"setFila");
         
         vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdProceso.inputValue}");   
         launchEvent.getDialogParameters().put("IdProceso", vValor);
         launchEvent.getDialogParameters().put("IdGestionX", vValor); 
         launchEvent.getDialogParameters().put("Gestion", "PROC_NOMINA"); 
         launchEvent.getDialogParameters().put("RefreshVw", "Proceso"); 
         
        // System.out.println("debug "+ vValor);
         
         vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdEstadoProc.inputValue}");
         launchEvent.getDialogParameters().put("Estado", vValor); 
                 
         
         launchEvent.getDialogParameters().put("IdSolicitud", null); 
         launchEvent.getDialogParameters().put("IdContrato",null);
         launchEvent.getDialogParameters().put("IdAnexo",null);
         launchEvent.getDialogParameters().put("IdHoraExtra",null);
         
    }
}
