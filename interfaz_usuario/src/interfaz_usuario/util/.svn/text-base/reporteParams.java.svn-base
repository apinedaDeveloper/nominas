package interfaz_usuario.util;


import java.util.HashMap;

import javax.faces.context.FacesContext;

public class reporteParams {
    public static final int AGREGAR_PARAMETROS=0;
    private HashMap vHmp_parametros;

    public reporteParams() {
        vHmp_parametros=new HashMap();
    }
    
    public void setParametrosReporte(HashMap pParametros){
        vHmp_parametros=pParametros;
    }
    
    public HashMap getParametrosReporte(){
        return this.vHmp_parametros;
    }
    
    
    public static void set_opciones(int pInt_opcion,Object pValor1){
         FacesContext ctx = FacesContext.getCurrentInstance();
         
         switch(pInt_opcion){
             case AGREGAR_PARAMETROS:
             JSFUtils.setManagedBeanValue(ctx,"param_reporte.parametrosReporte",(HashMap)pValor1);  
             break;
         }
    }
 
  public static HashMap getParametros(){
      FacesContext ctx = FacesContext.getCurrentInstance();
      return (HashMap)JSFUtils.getManagedBeanValue(ctx,"param_reporte.parametrosReporte");
  }
 
}
