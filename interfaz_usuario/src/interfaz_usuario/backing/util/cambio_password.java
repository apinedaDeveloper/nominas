package interfaz_usuario.backing.util;

import enlace_datos.util.resulOp;

import interfaz_usuario.util.JSFUtils;

import interfaz_usuario.util.utils;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import oracle.adf.view.faces.component.core.CorePoll;
import oracle.adf.view.faces.component.core.input.CoreInputText;
import oracle.adf.view.faces.component.core.input.CoreSelectOneChoice;
import oracle.adf.view.faces.component.core.layout.CorePanelForm;
import oracle.adf.view.faces.component.core.nav.CoreCommandButton;
import oracle.adf.view.faces.event.PollEvent;

import oracle.jbo.JboException;

public class cambio_password {
    private CoreInputText inpt_clave_actual;
    private CoreInputText inpt_clave_nueva;
    private CoreInputText inpt_clave_nueva2;
    private CorePoll afPoll;
    private CoreCommandButton btn_cambiar;
    private CoreCommandButton btn_cancelar;
    private CoreInputText inpt_preg_Seguridad;
    private CoreInputText inpt_respuesta_seg;
    private CorePanelForm pnl_form1;
    private CoreSelectOneChoice cmb_respuesta;

    public cambio_password() {
    }

    public String btn_cambiar_password() {
        List vErrrores;
        Object vValor,vUsuario;;
        
        
        vUsuario=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{flujo_usuario.selRegEmpleado_login}");        
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.ModPor.inputValue}",vUsuario);
        
        vErrrores=JSFUtils.EjecutarAcccion3(FacesContext.getCurrentInstance(),"Commit");
        if (vErrrores.size()==0) 
        {
            
            JSFUtils.setManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.validarPassword",false);
            utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Se ha cambiado la contraseña!"));           
            this.btn_cambiar.setDisabled(true);
            this.btn_cancelar.setDisabled(true);
            this.inpt_clave_actual.setDisabled(true);
            this.inpt_clave_nueva.setDisabled(true);
            this.inpt_clave_nueva2.setDisabled(true);
            this.inpt_preg_Seguridad.setDisabled(true);
            this.inpt_respuesta_seg.setDisabled(true);
            this.cmb_respuesta.setDisabled(true);
            
        }else{
            
            AgregarErroresControl(vErrrores);
            
        }
        
        
        
        return null;
    }
    
    public void setInpt_clave_actual(CoreInputText inpt_clave_actual) {
        this.inpt_clave_actual = inpt_clave_actual;
    }

    public CoreInputText getInpt_clave_actual() {
        return inpt_clave_actual;
    }

    public void setInpt_clave_nueva(CoreInputText inpt_clave_nueva) {
        this.inpt_clave_nueva = inpt_clave_nueva;
    }

    public CoreInputText getInpt_clave_nueva() {
        return inpt_clave_nueva;
    }

    public void setInpt_clave_nueva2(CoreInputText inpt_clave_nueva2) {
        this.inpt_clave_nueva2 = inpt_clave_nueva2;
    }

    public CoreInputText getInpt_clave_nueva2() {
        return inpt_clave_nueva2;
    }

    public void poll_listener(PollEvent pollEvent) {
       //System.out.println("Pollll");
       String vPagina;
       try{
     //  vPagina=JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"variablesSession.urlAnterior").toString();
     //  JSFUtils.setManagedBeanValue(FacesContext.getCurrentInstance(),"variablesSession.urlAnterior","");
     //  FacesContext.getCurrentInstance().getExternalContext().redirect(vPagina);
       }catch(Exception exep){
            exep.printStackTrace();
       }
    }

    public void setAfPoll(CorePoll afPoll) {
        this.afPoll = afPoll;
    }

    public CorePoll getAfPoll() {
        return afPoll;
    }


    public void setBtn_cambiar(CoreCommandButton btn_cambiar) {
        this.btn_cambiar = btn_cambiar;
    }

    public CoreCommandButton getBtn_cambiar() {
        return btn_cambiar;
    }

    public void setBtn_cancelar(CoreCommandButton btn_cancelar) {
        this.btn_cancelar = btn_cancelar;
    }

    public CoreCommandButton getBtn_cancelar() {
        return btn_cancelar;
    }


    public void setInpt_preg_Seguridad(CoreInputText inpt_preg_Seguridad) {
        this.inpt_preg_Seguridad = inpt_preg_Seguridad;      
        
    }

    public CoreInputText getInpt_preg_Seguridad() {
        return inpt_preg_Seguridad;
    }

    public void setInpt_respuesta_seg(CoreInputText inpt_respuesta_seg) {
        this.inpt_respuesta_seg = inpt_respuesta_seg;
    }

    public CoreInputText getInpt_respuesta_seg() {
        return inpt_respuesta_seg;
    }

    public void AgregarErroresControl(List pErrores){
        int vCantidadErrores=pErrores.size();
        JboException vError;
        String vIdComponente;
        FacesMessage vMessage; 
          for (int vContador=0;vContador<vCantidadErrores;vContador++)
          {
                             
             if (pErrores.get(vContador).getClass()==JboException.class) {
                 
                  vError=(JboException)pErrores.get(vContador);
                  vIdComponente= BuscarIdPaginaComponente(this.pnl_form1,vError.getErrorCode());
                               
                      if (vIdComponente!=null && !vIdComponente.equals("")){
                         //  System.out.println("Agregando a control");
                           vMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,vError.getMessage(),null);
                           FacesContext.getCurrentInstance().addMessage(vIdComponente,vMessage);       
                                                                           }
          
                                                                   }
            }
    }

     public String BuscarIdPaginaComponente(CorePanelForm pForma,String pIdComponente){
         Object vCompo; 
         String vId=null;
         vCompo=pForma.findComponent("inpt_"+pIdComponente.toLowerCase());
          if (vCompo==null){
              vCompo=pForma.findComponent("cmb_"+pIdComponente.toLowerCase());
          }
         
          if (vCompo==null){
              vCompo=pForma.findComponent("chk_"+pIdComponente.toLowerCase()); 
          }

         if (vCompo==null){
             vCompo=pForma.findComponent("sel_"+pIdComponente.toLowerCase());
         }
         
          if (vCompo!=null){
             vId=utils.getNomControlCliente(vCompo);
          }
       
     return vId;
     }


    public void setPnl_form1(CorePanelForm pnl_form1) {
        this.pnl_form1 = pnl_form1;
    }

    public CorePanelForm getPnl_form1() {
        return pnl_form1;
    }

    public void setCmb_respuesta(CoreSelectOneChoice cmb_respuesta) {
        this.cmb_respuesta = cmb_respuesta;
    }

    public CoreSelectOneChoice getCmb_respuesta() {
        return cmb_respuesta;
    }
    
}