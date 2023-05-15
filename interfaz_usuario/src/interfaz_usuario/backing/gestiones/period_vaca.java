package interfaz_usuario.backing.gestiones;

import enlace_datos.util.resulOp;

import interfaz_usuario.util.JSFUtils;

import interfaz_usuario.util.utils;

import javax.faces.context.FacesContext;

public class period_vaca {
    public period_vaca() {
    }

    public String btn_agregar() {
        
        JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"crear_fila");
        return null;
    }

    public String guardar() {
        
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit"))
        {
           utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Datos guardados exitosamente"));    
        }
        return null;
    }

    public String cancelar() {
        
        JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Rollback");
        
        return null;
    }
}
