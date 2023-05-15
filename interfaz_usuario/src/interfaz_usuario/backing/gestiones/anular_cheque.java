package interfaz_usuario.backing.gestiones;

import enlace_datos.util.resulOp;

import interfaz_usuario.util.JSFUtils;

import interfaz_usuario.util.utils;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import oracle.adf.view.faces.component.core.input.CoreSelectInputText;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class anular_cheque {
    private CoreSelectInputText sel_inpt_reg_Empleado;

    public anular_cheque() {
    }

    public void setSel_inpt_reg_Empleado(CoreSelectInputText sel_inpt_reg_Empleado) {
        this.sel_inpt_reg_Empleado = sel_inpt_reg_Empleado;
        if (this.sel_inpt_reg_Empleado.getValue()==null){
           this.sel_inpt_reg_Empleado.setValue(JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{sessionScope.selRegEmpleado}")); 
        }
   
    }

    public CoreSelectInputText getSel_inpt_reg_Empleado() {
        return sel_inpt_reg_Empleado;
    }
    
    
    public String btn_commit_anula_cheque_action() {
    
        BindingContainer vBnd_binding;
        OperationBinding operationBinding;
        Object result,vPerf;
        resulOp vResultado=new resulOp();
        boolean vResultadoOp=false;
        boolean vPerfil;
        
        
  //      if (this.getSel_inpt_reg_Empleado().getValue()!=null){
  //          JSFUtils.setManagedBeanValue(FacesContext.getCurrentInstance(),"sessionScope.selRegEmpleado",this.getSel_inpt_reg_Empleado().getValue().toString().trim());
  //      }
        
        // DESHABILITADO TEMPORALMENTE 
        vBnd_binding=(BindingContainer)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings}");        
        /*
        //operationBinding=vBnd_binding.getOperationBinding("Commit");
         operationBinding=vBnd_binding.getOperationBinding("verificarPago_Anular");
         result=operationBinding.execute();  
         */
         
        // JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit");
         
         result="1";
         
         vPerf=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vPerfiles1.inputValue}");        
         
         vPerfil=VerificaRol(vPerf==null?"":vPerf.toString());
         
         if (vPerfil==true)
         {
         
             // Han habido cambios en nomina cheque 
             if (result!=null && result.toString().equals("1")){
                
                 operationBinding=vBnd_binding.getOperationBinding("Commit");
                 result=operationBinding.execute();  
                 
                 if (operationBinding.getErrors().isEmpty()){
                     JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Eje_pagoAnulado");
                     vResultado.setMensajeError("Cheque Anulado Correctamente");
                     vResultado.setCodigoResultado(resulOp.OPE_OK);
                     utils.setADFMensaje(vResultado);
                     vResultadoOp=true;
                 }
                 if (vResultadoOp){
                     return null;
                 }else{
                     return null;
                 }                  
                 
             }else if(result!=null && result.toString().equals("-1")){
             
                 utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Ha ocurrido un error inesperado. Por favor intente nuevamente.")); 
                 
             }
             else{
                 
                utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"No han habido variaciones a la nómina, no se permite anular pago. Por favor realice las variaciones a la nomina e intente nuevamente.")); 
                 
             }    
             
         } else{
             
               utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"El motivo de anulación no es permitido para su perfil. Por favor dirigirse al Depto Caja Central."));  
               
         }
    return null;   
    }

 
private boolean VerificaRol(String pPerfiles)
{

  String []pRol;  
  boolean vExiste=false;
  pRol=pPerfiles.split("\\|");
  ExternalContext vExContexto;   
    
  if (pRol!=null)
  {
  
   try
   {
     
      vExContexto=FacesContext.getCurrentInstance().getExternalContext();  
      
  
      for (int i=0;i<=pRol.length;i++)
      {
          
          vExiste=vExContexto.isUserInRole(pRol[i]);  
          if (vExiste){
              break;
          }
          
      }
   
   }catch(Exception exep){
       
       
   }
           
  }      
return vExiste;
}
    
}
