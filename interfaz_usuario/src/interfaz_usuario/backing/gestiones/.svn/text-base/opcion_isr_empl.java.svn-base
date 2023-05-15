package interfaz_usuario.backing.gestiones;

import enlace_datos.util.resulOp;

import interfaz_usuario.util.JSFUtils;

import interfaz_usuario.util.utils;

import javax.faces.context.FacesContext;

public class opcion_isr_empl {
    public opcion_isr_empl() {
    }

    public String btn_agregar() {
        // Add event code here...        
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"AgregarDescuento"))
        {
            
        }
        return null;
    }

    public String btn_commit() {
    
         if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit"))
         {
            utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Datos guardados exitosamente")); 
             
         }
        return null;
    }
}
