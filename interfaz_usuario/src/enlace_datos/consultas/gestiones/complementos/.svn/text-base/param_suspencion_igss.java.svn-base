package enlace_datos.consultas.gestiones.complementos;

import enlace_datos.util.resulOp;

import interfaz_usuario.util.JSFUtils;
import interfaz_usuario.util.utils;

import javax.faces.context.FacesContext;

import oracle.adf.view.faces.component.core.layout.CoreShowDetailItem;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class param_suspencion_igss {
    private CoreShowDetailItem tabListaParametros;
    private CoreShowDetailItem tabEditarParametro;
    private BindingContainer bindings;

    public param_suspencion_igss() {
    }

    public void setTabListaParametros(CoreShowDetailItem tabListaParametros) {
        this.tabListaParametros = tabListaParametros;
    }

    public CoreShowDetailItem getTabListaParametros() {
        return tabListaParametros;
    }

    public void setTabEditarParametro(CoreShowDetailItem tabEditarParametro) {
        this.tabEditarParametro = tabEditarParametro;
    }

    public CoreShowDetailItem getTabEditarParametro() {
        return tabEditarParametro;
    }

    public String crear_parametro() {
        if(JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"CrearInserción")){
            utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Ingrese los datos solicitados."));
            this.getTabEditarParametro().setDisclosed(true);
            this.getTabListaParametros().setDisclosed(false);
        }
        else{
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"No fue posible inicializar la nueva parametrización."));
        }
        return null;
    }

    public String borrar_parametro() {
        if(JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"removeRowWithKey")){
            utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Parámetro borrado."));
        }
        else{
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Rollback");
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"No fue posible borrar el parámetro seleccionado."));
        }
        return null;
    }

    public BindingContainer getBindings() {
        return this.bindings;
    }

    public void setBindings(BindingContainer bindings) {
        this.bindings = bindings;
    }

    public String editar_parametro() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = 
            bindings.getOperationBinding("setCurrentRowWithKey");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        
        this.getTabEditarParametro().setDisclosed(true);
        this.getTabListaParametros().setDisclosed(false);
        
        return "setCurrentRowWithKey";
    }

    public String deshacer_cambios() {
        if(JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Rollback")){
            this.getTabEditarParametro().setDisclosed(false);
            this.getTabListaParametros().setDisclosed(true);
            utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Se omitió la grabación de los datos."));
        }
        else{
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"No fue posible omitir la grabación de los datos."));
        }
        return null;
    }

    public String guardar_cambios() {
        if(JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit")){
            this.getTabEditarParametro().setDisclosed(false);
            this.getTabListaParametros().setDisclosed(true);
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Ejecutar");
            utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Se realizo la grabación de los datos."));
        }
        else{
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"No fue posible realizar la grabación de los datos."));
        }
        return null;
    }
}
