package interfaz_usuario.backing.gestiones;

import enlace_datos.util.resulOp;

import interfaz_usuario.util.JSFUtils;

import interfaz_usuario.util.utils;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import oracle.adf.view.faces.component.core.input.CoreInputText;
import oracle.adf.view.faces.component.core.input.CoreSelectOneRadio;

import oracle.adf.view.faces.component.core.nav.CoreCommandButton;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class cheq_anular {
    private BindingContainer bindings;
    private CoreInputText inpt_acredit_obsrv;


    public cheq_anular() {
    }

    public BindingContainer getBindings() {
        return this.bindings;
    }

    public void setBindings(BindingContainer bindings) {
        this.bindings = bindings;
    }

  
  public String ejec_cheqAnular() {
        BindingContainer bindings;
        bindings =(BindingContainer)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings}");
        
        OperationBinding operationBinding = 
            bindings.getOperationBinding("ExecuteWithParams");
        Object result = operationBinding.execute();
        Object vResult1;
        
        result=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdDocumentoBanco.inputValue}");
        
        //vResult1=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.var_NumCheque1.inputValue}");
        
        
        if (result!=null){
            //utilizado para pasar como parametro el No. de cheque al viewobjet q muestra el detalle del cheque   
                operationBinding = 
                            bindings.getOperationBinding("ExecuteWithParams1");
                 result = operationBinding.execute();
        }else{
            operationBinding = 
                        bindings.getOperationBinding("ResetDetCheque");
             result = operationBinding.execute();
            
        }
                
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        return null;
        //Metodo q se utuliza para ejecutar con parametros la busqueda de un cheque en la pagiana
        //buscar_cheq_anular.jspx
    }

   /* public BindingContainer getBindings() {
        return this.bindings;
    }

    public void setBindings(BindingContainer bindings) {
        this.bindings = bindings;
    }*/
 
    public String  buscar_acredit() {
         
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ExecuteWithParams");
         
          return null;
      
      }

    public String btn_agregar_anul_acredit() {
    
      if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"crearConciliaAcreditM"))
      {
      
         this.inpt_acredit_obsrv.setRendered(true);
        
      }
    return null;
}

    public void setInpt_acredit_obsrv(CoreInputText inpt_acredit_obsrv) {
        this.inpt_acredit_obsrv = inpt_acredit_obsrv;
    }

    public CoreInputText getInpt_acredit_obsrv() {
        return inpt_acredit_obsrv;
    }

    public String btn_commit_anul_acredit() {
    
       if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit")){
         
          this.inpt_acredit_obsrv.setRendered(false);
          utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Datos guardados exitosamente!"));
          
          JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"ExecuteWithParams");
           
       }
   
        return null;
    }

    public String btn_rollback_anul_acredit() {
    
         if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Rollback")){
           
            this.inpt_acredit_obsrv.setRendered(false);
            
         }
        return null;
    }
}
