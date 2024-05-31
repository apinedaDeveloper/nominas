package interfaz_usuario.backing.gestiones;

import enlace_datos.util.resulOp;

import interfaz_usuario.util.JSFUtils;

import interfaz_usuario.util.mailer;
import interfaz_usuario.util.utils;

import javax.faces.context.FacesContext;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.faces.component.core.input.CoreInputText;
import oracle.adf.view.faces.component.core.input.CoreSelectBooleanCheckbox;
import oracle.adf.view.faces.component.core.input.CoreSelectOneChoice;
import oracle.adf.view.faces.component.core.layout.CoreShowDetailItem;

public class backing_bean_gestiones_reintegro {
    private CoreShowDetailItem tab_hist;
    private CoreShowDetailItem tab_det_reint;
    private CoreInputText txtNumDoc;
    private CoreSelectOneChoice cmbTipoDoc;
    private CoreInputText txtObservaciones;
    private CoreSelectBooleanCheckbox checkGenTodos;

    public backing_bean_gestiones_reintegro() {
    }


    public void setTab_hist(CoreShowDetailItem tab_hist) {
        this.tab_hist = tab_hist;
    }

    public CoreShowDetailItem getTab_hist() {
        return tab_hist;
    }

    public void setTab_det_reint(CoreShowDetailItem tab_det_reint) {
        this.tab_det_reint = tab_det_reint;
    }

    public CoreShowDetailItem getTab_det_reint() {
        return tab_det_reint;
    }
    
    public String btn_generar_reintegro() {
        Object idNomina=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdNomina.inputValue}");
        Object idDoc=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdDocumentoBanco.inputValue}");
        Object pTodos=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.pTodos.inputValue}");        
        Object pNuevo=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.pNuevo1.inputValue}");
        Object pIdReintegro=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdReintegro.inputValue}");
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pObserva.inputValue}",this.getTxtObservaciones().getValue().toString());
        String vAuxTodos =pTodos.toString();
        String vAuxNuevo = pNuevo.toString();
        
        
        if(vAuxNuevo.equals("1")){
            pIdReintegro = null;
        }
        
        if(idDoc!=null){
            if(pTodos.toString().equals("0")){
                if(idNomina ==null){
                    utils.setADFMensaje(new resulOp(resulOp.OPE_WARN,"Debe seleccionar una fila"));
                }
                else{
                    JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pTodos.inputValue}",idNomina.toString());
                    
                    if(pIdReintegro==null){
                        if(JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"crearReintegro")){
                            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Confirmar");
                            pIdReintegro=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdReintegro.inputValue}");
                            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pNuevo1.inputValue}",pIdReintegro.toString());
                            if(JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"generaReintegro")){
                                //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"BusDetReint");
                                this.btn_cancelar();
                                utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Calculo generado exitosamente"));
                                vAuxNuevo="0";
                            } 
                        }
                    }
                    else{                        
                        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pNuevo1.inputValue}",pIdReintegro.toString());
                        if(JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"generaReintegro")){
                            //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"BusDetReint");
                            this.btn_cancelar();
                            utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Calculo generado exitosamente"));
                            vAuxNuevo="0";
                        }
                    }
                }
            }
            else{
                JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pTodos.inputValue}","0");
                if(pIdReintegro==null){                    
                    if(JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"crearReintegro")){
                        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Confirmar");
                        pIdReintegro=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdReintegro.inputValue}");
                        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pNuevo1.inputValue}",pIdReintegro.toString());
                        if(JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"generaReintegro")){
                            //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"BusDetReint");
                            this.btn_cancelar();
                            utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Calculo generado exitosamente"));
                            vAuxNuevo="0";
                        }
                    }
                }
                else{
                    JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pNuevo1.inputValue}",pIdReintegro.toString());
                    if(JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"generaReintegro")){
                        //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"BusDetReint");
                        this.btn_cancelar();
                        utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Calculo generado exitosamente"));
                        vAuxNuevo="0";
                    }
                }
            }
        }
        else{
            utils.setADFMensaje(new resulOp(resulOp.OPE_WARN,"Primero, debe buscar un numero de cheque o acreditamiento"));
        }        
        
        
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pNuevo1.inputValue}",vAuxNuevo);
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pTodos.inputValue}",vAuxTodos);                
                
        return null;
    }

    public String verReintegro() {
        
        Object pIdReint, pNumDoc, pIdTipoDoc, pObserva; 
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Rollback");    
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"setCurrentRowWithKey");
        //JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pNuevo1.inputValue}","0");
        pIdReint=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdReintegro.inputValue}");
        pNumDoc=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.NumDocFisico.inputValue}");
        pIdTipoDoc=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdTipoDocumento.inputValue}");
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.var_NumCheque1.inputValue}","");
        pObserva=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.Observaciones.inputValue}");
        this.getTxtObservaciones().setValue(pObserva);
        
        
        if(JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"ExecuteWithParams")){
            this.getTxtNumDoc().setValue(pNumDoc);
            this.getCmbTipoDoc().setValue(pIdTipoDoc);
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.var_NumCheque1.inputValue}",pNumDoc);
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.var_tipoDoc1.inputValue}",pIdTipoDoc);
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ExecuteWithParams");
        }
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pNuevo1.inputValue}",pIdReint.toString());
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"BusDetReint");
        
        //limpiando 
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pNuevo1.inputValue}","0");
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pTodos.inputValue}","0");
        this.checkGenTodos.setSelected(false);
        this.tab_hist.setDisclosed(false);
        this.tab_det_reint.setDisclosed(true);
        return null;
    }
    
    public String btn_nuevo_action() {
        // Add event code here...
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Rollback");        
        this.txtObservaciones.setValue("");
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.var_NumCheque1.inputValue}","");
        this.getTxtNumDoc().setValue("");
        
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ExecuteWithParams");
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pNuevo1.inputValue}","0");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"BusDetReint");
                
        //limpiando
        this.checkGenTodos.setSelected(true);
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pNuevo1.inputValue}","1");
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pTodos.inputValue}","1");
        this.tab_hist.setDisclosed(false);
        this.tab_det_reint.setDisclosed(true);
        
        return null;
    }
    
    public void selBolChbox(ValueChangeEvent value) {                
        if(value.getNewValue().toString().equals("true")){
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pTodos.inputValue}","1");            
        }
        else{
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pTodos.inputValue}","0");             
        }
        
        
    }

    public String cmd_eliminar_det() {

        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"setCurrentRowDetReint")){
            if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"borrarDetReintegro")){
                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Confirmar");
                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"actualizaTotalPagoReintegro");
                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Confirmar");
                Object pIdReintegro=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdReintegro.inputValue}");
                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"BuscarReintporFechas");            
                JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pNuevo1.inputValue}",pIdReintegro.toString()); 
                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"setCurrentRowWithKeyValue");             
                JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pNuevo1.inputValue}","0");
                utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Fila borrada exitosamente"));            
            }        
        }
        return null;
    }
    
    public String cmd_editar_detReint() {
        
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"setCurrentRowDetReint")){
            Object pIdDetalleReintegro=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdDetalleReintegro.inputValue}");
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.varIdDetReintegro1.inputValue}",utils.getNumberOracle(pIdDetalleReintegro));
            
            if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"cambiarEstadoTodos")){
                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"cambiarEstadoActual");
                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"BusDescReintegro");
            }           
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pHabilitar1.inputValue}","0");
        } 
        return null;
    }
    
    public String btn_guardar_reintegro() {
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.Observaciones.inputValue}",this.getTxtObservaciones().getValue().toString());
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Confirmar")){
           // JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"generarAutomaticoDesc");
            Object pIdReintegro=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdReintegro.inputValue}");
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pNuevo1.inputValue}",pIdReintegro.toString());  
            JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"BusDetReint");            
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"cambiarEstadoTodos");                                              
            JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"actualizaTotalPagoReintegro");
            this.btn_cancelar();
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pNuevo1.inputValue}","0");            
            utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Datos guardados exitosamente"));
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pHabilitar1.inputValue}","1");
        }
        return null;
    }
    
    public String btn_agregar_descuento() {
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Confirmar")){
             
            if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"agregarDescuento")){
                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"actualizaTotalPagoReintegro");
                Object pIdReintegro=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdReintegro.inputValue}");
                JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pNuevo1.inputValue}",pIdReintegro.toString());  
                JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"BusDetReint");
                
                this.cmd_editar_detReint();
                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"BuscarReintporFechas");                        
                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"setCurrentRowWithKeyValue");
                JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pNuevo1.inputValue}","0");
            }
        }
        return null;
    }
    
    public String cmd_eliminar_desc() {
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"delDetAjuste")){
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"actualiza_desc_bono");
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Confirmar");
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"actualizaTotalPagoReintegro");            
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"posicionaSeleccionado");            
            Object pIdReintegro=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdReintegro.inputValue}");
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"BuscarReintporFechas");            
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pNuevo1.inputValue}",pIdReintegro.toString()); 
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"setCurrentRowWithKeyValue");             
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pNuevo1.inputValue}","0"); 
        }
        return null;
    }
    
    public String btn_cancelar() {        
        Object pIdReintegro=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdReintegro.inputValue}");        
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Rollback");
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pNuevo1.inputValue}",pIdReintegro.toString()); 
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"setCurrentRowWithKeyValue");
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pNuevo1.inputValue}","0");
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pHabilitar1.inputValue}","1");
        this.verReintegro();
        return null;
    }
    
    public String cmd_refresh() {
        this.btn_cancelar();
        
        
        //Envio de correo automatico
        String from = "no-responder@usac.edu.gt";  // Para que no acepte mensajes de reenvio  utilizo esta cuenta.
        String toBCC= "notificacionsiif@usac.edu.gt"; //para que quede registro del envio utilizar una cuenta con copia oculta
         
        Object emailAnalista=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.EmailAnalista.inputValue}");
        Object emailEmpleado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.EmailEmpleado.inputValue}"); 
        Object ordenPago=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdOrdenPago.inputValue}");
        
        String to ="";
        if(ordenPago!=null){
            if(emailEmpleado!=null ){
                to = emailEmpleado.toString();
                
                String toCC= "";
                if(emailAnalista!=null){
                    toCC = emailAnalista.toString();
                }
                String cuerpo ="Estimado trabajador:\n"
                                            + "Usted tiene un reintegro, por favor ingrese al sitio https://siif.usac.edu.gt/Nomina, con su usuario y contraseña, seleccione la pestaña"
                                            + " INICIO y luego la opción de Reintegros.\n" + 
                            "Imprima la orden de pago ("+ordenPago.toString()+") y realice el pago en las agencias que se especifican.\n\n\n";
                            cuerpo = cuerpo+"Si tiene alguna duda sobre el Reintegro, consulte al Profesional de Recursos Humanos delegado en su Unidad."
                                    + "\n\nUNIVERSIDAD DE SAN CARLOS DE GUATEMALA\n" +"GESTIÓN AUTOMATIZADA DE SUELDOS\nID Y ENSEÑAD A TODOS\nPOR FAVOR NO RESPONDA A ESTE MAIL.";
                String asunto = "Reintegro de Sueldos y Prestaciones";
                mailer envioMail = new mailer();
                envioMail.SendMail(from, to, toCC, toBCC, asunto, cuerpo,true);
            }
            else{
                utils.setADFMensaje(new resulOp(resulOp.OPE_WARN,"El reintegro ha sido autorizado, pero no se le ha notificado al empleado debido a que no tiene correo registrado"));
            }
        }
        
        return null;
    }
    
    public void setTxtNumDoc(CoreInputText txtNumDoc) {
        this.txtNumDoc = txtNumDoc;
    }

    public CoreInputText getTxtNumDoc() {
        return txtNumDoc;
    }

    public void setCmbTipoDoc(CoreSelectOneChoice cmbTipoDoc) {
        this.cmbTipoDoc = cmbTipoDoc;
    }

    public CoreSelectOneChoice getCmbTipoDoc() {
        return cmbTipoDoc;
    }

    public void setTxtObservaciones(CoreInputText txtObservaciones) {
        this.txtObservaciones = txtObservaciones;
    }

    public CoreInputText getTxtObservaciones() {
        return txtObservaciones;
    }

    public void setCheckGenTodos(CoreSelectBooleanCheckbox checkGenTodos) {
        this.checkGenTodos = checkGenTodos;
    }

    public CoreSelectBooleanCheckbox getCheckGenTodos() {
        return checkGenTodos;
    }

    public String btn_AplicarDescAutoma() {
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Confirmar")){
            JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"generarAutomaticoDesc");
            Object pIdReintegro=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdReintegro.inputValue}");
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pNuevo1.inputValue}",pIdReintegro.toString());  
            JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"BusDetReint");            
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"cambiarEstadoTodos");                                              
            JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"actualizaTotalPagoReintegro");
            this.btn_cancelar();
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pNuevo1.inputValue}","0");            
            utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Datos guardados exitosamente"));
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pHabilitar1.inputValue}","1");
        }
        return null;
    }
}
