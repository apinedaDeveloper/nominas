package interfaz_usuario.backing.gestiones;

import enlace_datos.consultas.gestiones.contrato.sis_contrato_busq2RowImpl;

import interfaz_usuario.util.JSFUtils;

import java.util.Iterator;

import javax.faces.context.FacesContext;

import oracle.adf.view.faces.component.core.data.CoreTable;

import oracle.adf.view.faces.component.core.input.CoreInputText;
import oracle.adf.view.faces.component.core.input.CoreSelectInputText;

import oracle.adf.view.faces.event.ReturnEvent;

import oracle.jbo.Key;
import oracle.jbo.RowSetIterator;
import oracle.jbo.domain.Number;
import oracle.jbo.uicli.binding.JUIteratorBinding;

public class seg_contrato {
    private CoreTable tbl_contratos;
    private CoreInputText inpt_id_padre;

    public seg_contrato() {
    }

    public String btn_actualizar() {
       
        Iterator vIterador;
        Key llave;
        sis_contrato_busq2RowImpl vFila;
        JUIteratorBinding vIterBinding;
        RowSetIterator vBinding;
        
        vIterador=this.getTbl_contratos().getSelectionState().getKeySet().iterator();
        vIterBinding=(JUIteratorBinding)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.sis_contrato_busq2Iterator}");
        vBinding=vIterBinding.getRowSetIterator();
        
        
        while(vIterador.hasNext())
        {
          llave =  (Key)vIterador.next();
          vFila=(sis_contrato_busq2RowImpl)vBinding.getRow(llave);
          if (this.getInpt_id_padre().getValue()==null||vFila.getIdContrato().compareTo((Number)this.getInpt_id_padre().getValue())!=0){
              
              vFila.setIdContratoPadre((Number)this.getInpt_id_padre().getValue());
          }
         // System.out.println(fila1.getIdContrato());
        }
        
        return null;
    }

    public void setTbl_contratos(CoreTable tbl_contratos) {
        this.tbl_contratos = tbl_contratos;
    }

    public CoreTable getTbl_contratos() {
        return tbl_contratos;
    }

    public String buscar_contratos_action() {
        // Add event code here...
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Exe_contratos");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Exe_det_contratos");
        return null;
    }

    public void setInpt_id_padre(CoreInputText inpt_id_padre) {
        this.inpt_id_padre = inpt_id_padre;
    }

    public CoreInputText getInpt_id_padre() {
        return inpt_id_padre;
    }

    public void btn_sel_contrato_listener(ReturnEvent returnEvent) {
        
        if (returnEvent.getReturnValue()!=null){
            sis_contrato_busq2RowImpl vFila;
            vFila=(sis_contrato_busq2RowImpl)returnEvent.getReturnValue();
            this.inpt_id_padre.setValue(vFila.getIdContrato());
            //System.out.println(returnEvent);
        }else{
            this.inpt_id_padre.setValue(null);
        }
        
    }
}
