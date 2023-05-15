package interfaz_usuario.backing.procesos;

import interfaz_usuario.util.JSFUtils;

import interfaz_usuario.util.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


import java.text.DateFormat;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.ResourceBundle;
import java.util.Vector;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.faces.component.core.input.CoreInputFile;
import oracle.adf.view.faces.component.core.layout.CorePanelBox;
import oracle.adf.view.faces.component.core.output.CoreMessage;
import oracle.adf.view.faces.model.UploadedFile;


import oracle.toplink.essentials.queryframework.ReadAllQuery;
import oracle.toplink.internal.expressions.SQLStatement;
import oracle.toplink.queryframework.DataReadQuery;
import oracle.toplink.queryframework.DatabaseQuery;
import oracle.toplink.queryframework.SQLCall;
import oracle.toplink.sessions.Connector;
import oracle.toplink.sessions.Session;
import oracle.toplink.sessions.UnitOfWork;
import oracle.toplink.sessions.entitymanager.Query;
import oracle.toplink.util.SessionFactory;
import pkg_carga_datos.carga_datos;

public class apertura {
    private CoreInputFile inp_file;
    private CoreMessage mensaje;
    private CorePanelBox panel_det_proc;
    private carga_datos vCarga;

    public apertura() {
    
    }

    public void setInp_file(CoreInputFile inp_file) {
        this.inp_file = inp_file;
    }

    public CoreInputFile getInp_file() {
        return inp_file;
    }

    public void inp_file_cambio_valor(ValueChangeEvent valueChangeEvent) {
       
        String vStr_directorioCarga;
        UploadedFile vArchivoEntrada;
       
        FacesContext vContext;
        FacesMessage vMessage; 
        boolean vResultado_carga;
        
        // Obteniendo el directorio para la carga del archivo
        vStr_directorioCarga=FacesContext.getCurrentInstance().getExternalContext().getInitParameter("DIRECTORIO_ARCHIVOS_CARGA");
        if (this.inp_file.getValue()!=null){
                
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
        vResultado_carga=vCarga.Bol_Cargar_Arch_Aper_Presup(vArchivoEntrada,vStr_directorioCarga + "/"+ ab.format(new Date())+"_"+vArchivoEntrada.getFilename(),Integer.parseInt(utils.getAnioActual()));
        vContext = FacesContext.getCurrentInstance();
         if (vResultado_carga==true && vCarga.get_insertados()>0 )
        vMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,"Archivo <"+vArchivoEntrada.getFilename()+ "> cargado. No Registros: "+vCarga.get_insertados()+". Procesados con error: "+vCarga.getCantErroresProc(),null);
         else if (vResultado_carga==true && vCarga.get_insertados()==0 )
        vMessage = new FacesMessage(FacesMessage.SEVERITY_WARN,"Archivo <"+vArchivoEntrada.getFilename()+ ">. " + vCarga.getError(),null);
         else 
        vMessage = new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error al cargar <"+vArchivoEntrada.getFilename()+ ">. "+ vCarga.getError(),null);
        
       //    System.out.println("id componenete "+valueChangeEvent.getComponent().getClientId(vContext));
        vContext.addMessage(valueChangeEvent.getComponent().getClientId(vContext),vMessage);    
        
        //this.inp_file.setValue(null);

       }
      catch(Exception eas){  eas.printStackTrace();}
    
    
        // Add event code here...
        }
    }

    public String btn_Cargar_archivo() {
        FacesContext vContext;
        FacesMessage vMessage; 
        vContext = FacesContext.getCurrentInstance();
        if (this.inp_file.getValue() == null) {
            vMessage = new FacesMessage(FacesMessage.SEVERITY_FATAL,"Seleccione un archivo",null);
            vContext.addMessage(inp_file.getClientId(vContext),vMessage);
        }
        
        return null;
    }

    public void setMensaje(CoreMessage mensaje) {
        this.mensaje = mensaje;
    }

    public CoreMessage getMensaje() {
        return mensaje;
    }

    public void setPanel_det_proc(CorePanelBox panel_det_proc) {
        this.panel_det_proc = panel_det_proc;
    }

    public CorePanelBox getPanel_det_proc() {
        return panel_det_proc;
    }
}
