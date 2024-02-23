package interfaz_usuario.backing.gestiones_indem;

import enlace_datos.util.resulOp;

import interfaz_usuario.servlets.verReporteExcel;

import interfaz_usuario.util.JSFUtils;
import interfaz_usuario.util.utils;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.adf.view.faces.component.core.CoreForm;
import oracle.adf.view.faces.component.core.data.CoreTable;
import oracle.adf.view.faces.component.core.input.CoreInputHidden;
import oracle.adf.view.faces.component.core.input.CoreInputText;
import oracle.adf.view.faces.component.core.input.CoreSelectBooleanCheckbox;
import oracle.adf.view.faces.component.core.input.CoreSelectInputDate;
import oracle.adf.view.faces.component.core.input.CoreSelectOneChoice;
import oracle.adf.view.faces.component.core.layout.CorePanelBox;
import oracle.adf.view.faces.component.core.layout.CorePanelForm;
import oracle.adf.view.faces.component.core.layout.CorePanelHorizontal;
import oracle.adf.view.faces.component.core.layout.CoreShowDetailItem;
import oracle.adf.view.faces.component.core.nav.CoreCommandButton;
import oracle.adf.view.faces.component.core.nav.CoreCommandLink;
import oracle.adf.view.faces.component.core.nav.CoreCommandMenuItem;
import oracle.adf.view.faces.component.core.nav.CorePage;
import oracle.adf.view.faces.component.core.output.CoreMessages;
import oracle.adf.view.faces.component.core.output.CoreOutputFormatted;
import oracle.adf.view.faces.component.core.output.CoreOutputText;
import oracle.adf.view.faces.component.html.HtmlBody;
import oracle.adf.view.faces.component.html.HtmlHead;
import oracle.adf.view.faces.component.html.HtmlHtml;
import oracle.adf.view.faces.event.ReturnEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.JboException;
import oracle.jbo.domain.Number;

import pkg_util_base_datos.interfaz_DB;


public class Indemnizacion_detalle {
    private HtmlHtml html1;
    private HtmlHead head1;
    private HtmlBody body1;
    private CoreForm form1;
    private CorePage page1;
    private CoreCommandButton cmdBtn_guardar;
    private CoreCommandButton cmdBtn_guardar_calculo;
    private CoreInputText inptText_registroEmpleado;
    private CoreInputText inptText_nombreCompleto;
    private CoreInputText inptText_nombreEstadoTrabajador;
    private CoreInputText inptText_IdIndemnizacion;
    private CoreInputText inptText_Correlativo;
    private CoreInputText inptText_IdSolicitud;
    private CoreInputText inptText_EstadoExpediente;
    private CoreInputText inptText_AniosServicio;
    private CoreInputText inptText_MesesServicio;
    private CoreInputText inptText_DiasServicio;
    private CoreCommandMenuItem cmdMenuItem;
    private CoreInputText inptText_cuiTrabajador;
    private CoreSelectOneChoice slctOneChoice_tipoCarreraLab;
    private CoreTable tbl_listadoUltimosSueldos_calculo;
    private CoreCommandLink cdmLink_buscarEmpl;
    private CoreOutputFormatted outputFormat_importe_calculo;
    private CorePanelHorizontal pnlHoriz_mensajes_calculo;
    private CoreOutputText outputTxt_mensaje2_calculo;
    private CoreOutputFormatted outputFormat_promedio_sueldos_calculo;
    private CoreInputHidden inptHidden_promedioSueldos;
    private CoreInputHidden inptHidden_montoIndemnizacion;
    private CoreOutputFormatted outputFormat_cantidad_contratos_calculo;
    private CoreCommandButton cmdBtn_calcular_prestacion;
    private CoreOutputText outputTxt_mensaje_calculo;
    private CoreShowDetailItem showDetItem_calculo;
    private CoreShowDetailItem showDetItem_solicitud;
    private CoreCommandButton cmdBtn_retornar;
    private CorePanelBox pnlBox_informacionSolicitante;
    private CorePanelForm pnlForm_solicitante;
    private CoreMessages messages_paso1_above;
    private CoreMessages messages_paso1_below;
    private CoreCommandButton cmdBtn_verReporteBasico;
    private CoreCommandLink cmdLink_trasladar_solicitud;
    private CoreCommandButton cmdBtn_retornar_calculo;
    private CoreInputText inptText_serieFacturaPost;
    private CoreInputText inptText_numeroFactPost;
    private CoreSelectInputDate slctInputDate_fechaFactPost;
    private CoreInputText inptText_nombreFunerariaPost;
    private CoreInputText inptText_montoFacturaPost;
    private CoreCommandButton cmdBtn_comprobar_gasto_funerario;
    private CoreCommandButton cmdBtn_guardar_gasto_funerario;
    private CoreCommandButton cmdBtn_retornar_gasto_funerario;
    private CoreCommandLink cmdLink_trasladar_gasto_funerario;
    private CoreCommandLink cmdLink_trasladar_calculo;
    private CoreInputHidden inptHidden_gastoFunerario;
    private CoreCommandButton cmdBtn_verReporteDARHSJI1;
    private CoreCommandButton cmdBtn_guardarRelacionLab;
    private CoreTable tbl_relacionLaboral;
    private CoreSelectInputDate slctInputDate_fechaSolicitud;
    private CoreInputText inptText_motivoRenuncia;
    private CoreSelectBooleanCheckbox slctBooleanCheckBox_bantrab;
    private CoreSelectBooleanCheckbox slctBooleanCheckBox_judicial;
    private CoreSelectBooleanCheckbox slctBooleanCheckBox_cargoCont;
    private CoreSelectBooleanCheckbox slctBooleanCheckBox_otros;
    private CoreInputText inptText_numeroExpRetiro;
    private CoreInputText inptText_fechaExpRetiro;
    private CoreInputText inptText_descripcionExpRetiro;
    private CoreSelectOneChoice slctOneChoice_tipoRetiro;
    private CoreSelectInputDate slctInputDate_fechaRetiro;

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

    public void setPage1(CorePage page1) {
        this.page1 = page1;
    }

    public CorePage getPage1() {
        return page1;
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

    //Función que habilita o deshabilita los campos de texto del formulario

    private void habilitar_componentes_solicitud_detallado(boolean deshabilitado) {
        this.getCdmLink_buscarEmpl().setDisabled(deshabilitado); //botón para buscar trabajador
        this.getSlctInputDate_fechaSolicitud().setDisabled(deshabilitado); //input Fecha de Solicitud
        this.getInptText_motivoRenuncia().setDisabled(deshabilitado); //input Motivo de Renuncia
        this.getInptText_AniosServicio().setDisabled(deshabilitado); //input Años de Servicio
        this.getInptText_MesesServicio().setDisabled(deshabilitado); //input Meses de Servicio
        this.getInptText_DiasServicio().setDisabled(deshabilitado); //input Días de Servicio
        this.getSlctOneChoice_tipoCarreraLab().setDisabled(deshabilitado); //combo Tipo Carrera Laboral
        this.getSlctBooleanCheckBox_bantrab().setDisabled(deshabilitado); //Check box Banco de los trabajadores
        this.getSlctBooleanCheckBox_judicial().setDisabled(deshabilitado); //Check box Judicial
        this.getSlctBooleanCheckBox_cargoCont().setDisabled(deshabilitado); //Check box Cargo Contable
        this.getSlctBooleanCheckBox_otros().setDisabled(deshabilitado); //Check box Otros Pagos pendientes
    }

    //Obtiene los datos del expediente en que se registró el retiro del extrabajador

    private void obtener_expediente_retiro(String regEmpleado, 
                                           interfaz_DB inter) {
        String consulta = 
            "select s.id_solicitud, s.fecha_solicitud, s.observacion, ts.nombre_solicitud ";
        consulta += 
                " from sis_solicitud s inner join sis_tipo_solicitud ts  on ts.id_tipo_solicitud = s.id_tipo_solicitud ";
        consulta += 
                " where s.id_tipo_solicitud in(5,6, 11) and s.id_estado = 39 and ";
        consulta += 
                " s.registro_empleado = " + regEmpleado + " order by s.id_solicitud desc";
        Object idSol = inter.getValorConsultaSimple("id_solicitud", consulta);
        Object fecha = 
            inter.getValorConsultaSimple("fecha_solicitud", consulta);
        Object obs = inter.getValorConsultaSimple("observacion", consulta);
        this.getInptText_numeroExpRetiro().setSubmittedValue(null);
        this.getInptText_numeroExpRetiro().setValue(idSol);
        this.getInptText_fechaExpRetiro().setSubmittedValue(null);
        this.getInptText_fechaExpRetiro().setValue(fecha);
        this.getInptText_descripcionExpRetiro().setSubmittedValue(null);
        this.getInptText_descripcionExpRetiro().setValue(obs);
    }

    public void cdmLink_buscarEmpl_returnListener(ReturnEvent returnEvent) {
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
            Object estadoTrabajador = 
                interfaz.getValorConsultaSimple("ESTADO_TRABAJADOR", consulta);
            Object cuiTrabajador = 
                interfaz.getValorConsultaSimple("CUI", consulta);
            if (nombreCompleto != null) {
                this.getInptText_registroEmpleado().setSubmittedValue(null);
                this.getInptText_registroEmpleado().setValue(returnEvent.getReturnValue());
                this.getInptText_nombreCompleto().setSubmittedValue(null);
                this.getInptText_nombreCompleto().setValue(nombreCompleto);
                this.getInptText_cuiTrabajador().setSubmittedValue(null);
                this.getInptText_cuiTrabajador().setValue(cuiTrabajador);
                /*this.getInptText_nombreEstadoTrabajador().setSubmittedValue(null);
                this.getInptText_nombreEstadoTrabajador().setValue(estadoTrabajador);
                obtener_expediente_retiro(registroEmpleado, interfaz);*/
            } else {
                mensaje("No se pudieron recuperar los datos del trabajador. Intente de nuevo por favor!!", 
                        3);
            }
        }
        interfaz.cn_Cerrar_coneccion();
    }

    //Prodecimiento que Despliega el Error detalladamente

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

    public void setInptText_registroEmpleado(CoreInputText inptText_registroEmpleado) {
        this.inptText_registroEmpleado = inptText_registroEmpleado;
    }

    public CoreInputText getInptText_registroEmpleado() {
        return inptText_registroEmpleado;
    }

    public void setInptText_nombreCompleto(CoreInputText inptText_nombreCompleto) {
        this.inptText_nombreCompleto = inptText_nombreCompleto;
    }

    public CoreInputText getInptText_nombreCompleto() {
        return inptText_nombreCompleto;
    }

    public void setInptText_nombreEstadoTrabajador(CoreInputText inptText_nombreEstadoTrabajador) {
        this.inptText_nombreEstadoTrabajador = inptText_nombreEstadoTrabajador;
    }

    public CoreInputText getInptText_nombreEstadoTrabajador() {
        return inptText_nombreEstadoTrabajador;
    }

    public void setCmdMenuItem(CoreCommandMenuItem cmdMenuItem) {
        this.cmdMenuItem = cmdMenuItem;
    }

    public CoreCommandMenuItem getCmdMenuItem() {
        return cmdMenuItem;
    }

    public void setInptText_IdIndemnizacion(CoreInputText inptText_IdIndemnizacion) {
        this.inptText_IdIndemnizacion = inptText_IdIndemnizacion;
    }

    public CoreInputText getInptText_IdIndemnizacion() {
        return inptText_IdIndemnizacion;
    }

    public void setInptText_Correlativo(CoreInputText inptText_Correlativo) {
        this.inptText_Correlativo = inptText_Correlativo;
    }

    public CoreInputText getInptText_Correlativo() {
        return inptText_Correlativo;
    }

    public void setInptText_IdSolicitud(CoreInputText inptText_IdSolicitud) {
        this.inptText_IdSolicitud = inptText_IdSolicitud;
    }

    public CoreInputText getInptText_IdSolicitud() {
        return inptText_IdSolicitud;
    }

    public void setInptText_EstadoExpediente(CoreInputText inptText_EstadoExpediente) {
        this.inptText_EstadoExpediente = inptText_EstadoExpediente;
    }

    public CoreInputText getInptText_EstadoExpediente() {
        return inptText_EstadoExpediente;
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

    public void setInptText_cuiTrabajador(CoreInputText inptText_cuiTrabajador) {
        this.inptText_cuiTrabajador = inptText_cuiTrabajador;
    }

    public CoreInputText getInptText_cuiTrabajador() {
        return inptText_cuiTrabajador;
    }

    public void setSlctOneChoice_tipoCarreraLab(CoreSelectOneChoice slctOneChoice_tipoCarreraLab) {
        this.slctOneChoice_tipoCarreraLab = slctOneChoice_tipoCarreraLab;
    }

    public CoreSelectOneChoice getSlctOneChoice_tipoCarreraLab() {
        return slctOneChoice_tipoCarreraLab;
    }

    public void setTbl_listadoUltimosSueldos_calculo(CoreTable tbl_listadoUltimosSueldos_calculo) {
        this.tbl_listadoUltimosSueldos_calculo = 
                tbl_listadoUltimosSueldos_calculo;
    }

    public CoreTable getTbl_listadoUltimosSueldos_calculo() {
        return tbl_listadoUltimosSueldos_calculo;
    }

    public void setCdmLink_buscarEmpl(CoreCommandLink cdmLink_buscarEmpl) {
        this.cdmLink_buscarEmpl = cdmLink_buscarEmpl;
    }

    public CoreCommandLink getCdmLink_buscarEmpl() {
        return cdmLink_buscarEmpl;
    }

    public void setCmdBtn_guardar_calculo(CoreCommandButton cmdBtn_guardar_calculo) {
        this.cmdBtn_guardar_calculo = cmdBtn_guardar_calculo;
    }

    public CoreCommandButton getCmdBtn_guardar_calculo() {
        return cmdBtn_guardar_calculo;
    }

    public void setOutputFormat_importe_calculo(CoreOutputFormatted outputFormat_importe_calculo) {
        this.outputFormat_importe_calculo = outputFormat_importe_calculo;
    }

    public CoreOutputFormatted getOutputFormat_importe_calculo() {
        return outputFormat_importe_calculo;
    }

    public void setPnlHoriz_mensajes_calculo(CorePanelHorizontal pnlHoriz_mensajes_calculo) {
        this.pnlHoriz_mensajes_calculo = pnlHoriz_mensajes_calculo;
    }

    public CorePanelHorizontal getPnlHoriz_mensajes_calculo() {
        return pnlHoriz_mensajes_calculo;
    }

    public void setOutputTxt_mensaje2_calculo(CoreOutputText outputTxt_mensaje2_calculo) {
        this.outputTxt_mensaje2_calculo = outputTxt_mensaje2_calculo;
    }

    public CoreOutputText getOutputTxt_mensaje2_calculo() {
        return outputTxt_mensaje2_calculo;
    }

    public void setOutputFormat_promedio_sueldos_calculo(CoreOutputFormatted outputFormat_promedio_sueldos_calculo) {
        this.outputFormat_promedio_sueldos_calculo = 
                outputFormat_promedio_sueldos_calculo;
    }

    public CoreOutputFormatted getOutputFormat_promedio_sueldos_calculo() {
        return outputFormat_promedio_sueldos_calculo;
    }

    public void setInptHidden_promedioSueldos(CoreInputHidden inptHidden_promedioSueldos) {
        this.inptHidden_promedioSueldos = inptHidden_promedioSueldos;
    }

    public CoreInputHidden getInptHidden_promedioSueldos() {
        return inptHidden_promedioSueldos;
    }

    public void setInptHidden_montoIndemnizacion(CoreInputHidden inptHidden_montoIndemnizacion) {
        this.inptHidden_montoIndemnizacion = inptHidden_montoIndemnizacion;
    }

    public CoreInputHidden getInptHidden_montoIndemnizacion() {
        return inptHidden_montoIndemnizacion;
    }

    public void setCmdBtn_guardar(CoreCommandButton cmdBtn_guardar) {
        this.cmdBtn_guardar = cmdBtn_guardar;
    }

    public CoreCommandButton getCmdBtn_guardar() {
        return cmdBtn_guardar;
    }

    //Comprueba si un trabajador ya falleció

    /*private boolean comprobarFallecimientoTrabajador(FacesContext f) {
        boolean correcto = false;
        Object aux =
            JSFUtils.EjecutarAcccion(f, "ComprobarTrabajadorFallecido");
        if (aux != null) {
            int resultado = Integer.parseInt(aux.toString());
            if (resultado >= 1) {
                correcto = true;
            } else {
                mensaje("El trabajador no está fallecido, verifique por favor!!",
                        3);
            }
        } else {
            mensaje("Error al intentar verificar si el trabajador esta fallecido o no, intente de nuevo por favor!!",
                    3);
        }
        return correcto;
    }*/

    //Habilita o deshabilita componentes del formulario al comprobar, guardar o cancelar una solicitud

    private void habilitar_componentes_paso1(boolean deshabilitado) {
        this.getShowDetItem_calculo().setDisabled(deshabilitado);
        //this.getCmdBtn_comprobar().setDisabled(deshabilitado);
        this.getCmdBtn_guardar().setDisabled(!deshabilitado);
        this.getCmdBtn_verReporteBasico().setDisabled(deshabilitado);
        this.getCmdLink_trasladar_solicitud().setDisabled(deshabilitado);
        habilitar_componentes_solicitud_detallado(deshabilitado); //Campos de Texto y Combos
    }

    //comprueba información para prestaciones postmortem

    /*private void comprobar_prestacion_postmortem(FacesContext f) {
        if (comprobarFallecimientoTrabajador(f)) {
            mensaje("Información Comprobada Correctamente!!", 1);
            habilitar_componentes_solicitud(true);
        }
    }*/

    //Función que obtiene el último correlativo de SIS_INDEMNIZACIÓN del año actual para Indemnización por Retiro Definitivo

    private long obtenerUltimoCorrelativo_solicitud(Number anioActual) {
        long correlativo = 0;
        interfaz_DB interfaz = new interfaz_DB();
        String consulta = "Select max(CORRELATIVO_ANIO) as valor ";
        consulta += "from siif.SIS_INDEMNIZACION ";
        consulta += "where ANIO = " + anioActual.toString() + " ";
        consulta += "AND ID_TIPO_PRESTACION = 1";
        Object varId = interfaz.getValorConsultaSimple("valor", consulta);
        interfaz.cn_Cerrar_coneccion();
        if (varId != null) {
            correlativo = Long.valueOf(varId.toString());
        }
        return correlativo;
    }

    //Procedimiento que obtiene el ID de la solicitud de retiro definitivo y lo setea al binding respectivo

    private boolean obtenerId_solicitudRetiro(FacesContext f) {
        boolean correcto = false;
        String b1 = "#{bindings.IdSolicitudRetiro.inputValue}";
        //String b2 = "#{bindings.IdSolicitudRetiro.inputValue}";
        String metodo = "ObtenerIDSolicitudAutorizadaRetiro";
        try {
            List errors = JSFUtils.EjecutarAcccion3(f, metodo);
            if (errors.size() == 0) {
                //No hubo errores y el resultado se guardó en una variable auxiliar
                Object aux = JSFUtils.resolveExpression(f, b1);
                if (aux != null && Integer.parseInt(aux.toString()) > 0) {
                    /*JSFUtils.setExpressionValue(f, b2,
                                                utils.getNumberOracle(aux));*/
                    correcto = true;
                } else {
                    mensaje("Error al intentar obtener el ID de la solicitud autorizada, intente de nuevo por favor!!", 
                            3);
                }
            } else {
                mensaje("Error al intentar obtener el ID de la solicitud autorizada del trabajador, intente de nuevo por favor!!", 
                        3);
                desplegarErrores(errors);
            }
        } catch (Exception e) {
            e.printStackTrace();
            mensaje("Ha ocurrido el siguiente error: " + e.getMessage(), 3);
        }
        return correcto;
    }

    //Procedimiento que rellena los campos pendientes de una solicitud nueva antes de grabar.

    private boolean rellenarCamposPend_expNuevo(FacesContext f) {
        boolean correcto = false;
        String b1 = "#{bindings.Anio.inputValue}";
        String b2 = "#{bindings.CorrelativoAnio.inputValue}";
        String b3 = "#{bindings.IdEstado.inputValue}";
        String b4 = "#{bindings.IdTipoPrestacion.inputValue}";
        //String b5 = "#{bindings.IdSolicitudAutorizadaRetiro.inputValue}";
        //String b6 = "#{bindings.IdSolicitudAutorizadaFallec.inputValue}";
        //String b7 = "#{bindings.IdSolicitudRetiro.inputValue}";
        //String b8 = "ObtenerIDSolicitudAutorizadaRetiro";
        //String b9 = "ObtenerIDSolicitudAutorizadaFallecimiento";
        try {
            Number anioActual = utils.getNumberOracle(utils.getAnioActual());
            //System.out.println("El año actual es: " + anioActual);
            //obtenemos el correlativo de la solicitud dependiendo del año actual
            long correlativo = 
                obtenerUltimoCorrelativo_solicitud(anioActual) + 1;
            JSFUtils.setExpressionValue(f, b1, anioActual);
            JSFUtils.setExpressionValue(f, b2, 
                                        utils.getNumberOracle(correlativo));
            JSFUtils.setExpressionValue(f, b3, utils.getNumberOracle("250"));
            JSFUtils.setExpressionValue(f, b4, utils.getNumberOracle("1"));
            /*Object tipo = JSFUtils.resolveExpression(f, b4); //Tipo de Gestión
            if (tipo != null) {
                if (Integer.parseInt(tipo.toString()) == 1) {
                    //indemnizacion por retiro definitivo
                    correcto = obtenerId_solicitudAutorizada(f, b8, b5, b7);
                } else { //prestaciones post-mortem
                    correcto = obtenerId_solicitudAutorizada(f, b9, b6, b7);
                }
            } else {
                mensaje("No se pudo obtener el tipo de gestión, intente de nuevo por favor!!",
                        3);
            }*/
            //correcto = obtenerId_solicitudRetiro(f);
            correcto = true;
        } catch (Exception e) {
            e.printStackTrace();
            mensaje("Ha ocurrido el siguiente error: " + e.getMessage(), 3);
        }
        return correcto;
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
            mensaje("¡¡No se pudo guardar porque ocurrió un error inesperado. Intente de nuevo por favor!!", 
                    3);
            desplegarErrores(operationBinding.getErrors()); //Despliega el detalle de los errores
            operationBinding = cont.getOperationBinding("Rollback");
            operationBinding.execute();
        }
        return correcto;
    }

    //Verifica si el trabajador ya se retiró de la institución

    private boolean verificarRetiroTrabajador(FacesContext f) {
        boolean retirado = false;
        Object aux = 
            JSFUtils.EjecutarAcccion(f, "ComprobarTrabajadorRetirado");
        if (aux != null) {
            int result = Integer.parseInt(aux.toString());
            if (result >= 1) {
                retirado = true;
            } else {
                mensaje("¡¡El trabajador no aparece como retirado en el sistema, verifique por favor!!", 
                        3);
            }
        } else {
            mensaje("Error al intentar verificar si el trabajador aparece como retirado en el sistema. Intente de nuevo por favor!!", 
                    3);
        }
        return retirado;
    }

    //Valida la información ingresada por el usuario

    private boolean validarInformacionIngresada(FacesContext f) {
        boolean valido = false;
        Object registroPersonal = 
            this.getInptText_registroEmpleado().getValue();
        Object fechaSolicitud = 
            this.getSlctInputDate_fechaSolicitud().getValue();
        //Object tipoCarreraLaboral = this.getSlctOneChoice_tipoCarreraLab().getValue();
        Object aniosServicio = this.getInptText_AniosServicio().getValue();
        Object mesesServicio = this.getInptText_MesesServicio().getValue();
        Object diasServicio = this.getInptText_DiasServicio().getValue();
        Object tipoRetiro = this.getSlctOneChoice_tipoRetiro().getValue();
        if (registroPersonal == null || 
            registroPersonal.toString().compareTo("") == 0) {
            mensaje("¡¡Busque trabajador para continuar por favor!!", 3);
        } else if (fechaSolicitud == null || 
                   fechaSolicitud.toString().compareTo("") == 0) {
            mensaje("!!Ingrese Fecha de Solicitud para continuar por favor!!", 
                    3);
        } else if (aniosServicio != null && 
                   (Integer.parseInt(aniosServicio.toString().trim()) > 99 || 
                    Integer.parseInt(aniosServicio.toString().trim()) <= 0)) {
            mensaje("!!Los Años de Servicio debe ser mayor de 0 y menor de 99!!", 
                    3);
        } else if (mesesServicio != null && 
                   (Integer.parseInt(mesesServicio.toString().trim()) > 11 || 
                    Integer.parseInt(mesesServicio.toString().trim()) < 0)) {
            mensaje("!!Los Meses de Servicio debe ser menor o igual de 11 y mayor o igual a 0!!", 
                    3);
        } else if (diasServicio != null && 
                   (Integer.parseInt(diasServicio.toString().trim()) > 30 || 
                    Integer.parseInt(diasServicio.toString().trim()) < 0)) {
            mensaje("!!Los Días de Servicio debe ser menor o igual de 30 y mayor o igual a 0!!", 
                    3);
        } else if (tipoRetiro == null) {
            mensaje("!!Seleccione un Tipo de Retiro para continuar por favor!!", 
                    3);
        } else {
            oracle.jbo.domain.Date fechaSol = 
                (oracle.jbo.domain.Date)this.getSlctInputDate_fechaSolicitud().getValue();
            oracle.jbo.domain.Date fechaRet = 
                (oracle.jbo.domain.Date)this.getSlctInputDate_fechaRetiro().getValue();
            if (fechaSol != null && fechaRet != null) {
                if (fechaRet.dateValue().after(fechaSol.dateValue())) {
                    mensaje("!!La Fecha de Retiro es más reciente que la Fecha de Solicitud!!", 
                            3);
                } else {
                    valido = true;
                }
            } else {
                valido = true;
            }
        }
        /*else if (Integer.parseInt(aniosServicio.toString().trim()) <= 0 &&
                   Integer.parseInt(mesesServicio.toString().trim()) <= 0 &&
                   Integer.parseInt(diasServicio.toString().trim()) <= 0) {
            mensaje("!!El tiempo de servicio debe ser mayor de 0!!", 3);
        } else if (tipoCarreraLaboral == null) {
            mensaje("!!Seleccione un tipo de carrera laboral para continuar por favor!!",
                    3);
        } else if (verificarRetiroTrabajador(f)) {
            //El trabajador está retirado de la institución
            valido = true;
        }*/
        return valido;
    }

    //Procedimiento que procesa el botón guardar solicitud

    private boolean procesar_guardar(FacesContext f, String bind) {
        boolean exito = false;
        if (validarInformacionIngresada(f)) {
            Object esNuevoObj = JSFUtils.resolveExpression(f, bind);
            if (esNuevoObj != null) {
                boolean esNuevo = Boolean.parseBoolean(esNuevoObj.toString());
                if (esNuevo) { //Solicitud Nueva
                    if (rellenarCamposPend_expNuevo(f)) {
                        exito = commit(f);
                    }
                } else { //Solicitud existente )
                    /*if (rellenarCamposPendientes_solicitudExistente(f)) {
                        exito = commit(f);
                    }*/
                    //if (obtenerId_solicitudRetiro(f)) {
                    exito = commit(f);
                    //}
                }
            } else {
                mensaje("Error al determinar si la solicitud es nueva o no, intente de nuevo por favor!!", 
                        3);
            }
        }
        return exito;
    }

    public String cmdBtn_guardar_action() {
        FacesContext f = FacesContext.getCurrentInstance();
        String binding = "#{bindings.EsSolicitudNueva.inputValue}";
        if (procesar_guardar(f, binding)) {
            mensaje("Solicitud Guardada Correctamente.", 1);
            //habilitar_componentes_paso1(false);
            JSFUtils.setExpressionValue(f, binding, 
                                        Boolean.parseBoolean("false"));
            JSFUtils.EjecutarAcccion(f, "RefrescarIndemnizacion");
        }
        return null;
    }

    public String cmdBtn_cancelar_action() {
        /*FacesContext f = FacesContext.getCurrentInstance();
        Object aux =
            JSFUtils.resolveExpression(f, "#{bindings.EsSolicitudNueva.inputValue}");
        if (aux != null && Boolean.parseBoolean(aux.toString()) == true) {
            //Es solicitud nueva
            JSFUtils.EjecutarAcccion(f, "Crear");
            JSFUtils.EjecutarAcccion(f, "RecuperarMunicipio");
        } else { //Es existente
            JSFUtils.EjecutarAcccion(f, "RecuperarIndemnizacion");
            JSFUtils.EjecutarAcccion(f, "RefrescarIndemnizacion");
        }
        habilitar_componentes_solicitud(false);
        mensaje("Procedimiento cancelado correctamente.", 1);
        return null;*/
        mensaje("Operación Cancelada Correctamente", 1);
        JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(), "Rollback");
        return null;
    }

    public String cmdBtn_retornar_action() {
        return "ir_a_listado_indemnizaciones";
    }

    //Habilita o deshabilita componentes del formulario al calcular, guardar o cancelar el cálculo

    private void habilitar_componentes_calculo(boolean deshabilitado) {
        this.getShowDetItem_solicitud().setDisabled(deshabilitado);
        this.getCmdBtn_calcular_prestacion().setDisabled(deshabilitado);
        this.getCmdBtn_guardar_calculo().setDisabled(!deshabilitado);
        this.getCmdLink_trasladar_calculo().setDisabled(deshabilitado);
    }

    //Calcula la indemnización por retiro definitivo

    private void calcular_indemnizacion(int anios, int meses, int dias, 
                                        FacesContext f) {
        //Total sueldos últimos doce meses
        //Object numSueldObj = 
        //  JSFUtils.EjecutarAcccion(f, "obtenerNumeroSueldos");
        int numSueldos = 
            this.getTbl_listadoUltimosSueldos_calculo().getRowCount();
        if (numSueldos > 0) {
            if (numSueldos > 12) {
                numSueldos = 12;
            }
            //Double numSueldos = Double.parseDouble(numSueldObj.toString());
            //String bind = "#{bindings.NumeroSueldos.inputValue}";
            //JSFUtils.setExpressionValue(f, bind, numSueldos);
            Object aux = JSFUtils.EjecutarAcccion(f, "obtenerTotalSueldos");
            if (aux != null && Double.parseDouble(aux.toString()) > 0) {
                Double totalSueldos = Double.parseDouble(aux.toString());
                Double diferido = totalSueldos / 12;
                Double diferido12 = totalSueldos * .12;
                Double aguinaldo = (totalSueldos + diferido + diferido12) / 12;
                Double bono14 = aguinaldo;
                Double sueldoProm = totalSueldos / 12;
                Double indemnizacion = null;
                if (anios >= 20) {
                    indemnizacion = sueldoProm * 12;
                } else if (anios >= 10) {
                    indemnizacion = sueldoProm * 10;
                } else {
                    indemnizacion = (sueldoProm * anios);
                    indemnizacion += (sueldoProm * (meses * 100 / 12) / 100);
                    indemnizacion += (sueldoProm * (dias * 100 / 365) / 100);
                }
                //Se guardan los resultados en controles ocultos
                this.getInptHidden_promedioSueldos().setValue(sueldoProm);
                this.getInptHidden_montoIndemnizacion().setValue(indemnizacion);
                habilitar_componentes_calculo(true);
                String mensaje = 
                    "Cálculo de Indemnización por Retiro Definitivo realizado correctamente.\n";
                mensaje += " Número de sueldos para promedio " + numSueldos;
                mensaje += 
                        ", total sueldos Q." + String.format("%1$,.2f", totalSueldos);
                mensaje += 
                        ", diferido Q." + String.format("%1$,.2f", diferido);
                mensaje += 
                        ", diferido 12% Q." + String.format("%1$,.2f", diferido12);
                mensaje += 
                        ", aguinaldo Q." + String.format("%1$,.2f", aguinaldo);
                mensaje += ", bono 14 Q." + String.format("%1$,.2f", bono14);
                mensaje += 
                        ", sueldo promedio Q." + String.format("%1$,.2f", sueldoProm);
                mensaje += ", tiempo de servicio: " + anios + " años";
                mensaje += ", " + meses + " meses y " + dias + " días";
                mensaje += 
                        ", indemnización Q." + String.format("%1$,.2f", indemnizacion);
                mensaje(mensaje, 1);
            } else {
                mensaje("No se pudo calcular la indemnización correctamente. Intente de nuevo por favor.", 
                        3);
            }
        } else {
            mensaje("No se pudo calcular la indemnización correctamente. Intente de nuevo por favor.", 
                    3);
        }
    }

    //Procedimiento que calcula la prestación detalladamente

    /*private void calcular_prestaciones_post_detallado(int anios, int meses,
                                                      int dias, String descr,
                                                      Double sueldoPr) {
        Double postMortem = null;
        if (anios >= 20) {
            postMortem = sueldoPr * 12;
        } else if (anios >= 10) {
            postMortem = sueldoPr * 10;
        } else {
            postMortem = (sueldoPr * anios);
            postMortem += (sueldoPr * (meses * 100 / 12) / 100);
            postMortem += (sueldoPr * (dias * 100 / 365) / 100);
        }
        this.getOutputTxt_mensaje_calculo().setValue(descr);
        this.getPnlHoriz_mensajes_calculo().setRendered(true);
        //Se guardan los resultados en controles ocultos
        this.getInptHidden_promedioSueldos().setValue(sueldoPr);
        this.getInptHidden_montoIndemnizacion().setValue(postMortem);
        habilitar_componentes_calculo(true);
        mensaje("Cálculo de prestación post-mortem realizado correctamente.",
                1);
    }*/


    //Calcula las presticiones post-mortem

    /*private void calcular_prestaciones_post(int anios, int meses, int dias,
                                            FacesContext f) {
        String b1 = "ObtenerNumContratosFinalizadorTrab";
        String b2 = "ObtenerContratosTrabajadorFallecido";
        Object aux = JSFUtils.EjecutarAcccion(f, b1);
        if (aux != null && Integer.parseInt(aux.toString()) > 0) {
            String mensaje = "Cantidad de contratos finalizados o dados ";
            mensaje += "de baja al momento del fallecimiento: " + aux;
            Object cont = JSFUtils.EjecutarAcccion(f, b2);
            if (cont != null && cont.toString().compareTo("") != 0) {
                mensaje += " (" + cont.toString() + ")";
            }
            aux = JSFUtils.EjecutarAcccion(f, "ObtenerPromedioSueldos");
            if (aux != null && Double.parseDouble(aux.toString()) > 0) {
                Double sueldoPromedio = Double.parseDouble(aux.toString());
                calcular_prestaciones_post_detallado(anios, meses, dias,
                                                     mensaje, sueldoPromedio);
            } else {
                mensaje("No se pudo obtener el sueldo promedio del trabajador.",
                        3);
            }
        } else {
            mensaje("No hay contratos finalizados o dados de baja al momento del fallecimiento del trabajador.",
                    3);
        }
    }*/

    public String cmdBtn_calcular_action() {
        String b1 = "#{bindings.AniosTiempoServicio.inputValue}";
        String b2 = "#{bindings.MesesTiempoServicio.inputValue}";
        String b3 = "#{bindings.DiasTiempoServicio.inputValue}";
        FacesContext f = FacesContext.getCurrentInstance();
        Object aniosObj = JSFUtils.resolveExpression(f, b1);
        Object mesesObj = JSFUtils.resolveExpression(f, b2);
        Object diasObj = JSFUtils.resolveExpression(f, b3);
        if (aniosObj != null && mesesObj != null && diasObj != null) {
            int anios = Integer.valueOf(aniosObj.toString()).intValue();
            int meses = Integer.valueOf(mesesObj.toString()).intValue();
            int dias = Integer.valueOf(diasObj.toString()).intValue();
            calcular_indemnizacion(anios, meses, dias, f);
        } else {
            mensaje("No se pudo obtener el tiempo de servicio del trabajador. Intente de nuevo por favor!!", 
                    3);
        }
        return null;
    }

    //Rellena campos pendientes antes de guardar el cálculo

    private boolean rellenarCamposPend_guardar_calculo(FacesContext f) {
        Number aux;
        String b1 = "#{bindings.SueldoPromedio.inputValue}";
        //String b2 = "#{bindings.PostMortem.inputValue}";
        String b2 = "#{bindings.TotalPrestacion.inputValue}";
        boolean correcto = false;
        Object promObj = this.getInptHidden_promedioSueldos().getValue();
        Object totalObj = this.getInptHidden_montoIndemnizacion().getValue();
        if (promObj != null && totalObj != null) {
            aux = utils.getNumberOracle(String.format("%.2f", promObj));
            JSFUtils.setExpressionValue(f, b1, aux);
            aux = utils.getNumberOracle(String.format("%.2f", totalObj));
            JSFUtils.setExpressionValue(f, b2, aux);
            correcto = true;
        } else {
            mensaje("No se pudo grabar. Intente de nuevo por favor", 3);
        }
        return correcto;
    }

    public String cmdBtn_guardar_calculo_action() {
        //procesar_guardar_calculo();
        FacesContext f = FacesContext.getCurrentInstance();
        if (rellenarCamposPend_guardar_calculo(f)) {
            if (commit(f)) {
                mensaje("Información grabada correctamente.", 1);
                habilitar_componentes_calculo(false);
                JSFUtils.EjecutarAcccion(f, "RefrescarIndemnizacion");
            }
        }
        return null;
    }

    //Realiza una comprobación básica del formulario

    private boolean comprobarCamposDeTexto_gastoFunerario() {
        boolean valido = false;
        Object serieFactura, numeroFactura, fechaFactura, nombreFuneraria, montoFactura;
        serieFactura = this.getInptText_serieFacturaPost().getValue();
        if (serieFactura != null) {
            serieFactura = serieFactura.toString().trim();
            this.getInptText_serieFacturaPost().setValue(serieFactura);
        }
        numeroFactura = this.getInptText_numeroFactPost().getValue();
        if (numeroFactura != null) {
            numeroFactura = numeroFactura.toString().trim();
            this.getInptText_numeroFactPost().setValue(numeroFactura);
        }
        fechaFactura = this.getSlctInputDate_fechaFactPost().getValue();
        if (fechaFactura != null) {
            fechaFactura = fechaFactura.toString().trim();
        }
        nombreFuneraria = this.getInptText_nombreFunerariaPost().getValue();
        if (nombreFuneraria != null) {
            nombreFuneraria = nombreFuneraria.toString().trim();
            this.getInptText_nombreFunerariaPost().setValue(nombreFuneraria);
        }
        montoFactura = this.getInptText_montoFacturaPost().getValue();
        //System.out.println("hola2");
        if (montoFactura != null) {
            //System.out.println("hola");
            montoFactura = montoFactura.toString().trim();
            this.getInptText_montoFacturaPost().setValue(montoFactura);
        }
        if (serieFactura == null) {
            mensaje("Ingrese la serie de la factura para para continuar por favor!!", 
                    3);
        } else if (numeroFactura == null) {
            mensaje("Ingrese el número de factura para continuar por favor!!", 
                    3);
        } else if (fechaFactura == null) {
            mensaje("Ingrese la fecha de la factura para continuar por favor!!", 
                    3);
        } else if (nombreFuneraria == null) {
            mensaje("Ingrese el nombre de la funeraria para continuar por favor!!", 
                    3);
        } else if (montoFactura == null) {
            mensaje("Ingrese el monto de la factura para continuar por favor!!", 
                    3);
        } else {
            valido = true;
        }
        return valido;
    }

    //Habilita o deshabilita componentes del formulario al comprobar, guardar o cancelar el gasto funerario

    private void habilitar_componentes_gasto_funerario(boolean deshabilitado) {
        this.getShowDetItem_solicitud().setDisabled(deshabilitado);
        this.getShowDetItem_calculo().setDisabled(deshabilitado);
        this.getCmdBtn_comprobar_gasto_funerario().setDisabled(deshabilitado);
        this.getCmdBtn_guardar_gasto_funerario().setDisabled(!deshabilitado);
        this.getCmdLink_trasladar_gasto_funerario().setDisabled(deshabilitado);
    }

    //Comprueba los valores ingresados del gasto funerario detalladamente

    private void comprobar_gasto_funerario_detallado(FacesContext f, 
                                                     double montoFactura, 
                                                     double montoMaximo) {
        double totalPrest;
        String b = "#{bindings.PostMortem.inputValue}";
        //String b2 = "#{bindings.GastoFunerario.inputValue}";
        //String b3 = "#{bindings.TotalPrestacion.inputValue}";
        //Number n1 = utils.getNumberOracle(String.format("%.2f", montoFactura));
        //Number n2 = utils.getNumberOracle(String.format("%.2f", montoMaximo));
        Object postM = JSFUtils.resolveExpression(f, b);
        if (montoFactura <= montoMaximo) {
            //JSFUtils.setExpressionValue(f, b2, n1);
            this.getInptHidden_gastoFunerario().setValue(montoFactura);
            totalPrest = montoFactura + Double.parseDouble(postM.toString());
        } else { //El gasto funerario será el monto máximo a cubrir
            //JSFUtils.setExpressionValue(f, b2, n2);
            this.getInptHidden_gastoFunerario().setValue(montoMaximo);
            totalPrest = montoMaximo + Double.parseDouble(postM.toString());
        }
        //Number n3 = utils.getNumberOracle(totalPrest);
        //JSFUtils.setExpressionValue(f, b3, n3);
        this.getInptHidden_montoIndemnizacion().setValue(totalPrest);
        mensaje("Gasto funerario comprobado con éxito", 1);
        if (montoFactura > montoMaximo) {
            Number n = utils.getNumberOracleFormato(montoMaximo);
            mensaje("El monto máximo a cubrir va a ser de: Q." + n, 1);
        }
        habilitar_componentes_gasto_funerario(true);
        JSFUtils.EjecutarAcccion(f, "RefrescarIndemnizacion");
    }

    //Comprueba los valores ingresado del gasto funerario

    private void comprobar_gasto_funerario() {
        String b1 = "#{bindings.SueldoPromedio.inputValue}";
        String b2 = "#{bindings.MontoFacturaPost.inputValue}";
        FacesContext f = FacesContext.getCurrentInstance();
        Object aux = JSFUtils.resolveExpression(f, b1);
        if (aux != null && Double.parseDouble(aux.toString()) > 0) {
            double sueldoProm = Double.parseDouble(aux.toString());
            double montoMax = sueldoProm - 412.50;
            if (montoMax > 0) { //Se determinó el monto máximo a cubrir
                aux = JSFUtils.resolveExpression(f, b2); //monto de la factura
                if (aux != null && Double.parseDouble(aux.toString()) >= 160) {
                    double montoFact = Double.parseDouble(aux.toString());
                    comprobar_gasto_funerario_detallado(f, montoFact, 
                                                        montoMax);
                } else {
                    mensaje("El monto de la factura del gasto funerario debe ser de al menos de Q160.00.", 
                            3);
                }
            } else {
                mensaje("El monto máximo a cubrir dió resultado 0 o negativo, verifique por favor.", 
                        3);
            }
        } else {
            mensaje("Calcule primeramente el sueldo promedio para continuar por favor.", 
                    3);
        }
    }

    public String cmdBtn_comprobar_gasto_funerario_action() {
        if (comprobarCamposDeTexto_gastoFunerario()) {
            comprobar_gasto_funerario();
        }
        return null;
    }

    //Rellena campos pendientes antes de guardar el gasto funerario

    private void rellenarCamposPendientes_guardar_gasto_fun(FacesContext f) {
        Number aux;
        String b1 = "#{bindings.GastoFunerario.inputValue}";
        String b2 = "#{bindings.TotalPrestacion.inputValue}";
        Object gastoFunObj = this.getInptHidden_gastoFunerario().getValue();
        if (gastoFunObj != null) {
            aux = utils.getNumberOracle(String.format("%.2f", gastoFunObj));
            JSFUtils.setExpressionValue(f, b1, aux);
        }
        Object totalObj = this.getInptHidden_montoIndemnizacion().getValue();
        if (totalObj != null) {
            aux = utils.getNumberOracle(String.format("%.2f", totalObj));
            JSFUtils.setExpressionValue(f, b2, aux);
        }
    }

    //Procesa el guardar gasto funerario.

    private void procesar_guardar_gasto_funerario() {
        FacesContext f = FacesContext.getCurrentInstance();
        rellenarCamposPendientes_guardar_gasto_fun(f);
        if (commit(f)) {
            mensaje("Información grabada correctamente.", 1);
            habilitar_componentes_gasto_funerario(false);
            JSFUtils.EjecutarAcccion(f, "RefrescarIndemnizacion");
        }
    }

    public String cmdBtn_guardar_gasto_funerario_action() {
        procesar_guardar_gasto_funerario();
        return null;
    }

    public void setOutputFormat_cantidad_contratos_calculo(CoreOutputFormatted outputFormat_cantidad_contratos_calculo) {
        this.outputFormat_cantidad_contratos_calculo = 
                outputFormat_cantidad_contratos_calculo;
    }

    public CoreOutputFormatted getOutputFormat_cantidad_contratos_calculo() {
        return outputFormat_cantidad_contratos_calculo;
    }

    public void setCmdBtn_calcular_prestacion(CoreCommandButton cmdBtn_calcular_prestacion) {
        this.cmdBtn_calcular_prestacion = cmdBtn_calcular_prestacion;
    }

    public CoreCommandButton getCmdBtn_calcular_prestacion() {
        return cmdBtn_calcular_prestacion;
    }

    public void setOutputTxt_mensaje_calculo(CoreOutputText outputTxt_mensaje_calculo) {
        this.outputTxt_mensaje_calculo = outputTxt_mensaje_calculo;
    }

    public CoreOutputText getOutputTxt_mensaje_calculo() {
        return outputTxt_mensaje_calculo;
    }

    public void setShowDetItem_calculo(CoreShowDetailItem showDetItem_calculo) {
        this.showDetItem_calculo = showDetItem_calculo;
    }

    public CoreShowDetailItem getShowDetItem_calculo() {
        return showDetItem_calculo;
    }

    public void setShowDetItem_solicitud(CoreShowDetailItem showDetItem_solicitud) {
        this.showDetItem_solicitud = showDetItem_solicitud;
    }

    public CoreShowDetailItem getShowDetItem_solicitud() {
        return showDetItem_solicitud;
    }

    public String cmdBtn_cancelar_calculo_action() {
        FacesContext f = FacesContext.getCurrentInstance();
        //Reseteamos y ocultamos los mensajes
        this.getOutputTxt_mensaje_calculo().setValue(null);
        this.getInptHidden_promedioSueldos().setValue(null);
        this.getInptHidden_montoIndemnizacion().setValue(null);
        this.getPnlHoriz_mensajes_calculo().setRendered(false);
        JSFUtils.EjecutarAcccion(f, "recuperarExpediente");
        JSFUtils.EjecutarAcccion(f, "RefrescarIndemnizacion");
        habilitar_componentes_calculo(false);
        mensaje("Se cancelaron los cambios no guardados correctamente.", 1);
        return null;
    }

    public void setCmdBtn_retornar(CoreCommandButton cmdBtn_retornar) {
        this.cmdBtn_retornar = cmdBtn_retornar;
    }

    public CoreCommandButton getCmdBtn_retornar() {
        return cmdBtn_retornar;
    }

    public void setPnlBox_informacionSolicitante(CorePanelBox pnlBox_informacionSolicitante) {
        this.pnlBox_informacionSolicitante = pnlBox_informacionSolicitante;
    }

    public CorePanelBox getPnlBox_informacionSolicitante() {
        return pnlBox_informacionSolicitante;
    }

    public void setPnlForm_solicitante(CorePanelForm pnlForm_solicitante) {
        this.pnlForm_solicitante = pnlForm_solicitante;
    }

    public CorePanelForm getPnlForm_solicitante() {
        return pnlForm_solicitante;
    }

    public void setMessages_paso1_above(CoreMessages messages_paso1_above) {
        this.messages_paso1_above = messages_paso1_above;
    }

    public CoreMessages getMessages_paso1_above() {
        return messages_paso1_above;
    }

    public void setMessages_paso1_below(CoreMessages messages_paso1_below) {
        this.messages_paso1_below = messages_paso1_below;
    }

    public CoreMessages getMessages_paso1_below() {
        return messages_paso1_below;
    }

    public void setCmdBtn_verReporteBasico(CoreCommandButton cmdBtn_verReporteBasico) {
        this.cmdBtn_verReporteBasico = cmdBtn_verReporteBasico;
    }

    public CoreCommandButton getCmdBtn_verReporteBasico() {
        return cmdBtn_verReporteBasico;
    }

    public void setCmdLink_trasladar_solicitud(CoreCommandLink cmdLink_trasladar_solicitud) {
        this.cmdLink_trasladar_solicitud = cmdLink_trasladar_solicitud;
    }

    public CoreCommandLink getCmdLink_trasladar_solicitud() {
        return cmdLink_trasladar_solicitud;
    }

    public void setCmdBtn_retornar_calculo(CoreCommandButton cmdBtn_retornar_calculo) {
        this.cmdBtn_retornar_calculo = cmdBtn_retornar_calculo;
    }

    public CoreCommandButton getCmdBtn_retornar_calculo() {
        return cmdBtn_retornar_calculo;
    }

    public String cmdBtn_retornar_calculo_action() {
        return "ir_a_listado_indemnizaciones";
    }

    public void setInptText_serieFacturaPost(CoreInputText inptText_serieFacturaPost) {
        this.inptText_serieFacturaPost = inptText_serieFacturaPost;
    }

    public CoreInputText getInptText_serieFacturaPost() {
        return inptText_serieFacturaPost;
    }

    public void setInptText_numeroFactPost(CoreInputText inptText_numeroFactPost) {
        this.inptText_numeroFactPost = inptText_numeroFactPost;
    }

    public CoreInputText getInptText_numeroFactPost() {
        return inptText_numeroFactPost;
    }

    public void setSlctInputDate_fechaFactPost(CoreSelectInputDate slctInputDate_fechaFactPost) {
        this.slctInputDate_fechaFactPost = slctInputDate_fechaFactPost;
    }

    public CoreSelectInputDate getSlctInputDate_fechaFactPost() {
        return slctInputDate_fechaFactPost;
    }

    public void setInptText_nombreFunerariaPost(CoreInputText inptText_nombreFunerariaPost) {
        this.inptText_nombreFunerariaPost = inptText_nombreFunerariaPost;
    }

    public CoreInputText getInptText_nombreFunerariaPost() {
        return inptText_nombreFunerariaPost;
    }

    public void setInptText_montoFacturaPost(CoreInputText inptText_montoFacturaPost) {
        this.inptText_montoFacturaPost = inptText_montoFacturaPost;
    }

    public CoreInputText getInptText_montoFacturaPost() {
        return inptText_montoFacturaPost;
    }

    public void setCmdBtn_comprobar_gasto_funerario(CoreCommandButton cmdBtn_comprobar_gasto_funerario) {
        this.cmdBtn_comprobar_gasto_funerario = 
                cmdBtn_comprobar_gasto_funerario;
    }

    public CoreCommandButton getCmdBtn_comprobar_gasto_funerario() {
        return cmdBtn_comprobar_gasto_funerario;
    }

    public void setCmdBtn_guardar_gasto_funerario(CoreCommandButton cmdBtn_guardar_gasto_funerario) {
        this.cmdBtn_guardar_gasto_funerario = cmdBtn_guardar_gasto_funerario;
    }

    public CoreCommandButton getCmdBtn_guardar_gasto_funerario() {
        return cmdBtn_guardar_gasto_funerario;
    }

    public String cmdBtn_cancelar_gasto_funerario_action() {
        FacesContext f = FacesContext.getCurrentInstance();
        JSFUtils.EjecutarAcccion(f, "recuperarExpediente");
        JSFUtils.EjecutarAcccion(f, "RefrescarIndemnizacion");
        habilitar_componentes_gasto_funerario(false);
        mensaje("Se cancelaron los cambios no guardados correctamente.", 1);
        return null;
    }

    public String cmdBtn_retornar_gasto_funerario_action() {
        return "ir_a_listado_indemnizaciones";
    }

    public void setCmdBtn_retornar_gasto_funerario(CoreCommandButton cmdBtn_retornar_gasto_funerario) {
        this.cmdBtn_retornar_gasto_funerario = cmdBtn_retornar_gasto_funerario;
    }

    public CoreCommandButton getCmdBtn_retornar_gasto_funerario() {
        return cmdBtn_retornar_gasto_funerario;
    }

    public void setCmdLink_trasladar_gasto_funerario(CoreCommandLink cmdLink_trasladar_gasto_funerario) {
        this.cmdLink_trasladar_gasto_funerario = 
                cmdLink_trasladar_gasto_funerario;
    }

    public CoreCommandLink getCmdLink_trasladar_gasto_funerario() {
        return cmdLink_trasladar_gasto_funerario;
    }

    public void setCmdLink_trasladar_calculo(CoreCommandLink cmdLink_trasladar_calculo) {
        this.cmdLink_trasladar_calculo = cmdLink_trasladar_calculo;
    }

    public CoreCommandLink getCmdLink_trasladar_calculo() {
        return cmdLink_trasladar_calculo;
    }

    public void setInptHidden_gastoFunerario(CoreInputHidden inptHidden_gastoFunerario) {
        this.inptHidden_gastoFunerario = inptHidden_gastoFunerario;
    }

    public CoreInputHidden getInptHidden_gastoFunerario() {
        return inptHidden_gastoFunerario;
    }

    public void setCmdBtn_verReporteDARHSJI1(CoreCommandButton cmdBtn_verReporteDARHSJI1) {
        this.cmdBtn_verReporteDARHSJI1 = cmdBtn_verReporteDARHSJI1;
    }

    public CoreCommandButton getCmdBtn_verReporteDARHSJI1() {
        return cmdBtn_verReporteDARHSJI1;
    }

    public void setCmdBtn_guardarRelacionLab(CoreCommandButton cmdBtn_guardarRelacionLab) {
        this.cmdBtn_guardarRelacionLab = cmdBtn_guardarRelacionLab;
    }

    public CoreCommandButton getCmdBtn_guardarRelacionLab() {
        return cmdBtn_guardarRelacionLab;
    }

    /*private void guardarRelacionLaboral() {
        int numFilas = this.getTbl_relacionLaboral().getRowCount();
        JUCtrlValueBindingRef rwRef;
        Row rw;
        Object  aux;
        //System.out.println("El número de filas es: " + numFilas);
        for (int i = 0; i < numFilas; i++) {
            rwRef =
                    (JUCtrlValueBindingRef)this.getTbl_relacionLaboral().getRowData(i);
            rw = rwRef.getRow();
            aux = rw.getAttribute("Partida");
            if (aux!=null) { System.out.println(aux.toString()); } else { System.out.println("Partida Undefined"); }
            aux = rw.getAttribute("NumeroPlaza");
            if (aux!=null) { System.out.println(aux.toString()); } else { System.out.println("NumeroPlaza Undefined"); }
            aux = rw.getAttribute("Anio");
            if (aux!=null) { System.out.println(aux.toString()); } else { System.out.println("Anio Undefined"); }
            aux = rw.getAttribute("J1");
            if (aux!=null) { System.out.println(aux.toString()); } else { System.out.println("J1 Undefined"); }
            aux = rw.getAttribute("J2");
            if (aux!=null) { System.out.println(aux.toString()); } else { System.out.println("J2 Undefined"); }
            aux = rw.getAttribute("J3");
            if (aux!=null) { System.out.println(aux.toString()); } else { System.out.println("J3 Undefined"); }
            aux = rw.getAttribute("J4");
            if (aux!=null) { System.out.println(aux.toString()); } else { System.out.println("J4 Undefined"); }
            aux = rw.getAttribute("J5");
            if (aux!=null) { System.out.println(aux.toString()); } else { System.out.println("J5 Undefined"); }
            aux = rw.getAttribute("J6");
            if (aux!=null) { System.out.println(aux.toString()); } else { System.out.println("J6 Undefined"); }
            aux = rw.getAttribute("J7");
            if (aux!=null) { System.out.println(aux.toString()); } else { System.out.println("J7 Undefined"); }
            aux = rw.getAttribute("J8");
            if (aux!=null) { System.out.println(aux.toString()); } else { System.out.println("J8 Undefined"); }
            aux = rw.getAttribute("J9");
            if (aux!=null) { System.out.println(aux.toString()); } else { System.out.println("J9 Undefined"); }
            aux = rw.getAttribute("J10");
            if (aux!=null) { System.out.println(aux.toString()); } else { System.out.println("J10 Undefined"); }
            aux = rw.getAttribute("J11");
            if (aux!=null) { System.out.println(aux.toString()); } else { System.out.println("J11 Undefined"); }
            aux = rw.getAttribute("J12");
            if (aux!=null) { System.out.println(aux.toString()); } else { System.out.println("J13 Undefined"); }
            aux = rw.getAttribute("Anios");
            if (aux!=null) { System.out.println(aux.toString()); } else { System.out.println("Anios Undefined"); }
            aux = rw.getAttribute("Meses");
            if (aux!=null) { System.out.println(aux.toString()); } else { System.out.println("Mese Undefined"); }
            aux = rw.getAttribute("Dias");
            if (aux!=null) { System.out.println(aux.toString()); } else { System.out.println("Dias Undefined"); }
        }
        Iterator it = this.getTbl_relacionLaboral().getSelectionState().getKeySet().iterator();
        //JUIteratorBinding vIterBinding = (JUIteratorBinding) JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.SisRelacionLaboral_vw1Iterator}");
        //RowSetIterator vBinding=vIterBinding.getRowSetIterator();
        while(it.hasNext()){
            //String key = it.next().toString();
            //System.out.println("hola: " + key);
        }
    }*/

    public String cmdBtn_guardarRelacionLab_action() {
        //guardarRelacionLaboral();
        return null;
    }

    public void setTbl_relacionLaboral(CoreTable tbl_relacionLaboral) {
        this.tbl_relacionLaboral = tbl_relacionLaboral;
    }

    public CoreTable getTbl_relacionLaboral() {
        return tbl_relacionLaboral;
    }

    public void setSlctInputDate_fechaSolicitud(CoreSelectInputDate slctInputDate_fechaSolicitud) {
        this.slctInputDate_fechaSolicitud = slctInputDate_fechaSolicitud;
    }

    public CoreSelectInputDate getSlctInputDate_fechaSolicitud() {
        return slctInputDate_fechaSolicitud;
    }

    public void setInptText_motivoRenuncia(CoreInputText inptText_motivoRenuncia) {
        this.inptText_motivoRenuncia = inptText_motivoRenuncia;
    }

    public CoreInputText getInptText_motivoRenuncia() {
        return inptText_motivoRenuncia;
    }

    public void setSlctBooleanCheckBox_bantrab(CoreSelectBooleanCheckbox slctBooleanCheckBox_bantrab) {
        this.slctBooleanCheckBox_bantrab = slctBooleanCheckBox_bantrab;
    }

    public CoreSelectBooleanCheckbox getSlctBooleanCheckBox_bantrab() {
        return slctBooleanCheckBox_bantrab;
    }

    public void setSlctBooleanCheckBox_judicial(CoreSelectBooleanCheckbox slctBooleanCheckBox_judicial) {
        this.slctBooleanCheckBox_judicial = slctBooleanCheckBox_judicial;
    }

    public CoreSelectBooleanCheckbox getSlctBooleanCheckBox_judicial() {
        return slctBooleanCheckBox_judicial;
    }

    public void setSlctBooleanCheckBox_cargoCont(CoreSelectBooleanCheckbox slctBooleanCheckBox_cargoCont) {
        this.slctBooleanCheckBox_cargoCont = slctBooleanCheckBox_cargoCont;
    }

    public CoreSelectBooleanCheckbox getSlctBooleanCheckBox_cargoCont() {
        return slctBooleanCheckBox_cargoCont;
    }

    public void setSlctBooleanCheckBox_otros(CoreSelectBooleanCheckbox slctBooleanCheckBox_otros) {
        this.slctBooleanCheckBox_otros = slctBooleanCheckBox_otros;
    }

    public CoreSelectBooleanCheckbox getSlctBooleanCheckBox_otros() {
        return slctBooleanCheckBox_otros;
    }

    public void setInptText_numeroExpRetiro(CoreInputText inptText_numeroExpRetiro) {
        this.inptText_numeroExpRetiro = inptText_numeroExpRetiro;
    }

    public CoreInputText getInptText_numeroExpRetiro() {
        return inptText_numeroExpRetiro;
    }

    public void setInptText_fechaExpRetiro(CoreInputText inptText_fechaExpRetiro) {
        this.inptText_fechaExpRetiro = inptText_fechaExpRetiro;
    }

    public CoreInputText getInptText_fechaExpRetiro() {
        return inptText_fechaExpRetiro;
    }

    public void setInptText_descripcionExpRetiro(CoreInputText inptText_descripcionExpRetiro) {
        this.inptText_descripcionExpRetiro = inptText_descripcionExpRetiro;
    }

    public CoreInputText getInptText_descripcionExpRetiro() {
        return inptText_descripcionExpRetiro;
    }

    public String cmdBtn_calcularTiempoServ_action() {
        // Add event code here...
        FacesContext f = FacesContext.getCurrentInstance();
        JSFUtils.EjecutarAcccion(f, "recorrer_relacion_laboral");
        return null;
    }

    public String cmdBtn_exportExcelRelLab_action() {
        //System.out.println("A");
        HttpServletRequest vRequest = 
            (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse vResponse = 
            (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
        try {
            String b = "#{bindings.RegistroEmpleado.inputValue}";
            FacesContext f = FacesContext.getCurrentInstance();
            Object regPersonal = JSFUtils.resolveExpression(f, b);
            if (regPersonal != null) {
                verReporteExcel Excel = new verReporteExcel();
                vRequest.setAttribute("rep", "DARHSJI2_INDEMNIZACION");
                vRequest.setAttribute("id", regPersonal.toString());
                Excel.doGet(vRequest, vResponse);
            } else {
                mensaje("No se pudo generar el archivo de Excel. Intente de nuevo por favor!!", 
                        3);
            }
        } catch (Exception exep) {
            exep.printStackTrace();
        }
        //System.out.println("B");
        return null;
    }

    public void setSlctOneChoice_tipoRetiro(CoreSelectOneChoice slctOneChoice_tipoRetiro) {
        this.slctOneChoice_tipoRetiro = slctOneChoice_tipoRetiro;
    }

    public CoreSelectOneChoice getSlctOneChoice_tipoRetiro() {
        return slctOneChoice_tipoRetiro;
    }

    public void setSlctInputDate_fechaRetiro(CoreSelectInputDate slctInputDate_fechaRetiro) {
        this.slctInputDate_fechaRetiro = slctInputDate_fechaRetiro;
    }

    public CoreSelectInputDate getSlctInputDate_fechaRetiro() {
        return slctInputDate_fechaRetiro;
    }
}
