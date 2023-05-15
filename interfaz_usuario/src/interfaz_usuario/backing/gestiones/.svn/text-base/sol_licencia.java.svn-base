package interfaz_usuario.backing.gestiones;

import enlace_datos.consultas.gestiones.SisDetplazaCubreLicVwImpl;
import enlace_datos.consultas.gestiones.SisLicenciasSinGoceVwRowImpl;
import enlace_datos.consultas.gestiones.contrato.plazasRowImpl;

import enlace_datos.consultas.gestiones.empleado.Sis_contratos_susp_igss_vwRowImpl;

import enlace_datos.util.resulOp;

import interfaz_usuario.backing.util.util_dialog_adf;

import interfaz_usuario.usuario;

import interfaz_usuario.util.JSFUtils;

import interfaz_usuario.util.utils;

import java.util.HashMap;
import java.util.Map;

import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import oracle.adf.view.faces.component.core.input.CoreInputHidden;

import oracle.adf.view.faces.component.core.layout.CorePanelHeader;
import oracle.adf.view.faces.component.core.output.CoreOutputFormatted;
import oracle.adf.view.faces.context.AdfFacesContext;

import oracle.adf.view.faces.event.AttributeChangeEvent;
import oracle.adf.view.faces.event.LaunchEvent;
import oracle.adf.view.faces.event.ReturnEvent;

import oracle.adfinternal.view.faces.model.binding.FacesCtrlRangeBinding;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class sol_licencia {
    private CoreInputHidden inp_hidden_mod_por;
    private CoreOutputFormatted det_lic_prorroga_label;
    private CorePanelHeader pnlMargen;
    private CorePanelHeader pnl_det_prorroga;

    public sol_licencia() {
    }


    public String btn_guardar() {
        
        resulOp vResultado=new resulOp();
        boolean vResultadoOp=false;
        
        Object fechaInicio = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.FechaInicio.inputValue}"); 
        Object añoActual = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{flujo_usuario.anioActual}"); 
        
        if (!utils.getFechaFormato3("yyyy",fechaInicio).equals(añoActual)){
            vResultado.setMensajeError("Verificar que la fecha de inicio sea del mismo año actual.");
            vResultado.setCodigoResultado(resulOp.OPE_ERROR);
            utils.setADFMensaje(vResultado);
        }
        else{
          
            if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit")){
            
                if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"actualizarEstado")){
    
                vResultado.setMensajeError("Datos guardados correctamente");
                vResultado.setCodigoResultado(resulOp.OPE_OK);
                utils.setADFMensaje(vResultado);
                usuario.set_opciones(usuario.VISTA_SOLICITUD,1);
                vResultadoOp=true;
                }
            }
        }
        if (vResultadoOp){
            return null;
        }else{
            return null;
        }
            
    }

    
    public String btn_adjuntarArch_action() {
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
          dialogParameters.put("IdSolicitud",JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdSolicitud.inputValue}").toString());
          dialogParameters.put("Opcion", 2);
          a.launchDialog(dialog,dialogParameters,null,true,windowProperties);
       //   System.out.println("salir");
         return null;
    }

    
    public void prueba_listener(ActionEvent actionEvent) {
        // Add event code here...
         System.out.println("sali3");
    }

    public String btn_autorizacion() {
         util_dialog_adf vDialog= new util_dialog_adf();
         Object vVariable,vEstado;
         vVariable=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdSolicitud.inputValue}");
         vEstado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdEstado.inputValue}");
         vDialog.abrir_dialogo_autorizacion(FacesContext.getCurrentInstance(),"LICENCIA",vVariable,vEstado,"licencia");
        return null;
    }

    public void autorizacion_return(ReturnEvent returnEvent) {
        //System.out.println("Ya sali autorizacion solicitud");
    }

    public void launch_sol_licencia_auto(LaunchEvent launchEvent) {
        util_dialog_adf vDialog= new util_dialog_adf();
                
        Object vVariable,vEstado,tipo_licencia;        
        tipo_licencia=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.TipoLicencia.inputValue}");
        
        if (tipo_licencia!=null)
        {
            vVariable=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdSolicitud.inputValue}");
            vEstado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdEstado.inputValue}");              
           
            if (tipo_licencia.equals("CS"))
              vDialog.setParametros_dialogo_autorizacion(launchEvent,"LICENCIA",vVariable,vEstado,"licencia");
            else
              vDialog.setParametros_dialogo_autorizacion(launchEvent,"LICENCIA SS",vVariable,vEstado,"licencia");
        }
        // Add event code here...
    }

    public String ver_licenciasHist() {
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"filtrarContrato");
        return "dialog:util_sel_lic";
    }

    public void lic_prorroga_return(ReturnEvent returnEvent) {
        SisLicenciasSinGoceVwRowImpl vFilaSel;
      
      if (returnEvent.getReturnValue()!=null){
            vFilaSel=(SisLicenciasSinGoceVwRowImpl)returnEvent.getReturnValue();
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.IdDetLicProrroga.inputValue}",vFilaSel.getIdDetLicencia());
            
      }   
 
    
    }

    public void setDet_lic_prorroga_label(CoreOutputFormatted det_lic_prorroga_label) {
        this.det_lic_prorroga_label = det_lic_prorroga_label;
    }

    public CoreOutputFormatted getDet_lic_prorroga_label() {
        return det_lic_prorroga_label;
    }

    
    public void setPnlMargen(CorePanelHeader pnlMargen) {
        this.pnlMargen = pnlMargen;
    }

    public CorePanelHeader getPnlMargen() {
        return pnlMargen;
    }

    public String cmdverMargenes() {
        // Add event code here...
         this.pnlMargen.setRendered(true);
        return null;
    }


    public void setPnl_det_prorroga(CorePanelHeader pnl_det_prorroga) {
        this.pnl_det_prorroga = pnl_det_prorroga;
    }

    public CorePanelHeader getPnl_det_prorroga() {
        return pnl_det_prorroga;
    }

    public String btn_agregar_prorroga() {
    
        this.pnl_det_prorroga.setRendered(true);
        // Add event code here...
        return null;
    }

    public void return_cubrelic(ReturnEvent returnEvent) {
        // Add event code here...
         Sis_contratos_susp_igss_vwRowImpl vFilaSel; 
         FacesCtrlRangeBinding vCubre;
         SisDetplazaCubreLicVwImpl vFilac=null;
         if (returnEvent.getReturnValue()!=null){
         
              vCubre=(FacesCtrlRangeBinding)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.SisDetLicenciaVwSisDetplazaCubreLicVw}");
              vFilaSel=(Sis_contratos_susp_igss_vwRowImpl)returnEvent.getReturnValue();            
              vFilac=(SisDetplazaCubreLicVwImpl )vCubre.getViewObject();
              vFilac.crearFila(vFilaSel.getIdContrato(),vFilaSel.getIdPartida(),vFilaSel.getIdPuesto(),vFilaSel.getNumeroPlaza(),vFilaSel.getCorrelativo(),vFilaSel.getRegistroEmpleado(),null);
               //JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.IdDetLicProrroga.inputValue}",vFilaSel.getIdDetLicencia());
               
         }   
        
    }

    public String cmd_borrar_detalle() {
        // Add event code here...
         Object vValor;
         
         vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.DescMotivoLicencia.inputValue}");
         
         if (vValor==null)
           vValor="";
         
         JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.DescMotivoLicencia.inputValue}",vValor.toString()+" ");
         
        return null;
    }
}
