package interfaz_usuario.backing.gestiones;

import enlace_datos.util.resulOp;

import interfaz_usuario.util.JSFUtils;

import interfaz_usuario.util.utils;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.faces.component.core.input.CoreInputText;
import oracle.adf.view.faces.component.core.input.CoreSelectBooleanCheckbox;

import oracle.adf.view.faces.component.core.input.CoreSelectInputDate;
import oracle.adf.view.faces.component.core.layout.CoreShowDetailItem;

import oracle.adf.view.faces.component.core.nav.CoreCommandButton;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import pkg_util_base_datos.interfaz_DB;

public class cheqAnuladoRecibido {
    public boolean selecDependencia = false;
    private CoreSelectBooleanCheckbox selecUni;
    private CoreSelectBooleanCheckbox selecFecha;
    private BindingContainer bindings;
    private CoreInputText idPagoRecibido;
    private CoreShowDetailItem pestania2;
    private CoreShowDetailItem pestania1;
    private CoreSelectInputDate fechainicio;
    private CoreSelectInputDate fechafin;
    private CoreCommandButton btnImprimir;
    //private BindingContainer bindings;



    public cheqAnuladoRecibido() {
    }
    public boolean getSelecDependencia(){
        return selecDependencia;
    }
    
    public String Buscar() {
        // Add event code here...
        if (this.selecUni.getValue().equals(true)&& this.selecFecha.getValue().equals(false)){
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), "filtrarUnidad");
        }
        else if (this.selecFecha.getValue().equals(true)&& this.selecUni.getValue().equals(false) ){
        
            if(this.fechainicio.getValue()!= null && this.fechafin.getValue() != null){
                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), "filtrarXfechas"); 
            }
            else{
               
                utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Si su busqueda lo realizará por fechas, debe ingresar la fecha de inicio y la fecha fin. "));
            }
        }
        else if (this.selecFecha.getValue().equals(true) && this.selecUni.getValue().equals(true) ){
        
            if(this.fechainicio.getValue()!= null && this.fechafin.getValue() != null){
                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), "unidadFechas");
            }
            else{
                
                utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Si su busqueda lo realizará por fechas, debe ingresar la fecha de inicio y la fecha fin. "));
            }
        }
        else{
            //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), "ExecuteWithParams");
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), "limpiarwhere");
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), "filtraCheques");
            
            
        }
        return null;
    }

    public void SeleccionarDependencia(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
         selecDependencia = true;
    }


    public void setSelecUni(CoreSelectBooleanCheckbox selecUni) {
        this.selecUni = selecUni;
    }

    public CoreSelectBooleanCheckbox getSelecUni() {
        return selecUni;
    }

    public void setSelecFecha(CoreSelectBooleanCheckbox selecFecha) {
        this.selecFecha = selecFecha;
    }

    public CoreSelectBooleanCheckbox getSelecFecha() {
        return selecFecha;
    }


    public String nuevoDocRecibido() {
        // Add event code here...
         //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), "reset");
         // JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), "Ejecutar");
         
       // JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), "Ejecutar");
        //this.idPagoRecibido.setSubmittedValue(utils.getNumberOracle(varId));
        // this.idPagoRecibido.setValue(utils.getNumberOracle(varId));
        //System.out.println("gui gugiuig");
         //boolean resultado;
         //resultado = JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit");
         /* if(resultado == true){
             System.out.println("holaaaaaaa");
             
         }*/
         //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), "Ejecutar");
         

/*
         interfaz_DB interfaz = new interfaz_DB();
         String consulta = "select SIS_DOCPAGO_RECIBIDO_SQ.nextval as idDoc  from dual";
         Object varId = interfaz.getValorConsultaSimple("idDoc",consulta) ;
         interfaz.cn_Cerrar_coneccion(); 
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.vIdDocRecibido1.inputValue}",utils.getNumberOracle(varId));
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.vIdDocRecibido1.inputValue}",utils.getNumberOracle(varId));
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), "crearIdDoc");
         */
     
     JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), "Rollback");    
     JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.vIdDocRecibido1.inputValue}",utils.getNumberOracle("0"));
     JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.IdDocRecibidoAux.inputValue}",null);
     JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), "crearIdDoc");
 
        this.pestania2.setDisabled(false);
        this.pestania2.setDisclosed(true);
        this.pestania1.setDisclosed(false);
        this.pestania1.setDisabled(true);
        
       
        
        return null;
    }

   /* public BindingContainer getBindings() {
        return this.bindings;
    }

    public void setBindings(BindingContainer bindings) {
        this.bindings = bindings;
    }
*/
    public String Guardar() {
        
        boolean resultado,resultado1;
        Object vIdRecibidoAux,varId;                
        interfaz_DB interfaz = new interfaz_DB();
        
        vIdRecibidoAux=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vIdDocRecibido1.inputValue}");
        
        if (vIdRecibidoAux==null || (vIdRecibidoAux!=null && vIdRecibidoAux.toString().equals("0"))){
        
            String consulta = "select SIS_DOCPAGO_RECIBIDO_SQ.nextval as idDoc  from dual";
            varId=interfaz.getValorConsultaSimple("idDoc",consulta);
            interfaz.cn_Cerrar_coneccion(); 
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.vIdDocRecibido1.inputValue}",utils.getNumberOracle(varId));      
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.IdDocRecibidoAux.inputValue}",utils.getNumberOracle(varId));
            //JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.IdDocpagoRecibido.inputValue}",utils.getNumberOracle(varId));
        }
        
        resultado1 =  JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(), "agregarIdRecibido");

        if(resultado1 == true){
            
            resultado = JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit");
            if(resultado == true){
                this.btnImprimir.setDisabled(false);
                interfaz_usuario.util.utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Datos Guardados Correctamente.")); 
                
            }
            else{
                interfaz_usuario.util.utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR ,"Error al  Guardar los Datos."));
            }
        }
       
       
        return null;
    }

    public void setIdPagoRecibido(CoreInputText idPagoRecibido) {
        this.idPagoRecibido = idPagoRecibido;
    }

    public CoreInputText getIdPagoRecibido() {
        return idPagoRecibido;
    }

    public void setPestania2(CoreShowDetailItem pestania2) {
        this.pestania2 = pestania2;
    }

    public CoreShowDetailItem getPestania2() {
        return pestania2;
    }

    public void setPestania1(CoreShowDetailItem pestania1) {
        this.pestania1 = pestania1;
    }

    public CoreShowDetailItem getPestania1() {
        return pestania1;
    }

    public void setFechainicio(CoreSelectInputDate fechainicio) {
        this.fechainicio = fechainicio;
    }

    public CoreSelectInputDate getFechainicio() {
        return fechainicio;
    }

    public void setFechafin(CoreSelectInputDate fechafin) {
        this.fechafin = fechafin;
    }

    public CoreSelectInputDate getFechafin() {
        return fechafin;
    }

    public void setBtnImprimir(CoreCommandButton btnImprimir) {
        this.btnImprimir = btnImprimir;
    }

    public CoreCommandButton getBtnImprimir() {
        return btnImprimir;
    }

    public BindingContainer getBindings() {
        return this.bindings;
}

    public void setBindings(BindingContainer bindings) {
        this.bindings = bindings;
    }

    public String cancelar() {
                
        boolean resultado;
        resultado =  JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(), "Rollback");
        if (resultado == true){
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), "Ejecutar");
            return "gestiones";
        }
        else{
            interfaz_usuario.util.utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR ,"Error al cancelar."));
            return null;
        }
    }

    public String btn_nuevo_recep() {
        // Add event code here...
        nuevoDocRecibido();
        return null;
    }
}
