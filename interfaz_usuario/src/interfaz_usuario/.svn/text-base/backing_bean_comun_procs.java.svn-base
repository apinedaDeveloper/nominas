package interfaz_usuario;

import enlace_datos.util.resulOp;

import interfaz_usuario.util.JSFUtils;

import interfaz_usuario.util.utils;

import javax.faces.context.FacesContext;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.faces.event.AttributeChangeEvent;
import oracle.adf.view.faces.event.LaunchEvent;

import oracle.adf.view.faces.event.SelectionEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class backing_bean_comun_procs {
    Object vResultadoEjecucion ;
    public backing_bean_comun_procs() {
    }

    private boolean ejecutar_action(String pNombreAccion){
        BindingContainer vBnd_binding;
        OperationBinding operationBinding;
        vBnd_binding=(BindingContainer)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings}");
        operationBinding=vBnd_binding.getOperationBinding(pNombreAccion);
        vResultadoEjecucion=operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()){
            return false;
        }else{
           
            return true;
        }
    }

    public String cmd_link_listAumentoSal() {
        usuario.set_opciones(usuario.VISTA_PROC_AUMENTO_SAL,1);
        return "op_aumento_sal";
    }

    public String btn_commit_aumentoSalarial() {
        boolean vResultado;
        Object vValor;
        vResultado=ejecutar_action("Commit");
           if (vResultado==true){
               
               vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.actualizarEscalas.inputValue}");
               if (vValor!=null && vValor.equals(true)){
                   System.out.println("Actualizando escalas"); 
                   vResultado=ejecutar_action("Calcular_nuevas_Escalas"); 
                   ejecutar_action("ActEscalas");
                   JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.actualizarEscalas.inputValue}", false);
               }
               
               
               
                if (vResultado==true){
                   utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Datos Guardados Correctamente."));  
                }else{
                    utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Ha ocurrido un error, por favor revise los datos."));   
                }
           
           }
    return null;
    }

    public void launch_dialog_aumentoSalarial(LaunchEvent launchEvent) {
        Object vValor;
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdProceso.inputValue}");   
        
        System.out.println(FacesContext.getCurrentInstance().getExternalContext().isUserInRole("sis_clasificacion_puestos"));
        
        launchEvent.getDialogParameters().put("IdProceso", vValor); 
              
        launchEvent.getDialogParameters().put("IdGestionX", vValor); 
        launchEvent.getDialogParameters().put("Gestion", "AUMENTOSAL"); 
        launchEvent.getDialogParameters().put("RefreshVw", "aumentosal"); 
        
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdEstado.inputValue}");
        launchEvent.getDialogParameters().put("Estado", vValor); 
                
        launchEvent.getDialogParameters().put("IdSolicitud", null); 
        launchEvent.getDialogParameters().put("IdContrato", null); 
       
       
    }

    public String btn_commit_proceso_pago() {
       boolean vResultado=false;
       String vOutcome;
       
        vOutcome=null;
        // Si no hubo ningun error en la insercion se ejecuta el proceso
         vResultado=this.ejecutar_action("Commit");
        if (vResultado){
            Object vResultadoProceso;
            vResultadoProceso=JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"generar_pago");
            // Si el resultado no es nulo muestra el resultado de la operacion
            if (vResultadoProceso!=null){
               resulOp resultadoProceso=(resulOp)vResultadoProceso;
               if (resultadoProceso.getCodigoResultado()==resulOp.OPE_OK){
                   vOutcome="proc_nomina";
               }
               utils.setADFMensaje(vResultadoProceso);
            }   
            
        }
        return vOutcome;
    }


    public String btn_responder_msg() {
        Object vReply,vAsunto;
        // Add event code here...
        vReply=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdMensajeSal.inputValue}");
        
        if (vReply!=null){
            JSFUtils.setManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.replyMensaje",vReply.toString());
        }
         
        vAsunto=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.Asunto.inputValue}"); 
        
        if (vAsunto!=null)
        {
        
            JSFUtils.setManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.asunto","Re:"+vAsunto.toString());
        }
        
         
        return "nuevo_mensaje";
    }

    public String btn_guardar_param_action() {
    
    
       if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit"))
       {
           
          utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Datos guardados correctamente."));    
           
       }        
        return null;
    }

    public void launch_auto_proc_isr(LaunchEvent launchEvent) {
        // Add event code here...
    }

    public String btn_aplicar_aumento() {
        // Add event code here...
        Object vResult;
        
        vResult=JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"RealizarAumentoSalarial");
            
        if (vResult!=null){
            
            utils.setADFMensaje((resulOp)vResult);       
            
        }

        return null;
    }

    public String btn_recalc_Esc() {
        // Add event code here...
         boolean vResultado;
         Object vValor;

           vResultado=ejecutar_action("Calcular_nuevas_Escalas"); 
            ejecutar_action("ActEscalas");

            if (vResultado==true){            
                utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Se han recalculado las escalas"));              
            }else {
                utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Ha ocurrido un error por favor verifique"));              
            }
         
        
        return null;
    }
}
