package interfaz_usuario.backing.gestiones_indem;

import enlace_datos.util.resulOp;

import interfaz_usuario.servlets.verReporteExcel;

import interfaz_usuario.util.JSFUtils;
import interfaz_usuario.util.utils;

import java.sql.ResultSet;

import java.sql.SQLException;

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
import oracle.jbo.domain.Date;
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
    private CoreInputText inptText_programasLaboro;
    //private CoreSelectOneChoice slctOneChoice_programa;
    private CoreCommandButton cmdBtn_guardar_auto;
    private CoreInputText inptText_AniosServicio_02;
    private CoreInputText inptText_MesesServicio_02;
    private CoreInputText inptText_DiasServicio_02;
    private CorePanelForm pnlForm_autofinanciable;
    private CoreCommandButton cmdBtn_crear_autofin;
    private CoreInputText inptText_TotalSueldos02;
    private CoreInputText inptText_tipoCasoExp;
    private CoreInputText inptText_idTipoCasoExp;
    private CoreCommandButton cmdBtn_cancelar;
    private CoreCommandButton cmdBtn_cancelar_auto;

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

    //Obtiene los datos del expediente en que se registr� el retiro del extrabajador

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
                consulta = 
                        "select unique ID_PROGRAMA from SIS_PARTIDA where ID_PARTIDA IN(  ";
                consulta += "select unique ID_PARTIDA from SIS_CONTRATO ";
                consulta += 
                        "where ESTATUS not in (11) and REGISTRO_EMPLEADO = " + 
                        registroEmpleado + ") order by ID_PROGRAMA ASC ";
                //System.out.println("La consulta es: " + consulta);
                ResultSet vResultado = 
                    interfaz.Bol_ejecutar_sentencia(consulta);
                try {
                    Object idPrograma = null;
                    String programasLaboro = "";
                    boolean laboroRegOrdinario = false;
                    boolean laboroRegEspecial = false;
                    boolean laboroRegDesc = false;
                    while (vResultado.next()) {
                        //System.out.println("Programa:="+vResultado.getString("Programa"));
                        idPrograma = vResultado.getString("ID_PROGRAMA");
                        if (idPrograma != null) {
                            //System.out.println("El programa recuperado es: " + 
                            //               idPrograma);
                            if (programasLaboro == "") {
                                programasLaboro = idPrograma.toString();
                            } else {
                                programasLaboro += ", " + idPrograma;
                            }
                            int id = Integer.valueOf(idPrograma.toString());
                            if (id == 41 || id == 42 || id == 43 || id == 44 || 
                                id == 48 || id == 49) {
                                laboroRegOrdinario = true;
                            } else if (id == 45 || id == 46) {
                                laboroRegEspecial = true;
                            } else {
                                laboroRegDesc = true;
                            }
                        } else {
                            System.out.println("No se pudo recuperar el programa en el que laboro el trabajador");
                        }
                    }
                    /*if (laboroRegDesc == true) {
                        System.out.println("El trabajador labor� en un r�gimen desconocido.");
                    } else if (laboroRegOrdinario == true &&
                               laboroRegEspecial == true) {
                        System.out.println("El trabajador labor� de forma mixta (R�gimen ordinario y especial)");
                    } else if (laboroRegOrdinario == true) {
                        System.out.println("El trabajador labor� �nicamente en el r�gimen ordinario");
                    } else if (laboroRegEspecial == true) {
                        System.out.println("El trabajador labor� �nicamente en el r�gimen especial");
                    } else {
                        System.out.println("No se pudo determinar en qu� r�gimen labor� el trabajador");
                    }*/
                    this.getInptText_programasLaboro().setSubmittedValue(null);
                    this.getInptText_programasLaboro().setValue(programasLaboro);
                    this.getInptText_tipoCasoExp().setSubmittedValue(null);
                    this.getInptText_idTipoCasoExp().setSubmittedValue(null);
                    //String bind = "#{bindings.Programa.inputValue}";
                    //FacesContext f = FacesContext.getCurrentInstance();
                    if (laboroRegDesc) {
                        this.getInptText_tipoCasoExp().setValue("Labor� en R�gimen Desconocido");
                        this.getInptText_idTipoCasoExp().setValue(utils.getNumberOracle("4"));
                        /*JSFUtils.setExpressionValue(f, bind,
                                                    utils.getNumberOracle("4"));*/
                    } else if (laboroRegOrdinario && laboroRegEspecial) {
                        this.getInptText_tipoCasoExp().setValue("Mixto (R�gimen Ordinario y Especial)");
                        this.getInptText_idTipoCasoExp().setValue(utils.getNumberOracle("3"));
                        /*JSFUtils.setExpressionValue(f, bind,
                                                    utils.getNumberOracle("3"));*/
                    } else if (laboroRegOrdinario) {
                        this.getInptText_tipoCasoExp().setValue("R�gimen Ordinario");
                        this.getInptText_idTipoCasoExp().setValue(utils.getNumberOracle("1"));
                        /*JSFUtils.setExpressionValue(f, bind,
                                                    utils.getNumberOracle("1"));*/
                    } else {
                        this.getInptText_tipoCasoExp().setValue("R�gimen Especial");
                        this.getInptText_idTipoCasoExp().setValue(utils.getNumberOracle("2"));
                        /*JSFUtils.setExpressionValue(f, bind,
                                                    utils.getNumberOracle("2"));*/
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
            } else {
                mensaje("No se pudieron recuperar los datos del trabajador. Intente de nuevo por favor!!", 
                        3);
            }
        }
        interfaz.cn_Cerrar_coneccion();
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

    //Funci�n que obtiene el �ltimo correlativo de SIS_INDEMNIZACI�N del a�o actual para Indemnizaci�n por Retiro Definitivo

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
                //No hubo errores y el resultado se guard� en una variable auxiliar
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

    //Funci�n que realiza el commit a la base de Datos

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
            mensaje("��No se pudo guardar porque ocurri� un error inesperado. Intente de nuevo por favor!!", 
                    3);
            desplegarErrores(operationBinding.getErrors()); //Despliega el detalle de los errores
            operationBinding = cont.getOperationBinding("Rollback");
            operationBinding.execute();
        }
        return correcto;
    }

    //Verifica si el trabajador ya se retir� de la instituci�n

    /*private boolean verificarRetiroTrabajador(FacesContext f) {
        boolean retirado = false;
        Object aux =
            JSFUtils.EjecutarAcccion(f, "ComprobarTrabajadorRetirado");
        if (aux != null) {
            int result = Integer.parseInt(aux.toString());
            if (result >= 1) {
                retirado = true;
            } else {
                mensaje("��El trabajador no aparece como retirado en el sistema, verifique por favor!!",
                        3);
            }
        } else {
            mensaje("Error al intentar verificar si el trabajador aparece como retirado en el sistema. Intente de nuevo por favor!!",
                    3);
        }
        return retirado;
    }*/

    //Valida el tiempo de Servicio, ya sea del formulario principal o formulario secundario

    private boolean validarTiempoDeServicio(int formulario) {
        boolean valido = false; //valor inicial
        boolean continuar = false;
        Number aniosServicio = null;
        Number mesesServicio = null;
        Number diasServicio = null;
        if (formulario == 1) {
            //Se refiere a la validaci�n del tiempo de servicio del formulario principal
            aniosServicio = 
                    (Number)this.getInptText_AniosServicio().getValue();
            mesesServicio = 
                    (Number)this.getInptText_MesesServicio().getValue();
            diasServicio = (Number)this.getInptText_DiasServicio().getValue();
        } else {
            //Se refiere a la validaci�n del tiempo de servicio del fomulario secundario
            aniosServicio = 
                    (Number)this.getInptText_AniosServicio_02().getValue();
            mesesServicio = 
                    (Number)this.getInptText_MesesServicio_02().getValue();
            diasServicio = 
                    (Number)this.getInptText_DiasServicio_02().getValue();
        }
        if (aniosServicio == null) {
            aniosServicio = new Number(0);
        }
        if (mesesServicio == null) {
            mesesServicio = new Number(0);
        }
        if (diasServicio == null) {
            diasServicio = new Number(0);
        }
        int anios = aniosServicio.intValue();
        int meses = mesesServicio.intValue();
        int dias = diasServicio.intValue();
        if ((anios < 0 || anios > 10) && anios != 12) {
            if (formulario == 1) {
                mensaje("!!A�os de Servicio para C�lculo de Indemnizaci�n Inv�lido. Debe ser entre 0 y 10, � 12!!", 
                        3);

            } else {
                mensaje("!!A�os de Servicio para C�lculo de Indemnizaci�n Autofinanciable Inv�lido. Debe ser entre 0 y 10, � 12!!", 
                        3);

            }
        } else if (meses != 0) {
            if (anios == 10 || anios == 12) {
                if (formulario == 1) {
                    mensaje("!!Meses de Servicio para C�lculo de Indemnizaci�n Inv�lido. Debe de ser 0 cuando los A�os de Servicio es 10 � 12!!", 
                            3);
                } else {
                    mensaje("!!Meses de Servicio para C�lculo de Indemnizaci�n Autofinanciable Inv�lido. Debe de ser 0 cuando los A�os de Servicio es 10 � 12!!", 
                            3);
                }
            } else if (meses < 0 || meses > 11) {
                if (formulario == 1) {
                    mensaje("!!Meses de Servicio para C�lculo de Indemnizaci�n Inv�lido. Debe ser entre 0 y 11!!", 
                            3);
                } else {
                    mensaje("!!Meses de Servicio para C�lculo de Indemnizaci�n Autifinanciable Inv�lido. Debe ser entre 0 y 11!!", 
                            3);
                }
            } else {
                continuar = true;
            }
        } else {
            continuar = true;
        }
        if (continuar == true) {
            continuar = false;
            if (dias != 0) {
                if (anios == 10 || anios == 12) {
                    if (formulario == 1) {
                        mensaje("!!D�as de Servicio para C�lculo de Indemnizaci�n Inv�lido. Debe de ser 0 cuando los A�os de Servicio es 10 � 12!!", 
                                3);
                    } else {
                        mensaje("!!D�as de Servicio para C�lculo de Indemnizaci�n Autofinanciable Inv�lido. Debe de ser 0 cuando los A�os de Servicio es 10 � 12!!", 
                                3);
                    }
                } else if (dias < 0 || dias > 29) {
                    if (formulario == 1) {
                        mensaje("!!D�as de Servicio para C�lculo de Indemnizaci�n Inv�lido. Debe ser entre 0 y 29!!", 
                                3);
                    } else {
                        mensaje("!!D�as de Servicio para C�lculo de Indemnizaci�n Autofinanciable Inv�lido. Debe ser entre 0 y 29!!", 
                                3);
                    }
                } else {
                    continuar = true;
                }
            } else {
                continuar = true;
            }
        }
        if (continuar == true) {
            if (anios <= 0 && meses <= 0 && dias <= 0) {
                if (formulario == 1) {
                    mensaje("!!Ingrese el Tiempo de Servicio para continuar!!", 
                            3);
                } else {
                    mensaje("!!Ingrese el Tiempo de Servicio Autofinanciable para continuar!!", 
                            3);
                }
            } else {
                valido = true;
            }
        }
        return valido;
    }

    //Valida la informaci�n ingresada en el formulario Principal

    private boolean validarInformacionFormPrinc() {
        boolean valido = false;
        boolean continuar = false;
        Object registroPersonal = 
            this.getInptText_registroEmpleado().getValue();
        oracle.jbo.domain.Date fechaRetiro = 
            (oracle.jbo.domain.Date)this.getSlctInputDate_fechaRetiro().getValue();
        oracle.jbo.domain.Date fechaSolicitud = 
            (oracle.jbo.domain.Date)this.getSlctInputDate_fechaSolicitud().getValue();
        Object tipoRetiro = this.getSlctOneChoice_tipoRetiro().getValue();
        //Object programa = this.getSlctOneChoice_programa().getValue();
        Object tipoCasoExpediente = 
            this.getInptText_idTipoCasoExp().getValue();
        Number totalSueldos = 
            (Number)this.getInptText_TotalSueldos().getValue();
        if (registroPersonal == null || 
            registroPersonal.toString().compareTo("") == 0) {
            mensaje("��Ingrese trabajador para continuar!!", 3);
        } else if (fechaRetiro == null) {
            mensaje("!!Ingrese Fecha de Retiro para continuar!!", 3);
        } else if (validarTiempoDeServicio(1)) {
            //el tiempo de servicio es v�lido
            continuar = true;
        }
        if (continuar == true) {
            continuar = false;
            int tipoCaso = 0;
            if (tipoCasoExpediente != null) {
                tipoCaso = Integer.parseInt(tipoCasoExpediente.toString());
            }
            System.out.println("El tipo de caso en la validaci�n de expediente es: " + 
                               tipoCaso);
            if (tipoRetiro == null) {
                mensaje("!!Seleccione un Tipo de Retiro para continuar!!", 3);
            } else if (tipoCaso <= 0 || tipoCaso > 3) {
                mensaje("!!No se pudo determinar el tipo de Expediente (Ordinario, Especial o Mixto)!!", 
                        3);
            } else if (totalSueldos == null || 
                       totalSueldos.doubleValue() <= 0) {
                mensaje("!!Ingrese Total de Sueldos para continuar!!", 3);
            } else if (fechaSolicitud == null) {
                mensaje("!!Ingrese Fecha de Solicitud para continuar!!", 3);
            } else {
                if (fechaSolicitud != null && fechaRetiro != null) {
                    if (fechaRetiro.dateValue().after(fechaSolicitud.dateValue())) {
                        mensaje("!!La Fecha de Retiro es m�s reciente que la Fecha de Solicitud!!", 
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
            //Verificamos si est� habilitado el campo de entrada N�mero de Cheque
            if (!this.getInptText_numeroCheque().isReadOnly()) {
                //Se encuentra habilitado
                Object aux = this.getInptText_numeroCheque().getValue();
                if (aux != null && Long.parseLong(aux.toString()) > 0) {
                    valido = true;
                } else {
                    mensaje("!!El N�mero de Cheque debe ser mayor de 0!!", 3);
                }
            } else {
                valido = true;
            }
        }
        return valido;
    }

    //Funci�n que procesa el guardar de una solicitud nueva

    private boolean procesar_guardar_sol_nueva(FacesContext f) {
        boolean exito = false;
        if (calcularIndemnizacion(f)) {
            String bind = "#{bindings.IdTipoPrestacion.inputValue}";
            try {
                JSFUtils.setExpressionValue(f, bind, 
                                            utils.getNumberOracle("1"));
                /*Object obj = JSFUtils.resolveExpression(f, bin);
                if (obj != null) {
                    int programa = Integer.parseInt(obj.toString());
                    System.out.println("El programa obtenido es: " + programa);
                } else {
                    System.out.println("No se pudo obtener el programa");
                }*/
                Object aux = this.getInptText_idTipoCasoExp().getValue();
                if (aux != null && Integer.parseInt(aux.toString()) > 0) {
                    int id = Integer.parseInt(aux.toString());
                    bind = "#{bindings.Programa.inputValue}";
                    JSFUtils.setExpressionValue(f, bind, 
                                                utils.getNumberOracle(id));
                    System.out.println("El caso obtenido es: " + id);
                } else {
                    System.out.println("No se pudo obtener el caso");
                }
                exito = commit(f);
            } catch (Exception e) {
                e.printStackTrace();
                mensaje("Ha ocurrido el siguiente error: " + e.getMessage(), 
                        3);
            }
        }
        return exito;
    }

    //Funci�n que procesa el guardar una solicitud existente

    private boolean procesar_guardar_sol_existente(FacesContext f) {
        boolean exito = false;
        String bin = "#{bindings.IdEstado.inputValue}";
        Object obj = JSFUtils.resolveExpression(f, bin);
        if (obj != null) {
            int idEstado = Integer.parseInt(obj.toString());
            if (idEstado == 250 || idEstado == 252) {
                //Estado grabado � objetado
                if (calcularIndemnizacion(f)) {
                    exito = commit(f);
                }
            } else if (idEstado == 256) {
                //Estado liquidado
                exito = commit(f);
            } else {
                exito = true; //para los dem�s estados deja pasar sin grabar
            }
        } else {
            mensaje("!!No se pudo recuperar la informaci�n correctamente!!", 
                    3);
        }
        return exito;
    }

    //Procedimiento que procesa el bot�n guardar

    private boolean procesar_guardar(FacesContext f, String bindEsSolNueva) {
        boolean exito = false;
        if (validarInformacionFormPrinc()) {
            Object auxObj = JSFUtils.resolveExpression(f, bindEsSolNueva);
            if (auxObj != null) {
                //Tiene alg�n valor
                boolean esNuevo = Boolean.parseBoolean(auxObj.toString());
                if (esNuevo) {
                    //Es solicitud nueva
                    exito = procesar_guardar_sol_nueva(f);
                } else {
                    //Es solicitud existente
                    exito = procesar_guardar_sol_existente(f);
                }
            } else {
                mensaje("!!No se pudo recuperar la informaci�n correctamente. Intente de nuevo!!", 
                        3);
            }
        }
        return exito;
    }

    public String cmdBtn_guardar_action() {
        String binding = "#{bindings.EsSolicitudNueva.inputValue}";
        FacesContext f = FacesContext.getCurrentInstance();
        if (procesar_guardar(f, binding)) {
            mensaje("��Informaci�n Guardada Correctamente!!", 1);
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
        mensaje("Operaci�n Cancelada Correctamente", 1);
        return null;
    }

    public String cmdBtn_retornar_action() {
        return "ir_a_listado_indemnizaciones";
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

    public String cmdBtn_retornar_gasto_funerario_action() {
        return "ir_a_listado_indemnizaciones";
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

    //Funci�n que realiza el c�lculo de la indemnizaci�n a pagar en base a la informaci�n ingresado por el usuario

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
            ///Ahora calculamos el monto total de Indemnizaci�n///
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
                ///seteamos el valor calculado en su binding respectivo///
                bind = "#{bindings.TotalPrestacion.inputValue}";
                JSFUtils.setExpressionValue(f, bind, 
                                            utils.getNumberOracle(String.format("%.2f", 
                                                                                montoIndTotal)));
                exito = true;
            } else {
                mensaje("��No hay Tiempo de Servicio para c�lculo de Indemnizaci�n!!", 
                        3);
            }
        } else {
            mensaje("��No hay Total de Sueldos para c�lculo de Indemnizaci�n!!", 
                    3);
        }
        return exito;
    }

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

    public void setInptText_programasLaboro(CoreInputText inptText_programasLaboro) {
        this.inptText_programasLaboro = inptText_programasLaboro;
    }

    public CoreInputText getInptText_programasLaboro() {
        return inptText_programasLaboro;
    }

    /*public void setSlctOneChoice_programa(CoreSelectOneChoice slctOneChoice_programa) {
        this.slctOneChoice_programa = slctOneChoice_programa;
    }

    public CoreSelectOneChoice getSlctOneChoice_programa() {
        return slctOneChoice_programa;
    }*/

    public void setCmdBtn_guardar_auto(CoreCommandButton cmdBtn_guardar_auto) {
        this.cmdBtn_guardar_auto = cmdBtn_guardar_auto;
    }

    public CoreCommandButton getCmdBtn_guardar_auto() {
        return cmdBtn_guardar_auto;
    }

    //Valida que el tiempo de servicio del formulario 2 sea menor al del formulario 1

    private boolean validarTiempo2MenorTiempo1() {
        boolean valido = false;
        Number anios01 = (Number)this.getInptText_AniosServicio().getValue();
        Number meses01 = (Number)this.getInptText_MesesServicio().getValue();
        Number dias01 = (Number)this.getInptText_DiasServicio().getValue();
        Number anios02 = 
            (Number)this.getInptText_AniosServicio_02().getValue();
        Number meses02 = 
            (Number)this.getInptText_MesesServicio_02().getValue();
        Number dias02 = (Number)this.getInptText_DiasServicio_02().getValue();
        if (anios01 == null) {
            anios01 = new Number(0);
        }
        if (meses01 == null) {
            meses01 = new Number(0);
        }
        if (dias01 == null) {
            dias01 = new Number(0);
        }
        if (anios02 == null) {
            anios02 = new Number(0);
        }
        if (meses02 == null) {
            meses02 = new Number(0);
        }
        if (dias02 == null) {
            dias02 = new Number(0);
        }
        int anios1 = anios01.intValue();
        int meses1 = meses01.intValue();
        int dias1 = dias01.intValue();
        int anios2 = anios02.intValue();
        int meses2 = meses02.intValue();
        int dias2 = dias02.intValue();
        if (anios2 < anios1) {
            valido = true;
        } else if (anios1 == anios2) {
            if (meses2 < meses1) {
                valido = true;
            } else if (meses1 == meses2) {
                if (dias2 < dias1) {
                    valido = true;
                } else if (dias1 == dias2) {
                    System.out.println();
                    mensaje("��El tiempo de servicio Autofinanciable es igual al consolidado!!", 
                            3);
                } else {
                    mensaje("��El tiempo de servicio Autofinanciable es mayor al consolidado!!", 
                            3);
                }
            } else {
                mensaje("��El tiempo de servicio Autofinanciable es mayor al consolidado!!", 
                        3);
            }
        } else {
            mensaje("��El tiempo de servicio Autofinanciable es mayor al consolidado!!", 
                    3);
        }
        return valido;
    }

    //Valida la informaci�n ingresada en el formulario Secundario

    private boolean validarInformacionFormSec() {
        boolean valido = false;
        boolean continuar = false;
        Number totalSueldos = 
            (Number)this.getInptText_TotalSueldos02().getValue();
        if (validarTiempoDeServicio(2)) {
            //el tiempo de servicio es v�lido
            if (validarTiempo2MenorTiempo1()) {
                //El tiempo de servicio del formulario 2 es menor al 1
                continuar = true;
            }
        }
        if (continuar == true) {
            //continuar = false;
            if (totalSueldos == null || totalSueldos.doubleValue() <= 0) {
                mensaje("!!Ingrese el Total de Sueldos en Autofinanciable para continuar!!", 
                        3);
            } else {
                //continuar = true;
                valido = true;
            }
        }
        return valido;
    }

    //Funci�n que realiza el c�lculo de la indemnizaci�n a pagar en base a la informaci�n ingresado por el usuario
    //En el formulario de Autofinanciable

    private boolean calcularIndemnizacionAuto(FacesContext f) {
        boolean exito = false;
        Object aux = this.getInptText_TotalSueldos02().getValue();
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
            String bind = "#{bindings.DiferidoCalc2.inputValue}";
            Number num = 
                utils.getNumberOracle(String.format("%.2f", diferido));
            JSFUtils.setExpressionValue(f, bind, num);
            bind = "#{bindings.Diferido12Calc2.inputValue}";
            num = utils.getNumberOracle(String.format("%.2f", diferido12));
            JSFUtils.setExpressionValue(f, bind, num);
            bind = "#{bindings.AguinaldoCalc2.inputValue}";
            num = utils.getNumberOracle(String.format("%.2f", aguinaldo));
            JSFUtils.setExpressionValue(f, bind, num);
            bind = "#{bindings.Bono14Calc2.inputValue}";
            num = utils.getNumberOracle(String.format("%.2f", bono14));
            JSFUtils.setExpressionValue(f, bind, num);
            bind = "#{bindings.SueldoPromedio2.inputValue}";
            num = utils.getNumberOracle(String.format("%.2f", sueldoPromedio));
            JSFUtils.setExpressionValue(f, bind, num);
            ///Ahora calculamos el monto total de Indemnizaci�n///
            Object anios = this.getInptText_AniosServicio_02().getValue();
            Object meses = this.getInptText_MesesServicio_02().getValue();
            Object dias = this.getInptText_DiasServicio_02().getValue();
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
                ///seteamos el valor calculado en su binding respectivo///
                bind = "#{bindings.TotalPrestacion2.inputValue}";
                JSFUtils.setExpressionValue(f, bind, 
                                            utils.getNumberOracle(String.format("%.2f", 
                                                                                montoIndTotal)));
                exito = true;
            } else {
                mensaje("��No hay Tiempo de Servicio para C�lculo de Indemnizaci�n Autofinanciable!!", 
                        3);
            }
        } else {
            mensaje("��No hay Total de Sueldos para C�lculo de Indemnizaci�n Autofinanciable!!", 
                    3);
        }
        return exito;
    }

    //Funci�n que procesa el guardar de una solicitud nueva autofinanciable

    private boolean procesar_guardar_auto_nuevo(FacesContext f) {
        boolean exito = false;
        if (calcularIndemnizacionAuto(f)) {
            try {
                //El tipo de prestaci�n para el formulario secundario ser� 1=Indemnizaci�n por Retiro
                JSFUtils.setExpressionValue(f, 
                                            "#{bindings.IdTipoPrestacion2.inputValue}", 
                                            utils.getNumberOracle("1"));
                //Tomamos el registro de personal de formulario principal para colocarlo en el secundario
                Object regPersonal = 
                    JSFUtils.resolveExpression(f, "#{bindings.RegistroEmpleado.inputValue}");
                if (regPersonal != null) {
                    //Lo colocamos en el formulario secundario
                    JSFUtils.setExpressionValue(f, 
                                                "#{bindings.RegistroEmpleado2.inputValue}", 
                                                regPersonal);
                    //Ahora recuperamos el ID del formulario principal para colocarlo como padre del secundario
                    Object idIndem = 
                        JSFUtils.resolveExpression(f, "#{bindings.IdIndemnizacion.inputValue}");
                    if (idIndem != null) {
                        JSFUtils.setExpressionValue(f, 
                                                    "#{bindings.IdPadre2.inputValue}", 
                                                    idIndem);
                        //El tipo de programa es 2 = autofinanciable
                        JSFUtils.setExpressionValue(f, 
                                                    "#{bindings.Programa2.inputValue}", 
                                                    utils.getNumberOracle("2"));
                        Date fecha = 
                            utils.getFechaOracle(utils.getFechaFormato3("dd/MM/yyyy", 
                                                                        JSFUtils.resolveExpression(f, 
                                                                                                   "#{bindings.FechaRetiro.inputValue}")));
                        JSFUtils.setExpressionValue(f, 
                                                    "#{bindings.FechaRetiro2.inputValue}", 
                                                    fecha);
                        Number tipoRet = 
                            utils.getNumberOracle(JSFUtils.resolveExpression(f, 
                                                                             "#{bindings.TipoRetiro.inputValue}"));
                        JSFUtils.setExpressionValue(f, 
                                                    "#{bindings.TipoRetiro2.inputValue}", 
                                                    tipoRet);
                        exito = commit(f);
                    } else {
                        mensaje("��No se pudo obtener la informaci�n para guardar!!", 
                                3);
                    }
                } else {
                    mensaje("��No se pudo obtener la informaci�n para guardar!!", 
                            3);
                }
            } catch (Exception e) {
                e.printStackTrace();
                mensaje("Ha ocurrido el siguiente error: " + e.getMessage(), 
                        3);
            }
        }
        return exito;
    }

    //Funci�n que procesa el guardar una solicitud existente autofinanciable

    private boolean procesar_guardar_auto_exist(FacesContext f) {
        boolean exito = false;
        /*String bin = "#{bindings.IdEstado.inputValue}";
        Object obj = JSFUtils.resolveExpression(f, bin);
        if (obj != null) {
            int idEstado = Integer.parseInt(obj.toString());
            if (idEstado == 250 || idEstado == 252) {
                //Estado grabado � objetado
                if (calcularIndemnizacion(f)) {*/
        exito = commit(f);
        /*}
            } else if (idEstado == 256) {
                //Estado liquidado
                exito = commit(f);
            } else {
                exito = true; //para los dem�s estados deja pasar sin grabar
            }
        } else {
            mensaje("!!No se pudo recuperar la informaci�n correctamente!!",
                    3);
        }*/
        return exito;
    }

    //Funci�n que procesa el bot�n Guardar del formulario de Solicitud de Pago Autofinanciable

    private boolean procesar_guardar_auto(FacesContext f, 
                                          String bindEsSolNueva) {
        boolean exito = false;
        //Primero validamos la informaci�n del formulario principal
        if (validarInformacionFormPrinc()) {
            if (validarInformacionFormSec()) {
                Object obj = JSFUtils.resolveExpression(f, bindEsSolNueva);
                if (obj != null) {
                    //Tiene alg�n valor
                    boolean esNuevo = Boolean.parseBoolean(obj.toString());
                    if (esNuevo) {
                        //Es solicitud nueva
                        exito = procesar_guardar_auto_nuevo(f);

                    } else {
                        //Es solicitud existente
                        exito = procesar_guardar_auto_exist(f);
                    }
                } else {
                    mensaje("!!No se pudo recuperar la informaci�n correctamente!!", 
                            3);
                }
            }
        }
        return exito;
    }

    public String cmdBtn_guardar_auto_action() {
        String binding = "#{bindings.EsSolicitudNuevaAuto.inputValue}";
        FacesContext f = FacesContext.getCurrentInstance();
        if (procesar_guardar_auto(f, binding)) {
            mensaje("��Informaci�n Guardada Correctamente!!", 1);
            JSFUtils.setExpressionValue(f, binding, 
                                        Boolean.parseBoolean("false"));
            /* JSFUtils.EjecutarAcccion(f, "Rollback"); //para que pueda trasladar sin inconvenientes*/
            ///JSFUtils.EjecutarAcccion(f, "RecuperarSolicitudMixto");
            JSFUtils.EjecutarAcccion(f, "RefrescarIndemnizacion");
            JSFUtils.EjecutarAcccion(f, "RefrescarIndemnizacionMixto");
            this.cmdLink_trasladar_solicitud.setDisabled(false);
        }
        return null;
    }

    public String cmdBtn_cancelar_auto_action() {
        FacesContext faces = FacesContext.getCurrentInstance();
        JSFUtils.EjecutarAcccion(faces, "Rollback");
        String bind = "#{bindings.EsSolicitudNuevaAuto.inputValue}";
        Object esNuevo = JSFUtils.resolveExpression(faces, bind);
        if (esNuevo != null && Boolean.parseBoolean(esNuevo.toString())) {
            //Es solicitud nueva
            //JSFUtils.EjecutarAcccion(faces, "CrearSolicitudMixto");
            //Rehace el formulario de Autofinanciable
            this.getPnlForm_autofinanciable().setRendered(false);
            this.getCmdBtn_crear_autofin().setRendered(true);
            //Rehace los botones del formulario principal 
            this.getCmdBtn_guardar().setDisabled(false);
            this.getCmdBtn_cancelar().setDisabled(false);
            this.getCmdLink_trasladar_solicitud().setDisabled(false);
            JSFUtils.setExpressionValue(faces, bind, 
                                        Boolean.parseBoolean("false"));
        }
        mensaje("��Operaci�n Cancelada Correctamente!!", 1);
        return null;
    }

    public void setInptText_AniosServicio_02(CoreInputText inptText_AniosServicio_02) {
        this.inptText_AniosServicio_02 = inptText_AniosServicio_02;
    }

    public CoreInputText getInptText_AniosServicio_02() {
        return inptText_AniosServicio_02;
    }

    public void setInptText_MesesServicio_02(CoreInputText inptText_MesesServicio_02) {
        this.inptText_MesesServicio_02 = inptText_MesesServicio_02;
    }

    public CoreInputText getInptText_MesesServicio_02() {
        return inptText_MesesServicio_02;
    }

    public void setInptText_DiasServicio_02(CoreInputText inptText_DiasServicio_02) {
        this.inptText_DiasServicio_02 = inptText_DiasServicio_02;
    }

    public CoreInputText getInptText_DiasServicio_02() {
        return inptText_DiasServicio_02;
    }

    public void setPnlForm_autofinanciable(CorePanelForm pnlForm_autofinanciable) {
        this.pnlForm_autofinanciable = pnlForm_autofinanciable;
    }

    public CorePanelForm getPnlForm_autofinanciable() {
        return pnlForm_autofinanciable;
    }

    public void setCmdBtn_crear_autofin(CoreCommandButton cmdBtn_crear_autofin) {
        this.cmdBtn_crear_autofin = cmdBtn_crear_autofin;
    }

    public CoreCommandButton getCmdBtn_crear_autofin() {
        return cmdBtn_crear_autofin;
    }

    public String cmdBtn_crear_autofin_action() {
        mensaje("��Nuevo formulario para Programa Autofinanciable creado correctamente!!", 
                1);
        this.getPnlForm_autofinanciable().setRendered(true);
        this.getCmdBtn_crear_autofin().setRendered(false);
        this.getCmdBtn_guardar().setDisabled(true);
        this.getCmdBtn_cancelar().setDisabled(true);
        this.getCmdLink_trasladar_solicitud().setDisabled(true);
        String binding = "#{bindings.EsSolicitudNuevaAuto.inputValue}";
        FacesContext f = FacesContext.getCurrentInstance();
        JSFUtils.setExpressionValue(f, binding, Boolean.parseBoolean("true"));
        return null;
    }

    public void setInptText_TotalSueldos02(CoreInputText inptText_TotalSueldos02) {
        this.inptText_TotalSueldos02 = inptText_TotalSueldos02;
    }

    public CoreInputText getInptText_TotalSueldos02() {
        return inptText_TotalSueldos02;
    }

    public void setInptText_tipoCasoExp(CoreInputText inptText_tipoCasoExp) {
        this.inptText_tipoCasoExp = inptText_tipoCasoExp;
    }

    public CoreInputText getInptText_tipoCasoExp() {
        return inptText_tipoCasoExp;
    }

    public void setInptText_idTipoCasoExp(CoreInputText inptText_idTipoCasoExp) {
        this.inptText_idTipoCasoExp = inptText_idTipoCasoExp;
    }

    public CoreInputText getInptText_idTipoCasoExp() {
        return inptText_idTipoCasoExp;
    }

    public void setCmdBtn_cancelar(CoreCommandButton cmdBtn_cancelar) {
        this.cmdBtn_cancelar = cmdBtn_cancelar;
    }

    public CoreCommandButton getCmdBtn_cancelar() {
        return cmdBtn_cancelar;
    }

    public void setCmdBtn_cancelar_auto(CoreCommandButton cmdBtn_cancelar_auto) {
        this.cmdBtn_cancelar_auto = cmdBtn_cancelar_auto;
    }

    public CoreCommandButton getCmdBtn_cancelar_auto() {
        return cmdBtn_cancelar_auto;
    }
}
