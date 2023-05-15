package interfaz_usuario.backing.gestiones;

import enlace_datos.util.resulOp;

import interfaz_usuario.usuario;

import interfaz_usuario.util.JSFUtils;

import interfaz_usuario.util.utils;

import java.util.List;

import javax.faces.context.FacesContext;

import javax.faces.event.ValueChangeEvent;

import javax.faces.model.SelectItem;

import oracle.adf.view.faces.component.core.data.CoreTable;
import oracle.adf.view.faces.component.core.data.CoreTableSelectOne;
import oracle.adf.view.faces.component.core.input.CoreInputText;
import oracle.adf.view.faces.component.core.input.CoreSelectOneChoice;
import oracle.adf.view.faces.component.core.layout.CoreShowOneRadio;
import oracle.adf.view.faces.component.core.nav.CoreCommandLink;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import pkg_autenticacion.menu.MenuModelAdapter;

public class List_empleadoAct {
    private CoreCommandLink cmdlnk_reg_empleado;
    private CoreTable tbl_empleados;
    private CoreInputText inptt_reg_empleado;
    private CoreShowOneRadio swrdio_tipoBusqueda;
    private CoreTableSelectOne tableSelectOne1;
    private CoreSelectOneChoice cmb_nivelAcademico1;
    private CoreSelectOneChoice cmb_institucionAca;

    boolean vCambioDireccion=false;
    private boolean vCambNivel=false;
    private boolean vCambioDeparta=false;
    private CoreSelectOneChoice cmb_departamento;
    private List<SelectItem> vListaItemsCheck;

    public List_empleadoAct() {
    
        vListaItemsCheck=utils.crearListaManyCheck("SisTipoJubiladoVwIterator","IdTipoJubilado","NombreTipjubilado");
    }

    public List<SelectItem> getListOfValuesCheck()
    {
    
           if (vListaItemsCheck==null){
               vListaItemsCheck=utils.crearListaManyCheck("SisTipoJubiladoVwIterator","IdTipoJubilado","NombreTipjubilado");            
           }
            return vListaItemsCheck;
    }


    

    public boolean getCambiaDireccion(){
        return vCambioDireccion;
    }
    
    public Boolean getCambioDep(){
        
      return vCambioDeparta;  
    }

     public Boolean getCambioNivel(){
     return this.vCambNivel;
     }

    public void setCambioNivel(boolean vValor){
        this.vCambNivel=vValor;
    }
    


    public String cmbtn_buscar_action() {
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Rollback");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ConsultaEmpleado");
        return null;
    }
    
    

        public String set_registro() {
           Object vValor;
           Object varOperacion = "",vRegistroSel;
           oracle.jbo.domain.Number vRegActual;  
            
           JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"posListaEmpl");
           vRegistroSel = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.RegistroEmpleado.inputValue}");
            
            
            
           usuario.set_opciones(usuario.SEL_REGEMPLEADO,utils.getNumber(vRegistroSel)); 
           
           usuario.set_opciones(usuario.VISTA_EMPLEADO,1); 
           usuario.set_opciones(usuario.EMPLSEL,1);
           JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.RegEmpleado1.inputValue}",utils.getNumberOracle(vRegistroSel));
          // JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.RegEmpleado.inputValue}",utils.getNumberOracle(this.cmlnk_reg_empleado.getText()));
           JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjeBusquedaEmpleado");     
           vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.NombreCompleto.inputValue}");
           JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"cambiarValidacion");
           usuario.set_opciones(usuario.NOMBREEMPLEADOSEL,vValor); 
           usuario.set_opciones(usuario.VISTA_CONTRATO,3); 
           
          vRegActual=utils.getNumberOracle(vRegistroSel);
          if (vRegActual.compareTo(90000000)>=0){
                   actualizarMenuDesabilita();
           }else{
                   actualizarMenu();    
           }
           
          return "gst_empleadoAct";
           }
        


  
    private void actualizarMenu(){
        Object vValor;
        MenuModelAdapter vMenu;
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{modeloMenu}");
        vMenu=(MenuModelAdapter)vValor;
        vMenu.cambiarEstadoItem("Empleado",false);
        
    }


    private void actualizarMenuDesabilita(){
        Object vValor;
        MenuModelAdapter vMenu;
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{modeloMenu}");
        vMenu=(MenuModelAdapter)vValor;
        vMenu.cambiarEstadoItem("Empleado",true);
        
    }

    public void setCmdlnk_reg_empleado(CoreCommandLink cmdlnk_reg_empleado) {
        this.cmdlnk_reg_empleado = cmdlnk_reg_empleado;
    }

    public CoreCommandLink getCmdlnk_reg_empleado() {
        return cmdlnk_reg_empleado;
    }

    public void setTbl_empleados(CoreTable tbl_empleados) {
        this.tbl_empleados = tbl_empleados;
    }

    public CoreTable getTbl_empleados() {
        return tbl_empleados;
    }

    public void setInptt_reg_empleado(CoreInputText inptt_reg_empleado) {
        this.inptt_reg_empleado = inptt_reg_empleado;
    }

    public CoreInputText getInptt_reg_empleado() {
        return inptt_reg_empleado;
    }

    public void setSwrdio_tipoBusqueda(CoreShowOneRadio swrdio_tipoBusqueda) {
        this.swrdio_tipoBusqueda = swrdio_tipoBusqueda;
    }

    public CoreShowOneRadio getSwrdio_tipoBusqueda() {
        return swrdio_tipoBusqueda;
    }

    public void setTableSelectOne1(CoreTableSelectOne tableSelectOne1) {
        this.tableSelectOne1 = tableSelectOne1;
    }

    public CoreTableSelectOne getTableSelectOne1() {
        return tableSelectOne1;
    }

public String btn_commit_Action()
{      
     resulOp vResultado=new resulOp();
     boolean vResultadoOps=false;
     Object vDireccion;
      
     vDireccion=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.SisDireccion_vwIterator.estimatedRowCount}");

     if (!vDireccion.toString().equals("0"))
     {

        
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"commit2"))
        {
        
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Exe_buscarEmpleado");
            vResultado.setMensajeError("Datos actualizados correctamente");    
            vResultado.setCodigoResultado(resulOp.OPE_OK);
            utils.setADFMensaje(vResultado); 
            vResultadoOps=true;
            
        }
    
    }else{
    
       utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"- Ingrese una dirección")); 
        
    }

        return null;

}

    public void setCmb_nivelAcademico1(CoreSelectOneChoice cmb_nivelAcademico1) {
        this.cmb_nivelAcademico1 = cmb_nivelAcademico1;
    }

    public CoreSelectOneChoice getCmb_nivelAcademico1() {
        return cmb_nivelAcademico1;
    }

    public void cmb_nivelAcademico_action(ValueChangeEvent valueChangeEvent) {
         if (
         
         !valueChangeEvent.getNewValue().toString().equals(valueChangeEvent.getOldValue()!=null?valueChangeEvent.getOldValue().toString():"")
         
         ){
             this.cmb_institucionAca.setSubmittedValue(0);
             this.vCambNivel=true;
         }

    }

    public void setCmb_institucionAca(CoreSelectOneChoice cmb_institucionAca) {
        this.cmb_institucionAca = cmb_institucionAca;
    }

    public CoreSelectOneChoice getCmb_institucionAca() {
        return cmb_institucionAca;
    }

    public void cmb_dep_direccion_change(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
    }

    public void setCmb_departamento(CoreSelectOneChoice cmb_departamento) {
        this.cmb_departamento = cmb_departamento;
    }

    public CoreSelectOneChoice getCmb_departamento() {
        return cmb_departamento;
    }
    
    
    public String act_tabla_direccion() {
        
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"setNombres");
        
        return null;
    }

    public String btn_selEmpleado_action() {
        // Add event code here...
        Object vValor,vRegTempo,vEstadoRegistro;
        oracle.jbo.domain.Number vRegActual;
        
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjeBusquedaEmpleado");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"cambiarValidacion");
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.RegistroEmpleado.inputValue}");
        usuario.set_opciones(usuario.SEL_REGEMPLEADO,utils.getNumber(vValor)); 
        this.inptt_reg_empleado.setValue(vValor);
        vRegTempo=vValor;
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.NombreCompleto.inputValue}");
        usuario.set_opciones(usuario.NOMBREEMPLEADOSEL,vValor); 
        usuario.set_opciones(usuario.EMPLSEL,1);
        usuario.set_opciones(usuario.SEL_CONTRATO,new Long(0) ); 
        usuario.set_opciones(usuario.VISTA_EMPLEADO,1); 
        usuario.set_opciones(usuario.VISTA_CONTRATO,3); 
        
        vEstadoRegistro=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.Nomestado.inputValue}");
        vRegActual=utils.getNumberOracle(vRegTempo);
        
        usuario.set_opciones(usuario.ESTADO_EMPLEADO ,vEstadoRegistro); 
        if (vEstadoRegistro!=null && vEstadoRegistro.toString().equals("DESHABILITADO")){
            
            actualizarMenuDesabilita();
            
        }else {
            
            if (vRegActual.compareTo(90000000)>=0){
                actualizarMenuDesabilita();
            }else{
                actualizarMenu();    
            }
                
            
        }
        
      
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.RegistroEmpleado.inputValue}");
        
      //  System.out.println("reg actual:" + vValor);        
        
        return "refresh_lstEmpl";
    }

}


