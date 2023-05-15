package interfaz_usuario.backing.gestiones;

import interfaz_usuario.util.JSFUtils;

import javax.faces.context.FacesContext;

import oracle.adf.view.faces.event.LaunchEvent;

public class susp_igss {
    public susp_igss() {
    }

    public void autorizar_list_susp_igss(LaunchEvent launchEvent) {
      // ADFFacesContext.
     Object vValor;
     vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdSolicitud.inputValue}");   
     launchEvent.getDialogParameters().put("IdSolicitud", vValor); 
     launchEvent.getDialogParameters().put("IdGestionX", vValor); 
     launchEvent.getDialogParameters().put("Gestion", "SUSP_IGSS"); 
     launchEvent.getDialogParameters().put("RefreshVw", "licencia"); 
     
     vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdEstado.inputValue}");
     launchEvent.getDialogParameters().put("Estado", vValor); 
             
     launchEvent.getDialogParameters().put("IdProceso", null); 
     launchEvent.getDialogParameters().put("IdContrato", null); 
       
        
    }
    
    public void autorizar_list_susp_lab(LaunchEvent launchEvent) {
      // ADFFacesContext.
     Object vValor;
     vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdSolicitud.inputValue}");   
     launchEvent.getDialogParameters().put("IdSolicitud", vValor); 
     launchEvent.getDialogParameters().put("IdGestionX", vValor); 
     launchEvent.getDialogParameters().put("Gestion", "BAJASUPLABORAL"); 
     launchEvent.getDialogParameters().put("RefreshVw", "licencia"); 
     
     vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdEstado.inputValue}");
     launchEvent.getDialogParameters().put("Estado", vValor); 
             
     launchEvent.getDialogParameters().put("IdProceso", null); 
     launchEvent.getDialogParameters().put("IdContrato", null); 
       
        
    }
}
