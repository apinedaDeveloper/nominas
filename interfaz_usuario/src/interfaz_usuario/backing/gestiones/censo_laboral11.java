package interfaz_usuario.backing.gestiones;

import enlace_datos.util.resulOp;

import interfaz_usuario.backing.util.Adjuntar_archivo;

import interfaz_usuario.backing.util.interrupcion_lab_TableHandler;

import interfaz_usuario.util.JSFUtils;
import interfaz_usuario.util.utils;

import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import oracle.adf.view.faces.component.core.data.CoreTable;
import oracle.adf.view.faces.component.core.input.CoreSelectBooleanCheckbox;
import oracle.adf.view.faces.component.core.input.CoreSelectOneChoice;
import oracle.adf.view.faces.component.core.layout.CorePanelForm;
import oracle.adf.view.faces.component.core.layout.CoreShowDetailItem;
import oracle.adf.view.faces.component.core.layout.CoreShowOneRadio;
import oracle.adf.view.faces.component.core.output.CoreMessages;
import oracle.adf.view.faces.context.AdfFacesContext;
import oracle.adf.view.faces.event.DisclosureEvent;
import oracle.adf.view.faces.event.LaunchEvent;
import oracle.adf.view.faces.event.ReturnEvent;
import oracle.adf.view.faces.util.LabeledFacesMessage;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.JboException;

public class censo_laboral11 {
    private CoreShowOneRadio shwOneRadio;

    public censo_laboral11() {
        vListaItemsCheck=utils.crearListaManyCheck("SisTipoJubiladoVwIterator","IdTipoJubilado","NombreTipjubilado");
    }

    private boolean vCambioNivelAcademico=false;
    private CoreSelectOneChoice cmb_institucionAca;
    private CoreSelectOneChoice cmb_NivelAcademico;
    private CoreTable tbl_archivos;
    private List<SelectItem> vListaItemsCheck;
    private CoreMessages outputMensajes;
    private CorePanelForm pnl_form1;
    private CoreSelectOneChoice cmb_munDirec;
    private CoreSelectOneChoice cmb_municipioCed;
    private CoreSelectOneChoice cmb_munDirecF;
    private CoreSelectBooleanCheckbox chk_cedula;
    private CoreSelectBooleanCheckbox chk_cui;
    private CoreSelectBooleanCheckbox chk_nit;
    private CoreSelectBooleanCheckbox chk_igss;


    public List<SelectItem> getListOfValuesCheck()
        {
            return vListaItemsCheck;
        }

    public boolean getCambioNivelAcademico(){
        return this.vCambioNivelAcademico;
    }


    public String btn_commit() {
   //     Object result;
        resulOp vResultado=new resulOp();
        List vResultado2;
        ficha_empleado_censo vDataPreguntas;
        interrupcion_lab_TableHandler vTabla1;
        vDataPreguntas=(ficha_empleado_censo)JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"ficha_empleado_censo");
        vDataPreguntas.actRespRadioShwn();
        vDataPreguntas.actRespTabla();
       
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.ptipoGest1.inputValue}","3"); 
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"setTipoGestion");
        
        
       if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"PrepararRespuestasCenso")){
           vResultado2=JSFUtils.EjecutarAcccion3(FacesContext.getCurrentInstance(),"Commit");   
           if (vResultado2.isEmpty()){
               vTabla1=(interrupcion_lab_TableHandler)JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"interrupcion_lab_TableHandler");
               vTabla1.resetTabla();
               //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"actFichaEmpleado");
               vDataPreguntas.setBajarRespuestas("1");
               //vDataPreguntas.set
               vResultado.setMensajeError("Datos guardados exitosamente.");    
               vResultado.setCodigoResultado(resulOp.OPE_OK);
               utils.setADFMensaje(vResultado); 
               
           }else{
               AgregarErroresControl(vResultado2);
               vDataPreguntas.setBajarRespuestas("1");
           }
           
       }
       
         
       /*
         BindingContainer vBnd_binding;
         OperationBinding operationBinding;
       
       
         boolean vResultadoOps=false;
         
        ficha_empleado_censo vficha;
         
        //ficha_empleado_censo
        
         vficha=(ficha_empleado_censo)JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"ficha_empleado_censo");
         
         vficha.actRespRadioShwn();
         
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"PrepararRespuestasCenso");
                                 
         vBnd_binding=(BindingContainer)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings}");
         operationBinding=vBnd_binding.getOperationBinding("Commit");
             
             try{
              result=operationBinding.execute();   
              
              if (operationBinding.getErrors().isEmpty()){
                 
                  JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"actFichaEmpleado");
                  vResultado.setMensajeError("Datos actualizados correctamente");    
                  vResultado.setCodigoResultado(resulOp.OPE_OK);
                  utils.setADFMensaje(vResultado); 
                  vResultadoOps=true;
                 // System.out.println("ok");
                  
              }else{ // Ocurrio algun error
               AgregarErroresControl(operationBinding.getErrors());
               //VerificarErrores();
               //utils.removeAllErrorADFLabelMessages();   
              }
              
             }catch(Exception exep){
                 exep.printStackTrace();
             }
        */
         return null;
         
    }

    public void AgregarErroresControl(List pErrores){
      int vCantidadErrores=pErrores.size();
      JboException vError;
      String vIdComponente;
      FacesMessage vMessage; 
        for (int vContador=0;vContador<vCantidadErrores;vContador++)
        {
                           
           if (pErrores.get(vContador).getClass()==JboException.class) {
               
                vError=(JboException)pErrores.get(vContador);
                vIdComponente= BuscarIdPaginaComponente(this.pnl_form1,vError.getErrorCode());
                             
                    if (vIdComponente!=null && !vIdComponente.equals("")){
                       //  System.out.println("Agregando a control");
                         vMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,vError.getMessage(),null);
                         FacesContext.getCurrentInstance().addMessage(vIdComponente,vMessage);       
                                                                         }
        
                                                                 }
          }
    }

    public String BuscarIdPaginaComponente(CorePanelForm pForma,String pIdComponente){
       Object vCompo; 
       String vId=null;
       vCompo=pForma.findComponent("inpt_"+pIdComponente.toLowerCase());
        if (vCompo==null){
            vCompo=pForma.findComponent("cmb_"+pIdComponente.toLowerCase());
        }
       
        if (vCompo==null){
            vCompo=pForma.findComponent("chk_"+pIdComponente.toLowerCase()); 
        }

       if (vCompo==null){
           vCompo=pForma.findComponent("sel_"+pIdComponente.toLowerCase());
       }
       
        if (vCompo==null && pIdComponente!=null && !pIdComponente.equals("")){
            vCompo=pForma.findComponent(pIdComponente.toLowerCase());
        }
        
        if (vCompo!=null){
           vId=utils.getNomControlCliente(vCompo);
        }
     
    return vId;
    }

    public void VerificarErrores(){
        FacesContext context = FacesContext.getCurrentInstance();
        Object vFila;
        Iterator<String> clients = context.getClientIdsWithMessages();
        String vIdComponente;
        
        FacesMessage vMessage; 
        while (clients.hasNext()) {
            String clientId = clients.next();
            Iterator messages = context.getMessages(clientId);        
            while (messages.hasNext()) {
            vFila=messages.next();
            
             if (vFila!=null && (clientId==null || (clientId!=null && clientId.equals(""))) &&vFila.getClass()==LabeledFacesMessage.class){
                
                 //vIdComponente=BuscarIdPaginaComponente(this.pnl_form1,)
                 
                 //vMessage.setLabel(((LabeledFacesMessage)vFila).getLabel());
                 
                  vIdComponente= BuscarIdPaginaComponente(this.pnl_form1,((LabeledFacesMessage)vFila).getLabel().toString());
                  if (vIdComponente!=null && !vIdComponente.equals("")){
                      vMessage = new FacesMessage(((LabeledFacesMessage)vFila).getSeverity(),((LabeledFacesMessage)vFila).getSummary(),null);
                      FacesContext.getCurrentInstance().addMessage(vIdComponente,vMessage);       
                    //  messages.remove();
                    //  System.out.println("Quitando");
                  }
                 
                 }else if(vFila!=null && clientId!=null && !clientId.equals("")&&vFila.getClass()==LabeledFacesMessage.class){
                      vMessage = new FacesMessage(((LabeledFacesMessage)vFila).getSeverity(),((LabeledFacesMessage)vFila).getSummary(),null);
                      FacesContext.getCurrentInstance().addMessage(clientId,vMessage);       
                     // messages.notify();
                    //  messages.remove();
                      
                      
                     // System.out.println("Quitando2");
                      break;
                  }
             
                }
        }
        
    }

    public void setCmb_institucionAca(CoreSelectOneChoice cmb_institucionAca) {
        this.cmb_institucionAca = cmb_institucionAca;
    }

    public CoreSelectOneChoice getCmb_institucionAca() {
        return cmb_institucionAca;
    }

    public void setCmb_NivelAcademico(CoreSelectOneChoice cmb_NivelAcademico) {
        this.cmb_NivelAcademico = cmb_NivelAcademico;
    }

    public CoreSelectOneChoice getCmb_NivelAcademico() {
        return cmb_NivelAcademico;
    }

    public void cmb_NivelAcademico_action(ValueChangeEvent valueChangeEvent) {
        
        if (!valueChangeEvent.getNewValue().toString().equals(valueChangeEvent.getOldValue().toString())){
            this.cmb_institucionAca.setSubmittedValue(0);
            this.vCambioNivelAcademico=true;
        }
        
    }

    /*
    *  PARA LA CONFRONTACION DE DATOS
    */
    public boolean verificarConfrontacionDatos(){
       
    String vValor;

    try{
       
          vValor=this.getChk_cedula().getText();
       if (vValor!=null){
          if ( this.getChk_cedula().isSelected()==false)
          {
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Por favor verifique el No. cédula"));
           return false;   
          }
       }
       
       vValor=this.getChk_cui().getText();       
       if (vValor!=null){
          if ( this.getChk_cui().isSelected()==false)
          {
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Por favor verifique el DPI"));
           return false;   
          }
       }
       
       vValor=this.getChk_nit().getText();       
       if (vValor!=null){
          if ( this.getChk_nit().isSelected()==false)
          {
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Por favor verifique el No. NIT"));
           return false;   
          }
       }

       
       vValor=this.getChk_igss().getText();       
       if (vValor!=null){
          if ( this.getChk_igss().isSelected()==false)
          {
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Por favor verifique el No. de afiliación al IGSS"));
           return false;   
          }
       }

    }catch(Exception exep)
    {
       return false;
    }

    return true;
    }

    public String btn_aprobar_action() {
        
        
        if (verificarConfrontacionDatos())
        {
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.Aprobado.inputValue}","SI");
        resulOp vResultado=new resulOp();
        boolean vResultadoOps=false;
                           
            try{
            
             if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit")){
                
                 vResultado.setMensajeError("Sistema nomina actualizado correctamente.");    
                 
                 vResultado.setCodigoResultado(resulOp.OPE_OK);
                 utils.setADFMensaje(vResultado); 
                 vResultadoOps=true;
                 
             }
             
            }catch(Exception exep){
                exep.printStackTrace();
            }
        }
        return null;
    }
    

    public void shw_item_otraIns_NO(DisclosureEvent disclosureEvent) {
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.OtroTrabajo.inputValue}","NO");
    }

    public void shw_item_otraIns_SI(DisclosureEvent disclosureEvent) {
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.OtroTrabajo.inputValue}","SI");
    }

    public void launch_archAdjunto(LaunchEvent launchEvent) {
         launchEvent.getDialogParameters().put("identificador",JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.RegistroEmpleado.inputValue}").toString());
         launchEvent.getDialogParameters().put("Opcion",3);
        
    }

    public void return_arch_adjunto(ReturnEvent returnEvent) {
       JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Execute");
    }

    public String btn_borrar_action() {
       
       Adjuntar_archivo vBorrado=new Adjuntar_archivo();
       String vNomArchivo;
       String vIdArchivoAdjunto;
       vNomArchivo=FacesContext.getCurrentInstance().getExternalContext().getInitParameter("DIRECTORIO_DOC_CONTRATO");
       
       vNomArchivo+=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{sessionScope.NomArchivo}").toString();
       vIdArchivoAdjunto=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{sessionScope.IdArchivoAdjunto}").toString();  
      
       if (vBorrado.eliminarArchivoAdjunto(vNomArchivo,vIdArchivoAdjunto,utils.getUsuario(),false)){
           JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Execute");
        //   System.out.println("actualizando borrado ");
       }
       
       //System.out.println("borrando " + vNomArchivo + "  ,  "  +vIdArchivoAdjunto);
       //vBorrado.eliminarArchivoAdjunto();
       
       return null;
    }

    public void setTbl_archivos(CoreTable tbl_archivos) {
        this.tbl_archivos = tbl_archivos;
    }

    public CoreTable getTbl_archivos() {
        return tbl_archivos;
    }

    public void setOutputMensajes(CoreMessages outputMensajes) {
        this.outputMensajes = outputMensajes;
    }

    public CoreMessages getOutputMensajes() {
        return outputMensajes;
    }

    public void setPnl_form1(CorePanelForm pnl_form1) {
        this.pnl_form1 = pnl_form1;
    }

    public CorePanelForm getPnl_form1() {
        return pnl_form1;
    }

    public void cmb_depDirec(ValueChangeEvent valueChangeEvent) {

     try
     {
        
        if (!valueChangeEvent.getNewValue().toString().equals(valueChangeEvent.getOldValue().toString()))
        {
            this.cmb_munDirec.setSubmittedValue(0);
            
        }
        
     }catch(Exception exep)
     {
         
     }
      
    }

    public void setCmb_munDirec(CoreSelectOneChoice cmb_munDirec) {
        this.cmb_munDirec = cmb_munDirec;
    }

    public CoreSelectOneChoice getCmb_munDirec() {
        return cmb_munDirec;
    }

    public void cmb_orden_departamento(ValueChangeEvent valueChangeEvent) 
    {
    
    //Object v[];
    
    try
    {
         if (valueChangeEvent.getNewValue()!=null && valueChangeEvent.getOldValue()!=null)
         {
           if (!valueChangeEvent.getNewValue().toString().equals(valueChangeEvent.getOldValue().toString()))
           {
                // this.cmb_municipioCed.setSubmittedValue(0);                      
           //     v=(Object [])JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.municipio_by_ordcedIterator.allRowsInRange}");
            //    System.out.println("debug" + v.length);                             
           }
         }    
          
    }catch(Exception exep) 
    {
        
    }
    }

    public void setCmb_municipioCed(CoreSelectOneChoice cmb_municipioCed) {
        this.cmb_municipioCed = cmb_municipioCed;
    }

    public CoreSelectOneChoice getCmb_municipioCed() {
        return cmb_municipioCed;
    }

    public void cmb_depDirecF(ValueChangeEvent valueChangeEvent) {
         try
         {
            
            if (!valueChangeEvent.getNewValue().toString().equals(valueChangeEvent.getOldValue().toString()))
            {
                this.cmb_munDirecF.setSubmittedValue(0);
                
            }
            
         }catch(Exception exep)
         {
             
         }
          
         }

    public void setCmb_munDirecF(CoreSelectOneChoice cmb_munDirecF) {
        this.cmb_munDirecF = cmb_munDirecF;
    }

    public CoreSelectOneChoice getCmb_munDirecF() {
        return cmb_munDirecF;
    }

    public void setChk_cedula(CoreSelectBooleanCheckbox chk_cedula) {
        this.chk_cedula = chk_cedula;
    }

    public CoreSelectBooleanCheckbox getChk_cedula() {
        return chk_cedula;
    }

    public void setChk_cui(CoreSelectBooleanCheckbox chk_cui) {
        this.chk_cui = chk_cui;
    }

    public CoreSelectBooleanCheckbox getChk_cui() {
        return chk_cui;
    }

    public void setChk_nit(CoreSelectBooleanCheckbox chk_nit) {
        this.chk_nit = chk_nit;
    }

    public CoreSelectBooleanCheckbox getChk_nit() {
        return chk_nit;
    }

    public void setChk_igss(CoreSelectBooleanCheckbox chk_igss) {
        this.chk_igss = chk_igss;
    }

    public CoreSelectBooleanCheckbox getChk_igss() {
        return chk_igss;
    }

    public String btn_rep_confC() {
       Object vFormulario;        
       vFormulario=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.NoFormulario.inputValue}") ;
       JSFUtils.storeOnSession(FacesContext.getCurrentInstance(),"pIdFormulario",vFormulario);
       return null;
    }

    public String btn_imprimir() {
        Object vFormulario;        
        vFormulario=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.NoFormulario.inputValue}") ;
        JSFUtils.storeOnSession(FacesContext.getCurrentInstance(),"pIdFormulario",vFormulario);
        return null;
    }

    public void setShwOneRadio(CoreShowOneRadio shwOneRadio) {
        this.shwOneRadio = shwOneRadio;
    }

    public CoreShowOneRadio getShwOneRadio() {
        return shwOneRadio;
    }

    public String btn_siguente_action() {
        // Add event code here...
        List vResultado2;
        ficha_empleado_censo vDataPreguntas;
        interrupcion_lab_TableHandler vTabla1;
        vDataPreguntas=(ficha_empleado_censo)JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"ficha_empleado_censo");
        
        vDataPreguntas.actRespRadioShwn();
        vDataPreguntas.actRespTabla();
        
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.ptipoGest1.inputValue}","2");               
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"setTipoGestion");

        
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"PrepararRespuestasCenso"))
        {
        
            vResultado2=JSFUtils.EjecutarAcccion3(FacesContext.getCurrentInstance(),"Commit");
            if (vResultado2.isEmpty()){
                
                JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.ptipoGest1.inputValue}","3");               
                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"setTipoGestion");
                
                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"nextGrupo");
                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Commit");
                
                JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.ptipoGest1.inputValue}","2");               
                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"setTipoGestion");
                
                vDataPreguntas=(ficha_empleado_censo)JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"ficha_empleado_censo");
                vDataPreguntas.EliminarPreguntas();
                vDataPreguntas.ResetearRespuestas();
                
                vTabla1=(interrupcion_lab_TableHandler)JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"interrupcion_lab_TableHandler");
                vTabla1.resetTabla();
                
                
                try{
                    
                    FacesContext.getCurrentInstance().getExternalContext().redirect("censo_laboral.jspx");    
                }catch(Exception exep){
                    
                    exep.printStackTrace();
                }
                
               //a=FacesContext.getCurrentInstance().getApplication().getViewHandler().createView(FacesContext.getCurrentInstance(),"");
               // FacesContext.getCurrentInstance().getApplication().setViewHandler(a);         
              }else{
                    AgregarErroresControl(vResultado2);
                    vDataPreguntas.setBajarRespuestas("1");
                   }
            
        }
        
        
        return null;
    }

    public String btn_resetear() {
    
        ficha_empleado_censo vDataPreguntas;
        interrupcion_lab_TableHandler vTabla1;
        
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"resetearBaseCenso"))
        {
        /*
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.ptipoGest1.inputValue}","3");               
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"setTipoGestion");
            
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"nextGrupo");
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Commit");
            
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.ptipoGest1.inputValue}","2");               
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"setTipoGestion");
            */
            vDataPreguntas=(ficha_empleado_censo)JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"ficha_empleado_censo");
            vDataPreguntas.EliminarPreguntas();
            vDataPreguntas.ResetearRespuestas();
            
            vTabla1=(interrupcion_lab_TableHandler)JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"interrupcion_lab_TableHandler");
            vTabla1.resetTabla();
            
            
            try{
                
                FacesContext.getCurrentInstance().getExternalContext().redirect("censo_laboral.jspx");    
            }catch(Exception exep){
                
                exep.printStackTrace();
            }
            
        }
        
        return null;
    }

    public String cmd_regEmpleado_CensoBusq() {
    
        ficha_empleado_censo vDataPreguntas;
        interrupcion_lab_TableHandler vTabla1;
        vDataPreguntas=(ficha_empleado_censo)JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"ficha_empleado_censo");
        vDataPreguntas.EliminarPreguntas();
        vDataPreguntas.ResetearRespuestas();
        
        vTabla1=(interrupcion_lab_TableHandler)JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"interrupcion_lab_TableHandler");
        vTabla1.resetTabla();

        
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"setCurrentRowWithKey");
        // JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"setActualizaValResp");
         
         JSFUtils.setManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.censoLaboralVista",1);
         
         return "gest_censoLaboral";
         
    }

    public String btn_nuevoCensoLab() {
        // Add event code here...
         ficha_empleado_censo vDataPreguntas;
         interrupcion_lab_TableHandler vTabla1;
         
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Rollback");
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"crearFichaCenso")){
            vDataPreguntas=(ficha_empleado_censo)JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"ficha_empleado_censo");
            vDataPreguntas.EliminarPreguntas();
            vDataPreguntas.ResetearRespuestas();
            
            vTabla1=(interrupcion_lab_TableHandler)JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"interrupcion_lab_TableHandler");
            vTabla1.resetTabla();

        
          JSFUtils.setManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.censoLaboralVista",1);
        return "gest_censoLaboral";
        }
        return null;
    }

    public String btn_buscar_censoBus() {
    
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Rollback");
        
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"buscarCensoPlanilla");
    
        return null;
    }
}
