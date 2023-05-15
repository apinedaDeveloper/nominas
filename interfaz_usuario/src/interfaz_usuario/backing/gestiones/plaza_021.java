package interfaz_usuario.backing.gestiones;

import enlace_datos.consultas.gestiones.anexo.sis_movimiento_plazaRowImpl;

import enlace_datos.consultas.gestiones.plazas021.sis_plazaRowImpl;

import enlace_datos.util.resulOp;
import enlace_datos.util.utils_DB;

import interfaz_usuario.util.JSFUtils;

import interfaz_usuario.util.utils;

import java.sql.ResultSet;

import java.text.DecimalFormat;

import java.util.Calendar;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.faces.component.core.data.CoreTableSelectOne;
import oracle.adf.view.faces.component.core.input.CoreInputText;

import oracle.adf.view.faces.component.core.input.CoreSelectBooleanCheckbox;
import oracle.adf.view.faces.component.core.input.CoreSelectInputDate;
import oracle.adf.view.faces.component.core.input.CoreSelectOneChoice;
import oracle.adf.view.faces.component.core.layout.CorePanelForm;
import oracle.adf.view.faces.component.core.nav.CoreCommandButton;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.domain.Date;

import pkg_util_base_datos.interfaz_DB;

public class plaza_021 {
    public boolean selecUnidad = false;
    private boolean vCambioPartida=false;
    private CoreInputText numPartida;
    private CoreInputText numPlaza;
    private BindingContainer bindings;
    private CoreInputText correlativo;
    private CoreCommandButton btnCrear;
    private CoreCommandButton btnGuardar;
    private CoreSelectOneChoice cmbDependencia;
    private CoreSelectOneChoice cmbUnidad;
    private CoreSelectOneChoice cmbPartida;
    private CoreSelectOneChoice cmbPuesto;
    private CoreSelectOneChoice cmbPeriodoPlaza;
    private CoreSelectOneChoice cmbPartidaSicoin;
    private CoreInputText nomPlaza;
    private CoreInputText dictamen;
    private CoreInputText cantHoras;
    private CoreInputText sueldo;
    private CoreInputText escalafon;
    private CoreInputText complSalarial;
    private CoreSelectInputDate fechainicio;
    private CoreSelectInputDate fechaFin;
    private CoreCommandButton btnActualizar;
    private CoreSelectInputDate fechaCreacion;
    private CoreInputText puesto;
    private CoreSelectOneChoice cmbPartida2;
    private CorePanelForm formulario;
    private CoreTableSelectOne selecPlaza;
    private CoreCommandButton btnListPlazas;
    private CoreInputText varMinimo;
    private CoreCommandButton btnExecute;
    private CoreInputText ampliacion;
    private CoreCommandButton btnAmpliar;
    private CoreCommandButton btnBorrar;
    private CoreCommandButton btnGuardar2;
    private CoreSelectBooleanCheckbox chkPagoUnico;


    public plaza_021() {
    }

    public void combo_dependencia(FacesContext facesContext, UIComponent uiComponent, Object object) {
        // Add event code here...
    }
    
    public boolean getSelecUnidad(){
        return selecUnidad;
    }

    public void seleccionarDependencia(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue() ) {
            selecUnidad = true;
        }
    }

    public boolean getCambioPartida(){
        return vCambioPartida;
    }

    public void cmbPartida(ValueChangeEvent valueChangeEvent){
        // Add event code here...
        if (valueChangeEvent.getOldValue()!=valueChangeEvent.getNewValue()){
            vCambioPartida=true;
        }
    }

    public void calculoNumPlaza(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        
        interfaz_DB consulta = new interfaz_DB();        
        Number anio;
        int varPartida;
        int valActual;
        //Calendar varFecha = Calendar.getInstance();
        varPartida = -1;
        valActual=-1;
        //anio = varFecha.get(Calendar.YEAR); modificado por la variable de sesion que tiene el año actual
        Object varAnio = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{flujo_usuario.anioActual}");
        anio = utils.getNumber(varAnio);
        if (this.numPartida.getValue() == null){
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Antes de seleccionar el puesto debe seleccionar la partida"));
        }
        else {
            if (this.numPlaza.getValue() == null || this.numPlaza.getValue().equals("")){
                varPartida = Integer.parseInt(this.numPartida.getValue().toString());
                String varquerry = "select nvl(max(plaza.NUMERO_PLAZA),0) as numeroPlaza  from sis_plaza plaza\n" + 
                "where plaza.ID_PARTIDA = "+varPartida + " and correlativo =  "+ anio ;
                Object auxiliar = consulta.getValorConsultaSimple("numeroPlaza",varquerry);
                valActual = Integer.parseInt(auxiliar.toString().trim())+1;
                Number aux= valActual;
                //JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.NumeroPlaza.inputValue}",valActual);
                numPlaza.setSubmittedValue(valActual);
                numPlaza.setValue(valActual);
                correlativo.setSubmittedValue(anio);
                correlativo.setValue(anio);
                this.escalafon.setSubmittedValue(0);
                escalafon.setValue(0);
                this.complSalarial.setSubmittedValue(0);
                this.complSalarial.setValue(0);
            }
        }
        consulta.cn_Cerrar_coneccion();
        
    }

    public void setNumPartida(CoreInputText numPartida) {
        this.numPartida = numPartida;
    }

    public CoreInputText getNumPartida() {
        return numPartida;
    }

    public void setNumPlaza(CoreInputText numPlaza) {
        this.numPlaza = numPlaza;
    }

    public CoreInputText getNumPlaza() {
        return numPlaza;
    }

    public BindingContainer getBindings() {
        return this.bindings;
    }

    public void setBindings(BindingContainer bindings) {
        this.bindings = bindings;
    }

    public String commandCrear_Plaza() {
       
        Object vNomSubprog,vCodSubprog;
        
        vNomSubprog=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.NombreSubprog.inputValue}");
        vCodSubprog=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.subprog1.inputValue}");
        
        /*
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = 
            bindings.getOperationBinding("Crear");
        Object result = operationBinding.execute();
        
        */
        
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Crear");
        
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"filtraPartida");
        
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pHabilitaPrest1.inputValue}",true);
        
        if (vNomSubprog!=null && (vNomSubprog.toString().indexOf("VACACION")>0) || vNomSubprog.toString().indexOf("PRE-UNIVER")>0 ){
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.PlazaCvacacion.inputValue}",utils.getNumberOracle("1"));
        }else{
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.PlazaCvacacion.inputValue}",utils.getNumberOracle("0"));
        }
    
        if (vCodSubprog.toString().equals("45.04.204")){ // curso de PREPARACION EXAMENES PRIVADOS
          this.chkPagoUnico.setRendered(true);
          this.chkPagoUnico.setDisabled(false);
          JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pHabilitaPrest1.inputValue}",false);
          JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.PagaMesVaca.inputValue}",false);
        }else{
            this.chkPagoUnico.setRendered(false);
            //JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.PlazaCvacacion.inputValue}",utils.getNumberOracle("0"));
        }
        
        this.btnGuardar.setDisabled(true);
        this.btnGuardar2.setDisabled(true);
        this.btnCrear.setDisabled(true);
        this.cmbDependencia.setDisabled(true);
        this.cmbUnidad.setDisabled(true);
        this.cmbPartida.setDisabled(false);
        this.cmbPeriodoPlaza.setDisabled(false);
        this.cmbPuesto.setDisabled(false);
        this.cantHoras.setDisabled(false);
        this.nomPlaza.setDisabled(false);
        this.numPartida.setDisabled(false);
        this.numPlaza.setDisabled(false);
        this.complSalarial.setDisabled(false);
        this.escalafon.setDisabled(false);
        this.sueldo.setDisabled(false);
        this.fechaFin.setDisabled(false);
        this.fechainicio.setDisabled(false);
        //this.correlativo.setDisabled(false);
        this.dictamen.setDisabled(false);
        
        this.formulario.setRendered(true);
        this.cmbPartida2.setRendered(false);
        this.btnListPlazas.setRendered(false);
        this.btnExecute.setDisabled(false);
        this.btnAmpliar.setDisabled(true);
        this.btnActualizar.setDisabled(true);
        this.btnBorrar.setDisabled(true);
       
        //System.out.println(" debug  " + vCodSubprog);
        return null;
    }

    public void setCorrelativo(CoreInputText correlativo) {
        this.correlativo = correlativo;
    }

    public CoreInputText getCorrelativo() {
        return correlativo;
    }

    public void setBtnCrear(CoreCommandButton btnCrear) {
        this.btnCrear = btnCrear;
    }

    public CoreCommandButton getBtnCrear() {
        return btnCrear;
    }

    public void setBtnGuardar(CoreCommandButton btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    public CoreCommandButton getBtnGuardar() {
        return btnGuardar;
    }

    public String boton_Actualizar() {
    
        Double sueldo;
        Double hor;
        DecimalFormat redondear = new DecimalFormat("0.00");
        Object varsueldo;
        //verificando que no este en blaco la fecha inicio y la fecha fin    
        if (this.fechainicio.getValue() == null|| fechainicio.getValue().equals("") ){
              utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Debe ingresar la fecha de inicio"));
              return null;
          }else if (this.fechaFin.getValue() == null || this.fechaFin.getValue().equals("")){
              utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Debe ingresar la fecha fin"));
              return null;
          }else if(this.cantHoras.getValue() == null){
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Debe ingresar el No. de horas"));
            return null;    
        }else if (this.cmbPeriodoPlaza.getValue() == null){
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Debe seleccional el regimen de la Unidad"));
            return null;
        /*}else if (this.cmbPartidaSicoin.getValue() == null){
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Debe seleccionar una PARTIDA DE SICOIN"));
            return null;*/
        }
          
        //verificando que la fecha de inicio no sea mayor a la fecha de finalizacion
        Date aux =  utils.getFechaOracle(utils.getFechaFormato3("dd/MM/yyyy",this.getFechainicio().getValue() ));            
        Date aux1 = utils.getFechaOracle(utils.getFechaFormato3("dd/MM/yyyy",this.getFechaFin().getValue()));
        if(aux.compareTo(aux1) > 0 ) {
             //this.btnActualizar.setDisabled(false);
             this.btnExecute.setDisabled(false);
             //botonEjecutar.setDisabled(false);
             utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"La fecha de inicio es mayor que la fecha fin "));
             return null;
        }
        
        if (this.ampliacion.getValue() != null){// se esta reutilizando la plaza 
            interfaz_DB interfaz = new interfaz_DB();
             String consulta = "select to_char(max(mov.FECHA_fin),'dd/mm/yyyy') as fecha_fin from sis_movimiento_plaza mov " + 
             " where mov.ID_ANEXO = 2402" +                  
             " and mov.ID_PARTIDA = " +utils.getNumberOracle(this.numPartida.getValue())+
             " and mov.CORRELATIVO =  " + utils.getNumberOracle(this.correlativo.getValue())  +
             " and mov.ID_PUESTO = "+utils.getNumberOracle(this.puesto.getValue()) + 
             " and mov.NUMERO_PLAZA = " +utils.getNumberOracle(this.numPlaza.getValue());
            
            Object vFecha = interfaz.getValorConsultaSimple("fecha_fin",consulta);
            Date varFecha = utils.getFechaOracle(vFecha.toString());
            interfaz.cn_Cerrar_coneccion(); //cierro la coneccion a la base d datos
            //int valor = varFecha.compareTo(aux);
            if(varFecha.compareTo(aux)>=0){
                utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"La fecha de incio debe ser mayor a "+vFecha));
                return null;
            }
        }  
        // calculo el sueldo de la plaza nueva de acuerdo a la escala minima
        if (varMinimo.getValue()!=null )   {
                //Object varsueldo = varMinimo.getValue();
               // Integer sueldo =  Integer.parseInt(varsueldo.toString().trim());
               sueldo = new Double(varMinimo.getValue().toString().trim());
               //sueldo.valueOf( );
              // sueldo = (double)varMinimo.getValue();
                //calcula el sueldo base si la escala minima es mayor a 0
                //System.out.println("esto tiene sueldo" + sueldoBase.getValue());
                if (sueldo > 0){
                        //System.out.println("entre al ifff uuuuuuu");
                        if (cantHoras.getValue() == null){//fue ingresada la cantidad de horas
                            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"DEBE INGRESAR UNA CANTIDAD DE HORAS"));
                            
                            //this.btnActualizar.setDisabled(false);
                            this.btnGuardar.setDisabled(true);
                            this.btnGuardar2.setDisabled(true);
                            this.btnCrear.setDisabled(true);
                           // throw new JboException("DEBE INGRESAR UNA CANTIDAD DE HORAS");
                        }
                        else{
                            //Object varhora = horas.getValue();
                            //Integer hor = Integer.parseInt(varhora.toString().trim());
                            hor = new Double( cantHoras.getValue().toString().trim());
                            sueldo = sueldo.doubleValue() * hor.doubleValue();
                            varsueldo = redondear.format(sueldo.doubleValue());
                            this.sueldo.setSubmittedValue(null);
                            this.sueldo.setValue(varsueldo);
        
                            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.SalarioBase.inputValue}",utils.getNumberOracle(varsueldo));
                            sis_plazaRowImpl varMovimiento = (sis_plazaRowImpl)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.sis_plaza1Iterator.currentRow}");
                            varMovimiento.setSalarioBase(utils.getNumberOracle(varsueldo));
                            
                            btnGuardar.setDisabled(false);
                            this.btnGuardar2.setDisabled(false);
                            
                            btnCrear.setDisabled(false);
                            //SalarioBase.setPartialTriggers(new String[]{});
                            btnActualizar.setDisabled(false);
                            this.btnExecute.setDisabled(true);
                           // System.out.println("imprimiendoo execute con " + sueldo);
                        }
                }
                else { //el puesto tiene escala minima = 0
                    utils.setADFMensaje(new resulOp(resulOp.OPE_WARN ,"EL PUESTO TIENE 0 EN ESCALA MININA, DEBIO HABER INGRESADO EL SUELDO BASE CORRECTO"));
                        
                    btnActualizar.setDisabled(false);
                    this.btnBorrar.setDisabled(false);
                    this.btnExecute.setDisabled(true);
                    btnGuardar.setDisabled(false);
                    this.btnGuardar2.setDisabled(false);
                    btnCrear.setDisabled(false);
                    this.cmbPartida.setDisabled(true);
                    this.cmbPeriodoPlaza.setDisabled(true);
                    this.cmbPuesto.setDisabled(true);
                    return null;
                }
            //utils.getFechaOracle(this.fecha_inicio.getValue().toString()).compareTo(utils.getFechaOracle(this.fecha_fin.getValue().toString()));
        }
        else {
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR ,"Debe seleccionar el puesto"));
            return null;
        }    
        
       /*   
        if(this.sueldo.getValue()== null){
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Debe ingresar el sueldo base"));
            return null;
        }
        */
        
        //verificando que la fecha de inicio no sea mayor a la fecha de finalizacion
        
       
       // BindingContainer bindings = getBindings();
        //OperationBinding operationBinding = 
          //  bindings.getOperationBinding("Execute");
        //Object result = operationBinding.execute();
        this.btnGuardar.setDisabled(false);
        this.btnGuardar2.setDisabled(false);
        this.btnCrear.setDisabled(false);
        //this.cmbDependencia.setDisabled(false);
        //this.cmbUnidad.setDisabled(false);
        
        this.cmbPartida.setDisabled(true);
        this.cmbPeriodoPlaza.setDisabled(true);
        this.cmbPuesto.setDisabled(true);
        this.cantHoras.setDisabled(true);
        this.nomPlaza.setDisabled(true);
        this.numPartida.setDisabled(true);
        this.numPlaza.setDisabled(true);
        this.complSalarial.setDisabled(true);
        this.escalafon.setDisabled(true);
        this.sueldo.setDisabled(true);
        this.fechaFin.setDisabled(true);
        this.fechainicio.setDisabled(true);
        //this.correlativo.setDisabled(true);
        this.dictamen.setDisabled(true);
        
        this.selecPlaza.setDisabled(false);
        this.btnExecute.setDisabled(true);
        this.btnActualizar.setDisabled(false);
        this.btnBorrar.setDisabled(false);
        this.chkPagoUnico.setDisabled(true);
        
        //if (!operationBinding.getErrors().isEmpty()) {
          //  return null;
        //}
        return null;
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

    public void setCmbPartida(CoreSelectOneChoice cmbPartida) {
        this.cmbPartida = cmbPartida;
    }

    public CoreSelectOneChoice getCmbPartida() {
        return cmbPartida;
    }

    public void setCmbPuesto(CoreSelectOneChoice cmbPuesto) {
        this.cmbPuesto = cmbPuesto;
    }

    public CoreSelectOneChoice getCmbPuesto() {
        return cmbPuesto;
    }

    public void setCmbPeriodoPlaza(CoreSelectOneChoice cmbPeriodoPlaza) {
        this.cmbPeriodoPlaza = cmbPeriodoPlaza;
    }

    public CoreSelectOneChoice getCmbPeriodoPlaza() {
        return cmbPeriodoPlaza;
    }

    public void setNomPlaza(CoreInputText nomPlaza) {
        this.nomPlaza = nomPlaza;
    }

    public CoreInputText getNomPlaza() {
        return nomPlaza;
    }

    public void setDictamen(CoreInputText dictamen) {
        this.dictamen = dictamen;
    }

    public CoreInputText getDictamen() {
        return dictamen;
    }

    public void setCantHoras(CoreInputText cantHoras) {
        this.cantHoras = cantHoras;
    }

    public CoreInputText getCantHoras() {
        return cantHoras;
    }

    public void setSueldo(CoreInputText sueldo) {
        this.sueldo = sueldo;
    }

    public CoreInputText getSueldo() {
        return sueldo;
    }

    public void setEscalafon(CoreInputText escalafon) {
        this.escalafon = escalafon;
    }

    public CoreInputText getEscalafon() {
        return escalafon;
    }

    public void setComplSalarial(CoreInputText complSalarial) {
        this.complSalarial = complSalarial;
    }

    public CoreInputText getComplSalarial() {
        return complSalarial;
    }

    public void setFechainicio(CoreSelectInputDate fechainicio) {
        this.fechainicio = fechainicio;
    }

    public CoreSelectInputDate getFechainicio() {
        return fechainicio;
    }

    public void setFechaFin(CoreSelectInputDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public CoreSelectInputDate getFechaFin() {
        return fechaFin;
    }

    public void setBtnActualizar(CoreCommandButton btnActualizar) {
        this.btnActualizar = btnActualizar;
    }

    public CoreCommandButton getBtnActualizar() {
        return btnActualizar;
    }

    public String botonGuardar() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("Commit");
        Object result = operationBinding.execute();
        this.btnCrear.setRendered(true);
        this.btnListPlazas.setRendered(true);
        this.formulario.setRendered(false);
        this.cmbPartida2.setRendered(true);
        this.cmbDependencia.setDisabled(false);
        this.cmbUnidad.setDisabled(false);
        this.btnGuardar.setDisabled(true);
        this.btnGuardar2.setDisabled(true);
        this.btnAmpliar.setDisabled(false);
        if (operationBinding.getErrors().isEmpty()) {
            utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Datos guardados correctamente."));
            //return null;
        }else {
            this.btnExecute.setDisabled(false);
        }
        return null;
    }

    public String botonModificar() {
        // Add event code here...
        Object vNomSubprog;
         
        vNomSubprog=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.NombreSubprog.inputValue}");
                  
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pHabilitaPrest1.inputValue}",true);
        
        if (vNomSubprog!=null && (vNomSubprog.toString().indexOf("VACACION")>0) || vNomSubprog.toString().indexOf("PRE-UNIVER")>0 ){
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.PlazaCvacacion.inputValue}",utils.getNumberOracle("1"));
        }else{
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.PlazaCvacacion.inputValue}",utils.getNumberOracle("0"));
        }
         //JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.ampliacion.inputValue}",null);
        if (this.fechaCreacion.getValue() == null) {
        // la plaza aun no ha sidgo guardada por lo tanto puede modificarse.
            this.cmbPartida.setDisabled(false);
            this.cmbPeriodoPlaza.setDisabled(false);
            this.cmbPuesto.setDisabled(false);
            this.cantHoras.setDisabled(false);
            this.nomPlaza.setDisabled(false);
            this.numPartida.setDisabled(false);
            this.numPlaza.setDisabled(false);
            this.complSalarial.setDisabled(false);
            this.escalafon.setDisabled(false);
            this.sueldo.setDisabled(false);
            this.fechaFin.setDisabled(false);
            this.fechainicio.setDisabled(false);
            //this.correlativo.setDisabled(false);
            this.dictamen.setDisabled(false);
            this.btnGuardar.setDisabled(true);     
            this.btnGuardar2.setDisabled(true);
            this.btnExecute.setDisabled(false);
            this.formulario.setRendered(true);
            this.btnAmpliar.setDisabled(true);
        }
        else {
            interfaz_DB interfaz = new interfaz_DB();
            //consulta para llamar la funcion que valida si es viable modificar la plaza
            String consulta = "select sis_pkg_util.VALIDAR_MOD_DEL_PLAZA021(" + utils.getNumberOracle(numPartida.getValue())+","+utils.getNumberOracle(puesto.getValue())+","+
            utils.getNumberOracle(numPlaza.getValue())+","+utils.getNumberOracle(correlativo.getValue())+","+2+ ") as contrato from dual";
            Object varContrato = interfaz.getValorConsultaSimple("contrato",consulta);
            interfaz.cn_Cerrar_coneccion();
            if (varContrato.toString().trim().equals("1")) {//la plaza no tiene ningun contrato asociado puede ser modificado.
                this.cmbPartida.setDisabled(false);
                this.cmbPeriodoPlaza.setDisabled(false);
                this.cmbPuesto.setDisabled(false);
                this.cantHoras.setDisabled(false);
                this.nomPlaza.setDisabled(false);
                this.numPartida.setDisabled(false);
                this.numPlaza.setDisabled(true);
                this.complSalarial.setDisabled(false);
                this.escalafon.setDisabled(false);
                this.sueldo.setDisabled(false);
                this.fechaFin.setDisabled(false);
                this.fechainicio.setDisabled(false);
                //this.correlativo.setDisabled(false);
                this.dictamen.setDisabled(false);
                this.btnGuardar.setDisabled(true);
                this.btnGuardar2.setDisabled(true);
                this.selecPlaza.setDisabled(true);
                this.formulario.setRendered(true);
                this.btnExecute.setDisabled(false);
                this.btnBorrar.setDisabled(true);
                this.btnActualizar.setDisabled(true);
                this.btnAmpliar.setDisabled(true);                               
            }
            else{ // la plaza tiene un contrato no puede ser modificado
                utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR ,"La plaza tiene el contrato No. "+ varContrato+" No puede ser modificado"));
            }
            //interfaz.cn_Cerrar_coneccion();
        }
        //Para refrescar el combo de partidas SICOIN
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("PlazasSicoin");
        Object result = operationBinding.execute();
         
        return null;
    }

    public String plazas_Guardadas() {
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Quitareset");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"listPlazas");
        this.cmbPartida.setDisabled(true);
        this.cmbPeriodoPlaza.setDisabled(true);
        this.cmbPuesto.setDisabled(true);
        this.cantHoras.setDisabled(true);
        this.nomPlaza.setDisabled(true);
        this.numPartida.setDisabled(true);
        this.numPlaza.setDisabled(true);
        this.complSalarial.setDisabled(true);
        this.escalafon.setDisabled(true);
        this.sueldo.setDisabled(true);
        this.fechaFin.setDisabled(true);
        this.fechainicio.setDisabled(true);
       // this.correlativo.setDisabled(true);
        this.dictamen.setDisabled(true);
        this.cmbDependencia.setDisabled(false);
        this.cmbUnidad.setDisabled(false);
        
        this.formulario.setRendered(false);
        this.cmbPartida2.setRendered(false);
        this.btnCrear.setRendered(false);
        //this.btnGuardar.setDisabled(false);
        this.btnActualizar.setDisabled(false);
        this.btnBorrar.setDisabled(false);
        this.btnAmpliar.setDisabled(false);
        this.ampliacion.setValue(null);
        
        return null;
    }

    public void setFechaCreacion(CoreSelectInputDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public CoreSelectInputDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setPuesto(CoreInputText puesto) {
        this.puesto = puesto;
    }

    public CoreInputText getPuesto() {
        return puesto;
    }

    public String botonBorrar() {
    
        if (this.fechaCreacion.getValue() == null) {//la plaza aun no ha sido guarda puede ser eliminado
            BindingContainer bindings = getBindings();
            OperationBinding operationBinding = bindings.getOperationBinding("Delete");
            Object result = operationBinding.execute();
            this.cmbPartida.setDisabled(true);
            this.cmbPeriodoPlaza.setDisabled(true);
            this.cmbPuesto.setDisabled(true);
            this.cantHoras.setDisabled(true);
            this.nomPlaza.setDisabled(true);
            this.numPartida.setDisabled(true);
            this.numPlaza.setDisabled(true);
            this.complSalarial.setDisabled(true);
            this.escalafon.setDisabled(true);
            this.sueldo.setDisabled(true);
            this.fechaFin.setDisabled(true);
            this.fechainicio.setDisabled(true);
           // this.correlativo.setDisabled(true);
            this.dictamen.setDisabled(true);
            this.formulario.setRendered(true);
            if (!operationBinding.getErrors().isEmpty()) {
                return null;
            }
        }
        else {
            interfaz_DB interfaz = new interfaz_DB();
            //consulta para llamar la funcion que valida si es viable modificar la plaza
            String consulta = "select sis_pkg_util.VALIDAR_MOD_DEL_PLAZA021(" + utils.getNumberOracle(numPartida.getValue())+","+utils.getNumberOracle(puesto.getValue())+","+
            utils.getNumberOracle(numPlaza.getValue())+","+utils.getNumberOracle(correlativo.getValue())+","+1+ ") as contrato from dual";
            Object varContrato = interfaz.getValorConsultaSimple("contrato",consulta);
            interfaz.cn_Cerrar_coneccion();
            if (varContrato.toString().trim().equals("1")) {//la plaza no tiene ningun contrato asociado puede ser eliminado.
                BindingContainer bindings = getBindings();
                OperationBinding operationBinding = 
                    bindings.getOperationBinding("Delete");
                Object result = operationBinding.execute();
                this.cmbPartida.setDisabled(true);
                this.cmbPeriodoPlaza.setDisabled(true);
                this.cmbPuesto.setDisabled(true);
                this.cantHoras.setDisabled(true);
                this.nomPlaza.setDisabled(true);
                this.numPartida.setDisabled(true);
                this.numPlaza.setDisabled(true);
                this.complSalarial.setDisabled(true);
                this.escalafon.setDisabled(true);
                this.sueldo.setDisabled(true);
                this.fechaFin.setDisabled(true);
                this.fechainicio.setDisabled(true);
                //this.correlativo.setDisabled(true);
                this.dictamen.setDisabled(true);
                this.formulario.setRendered(true);
                
                if (!operationBinding.getErrors().isEmpty()) {
                    return null;
                } 
            }
            else{ // la plaza tiene un contrato no puede ser eliminado
                utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR ,"La plaza tiene el contrato No. "+ varContrato+" No puede ser borrado"));
            }
            //interfaz.cn_Cerrar_coneccion();
        }
        
        return null;
    }

    public void setCmbPartida2(CoreSelectOneChoice cmbPartida2) {
        this.cmbPartida2 = cmbPartida2;
    }

    public CoreSelectOneChoice getCmbPartida2() {
        return cmbPartida2;
    }

    public void setFormulario(CorePanelForm formulario) {
        this.formulario = formulario;
    }

    public CorePanelForm getFormulario() {
        return formulario;
    }

    public void setSelecPlaza(CoreTableSelectOne selecPlaza) {
        this.selecPlaza = selecPlaza;
    }

    public CoreTableSelectOne getSelecPlaza() {
        return selecPlaza;
    }

    public void setBtnListPlazas(CoreCommandButton btnListPlazas) {
        this.btnListPlazas = btnListPlazas;
    }

    public CoreCommandButton getBtnListPlazas() {
        return btnListPlazas;
    }

    public String botonCancelar() {
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"reset");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Quitareset");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Rollback");
        //BindingContainer bindings = getBindings();
        //OperationBinding operationBinding = 
            //bindings.getOperationBinding("Rollback");
        //Object result = operationBinding.execute();
        this.btnCrear.setRendered(true);
        this.btnListPlazas.setRendered(true);
        this.formulario.setRendered(false);
        this.cmbPartida2.setRendered(true);
        this.cmbDependencia.setDisabled(false);
        this.cmbUnidad.setDisabled(false);
        
        //if (!operationBinding.getErrors().isEmpty()) {
          //  return null;
        //}
        return "gestiones";
    }

    public void setVarMinimo(CoreInputText varMinimo) {
        this.varMinimo = varMinimo;
    }

    public CoreInputText getVarMinimo() {
        return varMinimo;
    }

    public void setBtnExecute(CoreCommandButton btnExecute) {
        this.btnExecute = btnExecute;
    }

    public CoreCommandButton getBtnExecute() {
        return btnExecute;
    }

    public String botonAmpliar() {
        // Add event code here...
        
        Object vNomSubprog;
         
        vNomSubprog=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.NombreSubprog.inputValue}");
                  
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pHabilitaPrest1.inputValue}",true);
         
        if (vNomSubprog!=null && (vNomSubprog.toString().indexOf("VACACION")>0) || vNomSubprog.toString().indexOf("PRE-UNIVER")>0 ){
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.PlazaCvacacion.inputValue}",utils.getNumberOracle("1"));
        }else{
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.PlazaCvacacion.inputValue}",utils.getNumberOracle("0"));
        }

        //JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.ampliacion.inputValue}",1);
        interfaz_DB interfaz = new interfaz_DB();
        //consulta para llamar la funcion que valida si es viable modificar la plaza
        String consulta = "select sis_pkg_util.VALIDAR_MOD_DEL_PLAZA021(" + utils.getNumberOracle(numPartida.getValue())+","+utils.getNumberOracle(puesto.getValue())+","+
        utils.getNumberOracle(numPlaza.getValue())+","+utils.getNumberOracle(correlativo.getValue())+","+2+ ") as contrato from dual";
        Object varContrato = interfaz.getValorConsultaSimple("contrato",consulta);
        interfaz.cn_Cerrar_coneccion();
              
        if (varContrato.toString().trim().equals("1")) {//la plaza no tiene ningun contrato asociado puede ser modificado.
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR ,"La plaza no tiene ningun contrato asociado, no puede ser ampliada solamente modificada.  Utilice la opción Modificar"));  
        }
        else {
            this.ampliacion.setValue(1);
            //this.ampliacion.setAutoSubmit(true);
            this.cmbPartida.setDisabled(true);
            this.cmbPeriodoPlaza.setDisabled(true);
            this.cmbPuesto.setDisabled(true);
            this.cantHoras.setDisabled(false);
            this.nomPlaza.setDisabled(false);
            this.numPartida.setDisabled(true);
            this.numPlaza.setDisabled(true);
            this.complSalarial.setDisabled(false);
            this.escalafon.setDisabled(false);
            this.sueldo.setDisabled(false);
            this.fechaFin.setDisabled(false);
            this.fechainicio.setDisabled(false);
            // this.correlativo.setDisabled(true);
            this.dictamen.setDisabled(false);
            this.btnGuardar.setDisabled(true);
            this.btnGuardar2.setDisabled(true);
            this.selecPlaza.setDisabled(true);
            this.formulario.setRendered(true);
            this.btnExecute.setDisabled(false);
            this.btnBorrar.setDisabled(true);
            this.btnActualizar.setDisabled(true);
            this.btnAmpliar.setDisabled(true);
        }               

        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("PlazasSicoin");
        Object result = operationBinding.execute();
         
         //interfaz.cn_Cerrar_coneccion();
        return null;
    }

    public void setAmpliacion(CoreInputText ampliacion) {
        this.ampliacion = ampliacion;
    }

    public CoreInputText getAmpliacion() {
        return ampliacion;
    }

    public void setBtnAmpliar(CoreCommandButton btnAmpliar) {
        this.btnAmpliar = btnAmpliar;
    }

    public CoreCommandButton getBtnAmpliar() {
        return btnAmpliar;
    }

    public void setBtnBorrar(CoreCommandButton btnBorrar) {
        this.btnBorrar = btnBorrar;
    }

    public CoreCommandButton getBtnBorrar() {
        return btnBorrar;
    }

    public void setBtnGuardar2(CoreCommandButton btnGuardar2) {
        this.btnGuardar2 = btnGuardar2;
    }

    public CoreCommandButton getBtnGuardar2() {
        return btnGuardar2;
    }

    public void cmb_subprograma_value(ValueChangeEvent valueChangeEvent) {
    
     if (valueChangeEvent.getOldValue()!=valueChangeEvent.getNewValue()){
         
      //   valueChangeEvent.getNewValue();
     }
        // Add event code here...
    }

    public void setChkPagoUnico(CoreSelectBooleanCheckbox chkPagoUnico) {
        this.chkPagoUnico = chkPagoUnico;
    }

    public CoreSelectBooleanCheckbox getChkPagoUnico() {
        return chkPagoUnico;
    }

    public void setCmbPartidaSicoin(CoreSelectOneChoice cmbPartidaSicoin) {
        this.cmbPartidaSicoin = cmbPartidaSicoin;
    }

    public CoreSelectOneChoice getCmbPartidaSicoin() {
        return cmbPartidaSicoin;
    }
}
