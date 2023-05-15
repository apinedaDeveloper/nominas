package interfaz_usuario.backing.reportes;

import enlace_datos.util.resulOp;

import interfaz_usuario.servlets.verReporteExcel;

import interfaz_usuario.util.JSFUtils;

import interfaz_usuario.util.utils;

import java.util.ArrayList;

import javax.faces.context.FacesContext;

import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpServletRequest;


import javax.servlet.http.HttpServletResponse;

import oracle.adf.view.faces.component.core.input.CoreInputHidden;
import oracle.adf.view.faces.component.core.input.CoreInputText;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.domain.Date;

public class backing_bean_reportes {
    private BindingContainer bindings;
    private CoreInputText idProceso;
    private CoreInputText inpt_debug;
    private CoreInputHidden fechaFinalReporte = null;
    public boolean refresh = false;

    public backing_bean_reportes() {
    }

    public BindingContainer getBindings() {
        return this.bindings;
    }

    public void setBindings(BindingContainer bindings) {
        this.bindings = bindings;
    }

    public String btn_commit_rev_form22_action() {
        BindingContainer vBnd_binding;
        OperationBinding operationBinding;
        vBnd_binding=(BindingContainer)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings}");
        operationBinding=vBnd_binding.getOperationBinding("Commit");
        operationBinding.execute();
        
        if (operationBinding.getErrors().isEmpty()){
            utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Operación ejecutada correctamente"));
            
        }
    return null;
    }

    public String btn_rollback_revform22_action() {
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Rollback");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Reset");
       
        return null;
    }

    public String btn_generarsis_22_reppagos_anulados() {
        
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"generarSis_22")){
           JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Ejecutar") ;
           utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Se ha ejecutado correctamente la generación de SIS-22"));
        }
        
        return null;
    }

    public String cmd_reporte1_rep_por_dep_action() {
        // Add event code here...
         Object vValor;
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{Shuttle_Dep_histSal.selectedValues}");
         
         if (vValor!=null){
         //System.out.println(" seleccionados " + utils.getListaComas((ArrayList)vValor));
         JSFUtils.storeOnSession(FacesContext.getCurrentInstance(),"p1Dependencia",utils.getListaComas((ArrayList)vValor));
         
         }else{
             JSFUtils.storeOnSession(FacesContext.getCurrentInstance(),"p1Dependencia",null);    
         }
        
        return null;
    }

    public String cmdLinkRep2_rep_por_dep_action() {
        
        Object vValor;
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{Shuttle_Dep_histSal.selectedValues}");

        
        if (vValor!=null){
        //System.out.println(" seleccionados " + utils.getListaComas((ArrayList)vValor));
        JSFUtils.storeOnSession(FacesContext.getCurrentInstance(),"p1Dependencia",utils.getListaComas((ArrayList)vValor));
        
        }else{
            JSFUtils.storeOnSession(FacesContext.getCurrentInstance(),"p1Dependencia",null);    
        }
        
        return null;
    }

    public String btn_acreditamiento_final() {
        // Add event code here...
        HttpServletRequest vRequest=((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest());
        HttpServletResponse vResponse;
        Object vIdProceso;
         
        vResponse=(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
        
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"acreditamiento_final")){
            
        vIdProceso=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdProceso.inputValue}");
            
            
            verReporteExcel Excel;
            Excel = new verReporteExcel();
            try{
            
              vRequest.setAttribute("id",vIdProceso);
              vRequest.setAttribute("rep","ARCH_ACRE");  
              Excel.doGet(vRequest,vResponse);
            
            
            }catch(Exception exep){
                
                
            }
        }
        
        return null;
    }

    public String btn_gen_rep_nomina() {
        // Add event code here...
        preparar_reporte rep;
        rep=new preparar_reporte();
        Object vIdProceso,vTipoProceso;
        
        vIdProceso=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdProceso.inputValue}");        
        vTipoProceso=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.Tiponomina.inputValue}");
        if (vTipoProceso==null){
            vTipoProceso="NOM";
        }
        
        rep.preparar_nomina2(utils.getNumberOracle(vIdProceso),vTipoProceso.toString());
        
        return null;
    }

    public String btn_generar_cheques() {
        // Add event code here...
        preparar_reporte vRep=new preparar_reporte();
        
        vRep.generar_rep_pago2(utils.getNumberOracle(idProceso.getValue()));
        this. inpt_debug.setValue(vRep.getDebug());
        return null;
    }

    public void setIdProceso(CoreInputText idProceso) {
        this.idProceso = idProceso;
    }

    public CoreInputText getIdProceso() {
        return idProceso;
    }

    public void setInpt_debug(CoreInputText inpt_debug) {
        this.inpt_debug = inpt_debug;
    }

    public CoreInputText getInpt_debug() {
        return inpt_debug;
    }

    public String btn_autosis24_rep_rev() {
        // Add event code here...
        
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"SetFila")){
        
           if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"generarSis24"))
           {
              JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Ejecutar");
           
              utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Operación ejecutada exitosamente."));
               
           }
            
        }
        
        return null;
    }

    public String btn_guardar_remesa() {
        // Add event code here...
        
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit"))
        {        
            utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Operación ejecutada exitosamente."));
        }
        return null;
    }

    public String btn_procesarRemesa() {
        // Add event code here...
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"doRemesa"))
        {        
            utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Operación ejecutada exitosamente."));
        }
        return null;
    }

    public String btn_cambiarAnio() {
         String vAnio;        
         vAnio=(String)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vAnio1.inputValue}");
         JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{flujo_usuario.anioActual}",vAnio);
         //utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Se ha cambiado el año de trabajo."));         
        return null;
    }

    public void changeTipoReporte(ValueChangeEvent event) {
        refresh = true;
         if(event.getNewValue().equals("PROCCON_CHEQANUL")){   
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pTipoAtributo.inputValue}","1");            
        }
        else{
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pTipoAtributo.inputValue}","0");
        }
        
    }
    public void changeProceso(ValueChangeEvent event) {
        refresh = false;       
           /*
           Date fecha = (Date)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.FechaEmisionF.inputValue}");
           this.getFechaFinalReporte().setValue(fecha.toString());
           this.getFechaFinalReporte().setSubmittedValue(fecha.toString());
           System.out.println(event.getNewValue().toString());*/
    }
    
     public void setFechaFinalReporte(CoreInputHidden fechaFinalReporte) {
         this.fechaFinalReporte = fechaFinalReporte;
     }

     public CoreInputHidden getFechaFinalReporte() {
         if (fechaFinalReporte ==null){
             CoreInputHidden input = new CoreInputHidden();
             input.setValue("10/02/2012");
             input.setSubmittedValue("10/02/2012");
             this.setFechaFinalReporte(input);
         }
         return fechaFinalReporte;
     }

    public void setRefresh(boolean refresh) {
        this.refresh = refresh;
    }

    public boolean isRefresh() {
        return refresh;
    }
}
