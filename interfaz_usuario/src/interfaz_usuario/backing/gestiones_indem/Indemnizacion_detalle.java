package interfaz_usuario.backing.gestiones_indem;

//import enlace_datos.util.resulOp;

import interfaz_usuario.servlets.verReporteExcel;

import interfaz_usuario.util.JSFUtils;
import interfaz_usuario.util.utils;

//import java.util.List;

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

//import oracle.binding.BindingContainer;
//import oracle.binding.OperationBinding;

//import oracle.jbo.JboException;
import oracle.jbo.domain.Number;

import pkg_util_base_datos.interfaz_DB;


public class Indemnizacion_detalle {
    private HtmlHtml html1;
    private HtmlHead head1;
    private HtmlBody body1;
    private CoreForm form1;
    private CorePage page1;
    private CoreCommandButton cmdBtn_calcularIndemnizacion;
    private CoreCommandButton cmdBtn_guardar;
    private CoreCommandButton cmdBtn_guardar_calculo;
    private CoreCommandButton cmdBtn_guardarRelacionLab;
    private CoreCommandButton cmdBtn_retornar;
    private CoreCommandButton cmdBtn_verReporteBasico;
    private CoreCommandButton cmdBtn_verReporteDARHSJI1;
    private CoreCommandLink cdmLink_buscarEmpl;
    private CoreCommandLink cmdLink_trasladar_solicitud;
    private CoreCommandMenuItem cmdMenuItem;
    private CoreInputHidden inptHidden_aguinaldoCalculo;
    private CoreInputHidden inptHidden_bono14Calculo;
    private CoreInputHidden inptHidden_diferido12Calculo;
    private CoreInputHidden inptHidden_diferidoCalculo;
    private CoreInputHidden inptHidden_montoIndemTotal;
    private CoreInputHidden inptHidden_sueldoPromedio;
    private CoreInputText inptText_AniosServicio;
    private CoreInputText inptText_Correlativo;
    private CoreInputText inptText_cuiTrabajador;
    private CoreInputText inptText_descripcionExpRetiro;
    private CoreInputText inptText_DiasServicio;
    private CoreInputText inptText_EstadoExpediente;
    private CoreInputText inptText_fechaExpRetiro;
    private CoreInputText inptText_IdIndemnizacion;
    private CoreInputText inptText_IdSolicitud;
    private CoreInputText inptText_MesesServicio;
    private CoreInputText inptText_montoFacturaPost;
    private CoreInputText inptText_motivoRenuncia;
    private CoreInputText inptText_nombreCompleto;
    private CoreInputText inptText_nombreEstadoTrabajador;
    private CoreInputText inptText_nombreFunerariaPost;
    private CoreInputText inptText_numeroExpRetiro;
    private CoreInputText inptText_numeroFactPost;
    private CoreInputText inptText_registroEmpleado;
    private CoreInputText inptText_serieFacturaPost;
    private CoreInputText inptText_TotalSueldos;
    private CoreMessages messages_paso1_above;
    private CoreMessages messages_paso1_below;
    private CoreOutputFormatted outputFormat_aguinaldo_calc;
    private CoreOutputFormatted outputFormat_bono14_calc;
    private CoreOutputFormatted outputFormat_diferido_calc;
    private CoreOutputFormatted outputFormat_diferido12_calc;
    private CoreOutputFormatted outputFormat_montIndAnios_calc;
    private CoreOutputFormatted outputFormat_montIndDias_calc;
    private CoreOutputFormatted outputFormat_montIndMeses_calc;
    private CoreOutputFormatted outputFormat_montIndTotal_calc;
    private CoreOutputFormatted outputFormat_sueldoProm_calc;
    private CoreOutputFormatted outputFormat_totalParaCalc_calc;
    private CoreOutputFormatted outputFormat_totalPrestac_calc;
    private CoreOutputFormatted outputFormat_totalSueldos;
    private CoreOutputText outputTxt_mensaje_calculo;
    private CoreOutputText outputTxt_mensaje2_calculo;
    private CorePanelBox pnlBox_informacionSolicitante;
    private CorePanelForm pnlForm_solicitante;
    private CorePanelHorizontal pnlHoriz_indemCalculada;
    private CoreSelectBooleanCheckbox slctBooleanCheckBox_bantrab;
    private CoreSelectBooleanCheckbox slctBooleanCheckBox_cargoCont;
    private CoreSelectBooleanCheckbox slctBooleanCheckBox_judicial;
    private CoreSelectBooleanCheckbox slctBooleanCheckBox_otros;
    private CoreSelectInputDate slctInputDate_fechaFactPost;
    private CoreSelectInputDate slctInputDate_fechaRetiro;
    private CoreSelectInputDate slctInputDate_fechaSolicitud;
    private CoreSelectOneChoice slctOneChoice_tipoCarreraLab;
    private CoreSelectOneChoice slctOneChoice_tipoRetiro;
    private CoreShowDetailItem showDetItem_calculo;
    private CoreShowDetailItem showDetItem_solicitud;
    private CoreTable tbl_listadoUltimosSueldos_calculo;
    private CoreTable tbl_relacionLaboral;
    private CoreInputText inptText_numeroCheque;

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

    /*private void habilitar_componentes_solicitud_detallado(boolean deshabilitado) {
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
    }*/

    //Obtiene los datos del expediente en que se registró el retiro del extrabajador

    /*private void obtener_expediente_retiro(String regEmpleado,
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
    }*/

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
            //Object estadoTrabajador = 
            //interfaz.getValorConsultaSimple("ESTADO_TRABAJADOR", consulta);
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

    /*private void desplegarErrores(List pErrores) {
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
    }*/

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

    public void setOutputTxt_mensaje2_calculo(CoreOutputText outputTxt_mensaje2_calculo) {
        this.outputTxt_mensaje2_calculo = outputTxt_mensaje2_calculo;
    }

    public CoreOutputText getOutputTxt_mensaje2_calculo() {
        return outputTxt_mensaje2_calculo;
    }

    public void setCmdBtn_guardar(CoreCommandButton cmdBtn_guardar) {
        this.cmdBtn_guardar = cmdBtn_guardar;
    }

    public CoreCommandButton getCmdBtn_guardar() {
        return cmdBtn_guardar;
    }

    //Habilita o deshabilita componentes del formulario al comprobar, guardar o cancelar una solicitud

    /*private void habilitar_componentes_paso1(boolean deshabilitado) {
        this.getShowDetItem_calculo().setDisabled(deshabilitado);
        //this.getCmdBtn_comprobar().setDisabled(deshabilitado);
        this.getCmdBtn_guardar().setDisabled(!deshabilitado);
        this.getCmdBtn_verReporteBasico().setDisabled(deshabilitado);
        this.getCmdLink_trasladar_solicitud().setDisabled(deshabilitado);
        habilitar_componentes_solicitud_detallado(deshabilitado); //Campos de Texto y Combos
    }*/

    //Función que obtiene el último correlativo de SIS_INDEMNIZACIÓN del año actual para Indemnización por Retiro Definitivo

    /*private long obtenerUltimoCorrelativo_solicitud(Number anioActual) {
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
    }*/

    //Procedimiento que obtiene el ID de la solicitud de retiro definitivo y lo setea al binding respectivo

    /*private boolean obtenerId_solicitudRetiro(FacesContext f) {
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
                    //JSFUtils.setExpressionValue(f, b2, utils.getNumberOracle(aux));
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
    }*/

    //Función que realiza el commit a la base de Datos

    /*private boolean commit(FacesContext f) {
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
    }*/

    //Verifica si el trabajador ya se retiró de la institución

    /*private boolean verificarRetiroTrabajador(FacesContext f) {
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
    }*/

    //Valida la información ingresada por el usuario

    private boolean validarInformacionIngresada() {
        boolean valido = false;
        boolean continuar = false;
        Object registroPersonal = 
            this.getInptText_registroEmpleado().getValue();
        oracle.jbo.domain.Date fechaRetiro = 
            (oracle.jbo.domain.Date)this.getSlctInputDate_fechaRetiro().getValue();
        oracle.jbo.domain.Date fechaSolicitud = 
            (oracle.jbo.domain.Date)this.getSlctInputDate_fechaSolicitud().getValue();
        Number aniosServicio = 
            (Number)this.getInptText_AniosServicio().getValue();
        Number mesesServicio = 
            (Number)this.getInptText_MesesServicio().getValue();
        Number diasServicio = 
            (Number)this.getInptText_DiasServicio().getValue();
        Object tipoRetiro = this.getSlctOneChoice_tipoRetiro().getValue();
        Number totalSueldos = 
            (Number)this.getInptText_TotalSueldos().getValue();
        if (registroPersonal == null || 
            registroPersonal.toString().compareTo("") == 0) {
            mensaje("¡¡Ingrese trabajador para continuar!!", 3);
        } else if (fechaRetiro == null) {
            mensaje("!!Ingrese Fecha de Retiro para continuar!!", 3);
        } else if ((aniosServicio == null || aniosServicio.intValue() <= 0) && 
                   (mesesServicio == null || mesesServicio.intValue() <= 0) && 
                   (diasServicio == null || diasServicio.intValue() <= 0)) {
            mensaje("!!Ingrese el Tiempo de Servicio para continuar!!", 3);
        } else if (aniosServicio != null && 
                   (aniosServicio.intValue() < 0 || aniosServicio.intValue() > 
                    10) && aniosServicio.intValue() != 12) {
            mensaje("!!Años de Servicio para Cálculo de Indemnización Inválido (Debe ser entre 0 y 10 o 12)!!", 
                    3);
        } else if (aniosServicio != null && 
                   (aniosServicio.intValue() == 10 || aniosServicio.intValue() == 
                    12)) {
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
            if (diasServicio != null && diasServicio.intValue() >= 0 && 
                diasServicio.intValue() <= 29) {
                continuar = true;
            } else if (diasServicio != null) {
                mensaje("!!Días de Servicio para Cálculo de Indemnización Inválido (debe ser entre 0 y 29)!!", 
                        3);
            } else {
                continuar = true;
            }
        } else if (mesesServicio != null) {
            mensaje("!!Meses de Servicio para Cálculo de Indemnización Inválido (debe ser entre 0 y 11)!!", 
                    3);
        } else {
            continuar = true;
        }
        if (continuar == true) {
            continuar = false;
            if (tipoRetiro == null) {
                mensaje("!!Seleccione un Tipo de Retiro para continuar!!", 3);
            } else if (totalSueldos == null || 
                       totalSueldos.doubleValue() <= 0) {
                mensaje("!!Ingrese Total de Sueldos para continuar!!", 3);
            } else if (fechaSolicitud == null) {
                mensaje("!!Ingrese Fecha de Solicitud para continuar!!", 3);
            } else {
                if (fechaSolicitud != null && fechaRetiro != null) {
                    if (fechaRetiro.dateValue().after(fechaSolicitud.dateValue())) {
                        mensaje("!!La Fecha de Retiro es más reciente que la Fecha de Solicitud!!", 
                                3);
                    } else {
                        continuar = true;
                    }
                } else {
                    continuar = true;
                }
            }
        }
        if (continuar == true) {
            //Verificamos si está habilitado el campo de entrada Número de Cheque
            if (!this.getInptText_numeroCheque().isReadOnly()) {
                //Se encuentra habilitado
                Object aux = this.getInptText_numeroCheque().getValue();
                if (aux != null && Long.parseLong(aux.toString()) > 0) {
                    valido = true;
                } else {
                    mensaje("!!El Número de Cheque debe ser mayor de 0!!", 3);
                }
            } else {
                valido = true;
            }
        }
        return valido;
    }

    //Procedimiento que rellena los campos pendientes de una solicitud nueva antes de grabar.

    private boolean rellenarCamposPends_solNueva(FacesContext f) {
        boolean correcto = false;
        String bind = "#{bindings.IdTipoPrestacion.inputValue}";
        try {
            //Number anioActual = utils.getNumberOracle(utils.getAnioActual());
            //System.out.println("El año actual es: " + anioActual);
            //obtenemos el correlativo de la solicitud dependiendo del año actual
            //long correlativo = 
            //obtenerUltimoCorrelativo_solicitud(anioActual) + 1;
            //JSFUtils.setExpressionValue(f, b1, anioActual);
            //JSFUtils.setExpressionValue(f, b2, 
            //                        utils.getNumberOracle(correlativo));
            //JSFUtils.setExpressionValue(f, b3, utils.getNumberOracle("250"));
            JSFUtils.setExpressionValue(f, bind, utils.getNumberOracle("1"));
            correcto = true;
        } catch (Exception e) {
            e.printStackTrace();
            mensaje("Ha ocurrido el siguiente error: " + e.getMessage(), 3);
        }
        return correcto;
    }

    //Función que procesa el guardar de una solicitud nueva

    private boolean procesar_guardar_sol_nueva(FacesContext f) {
        boolean exito = false;
        if (calcularIndemnizacion(f)) {
            String bind = "#{bindings.IdTipoPrestacion.inputValue}";
            try {
                JSFUtils.setExpressionValue(f, bind, 
                                            utils.getNumberOracle("1"));
                if (JSFUtils.EjecutarAcccion2(f.getCurrentInstance(), 
                                              "Confirmar")) {
                    exito = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
                mensaje("Ha ocurrido el siguiente error: " + e.getMessage(), 
                        3);
            }
        }
        return exito;
    }

    //Función que procesa el guardar una solicitud existente

    private boolean procesar_guardar_sol_existente(FacesContext f) {
        boolean exito = false;
        String bin = "#{bindings.IdEstado.inputValue}";
        Object obj = JSFUtils.resolveExpression(f, bin);
        if (obj != null) {
            int idEstado = Integer.parseInt(obj.toString());
            if (idEstado == 250 || idEstado == 252) {
                //Estado grabado ú objetado
                if (calcularIndemnizacion(f)) {
                    if (JSFUtils.EjecutarAcccion2(f.getCurrentInstance(), 
                                                  "Confirmar")) {
                        exito = true;
                    }
                }
            } else if (idEstado == 256) {
                //Estado liquidado
                if (JSFUtils.EjecutarAcccion2(f.getCurrentInstance(), 
                                              "Confirmar")) {
                    exito = true;
                }
            } else {
                mensaje("!!Estado incorrecto para grabar. Revise por favor!!", 
                        3);
            }
        } else {
            mensaje("!!No se pudo recuperar la información correctamente!!", 
                    3);
        }
        return exito;
    }

    //Procedimiento que procesa el botón guardar

    private boolean procesar_guardar(FacesContext f, String bindEsSolNueva) {
        boolean exito = false;
        if (validarInformacionIngresada()) {
            Object auxObj = JSFUtils.resolveExpression(f, bindEsSolNueva);
            if (auxObj != null) {
                //Tiene algún valor
                boolean esNuevo = Boolean.parseBoolean(auxObj.toString());
                if (esNuevo) {
                    //Es solicitud nueva
                    exito = procesar_guardar_sol_nueva(f);
                } else {
                    //Es solicitud existente
                    exito = procesar_guardar_sol_existente(f);
                }
            } else {
                mensaje("!!No se pudo recuperar la información correctamente. Intente de nuevo!!", 
                        3);
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
            JSFUtils.EjecutarAcccion(f, "RefrescarIndemnizacion");
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
        /*this.getPnlHoriz_indemCalculada().setRendered(false);
        this.getCmdBtn_guardar_calculo().setDisabled(true);
        this.getCmdBtn_calcularIndemnizacion().setDisabled(false);
        this.getCdmLink_buscarEmpl().setDisabled(false);
        this.getSlctInputDate_fechaRetiro().setDisabled(false);
        this.getInptText_AniosServicio().setDisabled(false);
        this.getInptText_MesesServicio().setDisabled(false);
        this.getInptText_DiasServicio().setDisabled(false);
        this.getSlctOneChoice_tipoRetiro().setDisabled(false);
        this.getInptText_TotalSueldos().setDisabled(false);
        this.getSlctInputDate_fechaSolicitud().setDisabled(false);
        this.getCmdBtn_guardar().setDisabled(false);
        this.getCmdLink_trasladar_solicitud().setDisabled(false);*/
        mensaje("Operación Cancelada Correctamente", 1);
        return null;
    }

    public String cmdBtn_retornar_action() {
        return "ir_a_listado_indemnizaciones";
    }
    //Calcula la indemnización por retiro definitivo

    /* private void calcular_indemnizacion(int anios, int meses, int dias,
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
    }*/

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
        mensaje("Cálculo de prestación post-mortem realizado correctamente.",
                1);
    }*/

    //Rellena campos pendientes antes de guardar el cálculo

    /*private boolean rellenarCamposPends_calculoInd(FacesContext f) {
        boolean correcto = false;
        try {
            Object difObj, dif12Obj, aguiObj, bono14Obj, sueldoPromObj, totalIndemObj;
            Number diferido, diferido12, aguinaldo, bono14, sueldoProm, totalIndem;
            String bindDif = "#{bindings.DiferidoCalc.inputValue}";
            String bindDif12 = "#{bindings.Diferido12Calc.inputValue}";
            String bindAgui = "#{bindings.AguinaldoCalc.inputValue}";
            String bindBono14 = "#{bindings.Bono14Calc.inputValue}";
            String bindSueldoProm = "#{bindings.SueldoPromedio.inputValue}";
            String bindTotalIndem = "#{bindings.TotalPrestacion.inputValue}";
            ///////////////////////////////////////////////////
            difObj = this.getInptHidden_diferidoCalculo().getValue();
            if (difObj != null) {
                diferido =
                        utils.getNumberOracle(String.format("%.2f", difObj));
                JSFUtils.setExpressionValue(f, bindDif, diferido);
            }
            dif12Obj = this.getInptHidden_diferido12Calculo().getValue();
            if (dif12Obj != null) {
                diferido12 =
                        utils.getNumberOracle(String.format("%.2f", dif12Obj));
                JSFUtils.setExpressionValue(f, bindDif12, diferido12);
            }
            aguiObj = this.getInptHidden_aguinaldoCalculo().getValue();
            if (aguiObj != null) {
                aguinaldo =
                        utils.getNumberOracle(String.format("%.2f", aguiObj));
                JSFUtils.setExpressionValue(f, bindAgui, aguinaldo);
            }
            bono14Obj = this.getInptHidden_bono14Calculo().getValue();
            if (bono14Obj != null) {
                bono14 =
                        utils.getNumberOracle(String.format("%.2f", bono14Obj));
                JSFUtils.setExpressionValue(f, bindBono14, bono14);
            }
            sueldoPromObj = this.getInptHidden_sueldoPromedio().getValue();
            if (sueldoPromObj != null) {
                sueldoProm =
                        utils.getNumberOracle(String.format("%.2f", sueldoPromObj));
                JSFUtils.setExpressionValue(f, bindSueldoProm, sueldoProm);
            }
            totalIndemObj = this.getInptHidden_montoIndemTotal().getValue();
            if (totalIndemObj != null) {
                totalIndem =
                        utils.getNumberOracle(String.format("%.2f", totalIndemObj));
                JSFUtils.setExpressionValue(f, bindTotalIndem, totalIndem);
            }
            correcto = true;
            //correcto = true;
        } catch (Exception e) {
            e.printStackTrace();
            mensaje("Ha ocurrido el siguiente error: " + e.getMessage(), 3);
        }
        return correcto;
    }*/

    public String cmdBtn_guardar_calculo_action() {
        /*FacesContext f = FacesContext.getCurrentInstance();
        if (rellenarCamposPends_calculoInd(f)) {
            //if (commit(f)) {
            if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),
                                          "Confirmar")) {
                mensaje("¡¡Información Guardada Correctamente!!", 1);
                JSFUtils.EjecutarAcccion(f, "RefrescarIndemnizacion");
                this.getPnlHoriz_indemCalculada().setRendered(false);
                this.getCmdBtn_guardar_calculo().setDisabled(true);
                this.getCmdBtn_calcularIndemnizacion().setDisabled(false);
                this.getCdmLink_buscarEmpl().setDisabled(false);
                this.getSlctInputDate_fechaRetiro().setDisabled(false);
                this.getInptText_AniosServicio().setDisabled(false);
                this.getInptText_MesesServicio().setDisabled(false);
                this.getInptText_DiasServicio().setDisabled(false);
                this.getSlctOneChoice_tipoRetiro().setDisabled(false);
                this.getInptText_TotalSueldos().setDisabled(false);
                this.getSlctInputDate_fechaSolicitud().setDisabled(false);
                this.getCmdBtn_guardar().setDisabled(false);
                this.getCmdLink_trasladar_solicitud().setDisabled(false);
            }
        }*/
        return null;
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

    /*public void setCmdBtn_retornar_calculo(CoreCommandButton cmdBtn_retornar_calculo) {
        this.cmdBtn_retornar_calculo = cmdBtn_retornar_calculo;
    }

    public CoreCommandButton getCmdBtn_retornar_calculo() {
        return cmdBtn_retornar_calculo;
    }*/

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

    /*public void setCmdBtn_comprobar_gasto_funerario(CoreCommandButton cmdBtn_comprobar_gasto_funerario) {
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
    }*/

    public String cmdBtn_retornar_gasto_funerario_action() {
        return "ir_a_listado_indemnizaciones";
    }

    /*public void setCmdBtn_retornar_gasto_funerario(CoreCommandButton cmdBtn_retornar_gasto_funerario) {
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
    }*/

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

    //Función que realiza el cálculo de la indemnización a pagar en base a la información ingresado por el usuario

    private boolean calcularIndemnizacion(FacesContext f) {
        boolean exito = false;
        Object aux = this.getInptText_TotalSueldos().getValue();
        if (aux != null && Double.parseDouble(aux.toString()) > 0) {
            //Primero calculamos prestaciones y sueldo promedio
            Double totalSueldos = Double.parseDouble(aux.toString());
            Double diferido = totalSueldos / 12;
            Double diferido12 = totalSueldos * .12;
            Double aguinaldo = (totalSueldos + diferido + diferido12) / 12;
            Double bono14 = aguinaldo;
            Double totalPrest = diferido + diferido12 + aguinaldo + bono14;
            Double totalParaCalcSueldoProm = totalSueldos + totalPrest;
            Double sueldoPromedio = totalParaCalcSueldoProm / 12;
            ///seteamos los valores en sus bindings respectivos///
            String bind = "#{bindings.DiferidoCalc.inputValue}";
            Number num = 
                utils.getNumberOracle(String.format("%.2f", diferido));
            JSFUtils.setExpressionValue(f, bind, num);
            bind = "#{bindings.Diferido12Calc.inputValue}";
            num = utils.getNumberOracle(String.format("%.2f", diferido12));
            JSFUtils.setExpressionValue(f, bind, num);
            bind = "#{bindings.AguinaldoCalc.inputValue}";
            num = utils.getNumberOracle(String.format("%.2f", aguinaldo));
            JSFUtils.setExpressionValue(f, bind, num);
            bind = "#{bindings.Bono14Calc.inputValue}";
            num = utils.getNumberOracle(String.format("%.2f", bono14));
            JSFUtils.setExpressionValue(f, bind, num);
            bind = "#{bindings.SueldoPromedio.inputValue}";
            num = utils.getNumberOracle(String.format("%.2f", sueldoPromedio));
            JSFUtils.setExpressionValue(f, bind, num);
            ///Coloco los primeros valores calculados en pantalla///
            /*this.getOutputFormat_totalSueldos().setValue(totalSueldos);
            this.getOutputFormat_diferido_calc().setValue(diferido);
            this.getOutputFormat_diferido12_calc().setValue(diferido12);
            this.getOutputFormat_aguinaldo_calc().setValue(aguinaldo);
            this.getOutputFormat_bono14_calc().setValue(bono14);
            this.getOutputFormat_totalPrestac_calc().setValue(totalPrest);
            this.getOutputFormat_totalParaCalc_calc().setValue(totalParaCalcSueldoProm);
            this.getOutputFormat_sueldoProm_calc().setValue(sueldoPromedio);*/
            ///Ahora calculamos el monto total de Indemnización///
            Object anios = this.getInptText_AniosServicio().getValue();
            Object meses = this.getInptText_MesesServicio().getValue();
            Object dias = this.getInptText_DiasServicio().getValue();
            if (anios != null || meses != null || dias != null) {
                int aniosLab = 0;
                if (anios != null && Integer.parseInt(anios.toString()) > 0) {
                    aniosLab = Integer.valueOf(anios.toString()).intValue();
                }
                int mesesLab = 0;
                if (meses != null && Integer.parseInt(meses.toString()) > 0) {
                    mesesLab = Integer.valueOf(meses.toString()).intValue();
                }
                int diasLab = 0;
                if (dias != null && Integer.parseInt(dias.toString()) > 0) {
                    diasLab = Integer.valueOf(dias.toString()).intValue();
                }
                double sueldoPromRedon = 
                    Math.round(sueldoPromedio * 100.0) / 100.0;
                double montoIndAnios = aniosLab * sueldoPromRedon;
                double montoIndMeses = (mesesLab * sueldoPromRedon) / 12;
                montoIndMeses = Math.round(montoIndMeses * 100.0) / 100.0;
                double montoIndDias = (diasLab * sueldoPromRedon) / 365;
                montoIndDias = Math.round(montoIndDias * 100.0) / 100.0;
                double montoIndTotal = 
                    montoIndAnios + montoIndMeses + montoIndDias;
                ///Coloco los siguientes valores calculados en pantalla///
                /*this.getOutputFormat_montIndAnios_calc().setValue(montoIndAnios);
                this.getOutputFormat_montIndMeses_calc().setValue(montoIndMeses);
                this.getOutputFormat_montIndDias_calc().setValue(montoIndDias);
                this.getOutputFormat_montIndTotal_calc().setValue(montoIndTotal);*/
                ///seteamos el valor calculado en su binding respectivo///
                bind = "#{bindings.TotalPrestacion.inputValue}";
                JSFUtils.setExpressionValue(f, bind, 
                                            utils.getNumberOracle(String.format("%.2f", 
                                                                                montoIndTotal)));
                exito = true;
            } else {
                mensaje("¡¡No hay Tiempo de Servicio para cálculo de Indemnización!!", 
                        3);
            }
        } else {
            mensaje("¡¡No hay Total de Sueldos para cálculo de Indemnización!!", 
                    3);
        }
        return exito;
    }

    public String cmdBtn_calcularIndemnizacion_action() {
        //volvemos a validar la información ingresada por el usuario
        /* if (validarInformacionIngresada()) {
            procesarCalcularIndemnizacion();
        }*/
        return null;
    }

    /*public String cmdBtn_calcular_action() {
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
    }*/

    public void setInptText_TotalSueldos(CoreInputText inptText_TotalSueldos) {
        this.inptText_TotalSueldos = inptText_TotalSueldos;
    }

    public CoreInputText getInptText_TotalSueldos() {
        return inptText_TotalSueldos;
    }

    public void setInptHidden_diferidoCalculo(CoreInputHidden inptHidden_diferidoCalculo) {
        this.inptHidden_diferidoCalculo = inptHidden_diferidoCalculo;
    }

    public CoreInputHidden getInptHidden_diferidoCalculo() {
        return inptHidden_diferidoCalculo;
    }

    public void setInptHidden_diferido12Calculo(CoreInputHidden inptHidden_diferido12Calculo) {
        this.inptHidden_diferido12Calculo = inptHidden_diferido12Calculo;
    }

    public CoreInputHidden getInptHidden_diferido12Calculo() {
        return inptHidden_diferido12Calculo;
    }

    public void setInptHidden_aguinaldoCalculo(CoreInputHidden inptHidden_aguinaldoCalculo) {
        this.inptHidden_aguinaldoCalculo = inptHidden_aguinaldoCalculo;
    }

    public CoreInputHidden getInptHidden_aguinaldoCalculo() {
        return inptHidden_aguinaldoCalculo;
    }

    public void setInptHidden_bono14Calculo(CoreInputHidden inptHidden_bono14Calculo) {
        this.inptHidden_bono14Calculo = inptHidden_bono14Calculo;
    }

    public CoreInputHidden getInptHidden_bono14Calculo() {
        return inptHidden_bono14Calculo;
    }

    public void setPnlHoriz_indemCalculada(CorePanelHorizontal pnlHoriz_indemCalculada) {
        this.pnlHoriz_indemCalculada = pnlHoriz_indemCalculada;
    }

    public CorePanelHorizontal getPnlHoriz_indemCalculada() {
        return pnlHoriz_indemCalculada;
    }

    public void setOutputFormat_totalSueldos(CoreOutputFormatted outputFormat_totalSueldos) {
        this.outputFormat_totalSueldos = outputFormat_totalSueldos;
    }

    public CoreOutputFormatted getOutputFormat_totalSueldos() {
        return outputFormat_totalSueldos;
    }

    public void setOutputFormat_diferido_calc(CoreOutputFormatted outputFormat_diferido_calc) {
        this.outputFormat_diferido_calc = outputFormat_diferido_calc;
    }

    public CoreOutputFormatted getOutputFormat_diferido_calc() {
        return outputFormat_diferido_calc;
    }

    public void setOutputFormat_diferido12_calc(CoreOutputFormatted outputFormat_diferido12_calc) {
        this.outputFormat_diferido12_calc = outputFormat_diferido12_calc;
    }

    public CoreOutputFormatted getOutputFormat_diferido12_calc() {
        return outputFormat_diferido12_calc;
    }

    public void setOutputFormat_aguinaldo_calc(CoreOutputFormatted outputFormat_aguinaldo_calc) {
        this.outputFormat_aguinaldo_calc = outputFormat_aguinaldo_calc;
    }

    public CoreOutputFormatted getOutputFormat_aguinaldo_calc() {
        return outputFormat_aguinaldo_calc;
    }

    public void setOutputFormat_bono14_calc(CoreOutputFormatted outputFormat_bono14_calc) {
        this.outputFormat_bono14_calc = outputFormat_bono14_calc;
    }

    public CoreOutputFormatted getOutputFormat_bono14_calc() {
        return outputFormat_bono14_calc;
    }

    public void setOutputFormat_totalPrestac_calc(CoreOutputFormatted outputFormat_totalPrestac_calc) {
        this.outputFormat_totalPrestac_calc = outputFormat_totalPrestac_calc;
    }

    public CoreOutputFormatted getOutputFormat_totalPrestac_calc() {
        return outputFormat_totalPrestac_calc;
    }

    public void setOutputFormat_totalParaCalc_calc(CoreOutputFormatted outputFormat_totalParaCalc_calc) {
        this.outputFormat_totalParaCalc_calc = outputFormat_totalParaCalc_calc;
    }

    public CoreOutputFormatted getOutputFormat_totalParaCalc_calc() {
        return outputFormat_totalParaCalc_calc;
    }

    public void setInptHidden_sueldoPromedio(CoreInputHidden inptHidden_sueldoPromedio) {
        this.inptHidden_sueldoPromedio = inptHidden_sueldoPromedio;
    }

    public CoreInputHidden getInptHidden_sueldoPromedio() {
        return inptHidden_sueldoPromedio;
    }

    public void setOutputFormat_sueldoProm_calc(CoreOutputFormatted outputFormat_sueldoProm_calc) {
        this.outputFormat_sueldoProm_calc = outputFormat_sueldoProm_calc;
    }

    public CoreOutputFormatted getOutputFormat_sueldoProm_calc() {
        return outputFormat_sueldoProm_calc;
    }

    public void setOutputFormat_montIndAnios_calc(CoreOutputFormatted outputFormat_montIndAnios_calc) {
        this.outputFormat_montIndAnios_calc = outputFormat_montIndAnios_calc;
    }

    public CoreOutputFormatted getOutputFormat_montIndAnios_calc() {
        return outputFormat_montIndAnios_calc;
    }

    public void setOutputFormat_montIndMeses_calc(CoreOutputFormatted outputFormat_montIndMeses_calc) {
        this.outputFormat_montIndMeses_calc = outputFormat_montIndMeses_calc;
    }

    public CoreOutputFormatted getOutputFormat_montIndMeses_calc() {
        return outputFormat_montIndMeses_calc;
    }

    public void setOutputFormat_montIndDias_calc(CoreOutputFormatted outputFormat_montIndDias_calc) {
        this.outputFormat_montIndDias_calc = outputFormat_montIndDias_calc;
    }

    public CoreOutputFormatted getOutputFormat_montIndDias_calc() {
        return outputFormat_montIndDias_calc;
    }

    public void setOutputFormat_montIndTotal_calc(CoreOutputFormatted outputFormat_montIndTotal_calc) {
        this.outputFormat_montIndTotal_calc = outputFormat_montIndTotal_calc;
    }

    public CoreOutputFormatted getOutputFormat_montIndTotal_calc() {
        return outputFormat_montIndTotal_calc;
    }

    public void setInptHidden_montoIndemTotal(CoreInputHidden inptHidden_montoIndemTotal) {
        this.inptHidden_montoIndemTotal = inptHidden_montoIndemTotal;
    }

    public CoreInputHidden getInptHidden_montoIndemTotal() {
        return inptHidden_montoIndemTotal;
    }

    public void setCmdBtn_calcularIndemnizacion(CoreCommandButton cmdBtn_calcularIndemnizacion) {
        this.cmdBtn_calcularIndemnizacion = cmdBtn_calcularIndemnizacion;
    }

    public CoreCommandButton getCmdBtn_calcularIndemnizacion() {
        return cmdBtn_calcularIndemnizacion;
    }

    public void setInptText_numeroCheque(CoreInputText inptText_numeroCheque) {
        this.inptText_numeroCheque = inptText_numeroCheque;
    }

    public CoreInputText getInptText_numeroCheque() {
        return inptText_numeroCheque;
    }
}
