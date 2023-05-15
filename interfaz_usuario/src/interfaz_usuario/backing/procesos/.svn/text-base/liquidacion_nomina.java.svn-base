package interfaz_usuario.backing.procesos;

import enlace_datos.util.resulOp;

import interfaz_usuario.util.ADFUtils;
import interfaz_usuario.util.JSFUtils;

import interfaz_usuario.util.utils;

import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.faces.component.core.data.CoreTable;
import oracle.adf.view.faces.component.core.input.CoreSelectOneChoice;
import oracle.adf.view.faces.component.core.nav.CoreCommandButton;
import oracle.adf.view.faces.event.AttributeChangeEvent;
import oracle.adf.view.faces.event.SelectionEvent;
import oracle.adf.view.faces.model.CollectionModel;
import oracle.adf.view.faces.model.RowKeySet;

import oracle.jbo.Row;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.uicli.binding.JUIteratorBinding;


public class liquidacion_nomina {

private boolean vActuaDeps=false;
private boolean vActuaUni=false;

    private CoreTable tbl_procs;
    private CoreSelectOneChoice cmbDependencia;
    private CoreCommandButton btnOtraBusqueda;

    public liquidacion_nomina() {

    }

    public void tbl_procesos(SelectionEvent selectionEvent) {
        // Add event code here...
         vActuaDeps=true;        
        // System.out.println(" cambio de tabla ");
        Object vLlave;
         
        vLlave=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.SisNominasLiquidarVw.collectionModel}");
        CollectionModel b;
        b=(CollectionModel)vLlave;
         
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.vPosi1.inputValue}",new Integer(b.getRowKey().toString()));                
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"setFilaActual");
        
        
        
        Object vIdProceso=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdProceso.inputValue}");
        Object vIdDependencia=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdDependencia.inputValue}");
        Object vIdLiquidacion=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdLiquidacion.inputValue}");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ExeUni");
        
         //selectionEvent.
        
    }


    public void setActuaDeps(boolean vActuaDeps) {
        this.vActuaDeps = vActuaDeps;
    }

    public boolean isActuaDeps() {
        return vActuaDeps;
    }

    public void setTbl_procs(CoreTable tbl_procs) {
        this.tbl_procs = tbl_procs;
    }

    public CoreTable getTbl_procs() {
        return tbl_procs;
    }

    public void change_IdProceso(AttributeChangeEvent attributeChangeEvent) {
        // Add event code here...
         System.out.println(" cambio de id proceso ");
    }

    public void cmd_deps(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        
        if (valueChangeEvent.getNewValue()!=valueChangeEvent.getOldValue()){
            vActuaUni=true;            
        }
        
    }

    public void setActuaUni(boolean vActuaUni) {
        this.vActuaUni = vActuaUni;
    }

    public boolean isActuaUni() {
        return vActuaUni;
    }

    public String btn_liquidar() {
    
        Object vValor;
        boolean vResultado;
        resulOp vMensaResul=new resulOp();
        String vOutcome=null;
        
  /*      
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.CreadoPor.inputValue}");
         
        if (vValor==null){
           vValor=JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.selRegEmpleado_login");    
           JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.CreadoPor.inputValue}" ,utils.getNumberOracle(vValor));
        }
        
        */
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdProceso.inputValue}");
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.IdProceso1.inputValue}" ,vValor);
        
        
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdDependencia.inputValue}");        
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.IdDependenciaLiq.inputValue}" ,vValor);
        
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdProgramaUni.inputValue}");        
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.IdProgramaUn.inputValue}" ,vValor);
        
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdDependenciaUni.inputValue}");        
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.IdDependenciaUn.inputValue}" ,vValor);
        
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdUnidadUni.inputValue}");        
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.IdUnidadUn.inputValue}" ,vValor);
        
        
        
        
         if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Confirmar"))
         {
         
            if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"liquidar_nomina")) 
            {
            
                JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Confirmar");                
                vMensaResul.setMensajeError("Nomina liquidada correctamente");
                vMensaResul.setCodigoResultado(resulOp.OPE_OK);
                utils.setADFMensaje(vMensaResul);
                vOutcome="ver_repLiquidacion";     
                
            }
         
           
         }else{
             
            //JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Rollback");
            
        }
        
        return vOutcome;

    }

    public String btn_guardar() {
        resulOp vMensaResul=new resulOp();
        String vOutcome=null;
        Object vValor;
        
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdProgramaUni.inputValue}");        
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.IdProgramaUn.inputValue}" ,vValor);
        
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdDependenciaUni.inputValue}");        
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.IdDependenciaUn.inputValue}" ,vValor);
        
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdUnidadUni.inputValue}");        
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.IdUnidadUn.inputValue}" ,vValor);        
        
        
        
        
        // Add event code here...
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Confirmar")){
            if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"liquidar_nomina")) 
            {
                JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Confirmar");
                vMensaResul.setMensajeError("Nomina liquidada correctamente");
                vMensaResul.setCodigoResultado(resulOp.OPE_OK);            
                utils.setADFMensaje(vMensaResul);
            }
        }

        return vOutcome;
    }

    public String cmd_sel_liquidacion() {
        // Add event code here...
        
        //JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"",);
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"setFilaLiquida");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"SisLiquidacion");
        JSFUtils.setManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.vistaLiquidacion",1);
        return "new_liqNominaTeso";
    }

    public String btn_cancelar_update() {        
        JSFUtils.setManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.vistaLiquidacion",0);
        JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Rollback");        
        return "ver_repLiquidacion";
    }

    public String verProcesos() {
        // Add event code here...
         JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Nominas");
        //JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Deps");
        JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"ExeUni");
        this.getCmbDependencia().setDisabled(true);
        this.getBtnOtraBusqueda().setDisabled(false);
        return null;
    }

    public void setCmbDependencia(CoreSelectOneChoice cmbDependencia) {
        this.cmbDependencia = cmbDependencia;
    }

    public CoreSelectOneChoice getCmbDependencia() {
        return cmbDependencia;
    }

    public void setBtnOtraBusqueda(CoreCommandButton btnOtraBusqueda) {
        this.btnOtraBusqueda = btnOtraBusqueda;
    }

    public CoreCommandButton getBtnOtraBusqueda() {
        return btnOtraBusqueda;
    }

    public String btn_otra_busqueda_action() {
        JUIteratorBinding vIterBinding;
        
        vIterBinding=(JUIteratorBinding)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.SisNominasLiquidarVwIterator}");
        ViewObjectImpl vo = (ViewObjectImpl)vIterBinding.getViewObject();
        vo.executeEmptyRowSet();
        
        vIterBinding=(JUIteratorBinding)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.Sis_unidades_liquidacion_vwIterator}");
        vo = (ViewObjectImpl)vIterBinding.getViewObject();
        vo.executeEmptyRowSet();
        
        this.getCmbDependencia().setDisabled(false);
        this.getBtnOtraBusqueda().setDisabled(true);
        return null;
    }
}
