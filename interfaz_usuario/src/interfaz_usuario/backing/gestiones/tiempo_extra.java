package interfaz_usuario.backing.gestiones;

import enlace_datos.consultas.gestiones.anexo.sis_movimiento_plazaRowImpl;
import enlace_datos.consultas.gestiones.horas_extras.sis_det_tiempo_extra_vwRowImpl;

import enlace_datos.util.horario;
import enlace_datos.util.resulOp;
//import enlace_datos.util.utils;

import interfaz_usuario.backing.util.util_dialog_adf;

import interfaz_usuario.usuario;

import interfaz_usuario.util.JSFUtils;

import interfaz_usuario.util.utils;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Iterator;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.faces.component.core.data.CoreTable;
import oracle.adf.view.faces.component.core.data.CoreTableSelectOne;
import oracle.adf.view.faces.component.core.input.CoreInputText;
import oracle.adf.view.faces.component.core.input.CoreSelectInputDate;
import oracle.adf.view.faces.component.core.input.CoreSelectOneChoice;

import oracle.adf.view.faces.component.core.layout.CorePanelForm;
import oracle.adf.view.faces.component.core.layout.CoreShowDetailItem;
import oracle.adf.view.faces.component.core.layout.CoreShowOneRadio;
import oracle.adf.view.faces.component.core.nav.CoreCommandButton;
import oracle.adf.view.faces.component.core.output.CoreOutputText;
import oracle.adf.view.faces.context.AdfFacesContext;
import oracle.adf.view.faces.event.AttributeChangeEvent;

import oracle.adf.view.faces.event.LaunchEvent;

import oracle.adf.view.faces.event.ReturnEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.JboException;
import oracle.jbo.Key;
import oracle.jbo.RowSetIterator;
import oracle.jbo.uicli.binding.JUIteratorBinding;

import pkg_util_base_datos.interfaz_DB;


public class tiempo_extra {
   public boolean valorDependencia = false;
   public boolean empleado = false;//controla la seleccion del empleado
    private BindingContainer bindings;
   // private CoreSelectOneChoice selecEmpleado;
    private CoreTableSelectOne selecDatEmpleado;
    private CorePanelForm formActividad;
    private CoreCommandButton btn_actividad;
    private CoreCommandButton btn_guardar;
    private CoreCommandButton btn_borrar;
    private CoreCommandButton btn_crearEmpleado;
    private CoreInputText inpA;
    private CoreInputText inp_actividad;
    private CoreSelectInputDate inp_fecha;
    private CoreInputText inp_hrInicio;
    private CoreInputText inp_hrFin;
    private CoreCommandButton btn_save_upEmpleado;
    private CoreInputText inp_regEmpleado;
    private CoreOutputText etiquetaEmpleado;
    private CoreTable tblActividad;
    private CoreOutputText totalHrextra;
    private CoreSelectOneChoice selecEstado;
    private CoreCommandButton btn_CrearDetalle;
    private CoreShowOneRadio show_rango;
    private CoreSelectOneChoice cmbDependencia;
    private CoreSelectOneChoice cmbUnidad;
    private CoreSelectOneChoice cmbPeriodo;
    private CoreInputText inp_anio;
    private CoreInputText inp_Motivo;
    private CoreSelectInputDate inp_ranFecha;
    private CoreSelectInputDate inp_rangoFecha2;
    private CoreSelectInputDate inp_fechaFin;
    private CoreShowDetailItem detailDia;

    public tiempo_extra() {
   
    }
    

    public void selecDependencia(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valorDependencia = true;
        //System.out.println("valor variable" + valorDependencia);
    }


    public void selecRegistro(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
         //System.out.println("valor variable 2" + valorDependencia);
    }
    
    public boolean getSelecDependencia(){
    
        return valorDependencia;
    }
    public boolean getempleado(){// metodo utilizado para devolver el estado del empleado, si este ha sido seleccionado o no.
    
        return empleado;
    }
    public BindingContainer getBindings() {
        return this.bindings;
    }

    public void setBindings(BindingContainer bindings) {
        this.bindings = bindings;
    }

    public String crear_empleado() {
        Object varEmpleado = "";
        boolean resultado;
        varEmpleado = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{flujo_usuario.auxiliar}");
        if (varEmpleado.equals(0)){//no se ha seleccionado ningun empleado para hora extra.
       
       /* BindingContainer bindings = getBindings();
        OperationBinding operationBinding = 
            bindings.getOperationBinding("Create1");//crea una fila de ingreso para la tabla sis_tiempo_extra.
        Object result = operationBinding.execute();*/
        
        resultado = JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Create1");
        //this.selecEmpleado.setDisabled(true); 
        if (resultado == true) {
            usuario.set_opciones(usuario.VISTA_AUXILIAR,1);//asignamos 1  a la variablee de sesion
        }  
        else{
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Error al Asignar el Empleado"));
            return null;
        }
        }
       // JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"filtraEmpleados");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ConsultaEmpleado");
        Object valor = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.RegistroEmpleado1.inputValue}");
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.regEmpleado1.inputValue}",utils.getNumberOracle(valor));
        
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"filtraContrato");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"PartidaGasto");
        //selecEmpleado.setDisabled(false);//habilita elcombo para seleccionar empleado 
        
        //lo traje del boton crear actividad.......
         Object contrato = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.consul_contratosAdmin_byReg_vw1.currentRow['idContrato']}");
         JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.IdContrato.inputValue}",contrato);
    
        selecDatEmpleado.setDisabled(false);
        formActividad.setRendered(false);
        this.btn_actividad.setDisabled(false);
       // this.btn_crearEmpleado.setDisabled(true);
        this.inp_actividad.setDisabled(false);               
        this.inp_fecha.setDisabled(false);
        this.inp_hrInicio.setDisabled(false);
        this.inp_hrFin.setDisabled(false);
        return null;
    }

    public void asigna_datos_empleado(AttributeChangeEvent attributeChangeEvent) { //no utilizado por el momento..
        // Add event code here...
        int aux;
        aux = 0;
       /* if (aux== 0){
            System.out.println("solo para parar");
        }*/
        Object contrato = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.empleado_x_unidad_vw1SisContratosActivos_by_reg1.currentRow['IdContrato']}");
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.IdContrato.inputValue}",contrato);
        //System.out.println("contrato del empleado es " + contrato);
    }
/* metodo del boton crear actividad*/
    public String crear_actividad() {
    
        boolean resultado;
       resultado = JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Create");
        if (resultado == true){//resultado satisfactorio
            //Object contrato = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.empleado_x_unidad_vw1SisContratosActivos_by_reg1.currentRow['idContrato']}");
            //JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.IdContrato.inputValue}",contrato);
            //de la lista de contratos del empleado asigno el contrato donde se le pagaran horas extras.**************
            
            /* lo cambie al boton asignar empleado.
             Object contrato = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.consul_contratosAdmin_byReg_vw1.currentRow['idContrato']}");
             JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.IdContrato.inputValue}",contrato);
             **/
             usuario.set_opciones(usuario.VISTA_AUXILIAR,0); //empleado seleccionado para hora extra;
            //System.out.println("contrato del empleado es " + contrato);
            //selecEmpleado.setDisabled(true);
            selecDatEmpleado.setDisabled(true);
            formActividad.setRendered(true);
            this.inp_regEmpleado.setDisabled(true);
            this.btn_crearEmpleado.setDisabled(true);
            this.btn_actividad.setDisabled(true);
            this.btn_CrearDetalle.setDisabled(false);
            this.inp_fechaFin.setSubmittedValue(null);
            this.inp_fechaFin.setValue(null);
            this.detailDia.setDisclosed(true);
            //this.btn_guardar.setDisabled(false);    
            
             Object contrato = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.consul_contratosAdmin_byReg_vw1.currentRow['idContrato']}");
             JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.IdContrato.inputValue}",contrato);
             
            
        }
        else {
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Error al generar el detalle"));
        }
        
        return null;
    }
/*
    public void setSelecEmpleado(CoreSelectOneChoice selecEmpleado) {
        this.selecEmpleado = selecEmpleado;
    }

    public CoreSelectOneChoice getSelecEmpleado() {
        return selecEmpleado;
    }
*/
    public void setSelecDatEmpleado(CoreTableSelectOne selecDatEmpleado) {
        this.selecDatEmpleado = selecDatEmpleado;
    }

    public CoreTableSelectOne getSelecDatEmpleado() {
        return selecDatEmpleado;
    }

    public void setFormActividad(CorePanelForm formActividad) {
        this.formActividad = formActividad;
    }

    public CorePanelForm getFormActividad() {
        return formActividad;
    }

    public String btn_autorizar() {
        // Add event code here...
        
         util_dialog_adf vDialog= new util_dialog_adf();
         Object vVariable,vEstado;
         vVariable=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdHoraExtra.inputValue}");
         vEstado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.Estatus.inputValue}");
         vDialog.abrir_dialogo_autorizacion(FacesContext.getCurrentInstance(),"TIEMPO_EXTRA",vVariable,vEstado,"innecesario");
         //System.out.println(vVariable);
        //System.out.println(vEstado);
        return null;
    }

    public String btn_regresar() {
        // Add event code here...
         Object varUsuario = "";
         Object varUsuario1="";
         //varUsuario = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{flujo_usuario.perfilesEmpleadoLogin}");
         varUsuario = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{roles_usuario.profesionalPresupuesto}");
         varUsuario1 = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{roles_usuario.directorGeneralFinanciero}");
        //System.out.println("el rol es:  "+varUsuario);
         if(varUsuario.equals(true)||(varUsuario1.equals(true))) {//el usuario es de presupuesto o el director general financiero
             return "presup_hrExtra";
         } 
         else
            varUsuario = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{roles_usuario.analistaRecursosHum}");
            if(varUsuario.equals(true)){// el usuario es un analista
             return "Per_hrExtra";
         
         }
        else
            varUsuario = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{roles_usuario.tesorero}");
        varUsuario1 = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{roles_usuario.auxiliarTesoreria}");
            if(varUsuario.equals(true)||(varUsuario1.equals(true))){//el uusuario es un tesorero
            return "consul_hrExtra";
        
        }
        return null;
    }

    public void setBtn_actividad(CoreCommandButton btn_actividad) {
        this.btn_actividad = btn_actividad;
    }

    public CoreCommandButton getBtn_actividad() {
        return btn_actividad;
    }

    public void btn_autoriza_Extra(LaunchEvent launchEvent) {
        // Add event code here...
         Object vVariable;
         vVariable=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdHoraExtra.inputValue}");
         launchEvent.getDialogParameters().put("Gestion","TIEMPO_EXTRA");
         launchEvent.getDialogParameters().put("IdHoraExtra", vVariable);
         launchEvent.getDialogParameters().put("IdGestionX",vVariable);
         vVariable=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.Estatus.inputValue}");
         launchEvent.getDialogParameters().put("Estado",vVariable);
         launchEvent.getDialogParameters().put("RefreshVw", "innecesario");
    }
    
    public void launch_objetar(LaunchEvent launchEvent) {
        // Add event code here...
         Object vIdComplemento,vEstado;
         util_dialog_adf vDialog;
         vIdComplemento=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdHoraExtra.inputValue}");
         vEstado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdEstado.inputValue}");  
            if (vIdComplemento!=null){
                vDialog= new util_dialog_adf();
                vDialog.setParametros_dialogo_autorizacion(launchEvent,"TIEMPO_EXTRA",vIdComplemento,vEstado,"Autorizacion");
               // vDialog.abrir_dialogo_autorizacion(FacesContext.getCurrentInstance(),"NOMBRAMIENTO",vIdContrato,vEstado,"Autorizacion"); 
               
             //  JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ContratosPendRev");
                
            }
         
    }

    public String btn_Cancelar() {
        boolean resultado;
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"reset");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"resetUnidad");    
        
        
        //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ConsultaEmpleado1");
        /*BindingContainer bindings = getBindings();
       OperationBinding operationBinding = 
            bindings.getOperationBinding("Rollback");
        Object result = operationBinding.execute();*/
        
        resultado = JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Rollback");
         
        if (resultado == false) {
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Error al Anular la Gestion, click en cancelar nuevamente"));
            return null;
        }
       //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Rollback");
        return "gestiones";
    }

    public void setBtn_guardar(CoreCommandButton btn_guardar) {
        this.btn_guardar = btn_guardar;
    }

    public CoreCommandButton getBtn_guardar() {
        return btn_guardar;
    }
//metodo utilizado en el boton modificar de la pagina gestiones/det_act_tiempo_extra.jspx
    public String btn_modificar() {
        // Add event code here...         
        usuario.set_opciones(usuario.VISTA_OPERACION,1); 
        return "mod_hora_extra";
    }

    public void setBtn_borrar(CoreCommandButton btn_borrar) {
        this.btn_borrar = btn_borrar;
    }

    public CoreCommandButton getBtn_borrar() {
        return btn_borrar;
    }

    public void setBtn_crearEmpleado(CoreCommandButton btn_crearEmpleado) {
        this.btn_crearEmpleado = btn_crearEmpleado;
    }

    public CoreCommandButton getBtn_crearEmpleado() {
        return btn_crearEmpleado;
    }

    public String btn_actualizar() {
        
        /*BindingContainer bindings = getBindings();
        OperationBinding operationBinding = 
            bindings.getOperationBinding("Execute");
        Object result = operationBinding.execute();*/
        Object varPartidaGasto,varidContrato;
        varPartidaGasto = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), "#{bindings.PartidaGasto1.inputValue}");
        varidContrato = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), "#{bindings.PartidaGasto1.inputValue}");
        if (varPartidaGasto == null){
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Debe Seleccionar la partida gasto"));    
        }else if(varidContrato == null){
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"NO. DE CONTRATO: El empleado asignado no tiene ningún contrato valido o no fue seleccionado.  Verifique en la parte superior "));
        }else if (this.inp_fecha.getValue() == null || this.inp_fecha.getValue().equals("")){
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Debe ingresar la fecha en que se realizará la actividad"));
        }else if (this.inp_hrInicio.getValue() == null || this.inp_hrInicio.getValue().equals("")){
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Debe ingresar la hora de inicio de la actividad"));
        }else if (this.inp_hrFin.getValue() == null || this.inp_hrFin.getValue().equals("")){
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Debe ingresar la hora fin de la actividad"));
        }else {
        
       
                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Execute");
                //lleva el conteo de las horas extras ingresadas.
                sis_det_tiempo_extra_vwRowImpl auxVista;
                JUIteratorBinding vIterBinding; 
                Iterator valIterador;
                Key llave;
                RowSetIterator vBinding;
                vIterBinding=(JUIteratorBinding) JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.sis_det_tiempo_extra_vw1Iterator}");  
                //valIterador = this.tblBajas.getSelectionState().getKeySet().iterator();
                 vBinding=vIterBinding.getRowSetIterator();
                Object Var[] =  vIterBinding.getViewObject().getAllRowsInRange();
                int tamano = Var.length ;
                tamano = tamano -1;
                Double auxHora;
                horario hora1;
                horario hora2; 
                Double sumHrExtra = new Double(0);
                while( tamano >=0) {
                    
                    //System.out.println("tamaño. " + Var.length );  
                    //System.out.println("fila No. " + tamano);           
                    auxVista = (sis_det_tiempo_extra_vwRowImpl) Var[tamano];
                    //System.out.println("hora fictisia"+ auxVista.gethrFictisia1());
                    hora1 = new horario(auxVista.gethrFictisia1());
                    if (auxVista.gethrFictisia2().equals("0:00")){
                        hora2 = new horario ("24:01");
                    } else{
                        hora2 = new horario(auxVista.gethrFictisia2());
                    }
                  
                    sumHrExtra = sumHrExtra + hora2.getDiff_Horas(hora1);
                    this.totalHrextra.setValue(sumHrExtra);
                        //System.out.println("hora "+ auxVista.getHoraInicio());
                    
                    tamano --;
                }
                // System.out.println("hora total "+ sumHrExtra);  
                
                this.btn_crearEmpleado.setDisabled(false);
                this.btn_borrar.setDisabled(false);
                this.btn_actividad.setDisabled(false);
                this.btn_guardar.setDisabled(false);
                this.inp_actividad.setDisabled(false);
                this.inp_fecha.setDisabled(false);
                this.inp_hrInicio.setDisabled(false);
                this.inp_hrFin.setDisabled(false);
                this.inp_regEmpleado.setDisabled(false);
                this.btn_crearEmpleado.setDisabled(false);
                this.btn_actividad.setDisabled(false);
                this.btn_CrearDetalle.setDisabled(false);
                
                
               
                 Object varOperacion = "";
                 varOperacion = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{flujo_usuario.operacion}");
                 /*
                 if (varOperacion.equals(1)){ 
                  //ES UNA MODIFICACION A LAS HORAS EXTRAS 
                  Object regEmpleado = ""; 
                  Object varContrato = "";
        
                  interfaz_DB consulta = new interfaz_DB();
                  Object regEmpleado = "";  //
                  Object varContrato = "";
                  varContrato = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), "#{bindings.IdContrato1.inputValue}");
                  String detConsulta = "select registro_empleado from sis_contrato \n" + 
                  "where id_contrato = "+varContrato;   
                  //regEmpleado = consulta.getValorConsultaSimple("registro_empleado",detConsulta);
         
                  regEmpleado = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), "#{bindings.RegistroEmpleado.inputValue}");
                  JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.regEmpleado1.inputValue}", utils.getNumberOracle(regEmpleado) );
                  JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ConsultaEmpleado");
                  varContrato = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.Nombre1.inputValue}");
                  //consulta.cn_Cerrar_coneccion();  
                     //System.out.println("el nombre es .."+varContrato);
                 }
                 
        */
                /*if (!operationBinding.getErrors().isEmpty()) {
                    return null;
                }*/
        
        }
        return null;
    }


    public void setInp_actividad(CoreInputText inp_actividad) {
        this.inp_actividad = inp_actividad;
    }

    public CoreInputText getInp_actividad() {
        return inp_actividad;
    }

    public void setInp_fecha(CoreSelectInputDate inp_fecha) {
        this.inp_fecha = inp_fecha;
    }

    public CoreSelectInputDate getInp_fecha() {
        return inp_fecha;
    }

    public void setInp_hrInicio(CoreInputText inp_hrInicio) {
        this.inp_hrInicio = inp_hrInicio;
    }

    public CoreInputText getInp_hrInicio() {
        return inp_hrInicio;
    }

    public void setInp_hrFin(CoreInputText inp_hrFin) {
        this.inp_hrFin = inp_hrFin;
    }

    public CoreInputText getInp_hrFin() {
        return inp_hrFin;
    }
//metodo utilizado para borrar un empleado de la lista de horas extras asignadas
//metodo asociado al boton borrar de la pagina /gestiones/det_tiempo_extra.jspx
    public String btn_borraEmpleado() {
        boolean resultado;
        /*BindingContainer bindings = getBindings();
        OperationBinding operationBinding = 
            bindings.getOperationBinding("Delete");
            this.btn_save_upEmpleado.setDisabled(false);
        Object result = operationBinding.execute();*/
        
        resultado = JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Delete");
        if (resultado == false) {
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Error Al borrar"));
            return null;
        }
        this.btn_save_upEmpleado.setDisabled(false);
        return null;
    }
// los siguientes 2 metodos estan asociados al boton guardar
//de la pagina /gestiones/det_tiempo_extra.jspx
    public void setBtn_save_upEmpleado(CoreCommandButton btn_save_upEmpleado) {
        this.btn_save_upEmpleado = btn_save_upEmpleado;
    }

    public CoreCommandButton getBtn_save_upEmpleado() {
        return btn_save_upEmpleado;
    }

    public void setInp_regEmpleado(CoreInputText inp_regEmpleado) {
        this.inp_regEmpleado = inp_regEmpleado;
    }

    public CoreInputText getInp_regEmpleado() {
        return inp_regEmpleado;
    }

    public String guardar() {
        boolean resultado;
        
        /*BindingContainer bindings = getBindings();
        OperationBinding operationBinding = 
            bindings.getOperationBinding("Commit");
        Object result = operationBinding.execute();*/
         Object varPartidaGasto,varPartidaSICOIN;
         varPartidaGasto = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), "#{bindings.PartidaGasto1.inputValue}");
        varPartidaSICOIN = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), "#{bindings.PartidaSicoin.inputValue}");
        
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.PartidaSicoin.inputValue}",varPartidaSICOIN);
        resultado = JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit");
        if (resultado == true) {                        
            interfaz_usuario.util.utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Datos Guardados Correctamente."));            
        }
        else{
            interfaz_usuario.util.utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Error al Guardar los Datos."));
        }
        return null;
    }


    public void setTblActividad(CoreTable tblActividad) {
        this.tblActividad = tblActividad;
    }

    public CoreTable getTblActividad() {
        return tblActividad;
    }

    public void setTotalHrextra(CoreOutputText totalHrextra) {
        this.totalHrextra = totalHrextra;
    }

    public CoreOutputText getTotalHrextra() {
        return totalHrextra;
    }

    public String btn_buscar_revisados() {
        // Add event code here...
        if (this.selecEstado.getValue() == null || this.selecEstado.getValue().equals(" ")){
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Debe Seleccionar el estado a buscar "));
            return null;
        }
        Object varUsuario = "";
        varUsuario = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{roles_usuario.directorGeneralFinanciero}");
        if(varUsuario.equals(true)){//el usuario logueado es el director general financiero
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Financiero_revisado");
        }else {
           /* varUsuario = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{roles_usuario.profesionalPresupuesto}");
            if(varUsuario.equals(true)){// el usuario logueado es un profesional de presupuesto
                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Presupuesto_revisado");    
            }
         else {*/
                varUsuario = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{roles_usuario.analistaRecursosHum}");
                if(varUsuario.equals(true)){// el usuario logueado es un profesional de Recursos humanos
                
                //System.out.println("voy a llamar a personal");
                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Personal_revisado");    
                }
            //}
            
        }
        return null;
        
        
    }

    public void setSelecEstado(CoreSelectOneChoice selecEstado) {
        this.selecEstado = selecEstado;
    }

    public CoreSelectOneChoice getSelecEstado() {
        return selecEstado;
    }

    public String btn_modificar_sis17() {
        // Add event code here...
         usuario.set_opciones(usuario.VISTA_OPERACION,1); 
        return "sol_tiempo_extra";
    }

    public String btn_actualizarSis17() {
       boolean resultado;       
        resultado = JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"ActualizaSIS17");
        if (resultado == true) {  
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"resetUnidad");
            interfaz_usuario.util.utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Datos Actualizados Correctamente."));            
            return "gestiones";
        }
        else{
            interfaz_usuario.util.utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Error al Actualizar los Datos."));
            return null;
        }
        
    }

    public String autollenado() {
        boolean resultado;
        resultado = JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"crear_detalle");          
        if (resultado == true ){            
            this.btn_CrearDetalle.setDisabled(true);
        }
        return null;
    }

    public void setBtn_CrearDetalle(CoreCommandButton btn_CrearDetalle) {
        this.btn_CrearDetalle = btn_CrearDetalle;
    }

    public CoreCommandButton getBtn_CrearDetalle() {
        return btn_CrearDetalle;
    }

    public void setShow_rango(CoreShowOneRadio show_rango) {
        this.show_rango = show_rango;
    }

    public CoreShowOneRadio getShow_rango() {
        return show_rango;
    }

    public void setCmbDependencia(CoreSelectOneChoice cmbDependencia) {
        this.cmbDependencia = cmbDependencia;
    }

    public CoreSelectOneChoice getCmbDependencia() {
        return cmbDependencia;
    }

    public void setCmbUnidad(CoreSelectOneChoice cmbUnidad) {
        this.cmbUnidad = cmbUnidad;
    }

    public CoreSelectOneChoice getCmbUnidad() {
        return cmbUnidad;
    }

    public void setCmbPeriodo(CoreSelectOneChoice cmbPeriodo) {
        this.cmbPeriodo = cmbPeriodo;
    }

    public CoreSelectOneChoice getCmbPeriodo() {
        return cmbPeriodo;
    }

    public void setInp_anio(CoreInputText inp_anio) {
        this.inp_anio = inp_anio;
    }

    public CoreInputText getInp_anio() {
        return inp_anio;
    }

    public void setInp_Motivo(CoreInputText inp_Motivo) {
        this.inp_Motivo = inp_Motivo;
    }

    public CoreInputText getInp_Motivo() {
        return inp_Motivo;
    }

    public void setInp_ranFecha(CoreSelectInputDate inp_ranFecha) {
        this.inp_ranFecha = inp_ranFecha;
    }

    public CoreSelectInputDate getInp_ranFecha() {
        return inp_ranFecha;
    }

    public void setInp_rangoFecha2(CoreSelectInputDate inp_rangoFecha2) {
        this.inp_rangoFecha2 = inp_rangoFecha2;
    }

    public CoreSelectInputDate getInp_rangoFecha2() {
        return inp_rangoFecha2;
    }

    public String Siguiente() {
        // Add event code here...
        if(this.cmbDependencia.getValue() == null || this.cmbDependencia.getValue().equals(" ")){
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Debe Seleccionar la dependencia "));
            return null;
        }else if (this.cmbUnidad.getValue() == null || this.cmbUnidad.getValue().equals("")){
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Debe Seleccionar el Subprograma"));
            return null;
        } else if (this.cmbPeriodo.getValue() == null || this.cmbPeriodo.getValue().equals("")){
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Debe Seleccionar el mes"));
            return null;
        }else if (this.inp_anio.getValue() == null || this.inp_anio.getValue().equals("")){
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Debe ingresar el Año"));
            return null;
        }else if (this.inp_Motivo.getValue() == null || this.inp_Motivo.getValue().equals("")){
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Debe ingresar el motivo del tiempo extraordinario"));
            return null;
        }else if (this.inp_ranFecha.getValue() == null || this.inp_ranFecha.getValue().equals("")){
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Debe ingresar la fecha de inicio"));
            return null;
        }else if (this.inp_rangoFecha2.getValue() == null ||this.inp_rangoFecha2.getValue().equals("")){
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Debe ingresar la fecha de Finalizacion"));
            return null;
        }/*else if (this.inp_ranFecha.getValue() != null){
            System.out.println(" toyyyy   y");
            SimpleDateFormat formato = new SimpleDateFormat("MM");
            String cadena = formato.format(this.inp_ranFecha.getValue());
            
            System.out.println(" form"+cadena+" mes "+this.cmbPeriodo.getValue() );
            if(this.cmbPeriodo.getValue().equals(Integer.parseInt(cadena.trim()))){
                utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"La fecha de inicio ingresada no corresponde al mes seleccionado"));
                return null;
            }
            return null;
        }*/else{
            return "detalle_hr_extra";
        }
        
        
        
    }

    public void calcula_anio(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        
       Object Varanio = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{flujo_usuario.anioActual}");
        Number anio;
        anio = utils.getNumber(Varanio);        
       /*  int anio;
        Calendar varFecha = Calendar.getInstance();
        anio = varFecha.get(Calendar.YEAR);        
        */
        
        this.inp_anio.setSubmittedValue(anio);
        this.inp_anio.setValue(anio);
    }

    public void setInp_fechaFin(CoreSelectInputDate inp_fechaFin) {
        this.inp_fechaFin = inp_fechaFin;
    }

    public CoreSelectInputDate getInp_fechaFin() {
        return inp_fechaFin;
    }

    public void setDetailDia(CoreShowDetailItem detailDia) {
        this.detailDia = detailDia;
    }

    public CoreShowDetailItem getDetailDia() {
        return detailDia;
    }

    public String btn_objetar_personal() {
        // Add event code here...
         Object vIdComple;
         String vOutCome;
         
         
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"selHoraExtra");
         
         vIdComple=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdHoraExtra.inputValue}");
            if (vIdComple==null)
                {
                vOutCome=null;
                utils.setADFMensaje(new resulOp(resulOp.OPE_WARN,"Seleccione una gestión de hora Extra"));   
                }else{
                    vOutCome="dialog:auto_sol";
                }
         // System.out.println("autorizarrrrr");
         return vOutCome; 
        //return null;
    }
    
         public void return_objetar(ReturnEvent returnEvent) {
             // Add event code here...
             JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"paramPersonal");
                         
             //System.out.println("salir");
             
         }

    public String btn_autorizar_personal() {
        // Add event code here...
         if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"selHoraExtra"))
         {
         /*
             pIdComple=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdComplemento.inputValue}");
             JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pIdVar1.inputValue}",pIdComple);
         */    
          
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"AutoHoraExtra");
         
            if(JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"AutorizarHora")){
                
                //JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"EjecutarPend");
                //JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"EjecutarRev");
                 JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"paramPersonal");
                utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Se ha autorizado el Tiempo Extraordinario"));
                
            }
             
             
             
             
             
         }
        return null;
    }

    public String btn_guardar_dettTiemExtra() {
        // Add event code here...
        
         if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit")){
         
             utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Se ha actualizado el Tiempo Extraordinario"));
             
         }
        return null;
    }
}
