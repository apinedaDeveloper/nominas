package interfaz_usuario.backing.gestiones_postmortem;

import enlace_datos.util.resulOp;

import interfaz_usuario.util.JSFUtils;
import interfaz_usuario.util.utils;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import oracle.adf.view.faces.component.core.input.CoreInputText;
import oracle.adf.view.faces.component.core.input.CoreSelectInputDate;
import oracle.adf.view.faces.component.core.input.CoreSelectOneChoice;
import oracle.adf.view.faces.component.core.layout.CorePanelLabelAndMessage;
import oracle.adf.view.faces.component.core.nav.CoreCommandButton;
import oracle.adf.view.faces.component.core.nav.CoreCommandLink;
import oracle.adf.view.faces.component.core.output.CoreOutputFormatted;
import oracle.adf.view.faces.component.core.output.CoreOutputText;
import oracle.adf.view.faces.event.ReturnEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.JboException;

import oracle.jbo.domain.Number;

import pkg_util_base_datos.interfaz_DB;


public class Postmortem_detalle {
    private CoreCommandButton cmdBtn_cancelar;
    private CoreCommandButton cmdBtn_guardar;
    private CoreCommandButton cmdBtn_retornar;
    private CoreCommandLink cdmLink_buscarTrabajador;
    private CoreInputText inptText_cuiSolicitante;
    private CoreInputText inptText_cuiTrabajador;
    private CoreInputText inptText_descripcionExpFallec;
    private CoreInputText inptText_nombreCompleto;
    private CoreInputText inptText_nombreEstadoTrabajador;
    private CoreInputText inptText_nombreSolicitante;
    private CoreInputText inptText_numeroExpFallec;
    private CoreInputText inptText_otroParentescoSol;
    private CoreInputText inptText_registroEmpleado;
    private CoreOutputFormatted outFormat_rotuloNuevaSol;
    private CoreOutputText outputText_fechaFallecTrab;
    private CorePanelLabelAndMessage pnlLbl_correlativoSol;
    private CorePanelLabelAndMessage pnlLbl_estadoActualSol;
    private CorePanelLabelAndMessage pnlLbl_idSolicitud;
    private CoreSelectOneChoice slctOneChoice_parentescoSol;
    private CoreSelectOneChoice slctOneChoice_tipoCarreraLab;
    private CoreInputText inptText_AniosServicio;
    private CoreInputText inptText_MesesServicio;
    private CoreInputText inptText_DiasServicio;
    private CoreInputText inptText_sueldoPromedio;
    private CoreSelectInputDate slctInputDate_fechaSolicitud;

    public void setInptText_registroEmpleado(CoreInputText inptText_registroEmpleado) {
        this.inptText_registroEmpleado = inptText_registroEmpleado;
    }

    public CoreInputText getInptText_registroEmpleado() {
        return inptText_registroEmpleado;
    }

    public void setCdmLink_buscarTrabajador(CoreCommandLink cdmLink_buscarTrabajador) {
        this.cdmLink_buscarTrabajador = cdmLink_buscarTrabajador;
    }

    public CoreCommandLink getCdmLink_buscarTrabajador() {
        return cdmLink_buscarTrabajador;
    }

    public void setInptText_nombreCompleto(CoreInputText inptText_nombreCompleto) {
        this.inptText_nombreCompleto = inptText_nombreCompleto;
    }

    public CoreInputText getInptText_nombreCompleto() {
        return inptText_nombreCompleto;
    }

    //Prodecimiento que Despliega el error detalladamente

    private void desplegarErrores(List pErrores) {
        int vCantidadErrores = pErrores.size();
        JboException vError;
        resulOp vResultado = new resulOp();
        for (int vContador = 0; vContador < vCantidadErrores; vContador++) {
            if (pErrores.get(vContador).getClass() == JboException.class) {
                vError = (JboException)pErrores.get(vContador);
                vResultado.setMensajeError(vError.getMessage());
                vResultado.setCodigoResultado(resulOp.OPE_ERROR);
                utils.setADFMensaje(vResultado);
            }
        }
    }

    //Función que realiza el commit a la base de Datos

    private boolean commit(FacesContext f) {
        boolean correcto = false;
        OperationBinding operationBinding;
        BindingContainer cont = 
            (BindingContainer)JSFUtils.resolveExpression(f, "#{bindings}");
        operationBinding = cont.getOperationBinding("Confirmar");
        operationBinding.execute(); //Ejecutamos el Commit
        if (operationBinding.getErrors().isEmpty()) {
            correcto = true;
        } else { //Hubo error al ejecutar el Commit
            desplegarErrores(operationBinding.getErrors()); //Despliega el detalle de los errores
            operationBinding = cont.getOperationBinding("Rollback");
            operationBinding.execute();
        }
        return correcto;
    }

    //Procedimiento que muestra un mensaje en la pantalla de tipos: 1=INFO, 2=ADVERTENCIA y 3=ERROR

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
        context.addMessage("El control", fm);
    }

    //Obtiene los datos del expediente en que se registró el fallecimiento

    /*private void obtener_expediente_fallecimiento(String regEmpleado,
                                                  interfaz_DB interfaz) {
        String consulta = "select id_solicitud, fecha_solicitud, observacion ";
        consulta += "from sis_solicitud where id_tipo_solicitud = 9 ";
        consulta += "and id_estado = 39 and ";
        consulta += "registro_empleado = " + regEmpleado;
        Object idSolicitud =
            interfaz.getValorConsultaSimple("id_solicitud", consulta);
        Object fechaSolicitud =
            interfaz.getValorConsultaSimple("fecha_solicitud", consulta);
        Object observacion =
            interfaz.getValorConsultaSimple("observacion", consulta);
        this.getOutputText_fechaFallecTrab().setValue(fechaSolicitud);
        this.getInptText_numeroExpFallec().setSubmittedValue(null);
        this.getInptText_numeroExpFallec().setValue(idSolicitud);
        this.getInptText_descripcionExpFallec().setSubmittedValue(null);
        this.getInptText_descripcionExpFallec().setValue(observacion);
    }*/

    public void cdmLink_buscarTrabajador_returnListener(ReturnEvent returnEvent) {
        String registroEmpleado;
        interfaz_DB interfaz = new interfaz_DB();
        if (returnEvent.getReturnValue() != null) {
            registroEmpleado = returnEvent.getReturnValue().toString();
            String consulta = "select EMPL.NOMBRECOMPLETO, ";
            consulta += "EST.NOMBRE AS ESTADO_TRABAJADOR, ";
            consulta += "EMPL.CUI from SIIF.SIS_EMPLEADO_VW EMPL ";
            consulta += "INNER JOIN SIIF.SIS_ESTADO EST ";
            consulta += "ON EMPL.ID_ESTADO = EST.ID_ESTADO ";
            consulta += "WHERE REGISTRO_EMPLEADO = " + registroEmpleado;
            Object nombreCompleto = 
                interfaz.getValorConsultaSimple("NOMBRECOMPLETO", consulta);
            Object cuiTrabajador = 
                interfaz.getValorConsultaSimple("CUI", consulta);
            if (nombreCompleto != null) {
                this.getInptText_registroEmpleado().setSubmittedValue(null);
                this.getInptText_registroEmpleado().setValue(returnEvent.getReturnValue());
                this.getInptText_nombreCompleto().setSubmittedValue(null);
                this.getInptText_nombreCompleto().setValue(nombreCompleto);
                this.getInptText_cuiTrabajador().setSubmittedValue(null);
                this.getInptText_cuiTrabajador().setValue(cuiTrabajador);
                //obtener_expediente_fallecimiento(registroEmpleado, interfaz);
            } else {
                mensaje("¡¡No se pudieron recuperar los datos del trabajador. Intente de nuevo por favor!!", 
                        3);
            }
        }
        interfaz.cn_Cerrar_coneccion();
    }

    public void setInptText_cuiTrabajador(CoreInputText inptText_cuiTrabajador) {
        this.inptText_cuiTrabajador = inptText_cuiTrabajador;
    }

    public CoreInputText getInptText_cuiTrabajador() {
        return inptText_cuiTrabajador;
    }

    public void setInptText_nombreEstadoTrabajador(CoreInputText inptText_nombreEstadoTrabajador) {
        this.inptText_nombreEstadoTrabajador = inptText_nombreEstadoTrabajador;
    }

    public CoreInputText getInptText_nombreEstadoTrabajador() {
        return inptText_nombreEstadoTrabajador;
    }

    public void setCmdBtn_guardar(CoreCommandButton cmdBtn_guardar) {
        this.cmdBtn_guardar = cmdBtn_guardar;
    }

    public CoreCommandButton getCmdBtn_guardar() {
        return cmdBtn_guardar;
    }

    public void setCmdBtn_cancelar(CoreCommandButton cmdBtn_cancelar) {
        this.cmdBtn_cancelar = cmdBtn_cancelar;
    }

    public CoreCommandButton getCmdBtn_cancelar() {
        return cmdBtn_cancelar;
    }

    //Comprueba si un trabajador ya falleció

    private boolean comprobarFallecimientoTrabajador(FacesContext f) {
        boolean correcto = false;
        Object aux = 
            JSFUtils.EjecutarAcccion(f, "ComprobarTrabajadorFallecido");
        if (aux != null) {
            int resultado = Integer.parseInt(aux.toString());
            if (resultado >= 1) {
                correcto = true;
            } else {
                mensaje("¡¡No hay un fallecimiento registrado para el trabajador seleccionado!!", 
                        3);
            }
        } else {
            mensaje("Error al intentar verificar si hay un fallecimiento registrado para el trabajador seleccionado!!", 
                    3);
        }
        return correcto;
    }

    //valida la información ingresada antes de guardarla

    private boolean validarInformacionIngresada(FacesContext f) {
        boolean valido = false;
        boolean continuar = false;
        Object registroPersonal = 
            this.getInptText_registroEmpleado().getValue();
        Number aniosServicio = 
            (Number)this.getInptText_AniosServicio().getValue();
        Number mesesServicio = 
            (Number)this.getInptText_MesesServicio().getValue();
        Number diasServicio = 
            (Number)this.getInptText_DiasServicio().getValue();
        Number sueldoPromedio = 
            (Number)this.getInptText_sueldoPromedio().getValue();
        oracle.jbo.domain.Date fechaSolicitud = 
            (oracle.jbo.domain.Date)this.getSlctInputDate_fechaSolicitud().getValue();
        if (registroPersonal == null || 
            registroPersonal.toString().compareTo("") == 0) {
            mensaje("¡¡Ingrese trabajador para continuar, por favor!!", 3);
        } else if (!comprobarFallecimientoTrabajador(f)) {
            //Sí hubo error se mostro en la función invocada
        } else if ((aniosServicio == null || aniosServicio.intValue() <= 0) && 
                   (mesesServicio == null || mesesServicio.intValue() <= 0) && 
                   (diasServicio == null || diasServicio.intValue() <= 0)) {
            mensaje("!!Ingrese el Tiempo de Servicio para continuar por favor!!", 
                    3);
        } else if (aniosServicio != null && 
                   (aniosServicio.intValue() < 0 || aniosServicio.intValue() > 
                    10) && aniosServicio.intValue() != 12) {
            mensaje("!!Años de Servicio para Cálculo de Prestaciones Inválido (Debe ser entre 0 y 10 o 12)!!", 
                    3);
        } else if (aniosServicio != null && 
                   (aniosServicio.intValue() == 10 || aniosServicio.intValue() == 
                    12)) {
            //los años de servicio están en el rango permitido
            if (mesesServicio != null && mesesServicio.intValue() > 0) {
                mensaje("!!Meses de Servicio Inválido cuando Años de Servicio es 10 o 12 (Debe de ser 0)!!", 
                        3);
            } else if (diasServicio != null && diasServicio.intValue() > 0) {
                mensaje("!!Días de Servicio Inválido cuando Años de Servicio es 10 o 12 (Debe de ser 0)!!", 
                        3);
            } else {
                continuar = true;
            }
        } else if (mesesServicio != null && mesesServicio.intValue() >= 0 && 
                   mesesServicio.intValue() <= 11) {
            //los meses de servicio están en el rango permitido
            if (diasServicio != null && diasServicio.intValue() >= 0 && 
                diasServicio.intValue() <= 29) {
                //los dias de servicio están en el rango permitido
                continuar = true;
            } else if (diasServicio != null) {
                mensaje("!!Días de Servicio para Cálculo de Prestaciones Inválido (debe ser entre 0 y 29)!!", 
                        3);
            } else {
                continuar = true;
            }
        } else if (mesesServicio != null) {
            mensaje("!!Meses de Servicio para Cálculo de Prestaciones Inválido (debe ser entre 0 y 11)!!", 
                    3);
        } else {
            continuar = true;
        }
        if (continuar == true) {
            if (sueldoPromedio == null || sueldoPromedio.doubleValue() <= 0) {
                mensaje("!!Ingrese Sueldo Promedio para continuar, por favor!!", 
                        3);
            } else if (fechaSolicitud == null) {
                mensaje("!!Ingrese Fecha de Solicitud para continuar, por favor!!", 
                        3);
            } else {
                valido = true;
            }
        }
        return valido;
    }

    //Función que obtiene el correlativo de SIS_INDEMNIZACIÓN del año actual para Prestaciones Post-mortem

    private long obtenerUltimoCorrelativo(Number anioActual) {
        long correlativo = 0;
        interfaz_DB interfaz = new interfaz_DB();
        String consulta = "Select max(CORRELATIVO_ANIO) as valor ";
        consulta += "from siif.SIS_INDEMNIZACION ";
        consulta += "where ANIO = " + anioActual.toString() + " ";
        consulta += "AND ID_TIPO_PRESTACION = 2";
        Object varId = interfaz.getValorConsultaSimple("valor", consulta);
        interfaz.cn_Cerrar_coneccion();
        if (varId != null) {
            correlativo = Long.valueOf(varId.toString());
        }
        return correlativo;
    }

    //Procedimiento que obtiene el ID de la solicitud de fallecimiento autorizada del trabajador

    private boolean obtenerId_solicitudFallecimiento(FacesContext f) {
        boolean correcto = false;
        String metodo = "ObtenerIDSolicitudFallecimiento";
        try {
            List errors = JSFUtils.EjecutarAcccion3(f, metodo);
            if (errors.size() == 0) {
                //No hubo errores
                Object res = 
                    JSFUtils.resolveExpression(f, "#{bindings.IdSolicitudFallecRec.inputValue}");
                if (res != null && Integer.parseInt(res.toString()) > 0) {
                    JSFUtils.setExpressionValue(f, 
                                                "#{bindings.IdSolicitudFallecimiento.inputValue}", 
                                                utils.getNumberOracle(res));
                    //System.out.println("El resultado es: " + res);
                    correcto = true;
                } else {
                    mensaje("Error al intentar obtener el ID de la solicitud de fallecimiento!!", 
                            3);
                }
            } else {
                mensaje("Error al intentar obtener el ID de la solicitud de fallecimiento, intente de nuevo por favor!!", 
                        3);
                desplegarErrores(errors);
            }
        } catch (Exception e) {
            e.printStackTrace();
            mensaje("Ha ocurrido el siguiente error: " + e.getMessage(), 3);
        }
        return correcto;
    }

    //Procedimiento que rellena los campos pendientes de un expediente nuevo antes de grabar.

    private boolean rellenarCamposPends_expNuevo(FacesContext f) {
        boolean correcto = false;
        String b1 = "#{bindings.Anio.inputValue}";
        String b2 = "#{bindings.CorrelativoAnio.inputValue}";
        String b3 = "#{bindings.IdEstado.inputValue}";
        String b4 = "#{bindings.IdTipoPrestacion.inputValue}";
        try {
            Number anioActual = utils.getNumberOracle(utils.getAnioActual());
            //System.out.println("El año actual es: " + anioActual);
            //obtenemos el correlativo de la solicitud dependiendo del año actual
            long correlativo = obtenerUltimoCorrelativo(anioActual) + 1;
            JSFUtils.setExpressionValue(f, b1, anioActual);
            JSFUtils.setExpressionValue(f, b2, 
                                        utils.getNumberOracle(correlativo));
            JSFUtils.setExpressionValue(f, b3, utils.getNumberOracle("250"));
            JSFUtils.setExpressionValue(f, b4, utils.getNumberOracle("2"));
            correcto = obtenerId_solicitudFallecimiento(f);
        } catch (Exception e) {
            e.printStackTrace();
            mensaje("Ha ocurrido el siguiente error: " + e.getMessage(), 3);
        }
        return correcto;
    }

    //Procedimiento que procesa el botón guardar

    //private void procesar_guardar(FacesContext f, boolean esNuevaSol) 

    private boolean procesar_guardar(FacesContext f, String bindEsNuevoExp) {
        boolean exito = false;
        if (validarInformacionIngresada(f)) {
            Object esNuevoObj = JSFUtils.resolveExpression(f, bindEsNuevoExp);
            if (esNuevoObj != null) {
                boolean esNuevo = Boolean.parseBoolean(esNuevoObj.toString());
                if (esNuevo) { //Expediente Nuevo
                    if (rellenarCamposPends_expNuevo(f)) {
                        exito = commit(f);
                    }
                } else { //Expediente existente
                    //volverá a obtener el ID de la Solicitud de Fallecimiento
                    if (obtenerId_solicitudFallecimiento(f)) {
                        exito = commit(f);
                    }
                }
            }
        }
        return exito;
    }

    public String cmdBtn_guardar_action() {
        String binding = "#{bindings.EsSolicitudNueva.inputValue}";
        FacesContext f = FacesContext.getCurrentInstance();
        if (procesar_guardar(f, binding)) {
            mensaje("¡¡Información Guardada Correctamente!!", 1);
            JSFUtils.setExpressionValue(f, binding, 
                                        Boolean.parseBoolean("false"));
            JSFUtils.EjecutarAcccion(f, "RefrescarPrestacion");
        }
        return null;
    }

    public String cmdBtn_cancelar_action() {
        FacesContext f = FacesContext.getCurrentInstance();
        BindingContainer cont = 
            (BindingContainer)JSFUtils.resolveExpression(f, "#{bindings}");
        OperationBinding operationBinding = 
            cont.getOperationBinding("Rollback");
        operationBinding.execute(); //Ejecutamos el Commit
        if (operationBinding.getErrors().isEmpty()) {
            mensaje("¡¡Operación cancelada correctamente!!", 1);
            JSFUtils.EjecutarAcccion(f, "RefrescarPrestacion");
        } else {
            desplegarErrores(operationBinding.getErrors()); //Despliega el detalle de los errores
            mensaje("¡¡Hubo un error al cancelar la operación!!", 3);
        }
        //mensaje("¡¡Operación cancelada correctamente!!", 1);
        return null;
    }

    public void setSlctOneChoice_tipoCarreraLab(CoreSelectOneChoice slctOneChoice_tipoCarreraLab) {
        this.slctOneChoice_tipoCarreraLab = slctOneChoice_tipoCarreraLab;
    }

    public CoreSelectOneChoice getSlctOneChoice_tipoCarreraLab() {
        return slctOneChoice_tipoCarreraLab;
    }

    public void setInptText_numeroExpFallec(CoreInputText inptText_numeroExpFallec) {
        this.inptText_numeroExpFallec = inptText_numeroExpFallec;
    }

    public CoreInputText getInptText_numeroExpFallec() {
        return inptText_numeroExpFallec;
    }

    public void setOutputText_fechaFallecTrab(CoreOutputText outputText_fechaFallecTrab) {
        this.outputText_fechaFallecTrab = outputText_fechaFallecTrab;
    }

    public CoreOutputText getOutputText_fechaFallecTrab() {
        return outputText_fechaFallecTrab;
    }

    public void setInptText_descripcionExpFallec(CoreInputText inptText_descripcionExpFallec) {
        this.inptText_descripcionExpFallec = inptText_descripcionExpFallec;
    }

    public CoreInputText getInptText_descripcionExpFallec() {
        return inptText_descripcionExpFallec;
    }

    public void setInptText_nombreSolicitante(CoreInputText inptText_nombreSolicitante) {
        this.inptText_nombreSolicitante = inptText_nombreSolicitante;
    }

    public CoreInputText getInptText_nombreSolicitante() {
        return inptText_nombreSolicitante;
    }

    public void setInptText_cuiSolicitante(CoreInputText inptText_cuiSolicitante) {
        this.inptText_cuiSolicitante = inptText_cuiSolicitante;
    }

    public CoreInputText getInptText_cuiSolicitante() {
        return inptText_cuiSolicitante;
    }

    public void setSlctOneChoice_parentescoSol(CoreSelectOneChoice slctOneChoice_parentescoSol) {
        this.slctOneChoice_parentescoSol = slctOneChoice_parentescoSol;
    }

    public CoreSelectOneChoice getSlctOneChoice_parentescoSol() {
        return slctOneChoice_parentescoSol;
    }

    public void setInptText_otroParentescoSol(CoreInputText inptText_otroParentescoSol) {
        this.inptText_otroParentescoSol = inptText_otroParentescoSol;
    }

    public CoreInputText getInptText_otroParentescoSol() {
        return inptText_otroParentescoSol;
    }

    public void setOutFormat_rotuloNuevaSol(CoreOutputFormatted outFormat_rotuloNuevaSol) {
        this.outFormat_rotuloNuevaSol = outFormat_rotuloNuevaSol;
    }

    public CoreOutputFormatted getOutFormat_rotuloNuevaSol() {
        return outFormat_rotuloNuevaSol;
    }

    public void setPnlLbl_idSolicitud(CorePanelLabelAndMessage pnlLbl_idSolicitud) {
        this.pnlLbl_idSolicitud = pnlLbl_idSolicitud;
    }

    public CorePanelLabelAndMessage getPnlLbl_idSolicitud() {
        return pnlLbl_idSolicitud;
    }

    public void setPnlLbl_correlativoSol(CorePanelLabelAndMessage pnlLbl_correlativoSol) {
        this.pnlLbl_correlativoSol = pnlLbl_correlativoSol;
    }

    public CorePanelLabelAndMessage getPnlLbl_correlativoSol() {
        return pnlLbl_correlativoSol;
    }

    public void setPnlLbl_estadoActualSol(CorePanelLabelAndMessage pnlLbl_estadoActualSol) {
        this.pnlLbl_estadoActualSol = pnlLbl_estadoActualSol;
    }

    public CorePanelLabelAndMessage getPnlLbl_estadoActualSol() {
        return pnlLbl_estadoActualSol;
    }

    public void setCmdBtn_retornar(CoreCommandButton cmdBtn_retornar) {
        this.cmdBtn_retornar = cmdBtn_retornar;
    }

    public CoreCommandButton getCmdBtn_retornar() {
        return cmdBtn_retornar;
    }

    public String cmdBtn_retornar_action() {
        return "ir_a_listado_postmortem";
    }

    public void setInptText_AniosServicio(CoreInputText inptText_AniosServicio) {
        this.inptText_AniosServicio = inptText_AniosServicio;
    }

    public CoreInputText getInptText_AniosServicio() {
        return inptText_AniosServicio;
    }

    public void setInptText_MesesServicio(CoreInputText inptText_MesesServicio) {
        this.inptText_MesesServicio = inptText_MesesServicio;
    }

    public CoreInputText getInptText_MesesServicio() {
        return inptText_MesesServicio;
    }

    public void setInptText_DiasServicio(CoreInputText inptText_DiasServicio) {
        this.inptText_DiasServicio = inptText_DiasServicio;
    }

    public CoreInputText getInptText_DiasServicio() {
        return inptText_DiasServicio;
    }

    public void setInptText_sueldoPromedio(CoreInputText inptText_sueldoPromedio) {
        this.inptText_sueldoPromedio = inptText_sueldoPromedio;
    }

    public CoreInputText getInptText_sueldoPromedio() {
        return inptText_sueldoPromedio;
    }

    public void setSlctInputDate_fechaSolicitud(CoreSelectInputDate slctInputDate_fechaSolicitud) {
        this.slctInputDate_fechaSolicitud = slctInputDate_fechaSolicitud;
    }

    public CoreSelectInputDate getSlctInputDate_fechaSolicitud() {
        return slctInputDate_fechaSolicitud;
    }
}
