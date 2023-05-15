package enlace_datos.consultas.gestiones.complementos;

import enlace_datos.util.resulOp;

import interfaz_usuario.backing.util.util_dialog_adf;

import interfaz_usuario.util.ADFUtils;
import interfaz_usuario.util.JSFUtils;

import interfaz_usuario.util.utils;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.faces.component.core.layout.CoreShowDetailItem;

import oracle.adf.view.faces.component.core.nav.CoreCommandButton;
import oracle.adf.view.faces.context.AdfFacesContext;
import oracle.adf.view.faces.event.LaunchEvent;

import oracle.adf.view.faces.event.ReturnEvent;

import oracle.jbo.Row;
import oracle.jbo.uicli.binding.JUIteratorBinding;

public class pago_complementos {
   private boolean cambiaTipoNomina=false;
    private CoreShowDetailItem tab_detalle;
    private CoreShowDetailItem tab_histo;
    private CoreCommandButton btn_refrescaPendientes;
    private CoreCommandButton btn_refrescarRevisados;
    private CoreShowDetailItem tab_inicio;
    private CoreShowDetailItem tab_vacacion;
    private CoreCommandButton btn_gen_proc;

    public boolean getTipoNomina(){
       return cambiaTipoNomina;
   }

    public pago_complementos() {
    }

    public String btn_buscar() {
        // Add event code here..
        
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Empleado")){
            Object vNuevo=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.RegistroEmpleado.inputValue}");
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.reg_empleado.inputValue}",utils.getNumberOracle(vNuevo));
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Contratos");
            
        }
        
        return null;
    }

    public void tipo_nomina(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (valueChangeEvent.getNewValue()!=valueChangeEvent.getOldValue()){
            
            cambiaTipoNomina=true;
            
        }
        
    }

    public String btn_GenerarComplemento() {
        // Add event code here...
        Object vViewObject,vSel,vIdcontrato,vNuevo,pIdComple, pAutofinanciable;              
        JUIteratorBinding vIterador2;
        Row [] vFilas;
        int vNumeroFilas;
        vViewObject= JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.SisContratosEmplOpVwIterator}");
                
        vNuevo=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.pNuevo1.inputValue}");
                
        if (vViewObject!=null)
        { 
        
          if (vNuevo!=null && vNuevo.toString().equals("1")){
              
            JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"crearComplemento");
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pNuevo1.inputValue}","0");  
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Commit");
              
          }
        
        
            vIterador2=(JUIteratorBinding)vViewObject;            
            vFilas=vIterador2.getAllRowsInRange();            
            vNumeroFilas=vFilas.length;
            
            //verifica si es un complemento autofinanciable 
            if (vNumeroFilas > 0) {
                pAutofinanciable =JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.SisComplementoVwIsautofinanciable.inputValue}"); 
                if (pAutofinanciable.toString().equals("true"))
                    JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.Isautofinanciable.inputValue}","SI");  
                else
                    JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.Isautofinanciable.inputValue}","NO");  
            }
            
            
            for (int i=0;i<vNumeroFilas;i++){
                
                vSel=vFilas[i].getAttribute("Seleccionado");  
                
                if (vSel.toString().equals("true")){
                
                    vIdcontrato=vFilas[i].getAttribute("IdContrato"); 
                    JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pIdContrato1.inputValue}",vIdcontrato);                    
                    JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"crearDetComplNormal");
                    
                    pIdComple=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdComplemento.inputValue}");
                    JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pIdVar1.inputValue}",pIdComple);                                    
                    
                }
                
            }
            
            
         
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Commit");
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarDet");
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"actualizaSubProgramaCompl");   
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Commit");
         utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Calculo generado exitosamente"));
            
        }
        
        vViewObject=null;
        
        return null;
    }

    public String btn_nuevo_action() {
        // Add event code here...
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Rollback");
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pNuevo1.inputValue}","0");        
        this.tab_histo.setDisclosed(false);
        this.tab_detalle.setDisclosed(true);
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"crearComplemento");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Commit");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarDet");
        try{
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Execute1");
         }catch(Exception exep){
             
         }
        return null;
    }

    public void setTab_detalle(CoreShowDetailItem tab_detalle) {
        this.tab_detalle = tab_detalle;
    }

    public CoreShowDetailItem getTab_detalle() {
        return tab_detalle;
    }

    public void setTab_histo(CoreShowDetailItem tab_histo) {
        this.tab_histo = tab_histo;
    }

    public CoreShowDetailItem getTab_histo() {
        return tab_histo;
    }

    public String cmd_Complemento() {
    
    
        Object pIdComple; 
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"setCurrentRowWithKey");
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pNuevo1.inputValue}","0");    
        
        
        pIdComple=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdComplemento.inputValue}");
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pIdVar1.inputValue}",pIdComple);
        
        
        this.tab_histo.setDisclosed(false);
        this.tab_detalle.setDisclosed(true);
               
        return null;
    }

    public String cmdRefresh_action() {
    
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Execute")){
            
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"actualizarVW");
        }
        // Add event code here...
        return null;
    }

    public String cmd_eliminar_det() {
        // Add event code here...
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"setDetalleCompl"))
        {
        
          if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"borrarDetComple")){
              JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Commit");
              utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Fila borrada exitosamente"));
              
          }
          
        }
        
        return null;
    }

// rev_complementos_jspx
    public String cmd_ok_rev_contra() {
        // Add event code here...
        
        Object pIdComple;
        
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"SetComple"))
        {
        /*
            pIdComple=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdComplemento.inputValue}");
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pIdVar1.inputValue}",pIdComple);
        */    
         
           JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"AutoComplemen");
        
           if(JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"CambiarActivo")){
               
               JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"EjecutarPend");
               JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"EjecutarRev");
               
               utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Se ha autorizado el complemento"));
           }
            
            
            
            
            
        }
         
        return null;
    }
    
    // rev_complementos_jspx
    
    public String cmd_objetar() {
        Object vIdComple,vDataTabla;
        String vOutCome;
        
        
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"SetComple");
        
        vIdComple=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdComplemento.inputValue}");
           if (vIdComple==null)
               {
               vOutCome=null;
               utils.setADFMensaje(new resulOp(resulOp.OPE_WARN,"Seleccione un complemento"));   
               }else{
                   vOutCome="dialog:auto_sol";
               }
        // System.out.println("autorizarrrrr");
        return vOutCome; 
        
        
        
    }

    public void launch_objetar(LaunchEvent launchEvent) {
        // Add event code here...
         Object vIdComplemento,vEstado;
         util_dialog_adf vDialog;
         vIdComplemento=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdComplemento.inputValue}");
         vEstado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdEstado.inputValue}");  
            if (vIdComplemento!=null){
                vDialog= new util_dialog_adf();
                vDialog.setParametros_dialogo_autorizacion(launchEvent,"COMPLEMENTOS",vIdComplemento,vEstado,"Autorizacion");
               // vDialog.abrir_dialogo_autorizacion(FacesContext.getCurrentInstance(),"NOMBRAMIENTO",vIdContrato,vEstado,"Autorizacion"); 
               
             //  JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ContratosPendRev");
                
            }
         
    }

    public void return_listener_objetar(ReturnEvent returnEvent) {
        // Add event code here...
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarPend");
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarRev");
        // JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"actRevisados");        
         AdfFacesContext.getCurrentInstance().partialUpdateNotify(this.btn_refrescaPendientes);
         //System.out.println("retorne");
         
        
    }

    public void setBtn_refrescaPendientes(CoreCommandButton btn_refrescaPendientes) {
        this.btn_refrescaPendientes = btn_refrescaPendientes;
    }

    public CoreCommandButton getBtn_refrescaPendientes() {
        return btn_refrescaPendientes;
    }

//    pago_complementos_ant.jspx

    public String btn_buscarAnt() {
        Object objVerificarRegEmp = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.reg_empleado.inputValue}");
        if (objVerificarRegEmp != null){
             if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Empleado")){
                 Object vNuevo=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.RegistroEmpleado.inputValue}");
                 JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.reg_empleado.inputValue}",utils.getNumberOracle(vNuevo));
                 
                 Object vNuevoAnio= JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vAnio1.inputValue}");
                 if (vNuevoAnio == null) {
                     utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Seleccionar Año para Pago de Complemento"));
                 }else{
                     JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Contratos");
                 }  
                 
             }else {
                return null;
             }
        }else{
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Ingresar Registro de Personal."));
        }

        return null;
    }

    public String btn_generar_complemento_ant() {
         // Add event code here...
         Object vViewObject,vSel,vIdcontrato,vNuevo,pIdComple;              
         JUIteratorBinding vIterador2;
         Row [] vFilas;
         int vNumeroFilas;
         vViewObject= JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.SisContratos_ant_empl_vwIterator}");
                 
         vNuevo=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.pNuevo1.inputValue}");
        Object vNuevoAnio= JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vAnio1.inputValue}");
        if (vNuevoAnio == null) 
           utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Seleccionar Año para Pago Complemento"));
                 
         if (vViewObject!=null && vNuevoAnio != null)
         { 
         
           if (vNuevo!=null && vNuevo.toString().equals("1")){
               
             JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"crearComplemento");
             JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pNuevo1.inputValue}","0");  
             JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Commit");
               
           }
         
         
             vIterador2=(JUIteratorBinding)vViewObject;            
             vFilas=vIterador2.getAllRowsInRange();            
             vNumeroFilas=vFilas.length;
             
             
             for (int i=0;i<vNumeroFilas;i++){
                 
                 vSel=vFilas[i].getAttribute("Seleccionado");  
                 vSel=(vSel==null?false:vSel);
                 
                 if (vSel.toString().equals("true")){
                 
                     vIdcontrato=vFilas[i].getAttribute("IdContrato"); 
                     JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pIdContrato1.inputValue}",vIdcontrato);                    
                     JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"crearDetComplAnt");
                     
                     pIdComple=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdComplemento.inputValue}");
                     JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pIdVar1.inputValue}",pIdComple);                                    
                     
                 }
                 
             }
             
          JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Commit");
          JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarDet");
          JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"actualizaSubProgramaCompl");   
          JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Commit");
          utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Calculo generado exitosamente"));
             
         }
         
         vViewObject=null;
         
         return null;

    }

    public String cmd_editar_ant() {
    
    
         if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"setDetalleCompl"))
         {
         
             if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"cambiarEstadoTodos"))
             {
                 JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"cambiarEstadoActual");
                 
             }
           
         }         

        return null;
    }

    public String btn_guardar_ant() {
         if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit")){
         
             utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Datos guardados exitosamente"));    
         }
         
         
        return null;
    }

    public String btn_cancelar_edit_ant() {
         JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"cambiarEstadoTodos");
        return null;
    }

    public String btn_agregar_desc_ant() {
        
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit")){
            
            if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"agregarDescuento")){                
                JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"EjecutarDesc");                
                JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"EjecutarDet");
                JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"posicionaSeleccionado");
            }
        }
      return null;  
    }
    
    
    public String btn_eliminar_ajuste() {
        // Add event code here...
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"delDetAjuste")){
            JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"actualiza_desc_bono");
            JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit");
            JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"EjecutarDet");
            JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"posicionaSeleccionado");
            
        }
        
        return null;
    }


    public String cmd_eliminar_ajuste_ant() {
         if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"delDetAjuste")){
             JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"actualiza_desc_bono");
             JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit");
             JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"EjecutarDet");
             JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"posicionaSeleccionado");
             
         }

        return null;
    }

    public String cmd_refresh_ant() {
        // Add event code here...
        
        if(JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Execute")){
        
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"actualizarVW");
            
        }
        
        return null;
    }

    public String btn_filtrar_rev_complementos() {
        Object vTipo;
        
        vTipo=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.pIdTipoC1.inputValue}"); 
        
        if (!vTipo.toString().equals("0")){
         
           JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"filtrar_x_tipo");   
           JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"filtrar_x_tipoRev");
          
        }else{
        
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"filtrar_excluye");   
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"filtrar_excluyeRev");   
        }
        
        // Add event code here...
        return null;
    }
    
    //
    // código para revertir una autorización
    
     public String cmd_objetar_rev() {
         Object vIdComple,vDataTabla;
         String vOutCome;

         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"setCompleRev");
         vIdComple=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdComplementoRev.inputValue}");

            if (vIdComple==null)
            {
                vOutCome=null;
                utils.setADFMensaje(new resulOp(resulOp.OPE_WARN,"Seleccione un complemento"));   
            }else{
                    vOutCome="dialog:auto_sol";
            }
         // System.out.println("autorizarrrrr");
         //}
         return vOutCome; 
         
     }

     public void launch_objetar_rev(LaunchEvent launchEvent) {
         // Add event code here...
          Object vIdComplemento,vEstado;
          util_dialog_adf vDialog;
          
          vIdComplemento=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdComplementoRev.inputValue}");
          vEstado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdEstadoRev.inputValue}");  

             if (vIdComplemento!=null){
                 vDialog= new util_dialog_adf();
                 vDialog.setParametros_dialogo_autorizacion(launchEvent,"COMPLEMENTOS",vIdComplemento,vEstado,"Autorizacion");
                 
             }
          
     }

     public void return_listener_objetar_rev(ReturnEvent returnEvent) {
         // Add event code here...
          JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarPend");
          JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarRev");

          AdfFacesContext.getCurrentInstance().partialUpdateNotify(this.btn_refrescarRevisados);
         
     }

    public void setBtn_refrescarRevisados(CoreCommandButton btn_refrescarRevisados) {
        this.btn_refrescarRevisados = btn_refrescarRevisados;
    }

    public CoreCommandButton getBtn_refrescarRevisados() {
        return btn_refrescarRevisados;
    }

    public String cmd_editar() {
        // Add event code here...
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"setDetalleCompl"))
        {
        
            if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"cambiarEstadoTodos"))
            {
                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"cambiarEstadoActual");
                
            }
          
        }         
     return null;
    }

    public String btn_complemento_uno_ant() {
         Object vViewObject,vSel,vIdcontrato,vNuevo,pIdComple,vAnioContr, pAutofinanciable;              
         JUIteratorBinding vIterador2;
         Row [] vFilas;
         int vNumeroFilas;
         vViewObject= JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.SisContratos_ant_empl_vwIterator}");
                 
         vNuevo=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.pNuevo1.inputValue}");
         Object vNuevoAnio= JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vAnio1.inputValue}");
         if (vNuevoAnio == null) 
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Seleccionar Año para Pago Complemento"));
        
                 
         if (vViewObject!=null && vNuevoAnio != null)
         { 
         
           if (vNuevo!=null && vNuevo.toString().equals("1") ){
               
             JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"crearComplemento");
             JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pNuevo1.inputValue}","0");  
             JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Commit");
               
           }
         
         
             vIterador2=(JUIteratorBinding)vViewObject;            
             vFilas=vIterador2.getAllRowsInRange();            
             vNumeroFilas=vFilas.length;
             
             //verifica si es un complemento autofinanciable 
             if (vNumeroFilas > 0) {
                 pAutofinanciable =JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.SisComplementoVwIsautofinanciable.inputValue}"); 
                 if (pAutofinanciable.toString().equals("true"))
                     JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.Isautofinanciable.inputValue}","SI");  
                 else
                     JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.Isautofinanciable.inputValue}","NO");  
             }
             
             
             
             for (int i=0;i<vNumeroFilas;i++){
                 
                 vSel=vFilas[i].getAttribute("Seleccionado");  
                 vSel=(vSel==null?false:vSel);
                 
                 if (vSel.toString().equals("true")){
                 
                     vIdcontrato=vFilas[i].getAttribute("IdContrato"); 
                     JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pIdContrato1.inputValue}",vIdcontrato);                    
                     
                     vAnioContr=vFilas[i].getAttribute("Correlativo"); 
                     JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pAnioCont1.inputValue}",vAnioContr);                    
                     
                     JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"crearDetComplNormal");
                     
                     pIdComple=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdComplemento.inputValue}");
                     JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pIdVar1.inputValue}",pIdComple);                                    
                     
                 }
                 
             }
             
          JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Commit");
          JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarDet");
          JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"actualizaSubProgramaCompl");   
          JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Commit");

          utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Calculo generado exitosamente"));
             
         }
         
         vViewObject=null;
         
         return null;
    }

    public void launch_detalle_auto(LaunchEvent launchEvent) {
        // Add event code here...
         util_dialog_adf vDialog= new util_dialog_adf();
         Object vVariable,vEstado;
         vVariable=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdComplemento.inputValue}");
         vEstado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdEstado.inputValue}");
         //        vDialog.abrir_dialogo_autorizacion(FacesContext.getCurrentInstance(),"LICENCIA",vVariable,vEstado,"licencia");
         
         
         vDialog.setParametros_dialogo_autorizacion(launchEvent,"COMPLEMENTOS",vVariable,vEstado,"Pago Complemento");
         
        
        
    }

    public void launch_detalle_auto_ant(LaunchEvent launchEvent) {
        util_dialog_adf vDialog= new util_dialog_adf();
        Object vVariable,vEstado;
        vVariable=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdComplemento.inputValue}");
        vEstado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdEstado.inputValue}");
        //        vDialog.abrir_dialogo_autorizacion(FacesContext.getCurrentInstance(),"LICENCIA",vVariable,vEstado,"licencia");
        
        
        vDialog.setParametros_dialogo_autorizacion(launchEvent,"COMPLEMENTOS",vVariable,vEstado,"Pago Complemento");
        // Add event code here...
    }

    public String btn_vacacion_action() {
         Object vViewObject,vSel,vIdcontrato,vNuevo,pIdComple;              
         JUIteratorBinding vIterador2;
         Row [] vFilas;
         int vNumeroFilas;
         vViewObject= JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.SisContratosEmplOpVwIterator}");
                 
         vNuevo=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.pNuevo1.inputValue}");
                 
         if (vViewObject!=null)
         { 
         
           if (vNuevo!=null && vNuevo.toString().equals("1")){
               
             JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"crearComplemento");
             JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pNuevo1.inputValue}","0");  
             JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Commit");
               
           }
         
         
             vIterador2=(JUIteratorBinding)vViewObject;            
             vFilas=vIterador2.getAllRowsInRange();            
             vNumeroFilas=vFilas.length;
             
             
             for (int i=0;i<vNumeroFilas;i++){
                 
                 vSel=vFilas[i].getAttribute("Seleccionado");  
                 vSel=(vSel==null?false:vSel);
                 
                 if (vSel.toString().equals("true")){
                 
                     vIdcontrato=vFilas[i].getAttribute("IdContrato"); 
                     JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pIdContrato1.inputValue}",vIdcontrato);                    
                     JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"crearDetComplActual");
                     
                     pIdComple=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdComplemento.inputValue}");
                     JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pIdVar1.inputValue}",pIdComple);                                    
                     
                 }
                 
             }
             
          JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Commit");
          JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarDet");
          JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"actualizaSubProgramaCompl");   
          JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Commit");
          utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Calculo generado exitosamente"));
             
         }
         
         vViewObject=null;

        
        return null;
    }

    public String btn_procesar_vac2() {
        Object vViewObject,vSel,vIdcontrato,vNuevo,pIdComple;              
        JUIteratorBinding vIterador2;
        Row [] vFilas;
        int vNumeroFilas;
        vViewObject= JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.SisComplementoPlazaVac_vwIterator}");
                
        vNuevo=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.pNuevo1.inputValue}");
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.Isautofinanciable.inputValue}","SI");  
                
        if (vViewObject!=null)
        { 
        
          if (vNuevo!=null && vNuevo.toString().equals("1")){
              
            JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"crearComplemento");
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pNuevo1.inputValue}","0");  
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Commit");
              
          }
        
        
            vIterador2=(JUIteratorBinding)vViewObject;            
            vFilas=vIterador2.getAllRowsInRange();            
            vNumeroFilas=vFilas.length;
            
            
            for (int i=0;i<vNumeroFilas;i++){
                
                vSel=vFilas[i].getAttribute("Seleccionado");  
                vSel=(vSel==null?false:vSel);
                
                if (vSel.toString().equals("true")){
                
                    vIdcontrato=vFilas[i].getAttribute("IdContrato"); 
                    JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pIdContrato1.inputValue}",vIdcontrato);                    
                    JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"crearDetComplActual");
                    
                    pIdComple=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdComplemento.inputValue}");
                    JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pIdVar1.inputValue}",pIdComple);                                    
                    
                }
                
            }
            
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Commit");
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarDet");
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"actualizaSubProgramaCompl");   
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Commit");
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Execute1");
         utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Calculo generado exitosamente"));
         this.getTab_vacacion().setDisclosed(false);
         this.getTab_inicio().setDisclosed(true);         
            
        }
        
        vViewObject=null;
    return null;
    }

    public void setTab_inicio(CoreShowDetailItem tab_inicio) {
        this.tab_inicio = tab_inicio;
    }

    public CoreShowDetailItem getTab_inicio() {
        return tab_inicio;
    }

    public void setTab_vacacion(CoreShowDetailItem tab_vacacion) {
        this.tab_vacacion = tab_vacacion;
    }

    public CoreShowDetailItem getTab_vacacion() {
        return tab_vacacion;
    }
//complementos pendientes de revisar
    public String aplicaExtraordinario() {
        // Add event code here...
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"SetComple");
         if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"AplicarExtraordinario")){
         
             JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"filtrar_x_tipo");   
             JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"filtrar_x_tipoRev");
             utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"El complemento es  Extraordinario"));
         }
        return null;
    }
// complementos revisados
    public String aplicaExtraordinario_rev() {
        // Add event code here...
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"setCompleRev");
         if(JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"AplicarExtraordinario_rev")){
         
             JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"filtrar_x_tipo");   
             JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"filtrar_x_tipoRev");
             utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"El complemento es Extraordinario"));
         }
         
        return null;
    }

    public String btn_gen_proc_isr() {
        // Add event code here...
        
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"generar_proceso")){
        
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ExeListProcesos");
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.vDescrip1.inputValue}"," ");            
            utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Operación completada"));
            
        }
        
        return null;
    }

    public void launch_repo_isr_auto(LaunchEvent launchEvent) {
        Object vValor;        
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"setProceso");
        
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdProceso.inputValue}");   
        launchEvent.getDialogParameters().put("IdProceso", vValor);
        launchEvent.getDialogParameters().put("IdGestionX", vValor); 
        launchEvent.getDialogParameters().put("Gestion", "PROC_NOMINA"); 
        launchEvent.getDialogParameters().put("RefreshVw", "Proceso"); 
        
     //   System.out.println("debug "+ vValor);
        
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdEstadoProc.inputValue}");
        launchEvent.getDialogParameters().put("Estado", vValor); 
                
        
        launchEvent.getDialogParameters().put("IdSolicitud", null); 
        launchEvent.getDialogParameters().put("IdContrato",null);
        launchEvent.getDialogParameters().put("IdAnexo",null);
        launchEvent.getDialogParameters().put("IdHoraExtra",null);
        
      
    }

    public void return_listener_repISR(ReturnEvent returnEvent) {
    
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ExeListProcesos");
        AdfFacesContext.getCurrentInstance().partialUpdateNotify(this.btn_gen_proc);
    }

    public void setBtn_gen_proc(CoreCommandButton btn_gen_proc) {
        this.btn_gen_proc = btn_gen_proc;
    }

    public CoreCommandButton getBtn_gen_proc() {
        return btn_gen_proc;
    }

    public String btn_buscar_repoISR() {
        // Add event code here...
         JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"ExeListProcesos");
        return null;
    }
}
