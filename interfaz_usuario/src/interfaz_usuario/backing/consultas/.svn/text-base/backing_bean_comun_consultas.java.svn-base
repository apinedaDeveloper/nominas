package interfaz_usuario.backing.consultas;

import enlace_datos.util.resulOp;

import interfaz_usuario.usuario;

import interfaz_usuario.util.JSFUtils;

import interfaz_usuario.util.utils;

import javax.faces.context.FacesContext;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.faces.component.core.input.CoreInputText;

public class backing_bean_comun_consultas {
    private CoreInputText inputAnio;

    public backing_bean_comun_consultas() {
    }


    public void buscarEmpleado(){
        Object vRegistro,vValor;
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"selFilaTabla");
        vRegistro=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.RegistroEmpleado.inputValue}");
        
        
        usuario.set_opciones(usuario.SEL_REGEMPLEADO,utils.getNumber(vRegistro)); 
        
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"BuscarEmpleado");     
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.Nombrecompleto.inputValue}");
        usuario.set_opciones(usuario.NOMBREEMPLEADOSEL,vValor); 
        usuario.set_opciones(usuario.VISTA_CONTRATO,3); 
        usuario.set_opciones(usuario.VISTA_EMPLEADO,1); 
        usuario.set_opciones(usuario.EMPLSEL,1);
   
        
    }

    public String cmd_lnk_regEmpleado_contratos_teso() {
        
        buscarEmpleado();

       // actualizarMenu();
        return "empleado";
        
    }

    public String cmd_lnk_contrato_contratos_teso() {
        
        Object vIdcontrato;

        buscarEmpleado();

        vIdcontrato=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdContrato.inputValue}");
       // System.out.println(" contrato " + vIdcontrato);
        
        usuario.set_opciones(usuario.SEL_CONTRATO,Long.parseLong(vIdcontrato.toString()) ); 
        usuario.set_opciones(usuario.VISTA_CONTRATO,1); 
        
        return "ver_contrato";
    }

    public void setInputAnio(CoreInputText inputAnio) {
        this.inputAnio = inputAnio;
        
        if (this.inputAnio.getValue()==null){
        
          this.inputAnio.setValue(utils.getAnioActual());
            
        }
    }

    public CoreInputText getInputAnio() {
        return inputAnio;
    }

/*
 * consultas/contratos_tesorero.jspx
 */
 /*
    public void chk_selTabla(ValueChangeEvent valueChangeEvent) {
        // Add event code here...


        System.out.println(" debug " +valueChangeEvent.getNewValue());
        System.out.println(" debug " +valueChangeEvent.getPhaseId());

        if (valueChangeEvent!=null && valueChangeEvent.getNewValue()!=null){

           if (valueChangeEvent.getNewValue().toString().equals("true"))
           {
             JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"SeleccionarTodos");
           }
           else if(valueChangeEvent.getNewValue().toString().equals("false"))
           {
             JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"DesSeleccionarTodos");
           }
        }


    }
*/

    public String btn_trasladar_rrhh() {
    
      if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"trasladarRRHH")){
          
          JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"filtrarXEstado");
          utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Se han traslado los contratos seleccionados,aplica solo a los que tienen estado INGRESADO"));
      }
        // Add event code here...
        return null;
    }
}

