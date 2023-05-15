package interfaz_usuario.backing.gestiones;

import enlace_datos.util.resulOp;

import interfaz_usuario.backing.util.Adjuntar_archivo;

import interfaz_usuario.util.JSFUtils;
import interfaz_usuario.util.utils;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import javax.servlet.http.HttpSession;

import oracle.adf.view.faces.component.core.CoreForm;
import oracle.adf.view.faces.component.core.data.CoreTable;
import oracle.adf.view.faces.component.core.input.CoreInputFile;
import oracle.adf.view.faces.component.core.input.CoreInputText;
import oracle.adf.view.faces.component.core.input.CoreSelectBooleanCheckbox;
import oracle.adf.view.faces.component.core.input.CoreSelectOneChoice;
import oracle.adf.view.faces.component.core.layout.CorePanelForm;
import oracle.adf.view.faces.component.core.nav.CoreCommandButton;
import oracle.adf.view.faces.component.core.output.CoreMessage;
import oracle.adf.view.faces.component.core.output.CoreMessages;
import oracle.adf.view.faces.component.core.output.CoreOutputFormatted;
import oracle.adf.view.faces.event.DisclosureEvent;
import oracle.adf.view.faces.event.LaunchEvent;
import oracle.adf.view.faces.model.UploadedFile;
import oracle.adf.view.faces.util.LabeledFacesMessage;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.JboException;
import oracle.jbo.Row;
import oracle.jbo.domain.Date;
import oracle.jbo.uicli.binding.JUCtrlValueBindingRef;
import oracle.jbo.uicli.binding.JUIteratorBinding;

import pkg_carga_datos.carga_datos;


public class ficha_empleado {
    private boolean vCambioNivelAcademico = false;
    private CoreSelectOneChoice cmb_institucionAca;
    private CoreSelectOneChoice cmb_NivelAcademico;
    private List<SelectItem> vListaItemsCheck;
    private CoreMessages outputMensajes;
    private CorePanelForm pnl_form1;
    private CoreSelectOneChoice cmb_munDirec;
    private CoreSelectOneChoice cmb_municipioCed;
    private CoreSelectOneChoice cmb_munDirecF;
    private CoreSelectBooleanCheckbox chk_cedula;
    private CoreSelectBooleanCheckbox chk_cui;
    private CoreSelectBooleanCheckbox chk_nit;
    private CoreSelectBooleanCheckbox chk_igss;
    private CoreCommandButton btn_referencia_verificar;
    private CoreCommandButton btn_referencia_nuevo;
    private CoreCommandButton btn_referencia_aceptar;
    private CoreCommandButton btn_referencia_cancelar;
    private CoreCommandButton btn_experiencia_verificar;
    private CoreCommandButton btn_experiencia_lab_nuevo;
    private CoreCommandButton btn_experiencia_aceptar;
    private CoreCommandButton btn_experiencia_cancelar;
    private CoreCommandButton btn_documento_adjunto_verificar;
    private CoreCommandButton btn_documento_adjunto_aceptar;
    private CoreSelectOneChoice cmb_tipos_documentos_adjuntos;
    private CoreInputFile inptFile_documento_adjunto;
    private CoreCommandButton btn_documento_adjunto_nuevo;
    private CoreCommandButton btn_documento_adjunto_cancelar;
    private CoreOutputFormatted outputFormatDocumentoID;
    private CoreTable sis_documentos_adjuntos_table;
    private CoreForm form1;
    private CoreMessages messagesDocumentosAdjuntos;
    private CoreMessage messageDocumentoAdjunto;
    private CorePanelForm pnlFormDocumentosAdjuntos;
    private CoreOutputFormatted outputFormatDocumentoMsgEditable;
    private CorePanelForm pnlFormDocumentosAdjuntosAreaEdicion;
    private CorePanelForm pnlFormDocumentosAdjuntoInputFile;
    private FacesContext fctx;
    private ExternalContext ectx;
    private HttpSession userSession;
    private CoreTable sis_foto_empleado_table;
    private CoreCommandButton btn_imprimirCV;
    private CoreTable sis_referencias_empleado_table;
    private CoreTable sis_experiencias_empleado_table;
    private CoreCommandButton btn_guardar_datos_personales;
    private CoreCommandButton btn_guardar_paso5;
    private CoreInputFile inptFile_foto_empleado;
    private CoreCommandButton btn_foto_empleado_cancelar;
    private CoreMessages messagesFotoAdjunto;
    private CoreCommandButton btn_foto_empleado_comprobar;
    private CoreCommandButton btn_foto_empleado_guardar;
    private CoreCommandButton btn_foto_empleado_adjuntar;
    private CoreCommandButton btn_cancelar_paso5;
    private CoreInputText inptText_nombre_referencia_pers;
    private CoreInputText inptText_telefono_referencia_pers;
    private CoreInputText inptText_email_referencia_pers;
    private CoreInputText inptText_email_institucional;

    public List<SelectItem> getListOfValuesCheck() {
        return vListaItemsCheck;
    }

    public boolean getCambioNivelAcademico() {
        return this.vCambioNivelAcademico;
    }

    public ficha_empleado() {
        vListaItemsCheck = 
                utils.crearListaManyCheck("SisTipoJubiladoVwIterator", 
                                          "IdTipoJubilado", 
                                          "NombreTipjubilado");
        fctx = FacesContext.getCurrentInstance();
        ectx = fctx.getExternalContext();
        userSession = (HttpSession)ectx.getSession(true);
    }

    public static boolean ValidarMail(String email) {
        // Patron para validar el email
        Pattern pattern = 
            Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = pattern.matcher(email);
        return mather.find();
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

    //procesa el botón guardar del paso 1

    private void procesar_boton_guardar() {
        BindingContainer vBnd_binding;
        OperationBinding operationBinding;
        Object result;
        resulOp vResultado = new resulOp();
        boolean vResultadoOps = false;
        try {
            vBnd_binding = 
                    (BindingContainer)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                                                 "#{bindings}");
            operationBinding = vBnd_binding.getOperationBinding("Commit");
            result = operationBinding.execute();
            if (operationBinding.getErrors().isEmpty()) {
                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                         "actFichaEmpleado");
                vResultado.setMensajeError("Datos actualizados exitosamente.");
                vResultado.setCodigoResultado(resulOp.OPE_OK);
                utils.setADFMensaje(vResultado);
                JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                            "#{flujo_usuario.actualizaDatosConfronta}", 
                                            "");
                vResultadoOps = true;
            } else { // Ocurrio algun error
                AgregarErroresControl(operationBinding.getErrors());
            }
        } catch (Exception exep) {
            exep.printStackTrace();
            System.out.println(exep.getMessage());
            vResultado.setCodigoResultado(resulOp.OPE_ERROR);
            vResultado.setMensajeError("Ha ocurrido un error inesperado. Por favor revise. " + 
                                       exep.getMessage());
            utils.setADFMensaje(vResultado);
        }
    }

    public String btn_guardar_action() {
        if (verificarCorreoElectronicoInstitucional()) {
            procesar_boton_guardar();
        } else {
            mensaje("Verifique casilla de Correo Electrónico Institucional, tiene que ser de la Universidad.", 
                    3);
        }
        return null;
    }

    public void AgregarErroresControl(List pErrores) {
        int vCantidadErrores = pErrores.size();
        JboException vError;
        String vIdComponente;
        FacesMessage vMessage;
        for (int vContador = 0; vContador < vCantidadErrores; vContador++) {

            if (pErrores.get(vContador).getClass() == JboException.class) {

                vError = (JboException)pErrores.get(vContador);
                vIdComponente = 
                        BuscarIdPaginaComponente(this.pnl_form1, vError.getErrorCode());

                if (vIdComponente != null && !vIdComponente.equals("")) {
                    //  System.out.println("Agregando a control");
                    vMessage = 
                            new FacesMessage(FacesMessage.SEVERITY_ERROR, vError.getMessage(), 
                                             null);
                    FacesContext.getCurrentInstance().addMessage(vIdComponente, 
                                                                 vMessage);
                }

            }
        }
    }

    public String BuscarIdPaginaComponente(CorePanelForm pForma, 
                                           String pIdComponente) {
        Object vCompo;
        String vId = null;
        vCompo = pForma.findComponent("inpt_" + pIdComponente.toLowerCase());
        if (vCompo == null) {
            vCompo = 
                    pForma.findComponent("cmb_" + pIdComponente.toLowerCase());
        }

        if (vCompo == null) {
            vCompo = 
                    pForma.findComponent("chk_" + pIdComponente.toLowerCase());
        }

        if (vCompo == null) {
            vCompo = 
                    pForma.findComponent("sel_" + pIdComponente.toLowerCase());
        }

        if (vCompo != null) {
            vId = utils.getNomControlCliente(vCompo);
        }

        return vId;
    }

    public void VerificarErrores() {
        FacesContext context = FacesContext.getCurrentInstance();
        Object vFila;
        Iterator<String> clients = context.getClientIdsWithMessages();
        String vIdComponente;

        FacesMessage vMessage;
        while (clients.hasNext()) {
            String clientId = clients.next();
            Iterator messages = context.getMessages(clientId);
            while (messages.hasNext()) {
                vFila = messages.next();

                if (vFila != null && 
                    (clientId == null || (clientId != null && clientId.equals(""))) && 
                    vFila.getClass() == LabeledFacesMessage.class) {

                    //vIdComponente=BuscarIdPaginaComponente(this.pnl_form1,)

                    //vMessage.setLabel(((LabeledFacesMessage)vFila).getLabel());

                    vIdComponente = 
                            BuscarIdPaginaComponente(this.pnl_form1, ((LabeledFacesMessage)vFila).getLabel().toString());
                    if (vIdComponente != null && !vIdComponente.equals("")) {
                        vMessage = 
                                new FacesMessage(((LabeledFacesMessage)vFila).getSeverity(), 
                                                 ((LabeledFacesMessage)vFila).getSummary(), 
                                                 null);
                        FacesContext.getCurrentInstance().addMessage(vIdComponente, 
                                                                     vMessage);
                        //  messages.remove();
                        //  System.out.println("Quitando");
                    }

                } else if (vFila != null && clientId != null && 
                           !clientId.equals("") && 
                           vFila.getClass() == LabeledFacesMessage.class) {
                    vMessage = 
                            new FacesMessage(((LabeledFacesMessage)vFila).getSeverity(), 
                                             ((LabeledFacesMessage)vFila).getSummary(), 
                                             null);
                    FacesContext.getCurrentInstance().addMessage(clientId, 
                                                                 vMessage);
                    // messages.notify();
                    //  messages.remove();


                    // System.out.println("Quitando2");
                    break;
                }

            }
        }

    }

    public void setCmb_institucionAca(CoreSelectOneChoice cmb_institucionAca) {
        this.cmb_institucionAca = cmb_institucionAca;
    }

    public CoreSelectOneChoice getCmb_institucionAca() {
        return cmb_institucionAca;
    }

    public void setCmb_NivelAcademico(CoreSelectOneChoice cmb_NivelAcademico) {
        this.cmb_NivelAcademico = cmb_NivelAcademico;
    }

    public CoreSelectOneChoice getCmb_NivelAcademico() {
        return cmb_NivelAcademico;
    }

    public void cmb_NivelAcademico_action(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue() != null && 
            valueChangeEvent.getOldValue() != null) {
            //El valor nuev y el valor viejo no son nulos
            if (!valueChangeEvent.getNewValue().toString().equals(valueChangeEvent.getOldValue().toString())) {
                this.cmb_institucionAca.setSubmittedValue(0); //Cambió su nivel académico.
                this.vCambioNivelAcademico = true;
            }
        } else if (valueChangeEvent.getNewValue() != null) {
            //Al menos el valor nuevo no es nulo
            this.cmb_institucionAca.setSubmittedValue(0);
            this.vCambioNivelAcademico = true;
        }
    }

    /*
 *  PARA LA CONFRONTACION DE DATOS
 */

    public boolean verificarConfrontacionDatos() {

        String vValor;

        try {

            vValor = this.getChk_cedula().getText();
            if (vValor != null) {
                if (this.getChk_cedula().isSelected() == false) {
                    utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR, 
                                                    "Por favor verifique el No. cédula"));
                    return false;
                }
            }

            vValor = this.getChk_cui().getText();
            if (vValor != null) {
                if (this.getChk_cui().isSelected() == false) {
                    utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR, 
                                                    "Por favor verifique el DPI"));
                    return false;
                }
            }

            vValor = this.getChk_nit().getText();
            if (vValor != null) {
                if (this.getChk_nit().isSelected() == false) {
                    utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR, 
                                                    "Por favor verifique el No. NIT"));
                    return false;
                }
            }


            vValor = this.getChk_igss().getText();
            if (vValor != null) {
                if (this.getChk_igss().isSelected() == false) {
                    utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR, 
                                                    "Por favor verifique el No. de afiliación al IGSS"));
                    return false;
                }
            }

        } catch (Exception exep) {
            return false;
        }

        return true;
    }

    public String btn_aprobar_action() {


        if (verificarConfrontacionDatos()) {
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                        "#{bindings.Aprobado.inputValue}", 
                                        "SI");
            resulOp vResultado = new resulOp();
            boolean vResultadoOps = false;

            try {

                if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(), 
                                              "Commit")) {

                    vResultado.setMensajeError("Sistema nomina actualizado correctamente.");

                    vResultado.setCodigoResultado(resulOp.OPE_OK);
                    utils.setADFMensaje(vResultado);
                    vResultadoOps = true;

                }

            } catch (Exception exep) {
                exep.printStackTrace();
            }
        }
        return null;
    }


    public void shw_item_otraIns_NO(DisclosureEvent disclosureEvent) {
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                    "#{bindings.OtroTrabajo.inputValue}", 
                                    "NO");
    }

    public void shw_item_otraIns_SI(DisclosureEvent disclosureEvent) {
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                    "#{bindings.OtroTrabajo.inputValue}", 
                                    "SI");
    }

    public void launch_archAdjunto(LaunchEvent launchEvent) {
        launchEvent.getDialogParameters().put("identificador", 
                                              JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                                                         "#{bindings.RegistroEmpleado.inputValue}").toString());
        launchEvent.getDialogParameters().put("Opcion", 3);

    }

    /*public void return_arch_adjunto(ReturnEvent returnEvent) {
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), "Execute");

    }*/

    public String btn_borrar_action() {

        Adjuntar_archivo vBorrado = new Adjuntar_archivo();
        String vNomArchivo;
        String vIdArchivoAdjunto;
        vNomArchivo = 
                FacesContext.getCurrentInstance().getExternalContext().getInitParameter("DIRECTORIO_DOC_CONTRATO");

        vNomArchivo += 
                JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                           "#{sessionScope.NomArchivo}").toString();
        vIdArchivoAdjunto = 
                JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                           "#{sessionScope.IdArchivoAdjunto}").toString();

        if (vBorrado.eliminarArchivoAdjunto(vNomArchivo, vIdArchivoAdjunto, 
                                            utils.getUsuario(), false)) {
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                     "Execute");
            //   System.out.println("actualizando borrado ");
        }

        //System.out.println("borrando " + vNomArchivo + "  ,  "  +vIdArchivoAdjunto);
        //vBorrado.eliminarArchivoAdjunto();

        return null;
    }

    public void setOutputMensajes(CoreMessages outputMensajes) {
        this.outputMensajes = outputMensajes;
    }

    public CoreMessages getOutputMensajes() {
        return outputMensajes;
    }

    public void setPnl_form1(CorePanelForm pnl_form1) {
        this.pnl_form1 = pnl_form1;
    }

    public CorePanelForm getPnl_form1() {
        return pnl_form1;
    }

    public void cmb_depDirec(ValueChangeEvent valueChangeEvent) {

        try {

            if (!valueChangeEvent.getNewValue().toString().equals(valueChangeEvent.getOldValue().toString())) {
                this.cmb_munDirec.setSubmittedValue(0);

            }

        } catch (Exception exep) {
            System.out.println(exep.getMessage());
        }

    }

    public void setCmb_munDirec(CoreSelectOneChoice cmb_munDirec) {
        this.cmb_munDirec = cmb_munDirec;
    }

    public CoreSelectOneChoice getCmb_munDirec() {
        return cmb_munDirec;
    }

    public void cmb_orden_departamento(ValueChangeEvent valueChangeEvent) {

        //Object v[];

        try {
            if (valueChangeEvent.getNewValue() != null && 
                valueChangeEvent.getOldValue() != null) {
                if (!valueChangeEvent.getNewValue().toString().equals(valueChangeEvent.getOldValue().toString())) {
                    // this.cmb_municipioCed.setSubmittedValue(0);                      
                    //     v=(Object [])JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.municipio_by_ordcedIterator.allRowsInRange}");
                    //    System.out.println("debug" + v.length);                             
                }
            }

        } catch (Exception exep) {
            System.out.println(exep.getMessage());
        }
    }

    public void setCmb_municipioCed(CoreSelectOneChoice cmb_municipioCed) {
        this.cmb_municipioCed = cmb_municipioCed;
    }

    public CoreSelectOneChoice getCmb_municipioCed() {
        return cmb_municipioCed;
    }

    public void cmb_depDirecF(ValueChangeEvent valueChangeEvent) {
        try {

            if (!valueChangeEvent.getNewValue().toString().equals(valueChangeEvent.getOldValue().toString())) {
                this.cmb_munDirecF.setSubmittedValue(0);

            }

        } catch (Exception exep) {
            System.out.println(exep.getMessage());
        }

    }

    public void setCmb_munDirecF(CoreSelectOneChoice cmb_munDirecF) {
        this.cmb_munDirecF = cmb_munDirecF;
    }

    public CoreSelectOneChoice getCmb_munDirecF() {
        return cmb_munDirecF;
    }

    public void setChk_cedula(CoreSelectBooleanCheckbox chk_cedula) {
        this.chk_cedula = chk_cedula;
    }

    public CoreSelectBooleanCheckbox getChk_cedula() {
        return chk_cedula;
    }

    public void setChk_cui(CoreSelectBooleanCheckbox chk_cui) {
        this.chk_cui = chk_cui;
    }

    public CoreSelectBooleanCheckbox getChk_cui() {
        return chk_cui;
    }

    public void setChk_nit(CoreSelectBooleanCheckbox chk_nit) {
        this.chk_nit = chk_nit;
    }

    public CoreSelectBooleanCheckbox getChk_nit() {
        return chk_nit;
    }

    public void setChk_igss(CoreSelectBooleanCheckbox chk_igss) {
        this.chk_igss = chk_igss;
    }

    public CoreSelectBooleanCheckbox getChk_igss() {
        return chk_igss;
    }

    public String btn_rep_confC() {
        Object vFormulario;
        vFormulario = 
                JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                           "#{bindings.NoFormulario.inputValue}");
        JSFUtils.storeOnSession(FacesContext.getCurrentInstance(), 
                                "pIdFormulario", vFormulario);
        return null;
    }

    public String btn_imprimir() {
        Object vFormulario;
        vFormulario = 
                JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                           "#{bindings.NoFormulario.inputValue}");
        JSFUtils.storeOnSession(FacesContext.getCurrentInstance(), 
                                "pIdFormulario", vFormulario);
        return null;
    }

    public String cambiar_cuenta() {
        // Add event code here...

        // System.out.println("realizando cambio");
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(), 
                                      "cambiarCuenta")) {

            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                     "exeCuenta");

            utils.setADFMensaje(new resulOp(resulOp.OPE_OK, 
                                            "Se ha cambiado el número de cuenta!"));

        }


        return null;
    }

    //Método que muestra un mensaje en la pantalla. Tipos de Alerta: 1=INFO, 2=ADVERTENCIA y 3=ERROR

    private void mensaje(String messageText, int tipoAlerta) {
        FacesMessage fm = new FacesMessage(messageText);
        if (tipoAlerta == 1) {
            fm.setSeverity(FacesMessage.SEVERITY_INFO);
        } else if (tipoAlerta == 2) {
            fm.setSeverity(FacesMessage.SEVERITY_WARN);
        } else {
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
        }
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, fm);
    }

    public String btn_imprimirCV_action() {
        return null;
    }

    //Método que setea valores a los bindings del procedimiento agregar referencias personales antes de ser grabados

    public void setearValoresBindings_referencias_personales(String registroEmpleado) {
        Object idReferenciaPersonal;
        String mensaje = 
            "¡¡Referencia personal comprobada correctamente!! Presione el botón Guardar.";
        idReferenciaPersonal = 
                JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                           "#{bindings.Referencia_personal_idReferenciaFichaEmpl.inputValue}");
        Object esNuevaReferencia = userSession.getAttribute("esNuevaReferencia");
        //if (idReferenciaPersonal == null || 
            //idReferenciaPersonal.toString().equalsIgnoreCase("") == true) {
        if (esNuevaReferencia != null && 
                esNuevaReferencia.toString().equalsIgnoreCase("true")) { //Es nueva referencia
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                        "#{bindings.Referencia_personal_idFichaEmpleado.inputValue}", 
                                        utils.getNumberOracle(registroEmpleado));
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                        "#{bindings.Referencia_personal_idReferenciaTipo.inputValue}", 
                                        utils.getNumberOracle("1"));
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                        "#{bindings.Referencia_personal_creadoPor.inputValue}", 
                                        utils.getUsuario());
        } //else { //se trata de un registro existente a ser modificado
            //JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.Referencia_personal_modificadoPor.inputValue}" , utils.getUsuario());
        //}
        this.getBtn_referencia_nuevo().setDisabled(true); //Botón Nueva Referencia Personal
        this.getBtn_referencia_verificar().setDisabled(true); //Botón Comprobar Referencia Personal
        this.getBtn_referencia_aceptar().setDisabled(false); //Botón Guardar
        mensaje(mensaje, 1); // 1 = tipo INFO
    }
    
    //Método que comprueba la validez de la referenrecia personal ingresada

    private void comprobar_referencia_personal(String registroPersonal) {
        Object estatusCommitObj;
        estatusCommitObj = 
                JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                           "#{bindings.commit.enabled}");
        if (estatusCommitObj != null) { //El objeto commit está activo.
            setearValoresBindings_referencias_personales(registroPersonal);
        }
    }

    //Botón Comprobar Referencia Personal

    public String btn_referencia_verificar_action() {
        Object registroPersonalObj;
        registroPersonalObj = 
                JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                           "#{bindings.RegistroEmpleado.inputValue}");
        if (registroPersonalObj != null) {
            //Está correcto, se procede a comprobar 
            comprobar_referencia_personal(registroPersonalObj.toString());
        }
        return null;
    }

    //Botón Guardar Referencia Personal

    public String btn_referencia_aceptar_action() {
        String mensaje = "¡¡Referencia personal guardada correctamente!!";
        mensaje(mensaje, 1); // 1 = tipo INFO
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                 "Exe_referencias_empleado"); //actualizamos ambas tablas
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                 "Exe_experiencias_empleado");
        //Area de Referencia Personal
        this.getBtn_referencia_aceptar().setDisabled(true); //Botón Guardar Referencia
        this.getBtn_referencia_nuevo().setDisabled(false); //Botón Nueva Referencia Personal
        this.getBtn_referencia_verificar().setDisabled(false); //Botón Comprobar Referencia Personal
        //Area de de Experiencia Laboral
        this.getBtn_experiencia_aceptar().setDisabled(true); //Botón Guardar Experiencia
        this.getBtn_experiencia_lab_nuevo().setDisabled(false); //Botón Nueva Experiencia Laboral
        if (this.getSis_experiencias_empleado_table().getRowCount() > 0) {
            this.getBtn_experiencia_verificar().setDisabled(false); //Botón Comprobar Expriencia
        } else {
            this.getBtn_experiencia_verificar().setDisabled(true); //Botón Comprobat Experiencia
        }
        userSession.setAttribute("esNuevaReferencia","false");
        return null;
    }

    //Método que setea valores a los bindings de Experiencia Laboral para ser añadidos o modificados

    public void setearValores_experiencia_laboral(String registroEmpleado) {
        Object idExperienciaLaboral;
        String mensaje = 
            "¡¡Experiencia laboral comprobada correctamente!! Presiona el botón Guardar.";
        idExperienciaLaboral = 
                JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                           "#{bindings.Experiencia_laboral_idReferenciaFichaEmpl.inputValue}");
        if (idExperienciaLaboral == null || 
            idExperienciaLaboral.toString().equalsIgnoreCase("") == true) {
            //Es un registro nuevo
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                        "#{bindings.Experiencia_laboral_idFichaEmpleado.inputValue}", 
                                        utils.getNumberOracle(registroEmpleado));
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                        "#{bindings.Experiencia_laboral_idReferenciaTipo.inputValue}", 
                                        utils.getNumberOracle("2"));
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                        "#{bindings.Experiencia_laboral_creadoPor.inputValue}", 
                                        utils.getUsuario());
        } else { //se trata de un registro existente a ser modificado
            //JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.Referencia_personal_modificadoPor.inputValue}" , utils.getUsuario());
        }
        mensaje(mensaje, 1); // 1 = tipo INFO
        this.getBtn_experiencia_lab_nuevo().setDisabled(true); //Botón Nueva Experiencia Laboral
        this.getBtn_experiencia_verificar().setDisabled(true); //Botón Comprobar Experiencia Laboral
        this.getBtn_experiencia_aceptar().setDisabled(false); //Botón Guardar Experiencia Laboral
        //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"setCurrentRowWithKey");     
    }

    //Botón Comprobar Experiencia Laboral

    public String btn_experiencia_verificar_action() {
        Object registroPersonalObj, estatusCommitObj;
        registroPersonalObj = 
                JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                           "#{bindings.RegistroEmpleado.inputValue}");
        if (registroPersonalObj != 
            null) { //Está correcto se podrá añadir o modificar
            estatusCommitObj = 
                    JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                               "#{bindings.commit.enabled}");
            if (estatusCommitObj != null) { //El objeto Commit está listo
                setearValores_experiencia_laboral(registroPersonalObj.toString());
            }
        }
        return null;
    }

    //Botón Guardar Experiencia Laboral

    public String btn_experiencia_aceptar_action() {
        String mensaje = "¡¡Experiencia laboral guardada correctamente!!";
        mensaje(mensaje, 1); // 1 = tipo INFO
        //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"setCurrentRowWithKey");     
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                 "Exe_referencias_empleado");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                 "Exe_experiencias_empleado");
        //Área de Experiencia Laboral
        this.getBtn_experiencia_aceptar().setDisabled(true); //Botón Guardar Experiencia Laboral
        this.getBtn_experiencia_lab_nuevo().setDisabled(false); //Botón Nueva Experiencia Laboral
        this.getBtn_experiencia_verificar().setDisabled(false); //Botón Comprobar Experiencia Laboral
        //Área de Referencia Personal
        this.getBtn_referencia_aceptar().setDisabled(true); //Botón Guardar Referencia Personal
        this.getBtn_referencia_nuevo().setDisabled(false); //Botón Nueva Referencia Personal
        if (this.getSis_referencias_empleado_table().getRowCount() > 0) {
            this.getBtn_referencia_verificar().setDisabled(false); //Botón Comprobar Referencia Personal
        } else {
            this.getBtn_referencia_verificar().setDisabled(true);
        }
        return null;
    }

    public void setBtn_experiencia_verificar(CoreCommandButton btn_experiencia_verificar) {
        this.btn_experiencia_verificar = btn_experiencia_verificar;
    }

    public CoreCommandButton getBtn_experiencia_verificar() {
        return btn_experiencia_verificar;
    }

    //Botón Nueva Experiencia Laboral

    public String btn_experiencia_lab_nuevo_action() {
        String mensaje = 
            "¡¡Experiencia laboral nueva habilitada!! Ingrese la información y luego presione el botón Comprobar Experiencia Laboral.";
        mensaje(mensaje, 1); // 1 = tipo INFO
        this.getBtn_experiencia_verificar().setDisabled(false); //Botón Comprobar Experiencia Laboral
        this.getBtn_experiencia_lab_nuevo().setDisabled(true); //Botón Nueva Experiencia Laboral
        this.getBtn_referencia_verificar().setDisabled(true); //Botón Comprobar Referencia Laboral
        this.getBtn_referencia_nuevo().setDisabled(true); //Botón Nueva Referencia Laboral
        return null;
    }

    public void setBtn_referencia_verificar(CoreCommandButton btn_referencia_verificar) {
        this.btn_referencia_verificar = btn_referencia_verificar;
    }

    public CoreCommandButton getBtn_referencia_verificar() {
        return btn_referencia_verificar;
    }

    //Botón Nueva Referencia Personal

    public String btn_referencia_nuevo_action() {
        String mensaje = 
            "¡¡Referencia personal nueva habilitada!! Ingrese la información y luego presione el botón Comprobar Referencia Personal.";
        mensaje(mensaje, 1); // 1 = tipo INFO
        this.getBtn_referencia_nuevo().setDisabled(true); //Botón Nueva Referencia Personal
        this.getBtn_experiencia_lab_nuevo().setDisabled(true); //Botón Nueva Experiencia Laboral
        this.getBtn_experiencia_verificar().setDisabled(true); //Botón Comprobar Experiencia Laboral
        this.getBtn_referencia_verificar().setDisabled(false); //Botón Comprobar Referencia Personal
         userSession.setAttribute("esNuevaReferencia", "true"); //variable de sesión.
        return null;
    }

    public void setBtn_referencia_aceptar(CoreCommandButton btn_referencia_aceptar) {
        this.btn_referencia_aceptar = btn_referencia_aceptar;
    }

    public CoreCommandButton getBtn_referencia_aceptar() {
        return btn_referencia_aceptar;
    }

    public void setBtn_referencia_cancelar(CoreCommandButton btn_referencia_cancelar) {
        this.btn_referencia_cancelar = btn_referencia_cancelar;
    }

    public CoreCommandButton getBtn_referencia_cancelar() {
        return btn_referencia_cancelar;
    }

    public void setBtn_referencia_nuevo(CoreCommandButton btn_referencia_nuevo) {
        this.btn_referencia_nuevo = btn_referencia_nuevo;
    }

    public CoreCommandButton getBtn_referencia_nuevo() {
        return btn_referencia_nuevo;
    }

    //Método que cancela cualquier operación del paso 4

    private void cancelar_paso4() {
        String mensaje = "¡¡Operación cancelada correctamente!!";
        mensaje(mensaje, 1); // 1 = tipo INFO
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                 "Exe_experiencias_empleado");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                 "Exe_referencias_empleado");
        //Se habilitan y deshabilitan los botones del área de Referencias Personales
        this.btn_referencia_aceptar.setDisabled(true); //Botón Guardar Referencia
        this.btn_referencia_nuevo.setDisabled(false); //Botón Nueva Referencia Personal
        if (this.getSis_referencias_empleado_table().getRowCount() <= 0) {
            //La tabla de Referencias Personales esta vacía y se deshabilita el botón Comprobar.
            this.getBtn_referencia_verificar().setDisabled(true); //Botón Comprobar.
        } else {
            this.getBtn_referencia_verificar().setDisabled(false); //Botón Comprobar.
        }
        //Se habilitan y deshabilitan los botones del área de Experiencia Laboral
        this.btn_experiencia_aceptar.setDisabled(true); //Botón Guardar Experiencia
        this.btn_experiencia_lab_nuevo.setDisabled(false); //Botón Nueva Experiencia Lab.
        if (this.getSis_experiencias_empleado_table().getRowCount() <= 0) {
            //La tabla de Experiencias Laborales está vacia y se deshabilita el botón Comprobar.
            this.getBtn_experiencia_verificar().setDisabled(true); //Botón Comprobar.
        } else {
            this.getBtn_experiencia_verificar().setDisabled(false); //Botón Comprobar.
        }
        userSession.setAttribute("esNuevaReferencia", "false");
    }

    //Botón Cancelar Referencia Personal

    public String btn_referencia_cancelar_action() {
        cancelar_paso4();
        return null;
    }

    public void setBtn_experiencia_lab_nuevo(CoreCommandButton btn_experiencia_lab_nuevo) {
        this.btn_experiencia_lab_nuevo = btn_experiencia_lab_nuevo;
    }

    public CoreCommandButton getBtn_experiencia_lab_nuevo() {
        return btn_experiencia_lab_nuevo;
    }

    public void setBtn_experiencia_aceptar(CoreCommandButton btn_experiencia_aceptar) {
        this.btn_experiencia_aceptar = btn_experiencia_aceptar;
    }

    public CoreCommandButton getBtn_experiencia_aceptar() {
        return btn_experiencia_aceptar;
    }

    public void setBtn_experiencia_cancelar(CoreCommandButton btn_experiencia_cancelar) {
        this.btn_experiencia_cancelar = btn_experiencia_cancelar;
    }

    public CoreCommandButton getBtn_experiencia_cancelar() {
        return btn_experiencia_cancelar;
    }

    //Botón Cancelar Experiencia Laboral

    public String btn_experiencia_cancelar_action() {
        cancelar_paso4();
        return null;
    }

    public String btn_confirmar_referencia_personal_action() {
        String mensaje = "¡¡Referencia personal confirmada correctamente!!";
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                 "ConfirmarReferenciaPersonal");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                 "Exe_referencias_empleado");
        mensaje(mensaje, 1); // 1 = tipo INFO
        return null;
    }

    public String btn_confirmar_experiencia_laboral_action() {
        String mensaje = "¡¡Experiencia laboral confirmada correctamente!!";
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                 "ConfirmarExperienciaLaboral");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                 "Exe_experiencias_empleado");
        mensaje(mensaje, 1); // 1 = tipo INFO
        return null;
    }

    public void setBtn_documento_adjunto_aceptar(CoreCommandButton btn_documento_adjunto_aceptar) {
        this.btn_documento_adjunto_aceptar = btn_documento_adjunto_aceptar;
    }

    public CoreCommandButton getBtn_documento_adjunto_aceptar() {
        return btn_documento_adjunto_aceptar;
    }

    public void setInptFile_documento_adjunto(CoreInputFile inptFile_documento_adjunto) {
        this.inptFile_documento_adjunto = inptFile_documento_adjunto;
    }

    public CoreInputFile getInptFile_documento_adjunto() {
        return inptFile_documento_adjunto;
    }

    //Función que guarda o reemplaza el archivo seleccionado

    private boolean guardar_archivo(UploadedFile archivoAdjunto, 
                                            Object idTipoArchivo, 
                                            Object idArchivoAdjunto) {
        boolean resultadoCarga; //si la grabación del archivo fue exitosa tendra valor de true
        String mensaje = "";
        HashMap parametros = new HashMap();
        carga_datos vCarga;
        parametros.put("registro_empleado", utils.getUsuario());
        parametros.put("tipo_archivo", idTipoArchivo.toString());
        parametros.put("id", idArchivoAdjunto.toString());
        vCarga = 
                new carga_datos(); //Se inicializa la clase que actualizará el archivo adjunto
        resultadoCarga = 
                vCarga.Bol_Actualizar_Data(archivoAdjunto, parametros); //actualida la data en la BD
        if (resultadoCarga == false) {
            mensaje = 
                    "Hubo un error al grabar el Archivo Seleccionado!! Intente de nuevo por favor. (Error técnico: " + 
                    vCarga.getError() + ")";
            mensaje(mensaje, 3); // 3 = tipo ERROR
        }
        return resultadoCarga;
    }

    //Método que muestra el mensaje de confirmación en pantalla y refresca los controles

    private void mostrar_mensaje_documento_guardado(String mensaje) {
        mensaje(mensaje, 1); // 1 = tipo INFO
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                 "Exe_documentos_adjuntos");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                 "Exe_foto_empleado"); //Refresca la tabla de fotos también
        this.getBtn_documento_adjunto_aceptar().setDisabled(true); //botón Guardar
        this.getBtn_documento_adjunto_nuevo().setDisabled(false); //botón Nuevo Documento
        this.getBtn_documento_adjunto_verificar().setDisabled(false); //botón Comprobar
        userSession.setAttribute("esNuevoDocumento", "false");
    }

    //Método que valida y guarda el documento adjunto

    private boolean guardar_documento_adjunto(Object archivoSeleccionado) {
        UploadedFile archivo;
        String mensaje = "";
        boolean correcto = false;
        Object idTipoDocumento, idDocumento;
        archivo = (UploadedFile)archivoSeleccionado;
        if (archivo != null && archivo.getLength() > 0) {
            idTipoDocumento = 
                    JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                               "#{bindings.Documento_adjunto_idTipoArchivo.inputValue}").toString();
            idDocumento = 
                    JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                               "#{bindings.Documento_adjunto_idArchivoAdjunto.inputValue}").toString();
            if (guardar_archivo(archivo, idTipoDocumento, idDocumento)) {
                correcto = true;
            }
        } else { //No se pudo obtener el archivo que se seleccionó
            mensaje = 
                    "!!No se pudo guardar el documento. Intente de nuevo por favor!!";
            mensaje(mensaje, 3); // 3 = tipo ERROR
        }
        return correcto;
    }
    
    //Procesa el botón guardar documento adjunto

    private void procesar_guardar_documento_adjunto(Object regPersonal, 
                                                    Object idTipoDoc, 
                                                    UploadedFile file) {
        String regP = regPersonal.toString();
        int idTipo = Integer.parseInt(idTipoDoc.toString());
        String mensaje = "";
        if (setearValoresBindings_adjuntar_docs(file, regP, idTipo)) {
            BindingContainer bind = 
                (BindingContainer)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                                             "#{bindings}");
            OperationBinding oper = bind.getOperationBinding("Commit");
            oper.execute();
            if (oper.getErrors().isEmpty()) {
                if (file != null) {
                    if (guardar_documento_adjunto(file)) {
                        mensaje = "!!Documento guardado correctamente!!";
                        mostrar_mensaje_documento_guardado(mensaje);
                    }
                } else {
                    //Solo mostrará el mensaje y refrescará los controles
                    mensaje = "¡¡Documento guardado correctamente!!";
                    mostrar_mensaje_documento_guardado(mensaje);
                }
            } else { // Ocurrio algun error
                mensaje = 
                        "Hubo un eroor al grabar la información. Intente de nuevo por favor";
                mensaje(mensaje, 3); // 3 = tipo ERROR
            }
        }
    }

    //Botón Guardar Documento Adjunto

    public String btn_documento_adjunto_aceptar_action() {
        String mensaje = "";
        Object regPersonal = 
            JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                       "#{bindings.RegistroEmpleado.inputValue}");
        Object idTipoDoc = 
            JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                       "#{bindings.Documento_adjunto_idTipoArchivo.inputValue}");
        UploadedFile file = 
            (UploadedFile)this.getInptFile_documento_adjunto().getValue();
        try {
            if (regPersonal != null && idTipoDoc != null) {
                //Es correcto se puede proseguir
                if (comprobar_documento_adjunto(idTipoDoc, file)) {
                    procesar_guardar_documento_adjunto(regPersonal, idTipoDoc, file);
                }
            } else {
                mensaje = "No se pudo guardar la información. Intente de nuevo por favor. ";
                mensaje(mensaje, 3);
            }
        } catch (Exception eas) {
            eas.printStackTrace();
            mensaje = 
                    "Ha ocurrido un error inesperado. Intente de nuevo por favor. ";
            mensaje += " Error: " + eas.getMessage();
            mensaje(mensaje, 3); // 3 = tipo ERROR
        }
        return null;
    }

    public void setCmb_tipos_documentos_adjuntos(CoreSelectOneChoice cmb_tipos_documentos_adjuntos) {
        this.cmb_tipos_documentos_adjuntos = cmb_tipos_documentos_adjuntos;
    }

    public CoreSelectOneChoice getCmb_tipos_documentos_adjuntos() {
        return cmb_tipos_documentos_adjuntos;
    }

    public void setBtn_documento_adjunto_verificar(CoreCommandButton btn_documento_adjunto_verificar) {
        this.btn_documento_adjunto_verificar = btn_documento_adjunto_verificar;
    }

    public CoreCommandButton getBtn_documento_adjunto_verificar() {
        return btn_documento_adjunto_verificar;
    }

    //Método que obtiene la extensión del archivo seleccionado

    private String obtenerExtensionDocumentoAdjunto(UploadedFile archivo) {
        String extension = ""; 
        String nombreDocumento = "";
        //UploadedFile documento = (UploadedFile) this.getInptFile_documento_adjunto().getValue();
        if (archivo != null && archivo.getLength() > 0) {
            extension = archivo.getContentType();
            if (!extension.equalsIgnoreCase("")) {
                extension = extension.substring(extension.indexOf("/") + 1);
            }
        } else {
            nombreDocumento = 
                    (String)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                                       "#{bindings.Documento_adjunto_nomArchivo.inputValue}");
            if (nombreDocumento != null && 
                nombreDocumento.equalsIgnoreCase("") == false) {
                if (nombreDocumento.indexOf(".") >= 0) {
                    extension = 
                            nombreDocumento.substring(nombreDocumento.indexOf(".") + 
                                                      1);
                }
            }
        }
        //System.out.println("la extensión es: [" + extension + "]");
        return extension;
    }

    //procedimiento que le crea un nombre al documento adjunto

    private String crearNombreDocumentoAdjunto(String registroEmpleado, 
                                               UploadedFile archivo) {
        String nombre = "";
        Integer idTipoDocumento;
        carga_datos vCarga;
        Object idTipoDocumentoObj;
        String nombreTipoDocumento;
        vCarga = new carga_datos();
        String extensionArchivo;
        idTipoDocumentoObj = 
                JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                           "#{bindings.Documento_adjunto_idTipoArchivo.inputValue}");
        if (idTipoDocumentoObj != null) {
            idTipoDocumento = Integer.valueOf(idTipoDocumentoObj.toString());
            if (idTipoDocumento != null && idTipoDocumento > 0) {
                nombreTipoDocumento = 
                        vCarga.obtenerNombreTipoDocumentoAdjunto(idTipoDocumento.intValue());
                if (nombreTipoDocumento != null && 
                    nombreTipoDocumento.equalsIgnoreCase("") == false) {
                    nombreTipoDocumento = 
                            nombreTipoDocumento.replaceAll(" ", "_"); //remplazo los espacios en blanco por sub guiones
                    extensionArchivo = 
                            obtenerExtensionDocumentoAdjunto(archivo);
                    if (!extensionArchivo.equalsIgnoreCase("")) {
                        nombre = 
                                registroEmpleado + "_" + nombreTipoDocumento + "." + 
                                extensionArchivo;
                    } else {
                        nombre = registroEmpleado + "_" + nombreTipoDocumento;
                    }
                }
            } else {
                JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                            "#{bindings.Documento_adjunto_nomArchivo.inputValue}", 
                                            "No se pudo obtener el tipo de documento!! Intente de nuevo.");
            }
        } else {
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                        "#{bindings.Documento_adjunto_nomArchivo.inputValue}", 
                                        "No se pudo obtener el tipo de documento!! Intente de nuevo.");
        }
        return nombre;
    }

    private String obtenerNombreTipoDocumento(Object idTipoDocumentoObj) {
        String nombre = "";
        JUIteratorBinding listOfValuesIterator;
        int idTipoDocumento, idTipoDocumentoAux;
        idTipoDocumento = Integer.parseInt(idTipoDocumentoObj.toString());
        listOfValuesIterator = 
                (JUIteratorBinding)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                                              "#{bindings.Sis_tipo_documento_adjunto_vwIterator}");
        for (int i = 0; i < listOfValuesIterator.getEstimatedRowCount(); i++) {
            Row currentRow = listOfValuesIterator.getRowAtRangeIndex(i);
            idTipoDocumentoAux = 
                    Integer.parseInt(currentRow.getAttribute("IdTipoArchivo").toString());
            if (idTipoDocumento == idTipoDocumentoAux) {
                nombre = currentRow.getAttribute("Nombre").toString();
                break;
            }
        }
        return nombre;
    }

    //Método que setea valores a los bindings del procedimiento adjuntar documentos antes de ser grabados.

    private boolean setearValoresBindings_adjuntar_docs(UploadedFile archivo, 
                                                           String registroEmpleado, 
                                                           int idTipoDocumento) {
        String nombreArchivo; //nombre de como se guardará el archivo en la base de datos
        String nombreTipoDocumento; //nombre del tipo de documento seleccionado
        boolean correcto = false;
        nombreArchivo = crearNombreDocumentoAdjunto(registroEmpleado, archivo);
        if (nombreArchivo.equalsIgnoreCase("")) {
            nombreArchivo = registroEmpleado;
        }
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                    "#{bindings.Documento_adjunto_nomArchivo.inputValue}", 
                                    nombreArchivo);
        nombreTipoDocumento = obtenerNombreTipoDocumento(idTipoDocumento);
        if (nombreTipoDocumento.equalsIgnoreCase("")) {
            nombreTipoDocumento = "DPI";
        }
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                    "#{bindings.Documento_adjunto_nombreTipoArchivo.inputValue}", 
                                    nombreTipoDocumento);
        Object esNuevoDocumento = userSession.getAttribute("esNuevoDocumento");
        if (esNuevoDocumento != null && 
            esNuevoDocumento.toString().equalsIgnoreCase("true")) { //Es nuevo Documento
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                        "#{bindings.Documento_adjunto_registroEmpleado.inputValue}", 
                                        utils.getNumberOracle(registroEmpleado));
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                        "#{bindings.Documento_adjunto_creadoPor.inputValue}", 
                                        utils.getUsuario());
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                        "#{bindings.Documento_adjunto_modulo.inputValue}", 
                                        "SIS");
            correcto = true;
        } else if (idTipoDocumento > 0) { //Documento ya existente
            Date aux = obtenerFechaSistema();
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                        "#{bindings.Documento_adjunto_fechaCreacion.inputValue}", 
                                        aux);
            correcto = true;
        } 
        return correcto;
    }

    //Lanza el mensaje de error si el tipo de documento ya existe en la lista

    /*private void comprobar_unicidad_tipo_documento_mensaje_error() {
        String mensaje = 
            "¡¡El tipo de documento ya existe en el listado de documentos adjuntados!!";
        mensaje(mensaje, 3); // 3 = tipo ERROR}
        this.getBtn_documento_adjunto_nuevo().setDisabled(true); //botón Nuevo Documento
        this.getBtn_documento_adjunto_aceptar().setDisabled(true); //botón Guardar
    }*/

    //Comprueba la unicidad del tipo de documento seleccionado en la lista de documentos adjuntos.

    private boolean comprobar_unicidad_tipo_documento(int idDocumento, 
                                                      int idTipoDocumento) {
        Object idDocAuxObj, idTipoDocAuxObj;
        int idDocAux, idTipoDocAux;
        boolean unico = true;
        JUCtrlValueBindingRef rwRef;
        Row rw;
        int numFilas = this.getSis_documentos_adjuntos_table().getRowCount();
        for (int i = 0; i <= numFilas - 1; i++) {
            rwRef = 
                    (JUCtrlValueBindingRef)this.getSis_documentos_adjuntos_table().getRowData(i);
            rw = rwRef.getRow();
            idDocAuxObj = rw.getAttribute("IdArchivoAdjunto");
            if (idDocAuxObj != null) {
                idDocAux = Integer.parseInt(idDocAuxObj.toString());
                idTipoDocAuxObj = rw.getAttribute("IdTipoArchivo");
                idTipoDocAux = Integer.parseInt(idTipoDocAuxObj.toString());
                if (idDocumento > 0) { //Es edición de documento
                    if (idDocumento != idDocAux) {
                        if (idTipoDocumento == idTipoDocAux) {
                            unico = false;
                            break;
                        }
                    }
                } else if (idTipoDocumento == idTipoDocAux) {
                    //Es nuevo documento
                    unico = false;
                    break;
                }
            }
        }
        return unico;
    }

    //Método que valida el archivo es seleccionado.

    private boolean validar_extension_archivo_seleccionado(UploadedFile file, 
                                                           int idTipoDoc) {
        boolean valido = false; //cambiara a true si el tipo de archivo válido
        String mensaje = "";
        carga_datos vCarga;
        if (idTipoDoc > 0) {
            vCarga = new carga_datos();
            valido = 
                    vCarga.comprobarValidezTipoArchivoAdjunto(file.getContentType(), 
                                                              idTipoDoc);
            if (valido == false) {
                mensaje = vCarga.getError();
                mensaje(mensaje, 3); // 3 = tipo ERROR
            }
        } else {
            mensaje = 
                    "¡¡No se puede obtener el tipo de documento seleccionado. Intente de nuevo por favor!!";
            mensaje(mensaje, 3); // 3 = tipo ERROR
        }
        return valido;
    }

    //Método que valida el archivo seleccionado (tipo de archivo y peso)

    private boolean validar_archivo_seleccionado(UploadedFile file, 
                                                 int idTipoDoc) {
        String mensaje = "";
        boolean valido = false;
        if (validar_extension_archivo_seleccionado(file, idTipoDoc)) {
            //Extensión del archivo seleccionado validado correctamente
            //Ahora comprobamos el peso del archivo
            long tamByteMaxArchivo = 
                new Long(FacesContext.getCurrentInstance().getExternalContext().getInitParameter("TAMANIO_MAX_FOTO_EMPLEADO"));
            if (file.getLength() <= tamByteMaxArchivo) {
                //tiene un peso permitido
                valido = true;
            } else {
                mensaje = 
                        "¡¡El archivo seleccionado es muy grande!! Tamaño máximo permitido: ";
                mensaje += (tamByteMaxArchivo / 1024) + " KB.";
                mensaje(mensaje, 3); // 3 = tipo ERROR
            }
        }
        return valido;
    }

    //Método que comprueba la información ingresada de un documento nuevo

    private boolean comprobar_documento_nuevo(Object idTipoDocObj, 
                                              UploadedFile file) {
        int idDocAdjunto = 0; //0 porque es nuevo
        int idTipoDoc;
        String mensaje = "";
        boolean valido = false;
        if (idTipoDocObj != null && 
            Integer.parseInt(idTipoDocObj.toString()) > 0) {
            idTipoDoc = Integer.parseInt(idTipoDocObj.toString());
            //Comprobaré que no haya otro documento del mismo tipo en el listado
            if (comprobar_unicidad_tipo_documento(idDocAdjunto, idTipoDoc)) {
                //Es único en el listado ahora se valida el archivo seleccionado
                if (file != null && file.getLength() > 0) {
                    //Seleccionó un archivo, ahora lo validaremos
                    if (validar_archivo_seleccionado(file, idTipoDoc)) {
                        valido = true;
                    }
                } else {
                    mensaje = "¡¡Seleccione un archivo por favor!!";
                    mensaje(mensaje, 3); // 3 = tipo ERROR
                }
            } else {
                //comprobar_unicidad_tipo_documento_mensaje_error();
                mensaje = 
                        "¡¡El tipo de documento ya existe en el listado de documentos adjuntados!!";
                mensaje(mensaje, 3); // 3 = tipo ERROR}
            }
        } else {
            mensaje = 
                    "No se pudo obtener el tipo de documento seleccionado. Intente de nuevo por favor!!";
            mensaje(mensaje, 3); // 3 = tipo ERROR
        }
        return valido;
    }

    /*//Método que comprueba el documento adjunto existente detalladamente

    private boolean validar_doc_adjunto4_existente(UploadedFile file, int idDocAdjunto, int idTipoDoc) {
        boolean valido=false;
        if (comprobar_unicidad_tipo_documento(idDocAdjunto, idTipoDoc)) {
            //Es único en la lista, se prosigue a comprobar si se seleccionó un archivo.
            if (file != null && file.getLength() > 0) {
                //Seleccionó un archivo, ahora lo validaremos
                if (validar_archivo_seleccionado(file, idTipoDoc)) {
                    valido = true;
                } 
            } else { 
                //No se seleccionó archivo alguno es valido
                valido = true;
            }
        } else {
            String mensaje = 
                "¡¡El tipo de documento ya existe en el listado de documentos adjuntados!!";
            mensaje(mensaje, 3); // 3 = tipo ERROR}
        }
        return valido;
    }*/
    
    //Método que comprueba el documento adjunto ya existente

    private boolean comprobar_documento_existente(UploadedFile file, 
                                                  Object idDocObj, 
                                                  Object idTipoDocObj, 
                                                  Object estatusDocObj) {
        String mensaje = "";
        //System.out.println("El estatus del documento es: " + estatusDocumento);
        boolean valido = false;
        if (idDocObj != null && idTipoDocObj != null) {
            if (estatusDocObj == null) {
                //Documento no confirmado aun
                int idDoc = Integer.parseInt(idDocObj.toString());
                int idTipoDoc = Integer.parseInt(idTipoDocObj.toString());
                /*if (validar_doc_adjunto_existente(file, idDoc, idTipoDoc)) {
                    //setearValoresBindings_adjuntar_docs(file, regPersonal,  idTipoDoc);
                    valido = true;
                }*/
                if (comprobar_unicidad_tipo_documento(idDoc, idTipoDoc)) {
                    //Es único en la lista, se prosigue a comprobar si se seleccionó un archivo.
                    if (file != null && file.getLength() > 0) {
                        //Seleccionó un archivo, ahora lo validaremos
                        if (validar_archivo_seleccionado(file, idTipoDoc)) {
                            valido = true;
                        }
                    } else {
                        //No se seleccionó archivo alguno 
                        //por ser documento existente es valido
                        valido = true;
                    }
                } else {
                    mensaje = 
                            "¡¡El tipo de documento ya existe en el listado de documentos adjuntados!!";
                    mensaje(mensaje, 3); // 3 = tipo ERROR}
                }
            } else if (estatusDocObj.toString().equalsIgnoreCase("1")) {
                //Documento ya confirmado, no se puede editar la información
                mensaje = 
                        "No se puede editar el documento ya que ya se encuentra Confirmado.";
                mensaje += " ID Documento No. " + idDocObj.toString();
                mensaje(mensaje, 3); // 3 = tipo ERROR
            } else {
                mensaje = 
                        "No se pudo establecer el estado actual del documento. Intente de nuevo por favor.";
                mensaje(mensaje, 3); // 3 = tipo ERROR
            }
        } else {
            mensaje = 
                    "No se pudo comprobar el documento correctamente. Intente de nuevo por favor.";
            mensaje(mensaje, 3); // 3 = tipo ERROR
        }
        return valido;
    }

    //Método que comprueba el documento adjunto

    private boolean comprobar_documento_adjunto(Object idTipoDoc, UploadedFile file) {
        String mensaje = "";
        Object idDoc = 
            JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                       "#{bindings.Documento_adjunto_idArchivoAdjunto.inputValue}");
        Object estatusDoc = 
            JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                       "#{bindings.Documento_adjunto_confirmado.inputValue}");
        Object esNuevoDoc = 
            userSession.getAttribute("esNuevoDocumento"); //Nos dice si el documento es nuevo o no.
        boolean valido = false;
        if (esNuevoDoc != null) { //Contiene un valor
            if (esNuevoDoc.toString().equalsIgnoreCase("true")) { //Es un nuevo documento
                if (comprobar_documento_nuevo(idTipoDoc, file)) {
                    valido = true;
                }
            } else { //Es un documento existente
                if (comprobar_documento_existente(file, idDoc, idTipoDoc, 
                                                  estatusDoc)) {
                    valido = true;
                }
            }
        } else if (idDoc != null && idTipoDoc != null) {
            //Es un documento ya existente
            if (comprobar_documento_existente(file, idDoc, idTipoDoc, 
                                              estatusDoc)) {
                valido = true;
            }
        } else {
            mensaje = 
                    "No se pudo comprobar el documento adjunto correctamente. Intente de nuevo por favor.";
            mensaje(mensaje, 3); // 3 = tipo ERROR
        }
        return valido;
    }
    
    //Botón Comprobar Documento

    public String btn_documento_adjunto_verificar_action() {
        UploadedFile file = 
            (UploadedFile)this.getInptFile_documento_adjunto().getValue();
        Object idTipoDoc = 
            JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                       "#{bindings.Documento_adjunto_idTipoArchivo.inputValue}");
        if (comprobar_documento_adjunto( idTipoDoc, file)) {
            //setearValoresBindings_adjuntar_docs(file, regPersonal,  idTipoDoc);
            String mensaje = "¡¡Documento comprobado correctamente!!";
            this.getBtn_documento_adjunto_nuevo().setDisabled(true); //botón Nuevo
            this.getBtn_documento_adjunto_verificar().setDisabled(true); //botón Comprobar
            this.getBtn_documento_adjunto_aceptar().setDisabled(false); //botón Guardar
            mensaje(mensaje, 1); // 1 = tipo INFO
        }
        return null;
    }
    
    //Botón Agregar Documento

    public String btn_documento_adjunto_nuevo_action() {
        String mensaje = "¡¡Documento nuevo habilitado!!";
        this.getBtn_documento_adjunto_nuevo().setDisabled(true); //Botón Nuevo
        this.getBtn_documento_adjunto_verificar().setDisabled(false); //Botón Comprobar
        userSession.setAttribute("esNuevoDocumento", "true");
        mensaje(mensaje, 1); // 1 = tipo INFO
        return null;
    }

    public void setBtn_documento_adjunto_nuevo(CoreCommandButton btn_documento_adjunto_nuevo) {
        this.btn_documento_adjunto_nuevo = btn_documento_adjunto_nuevo;
    }

    public CoreCommandButton getBtn_documento_adjunto_nuevo() {
        return btn_documento_adjunto_nuevo;
    }

    public void setBtn_documento_adjunto_cancelar(CoreCommandButton btn_documento_adjunto_cancelar) {
        this.btn_documento_adjunto_cancelar = btn_documento_adjunto_cancelar;
    }

    public CoreCommandButton getBtn_documento_adjunto_cancelar() {
        return btn_documento_adjunto_cancelar;
    }

    //Botón Cancelar Documento Adjunto

    public String btn_documento_adjunto_cancelar_action() {
        String mensaje = "¡¡Operación cancelada correctamente!!!!";
        mensaje(mensaje, 1); // 1 = tipo INFO
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                 "Exe_documentos_adjuntos");
        this.getBtn_documento_adjunto_aceptar().setDisabled(true); //Se deshabilita el botón Guardar.    
        this.getBtn_documento_adjunto_nuevo().setDisabled(false); //se habilita el botón Nuevo Documento
        if (this.getSis_documentos_adjuntos_table().getRowCount() <= 0) {
            //La tabla de documentos adjuntos esta vacía y se deshabilita el botón Comprobar.
            this.getBtn_documento_adjunto_verificar().setDisabled(true); //Se deshabilita el botón Comprobar.
        } else {
            this.getBtn_documento_adjunto_verificar().setDisabled(false); //Se habilita el botón Comprobar.
        }
        userSession.setAttribute("esNuevoDocumento", "false");
        return null;
    }

    public String btn_confirmar_documento_adjunto_action() {
        String mensaje = "¡¡Documento confirmado correctamente!!";
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                 "ConfirmarDocumentoAdjunto");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                 "Exe_documentos_adjuntos");
        mensaje(mensaje, 1); // 1 = tipo INFO
        return null;
    }

    public void setOutputFormatDocumentoID(CoreOutputFormatted outputFormatDocumentoID) {
        this.outputFormatDocumentoID = outputFormatDocumentoID;
    }

    public CoreOutputFormatted getOutputFormatDocumentoID() {
        return outputFormatDocumentoID;
    }

    public void setSis_documentos_adjuntos_table(CoreTable sis_documentos_adjuntos_table) {
        this.sis_documentos_adjuntos_table = sis_documentos_adjuntos_table;
    }

    public CoreTable getSis_documentos_adjuntos_table() {
        return sis_documentos_adjuntos_table;
    }

    public void setForm1(CoreForm form1) {
        this.form1 = form1;
    }

    public CoreForm getForm1() {
        return form1;
    }

    public void setMessagesDocumentosAdjuntos(CoreMessages messagesDocumentosAdjuntos) {
        this.messagesDocumentosAdjuntos = messagesDocumentosAdjuntos;
    }

    public CoreMessages getMessagesDocumentosAdjuntos() {
        return messagesDocumentosAdjuntos;
    }

    public void setMessageDocumentoAdjunto(CoreMessage messageDocumentoAdjunto) {
        this.messageDocumentoAdjunto = messageDocumentoAdjunto;
    }

    public CoreMessage getMessageDocumentoAdjunto() {
        return messageDocumentoAdjunto;
    }

    public void setPnlFormDocumentosAdjuntos(CorePanelForm pnlFormDocumentosAdjuntos) {
        this.pnlFormDocumentosAdjuntos = pnlFormDocumentosAdjuntos;
    }

    public CorePanelForm getPnlFormDocumentosAdjuntos() {
        return pnlFormDocumentosAdjuntos;
    }

    public void setOutputFormatDocumentoMsgEditable(CoreOutputFormatted outputFormatDocumentoMsgEditable) {
        this.outputFormatDocumentoMsgEditable = 
                outputFormatDocumentoMsgEditable;
    }

    public CoreOutputFormatted getOutputFormatDocumentoMsgEditable() {
        return outputFormatDocumentoMsgEditable;
    }

    public void setPnlFormDocumentosAdjuntosAreaEdicion(CorePanelForm pnlFormDocumentosAdjuntosAreaEdicion) {
        this.pnlFormDocumentosAdjuntosAreaEdicion = 
                pnlFormDocumentosAdjuntosAreaEdicion;
    }

    public CorePanelForm getPnlFormDocumentosAdjuntosAreaEdicion() {
        return pnlFormDocumentosAdjuntosAreaEdicion;
    }

    public void setPnlFormDocumentosAdjuntoInputFile(CorePanelForm pnlFormDocumentosAdjuntoInputFile) {
        this.pnlFormDocumentosAdjuntoInputFile = 
                pnlFormDocumentosAdjuntoInputFile;
    }

    public CorePanelForm getPnlFormDocumentosAdjuntoInputFile() {
        return pnlFormDocumentosAdjuntoInputFile;
    }

    public void setSis_foto_empleado_table(CoreTable sis_foto_empleado_table) {
        this.sis_foto_empleado_table = sis_foto_empleado_table;
    }

    public CoreTable getSis_foto_empleado_table() {
        return sis_foto_empleado_table;
    }

    public void setBtn_imprimirCV(CoreCommandButton btn_imprimirCV) {
        this.btn_imprimirCV = btn_imprimirCV;
    }

    public CoreCommandButton getBtn_imprimirCV() {
        return btn_imprimirCV;
    }

    public void setSis_referencias_empleado_table(CoreTable sis_referencias_empleado_table) {
        this.sis_referencias_empleado_table = sis_referencias_empleado_table;
    }

    public CoreTable getSis_referencias_empleado_table() {
        return sis_referencias_empleado_table;
    }

    public void setSis_experiencias_empleado_table(CoreTable sis_experiencias_empleado_table) {
        this.sis_experiencias_empleado_table = sis_experiencias_empleado_table;
    }

    public CoreTable getSis_experiencias_empleado_table() {
        return sis_experiencias_empleado_table;
    }

    public void setBtn_guardar_datos_personales(CoreCommandButton btn_guardar_datos_personales) {
        this.btn_guardar_datos_personales = btn_guardar_datos_personales;
    }

    public CoreCommandButton getBtn_guardar_datos_personales() {
        return btn_guardar_datos_personales;
    }

    public void setBtn_guardar_paso5(CoreCommandButton btn_guardar_paso5) {
        this.btn_guardar_paso5 = btn_guardar_paso5;
    }

    public CoreCommandButton getBtn_guardar_paso5() {
        return btn_guardar_paso5;
    }

    public void setInptFile_foto_empleado(CoreInputFile inptFile_foto_empleado) {
        this.inptFile_foto_empleado = inptFile_foto_empleado;
    }

    public CoreInputFile getInptFile_foto_empleado() {
        return inptFile_foto_empleado;
    }

    public void setBtn_foto_empleado_cancelar(CoreCommandButton btn_foto_empleado_cancelar) {
        this.btn_foto_empleado_cancelar = btn_foto_empleado_cancelar;
    }

    public CoreCommandButton getBtn_foto_empleado_cancelar() {
        return btn_foto_empleado_cancelar;
    }

    public String btn_foto_empleado_cancelar_action() {
        Object StatusFoto;
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                 "Exe_foto_empleado");
        this.getBtn_foto_empleado_guardar().setDisabled(true); //Botón Guardar    
        if (this.getSis_foto_empleado_table().getRowCount() <= 0) {
            //La tabla de fotos está vacía, se deshabilita el botón Comprobar Fotos y se habilita el botón Adjuntar Foto.
            this.getBtn_foto_empleado_comprobar().setDisabled(true); //botón Comprobar Foto.
            this.getBtn_foto_empleado_adjuntar().setDisabled(false); //botón Adjuntar Foto.            
        } else {
            StatusFoto = 
                    JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                               "#{bindings.Foto_empleado_status.inputValue}");
            if (StatusFoto != null && 
                StatusFoto.toString().equalsIgnoreCase("1")) {
                //Foto está confirmada se Deshabilitan los botones Comprobar Foto y Adjuntar Foto.
                this.getBtn_foto_empleado_comprobar().setDisabled(true);
                this.getBtn_foto_empleado_adjuntar().setDisabled(true); //botón Adjuntar Foto.            
            } else { //Foto No Confirmada aún, se habilita el botón Confirmar Foto y deshabilita el botón Adjuntar Foto
                this.getBtn_foto_empleado_comprobar().setDisabled(false);
                this.getBtn_foto_empleado_adjuntar().setDisabled(true); //botón Adjuntar Foto.            
            }
        }
        userSession.setAttribute("esFotoNueva", "false"); //variable de sesión.
        String mensaje = "¡¡Operación cancelada correctamente!!!!";
        mensaje(mensaje, 1); // 1 = tipo INFO
        return null;
    }

    public void setMessagesFotoAdjunto(CoreMessages messagesFotoAdjunto) {
        this.messagesFotoAdjunto = messagesFotoAdjunto;
    }

    public CoreMessages getMessagesFotoAdjunto() {
        return messagesFotoAdjunto;
    }

    public String btn_foto_empleado_adjuntar_action() {
        // Add event code here...
        String mensaje = 
            "¡¡Foto nueva habilitada!! Seleccione la foto a adjuntar y luego presiones el botón Comprobar Foto.";
        mensaje(mensaje, 1); // 1 = tipo INFO
        this.getBtn_foto_empleado_adjuntar().setDisabled(true); //Botón Adjuntar Foto
        this.getBtn_foto_empleado_comprobar().setDisabled(false); //Botón Comprobar Foto
        userSession.setAttribute("esFotoNueva", "true"); //variable de sesión.
        return null;
    }

    public void setBtn_foto_empleado_comprobar(CoreCommandButton btn_foto_empleado_comprobar) {
        this.btn_foto_empleado_comprobar = btn_foto_empleado_comprobar;
    }

    public CoreCommandButton getBtn_foto_empleado_comprobar() {
        return btn_foto_empleado_comprobar;
    }

    public void setBtn_foto_empleado_guardar(CoreCommandButton btn_foto_empleado_guardar) {
        this.btn_foto_empleado_guardar = btn_foto_empleado_guardar;
    }

    public CoreCommandButton getBtn_foto_empleado_guardar() {
        return btn_foto_empleado_guardar;
    }

    public void setBtn_foto_empleado_adjuntar(CoreCommandButton btn_foto_empleado_adjuntar) {
        this.btn_foto_empleado_adjuntar = btn_foto_empleado_adjuntar;
    }

    public CoreCommandButton getBtn_foto_empleado_adjuntar() {
        return btn_foto_empleado_adjuntar;
    }

    //Función que valida el tipo del archivo de la foto seleccionado.

    private boolean validar_tipo_archivo_foto_seleccionada(UploadedFile archivo) {
        boolean valido = 
            false; //variable que tendrá el valor true si el tipo de archivo es admitido
        String mensaje = ""; //Guardará el mensaje si hubo error
        carga_datos vCarga;
        vCarga = new carga_datos();
        valido = 
                vCarga.comprobarValidezTipoArchivoAdjunto(archivo.getContentType(), 
                                                          3); //3 = foto
        if (valido == false) {
            mensaje = vCarga.getError();
            mensaje("Error:" + mensaje, 3); // 3 = tipo ERROR
        }
        return valido;
    }

    //procedimiento que le crea un nombre al documento adjunto

    private String crearNombreFotoAdjunto(UploadedFile archivo, 
                                          String registroEmpleado) {
        String nombre = "";
        carga_datos vCarga;
        String nombreTipoDocumento;
        vCarga = new carga_datos();
        String extensionArchivo;
        nombreTipoDocumento = 
                vCarga.obtenerNombreTipoDocumentoAdjunto(3); //3 es foto
        if (nombreTipoDocumento != null && 
            nombreTipoDocumento.equalsIgnoreCase("") == false) {
            nombreTipoDocumento = 
                    nombreTipoDocumento.replaceAll(" ", "_"); //remplazo los espacios en blanco por sub guiones
            extensionArchivo = obtenerExtensionDocumentoAdjunto(archivo);
            if (!extensionArchivo.equalsIgnoreCase("")) {
                nombre = 
                        registroEmpleado + "_" + nombreTipoDocumento + "." + extensionArchivo;
            } else {
                nombre = registroEmpleado + "_" + nombreTipoDocumento;
            }
        } else {
            nombre = "Undefined";
        }
        return nombre;
    }

    //Método que obteniene la fecha y hora actual del sistema

    private Date obtenerFechaSistema() {
        Object fecha = new oracle.jbo.domain.Date().getCurrentDate();
        Calendar calendario = Calendar.getInstance();
        int hora = calendario.get(Calendar.HOUR_OF_DAY);
        int minutos = calendario.get(Calendar.MINUTE);
        int segundos = calendario.get(Calendar.SECOND);
        Date fechaHora = 
            new Date(fecha.toString() + " " + String.valueOf(hora) + ":" + 
                     String.valueOf(minutos) + ":" + String.valueOf(segundos));
        return fechaHora;
    }

    //procedimiento que asigna valores a los bindings de la foto a adjuntar lista para ser grabada.

    private void asignarValoresBindings_foto_adjunta(UploadedFile archivo, 
                                                     String registroEmpleado, 
                                                     boolean esRegistroNuevo) {
        //String nombreArchivo; //nombre como se guardará en la base de datos
        String nombreArchivo = 
            crearNombreFotoAdjunto(archivo, registroEmpleado);
        String mensaje = 
            "¡¡Foto comprobada correctamente!! Hacer clic en Guardar.";
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                    "#{bindings.Foto_empleado_nomArchivo.inputValue}", 
                                    nombreArchivo);
        System.out.println("El nombre de la foto será: " + nombreArchivo);
        if (esRegistroNuevo == true) { //Es foto nueva
            //nombreArchivo = crearNombreFotoAdjunto(archivo, registroEmpleado);
            //JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.Foto_empleado_nomArchivo.inputValue}" , nombreArchivo);
            //System.out.println("El nombre de la foto será: " + nombreArchivo);
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                        "#{bindings.Foto_empleado_idTipoDocumento.inputValue}", 
                                        utils.getNumberOracle("3"));
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                        "#{bindings.Foto_empleado_registroEmpleado.inputValue}", 
                                        utils.getNumberOracle(registroEmpleado));
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                        "#{bindings.Foto_empleado_creadoPor.inputValue}", 
                                        utils.getUsuario());
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                        "#{bindings.Foto_empleado_modulo.inputValue}", 
                                        "SIS");
            //System.out.println("Se setearon los valores bindings para la Foto Nueva");
        } else {
            Date aux = obtenerFechaSistema();
            //System.out.println("La fecha y hora acutal es: " + aux);
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                        "#{bindings.Foto_empleado_fechaCreacion.inputValue}", 
                                        aux);
        }
        this.getBtn_foto_empleado_adjuntar().setDisabled(true); //botón Adjuntar Foto
        this.getBtn_foto_empleado_comprobar().setDisabled(true); //botón Comprobar Foto
        this.getBtn_foto_empleado_guardar().setDisabled(false); //botón Guardar
        mensaje(mensaje, 1); // 1 = tipo INFO
    }

    //Función que valida el tipo de archivo y longitud de la foto seleccionada.

    private boolean validar_foto_seleccionada(UploadedFile archivo) {
        String mensaje = "";
        boolean valido = false; //valor inicial
        if (validar_tipo_archivo_foto_seleccionada(archivo)) {
            //System.out.println("La extensión del archivo es admitida.");
            //El tipo de archivo para la foto es admitido, ahora comprobamos el tamaño del archivo
            long tamByteMaxArchivo = 
                new Long(FacesContext.getCurrentInstance().getExternalContext().getInitParameter("TAMANIO_MAX_FOTO_EMPLEADO"));
            if (archivo.getLength() <= tamByteMaxArchivo) {
                valido = true;
                //System.out.println("La foto tiene un tamaño permitido: " + archivo.getLength() + " bytes.");
            } else {
                mensaje = 
                        "El archivo es muy grande. Tamaño máximo permitido: " + 
                        (tamByteMaxArchivo / 1024) + 
                        " KB. Seleccione otro o Cancele.";
                mensaje(mensaje, 3); // 3 = tipo ERROR
            }
        }
        return valido;
    }

    //Método que comprueba la foto de nuevo ingreso

    private void comprobar_foto_nueva(String registroPersonal) {
        String mensaje;
        UploadedFile fotoSeleccionada = 
            (UploadedFile)this.getInptFile_foto_empleado().getValue();
        if (fotoSeleccionada != null && fotoSeleccionada.getLength() > 0) {
            //Validamos la extensión y el tamaño del archivo seleccionado.
            if (validar_foto_seleccionada(fotoSeleccionada)) {
                asignarValoresBindings_foto_adjunta(fotoSeleccionada, 
                                                    registroPersonal, true);
            }
        } else {
            mensaje = "¡¡Seleccione un archivo por favor!!";
            mensaje(mensaje, 3); // 3 = tipo ERROR
        }
    }

    //Método que valida la foto seleccionada detalladamente

    private void comprobar_foto_existente_detallado(String registroPersonal, 
                                                    int idFotoActual) {
        System.out.println("Validando la foto a reemplazar del Registro de Personal No." + 
                           registroPersonal + " y Foto ID No." + idFotoActual);
        UploadedFile fotoSeleccionada = 
            (UploadedFile)this.getInptFile_foto_empleado().getValue();
        if (fotoSeleccionada != null && fotoSeleccionada.getLength() > 0) {
            //Se valida el tipo de archivo y la longitud del mismo.
            if (validar_foto_seleccionada(fotoSeleccionada)) {
                asignarValoresBindings_foto_adjunta(fotoSeleccionada, 
                                                    registroPersonal, false);
            }
        } else {
            mensaje("¡¡Seleccione un archivo por favor!!", 
                    3); // 3 = tipo ERROR
        }
    }

    //Método que comprueba la foto como existente

    private void comprobar_foto_existente(Object idFotoActual, 
                                          Object estatusFoto, 
                                          String registroPersonal) {
        String mensaje;
        if (idFotoActual != null) {
            if (estatusFoto == null) { //Foto No Confirmada aún.
                comprobar_foto_existente_detallado(registroPersonal, 
                                                   Integer.parseInt(idFotoActual.toString()));
            } else if (estatusFoto.toString().equalsIgnoreCase("1")) {
                //Confirmado, No se puede grabar la información
                mensaje = 
                        "No se puede grabar la foto ya que se encuentra Confirmada. Foto ID: " + 
                        idFotoActual.toString();
                mensaje(mensaje, 3); // 3 = tipo ERROR
            } else {
                mensaje = 
                        "No se pudo obtener el estado de la foto actual, reportelo con el administrador del sistema por favor.";
                mensaje(mensaje, 3); // 3 = tipo ERROR
            }
        } else {
            mensaje = 
                    "No se pudo obtener el ID de la foto actual. Intente de nuevo por favor.";
            mensaje(mensaje, 3); // 3 = tipo ERROR
        }
    }

    //Método que comprueba la foto que se desea adjuntar.

    private void comprobar_foto_adjunto(String registroPersonal) {
        Object idFoto, esFotoNueva, statusFoto;
        String mensaje;
        idFoto = 
                JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), "#{bindings.Foto_empleado_id.inputValue}");
        statusFoto = 
                JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                           "#{bindings.Foto_empleado_status.inputValue}");
        esFotoNueva = 
                userSession.getAttribute("esFotoNueva"); //Nos dice si es Foto Nueva o existente
        if (esFotoNueva != null) { //Contiene un valor
            if (esFotoNueva.toString().equalsIgnoreCase("true")) { //Es un foto nueva
                comprobar_foto_nueva(registroPersonal);
            } else { //Es una foto ya existente que se desea cambiar
                comprobar_foto_existente(idFoto, statusFoto, registroPersonal);
                //System.out.println("Hola2");
            }
        } else if (idFoto != null) { //Es una foto ya existente
            comprobar_foto_existente(idFoto, statusFoto, registroPersonal);
            //System.out.println("Hola3");
        } else {
            mensaje = 
                    "¡¡No se pudo obtener el ID de la foto. Intente de nuevo por favor!!";
            mensaje(mensaje, 3); // 3 = tipo ERROR
            //System.out.println("Hola4");
        }
    }

    public String btn_foto_empleado_comprobar_action() {
        Object registroPersonalObj;
        registroPersonalObj = 
                JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                           "#{bindings.RegistroEmpleado.inputValue}");
        if (registroPersonalObj != 
            null) { //Está correcto, se procede a comprobar 
            comprobar_foto_adjunto(registroPersonalObj.toString()); //se invoca procedimiento que comprueba la foto que se desea adjuntar
        }
        return null;
    }

    //Función que guarda la foto en la base de datos

    private void guardar_foto(Object archivoAdjunto) {
        UploadedFile archivo;
        String mensaje = "";
        Object idTipoArchivo, idArchivoAdjunto;
        Object esFotoNueva; //, archivo;
        archivo = (UploadedFile)archivoAdjunto;
        if (archivo != null && archivo.getLength() > 0) {
            //Guardará el archivo adjunto sí y solo si es Foto Nueva ó la Foto no está Confirmada.
            idTipoArchivo = 
                    JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                               "#{bindings.Foto_empleado_idTipoDocumento.inputValue}").toString();
            idArchivoAdjunto = 
                    JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                               "#{bindings.Foto_empleado_id.inputValue}").toString();
            if (guardar_archivo(archivo, idTipoArchivo, 
                                        idArchivoAdjunto) == true) {
                esFotoNueva = userSession.getAttribute("esFotoNueva");
                if (esFotoNueva != null && 
                    esFotoNueva.toString().equalsIgnoreCase("true")) { //Es Foto Nueva
                    mensaje = "¡¡Foto guardada correctamente!!";
                } else {
                    mensaje = "!!Foto actualizada correctamente!!";
                }
                mensaje(mensaje, 1); // 1 = tipo INFO
                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                         "Exe_foto_empleado");
                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                         "Exe_documentos_adjuntos"); //Se actualiza la tabla de Documentos Adjuntos También
                this.getBtn_foto_empleado_guardar().setDisabled(true); //botón Guardar
                this.getBtn_foto_empleado_adjuntar().setDisabled(true); //botón Adjuntar Foto
                this.getBtn_foto_empleado_comprobar().setDisabled(false); //botón Comprobar Foto                               
                userSession.setAttribute("esFotoNueva", "false");
            }
        } else { //No se pudo obtener el archivo que se seleccionó
            mensaje = 
                    "No se pudo guardar la foto seleccionada. Cancele el procedimiento e intente de nuevo por favor!!";
            mensaje(mensaje, 3); // 3 = tipo ERROR
        }
    }

    public String btn_foto_empleado_guardar_action() {
        String mensaje = "";
        Object archivoAdjunto;
        try {
            archivoAdjunto = this.getInptFile_foto_empleado().getValue();
            if (archivoAdjunto != null) {
                guardar_foto(archivoAdjunto);
            } else {
                mensaje = 
                        "¡¡No se pudo guardar la foto!! Intente de nuevo por favor";
                mensaje(mensaje, 3); // 3 = tipo ERROR
            }
        } catch (Exception eas) {
            eas.printStackTrace();
            mensaje = 
                    "Ha ocurrido un error inesperado. Intente de nuevo por favor. Descripción: " + 
                    eas.getMessage();
            mensaje(mensaje, 3); // 3 = tipo ERROR
        }
        return null;
    }

    public void setBtn_cancelar_paso5(CoreCommandButton btn_cancelar_paso5) {
        this.btn_cancelar_paso5 = btn_cancelar_paso5;
    }

    public CoreCommandButton getBtn_cancelar_paso5() {
        return btn_cancelar_paso5;
    }

    public String btn_confirmar_foto_action() {
        String mensaje = "Foto Confirmada Exitósamente!!";
        //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"validarFotoEmpleado");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                 "ConfirmarFoto");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                 "Exe_foto_empleado");
        mensaje(mensaje, 1); // 1 = tipo INFO
        return null;
    }

    public String btn_eliminar_referencia_personal_action() {
        // Add event code here...
        String mensaje = "¡¡Referencia personal eliminada correctamente!!";
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                 "EliminarReferenciaPersonal");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                 "Exe_referencias_empleado");
        mensaje(mensaje, 1); // 1 = tipo INFO
        return null;
    }

    public String btn_eliminar_experiencia_laboral_action() {
        // Add event code here...
        String mensaje = "¡¡Experiencia laboral eliminada correctamente!!";
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                 "EliminarExperienciaLaboral");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                 "Exe_experiencias_empleado");
        mensaje(mensaje, 1); // 1 = tipo INFO
        return null;
    }

    public void setInptText_nombre_referencia_pers(CoreInputText inptText_nombre_referencia_pers) {
        this.inptText_nombre_referencia_pers = inptText_nombre_referencia_pers;
    }

    public CoreInputText getInptText_nombre_referencia_pers() {
        return inptText_nombre_referencia_pers;
    }

    public void setInptText_telefono_referencia_pers(CoreInputText inptText_telefono_referencia_pers) {
        this.inptText_telefono_referencia_pers = inptText_telefono_referencia_pers;
    }

    public CoreInputText getInptText_telefono_referencia_pers() {
        return inptText_telefono_referencia_pers;
    }

    public void setInptText_email_referencia_pers(CoreInputText inptText_email_referencia_pers) {
        this.inptText_email_referencia_pers = inptText_email_referencia_pers;
    }

    public CoreInputText getInptText_email_referencia_pers() {
        return inptText_email_referencia_pers;
    }

    public void setInptText_email_institucional(CoreInputText inptText_email_institucional) {
        this.inptText_email_institucional = inptText_email_institucional;
    }

    public CoreInputText getInptText_email_institucional() {
        return inptText_email_institucional;
    }
}
