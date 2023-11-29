package enlace_datos.consultas;

import enlace_datos.consultas.admin.SisAjustePartida_VwImpl;
import enlace_datos.consultas.admin.SisIntervaloIsrViewImpl;
import enlace_datos.consultas.admin.SisParametrosAplicacionVwImpl;
import enlace_datos.consultas.admin.SisParametrosApp_restric_vwImpl;
import enlace_datos.consultas.admin.Sis_tiposerv_puesto_vwImpl;
import enlace_datos.consultas.admin.categoriaImpl;
import enlace_datos.consultas.admin.consulta_puestoImpl;
import enlace_datos.consultas.admin.historico_puestoImpl;
import enlace_datos.consultas.admin.nivelImpl;
import enlace_datos.consultas.admin.puestoImpl;
import enlace_datos.consultas.admin.sis_tipo_deduccion_isrImpl;
import enlace_datos.consultas.ajustes.SisAjusteActivosImpl;
import enlace_datos.consultas.ajustes.SisAjusteExcludEmpleadoVwImpl;
import enlace_datos.consultas.ajustes.SisAjusteImpl;
import enlace_datos.consultas.ajustes.SisAjustesSinFiltroImpl;
import enlace_datos.consultas.ajustes.SisReglaImpl;
import enlace_datos.consultas.ajustes.SisTipoAjusteImpl;
import enlace_datos.consultas.ajustes.Sis_Ajuste_x_tipoImpl;
import enlace_datos.consultas.ajustes.ajuste_nivelImpl;
import enlace_datos.consultas.ajustes.tipoajuste_operacionImpl;
import enlace_datos.consultas.analisis.empleado.consul_empleado_vwImpl;
import enlace_datos.consultas.analisis.empleado.contratoImpl;
import enlace_datos.consultas.analisis.empleado.licencias_vwImpl;
import enlace_datos.consultas.analisis.empleado.suspensionIgss_vwImpl;
import enlace_datos.consultas.common.QUERRYS;
import enlace_datos.consultas.complementos.ComplementoPersonalVImpl;
import enlace_datos.consultas.complementos.ListadoPlazasXUniDepImpl;
import enlace_datos.consultas.complementos.ListadoPrestxRetPorEmpleadoImpl;
import enlace_datos.consultas.complementos.ListadoPuestoxTrabajadorVImpl;
import enlace_datos.consultas.complementos.ListadoTipoNominaImpl;
import enlace_datos.consultas.complementos.SisCompleRevPendISRVwImpl;
import enlace_datos.consultas.complementos.SisCompleRevPendVwImpl;
import enlace_datos.consultas.complementos.SisComplementoDetVwImpl;
import enlace_datos.consultas.complementos.SisComplementoDetajustesVwImpl;
import enlace_datos.consultas.complementos.SisComplementoIgssPorEmpleadoVwImpl;
import enlace_datos.consultas.complementos.SisComplementoIgssVwImpl;
import enlace_datos.consultas.complementos.SisComplementoPlazaVac_vwImpl;
import enlace_datos.consultas.complementos.SisComplementoPorIdVwImpl;
import enlace_datos.consultas.complementos.SisComplementoVwImpl;
import enlace_datos.consultas.complementos.SisParamSuspIgssVwImpl;
import enlace_datos.consultas.complementos.SisPartProv_devnopag_vwImpl;
import enlace_datos.consultas.complementos.Sis_CompleRevisadosISR_vwImpl;
import enlace_datos.consultas.complementos.Sis_CompleRevisados_vwImpl;
import enlace_datos.consultas.complementos.TieneAlgunPagoImpl;
import enlace_datos.consultas.empleado.Sis_experiencia_profesionalImpl;
import enlace_datos.consultas.empleado.Sis_list_dest_empleado_vwImpl;
import enlace_datos.consultas.empleado.Sis_list_detPagoDesc_vwImpl;
import enlace_datos.consultas.empleado.Sis_list_referencias_empleado_fichaImpl;
import enlace_datos.consultas.empleado.consul_empl_bibliovwImpl;
import enlace_datos.consultas.empleado.sis_desc_judicial_consulImpl;
import enlace_datos.consultas.empleado.sis_fallecimiento_consulImpl;
import enlace_datos.consultas.empleado.sis_licencias_consulImpl;
import enlace_datos.consultas.empleado.sis_nombramientos_consulImpl;
import enlace_datos.consultas.empleado.sis_promo_reclaf_consulImpl;
import enlace_datos.consultas.empleado.sis_reintegrosImpl;
import enlace_datos.consultas.empleado.sis_renuncia_parcialImpl;
import enlace_datos.consultas.empleado.sis_renuncias_despImpl;
import enlace_datos.consultas.empleado.sis_retiro_obligatorio_consulImpl;
import enlace_datos.consultas.empleado.sis_solBajaLaboralvwImpl;
import enlace_datos.consultas.empleado.sis_suspenciones_igss_consulImpl;
import enlace_datos.consultas.empleado.sis_tiempo_extra_consulImpl;
import enlace_datos.consultas.gestiones.ContratosParaTE031Lista_vwImpl;
import enlace_datos.consultas.gestiones.ContratosParaTE031_vwImpl;
import enlace_datos.consultas.gestiones.SaldoAnualvwImpl;
import enlace_datos.consultas.gestiones.SicoinPartidaEgresosViewImpl;
import enlace_datos.consultas.gestiones.SisArchivoAdjuntoSolImpl;
import enlace_datos.consultas.gestiones.SisContrato_byRegAnioImpl;
import enlace_datos.consultas.gestiones.SisDeduccionIsr2VwImpl;
import enlace_datos.consultas.gestiones.SisDeduccionIsrOtrPat_vwImpl;
import enlace_datos.consultas.gestiones.SisDescuentoReintegroVwImpl;
import enlace_datos.consultas.gestiones.SisDetLicenciaVwImpl;
import enlace_datos.consultas.gestiones.SisDetalleReintegroVwImpl;
import enlace_datos.consultas.gestiones.SisDetplazaCubreLicVwImpl;
import enlace_datos.consultas.gestiones.SisEmpleadoJubiladoVwImpl;
import enlace_datos.consultas.gestiones.SisIsrForm1101OtrosptrnosVwImpl;
import enlace_datos.consultas.gestiones.SisIsrForm1101VwImpl;
import enlace_datos.consultas.gestiones.SisIsrproy031vwImpl;
import enlace_datos.consultas.gestiones.SisIsrproyDetDesc_vwImpl;
import enlace_datos.consultas.gestiones.SisIsrproyDetvwImpl;
import enlace_datos.consultas.gestiones.SisLicenciasSinGoceVwImpl;
import enlace_datos.consultas.gestiones.SisMotivoDetLicenciaVwImpl;
import enlace_datos.consultas.gestiones.SisPartidavwImpl;
import enlace_datos.consultas.gestiones.SisPlazaComentarioVwImpl;
import enlace_datos.consultas.gestiones.SisPromReclafViewImpl;
import enlace_datos.consultas.gestiones.SisPuestoXCategoriaVwImpl;
import enlace_datos.consultas.gestiones.SisReintegroEmpVwImpl;
import enlace_datos.consultas.gestiones.SisSolDescJudImpl;
import enlace_datos.consultas.gestiones.SisSolicitudVwImpl;
import enlace_datos.consultas.gestiones.SisTipoSolicitudImpl;
import enlace_datos.consultas.gestiones.SisTransferencia_vwImpl;
import enlace_datos.consultas.gestiones.SisVariacionNominavw2Impl;
import enlace_datos.consultas.gestiones.Sis_Arch_adjuntoImpl;
import enlace_datos.consultas.gestiones.Sis_Departamentos2_vwImpl;
import enlace_datos.consultas.gestiones.Sis_Solicitud_rev_vwImpl;
import enlace_datos.consultas.gestiones.Sis_ajuste_modificables_empl_vwImpl;
import enlace_datos.consultas.gestiones.Sis_ajustes_mod_simple2Impl;
import enlace_datos.consultas.gestiones.Sis_deudores_vwImpl;
import enlace_datos.consultas.gestiones.Sis_variacionNom_Revisada_vwImpl;
import enlace_datos.consultas.gestiones.Sis_variacionNom_pendiente_vwImpl;
import enlace_datos.consultas.gestiones.anexo.SisPuesto_vwImpl;
import enlace_datos.consultas.gestiones.anexo.consul_alzaNom_anexoImpl;
import enlace_datos.consultas.gestiones.anexo.consul_anexo_vwImpl;
import enlace_datos.consultas.gestiones.anexo.consul_plazaXempleado_vwImpl;
import enlace_datos.consultas.gestiones.anexo.consul_puestoXempleadoImpl;
import enlace_datos.consultas.gestiones.anexo.consul_puesto_promocion_vwImpl;
import enlace_datos.consultas.gestiones.anexo.consul_sisPartida_vwImpl;
import enlace_datos.consultas.gestiones.anexo.consul_sisPlaza_vwImpl;
import enlace_datos.consultas.gestiones.anexo.consul_sisTipoMovPlazaImpl;
import enlace_datos.consultas.gestiones.anexo.encabezado_anexo_vwImpl;
import enlace_datos.consultas.gestiones.anexo.sis_anexoImpl;
import enlace_datos.consultas.gestiones.anexo.sis_movimiento_plazaImpl;
import enlace_datos.consultas.gestiones.censo.SisDireccionFiscalVwImpl;
import enlace_datos.consultas.gestiones.censo.SisFichaEmpleadoVwImpl;
import enlace_datos.consultas.gestiones.censo.SisRespuestaCensoVwImpl;
import enlace_datos.consultas.gestiones.censo.SisTipoJubiladoVwImpl;
import enlace_datos.consultas.gestiones.censo.SisUnidadAcademicaVwImpl;
import enlace_datos.consultas.gestiones.cheques.SisChequeDescartadoVwImpl;
import enlace_datos.consultas.gestiones.cheques.SisMotivoChequeRechaImpl;
import enlace_datos.consultas.gestiones.cheques.Sis_docPagoAnuladoForm22Impl;
import enlace_datos.consultas.gestiones.cheques.consul_MotivoAnulacionImpl;
import enlace_datos.consultas.gestiones.cheques.consul_buscheque_anularImpl;
import enlace_datos.consultas.gestiones.cheques.consul_cheqAnuladoXRecibir_vwImpl;
import enlace_datos.consultas.gestiones.cheques.consul_cheque_descartado_vwImpl;
import enlace_datos.consultas.gestiones.cheques.consul_cheque_reintegroImpl;
import enlace_datos.consultas.gestiones.cheques.consul_det_cheque_anularImpl;
import enlace_datos.consultas.gestiones.cheques.sis_acta_facsimil_vwImpl;
import enlace_datos.consultas.gestiones.cheques.sis_comision_facsimilImpl;
import enlace_datos.consultas.gestiones.cheques.sis_detCheques_facsimil_vwImpl;
import enlace_datos.consultas.gestiones.cheques.sis_docPago_recibido_vwImpl;
import enlace_datos.consultas.gestiones.cheques.view_SisDocPagoAnuladoImpl;
import enlace_datos.consultas.gestiones.consul_asignacion_ajusteImpl;
import enlace_datos.consultas.gestiones.contrato.SisAuthContratoVwImpl;
import enlace_datos.consultas.gestiones.contrato.SisContrato029VwExImpl;
import enlace_datos.consultas.gestiones.contrato.SisContrato029VwImpl;
import enlace_datos.consultas.gestiones.contrato.SisContrato031vwImpl;
import enlace_datos.consultas.gestiones.contrato.SisContrato_vwImpl;
import enlace_datos.consultas.gestiones.contrato.SisContratosActivosDepImpl;
import enlace_datos.consultas.gestiones.contrato.SisHistActaHorarioContratoVwImpl;
import enlace_datos.consultas.gestiones.contrato.SisHorarioContratoImpl;
import enlace_datos.consultas.gestiones.contrato.SisPartida029_vwImpl;
import enlace_datos.consultas.gestiones.contrato.SisPartida031_vwImpl;
import enlace_datos.consultas.gestiones.contrato.SisPartidaProvisionVwImpl;
import enlace_datos.consultas.gestiones.contrato.SisPlazaXUsuarioVwImpl;
import enlace_datos.consultas.gestiones.contrato.SisPlazaxUsuarioEmpl_vwImpl;
import enlace_datos.consultas.gestiones.contrato.SisUnidadesEjecutoras_Id_vwImpl;
import enlace_datos.consultas.gestiones.contrato.SisUnidadesEjecutoras_depsImpl;
import enlace_datos.consultas.gestiones.contrato.SisVacacionEmpleadoVwImpl;
import enlace_datos.consultas.gestiones.contrato.Sis_UniversidadesVwImpl;
import enlace_datos.consultas.gestiones.contrato.Sis_firmas_docs_regper_vwImpl;
import enlace_datos.consultas.gestiones.contrato.Sis_firmas_docs_vwImpl;
import enlace_datos.consultas.gestiones.contrato.arch_adjunto_contratoImpl;
import enlace_datos.consultas.gestiones.contrato.contrato_busquedaImpl;
import enlace_datos.consultas.gestiones.contrato.contratos_del_tesorero_vwImpl;
import enlace_datos.consultas.gestiones.contrato.dependenciasImpl;
import enlace_datos.consultas.gestiones.contrato.sis_contrato_busq2Impl;
import enlace_datos.consultas.gestiones.contrato.unidades_ejecImpl;
import enlace_datos.consultas.gestiones.dictamen.consul_nomDictamen_vwImpl;
import enlace_datos.consultas.gestiones.dictamen.sisDictamenDetalle_vwImpl;
import enlace_datos.consultas.gestiones.dictamen.sisDictamen_vwImpl;
import enlace_datos.consultas.gestiones.empleado.SisBeneficiarioImpl;
import enlace_datos.consultas.gestiones.empleado.SisContratosActivos_by_regImpl;
import enlace_datos.consultas.gestiones.empleado.SisContratosEmplOpVwImpl;
import enlace_datos.consultas.gestiones.empleado.SisContratos_ant_empl_vwImpl;
import enlace_datos.consultas.gestiones.empleado.SisCuentaVwImpl;
import enlace_datos.consultas.gestiones.empleado.SisDeclaracionJuradaVwImpl;
import enlace_datos.consultas.gestiones.empleado.SisDireccionImpl;
import enlace_datos.consultas.gestiones.empleado.SisEmpleadoCambiosVwImpl;
import enlace_datos.consultas.gestiones.empleado.SisEmpleadoPendienteReg_vwImpl;
import enlace_datos.consultas.gestiones.empleado.SisEmpleadoVwImpl;
import enlace_datos.consultas.gestiones.empleado.SisFormaPagoVwImpl;
import enlace_datos.consultas.gestiones.empleado.SisGrupoEtnicoVwImpl;
import enlace_datos.consultas.gestiones.empleado.SisHorarioDecJuradaVwImpl;
import enlace_datos.consultas.gestiones.empleado.SisMonedaImpl;
import enlace_datos.consultas.gestiones.empleado.SisNivelAcadImpl;
import enlace_datos.consultas.gestiones.empleado.SisPlazasEmpleadoComplVwImpl;
import enlace_datos.consultas.gestiones.empleado.SisPlazasPerfil_EmpleadoImpl;
import enlace_datos.consultas.gestiones.empleado.SisRegPerAsignacionVwExImpl;
import enlace_datos.consultas.gestiones.empleado.SisRegPerAsignacionVwImpl;
import enlace_datos.consultas.gestiones.empleado.SisSueldosEmpl_ISR_vwImpl;
import enlace_datos.consultas.gestiones.empleado.Sis_ListLic_empleado_vwImpl;
import enlace_datos.consultas.gestiones.empleado.Sis_contratos_susp_igss_vwImpl;
import enlace_datos.consultas.gestiones.empleado.Sis_descuentos_empleadoImpl;
import enlace_datos.consultas.gestiones.empleado.Sis_foto_empleado_vwImpl;
import enlace_datos.consultas.gestiones.empleado.consul_contrato_variacion_vwImpl;
import enlace_datos.consultas.gestiones.empleado.detalle_desImpl;
import enlace_datos.consultas.gestiones.empleado.lista_empleadosImpl;
import enlace_datos.consultas.gestiones.empleado.plazaempleadoVwImpl;
import enlace_datos.consultas.gestiones.empleado.plazaregistroImpl;
import enlace_datos.consultas.gestiones.empleado.sis_beneficiario_cta_actual_vwImpl;
import enlace_datos.consultas.gestiones.empleado.sis_cuenta_actual_vwImpl;
import enlace_datos.consultas.gestiones.empleado.sis_parentescoImpl;
import enlace_datos.consultas.gestiones.empleado.sis_timbres_empl_vwImpl;
import enlace_datos.consultas.gestiones.empleado.todos_los_DepartamentoImpl;
import enlace_datos.consultas.gestiones.empleado.todos_municipiosImpl;
import enlace_datos.consultas.gestiones.empleado.valores_estadoCivilImpl;
import enlace_datos.consultas.gestiones.empleado.valores_generoImpl;
import enlace_datos.consultas.gestiones.empleado_ficha.Sis_documento_adj_especifico_vwImpl;
import enlace_datos.consultas.gestiones.empleado_ficha.Sis_documento_adjunto_vwImpl;
import enlace_datos.consultas.gestiones.empleado_ficha.Sis_ficha_empleado_consulta_vwImpl;
import enlace_datos.consultas.gestiones.empleado_ficha.Sis_tipo_archivo_adjunto_vwImpl;
import enlace_datos.consultas.gestiones.horas_extras.consul_Hora_extra_vwImpl;
import enlace_datos.consultas.gestiones.horas_extras.consul_contratosAdmin_byReg_vwImpl;
import enlace_datos.consultas.gestiones.horas_extras.consul_partidaGasto_vwImpl;
import enlace_datos.consultas.gestiones.horas_extras.consul_partidaSICOIN_vwImpl;
import enlace_datos.consultas.gestiones.horas_extras.empleado_x_unidad_vwImpl;
import enlace_datos.consultas.gestiones.horas_extras.sis_det_tiempo_extra_vwImpl;
import enlace_datos.consultas.gestiones.horas_extras.sis_hora_extra_vwImpl;
import enlace_datos.consultas.gestiones.horas_extras.sis_tiempo_extraordinario_vwImpl;
import enlace_datos.consultas.gestiones.indemnizaciones.SisHistorialSalarialIndemnizacion_vwImpl;
import enlace_datos.consultas.gestiones.indemnizaciones.SisIndemnizacion_vwImpl;
import enlace_datos.consultas.gestiones.indemnizaciones.SisRelacionLaboral_vwImpl;
import enlace_datos.consultas.gestiones.indemnizaciones.SisSolicitudesRenunciaIndem_vwImpl;
import enlace_datos.consultas.gestiones.indemnizaciones.SisTipoIndemnizacion_vwImpl;
import enlace_datos.consultas.gestiones.judiciales.consul_depto_porel_municipioImpl;
import enlace_datos.consultas.gestiones.judiciales.consul_tipCondicion_ordenJudiImpl;
import enlace_datos.consultas.gestiones.judiciales.consul_tipo_judicialImpl;
import enlace_datos.consultas.gestiones.judiciales.sis_condicion_ordenJudicial_vwImpl;
import enlace_datos.consultas.gestiones.judiciales.view_orden_judicialImpl;
import enlace_datos.consultas.gestiones.partidasSICOINImpl;
import enlace_datos.consultas.gestiones.plazas021.consul_sispartida021Impl;
import enlace_datos.consultas.gestiones.plazas021.consul_sispuesto021Impl;
import enlace_datos.consultas.gestiones.plazas021.sis_plazaImpl;
import enlace_datos.consultas.gestiones.plazasParaMapearImpl;
import enlace_datos.consultas.gestiones.post_mortem.SisPostMortem_vwImpl;
import enlace_datos.consultas.gestiones.procesos.ProcesoVwImpl;
import enlace_datos.consultas.gestiones.procesos.SisProcesoSfltroImpl;
import enlace_datos.consultas.gestiones.procesos.SisProcesoVw2Impl;
import enlace_datos.consultas.gestiones.procesos.Sis_formsis24_vwImpl;
import enlace_datos.consultas.gestiones.procesos.Sis_remesaImpl;
import enlace_datos.consultas.gestiones.procesos.periodos_proc_vwImpl;
import enlace_datos.consultas.gestiones.procesos.tipo_proceso_vwImpl;
import enlace_datos.consultas.gestiones.revision.SisContratosPendientesRevImpl;
import enlace_datos.consultas.gestiones.revision.SisContratosRevisadosImpl;
import enlace_datos.consultas.gestiones.sis_deduccion_isrImpl;
import enlace_datos.consultas.gestiones.sis_reintegro_vwImpl;
import enlace_datos.consultas.gestiones.sis_resumen_deduccion_isrImpl;
import enlace_datos.consultas.gestiones.variacionDetAjusteImpl;
import enlace_datos.consultas.gestiones.variacion_nominaImpl;
import enlace_datos.consultas.mensajes.SisMensajeSalienteVwImpl;
import enlace_datos.consultas.mensajes.SisMensajesEntrantesVwImpl;
import enlace_datos.consultas.mensajes.SisMensajesRelacionadosVwImpl;
import enlace_datos.consultas.nomina.SisConciliacionAcreditVwImpl;
import enlace_datos.consultas.nomina.SisConsulPlazaImpl;
import enlace_datos.consultas.nomina.SisConsultaChequeConciaVWImpl;
import enlace_datos.consultas.nomina.SisDetCalculoAjusteAgrupVwImpl;
import enlace_datos.consultas.nomina.SisDetCalculoAjusteVwImpl;
import enlace_datos.consultas.nomina.SisNominaVwImpl;
import enlace_datos.consultas.nomina.SisPolizaDiarioVwImpl;
import enlace_datos.consultas.nomina.Sis_Banco_vwImpl;
import enlace_datos.consultas.nomina.Sis_tipo_nominaImpl;
import enlace_datos.consultas.nomina.sis_mod_nomina_vwImpl;
import enlace_datos.consultas.procesos.NominasXProcesoImpl;
import enlace_datos.consultas.procesos.SisAumentoSalDetVwImpl;
import enlace_datos.consultas.procesos.SisAumentoSalarialVwImpl;
import enlace_datos.consultas.procesos.SisCalendarioActividadVwImpl;
import enlace_datos.consultas.procesos.SisDepsLiquidacionVwImpl;
import enlace_datos.consultas.procesos.SisFolioEmisionAnuladoViewImpl;
import enlace_datos.consultas.procesos.SisFolioEmisionViewImpl;
import enlace_datos.consultas.procesos.SisFolioLiquidacionVwImpl;
import enlace_datos.consultas.procesos.SisNominasLiquidarVwImpl;
import enlace_datos.consultas.procesos.SisPeridoxTipoNomImpl;
import enlace_datos.consultas.procesos.SisProcesoConciliacionVwImpl;
import enlace_datos.consultas.procesos.SisProcesoPagoDetViewImpl;
import enlace_datos.consultas.procesos.Sis_conciliacion_bancaria_vwImpl;
import enlace_datos.consultas.procesos.Sis_unidades_liquidacion_vwImpl;
import enlace_datos.consultas.procesos.consul_aumentoSalarial_vwImpl;
import enlace_datos.consultas.procesos.detalle_asig_chequeImpl;
import enlace_datos.consultas.procesos.liquidacionImpl;
import enlace_datos.consultas.procesos.listado_procesos_mod_nominaImpl;
import enlace_datos.consultas.procesos.modificar_nominavoImpl;
import enlace_datos.consultas.procesos.nominas_a_liquidarImpl;
import enlace_datos.consultas.procesos.sis_sueldo_cuenta_vwImpl;
import enlace_datos.consultas.procesos.sis_tipoproceso_rol_vwImpl;
import enlace_datos.consultas.reintegros.consul_reintegros_vwImpl;
import enlace_datos.consultas.reportes.SisAnioNominaVwImpl;
import enlace_datos.consultas.reportes.SisDetProcesosImpl;
import enlace_datos.consultas.reportes.SisFormsis24_rev_vwImpl;
import enlace_datos.consultas.reportes.SisListSis_22VwImpl;
import enlace_datos.consultas.reportes.SisMovPlaza_AnexoImpl;
import enlace_datos.consultas.reportes.SisMovimientosPlazaVwImpl;
import enlace_datos.consultas.reportes.SisPagosProcesadosImpl;
import enlace_datos.consultas.reportes.SisProcesosNominaPorAnio2_VwImpl;
import enlace_datos.consultas.reportes.SisProcesosNominaPorAnioVwImpl;
import enlace_datos.consultas.reportes.SisProcesosNominaVwImpl;
import enlace_datos.consultas.reportes.SisProcesosRev_audiDep_vwImpl;
import enlace_datos.consultas.reportes.SisProcesosRev_audiImpl;
import enlace_datos.consultas.reportes.SisProyeccionISRImpl;
import enlace_datos.consultas.reportes.SisTipoProcesoTrab_vwImpl;
import enlace_datos.consultas.reportes.Sis_Procesos_revISR_vwImpl;
import enlace_datos.consultas.reportes.Sis_pagosAnuladosVwImpl;
import enlace_datos.consultas.reportes.rpt_control_plazaImpl;
import enlace_datos.consultas.reportes.rpt_liquidacionImpl;
import enlace_datos.consultas.reportes.rpt_liquidacion_auditorImpl;
import enlace_datos.consultas.reportes.rpt_reintegrosImpl;
import enlace_datos.consultas.util.BitacoraEventoUsuarioVwImpl;
import enlace_datos.consultas.util.SisAutorizacionDetVwImpl;
import enlace_datos.consultas.util.SisAutorizacion_estadosImpl;
import enlace_datos.consultas.util.SisAutorizacion_vwImpl;
import enlace_datos.consultas.util.Sis_documentos_adjuntos_vwImpl;
import enlace_datos.consultas.util.UsuarioVwImpl;
import enlace_datos.consultas.util.pregunta_seguridadImpl;
import enlace_datos.consultas.varios.Sis_historial_det1Impl;
import enlace_datos.consultas.varios.Sis_historial_salarialImpl;
import enlace_datos.consultas.varios.Sis_historial_salarial_IsrImpl;
import enlace_datos.consultas.varios.Sis_renglonImpl;
import enlace_datos.consultas.varios.consul_partidaSueldos_vwImpl;

import enlace_datos.util.resulOp;
import enlace_datos.util.utils;

import java.lang.reflect.Method;

import java.sql.CallableStatement;

import oracle.jbo.JboException;
import oracle.jbo.Session;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.ViewLinkImpl;
import oracle.jbo.server.ViewObjectImpl;

// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class QUERRYSImpl extends ApplicationModuleImpl implements QUERRYS {
   
   private Object pContextoExterno;
   private String [] vRolesUsuario;
   private String vIDBitacora="20";
  
           
    /*
     * Metodo para calcular la nomina de un empleado
     */
    public resulOp procesosISR(String pTipoProceso, oracle.jbo.domain.Number pPeriodo,oracle.jbo.domain.Number pAnio,oracle.jbo.domain.Number pDisponibilidad,String pUsuario){
        String str_proc;
        resulOp vResultado=new resulOp();
        CallableStatement cl_proc=null;
       // System.out.println("debug: " + pTipoProceso + " " + pPeriodo + " " + pIdContrato+ " "+ pUsuario);
        
        
        if (pTipoProceso.equals("RETENCION") ){
            
            if (pPeriodo==null){
                throw new  JboException("Por favor seleccione el mes");
            }
             
            if (pAnio==null){
                throw new  JboException("Por favor ingrese el año");
            }    
            
        }
        else if (pTipoProceso.equals("CONCILIACION") ){
        
            if (pAnio==null){
                throw new  JboException("Por favor ingrese el año");
            }    
        
        
        }else if (pTipoProceso.equals("DEVOLUCION") ){
        
        
            if (pPeriodo==null){
                throw new  JboException("Por ingrese el No. de pago.");
            }
            
        
            if (pDisponibilidad==null){
                throw new  JboException("Por favor ingrese la disponibilidad.");
            }    
            
            if (pAnio==null){
                throw new  JboException("Por favor ingrese el año.");
            }    
        
        }
                
        if (pAnio.compareTo(2009)<0 || pAnio.compareTo(2099)>0){            
            throw new  JboException("Por favor ingrese un año valido.");
        }
        
   
        try{
        
            if (pTipoProceso.equals("RETENCION") ){
                str_proc="call sis_pkg_calculos_isr.CALCULOS_RETEREP(?,?)";
                cl_proc=this.getDBTransaction().createCallableStatement(str_proc,0);   
                cl_proc.setInt(1,pPeriodo.intValue());
                cl_proc.setInt(2,pAnio.intValue());
                
            }else if (pTipoProceso.equals("CONCILIACION") ){
            
                str_proc="call sis_pkg_calculos_isr.CALCULOS_ISR_ANUAL2(?)";
                cl_proc=this.getDBTransaction().createCallableStatement(str_proc,0);   
                cl_proc.setInt(1,pAnio.intValue());
            
        
            }else if (pTipoProceso.equals("DEVOLUCION") ){
            
                str_proc="call sis_pkg_calculos_isr.DISTRIBUCION_DEVOLUCION(?,?,?,?)";
                cl_proc=this.getDBTransaction().createCallableStatement(str_proc,0);   
                cl_proc.setInt(1,pAnio.intValue());
                cl_proc.setInt(2,pPeriodo.intValue());
                cl_proc.setInt(3,pDisponibilidad.intValue());
                cl_proc.setString(4,pUsuario);
                
            }

                  
        
        cl_proc.execute();        
        this.getDBTransaction().commit();
        
        cl_proc.close();
        vResultado.setCodigoResultado(resulOp.OPE_OK);
        vResultado.setMensajeError("PROCESO EJECUTADO CORRECTAMENTE.");
        }catch(Exception exep){
            try{
            this.getDBTransaction().rollback();
            cl_proc.close(); 
            }catch(Exception exep2){
                
            }
            vResultado.setMensajeError(utils.getSQLMensaje(exep));
            vResultado.setCodigoResultado(resulOp.OPE_ERROR);
        }
    
      return vResultado;
    }


    
    /*
    *  Metodo para ejecutar la consulta para la pagina de los multiples reportes
    */
    public void EjecutarConsulGestiones(Date FechaI,Date FechaF,Number regEmpleado,Number Dependencia,String pConsulta,String pUsuario,String pEstados, String pCui){
        String vConsultas[];
        String vEstados[];
        String vConsulta;
        this.getsis_licencias_consul().clearCache();  
        this.getsis_suspenciones_igss_consul().clearCache();
        this.getsis_nombramientos_consul().clearCache();
        this.getsis_desc_judicial_consul().clearCache();
        this.getsis_retiro_obligatorio_consul1().clearCache();
        this.getsis_solBajaLaboralvw().clearCache();
        if (FechaI==null&&FechaF==null){
            throw new JboException("Favor ingrese al menos la fecha de inicio."); 
        } else if (FechaI==null && FechaF==null && regEmpleado==null){
            throw new JboException("Favor ingrese un rango de fechas o el registro de empleado."); 
        }
        if (FechaF==null){
            FechaF=utils.getFechaActual();
        }
        vEstados=pEstados.split("\\|");
        if (pConsulta!=null && !pConsulta.equals("")){ 
            vConsultas=pConsulta.split("\\|");
            for (int indice=0;indice<vConsultas.length;indice++){ 
                vConsulta=vConsultas[indice];
                if (vConsulta.equals("LICENCIAS")){
                    this.getsis_licencias_consul().BusquedaAvanzada(FechaI,FechaF,regEmpleado,Dependencia,pUsuario,getValorArray(vEstados,"L"), pCui);
                }else if (vConsulta.equals("SUSPIGSS")){
                    this.getsis_suspenciones_igss_consul().BusquedaAvanzada(FechaI,FechaF,regEmpleado,Dependencia,pUsuario,getValorArray(vEstados,"G"), pCui);
                }else if (vConsulta.equals("CONTRATOS")){
                    this.getsis_nombramientos_consul().consultaContrato=1;
                    this.getsis_nombramientos_consul().BusquedaAvanzada(FechaI,FechaF,regEmpleado,Dependencia,pUsuario,getValorArray(vEstados,"C"), pCui);
                }else if (vConsulta.equals("DESC_JUDICIAL")){
                    this.getsis_desc_judicial_consul().consultaFecha=1;
                    this.getsis_desc_judicial_consul().BusquedaAvanzada(FechaI,FechaF,regEmpleado,null,pUsuario,getValorArray(vEstados,"J"), pCui);
                }else if (vConsulta.equals("RENUNCIADESP")){
                    this.getsis_renuncias_desp().BusquedaAvanzada(FechaI,FechaF,regEmpleado,Dependencia,pUsuario,getValorArray(vEstados,"R"), pCui);
                }else if (vConsulta.equals("RENUNCIAPARCIAL")){
                    this.getsis_renuncia_parcial().BusquedaAvanzada(FechaI,FechaF,regEmpleado,Dependencia,pUsuario,getValorArray(vEstados,"R"), pCui);
                }else if (vConsulta.equals("HORA_EXTRA")){
                    this.getsis_tiempo_extra_consul().BusquedaAvanzada(FechaI,FechaF,regEmpleado,Dependencia,pUsuario,getValorArray(vEstados,"H"), pCui);
                }else if (vConsulta.equals("PROMRECLASIF")){
                    this.getsis_promo_reclaf_consul().BusquedaAvanzada(FechaI,FechaF,regEmpleado,Dependencia,pUsuario,pCui);  
                }else if (vConsulta.equals("RECLASIF")){
                    this.getsis_promo_reclaf_consul().setEjecutarConsulta(false);
                    this.getsis_promo_reclaf_consul().BusquedaAvanzada(FechaI,FechaF,regEmpleado,Dependencia,pUsuario,pCui);
                    this.getsis_promo_reclaf_consul().filtrarTipoProm("RECLAF");
                    this.getsis_promo_reclaf_consul().setEjecutarConsulta(true);
                }else if (vConsulta.equals("PROMDOC")){
                    this.getsis_promo_reclaf_consul().setEjecutarConsulta(false);
                    this.getsis_promo_reclaf_consul().BusquedaAvanzada(FechaI,FechaF,regEmpleado,Dependencia,pUsuario,pCui);
                    this.getsis_promo_reclaf_consul().filtrarTipoProm("PROMODOCENTE");
                    this.getsis_promo_reclaf_consul().setEjecutarConsulta(true);
                }else if (vConsulta.equals("FALLE")){
                    this.getsis_fallecimiento_consul_vw().BusquedaAvanzada(FechaI,FechaF,regEmpleado,Dependencia,pUsuario,getValorArray(vEstados,"F"), pCui);
                }else if (vConsulta.equals("RETIRO")){         
                    this.getsis_retiro_obligatorio_consul1().BusquedaAvanzada(FechaI,FechaF,regEmpleado,Dependencia,pUsuario,getValorArray(vEstados,"B"), pCui);
                }else if (vConsulta.equals("REINTEGROS")){
                    this.getsis_reintegros1().BusquedaAvanzada(FechaI,FechaF,regEmpleado,Dependencia,pUsuario,getValorArray(vEstados,"REI"),pCui);
                }else if (vConsulta.equals("BAJALABORAL")){
                    this.getsis_solBajaLaboralvw().consultaFecha = 2;
                    this.getsis_solBajaLaboralvw().BusquedaAvanzada(FechaI,FechaF,regEmpleado,Dependencia,pUsuario,getValorArray(vEstados,"BL"), pCui);
                }
                
            } //fin del for
        }
    }


public String getValorArray(String [] valores,String pLlave){
  int vTamanio=0;
  String vResultado=null;
  
  if (valores!=null)
  {
  
    vTamanio=valores.length;
  
  for(int i=0;i<=vTamanio;i++)
  {
     if (valores[i].equals(pLlave)){
         
        vResultado=valores[i+1]; 
        break;
     }
      
  }
  
  }
    
return vResultado;    
}

    
    /*
     * Metodo para calcular la nomina de un empleado
     */
    public resulOp Calcular_nomina_empleado(oracle.jbo.domain.Number pTipoProceso, oracle.jbo.domain.Number pPeriodo,oracle.jbo.domain.Number pIdContrato,String pUsuario){
        String str_proc;
        resulOp vResultado=new resulOp();
       // System.out.println("debug: " + pTipoProceso + " " + pPeriodo + " " + pIdContrato+ " "+ pUsuario);
        
        if (pTipoProceso==null){
            throw new  JboException("Por favor seleccione la nomina");
        }
        
        if (pPeriodo==null){
            throw new  JboException("Por favor seleccione el periodo");
        }
        if (pIdContrato==null){
            throw new  JboException("Por favor seleccione un contrato");
        }
        
        str_proc="call sis_pkg_calculos.calcular_proceso_empleado(null,?,?,?,to_char(sysdate,'yyyy'),null)";
        CallableStatement cl_proc;
        try{
        cl_proc=this.getDBTransaction().createCallableStatement(str_proc,0);
        cl_proc.setLong(1,pIdContrato.longValue());
        cl_proc.setInt(2,pTipoProceso.intValue());
        cl_proc.setInt(3,pPeriodo.intValue());
        cl_proc.execute();
        cl_proc.close();
        vResultado.setCodigoResultado(resulOp.OPE_OK);
        vResultado.setMensajeError("PROCESO EJECUTADO CORRECTAMENTE.");
        }catch(Exception exep){
            vResultado.setMensajeError(utils.getSQLMensaje(exep));
            vResultado.setCodigoResultado(resulOp.OPE_ERROR);
        }
    
      return vResultado;
    }


    /*
     * Metodo para calcular la nomina de un empleado
     */
    public resulOp Calcular_nuevas_Escalas(oracle.jbo.domain.Number pIdAumento){
        String str_proc;
        resulOp vResultado=new resulOp();
       // System.out.println("debug: " + pTipoProceso + " " + pPeriodo + " " + pIdContrato+ " "+ pUsuario);
        
        if (pIdAumento==null){
            throw new  JboException("Por favor seleccione el proceso de aumento");
        }
        
        
        str_proc="call sis_pkg_aumento_salarial.Calcular_nuevas_escalas(?)";
        CallableStatement cl_proc;
        try{
        cl_proc=this.getDBTransaction().createCallableStatement(str_proc,0);
        cl_proc.setLong(1,pIdAumento.longValue());
        cl_proc.execute();
        cl_proc.getConnection().commit();
        cl_proc.close();
        
        vResultado.setCodigoResultado(resulOp.OPE_OK);
        vResultado.setMensajeError("PROCESO EJECUTADO CORRECTAMENTE.");
        }catch(Exception exep){
            vResultado.setMensajeError(utils.getSQLMensaje(exep));
            vResultado.setCodigoResultado(resulOp.OPE_ERROR);
        }
    
      return vResultado;
    }



    /*
     * Metodo para realizar el aumento salarial
     */
    public resulOp RealizarAumentoSalarial(oracle.jbo.domain.Number pIdAumento){
        String str_proc;
        resulOp vResultado=new resulOp();
       // System.out.println("debug: " );
        
        if (pIdAumento==null){
            throw new  JboException("Por favor seleccione el Id del aumento salarial");
        }
        
        
        str_proc="call sis_pkg_aumento_salarial.procesar_aumento_salarial2(?)";
        CallableStatement cl_proc;
        try{
        cl_proc=this.getDBTransaction().createCallableStatement(str_proc,0);
        cl_proc.setLong(1,pIdAumento.longValue());
        cl_proc.execute();
        cl_proc.getConnection().commit();
        cl_proc.close();
        
        vResultado.setCodigoResultado(resulOp.OPE_OK);
        vResultado.setMensajeError("PROCESO EJECUTADO CORRECTAMENTE.");
        }catch(Exception exep){
            vResultado.setMensajeError(utils.getSQLMensaje(exep));
            vResultado.setCodigoResultado(resulOp.OPE_ERROR);
        }
    
      return vResultado;
    }


    public void tempo_aumento_saldo_partida(oracle.jbo.domain.Number pIdAumento){
        String str_proc;
        str_proc="call sis_pkg_aumento_salarial.app_porcentaje(?)";
        CallableStatement cl_proc;
        try{
        cl_proc=this.getDBTransaction().createCallableStatement(str_proc,0);
        cl_proc.setLong(1,pIdAumento.longValue());
        cl_proc.execute();
        cl_proc.getConnection().commit();
        cl_proc.close();
        
        }catch(Exception exep){
         exep.printStackTrace();
       
        }
    }

  
  public void setRolesUsuario(String [] pRoles){
  vRolesUsuario=pRoles;
  }
  
   public void setContextoExterno(Object pContexto){
       pContextoExterno=pContexto;
       
   }
   
   public boolean isUsuarioEnRol2(String pRol){

       boolean vResultado=false;
       int vRoles,i=0;
       
       //System.out.println("buscar***** "+pRol);
       
       if (this.vRolesUsuario!=null){
        vRoles=this.vRolesUsuario.length;
          // System.out.println("buscar2***** "+vRoles);
         //Verificando si algun el usuario pertenece a algun rol
         if (vRoles>0){
             while (i<vRoles){
                 //System.out.println(this.vRolesUsuario[i].toString()+" entreee111**** "+vResultado );
                   if (vRolesUsuario[i].equals(pRol)){                   
                       vResultado=true;
                       //System.out.println(this.vRolesUsuario[i].toString()+" entreee "+vResultado );
                       break;
                   }
               i++;    
             }
         }   
       }
        return vResultado; 
   }
   
    public boolean isUsuarioEnRol(String pRol){
      Method vmetodo;
      Object [] vparametros=new Object[1];
      boolean vresultado=false;
      
      try{
         vmetodo=this.pContextoExterno.getClass().getMethod("isUserInRole",new Class[]{String.class});
         vparametros[0]=pRol;
         vresultado=(Boolean)vmetodo.invoke(pContextoExterno,vparametros);
    
      }catch(Exception eas){
          eas.printStackTrace();
      }
       
     return vresultado; 
    }
   
 
   
    protected void prepareSession(Session session) {
      super.prepareSession(session);
    //  System.out.println("preparar sesion " + this.getSession());
    
    }

    /**This is the default constructor (do not remove)
     */
    public QUERRYSImpl() {
    }

    /**Container's getter for lista_empleados
     */
    public lista_empleadosImpl getlista_empleados() {
        return (lista_empleadosImpl)findViewObject("lista_empleados");
    }

    /**Sample main for debugging Business Components code using the tester.
     */
    public static void main(String[] args) {
        launchTester("enlace_datos.consultas", /* package name */
      "QUERRYSLocal" /* Configuration Name */);
    }

    /**Container's getter for valores_estadoCivil
     */
    public valores_estadoCivilImpl getvalores_estadoCivil() {
        return (valores_estadoCivilImpl)findViewObject("valores_estadoCivil");
    }

    /**Container's getter for valores_genero
     */
    public valores_generoImpl getvalores_genero() {
        return (valores_generoImpl)findViewObject("valores_genero");
    }

    /**Container's getter for todos_los_Departamentos
     */
    public ViewObjectImpl gettodos_los_Departamentos() {
        return (ViewObjectImpl)findViewObject("todos_los_Departamentos");
    }

    /**Container's getter for municipios_by_dep
     */
    public ViewObjectImpl getmunicipios_by_dep() {
        return (ViewObjectImpl)findViewObject("municipios_by_dep");
    }

    /**Container's getter for municipios_dep_by_mun
     */
    public ViewObjectImpl getmunicipios_dep_by_mun() {
        return (ViewObjectImpl)findViewObject("municipios_dep_by_mun");
    }

    /**Container's getter for municipio_by_ordced
     */
    public ViewObjectImpl getmunicipio_by_ordced() {
        return (ViewObjectImpl)findViewObject("municipio_by_ordced");
    }

    /**Container's getter for nacionalidad
     */
    public ViewObjectImpl getnacionalidad() {
        return (ViewObjectImpl)findViewObject("nacionalidad");
    }

    /**Container's getter for empleado_cont_by_reg
     */
    public ViewObjectImpl getempleado_cont_by_reg() {
        return (ViewObjectImpl)findViewObject("empleado_cont_by_reg");
    }

    /**Container's getter for unidades_ejec
     */
    public ViewObjectImpl getunidades_ejec() {
       System.out.println("Unidades");
        return (ViewObjectImpl)findViewObject("unidades_ejec");
    }

    /**Container's getter for dependencias
     */
    public ViewObjectImpl getdependencias() {
        return (ViewObjectImpl)findViewObject("dependencias");
    }

    /**Container's getter for plazas
     */
    public ViewObjectImpl getplazas() {
        return (ViewObjectImpl)findViewObject("plazas");
    }


    /**Container's getter for tipo_contrato
     */
    public ViewObjectImpl gettipo_contrato() {
        return (ViewObjectImpl)findViewObject("tipo_contrato");
    }

    /**Container's getter for contrato_busqueda
     */
    public ViewObjectImpl getcontrato_busqueda() {
        return (ViewObjectImpl)findViewObject("contrato_busqueda");
    }

    /**Container's getter for contrato_det_puesto
     */
    public ViewObjectImpl getcontrato_det_puesto() {
        return (ViewObjectImpl)findViewObject("contrato_det_puesto");
    }

    /**Container's getter for contrato_desc_y_bonos
     */
    public ViewObjectImpl getcontrato_desc_y_bonos() {
        return (ViewObjectImpl)findViewObject("contrato_desc_y_bonos");
    }

    /**Container's getter for formas_obt_puesto
     */
    public ViewObjectImpl getformas_obt_puesto() {
        return (ViewObjectImpl)findViewObject("formas_obt_puesto");
    }

    /**Container's getter for SisAjuste
     */
    public SisAjusteImpl getSisAjuste() {
        return (SisAjusteImpl)findViewObject("SisAjuste");
    }

    /**Container's getter for SisRegla
     */
    public SisReglaImpl getSisRegla() {
        return (SisReglaImpl)findViewObject("SisRegla");
    }

    /**Container's getter for SisTipoAjuste
     */
    public SisTipoAjusteImpl getSisTipoAjuste() {
        return (SisTipoAjusteImpl)findViewObject("SisTipoAjuste");
    }

    /**Container's getter for ajuste_nivel
     */
    public ajuste_nivelImpl getajuste_nivel() {
        return (ajuste_nivelImpl)findViewObject("ajuste_nivel");
    }

    /**Container's getter for tipoajuste_operacion
     */
    public tipoajuste_operacionImpl gettipoajuste_operacion() {
        return (tipoajuste_operacionImpl)findViewObject("tipoajuste_operacion");
    }

    /**Container's getter for SisRegla1
     */
    public SisReglaImpl getSisRegla1() {
        return (SisReglaImpl)findViewObject("SisRegla1");
    }

    /**Container's getter for SisReglaSisAjusteFkLink1
     */
    public ViewLinkImpl getSisReglaSisAjusteFkLink1() {
        return (ViewLinkImpl)findViewLink("SisReglaSisAjusteFkLink1");
    }


    /**Container's getter for nivel1
     */
    public nivelImpl getnivel1() {
        return (nivelImpl)findViewObject("nivel1");
    }

    /**Container's getter for puesto1
     */
    public puestoImpl getpuesto1() {
        return (puestoImpl)findViewObject("puesto1");
    }


    /**Container's getter for Link_cat_nivel1
     */
    public ViewLinkImpl getLink_cat_nivel1() {
        return (ViewLinkImpl)findViewLink("Link_cat_nivel1");
    }

    /**Container's getter for categoria1
     */
    public categoriaImpl getcategoria1() {
        return (categoriaImpl)findViewObject("categoria1");
    }


    /**Container's getter for tipo_proceso_vw
     */
    public ViewObjectImpl gettipo_proceso_vw() {
        return (ViewObjectImpl)findViewObject("tipo_proceso_vw");
    }

    /**Container's getter for periodos_proc_vw
     */
    public ViewObjectImpl getperiodos_proc_vw() {
        return (ViewObjectImpl)findViewObject("periodos_proc_vw");
    }

    /**Container's getter for tipo_proceso_periodo1
     */
    public ViewLinkImpl gettipo_proceso_periodo1() {
        return (ViewLinkImpl)findViewLink("tipo_proceso_periodo1");
    }


    /**Container's getter for consulta_puesto1
     */
    public consulta_puestoImpl getconsulta_puesto1() {
        return (consulta_puestoImpl)findViewObject("consulta_puesto1");
    }

    /**Container's getter for historico_puesto1
     */
    public historico_puestoImpl gethistorico_puesto1() {
        return (historico_puestoImpl)findViewObject("historico_puesto1");
    }

    /**Container's getter for Link_historico_puesto1
     */
    public ViewLinkImpl getLink_historico_puesto1() {
        return (ViewLinkImpl)findViewLink("Link_historico_puesto1");
    }

    /**Container's getter for dias_Semana_vw
     */
    public ViewObjectImpl getdias_Semana_vw() {
        return (ViewObjectImpl)findViewObject("dias_Semana_vw");
    }

    /**Container's getter for ProcesoVw
     */
    public ProcesoVwImpl getProcesoVw() {
        return (ProcesoVwImpl)findViewObject("ProcesoVw");
    }

    /**Container's getter for SisProcesoPagoDetVw
     */
    public SisProcesoPagoDetViewImpl getSisProcesoPagoDetVw() {
        return (SisProcesoPagoDetViewImpl)findViewObject("SisProcesoPagoDetVw");
    }

    /**Container's getter for Proceso_proceso_pago_lnk1
     */
    public ViewLinkImpl getProceso_proceso_pago_lnk1() {
        return (ViewLinkImpl)findViewLink("Proceso_proceso_pago_lnk1");
    }


    /**Container's getter for consul_asignacion_ajuste2
     */
    public consul_asignacion_ajusteImpl getconsul_asignacion_ajuste2() {
        return (consul_asignacion_ajusteImpl)findViewObject("consul_asignacion_ajuste2");
    }

    /**Container's getter for variacion_nomina2
     */
    public variacion_nominaImpl getvariacion_nomina2() {
        return (variacion_nominaImpl)findViewObject("variacion_nomina2");
    }

    /**Container's getter for variacionDetAjuste2
     */
    public variacionDetAjusteImpl getvariacionDetAjuste2() {
        return (variacionDetAjusteImpl)findViewObject("variacionDetAjuste2");
    }

    /**Container's getter for consulVarNomina_VarNomina1
     */
    public ViewLinkImpl getconsulVarNomina_VarNomina1() {
        return (ViewLinkImpl)findViewLink("consulVarNomina_VarNomina1");
    }

    /**Container's getter for link_VarNomina_VarDetAjuste1
     */
    public ViewLinkImpl getlink_VarNomina_VarDetAjuste1() {
        return (ViewLinkImpl)findViewLink("link_VarNomina_VarDetAjuste1");
    }

    /**Container's getter for variacionDetAjuste1
     */
    public variacionDetAjusteImpl getvariacionDetAjuste1() {
        return (variacionDetAjusteImpl)findViewObject("variacionDetAjuste1");
    }

    /**Container's getter for rpt_reporte_texto
     */
    public ViewObjectImpl getrpt_reporte_texto() {
        return (ViewObjectImpl)findViewObject("rpt_reporte_texto");
    }

    /**Container's getter for sis_tipo_reporte
     */
    public ViewObjectImpl getsis_tipo_reporte() {
        return (ViewObjectImpl)findViewObject("sis_tipo_reporte");
    }

    /**Container's getter for SisContrato_vw
     */
    public SisContrato_vwImpl getSisContrato_vw() {
        return (SisContrato_vwImpl)findViewObject("SisContrato_vw");
    }

    /**Container's getter for todos_municipios
     */
    public todos_municipiosImpl gettodos_municipios() {
        return (todos_municipiosImpl)findViewObject("todos_municipios");
    }

    /**Container's getter for dep_mun_lnk1
     */
    public ViewLinkImpl getdep_mun_lnk1() {
        return (ViewLinkImpl)findViewLink("dep_mun_lnk1");
    }

    /**Container's getter for SisHorarioContrato
     */
    public SisHorarioContratoImpl getSisHorarioContrato() {
        return (SisHorarioContratoImpl)findViewObject("SisHorarioContrato");
    }

    /**Container's getter for SisContratoHorario_lnk1
     */
    public ViewLinkImpl getSisContratoHorario_lnk1() {
        return (ViewLinkImpl)findViewLink("SisContratoHorario_lnk1");
    }
    /**Container's getter for consul_buscheque_anular1
     */
    public consul_buscheque_anularImpl getconsul_buscheque_anular1() {
        return (consul_buscheque_anularImpl)findViewObject("consul_buscheque_anular1");
    }

    /**Container's getter for sis_tipo_deduccion_isr
     */
    public sis_tipo_deduccion_isrImpl getsis_tipo_deduccion_isr() {
        return (sis_tipo_deduccion_isrImpl)findViewObject("sis_tipo_deduccion_isr");
    }

    /**Container's getter for sis_deduccion_isr
     */
    public sis_deduccion_isrImpl getsis_deduccion_isr() {
        return (sis_deduccion_isrImpl)findViewObject("sis_deduccion_isr");
    }


    /**Container's getter for sis_resumen_deduccion_isr
     */
    public sis_resumen_deduccion_isrImpl getsis_resumen_deduccion_isr() {
        return (sis_resumen_deduccion_isrImpl)findViewObject("sis_resumen_deduccion_isr");
    }

    /**Container's getter for arch_adjunto_contrato_vw
     */
    public arch_adjunto_contratoImpl getarch_adjunto_contrato_vw() {
        return (arch_adjunto_contratoImpl)findViewObject("arch_adjunto_contrato_vw");
    }

    /**Container's getter for contrato_archivo_adjunto_lnk1
     */
    public ViewLinkImpl getcontrato_archivo_adjunto_lnk1() {
        return (ViewLinkImpl)findViewLink("contrato_archivo_adjunto_lnk1");
    }

    /**Container's getter for SisIntervaloIsrVw
     */
    public SisIntervaloIsrViewImpl getSisIntervaloIsrVw() {
        return (SisIntervaloIsrViewImpl)findViewObject("SisIntervaloIsrVw");
    }


    /**Container's getter for SisMotivoDetLicenciaVw
     */
    public SisMotivoDetLicenciaVwImpl getSisMotivoDetLicenciaVw() {
        return (SisMotivoDetLicenciaVwImpl)findViewObject("SisMotivoDetLicenciaVw");
    }

    /**Container's getter for SisSolicitudVw
     */
    public SisSolicitudVwImpl getSisSolicitudVw() {
        return (SisSolicitudVwImpl)findViewObject("SisSolicitudVw");
    }

    /**Container's getter for SisTipoSolicitud
     */
    public SisTipoSolicitudImpl getSisTipoSolicitud() {
        return (SisTipoSolicitudImpl)findViewObject("SisTipoSolicitud");
    }

    /**Container's getter for SisEmpleadoVw
     */
    public SisEmpleadoVwImpl getSisEmpleadoVw() {
        return (SisEmpleadoVwImpl)findViewObject("SisEmpleadoVw");
    }

    /**Container's getter for SisContratosActivos_by_reg
     */
    public SisContratosActivos_by_regImpl getSisContratosActivos_by_reg() {
        return (SisContratosActivos_by_regImpl)findViewObject("SisContratosActivos_by_reg");
    }

    /**Container's getter for SisEmpl_contrato_act1
     */
    public ViewLinkImpl getSisEmpl_contrato_act1() {
        return (ViewLinkImpl)findViewLink("SisEmpl_contrato_act1");
    }

    /**Container's getter for SisDetLicenciaVw
     */
    public SisDetLicenciaVwImpl getSisDetLicenciaVw() {
        return (SisDetLicenciaVwImpl)findViewObject("SisDetLicenciaVw");
    }

    /**Container's getter for SisSolicitud_licencia_lnk1
     */
    public ViewLinkImpl getSisSolicitud_licencia_lnk1() {
        return (ViewLinkImpl)findViewLink("SisSolicitud_licencia_lnk1");
    }

    /**Container's getter for SisArchivoAdjuntoSol
     */
    public SisArchivoAdjuntoSolImpl getSisArchivoAdjuntoSol() {
        return (SisArchivoAdjuntoSolImpl)findViewObject("SisArchivoAdjuntoSol");
    }

    /**Container's getter for SisSolicitudArchAdjunto_lnk1
     */
    public ViewLinkImpl getSisSolicitudArchAdjunto_lnk1() {
        return (ViewLinkImpl)findViewLink("SisSolicitudArchAdjunto_lnk1");
    }

    /**Container's getter for SisNivelAcad
     */
    public SisNivelAcadImpl getSisNivelAcad() {
        return (SisNivelAcadImpl)findViewObject("SisNivelAcad");
    }


    /**Container's getter for SisEmplDireccion_lnk1
     */
    public ViewLinkImpl getSisEmplDireccion_lnk1() {
        return (ViewLinkImpl)findViewLink("SisEmplDireccion_lnk1");
    }

    /**Container's getter for SisDireccion_vw
     */
    public ViewObjectImpl getSisDireccion_vw() {
        return (ViewObjectImpl)findViewObject("SisDireccion_vw");
    }

    /**Container's getter for SisPagosProcesados_vw
     */
    public SisPagosProcesadosImpl getSisPagosProcesados_vw() {
        return (SisPagosProcesadosImpl)findViewObject("SisPagosProcesados_vw");
    }

    /**Container's getter for SisProcesoPagoDetView
     */
    public SisProcesoPagoDetViewImpl getSisProcesoPagoDetView() {
        return (SisProcesoPagoDetViewImpl)findViewObject("SisProcesoPagoDetView");
    }

    /**Container's getter for SisPagosProce_detpago_lnk1
     */
    public ViewLinkImpl getSisPagosProce_detpago_lnk1() {
        return (ViewLinkImpl)findViewLink("SisPagosProce_detpago_lnk1");
    }


    /**Container's getter for consul_det_cheque_anular2
     */
    public consul_det_cheque_anularImpl getconsul_det_cheque_anular2() {
        return (consul_det_cheque_anularImpl)findViewObject("consul_det_cheque_anular2");
    }


    /**Container's getter for consul_MotivoAnulacion1
     */
    public consul_MotivoAnulacionImpl getconsul_MotivoAnulacion1() {
        return (consul_MotivoAnulacionImpl)findViewObject("consul_MotivoAnulacion1");
    }


    /**Container's getter for link_BusCheqAnular_SisDocPagoAnulado1
     */
    public ViewLinkImpl getlink_BusCheqAnular_SisDocPagoAnulado1() {
        return (ViewLinkImpl)findViewLink("link_BusCheqAnular_SisDocPagoAnulado1");
    }

    /**Container's getter for consul_tipo_judicial1
     */
    public consul_tipo_judicialImpl getconsul_tipo_judicial1() {
        return (consul_tipo_judicialImpl)findViewObject("consul_tipo_judicial1");
    }

    /**Container's getter for view_orden_judicial1
     */
    public view_orden_judicialImpl getview_orden_judicial1() {
        return (view_orden_judicialImpl)findViewObject("view_orden_judicial1");
    }

    /**Container's getter for link_solicitud_ordenJudicial1
     */
    public ViewLinkImpl getlink_solicitud_ordenJudicial1() {
        return (ViewLinkImpl)findViewLink("link_solicitud_ordenJudicial1");
    }

    /**Container's getter for sis_condicion_ordenJudicial_vw1
     */
    public sis_condicion_ordenJudicial_vwImpl getsis_condicion_ordenJudicial_vw1() {
        return (sis_condicion_ordenJudicial_vwImpl)findViewObject("sis_condicion_ordenJudicial_vw1");
    }

    /**Container's getter for link_condicion_ordenJudicial1
     */
    public ViewLinkImpl getlink_condicion_ordenJudicial1() {
        return (ViewLinkImpl)findViewLink("link_condicion_ordenJudicial1");
    }

    /**Container's getter for consul_tipCondicion_ordenJudi1
     */
    public consul_tipCondicion_ordenJudiImpl getconsul_tipCondicion_ordenJudi1() {
        return (consul_tipCondicion_ordenJudiImpl)findViewObject("consul_tipCondicion_ordenJudi1");
    }

    /**Container's getter for view_SisDocPagoAnulado1
     */
    public view_SisDocPagoAnuladoImpl getview_SisDocPagoAnulado1() {
        return (view_SisDocPagoAnuladoImpl)findViewObject("view_SisDocPagoAnulado1");
    }
  /**Container's getter for sis_poliza_vw
     */
    public ViewObjectImpl getsis_poliza_vw() {
        return (ViewObjectImpl)findViewObject("sis_poliza_vw");
    }

    /**Container's getter for consul_depto_porel_municipio1
     */
    public consul_depto_porel_municipioImpl getconsul_depto_porel_municipio1() {
        return (consul_depto_porel_municipioImpl)findViewObject("consul_depto_porel_municipio1");
    }

    /**Container's getter for SisCuentaVw
     */
    public SisCuentaVwImpl getSisCuentaVw() {
        return (SisCuentaVwImpl)findViewObject("SisCuentaVw");
    }

    /**Container's getter for SisEmpleado_cuenta_lnk1
     */
    public ViewLinkImpl getSisEmpleado_cuenta_lnk1() {
        return (ViewLinkImpl)findViewLink("SisEmpleado_cuenta_lnk1");
    }

    /**Container's getter for SisTipoDocBanco_vw
     */
    public ViewObjectImpl getSisTipoDocBanco_vw() {
        return (ViewObjectImpl)findViewObject("SisTipoDocBanco_vw");
    }

    /**Container's getter for SisFormaPagoVw
     */
    public SisFormaPagoVwImpl getSisFormaPagoVw() {
        return (SisFormaPagoVwImpl)findViewObject("SisFormaPagoVw");
    }

    /**Container's getter for SisEmpleadoFormaPago_lnk1
     */
    public ViewLinkImpl getSisEmpleadoFormaPago_lnk1() {
        return (ViewLinkImpl)findViewLink("SisEmpleadoFormaPago_lnk1");
    }

    /**Container's getter for SisMoneda_vw
     */
    public SisMonedaImpl getSisMoneda_vw() {
        return (SisMonedaImpl)findViewObject("SisMoneda_vw");
    }

    /**Container's getter for SisCuentaActivas_Vw
     */
    public SisCuentaVwImpl getSisCuentaActivas_Vw() {
        return (SisCuentaVwImpl)findViewObject("SisCuentaActivas_Vw");
    }

    /**Container's getter for SisEmplCuentaActivas_lnk1
     */
    public ViewLinkImpl getSisEmplCuentaActivas_lnk1() {
        return (ViewLinkImpl)findViewLink("SisEmplCuentaActivas_lnk1");
    }

    /**Container's getter for SisAjusteActivos_vw
     */
    public ViewObjectImpl getSisAjusteActivos_vw() {
        return (ViewObjectImpl)findViewObject("SisAjusteActivos_vw");
    }

    /**Container's getter for Sis_Arch_adjunto_vw
     */
    public Sis_Arch_adjuntoImpl getSis_Arch_adjunto_vw() {
        return (Sis_Arch_adjuntoImpl)findViewObject("Sis_Arch_adjunto_vw");
    }

    /**Container's getter for SisEmplArchadjunto_lnk1
     */
    public ViewLinkImpl getSisEmplArchadjunto_lnk1() {
        return (ViewLinkImpl)findViewLink("SisEmplArchadjunto_lnk1");
    }

    /**Container's getter for SisDetProcesos_vw
     */
    public ViewObjectImpl getSisDetProcesos_vw() {
        return (ViewObjectImpl)findViewObject("SisDetProcesos_vw");
    }

    /**Container's getter for Sis_ajustes_mod_simple_vw
     */
    public ViewObjectImpl getSis_ajustes_mod_simple_vw() {
        return (ViewObjectImpl)findViewObject("Sis_ajustes_mod_simple_vw");
    }

    /**Container's getter for SisAutorizacion_vw
     */
    public ViewObjectImpl getSisAutorizacion_vw() {
        return (ViewObjectImpl)findViewObject("SisAutorizacion_vw");
    }

    /**Container's getter for SisAutorizacionDetVw
     */
    public SisAutorizacionDetVwImpl getSisAutorizacionDetVw() {
        return (SisAutorizacionDetVwImpl)findViewObject("SisAutorizacionDetVw");
    }

    /**Container's getter for SisAut_autDet_lnk1
     */
    public ViewLinkImpl getSisAut_autDet_lnk1() {
        return (ViewLinkImpl)findViewLink("SisAut_autDet_lnk1");
    }

    /**Container's getter for SisAutorizacion_estadosVw
     */
    public ViewObjectImpl getSisAutorizacion_estadosVw() {
        return (ViewObjectImpl)findViewObject("SisAutorizacion_estadosVw");
    }

    /**Container's getter for SisMensajesEntrantesVw
     */
    public ViewObjectImpl getSisMensajesEntrantesVw() {
        return (ViewObjectImpl)findViewObject("SisMensajesEntrantesVw");
    }

    /**Container's getter for SisMensajeSalienteVw
     */
    public SisMensajeSalienteVwImpl getSisMensajeSalienteVw() {
        return (SisMensajeSalienteVwImpl)findViewObject("SisMensajeSalienteVw");
    }

    /**Container's getter for SisSuspencionIgss
     */
    public ViewObjectImpl getSisSuspencionIgss() {
        return (ViewObjectImpl)findViewObject("SisSuspencionIgss");
    }

    /**Container's getter for SisSol_SuspIgss1
     */
    public ViewLinkImpl getSisSol_SuspIgss1() {
        return (ViewLinkImpl)findViewLink("SisSol_SuspIgss1");
    }

    /**Container's getter for SisTipoSuspIgss
     */
    public ViewObjectImpl getSisTipoSuspIgss() {
        return (ViewObjectImpl)findViewObject("SisTipoSuspIgss");
    }

    /**Container's getter for SisContratosPendientesRev_vw
     */
    public ViewObjectImpl getSisContratosPendientesRev_vw() {
        return (ViewObjectImpl)findViewObject("SisContratosPendientesRev_vw");
    }

    /**Container's getter for SisContratosRevisados_vw
     */
    public ViewObjectImpl getSisContratosRevisados_vw() {
        return (ViewObjectImpl)findViewObject("SisContratosRevisados_vw");
    }

    /**Container's getter for liquidacion
     */
    public liquidacionImpl getliquidacion() {
        return (liquidacionImpl)findViewObject("liquidacion");
    }

    /**Container's getter for nominas_a_liquidar
     */
    public nominas_a_liquidarImpl getnominas_a_liquidar() {
        return (nominas_a_liquidarImpl)findViewObject("nominas_a_liquidar");
    }

    /**Container's getter for rpt_liquidacion
     */
    public rpt_liquidacionImpl getrpt_liquidacion() {
        return (rpt_liquidacionImpl)findViewObject("rpt_liquidacion");
    }


    /**Container's getter for detalle_desc_Vw
     */
    public detalle_desImpl getdetalle_desc_Vw() {
        return (detalle_desImpl)findViewObject("detalle_desc_Vw");
    }

    /**Container's getter for plazaempleadoVw1
     */
    public plazaempleadoVwImpl getplazaempleadoVw1() {
        return (plazaempleadoVwImpl)findViewObject("plazaempleadoVw1");
    }

    /**Container's getter for link_contratoPenRev_PlazaEmpleadoVw1
     */
    public ViewLinkImpl getlink_contratoPenRev_PlazaEmpleadoVw1() {
        return (ViewLinkImpl)findViewLink("link_contratoPenRev_PlazaEmpleadoVw1");
    }

    /**Container's getter for plazaregistro1
     */
    public plazaregistroImpl getplazaregistro1() {
        return (plazaregistroImpl)findViewObject("plazaregistro1");
    }

    /**Container's getter for PlazaREgistro_ContratoPendREv_lnk1
     */
    public ViewLinkImpl getPlazaREgistro_ContratoPendREv_lnk1() {
        return (ViewLinkImpl)findViewLink("PlazaREgistro_ContratoPendREv_lnk1");
    }

    /**Container's getter for consul_sisTipoMovPlaza1
     */
    public consul_sisTipoMovPlazaImpl getconsul_sisTipoMovPlaza1() {
        return (consul_sisTipoMovPlazaImpl)findViewObject("consul_sisTipoMovPlaza1");
    }

    /**Container's getter for sis_anexo1
     */
    public sis_anexoImpl getsis_anexo1() {
        return (sis_anexoImpl)findViewObject("sis_anexo1");
    }


    /**Container's getter for consul_sisPartida_vw1
     */
    public consul_sisPartida_vwImpl getconsul_sisPartida_vw1() {
        return (consul_sisPartida_vwImpl)findViewObject("consul_sisPartida_vw1");
    }

    /**Container's getter for sis_movimiento_plaza1
     */
    public sis_movimiento_plazaImpl getsis_movimiento_plaza1() {
        return (sis_movimiento_plazaImpl)findViewObject("sis_movimiento_plaza1");
    }

    /**Container's getter for sisAnexo_sisMovPlaza_lk1
     */
    public ViewLinkImpl getsisAnexo_sisMovPlaza_lk1() {
        return (ViewLinkImpl)findViewLink("sisAnexo_sisMovPlaza_lk1");
    }

    /**Container's getter for consul_sisPlaza_vw1
     */
    public consul_sisPlaza_vwImpl getconsul_sisPlaza_vw1() {
        return (consul_sisPlaza_vwImpl)findViewObject("consul_sisPlaza_vw1");
    }
    /**Container's getter for Sis_det_plaza_contrato1
     */
    public ViewObjectImpl getSis_det_plaza_contrato1() {
        return (ViewObjectImpl)findViewObject("Sis_det_plaza_contrato1");
    }

    /**Container's getter for sis_contrato_det_plaza1
     */
    public ViewLinkImpl getsis_contrato_det_plaza1() {
        return (ViewLinkImpl)findViewLink("sis_contrato_det_plaza1");
    }

    /**Container's getter for encabezado_anexo_vw1
     */
    public encabezado_anexo_vwImpl getencabezado_anexo_vw1() {
        return (encabezado_anexo_vwImpl)findViewObject("encabezado_anexo_vw1");
    }

    /**Container's getter for consul_anexo_vw1
     */
    public consul_anexo_vwImpl getconsul_anexo_vw1() {
        return (consul_anexo_vwImpl)findViewObject("consul_anexo_vw1");
    }

    /**Container's getter for encab_Anexo_Consul_anexo_lk1
     */
    public ViewLinkImpl getencab_Anexo_Consul_anexo_lk1() {
        return (ViewLinkImpl)findViewLink("encab_Anexo_Consul_anexo_lk1");
    }

    /**Container's getter for sis_licencias_consul
     */
    public sis_licencias_consulImpl getsis_licencias_consul() {
     //  System.out.println("Consulta licencia");
        return (sis_licencias_consulImpl)findViewObject("sis_licencias_consul");
    }
    
    
   
    /**Container's getter for sis_suspenciones_igss_consul
     */
    public sis_suspenciones_igss_consulImpl getsis_suspenciones_igss_consul() {
        return (sis_suspenciones_igss_consulImpl)findViewObject("sis_suspenciones_igss_consul");
    }

    /**Container's getter for sis_nombramiento_consul
     */
    public sis_nombramientos_consulImpl getsis_nombramientos_consul() {
        return (sis_nombramientos_consulImpl)findViewObject("sis_nombramientos_consul");
    }

    /**Container's getter for sis_desc_judicial_consul
     */
    public sis_desc_judicial_consulImpl getsis_desc_judicial_consul() {
        return (sis_desc_judicial_consulImpl)findViewObject("sis_desc_judicial_consul");
    }

    /**Container's getter for SisAuthContratoVw
     */
    public SisAuthContratoVwImpl getSisAuthContratoVw() {
        return (SisAuthContratoVwImpl)findViewObject("SisAuthContratoVw");
    }


    /**Container's getter for sis_contrato_busq2
     */
    public sis_contrato_busq2Impl getsis_contrato_busq2() {
        return (sis_contrato_busq2Impl)findViewObject("sis_contrato_busq2");
    }

    /**Container's getter for sis_contrato_busq2_1
     */
    public sis_contrato_busq2Impl getsis_contrato_busq2_1() {
        return (sis_contrato_busq2Impl)findViewObject("sis_contrato_busq2_1");
    }

    /**Container's getter for sis_contrat_bus2_lnk1
     */
    public ViewLinkImpl getsis_contrat_bus2_lnk1() {
        return (ViewLinkImpl)findViewLink("sis_contrat_bus2_lnk1");
    }

    /**Container's getter for SisNominaVw
     */
    public SisNominaVwImpl getSisNominaVw() {
        return (SisNominaVwImpl)findViewObject("SisNominaVw");
    }

    /**Container's getter for SisDetCalculoAjusteVw
     */
    public SisDetCalculoAjusteVwImpl getSisDetCalculoAjusteVw() {
        return (SisDetCalculoAjusteVwImpl)findViewObject("SisDetCalculoAjusteVw");
    }

    /**Container's getter for SisDetNominaVw1
     */
    public ViewLinkImpl getSisDetNominaVw1() {
        return (ViewLinkImpl)findViewLink("SisDetNominaVw1");
    }

    /**Container's getter for SisNominaVw1
     */
    public SisNominaVwImpl getSisNominaVw1() {
        return (SisNominaVwImpl)findViewObject("SisNominaVw1");
    }

    /**Container's getter for Sis_contrat_nomina_lnk1
     */
    public ViewLinkImpl getSis_contrat_nomina_lnk1() {
        return (ViewLinkImpl)findViewLink("Sis_contrat_nomina_lnk1");
    }


    /**Container's getter for SisDetCalculoAjusteVw1
     */
    public SisDetCalculoAjusteVwImpl getSisDetCalculoAjusteVw1() {
        return (SisDetCalculoAjusteVwImpl)findViewObject("SisDetCalculoAjusteVw1");
    }

    /**Container's getter for SisDetNominaVw2
     */
    public ViewLinkImpl getSisDetNominaVw2() {
        return (ViewLinkImpl)findViewLink("SisDetNominaVw2");
    }

    /**Container's getter for SisAumentoSalarialVw
     */
    public SisAumentoSalarialVwImpl getSisAumentoSalarialVw() {
        return (SisAumentoSalarialVwImpl)findViewObject("SisAumentoSalarialVw");
    }

    /**Container's getter for SisAumentoSalDetVw
     */
    public SisAumentoSalDetVwImpl getSisAumentoSalDetVw() {
        return (SisAumentoSalDetVwImpl)findViewObject("SisAumentoSalDetVw");
    }

    /**Container's getter for SisAumentoSal_lnk1
     */
    public ViewLinkImpl getSisAumentoSal_lnk1() {
        return (ViewLinkImpl)findViewLink("SisAumentoSal_lnk1");
    }

    /**Container's getter for asignacion_num_cheque
     */
    public ViewObjectImpl getasignacion_num_cheque() {
        return (ViewObjectImpl)findViewObject("asignacion_num_cheque");
    }

    /**Container's getter for SisProcesoAsigCheque_lnk1
     */
    public ViewLinkImpl getSisProcesoAsigCheque_lnk1() {
        return (ViewLinkImpl)findViewLink("SisProcesoAsigCheque_lnk1");
    }

    /**Container's getter for detalle_asig_cheque1
     */
    public detalle_asig_chequeImpl getdetalle_asig_cheque1() {
        return (detalle_asig_chequeImpl)findViewObject("detalle_asig_cheque1");
    }

    /**Container's getter for Link_asig_Num_det_cheq1
     */
    public ViewLinkImpl getLink_asig_Num_det_cheq1() {
        return (ViewLinkImpl)findViewLink("Link_asig_Num_det_cheq1");
    }


    /**Container's getter for sis_hora_extra_vw1
     */
    public sis_hora_extra_vwImpl getsis_hora_extra_vw1() {
        return (sis_hora_extra_vwImpl)findViewObject("sis_hora_extra_vw1");
    }

    /**Container's getter for empleado_x_unidad_vw1
     */
    public empleado_x_unidad_vwImpl getempleado_x_unidad_vw1() {
        return (empleado_x_unidad_vwImpl)findViewObject("empleado_x_unidad_vw1");
    }

    /**Container's getter for SisContratosActivos_by_reg1
     */
    public SisContratosActivos_by_regImpl getSisContratosActivos_by_reg1() {
        return (SisContratosActivos_by_regImpl)findViewObject("SisContratosActivos_by_reg1");
    }

    /**Container's getter for contratoActivoXReg_empleadoXUnidad_lnk1
     */
    public ViewLinkImpl getcontratoActivoXReg_empleadoXUnidad_lnk1() {
        return (ViewLinkImpl)findViewLink("contratoActivoXReg_empleadoXUnidad_lnk1");
    }

    /**Container's getter for sis_tiempo_extraordinario_vw1
     */
    public sis_tiempo_extraordinario_vwImpl getsis_tiempo_extraordinario_vw1() {
        return (sis_tiempo_extraordinario_vwImpl)findViewObject("sis_tiempo_extraordinario_vw1");
    }

    /**Container's getter for sis_det_tiempo_extra_vw1
     */
    public sis_det_tiempo_extra_vwImpl getsis_det_tiempo_extra_vw1() {
        return (sis_det_tiempo_extra_vwImpl)findViewObject("sis_det_tiempo_extra_vw1");
    }

    /**Container's getter for sisHoraExtra_sisTiempoExtraor_lnk1
     */
    public ViewLinkImpl getsisHoraExtra_sisTiempoExtraor_lnk1() {
        return (ViewLinkImpl)findViewLink("sisHoraExtra_sisTiempoExtraor_lnk1");
    }

    /**Container's getter for sisTiempoExtraor_disDetExtra_lnk1
     */
    public ViewLinkImpl getsisTiempoExtraor_disDetExtra_lnk1() {
        return (ViewLinkImpl)findViewLink("sisTiempoExtraor_disDetExtra_lnk1");
    }
      /**Container's getter for SisPolizaDiarioVw
     */
    public SisPolizaDiarioVwImpl getSisPolizaDiarioVw() {
        return (SisPolizaDiarioVwImpl)findViewObject("SisPolizaDiarioVw");
    }

    /**Container's getter for sis_variacion_nomina
     */
    public variacion_nominaImpl getsis_variacion_nomina() {
        return (variacion_nominaImpl)findViewObject("sis_variacion_nomina");
    }

    /**Container's getter for sis_variacionDetAjuste
     */
    public variacionDetAjusteImpl getsis_variacionDetAjuste() {
        return (variacionDetAjusteImpl)findViewObject("sis_variacionDetAjuste");
    }

    /**Container's getter for link_VarNomina_VarDetAjuste2
     */
    public ViewLinkImpl getlink_VarNomina_VarDetAjuste2() {
        return (ViewLinkImpl)findViewLink("link_VarNomina_VarDetAjuste2");
    }

    /**Container's getter for Sis_descuentos_empleado
     */
    public Sis_descuentos_empleadoImpl getSis_descuentos_empleado() {
        return (Sis_descuentos_empleadoImpl)findViewObject("Sis_descuentos_empleado");
    }

    /**Container's getter for sis_renuncias_desp
     */
    public sis_renuncias_despImpl getsis_renuncias_desp() {
        return (sis_renuncias_despImpl)findViewObject("sis_renuncias_desp");
    }

    public sis_renuncia_parcialImpl getsis_renuncia_parcial() {
        return (sis_renuncia_parcialImpl)findViewObject("sis_renuncia_parcial");
    }

    /**Container's getter for Sis_ajustes_mod_simple2_vw
     */
    public Sis_ajustes_mod_simple2Impl getSis_ajustes_mod_simple2_vw() {
        return (Sis_ajustes_mod_simple2Impl)findViewObject("Sis_ajustes_mod_simple2_vw");
    }


    /**Container's getter for Sis_ajustes_act_empl
     */
    public ViewObjectImpl getSis_ajustes_act_empl() {
        return (ViewObjectImpl)findViewObject("Sis_ajustes_act_empl");
    }

    /**Container's getter for Sis_Ajuste_x_tipo
     */
    public Sis_Ajuste_x_tipoImpl getSis_Ajuste_x_tipo() {
        return (Sis_Ajuste_x_tipoImpl)findViewObject("Sis_Ajuste_x_tipo");
    }

    /**Container's getter for Sis_Arch_adjunto_variaNom
     */
    public ViewObjectImpl getSis_Arch_adjunto_variaNom() {
        return (ViewObjectImpl)findViewObject("Sis_Arch_adjunto_variaNom");
    }

    /**Container's getter for Sis_archAdj_varia_nom_lnk1
     */
    public ViewLinkImpl getSis_archAdj_varia_nom_lnk1() {
        return (ViewLinkImpl)findViewLink("Sis_archAdj_varia_nom_lnk1");
    }

    /**Container's getter for variacionDetAjuste
     */
    public variacionDetAjusteImpl getvariacionDetAjuste() {
        return (variacionDetAjusteImpl)findViewObject("variacionDetAjuste");
    }

    /**Container's getter for Sis_deudores_vw
     */
    public Sis_deudores_vwImpl getSis_deudores_vw() {
        return (Sis_deudores_vwImpl)findViewObject("Sis_deudores_vw");
    }

    /**Container's getter for Sis_sol_deudor_lnk1
     */
    public ViewLinkImpl getSis_sol_deudor_lnk1() {
        return (ViewLinkImpl)findViewLink("Sis_sol_deudor_lnk1");
    }


    /**Container's getter for SisAjustesSinFiltro
     */
    public SisAjustesSinFiltroImpl getSisAjustesSinFiltro() {
        return (SisAjustesSinFiltroImpl)findViewObject("SisAjustesSinFiltro");
    }

    /**Container's getter for consul_plazaXempleado_vw1
     */
    public consul_plazaXempleado_vwImpl getconsul_plazaXempleado_vw1() {
        return (consul_plazaXempleado_vwImpl)findViewObject("consul_plazaXempleado_vw1");
    }

    /**Container's getter for consul_puesto_promocion_vw1
     */
    public consul_puesto_promocion_vwImpl getconsul_puesto_promocion_vw1() {
        return (consul_puesto_promocion_vwImpl)findViewObject("consul_puesto_promocion_vw1");
    }

    /**Container's getter for SisSolicitudPendiente_vw
     */
    public ViewObjectImpl getSisSolicitudPendiente_vw() {
        return (ViewObjectImpl)findViewObject("SisSolicitudPendiente_vw");
    }

    /**Container's getter for Sis_Colegio_profesional
     */
    public ViewObjectImpl getSis_Colegio_profesional() {
        return (ViewObjectImpl)findViewObject("Sis_Colegio_profesional");
    }


    /**Container's getter for Sis_historial_salarial
     */
    public Sis_historial_salarialImpl getSis_historial_salarial() {
        return (Sis_historial_salarialImpl)findViewObject("Sis_historial_salarial");
    }

    /**Container's getter for Sis_renglon
     */
    public Sis_renglonImpl getSis_renglon() {
        return (Sis_renglonImpl)findViewObject("Sis_renglon");
    }

    /**Container's getter for Sis_tipo_nomina
     */
    public Sis_tipo_nominaImpl getSis_tipo_nomina() {
        return (Sis_tipo_nominaImpl)findViewObject("Sis_tipo_nomina");
    }


    /**Container's getter for SisPrograma
     */
    public ViewObjectImpl getSisPrograma() {
        return (ViewObjectImpl)findViewObject("SisPrograma");
    }


    /**Container's getter for SisUnidadesEjecutoras_deps
     */
    public SisUnidadesEjecutoras_depsImpl getSisUnidadesEjecutoras_deps() {
        return (SisUnidadesEjecutoras_depsImpl)findViewObject("SisUnidadesEjecutoras_deps");
    }

    /**Container's getter for Sis_historial_det1_1
     */
    public Sis_historial_det1Impl getSis_historial_det1_1() {
        return (Sis_historial_det1Impl)findViewObject("Sis_historial_det1_1");
    }

    /**Container's getter for SisDetCalculoAjusteAgrupVw
     */
    public SisDetCalculoAjusteAgrupVwImpl getSisDetCalculoAjusteAgrupVw() {
        return (SisDetCalculoAjusteAgrupVwImpl)findViewObject("SisDetCalculoAjusteAgrupVw");
    }

    /**Container's getter for Sis_hist_det_descuentos_lnk1
     */
    public ViewLinkImpl getSis_hist_det_descuentos_lnk1() {
        return (ViewLinkImpl)findViewLink("Sis_hist_det_descuentos_lnk1");
    }

    /**Container's getter for consul_puestoXempleado1
     */
    public consul_puestoXempleadoImpl getconsul_puestoXempleado1() {
        return (consul_puestoXempleadoImpl)findViewObject("consul_puestoXempleado1");
    }
     /**Container's getter for SisProcesoSfltro
     */
    public SisProcesoSfltroImpl getSisProcesoSfltro() {
        return (SisProcesoSfltroImpl)findViewObject("SisProcesoSfltro");
    }

    /**Container's getter for Sis_Arch_adjunto1
     */
    public Sis_Arch_adjuntoImpl getSis_Arch_adjunto1() {
        return (Sis_Arch_adjuntoImpl)findViewObject("Sis_Arch_adjunto1");
    }

    /**Container's getter for sisAnexo_sisArchivoAdjunto_vlk1
     */
    public ViewLinkImpl getsisAnexo_sisArchivoAdjunto_vlk1() {
        return (ViewLinkImpl)findViewLink("sisAnexo_sisArchivoAdjunto_vlk1");
    }

    /**Container's getter for Sis_pagosAnuladosVw
     */
    public Sis_pagosAnuladosVwImpl getSis_pagosAnuladosVw() {
        return (Sis_pagosAnuladosVwImpl)findViewObject("Sis_pagosAnuladosVw");
    }

    /**Container's getter for SisFichaEmpleadoVw
     */
    public SisFichaEmpleadoVwImpl getSisFichaEmpleadoVw() {
        return (SisFichaEmpleadoVwImpl)findViewObject("SisFichaEmpleadoVw");
    }

    /**Container's getter for SisTipoJubiladoVw
     */
    public SisTipoJubiladoVwImpl getSisTipoJubiladoVw() {
        return (SisTipoJubiladoVwImpl)findViewObject("SisTipoJubiladoVw");
    }


    /**Container's getter for Sis_Institucion_academica
     */
    public ViewObjectImpl getSis_Institucion_academica() {
        return (ViewObjectImpl)findViewObject("Sis_Institucion_academica");
    }

    /**Container's getter for SisNivelAca_Institucion1
     */
    public ViewLinkImpl getSisNivelAca_Institucion1() {
        return (ViewLinkImpl)findViewLink("SisNivelAca_Institucion1");
    }

    /**Container's getter for Sis_Arch_adjunto
     */
    public Sis_Arch_adjuntoImpl getSis_Arch_adjunto() {
        return (Sis_Arch_adjuntoImpl)findViewObject("Sis_Arch_adjunto");
    }

    /**Container's getter for SisFichaEmpArchs_lnk1
     */
    public ViewLinkImpl getSisFichaEmpArchs_lnk1() {
        return (ViewLinkImpl)findViewLink("SisFichaEmpArchs_lnk1");
    }

    /**Container's getter for SisEmpleadoJubiladoVw
     */
    public SisEmpleadoJubiladoVwImpl getSisEmpleadoJubiladoVw() {
        return (SisEmpleadoJubiladoVwImpl)findViewObject("SisEmpleadoJubiladoVw");
    }

    /**Container's getter for SisFichaEmplTipJubilado_lnk1
     */
    public ViewLinkImpl getSisFichaEmplTipJubilado_lnk1() {
        return (ViewLinkImpl)findViewLink("SisFichaEmplTipJubilado_lnk1");
    }

    /**Container's getter for SisEmpleadoJubiladoVw1
     */
    public SisEmpleadoJubiladoVwImpl getSisEmpleadoJubiladoVw1() {
        return (SisEmpleadoJubiladoVwImpl)findViewObject("SisEmpleadoJubiladoVw1");
    }

    /**Container's getter for SisEmpleadoTipJub_lnk1
     */
    public ViewLinkImpl getSisEmpleadoTipJub_lnk1() {
        return (ViewLinkImpl)findViewLink("SisEmpleadoTipJub_lnk1");
    }

    /**Container's getter for SisChequeDescartadoVw
     */
    public SisChequeDescartadoVwImpl getSisChequeDescartadoVw() {
        return (SisChequeDescartadoVwImpl)findViewObject("SisChequeDescartadoVw");
    }

    /**Container's getter for SisMotivoChequeRecha_vw
     */
    public SisMotivoChequeRechaImpl getSisMotivoChequeRecha_vw() {
        return (SisMotivoChequeRechaImpl)findViewObject("SisMotivoChequeRecha_vw");
    }

    /**Container's getter for Sis_docPagoAnuladoForm22_vw
     */
    public Sis_docPagoAnuladoForm22Impl getSis_docPagoAnuladoForm22_vw() {
        return (Sis_docPagoAnuladoForm22Impl)findViewObject("Sis_docPagoAnuladoForm22_vw");
    }

    /**Container's getter for SisParametrosAplicacionVw
     */
    public SisParametrosAplicacionVwImpl getSisParametrosAplicacionVw() {
        return (SisParametrosAplicacionVwImpl)findViewObject("SisParametrosAplicacionVw");
    }

    /**Container's getter for SisAjustePartida_Vw
     */
    public SisAjustePartida_VwImpl getSisAjustePartida_Vw() {
        return (SisAjustePartida_VwImpl)findViewObject("SisAjustePartida_Vw");
    }

    /**Container's getter for SisAjustePartida_lnk1
     */
    public ViewLinkImpl getSisAjustePartida_lnk1() {
        return (ViewLinkImpl)findViewLink("SisAjustePartida_lnk1");
    }

    /**Container's getter for PlanPartidaVw
     */
    public ViewObjectImpl getPlanPartidaVw() {
        return (ViewObjectImpl)findViewObject("PlanPartidaVw");
    }

    /**Container's getter for RenglonPartidaVw
     */
    public ViewObjectImpl getRenglonPartidaVw() {
        return (ViewObjectImpl)findViewObject("RenglonPartidaVw");
    }

    /**Container's getter for PartidaGastoVw
     */
    public ViewObjectImpl getPartidaGastoVw() {
        return (ViewObjectImpl)findViewObject("PartidaGastoVw");
    }

    /**Container's getter for sis_acta_facsimil_vw1
     */
    public sis_acta_facsimil_vwImpl getsis_acta_facsimil_vw1() {
        return (sis_acta_facsimil_vwImpl)findViewObject("sis_acta_facsimil_vw1");
    }

    /**Container's getter for sis_detCheques_facsimil_vw1
     */
    public sis_detCheques_facsimil_vwImpl getsis_detCheques_facsimil_vw1() {
        return (sis_detCheques_facsimil_vwImpl)findViewObject("sis_detCheques_facsimil_vw1");
    }

    /**Container's getter for actaFacsimil_detChequesFac_vlk1
     */
    public ViewLinkImpl getactaFacsimil_detChequesFac_vlk1() {
        return (ViewLinkImpl)findViewLink("actaFacsimil_detChequesFac_vlk1");
    }

    /**Container's getter for sis_comision_facsimil1
     */
    public sis_comision_facsimilImpl getsis_comision_facsimil1() {
        return (sis_comision_facsimilImpl)findViewObject("sis_comision_facsimil1");
    }

    /**Container's getter for comision_facsimil_vlk1
     */
    public ViewLinkImpl getcomision_facsimil_vlk1() {
        return (ViewLinkImpl)findViewLink("comision_facsimil_vlk1");
    }

    /**Container's getter for view_SisDocPagoAnulado2
     */
    public view_SisDocPagoAnuladoImpl getview_SisDocPagoAnulado2() {
        return (view_SisDocPagoAnuladoImpl)findViewObject("view_SisDocPagoAnulado2");
    }

    /**Container's getter for actaFacsimil_docPagoAnulado_vkl1
     */
    public ViewLinkImpl getactaFacsimil_docPagoAnulado_vkl1() {
        return (ViewLinkImpl)findViewLink("actaFacsimil_docPagoAnulado_vkl1");
    }

    /**Container's getter for consul_cheque_descartado_vw1
     */
    public consul_cheque_descartado_vwImpl getconsul_cheque_descartado_vw1() {
        return (consul_cheque_descartado_vwImpl)findViewObject("consul_cheque_descartado_vw1");
    }

    /**Container's getter for SisChequeDescartadoVw1
     */
    public SisChequeDescartadoVwImpl getSisChequeDescartadoVw1() {
        return (SisChequeDescartadoVwImpl)findViewObject("SisChequeDescartadoVw1");
    }

    /**Container's getter for actaFacsimil_chequesDescartados_vlk1
     */
    public ViewLinkImpl getactaFacsimil_chequesDescartados_vlk1() {
        return (ViewLinkImpl)findViewLink("actaFacsimil_chequesDescartados_vlk1");
    }

    /**Container's getter for SisTipoNominaPartidaVw
     */
    public ViewObjectImpl getSisTipoNominaPartidaVw() {
        return (ViewObjectImpl)findViewObject("SisTipoNominaPartidaVw");
    }

    /**Container's getter for SisTipoNomTipNomPartida_lnk1
     */
    public ViewLinkImpl getSisTipoNomTipNomPartida_lnk1() {
        return (ViewLinkImpl)findViewLink("SisTipoNomTipNomPartida_lnk1");
    }

    /**Container's getter for SisListSis_22Vw
     */
    public SisListSis_22VwImpl getSisListSis_22Vw() {
        return (SisListSis_22VwImpl)findViewObject("SisListSis_22Vw");
    }

    /**Container's getter for sis_sueldo_cuenta_vw1
     */
    public sis_sueldo_cuenta_vwImpl getsis_sueldo_cuenta_vw1() {
        return (sis_sueldo_cuenta_vwImpl)findViewObject("sis_sueldo_cuenta_vw1");
    }

    /**Container's getter for SisConsulPlaza_vw
     */
    public SisConsulPlazaImpl getSisConsulPlaza_vw() {
        return (SisConsulPlazaImpl)findViewObject("SisConsulPlaza_vw");
    }

    /**Container's getter for SisPartida2_Vw
     */
    public ViewObjectImpl getSisPartida2_Vw() {
        return (ViewObjectImpl)findViewObject("SisPartida2_Vw");
    }

    /**Container's getter for SisPeriodoCodNomina_vw
     */
    public ViewObjectImpl getSisPeriodoCodNomina_vw() {
        return (ViewObjectImpl)findViewObject("SisPeriodoCodNomina_vw");
    }

    /**Container's getter for consul_contratosAdmin_byReg_vw1
     */
    public consul_contratosAdmin_byReg_vwImpl getconsul_contratosAdmin_byReg_vw1() {
        return (consul_contratosAdmin_byReg_vwImpl)findViewObject("consul_contratosAdmin_byReg_vw1");
    }

    /**Container's getter for consul_partidaGasto_vw1
     */
    public consul_partidaGasto_vwImpl getconsul_partidaGasto_vw1() {
        return (consul_partidaGasto_vwImpl)findViewObject("consul_partidaGasto_vw1");
    }

    /**Container's getter for SisRespuestaCensoVw
     */
    public SisRespuestaCensoVwImpl getSisRespuestaCensoVw() {
        return (SisRespuestaCensoVwImpl)findViewObject("SisRespuestaCensoVw");
    }

    /**Container's getter for SisFichaEmpl_respuestaCenso_lnk1
     */
    public ViewLinkImpl getSisFichaEmpl_respuestaCenso_lnk1() {
        return (ViewLinkImpl)findViewLink("SisFichaEmpl_respuestaCenso_lnk1");
    }

    /**Container's getter for SisHorarioContrato1
     */
    public SisHorarioContratoImpl getSisHorarioContrato1() {
        return (SisHorarioContratoImpl)findViewObject("SisHorarioContrato1");
    }

    /**Container's getter for contratosAdminbyReg_HorarioContrato_lk1
     */
    public ViewLinkImpl getcontratosAdminbyReg_HorarioContrato_lk1() {
        return (ViewLinkImpl)findViewLink("contratosAdminbyReg_HorarioContrato_lk1");
    }


    /**Container's getter for consul_empleado_vw1
     */
    public consul_empleado_vwImpl getconsul_empleado_vw1() {
        return (consul_empleado_vwImpl)findViewObject("consul_empleado_vw1");
    }

    /**Container's getter for SisProcesosNominaVw
     */
    public SisProcesosNominaVwImpl getSisProcesosNominaVw() {
        return (SisProcesosNominaVwImpl)findViewObject("SisProcesosNominaVw");
    }

    /**Container's getter for sis_tiempo_extra_consul
     */
    public sis_tiempo_extra_consulImpl getsis_tiempo_extra_consul() {
        return (sis_tiempo_extra_consulImpl)findViewObject("sis_tiempo_extra_consul");
    }

    /**Container's getter for sis_promo_reclaf_consul
     */
    public sis_promo_reclaf_consulImpl getsis_promo_reclaf_consul() {
        return (sis_promo_reclaf_consulImpl)findViewObject("sis_promo_reclaf_consul");
    }

    /**Container's getter for contrato1
     */
    public contratoImpl getcontrato1() {
        return (contratoImpl)findViewObject("contrato1");
    }

    /**Container's getter for SisHorarioContrato2
     */
    public SisHorarioContratoImpl getSisHorarioContrato2() {
        return (SisHorarioContratoImpl)findViewObject("SisHorarioContrato2");
    }

    /**Container's getter for contrato_horarioContrato_lk1
     */
    public ViewLinkImpl getcontrato_horarioContrato_lk1() {
        return (ViewLinkImpl)findViewLink("contrato_horarioContrato_lk1");
    }

    /**Container's getter for contratos_del_tesorero_vw
     */
    public contratos_del_tesorero_vwImpl getcontratos_del_tesorero_vw() {
        return (contratos_del_tesorero_vwImpl)findViewObject("contratos_del_tesorero_vw");
    }

    /**Container's getter for SisContratosEmplOpVw
     */
    public SisContratosEmplOpVwImpl getSisContratosEmplOpVw() {
        return (SisContratosEmplOpVwImpl)findViewObject("SisContratosEmplOpVw");
    }

    /**Container's getter for SisEmpl_ContratAct2_lnk1
     */
    public ViewLinkImpl getSisEmpl_ContratAct2_lnk1() {
        return (ViewLinkImpl)findViewLink("SisEmpl_ContratAct2_lnk1");
    }

    /**Container's getter for SisLicenciasSinGoceVw
     */
    public SisLicenciasSinGoceVwImpl getSisLicenciasSinGoceVw() {
        return (SisLicenciasSinGoceVwImpl)findViewObject("SisLicenciasSinGoceVw");
    }

    /**Container's getter for Sis_conciliacion_bancaria_vw
     */
    public Sis_conciliacion_bancaria_vwImpl getSis_conciliacion_bancaria_vw() {
        return (Sis_conciliacion_bancaria_vwImpl)findViewObject("Sis_conciliacion_bancaria_vw");
    }

    /**Container's getter for licencias_vw1
     */
    public licencias_vwImpl getlicencias_vw1() {
        return (licencias_vwImpl)findViewObject("licencias_vw1");
    }

    /**Container's getter for suspensionIgss_vw1
     */
    public suspensionIgss_vwImpl getsuspensionIgss_vw1() {
        return (suspensionIgss_vwImpl)findViewObject("suspensionIgss_vw1");
    }

    /**Container's getter for Sis_ajuste_modificables_empl_vw
     */
    public Sis_ajuste_modificables_empl_vwImpl getSis_ajuste_modificables_empl_vw() {
        return (Sis_ajuste_modificables_empl_vwImpl)findViewObject("Sis_ajuste_modificables_empl_vw");
    }

    /**Container's getter for Sis_variacionNom_pendiente_vw
     */
    public Sis_variacionNom_pendiente_vwImpl getSis_variacionNom_pendiente_vw() {
        return (Sis_variacionNom_pendiente_vwImpl)findViewObject("Sis_variacionNom_pendiente_vw");
    }

    /**Container's getter for sis_tipoproceso_rol_vw
     */
    public sis_tipoproceso_rol_vwImpl getsis_tipoproceso_rol_vw() {
        return (sis_tipoproceso_rol_vwImpl)findViewObject("sis_tipoproceso_rol_vw");
    }

    /**Container's getter for periodos_proc_vw1
     */
    public periodos_proc_vwImpl getperiodos_proc_vw1() {
        return (periodos_proc_vwImpl)findViewObject("periodos_proc_vw1");
    }

    /**Container's getter for SisTipoProcRol_period_lnk1
     */
    public ViewLinkImpl getSisTipoProcRol_period_lnk1() {
        return (ViewLinkImpl)findViewLink("SisTipoProcRol_period_lnk1");
    }

    /**Container's getter for consul_sispartida021_1
     */
    public consul_sispartida021Impl getconsul_sispartida021_1() {
        return (consul_sispartida021Impl)findViewObject("consul_sispartida021_1");
    }

    /**Container's getter for consul_sispuesto021_1
     */
    public consul_sispuesto021Impl getconsul_sispuesto021_1() {
        return (consul_sispuesto021Impl)findViewObject("consul_sispuesto021_1");
    }

    /**Container's getter for sis_plaza1
     */
    public sis_plazaImpl getsis_plaza1() {
        return (sis_plazaImpl)findViewObject("sis_plaza1");
    }

    /**Container's getter for SisContrato029Vw
     */
    public SisContrato029VwImpl getSisContrato029Vw() {
        return (SisContrato029VwImpl)findViewObject("SisContrato029Vw");
    }

    /**Container's getter for SisEmpl_contrat029_lnk1
     */
    public ViewLinkImpl getSisEmpl_contrat029_lnk1() {
        return (ViewLinkImpl)findViewLink("SisEmpl_contrat029_lnk1");
    }

    /**Container's getter for SisPartida029_vw
     */
    public SisPartida029_vwImpl getSisPartida029_vw() {
        return (SisPartida029_vwImpl)findViewObject("SisPartida029_vw");
    }

    /**Container's getter for SisEmpleadoPendienteReg_vw
     */
    public SisEmpleadoPendienteReg_vwImpl getSisEmpleadoPendienteReg_vw() {
        return (SisEmpleadoPendienteReg_vwImpl)findViewObject("SisEmpleadoPendienteReg_vw");
    }

    /**Container's getter for SisContrato029VwEx
     */
    public SisContrato029VwExImpl getSisContrato029VwEx() {
        return (SisContrato029VwExImpl)findViewObject("SisContrato029VwEx");
    }

    /**Container's getter for SisRegPerAsignacionVw
     */
    public SisRegPerAsignacionVwImpl getSisRegPerAsignacionVw() {
        return (SisRegPerAsignacionVwImpl)findViewObject("SisRegPerAsignacionVw");
    }

    /**Container's getter for SisRegPerAsignacionVwEx
     */
    public SisRegPerAsignacionVwExImpl getSisRegPerAsignacionVwEx() {
        return (SisRegPerAsignacionVwExImpl)findViewObject("SisRegPerAsignacionVwEx");
    }

    /**Container's getter for todos_los_Departamentos2
     */
    public ViewObjectImpl gettodos_los_Departamentos2() {
        return (ViewObjectImpl)findViewObject("todos_los_Departamentos2");
    }

    /**Container's getter for municipios_dep_by_mun2
     */
    public ViewObjectImpl getmunicipios_dep_by_mun2() {
        return (ViewObjectImpl)findViewObject("municipios_dep_by_mun2");
    }

    /**Container's getter for SisProyeccionISRVw
     */
    public SisProyeccionISRImpl getSisProyeccionISRVw() {
        return (SisProyeccionISRImpl)findViewObject("SisProyeccionISRVw");
    }

    /**Container's getter for SisDeclaracionJuradaVw
     */
    public SisDeclaracionJuradaVwImpl getSisDeclaracionJuradaVw() {
        return (SisDeclaracionJuradaVwImpl)findViewObject("SisDeclaracionJuradaVw");
    }

    /**Container's getter for SisHorarioDecJuradaVw
     */
    public SisHorarioDecJuradaVwImpl getSisHorarioDecJuradaVw() {
        return (SisHorarioDecJuradaVwImpl)findViewObject("SisHorarioDecJuradaVw");
    }

    /**Container's getter for Sis_declara_horarios_lnk1
     */
    public ViewLinkImpl getSis_declara_horarios_lnk1() {
        return (ViewLinkImpl)findViewLink("Sis_declara_horarios_lnk1");
    }

    /**Container's getter for SisUnidadesEjecutoras_Id_vw
     */
    public SisUnidadesEjecutoras_Id_vwImpl getSisUnidadesEjecutoras_Id_vw() {
        return (SisUnidadesEjecutoras_Id_vwImpl)findViewObject("SisUnidadesEjecutoras_Id_vw");
    }

    /**Container's getter for SisIsrForm1101Vw
     */
    public SisIsrForm1101VwImpl getSisIsrForm1101Vw() {
        return (SisIsrForm1101VwImpl)findViewObject("SisIsrForm1101Vw");
    }

    /**Container's getter for SisIsrForm1101OtrosptrnosVw
     */
    public SisIsrForm1101OtrosptrnosVwImpl getSisIsrForm1101OtrosptrnosVw() {
        return (SisIsrForm1101OtrosptrnosVwImpl)findViewObject("SisIsrForm1101OtrosptrnosVw");
    }

    /**Container's getter for SisForm1101_OPatro_vw1
     */
    public ViewLinkImpl getSisForm1101_OPatro_vw1() {
        return (ViewLinkImpl)findViewLink("SisForm1101_OPatro_vw1");
    }

    /**Container's getter for SisDireccionFiscalVw
     */
    public SisDireccionFiscalVwImpl getSisDireccionFiscalVw() {
        return (SisDireccionFiscalVwImpl)findViewObject("SisDireccionFiscalVw");
    }
    /**Container's getter for consul_partidaSueldos_vw1
     */
    public consul_partidaSueldos_vwImpl getconsul_partidaSueldos_vw1() {
        return (consul_partidaSueldos_vwImpl)findViewObject("consul_partidaSueldos_vw1");
    }

    /**Container's getter for SisEmpleadoCambiosVw
     */
    public SisEmpleadoCambiosVwImpl getSisEmpleadoCambiosVw() {
        return (SisEmpleadoCambiosVwImpl)findViewObject("SisEmpleadoCambiosVw");
    }

    /**Container's getter for UsuarioVw
     */
    public UsuarioVwImpl getUsuarioVw() {
        return (UsuarioVwImpl)findViewObject("UsuarioVw");
    }

    /**Container's getter for pregunta_seguridad_vw
     */
    public pregunta_seguridadImpl getpregunta_seguridad_vw() {
        return (pregunta_seguridadImpl)findViewObject("pregunta_seguridad_vw");
    }

    /**Container's getter for Sis_firmas_docs_vw
     */
     
    public Sis_firmas_docs_vwImpl getSis_firmas_docs_vw() {
        return (Sis_firmas_docs_vwImpl)findViewObject("Sis_firmas_docs_vw");
    }
    
    /**Container's getter for consul_Hora_extra_vw1
     */
    public consul_Hora_extra_vwImpl getconsul_Hora_extra_vw1() {
        return (consul_Hora_extra_vwImpl)findViewObject("consul_Hora_extra_vw1");
    }

    /**Container's getter for consul_aumentoSalarial_vw1
     */
    public consul_aumentoSalarial_vwImpl getconsul_aumentoSalarial_vw1() {
        return (consul_aumentoSalarial_vwImpl)findViewObject("consul_aumentoSalarial_vw1");
    }

    /**Container's getter for consul_contrato_variacion_vw1
     */
    public consul_contrato_variacion_vwImpl getconsul_contrato_variacion_vw1() {
        return (consul_contrato_variacion_vwImpl)findViewObject("consul_contrato_variacion_vw1");
    }

    /**Container's getter for sisEmpleado_consulContratoVariacion_lnk1
     */
    public ViewLinkImpl getsisEmpleado_consulContratoVariacion_lnk1() {
        return (ViewLinkImpl)findViewLink("sisEmpleado_consulContratoVariacion_lnk1");
    }

    /**Container's getter for Sis_documentos_adjuntos_vw
     */
    public Sis_documentos_adjuntos_vwImpl getSis_documentos_adjuntos_vw() {
        return (Sis_documentos_adjuntos_vwImpl)findViewObject("Sis_documentos_adjuntos_vw");
    }

    /**Container's getter for Sis_UniversidadesVw
     */
    public Sis_UniversidadesVwImpl getSis_UniversidadesVw() {
        return (Sis_UniversidadesVwImpl)findViewObject("Sis_UniversidadesVw");
    }

    /**Container's getter for sisDictamen_vw1
     */
    public sisDictamen_vwImpl getsisDictamen_vw1() {
        return (sisDictamen_vwImpl)findViewObject("sisDictamen_vw1");
    }

    /**Container's getter for sisDictamenDetalle_vw1
     */
    public sisDictamenDetalle_vwImpl getsisDictamenDetalle_vw1() {
        return (sisDictamenDetalle_vwImpl)findViewObject("sisDictamenDetalle_vw1");
    }

    /**Container's getter for sisDictamen_sisDictamenDetalle_vlk1
     */
    public ViewLinkImpl getsisDictamen_sisDictamenDetalle_vlk1() {
        return (ViewLinkImpl)findViewLink("sisDictamen_sisDictamenDetalle_vlk1");
    }
    /**Container's getter for Sis_list_detPagoDesc_vw
     */
    public Sis_list_detPagoDesc_vwImpl getSis_list_detPagoDesc_vw() {
        return (Sis_list_detPagoDesc_vwImpl)findViewObject("Sis_list_detPagoDesc_vw");
    }

    /**Container's getter for Sis_list_dest_empleado_vw
     */
    public Sis_list_dest_empleado_vwImpl getSis_list_dest_empleado_vw() {
        return (Sis_list_dest_empleado_vwImpl)findViewObject("Sis_list_dest_empleado_vw");
    }

    /**Container's getter for Sis_Banco_vw
     */
    public Sis_Banco_vwImpl getSis_Banco_vw() {
        return (Sis_Banco_vwImpl)findViewObject("Sis_Banco_vw");
    }

    /**Container's getter for SisUnidadAcademicaVw
     */
    public SisUnidadAcademicaVwImpl getSisUnidadAcademicaVw() {
        return (SisUnidadAcademicaVwImpl)findViewObject("SisUnidadAcademicaVw");
    }

    /**Container's getter for Sis_Departamentos2_vw
     */
    public Sis_Departamentos2_vwImpl getSis_Departamentos2_vw() {
        return (Sis_Departamentos2_vwImpl)findViewObject("Sis_Departamentos2_vw");
    }
    
    
    /**Container's getter for consul_nomDictamen_vw1
     */
    public consul_nomDictamen_vwImpl getconsul_nomDictamen_vw1() {
        return (consul_nomDictamen_vwImpl)findViewObject("consul_nomDictamen_vw1");
    }

    /**Container's getter for SisPlazasPerfil_Empleado_vw
     */
    public SisPlazasPerfil_EmpleadoImpl getSisPlazasPerfil_Empleado_vw() {
        return (SisPlazasPerfil_EmpleadoImpl)findViewObject("SisPlazasPerfil_Empleado_vw");
    }

    /**Container's getter for SisEmpleadoPlazas_perfEmpl1
     */
    public ViewLinkImpl getSisEmpleadoPlazas_perfEmpl1() {
        return (ViewLinkImpl)findViewLink("SisEmpleadoPlazas_perfEmpl1");
    }

    /**Container's getter for Sis_ListLic_empleado_vw
     */
    public Sis_ListLic_empleado_vwImpl getSis_ListLic_empleado_vw() {
        return (Sis_ListLic_empleado_vwImpl)findViewObject("Sis_ListLic_empleado_vw");
    }

    /**Container's getter for SisSueldosEmpl_ISR_vw
     */
    public SisSueldosEmpl_ISR_vwImpl getSisSueldosEmpl_ISR_vw() {
        return (SisSueldosEmpl_ISR_vwImpl)findViewObject("SisSueldosEmpl_ISR_vw");
    }

    /**Container's getter for SisVariacionNominavw2
     */
    public SisVariacionNominavw2Impl getSisVariacionNominavw2() {
        return (SisVariacionNominavw2Impl)findViewObject("SisVariacionNominavw2");
    }

    /**Container's getter for SisConsultaChequeConciaVW
     */
    public SisConsultaChequeConciaVWImpl getSisConsultaChequeConciaVW() {
        return (SisConsultaChequeConciaVWImpl)findViewObject("SisConsultaChequeConciaVW");
    }

    /**Container's getter for ListadoPuestoxTrabajadorV
     */
    public ListadoPuestoxTrabajadorVImpl getListadoPuestoxTrabajadorV() {
        return (ListadoPuestoxTrabajadorVImpl)findViewObject("ListadoPuestoxTrabajadorV");
    }

    /**Container's getter for SisComplementoVw
     */
    public SisComplementoVwImpl getSisComplementoVw() {
        return (SisComplementoVwImpl)findViewObject("SisComplementoVw");
    }

    /**Container's getter for SisComplementoDetVw
     */
    public SisComplementoDetVwImpl getSisComplementoDetVw() {
        return (SisComplementoDetVwImpl)findViewObject("SisComplementoDetVw");
    }

    /**Container's getter for vkSisComplementoSisComplDet1
     */
    public ViewLinkImpl getvkSisComplementoSisComplDet1() {
        return (ViewLinkImpl)findViewLink("vkSisComplementoSisComplDet1");
    }

    /**Container's getter for ComplementoPersonalV
     */
    public ComplementoPersonalVImpl getComplementoPersonalV() {
        return (ComplementoPersonalVImpl)findViewObject("ComplementoPersonalV");
    }

    /**Container's getter for SisPeridoxTipoNomVw
     */
    public SisPeridoxTipoNomImpl getSisPeridoxTipoNomVw() {
        return (SisPeridoxTipoNomImpl)findViewObject("SisPeridoxTipoNomVw");
    }

    /**Container's getter for SisComplementoIgssVw
     */
    public SisComplementoIgssVwImpl getSisComplementoIgssVw() {
        return (SisComplementoIgssVwImpl)findViewObject("SisComplementoIgssVw");
    }

    /**Container's getter for SisComplementoSisComplIgss_Vw1
     */
    public ViewLinkImpl getSisComplementoSisComplIgss_Vw1() {
        return (ViewLinkImpl)findViewLink("SisComplementoSisComplIgss_Vw1");
    }

    /**Container's getter for SisCompleRevPendVw
     */
    public SisCompleRevPendVwImpl getSisCompleRevPendVw() {
        return (SisCompleRevPendVwImpl)findViewObject("SisCompleRevPendVw");
    }

    /**Container's getter for SisProcesoVw2
     */
    public SisProcesoVw2Impl getSisProcesoVw2() {
        return (SisProcesoVw2Impl)findViewObject("SisProcesoVw2");
    }

    /**Container's getter for SisParamSuspIgssVw
     */
    public SisParamSuspIgssVwImpl getSisParamSuspIgssVw() {
        return (SisParamSuspIgssVwImpl)findViewObject("SisParamSuspIgssVw");
    }

    /**Container's getter for SisPromReclafView1
     */
    public SisPromReclafViewImpl getSisPromReclafView1() {
        return (SisPromReclafViewImpl)findViewObject("SisPromReclafView1");
    }

    /**Container's getter for SisPromoreclafSolicitudLink1
     */
    public ViewLinkImpl getSisPromoreclafSolicitudLink1() {
        return (ViewLinkImpl)findViewLink("SisPromoreclafSolicitudLink1");
    }
    
    /**Container's getter for consul_cheqAnuladoXRecibir_vw1
     */
    public consul_cheqAnuladoXRecibir_vwImpl getconsul_cheqAnuladoXRecibir_vw1() {
        return (consul_cheqAnuladoXRecibir_vwImpl)findViewObject("consul_cheqAnuladoXRecibir_vw1");
    }

    /**Container's getter for sis_docPago_recibido_vw1
     */
    public sis_docPago_recibido_vwImpl getsis_docPago_recibido_vw1() {
        return (sis_docPago_recibido_vwImpl)findViewObject("sis_docPago_recibido_vw1");
    }


    /**Container's getter for SisComplementoVw1
     */
    public SisComplementoVwImpl getSisComplementoVw1() {
        return (SisComplementoVwImpl)findViewObject("SisComplementoVw1");
    }

    /**Container's getter for SisComplementoDetVw1
     */
    public SisComplementoDetVwImpl getSisComplementoDetVw1() {
        return (SisComplementoDetVwImpl)findViewObject("SisComplementoDetVw1");
    }

    /**Container's getter for SisComplementoSolicitudLink1
     */
    public ViewLinkImpl getSisComplementoSolicitudLink1() {
        return (ViewLinkImpl)findViewLink("SisComplementoSolicitudLink1");
    }

    /**Container's getter for vkSisComplementoSisComplDet2
     */
    public ViewLinkImpl getvkSisComplementoSisComplDet2() {
        return (ViewLinkImpl)findViewLink("vkSisComplementoSisComplDet2");
    }

    /**Container's getter for SisCalendarioActividadVw
     */
    public SisCalendarioActividadVwImpl getSisCalendarioActividadVw() {
        return (SisCalendarioActividadVwImpl)findViewObject("SisCalendarioActividadVw");
    }

    /**Container's getter for SisComplementoDetajustesVw
     */
    public SisComplementoDetajustesVwImpl getSisComplementoDetajustesVw() {
        return (SisComplementoDetajustesVwImpl)findViewObject("SisComplementoDetajustesVw");
    }

    /**Container's getter for SisCompl_DetAjuste_lnk1
     */
    public ViewLinkImpl getSisCompl_DetAjuste_lnk1() {
        return (ViewLinkImpl)findViewLink("SisCompl_DetAjuste_lnk1");
    }

    /**Container's getter for SisPuestoXCategoriaVw1
     */
    public SisPuestoXCategoriaVwImpl getSisPuestoXCategoriaVw1() {
        return (SisPuestoXCategoriaVwImpl)findViewObject("SisPuestoXCategoriaVw1");
    }

    /**Container's getter for SisComplementoDetajustesVw1
     */
    public SisComplementoDetajustesVwImpl getSisComplementoDetajustesVw1() {
        return (SisComplementoDetajustesVwImpl)findViewObject("SisComplementoDetajustesVw1");
    }

    /**Container's getter for SisCompl_DetAjuste_lnk2
     */
    public ViewLinkImpl getSisCompl_DetAjuste_lnk2() {
        return (ViewLinkImpl)findViewLink("SisCompl_DetAjuste_lnk2");
    }

    /**Container's getter for SisContratos_ant_empl_vw
     */
    public SisContratos_ant_empl_vwImpl getSisContratos_ant_empl_vw() {
        return (SisContratos_ant_empl_vwImpl)findViewObject("SisContratos_ant_empl_vw");
    }

    /**Container's getter for Sis_CompleRevisados_vw
     */
    public Sis_CompleRevisados_vwImpl getSis_CompleRevisados_vw() {
        return (Sis_CompleRevisados_vwImpl)findViewObject("Sis_CompleRevisados_vw");
    }

    /**Container's getter for listado_procesos_mod_nomina
     */
    public listado_procesos_mod_nominaImpl getlistado_procesos_mod_nomina() {
        return (listado_procesos_mod_nominaImpl)findViewObject("listado_procesos_mod_nomina");
    }

    /**Container's getter for modificar_nominavo
     */
    public modificar_nominavoImpl getmodificar_nominavo() {
        return (modificar_nominavoImpl)findViewObject("modificar_nominavo");
    }
    
    public void setIdBitacora(String pIdBitacora){
        
        vIDBitacora=pIdBitacora;
        
    }
    
    public String getIdBitacora(){
        
        return vIDBitacora;
    }

    /**Container's getter for SisContratosActivosDepVw
     */
    public SisContratosActivosDepImpl getSisContratosActivosDepVw() {
        return (SisContratosActivosDepImpl)findViewObject("SisContratosActivosDepVw");
    }

    /**Container's getter for Sis_variacionNom_Revisada_vw
     */
    public Sis_variacionNom_Revisada_vwImpl getSis_variacionNom_Revisada_vw() {
        return (Sis_variacionNom_Revisada_vwImpl)findViewObject("Sis_variacionNom_Revisada_vw");
    }

    /**Container's getter for SisMovimientosPlazaVw
     */
    public SisMovimientosPlazaVwImpl getSisMovimientosPlazaVw() {
        return (SisMovimientosPlazaVwImpl)findViewObject("SisMovimientosPlazaVw");
    }

    /**Container's getter for SisBeneficiario
     */
    public SisBeneficiarioImpl getSisBeneficiario() {
        return (SisBeneficiarioImpl)findViewObject("SisBeneficiario");
    }

    /**Container's getter for SisSolicitud_Beneficiario_lnk1
     */
    public ViewLinkImpl getSisSolicitud_Beneficiario_lnk1() {
        return (ViewLinkImpl)findViewLink("SisSolicitud_Beneficiario_lnk1");
    }

    /**Container's getter for sis_parentesco
     */
    public sis_parentescoImpl getsis_parentesco() {
        return (sis_parentescoImpl)findViewObject("sis_parentesco");
    }

    /**Container's getter for SisPlazaXUsuarioVw
     */
    public SisPlazaXUsuarioVwImpl getSisPlazaXUsuarioVw() {
        return (SisPlazaXUsuarioVwImpl)findViewObject("SisPlazaXUsuarioVw");
    }

    /**Container's getter for SisPartidaProvisionVw
     */
    public SisPartidaProvisionVwImpl getSisPartidaProvisionVw() {
        return (SisPartidaProvisionVwImpl)findViewObject("SisPartidaProvisionVw");
    }

    /**Container's getter for SisComplementoIgssPorEmpleadoVw
     */
    public SisComplementoIgssPorEmpleadoVwImpl getSisComplementoIgssPorEmpleadoVw() {
        return (SisComplementoIgssPorEmpleadoVwImpl)findViewObject("SisComplementoIgssPorEmpleadoVw");
    }

    /**Container's getter for SisPlazasEmpleadoComplVw
     */
    public SisPlazasEmpleadoComplVwImpl getSisPlazasEmpleadoComplVw() {
        return (SisPlazasEmpleadoComplVwImpl)findViewObject("SisPlazasEmpleadoComplVw");
    }


    /**Container's getter for SisDetCalculoAjusteVw2
     */
    public SisDetCalculoAjusteVwImpl getSisDetCalculoAjusteVw2() {
        return (SisDetCalculoAjusteVwImpl)findViewObject("SisDetCalculoAjusteVw2");
    }

    /**Container's getter for SisModNominavo_desc_lnk1
     */
    public ViewLinkImpl getSisModNominavo_desc_lnk1() {
        return (ViewLinkImpl)findViewLink("SisModNominavo_desc_lnk1");
    }

    /**Container's getter for SisMensajesRelacionadosVw
     */
    public SisMensajesRelacionadosVwImpl getSisMensajesRelacionadosVw() {
        return (SisMensajesRelacionadosVwImpl)findViewObject("SisMensajesRelacionadosVw");
    }    

    /**Container's getter for TieneAlgunPago
     */
    public TieneAlgunPagoImpl getTieneAlgunPago() {
        return (TieneAlgunPagoImpl)findViewObject("TieneAlgunPago");
    }

    /**Container's getter for SisNominasLiquidarVw
     */
    public SisNominasLiquidarVwImpl getSisNominasLiquidarVw() {
        return (SisNominasLiquidarVwImpl)findViewObject("SisNominasLiquidarVw");
    }

    /**Container's getter for SisDepsLiquidacionVw
     */
    public SisDepsLiquidacionVwImpl getSisDepsLiquidacionVw() {
        return (SisDepsLiquidacionVwImpl)findViewObject("SisDepsLiquidacionVw");
    }

    /**Container's getter for Sis_unidades_liquidacion_vw
     */
    public Sis_unidades_liquidacion_vwImpl getSis_unidades_liquidacion_vw() {
        return (Sis_unidades_liquidacion_vwImpl)findViewObject("Sis_unidades_liquidacion_vw");
    }

    /**Container's getter for SisDetplazaCubreLicVw
     */
    public SisDetplazaCubreLicVwImpl getSisDetplazaCubreLicVw() {
        return (SisDetplazaCubreLicVwImpl)findViewObject("SisDetplazaCubreLicVw");
    }

    /**Container's getter for Sis_detLic_cubrelic_lnk1
     */
    public ViewLinkImpl getSis_detLic_cubrelic_lnk1() {
        return (ViewLinkImpl)findViewLink("Sis_detLic_cubrelic_lnk1");
    }

    /**Container's getter for Sis_contratos_susp_igss_vw
     */
    public Sis_contratos_susp_igss_vwImpl getSis_contratos_susp_igss_vw() {
        return (Sis_contratos_susp_igss_vwImpl)findViewObject("Sis_contratos_susp_igss_vw");
    }

    /**Container's getter for BitacoraEventoUsuarioVw
     */
    public BitacoraEventoUsuarioVwImpl getBitacoraEventoUsuarioVw() {
        return (BitacoraEventoUsuarioVwImpl)findViewObject("BitacoraEventoUsuarioVw");
    }

    /**Container's getter for SisParametrosApp_restric_vw
     */
    public SisParametrosApp_restric_vwImpl getSisParametrosApp_restric_vw() {
        return (SisParametrosApp_restric_vwImpl)findViewObject("SisParametrosApp_restric_vw");
    }

    /**Container's getter for SisFolioLiquidacionVw
     */
    public SisFolioLiquidacionVwImpl getSisFolioLiquidacionVw() {
        return (SisFolioLiquidacionVwImpl)findViewObject("SisFolioLiquidacionVw");
    }

    /**Container's getter for Sis_liquidacion_folios_lnk1
     */
    public ViewLinkImpl getSis_liquidacion_folios_lnk1() {
        return (ViewLinkImpl)findViewLink("Sis_liquidacion_folios_lnk1");
    }

    /**Container's getter for SisAnioNominaVw
     */
    public SisAnioNominaVwImpl getSisAnioNominaVw() {
        return (SisAnioNominaVwImpl)findViewObject("SisAnioNominaVw");
    }

    /**Container's getter for SisProcesosNominaPorAnioVw1
     */
    public SisProcesosNominaPorAnioVwImpl getSisProcesosNominaPorAnioVw1() {
        return (SisProcesosNominaPorAnioVwImpl)findViewObject("SisProcesosNominaPorAnioVw1");
    }


    /**Container's getter for SisAnioProcesosNominaLnk1
     */
    public ViewLinkImpl getSisAnioProcesosNominaLnk1() {
        return (ViewLinkImpl)findViewLink("SisAnioProcesosNominaLnk1");
    }


    /**Container's getter for Sis_Procesos_revISR_vw
     */
    public Sis_Procesos_revISR_vwImpl getSis_Procesos_revISR_vw() {
        return (Sis_Procesos_revISR_vwImpl)findViewObject("Sis_Procesos_revISR_vw");
    }

    /**Container's getter for SisFolioEmisionView
     */
    public SisFolioEmisionViewImpl getSisFolioEmisionView() {
        return (SisFolioEmisionViewImpl)findViewObject("SisFolioEmisionView");
    }

    /**Container's getter for SisFolioEmisionAnuladoView
     */
    public SisFolioEmisionAnuladoViewImpl getSisFolioEmisionAnuladoView() {
        return (SisFolioEmisionAnuladoViewImpl)findViewObject("SisFolioEmisionAnuladoView");
    }

    /**Container's getter for SisFolioEmisionView_SisProcesoViewLink1
     */
    public ViewLinkImpl getSisFolioEmisionView_SisProcesoViewLink1() {
        return (ViewLinkImpl)findViewLink("SisFolioEmisionView_SisProcesoViewLink1");
    }

    /**Container's getter for SisFolioEmisionAnu_FolioEmisionViewLink1
     */
    public ViewLinkImpl getSisFolioEmisionAnu_FolioEmisionViewLink1() {
        return (ViewLinkImpl)findViewLink("SisFolioEmisionAnu_FolioEmisionViewLink1");
    }

    /**Container's getter for SisProcesosRev_audi_vw
     */
    public SisProcesosRev_audiImpl getSisProcesosRev_audi_vw() {
        return (SisProcesosRev_audiImpl)findViewObject("SisProcesosRev_audi_vw");
    }

    /**Container's getter for SisPuesto_vw
     */
    public SisPuesto_vwImpl getSisPuesto_vw() {
        return (SisPuesto_vwImpl)findViewObject("SisPuesto_vw");
    }

    /**Container's getter for SisCompleRevPendISRVw
     */
    public SisCompleRevPendISRVwImpl getSisCompleRevPendISRVw() {
        return (SisCompleRevPendISRVwImpl)findViewObject("SisCompleRevPendISRVw");
    }

    /**Container's getter for SisProcesosRev_audiDep_vw
     */
    public SisProcesosRev_audiDep_vwImpl getSisProcesosRev_audiDep_vw() {
        return (SisProcesosRev_audiDep_vwImpl)findViewObject("SisProcesosRev_audiDep_vw");
    }

    /**Container's getter for sis_fallecimiento_consul_vw
     */
    public sis_fallecimiento_consulImpl getsis_fallecimiento_consul_vw() {
        return (sis_fallecimiento_consulImpl)findViewObject("sis_fallecimiento_consul_vw");
    }

    /**Container's getter for SisComplementoPlazaVac_vw
     */
    public SisComplementoPlazaVac_vwImpl getSisComplementoPlazaVac_vw() {
        return (SisComplementoPlazaVac_vwImpl)findViewObject("SisComplementoPlazaVac_vw");
    }
    
    /**Container's getter for consul_alzaNom_anexo1
     */
    public consul_alzaNom_anexoImpl getconsul_alzaNom_anexo1() {
        return (consul_alzaNom_anexoImpl)findViewObject("consul_alzaNom_anexo1");
    }

    /**Container's getter for sis_cuenta_actual_vw
     */
    public sis_cuenta_actual_vwImpl getsis_cuenta_actual_vw() {
        return (sis_cuenta_actual_vwImpl)findViewObject("sis_cuenta_actual_vw");
    }

    /**Container's getter for ListadoPlazasXUniDep
     */
    public ListadoPlazasXUniDepImpl getListadoPlazasXUniDep() {
        return (ListadoPlazasXUniDepImpl)findViewObject("ListadoPlazasXUniDep");
    }

    /**Container's getter for SisTipoProcesoTrab_vw
     */
    public SisTipoProcesoTrab_vwImpl getSisTipoProcesoTrab_vw() {
        return (SisTipoProcesoTrab_vwImpl)findViewObject("SisTipoProcesoTrab_vw");
    }

    /**Container's getter for SisProcesosNominaPorAnio2_Vw1
     */
    public SisProcesosNominaPorAnio2_VwImpl getSisProcesosNominaPorAnio2_Vw1() {
        return (SisProcesosNominaPorAnio2_VwImpl)findViewObject("SisProcesosNominaPorAnio2_Vw1");
    }

    /**Container's getter for SisAnioProcesosNominaNomina2Lnk1
     */
    public ViewLinkImpl getSisAnioProcesosNominaNomina2Lnk1() {
        return (ViewLinkImpl)findViewLink("SisAnioProcesosNominaNomina2Lnk1");
    }

    /**Container's getter for Sis_formsis24_vw
     */
    public Sis_formsis24_vwImpl getSis_formsis24_vw() {
        return (Sis_formsis24_vwImpl)findViewObject("Sis_formsis24_vw");
    }

    /**Container's getter for SisFormsis24_rev_vw
     */
    public SisFormsis24_rev_vwImpl getSisFormsis24_rev_vw() {
        return (SisFormsis24_rev_vwImpl)findViewObject("SisFormsis24_rev_vw");
    }

    /**Container's getter for ListadoTipoNomina
     */
    public ListadoTipoNominaImpl getListadoTipoNomina() {
        return (ListadoTipoNominaImpl)findViewObject("ListadoTipoNomina");
    }

    /**Container's getter for Sis_tiposerv_puesto_vw
     */
    public Sis_tiposerv_puesto_vwImpl getSis_tiposerv_puesto_vw() {
        return (Sis_tiposerv_puesto_vwImpl)findViewObject("Sis_tiposerv_puesto_vw");
    }

    /**Container's getter for Sis_firmas_docs_regper_vw
     */
    public Sis_firmas_docs_regper_vwImpl getSis_firmas_docs_regper_vw() {
        return (Sis_firmas_docs_regper_vwImpl)findViewObject("Sis_firmas_docs_regper_vw");
    }

    /**Container's getter for Sis_remesa_vw
     */
    public Sis_remesaImpl getSis_remesa_vw() {
        return (Sis_remesaImpl)findViewObject("Sis_remesa_vw");
    }

    /**Container's getter for SisDeduccionIsr2Vw
     */
    public SisDeduccionIsr2VwImpl getSisDeduccionIsr2Vw() {
        return (SisDeduccionIsr2VwImpl)findViewObject("SisDeduccionIsr2Vw");
    }

    /**Container's getter for SisAjusteExcludEmpleadoVw
     */
    public SisAjusteExcludEmpleadoVwImpl getSisAjusteExcludEmpleadoVw() {
        return (SisAjusteExcludEmpleadoVwImpl)findViewObject("SisAjusteExcludEmpleadoVw");
    }

    /**Container's getter for SisDeduccionIsrOtrPat_vw
     */
    public SisDeduccionIsrOtrPat_vwImpl getSisDeduccionIsrOtrPat_vw() {
        return (SisDeduccionIsrOtrPat_vwImpl)findViewObject("SisDeduccionIsrOtrPat_vw");
    }

    /**Container's getter for SisVacacionEmpleadoVw
     */
    public SisVacacionEmpleadoVwImpl getSisVacacionEmpleadoVw() {
        return (SisVacacionEmpleadoVwImpl)findViewObject("SisVacacionEmpleadoVw");
    }

    /**Container's getter for sis_timbres_empl_vw
     */
    public sis_timbres_empl_vwImpl getsis_timbres_empl_vw() {
        return (sis_timbres_empl_vwImpl)findViewObject("sis_timbres_empl_vw");
    }

    /**Container's getter for Sis_historial_salarial_Isr
     */
    public Sis_historial_salarial_IsrImpl getSis_historial_salarial_Isr() {
        return (Sis_historial_salarial_IsrImpl)findViewObject("Sis_historial_salarial_Isr");
    }

    /**Container's getter for consul_empl_bibliovw1
     */
    public consul_empl_bibliovwImpl getconsul_empl_bibliovw1() {
        return (consul_empl_bibliovwImpl)findViewObject("consul_empl_bibliovw1");
    }

    /**Container's getter for SisPartProv_devnopag_vw
     */
    public SisPartProv_devnopag_vwImpl getSisPartProv_devnopag_vw() {
        return (SisPartProv_devnopag_vwImpl)findViewObject("SisPartProv_devnopag_vw");
    }

    /**Container's getter for Sis_CompleRevisadosISR_vw
     */
    public Sis_CompleRevisadosISR_vwImpl getSis_CompleRevisadosISR_vw() {
        return (Sis_CompleRevisadosISR_vwImpl)findViewObject("Sis_CompleRevisadosISR_vw");
    }

    /**Container's getter for SisConciliacionAcreditVw
     */
    public SisConciliacionAcreditVwImpl getSisConciliacionAcreditVw() {
        return (SisConciliacionAcreditVwImpl)findViewObject("SisConciliacionAcreditVw");
    }

    /**Container's getter for SisProcesoConciliacionVw
     */
    public SisProcesoConciliacionVwImpl getSisProcesoConciliacionVw() {
        return (SisProcesoConciliacionVwImpl)findViewObject("SisProcesoConciliacionVw");
    }

    /**Container's getter for Sis_Solicitud_rev_vw
     */
    public Sis_Solicitud_rev_vwImpl getSis_Solicitud_rev_vw() {
        return (Sis_Solicitud_rev_vwImpl)findViewObject("Sis_Solicitud_rev_vw");
    }

    /**Container's getter for SisPlazaComentarioVw
     */
    public SisPlazaComentarioVwImpl getSisPlazaComentarioVw() {
        return (SisPlazaComentarioVwImpl)findViewObject("SisPlazaComentarioVw");
    }

    /**Container's getter for SisPlazaxUsuarioEmpl_vw
     */
    public SisPlazaxUsuarioEmpl_vwImpl getSisPlazaxUsuarioEmpl_vw() {
        return (SisPlazaxUsuarioEmpl_vwImpl)findViewObject("SisPlazaxUsuarioEmpl_vw");
    }

    /**Container's getter for sis_retiro_obligatorio_consul1
     */
    public sis_retiro_obligatorio_consulImpl getsis_retiro_obligatorio_consul1() {
        return (sis_retiro_obligatorio_consulImpl)findViewObject("sis_retiro_obligatorio_consul1");
    }

    /**Container's getter for ListadoPrestxRetPorEmpleado
    */
    public ListadoPrestxRetPorEmpleadoImpl getListadoPrestxRetPorEmpleado() {
        return (ListadoPrestxRetPorEmpleadoImpl)findViewObject("ListadoPrestxRetPorEmpleado");
    }

    /**Container's getter for sis_mod_nomina_vw1
     */
    public sis_mod_nomina_vwImpl getsis_mod_nomina_vw1() {
        return (sis_mod_nomina_vwImpl)findViewObject("sis_mod_nomina_vw1");
    }

    /**Container's getter for rpt_liquidacion_auditor
     */
    public rpt_liquidacion_auditorImpl getrpt_liquidacion_auditor() {
        return (rpt_liquidacion_auditorImpl)findViewObject("rpt_liquidacion_auditor");
    }

    /**Container's getter for rpt_control_plaza1
     */
    public rpt_control_plazaImpl getrpt_control_plaza1() {
        return (rpt_control_plazaImpl)findViewObject("rpt_control_plaza1");
    }
    
    /**Container's getter for SisContrato_byRegAnio1
     */
    public SisContrato_byRegAnioImpl getSisContrato_byRegAnio1() {
        return (SisContrato_byRegAnioImpl)findViewObject("SisContrato_byRegAnio1");
    }

    /**Container's getter for SisHistActaHorarioContratoVw1
     */
    public SisHistActaHorarioContratoVwImpl getSisHistActaHorarioContratoVw1() {
        return (SisHistActaHorarioContratoVwImpl)findViewObject("SisHistActaHorarioContratoVw1");
    }

    /**Container's getter for consul_cheque_reintegro1
     */
    public consul_cheque_reintegroImpl getconsul_cheque_reintegro1() {
        return (consul_cheque_reintegroImpl)findViewObject("consul_cheque_reintegro1");
    }

    /**Container's getter for sis_reintegro_vw1
     */
    public sis_reintegro_vwImpl getsis_reintegro_vw1() {
        return (sis_reintegro_vwImpl)findViewObject("sis_reintegro_vw1");
    }

    /**Container's getter for SisDetalleReintegroVw1
     */
    public SisDetalleReintegroVwImpl getSisDetalleReintegroVw1() {
        return (SisDetalleReintegroVwImpl)findViewObject("SisDetalleReintegroVw1");
    }

    /**Container's getter for SisDescuentoReintegroVw1
     */
    public SisDescuentoReintegroVwImpl getSisDescuentoReintegroVw1() {
        return (SisDescuentoReintegroVwImpl)findViewObject("SisDescuentoReintegroVw1");
    }

    /**Container's getter for SisReintegroEmpVw1
     */
    public SisReintegroEmpVwImpl getSisReintegroEmpVw1() {
        return (SisReintegroEmpVwImpl)findViewObject("SisReintegroEmpVw1");
    }

    /**Container's getter for SisSolDescJud1
     */
    public SisSolDescJudImpl getSisSolDescJud1() {
        return (SisSolDescJudImpl)findViewObject("SisSolDescJud1");
    }

    /**Container's getter for SisComplementoPorIdVw1
     */
    public SisComplementoPorIdVwImpl getSisComplementoPorIdVw1() {
        return (SisComplementoPorIdVwImpl)findViewObject("SisComplementoPorIdVw1");
    }

    /**Container's getter for Sis_foto_empleado_vw1
     */
    public Sis_foto_empleado_vwImpl getSis_foto_empleado_vw1() {
        return (Sis_foto_empleado_vwImpl)findViewObject("Sis_foto_empleado_vw1");
    }

    /**Container's getter for Sis_list_referencias_empleado_ficha_vw
     */
    public Sis_list_referencias_empleado_fichaImpl getSis_list_referencias_empleado_ficha_vw() {
        return (Sis_list_referencias_empleado_fichaImpl)findViewObject("Sis_list_referencias_empleado_ficha_vw");
    }

    /**Container's getter for Sis_experiencia_profesional1
     */
    public Sis_experiencia_profesionalImpl getSis_experiencia_profesional1() {
        return (Sis_experiencia_profesionalImpl)findViewObject("Sis_experiencia_profesional1");
    }

    /**Container's getter for Sis_documento_adjunto_vw1
     */
    public Sis_documento_adjunto_vwImpl getSis_documento_adjunto_vw1() {
        return (Sis_documento_adjunto_vwImpl)findViewObject("Sis_documento_adjunto_vw1");
    }

    /**Container's getter for Sis_tipo_archivo_adjunto_vw1
     */
    public Sis_tipo_archivo_adjunto_vwImpl getSis_tipo_archivo_adjunto_vw1() {
        return (Sis_tipo_archivo_adjunto_vwImpl)findViewObject("Sis_tipo_archivo_adjunto_vw1");
    }

    /**Container's getter for rpt_reintegrosVw
     */
    public rpt_reintegrosImpl getrpt_reintegrosVw() {
        return (rpt_reintegrosImpl)findViewObject("rpt_reintegrosVw");
    }

    /**Container's getter for Sis_ficha_empleado_consulta_vw1
     */
    public Sis_ficha_empleado_consulta_vwImpl getSis_ficha_empleado_consulta_vw1() {
        return (Sis_ficha_empleado_consulta_vwImpl)findViewObject("Sis_ficha_empleado_consulta_vw1");
    }

    /**Container's getter for consul_reintegros_vw1
     */
    public consul_reintegros_vwImpl getconsul_reintegros_vw1() {
        return (consul_reintegros_vwImpl)findViewObject("consul_reintegros_vw1");
    }

    /**Container's getter for sis_reintegros1
     */
    public sis_reintegrosImpl getsis_reintegros1() {
        return (sis_reintegrosImpl)findViewObject("sis_reintegros1");
    }

    /**Container's getter for Sis_documento_adj_especifico_vw1
     */
    public Sis_documento_adj_especifico_vwImpl getSis_documento_adj_especifico_vw1() {
        return (Sis_documento_adj_especifico_vwImpl)findViewObject("Sis_documento_adj_especifico_vw1");
    }


    /**Container's getter for SisContrato031vw1
     */
    public SisContrato031vwImpl getSisContrato031vw1() {
        return (SisContrato031vwImpl)findViewObject("SisContrato031vw1");
    }

    /**Container's getter for SisEmpl_Contrato031_link1
     */
    public ViewLinkImpl getSisEmpl_Contrato031_link1() {
        return (ViewLinkImpl)findViewLink("SisEmpl_Contrato031_link1");
    }

    /**Container's getter for SisPartida031_vw
     */
    public SisPartida031_vwImpl getSisPartida031_vw() {
        return (SisPartida031_vwImpl)findViewObject("SisPartida031_vw");
    }

    /**Container's getter for SisIsrproy031vw
     */
    public SisIsrproy031vwImpl getSisIsrproy031vw() {
        return (SisIsrproy031vwImpl)findViewObject("SisIsrproy031vw");
    }

    /**Container's getter for SisIsrproyDetvw
     */
    public SisIsrproyDetvwImpl getSisIsrproyDetvw() {
        return (SisIsrproyDetvwImpl)findViewObject("SisIsrproyDetvw");
    }

    /**Container's getter for SisISR31_ISRDet_lnk1
     */
    public ViewLinkImpl getSisISR31_ISRDet_lnk1() {
        return (ViewLinkImpl)findViewLink("SisISR31_ISRDet_lnk1");
    }

    /**Container's getter for SisIsrproyDetDesc_vw
     */
    public SisIsrproyDetDesc_vwImpl getSisIsrproyDetDesc_vw() {
        return (SisIsrproyDetDesc_vwImpl)findViewObject("SisIsrproyDetDesc_vw");
    }

    /**Container's getter for SisIsrProy_DetDesc_lnk1
     */
    public ViewLinkImpl getSisIsrProy_DetDesc_lnk1() {
        return (ViewLinkImpl)findViewLink("SisIsrProy_DetDesc_lnk1");
    }

    /**Container's getter for SisIndemnizacion_vw
     */
    public SisIndemnizacion_vwImpl getSisIndemnizacion_vw() {
        return (SisIndemnizacion_vwImpl)findViewObject("SisIndemnizacion_vw");
    }

    /**Container's getter for SisTipoIndemnizacion_vw
     */
    public SisTipoIndemnizacion_vwImpl getSisTipoIndemnizacion_vw() {
        return (SisTipoIndemnizacion_vwImpl)findViewObject("SisTipoIndemnizacion_vw");
    }

    /**Container's getter for ContratosParaTE031_vw
     */
    public ContratosParaTE031_vwImpl getContratosParaTE031_vw() {
        return (ContratosParaTE031_vwImpl)findViewObject("ContratosParaTE031_vw");
    }

    /**Container's getter for ContratosParaTE031Lista_vw
     */
    public ContratosParaTE031Lista_vwImpl getContratosParaTE031Lista_vw() {
        return (ContratosParaTE031Lista_vwImpl)findViewObject("ContratosParaTE031Lista_vw");
    }

    /**Container's getter for SisHistorialSalarialIndemnizacion_vw
     */
    public SisHistorialSalarialIndemnizacion_vwImpl getSisHistorialSalarialIndemnizacion_vw() {
        return (SisHistorialSalarialIndemnizacion_vwImpl)findViewObject("SisHistorialSalarialIndemnizacion_vw");
    }

    /**Container's getter for paisOrigen
     */
    public ViewObjectImpl getpaisOrigen() {
        return (ViewObjectImpl)findViewObject("paisOrigen");
    }

    /**Container's getter for SisGrupoEtnicoVw
     */
    public SisGrupoEtnicoVwImpl getSisGrupoEtnicoVw() {
        return (SisGrupoEtnicoVwImpl)findViewObject("SisGrupoEtnicoVw");
    }

    /**Container's getter for plazasParaMapear
     * 
     */
    public plazasParaMapearImpl getplazasParaMapear() {
        return (plazasParaMapearImpl)findViewObject("plazasParaMapear");
    }

    /**Container's getter for partidasSICOIN
     */
    public partidasSICOINImpl getpartidasSICOIN() {
        return (partidasSICOINImpl)findViewObject("partidasSICOIN");
    }

    /**Container's getter for SisMovPlaza_Anexo1
     */
    public SisMovPlaza_AnexoImpl getSisMovPlaza_Anexo1() {
        return (SisMovPlaza_AnexoImpl)findViewObject("SisMovPlaza_Anexo1");
    }

    /**Container's getter for consul_partidaSICOIN_vw1
     */
    public consul_partidaSICOIN_vwImpl getconsul_partidaSICOIN_vw1() {
        return (consul_partidaSICOIN_vwImpl)findViewObject("consul_partidaSICOIN_vw1");
    }

    /**Container's getter for SicoinPartidaEgresosView1
     */
    public SicoinPartidaEgresosViewImpl getSicoinPartidaEgresosView1() {
        return (SicoinPartidaEgresosViewImpl)findViewObject("SicoinPartidaEgresosView1");
    }

    /**Container's getter for sis_beneficiario_cta_actual_vw
     */
    public sis_beneficiario_cta_actual_vwImpl getsis_beneficiario_cta_actual_vw() {
        return (sis_beneficiario_cta_actual_vwImpl)findViewObject("sis_beneficiario_cta_actual_vw");
    }

    /**Container's getter for SisPartidavw
     */
    public SisPartidavwImpl getSisPartidavw() {
        return (SisPartidavwImpl)findViewObject("SisPartidavw");
    }

    /**Container's getter for SaldoAnualvw
     */
    public SaldoAnualvwImpl getSaldoAnualvw() {
        return (SaldoAnualvwImpl)findViewObject("SaldoAnualvw");
    }

    /**Container's getter for SisTransferencia_vw
     */
    public SisTransferencia_vwImpl getSisTransferencia_vw() {
        return (SisTransferencia_vwImpl)findViewObject("SisTransferencia_vw");
    }

    /**Container's getter for NominasXProceso1
     */
    public NominasXProcesoImpl getNominasXProceso1() {
        return (NominasXProcesoImpl)findViewObject("NominasXProceso1");
    }

    /**Container's getter for SisRelacionLaboral_vw1
     */
    public SisRelacionLaboral_vwImpl getSisRelacionLaboral_vw1() {
        return (SisRelacionLaboral_vwImpl)findViewObject("SisRelacionLaboral_vw1");
    }

    /**Container's getter for sis_solBajaLaboralvw
     */
    public sis_solBajaLaboralvwImpl getsis_solBajaLaboralvw() {
        return (sis_solBajaLaboralvwImpl)findViewObject("sis_solBajaLaboralvw");
    }
    
    /**Container's getter for SisPostMortem_vw1
     */
    public SisPostMortem_vwImpl getSisPostMortem_vw1() {
        return (SisPostMortem_vwImpl)findViewObject("SisPostMortem_vw1");
    }

    /**Container's getter for SisSolicitudesRenunciaIndem_vw1
     */
    public SisSolicitudesRenunciaIndem_vwImpl getSisSolicitudesRenunciaIndem_vw1() {
        return (SisSolicitudesRenunciaIndem_vwImpl)findViewObject("SisSolicitudesRenunciaIndem_vw1");
    }
}
