package enlace_datos.consultas.gestiones.complementos;

import enlace_datos.util.resulOp;

import interfaz_usuario.backing.util.util_dialog_adf;

import interfaz_usuario.util.JSFUtils;
import interfaz_usuario.util.utils;

import javax.faces.context.FacesContext;

import oracle.adf.view.faces.event.LaunchEvent;

import oracle.jbo.Row;
import oracle.jbo.uicli.binding.JUIteratorBinding;

public class reposicion_pago {
    public reposicion_pago() {
    }

    public String btn_procesar_reposicion() {

               
 if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Procesar_reposicion"))
 {
     JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"actualizaSubProgramaCompl"); 
     
     JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Commit"); 
     JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarDet");
     utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Calculo generado exitosamente"));
  }
             
             
  return null;

 }

    public String cmd_editar() {
         if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"setDetalleCompl"))
         {
         
             if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"cambiarEstadoTodos"))
             {
                 JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"cambiarEstadoActual");
                 
             }
           
         }         
        return null;
    }

    public String btn_agregaDesc() {
        // Add event code here...
        
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit")){
            
            if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"agregarDescuento")){                
                JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"EjecutarDesc");                
                JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"EjecutarDet");
                JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"posicionaSeleccionado");
            }
        }
        
        return null;
    }

    public String btn_eliminar_ajuste() {
        // Add event code here...
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"delDetAjuste")){
            JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"actualiza_desc_bono");
            JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit");
            JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"EjecutarDet");
            JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"posicionaSeleccionado");
            
        }
        
        return null;
    }

    public String btn_cancelar_edicion() {
        // Add event code here...
        JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"cambiarEstadoTodos");

        return null;
    }

    public String btn_guardar_datos() {
    
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit")){
            
            utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Datos Guardados exitosamente."));
        }
        
        return null;
    }

    public String cmd_borrar_det() {
            // Add event code here...
            if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"setDetalleCompl"))
            {
            
              if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"borrarDetComple")){
                  JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Commit");
                  utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Fila borrada exitosamente"));
                  
              }
              
            }
            
            return null;
        }

    public String bnt_mostrar_det_revRepo() {
        // Add event code here...
        
        if(JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"SetComple")){
        
            JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"CambiarEstadoTodos");
            JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"CambiarEstadoActual");  
           // JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"EjecutaComple");  
            JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"BuscarXIdComple");
            
        }
        
        return null;
    }

    public String btn_ocultar_det_revRepo() {
        // Add event code here...
         JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"CambiarEstadoTodos");
        return null;
    }

    public String cmd_ok_pago() {
        // Add event code here...
         Object pIdComple;
         
         if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"SetComple"))
         {
         /*
             pIdComple=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdComplemento.inputValue}");
             JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pIdVar1.inputValue}",pIdComple);
         */    
          
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"AutoComplemen");
         
            if(JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"CambiarActivo")){
                
                JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"EjecutarPend");
                utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Se ha autorizado el complemento"));
            }
             
             
         }
          

        return null;
    }

    public String cmdRefresh_action() {
    
       if(JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Execute")) 
       {
            JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"actualizarVW");
            
        }
        
        return null;
    }

    public void lauch_det(LaunchEvent launchEvent) {
        // Add event code here...
         util_dialog_adf vDialog= new util_dialog_adf();
         Object vVariable,vEstado;
         vVariable=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdComplemento.inputValue}");
         vEstado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdEstado.inputValue}");
         //        vDialog.abrir_dialogo_autorizacion(FacesContext.getCurrentInstance(),"LICENCIA",vVariable,vEstado,"licencia");
         
         
         vDialog.setParametros_dialogo_autorizacion(launchEvent,"COMPLEMENTOS",vVariable,vEstado,"Reposiciones");
         
        
        
    }
}
