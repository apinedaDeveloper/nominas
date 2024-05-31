package interfaz_usuario.backing.gestiones_postmortem;

import interfaz_usuario.usuario;

import interfaz_usuario.util.utils;

import oracle.adf.view.faces.component.core.nav.CoreCommandButton;

public class Listado_postmortems {

    private CoreCommandButton cmdButton_nuevaSolicitud;

    public void setCmdButton_nuevaSolicitud(CoreCommandButton cmdButton_nuevaSolicitud) {
        this.cmdButton_nuevaSolicitud = cmdButton_nuevaSolicitud;
    }

    public CoreCommandButton getCmdButton_nuevaSolicitud() {
        return cmdButton_nuevaSolicitud;
    }
    
    public String cmdLinkRegistroPersonal_action() {
        usuario.set_opciones(usuario.VISTA_OPERACION, utils.getInteger("2"));
        return "ir_a_detalle_postmortem";
    }

    public String cmdButton_nuevaSolicitud_action() {
        usuario.set_opciones(usuario.VISTA_OPERACION, utils.getInteger("1"));
        return "ir_a_detalle_postmortem";
    }
}
