package interfaz_usuario.backing.gestiones;

import enlace_datos.consultas.gestiones.revision.SisContratosPendientesRevRowImpl;

import enlace_datos.util.resulOp;

import interfaz_usuario.backing.util.dialog_autorizacion;

import interfaz_usuario.backing.util.util_dialog_adf;

import interfaz_usuario.usuario;

import interfaz_usuario.util.JSFUtils;
import interfaz_usuario.util.utils;

import javax.faces.context.FacesContext;

import oracle.adf.view.faces.component.core.data.CoreTable;
import oracle.adf.view.faces.component.core.nav.CoreCommandButton;
import oracle.adf.view.faces.component.core.nav.CoreCommandLink;
import oracle.adf.view.faces.context.AdfFacesContext;
import oracle.adf.view.faces.event.LaunchEvent;

import oracle.adf.view.faces.event.ReturnEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.uicli.binding.JUCtrlValueBindingRef;

public class rev_varNominaDesc {
    private CoreTable tbl_pendientes_rev;
    private CoreTable tbl_revisados;
    private CoreCommandButton btn_actualizar_tablas;

    public rev_varNominaDesc() {
    }


    public String autorizar_unPaso() {
        
        Object vIdVariacion,vDataTabla,vRegistro,vPlaza;
        String vOutCome;
        
        
        
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"setFilaActual")){
            
            if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"EjecutaEstadosVariacion")){
                
                
                vIdVariacion=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdVariacionNomina.inputValue}");
                vRegistro=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.RegistroEmpleado.inputValue}");
                vPlaza=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.NumeroPlaza.inputValue}");
                
                vDataTabla=this.getTbl_pendientes_rev().getSelectedRowData();

                 if (vIdVariacion==null || vDataTabla==null)
                  {
                       vOutCome=null;
                       utils.setADFMensaje(new resulOp(resulOp.OPE_WARN,"Seleccione un descuento"));   
                       
                   }else{
                       
                      if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"CambiarAutorizado")){
                          
                          JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"lstAjustesPendientes");
                          JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"lstAjustesRevisados");                          
                          AdfFacesContext.getCurrentInstance().partialUpdateNotify(this.btn_actualizar_tablas);
                          
                          utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Se ha cambiado el estado del descuento ID:"+vIdVariacion+ " a estado AUTORIZADO del Registro Empleado:"+vRegistro + " plaza:"+vPlaza));     
                          
                      }
                      
                           
                 }
                
                
            }
            
        }
        
        
        return null;
    }


    public String btn_autorizar_action() {
         Object IdVariacion,vDataTabla;
         String vOutCome;
         
         
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"setFilaActual");
        
         IdVariacion=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdVariacionNomina.inputValue}");
         vDataTabla=this.getTbl_pendientes_rev().getSelectedRowData();

            if (IdVariacion==null || vDataTabla==null)
                {
                vOutCome=null;
                utils.setADFMensaje(new resulOp(resulOp.OPE_WARN,"Seleccione un descuento"));   
                }else{
                    vOutCome="dialog:auto_sol";
                }

        return vOutCome;
    }

    public void btn_autorizar_launch(LaunchEvent launchEvent) {
        Object vIdVariacion,vEstado;
        util_dialog_adf vDialog;
        vIdVariacion=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdVariacionNomina.inputValue}");
        vEstado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdEstado.inputValue}");  
           if (vIdVariacion!=null){
               vDialog= new util_dialog_adf();
               vDialog.setParametros_dialogo_autorizacion(launchEvent,"VARIACION_NOM_DESC",vIdVariacion,vEstado,"Autorizacion");
               
           }
       
    }


    public void return_autoriza(ReturnEvent returnEvent) {
        // Add event code here...
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"lstAjustesPendientes");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"lstAjustesRevisados"); 
        //AdfFacesContext.getCurrentInstance().partialUpdateNotify(this.tbl_pendientes_rev);
        AdfFacesContext.getCurrentInstance().partialUpdateNotify(this.btn_actualizar_tablas);
        //System.out.println("salir");
                 
    }


/*
    public void return_desautoriza(ReturnEvent returnEvent) {
        // Add event code here...
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"actPendientes");         
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"actRevisados");         
        AdfFacesContext.getCurrentInstance().partialUpdateNotify(this.btn_actualizar_tabla_rev);         
                 
        //System.out.println("salir");         
    }

    public String btn_desautorizar_action() {
        Object vIdContrato,vDataTabla;
        String vOutCome;         
                  
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"filaActualRev");         
                 
        vIdContrato=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdContratoRev.inputValue}");
        vDataTabla=this.getTbl_revisados().getSelectedRowData();
        if (vIdContrato==null || vDataTabla==null)
        {
            vOutCome=null;
            utils.setADFMensaje(new resulOp(resulOp.OPE_WARN,"Seleccione un nombramiento"));   
        }else{
            vOutCome="dialog:auto_sol";
        }
        
        // System.out.println("autorizarrrrr");
        return vOutCome;         
    }

    public void btn_desautorizar_launch(LaunchEvent launchEvent) {
                 Object vIdContrato,vEstado;
                 util_dialog_adf vDialog;
                 vIdContrato=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdContratoRev.inputValue}");
                 vEstado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.EstatusRev.inputValue}");  
                    if (vIdContrato!=null){
                        vDialog= new util_dialog_adf();
                        vDialog.setParametros_dialogo_autorizacion(launchEvent,"NOMBRAMIENTO",vIdContrato,vEstado,"Autorizacion");
                       // vDialog.abrir_dialogo_autorizacion(FacesContext.getCurrentInstance(),"NOMBRAMIENTO",vIdContrato,vEstado,"Autorizacion"); 
                       
                     //  JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ContratosPendRev");
                        
                    }
                
    }
*/    

    public void setTbl_pendientes_rev(CoreTable tbl_pendientes_rev) {
        this.tbl_pendientes_rev = tbl_pendientes_rev;
    }

    public CoreTable getTbl_pendientes_rev() {
        return tbl_pendientes_rev;
    }


    public void setBtn_actualizar_tablas(CoreCommandButton btn_actualizar_tablas) {
        this.btn_actualizar_tablas = btn_actualizar_tablas;
    }

    public CoreCommandButton getBtn_actualizar_tablas() {
        return btn_actualizar_tablas;
    }


    public void setTbl_revisados(CoreTable tbl_revisados) {
        this.tbl_revisados = tbl_revisados;
    }

    public CoreTable getTbl_revisados() {
        return tbl_revisados;
    }

    /**
     *  Ejecuta los execute de cada tabla para refrescar los valores desplegados
     */
    public String actualizarTablas(){
    
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"lstAjustesPendientes");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"lstAjustesRevisados"); 
        return null;
        
    }

}
