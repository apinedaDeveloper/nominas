package interfaz_usuario.backing.gestiones;

import enlace_datos.util.resulOp;

import interfaz_usuario.usuario;

import interfaz_usuario.util.JSFUtils;
import interfaz_usuario.util.utils;

import javax.faces.context.FacesContext;

import oracle.adf.view.faces.component.core.input.CoreInputText;

import oracle.adf.view.faces.component.core.input.CoreSelectOneChoice;

import oracle.adf.view.faces.context.AdfFacesContext;

import oracle.adf.view.faces.event.DisclosureEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class Ingresar_deduccion {
    private BindingContainer bindings;
    private CoreInputText inpt_regEmpleado;
    private CoreInputText cantidad;
    private CoreSelectOneChoice tipo_deduccion;
    private CoreInputText anio;
    private CoreInputText inpAnioBusqueda;
    private CoreInputText inpt_descrip;
    private CoreInputText inptNitDedu;
    
    public Ingresar_deduccion() {
        if (!AdfFacesContext.getCurrentInstance().isPostback()){
            EjecutarConsultas();
        }
    
    }

    public String getAnioServer(){
       return utils.getAnioActual(); 
    }

    public BindingContainer getBindings() {
        return this.bindings;
    }

    public void setBindings(BindingContainer bindings) {
        this.bindings = bindings;
    }


    public void EjecutarConsultas(){
        BindingContainer bindings = (BindingContainer)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings}");
      
        OperationBinding operationBinding;
        Object result;
        // 
      //  bindings.getOperationBinding("ExecBuscaEmpleado");
      //  Object result = operationBinding.execute();
        //Object registro_empleado;
        
       // bindings = getBindings();
        operationBinding = 
        bindings.getOperationBinding("ExecDeduccionesIsr");
        result = operationBinding.execute();
        
      //  bindings = getBindings();
        operationBinding = 
        bindings.getOperationBinding("ExecMostrarResumen");
        result = operationBinding.execute();
        
    }

    public String commandButton_action() {
            EjecutarConsultas();
            return null;
    }

    public String CreateNuevaDeduccion() {
    
    
        
        Object registro_empleado;
        Object anio;
        
        
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit")){
        
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"reprocesar_deducciones")){
            
            if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Create")){
                
                registro_empleado=(JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{flujo_usuario.selRegEmpleado}")); 
                anio=(JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{flujo_usuario.anioActual}")); 
                
                JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.RegistroEmpleado.inputValue}",utils.getNumberOracle(registro_empleado));
                JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.Anio.inputValue}",utils.getNumberOracle(anio));
                /*
                if (anio==null){
                 anio=this.getInpAnioBusqueda().getValue();   
                }
                
                this.inpt_regEmpleado.setValue(registro_empleado);
                this.getAnio().setSubmittedValue(anio);
                this.anio.setValue(anio);
                */
                //JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.RegistroEmpleado.inputValue}",utils.getNumberOracle(registro_empleado));
                this.tipo_deduccion.setDisabled(false);
                this.cantidad.setDisabled(false );
                this.inpt_descrip.setDisabled(false);

                
                
            }   
            
        }
            
           
           
        }
        
        
          //  this.anio.setDisabled(false);
            
        return null;
    }

    public void setInpt_regEmpleado(CoreInputText inpt_regEmpleado) {
        this.inpt_regEmpleado = inpt_regEmpleado;
    }

    public CoreInputText getInpt_regEmpleado() {
        return inpt_regEmpleado;
    }

    public String commit() {
  
        
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit")){
        
            if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"reprocesar_deducciones")){
            
                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ExecDetalleDeduccionesPorAnio");
                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ExecMostrarResumen");
            
            }
            
        
        }
        
        
        return null;
    }

    public String commandButton_commit() {
      
        
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit")){
        
            if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"reprocesar_deducciones")){
            
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ExecDeduccionesIsr");
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ExecMostrarResumen");
        
        
            this.tipo_deduccion.setDisabled(true);
            this.cantidad.setDisabled(true );
            this.anio.setDisabled(true );
            this.inpt_descrip.setDisabled(true);
            this.inptNitDedu.setDisabled(true);
            
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"verificarForma1101");
            utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Datos guardados exitosamente."));
            
            }
        
        }
                
        return null;
    }

    public void setCantidad(CoreInputText cantidad) {
        this.cantidad = cantidad;
    }

    public CoreInputText getCantidad() {
        return cantidad;
    }

    public void setTipo_deduccion(CoreSelectOneChoice tipo_deduccion) {
        this.tipo_deduccion = tipo_deduccion;
    }

    public CoreSelectOneChoice getTipo_deduccion() {
        return tipo_deduccion;
    }

    public String commandButton_Rollback() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = 
            bindings.getOperationBinding("Rollback");
        Object result = operationBinding.execute();
        if (operationBinding.getErrors().isEmpty()) {
        
            this.tipo_deduccion.setDisabled(true);
            this.cantidad.setDisabled(true );
            this.anio.setDisabled(true );
            this.inpt_descrip.setDisabled(true);
            this.inptNitDedu.setDisabled(true);
            
        }
        
        return null;
        
    }

    public void setAnio(CoreInputText anio) {
        this.anio = anio;
    }

    public CoreInputText getAnio() {
        return anio;
    }

    public void setInpAnioBusqueda(CoreInputText inpAnioBusqueda) {
        this.inpAnioBusqueda = inpAnioBusqueda;
        if (this.inpAnioBusqueda.getValue()==null){
            this.inpAnioBusqueda.setSubmittedValue(utils.getAnioActual());       
            this.inpAnioBusqueda.setValue(utils.getAnioActual());
        }
    }

    public CoreInputText getInpAnioBusqueda() {
        return inpAnioBusqueda;
    }

    public String cmd_eliminar() {
    
       if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"setDeduccion"))
       {
          JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Delete");
           
       }
        // Add event code here...
        return null;
    }

    public String cmd_editar() {
       
        Object vNomDed;
    
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"setDeduccion"))
        {
          this.cantidad.setDisabled(false);
          this.inpt_descrip.setDisabled(false);
          
          vNomDed=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.NombreDeduccion.inputValue}");
          
           if (vNomDed.toString().equals("SUELDO OTROS PATRONOS")||vNomDed.toString().equals("SUELDO OTRO PATRONO"))
           {
           
             this.inptNitDedu.setDisabled(false);    
               
           }
          
           //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Delete");
            
        }
                   
        
        
        return null;
    }

    public String btn_reprocesar() {
        
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"reprocesar_deducciones")){
            
           utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Se ha realizado exitosamente la proyección ISR."));
           
        }else{
        
           utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Ha ocurrido un error."));
            
        }
        
        
        return null;
    }

    public String btn_cambiar_anio() {
    
        String vAnio;        
        vAnio=(String)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vAnio1.inputValue}");
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{flujo_usuario.anioActual}",vAnio);
        
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ExecDeduccionesIsr");        
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ExecMostrarResumen");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"SueldosEmpl");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"verificarForma1101");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"DecJurada");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"DevISR");
        
        
        utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Se ha cambiado el año de trabajo."));
        
        return null;
    }

    public void setInpt_descrip(CoreInputText inpt_descrip) {
        this.inpt_descrip = inpt_descrip;
    }

    public CoreInputText getInpt_descrip() {
        return inpt_descrip;
    }

    public void tab_deduccion(DisclosureEvent disclosureEvent) {
        // Add event code here...
        
        if (disclosureEvent.isExpanded()){
        
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"getTotalNominalSA");
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"getTotalNominal");
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"getTotalNominalDiff");
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"getTotalBonoSA");
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"getTotalBono");
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"getTotalBonoDiff");
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"getTotalJudi");
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"getTotalJudiSA");
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"getTotalJudiDiff");
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"getTotalPlan");
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"getTotalPlanSA");
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"getTotalPlanDiff");
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"getTotalISR");
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"getTotalISRSA");
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"getTotalISRDiff");
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"getTotalLiquido");
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"getTotalLiquidoSA");
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"getTotalLiquidoDiff");
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"getTotalDesc");
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"getTotalDescSA");
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"getTotalDescDiff");
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"getTotalIgssSA");
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"getTotalIgss");
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"getTotalIgssDiff");
            
            
            
           // System.out.println("selec");
            
        }
        
        
    }

    public String btn_isr_definitivo() {
        // Add event code here...
         if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"reprocesar_ISR_def")){
             JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"verificarForma1101");
            utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Se ha realizado exitosamente el calculo ISR definitivo."));
            
         }else{
         
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Ha ocurrido un error."));
             
         }
         
         
        return null;
    }

    public String btn_buscarEmpl() {
    
        Object vValor, vTipoDeduccion;
    
      if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"ExecuteWithParams"))
      {
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.RegistroEmpleado.inputValue}");
        usuario.set_opciones(usuario.SEL_REGEMPLEADO,utils.getNumber(vValor)); 
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.NombreCompleto.inputValue}");
        usuario.set_opciones(usuario.NOMBREEMPLEADOSEL,vValor); 
        usuario.set_opciones(usuario.EMPLSEL,1);
        usuario.set_opciones(usuario.SEL_CONTRATO,new Long(0) ); 
        usuario.set_opciones(usuario.VISTA_EMPLEADO,1); 
        usuario.set_opciones(usuario.VISTA_CONTRATO,3); 
        
          vTipoDeduccion=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.attrTipoDeducion.inputValue}"); 
          if (vTipoDeduccion.toString().equals("17")){
              //Cuando es un tipo de deduccion por Formulario SAT se recalcularia el año del formulario ingresado, es por eso que se hace un cambio en la variable de sesion de AnioActual.        
               JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"exeFormSAT2");
          }else{
              JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"verificarEmpl");
              JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"lstOtrosPat");
              
          }
        
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"DatosFiscales");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"MuniNoPost");
        
        //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ExeTimbres"); debido a la nueva ley 2013
          
          
      
      } 
      
        return null;
    }

    public String btn_commit_cap() 
    {
     try {
       Object vNit,vValor, vAnioActual;
        
       vNit=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.Nit.inputValue}");

       if (vNit==null || (vNit!=null && vNit.toString().trim().equals(""))){
           
           utils.setADFMensajetoControl(new resulOp(resulOp.OPE_ERROR,"Ingrese el No de NIT"),"form1:page1:inpt_Nit");
           return null;   
       }
        
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.CalleAve.inputValue}");
        if (vValor==null || (vValor!=null && vValor.toString().trim().equals(""))){
            
            utils.setADFMensajetoControl(new resulOp(resulOp.OPE_ERROR,"Ingrese la calle o avenida"),"form1:page1:inptCalle");
            return null;   
        }
        
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.Zona.inputValue}");
        if (vValor==null || (vValor!=null && vValor.toString().trim().equals(""))){
            
            utils.setADFMensajetoControl(new resulOp(resulOp.OPE_ERROR,"Ingrese la zona"),"form1:page1:inptZona");
            return null;   
        }
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit"))
        {
        
        //Guardo el Año actual para que cuando termine de recalcular las deducciones regrese al año actual
            vAnioActual = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), "#{flujo_usuario.anioActual}");
            
            vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdTipoDeduccionIsr.inputValue}"); 
            if (vValor.toString().equals("17")){
                //Cuando es un tipo de deduccion por Formulario SAT se recalcularia el año del formulario ingresado, es por eso que se hace un cambio en la variable de sesion de AnioActual.        
                vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.Anio.inputValue}"); 
                JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{flujo_usuario.anioActual}",vValor.toString());
            }
            
            if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"reprocesar_deducciones"))
            {
                if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit"))
                {
                    JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"EjeOtrosPatr");
                    JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"EjeDeduccion");
                    utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Datos Guardados"));    
                }
            }
            //Regresa el valor de la variable de Sesion de AnioActual que tenia al inicio.
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{flujo_usuario.anioActual}",vAnioActual.toString());
            
        }
     } catch (Exception e){
        System.out.println("Error al RECALCULAR DEDUCCIONES: "+e.toString());
     }
        return null;
    }

    public String btn_agregar_otrospat() {
         
          JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"agregar_Detalle");
        
        return null;
    }

    public String btn_boleta_action() {
        btn_commit_cap(); 
        return null;
    }

    public String cmd_eliminar_otropat() {
         
         if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"setOtrosPat")) 
         {
             JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"DelOtrosPat");
             
         }
         
        return null;
    }

    public String btn_Actualizar_tipo() {
        // Add event code here...
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ExecDeduccionesIsr");        
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ExecMostrarResumen");

        
        return null;
    }

    public void setInptNitDedu(CoreInputText inptNitDedu) {
        this.inptNitDedu = inptNitDedu;
    }

    public CoreInputText getInptNitDedu() {
        return inptNitDedu;
    }

    public void showDetailItem_disclosureListener(DisclosureEvent disclosureEvent) {
        // Add event code here...
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Rollback");
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.attrTipoDeducion.inputValue}","17"); //al dar clic en la estaña de formularioSAT se setea la variable 
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"exeFormSAT2"); 
    }

    public void showDetailItem_disclosureListener2(DisclosureEvent disclosureEvent) {
        // Add event code here...
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Rollback");
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.attrTipoDeducion.inputValue}","8"); //al dar clic en la pestaña de Deducciones se setea la variable 
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"lstOtrosPat2");
    }

    public String btn_agregar_fromsat() {
        // Add event code here...
        
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"agregar_DetalleSAT");
        return null;
    }

    public String btn_congelarFormulario() {
         //Cambia el valor de la columna tipo_calculo de la tabla sis_deduccion_isr, si se congela es -1 y si quiere habilitar seria null.
        Object  vAnioActual, vValor;
        vAnioActual= JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), "#{flujo_usuario.anioActual}");
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.Anio.inputValue}"); 
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{flujo_usuario.anioActual}",vValor.toString());
        
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"CongelarFormularioSAT"))
        {
            if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit"))
            {
                JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"EjeOtrosPatr");
                JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"EjeDeduccion");
                utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Datos Guardados"));    
            }
        }
         
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{flujo_usuario.anioActual}",vAnioActual.toString()); //se regresa el año actual, la variable de sesion cambia segun el año del formulario sat.
        return null;
    }
}
