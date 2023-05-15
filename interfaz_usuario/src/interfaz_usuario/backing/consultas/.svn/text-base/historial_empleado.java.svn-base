package interfaz_usuario.backing.consultas;

import interfaz_usuario.util.JSFUtils;

import javax.faces.context.FacesContext;

import oracle.adf.view.faces.component.core.input.CoreInputText;
import oracle.adf.view.faces.component.core.input.CoreSelectBooleanCheckbox;
import oracle.adf.view.faces.component.core.input.CoreSelectInputDate;
import oracle.adf.view.faces.component.core.input.CoreSelectOneChoice;
import oracle.adf.view.faces.component.core.nav.CoreCommandButton;
import oracle.adf.view.faces.context.AdfFacesContext;

public class historial_empleado {

    private CoreCommandButton btnLimpiar;
    private CoreInputText inptCui;
    private CoreSelectInputDate slctInputDateFechaInicio;
    private CoreInputText inptRegistroEmpleado;
    private CoreSelectInputDate slctInputDateFechaFin;
    private CoreSelectOneChoice slcOneChoiceDependencias;
    private CoreSelectBooleanCheckbox slctBoolChkBoxFiltrarDependencia;
    private CoreSelectBooleanCheckbox slctBoolChkBoxContrataciones;

    public historial_empleado() {
    }

    public String btn_buscar() {
        Object pBinding,pEstado;
        String vConsultas,vParamEstados;
        //boolean vEspecifico=false;
        vConsultas="";
        
        pBinding=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.mostrarContr1.inputValue}");
        if (pBinding!=null&&pBinding.equals(true)){
            vConsultas="CONTRATOS";
            //vEspecifico=true;
        }
        
        pBinding=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.mostrarLic1.inputValue}");
        if (pBinding!=null&&pBinding.equals(true)){
            vConsultas=vConsultas+"|LICENCIAS";
            //vEspecifico=true;
        }
        
        pBinding=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.mostrarSuspIgss1.inputValue}");
        if (pBinding!=null&&pBinding.equals(true)){
            vConsultas=vConsultas+"|SUSPIGSS";
            //vEspecifico=true;
        }    
        
        pBinding=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.mostrarDescJud1.inputValue}");
        if (pBinding!=null&&pBinding.equals(true)){
            vConsultas=vConsultas+"|DESC_JUDICIAL";
            //vEspecifico=true;
        }
        
        pBinding=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.mostrarRenunDesp1.inputValue}");
        if (pBinding!=null&&pBinding.equals(true)){
            vConsultas=vConsultas+"|RENUNCIADESP";
            //vEspecifico=true;
        }
        
        pBinding=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.mostrarRenunParcial1.inputValue}");
        if (pBinding!=null&&pBinding.equals(true)){
            vConsultas=vConsultas+"|RENUNCIAPARCIAL";
            //vEspecifico=true;
        }
        
        pBinding=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.mostrarHoraExtra1.inputValue}");
        if (pBinding!=null&&pBinding.equals(true)){
            vConsultas=vConsultas+"|HORA_EXTRA";
            //vEspecifico=true;
        }
        
        if (JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.mostrarReclaf1.inputValue}").equals(true) 
        &&JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.mostrarPromDoc1.inputValue}").equals(true)){
            vConsultas=vConsultas+"|PROMRECLASIF";
            //vEspecifico=true;            
        } else{
            pBinding=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.mostrarReclaf1.inputValue}");
            if (pBinding!=null&&pBinding.equals(true)){
                vConsultas=vConsultas+"|RECLASIF";
                //vEspecifico=true;
            }
            pBinding=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.mostrarPromDoc1.inputValue}");
            if (pBinding!=null&&pBinding.equals(true)){
                vConsultas=vConsultas+"|PROMDOC";
                //vEspecifico=true;
            }
        }
        
        pBinding=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.mostrarFallec1.inputValue}");
        if (pBinding!=null&&pBinding.equals(true)){
            vConsultas=vConsultas+"|FALLE";
            //vEspecifico=true;
        }
        
        pBinding=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.mostrarRetiro1.inputValue}");
        if (pBinding!=null&&pBinding.equals(true)){
            vConsultas=vConsultas+"|RETIRO";
            //vEspecifico=true;
        }
        
        pBinding=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.mostrarReintegros1.inputValue}");
        if (pBinding!=null&&pBinding.equals(true)){
            vConsultas=vConsultas+"|REINTEGROS";
            //vEspecifico=true;
        }
        
        pBinding=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.mostrarSuspBajaLab1.inputValue}");
        if (pBinding!=null&&pBinding.equals(true)){
            vConsultas=vConsultas+"|BAJALABORAL";
            //vEspecifico=true;
        }    
        
        vParamEstados="";
        pEstado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vEstadoContrato1.inputValue}");
        if (pEstado!=null){
            vParamEstados="C|"+pEstado; 
        }
        
        pEstado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vEstadoLic1.inputValue}");
        if (pEstado!=null){
            vParamEstados=vParamEstados+"|L|"+pEstado; 
        }
        
        pEstado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vSuspIgss1.inputValue}");
        if (pEstado!=null){
            vParamEstados=vParamEstados+"|G|"+pEstado; 
        }
        
        pEstado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vDescJud1.inputValue}");
        if (pEstado!=null){
            vParamEstados=vParamEstados+"|J|"+pEstado; 
        }
        
        pEstado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vRenun1.inputValue}");
        if (pEstado!=null){
            vParamEstados=vParamEstados+"|R|"+pEstado; 
        }
        
        pEstado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vRenunParcial1.inputValue}");
        if (pEstado!=null){
            vParamEstados=vParamEstados+"|R|"+pEstado; 
        }
        
        pEstado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vHoraE1.inputValue}");
        if (pEstado!=null){
            vParamEstados=vParamEstados+"|H|"+pEstado; 
        }

        pEstado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vEstFalle1.inputValue}");
        
        if (pEstado!=null){
            vParamEstados=vParamEstados+"|F|"+pEstado; 
        }
        
        pEstado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vEstReti1.inputValue}");
        if (pEstado!=null){
            vParamEstados=vParamEstados+"|B|"+pEstado; 
        }
        
        pEstado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vSuspBajaLab1.inputValue}");
        if (pEstado!=null){
            vParamEstados=vParamEstados+"|BL|"+pEstado; 
        }
        
        pEstado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vReintegros1.inputValue}");
        if (pEstado!=null){
            vParamEstados=vParamEstados+"|REI|"+pEstado; 
        }
        
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pConsulta.inputValue}",vConsultas);
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.vEstados1.inputValue}",vParamEstados);
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarConsulGestiones");
        return null;
    }

    public void setBtnLimpiar(CoreCommandButton btnLimpiar) {
        this.btnLimpiar = btnLimpiar;
    }

    public CoreCommandButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public String btnLimpiar_action() {
        this.getInptCui().setValue("");
        this.getInptRegistroEmpleado().setValue("");
        this.getSlctInputDateFechaInicio().setValue("");
        this.getSlctInputDateFechaFin().setValue("");
        this.getSlctBoolChkBoxFiltrarDependencia().setSelected(false);
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.mostrarContr1.inputValue}",false);
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.mostrarLic1.inputValue}",false);
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.mostrarSuspIgss1.inputValue}",false);
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.mostrarDescJud1.inputValue}",false);
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.mostrarRenunDesp1.inputValue}",false);
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.mostrarRenunParcial1.inputValue}",false);
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.mostrarHoraExtra1.inputValue}",false);
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.mostrarFallec1.inputValue}",false);
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.mostrarRetiro1.inputValue}",false);
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.mostrarPromDoc1.inputValue}",false);
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.mostrarReclaf1.inputValue}",false);
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.mostrarReintegros1.inputValue}",false);
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.mostrarTodoAux1.inputValue}",false);
        return null;
    }

    public void setInptCui(CoreInputText inptCui) {
        this.inptCui = inptCui;
    }

    public CoreInputText getInptCui() {
        return inptCui;
    }

    public void setSlctInputDateFechaInicio(CoreSelectInputDate slctInputDateFechaInicio) {
        this.slctInputDateFechaInicio = slctInputDateFechaInicio;
    }

    public CoreSelectInputDate getSlctInputDateFechaInicio() {
        return slctInputDateFechaInicio;
    }

    public void setInptRegistroEmpleado(CoreInputText inptRegistroEmpleado) {
        this.inptRegistroEmpleado = inptRegistroEmpleado;
    }

    public CoreInputText getInptRegistroEmpleado() {
        return inptRegistroEmpleado;
    }

    public void setSlctInputDateFechaFin(CoreSelectInputDate slctInputDateFechaFin) {
        this.slctInputDateFechaFin = slctInputDateFechaFin;
    }

    public CoreSelectInputDate getSlctInputDateFechaFin() {
        return slctInputDateFechaFin;
    }

    public void setSlcOneChoiceDependencias(CoreSelectOneChoice slcOneChoiceDependencias) {
        this.slcOneChoiceDependencias = slcOneChoiceDependencias;
    }

    public CoreSelectOneChoice getSlcOneChoiceDependencias() {
        return slcOneChoiceDependencias;
    }

    public void setSlctBoolChkBoxFiltrarDependencia(CoreSelectBooleanCheckbox slctBoolChkBoxFiltrarDependencia) {
        this.slctBoolChkBoxFiltrarDependencia = slctBoolChkBoxFiltrarDependencia;
    }

    public CoreSelectBooleanCheckbox getSlctBoolChkBoxFiltrarDependencia() {
        return slctBoolChkBoxFiltrarDependencia;
    }

    public void setSlctBoolChkBoxContrataciones(CoreSelectBooleanCheckbox slctBoolChkBoxContrataciones) {
        this.slctBoolChkBoxContrataciones = slctBoolChkBoxContrataciones;
    }

    public CoreSelectBooleanCheckbox getSlctBoolChkBoxContrataciones() {
        return slctBoolChkBoxContrataciones;
    }
}
