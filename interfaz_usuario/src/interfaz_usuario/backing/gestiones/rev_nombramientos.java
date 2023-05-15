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

public class rev_nombramientos {
    private CoreTable tbl_pendientes_rev;
    private CoreCommandButton btn_ver_nombramiento;
    private CoreCommandButton btn_actualizar_tablas;
    private CoreCommandLink cmdIdContrato;
    private CoreTable tbl_revisados;
    private CoreCommandButton btn_actualizar_tabla_rev;

    public rev_nombramientos() {
    }


    public String btn_ver_nombramiento() {
         Object vIdContrato;
         util_dialog_adf vDialog;
         
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"filaActual");
         
         vIdContrato=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdContrato.inputValue}");
        if (vIdContrato!=null){
            vDialog= new util_dialog_adf();
            vDialog.abrir_dialogo(FacesContext.getCurrentInstance(),"/verreportepdf?id="+vIdContrato.toString()+"&rep=NOMBRAMIENTO");
        }
        else {
                utils.setADFMensaje(new resulOp(resulOp.OPE_WARN,"Seleccione un nombramiento"));          
                }
        return null;
    }

    public String btn_autorizar_action() {
         Object vIdContrato,vDataTabla;
         String vOutCome;
         
         
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"filaActual");
        
         vIdContrato=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdContrato.inputValue}");
         vDataTabla=this.getTbl_pendientes_rev().getSelectedRowData();
         /*
            if (vIdContrato!=null){
                vDialog= new util_dialog_adf();
                //vDialog.setParametros_dialogo_autorizacion();
                vDialog.abrir_dialogo_autorizacion(FacesContext.getCurrentInstance(),"NOMBRAMIENTO",vIdContrato,vEstado,"Autorizacion"); 
            }
            else*/
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

    public String cmd_lnk_registroEmpleado_action() {
        
        Object vValor;   
        SisContratosPendientesRevRowImpl vFila;
        String vOutcome;
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.SisContratosPendientesRev_vw.currentRow}");
        if (vValor!=null){
            vFila=(SisContratosPendientesRevRowImpl)vValor;
             usuario.set_opciones(usuario.REG_EMPLEADO_REV_NOM,utils.getNumber(vFila.getRegistroEmpleado()));
             vOutcome="dialog:seg_contrato";
            
        }else{
            vOutcome="";
        }
        
       // System.out.println(vValor);
        
        return vOutcome;
    }

    public String cmd_idContrato_action() {
       
       
        return null;
    }

    public void id_contrato_launch(LaunchEvent launchEvent) {
        
        CoreCommandLink linkIdContrato;
        linkIdContrato=(CoreCommandLink)launchEvent.getComponent();
        launchEvent.getDialogParameters().put("IdContrato",utils.getNumberOracle(linkIdContrato.getText()));
    }

    public void btn_autorizar_launch(LaunchEvent launchEvent) {
        Object vIdContrato,vEstado;
        util_dialog_adf vDialog;
        vIdContrato=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdContrato.inputValue}");
        vEstado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.Estatus.inputValue}");  
           if (vIdContrato!=null){
               vDialog= new util_dialog_adf();
               vDialog.setParametros_dialogo_autorizacion(launchEvent,"NOMBRAMIENTO",vIdContrato,vEstado,"Autorizacion");
              // vDialog.abrir_dialogo_autorizacion(FacesContext.getCurrentInstance(),"NOMBRAMIENTO",vIdContrato,vEstado,"Autorizacion"); 
              
            //  JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ContratosPendRev");
               
           }
       
    }

    public void return_desautoriza(ReturnEvent returnEvent) {
        // Add event code here...
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"actPendientes"); 
        
        //lo cambie habilitarlo al revisar
        //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"actRevisados");         
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

    public void setTbl_pendientes_rev(CoreTable tbl_pendientes_rev) {
        this.tbl_pendientes_rev = tbl_pendientes_rev;
    }

    public CoreTable getTbl_pendientes_rev() {
        return tbl_pendientes_rev;
    }

    public void return_autoriza(ReturnEvent returnEvent) {
        // Add event code here...
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"actPendientes");
        //lo cambie habilitarlo al revisar
        //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"actRevisados");
        
        // este noo  AdfFacesContext.getCurrentInstance().partialUpdateNotify(this.tbl_pendientes_rev);
        AdfFacesContext.getCurrentInstance().partialUpdateNotify(this.btn_actualizar_tablas);
        
        System.out.println("salir");
        
    }

    public void setBtn_ver_nombramiento(CoreCommandButton btn_ver_nombramiento) {
        this.btn_ver_nombramiento = btn_ver_nombramiento;
    }

    public CoreCommandButton getBtn_ver_nombramiento() {
        return btn_ver_nombramiento;
    }

    public void setBtn_actualizar_tablas(CoreCommandButton btn_actualizar_tablas) {
        this.btn_actualizar_tablas = btn_actualizar_tablas;
    }

    public CoreCommandButton getBtn_actualizar_tablas() {
        return btn_actualizar_tablas;
    }

    public String cmd_IdContrato() {
         Object vIdContrato;
         util_dialog_adf vDialog;
         
              
         vIdContrato=this.cmdIdContrato.getText();
         if (vIdContrato!=null){
            vDialog= new util_dialog_adf();
            vDialog.abrir_dialogo(FacesContext.getCurrentInstance(),"/verreportepdf?id="+vIdContrato.toString()+"&rep=NOMBRAMIENTO");
         }
         else {
                utils.setADFMensaje(new resulOp(resulOp.OPE_WARN,"Seleccione un nombramiento"));          
                }
        return null;
    }

    public void setCmdIdContrato(CoreCommandLink cmdIdContrato) {
        this.cmdIdContrato = cmdIdContrato;
    }

    public CoreCommandLink getCmdIdContrato() {
        return cmdIdContrato;
    }

    public String autorizar_unPaso() {
        
        Object vIdContrato,vDataTabla,vRegistro,vPlaza;
        String vOutCome;
        
        
        
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"filaActual")){
            
            if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"EjecutaEstadosContrato")){
                
                
                vIdContrato=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdContrato.inputValue}");
                vRegistro=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.RegistroEmpleado.inputValue}");
                vPlaza=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.NumeroPlaza.inputValue}");
                
                vDataTabla=this.getTbl_pendientes_rev().getSelectedRowData();

                 if (vIdContrato==null || vDataTabla==null)
                  {
                       vOutCome=null;
                       utils.setADFMensaje(new resulOp(resulOp.OPE_WARN,"Seleccione un nombramiento"));   
                       
                   }else{
                       
                      if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"CambiarActivo")){
                          
                          JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"actPendientes");
                          // cambio habilitarlo al revisar 
                         // JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"actRevisados");                          
                          AdfFacesContext.getCurrentInstance().partialUpdateNotify(this.btn_actualizar_tablas);
                          
                          utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Se ha cambiado el estado del contrato ID:"+vIdContrato+ " a estado ACTIVO del Registro Empleado:"+vRegistro + " plaza:"+vPlaza));     
                          
                      }
                      
                           
                 }
                
                
            }
            
        }
        
        
        return null;
    }

    public void setTbl_revisados(CoreTable tbl_revisados) {
        this.tbl_revisados = tbl_revisados;
    }

    public CoreTable getTbl_revisados() {
        return tbl_revisados;
    }

    public void setBtn_actualizar_tabla_rev(CoreCommandButton btn_actualizar_tabla_rev) {
        this.btn_actualizar_tabla_rev = btn_actualizar_tabla_rev;
    }

    public CoreCommandButton getBtn_actualizar_tabla_rev() {
        return btn_actualizar_tabla_rev;
    }

    public String btn_revertir_nombra() {
        // Add event code here...
        String  vOutcome=null;
        
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"filaActualRev")){
            
            vOutcome="goto_nom_rever";
            
        }
        
        
        return vOutcome;
    }

    public String btn_realizar_reversion() {
         String vOutcome=null;
         
         if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"reversar_contrato")){
          
          // JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Ejecutar");
             
           utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Se ha reversado el contrato exitosamente!."));
           
           vOutcome="return_rev_nombra";
           
         }
         
         return vOutcome;
    }
}
