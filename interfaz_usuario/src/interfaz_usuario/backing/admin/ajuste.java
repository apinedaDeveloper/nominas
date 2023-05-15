package interfaz_usuario.backing.admin;

import interfaz_usuario.util.JSFUtils;

import javax.faces.context.FacesContext;

import oracle.adf.view.faces.component.core.input.CoreInputHidden;
import oracle.adf.view.faces.component.core.input.CoreSelectOneChoice;

public class ajuste {
    private CoreSelectOneChoice cmb_tipo_ajuste;
    private CoreInputHidden inpt_modPor;

    public ajuste() {
    }

    public void setCmb_tipo_ajuste(CoreSelectOneChoice cmb_tipo_ajuste) {
        this.cmb_tipo_ajuste = cmb_tipo_ajuste;
    }

    public CoreSelectOneChoice getCmb_tipo_ajuste() {
        return cmb_tipo_ajuste;
    }

    public String btn_crear_action() {
        // Add event code here...
        this.cmb_tipo_ajuste.setDisabled(false);
        this.inpt_modPor.setValue(JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.selRegEmpleado_login"));
        return null;
    }

    public String btn_guardar_Action() {
        // Add event code here...
         this.cmb_tipo_ajuste.setDisabled(true);
        return null;
    }

    public String btn_descartar_action() {
        // Add event code here...
         this.cmb_tipo_ajuste.setDisabled(true);
        return null;
    }

    public String btn_actaPosesion_ant() {
        // Add event code here...
        return null;
    }

    public void setInpt_modPor(CoreInputHidden inpt_modPor) {
        this.inpt_modPor = inpt_modPor;
    }

    public CoreInputHidden getInpt_modPor() {
        return inpt_modPor;
    }
}
