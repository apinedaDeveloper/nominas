package interfaz_usuario;

import enlace_datos.util.resulOp;
import interfaz_usuario.util.JSFUtils;
import interfaz_usuario.util.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import oracle.adf.view.faces.component.core.input.CoreInputHidden;
import oracle.adf.view.faces.component.core.input.CoreInputText;
import oracle.adf.view.faces.component.core.input.CoreSelectOneChoice;
import oracle.adf.view.faces.component.core.layout.CoreShowDetailItem;
import oracle.adf.view.faces.component.core.nav.CoreCommandButton;
import oracle.adf.view.faces.context.AdfFacesContext;
import oracle.adf.view.faces.event.DisclosureEvent;
import oracle.adf.view.faces.event.LaunchEvent;
import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;
import oracle.jbo.uicli.binding.JUIteratorBinding;

public class backing_bean_comun {
    private CoreInputHidden inpt_hidden_creado_por;
    private CoreInputHidden inpt_hidden_creadoPor2;
    private CoreInputText inp_regEmpleadoBusqueda;
    private CoreCommandButton btn_commit_condicion_ordenJudicial;
    private BindingContainer bindings;
    private Object vResultadoEjecucion;
    private CoreCommandButton btnCrear_anexo;
    private CoreSelectOneChoice cmb_mun_judicial;
    private CoreShowDetailItem detailCantidad;
    private CoreShowDetailItem detailPorcentaje;
    private CoreCommandButton btn_autorizar_auto;
    private CoreInputText anio;
    private CoreInputText txthoras;

    public backing_bean_comun() {
    }

    public void setInpt_hidden_creado_por(CoreInputHidden inpt_hidden_creado_por) {
        this.inpt_hidden_creado_por = inpt_hidden_creado_por;
        this.inpt_hidden_creado_por.setValue(JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.selRegEmpleado_login"));
     // this.inpt_hidden_creado_por.getValue()
    }

    public CoreInputHidden getInpt_hidden_creado_por() {
        return inpt_hidden_creado_por;
    }
    
    public void actualizaCreadoPor(){
     if (this.inpt_hidden_creado_por!=null){
         this.inpt_hidden_creado_por.setValue(JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.selRegEmpleado_login"));
     }
    }

    public String btn_actualizaCreadoPor() {
        // Add event code here...
         if (this.inpt_hidden_creado_por!=null){
             this.inpt_hidden_creado_por.setValue(JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.selRegEmpleado_login"));
         }

        return null;
    }

    public void setInpt_hidden_creadoPor2(CoreInputHidden inpt_hidden_creadoPor2) {
        this.inpt_hidden_creadoPor2 = inpt_hidden_creadoPor2;
        this.inpt_hidden_creadoPor2.setValue(JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.selRegEmpleado_login"));
        
    }


    public String btn_actualizaCreadoPor2() {
        // Add event code here...
         if (this.inpt_hidden_creadoPor2!=null){
             this.inpt_hidden_creadoPor2.setValue(JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.selRegEmpleado_login"));
         }

        return null;
    }

    public CoreInputHidden getInpt_hidden_creadoPor2() {
        return inpt_hidden_creadoPor2;
    }

   
    public String btn_buscar_cheque_siguiente_action() {
        // Add event code here...
         String vOutcome=null;
        
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"verificar_doc_pago_Anular")){
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"CrearDocAnulado");
            vOutcome="anular";
        }
         //JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.SolicitadoPor.inputValue}",JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{sessionScope.selRegEmpleado}"));        
        return vOutcome;
    }

    public String btn_commit_mod_varia_nomina_action() {
         BindingContainer vBnd_binding;
         OperationBinding operationBinding;
         Object result;
         resulOp vResultado=new resulOp();
         boolean vResultadoOp=false;
         vBnd_binding=(BindingContainer)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings}");
         operationBinding=vBnd_binding.getOperationBinding("modificar_ajuste");
         result=operationBinding.execute();  
         if (!operationBinding.getErrors().isEmpty()){
             return null;
         }else{
             
             vResultado.setMensajeError("Datos modificados correctamente");
             vResultado.setCodigoResultado(resulOp.OPE_OK);
             utils.setADFMensaje(vResultado);
             return "buscar";
         }
         
    }

    public void setInp_regEmpleadoBusqueda(CoreInputText inp_regEmpleadoBusqueda) {
         Object vValor;
        
         vValor=inp_regEmpleadoBusqueda.getValue();
         this.inp_regEmpleadoBusqueda = inp_regEmpleadoBusqueda;
          if (vValor==null){
              vValor=JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.selRegEmpleado");      
              if (utils.getNumber(vValor)!=null&&utils.getNumber(vValor).longValue()>0) {
                this.inp_regEmpleadoBusqueda.setValue(vValor);      
              }
          }
        
        
    }

    public CoreInputText getInp_regEmpleadoBusqueda() {
        return inp_regEmpleadoBusqueda;
    }
 /*    public String btn_commit_orden_judicial_action() {
         BindingContainer vBnd_binding;
         OperationBinding operationBinding;
         Object result;
         resulOp vResultado=new resulOp();
         boolean vResultadoOp=false;
         vBnd_binding=(BindingContainer)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings}");
         operationBinding=vBnd_binding.getOperationBinding("Commit");
         result=operationBinding.execute();  
         if (!operationBinding.getErrors().isEmpty()){
             return null;
         }else{
             usuario.set_opciones(usuario.VISTA_ORDEN_JUDICIAL,1);
             return "condicion_judicial";
         }
    }*/

    //public String Btn_commit_condicion_ordenJudicial(CoreCommandButton btn_commit_condicion_ordenJudicial)
  /*  public String btn_commit_condicion_ordenJudicial() {
        BindingContainer vBnd_binding;
        OperationBinding operationBinding;
        Object result;
        resulOp vResultado=new resulOp();
        boolean vResultadoOp=false;
        vBnd_binding=(BindingContainer)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings}");
        operationBinding=vBnd_binding.getOperationBinding("Commit");
        result=operationBinding.execute();  
        if (!operationBinding.getErrors().isEmpty()){
            return null;
        }else{
           
            return "nueva_solicitud";
        }
    }*/

   /* public CoreCommandButton getBtn_commit_condicion_ordenJudicial() {
        return btn_commit_condicion_ordenJudicial;
    }
*/

    public BindingContainer getBindings() {
        return this.bindings;
    }

    public void setBindings(BindingContainer bindings) {
        this.bindings = bindings;
    }
   
    

    private boolean ejecutar_action(String pNombreAccion){
        BindingContainer vBnd_binding;
        OperationBinding operationBinding;
        vBnd_binding=(BindingContainer)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings}");
        operationBinding=vBnd_binding.getOperationBinding(pNombreAccion);
        vResultadoEjecucion=operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()){
            return false;
        }else{
           
            return true;
        }
    }

    public String btn_cambia_estado_autorizacion_action() {
       boolean vResultado;
       Object vRefrescar,vIdNuevoEstado;       
       resulOp vMensaResul=new resulOp();
       String vKeyRow;
       Object nomEstadoAumento;
       String vMensajeOperacion="Se ha cambiado el estado correctamente";
       
       this.getBtn_autorizar_auto().setDisabled(true);
       
       vResultado=ejecutar_action("CambiarEstadoGestion");
        if (vResultado==true){
         //  JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Commit");
            vRefrescar=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.RefrescarV.inputValue}");
            vIdNuevoEstado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.Estatus.inputValue}");                
           // vIdNuevoEstado=JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"processScope.Estado");
            JSFUtils.setManagedBeanValue(FacesContext.getCurrentInstance(),"processScope.Estado",vIdNuevoEstado);
                if (vRefrescar!=null){
                    if (vRefrescar.equals("Contrato")){
                    JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ActContrato");
                    
                   // System.out.println("voy autorizar un contrato");
                    }
                    else if (vRefrescar.equals("Autorizacion")){
                    System.out.println("autorizacion -> autorizacion");
                   // JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"actRevisados");
                   // JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"actPendientes"); 
                  
                    }
                    else if (vRefrescar.equals("licencia")){
                        
                        JUIteratorBinding vIterBinding;
                        vIterBinding=(JUIteratorBinding)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.SisSolicitudVwIterator}");
                        vKeyRow=vIterBinding.getCurrentRowKeyString();
                    //    System.out.println("autorizacion -> solicitud" + vIterBinding.getCurrentRowKeyString());
                        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"actSolicitud");
                        
                        if (vIterBinding.getCurrentRow()==null) {
                            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ConsultaSolicitud");
                            vIterBinding.setCurrentRowWithKey(vKeyRow);     
                        }else{
                          try{
                            vIterBinding.setCurrentRowWithKey(vKeyRow);  
                          }catch(Exception exp) {
                              exp.printStackTrace();
                          }
                        }
                       
                      //  System.out.println("autorizacion -> solicitud2" + vIterBinding.getCurrentRowKeyString());
                             
                    }
                       else if (vRefrescar.equals("aumentosal")){
                           System.out.println("autorizacion -> aumento Salarial"); 
                           ejecutar_action("actAumentoSal");
                           
                           nomEstadoAumento=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.NomEstadoAumento.inputValue}");
                            
                            if (nomEstadoAumento!=null && nomEstadoAumento.toString().equals("APROBADO")){
                              //  System.out.println("autorizacion -> aumento Salarial -> Realizando aumento ...."); 
                                  vResultado=ejecutar_action("RealizarAumentoSalarial");
                                if (vResultado){
                                    vMensajeOperacion="Se ha aplicado el aumento salarial correctamente.";
                                }
                                
                            }
                        
                           
                       }
                }
        
            vMensaResul.setMensajeError(vMensajeOperacion);
            vMensaResul.setCodigoResultado(resulOp.OPE_OK);
            utils.setADFMensaje(vMensaResul);
        }
        
      return null;  
    }   

    public String btn_enviarMensaje_redactar_mensaje_action() {
        boolean vResultado;
        String vOutcome=null;
        resulOp vMensaResul=new resulOp();
         
        vResultado=ejecutar_action("crear_mensaje");
         if (vResultado==true){
             
             if (vResultadoEjecucion!=null){
                 vMensaResul.setMensajeError("No se ha podido enviar el mensaje a los siguientes destinatarios:" +vResultadoEjecucion.toString());
                 vMensaResul.setCodigoResultado(resulOp.OPE_WARN);
                 utils.setADFMensaje(vMensaResul); 
                 vOutcome="lst_mensajes_recibidos_new";
                 
             }else {
                 vMensaResul.setMensajeError("Se ha enviado el mensaje");
                 vMensaResul.setCodigoResultado(resulOp.OPE_OK);
                 utils.setADFMensaje(vMensaResul);      
                 vOutcome="lst_mensajes_recibidos_new";
             }
             
             
         }   
        return vOutcome;
    }

    public String btn_adjuntar_archivo_solicitud() {
        FacesContext context = FacesContext.getCurrentInstance();  
         ViewHandler vh = context.getApplication().getViewHandler();  
           // el jspx que se mostrara en forma de  ventana emergente  
         UIViewRoot dialog = vh.createView(context, "/util/adjuntar_archivo.jspx");  
         AdfFacesContext a = AdfFacesContext.getCurrentInstance();  
           // fijamos el ancho y el alto de la ventana emergente  
          Map windowProperties = new HashMap();  
          windowProperties.put("width", new Integer(500));  
          windowProperties.put("height", new Integer(400));  
          //añadimos mas paremetros que seran recogidos en la jspx ventana  
          Map dialogParameters = new HashMap();  
          dialogParameters.put("IdSolicitud",JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdSolicitud.inputValue}").toString());
          dialogParameters.put("Opcion", 2);
          a.launchDialog(dialog,dialogParameters,null,true,windowProperties);
        return null;
    }
    
    public String btn_adjuntar_archivo_doc_solicitud() {
        FacesContext context = FacesContext.getCurrentInstance();  
         ViewHandler vh = context.getApplication().getViewHandler();  
           // el jspx que se mostrara en forma de  ventana emergente  
         UIViewRoot dialog = vh.createView(context, "/util/adjuntar_archivo_doc.jspx");  
         AdfFacesContext a = AdfFacesContext.getCurrentInstance();  
           // fijamos el ancho y el alto de la ventana emergente  
          Map windowProperties = new HashMap();  
          windowProperties.put("width", new Integer(500));  
          windowProperties.put("height", new Integer(400));  
          //añadimos mas paremetros que seran recogidos en la jspx ventana  
          Map dialogParameters = new HashMap();  
          dialogParameters.put("IdSolicitud",JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdSolicitud.inputValue}").toString());
          dialogParameters.put("Opcion", 7);
          a.launchDialog(dialog,dialogParameters,null,true,windowProperties);
        return null;
    }

    public String btn_grabar_suspencion_igss_action() {
        boolean vResultado;
        resulOp vMensaResul=new resulOp();
         
        vResultado=ejecutar_action("Commit");
         if (vResultado==true){
             usuario.set_opciones(usuario.VISTA_SUSP_IGSS,1);
             vMensaResul.setMensajeError("Datos de la suspension IGSS guardados correctamente");
             vMensaResul.setCodigoResultado(resulOp.OPE_OK);
             utils.setADFMensaje(vMensaResul);
         }
         
        return null;
    }
    
    public String btn_grabar_baja_laboral() { 
        boolean vResultado;
        resulOp vMensaResul=new resulOp();
        //JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.tipoSolicitud.inputValue}","BAJA SUPENCION LABORAL");
        
        vResultado=ejecutar_action("Commit");
         if (vResultado==true){
             usuario.set_opciones(usuario.VISTA_SUSP_LAB,1);
             vMensaResul.setMensajeError("Datos de la Baja Laboral guardados correctamente");
             vMensaResul.setCodigoResultado(resulOp.OPE_OK);
             utils.setADFMensaje(vMensaResul);
         }
         
        return null;
    }
    
    public String btn_commit_liquidacion_nomina() {
           // Add event code here...
           Object vValor;
           boolean vResultado;
           resulOp vMensaResul=new resulOp();
           String vOutcome=null;
          
     
          vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.CreadoPor.inputValue}");      
            
          if (vValor==null){
              vValor=JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.selRegEmpleado_login");    
              JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.CreadoPor.inputValue}" ,utils.getNumberOracle(vValor));
          }
          
          
          vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdProceso.inputValue}");  
          JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.IdProceso1.inputValue}" ,vValor);
           
           vResultado=ejecutar_action("Confirmar");
           
            if (vResultado==true){
               vMensaResul.setMensajeError("Nomina liquidada correctamente");
               vMensaResul.setCodigoResultado(resulOp.OPE_OK);
               utils.setADFMensaje(vMensaResul);
               vOutcome="ver_repLiquidacion";
            }else{
                
               vResultado=ejecutar_action("Rollback");
           }
           
           return vOutcome;
       }
/* metodo aplicado en la pagina /gestiones/anexo.jspx, en el boton crear para dar de bajas a plazas 
 * habilitando una creacion y la invocacion de los parametros para filtrar las unidades */
    /*public String bt_crearBajas_anexo() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = 
        bindings.getOperationBinding("Create1");
        Object result = operationBinding.execute();
        /*FiltraUnidad= accion que paso los parametros */
      /*  JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), "filtraUnidad");
     //   btnCrear_anexo.setDisabled(true);
        //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"filtraPartida");
        
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
       // btnCrear_anexo.setDisabled(true);
        return null;
    }*/
/* los siguientes 2 metodos son utilizados para controlar el estado del boton crear pagina anexo.jspx */
  /*public void setBtnCrear_anexo(CoreCommandButton btnCrear_anexo) {
        this.btnCrear_anexo = btnCrear_anexo;
    }

    public CoreCommandButton getBtnCrear_anexo() {
        return btnCrear_anexo;
    }*/


    public void btn_auto_launch_orden_judicial(LaunchEvent launchEvent) {
        Object vValor;
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdSolicitud.inputValue}");   
        launchEvent.getDialogParameters().put("IdSolicitud", vValor); 
        launchEvent.getDialogParameters().put("IdGestionX", vValor); 
        launchEvent.getDialogParameters().put("Gestion", "ORDENJUDICIAL"); 
        launchEvent.getDialogParameters().put("RefreshVw", "licencia"); 
        
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdEstado.inputValue}");
        launchEvent.getDialogParameters().put("Estado", vValor); 
                
        launchEvent.getDialogParameters().put("IdProceso", null); 
        launchEvent.getDialogParameters().put("IdContrato", null); 
        
    }


    public String btn_commit_alta_susp_igss() {
        boolean vResultado;
        resulOp vMensaResul=new resulOp();
         
        vResultado=ejecutar_action("Confirmar");
         if (vResultado==true){
             usuario.set_opciones(usuario.VISTA_SUSP_IGSS,1);
             vMensaResul.setMensajeError("Datos de la Alta suspensión IGSS guardados correctamente");
             vMensaResul.setCodigoResultado(resulOp.OPE_OK);
             utils.setADFMensaje(vMensaResul);
         }
         
        return null;
    }

    public void btn_auto_alta_susp_igss(LaunchEvent launchEvent) {
        Object vValor;
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdSolicitud.inputValue}");   
        launchEvent.getDialogParameters().put("IdSolicitud", vValor); 
        launchEvent.getDialogParameters().put("IdGestionX", vValor); 
        launchEvent.getDialogParameters().put("Gestion", "SUSP_IGSS"); 
        launchEvent.getDialogParameters().put("RefreshVw", "licencia"); 
        
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdEstado.inputValue}");
        launchEvent.getDialogParameters().put("Estado", vValor); 
                
        launchEvent.getDialogParameters().put("IdProceso", null); 
        launchEvent.getDialogParameters().put("IdContrato", null); 
    }

    public String btn_guardar_renuncias_action() {
        resulOp vMensaResul=new resulOp();
        int intGuardar = 1;
        
       Object vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.HorasBaja.inputValue}");     
       Object vcurrentSol = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{flujo_usuario.currentSol}");
        
        Object vTipoRenuncia = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), "#{bindings.atrdefaultTipoRenuncia.inputValue}");
        if (vTipoRenuncia == null){
            vTipoRenuncia = "RT";
        }
        Object fechaInicio = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.FechaSolicitud.inputValue}"); 
        Object añoActual = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{flujo_usuario.anioActual}"); 
        
            if (vTipoRenuncia.equals("RP") ){
            //cuando valor de horas a renunciar no esta vacio se convierte en tipo de licencia : RP (Renuncia Parcial), este tipo de licencia queda null en base de datos, solo es usada como referencia en programacion.
                if (vValor != null && !vValor.toString().equals("") && !vValor.toString().equals("0") ){ 
                    vValor = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.FechaSolicitud.inputValue}")
                    ; 
                    
                    if (!utils.getFechaFormato3("yyyy",fechaInicio).equals(añoActual)){
                        intGuardar = 0;
                        vMensaResul.setMensajeError("Verificar que la fecha de inicio sea del mismo año actual.");
                        vMensaResul.setCodigoResultado(resulOp.OPE_ERROR);
                        utils.setADFMensaje(vMensaResul);
                        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{flujo_usuario.currentSol}",vcurrentSol); 
                    }else{                        
                        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.FechaInicio.inputValue}",vValor);
                        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.tipoSolicitud.inputValue}","RENUNCIA PARCIAL");
                        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{flujo_usuario.currentSol}","RENUNCIA PARCIAL"); 
                        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.TipoLicencia.inputValue}","RP");
                        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.Prorroga.inputValue}","NO");
                    }
                }else{
                    intGuardar = 0;
                    vMensaResul.setMensajeError("Verificar el número de horas de baja.");
                    vMensaResul.setCodigoResultado(resulOp.OPE_ERROR);
                    utils.setADFMensaje(vMensaResul);
                    JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{flujo_usuario.currentSol}",vcurrentSol); 
                }
                
            }else if (vTipoRenuncia.equals("RT") ){
                JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.TipoLicencia.inputValue}","RT");
            }
            
       if (intGuardar == 1 && this.ejecutar_action("Commit")){
            vMensaResul.setMensajeError("Datos guardados correctamente");
            vMensaResul.setCodigoResultado(resulOp.OPE_OK);
            utils.setADFMensaje(vMensaResul);
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.atrBloquearRenunciaTotal.inputValue}","1");
       }else{
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{flujo_usuario.currentSol}",vcurrentSol); 
       }
        
        
        return null;     
    }

    public void btn_auto_renuncia(LaunchEvent launchEvent) {
        Object vValor;
        String vNombreSolicitud;
        
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdSolicitud.inputValue}");   
        vNombreSolicitud=(String)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{flujo_usuario.currentSol}");
        
        launchEvent.getDialogParameters().put("IdSolicitud", vValor); 
        launchEvent.getDialogParameters().put("IdGestionX", vValor); 
        
        if (vNombreSolicitud.equals("RENUNCIA") || vNombreSolicitud.equals("RENUNCIA PARCIAL"))
            launchEvent.getDialogParameters().put("Gestion", "RENUNCIA"); 
        else if (vNombreSolicitud.equals("DESPIDO"))
            launchEvent.getDialogParameters().put("Gestion", "DESPIDO");
        else if (vNombreSolicitud.equals("DECISION DE AUTORIDADES"))
            launchEvent.getDialogParameters().put("Gestion", "DECISION AUTORIDAD"); 
        
        launchEvent.getDialogParameters().put("RefreshVw", "licencia"); 
        
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdEstado.inputValue}");
        launchEvent.getDialogParameters().put("Estado", vValor); 
                
        launchEvent.getDialogParameters().put("IdProceso", null); 
        launchEvent.getDialogParameters().put("IdContrato", null);         
    }

    public String btn_commit_new_descuento_action() {
        resulOp vMensaResul=new resulOp();
        String vOutcome=null;
        Object vIdVaria;
        vIdVaria=JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"nuevo_ajuste");
        
        //if (this.ejecutar_action("nuevo_ajuste")){
        if (vIdVaria!=null)
        {
           JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pIdVar1.inputValue}",vIdVaria);
           vMensaResul.setMensajeError("Datos guardados correctamente");
           vMensaResul.setCodigoResultado(resulOp.OPE_OK);
           utils.setADFMensaje(vMensaResul);
           //vOutcome="lst_desc_empleado";
            vOutcome=null;
        }
        return vOutcome;
       
       
    }

    public String btn_commit_mod_descuentos_action() {
        resulOp vMensaResul=new resulOp();
        String vOutcome=null;
        
        Object vIdVaria;
        vIdVaria=JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"modificar_ajuste");
        
        
        if (vIdVaria!=null){
        
           JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pIdVariacion1.inputValue}",vIdVaria);
           vMensaResul.setMensajeError("Datos guardados exitosamente");
           vMensaResul.setCodigoResultado(resulOp.OPE_OK);
           utils.setADFMensaje(vMensaResul);
           //vOutcome="lst_desc_empleado";
        }
        return vOutcome;
    }

    public String btn_commit_renuncia_desc_action() {
        resulOp vMensaResul=new resulOp();
        String vOutcome=null;
        if (this.ejecutar_action("insertar_det_renuncia")){
           vMensaResul.setMensajeError("Datos modificados correctamente");
           vMensaResul.setCodigoResultado(resulOp.OPE_OK);
           utils.setADFMensaje(vMensaResul);
           vOutcome="lst_desc_empleado";
        }
        return vOutcome;
    }

    public String btn_cambios_igss_commit_action() {    
        resulOp vMensaResul=new resulOp();
        String vOutcome=null;
        if (this.ejecutar_action("cambiar_igss")){
           vMensaResul.setMensajeError("Datos modificados correctamente");
           vMensaResul.setCodigoResultado(resulOp.OPE_OK);
           utils.setADFMensaje(vMensaResul);
           vOutcome="lst_desc_empleado";
        }
        return vOutcome;
    }

    public String btn_adjuntar_arch_det_var_ajustes_action() {
        FacesContext context = FacesContext.getCurrentInstance();  
         ViewHandler vh = context.getApplication().getViewHandler();  
           // el jspx que se mostrara en forma de  ventana emergente  
         UIViewRoot dialog = vh.createView(context, "/util/adjuntar_archivo.jspx");  
         AdfFacesContext a = AdfFacesContext.getCurrentInstance();  
           // fijamos el ancho y el alto de la ventana emergente  
          Map windowProperties = new HashMap();  
          windowProperties.put("width", new Integer(450));  
          windowProperties.put("height", new Integer(350));  
          //añadimos mas paremetros que seran recogidos en la jspx ventana  
          Map dialogParameters = new HashMap();  
          dialogParameters.put("IdVariacionNom",JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdVariacionNomina1.inputValue}").toString());
          dialogParameters.put("Opcion", 4);
          a.launchDialog(dialog,dialogParameters,null,true,windowProperties);
          System.out.println("salir");
         return null;
    }

    public void btn_auto_cargo_deudores_launch(LaunchEvent launchEvent) {
        Object vValor;
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdSolicitud.inputValue}");   
        launchEvent.getDialogParameters().put("IdSolicitud", vValor); 
        launchEvent.getDialogParameters().put("IdGestionX", vValor); 
        launchEvent.getDialogParameters().put("Gestion", "LICENCIA"); 
        launchEvent.getDialogParameters().put("RefreshVw", "licencia"); 
        
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdEstado.inputValue}");
        launchEvent.getDialogParameters().put("Estado", vValor); 
                
        launchEvent.getDialogParameters().put("IdProceso", null); 
        launchEvent.getDialogParameters().put("IdContrato", null); 
    }

    public String btn_cargo_deudores_action() {
         resulOp vMensaResul=new resulOp();
         String vOutcome=null;
         if (this.ejecutar_action("Commit")){
            vMensaResul.setMensajeError("Datos guardados correctamente");
            vMensaResul.setCodigoResultado(resulOp.OPE_OK);
            utils.setADFMensaje(vMensaResul);
           // vOutcome="lst_empleado";
         }
         return vOutcome;
    }

    public String cmd_action_listaFormularios() {
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"setCurrentRowWithKey");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"setActualizaValResp");
        return "op_act_datos";
    }

    public String btn_commit_contrat029() {
        // Add event code here...
        return null;
    }

    public String btnCambiarAnio() {
        String vAnio;        
        vAnio=(String)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vAnio1.inputValue}");
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{flujo_usuario.anioActual}",vAnio);
        utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Se ha cambiado el año de trabajo."));
        
        return null;
    }
    
    public List<SelectItem> getListaComboAniosTrabajo()
    {
    
      return utils.crearListaComboAniosTrabajo();    
    }
    
    public List<SelectItem> getListaComboAniosAntTrabajo()
    {
        List<SelectItem> anios = utils.crearListaComboAniosTrabajo();
        List<SelectItem> aniosAux = new ArrayList<SelectItem>(anios.size()-1);
        for(int i=0;i<anios.size()-1;i++){
            aniosAux.add(anios.get(i));
        }
        return aniosAux;    
    }

    public String cmd_set_mensaje_recibidoNuevos() {
    
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{flujo_usuario.mensajesNuevos}","0");
        // Add event code here...
        return "ver_mensaje_entrante";
    }

    public void setBtn_autorizar_auto(CoreCommandButton btn_autorizar_auto) {
        this.btn_autorizar_auto = btn_autorizar_auto;
    }

    public CoreCommandButton getBtn_autorizar_auto() {
        return btn_autorizar_auto;
    }

    public void seleccionarMes(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
         if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue() ){                         
             int varanio;
             Calendar varFecha = Calendar.getInstance();
             varanio = varFecha.get(Calendar.YEAR);
             this.anio.setSubmittedValue(varanio);
             this.anio.setValue(varanio);
             
         }
    }

    public void setAnio(CoreInputText anio) {
        this.anio = anio;
    }

    public CoreInputText getAnio() {
        return anio;
    }
    
    public void settxtHoras(CoreInputText txthoras) {
        this.txthoras = txthoras;
    }

    public CoreInputText gettxtHoras() {
        return txthoras;
    }

    public void showDetailItem_disclosureListener(DisclosureEvent disclosureEvent) {
        // Add event code here...  
        
       
    }

    public void rdbtipoRenuncia_validator(FacesContext facesContext, 
                                          UIComponent uiComponent, 
                                          Object object) {
                                          
        System.out.println("------------------"); 
        Object vTipoRenuncia = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), "#{bindings.atrdefaultTipoRenuncia.inputValue}");
        this.txthoras.setDisabled(true);
        // Add event code here...
    }
}
