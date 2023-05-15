package interfaz_usuario.util;

import interfaz_usuario.usuario;

import javax.servlet.http.HttpSessionEvent;

import pkg_util_base_datos.interfaz_DB;

public class HttpSessionListener
implements javax.servlet.http.HttpSessionListener {
public HttpSessionListener() { }

public void sessionCreated(
HttpSessionEvent httpSessionEvent) { }

public void sessionDestroyed(
    HttpSessionEvent httpSessionEvent) { 
    try {
    
        usuario.set_opciones(usuario.LOGUOUT," ");
    }catch(Exception exep) {
    
    
        interfaz_DB vCone=new interfaz_DB();
        vCone.ejecutar_update("update bitacora_acceso set fecha_timeout=sysdate where id_bitacora="+httpSessionEvent.getSession().getAttribute("idBitacora"),true);
       // System.out.println(" session: "+httpSessionEvent.getSession().getAttribute("idBitacora"));
    
    
                            }

                                    }


}
