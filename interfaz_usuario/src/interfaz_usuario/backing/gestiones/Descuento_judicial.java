package interfaz_usuario.backing.gestiones;

import enlace_datos.util.resulOp;

import interfaz_usuario.usuario;

import interfaz_usuario.util.JSFUtils;

import interfaz_usuario.util.utils;

import javax.faces.context.FacesContext;

import oracle.adf.view.faces.component.core.input.CoreInputText;
import oracle.adf.view.faces.component.core.input.CoreSelectInputDate;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class Descuento_judicial {
    private CoreSelectInputDate fechFinOrden;
    private CoreInputText juezFinOrden;
    private CoreInputText juzgadoFinOrden;
    private BindingContainer bindings;

    public Descuento_judicial() {
    }

       //metodo asociado al boton guardar de la orden judicial
    public String btn_commit_orden_judicial_action() {
        BindingContainer vBnd_binding;
        OperationBinding operationBinding;
        Object result;
        resulOp vResultado=new resulOp();
        boolean vResultadoOp=false;
        vBnd_binding=(BindingContainer)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings}");
        operationBinding=vBnd_binding.getOperationBinding("Commit");
        result=operationBinding.execute();  
        if (!operationBinding.getErrors().isEmpty()){
            return null;
        }else{
            usuario.set_opciones(usuario.VISTA_ORDEN_JUDICIAL,1);
            return "condicion_judicial";
        }
    }
    //metodo asociado al boton guardar de la pagina /gestiones/condicion_orden_judicial.jspx
    public String btn_commit_condicion_ordenJudicial() {
        BindingContainer vBnd_binding;
        OperationBinding operationBinding;
        Object result;
        resulOp vResultado=new resulOp();
        boolean vResultadoOp=false;
        vBnd_binding=(BindingContainer)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings}");
        operationBinding=vBnd_binding.getOperationBinding("Commit");
        result=operationBinding.execute();  
        if (!operationBinding.getErrors().isEmpty()){
            return null;
        }else{
           
            return "nueva_solicitud";
        }
    }

    public void setFechFinOrden(CoreSelectInputDate fechFinOrden) {
        this.fechFinOrden = fechFinOrden;
    }

    public CoreSelectInputDate getFechFinOrden() {
        return fechFinOrden;
    }

    public void setJuezFinOrden(CoreInputText juezFinOrden) {
        this.juezFinOrden = juezFinOrden;
    }

    public CoreInputText getJuezFinOrden() {
        return juezFinOrden;
    }

    public void setJuzgadoFinOrden(CoreInputText juzgadoFinOrden) {
        this.juzgadoFinOrden = juzgadoFinOrden;
    }

    public CoreInputText getJuzgadoFinOrden() {
        return juzgadoFinOrden;
    }

    public BindingContainer getBindings() {
        return this.bindings;
    }

    public void setBindings(BindingContainer bindings) {
        this.bindings = bindings;
    }

    public String btn_guardar_baja_orden() {
        int bandera = 0;
        if (this.fechFinOrden.getValue() == null){
             utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"DEBE INGRESAR LA FECHA DEL DOCUMENTO"));
             bandera = 1;
        }
        if (this.juezFinOrden.getValue() == null){
             utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"DEBE INGRESAR EL NOMBRE DEL JUEZ QUE ORDENA lEVANTAR LA ORDEN JUDICIAL"));
             bandera = 1;
        }
        if (this.juzgadoFinOrden.getValue() == null){
             utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"DEBE INGRESAR EL NOMBRE DEL JUZGADO QUE ORDENA lEVANTAR LA ORDEN JUDICIAL"));
             bandera = 1;
        }
        if (bandera == 0){
            BindingContainer bindings = getBindings();
            OperationBinding operationBinding = 
            bindings.getOperationBinding("Commit");
            Object result = operationBinding.execute();
            if (!operationBinding.getErrors().isEmpty()) {
                return null;
            }
        }
        return "nueva_solicitud";
    }
}

