package interfaz_usuario.backing.procesos;

import enlace_datos.util.resulOp;

import interfaz_usuario.util.JSFUtils;

import interfaz_usuario.util.utils;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.faces.component.core.nav.CoreCommandButton;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class autofinanciables {
    public boolean selecUnidad = false;
    private BindingContainer bindings;
    private CoreCommandButton btnGuardar;
    private CoreCommandButton btnImprimir;
    private CoreCommandButton btnCancelar;
    //private BindingContainer bindings;

    public autofinanciables() {
    }

    public String Generar() {
        // Add event code here...
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"filtrar_x_acceso_dep45" );
        return null;
    }
    
    public boolean getSelecUnidad(){
    
        return selecUnidad;
    }

    public void SeleccionarDependencia(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        selecUnidad = true;
    }

  /*  public BindingContainer getBindings() {
        return this.bindings;
    }

    public void setBindings(BindingContainer bindings) {
        this.bindings = bindings;
    }
*/
    public String GenerarAumento() {
       boolean resultado, resultado1;
             
        resultado = JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit");
        if (resultado == true){//el anexo fue creado con exito
            this.btnGuardar.setDisabled(true);
            resultado1 =JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"aumentoPlan45");
            if (resultado1 == true){  // el detalle del anexo fue creado con exito
                this.btnImprimir.setDisabled(false);
                this.btnCancelar.setDisabled(true);
                utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Incremento Salarial Generado Correctamente."));
            }else{ //el detalle del anexo no fue creado con exito.
                utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Error al Generar el Incremento Salarial"));       
            }
        }else{  //el anexo no se creo con exito
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Error al Generar el Incremento Salarial"));   
        }
                     
        return null;
    }

    public void setBtnGuardar(CoreCommandButton btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    public CoreCommandButton getBtnGuardar() {
        return btnGuardar;
    }

    public void setBtnImprimir(CoreCommandButton btnImprimir) {
        this.btnImprimir = btnImprimir;
    }

    public CoreCommandButton getBtnImprimir() {
        return btnImprimir;
    }

    public void setBtnCancelar(CoreCommandButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public CoreCommandButton getBtnCancelar() {
        return btnCancelar;
    }

    public BindingContainer getBindings() {
        return this.bindings;
    }

    public void setBindings(BindingContainer bindings) {
        this.bindings = bindings;
    }

    public String Cancelar() {
        this.btnGuardar.setDisabled(true);
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Rollback");   
        return null;
    }
}
