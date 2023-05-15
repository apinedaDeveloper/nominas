package interfaz_usuario.backing.gestiones;

import enlace_datos.util.resulOp;

import interfaz_usuario.usuario;

import interfaz_usuario.util.JSFUtils;
import interfaz_usuario.util.utils;
import java.util.Map;
import javax.faces.component.UISelectItems;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import oracle.adf.view.faces.component.core.data.CoreTable;
import oracle.adf.view.faces.component.core.input.CoreSelectOneChoice;

import oracle.jbo.uicli.binding.JUCtrlValueBindingRef;

public class nueva_solicitud {
     private CoreTable tbl_contratosAct;
    private CoreSelectOneChoice cmb_tipoSolicitud;
    private UISelectItems cmb_tipoSol_items;

    public nueva_solicitud() {
    }


    public boolean VerificarRol(String[] vRol){
        ExternalContext vExContexto;   
        boolean vResultado=false;
        int vRoles,i=0;
        vExContexto=FacesContext.getCurrentInstance().getExternalContext();  
        
        vRoles=vRol.length;
          //Verificando si algun el usuario pertenece a algun rol
          if (vRoles>0){
              while (i<vRoles){
                    vResultado=vExContexto.isUserInRole(vRol[i]); 
                    if (vResultado==true){
                     break;
                    }
                i++;    
              }
            }
        
         // Si el resultado es false se muestr mensaje de error
            if (vResultado!=true){
                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Rollback");
                utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"NO TIENE LOS PERMISOS NECESARIOS PARA ACCEDER A ESA OPCION"));                    
            }
       return vResultado;     
    }

    public String btn_nueva_solicitud() {
        // Add event code here...
         String vNombreSolicitud;
         String vOutcome;
         JUCtrlValueBindingRef tableRowRef;
         Object IdTipoSolicitud;
       
         vOutcome=null;   
         tableRowRef=(JUCtrlValueBindingRef) this.tbl_contratosAct.getSelectedRowData(); 
         
         if (tableRowRef!=null){
                usuario.set_opciones(usuario.NUEVA_SOL_REG_EMPLEADO,utils.getNumber(tableRowRef.getRow().getAttribute("RegistroEmpleado")));
                usuario.set_opciones(usuario.NUEVA_SOL_ID_CONTRATO,utils.getNumber(tableRowRef.getRow().getAttribute("IdContrato"))); 
                //vNombreSolicitud=(JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.NombreSolicitud.inputValue}")).toString().trim();
               // IdTipoSolicitud=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.SisTipoSolicitud.currentRow['idTipoSolicitud']}");
                
                vNombreSolicitud=(String)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{flujo_usuario.currentSol}");                
                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"crearSolicitud3");
                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Ejecutar");
               // JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.RegistroEmpleado.inputValue}",utils.getNumberOracle(tableRowRef.getRow().getAttribute("RegistroEmpleado")));
               // JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.IdContrato.inputValue}",utils.getNumberOracle(tableRowRef.getRow().getAttribute("IdContrato")));
               // JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.IdTipoSolicitud.inputValue}",utils.getNumberOracle(IdTipoSolicitud));
               // JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.CreadoPor.inputValue}",utils.getNumberOracle(JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.selRegEmpleado_login")));
                
                if (vNombreSolicitud.equals("LICENCIA")){
                   if (VerificarRol(new String[]{"tesorero","sis_administrador","auxiliar_tesoreria"})){ 
                   // JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"CrearLicencia");
                    usuario.set_opciones(usuario.VISTA_SOLICITUD,0);
                    vOutcome="new_sol_to_licencia";
                   }
                }else if(vNombreSolicitud.equals("SUSPENSION IGSS")){
                    if (VerificarRol(new String[]{"tesorero","sis_administrador","auxiliar_tesoreria"})){  
                    usuario.set_opciones(usuario.VISTA_SUSP_IGSS,0);
                   // JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"CrearSuspIgss");    
                    vOutcome="new_suspIgss";
                    }
                }else if(vNombreSolicitud.equals("RESCISION DE CONTRATOS")){ //Utilizado por Rolando Anona
                    if (VerificarRol(new String[]{"tesorero","sis_administrador","auxiliar_tesoreria"})){  
                    usuario.set_opciones(usuario.VISTA_RESCISION,0);
                   // JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"CrearSuspIgss");    
                    vOutcome="gest_NewRescPlaza";
                    }
                }else if(vNombreSolicitud.equals("DESCUENTO JUDICIAL")){
                    if (VerificarRol(new String[]{"coordinador_descuento_judicial","sis_administrador"})){ 
                    usuario.set_opciones(usuario.VISTA_ORDEN_JUDICIAL,0);
                    JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), "CrearOrdenJud");
                 // SE VA A LA PAGINA /GESTIONES/ORDEN_JUDICIAL.JSPX        
                    vOutcome="new_orden_judicial";
                    }
                }//fin else if descuento judicial
                else if (vNombreSolicitud.equals("RENUNCIA") || vNombreSolicitud.equals("RENUNCIA PARCIAL")){
                    if (VerificarRol(new String[]{"tesorero","sis_administrador","auxiliar_tesoreria"})){ 
                        usuario.set_opciones(usuario.VISTA_RENUNCIA_PARCIAL,0);
                        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"CrearLicencia");
                    vOutcome="new_desp_renun_empl";
                    }
                }
                else if (vNombreSolicitud.equals("DESPIDO") || vNombreSolicitud.equals("DECISION DE AUTORIDADES")){
                    vOutcome="new_desp_renun_empl";
                }
        }else{
           utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Seleccione un contrato activo")); 
            }
       
        return vOutcome;
    }

    
    public void setTbl_contratosAct(CoreTable tbl_contratosAct) {
        this.tbl_contratosAct = tbl_contratosAct;
    }

    public CoreTable getTbl_contratosAct() {
        return tbl_contratosAct;
    }

    public void setCmb_tipoSolicitud(CoreSelectOneChoice cmb_tipoSolicitud) {
        this.cmb_tipoSolicitud = cmb_tipoSolicitud;
    }

    public CoreSelectOneChoice getCmb_tipoSolicitud() {
        return cmb_tipoSolicitud;
    }

    public void setCmb_tipoSol_items(UISelectItems cmb_tipoSol_items) {
        this.cmb_tipoSol_items = cmb_tipoSol_items;
    }

    public UISelectItems getCmb_tipoSol_items() {
        return cmb_tipoSol_items;
    }
}
