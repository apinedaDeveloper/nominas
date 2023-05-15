package interfaz_usuario.backing.gestiones;

import enlace_datos.util.resulOp;

import enlace_datos.util.utils_DB;

import interfaz_usuario.backing.util.util_dialog_adf;

import interfaz_usuario.usuario;

import interfaz_usuario.util.JSFUtils;

import interfaz_usuario.util.executeOSProcess;
import interfaz_usuario.util.utils;


import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.faces.component.core.layout.CorePanelForm;
import oracle.adf.view.faces.component.core.layout.CorePanelHeader;
import oracle.adf.view.faces.event.LaunchEvent;
import oracle.adf.view.faces.event.ReturnEvent;

import pkg_autenticacion.menu.MenuModelAdapter;

public class contrato029 {
    private boolean vCambioDep=false;
    private CorePanelForm pnlform1;
    private CorePanelHeader pnlHeaderRevRegPer;

    public contrato029() {
    }

    public boolean getCambioDep(){        
        return vCambioDep ;
    }

    public void cmbDependencia(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        
        if (valueChangeEvent.getOldValue()!=valueChangeEvent.getNewValue()){
            
            vCambioDep=true;
            
        }
        
    }

    public String btnCommit() {
        Object vCui, vRegPer;
        vCui=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{flujo_usuario.selCui}");
        vRegPer=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{flujo_usuario.selRegEmpleado}");
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.Cui.inputValue}",vCui.toString());
        if (vRegPer != null)
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.RegistroEmpleado.inputValue}",vRegPer.toString());
        
         if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit")){
            
           utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Datos guardados exitosamente.")); 
        }
        return null;
    }
    
    public void btn_auto_lauch_auto(LaunchEvent launchEvent) {
        util_dialog_adf vDialog= new util_dialog_adf();
        Object vVariable,vEstado;
        vVariable =JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdContrato029.inputValue} ");
        vEstado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdEstado.inputValue}");
        vDialog.setParametros_dialogo_autorizacion(launchEvent,"NOMBRAMIENTO029",vVariable,vEstado,"Contrato");
    }

    public String btn_crear_list_contrato() {

        String vOutcome=null;
        
        JSFUtils.verificarRollback(FacesContext.getCurrentInstance());
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Crear")){
            
            vOutcome="lst_contrato_contrat029";
        }
                
        return vOutcome;
        
    } 

    public String nuevoEmpleado029() {
        // Add event code here...
        String vOutcome=null;
         
        usuario.set_opciones(usuario.SEL_REGEMPLEADO,0 ); 
        usuario.set_opciones(usuario.VISTA_EMPLEADO,0); 
        
         JSFUtils.verificarRollback(FacesContext.getCurrentInstance());
         
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"crearEmpleado")){
            
            vOutcome="empleado";
        }
        
        return vOutcome;
        
    }

   public String parseResult(String pRegistro,String vResultado){
       String vInfo[];
       String vResul="";      
       
       try{
           
       
       if (vResultado==null || vResultado!=null && vResultado.equals("")){
           // error fatal
            vResul="No se ha podido crear el correo electronico";   
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.vOpcion21.inputValue}","2");
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"actualizarCorreoIns");
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Commit");
            
       }else{
       
           vInfo=vResultado.split("\\,");  
           vResul=vInfo[1];           
           JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.vCorreoIns1.inputValue}",vResul);
           JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.vRegistro1.inputValue}",pRegistro);
         
          if (vInfo[0].equals("OK")){
           
              
              JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.vOpcion21.inputValue}","1");
              
          }else{
          
              JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.vOpcion21.inputValue}","2");
              vResul="No se ha podido crear el correo electronico";   
          }           
         
           JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"actualizarCorreoIns");
           JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Commit");
 
       }
       
       }catch(Exception exep){
           
       }
   return vResul;    
   }


    public String btn_asignarNuevo() {
        
        Object vResultado;
        executeOSProcess vProc;
        Object vNombre1,vNombre2,vApellido1,vApellido2,vCelular,vReg,vNumUnidad,vCLV;
        String vCadenaLlamada;
        String vNullParam="NOHAY";
        String vComandoOs="/home/oracle/crea.pl";
        //String vComandoOs="c:\\crea.bat";
        Object  vCreaCorreo;
        
        int vPos;
                
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Posicionarse"))
        {
        
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.vOpcion1.inputValue}","1");
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.vRegistroAnt1.inputValue}",null);
            
            vResultado=JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"CambiarRegistro");
            
            if (vResultado!=null && !vResultado.equals("")){
            
                vCreaCorreo=JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.creaCorreo");
                
                if (vCreaCorreo!=null && vCreaCorreo.toString().equals("1"))
                {           
            
                vReg=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.RegistroEmpleado1.inputValue}");
                vNombre1=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.Nombre1.inputValue}");
                vNombre2=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.Nombre2.inputValue}");
                vApellido1=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.Apellido1.inputValue}");
                vApellido2=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.Apellido2.inputValue}");
                vCelular=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.Celular.inputValue}");
                vNumUnidad=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.Nomunidad.inputValue}");
                
                vPos=vResultado.toString().indexOf(":");
                
                 if (vPos>0){
                 
                    vReg=vResultado.toString().substring(vPos+1,vPos+10);
                    vReg=vReg.toString().trim(); 
                    JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.vRegistro1.inputValue}",vReg.toString());
                    JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ExeEmpl");
                     
                 }
               
                vCLV=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.Clv.inputValue}");
                vCLV=(vCLV==null?"123":vCLV);
                
             //   System.out.println("d "+vReg+" "+vNombre1+" "+vNombre2+ " "+vApellido1+" "+vApellido2+ "  "+vCLV);
              
                vProc=new executeOSProcess(""); 
                
                vCadenaLlamada="";
                
                if (vNombre1!=null && !vNombre1.equals("")){
                
                    vCadenaLlamada=vCadenaLlamada+enlace_datos.util.utils.getSimpleChar(vNombre1.toString().toLowerCase());
                    
                }else{ // no viene
                
                     vCadenaLlamada=vCadenaLlamada+" "+vNullParam;
                    
                }
                
                 if (vNombre2!=null && !vNombre2.equals("")){
                 
                     vCadenaLlamada=vCadenaLlamada+"|"+enlace_datos.util.utils.getSimpleChar(vNombre2.toString().toLowerCase());
                     
                 }else{ // no viene
                     
                      vCadenaLlamada=vCadenaLlamada+"|"+vNullParam;
                      
                 }
                 
                  if (vApellido1!=null && !vApellido1.equals("")){
                  
                      vCadenaLlamada=vCadenaLlamada+"|"+enlace_datos.util.utils.getSimpleChar(vApellido1.toString().toLowerCase());
                      
                  }else{ // no viene
                      
                      vCadenaLlamada=vCadenaLlamada+"|"+vNullParam;
                  }
                 
                  if (vApellido2!=null && !vApellido2.equals("")){
                   
                       vCadenaLlamada=vCadenaLlamada+"|"+enlace_datos.util.utils.getSimpleChar(vApellido2.toString().toLowerCase());
                       
                  }else{ // no viene
                       
                       vCadenaLlamada=vCadenaLlamada+"|"+vNullParam;
                   
                  }
                 
                
                // Password primer nombre + CLV 
                vCadenaLlamada=vCadenaLlamada+"|"+enlace_datos.util.utils.getSimpleChar(vNombre1.toString().toLowerCase())+vCLV.toString();

                if (vCelular!=null && !vCelular.equals("")){
                 
                     vCadenaLlamada=vCadenaLlamada+"|"+enlace_datos.util.utils.getSimpleChar(vCelular.toString().toLowerCase());
                     
                }else{ // no viene
                     
                    vCadenaLlamada=vCadenaLlamada+"|"+vNullParam;
                 
                }
                
                if ( vNumUnidad!=null && ! vNumUnidad.equals("")){
                 
                     vCadenaLlamada=vCadenaLlamada+"|"+enlace_datos.util.utils.getSimpleChar(vNumUnidad.toString())+"";
                     
                }else{ // no viene
                     
                     vCadenaLlamada=vCadenaLlamada+"|"+vNullParam;
                 
                }
                 
               vCadenaLlamada=vCadenaLlamada+"|"+vReg; 
                    
                // Haciendo la llamada del proceso que crea el correo   
                vCadenaLlamada=vComandoOs+"|"+vCadenaLlamada;
                
                vProc.ejecutarProceso(vCadenaLlamada.split("\\|"));
                
            //    System.out.println("debug : " + vCadenaLlamada);                
            //    System.out.println("debug : " + vProc.getSalidaProc());
                utils.setADFMensaje(new resulOp(resulOp.OPE_OK,vResultado.toString()+". Correo Electrónico: "+ parseResult(vReg.toString(),vProc.getSalidaProc()))); 
               
               }
               else
               {
               
                utils.setADFMensaje(new resulOp(resulOp.OPE_OK,vResultado.toString()));
                   
               }
              
              JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Ejecutar");  
              
            }
          
          this.getPnlHeaderRevRegPer().setRendered(false);
          vResultado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.RegistroEmpleado1.inputValue}");
         // System.out.println("debug " +vResultado);
        
        }
        return null;
    }

    public void returnRegEmpleado(ReturnEvent returnEvent) {
        // Add event code here...
    }

    public String procesar_reg_existente() {
        Object vResultado;        
        vResultado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vActualiza1.inputValue}");
        
        
       
        if (vResultado.equals(false))        
           JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.vOpcion1.inputValue}","2");
        else
           JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.vOpcion1.inputValue}","3");
        
        vResultado=JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"CambiarRegistro");
        
        if (vResultado!=null && !vResultado.equals("")){
            
          JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Ejecutar");  
          utils.setADFMensaje(new resulOp(resulOp.OPE_OK,vResultado.toString())); 
          
        }

        
        this.getPnlHeaderRevRegPer().setRendered(false);

        return null;
    }

    public String modEmpleado_action() {
        // Add event code here...
         String vOutcome=null;
         usuario.set_opciones(usuario.VISTA_EMPLEADO,1); 
         usuario.set_opciones(usuario.EMPLSEL,1);
         usuario.set_opciones(usuario.VISTA_CONTRATO,3); 

        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"cambiarValidacion")){
            
            vOutcome="empleado";
        }
        
        
        return vOutcome;
    }

    public void setPnlform1(CorePanelForm pnlform1) {
        this.pnlform1 = pnlform1;
    }

    public CorePanelForm getPnlform1() {
        return pnlform1;
    }

    public String regEmpleado_action029() {
                
        this.getPnlHeaderRevRegPer().setRendered(true);
        return null;
    }

    public void setPnlHeaderRevRegPer(CorePanelHeader pnlHeaderRevRegPer) {
        this.pnlHeaderRevRegPer = pnlHeaderRevRegPer;
    }

    public CorePanelHeader getPnlHeaderRevRegPer() {
        return pnlHeaderRevRegPer;
    }

    public String cmdIdContrato_consultas() {
 
        String vOutcome=null;
  
  
        if (buscarEmpleado())
        {
            if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"buscarIdContrato")) 
            {
                actualizarMenu();
                vOutcome="lst_contrato_contrat029";      
                
            }                    
            
        }                
        return vOutcome;
        
    }

/*
 *  
 *  Método para buscar un empleado
 */
    public boolean buscarEmpleado(){
    
        Object vRegistro,vValor;
        
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"PosicionarseTabla"))
        {
        
        vRegistro=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.RegistroEmpleado.inputValue}");
        
        
        usuario.set_opciones(usuario.SEL_REGEMPLEADO,utils.getNumber(vRegistro)); 
        
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"BuscarEmpleado");     
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.NombreCompleto.inputValue}");
        usuario.set_opciones(usuario.NOMBREEMPLEADOSEL,vValor); 
        usuario.set_opciones(usuario.VISTA_CONTRATO,3); 
        usuario.set_opciones(usuario.VISTA_EMPLEADO,1); 
        usuario.set_opciones(usuario.EMPLSEL,1);
        
        return true;
        }    
       
        return false; 
    }


    private void actualizarMenu(){
        Object vValor;
        MenuModelAdapter vMenu;
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{modeloMenu}");
        vMenu=(MenuModelAdapter)vValor;
        vMenu.cambiarEstadoItem("Empleado",false);
        
    }


    public String btn_rechazarRegistro() {
        // Add event code here...
        Object vReg;
         if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Posicionarse")) {
         
           JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"rechazaAsignacion"); 
           //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Ejecutar");
           utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Solictud de Registro Objetada"));  
             JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Ejecutar"); 
         }
        return null;
    }

    public void return_autorizacion(ReturnEvent returnEvent) {
        // Add event code here...
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Ejecutar029"); 
    }
}
