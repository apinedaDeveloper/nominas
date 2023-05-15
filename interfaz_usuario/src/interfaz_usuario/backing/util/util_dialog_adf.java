package interfaz_usuario.backing.util;

import interfaz_usuario.util.utils;

import java.util.HashMap;
import java.util.Map;

import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import oracle.adf.view.faces.context.AdfFacesContext;
import oracle.adf.view.faces.event.LaunchEvent;

public class util_dialog_adf {
    public util_dialog_adf() {
    }
   
   /*
    * Metodo para abrir un dialogo modal para las autorizaciones
    */
    public void abrir_dialogo_autorizacion(FacesContext pContexto,String pGestion,Object pIdGestion,Object pEstado,String pActViewObjct){
       // FacesContext context = FacesContext.getCurrentInstance();  
         ViewHandler vh = pContexto.getApplication().getViewHandler();  
           // el jspx que se mostrara en forma de  ventana emergente  
         UIViewRoot dialog = vh.createView(pContexto, "/util/autorizacion.jspx");  
         AdfFacesContext a = AdfFacesContext.getCurrentInstance();  
           // fijamos el ancho y el alto de la ventana emergente  
          Map windowProperties = new HashMap();  
          windowProperties.put("width", new Integer(500));  
          windowProperties.put("height", new Integer(500));  
          //añadimos mas parametros que seran recogidos en la jspx ventana  
          Map dialogParameters = new HashMap();
            if (pGestion.equals("NOMBRAMIENTO")){
               dialogParameters.put("IdContrato",utils.getNumberOracle(pIdGestion));
               dialogParameters.put("IdProceso",null);
               dialogParameters.put("IdSolicitud",null);
               dialogParameters.put("IdAnexo",null);
                dialogParameters.put("IdHoraExtra",null);}
            else if (pGestion.equals("LICENCIA")){
                dialogParameters.put("IdSolicitud",utils.getNumberOracle(pIdGestion));
                dialogParameters.put("IdProceso",null);
                dialogParameters.put("IdContrato",null);
                dialogParameters.put("IdAnexo",null);
                dialogParameters.put("IdHoraExtra",null);
            }else if (pGestion.equals("PROC_NOMINA")){
                dialogParameters.put("IdSolicitud",null);
                dialogParameters.put("IdProceso",utils.getNumberOracle(pIdGestion));
                dialogParameters.put("IdContrato",null);
                dialogParameters.put("IdAnexo",null);
                dialogParameters.put("IdHoraExtra",null);
            }else if (pGestion.equals("ANEXO_A")){
                dialogParameters.put("IdSolicitud",null);
                dialogParameters.put("IdProceso",null);
                dialogParameters.put("IdContrato",null);
                dialogParameters.put("IdAnexo",utils.getNumberOracle(pIdGestion));
                dialogParameters.put("IdHoraExtra",null);
            }else if (pGestion.equals("TIEMPO_EXTRA")){
                dialogParameters.put("IdSolicitud",null);
                dialogParameters.put("IdProceso",null);
                dialogParameters.put("IdContrato",null);
                dialogParameters.put("IdAnexo",null);
                dialogParameters.put("IdHoraExtra",utils.getNumberOracle(pIdGestion));
            }else if (pGestion.equals("ANEXO_A_INVESTIGACION")){
                dialogParameters.put("IdSolicitud",null);
                dialogParameters.put("IdProceso",null);
                dialogParameters.put("IdContrato",null);
                dialogParameters.put("IdAnexo",utils.getNumberOracle(pIdGestion));
                dialogParameters.put("IdHoraExtra",null);
            }
            
            
          dialogParameters.put("IdGestionX",utils.getNumberOracle(pIdGestion)); 
          dialogParameters.put("Gestion",pGestion); 
          dialogParameters.put("Estado",utils.getNumberOracle(pEstado)); 
          dialogParameters.put("RefreshVw",pActViewObjct); 
          a.launchDialog(dialog,dialogParameters,null,true,windowProperties);
                
    }
    
    
    public void abrir_dialogo(FacesContext pContexto,String pURL){
       // FacesContext context = FacesContext.getCurrentInstance();  
         ViewHandler vh = pContexto.getApplication().getViewHandler();  
           // el jspx que se mostrara en forma de  ventana emergente  
         UIViewRoot dialog = vh.createView(pContexto, pURL);  
         AdfFacesContext a = AdfFacesContext.getCurrentInstance();  
           // fijamos el ancho y el alto de la ventana emergente  
          Map windowProperties = new HashMap();  
          windowProperties.put("width", new Integer(500));  
          windowProperties.put("height", new Integer(500));  
          //añadimos mas parametros que seran recogidos en la jspx ventana  
          Map dialogParameters = new HashMap();
          a.launchDialog(dialog,dialogParameters,null,true,windowProperties);
                
    }    
    
    
    
    /*
     * Metodo para poner parametros dialogo modal para las autorizaciones
     */
     public void setParametros_dialogo_autorizacion(LaunchEvent launchEvent,String pGestion,Object pIdGestion,Object pEstado,String pActViewObjct){ 
        
                launchEvent.getDialogParameters().put("IdGestionX", pIdGestion); 
                launchEvent.getDialogParameters().put("Gestion", pGestion); 
                launchEvent.getDialogParameters().put("RefreshVw", pActViewObjct); 
                launchEvent.getDialogParameters().put("Estado", pEstado); 

                if (pGestion.equals("NOMBRAMIENTO")){
                    launchEvent.getDialogParameters().put("IdProceso", null);                             
                    launchEvent.getDialogParameters().put("IdSolicitud", null); 
                    launchEvent.getDialogParameters().put("IdContrato",pIdGestion );
                    launchEvent.getDialogParameters().put("IdAnexo", null);
                    launchEvent.getDialogParameters().put("IdHoraExtra", null);
                    launchEvent.getDialogParameters().put("IdComplemento", null);
                    launchEvent.getDialogParameters().put("IdVariacionNomina", null);   
                }if (pGestion.equals("NOMBRAMIENTO029")){
                    launchEvent.getDialogParameters().put("IdProceso", null);                             
                    launchEvent.getDialogParameters().put("IdSolicitud", null); 
                    launchEvent.getDialogParameters().put("IdContrato",pIdGestion );
                    launchEvent.getDialogParameters().put("IdAnexo", null);
                    launchEvent.getDialogParameters().put("IdHoraExtra", null);
                    launchEvent.getDialogParameters().put("IdComplemento", null);
                    launchEvent.getDialogParameters().put("IdVariacionNomina", null);   
                }else if (pGestion.equals("LICENCIA") || pGestion.equals("LICENCIA SS")){
                    launchEvent.getDialogParameters().put("IdProceso", null);                             
                    launchEvent.getDialogParameters().put("IdSolicitud",pIdGestion); 
                    launchEvent.getDialogParameters().put("IdContrato",null); 
                    launchEvent.getDialogParameters().put("IdAnexo", null);
                    launchEvent.getDialogParameters().put("IdHoraExtra", null);
                    launchEvent.getDialogParameters().put("IdComplemento", null);
                    launchEvent.getDialogParameters().put("IdVariacionNomina", null);   
                }else if (pGestion.equals("PROC_NOMINA")){
                    launchEvent.getDialogParameters().put("IdProceso", pIdGestion);                             
                    launchEvent.getDialogParameters().put("IdSolicitud",null); 
                    launchEvent.getDialogParameters().put("IdContrato",null);
                    launchEvent.getDialogParameters().put("IdAnexo", null);
                    launchEvent.getDialogParameters().put("IdHoraExtra", null);
                    launchEvent.getDialogParameters().put("IdComplemento", null);
                    launchEvent.getDialogParameters().put("IdVariacionNomina", null);   
            }else if (pGestion.equals("ANEXO_A")){
                    launchEvent.getDialogParameters().put("IdProceso", null);                             
                    launchEvent.getDialogParameters().put("IdSolicitud",null); 
                    launchEvent.getDialogParameters().put("IdContrato",null);
                    launchEvent.getDialogParameters().put("IdAnexo", pIdGestion);
                    launchEvent.getDialogParameters().put("IdHoraExtra", null);
                    launchEvent.getDialogParameters().put("IdComplemento", null);
                    launchEvent.getDialogParameters().put("IdVariacionNomina", null);   
            }else if (pGestion.equals("TIEMPO_EXTRA")){
                    launchEvent.getDialogParameters().put("IdProceso", null);                             
                    launchEvent.getDialogParameters().put("IdSolicitud",null); 
                    launchEvent.getDialogParameters().put("IdContrato",null);
                    launchEvent.getDialogParameters().put("IdAnexo", null);
                    launchEvent.getDialogParameters().put("IdHoraExtra", pIdGestion);
                    launchEvent.getDialogParameters().put("IdComplemento", null);
                    launchEvent.getDialogParameters().put("IdVariacionNomina", null);   
            }else if (pGestion.equals("VARIACION_NOM_DESC")){
                    launchEvent.getDialogParameters().put("IdProceso", null);                             
                    launchEvent.getDialogParameters().put("IdSolicitud",null); 
                    launchEvent.getDialogParameters().put("IdContrato",null);
                    launchEvent.getDialogParameters().put("IdAnexo", null);
                    launchEvent.getDialogParameters().put("IdHoraExtra", null);
                    launchEvent.getDialogParameters().put("IdVariacionNomina", pIdGestion);
                    launchEvent.getDialogParameters().put("IdComplemento", null);
            }
             else if (pGestion.equals("COMPLEMENTOS")){
                    launchEvent.getDialogParameters().put("IdProceso", null);                             
                    launchEvent.getDialogParameters().put("IdSolicitud",null); 
                    launchEvent.getDialogParameters().put("IdContrato",null);
                    launchEvent.getDialogParameters().put("IdAnexo", null);
                    launchEvent.getDialogParameters().put("IdHoraExtra", null);
                    launchEvent.getDialogParameters().put("IdVariacionNomina", null);    
                    launchEvent.getDialogParameters().put("IdComplemento", pIdGestion);    
                    
            }
            
        
    }
    
}
