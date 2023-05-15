package interfaz_usuario.backing.gestiones;

import enlace_datos.util.resulOp;

import interfaz_usuario.backing.util.util_dialog_adf;

import interfaz_usuario.usuario;

import interfaz_usuario.util.JSFUtils;

import interfaz_usuario.util.utils;

import java.util.Iterator;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import oracle.adf.view.faces.component.core.data.CoreTable;
import oracle.adf.view.faces.component.core.nav.CoreCommandButton;
import oracle.adf.view.faces.context.AdfFacesContext;
import oracle.adf.view.faces.event.LaunchEvent;

import oracle.adf.view.faces.event.ReturnEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Key;

import pkg_autenticacion.menu.MenuModelAdapter;

public class rev_solicitud {
    private CoreTable tbl_sol;
    private CoreCommandButton btn_actualizar;

    public rev_solicitud() {
    }


    public String cmd_id_solicitud() {
    
     return setSolicitud(1);
     
    }

    public String setSolicitud(int pOpcion) {  // pOpcion = 1  pendientes , 2 = revisados 
        
        Object vSolicitud,vRegEmpleado,vNomSolicitud,vValor,vFechaC;
        solicitud vSol=new solicitud();
        String vOutcome=null,vFechaBusqueda;
        oracle.jbo.domain.Date vFechaC1;
        
        if (pOpcion==1) 
        {
        
        vSolicitud=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.SisSolicitudPendiente_vw.currentRow['idSolicitud']}");
        vRegEmpleado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.SisSolicitudPendiente_vw.currentRow['registroEmpleado']}");
        vNomSolicitud=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.SisSolicitudPendiente_vw.currentRow['nombreSolicitud']}");
        vFechaC=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.SisSolicitudPendiente_vw.currentRow['fechaCreacion']}");
        
        }else{
        
            vSolicitud=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.Sis_Solicitud_rev_vw.currentRow['idSolicitud']}");
            vRegEmpleado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.Sis_Solicitud_rev_vw.currentRow['registroEmpleado']}");
            vNomSolicitud=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.Sis_Solicitud_rev_vw.currentRow['nombreSolicitud']}");
            vFechaC=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.Sis_Solicitud_rev_vw.currentRow['fechaCreacion']}");    
            
        }
        
        
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.RegEmpleado.inputValue}",vRegEmpleado);
      
       // vKey=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.SisSolicitudPendiente_vwIterator.currentRow.rowKeyStr}");
        
        if (vFechaC.getClass()==oracle.jbo.domain.Date.class){
            vFechaC1=(oracle.jbo.domain.Date)vFechaC;
            vFechaBusqueda=utils.getFechaFormato2("yyyy",vFechaC1);
        }else{
            
            vFechaBusqueda=utils.getAnioActual();
        }
        
        /* ******        ***************       ****/
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"DatosEmpleado");
        //vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.RegistroEmpleado.inputValue}");
        usuario.set_opciones(usuario.SEL_REGEMPLEADO,utils.getNumber(vRegEmpleado)); 
      //  this.inptt_reg_empleado.setValue(vValor);
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.NombreCompleto.inputValue}");
        usuario.set_opciones(usuario.NOMBREEMPLEADOSEL,vValor); 
        usuario.set_opciones(usuario.EMPLSEL,1);
        usuario.set_opciones(usuario.SEL_CONTRATO,new Long(0) ); 
        usuario.set_opciones(usuario.VISTA_EMPLEADO,0); 
        usuario.set_opciones(usuario.VISTA_CONTRATO,3); 
       
        MenuModelAdapter vMenu;
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{modeloMenu}");
        vMenu=(MenuModelAdapter)vValor;
        vMenu.cambiarEstadoItem("Empleado",false);
        
        /* ******        ***************       ****/
        
       
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Solicitud");
       
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.SisSolicitudVwIterator.estimatedRowCount}");
        
        if (vValor!=null && utils.getDouble1(vValor).doubleValue()<=0){
        
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.FechaSolicitud.inputValue}",utils.getFechaOracle("01/01/"+vFechaBusqueda));
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Solicitud");
        
        }
       
        try{
        Object vResultado;
        Key vllave = 
        new Key(new Object [] {new oracle.jbo.domain.Number(vSolicitud.toString())});
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.llaveSol.inputValue}",vllave.toStringFormat(true));
       
        //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"setCurrentRowSol"); //Posicionando la posicion del iterador
         
         BindingContainer vBnd_binding;
         OperationBinding operationBinding;
         vBnd_binding=(BindingContainer)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings}");
         operationBinding=vBnd_binding.getOperationBinding("setCurrentRowSol");
         vResultado=operationBinding.execute(); 
         
         //System.out.println("debug: " +operationBinding.getErrors().size());
         
         
            if (operationBinding.getErrors().size()>0){
               
                
                JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.FechaSolicitud.inputValue}",utils.getFechaOracle("01/01/"+vFechaBusqueda));
                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Solicitud");   
                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"setCurrentRowSol"); //Posicionando la posicion del iterador
                utils.removeAllErrorADF();
            
            }
         
         vOutcome=vSol.IrAPagina(vNomSolicitud.toString().trim());
         
        }catch(Exception exep){
            
             exep.printStackTrace();
        }
        
        
        return vOutcome;
    }

    public String autorizar_gestion() {
        return null;
    }

    public void autorizar_launch(LaunchEvent launchEvent) {
         Object vSolicitud,vNomSolicitud,vEstado,vRegEmpleado,vNombreComp;
         util_dialog_adf vDialog= new util_dialog_adf();
         
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"setCurrentRowWithKey");
         vSolicitud=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.SisSolicitudPendiente_vw.currentRow['idSolicitud']}");        
         vNomSolicitud=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.SisSolicitudPendiente_vw.currentRow['nombreSolicitud']}");
         vEstado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.SisSolicitudPendiente_vw.currentRow['idEstado']}");
         vRegEmpleado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.SisSolicitudPendiente_vw.currentRow['registroEmpleado']}");
         vNombreComp=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.SisSolicitudPendiente_vw.currentRow['nombrecompleto']}");
         vDialog.setParametros_dialogo_autorizacion(launchEvent,"LICENCIA",vSolicitud,vEstado,"licencia");
         launchEvent.getDialogParameters().put("TituloGes", vNomSolicitud+ " [ "+vRegEmpleado + " - "+ vNombreComp+" ] "); 
         }

    public void return_autoriza(ReturnEvent returnEvent) {
        // Add event code here...
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Execute");
        AdfFacesContext.getCurrentInstance().partialUpdateNotify(this.getBtn_actualizar());
        
    }

    public void setTbl_sol(CoreTable tbl_sol) {
        this.tbl_sol = tbl_sol;
    }

    public CoreTable getTbl_sol() {
        return tbl_sol;
    }

    public void setBtn_actualizar(CoreCommandButton btn_actualizar) {
        this.btn_actualizar = btn_actualizar;
    }

    public CoreCommandButton getBtn_actualizar() {
        return btn_actualizar;
    }

    public String btn_cambiar_anio() {
        // Add event code here...
         String vAnio;        
         vAnio=(String)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.pAnio1.inputValue}");
         JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{flujo_usuario.anioActual}",vAnio);
         utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Se ha cambiado el año de trabajo."));
        
        return null;
    }

    public String cmd_revisados() {
        // Add event code here...
        return  setSolicitud(2);
    }
}
