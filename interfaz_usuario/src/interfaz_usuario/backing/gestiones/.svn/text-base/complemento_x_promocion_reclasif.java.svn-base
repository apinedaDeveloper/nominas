package interfaz_usuario.backing.gestiones;

import enlace_datos.util.resulOp;

import interfaz_usuario.util.JSFUtils;

import interfaz_usuario.util.utils;

import java.util.Calendar;
import java.util.Date;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import oracle.adf.view.faces.component.core.input.CoreSelectInputDate;
import oracle.adf.view.faces.component.core.layout.CoreShowDetailItem;

import oracle.jbo.Row;
import oracle.jbo.uicli.binding.JUIteratorBinding;

public class complemento_x_promocion_reclasif {

    private CoreShowDetailItem tab_detalle;
    private CoreShowDetailItem tab_histo;
    private boolean vIdComplementoDet;

    public complemento_x_promocion_reclasif() {
    }    

    public String btnNuevaSolicitud() {
        // Add event code here...
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Rollback");
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pNuevo1.inputValue}","0");        
        this.tab_histo.setDisclosed(false);
        this.tab_detalle.setDisclosed(true);
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"crearSolicitud4");       
        //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarDet");
        return null;
    }

    public String btnCommit() {
        // Add event code here...
        //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"crearComplemento");        
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pEditarComplementoDet1.inputValue}","0"); 
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Confirmar");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarSisPromReclaf");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarDet");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"actualiza_desc_bono");
        JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"posicionaSeleccionado");
        JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"cambiarEstadoTodos");        
        return null;
    }

    public String cmd_solicitud() {
        // Add event code here...
         Object pIdSolicitud;         
         
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"setCurrentRowWithKey");
         JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pNuevo1.inputValue}","0");    
         
         pIdSolicitud=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdSolicitud.inputValue}");
              
         /*Calendar cal = Calendar.getInstance(); 
         cal.add(Calendar.MONTH, -6);
         fechaI=cal.getTime();
         
         fechaF= new Date();
        
         this.fechaI.setValue(fechaI);
         this.fechaF.setValue(fechaF);*/
         
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Compl");
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarComplemento");
        
         this.tab_histo.setDisclosed(false);
         this.tab_detalle.setDisclosed(true);

        return null;
    }

    public String btnGenerarComplemento() {
        // Add event code here...
         Object vViewObject,vSel,vIdSolicitud,vNuevo,pIdComple;              
         JUIteratorBinding vIterador;
         Row [] vFilas;
         int vNumeroFilas;
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Confirmar");
         vViewObject= JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.SisPromReclafView1Iterator}");
                 
         //vNuevo=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.pNuevo2.inputValue}");
                 
         if (vViewObject!=null)
         { 
         
        //   if (vNuevo!=null && vNuevo.toString().equals("1")){
             pIdComple=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdComplemento.inputValue}");  
             if (pIdComple == null) {
                JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"crearComplemento");
                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Confirmar");                           
                 JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarSisPromReclaf");                                            
                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Compl");
                pIdComple=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdComplemento.inputValue}");
                JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pIdVar1.inputValue}",pIdComple);

             }
         //    JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pNuevo2.inputValue}","0");  
               
          // }
                  
             vIterador=(JUIteratorBinding)vViewObject;            
             vFilas=vIterador.getAllRowsInRange();            
             vNumeroFilas=vFilas.length;             
             
             for (int i=0;i<vNumeroFilas;i++){
                 
                 //vIdSolicitud=vFilas[i].getAttribute("IdSolicitud"); 
                 //JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pIdSolicitud.inputValue}",vIdSolicitud);
                 
                 if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"generarComplementoPorPromocion"))
                    utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"La información del complemento se ha generado."));
                 else utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Ocurrió un error al tratar de generar el complemento."));
                 //pIdComple=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdComplemento.inputValue}");
                 //JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pIdVar2.inputValue}",pIdComple);                                    
                 
             }
             
          JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarSisPromReclaf");
          JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarDet");          
        
         }
         
         vViewObject=null;
         
        return null;
    }
    
    public String btnBorrar() {
        // Add event code here...
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"removeRowWithKey");
        return null;
    }
    
    public String btnCancel() {
        // Add event code here...
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Rollback");
        this.tab_histo.setDisclosed(true);
        this.tab_detalle.setDisclosed(false);
        return null;
    }
    
    public void setTab_histo(CoreShowDetailItem tab_histo) {
        this.tab_histo = tab_histo;
    }

    public CoreShowDetailItem getTab_histo() {
        return tab_histo;
    }

    public void setTab_detalle(CoreShowDetailItem tab_detalle) {
        this.tab_detalle = tab_detalle;
    }

    public CoreShowDetailItem getTab_detalle() {
        return tab_detalle;
    }


    public String cmdEliminarDet() {
        // Add event code here...
         if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"setDetalleCompl"))
         {
         
           if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"borrarDetComple")){
               JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Confirmar");
               utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Fila borrada exitosamente"));
               
           }
         } 
        return null;
    }

    public String cmdRefresh_action() {
        // Add event code here...
         if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"EjecutarComplemento")){
             
             JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"actualizarVW");
         }        
        return null;
    }

    public String cmdEditarComplementoDet_action() {
        // Add event code here...
    
        
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"setCurrentRowWithKey1"))
        {
        
            if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"cambiarEstadoTodos"))
            {
                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"cambiarEstadoActual");
                
            }
          
        }             
      
        return null;
    }

    public String btnAgregarReclasif_action() {
        // Add event code here...
        
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Confirmar");  
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarSisPromReclaf");  
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"CrearSisPromReclaf");                
        return null;
    }
    
    public String btn_agregar_desc_ant() {
        
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Confirmar")){
            
            if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"agregarDescuento")){                
                JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"EjecutarDesc");                
                JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"EjecutarDet");
               JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"posicionaSeleccionado");
            }
        }
      return null;  
    }
    
    
    public String btn_eliminar_ajuste() {
        // Add event code here...
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"delDetAjuste")){
            JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"actualiza_desc_bono");
            JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Confirmar");
            JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"EjecutarDet");
            JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"posicionaSeleccionado");
            
        }
        
        return null;
    }


    public String cmd_eliminar_ajuste_ant() {
         if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"delDetAjuste")){
             JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"actualiza_desc_bono");
             JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Confirmar");
             JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"EjecutarDet");
             JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"posicionaSeleccionado");
             
         }

        return null;
    }

    public String btn_cancel_edit_action() {
        // Add event code here...
        JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"cambiarEstadoTodos");
        return null;
    }

    public void selectOneRadio1_validator(FacesContext facesContext,
                                          UIComponent uiComponent,
                                          Object object) {
         JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"FiltrarPuestos");
         
    }

}
