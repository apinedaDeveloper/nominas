package interfaz_usuario.backing.gestiones;

import enlace_datos.util.resulOp;

import interfaz_usuario.backing.util.util_dialog_adf;

import interfaz_usuario.util.JSFUtils;

import interfaz_usuario.util.utils;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.faces.component.core.input.CoreSelectOneChoice;
import oracle.adf.view.faces.event.LaunchEvent;

import oracle.jbo.uicli.binding.JUIteratorBinding;

public class detVarAjuste {
    private CoreSelectOneChoice cmbAjustes;

    public detVarAjuste() {
    }

    public String btn_commit() {
        // Add event code here..
        
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit"))
        {
            
          utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Datos guardados exitosamente.")); 
        }
        
        return null;
    }
    
    public void lauchListener(LaunchEvent launchEvent) {
         util_dialog_adf vDialog= new util_dialog_adf();
         Object vVariable,vEstado;
         vVariable=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdVariacionNomina1.inputValue}");
         vEstado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdEstado.inputValue}");
         //        vDialog.abrir_dialogo_autorizacion(FacesContext.getCurrentInstance(),"LICENCIA",vVariable,vEstado,"licencia");
         
         
         vDialog.setParametros_dialogo_autorizacion(launchEvent,"VARIACION_NOM_DESC",vVariable,vEstado,"variacion_nomina");
    }

    public String refreshAction() {
        // Add event code here...
        String vKey;
        
        System.out.println("Refresh");
        vKey=JSFUtils.getStrKeyIterator("sis_variacion_nominaIterator");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Ejecutar");
        JSFUtils.setStrKeyIterator("sis_variacion_nominaIterator",vKey);
        return null;
    }

    public void cmbAjustes_changeValue(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        Object vValor,vAtributo;
        
         if (valueChangeEvent.getOldValue()!=valueChangeEvent.getNewValue()){
             
             vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.SisAjusteActivos_vwIterator.allRowsInRange}");
             
             if (vValor!=null)
              {
             
                 vAtributo=JSFUtils.getAtributoIterador(vValor,Integer.valueOf(valueChangeEvent.getNewValue().toString()),"Nivel");
                 if (vAtributo!=null && vAtributo.toString().equals("E")){
                     this.cmbAjustes.setDisabled(true);
                     
                 }else{
                     this.cmbAjustes.setDisabled(false);
                     
                 }
                 
                 
                }
             
             
         }
        
    }

    public void setCmbAjustes(CoreSelectOneChoice cmbAjustes) {
        this.cmbAjustes = cmbAjustes;
    }

    public CoreSelectOneChoice getCmbAjustes() {
        return cmbAjustes;
    }
}
