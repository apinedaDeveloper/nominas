package interfaz_usuario.backing.gestiones;

import enlace_datos.consultas.gestiones.contrato.SisUnidadesEjecutoras_Id_vwImpl;

import enlace_datos.util.resulOp;

import interfaz_usuario.util.JSFUtils;

import interfaz_usuario.util.utils;

import javax.faces.context.FacesContext;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.faces.component.core.data.CoreTableSelectOne;
import oracle.adf.view.faces.component.core.input.CoreInputText;
import oracle.adf.view.faces.component.core.input.CoreSelectOneChoice;
import oracle.adf.view.faces.component.core.layout.CoreShowDetailItem;
import oracle.adf.view.faces.component.core.nav.CoreCommandButton;

import oracle.adf.view.faces.context.AdfFacesContext;

import oracle.jbo.Row;

public class declaracionjuada {
    private CoreInputText inptRegistro;
    private CoreTableSelectOne sele_tbl_declaraMaster;
    private CoreCommandButton btn_CrearDecJurada;
    private CoreCommandButton btn_crearHorario;
    private CoreCommandButton btn_eliminarHorario;
    private CoreCommandButton btn_editHorario;
    private CoreCommandButton btn_ok_horario;
    private CoreTableSelectOne sele_tbl_horario;
    private CoreInputText inpt_empresa;
    private CoreInputText inpt_direccion;
    private CoreSelectOneChoice cmb_subprograma;
    private CoreCommandButton btn_delDeclara;
    private CoreCommandButton btn_EdDecla;
    private CoreShowDetailItem shwmMensualISR;
    private CoreShowDetailItem shwnAnualISR;

    public declaracionjuada() {
    }

    public String btn_crear_action() {
        // Add event code here...
        
         if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Crear")) 
         {
             
        this.sele_tbl_declaraMaster.setDisabled(true);
        this.btn_CrearDecJurada.setDisabled(true); 
        this.btn_delDeclara.setDisabled(true);
        this.btn_crearHorario.setDisabled(true);
        this.btn_EdDecla.setDisabled(true);
             
         }
        
        return null;
    }

    public void setInptRegistro(CoreInputText inptRegistro) {
        this.inptRegistro = inptRegistro;
    }

    public CoreInputText getInptRegistro() {
        return inptRegistro;
    }

    public String btn_actualiza() {
        // Add event code here...
      //   this.getInptRegistro().setRendered(false);
       Object v1;
       v1=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.SisDeclaracionJuradaVw.collectionModel}");

        return null;
    }

    public String btn_agregarHorario() {
        // Add event code here...
         if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"DisableAllH")) 
         {
             
             if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"crearHorario"))
             {
               this.sele_tbl_horario.setDisabled(true);
               this.btn_crearHorario.setDisabled(true);
               this.btn_editHorario.setDisabled(true);
             
                 
             }
             
         }
         
        return null;
    }

    public String btnEditarH() {
        
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"DisableAllH"))
        {
            if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"FilaActualH")){
                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"HabilitaActualH");
                
                this.sele_tbl_horario.setDisabled(true);
                this.btn_crearHorario.setDisabled(true);
                this.btn_editHorario.setDisabled(true);
                this.btn_eliminarHorario.setDisabled(true);
                
            }
            
        }
        return null;
    }

    public String btn_commit() {
        
        
        
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit"))
        {
            
            this.sele_tbl_horario.setDisabled(false);
            this.btn_crearHorario.setDisabled(false);
            this.btn_editHorario.setDisabled(false);
            this.btn_eliminarHorario.setDisabled(false);
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"DisableAllH");
            utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Datos guardados exitosamente."));
        }
        
        return null;
    }

    public void setSele_tbl_declaraMaster(CoreTableSelectOne sele_tbl_declaraMaster) {
        this.sele_tbl_declaraMaster = sele_tbl_declaraMaster;
    }

    public CoreTableSelectOne getSele_tbl_declaraMaster() {
        return sele_tbl_declaraMaster;
    }

    public String ok_decJurada_action() {
        
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit")){
            this.btn_CrearDecJurada.setDisabled(false);   
            this.sele_tbl_declaraMaster.setDisabled(false);
            this.btn_delDeclara.setDisabled(false);
            this.btn_crearHorario.setDisabled(false);
            this.btn_EdDecla.setDisabled(false);
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"DisableAllD");            
            utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Datos guardados exitosamente."));
        }
        
        return null;
  }

    public void setBtn_CrearDecJurada(CoreCommandButton btn_CrearDecJurada) {
        this.btn_CrearDecJurada = btn_CrearDecJurada;
    }

    public CoreCommandButton getBtn_CrearDecJurada() {
        return btn_CrearDecJurada;
    }

    public String edtiarDecJurada_action() {
         if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"DisableAllD"))
         {
            
         
             if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"FilaActualD")){
                 JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Habilitar");
             }
            
             this.btn_CrearDecJurada.setDisabled(true);   
             this.sele_tbl_declaraMaster.setDisabled(true);  
             this.btn_CrearDecJurada.setDisabled(true);
             this.btn_delDeclara.setDisabled(true);
             this.btn_EdDecla.setDisabled(true);
             
             
         }
        return null;
    }

public String btBorrar_DecJurada_action() {
        
       if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"borrarHorarios"))       
       {
           JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit"); 
       
           if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"DeleteDJ"))
           {
               JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit");
               utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Datos eliminados exitosamente."));
           }
                      
       }
        
        return null;
   }

    public void setBtn_crearHorario(CoreCommandButton btn_crearHorario) {
        this.btn_crearHorario = btn_crearHorario;
    }

    public CoreCommandButton getBtn_crearHorario() {
        return btn_crearHorario;
    }

    public void setBtn_eliminarHorario(CoreCommandButton btn_eliminarHorario) {
        this.btn_eliminarHorario = btn_eliminarHorario;
    }

    public CoreCommandButton getBtn_eliminarHorario() {
        return btn_eliminarHorario;
    }

    public void setBtn_editHorario(CoreCommandButton btn_editHorario) {
        this.btn_editHorario = btn_editHorario;
    }

    public CoreCommandButton getBtn_editHorario() {
        return btn_editHorario;
    }

    public void setBtn_ok_horario(CoreCommandButton btn_ok_horario) {
        this.btn_ok_horario = btn_ok_horario;
    }

    public CoreCommandButton getBtn_ok_horario() {
        return btn_ok_horario;
    }

    public void setSele_tbl_horario(CoreTableSelectOne sele_tbl_horario) {
        this.sele_tbl_horario = sele_tbl_horario;
    }

    public CoreTableSelectOne getSele_tbl_horario() {
        return sele_tbl_horario;
    }

    public String btn_eliminar_action() {
        // Add event code here...
        
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"DeleteH")){
            
            if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit"))
            {            
                utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Datos eliminados exitosamente."));
            }
            
        }
        
        return null;
    }

    public String btn_imprimir_action() {
        
        return null;
    }

    public void cmbSubprograma_valuechange(ValueChangeEvent valueChangeEvent) {
        Row[] vfilas;
        int vPosicion;
        Object  vDireccion;
        Object vNombreSubprograma=null;
        
        try{
        if (valueChangeEvent.getNewValue()!=valueChangeEvent.getOldValue()){
            
            
           vfilas=(Row [])JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.SisUnidadesEjecutoras_Id_vwIterator.allRowsInRange}");
           vPosicion=new Integer(valueChangeEvent.getNewValue().toString()); 
         
           if (vPosicion>0){
            vPosicion--; 
            vDireccion=vfilas[vPosicion].getAttribute("Ubicacion");
            vNombreSubprograma=vfilas[vPosicion].getAttribute("Nombresub");  
            this.inpt_empresa.setValue(vNombreSubprograma);
            this.inpt_direccion.setValue(vDireccion);
            
           }else{
               this.inpt_empresa.setValue("");
               this.inpt_direccion.setValue("");
           }
          

            
        }
     
        }catch(Exception exep){
            
        }
     
    }

    public void setInpt_empresa(CoreInputText inpt_empresa) {
        this.inpt_empresa = inpt_empresa;
    }

    public CoreInputText getInpt_empresa() {
        return inpt_empresa;
    }

    public void setInpt_direccion(CoreInputText inpt_direccion) {
        this.inpt_direccion = inpt_direccion;
    }

    public CoreInputText getInpt_direccion() {
        return inpt_direccion;
    }

    public void cmbTipoDeclaracion(ValueChangeEvent valueChangeEvent) {    
      try{  
             
         if (valueChangeEvent.getNewValue()!=valueChangeEvent.getOldValue() && valueChangeEvent.getNewValue()!=null)
         {        
             
             if (valueChangeEvent.getNewValue().toString().equals("E")){
                 //this.cmb_subprograma.;
                 this.cmb_subprograma.setDisabled(true);
             }
             else{
                 this.cmb_subprograma.setDisabled(false);
             }
         
          System.out.println(" debug "+valueChangeEvent.getNewValue());
         }
      }catch(Exception exep){
                  
    }
 }

    public void setCmb_subprograma(CoreSelectOneChoice cmb_subprograma) {
        this.cmb_subprograma = cmb_subprograma;
    }

    public CoreSelectOneChoice getCmb_subprograma() {
        return cmb_subprograma;
    }

    public void setBtn_delDeclara(CoreCommandButton btn_delDeclara) {
        this.btn_delDeclara = btn_delDeclara;
    }

    public CoreCommandButton getBtn_delDeclara() {
        return btn_delDeclara;
    }

    public void setBtn_EdDecla(CoreCommandButton btn_EdDecla) {
        this.btn_EdDecla = btn_EdDecla;
    }

    public CoreCommandButton getBtn_EdDecla() {
        return btn_EdDecla;
    }

    public String btn_rollback() {
         this.btn_CrearDecJurada.setDisabled(false);   
         this.sele_tbl_declaraMaster.setDisabled(false);
         this.btn_delDeclara.setDisabled(false);
         this.btn_crearHorario.setDisabled(false);
         this.btn_editHorario.setDisabled(false);
         this.btn_eliminarHorario.setDisabled(false);
         this.sele_tbl_horario.setDisabled(false);
         this.btn_EdDecla.setDisabled(false);
        return null;
    }

    public String btn_buscar() {
        
        Object vSeleccionado;
        
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"EjecutaISR"))
        {
        
            JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"verificarForma1101");
            JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"DecJurada");
            
            vSeleccionado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.isISrAnual.inputValue}");
            
            if (vSeleccionado!=null && vSeleccionado.toString().equals("true")){
                
                this.shwmMensualISR.setDisclosed(false);
                this.shwnAnualISR.setDisclosed(true);
                
            }else {
                
                this.shwmMensualISR.setDisclosed(true);
                this.shwnAnualISR.setDisclosed(false);
            }
            
            
        }
        
        return null;
    }

    public void setShwmMensualISR(CoreShowDetailItem shwmMensualISR) {
        this.shwmMensualISR = shwmMensualISR;
    }

    public CoreShowDetailItem getShwmMensualISR() {
        return shwmMensualISR;
    }

    public void setShwnAnualISR(CoreShowDetailItem shwnAnualISR) {
        this.shwnAnualISR = shwnAnualISR;
    }

    public CoreShowDetailItem getShwnAnualISR() {
        return shwnAnualISR;
    }

    public String btn_Cambia_anio() {
        // Add event code here...        
        JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"EjecutaDeclara");
        JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"EjecutaContratos");
        
        
        return null;
    }
}
