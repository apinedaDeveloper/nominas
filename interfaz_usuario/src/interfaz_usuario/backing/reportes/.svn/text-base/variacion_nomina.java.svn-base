package interfaz_usuario.backing.reportes;

import interfaz_usuario.backing.gestiones.solicitud;

import interfaz_usuario.usuario;

import interfaz_usuario.util.JSFUtils;
import interfaz_usuario.util.utils;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.faces.component.core.input.CoreInputText;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Key;

import pkg_autenticacion.menu.MenuModelAdapter;

public class variacion_nomina {
    public boolean selecDependencia = false;
    private CoreInputText anio;

    public variacion_nomina() {
    }
    public boolean getSelecDependencia(){
    
        return selecDependencia;
    }
    public void selecDependencia(ValueChangeEvent valueChangeEvent) {
        
        selecDependencia = true;
    }

    public String cmd_variacion_rev_varNomina() {
        Object vIdVariacion,vRegEmpleado,vValor;
        String vOutcome=null;
        
        vIdVariacion=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.Sis_variacionNom_pendiente_vw.currentRow['idVariacionNomina']}");
        vRegEmpleado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.Sis_variacionNom_pendiente_vw.currentRow['registroEmpleado']}");
        
        
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.vRegEmpleado1.inputValue}",vRegEmpleado);
                            
        /* ******        ***************       ****/
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Empleado");        
        usuario.set_opciones(usuario.SEL_REGEMPLEADO,utils.getNumber(vRegEmpleado));         
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
        
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Variacion");
                
        try{

        Key vllave = 
        new Key(new Object [] {new oracle.jbo.domain.Number(vIdVariacion.toString())});
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.vLlaveSol1.inputValue}",vllave.toStringFormat(true));
        
         if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"setFilaVariacion")){
             vOutcome="mant_variaDesc";                 
         }
                  
        }catch(Exception exep){
            
             exep.printStackTrace();
        }
        
        return vOutcome;
        
        
    }
}
