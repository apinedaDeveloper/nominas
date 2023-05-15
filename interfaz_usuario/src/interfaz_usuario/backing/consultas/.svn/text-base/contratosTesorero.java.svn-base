package interfaz_usuario.backing.consultas;

import interfaz_usuario.util.JSFUtils;

import javax.faces.context.FacesContext;

import oracle.adf.view.faces.component.core.input.CoreSelectOneChoice;
import oracle.adf.view.faces.component.core.nav.CoreCommandButton;

public class contratosTesorero {
    private CoreSelectOneChoice cmb_estado;
    private CoreCommandButton btn_trasladar;

    public contratosTesorero() {
    }

    public String btn_filtrar() {
        // Add event code here...
        Object vEstado;
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"filtrarXEstado"))
        {
        
            vEstado=this.getCmb_estado().getValue();
            
            if (vEstado!=null && vEstado.toString().equals("3")) // Estado ingresado
            {
                this.getBtn_trasladar().setDisabled(false);
                
            }else {
                
                this.getBtn_trasladar().setDisabled(true);
            }
        }
        
        return null;
    }

    public void setCmb_estado(CoreSelectOneChoice cmb_estado) {
        this.cmb_estado = cmb_estado;
    }

    public CoreSelectOneChoice getCmb_estado() {
        return cmb_estado;
    }

    public void setBtn_trasladar(CoreCommandButton btn_trasladar) {
        this.btn_trasladar = btn_trasladar;
    }

    public CoreCommandButton getBtn_trasladar() {
        return btn_trasladar;
    }
}
