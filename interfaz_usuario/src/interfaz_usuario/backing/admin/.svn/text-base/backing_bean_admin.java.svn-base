package interfaz_usuario.backing.admin;

import enlace_datos.util.resulOp;

import interfaz_usuario.util.JSFUtils;

import interfaz_usuario.util.utils;

import java.util.HashMap;
import java.util.Map;

import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import oracle.adf.view.faces.component.core.nav.CoreCommandButton;
import oracle.adf.view.faces.context.AdfFacesContext;

import oracle.adf.view.faces.event.ReturnEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class backing_bean_admin {
    private CoreCommandButton btn_upload_docClasif;

    public backing_bean_admin() {
    }

    public String btn_commit_param_aplicacion_action() {
        BindingContainer vBnd_binding;
        OperationBinding operationBinding;
        vBnd_binding=(BindingContainer)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings}");
        operationBinding=vBnd_binding.getOperationBinding("Commit");
        operationBinding.execute();
        
        if (operationBinding.getErrors().isEmpty()){
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.vEditar1.inputValue}","0");
            utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Datos guardados correctamente."));            
        }
     return null;   
    }

    public String btn_commit_ajustePartida_action() {
        BindingContainer vBnd_binding;
        OperationBinding operationBinding;
        vBnd_binding=(BindingContainer)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings}");
        operationBinding=vBnd_binding.getOperationBinding("Commit");
        operationBinding.execute();
        
        if (operationBinding.getErrors().isEmpty()){
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.vEditar1.inputValue}","0");
            utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Datos guardados correctamente."));            
        }
      return null;  
    }

    public String btn_commit_ajusteTipNomina_action() {
         BindingContainer vBnd_binding;
         OperationBinding operationBinding;
         vBnd_binding=(BindingContainer)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings}");
         operationBinding=vBnd_binding.getOperationBinding("Commit");
         operationBinding.execute();
         
         if (operationBinding.getErrors().isEmpty()){
             JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.vEditar1.inputValue}","0");
             utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Datos guardados correctamente."));            
         }
         return null;
    }

    public String guardar_operacion_puesto() {
        String vOutcome=null;
        
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit"))
        {
            
            utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Datos guardados exitosamente."));
            vOutcome="search_puesto";
            
        }
        
        return vOutcome;
    }

    public String commit_mod_escala() {
        
        String vOutcome=null;
        
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit"))
        {
            
            vOutcome="ver_puesto";
            utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Datos guardados exitosamente."));
        }
        
        return vOutcome;
    }

    public String del_buscarPuesto() {

         if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"setCurrentRowWithKey"))
         {
             if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"borrarPuesto"))
             {
                 JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ExecuteWithParams1");
                 utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Se ha borrado el puesto exitosamente."));
             
             }          
         
         }          
        return null;
    }

    public String btnCommit_puestos() {
    
         if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit"))
         {
                     
             JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"deshabilitaTodos");         
             
             utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Datos guardados exitosamente."));
         }
        return null;
    }

    public String cmd_del_escala_puesto() {
         if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"PosicionarEscala"))
         {
             if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"DelEscala"))
             {
                 if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit"))
                 {
                 
                     utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Se ha borrado la escala exitosamente."));
                 
                 }
                 
             }          
         
         }          

        return null;
    }

    public String btn_adjuntar_documento_clasif() {
         FacesContext context = FacesContext.getCurrentInstance();  
          ViewHandler vh = context.getApplication().getViewHandler();  
            // el jspx que se mostrara en forma de  ventana emergente  
          UIViewRoot dialog = vh.createView(context, "/util/subir_documento.jspx");  
          AdfFacesContext a = AdfFacesContext.getCurrentInstance();  
            // fijamos el ancho y el alto de la ventana emergente  
           Map windowProperties = new HashMap();  
           windowProperties.put("width", new Integer(450));  
           windowProperties.put("height", new Integer(350));  
           //añadimos mas paremetros que seran recogidos en la jspx ventana  
           Map dialogParameters = new HashMap();  
           dialogParameters.put("Modulo","PUESTOS");
           dialogParameters.put("Opcion", 6);
           a.launchDialog(dialog,dialogParameters,this.getBtn_upload_docClasif(),true,windowProperties);

        return null;
    }

    public void returnlistener_documentoClasif(ReturnEvent returnEvent) {
        // Add event code here...
     //   System.out.println("Retorno");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Ejecutar");
        
    }

    public void setBtn_upload_docClasif(CoreCommandButton btn_upload_docClasif) {
        this.btn_upload_docClasif = btn_upload_docClasif;
    }

    public CoreCommandButton getBtn_upload_docClasif() {
        return btn_upload_docClasif;
    }

    public String btn_editar_escala() {
        // Add event code here...
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"PosicionarEscala")){
            
            JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"setModifActual");
            
        }
        
        return null;
    }
}
