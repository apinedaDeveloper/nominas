package interfaz_usuario.backing.util;

import interfaz_usuario.util.JSFUtils;

import interfaz_usuario.util.utils;

import java.util.HashMap;
import java.util.Map;

import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import oracle.adf.view.faces.context.AdfFacesContext;

public class dialog_autorizacion {
    public dialog_autorizacion() {
    }
    
    public void abrir_dialogo(FacesContext pContexto,String pGestion,Object pIdGestion){
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
            }
          dialogParameters.put("Gestion",pGestion); 
          a.launchDialog(dialog,dialogParameters,null,true,windowProperties);
                
    }
    
}
