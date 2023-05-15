package interfaz_usuario.backing.gestiones;

import enlace_datos.util.resulOp;

import interfaz_usuario.util.JSFUtils;

import interfaz_usuario.util.utils;

import javax.faces.context.FacesContext;

public class rev_promo_reclasificacion {
    public rev_promo_reclasificacion() {
    }

    public String alzar_nomina() {
        // Add event code here...
       if(JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"setCurrentRowWithKey")){
       
           if( JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"alzarPromocion")){
                //System.out.println("funciono");
                 utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Se ha alzado a nomina correctamente"));
           }
           /*else{
               System.out.println("No  funciono");
           }*/
       }
       
        return null;
    }
}
