package interfaz_usuario.backing.procesos;

import enlace_datos.util.resulOp;

import interfaz_usuario.util.JSFUtils;
import interfaz_usuario.util.utils;

import java.io.File;

import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.HashMap;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.faces.component.core.input.CoreChooseDate;
import oracle.adf.view.faces.component.core.input.CoreInputFile;
import oracle.adf.view.faces.component.core.input.CoreSelectInputDate;
import oracle.adf.view.faces.component.core.layout.CoreShowDetailItem;
import oracle.adf.view.faces.component.core.layout.CoreShowOneRadio;
import oracle.adf.view.faces.event.AttributeChangeEvent;
import oracle.adf.view.faces.event.DisclosureEvent;
import oracle.adf.view.faces.model.UploadedFile;

import pkg_carga_datos.carga_datos;

public class carga_prestamo {
    private CoreInputFile inpt_carga_archivo;
    private CoreChooseDate inpt_fecha_periodo;
    private CoreShowOneRadio shOneRadio;
    private boolean vPeriodoAct;
    private boolean vValidar;
    private CoreShowDetailItem sh_detailItem_actual;
    private CoreSelectInputDate inpt_fechaI;
    private CoreSelectInputDate inpt_fechaF;


    public carga_prestamo() {
      vPeriodoAct=true;
     
    
    }

    public String carga_archivo_action() {
       
        if (this.inpt_carga_archivo.getValue() == null) {
           resulOp vmensaje= new resulOp();
           vmensaje.setMensajeError("Seleccione un archivo");
           vmensaje.setCodigoResultado(resulOp.OPE_ERROR);        
           utils.setADFMensajetoControl(vmensaje,utils.getNomControlCliente(this.inpt_carga_archivo));          
        }
        return null;
    }

    public void inpt_file_change(ValueChangeEvent valueChangeEvent) {
        
         String vStr_directorioCarga;
         UploadedFile vArchivoEntrada;
         
        
         carga_datos vCarga;
         
         boolean vResultado_carga;
         HashMap vParametros;
         String  vVariable;
         resulOp vResultado;
         vResultado=new resulOp();
         String [] vPeriodo;
         
         // Obteniendo el directorio para la carga del archivo
         vStr_directorioCarga=FacesContext.getCurrentInstance().getExternalContext().getInitParameter("DIRECTORIO_ARCHIVOS_PRESTAMO");
         if (this.inpt_carga_archivo.getValue()!=null){
                 
         vArchivoEntrada = (UploadedFile)valueChangeEvent.getNewValue();
         // System.out.println("seleccionado"+vArchivoEntrada.getFilename());
         
         
         // Verifica si existe el directorio para la carga y si no lo crea
         boolean exists = (new File(vStr_directorioCarga)).exists();
         if (!exists) {
             (new File(vStr_directorioCarga)).mkdirs();
         }
         
         vCarga=new carga_datos();    
         
         SimpleDateFormat ab= new SimpleDateFormat("MMdd_hhmmss");
         
         try{
         
         vParametros=new HashMap();      
         //vVariable=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdOrigenCargaArchivo.currentRow['idOrigenCargaArchivo']}").toString();
         vVariable=JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.idCargaArchivo").toString();
        // vVariable="1";
         
         vParametros.put("nombreArchivo",vStr_directorioCarga + ab.format(new Date())+"_"+vArchivoEntrada.getFilename());
         vParametros.put("idBanco",vVariable);
        
         ab= new SimpleDateFormat("MM yyyy"); 
         vPeriodo=ab.format(new Date()).split("\\s+");
             
         vParametros.put("periodo",vPeriodo[0]);
         vParametros.put("anio",vPeriodo[1]);     
         
         /*               
         if (this.sh_detailItem_actual.isDisclosed()){ // Si es el perido actual se obtiene el mes
             vParametros.put("periodo",vPeriodo[0]);
             vParametros.put("anio",vPeriodo[1]);
         }else{ // Si es otro perido se obtiene del binding
             vVariable=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.periodo1.currentRow['idPeriodo']}").toString();    
             vParametros.put("periodo",vVariable);
             vParametros.put("anio",vPeriodo[1]);
         }
         */
          
         
         vResultado_carga=vCarga.Bol_Cargar_ArchPrestamos(vArchivoEntrada,vParametros);
            
          
          if (vResultado_carga==true && vCarga.get_insertados()>0 && vCarga.getCantErroresProc()==0){
          vResultado.setCodigoResultado(resulOp.OPE_OK);
          vResultado.setMensajeError("Archivo <"+vArchivoEntrada.getFilename()+ "> cargado exitosamente. No Registros: "+vCarga.get_insertados());
          }
          else if (vResultado_carga==true && vCarga.get_insertados()>0 && vCarga.getCantErroresProc()>0){
             vResultado.setCodigoResultado(resulOp.OPE_WARN);
             vResultado.setMensajeError("Archivo <"+vArchivoEntrada.getFilename()+ "> cargado, pero con errores. No Registros: "+vCarga.get_insertados()+". Procesados con error: "+vCarga.getCantErroresProc());
             }      

          else if (vResultado_carga==true && vCarga.get_insertados()==0 ){
          
           vResultado.setCodigoResultado(resulOp.OPE_WARN);
           vResultado.setMensajeError("Archivo <"+vArchivoEntrada.getFilename()+ "> cargado. No se procesó ningun registro." );

          }
          else{ 
          vResultado.setCodigoResultado(resulOp.OPE_ERROR);
          vResultado.setMensajeError("Error al cargar <"+vArchivoEntrada.getFilename()+ ">. "+ vCarga.getError());         
          }
 
         JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"ExecuteWithParams");        
         utils.setADFMensaje(vResultado);
         
 
       
         }
         catch(Exception eas){  eas.printStackTrace();
             vResultado.setCodigoResultado(resulOp.OPE_ERROR);
             vResultado.setMensajeError("HA OCURRIDO UN ERROR INESPERADO FAVOR REVISE.");
             utils.setADFMensajetoControl(vResultado,utils.getNomControlCliente(this.inpt_carga_archivo));
         }
         }
    }

    public void setInpt_carga_archivo(CoreInputFile inpt_carga_archivo) {
        this.inpt_carga_archivo = inpt_carga_archivo;
    }

    public CoreInputFile getInpt_carga_archivo() {
        return inpt_carga_archivo;
    }

    public void setInpt_fecha_periodo(CoreChooseDate inpt_fecha_periodo) {
        this.inpt_fecha_periodo = inpt_fecha_periodo;
    }

    public CoreChooseDate getInpt_fecha_periodo() {
        return inpt_fecha_periodo;
    }

    public void inpt_periodo_change(AttributeChangeEvent attributeChangeEvent) {
        Object vPeriodo;
        vPeriodo =  attributeChangeEvent.getNewValue();
        // Add event code here...
    }

    public void setShOneRadio(CoreShowOneRadio shOneRadio) {
        this.shOneRadio = shOneRadio;
    }

    public CoreShowOneRadio getShOneRadio() {
        return shOneRadio;
    }

    

    public void setSh_detailItem_actual(CoreShowDetailItem sh_detailItem_actual) {
        this.sh_detailItem_actual = sh_detailItem_actual;
    }

    public CoreShowDetailItem getSh_detailItem_actual() {
        return sh_detailItem_actual;
    }

    public void setInpt_fechaI(CoreSelectInputDate inpt_fechaI) {
        this.inpt_fechaI = inpt_fechaI;
    }

    public CoreSelectInputDate getInpt_fechaI() {
        return inpt_fechaI;
    }

    public void setInpt_fechaF(CoreSelectInputDate inpt_fechaF) {
        this.inpt_fechaF = inpt_fechaF;
    }

    public CoreSelectInputDate getInpt_fechaF() {
        return inpt_fechaF;
    }

    
    public void shw_detail_crear_action(DisclosureEvent disclosureEvent) {
         this.inpt_fechaI.setValue("");
         this.inpt_fechaF.setValue("");
    }

    public String btn_anular_carga() {
        // Add event code here...        
         if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"PosicionarTabla"))
         {
         
            if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"AnularCarga")){
                
                JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"ExecuteWithParams");
                utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Carga Anulada"));
                
            }
             
         }
         
        return null;
    }
}
