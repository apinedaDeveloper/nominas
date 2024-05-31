package interfaz_usuario.backing.gestiones_postmortem;

import enlace_datos.util.resulOp;

import interfaz_usuario.util.JSFUtils;
import interfaz_usuario.util.utils;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import oracle.adf.view.faces.component.core.data.CoreTable;
import oracle.adf.view.faces.component.core.input.CoreInputHidden;
import oracle.adf.view.faces.component.core.input.CoreInputText;
import oracle.adf.view.faces.component.core.input.CoreSelectInputDate;
import oracle.adf.view.faces.component.core.input.CoreSelectOneChoice;
import oracle.adf.view.faces.component.core.layout.CorePanelHorizontal;
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
    private CoreTable tbl_beneficiarios_fallecido;
    private CoreCommandButton cmdBtn_guardar_calculo;
    private CorePanelHorizontal pnlHoriz_prestacCalculadas;
    private CoreOutputFormatted outputFormat_sueldoPromedio;
    private CoreOutputFormatted outputFormat_sueldoPromAnios;
    private CoreOutputFormatted outputFormat_sueldoPromMeses;
    private CoreOutputFormatted outputFormat_sueldoPromDias;
    private CoreOutputFormatted outputFormat_gastoFunerario;
    private CoreOutputFormatted outputFormat_totalPresta;
    private CoreInputText inptText_gastoFunerario;
    private CoreInputHidden inptHidden_totalPrestac;

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
            JSFUtils.EjecutarAcccion(f, "RefrescarPrestaciones");
        }
        return null;
    }

    public String cmdBtn_cancelar_action() {
        FacesContext faces = FacesContext.getCurrentInstance();
        JSFUtils.EjecutarAcccion(faces, "Rollback");
        String bind = "#{bindings.EsSolicitudNueva.inputValue}";
        Object esNuevo = JSFUtils.resolveExpression(faces, bind);
        if (esNuevo != null && Boolean.parseBoolean(esNuevo.toString())) {
            //Es solicitud nueva
            JSFUtils.EjecutarAcccion(faces, "CrearSolicitud");
        }
        this.getPnlHoriz_prestacCalculadas().setRendered(false);
        this.getCmdBtn_guardar_calculo().setDisabled(true);
        mensaje("Operación Cancelada Correctamente", 1);
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

    //Rellena campos pendientes antes de guardar el cálculo

    private boolean rellenarCamposPends_guardar_calculo(FacesContext f) {
        boolean correcto = false;
        try {
            Object totalPrestacObj;
            Number totalPrestac;
            String bindTotalPrestac = "#{bindings.TotalPrestacion.inputValue}";
            totalPrestacObj = this.getInptHidden_totalPrestac().getValue();
            if (totalPrestacObj != null) {
                totalPrestac = 
                        utils.getNumberOracle(String.format("%.2f", totalPrestacObj));
                JSFUtils.setExpressionValue(f, bindTotalPrestac, totalPrestac);
            }
            correcto = true;
        } catch (Exception e) {
            e.printStackTrace();
            mensaje("Ha ocurrido el siguiente error: " + e.getMessage(), 3);
        }
        return correcto;
    }

    public String cmdBtn_guardar_calculo_action() {
        FacesContext f = FacesContext.getCurrentInstance();
        if (rellenarCamposPends_guardar_calculo(f)) {
            if (commit(f)) {
                mensaje("¡¡Información Guardada Correctamente!!", 1);
                JSFUtils.EjecutarAcccion(f, "RefrescarPrestaciones");
                this.getCmdBtn_guardar_calculo().setDisabled(true);
                this.getPnlHoriz_prestacCalculadas().setRendered(false);
            }
        }
        return null;
    }

    public String cmdBtn_calcular_presta_action() {
        int numFilas = this.getTbl_beneficiarios_fallecido().getRowCount();
        //System.out.println("el número de fila es: " + numFilas);
        if (numFilas > 0) {
            Object aux = this.getInptText_sueldoPromedio().getValue();
            if (aux != null && Double.parseDouble(aux.toString()) > 0) {
                Double sueldoPromedio = Double.parseDouble(aux.toString());
                this.getOutputFormat_sueldoPromedio().setValue(sueldoPromedio);
                //////Ahora se calculará el monto por años meses y días laborados///////
                Object aux2 = this.getInptText_AniosServicio().getValue();
                Object aux3 = this.getInptText_MesesServicio().getValue();
                Object aux4 = this.getInptText_DiasServicio().getValue();
                Object aux5 = this.getInptText_gastoFunerario().getValue();
                if (aux2 != null || aux3 != null || aux4 != null) {
                    int aniosLab = 0;
                    if (aux2 != null && 
                        Integer.parseInt(aux2.toString()) > 0) {
                        aniosLab = Integer.valueOf(aux2.toString()).intValue();
                    }
                    int mesesLab = 0;
                    if (aux3 != null && 
                        Integer.parseInt(aux3.toString()) > 0) {
                        mesesLab = Integer.valueOf(aux3.toString()).intValue();
                    }
                    int diasLab = 0;
                    if (aux4 != null && 
                        Integer.parseInt(aux4.toString()) > 0) {
                        diasLab = Integer.valueOf(aux4.toString()).intValue();
                    }
                    double gastoFunerario = 0;
                    if (aux5 != null && 
                        Double.parseDouble(aux5.toString()) > 0) {
                        gastoFunerario = 
                                Double.valueOf(aux5.toString()).doubleValue();
                    }
                    double sueldoPromRedon = 
                        Math.round(sueldoPromedio * 100.0) / 100.0;
                    double montoIndAnios = aniosLab * sueldoPromRedon;
                    double montoIndMeses = (mesesLab * sueldoPromRedon) / 12;
                    montoIndMeses = Math.round(montoIndMeses * 100.0) / 100.0;
                    double montoIndDias = (diasLab * sueldoPromRedon) / 365;
                    montoIndDias = Math.round(montoIndDias * 100.0) / 100.0;
                    double totalPrestaciones = 
                        montoIndAnios + montoIndMeses + montoIndDias + 
                        gastoFunerario;
                    this.getOutputFormat_sueldoPromAnios().setValue(montoIndAnios);
                    this.getOutputFormat_sueldoPromMeses().setValue(montoIndMeses);
                    this.getOutputFormat_sueldoPromDias().setValue(montoIndDias);
                    this.getOutputFormat_gastoFunerario().setValue(gastoFunerario);
                    this.getOutputFormat_totalPresta().setValue(totalPrestaciones);
                    //////almacenamos el valor calculad en el input hiddens creado para este propósito/////
                    this.getInptHidden_totalPrestac().setValue(totalPrestaciones);
                }
                //////////////////////////////////////////////////////////////////
                this.getPnlHoriz_prestacCalculadas().setRendered(true);
                this.getCmdBtn_guardar_calculo().setDisabled(false);
            } else {
                mensaje("¡¡No hay Sueldo Promedio para realizar el cálculo de Prestaciones, verifique por favor!!", 
                        3);
            }
        } else {
            mensaje("¡¡No hay beneficiarios aún, verifique por favor!!", 3);
        }
        return null;
    }

    public void setTbl_beneficiarios_fallecido(CoreTable tbl_beneficiarios_fallecido) {
        this.tbl_beneficiarios_fallecido = tbl_beneficiarios_fallecido;
    }

    public CoreTable getTbl_beneficiarios_fallecido() {
        return tbl_beneficiarios_fallecido;
    }

    public void setCmdBtn_guardar_calculo(CoreCommandButton cmdBtn_guardar_calculo) {
        this.cmdBtn_guardar_calculo = cmdBtn_guardar_calculo;
    }

    public CoreCommandButton getCmdBtn_guardar_calculo() {
        return cmdBtn_guardar_calculo;
    }

    public void setPnlHoriz_prestacCalculadas(CorePanelHorizontal pnlHoriz_prestacCalculadas) {
        this.pnlHoriz_prestacCalculadas = pnlHoriz_prestacCalculadas;
    }

    public CorePanelHorizontal getPnlHoriz_prestacCalculadas() {
        return pnlHoriz_prestacCalculadas;
    }

    public void setOutputFormat_sueldoPromedio(CoreOutputFormatted outputFormat_sueldoPromedio) {
        this.outputFormat_sueldoPromedio = outputFormat_sueldoPromedio;
    }

    public CoreOutputFormatted getOutputFormat_sueldoPromedio() {
        return outputFormat_sueldoPromedio;
    }

    public void setOutputFormat_sueldoPromAnios(CoreOutputFormatted outputFormat_sueldoPromAnios) {
        this.outputFormat_sueldoPromAnios = outputFormat_sueldoPromAnios;
    }

    public CoreOutputFormatted getOutputFormat_sueldoPromAnios() {
        return outputFormat_sueldoPromAnios;
    }

    public void setOutputFormat_sueldoPromMeses(CoreOutputFormatted outputFormat_sueldoPromMeses) {
        this.outputFormat_sueldoPromMeses = outputFormat_sueldoPromMeses;
    }

    public CoreOutputFormatted getOutputFormat_sueldoPromMeses() {
        return outputFormat_sueldoPromMeses;
    }

    public void setOutputFormat_sueldoPromDias(CoreOutputFormatted outputFormat_sueldoPromDias) {
        this.outputFormat_sueldoPromDias = outputFormat_sueldoPromDias;
    }

    public CoreOutputFormatted getOutputFormat_sueldoPromDias() {
        return outputFormat_sueldoPromDias;
    }

    public void setOutputFormat_gastoFunerario(CoreOutputFormatted outputFormat_gastoFunerario) {
        this.outputFormat_gastoFunerario = outputFormat_gastoFunerario;
    }

    public CoreOutputFormatted getOutputFormat_gastoFunerario() {
        return outputFormat_gastoFunerario;
    }

    public void setOutputFormat_totalPresta(CoreOutputFormatted outputFormat_totalPresta) {
        this.outputFormat_totalPresta = outputFormat_totalPresta;
    }

    public CoreOutputFormatted getOutputFormat_totalPresta() {
        return outputFormat_totalPresta;
    }

    public void setInptText_gastoFunerario(CoreInputText inptText_gastoFunerario) {
        this.inptText_gastoFunerario = inptText_gastoFunerario;
    }

    public CoreInputText getInptText_gastoFunerario() {
        return inptText_gastoFunerario;
    }

    public void setInptHidden_totalPrestac(CoreInputHidden inptHidden_totalPrestac) {
        this.inptHidden_totalPrestac = inptHidden_totalPrestac;
    }

    public CoreInputHidden getInptHidden_totalPrestac() {
        return inptHidden_totalPrestac;
    }
}
