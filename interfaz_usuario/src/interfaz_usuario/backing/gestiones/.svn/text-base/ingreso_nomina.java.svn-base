package interfaz_usuario.backing.gestiones;

import enlace_datos.util.resulOp;

import interfaz_usuario.util.JSFUtils;

import interfaz_usuario.util.utils;

import java.util.List;

import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import javax.faces.model.SelectItem;

import oracle.adf.view.faces.component.core.input.CoreInputText;
import oracle.adf.view.faces.component.core.input.CoreSelectOneChoice;

import oracle.adfinternal.view.faces.model.binding.FacesCtrlListBinding;

import oracle.jbo.domain.Number;

public class ingreso_nomina {
    private boolean cmb_partida1=false;
    private CoreSelectOneChoice cmb_partida;
    private CoreInputText inpt_partida;
    private UISelectItems item_cmb_partida;
    private CoreInputText inpt_anio;

    public ingreso_nomina() {
      Object vProceso;
      vProceso=JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.procesoSelOpe");
      if (vProceso==null){
      try{
       FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()+"/faces/gestiones/procesos_operador.jspx");   
       
      }catch(Exception exep){
          
      }
       
      }
        
    
    }

    public boolean getCmbPartida(){
        return cmb_partida1;
    }


    public String btn_crear_nomina() {
        Number vIdproceso;
        vIdproceso=(Number)JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.procesoSelOpe");
        Object IdPartidaActual,vAnio;
        IdPartidaActual=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.pIdPartida1.inputValue}");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"CreateNom");
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.IdProceso.inputValue}",vIdproceso);
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.IdPartida.inputValue}",IdPartidaActual);
        
        vAnio=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.pAnio1.inputValue}");
        
        this.getInpt_anio().setValue(utils.getNumberOracle(vAnio));
        this.getInpt_anio().setSubmittedValue(utils.getNumberOracle(vAnio));
        this.cmb_partida1=true;
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"LstPlazas");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"reset");
        
        //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjeAjuste");
        return null;
    }

    public void cmb_partida(ValueChangeEvent valueChangeEvent) {

        String vValorNuevo;
        String vValorViejo;
        
        vValorNuevo=valueChangeEvent.getNewValue()!=null?valueChangeEvent.getNewValue().toString():"";
        vValorViejo=valueChangeEvent.getOldValue()!=null?valueChangeEvent.getOldValue().toString():"";

            if (valueChangeEvent.getNewValue()!=null && !vValorNuevo.equals(vValorViejo)){
                this.cmb_partida1=true;
                Object []vAryl_DatosCombo;
                List <FacesCtrlListBinding> vClb_itemsValue;
                vClb_itemsValue=(List <FacesCtrlListBinding>)this.item_cmb_partida.getValue(); //binding del <f:selectItems>
                vAryl_DatosCombo=vClb_itemsValue.toArray();
                SelectItem vSlct_seleccionado;
                vSlct_seleccionado=(SelectItem)vAryl_DatosCombo[Integer.parseInt(valueChangeEvent.getNewValue().toString())];     
             //   System.out.println("cambiado la partida" +vSlct_seleccionado.getLabel());
                
                this.inpt_partida.setValue(vSlct_seleccionado.getLabel());
                 
            }else if (valueChangeEvent.getNewValue()==null){
                this.inpt_partida.setValue(null);
            }
        
    }

    public String btn_commit() {
        
        Object vValorPartida,vAnio;
        
        vAnio=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{flujo_usuario.anioActual}");
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.Anio.inputValue}",utils.getNumberOracle(vAnio));
        
       if(JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit")){
          JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pEstado_1.inputValue}","0"); 
          JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pEstado_2.inputValue}","0"); 
          JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjeAjuste");
        
          vValorPartida=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdPartida.inputValue}");
          JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pIdPartida1.inputValue}",vValorPartida);
                     
          utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Datos guardados correctamente."));
       }
      return null;  
    }

    public String btn_rollback() {
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"LstPlazas");
         JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pEstado_1.inputValue}","0"); 
         JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pEstado_2.inputValue}","0"); 
        return null;
    }

    public String btn_crear_ajuste() {
        //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjeAjuste");
        
        return null;
    }

    public void setCmb_partida(CoreSelectOneChoice cmb_partida) {
        this.cmb_partida = cmb_partida;
    }

    public CoreSelectOneChoice getCmb_partida() {
        return cmb_partida;
    }

    public void setInpt_partida(CoreInputText inpt_partida) {
        this.inpt_partida = inpt_partida;
        //System.out.println("debug" + this.getCmb_partida().getValue());
        //this.getCmb_partida().setv
        //this.getCmb_partida().setv
    }

    public CoreInputText getInpt_partida() {
        return inpt_partida;
    }

    public void setItem_cmb_partida(UISelectItems item_cmb_partida) {
        this.item_cmb_partida = item_cmb_partida;
    }

    public UISelectItems getItem_cmb_partida() {
        return item_cmb_partida;
    }

    public void inpt_partida_change(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        String vValorNuevo;
        String vValorViejo;
        
        vValorNuevo=valueChangeEvent.getNewValue()!=null?valueChangeEvent.getNewValue().toString():"";
        vValorViejo=valueChangeEvent.getOldValue()!=null?valueChangeEvent.getOldValue().toString():"";
        
        if (valueChangeEvent.getNewValue()!=null && !vValorNuevo.equals(vValorViejo)){

            Object []vAryl_DatosCombo;
            List <FacesCtrlListBinding> vClb_itemsValue;
            vClb_itemsValue=(List <FacesCtrlListBinding>)this.item_cmb_partida.getValue(); //binding del <f:selectItems>
            vAryl_DatosCombo=vClb_itemsValue.toArray();
            SelectItem vSlct_seleccionado;
            int vCantidad;
            boolean vEncontrado=false;
            vCantidad=vAryl_DatosCombo.length;
            
            for (int i=0;i<vCantidad;i++){
                vSlct_seleccionado=(SelectItem)vAryl_DatosCombo[i];         
                if (vSlct_seleccionado.getLabel().equals(valueChangeEvent.getNewValue().toString())){
                    this.cmb_partida.setValue(i);
                    vEncontrado=true;
                    this.cmb_partida1=true;
                    break;
                }
            }
            
            
            if (vEncontrado==false){
               utils.setADFMensajetoControl(new resulOp(resulOp.OPE_ERROR,"No existe la partida"),utils.getNomControlCliente(this.getInpt_partida())); 
            }

            //System.out.println("cambiado la partida desde input "+ valueChangeEvent.getNewValue() );
            
        }
    }

    public void setInpt_anio(CoreInputText inpt_anio) {
        this.inpt_anio = inpt_anio;
    }

    public CoreInputText getInpt_anio() {
        return inpt_anio;
    }

    public String btnEditarNomina_action() {
        this.cmb_partida1=true;
        return null;
    }

    public String btn_reset_busqueda_action() {
         Object vValor;
         
         
         vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.SisNominaVwIterator.findMode}");
         
         if (!vValor.equals(true)){
             JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Find");
         }
         
         JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.RegistroEmpleado.inputValue}","");      
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.Numpartida.inputValue}","");      
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjeNomina");

        return null;
    }

    public void inpt_Anio(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
         this.cmb_partida1=true;
    }
}
