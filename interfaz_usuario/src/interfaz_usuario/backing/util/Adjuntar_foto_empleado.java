package interfaz_usuario.backing.util;

import enlace_datos.util.resulOp;

import interfaz_usuario.util.JSFUtils;
import interfaz_usuario.util.utils;

import java.util.HashMap;

import javax.faces.context.FacesContext;

import oracle.adf.view.faces.component.core.input.CoreInputFile;
import oracle.adf.view.faces.component.core.layout.CorePanelBox;
import oracle.adf.view.faces.component.core.layout.CorePanelHorizontal;
import oracle.adf.view.faces.component.core.nav.CoreCommandButton;
import oracle.adf.view.faces.component.core.output.CoreMessages;
import oracle.adf.view.faces.model.UploadedFile;

import pkg_carga_datos.carga_datos;

import pkg_util_base_datos.interfaz_DB;


public class Adjuntar_foto_empleado {

    private CoreInputFile inpt_fileAdd;
    private CoreMessages messages1;
    private CoreCommandButton btn_aniadir_foto;
    private CoreCommandButton btn_salir;
    private CorePanelBox panelBox1;
    private CorePanelHorizontal panelHorizontal1;
    
    public void setMessages1(CoreMessages messages1) {
        this.messages1 = messages1;
    }

    public CoreMessages getMessages1() {
        return messages1;
    }
    
    public void setInpt_fileAdd(CoreInputFile inpt_fileAdd) {
        this.inpt_fileAdd = inpt_fileAdd;
    }

    public CoreInputFile getInpt_fileAdd() {
        return inpt_fileAdd;
    }
    
    public void setBtn_aniadir_foto(CoreCommandButton btn_agregar_archivo) {
        this.btn_aniadir_foto = btn_agregar_archivo;
    }

    public CoreCommandButton getBtn_aniadir_foto() {
        return btn_aniadir_foto;
    }

    public void setBtn_salir(CoreCommandButton btn_salir) {
        this.btn_salir = btn_salir;
    }

    public CoreCommandButton getBtn_salir() {
        return btn_salir;
    }
    
    //función que valida el tipo de archivo que se pretende adjuntar
    private boolean validarTipoArchivo(UploadedFile vArchivoEntrada){
        boolean valido = false;
        carga_datos vCarga;
        Object idTipoDocumentoObj;
        String mensaje = "";
        //idTipoDocumentoObj = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.Documento_adjunto_idTipoArchivo.inputValue}"); 
        //if (idTipoDocumentoObj != null) {
            vCarga = new carga_datos();
            valido = vCarga.comprobarValidezTipoArchivoAdjunto(vArchivoEntrada.getContentType(),Integer.parseInt("3")); //el No.3 significa que es la foto del empleado
            if (valido == false) {
                mensaje = vCarga.getError();
                resulOp vResultado;
                vResultado=new resulOp();
                vResultado.setCodigoResultado(resulOp.OPE_ERROR);
                vResultado.setMensajeError(mensaje);
                utils.setADFMensajetoControl(vResultado,utils.getNomControlCliente(this.inpt_fileAdd));
                //JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.Documento_adjunto_mensaje.inputValue}" , mensaje);
                //this.getBtn_documento_adjunto_aceptar().setDisabled(true);
            }
        /*} else {
            mensaje = "No se pudo obtener el ID del tipo de archivo!! Reinicie la aplicación e intente de nuevo!!";
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.Documento_adjunto_mensaje.inputValue}" , mensaje);
            this.getBtn_documento_adjunto_aceptar().setDisabled(true);
        }*/
        return valido;
    }
    
    //función que valida el tamaño de la imagen añadir
    private boolean validarTamanioArchivo(UploadedFile vArchivoEntrada){
        boolean valido = true; //valor inicial
        long tamByteMaxArchivo=0; //valor inicial
        tamByteMaxArchivo=new Long(FacesContext.getCurrentInstance().getExternalContext().getInitParameter("TAMANIO_MAX_FOTO_EMPLEADO")); 
        if (vArchivoEntrada.getLength()>tamByteMaxArchivo){
            valido = false;
            resulOp vResultado;
            vResultado=new resulOp();
            vResultado.setCodigoResultado(resulOp.OPE_ERROR);
            vResultado.setMensajeError("EL TAMANIO DEL ARCHIVO ES MUY GRANDE. TAMANIO MAXIMO PERMITIDO:  "+ (tamByteMaxArchivo/1024) + " KB ");
            utils.setADFMensajetoControl(vResultado,utils.getNomControlCliente(this.inpt_fileAdd));
        }
        return valido;
    }
    
    private boolean eliminarFotosAnteriores(String pRegistro_empleado){
        boolean vResultadoBorrar = false;
        String sentencia = "delete sis_Archivo_Adjunto where registro_empleado = '" + pRegistro_empleado + "'";
        sentencia += " and id_tipo_archivo = 3 and fecha_baja is null";
        //System.out.println(sentencia);
        interfaz_DB vConec=new interfaz_DB();
        vConec.Crear_sentencia(sentencia);
        if (vConec.ejecutar_update(false)!=-1) {
            vResultadoBorrar=true;
        } 
        vConec.cn_Cerrar_coneccion();
        return vResultadoBorrar;
    }
    
    private void validarFoto(HashMap vParametros, UploadedFile file){
    resulOp vResultado;
    vResultado=new resulOp();
    boolean vResultado_carga;
    carga_datos vCarga;
    //Object vUsuarioObj;
    //String vUsuario;
    Object vRegistroEmpleadoObj;
    String vRegistroEmpleado;
    if ( validarTipoArchivo(file) == true ) {
    if ( validarTamanioArchivo(file) == true ) {
    try {
        //vUsuarioObj = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{flujo_usuario.selRegEmpleado_login}");
        //vUsuario = (String) vUsuarioObj;
        vRegistroEmpleadoObj = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{processScope.identificador}");
        vRegistroEmpleado = (String) vRegistroEmpleadoObj;
        //darDeBajaFotosHabilitadas(vUsuario, vRegistroEmpleado); //primero da de baja a los fotos habilitadas del empleado
        eliminarFotosAnteriores(vRegistroEmpleado);
        vCarga = new carga_datos(); //Se inicializa la clase que insertará en nuevo registro
        vResultado_carga = vCarga.Bol_Cargar_Archivo_Adjunto2(file, vParametros); //inserta el nuevo registro
        if (vResultado_carga==true){
            vResultado.setCodigoResultado(resulOp.OPE_OK);
            vResultado.setMensajeError("Foto <" + file.getFilename()+ "> cargado exitosamente.");
            this.getBtn_aniadir_foto().setDisabled(true); //Deshabilitamos el botón Aceptar.
        } else{ 
            vResultado.setCodigoResultado(resulOp.OPE_ERROR);
            vResultado.setMensajeError("Error al cargar <"+file.getFilename()+ ">. " + vCarga.getError());         
        }
        utils.setADFMensaje(vResultado);
    } catch(Exception eas){  
        eas.printStackTrace();
        vResultado.setCodigoResultado(resulOp.OPE_ERROR);
        vResultado.setMensajeError("HA OCURRIDO UN ERROR INESPERADO FAVOR REVISE.");
        utils.setADFMensajetoControl(vResultado,utils.getNomControlCliente(this.inpt_fileAdd));
    } 
    }
    }
    }
    
    public void validarArchivoSeleccionado(UploadedFile file) {
        HashMap vParametros;
        resulOp vResultado;
        Object vOpcionObj;
        Object vModuloOrigenObj;
        Object vRegistroEmpleadoObj;
        int vOpcion;
        String vModuloOrigen;
        String vRegistroEmpleado;
        if (file != null && file.getLength() > 0)   {   //Seleccionó un archivo
            vResultado=new resulOp();
            vModuloOrigenObj=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{processScope.Modulo}"); 
            vModuloOrigen=(vModuloOrigenObj!=null?vModuloOrigenObj.toString():"NINGUNO");
            vOpcionObj=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{processScope.Opcion}");
            if (vOpcionObj!=null){ // Si la pagina fue lanzada desde otra pagina con los parametros correctos
                vOpcion=(Integer)vOpcionObj;
                if (vOpcion==1){ // foto del empleado
                    vRegistroEmpleadoObj = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{processScope.identificador}");
                    vRegistroEmpleado = (String) vRegistroEmpleadoObj;
                    vParametros=new HashMap();  
                    vParametros.put("Modulo",vModuloOrigen);
                    vParametros.put("nomArchivo",file.getFilename());
                    vParametros.put("contentType",file.getContentType());
                    vParametros.put("Descripcion","Foto del Empleado");
                    vParametros.put("opcion",6); //Foto del empoleado
                    vParametros.put("CreadoPor",JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{flujo_usuario.selRegEmpleado_login}"));
                    vParametros.put("registro_empleado",vRegistroEmpleado);
                    validarFoto(vParametros, file);
                }
            }else {
                vResultado.setCodigoResultado(resulOp.OPE_ERROR);
                vResultado.setMensajeError("NO SE TIENEN TODOS LOS DATOS.");
                utils.setADFMensajetoControl(vResultado,utils.getNomControlCliente(this.inpt_fileAdd));
            }
        }
    }

    public String btn_aniadir_foto_action() {           
        UploadedFile myfile = (UploadedFile)this.getInpt_fileAdd().getValue();
        if (myfile != null && myfile.getLength() > 0) {
            validarArchivoSeleccionado(myfile);
        } 
        return null;
    }
    
    //Procedimiento que da de baja a las fotos habilitadas del empleado
    public boolean darDeBajaFotosHabilitadas(String pUsuario, String pRegistro_empleado){
        boolean vResultadoBorrar = false;
        String sentencia = "update sis_Archivo_Adjunto set baja_por = '" + pUsuario + "',";
        sentencia += " fecha_baja = sysdate where registro_empleado = '" + pRegistro_empleado + "'";
        sentencia += " and id_tipo_archivo = 3 and fecha_baja is null";
        interfaz_DB vConec=new interfaz_DB();
        vConec.Crear_sentencia(sentencia);
        if (vConec.ejecutar_update(false)!=-1) {
            vResultadoBorrar=true;
        } 
        vConec.cn_Cerrar_coneccion();
        return vResultadoBorrar;
    }
    
    public void setPanelBox1(CorePanelBox panelBox1) {
        this.panelBox1 = panelBox1;
    }

    public CorePanelBox getPanelBox1() {
        return panelBox1;
    }
    
    public void setPanelHorizontal1(CorePanelHorizontal panelHorizontal1) {
        this.panelHorizontal1 = panelHorizontal1;
    }

    public CorePanelHorizontal getPanelHorizontal1() {
        return panelHorizontal1;
    }

}
