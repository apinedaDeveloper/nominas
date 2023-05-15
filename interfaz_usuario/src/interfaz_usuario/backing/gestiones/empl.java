package interfaz_usuario.backing.gestiones;

import enlace_datos.util.resulOp;

import interfaz_usuario.usuario;

import interfaz_usuario.util.JSFUtils;
import interfaz_usuario.util.executeOSProcess;
import interfaz_usuario.util.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import javax.faces.model.SelectItem;

import oracle.adf.view.faces.component.core.data.CoreTable;
import oracle.adf.view.faces.component.core.input.CoreInputHidden;
import oracle.adf.view.faces.component.core.input.CoreInputText;
import oracle.adf.view.faces.component.core.input.CoreSelectOneChoice;
import oracle.adf.view.faces.component.core.nav.CoreCommandLink;

import oracle.adf.view.faces.context.AdfFacesContext;
import oracle.adf.view.faces.event.AttributeChangeEvent;

import oracle.adf.view.faces.event.DisclosureEvent;

import oracle.adf.view.faces.event.LaunchEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.uicli.binding.JUCtrlValueBindingRef;

import pkg_autenticacion.menu.MenuModelAdapter;

public class empl {
    private CoreCommandLink cmd_lnl_idContrato;
    boolean vCambioDireccion=false;
    private CoreTable tbl_contratos;
    private CoreSelectOneChoice cmb_departamento;
    private boolean vCambNivel=false;
    private CoreSelectOneChoice cmb_institucionAca;
    private CoreSelectOneChoice cmb_nivelAcademico1;
    private List<SelectItem> vListaItemsCheck;
    private boolean vCambioDeparta=false;
    private CoreInputHidden inpHiddenCambioN;
    private CoreTable tbl_documentos_adjuntos;
    private CoreInputText inptText_email_institucional;

    public List<SelectItem> getListOfValuesCheck()
   {
            return vListaItemsCheck;
   }


   public Boolean getCambioDep(){
       
     return vCambioDeparta;  
   }

    public Boolean getCambioNivel(){
    return this.vCambNivel;
    }

   public void setCambioNivel(boolean vValor){
       this.vCambNivel=vValor;
   }
   
    public empl() {
        vListaItemsCheck=utils.crearListaManyCheck("SisTipoJubiladoVwIterator","IdTipoJubilado","NombreTipjubilado");

   //     if (!AdfFacesContext.getCurrentInstance().isPostback()){
    //        this.cmb_nivelAcademico2.setValue(this.cmb_nivelAcademico1.getValue());
    //    }
    
    }


    public boolean getCambiaDireccion(){
        return vCambioDireccion;
    }

    //Procesa el botón guardar

    private void procesar_boton_guardar() {
        BindingContainer vBnd_binding;
        OperationBinding operationBinding;
        Object result, vNombreC;
        resulOp vResultado = new resulOp();
        boolean vResultadoOps = false;
        String vVistaEmpleado;
        vBnd_binding = 
                (BindingContainer)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                                             "#{bindings}");
        operationBinding = vBnd_binding.getOperationBinding("commit2");
        try {
            result = operationBinding.execute();
            if (operationBinding.getErrors().isEmpty()) {
                vVistaEmpleado = 
                        JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(), 
                                                     "flujo_usuario.vistaEmpleado").toString();
                if (vVistaEmpleado.equals("0")) {
                    vResultado.setMensajeError("Empleado creado correctamente!!");
                    result = 
                            JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                                       "#{bindings.RegistroEmpleado.inputValue}");
                    usuario.set_opciones(usuario.SEL_REGEMPLEADO, 
                                         utils.getNumber(result));
                    vNombreC = 
                            JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                                       "#{bindings.NombreCompleto.inputValue}");
                    usuario.set_opciones(usuario.NOMBREEMPLEADOSEL, vNombreC);
                    usuario.set_opciones(usuario.VISTA_EMPLEADO, 1);
                } else {
                    JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                             "Exe_buscarEmpleado");
                    vResultado.setMensajeError("Datos actualizados correctamente");
                    this.inpHiddenCambioN.setValue(null);
                }
                vResultado.setCodigoResultado(resulOp.OPE_OK);
                utils.setADFMensaje(vResultado);
                vResultadoOps = true;
            }
        } catch (Exception exep) {
            exep.printStackTrace();
            vResultado.setMensajeError(exep.getMessage());
            vResultado.setCodigoResultado(resulOp.OPE_ERROR);
            utils.setADFMensaje(vResultado);
        }
    }
    
    //Verifica el correo electrónico instititucional ingresado (tiene que ser @usac.edu.gt)

    private boolean verificarCorreoElectronicoInstitucional() {
        boolean vResultado = false;
        try {
            if ( this.getInptText_email_institucional().getValue()!=null) {
                String emailInstitucional = 
                    this.getInptText_email_institucional().getValue().toString().trim();
                if (emailInstitucional.trim().compareTo("") != 0) {
                    if (emailInstitucional.toLowerCase().endsWith("@usac.edu.gt")) {
                        vResultado = true;
                    }
                } else {
                    vResultado = true;
                }
            } else {
                vResultado = true;
            }
        } catch (Exception exep) {
            exep.printStackTrace();
        }
        return vResultado;
    }

    public String btn_grabar() {
        Object vDireccion;
        vDireccion = 
                JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                           "#{bindings.SisDireccion_vwIterator.estimatedRowCount}");
        if (!vDireccion.toString().equals("0")) {
            if (verificarCorreoElectronicoInstitucional()) {
                procesar_boton_guardar();
            } else {
                utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR, 
                                                "Verifique casilla de Correo Electrónico Institucional, tiene que ser de la Universidad."));
            }
        } else {
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR, 
                                            "Ingrese una dirección."));
        }
        return null;
    }

    public String btn_new_contrato() {
        MenuModelAdapter vMenu;
        Object vRegistroEmpleado;
    
        vRegistroEmpleado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{flujo_usuario.selRegEmpleado}");
    
        vMenu=(MenuModelAdapter)JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"modeloMenu");
        if (vMenu.isAllowContract(vRegistroEmpleado.toString())){
            
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Resetear");
            usuario.set_opciones(usuario.SEL_CONTRATO,new Long(0) ); 
            usuario.set_opciones(usuario.VISTA_CONTRATO,3); 
            return "ver_contrato";    
            
        }else{
            
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"El trabajador no ha validado su cuenta monetaria para acreditamiento de su salario.\n El trabajador debe realizar la gestion en la Actualización de datos."));
        }
    
    
         
    return null;
        
    }

    public String cmd_link_action_verContrato() {
        JUCtrlValueBindingRef tableRowRef;
        String vOutcome;
        vOutcome=null;   
        tableRowRef=(JUCtrlValueBindingRef)this.tbl_contratos.getSelectedRowData(); 
         if (tableRowRef!=null){
             usuario.set_opciones(usuario.SEL_CONTRATO,Long.parseLong(this.cmd_lnl_idContrato.getText()) ); 
             usuario.set_opciones(usuario.SEL_CONTRATO_PARTIDA,tableRowRef.getRow().getAttribute("Partida").toString());
             usuario.set_opciones(usuario.SEL_CONTRATO_PLAZA,utils.getInteger(tableRowRef.getRow().getAttribute("NumeroPlaza")));
             usuario.set_opciones(usuario.VISTA_CONTRATO,1); 
             vOutcome="ver_contrato";
         }
         return vOutcome;
    }

    public void setCmd_lnl_idContrato(CoreCommandLink cmd_lnl_idContrato) {
        this.cmd_lnl_idContrato = cmd_lnl_idContrato;
    }

    public CoreCommandLink getCmd_lnl_idContrato() {
        return cmd_lnl_idContrato;
    }

    
    public String bnt_sel_direcc_action() {
        // Add event code here...
         this.vCambioDireccion=true;
        return null;
    }

    public String btn_adj_Archivo_Action() {
         FacesContext context = FacesContext.getCurrentInstance();  
          ViewHandler vh = context.getApplication().getViewHandler();  
            // el jspx que se mostrara en forma de  ventana emergente  
          UIViewRoot dialog = vh.createView(context, "/util/adjuntar_archivo.jspx");  
          AdfFacesContext a = AdfFacesContext.getCurrentInstance();  
            // fijamos el ancho y el alto de la ventana emergente  
           Map windowProperties = new HashMap();  
           windowProperties.put("width", new Integer(450));  
           windowProperties.put("height", new Integer(350));  
           //añadimos mas paremetros que seran recogidos en la jspx ventana  
           Map dialogParameters = new HashMap();  
           dialogParameters.put("identificador",JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.RegistroEmpleado.inputValue}").toString());
           dialogParameters.put("Opcion", 3);
           a.launchDialog(dialog,dialogParameters,null,true,windowProperties);
         
          return null;
    }

/*
 *  Metodo para obtener el contrato seleccionado y dirigirse a mod descuentos
 */
    public String btn_descuentos_contrato_action() {
        JUCtrlValueBindingRef tableRowRef;
        String vOutcome;
        
        Object IdTipoSolicitud;
        
            vOutcome=null;   
            tableRowRef=(JUCtrlValueBindingRef)this.tbl_contratos.getSelectedRowData(); 
        
            if (tableRowRef!=null){
                usuario.set_opciones(usuario.SEL_CONTRATO,utils.getNumber(tableRowRef.getRow().getAttribute("IdContrato"))); 
                usuario.set_opciones(usuario.SEL_CONTRATO_PARTIDA,tableRowRef.getRow().getAttribute("Partida").toString());
                usuario.set_opciones(usuario.SEL_CONTRATO_PLAZA,utils.getInteger(tableRowRef.getRow().getAttribute("NumeroPlaza")));
                usuario.set_opciones(usuario.VISTA_CONTRATO,1); 
                vOutcome="empl_descuento";                   
                
               // tableRowRef.getRow().getAttribute("Partida")
                //tableRowRef.getRow().getAttribute("Numero Plaza")
                
            }
        return vOutcome;
    }

    public void setTbl_contratos(CoreTable tbl_contratos) {
        this.tbl_contratos = tbl_contratos;
    }

    public CoreTable getTbl_contratos() {
        return tbl_contratos;
    }

    public String act_tabla_direccion() {
        
        
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"setNombres");
        
        return null;
    }

    public void setCmb_departamento(CoreSelectOneChoice cmb_departamento) {
        this.cmb_departamento = cmb_departamento;
    }

    public CoreSelectOneChoice getCmb_departamento() {
        return cmb_departamento;
    }


    public void cmb_nivelAcademico_action(ValueChangeEvent valueChangeEvent) {
        
       // System.out.println(" debug :( " +JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.NivelAca.inputValue}"));
        if (
        
        !valueChangeEvent.getNewValue().toString().equals(valueChangeEvent.getOldValue()!=null?valueChangeEvent.getOldValue().toString():"")
        
        ){
            this.cmb_institucionAca.setSubmittedValue(0);
            this.vCambNivel=true;
        }
    
        
    }

    public void setCmb_institucionAca(CoreSelectOneChoice cmb_institucionAca) {
        this.cmb_institucionAca = cmb_institucionAca;
        
    }

    public CoreSelectOneChoice getCmb_institucionAca() {
        return cmb_institucionAca;
    }

    public void setCmb_nivelAcademico1(CoreSelectOneChoice cmb_nivelAcademico1) {
        this.cmb_nivelAcademico1 = cmb_nivelAcademico1;
        //cmb_nivelAcademico1.getValue()
    }

    public CoreSelectOneChoice getCmb_nivelAcademico1() {
        return cmb_nivelAcademico1;
    }


    public void shwPanel_otraIns_NO(DisclosureEvent disclosureEvent) {
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.OtroTrabajo.inputValue}","NO");
    }

    public void shwPanel_otraIns_SI(DisclosureEvent disclosureEvent) {
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.OtroTrabajo.inputValue}","SI");
    }

    public void cmb_dep_direccion_change(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        
        if (valueChangeEvent.getOldValue()!=valueChangeEvent.getNewValue()){
           // System.out.println("cambio de dep");
            vCambioDeparta=true;
            //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"setNombres");
            
            
        }
        
    }

    public String btn_asignar_registro() {

        String vOutcome=null;
        
         if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"asignacionRegPer"))
         {             
             JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ConsultaEmpleado");
             vOutcome="lst_empleado_nor";  
             utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Se ha enviado la solicitud para asignación de registro de empleado."));
         }
         
        
        return vOutcome;
    }

    public void setInpHiddenCambioN(CoreInputHidden inpHiddenCambioN) {
        this.inpHiddenCambioN = inpHiddenCambioN;
    }

    public CoreInputHidden getInpHiddenCambioN() {
        return inpHiddenCambioN;
    }

    public void setTbl_documentos_adjuntos(CoreTable tbl_documentos_adjuntos) {
        this.tbl_documentos_adjuntos = tbl_documentos_adjuntos;
    }

    public CoreTable getTbl_documentos_adjuntos() {
        return tbl_documentos_adjuntos;
    }

    public void setInptText_email_institucional(CoreInputText inptText_email_institucional) {
        this.inptText_email_institucional = inptText_email_institucional;
    }

    public CoreInputText getInptText_email_institucional() {
        return inptText_email_institucional;
    }
}

