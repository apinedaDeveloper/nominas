package interfaz_usuario.backing.gestiones;


import enlace_datos.consultas.gestiones.contrato.plazasRowImpl;

import enlace_datos.util.resulOp;
import interfaz_usuario.backing.util.util_dialog_adf;
import interfaz_usuario.usuario;
import interfaz_usuario.util.JSFUtils;
import interfaz_usuario.util.reporteParams;
import interfaz_usuario.util.utils;
import java.io.File;

import java.math.BigDecimal;

import java.sql.ResultSet;

import java.util.HashMap;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import oracle.adf.view.faces.component.core.data.CoreTable;
import oracle.adf.view.faces.component.core.data.CoreTableSelectOne;
import oracle.adf.view.faces.component.core.input.CoreInputFile;
import oracle.adf.view.faces.component.core.input.CoreInputHidden;
import oracle.adf.view.faces.component.core.input.CoreInputText;
import oracle.adf.view.faces.component.core.input.CoreSelectInputDate;
import oracle.adf.view.faces.component.core.input.CoreSelectOneChoice;
import oracle.adf.view.faces.component.core.layout.CoreShowDetailItem;
import oracle.adf.view.faces.component.core.nav.CoreCommandButton;
import oracle.adf.view.faces.component.core.nav.CoreCommandLink;
import oracle.adf.view.faces.component.core.output.CoreMessages;
import oracle.adf.view.faces.event.DisclosureEvent;
import oracle.adf.view.faces.event.LaunchEvent;
import oracle.adf.view.faces.event.ReturnEvent;
import oracle.adf.view.faces.model.UploadedFile;
import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;
import oracle.jbo.uicli.binding.JUCtrlValueBindingRef;
import pkg_carga_datos.carga_datos;

import pkg_util_base_datos.interfaz_DB;

public class Nombramiento {
    int idComboPuesto=0;
    boolean sel_depto=false;
    private CoreTable tbl_plazas;
    private CoreSelectInputDate int_fecha_i;
    private CoreSelectInputDate inpt_fecha_i;
    private CoreSelectInputDate inpt_fecha_f;
    private CoreInputText inp_sueldo_base2;
    private CoreInputText inpt_reg_empleado;
    private BindingContainer bindings;
    private CoreInputText inp_registro_empleado;
    private CoreInputText inpt_idPuesto;
    private CoreInputText inpt_numPlaza;
    private CoreInputText inpt_correlativo;
    private CoreInputHidden inpt_id_partida;
    private CoreInputText inpt_horaE;
    private CoreInputText inpt_horaS;
    private CoreTable tbl_horario;
    private CoreSelectOneChoice cmb_tipoContrato;
    private CoreShowDetailItem shw_pestania1;
    private CoreShowDetailItem shw_pestania2;
    private CoreShowDetailItem shw_pestania3;
    private CoreShowDetailItem shw_pestania4;
    private CoreTableSelectOne tbl_selection;
    private CoreCommandButton btn_horario_crear;
    private CoreInputText inpt_sueldoBase;
    private CoreMessages mensajes;
    private CoreInputFile inpt_addFile;
    private CoreInputText inpt_DescripcionArchivo;
    private CoreCommandLink cmd_lnk_otro;
    private CoreInputText inpt_complemento_sal;
    private CoreInputText inpt_escalafon;
    private CoreInputText inpt_atribEspe;
    private CoreInputText inpt_atribucionesEspeAnexo;
    private CoreCommandButton btn_crear_horarioNew;
    //private CoreCommandButton btn_horario_borrar;
    private CoreCommandLink cm_lnk_editarHorario;
    private CoreCommandLink cmd_link_borrarH;


public Nombramiento(){
sel_depto=false;
Object vValor,vDominio;
vValor=JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.showMensajeCuenta");
vDominio=JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.dominioApp");

 
try{
     
   if (vValor.toString().equals("true")){     
      JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Rollback");
      JSFUtils.setManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.showMensajeCuenta",true);
      FacesContext.getCurrentInstance().getExternalContext().redirect("/"+vDominio+"/faces/gestiones/list_empleado.jspx");    
   }
      
 }catch(Exception exep){

     
 }
              
}
    
    
    public boolean getSelDepto(){
        return sel_depto;
    }
    public int getIdComboPuesto(){
        return this.idComboPuesto;
    }
    
    public String commandButton_action() {
        // Add event code here...
        return null;
    }

    public void cmb_dependencia(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
         idComboPuesto=1;
        }

    public void setTbl_plazas(CoreTable tbl_plazas) {
        this.tbl_plazas = tbl_plazas;
    }

    public CoreTable getTbl_plazas() {
        return tbl_plazas;
    }

    public void cmb_unidades(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
         idComboPuesto=2;
    }

    public String bnt_seleccionar_plaza() {
        // Add event code here...
         Double vsal_base;
         Integer vhoras_plaza;
         Number vIdPuesto;
         JUCtrlValueBindingRef tableRowRef =
         (JUCtrlValueBindingRef) this.tbl_plazas.getSelectedRowData();
         
         if (tableRowRef!=null){
         vsal_base=utils.getDouble1(tableRowRef.getRow().getAttribute("SalarioBasepuesto"));
         vhoras_plaza=utils.getInteger(tableRowRef.getRow().getAttribute("CantidadHoras"));
        // vIdPuesto=(Number)tableRowRef.getRow().getAttribute("IdPuesto");
         /*
         if (this.inp_horas_contratadas.getValue()==null){
             this.inp_horas_contratadas.setValue(vhoras_plaza.toString());
         }
         */
         if (this.inpt_fecha_i.getValue()==null){
             this.inpt_fecha_i.setValue(tableRowRef.getRow().getAttribute("FechaInicio")); 
         }
         
        if (this.inpt_fecha_f.getValue()==null){
            this.inpt_fecha_f.setValue(tableRowRef.getRow().getAttribute("FechaFin")); 
        }
        
         
         if (vsal_base<=0){
             if (this.inp_sueldo_base2.getValue()==null){
                 this.inp_sueldo_base2.setRequired(true);
                 this.inp_sueldo_base2.setDisabled(false);        
             }else {
             this.inp_sueldo_base2.setRequired(true);
             this.inp_sueldo_base2.setDisabled(false);  
             calcular_sueldo();  
             }
         }else{
             
             this.inp_sueldo_base2.setDisabled(true);
             this.inp_sueldo_base2.setRequired(false);
             this.inp_sueldo_base2.setValue(vsal_base.toString());
             
           //  int hora=utils.diffHoras(this.inpt_horaE.getValue().toString(),this.inpt_horaF.getValue().toString());
           //  this.inp_horas_contratadas.setValue(hora);
             calcular_sueldo();
         }
        
       idComboPuesto=0; 
         }else {
             FacesMessage vMessage; 
             vMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,"Seleccione una plaza!!",null);
             FacesContext.getCurrentInstance().addMessage(null,vMessage); 
             
         }
       return null;  
    }

    /*
     * Metodo para calcular el sueldo de acuerdo a datos de plaza y horas por trabajar
     */
        private void calcular_sueldo(){
            Double vsal_base=null;
            Integer vhoras_cont;
            double vsueldo_mensual,vhoras_plaza;
            
            JUCtrlValueBindingRef tableRowRef =
            (JUCtrlValueBindingRef) this.tbl_plazas.getSelectedRowData();
            
            // Salario base
            vsal_base=utils.getDouble1(tableRowRef.getRow().getAttribute("SalarioBasepuesto"));
            
            vhoras_plaza=utils.getInteger(tableRowRef.getRow().getAttribute("CantidadHoras"));
             
            
            /*
            if (vhoras_cont>vhoras_plaza){
                vhoras_cont=vhoras_plaza;
                this.inp_horas_contratadas.setValue(vhoras_cont.toString());
            }
            */
           
            if (vsal_base.doubleValue()<=0){
                vsal_base=Double.parseDouble(this.inp_sueldo_base2.getValue().toString())*vhoras_plaza;
            }
           
            vsueldo_mensual=vsal_base.doubleValue();//(vsal_base.doubleValue()/vhoras_plaza.intValue())*vhoras_cont.intValue();
            
            this.inpt_sueldoBase.setValue(vsueldo_mensual);
            
        }



    public void setInt_fecha_i(CoreSelectInputDate int_fecha_i) {
        this.int_fecha_i = int_fecha_i;
    }

    public CoreSelectInputDate getInt_fecha_i() {
        return int_fecha_i;
    }

    public void setInpt_fecha_i(CoreSelectInputDate inpt_fecha_i) {
        this.inpt_fecha_i = inpt_fecha_i;
    }

    public CoreSelectInputDate getInpt_fecha_i() {
        return inpt_fecha_i;
    }

    public void setInpt_fecha_f(CoreSelectInputDate inpt_fecha_f) {
        this.inpt_fecha_f = inpt_fecha_f;
    }

    public CoreSelectInputDate getInpt_fecha_f() {
        return inpt_fecha_f;
    }

    public void setInp_sueldo_base2(CoreInputText inp_sueldo_base2) {
        this.inp_sueldo_base2 = inp_sueldo_base2;
    }

    public CoreInputText getInp_sueldo_base2() {
        return inp_sueldo_base2;
    }

    public void setInpt_reg_empleado(CoreInputText inpt_reg_empleado) {
        this.inpt_reg_empleado = inpt_reg_empleado;
    }

    public CoreInputText getInpt_reg_empleado() {
        return inpt_reg_empleado;
    }

    public BindingContainer getBindings() {
        return this.bindings;
    }

    public void setBindings(BindingContainer bindings) {
        this.bindings = bindings;
    }

    public String btn_guardar() {
        BindingContainer vBnd_binding;
        OperationBinding operationBinding;
        Object result, vVariable;
        resulOp vResultado=new resulOp();
        boolean vResultadoOps=false;
        long registro_empleado;
        validarAtribucionesEspe();
        interfaz_DB conexion; 
        String sqlQuerry;  Object vResultadoConsul;

        
            registro_empleado=new Long(JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.selRegEmpleado").toString());    
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.RegistroEmpleado1.inputValue}",utils.getNumberOracle(registro_empleado));
            
             vBnd_binding=(BindingContainer)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings}");
             operationBinding=vBnd_binding.getOperationBinding("Commit");
            
            
            try{
             result=operationBinding.execute();   
             
             if (operationBinding.getErrors().isEmpty()){
                 vResultado.setMensajeError("Contrato creado correctamente!!");
                 vResultado.setCodigoResultado(resulOp.OPE_OK);
                 utils.setADFMensaje(vResultado); 
                 vResultadoOps=true;
             }
             
             
            }catch(Exception exep){
                exep.printStackTrace();
            }
        
      
          if (vResultadoOps==true){   
                usuario.set_opciones(usuario.VISTA_CONTRATO,1);
                usuario.set_opciones(usuario.SEL_CONTRATO,new Long(JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdContrato.inputValue}").toString())); 
                //this.shw_pestania4.setDisclosed(false);
              
              
              vVariable=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdContrato.inputValue}").toString();
              conexion=new interfaz_DB();
              
              sqlQuerry="select count(*) valor from sis_ajuste_contrato where id_contrato = ";
              sqlQuerry=sqlQuerry+ vVariable;
              sqlQuerry= sqlQuerry + "  and  estado='A' ";
              sqlQuerry = sqlQuerry + " and id_ajuste in ( " + 
              "                             select id_ajuste " + 
              "                                from sis_ajuste " + 
              "                             where nombre like 'CUOTA PLAN DE PRESTACIONES' " + 
              "                             and fecha_baja is null  " + 
              "                                      )";
              
              vResultadoConsul=conexion.getValorConsultaSimple("valor",sqlQuerry);
              
              
              if (vResultadoConsul!=null && vResultadoConsul.toString().equals("1")){
                  utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"TIENE CUOTA PLAN DE PRESTACIONES."));
                  conexion.cn_Cerrar_coneccion(); 
              }
              
            
              return "gest_nomb_ok";
          }else{
               return null;
          }
 
    
    }
    

   public boolean validarAtribucionesEspe(){
       
       String vTexto;
       String vSaltos[];
       
       if (this.inpt_atribEspe.getValue()!=null)
       {
       
          vTexto=this.inpt_atribEspe.getValue().toString();
       
          vSaltos=vTexto.split("\\n");
       
          if (vTexto.length()>490 || vSaltos.length>=5){
              
            utils.setADFMensajetoControl(new resulOp(resulOp.OPE_WARN,"El texto de las atribuciones específicas es muy largo. Por favor continue en el campo Anexo Atribuciones Específicas."),this.inpt_atribEspe.getClientId(FacesContext.getCurrentInstance()));   
            this.inpt_atribucionesEspeAnexo.setRendered(true);
            return false;
          }else{
              
              if (this.inpt_atribucionesEspeAnexo.getValue()==null)
              this.inpt_atribucionesEspeAnexo.setRendered(false);  
          }
       }
     return true;         
   }

    public void setInp_registro_empleado(CoreInputText inp_registro_empleado) {
        this.inp_registro_empleado = inp_registro_empleado;
    }

    public CoreInputText getInp_registro_empleado() {
        return inp_registro_empleado;
    }

    public void setInpt_idPuesto(CoreInputText inpt_idPuesto) {
        this.inpt_idPuesto = inpt_idPuesto;
    }

    public CoreInputText getInpt_idPuesto() {
        return inpt_idPuesto;
    }

    public void setInpt_numPlaza(CoreInputText inpt_numPlaza) {
        this.inpt_numPlaza = inpt_numPlaza;
    }

    public CoreInputText getInpt_numPlaza() {
        return inpt_numPlaza;
    }

    public void setInpt_correlativo(CoreInputText inpt_correlativo) {
        this.inpt_correlativo = inpt_correlativo;
    }

    public CoreInputText getInpt_correlativo() {
        return inpt_correlativo;
    }

    public void setInpt_id_partida(CoreInputHidden inpt_id_partida) {
        this.inpt_id_partida = inpt_id_partida;
    }

    public CoreInputHidden getInpt_id_partida() {
        return inpt_id_partida;
    }

    public String btn_crear_horario_action() {
        // Add event code here...
        this.inpt_horaE.setValue("");
        this.inpt_horaS.setValue("");
       
         if (!tbl_horario.isRendered()){
           //  this.tbl_horario.setRendered(true);
             this.btn_horario_crear.setPartialSubmit(true);
         }else{
             this.btn_horario_crear.setPartialSubmit(true);
         }
         
        return null;
    }

    public void setInpt_horaE(CoreInputText inpt_horaE) {
        this.inpt_horaE = inpt_horaE;
    }

    public CoreInputText getInpt_horaE() {
        return inpt_horaE;
    }

    public void setInpt_horaS(CoreInputText inpt_horaS) {
        this.inpt_horaS = inpt_horaS;
    }

    public CoreInputText getInpt_horaS() {
        return inpt_horaS;
    }

    public void setTbl_horario(CoreTable tbl_horario) {
        this.tbl_horario = tbl_horario;
    }

    public CoreTable getTbl_horario() {
        return tbl_horario;
    }

    public void shw_detail_puesto_action(DisclosureEvent disclosureEvent) {

    }

    public void setCmb_tipoContrato(CoreSelectOneChoice cmb_tipoContrato) {
        this.cmb_tipoContrato = cmb_tipoContrato;
      //  if (this.cmb_tipoContrato.getValue()==null)
      //      this.cmb_tipoContrato.setValue(0);
        
    }

    public CoreSelectOneChoice getCmb_tipoContrato() {
        return cmb_tipoContrato;
    }

    public void setShw_pestania1(CoreShowDetailItem shw_pestania1) {
        this.shw_pestania1 = shw_pestania1;
    }

    public CoreShowDetailItem getShw_pestania1() {
        return shw_pestania1;
    }

    public void setShw_pestania2(CoreShowDetailItem shw_pestania2) {
        this.shw_pestania2 = shw_pestania2;
    }

    public CoreShowDetailItem getShw_pestania2() {
        return shw_pestania2;
    }

    public void setShw_pestania3(CoreShowDetailItem shw_pestania3) {
        this.shw_pestania3 = shw_pestania3;
    }

    public CoreShowDetailItem getShw_pestania3() {
        return shw_pestania3;
    }

    public void setShw_pestania4(CoreShowDetailItem shw_pestania4) {
        this.shw_pestania4 = shw_pestania4;
    }

    public CoreShowDetailItem getShw_pestania4() {
        return shw_pestania4;
    }

    public String btn_sig_datos_action() {
        // Add event code here...
        this.shw_pestania1.setDisclosed(false);
        this.shw_pestania2.setDisclosed(true);
        
        return null;
    }

    public String btn_puesto_ant() {
        // Add event code here...
         this.shw_pestania2.setDisclosed(false);
         this.shw_pestania1.setDisclosed(true);
        return null;
    }

    public String btn_puesto_sig() {
         this.shw_pestania2.setDisclosed(false);
         this.shw_pestania3.setDisclosed(true);
        return null;
    }

    public String btn_actaPosesion_ant() {
        // Add event code here...
         this.shw_pestania3.setDisclosed(false);
         this.shw_pestania2.setDisclosed(true);
        return null;
    }

    public String btn_actaPosesion_sig() {
        // Add event code here...
         this.shw_pestania3.setDisclosed(false);
         this.shw_pestania4.setDisclosed(true);
        return null;
    }

    public String btn_tranSueldo_ant() {
        // Add event code here..
         this.shw_pestania4.setDisclosed(false);
         this.shw_pestania3.setDisclosed(true);
        return null;
    }

    public void setTbl_selection(CoreTableSelectOne tbl_selection) {
        this.tbl_selection = tbl_selection;
    }

    public CoreTableSelectOne getTbl_selection() {
        return tbl_selection;
    }

    public void setBtn_horario_crear(CoreCommandButton btn_horario_crear) {
        this.btn_horario_crear = btn_horario_crear;
    }

    public CoreCommandButton getBtn_horario_crear() {
        return btn_horario_crear;
    }

    public void setInpt_sueldoBase(CoreInputText inpt_sueldoBase) {
        this.inpt_sueldoBase = inpt_sueldoBase;
    }

    public CoreInputText getInpt_sueldoBase() {
        return inpt_sueldoBase;
    }

    public void setMensajes(CoreMessages mensajes) {
        this.mensajes = mensajes;
    }

    public CoreMessages getMensajes() {
        return mensajes;
    }

    public String btn_imprimir_Action() {
        // Add event code here...
        HashMap parametros=new HashMap();
        parametros.put("contrato",(JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdContrato.inputValue}")).toString());
        parametros.put("opcion",(JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{1}")).toString());
        reporteParams.set_opciones(reporteParams.AGREGAR_PARAMETROS,parametros);  
        return "dialog:imprimir_contrato";
    }

    public String btn_imprimirSicoin_Action() {
        // Add event code here...
        HashMap parametros=new HashMap();
        parametros.put("contrato",(JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdContrato.inputValue}")).toString());
        parametros.put("opcion",(JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{2}")).toString());
        reporteParams.set_opciones(reporteParams.AGREGAR_PARAMETROS,parametros);  
        return "dialog:imprimir_contrato";
    }

    public void cmb_dependencia_cambio(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
          
        sel_depto=true;

    }

    public String btn_nuevo_nombramiento() {
        // Add event code here...
         usuario.set_opciones(usuario.SEL_CONTRATO,new Long(0) ); 
         usuario.set_opciones(usuario.VISTA_CONTRATO,0); 
         usuario.set_opciones(usuario.SEL_REGEMPLEADO,0);
        return "gest_nomb_ok";
    }

    public void inp_addfile(ValueChangeEvent valueChangeEvent) {
        String vStr_directorioCarga;
        UploadedFile vArchivoEntrada;   
        carga_datos vCarga;
        
        boolean vResultado_carga;
        HashMap vParametros;
        String  vVariable;
        resulOp vResultado;
        vResultado=new resulOp();
        Object vValorTemp;
        long tamByteMaxArchivo=0;
        
        Object vDominio;  
          
        vDominio=JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.dominioApp");
                

        if (vDominio!=null && vDominio.toString().equals("nomina_usac")){
            resulOp vmensaje= new resulOp();
            vmensaje.setMensajeError("Adjuntar archivos desactivado: Ir nueva dirección: siif.usac.edu.gt/Nomina ");
            vmensaje.setCodigoResultado(resulOp.OPE_ERROR);        
            utils.setADFMensajetoControl(vmensaje,utils.getNomControlCliente(this.inpt_addFile));  
            return;
        }

        
        // Obteniendo el directorio para la carga del archivo
        vStr_directorioCarga=FacesContext.getCurrentInstance().getExternalContext().getInitParameter("ROOT_UPLOADS");
        vStr_directorioCarga=vStr_directorioCarga+FacesContext.getCurrentInstance().getExternalContext().getInitParameter("DIRECTORIO_DOC_CONTRATO");
        
        
        tamByteMaxArchivo=new Long(FacesContext.getCurrentInstance().getExternalContext().getInitParameter("TAMANIO_MAX_DOC_ADJUNTO"));
        
        
        if (this.inpt_addFile.getValue()!=null){
                
        vArchivoEntrada = (UploadedFile)valueChangeEvent.getNewValue();
        // System.out.println("seleccionado"+vArchivoEntrada.getFilename());
        
        
        // Verifica si existe el directorio para la carga y si no lo crea
        boolean exists = (new File(vStr_directorioCarga)).exists();
        if (!exists) {
            (new File(vStr_directorioCarga)).mkdirs();
        }
        
        vCarga=new carga_datos();    
         
        try{
        
        if (vArchivoEntrada.getLength()<=tamByteMaxArchivo){ 
        
        vParametros=new HashMap();      
        vVariable=(vValorTemp=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdContrato.inputValue}"))!=null?vValorTemp.toString():null;
        
        if (vVariable!=null){
            vParametros.put("Directorio",vStr_directorioCarga);
            vParametros.put("nomArchivo",vArchivoEntrada.getFilename());
            vParametros.put("idContrato",vVariable);
            vParametros.put("contentType",vArchivoEntrada.getContentType());
            vParametros.put("Descripcion",this.inpt_DescripcionArchivo.getValue());
            vParametros.put("opcion",1);
            vParametros.put("CreadoPor",utils.getUsuario());
            vParametros.put("Modulo","NINGUNO");
            
        
            vResultado_carga=vCarga.Bol_Cargar_Archivo_Adjunto2(vArchivoEntrada,vParametros);
           
           this.inpt_DescripcionArchivo.setValue("");
         if (vResultado_carga==true){
         
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ExeArchAdjunto");
         
         vResultado.setCodigoResultado(resulOp.OPE_OK);
         vResultado.setMensajeError("Archivo <"+vArchivoEntrada.getFilename()+ "> cargado exitosamente.");
         }
         else{ 
         vResultado.setCodigoResultado(resulOp.OPE_ERROR);
         vResultado.setMensajeError("Error al cargar <"+vArchivoEntrada.getFilename()+ ">. "+ vCarga.getError());         
         }
        
        utils.setADFMensaje(vResultado);
                                    }
        
            }else {
                
                vResultado.setCodigoResultado(resulOp.OPE_ERROR);
                vResultado.setMensajeError("EL TAMANIO DEL ARCHIVO ES MUY GRANDE. TAMANIO MAX PERMITIDO:  "+ (tamByteMaxArchivo/1024) + " KB ");
                utils.setADFMensajetoControl(vResultado,utils.getNomControlCliente(this.inpt_addFile));
            }
        }
        catch(Exception eas){  eas.printStackTrace();
            vResultado.setCodigoResultado(resulOp.OPE_ERROR);
            vResultado.setMensajeError("HA OCURRIDO UN ERROR INESPERADO FAVOR REVISE.");
            utils.setADFMensajetoControl(vResultado,utils.getNomControlCliente(this.inpt_addFile));
        }
        }       
        
    }

    public void setInpt_addFile(CoreInputFile inpt_addFile) {
        this.inpt_addFile = inpt_addFile;
    }

    public CoreInputFile getInpt_addFile() {
        return inpt_addFile;
    }

    public String btn_carga_Archivo() {
        if (this.inpt_addFile.getValue() == null) {
           resulOp vmensaje= new resulOp();
           vmensaje.setMensajeError("Seleccione un archivo");
           vmensaje.setCodigoResultado(resulOp.OPE_ERROR);        
           utils.setADFMensajetoControl(vmensaje,utils.getNomControlCliente(this.inpt_addFile));          
        }
        return null;
    }

    public void setInpt_DescripcionArchivo(CoreInputText inpt_DescripcionArchivo) {
        this.inpt_DescripcionArchivo = inpt_DescripcionArchivo;
    }

    public CoreInputText getInpt_DescripcionArchivo() {
        return inpt_DescripcionArchivo;
    }


    public void setCmd_lnk_otro(CoreCommandLink cmd_lnk_otro) {
        this.cmd_lnk_otro = cmd_lnk_otro;
    }

    public CoreCommandLink getCmd_lnk_otro() {
        return cmd_lnk_otro;
    }

    
    public String btn_autorizacion_action() {
        util_dialog_adf vDialog= new util_dialog_adf();
        Object vVariable,vEstado;
        vVariable=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdContrato.inputValue}");
        vEstado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.Estatus.inputValue}");
        vDialog.abrir_dialogo_autorizacion(FacesContext.getCurrentInstance(),"NOMBRAMIENTO",vVariable,vEstado,"Contrato");
        return null;
    }

    public String btn_actualizar_contrato() 
    {
        BindingContainer vBnd_binding;
        OperationBinding operationBinding;
        Object result;
        resulOp vResultado=new resulOp();
        validarAtribucionesEspe();
                               
             vBnd_binding=(BindingContainer)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings}");
             operationBinding=vBnd_binding.getOperationBinding("Commit");
            
            
            try{
             result=operationBinding.execute();   
             
             if (operationBinding.getErrors().isEmpty()){
                 vResultado.setMensajeError("Contrato actualizado correctamente!!");
                 vResultado.setCodigoResultado(resulOp.OPE_OK);
                 utils.setADFMensaje(vResultado); 
                 usuario.set_opciones(usuario.VISTA_CONTRATO,1); 
                 JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Ejec_buscar_contrato");
                 JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"bonos");
                 return "gest_nomb_ok";
             }
             
             
            }catch(Exception exep){
                exep.printStackTrace();
            }
        
        return null;
    }

    public void return_sel_plazas(ReturnEvent returnEvent) {
        // Add event code here...
        
         plazasRowImpl vFilaSel;
         String sqlQuerry; 
         String regEmpleado;
         String strMensaje;
         Object vFechaCreacion,vFechaInicio;
         String vIdContrato;
         Object vResultadoConsul;
         String vRenglon;
        
        if (returnEvent.getReturnValue()!=null){
            vFilaSel=(plazasRowImpl)returnEvent.getReturnValue();
          //  System.out.println("retorno "+ vFilaSel.getNombre()+ " " +vFilaSel.getNombre() + " " +vFilaSel.getSalarioBasepuesto() + " " +vFilaSel.getComplementoSal());
            
           
            interfaz_DB conexion;
            ResultSet vResultado;
            conexion=new interfaz_DB();
             
            vFechaCreacion=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.FechaCreacion.inputValue}");
            vFechaInicio=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.FechaInicio.inputValue}");
            regEmpleado=JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.selRegEmpleado").toString();
           
            if (vFilaSel.getFormato1()!=null){
                
                vRenglon = vFilaSel.getFormato1().substring(8,10);
                
                if (vRenglon.equals("11")){
                    
                  //  System.out.println("Nombrar");
                    this.cmb_tipoContrato.setValue(utils.getNumberOracle("2"));
                    this.cmb_tipoContrato.setSubmittedValue(utils.getNumberOracle("2"));
                    
                }else{
                    
                  //  System.out.println("Contratar");
                    this.cmb_tipoContrato.setValue(utils.getNumberOracle("1"));
                    this.cmb_tipoContrato.setSubmittedValue(utils.getNumberOracle("1"));
                    
                }
                
            }
            
           if (vFechaInicio!=null)
           {
           
               // verificando si la plaza no esta en periodo de licencia sin goce de sueldo
                sqlQuerry="select sis_pkg_util.verificaPlazaLicParcial(";
                sqlQuerry=sqlQuerry+vFilaSel.getIdPartida().toString();
                sqlQuerry=sqlQuerry+","+vFilaSel.getIdPuesto()+","+vFilaSel.getNumeroPlaza()+","+vFilaSel.getCorrelativo();
                sqlQuerry=sqlQuerry+",to_date('"+utils.getFechaFormato3("dd/MM/yyyy",vFechaInicio)+"','dd/mm/yyyy')";
                sqlQuerry=sqlQuerry+") as valor from dual"; 
                
                vResultadoConsul=conexion.getValorConsultaSimple("valor",sqlQuerry);
                
               
                if (vResultadoConsul!=null && !vResultadoConsul.toString().equals("1")){
                    utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"No se pueda asignar una plaza asociada a una licencia sin goce de sueldo parcial"));
                    conexion.cn_Cerrar_coneccion();
                    return;
                }
           
           }
            /*
            if (vFechaCreacion==null){
            sqlQuerry="select sis_pkg_util.VALIDARHORASCONTRATADAS(";
            sqlQuerry=sqlQuerry+ "'"+regEmpleado+"',";
            sqlQuerry=sqlQuerry+vFilaSel.getCantidadHoras().stringValue()+","+vFilaSel.getIdPartida().toString();
            sqlQuerry=sqlQuerry+","+vFilaSel.getIdPuesto()+",null),";
            sqlQuerry=sqlQuerry+"sis_pkg_util.getHorasContratadasEmpleado('"+regEmpleado+"') from dual"; 
            }else {
                vIdContrato=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdContrato.inputValue}").toString();
                sqlQuerry="select sis_pkg_util.VALIDARHORASCONTRATADAS(";
                sqlQuerry=sqlQuerry+ "'"+regEmpleado+"',";
                sqlQuerry=sqlQuerry+vFilaSel.getCantidadHoras().stringValue()+","+vFilaSel.getIdPartida().toString();
                sqlQuerry=sqlQuerry+","+vFilaSel.getIdPuesto()+","+vIdContrato + "),";
                sqlQuerry=sqlQuerry+"sis_pkg_util.getHorasContratadasEmpleado('"+regEmpleado+"') from dual";     
                
            }
            */
          //  System.out.println(sqlQuerry);
            
            vResultado=null;
            strMensaje=null;
            /*
            try{
                vResultado=conexion.Bol_ejecutar_sentencia(sqlQuerry);
             if (vResultado.next()){
              // vResultado.getType()
                 if (vResultado.getBigDecimal(1)!=null && vResultado.getBigDecimal(1).compareTo(new BigDecimal(0))<0){
                     strMensaje="El empleado ya tiene asignado "+vResultado.getObject(2).toString() + " horas. Ya no se le pueden asignar mas horas.";
                 }
                 
             }
            
            // vResultado.close();
            */
             conexion.cn_Cerrar_coneccion();
            
            
            if (strMensaje!=null){    
                utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,strMensaje));
                                }
            else{
                //Datos de la plaza
                JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.IdPartida.inputValue}",vFilaSel.getIdPartida());
                JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.IdPuesto.inputValue}",vFilaSel.getIdPuesto());
                JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.NumeroPlaza.inputValue}",vFilaSel.getNumeroPlaza());
                JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.Correlativo.inputValue}",vFilaSel.getCorrelativo());
                JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.Horascontratadas.inputValue}",vFilaSel.getCantidadHoras());
                
                this.inpt_escalafon.setSubmittedValue(null);
                this.inpt_complemento_sal.setSubmittedValue(null);
                this.inpt_sueldoBase.setSubmittedValue(null);
                this.inpt_fecha_i.setSubmittedValue(null);
                this.inpt_fecha_f.setSubmittedValue(null);
                // Datos del salario
                 JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.ComplSal.inputValue}",vFilaSel.getComplementoSal());
                 JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.Escalaf.inputValue}",vFilaSel.getEscalafon());
                 JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.Sueldobase.inputValue}",vFilaSel.getSalarioBasepuesto());
                // JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.FechaInicio.inputValue}",vFilaSel.getFechaInicio2());
                // JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.FechaFin.inputValue}",vFilaSel.getFechaFin2());
                this.inpt_fecha_i.setValue(vFilaSel.getFechaInicio2());
                this.inpt_fecha_f.setValue(vFilaSel.getFechaFin2());
                 //this.inpt_complemento_sal.setValue(utils.getNumberOracle("15"));
                // this.inpt_fecha_i.setValue(vFilaSel.getFechaInicio());
                 //this.inpt_escalafon.setValue("147");
                
            }
             /*                   
            }catch(Exception exep){
                exep.printStackTrace();    
            }
            */
            //Object vre=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.SisContrato_vwIterator.currentRow['validarHoras']}");
            
            //System.out.println("retorno2 " + vre);
          
            if (vFilaSel.getSalarioBasepuesto().equals(0)){
                this.inpt_sueldoBase.setDisabled(false);
            }else{
                this.inpt_sueldoBase.setDisabled(true);
            }
            
          
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarDetPuesto");
         
            
        }
        
    }
    
    public void setInpt_complemento_sal(CoreInputText inpt_complemento_sal) {
        this.inpt_complemento_sal = inpt_complemento_sal;
    }

    public CoreInputText getInpt_complemento_sal() {
        return inpt_complemento_sal;
    }

    public void setInpt_escalafon(CoreInputText inpt_escalafon) {
        this.inpt_escalafon = inpt_escalafon;
    }

    public CoreInputText getInpt_escalafon() {
        return inpt_escalafon;
    }


    public void return_autorizacion(ReturnEvent returnEvent) {
        // Add event code here...
        //System.out.println("regrese de autorizacion");
    }

    public void btn_auto_lauch_auto(LaunchEvent launchEvent) {
        util_dialog_adf vDialog= new util_dialog_adf();
        Object vVariable,vEstado;
        vVariable=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdContrato.inputValue}");
        vEstado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.Estatus.inputValue}");
        vDialog.setParametros_dialogo_autorizacion(launchEvent,"NOMBRAMIENTO",vVariable,vEstado,"Contrato");
    }

    public String btn_clonarContrato() {
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"clonarActual");
        //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Resetear");
        usuario.set_opciones(usuario.SEL_CONTRATO,new Long(0) ); 
        usuario.set_opciones(usuario.VISTA_CONTRATO,3); 
        return null;
    }
    
    public boolean getIsAnioActual(){
    
        Object vAnioPlaza,vAnio;
        vAnioPlaza=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.Correlativo.inputValue}");        
        vAnio=utils.getAnioActual();//JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{flujo_usuario.anioActual}");

        if (vAnioPlaza!=null){
            
            if (vAnioPlaza.equals(vAnio))             
            {
                return true;
            }
        }

     return false;   
    }

    public void setInpt_atribEspe(CoreInputText inpt_atribEspe) {
        this.inpt_atribEspe = inpt_atribEspe;
    }

    public CoreInputText getInpt_atribEspe() {
        return inpt_atribEspe;
    }

    public void setInpt_atribucionesEspeAnexo(CoreInputText inpt_atribucionesEspeAnexo) {
        this.inpt_atribucionesEspeAnexo = inpt_atribucionesEspeAnexo;
    }

    public CoreInputText getInpt_atribucionesEspeAnexo() {
        return inpt_atribucionesEspeAnexo;
    }

    public String btn_horario_crear() {
        // Add event code here...
        
         if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"DisableAll")) 
         {
             
             if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"crearHorario"))
             {
             
               this.tbl_selection.setDisabled(true);
            
               this.btn_crear_horarioNew.setDisabled(true);
               this.cm_lnk_editarHorario.setDisabled(true);
             
                 
             }
             
         }

        return null;
    }

    public void setBtn_crear_horarioNew(CoreCommandButton btn_crear_horarioNew) {
        this.btn_crear_horarioNew = btn_crear_horarioNew;
    }

    public CoreCommandButton getBtn_crear_horarioNew() {
        return btn_crear_horarioNew;
    }

    public String btn_editar_horarioNew() {
        // Add event code here...
         if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"DisableAll"))
         {
             if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"FilaActualH")){
                 JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Habilitar");
                 
                 this.tbl_selection.setDisabled(true);
                 this.btn_crear_horarioNew.setDisabled(true);
                 this.cm_lnk_editarHorario.setDisabled(true);
                 this.cmd_link_borrarH.setDisabled(true);
                // this.cmd_lnk_otro.setDisabled(true);                 
                 
             }
             
         }
        
        return null;
    }

    public void setCm_lnk_editarHorario(CoreCommandLink cm_lnk_editarHorario) {
        this.cm_lnk_editarHorario = cm_lnk_editarHorario;
    }

    public CoreCommandLink getCm_lnk_editarHorario() {
        return cm_lnk_editarHorario;
    }

    public String btn_horario_OK() {
         this.btn_crear_horarioNew.setDisabled(false);   
         this.tbl_selection.setDisabled(false);
         this.cm_lnk_editarHorario.setDisabled(false);
         this.cmd_link_borrarH.setDisabled(false);
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"DisableAll");            
        return null;
    }

    public String cmd_borrarH() {
        // Add event code here...
        
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Delete");
        this.btn_crear_horarioNew.setDisabled(false);   
        this.cm_lnk_editarHorario.setDisabled(false);
        return null;
    }

    public void setCmd_link_borrarH(CoreCommandLink cmd_link_borrarH) {
        this.cmd_link_borrarH = cmd_link_borrarH;
    }

    public CoreCommandLink getCmd_link_borrarH() {
        return cmd_link_borrarH;
    }
}
