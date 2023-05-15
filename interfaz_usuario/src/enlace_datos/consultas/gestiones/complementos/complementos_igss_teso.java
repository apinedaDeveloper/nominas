package enlace_datos.consultas.gestiones.complementos;

import enlace_datos.util.resulOp;

import interfaz_usuario.backing.util.util_dialog_adf;

import interfaz_usuario.util.JSFUtils;
import interfaz_usuario.util.utils;

import javax.faces.context.FacesContext;

import oracle.adf.view.faces.component.core.layout.CoreShowDetailItem;

import oracle.adf.view.faces.event.LaunchEvent;
import oracle.adf.view.faces.event.ReturnEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.JboException;

public class complementos_igss_teso {
    private BindingContainer bindings;
    private CoreShowDetailItem tabHistorico;
    private CoreShowDetailItem tabNuevoComplemento;
    private CoreShowDetailItem tabEditarComplemento;

    public complementos_igss_teso() {
    }

    public BindingContainer getBindings() {
        return this.bindings;
    }

    public void setBindings(BindingContainer bindings) {
        this.bindings = bindings;
    }

    // visualizar detalle de autorizaciones
    public void launch_detalle_auto(LaunchEvent launchEvent) {
        // Add event code here...
         util_dialog_adf vDialog= new util_dialog_adf();
         Object vVariable,vEstado;
         vVariable=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdComplemento.inputValue}");
         vEstado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdEstado.inputValue}");
         //        vDialog.abrir_dialogo_autorizacion(FacesContext.getCurrentInstance(),"LICENCIA",vVariable,vEstado,"licencia");
         
         vDialog.setParametros_dialogo_autorizacion(launchEvent,"COMPLEMENTOS",vVariable,vEstado,"Pago Complemento");
        
    }


    // confirmar la operación de borrado de sis_complemento_igss
    public String confirmarBorrar(){
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit"))
        {
              utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Complemento borrado correctamente."));
              JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"actualizaSubProgramaCompl");
              JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Commit");
              //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ExecuteSisComplemento");
              
        }
        else{
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Rollback");
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"No fue posible borrar el complemento."));
        }

        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarSisCompIgss");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarSisCompDet");        
        
        return null;
    }

    public String commandLink_action() {
        Object pIdComple; 
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = 
            bindings.getOperationBinding("setCurrentRowWithKey");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        
        pIdComple=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdComplemento.inputValue}");
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pIdVar1.inputValue}",pIdComple);
        
        this.tabEditarComplemento.setDisclosed(true);
        this.tabNuevoComplemento.setDisclosed(false);
        this.tabHistorico.setDisclosed(false);
        
        return "setCurrentRowWithKey";
    }

    public void setTabHistorico(CoreShowDetailItem tabHistorico) {
        this.tabHistorico = tabHistorico;
    }

    public CoreShowDetailItem getTabHistorico() {
        return tabHistorico;
    }

    public void setTabNuevoComplemento(CoreShowDetailItem tabNuevoComplemento) {
        this.tabNuevoComplemento = tabNuevoComplemento;
    }

    public CoreShowDetailItem getTabNuevoComplemento() {
        return tabNuevoComplemento;
    }

/*
 *         if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"reprocesarComplementoIGSS"))
        {
        
          if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"borrarDetComple")){
              JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Commit");
              utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Fila borrada exitosamente"));
              
          }
          
        }
 */
    public String reprocesar_complemento() {
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"reprocesarComplementoIGSS"))
        {
              JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarSisCompIgss");
              JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"cambiarEstadoTodos");
              JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarSisCompDet");
              utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Complemento reprocesado."));
              
        }
        return null;
    }
    
    public String agregarComplemento(){
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"agregarComplementoIGSS"))
        {
              JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Commit");
              JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarSisCompIgss");
              JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"cambiarEstadoTodos");
              JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarSisCompDet");
              utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Proceso ejecutado, verifique que se haya incluido al personal suspendido en el mes seleccionado."));
              
        }
        return null;
    }

    public String crearComplementoIGSS() {
         if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"crearComplementoIGSS"))
         {
               JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ExecuteSisComplemento"); 
               JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"actualizaSubProgramaCompl");
               JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Commit");
               JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ExecuteSisComplemento"); 
               utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Se genero Complemento IGSS."));
               
               this.tabEditarComplemento.setDisclosed(true);
               this.tabHistorico.setDisclosed(false);
               this.tabNuevoComplemento.setDisclosed(false);
               
               Object pIdComple;
               pIdComple=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdComplemento.inputValue}");
               JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pIdVar1.inputValue}",pIdComple);
         }
         else{
             utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"No fue posible generar el complemento, es posible que no existan suspensiones IGSS para procesar."));
         }
        return null;
    }
    
    
    public String crearAjusteComplementoIGSS() {

        Object pIdComple;
        Object pModo = null;
        
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"setearCompleIgssEmpl");
        
        try{
            pModo=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.pModoAjuste.inputValue}");
        }
        catch(Exception e){
            String err = null;
        }
        if(pModo == null){
            utils.setADFMensaje(new resulOp(resulOp.OPE_WARN,"Debe indicar si el ajuste va a generar un nuevo complemento o se agregará al complemento seleccionado."));
            return null;
        }
        
        if(!(pModo.toString().compareToIgnoreCase("AGREGAR")==0 || pModo.toString().compareToIgnoreCase("NUEVO")==0)){
            utils.setADFMensaje(new resulOp(resulOp.OPE_WARN,"Debe indicar si el ajuste va a generar un nuevo complemento o se agregará al complemento seleccionado."));
            return null;
        }
        
        if(pModo.toString().compareToIgnoreCase("AGREGAR")==0){
            pIdComple=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdComplemento.inputValue}");
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pIdComplementoAjuste.inputValue}",pIdComple);
        }
        else{
            System.out.println("Entro al else");
            //pIdComple = null;
            //JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pIdComplementoAjuste.inputValue}",pIdComple);
        }
        
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"crearAjusteComplementoIGSS"))
        {
             if(pModo.toString().compareToIgnoreCase("NUEVO")==0){
                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ExecuteSisComplemento");
                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"actualizaSubProgramaCompl");
                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Commit");
             }
             
             // refrescar iteradores
             JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarSisCompIgss");
             JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"posicionaSeleccionado");                
             JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"EjecutarCompDetAjust");                
             JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"EjecutarSisCompDet");
             JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ubicarEnFilaAsociadaCompleDet");
             
             utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Se genero Complemento IGSS."));
               
             this.tabEditarComplemento.setDisclosed(true);
             this.tabHistorico.setDisclosed(false);
             this.tabNuevoComplemento.setDisclosed(false);
               
             pIdComple=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdComplemento.inputValue}");
             JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pIdVar1.inputValue}",pIdComple);
         }
         else{
             utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"No fue posible generar el complemento."));
         }
        return null;
    }    
    

    public String guardar() {
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit"))
        {
              utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Cambios guardados correctamente."));
              JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"cambiarEstadoTodos");
              JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarSisCompIgss");
              JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarSisCompDet");     
              JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarCompleDetAjustes");
        }
        else{
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"No fue posible guardar los cambios realizados."));
        }
        return null;
    }

    public String deshacer() {
        // Add event code here... 888
         if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Rollback"))
         {
             utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Cambios revertidos correctamente."));
             if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"ExecuteSisComplemento")){
                 JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"actualizarVW");
                 JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"cambiarEstadoTodos");
                 JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarSisCompIgss");
                 JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarSisCompDet");     
                 JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarCompleDetAjustes");
             }
               
             //this.tabHistorico.setDisclosed(true);
             //this.tabNuevoComplemento.setDisclosed(false);
         }
         else{
             utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"No fue posible deshacer los cambios realizados."));
         }
        return null;
    }


    public String verParametrosSuspIgss() {
        /*
         Object vIdContrato;
         util_dialog_adf vDialog;
         
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"filaActual");
         vIdContrato=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdContrato.inputValue}");
         if (vIdContrato!=null){
            vDialog= new util_dialog_adf();
            vDialog.abrir_dialogo(FacesContext.getCurrentInstance(),"/verreportepdf?id="+vIdContrato.toString()+"&rep=NOMBRAMIENTO");
         }
         else {
                utils.setADFMensaje(new resulOp(resulOp.OPE_WARN,"Seleccione un nombramiento"));          
                }
        */
         
        util_dialog_adf vDialog;
        vDialog= new util_dialog_adf();
        vDialog.abrir_dialogo(FacesContext.getCurrentInstance(),"/faces/gestiones/param_suspencion_igss.jspx");         
         
        return null;
    }

    public void returnAnulacionComple(ReturnEvent returnEvent) {
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ExecuteSisComplemento");
        this.tabHistorico.setDisclosed(true);
        this.tabNuevoComplemento.setDisclosed(false);
        this.tabEditarComplemento.setDisclosed(false);
        // Add event code here...
    }

    public void setTabEditarComplemento(CoreShowDetailItem tabEditarComplemento) {
        this.tabEditarComplemento = tabEditarComplemento;
    }

    public CoreShowDetailItem getTabEditarComplemento() {
        return tabEditarComplemento;
    }
    
    /* *** */
     public String cmd_editar() {
          if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"setCurrentRowCompleIgss"))
          {
          
              if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"cambiarEstadoTodos"))
              {
                  JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ubicarEnFilaAsociadaCompleDet");
                  JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"cambiarEstadoActual");
                  
              }
            
          }         
         return null;
     }


     public String btn_cancelar_edicion() {
         // Add event code here...
         if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit"))
         {
               utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Cambios guardados correctamente."));
               JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"cambiarEstadoTodos");
               JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarSisCompIgss");
               JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"posicionaSeleccionado");
               JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarSisCompDet");     
               JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarCompleDetAjustes");
         }
         else{
             utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"No fue posible guardar los cambios realizados."));
         }         

         return null;
     }    
     
    public String btn_agregaDesc() {
            // Add event code here...
            
            if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit")){
                
                if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"agregarDescuento")){
                
                    JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"registraModificacionEnDetalle");
                    JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit");
                    JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarSisCompIgss");
                    JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"posicionaSeleccionado");                
                    JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"EjecutarCompDetAjust");                
                    JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"EjecutarSisCompDet");
                    JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ubicarEnFilaAsociadaCompleDet");

                }
            }
            
            return null;
    }

    public String btn_eliminar_ajuste() {
            // Add event code here...
            if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"delDetAjuste")){
                if(JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"actualiza_desc_bono")){
                    JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"registraModificacionEnDetalle");
                    JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit");
                    JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarSisCompIgss");
                    JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"posicionaSeleccionado");                
                    JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"EjecutarSisCompDet");
                    JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"EjecutarCompDetAjust");
                    JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ubicarEnFilaAsociadaCompleDet");                    
                }
                else{
                        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Rollback"))
                        {
                            utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Ultimos cambios revertidos."));
                            if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"ExecuteSisComplemento")){
                                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"actualizarVW");
                                JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"cambiarEstadoTodos");
                                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarSisCompIgss");
                                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarSisCompDet");     
                                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarCompleDetAjustes");
                            }
                              
                        }
                }
                
            }
            else{
                if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Rollback"))
                {
                    utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Ultimos cambios revertidos."));
                    if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"ExecuteSisComplemento")){
                        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"actualizarVW");
                        JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"cambiarEstadoTodos");
                        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarSisCompIgss");
                        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarSisCompDet");     
                        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarCompleDetAjustes");
                    }
                      
                }
            }
            
            return null;
    }
    
    public String btn_guardar_en_detalle(){
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit"))
        {
              utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Cambios guardados correctamente."));
              JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarSisCompIgss");
              JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"posicionaSeleccionado");
              JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarSisCompDet");     
              JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarCompleDetAjustes");
              JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ubicarEnFilaAsociadaCompleDet");
        }
        else{
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"No fue posible guardar los cambios realizados."));
        }      
        
        return null;
    }
    
    public String cmdRefresh_action() {
    
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"ExecuteSisComplemento")){
            
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"actualizarVW");
        }
        // Add event code here...
        return null;
    }
}
