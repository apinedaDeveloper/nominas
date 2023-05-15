package interfaz_usuario.backing.util;

import enlace_datos.util.resulOp;

import interfaz_usuario.util.JSFUtils;
import interfaz_usuario.util.utils;
import java.io.File;
import java.util.HashMap;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.faces.component.core.CoreForm;
import oracle.adf.view.faces.component.core.input.CoreInputFile;
import oracle.adf.view.faces.component.core.input.CoreInputText;
import oracle.adf.view.faces.component.core.layout.CorePanelBox;
import oracle.adf.view.faces.component.core.layout.CorePanelHorizontal;
import oracle.adf.view.faces.component.core.nav.CoreCommandButton;
import oracle.adf.view.faces.component.core.output.CoreMessages;
import oracle.adf.view.faces.component.core.output.CoreObjectSpacer;
import oracle.adf.view.faces.component.html.HtmlBody;
import oracle.adf.view.faces.component.html.HtmlHead;
import oracle.adf.view.faces.component.html.HtmlHtml;
import oracle.adf.view.faces.model.UploadedFile;

import pkg_carga_datos.archivo;
import pkg_carga_datos.carga_datos;

import pkg_util_base_datos.interfaz_DB;

public class Adjuntar_archivo {

    private CorePanelBox panelBox1;
    private CoreInputFile inpt_fileAdd;
    private CoreInputText descrip;
    private CoreInputText noDocRef;
    private CoreMessages messages1;
    private CorePanelHorizontal panelHorizontal1;
    private CoreCommandButton btn_agregar_archivo;
    private CoreCommandButton commandButton1;
    private CoreObjectSpacer objectSpacer1;
    private HtmlHtml html1;
    private HtmlHead head1;
    private HtmlBody body1;
    private CoreForm form1;


    //Método que realiza una validación más detallada del documento seleccionado
    private void validarArchivoSeleccionadoDetallado(String vStr_directorioCarga, String vModulo, int vOpcion, Object vIdProcedimientoObj, UploadedFile file, int pTipo) {
        //UploadedFile vArchivoEntrada;   
        carga_datos vCarga;
        boolean vResultado_carga;
        HashMap vParametros;
        //String  vVariable, vDescripcion;
        String vIdProcedimiento, vDescripcion;
        resulOp vResultado;
        vResultado=new resulOp();
        vIdProcedimiento = (String) vIdProcedimientoObj;
        //if (this.inpt_fileAdd.getValue()!=null){
        //vArchivoEntrada = (UploadedFile)valueChangeEvent.getNewValue();
        // Verifica si existe el directorio para la carga y si no lo crea
        boolean exists = (new File(vStr_directorioCarga)).exists();
        if (!exists) {
            (new File(vStr_directorioCarga)).mkdirs();
        }
        try {
            vCarga=new carga_datos();    
            vParametros=new HashMap();  
            vParametros.put("Modulo", vModulo);             
            vDescripcion = this.descrip.getValue()!=null ? (String)this.descrip.getValue():"";
            if (vDescripcion.length()<=150){
                vParametros.put("Directorio",vStr_directorioCarga);
                vParametros.put("nomArchivo", file.getFilename());
                vParametros.put("contentType", file.getContentType());
                vParametros.put("Descripcion", vDescripcion );
                vParametros.put("opcion", vOpcion);
                vParametros.put("CreadoPor",JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{flujo_usuario.selRegEmpleado_login}"));
                switch (vOpcion) {
                    case 1:  vParametros.put("idContrato", vIdProcedimiento); break;
                    case 2:  vParametros.put("idSolicitud", vIdProcedimiento);  break;
                    case 3:  vParametros.put("registro_empleado", vIdProcedimiento);break;
                    case 4:  vParametros.put("idVariacionNomina", vIdProcedimiento);break;
                    case 5:  vParametros.put("idAnexo", vIdProcedimiento);break;
                    case 7:  vParametros.put("idSolicitud", vIdProcedimiento); 
                             break;
                }
                if ( validarTamanioArchivo(vOpcion, file) == true ) {
                    vResultado_carga=vCarga.Bol_Cargar_Archivo_Adjunto2(file, vParametros);
                    if (vResultado_carga==true){
                        vResultado.setCodigoResultado(resulOp.OPE_OK);
                        vResultado.setMensajeError("Archivo <" + file.getFilename() + "> cargado exitosamente.");
                        this.getBtn_agregar_archivo().setDisabled(true); //Deshabilitamos el botón Aceptar.
                    } else {
                        vResultado.setCodigoResultado(resulOp.OPE_ERROR);
                        vResultado.setMensajeError("Error al cargar < " + file.getFilename()+ ">. " + vCarga.getError());         
                    }
                    utils.setADFMensaje(vResultado);
                }
            } else {
                vResultado.setCodigoResultado(resulOp.OPE_ERROR);
                vResultado.setMensajeError("La longitud de la descripcion es muy larga. Max 150 caracteres.");
                utils.setADFMensajetoControl(vResultado,utils.getNomControlCliente(this.inpt_fileAdd));
            }
        } catch(Exception eas) {  
            eas.printStackTrace();
            vResultado.setCodigoResultado(resulOp.OPE_ERROR);
            vResultado.setMensajeError("HA OCURRIDO UN ERROR INESPERADO, FAVOR REVISE.");
            utils.setADFMensajetoControl(vResultado,utils.getNomControlCliente(this.inpt_fileAdd));
        }
        //}  
    }
    
    //Método que realiza las validaciones iniciales del archivo Seleccionado.
    private void validarArchivoSeleccionado(UploadedFile file, int pTipo) {
        String vStr_directorioCarga;
        resulOp vResultado;
        vResultado=new resulOp();
        Object vValorTemp;
        int vOpcion;
        String vModulo;
        Object vDominio;  
        vDominio=JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.dominioApp");
        if (vDominio!=null && vDominio.toString().equals("nomina_usac")){
            resulOp vmensaje= new resulOp();
            vmensaje.setMensajeError("Adjuntar archivos desactivado: Ir nueva dirección: siif.usac.edu.gt/Nomina ");
            vmensaje.setCodigoResultado(resulOp.OPE_ERROR);        
            utils.setADFMensajetoControl(vmensaje,utils.getNomControlCliente(this.inpt_fileAdd));  
            return;
        }
        // Obteniendo el directorio para la carga del archivo
        vStr_directorioCarga=FacesContext.getCurrentInstance().getExternalContext().getInitParameter("ROOT_UPLOADS");
        vValorTemp = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{processScope.Modulo}"); 
        vModulo = (vValorTemp!=null?vValorTemp.toString():"NINGUNO");
        vValorTemp=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{processScope.Opcion}");
        if (vValorTemp!=null){ // Si la pagina fue lanzada desde otra pagina con los parametros respectivos
            vOpcion=(Integer)vValorTemp;
            if (vOpcion==1){ // Archivos para contrato
                vValorTemp=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{processScope.IdContrato}"); 
                vStr_directorioCarga=vStr_directorioCarga+FacesContext.getCurrentInstance().getExternalContext().getInitParameter("DIRECTORIO_DOC_CONTRATO");
            } else if (vOpcion==2 || vOpcion == 7){ //Archivos para la solicitud
                vValorTemp=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{processScope.IdSolicitud}"); 
                vStr_directorioCarga=vStr_directorioCarga+FacesContext.getCurrentInstance().getExternalContext().getInitParameter("DIRECTORIO_DOCS_SOLITUD");
            } else if (vOpcion==3){ //Archivos para el empleado
                vValorTemp=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{processScope.identificador}"); 
                vStr_directorioCarga=vStr_directorioCarga+FacesContext.getCurrentInstance().getExternalContext().getInitParameter("DIRECTORIO_DOCS_EMPL");
            } else if (vOpcion==4){ //Archivos para la variacion nomina
                vValorTemp=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{processScope.IdVariacionNom}");     
                vStr_directorioCarga=vStr_directorioCarga+FacesContext.getCurrentInstance().getExternalContext().getInitParameter("DIRECTORIO_DOCS_VARIANOM");
            } else if (vOpcion==5){ //Archivos para el anexo
                vValorTemp=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{processScope.IdAnexo}");     
                vStr_directorioCarga=vStr_directorioCarga+FacesContext.getCurrentInstance().getExternalContext().getInitParameter("DIRECTORIO_DOCS_ANEXO");
            } else {
                vValorTemp =  null;
            }
            if (vValorTemp!=null){//Los parametros estan completos, ejecutar la carga del archivo 
                validarArchivoSeleccionadoDetallado(vStr_directorioCarga, vModulo, vOpcion, vValorTemp, file, pTipo);
            } else {
                vResultado.setCodigoResultado(resulOp.OPE_ERROR);
                vResultado.setMensajeError("NO SE TIENEN TODOS LOS DATOS.");
                utils.setADFMensajetoControl(vResultado,utils.getNomControlCliente(this.inpt_fileAdd));
            }    
        } else {
            vResultado.setCodigoResultado(resulOp.OPE_ERROR);
            vResultado.setMensajeError("NO SE TIENEN TODOS LOS DATOS.");
            utils.setADFMensajetoControl(vResultado,utils.getNomControlCliente(this.inpt_fileAdd));
        }
    }
        
    public String btn_adjuntar_archivo_action() {
        UploadedFile myfile = (UploadedFile) this.getInpt_fileAdd().getValue();
        if ( myfile != null ) {
            validarArchivoSeleccionado(myfile,0);
        }
        return null;
    }
    
    public String btn_adjuntar_archivo_doc_action() {
        UploadedFile myfile = (UploadedFile) this.getInpt_fileAdd().getValue();
        if ( myfile != null ) {
            validarArchivoSeleccionado(myfile,1);
        }
        return null;
    }
    
    //función que verifica el tamaño del archivo a adjuntar
    private boolean validarTamanioArchivo(int vOpcion, UploadedFile vArchivoEntrada){
        boolean valido = false; //valor inicial
        long tamByteMaxArchivo=0; //valor inicial
        tamByteMaxArchivo=new Long(FacesContext.getCurrentInstance().getExternalContext().getInitParameter("TAMANIO_MAX_DOC_ADJUNTO")); 
        if (vArchivoEntrada.getLength() <= tamByteMaxArchivo){
            valido = true;
        } else {
            resulOp vResultado;
            vResultado=new resulOp();
            vResultado.setCodigoResultado(resulOp.OPE_ERROR);
            vResultado.setMensajeError("EL TAMANIO DEL ARCHIVO ES MUY GRANDE. TAMANIO MAXIMO PERMITIDO:  "+ (tamByteMaxArchivo/1024) + " KB ");
            utils.setADFMensajetoControl(vResultado,utils.getNomControlCliente(this.inpt_fileAdd));
        }
        return valido;
    }
    
    /*public void inpt_file_change_action(ValueChangeEvent valueChangeEvent) {
        String vStr_directorioCarga;
        UploadedFile vArchivoEntrada;   
        carga_datos vCarga;
         
        boolean vResultado_carga;
        HashMap vParametros;
        String  vVariable,vDescripcion;
        resulOp vResultado;
        vResultado=new resulOp();
        Object vValorTemp,vValorTemp2;
        int vOpcion;
        String vModulo;
        // String pTipoArchivo[];
         
        Object vDominio;  
           
        vDominio=JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.dominioApp");
                 

        if (vDominio!=null && vDominio.toString().equals("nomina_usac")){
            resulOp vmensaje= new resulOp();
            vmensaje.setMensajeError("Adjuntar archivos desactivado: Ir nueva dirección: siif.usac.edu.gt/Nomina ");
            vmensaje.setCodigoResultado(resulOp.OPE_ERROR);        
            utils.setADFMensajetoControl(vmensaje,utils.getNomControlCliente(this.inpt_fileAdd));  
            return;
        }
         
        // Obteniendo el directorio para la carga del archivo
        vStr_directorioCarga=FacesContext.getCurrentInstance().getExternalContext().getInitParameter("ROOT_UPLOADS");
        vValorTemp2=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{processScope.Modulo}"); 
        vModulo=(vValorTemp2!=null?vValorTemp2.toString():"NINGUNO");
         
         
        vValorTemp=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{processScope.Opcion}");
        if (vValorTemp!=null){ // Si la pagina fue lanzada desde otra pagina con los parametros respectivos
            vOpcion=(Integer)vValorTemp;
            //vValorTemp=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{processScope.Opcion}");
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
            }else if (vOpcion==6){ //Foto del empleado
                vValorTemp=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{processScope.identificador}");     
                vStr_directorioCarga=vStr_directorioCarga+FacesContext.getCurrentInstance().getExternalContext().getInitParameter("DIRECTORIO_DOCS_EMPL");
            }
            if (vValorTemp!=null){//Los parametros estan completos, ejecutar la carga del archivo 
             
                vVariable=(String)vValorTemp;
             
                if (this.inpt_fileAdd.getValue()!=null){
                     
                    vArchivoEntrada = (UploadedFile)valueChangeEvent.getNewValue();
             
                    //System.out.println(" tipo  "+vArchivoEntrada.getContentType());
                 
                    // Verifica si existe el directorio para la carga y si no lo crea
                    boolean exists = (new File(vStr_directorioCarga)).exists();
                    if (!exists) {
                        (new File(vStr_directorioCarga)).mkdirs();
                    }
             
                    vCarga=new carga_datos();    
                    vParametros=new HashMap();  
                    
                    vParametros.put("Modulo",vModulo);             
              
              
                    try {
                     
                        vDescripcion=this.descrip.getValue()!=null?(String)this.descrip.getValue():"";
                        //pTipoArchivo=vArchivoEntrada.getContentType().split("\\/");
                     
                     
                        if (vDescripcion.length()<=150){
                            vParametros.put("Directorio",vStr_directorioCarga);
                            vParametros.put("nomArchivo",vArchivoEntrada.getFilename());
                            vParametros.put("contentType",vArchivoEntrada.getContentType());
                            vParametros.put("Descripcion",this.descrip.getValue());
                            vParametros.put("opcion",vOpcion);
                            vParametros.put("CreadoPor",JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{flujo_usuario.selRegEmpleado_login}"));
        
        
                            switch (vOpcion) {
        
                                case 1:  vParametros.put("idContrato",vVariable); break;
                                case 2:  vParametros.put("idSolicitud",vVariable);  break;
                                case 3:  vParametros.put("registro_empleado",vVariable);break;
                                case 4:  vParametros.put("idVariacionNomina",vVariable);break;
                                case 5:  vParametros.put("idAnexo",vVariable);break;
                                case 6:  vParametros.put("registro_empleado",vVariable);break; //Foto del empleado
                            }
                            if ( validarTamanioArchivo(vOpcion, vArchivoEntrada, vResultado) == true ) {
                                vResultado_carga=vCarga.Bol_Cargar_Archivo_Adjunto2(vArchivoEntrada,vParametros);
                
                            
                                this.descrip.setValue("");
                                if (vResultado_carga==true){
                                    vResultado.setCodigoResultado(resulOp.OPE_OK);
                                    vResultado.setMensajeError("Archivo <"+vArchivoEntrada.getFilename()+ "> cargado exitosamente.");
                                    this.getBtn_agregar_archivo().setDisabled(true); //Deshabilitamos el botón Aceptar.
                                                    }
                        else{ 
                                    vResultado.setCodigoResultado(resulOp.OPE_ERROR);
                                    vResultado.setMensajeError("Error al cargar <"+vArchivoEntrada.getFilename()+ ">. " + vCarga.getError());         
                                }
             
                                utils.setADFMensaje(vResultado);
                            }
                        } else {
                     
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
         
         
    }*/


    public void setPanelBox1(CorePanelBox panelBox1) {
        this.panelBox1 = panelBox1;
    }

    public CorePanelBox getPanelBox1() {
        return panelBox1;
    }

    public void setInpt_fileAdd(CoreInputFile inpt_fileAdd) {
        this.inpt_fileAdd = inpt_fileAdd;
    }

    public CoreInputFile getInpt_fileAdd() {
        return inpt_fileAdd;
    }

    public void setDescrip(CoreInputText descrip) {
        this.descrip = descrip;
    }

    public CoreInputText getDescrip() {
        return descrip;
    }


    public void setMessages1(CoreMessages messages1) {
        this.messages1 = messages1;
    }

    public CoreMessages getMessages1() {
        return messages1;
    }


    public void setPanelHorizontal1(CorePanelHorizontal panelHorizontal1) {
        this.panelHorizontal1 = panelHorizontal1;
    }

    public CorePanelHorizontal getPanelHorizontal1() {
        return panelHorizontal1;
    }

    public void setBtn_agregar_archivo(CoreCommandButton btn_agregar_archivo) {
        this.btn_agregar_archivo = btn_agregar_archivo;
    }

    public CoreCommandButton getBtn_agregar_archivo() {
        return btn_agregar_archivo;
    }

    public void setCommandButton1(CoreCommandButton commandButton1) {
        this.commandButton1 = commandButton1;
    }

    public CoreCommandButton getCommandButton1() {
        return commandButton1;
    }

    public void setObjectSpacer1(CoreObjectSpacer objectSpacer1) {
        this.objectSpacer1 = objectSpacer1;
    }

    public CoreObjectSpacer getObjectSpacer1() {
        return objectSpacer1;
    }
    
    public boolean eliminarArchivoAdjunto(String pNomArchivo,String pId,String pUsuario,boolean pDelOfTable){
        boolean vResultadoBorrar=false;
        archivo vArch=new archivo(pNomArchivo);
        interfaz_DB vConec=new interfaz_DB();
        
         if (pDelOfTable==false){  // baja logica 
            vConec.Crear_sentencia("update sis_Archivo_Adjunto set baja_por='"+pUsuario+"' where id_archivo_adjunto="+pId);
            if (vConec.ejecutar_update(false)!=-1)
                vResultadoBorrar=true;
           
            
         }else{ //borrado del registro
          vConec.Crear_sentencia("delete sis_Archivo_Adjunto where id_archivo_adjunto="+pId);
             if (vConec.ejecutar_update(false)!=-1)
                 vResultadoBorrar=true;
         }
            
         if (vResultadoBorrar==true){
             if (vArch.borrar()){
                 vConec.commit();
             }else{
                 vConec.rollback();   
                 vResultadoBorrar=false;
             }            
         }
        vConec.cn_Cerrar_coneccion();
        return vResultadoBorrar;
    }


    public void setHtml1(HtmlHtml html1) {
        this.html1 = html1;
    }

    public HtmlHtml getHtml1() {
        return html1;
    }

    public void setHead1(HtmlHead head1) {
        this.head1 = head1;
    }

    public HtmlHead getHead1() {
        return head1;
    }

    public void setBody1(HtmlBody body1) {
        this.body1 = body1;
    }

    public HtmlBody getBody1() {
        return body1;
    }

    public void setForm1(CoreForm form1) {
        this.form1 = form1;
    }

    public CoreForm getForm1() {
        return form1;
    }

    public void setNoDocRef(CoreInputText noDocRef) {
        this.noDocRef = noDocRef;
    }

    public CoreInputText getNoDocRef() {
        return noDocRef;
    }
}
