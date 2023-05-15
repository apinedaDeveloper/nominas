package interfaz_usuario.backing.gestiones;

import enlace_datos.util.resulOp;

import interfaz_usuario.util.JSFUtils;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.faces.component.core.input.CoreInputText;
import oracle.adf.view.faces.component.core.input.CoreSelectInputDate;
import oracle.adf.view.faces.component.core.input.CoreSelectOneChoice;

import oracle.adf.view.faces.component.core.layout.CoreShowDetailItem;
import oracle.adf.view.faces.component.core.nav.CoreCommandButton;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class dictamen {
    public boolean selecUnidad = false;
    private CoreInputText numero_plaza;
    private CoreSelectOneChoice tipo_operacion;
    private BindingContainer bindings;
    private CoreCommandButton btn_crear;
    private CoreSelectOneChoice cmbPartida;
    private CoreSelectOneChoice cmbPuesto;
    private CoreInputText cantidad_horas;
    private CoreInputText sueldo_base;
    private CoreSelectInputDate fechaInicio;
    private CoreSelectInputDate fechaFin;
    private CoreInputText horario;
    private CoreCommandButton btn_actualizar;
    private CoreCommandButton btn_guardar;
    private CoreCommandButton btn_modificar;
    private CoreCommandButton btn_borrar;
    private CoreShowDetailItem pestanaPlazas;
    private CoreShowDetailItem pestanaDictamen;
    

    public dictamen() {
    }

    public void selecDependencia(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue()){
            selecUnidad = true;
        }
    }

    public String Crear() {
       JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Create1");
       JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"filtraPartida");
      
       
        this.tipo_operacion.setDisabled(false);
        this.cmbPartida.setDisabled(false);
        this.cmbPuesto.setDisabled(false);
        this.numero_plaza.setDisabled(false);
        this.cantidad_horas.setDisabled(false);
        this.sueldo_base.setDisabled(false);
        this.horario.setDisabled(false);
        this.fechaFin.setDisabled(false);
        this.fechaInicio.setDisabled(false);
        this.btn_guardar.setDisabled(true);
        this.btn_modificar.setDisabled(true);
        this.btn_borrar.setDisabled(true);
        this.btn_actualizar.setDisabled(false);
        this.btn_crear.setDisabled(true);        
        this.pestanaDictamen.setDisabled(true);
        return null;
    }
    //devuelve si fue o no seleccionado la unidad.
    public boolean getSelecUnidad(){
        
        return selecUnidad;
    }

    public void setNumero_plaza(CoreInputText numero_plaza) {
        this.numero_plaza = numero_plaza;
    }

    public CoreInputText getNumero_plaza() {
        return numero_plaza;
    }

    public void setTipo_operacion(CoreSelectOneChoice tipo_operacion) {
        this.tipo_operacion = tipo_operacion;
    }

    public CoreSelectOneChoice getTipo_operacion() {
        return tipo_operacion;
    }

    public void selecOperacion(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
       // System.out.println("tipo operacion  "+ selecUnidad);
        
        if (this.tipo_operacion.getValue().equals("A")){
            this.numero_plaza.setRendered(true);
            this.numero_plaza.setDisabled(false);
            //System.out.println("tipo operacion1  "+this.tipo_operacion.getValue());
        }
        else{
            this.numero_plaza.setRendered(false);
            this.numero_plaza.setAutoSubmit(true);
            this.numero_plaza.setDisabled(true);
            //System.out.println("tipo operacion2  "+this.tipo_operacion.getValue());
        }
        
    }

    public BindingContainer getBindings() {
        return this.bindings;
    }

    public void setBindings(BindingContainer bindings) {
        this.bindings = bindings;
    }

    public String Guardar() {
    
        boolean resultado;
        resultado = JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit");
        
        if (resultado == true) {
            interfaz_usuario.util.utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Datos Guardados Correctamente."));
        }
        else {
            interfaz_usuario.util.utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Error al Guardar los Datos."));
        }
        
        return null;
    }


    public void setBtn_crear(CoreCommandButton btn_crear) {
        this.btn_crear = btn_crear;
    }

    public CoreCommandButton getBtn_crear() {
        return btn_crear;
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

    public void setCantidad_horas(CoreInputText cantidad_horas) {
        this.cantidad_horas = cantidad_horas;
    }

    public CoreInputText getCantidad_horas() {
        return cantidad_horas;
    }

    public void setSueldo_base(CoreInputText sueldo_base) {
        this.sueldo_base = sueldo_base;
    }

    public CoreInputText getSueldo_base() {
        return sueldo_base;
    }

    public void setFechaInicio(CoreSelectInputDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public CoreSelectInputDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaFin(CoreSelectInputDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public CoreSelectInputDate getFechaFin() {
        return fechaFin;
    }

    public void setHorario(CoreInputText horario) {
        this.horario = horario;
    }

    public CoreInputText getHorario() {
        return horario;
    }

    public void setBtn_actualizar(CoreCommandButton btn_actualizar) {
        this.btn_actualizar = btn_actualizar;
    }

    public CoreCommandButton getBtn_actualizar() {
        return btn_actualizar;
    }

    public void setBtn_guardar(CoreCommandButton btn_guardar) {
        this.btn_guardar = btn_guardar;
    }

    public CoreCommandButton getBtn_guardar() {
        return btn_guardar;
    }

    public String actualizar() {
    
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Execute");
        this.tipo_operacion.setDisabled(true);
        this.cmbPartida.setDisabled(true);
        this.cmbPuesto.setDisabled(true);
        this.numero_plaza.setDisabled(true);
        this.cantidad_horas.setDisabled(true);
        this.sueldo_base.setDisabled(true);
        this.horario.setDisabled(true);
        this.fechaFin.setDisabled(true);
        this.fechaInicio.setDisabled(true);
        this.btn_guardar.setDisabled(false);
        this.btn_crear.setDisabled(false);
        this.btn_modificar.setDisabled(false);
        this.btn_actualizar.setDisabled(true);
        this.btn_borrar.setDisabled(false);
       /* BindingContainer bindings = getBindings();
        OperationBinding operationBinding = 
            bindings.getOperationBinding("Execute");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }*/
        return null;
    }

    public void setBtn_modificar(CoreCommandButton btn_modificar) {
        this.btn_modificar = btn_modificar;
    }

    public CoreCommandButton getBtn_modificar() {
        return btn_modificar;
    }

    public String modificar() {
        // Add event code here...
         this.tipo_operacion.setDisabled(false);
         this.cmbPartida.setDisabled(false);
         this.cmbPuesto.setDisabled(false);
         this.numero_plaza.setDisabled(false);
         this.cantidad_horas.setDisabled(false);
         this.sueldo_base.setDisabled(false);
         this.horario.setDisabled(false);
         this.fechaFin.setDisabled(false);
         this.fechaInicio.setDisabled(false);
         this.btn_guardar.setDisabled(true);
         this.btn_crear.setDisabled(true);
         this.btn_actualizar.setDisabled(false);
        return null;
    }

    public void setBtn_borrar(CoreCommandButton btn_borrar) {
        this.btn_borrar = btn_borrar;
    }

    public CoreCommandButton getBtn_borrar() {
        return btn_borrar;
    }

    public String continuar() {
        // Add event code here...
        this.pestanaPlazas.setDisabled(false);
        
        this.pestanaPlazas.setDisclosed(true);
        this.pestanaDictamen.setDisclosed(false);
        return null;
    }

    public void setPestanaPlazas(CoreShowDetailItem pestanaPlazas) {
        this.pestanaPlazas = pestanaPlazas;
    }

    public CoreShowDetailItem getPestanaPlazas() {
        return pestanaPlazas;
    }

    public void setPestanaDictamen(CoreShowDetailItem pestanaDictamen) {
        this.pestanaDictamen = pestanaDictamen;
    }

    public CoreShowDetailItem getPestanaDictamen() {
        return pestanaDictamen;
    }

}
