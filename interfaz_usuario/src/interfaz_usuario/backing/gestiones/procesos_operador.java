package interfaz_usuario.backing.gestiones;

import interfaz_usuario.util.JSFUtils;
import interfaz_usuario.util.utils;

import javax.faces.context.FacesContext;
import oracle.adf.view.faces.component.core.nav.CoreCommandLink;
import oracle.jbo.domain.Number;

public class procesos_operador {
    private CoreCommandLink cmdLnk_IdProceso;

    public procesos_operador() {
    }

    public String cmd_IdProceso_action() {
        
        //System.out.println("debug "+this.cmdLnk_IdProceso.getText());
        
        JSFUtils.setManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.procesoSelOpe",utils.getNumberOracle(this.cmdLnk_IdProceso.getText()));
        
        return "op_to_ing_nomina";
    }

    public String btn_crearProceso_action() {
        Object vIdProceso;
        vIdProceso=JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"crearProceso2");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"filtrarProceso");
        //System.out.println(vIdProceso);
        return null;
    }

    public void setCmdLnk_IdProceso(CoreCommandLink cmdLnk_IdProceso) {
        this.cmdLnk_IdProceso = cmdLnk_IdProceso;
    }

    public CoreCommandLink getCmdLnk_IdProceso() {
        return cmdLnk_IdProceso;
    }
}
