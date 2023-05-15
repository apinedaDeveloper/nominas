package interfaz_usuario.backing.gestiones;

import interfaz_usuario.usuario;

import java.util.List;

import javax.faces.application.Application;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;

import javax.faces.event.ValueChangeEvent;

import javax.faces.model.SelectItem;

import oracle.adf.view.faces.component.core.input.CoreInputText;
import oracle.adf.view.faces.component.core.layout.CorePanelBox;
import oracle.adf.view.faces.component.core.input.CoreSelectOneChoice;

import oracle.adf.view.faces.component.core.nav.CoreCommandLink;

import oracle.adfinternal.view.faces.model.binding.FacesCtrlListBinding;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;


public class empleado {
    boolean selDepto=false;
    private CoreInputText apellido1;
    private CorePanelBox panel1;
    private CoreInputText prueba3;
    private CoreSelectOneChoice combo_departamento;
    private oracle.jbo.domain.Number deptsel;
    private String orden_Cedula;
    private String depto_sel;
    private CoreSelectOneChoice combo_ordenced;
    private UISelectItems item_combo_orden;
    private UISelectItems item_combo_dep;
    private CoreCommandLink cmdlnk_contrato;


    public oracle.jbo.domain.Number getDepsel(){
        return deptsel;
    }
    
    public boolean getSelDepto(){
        return selDepto;
    }
    
    public String getOrdenCedula(){
        System.out.println("Obteniendo el orden cedula" + orden_Cedula); 
        return orden_Cedula;
    }
    
    public String getDeptoSel(){
        System.out.println("Obteniendo el depto seleccionado" + depto_sel); 
        return depto_sel;
    }
    public empleado() {
    deptsel= new oracle.jbo.domain.Number(1);
        System.out.println("Valor cambiado a 1");
        orden_Cedula="A1";
        depto_sel="XXXXXX";
        selDepto=false;    
    }

    public void setApellido1(CoreInputText apellido1) {
        this.apellido1 = apellido1;
    }

    public CoreInputText getApellido1() {
        return apellido1;
    }


    public String commandButton_action() {
        
        
         BindingContainer pla;
         FacesContext ctx;
         Object fra;
         
         ctx = FacesContext.getCurrentInstance(); 
         Application app = ctx.getApplication();
         ValueBinding bind = app.createValueBinding("#{bindings}");
         pla=(BindingContainer)bind.getValue(ctx);
         //return bind.getValue(ctx);
         
          OperationBinding operationBinding =
          pla.getOperationBinding("guardar_empleado");
          fra=operationBinding.execute();
        System.out.println("ejecutado guardar"+fra);
        usuario.set_opciones(usuario.SEL_REGEMPLEADO,(Number)(Integer.parseInt((String)fra)) ); 
        usuario.set_opciones(usuario.VISTA_EMPLEADO,1); 
       // return null;
        return "ver_empleado";
    }

    public void setPanel1(CorePanelBox panel1) {
        this.panel1 = panel1;
    }

    public CorePanelBox getPanel1() {
        return panel1;
    }

    public void setPrueba3(CoreInputText prueba3) {
        this.prueba3 = prueba3;
    }

    public CoreInputText getPrueba3() {
        return prueba3;
    }

    public void dep_cambio(ValueChangeEvent valueChangeEvent) {
        // Add event code here... 
      
         selDepto=true;
      /*
         List <FacesCtrlListBinding> pa;
         pa=(List <FacesCtrlListBinding>)this.item_combo_dep.getValue();
         
         Object []ab;
         
         ab=pa.toArray();
          SelectItem abx;
          abx=(SelectItem)ab[Integer.parseInt(this.combo_departamento.getValue().toString())];       
           //rw=pa.get(0).getRowAtRangeIndex(0);
            depto_sel=abx.getLabel();
          System.out.println("cambiado el departamento" + depto_sel); 
          usuario.set_opciones(usuario.SEL_DEPTO,abx.getLabel()); 
          
        BindingContainer pla;
        FacesContext ctx;
        Object fra;
        
        ctx = FacesContext.getCurrentInstance(); 
        Application app = ctx.getApplication();
        ValueBinding bind = app.createValueBinding("#{bindings}");
        pla=(BindingContainer)bind.getValue(ctx);
        //return bind.getValue(ctx);
        
         OperationBinding operationBinding =
         pla.getOperationBinding("municipios_post");
         fra=operationBinding.execute();
        */   
    }

    public void setCombo_departamento(CoreSelectOneChoice combo_departamento) {
        this.combo_departamento = combo_departamento;
        //this.combo_departamento.setValue(3);
    }

    public CoreSelectOneChoice getCombo_departamento() {
        return combo_departamento;
    }

    public void setCombo_ordenced(CoreSelectOneChoice combo_ordenced) {
        this.combo_ordenced = combo_ordenced;
    }

    public CoreSelectOneChoice getCombo_ordenced() {
        return combo_ordenced;
    }

    public void cambio_ordenCed(ValueChangeEvent valueChangeEvent) {
       
        List <FacesCtrlListBinding> pa;
        pa=(List <FacesCtrlListBinding>)this.item_combo_orden.getValue();
        
        Object []ab;
        
        ab=pa.toArray();
         SelectItem abx;
         abx=(SelectItem)ab[Integer.parseInt(combo_ordenced.getValue().toString())];       
         System.out.println(abx.getLabel());
        orden_Cedula=abx.getLabel();
        System.out.println("cambiado el orden de cedula" + orden_Cedula); 
        usuario.set_opciones(usuario.SEL_ORDEN,abx.getLabel()); 
        
        BindingContainer pla;
        FacesContext ctx;
        Object fra;
        
        ctx = FacesContext.getCurrentInstance(); 
        Application app = ctx.getApplication();
        ValueBinding bind = app.createValueBinding("#{bindings}");
        pla=(BindingContainer)bind.getValue(ctx);
        //return bind.getValue(ctx);
        
         OperationBinding operationBinding =
         pla.getOperationBinding("Municipio_by_Orden_Post");
         fra=operationBinding.execute();
        
        
    }

    public void setItem_combo_orden(UISelectItems item_combo_orden) {
        this.item_combo_orden = item_combo_orden;
    }

    public UISelectItems getItem_combo_orden() {
        return item_combo_orden;
    }

    public void setItem_combo_dep(UISelectItems item_combo_dep) {
        this.item_combo_dep = item_combo_dep;
    }

    public UISelectItems getItem_combo_dep() {
        return item_combo_dep;
    }

    public String btn_nuevo_action() {
        // Add event code here...
         usuario.set_opciones(usuario.SEL_REGEMPLEADO,0 ); 
         return "ver_empleado";
    }

    public String cmdlk_contrato_action() {
        // Add event code here...
         usuario.set_opciones(usuario.SEL_CONTRATO,Long.parseLong(this.cmdlnk_contrato.getText()) ); 
         usuario.set_opciones(usuario.VISTA_CONTRATO,1); 
         return "ver_contrato";
    }

    public void setCmdlnk_contrato(CoreCommandLink cmdlnk_contrato) {
        this.cmdlnk_contrato = cmdlnk_contrato;
    }

    public CoreCommandLink getCmdlnk_contrato() {
        return cmdlnk_contrato;
    }

    public String btn_nuevoContrato_action() {
        // Add event code here...
         usuario.set_opciones(usuario.SEL_CONTRATO,new Long(0) ); 
         usuario.set_opciones(usuario.VISTA_CONTRATO,3); 
         return "ver_contrato";
    }
}
