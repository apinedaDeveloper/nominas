package interfaz_usuario.backing.gestiones;

import interfaz_usuario.usuario;

import interfaz_usuario.util.JSFUtils;
import interfaz_usuario.util.utils;

import javax.faces.context.FacesContext;

import oracle.adf.view.faces.component.core.data.CoreTable;
import oracle.adf.view.faces.component.core.nav.CoreCommandLink;

import oracle.binding.BindingContainer;

import oracle.binding.OperationBinding;

import oracle.jbo.uicli.binding.JUCtrlValueBindingRef;


public class lst_contrato {
    private BindingContainer bindings;
    private CoreCommandLink cmdlk_numContrato;
    private CoreTable tbl_contratos;

    public lst_contrato() {
    }

    public BindingContainer getBindings() {
        return this.bindings;
    }

    public void setBindings(BindingContainer bindings) {
        this.bindings = bindings;
    }

    public String cmlnk_contrato_action() {
        // Add event code here... 
         BindingContainer vBnd_binding;
         OperationBinding operationBinding;
         JUCtrlValueBindingRef tableRowRef =
         (JUCtrlValueBindingRef) this.tbl_contratos.getSelectedRowData();
         usuario.set_opciones(usuario.SEL_REGEMPLEADO,utils.getNumber(tableRowRef.getRow().getAttribute("RegistroEmpleado")) ); 
         usuario.set_opciones(usuario.SEL_CONTRATO,Long.parseLong(this.cmdlk_numContrato.getText()) ); 
         usuario.set_opciones(usuario.VISTA_CONTRATO,1);  // Modificacion
         vBnd_binding=(BindingContainer)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings}");
         operationBinding=vBnd_binding.getOperationBinding("Rollback");
         operationBinding.execute();   
         return "ir_a_nombramiento";
    }

    public void setCmdlk_numContrato(CoreCommandLink cmdlk_numContrato) {
        this.cmdlk_numContrato = cmdlk_numContrato;
    }

    public CoreCommandLink getCmdlk_numContrato() {
        return cmdlk_numContrato;
    }

    public String btn_nuevo_action() {
        // Add event code here...
         usuario.set_opciones(usuario.SEL_CONTRATO,new Long(0) ); 
         usuario.set_opciones(usuario.VISTA_CONTRATO,0); 
         usuario.set_opciones(usuario.SEL_REGEMPLEADO,0);
        return "ir_a_nombramiento";
    }

    public void setTbl_contratos(CoreTable tbl_contratos) {
        this.tbl_contratos = tbl_contratos;
    }

    public CoreTable getTbl_contratos() {
        return tbl_contratos;
    }
}
