package interfaz_usuario.backing.procesos;

import enlace_datos.util.resulOp;

import interfaz_usuario.util.JSFUtils;
import interfaz_usuario.util.utils;

import java.io.File;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.HashMap;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.faces.component.core.CorePoll;
import oracle.adf.view.faces.component.core.input.CoreInputFile;
import oracle.adf.view.faces.component.core.input.CoreSelectInputDate;
import oracle.adf.view.faces.component.core.layout.CoreShowDetailItem;
import oracle.adf.view.faces.event.PollEvent;
import oracle.adf.view.faces.model.UploadedFile;

import pkg_carga_datos.carga_datos;

public class carga_conciliacion {
    private CoreInputFile inputCargaArchivo;
    private CoreShowDetailItem showDetail2;
    private CoreShowDetailItem showDetail1;
    private CoreSelectInputDate inputFechaAnulacion;

    public carga_conciliacion() {
    }

    public void input_file(ValueChangeEvent valueChangeEvent) {
        
         String vStr_directorioCarga;
         UploadedFile vArchivoEntrada;
         carga_datos vCarga;
         boolean vResultado_carga;
         HashMap vParametros;
         resulOp vResultado;
         vResultado=new resulOp();
         String [] vPeriodo;
         String vNombTemp;
         
         // Obteniendo el directorio para la carga del archivo
         vStr_directorioCarga=FacesContext.getCurrentInstance().getExternalContext().getInitParameter("ROOT_UPLOADS");
         vStr_directorioCarga=vStr_directorioCarga+FacesContext.getCurrentInstance().getExternalContext().getInitParameter("DIRECTORIO_CONCILIACION");
         if (this.inputCargaArchivo.getValue()!=null){
                 
         vArchivoEntrada = (UploadedFile)valueChangeEvent.getNewValue();
         // System.out.println("seleccionado"+vArchivoEntrada.getFilename());
         
         
         // Verifica si existe el directorio para la carga y si no lo crea
         boolean exists = (new File(vStr_directorioCarga)).exists();
         if (!exists) {
             (new File(vStr_directorioCarga)).mkdirs();
         }
         
         vCarga=new carga_datos();    
         
         SimpleDateFormat ab= new SimpleDateFormat("MMdd_HHmmss");
         
         try{
         
         vParametros=new HashMap();      
 
         vNombTemp=ab.format(new Date())+"_"+vArchivoEntrada.getFilename();
         vParametros.put("nombreArchivoOrig",vNombTemp);
         vParametros.put("nombreArchivo",vStr_directorioCarga + vNombTemp);
         
        
         ab= new SimpleDateFormat("MM yyyy"); 
         vPeriodo=ab.format(new Date()).split("\\s+");
             
         vParametros.put("periodo",vPeriodo[0]);
         vParametros.put("anio",vPeriodo[1]);                        
         
         vResultado_carga=vCarga.Bol_Cargar_ConciliacionBancaria(vArchivoEntrada,vParametros);
            
         if (vResultado_carga==true){
             this.showDetail1.setDisclosed(false);
             this.showDetail2.setDisclosed(true);
             JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ExecuteWithParams");
         }
            
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
         
         utils.setADFMensaje(vResultado);
        
         }
         catch(Exception eas){  eas.printStackTrace();
             vResultado.setCodigoResultado(resulOp.OPE_ERROR);
             vResultado.setMensajeError("HA OCURRIDO UN ERROR INESPERADO FAVOR REVISE.");
             utils.setADFMensajetoControl(vResultado,utils.getNomControlCliente(this.inputCargaArchivo));
         }
         }

    }


    public String carga_archivo_action() {
       
        if (this.inputCargaArchivo.getValue() == null) {
           resulOp vmensaje= new resulOp();
           vmensaje.setMensajeError("Seleccione un archivo");
           vmensaje.setCodigoResultado(resulOp.OPE_ERROR);        
           utils.setADFMensajetoControl(vmensaje,utils.getNomControlCliente(this.inputCargaArchivo));          
        }
        return null;
    }
    
    public void setInputCargaArchivo(CoreInputFile inputCargaArchivo) {
        this.inputCargaArchivo = inputCargaArchivo;
    }

    public CoreInputFile getInputCargaArchivo() {
        return inputCargaArchivo;
    }

    public String btn_procesar() {
      
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"ProcesarConciliacionBancaria")){
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ExecuteWithParams");
            utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Proceso ejecutado exitosamente."));  
        }      
        return null;
    }

    
    public void setShowDetail2(CoreShowDetailItem showDetail2) {
        this.showDetail2 = showDetail2;
    }

    public CoreShowDetailItem getShowDetail2() {
        return showDetail2;
    }

    public void setShowDetail1(CoreShowDetailItem showDetail1) {
        this.showDetail1 = showDetail1;
    }

    public CoreShowDetailItem getShowDetail1() {
        return showDetail1;
    }

    public String btn_cambiar_estado_cheque() {
    
      if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"cambiarEstadoCheque")){
          
         utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Se ha cambiado el estado del cheque"));
          
      }
    
        // Add event code here...
        return null;
    }

    public String btn_procesar_concilia() 
    {
        // Add event code here...
       if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"setFilaConcilia")){
        
         if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"procesar_conciliacion"))
         {        
           utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Se ha procesado los datos") );
         }
         
       }
        
      return null;
   }

    public String btn_dar_visto_bueno() {
        // Add event code here...
         if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"setFilaConcilia"))
         {
          
           if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"dar_visto_bueno"))
           {
           
             JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecProcConcilia");
             utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Se ha cambiado el estado."));
             
           }
           
         }        
        return null;
    }

    public void cambioEstado(ValueChangeEvent val) {
        if(val.getNewValue().equals("0")){
            this.inputFechaAnulacion.setDisabled(false);
        }
        else{
            this.inputFechaAnulacion.setDisabled(true);
        }
    }

    public void setInputFechaAnulacion(CoreSelectInputDate inputFechaAnulacion) {
        this.inputFechaAnulacion = inputFechaAnulacion;
    }

    public CoreSelectInputDate getInputFechaAnulacion() {
        return inputFechaAnulacion;
    }
}
