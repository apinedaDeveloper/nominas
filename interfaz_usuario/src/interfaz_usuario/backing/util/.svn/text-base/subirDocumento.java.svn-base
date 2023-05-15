package interfaz_usuario.backing.util;

import enlace_datos.util.resulOp;

import interfaz_usuario.util.JSFUtils;
import interfaz_usuario.util.utils;

import java.io.File;

import java.util.HashMap;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.faces.component.core.input.CoreInputFile;
import oracle.adf.view.faces.component.core.input.CoreInputText;
import oracle.adf.view.faces.component.core.nav.CoreCommandButton;
import oracle.adf.view.faces.model.UploadedFile;

import pkg_carga_datos.carga_datos;

public class subirDocumento {
    private CoreInputFile inpt_file;
    private CoreInputFile inpt_fileAdd;
    private CoreInputText descrip;
    private CoreCommandButton salir;

    public subirDocumento() {
    }

    public String subir_arch() {
        if (this.inpt_fileAdd.getValue() == null) {
           
           resulOp vmensaje= new resulOp();
           vmensaje.setMensajeError("Seleccione un archivo");
           vmensaje.setCodigoResultado(resulOp.OPE_ERROR);        
           utils.setADFMensajetoControl(vmensaje,utils.getNomControlCliente(this.inpt_fileAdd));  
        }
        return null;
    }

    public void setInpt_file(CoreInputFile inpt_file) {
        this.inpt_file = inpt_file;
    }

    public CoreInputFile getInpt_file() {
        return inpt_file;
    }

    public void setInpt_fileAdd(CoreInputFile inpt_fileAdd) {
        this.inpt_fileAdd = inpt_fileAdd;
    }

    public CoreInputFile getInpt_fileAdd() {
        return inpt_fileAdd;
    }

    public void inpt_file_change_action(ValueChangeEvent valueChangeEvent) {

        String vStr_directorioCarga,vModulo;
        UploadedFile vArchivoEntrada;   
        carga_datos vCarga;
        
        boolean vResultado_carga;
        HashMap vParametros;
        String  vVariable,vDescripcion;
        resulOp vResultado;
        vResultado=new resulOp();
        Object vValorTemp,vValorTemp2;
        long tamByteMaxArchivo=0;
        int vOpcion;
        // String pTipoArchivo[];
        
        Object vDominio;  
          
        vDominio=JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.dominioApp");
                
/*
        if (vDominio!=null && vDominio.toString().equals("nomina_usac")){
            resulOp vmensaje= new resulOp();
            vmensaje.setMensajeError("Adjuntar archivos desactivado: Ir nueva dirección: siif.usac.edu.gt/Nomina ");
            vmensaje.setCodigoResultado(resulOp.OPE_ERROR);        
            utils.setADFMensajetoControl(vmensaje,utils.getNomControlCliente(this.inpt_fileAdd));  
            return;
        }
      */  
        // Obteniendo el directorio para la carga del archivo
        vStr_directorioCarga=FacesContext.getCurrentInstance().getExternalContext().getInitParameter("ROOT_UPLOADS");
        
        tamByteMaxArchivo=new Long(FacesContext.getCurrentInstance().getExternalContext().getInitParameter("TAMANIO_MAX_DOC_ADJUNTO"));
        
       vValorTemp=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{processScope.Opcion}");
        
        if (vValorTemp!=null){ // Si la pagina fue lanzada desde otra pagina con los parametros respectivos
        vOpcion=(Integer)vValorTemp;
          
        vValorTemp2=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{processScope.Modulo}"); 
         vModulo=(vValorTemp2!=null?vValorTemp2.toString():"NINGUNO");
         
           if (vOpcion==1){ // Archivos para contrato
            
            vValorTemp=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{processScope.IdContrato}"); 

            vStr_directorioCarga=vStr_directorioCarga+FacesContext.getCurrentInstance().getExternalContext().getInitParameter("DIRECTORIO_DOC_CONTRATO");
            
           }else if (vOpcion==2){ //Archivos para la solicitud
            vValorTemp=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{processScope.IdSolicitud}"); 
            vStr_directorioCarga=vStr_directorioCarga+FacesContext.getCurrentInstance().getExternalContext().getInitParameter("DIRECTORIO_DOCS_SOLITUD");
           
           }else if (vOpcion==3){ //Archivos para el empleado
           
            vValorTemp=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{processScope.identificador}"); 
            vStr_directorioCarga=vStr_directorioCarga+FacesContext.getCurrentInstance().getExternalContext().getInitParameter("DIRECTORIO_DOCS_EMPL");
            
           }else if (vOpcion==4){ //Archivos para la variacion nomina
           
               vValorTemp=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{processScope.IdVariacionNom}");     
               vStr_directorioCarga=vStr_directorioCarga+FacesContext.getCurrentInstance().getExternalContext().getInitParameter("DIRECTORIO_DOCS_VARIANOM");
               
           }else if (vOpcion==5){ //Archivos para el anexo
           
               vValorTemp=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{processScope.IdAnexo}");     
               vStr_directorioCarga=vStr_directorioCarga+FacesContext.getCurrentInstance().getExternalContext().getInitParameter("DIRECTORIO_DOCS_ANEXO");
           }
           else if (vOpcion==6){ //Archivos para clasif puesto
            
            vValorTemp="0";
            
           }
           if (vValorTemp!=null){//Los parametros estan completos, ejecutar la carga del archivo 
            
            vVariable=(String)vValorTemp;
            
               if (this.inpt_fileAdd.getValue()!=null){
                    
                   vArchivoEntrada = (UploadedFile)valueChangeEvent.getNewValue();
            
                             
                     // Verifica si existe el directorio para la carga y si no lo crea
                   boolean exists = (new File(vStr_directorioCarga)).exists();
                   if (!exists) {
                           (new File(vStr_directorioCarga)).mkdirs();
                               }
            
                   vCarga=new carga_datos();    
             
                   try{
                    
                    vDescripcion=this.descrip.getValue()!=null?(String)this.descrip.getValue():"";
                    //pTipoArchivo=vArchivoEntrada.getContentType().split("\\/");
                    
                    
                     if (vDescripcion.length()<=150){
                       if (vArchivoEntrada.getLength()<=tamByteMaxArchivo){ 
                           vParametros=new HashMap();      
                           
                            vParametros.put("Directorio",vStr_directorioCarga);
                            vParametros.put("nomArchivo",vArchivoEntrada.getFilename());
                            vParametros.put("contentType",vArchivoEntrada.getContentType());
                            vParametros.put("Descripcion",this.descrip.getValue());
                            vParametros.put("opcion",vOpcion);
                            vParametros.put("CreadoPor",JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{flujo_usuario.selRegEmpleado_login}"));
                            vParametros.put("Modulo",vModulo);
        
                            switch (vOpcion) {
        
                               case 1:  vParametros.put("idContrato",vVariable); break;
                               case 2:  vParametros.put("idSolicitud",vVariable);  break;
                               case 3:  vParametros.put("registro_empleado",vVariable);break;
                               case 4:  vParametros.put("idVariacionNomina",vVariable);break;
                               case 5:  vParametros.put("idAnexo",vVariable);break;
                           }
                                          
                       
                       vResultado_carga=vCarga.Bol_Cargar_Archivo_Adjunto2(vArchivoEntrada,vParametros);
               
                           
                       this.descrip.setValue("");
                       if (vResultado_carga==true){
             
                       //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ExeArchAdjunto");
             
                       vResultado.setCodigoResultado(resulOp.OPE_OK);
                       vResultado.setMensajeError("Archivo <"+vArchivoEntrada.getFilename()+ "> cargado exitosamente.");
                                                   }
                       else{ 
                           vResultado.setCodigoResultado(resulOp.OPE_ERROR);
                           vResultado.setMensajeError("Error al cargar <"+vArchivoEntrada.getFilename()+ ">. "+ vCarga.getError());         
                           }
            
                       utils.setADFMensaje(vResultado);
                       }else{
                               vResultado.setCodigoResultado(resulOp.OPE_ERROR);
                               vResultado.setMensajeError("EL TAMANIO DEL ARCHIVO ES MUY GRANDE. TAMANIO MAX PERMITIDO:  "+ (tamByteMaxArchivo/1024) + " KB ");
                               utils.setADFMensajetoControl(vResultado,utils.getNomControlCliente(this.inpt_fileAdd));
                           }
                       }else {
                    
                    vResultado.setCodigoResultado(resulOp.OPE_ERROR);
                    vResultado.setMensajeError("La longitud de la descripcion es muy larga. Max 150 caracteres.");
                    utils.setADFMensajetoControl(vResultado,utils.getNomControlCliente(this.inpt_fileAdd));
                    
                }
            }
            catch(Exception eas){  eas.printStackTrace();
                vResultado.setCodigoResultado(resulOp.OPE_ERROR);
                vResultado.setMensajeError("HA OCURRIDO UN ERROR INESPERADO FAVOR REVISE.");
                utils.setADFMensajetoControl(vResultado,utils.getNomControlCliente(this.inpt_fileAdd));
            }
            }              
               
               
           }else{
               vResultado.setCodigoResultado(resulOp.OPE_ERROR);
               vResultado.setMensajeError("NO SE TIENEN TODOS LOS DATOS.");
               utils.setADFMensajetoControl(vResultado,utils.getNomControlCliente(this.inpt_fileAdd));
           }
           
        }else {
           vResultado.setCodigoResultado(resulOp.OPE_ERROR);
           vResultado.setMensajeError("NO SE TIENEN TODOS LOS DATOS.");
           utils.setADFMensajetoControl(vResultado,utils.getNomControlCliente(this.inpt_fileAdd));
        }
        
        
        
    }

    public void setDescrip(CoreInputText descrip) {
        this.descrip = descrip;
    }

    public CoreInputText getDescrip() {
        return descrip;
    }

    public void setSalir(CoreCommandButton salir) {
        this.salir = salir;
    }

    public CoreCommandButton getSalir() {
        return salir;
    }
}
