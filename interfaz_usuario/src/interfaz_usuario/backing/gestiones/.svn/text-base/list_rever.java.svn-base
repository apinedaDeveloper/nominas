package interfaz_usuario.backing.gestiones;

import enlace_datos.util.resulOp;

import interfaz_usuario.util.JSFUtils;

import interfaz_usuario.util.utils;

import javax.faces.context.FacesContext;

import pkg_util_base_datos.interfaz_DB;

public class list_rever {
    public list_rever() {
    }

    public String btn_ir_aReversion() {
        
        String vOutcome=null;
        
         if ( JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"setFilaList")){
                         
             vOutcome="det_rever";
             
         }
        
        return vOutcome;
    }
    
    public String btn_ir_aReversionComplemento() {
        
        String vOutcome=null;
        
         if ( JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"setFilaListComplementosCorregido")){
                         
             vOutcome="det_rever_complemento";
             
         }
        
        return vOutcome;
    }
    
    public String btn_ir_aReversionTiempoExtraordinario() {
        
        String vOutcome=null;
        
         if ( JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"setFilaListTiemposExtraordinarios")){
                         
             vOutcome="det_rever_tiempo_extraordinario";
             
         }
        
        return vOutcome;
    }

    public String btn_realizar_reversion() {
        String vOutcome=null;
        
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"reversar_gestion")){
         
         // JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Ejecutar");
            
          utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Se ha revertido la gestión exitosamente!."));
          
          vOutcome="rever_list";
          
        }
        
        return vOutcome;
    }
    
    //Función que retorna el id_proceso del complemento a revertir
    private Integer getIdProcesoComplemento(Number idComplemento){
        Integer idProceso = 0;
        String consulta;
        interfaz_DB interfaz = new interfaz_DB();
        consulta = "select nvl(id_proceso,0) as id from sis_complemento where id_complemento = " + idComplemento;
        Object auxconsul = interfaz.getValorConsultaSimple("id", consulta);
        interfaz.cn_Cerrar_coneccion();
        if (auxconsul!=null && Integer.valueOf(auxconsul.toString())>0){
            idProceso = Integer.valueOf(auxconsul.toString());
        }
        return idProceso;
    }
    
    private void revertir_complemento(){
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"revertir_gestion")){
            utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Se ha revertido la gestión exitosamente!"));
        } else {
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"No se ha revertido la gestión! Intente de nuevo."));
        }
    }
    
    public String btn_revertir_complemento() {
        String vOutcome=null;
        Object vObservacion, vIdComplemento;
        vObservacion=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.pObservacion.inputValue}");
        if (vObservacion == null || vObservacion.toString().trim()=="") {
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"No se ha ingresado un comentario!."));
        } else {
            vIdComplemento = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdComplemento.inputValue}");
            if (vIdComplemento != null) {
                Integer vIdProceso = getIdProcesoComplemento( Integer.valueOf(vIdComplemento.toString()));
                if (vIdProceso == null || vIdProceso <= 0) {
                    revertir_complemento();
                    vOutcome="rever_list";
                } else if (existProceso(vIdProceso)) {
                    if(IsItApproved(vIdProceso)) {
                        utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"No se puede revertir debido a que la nómina de pago con ID " + vIdProceso + " está APROBADO"));
                    } else {
                        revertir_complemento();
                        vOutcome="rever_list";
                    } 
                } else {
                    utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"No se pudo obtener el ID [" + vIdProceso + "] de la tabla PROCESO"));
                }
            } else {
                utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"No se pudo obtener el Id Complemento para realizar la reversion! Intente de nuevo."));
            }
        }
        return vOutcome;
    }
    
    /*//Función que retorna true o false dependiendo si el Tiempo Extraordinario tiene una autorización creada
    private boolean existsAutorizacion(Number idHoraExtra){
        boolean tiene = true; //valor inicial
        String consulta;
        interfaz_DB interfaz = new interfaz_DB();
        consulta = "select count(0) as cantidad from sis_autorizacion where id_hora_extra = " + idHoraExtra;
        Object auxconsul = interfaz.getValorConsultaSimple("cantidad", consulta);
        interfaz.cn_Cerrar_coneccion();
        if (auxconsul.toString().trim().equals("0")){
            tiene = false;
        } 
        return tiene;
    }
    
    //Función que retorna un número Id de autorización
    private Integer getIdAutorizacion(Number idHoraExtra){
        Integer idAutorizacion = 0; //valor inicial
        String consulta;
        interfaz_DB interfaz = new interfaz_DB();
        consulta = "select nvl(id_autorizacion,0) as id from sis_autorizacion where id_hora_extra = " + idHoraExtra;
        Object auxconsul = interfaz.getValorConsultaSimple("id", consulta);
        interfaz.cn_Cerrar_coneccion();
        if (auxconsul != null && Integer.valueOf(auxconsul.toString())>0){
            idAutorizacion = Integer.valueOf(auxconsul.toString());
        }
        return idAutorizacion;
    }*/
    
    //Función que retorna el id_proceso del tiempo extraordinario a revertir
    private Integer getIdProcesoTiempExtraordinario(Number idHoraExtra) {
        Integer idProceso = 0; //valor inicial
        String consulta;
        interfaz_DB interfaz =  new interfaz_DB();
        consulta = "select nvl(id_proceso,0) as id from sis_hora_extra where id_hora_extra = " + idHoraExtra;
        Object auxconsul = interfaz.getValorConsultaSimple("id", consulta);
        interfaz.cn_Cerrar_coneccion();
        if (auxconsul!=null && Integer.valueOf(auxconsul.toString())>0) {
            idProceso = Integer.valueOf(auxconsul.toString());
        }
        return idProceso;
    }
    
    //Función que retorna true o false dependiendo si el Id recibido existe en la tabla SIS_PROCESO
    private boolean existProceso(Number idProceso) {
        boolean existe = true; //valor inicial
        String consulta;
        interfaz_DB interfaz = new interfaz_DB();
        consulta = "select count(0) as cantidad from sis_proceso where id_proceso = " + idProceso;
        Object auxconsul = interfaz.getValorConsultaSimple("cantidad", consulta);
        interfaz.cn_Cerrar_coneccion();
        if (auxconsul.toString().trim().equals("0")){
            existe = false;
        } 
        return existe;
    }
    
    //Función que retorna true si una nómina de pago se encuentra APROBADO
    private boolean IsItApproved(Number idProceso){
        boolean aprobado = false; //valor inicial
        String consulta;
        interfaz_DB interfaz = new interfaz_DB();
        consulta = "select count(0) as cantidad from sis_proceso where id_proceso = " + idProceso +  " ";
        consulta += "and id_estado = 44";
        Object auxconsulta = interfaz.getValorConsultaSimple("cantidad", consulta);
        interfaz.cn_Cerrar_coneccion();
        if (auxconsulta.toString().trim().equals("1")) {
            aprobado = true;
        }
        return aprobado;
    }
    
    private void revertir_tiempo_extraordinario(){
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"revertir_gestion")){
            utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Se ha revertido la gestión exitosamente!"));
        } else {
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"No se ha revertido la gestión! Intente de nuevo."));
        }
    }
    
    public String btn_revertir_tiempo_extraordinario() {
        String vOutcome=null;
        Object vObservacion, vIdHoraExtra;
        vObservacion=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.pObservacion.inputValue}");
        if (vObservacion == null || vObservacion.toString().trim()=="") {
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"No se ha ingresado un comentario!."));
        } else {
            vIdHoraExtra = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdHoraExtra.inputValue}");
            Integer vProceso = getIdProcesoTiempExtraordinario(Integer.valueOf(vIdHoraExtra.toString()));
            if ( vProceso != null && vProceso > 0 ) {
                if ( existProceso(vProceso) ) {
                    if ( IsItApproved(vProceso) ) {
                        utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"No se puede revertir debido a que la nómina de pago con ID " + vProceso + " está APROBADO"));       
                    } else {
                        revertir_tiempo_extraordinario();       
                        vOutcome="rever_list";
                        //utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"La nómina de pago: " + vProceso + " no está APROBADO, se puede revertir"));       
                    }
                } else {
                    utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"El número de proceso de nómina: " + vProceso + " no existe en la tabla PROCESO"));    
                }
            } else {
                revertir_tiempo_extraordinario();       
                vOutcome="rever_list";
            }
        }
        return vOutcome;
    }
    
    /*public String btn_buscar_complemento() {
        Object vId;
        vId=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.pIdComplemento.inputValue}"); 
        if (vId != null && vId.toString().trim().equals("") == false){
           JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"filtrar_x_id");   
        }else{
           utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"No se escribió un ID Complemento!."));   
        }
        // Add event code here...
        return null;
    }*/
    
    public String btn_buscar_tiempo_extraordinario() {
        Object vId;
        vId=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.pIdHoraExtra.inputValue}"); 
        if (vId != null && vId.toString().trim().equals("") == false){
           //utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Se escribió un ID Tiempo Extraordinario correctamente!."));
           JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"filtrar_x_id_tiempo_extraordinario");   
        }else{
           utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"No se escribió un ID Tiempo Extraordinario!."));   
        }
        // Add event code here...
        return null;
    }

}
