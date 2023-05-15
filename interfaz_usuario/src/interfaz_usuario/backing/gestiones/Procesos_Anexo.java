package interfaz_usuario.backing.gestiones;

import enlace_datos.consultas.gestiones.anexo.sis_movimiento_plazaRowImpl;

import enlace_datos.consultas.gestiones.contrato.unidades_ejecRowImpl;

import enlace_datos.util.resulOp;

import interfaz_usuario.backing.util.util_dialog_adf;

import interfaz_usuario.usuario;

import interfaz_usuario.util.JSFUtils;

import interfaz_usuario.util.utils;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.text.DecimalFormat;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.faces.component.core.input.CoreInputText;
import oracle.adf.view.faces.component.core.input.CoreSelectInputDate;
import oracle.adf.view.faces.component.core.input.CoreSelectOneChoice;
import oracle.adf.view.faces.component.core.layout.CorePanelForm;
import oracle.adf.view.faces.component.core.nav.CoreCommandButton;

import oracle.adf.view.faces.event.LaunchEvent;
import oracle.adf.view.faces.event.ReturnEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.domain.Date;

import oracle.jbo.uicli.binding.JUIteratorBinding;

import pkg_util_base_datos.interfaz_DB;

public class Procesos_Anexo {
    private CoreSelectOneChoice tipOperacion;
    private CoreInputText plaza1;
    private CoreInputText correlativo;
    private CoreSelectOneChoice listPlaza;
    private CoreInputText horas;
    private CoreInputText sueldoBase;
    private CoreInputText escalafon;
    private CoreInputText complemenSalarial;
    private CoreSelectOneChoice listPuesto;
    private CoreInputText puesto;
    private CoreInputText escalaMin;
    private BindingContainer bindings;
    private CoreInputText varMinimo;
    private CoreCommandButton botonGuardar;
    private CoreCommandButton botonReporte;
    private CoreCommandButton botonEjecutar;
    private CoreCommandButton botonCrear;
    private CoreSelectOneChoice listPeriodo;
    public boolean selecUnidad = false;
    private boolean vCambioPartida = false;
    public boolean change_partida = false;
    private CoreSelectOneChoice listPartida;
    private CoreInputText numPartida;
    private CoreCommandButton botonRegresar;
    private CoreCommandButton botonAnexo_autorizar;
    private CoreInputText dictamen;
    private CoreInputText nombrePlaza;
    private CorePanelForm formDetalle;
    private CoreSelectOneChoice lisTipDoc;
    private CoreSelectOneChoice lisDependencia;
    private CoreSelectOneChoice listUnidad;
    private CoreSelectInputDate fecha_inicio;
    private CoreSelectInputDate fecha_fin;
    private CoreInputText regEmpleado;
    private CoreInputText facTiempo;
    private CoreInputText dictamenNumero;
    private CoreInputText dictamenAnio;
    private CoreSelectOneChoice dictamenEmitido;
    private CoreSelectOneChoice listPuestoEscala;
    private CoreInputText varMinEscalaf;
    private CoreSelectOneChoice partidaSicoin;

    public Procesos_Anexo() {
        // selecUnidad = false;
    }

    public void Operaciones(ValueChangeEvent valueChangeEvent) {
        if (tipOperacion.getValue().equals("A")) {
            //partidaSicoin.setDisabled(false);    //Se deshabilita por NO continuar SICOIN
        } else if (tipOperacion.getValue().equals("B")) {
            partidaSicoin.setDisabled(true);
        }

    }

    public void ValoresPlaza(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        //System.out.println("valor Combo"+tipOperacion.getValue());
        //System.out.println("valor de la partida" + listPartida.getValue());

        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                    "#{bindings.comboPartida1.inputValue}", 
                                    new Integer(1));
        if (tipOperacion.getValue().equals("A")) {
            if (valueChangeEvent.getOldValue() != 
                valueChangeEvent.getNewValue()) {
                //System.out.println("Cambio valor de combo");
                vCambioPartida = true;
            }

            horas.setDisabled(false);
            //correlativo.setDisabled(false);
            sueldoBase.setDisabled(false);
            escalafon.setDisabled(false);
            complemenSalarial.setDisabled(false);
            plaza1.setDisabled(false);
            //listPlaza.setRendered(false);
            puesto.setDisabled(false);
            //listPlaza.setDisabled(true);
            //dictamen.setDisabled(false);
            //nombrePlaza.setDisabled(false);
            dictamen.setDisabled(false);
            nombrePlaza.setDisabled(false);
            regEmpleado.setDisabled(false);
            // dictamen.setRendered(true);
            // nombrePlaza.setRendered(true);

            horas.setPartialTriggers(new String[] { });
            //correlativo.setPartialTriggers(new String[]{});
            // sueldoBase.setPartialTriggers(new String[]{"codPuesto"});
            escalafon.setPartialTriggers(new String[] { });
            complemenSalarial.setPartialTriggers(new String[] { });
            sueldoBase.setPartialTriggers(new String[] { });
            correlativo.setPartialTriggers(new String[] { "codPuesto","lisPartida" });
            correlativo.setPartialTriggers(new String[] { "codPuesto" });
            plaza1.setPartialTriggers(new String[] { "codPuesto", "lisPartida" });
            puesto.setPartialTriggers(new String[] { "codPuesto" });
            //partidaSicoin.setPartialTriggers(new String[]{"lisPartida"});

            horas.setValue("");
            //correlativo.setValue("");
            sueldoBase.setValue("");
            //escalafon.setValue("");
            // complemenSalarial.setValue("");
            horas.setValue("");
            correlativo.setSubmittedValue(null);
            correlativo.setValue(null);
            plaza1.setSubmittedValue(null);
            plaza1.setValue(0);
            //listPlaza.setRendered(false);
            listPuesto.setDisabled(false);

            listPlaza.setDisabled(true);
            listPeriodo.setDisabled(false);
            // System.out.println("toy en el mero2 " + tipOperacion.getValue());
        } else if (tipOperacion.getValue().equals("B")) {
            //dictamen.setPartialTriggers(new String[]{});
            //nombrePlaza.setPartialTriggers(new String[]{});
            horas.setPartialTriggers(new String[] { "valorPlaza" });
            correlativo.setPartialTriggers(new String[] { "valorPlaza" });
            sueldoBase.setPartialTriggers(new String[] { "valorPlaza" });
            escalafon.setPartialTriggers(new String[] { "valorPlaza" });
            complemenSalarial.setPartialTriggers(new String[] { "valorPlaza" });
            plaza1.setPartialTriggers(new String[] { "valorPlaza" });
            puesto.setPartialTriggers(new String[] { "valorPlaza" });
            listPlaza.setDisabled(false);
            listPeriodo.setDisabled(true);
            listPuesto.setDisabled(true);
            dictamen.setDisabled(true);
            nombrePlaza.setDisabled(true);
            this.plaza1.setDisabled(true);

            // regEmpleado.setDisabled(true);
            // dictamen.setRendered(false);
            //nombrePlaza.setRendered(false);

            // listPlaza.setRendered(true);
            // horas.setDisabled(true);
            //System.out.println("toy en el mero1 " + tipOperacion.getValue());
        }
    }

    public void setTipOperacion(CoreSelectOneChoice tipOperacion) {
        Object valuar;
        this.tipOperacion = tipOperacion;
        /* valuar = tipOperacion;
        if (valuar.equals("A")){

            listPlaza.setRendered(false);
        }
         */
        //System.out.println("tipo operacion" + tipOperacion.getLabel());

    }

    public CoreSelectOneChoice getTipOperacion() {
        return tipOperacion;
    }

    public void asigValorPlaza(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        /*
        Object controlValor = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.Correlativo1.inputValue}");
        correlativo.setSubmittedValue(null);
        correlativo.setValue(controlValor);
        controlValor =JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.consul_sisPlaza_vw1Iterator.currentRow['escalafon']}");
        escalafon.setSubmittedValue(null);
        escalafon.setValue(controlValor);
        //sueldoBase.setValue(JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.SalarioBase.inputValue}"));
        horas.setSubmittedValue(null);
        //horas.setValue(JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.consul_sisPlaza_vw1Iterator.currentRow['cantidadHoras']}"));
        sueldoBase.setSubmittedValue(null);
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.SueldoBase.inputValue}",JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.consul_sisPlaza_vw1Iterator.currentRow['salarioBase']}"));
        complemenSalarial.setSubmittedValue(null);
        complemenSalarial.setValue(JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.ComplementoSal.inputValue}"));
        System.out.println("valores plaza " + complemenSalarial.getValue() );
        System.out.println("valores plaza  " + horas.getValue());
        System.out.println("valores plaza  " + correlativo.getValue());
        System.out.println("valores plaza  " + escalafon.getValue());
        System.out.println("valores plaza  " + sueldoBase.getValue());
*/
        /* if (tipOperacion.getValue().equals("A")){

            horas.setDisabled(false);
            correlativo.setDisabled(false);
            sueldoBase.setDisabled(false);
            escalafon.setDisabled(false);
            complemenSalarial.setDisabled(false);
            plaza1.setDisabled(false);
            listPlaza.setRendered(false);
            System.out.println("habilite para escritura " + tipOperacion.getValue());
        }
        else*/if (tipOperacion.getValue().equals("B")) {

            horas.setDisabled(true);
            //correlativo.setDisabled(true);
            sueldoBase.setDisabled(true);
            escalafon.setDisabled(true);
            complemenSalarial.setDisabled(true);
            plaza1.setDisabled(true);
            listPeriodo.setDisabled(true);
            dictamen.setDisabled(true);
            nombrePlaza.setDisabled(true);
            //regEmpleado.setDisabled(true);

        }

    }

    public void setPlaza1(CoreInputText plaza1) {
        this.plaza1 = plaza1;

    }

    public CoreInputText getPlaza1() {
        return plaza1;
    }

    public void setCorrelativo(CoreInputText correlativo) {
        this.correlativo = correlativo;
    }

    public CoreInputText getCorrelativo() {
        return correlativo;
    }

    public void setListPlaza(CoreSelectOneChoice listPlaza) {
        this.listPlaza = listPlaza;
        //System.out.println("set lista_plaza");
    }

    public CoreSelectOneChoice getListPlaza() {
        //System.out.println("get lista_plaza");
        return listPlaza;
    }

    public void setHoras(CoreInputText horas) {
        this.horas = horas;
    }

    public CoreInputText getHoras() {
        return horas;
    }

    public void setSueldoBase(CoreInputText sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public CoreInputText getSueldoBase() {
        return sueldoBase;
    }

    public void setEscalafon(CoreInputText escalafon) {
        this.escalafon = escalafon;
    }

    public CoreInputText getEscalafon() {
        return escalafon;
    }

    public void setComplemenSalarial(CoreInputText complemenSalarial) {
        this.complemenSalarial = complemenSalarial;
    }

    public CoreInputText getComplemenSalarial() {
        return complemenSalarial;
    }

    public String btn_commit() {

        Double sueldo;
        Double hor;

        DecimalFormat redondear = new DecimalFormat("0.00");
        Object varsueldo;
        //verificando que no este en blaco la fecha inicio y la fecha fin 
        if ((fecha_inicio.getValue() == null || (fecha_inicio.getValue() != null && fecha_inicio.getValue().equals(""))) || 
            (fecha_fin.getValue() == null) || (fecha_fin.getValue() != null && fecha_fin.getValue().equals(""))) {
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR, "DEBE INGRESAR LAS FECHAS CORRESPONDIENTES"));
            return null;
        }

        if (this.tipOperacion.getValue().equals("A") && this.listPuesto.getValue() == null) {
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR, "DEBE SELECCIONAR EL PUESTO"));
            return null;
        }

        if (this.tipOperacion.getValue().equals("A")) { //el anexo es para el plan de investigacion debe seleccionar la escala salarial aplicar
            interfaz_DB interfaz = new interfaz_DB();
            String Consulta = 
                "select id_programa from sis_partida where id_partida =  " + 
                utils.getNumberOracle(this.numPartida.getValue());

            Object varPlan = interfaz.getValorConsultaSimple("id_programa", Consulta);
            interfaz.cn_Cerrar_coneccion();

            if ((varPlan.toString().trim().equals("48") || varPlan.toString().trim().equals("49")) && this.listPuestoEscala.getValue() == null) {
                utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR, "DEBE SELECCIONAR LA ESCALA SALARIAL PARA EL PUESTO"));
                return null;
            }
        }

        /* *********************************************************************/
        //Este bloque es para verificar que se haya seleccionado la partida SICOIN
        //Se comenta por NO continuar SICOIN, fecha modificación 13/01/2022
        /*if (this.tipOperacion.getValue().equals("A")) {
            Object cmbPartidaSicoin = this.partidaSicoin.getValue();
            
            if (cmbPartidaSicoin == null) {
                utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR, "Debe seleccionar una PARTIDA DE SICOIN"));
                return null;
            }
        }*/
        /* *********************************************************************/

        // calculo el sueldo de la plaza nueva de acuerdo a la escala minima
        if (tipOperacion.getValue().equals("A") && varMinimo.getValue() != null) {
            //Object varsueldo = varMinimo.getValue();
            // Integer sueldo =  Integer.parseInt(varsueldo.toString().trim());
            interfaz_DB interfaz = new interfaz_DB();
            String Consulta = 
                "select id_programa from sis_partida where id_partida =  " + 
                utils.getNumberOracle(this.numPartida.getValue());

            Object varPlan = interfaz.getValorConsultaSimple("id_programa", Consulta);
            interfaz.cn_Cerrar_coneccion();

            sueldo = new Double(varMinimo.getValue().toString().trim());

            if (varPlan.toString().trim().equals("48") || varPlan.toString().trim().equals("49")) {
                if (this.varMinEscalaf.getValue() != null) {
                    sueldo = sueldo + new Double(this.varMinEscalaf.getValue().toString().trim());
                    //System.out.println("el sueldo es 22 "+sueldo);
                }
            }

            //sueldo.valueOf( );
            // sueldo = (double)varMinimo.getValue();
            //calcula el sueldo base si la escala minima es mayor a 0
            //System.out.println("esto tiene sueldo" + sueldoBase.getValue());
            if (sueldo > 0) {
                //System.out.println("entre al ifff uuuuuuu");

                if (horas.getValue() == null) { //fue ingresada la cantidad de horas
                    utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR, "DEBE INGRESAR UNA CANTIDAD DE HORAS"));
                    botonEjecutar.setDisabled(false);
                    botonGuardar.setDisabled(true);
                    botonCrear.setDisabled(true);
                    return null;
                    // throw new JboException("DEBE INGRESAR UNA CANTIDAD DE HORAS");
                } else {
                    //Object varhora = horas.getValue();
                    //Integer hor = Integer.parseInt(varhora.toString().trim());
                    hor = new Double(horas.getValue().toString().trim());
                    sueldo = sueldo.doubleValue() * hor.doubleValue();
                    varsueldo = redondear.format(sueldo.doubleValue());
                    sueldoBase.setSubmittedValue(null);
                    sueldoBase.setValue(varsueldo);

                    JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                                "#{bindings.SueldoBase.inputValue}", 
                                                utils.getNumberOracle(varsueldo));
                    sis_movimiento_plazaRowImpl varMovimiento = 
                        (sis_movimiento_plazaRowImpl)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                                                                "#{bindings.sis_movimiento_plaza1Iterator.currentRow}");
                    varMovimiento.setSueldoBase(utils.getNumberOracle(varsueldo));

                    botonGuardar.setDisabled(false);

                    botonCrear.setDisabled(false);
                    sueldoBase.setPartialTriggers(new String[] { });
                    botonEjecutar.setDisabled(true);
                    // System.out.println("imprimiendoo execute con " + sueldo);
                }
            } else { //el puesto tiene escala minima = 0
                utils.setADFMensaje(new resulOp(resulOp.OPE_WARN, 
                                                "EL PUESTO SELECCIONADO TIENE 0 EN ESCALA SALARIAL, EL SUELDO BASE ES EL INGRESADO"));
                botonEjecutar.setDisabled(true);
                botonGuardar.setDisabled(false);
                botonCrear.setDisabled(false);
                //return null;
            }

            //utils.getFechaOracle(this.fecha_inicio.getValue().toString()).compareTo(utils.getFechaOracle(this.fecha_fin.getValue().toString()));
        } else if (tipOperacion.getValue().equals("B")) { //bajaremos una plaza
            interfaz_DB interfaz = new interfaz_DB();
            Double complemento;
            Double escalafon;
            //Double horaPlaza ;
            Object varComplemento = 0;
            Object varEscalafon = 0;
            /*
            String consulta = "select cont.ID_CONTRATO from sis_contrato cont\n" +
            "where cont.ID_PARTIDA = " +utils.getNumberOracle(this.numPartida.getValue()) +
            "and cont.NUMERO_PLAZA = "+utils.getNumberOracle(this.plaza1.getValue())  +
            "and cont.ID_PUESTO = " +utils.getNumberOracle(this.puesto.getValue()) +
            "and cont.CORRELATIVO = to_number(to_char(sysdate,'yyyy'))";
            Object contrato = interfaz.getValorConsultaSimple("id_contrato",consulta );//buscando licencias parciales sobre la baja
            */
            //System.out.println("LA FECHA ES "+ this.fecha_inicio.getValue().toString().trim());
            //System.out.println("LA FECHA  "+ this.fecha_inicio.getValue());
            //System.out.println("LA clase es  "+ this.fecha_inicio.getValue().getClass());
            String consulta =
                //+" and to_date('"+ utils.getFechaFormato("dd/MM/yyyy", utils.getFechaOracle(this.fecha_inicio.getValue().toString().trim()))+" ','dd/mm/yyyy') between det.FECHA_INICIO and det.FECHA_FIN";  //buscando licencias parciales sobre la baja
                "select det.HORAS_BAJA from sis_solicitud s, sis_det_licencia det, sis_estado_solicitud_vw est, sis_contrato cont " + 
                " where s.ID_SOLICITUD = det.ID_SOLICITUD  and s.ID_ESTADO = est.ID_ESTADO and est.NOMBRE = 'AUTORIZADO'" + 
                " and s.ID_CONTRATO = cont.ID_CONTRATO" + 
                " and cont.ID_PARTIDA = " + 
                utils.getNumberOracle(this.numPartida.getValue()) + 
                " and cont.NUMERO_PLAZA = " + 
                utils.getNumberOracle(this.plaza1.getValue()) + 
                " and cont.ID_PUESTO = " + 
                utils.getNumberOracle(this.puesto.getValue()) + 
                " and cont.CORRELATIVO = to_number(to_char(sysdate,'yyyy'))" + 
                " and to_date('" + 
                utils.getFechaFormato3("dd/MM/yyyy", this.fecha_inicio.getValue()) + 
                " ','dd/mm/yyyy') between det.FECHA_INICIO and det.FECHA_FIN"; //buscando licencias parciales sobre la baja
            /* System.out.println("LA FECHA ES "+ this.fecha_inicio.getValue().toString().trim());
            System.out.println("LA FECHA  "+ this.fecha_inicio.getValue());
            System.out.println("LA clase es  "+ this.fecha_inicio.getClass()); */
            Object auxiliar = interfaz.getValorConsultaSimple("horas_baja", consulta); //buscando licencias parciales sobre la baja

            /*
            //consulta para obtener el numero de horas de la plaza a bajar
            consulta = "select plaz.cantidad_horas from sis_plaza plaz"
            +"and plaz.ID_PARTIDA =  "+ utils.getNumberOracle(this.numPartida.getValue())+"  and plaz.ID_PUESTO = "+utils.getNumberOracle(this.puesto.getValue())
            +" and plaz.CORRELATIVO = to_number(to_char(to_date(' "+ this.fecha_inicio.getValue().toString()+"' ,'yyyy-mm-dd')" + " ,'YYYY'))" +" and plaz.NUMERO_PLAZA = "+ utils.getNumberOracle(this.plaza1.getValue());

            //obtengo el numero de horas de la plaza a bajar
            Object auxHoraPlaza = interfaz.getValorConsultaSimple("cantidad_horas",consulta);
           */
            //consulta para verificar si hubo una promosion en la plaza
            consulta = 
                    "select to_char(mov.FECHA_INICIO,'dd/mm/yyyy') as fecha_inicio from sis_movimiento_plaza mov, sis_anexo an, sis_estado est " + 
                    " where mov.ID_ANEXO = an.ID_ANEXO" + 
                    " and an.ESTATUS = est.ID_ESTADO" + 
                    " AND est.NOMBRE = 'AUTORIZADO'" + 
                    " and mov.ID_PARTIDA = " + 
                    utils.getNumberOracle(this.numPartida.getValue()) + 
                    " and mov.CORRELATIVO = to_number(to_char(sysdate,'yyyy'))" + 
                    " and mov.ID_PUESTO = " + 
                    utils.getNumberOracle(this.puesto.getValue()) + 
                    " and mov.NUMERO_PLAZA = " + 
                    utils.getNumberOracle(this.plaza1.getValue()) + 
                    " AND AN.ID_TIPO_MOV_PLAZA IN (5,6)";

            Object fechaPromo = interfaz.getValorConsultaSimple("fecha_inicio", consulta);

            if (this.dictamen.getValue() != null && this.dictamenNumero.getValue() != null) { // la plaza se bajara para ampliación de horario
                consulta = 
                        "select to_char(dic.FECHA_INICIO,'dd/mm/yyyy') as fecha_inicio from sis_dictamen_detalle dic where dic.EMITIDO_POR =  '" + 
                        this.dictamen.getValue().toString().trim() + 
                        "' and dic.NUMERO =  " + 
                        utils.getNumberOracle(this.dictamenNumero.getValue()) + 
                        "  and dic.ANIO =  " + 
                        utils.getNumberOracle(this.dictamenAnio.getValue()) + 
                        " and dic.ID_PARTIDA =  " + 
                        utils.getNumberOracle(this.numPartida.getValue()) + 
                        " and dic.ID_PUESTO = " + 
                        utils.getNumberOracle(this.puesto.getValue()) + 
                        " and dic.tipo_operacion = 'A' ";

                Object fechaDictamen = interfaz.getValorConsultaSimple("fecha_inicio", consulta);

                //Date fechInicio = utils.getFechaOracle(this.fecha_inicio.getValue().toString());

                //verificamos que hayan ingresado un registro.
                if (this.regEmpleado.getValue() == null || 
                    this.regEmpleado.getValue().equals(" ")) { //verificamos que hayan ingresado el registro del empleado quien tiene actualmente la plaza
                    utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR, 
                                                    "La plaza se bajará por ampliación de horario, debe ingresar el registro del empleado que tiene actualmente la plaza "));
                    return null;
                } else { //buscamos si el registro de empleado ingresado esta contratado en la plaza que se ampliará
                    consulta = 
                            "select mov.registro_empleado from sis_contrato mov" + 
                            " where  mov.ID_PARTIDA =  " + 
                            utils.getNumberOracle(this.numPartida.getValue()) + 
                            "  and mov.ID_PUESTO = " + 
                            utils.getNumberOracle(this.puesto.getValue()) + 
                            " and mov.NUMERO_PLAZA = " + 
                            utils.getNumberOracle(this.plaza1.getValue()) + 
                            " and to_date('" + 
                            utils.getFechaFormato3("dd/MM/yyyy", 
                                                   this.fecha_inicio.getValue()) + 
                            " ','dd/mm/yyyy') between mov.FECHA_INICIO and mov.FECHA_FIN";

                    Object existRegistro = interfaz.getValorConsultaSimple("registro_empleado", consulta);
                    if (existRegistro == null || existRegistro.equals(" ")) { // el registro no esta contratado en la plaza a bajar
                        utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR, 
                                                        "El registro de empleado que ingresó no esta contratado en la plaza que esta bajando por ampliación de horario "));
                        return null;
                    }

                } //Fin verificacion del registro

                if (fechaDictamen == null || fechaDictamen.equals(" ")) {
                    utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR, 
                                                    "La plaza se bajará por ampliación de horario y los datos en el dictamen son incorrectos, verifiquelos. "));
                    return null;
                } else { // existe la plaza para ampliacion de horario en el dictamen..

                    //Consultamos para ver si ya existe una baja por ampliacion de horario
                    consulta = 
                            "select mov.ID_ANEXO from sis_anexo an, sis_movimiento_plaza mov, sis_estado estado" + 
                            " where an.ID_ANEXO = mov.ID_ANEXO and an.ESTATUS = estado.ID_ESTADO and estado.nombre != 'ANULADO'" + 
                            "and mov.ID_PARTIDA =  " + 
                            utils.getNumberOracle(this.numPartida.getValue()) + 
                            "  and mov.ID_PUESTO = " + 
                            utils.getNumberOracle(this.puesto.getValue()) + 
                            " and mov.CORRELATIVO = to_number(to_char(to_date(' " + 
                            this.fecha_inicio.getValue().toString() + 
                            "' ,'yyyy-mm-dd')" + " ,'YYYY'))" + 
                            " and mov.NUMERO_PLAZA = " + 
                            utils.getNumberOracle(this.plaza1.getValue()) + 
                            " and mov.operacion = 'B' and mov.dictamen is not null and mov.numero is not null";

                    Object auxAnexo = interfaz.getValorConsultaSimple("id_anexo", consulta);

                    Date fechDictamen = utils.getFechaOracle(fechaDictamen.toString()); // fecha de inicio de la plaza segun dictamen

                    if (auxAnexo != null) { //existe una baja por ampliacion de horario 
                        utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR, 
                                                        "No se puede bajar la plaza, debido a que ya fue bajada para Ampliacion de horario, CONSULTE EL ANEXO No. " + 
                                                        auxAnexo));
                        return null;
                    }else if (fechDictamen.compareTo((Date)this.fecha_inicio.getValue()) > 0) { 
                        //verificamos que la fecha de inicio sea mayor o igual a la fecha de inicio de la ampliacion en el dictamen.
                        utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR, 
                                                        "La Fecha de inicio a bajar es incorrecta, la fecha para ampliación de horario segun  dictamen es:  " + 
                                                        fechaDictamen));
                        return null;
                    }
                }
            }else { // LA PLAZA NO SE BAJARA POR AMPLIACION DE HORARIO--------------------------------------
                //interfaz.cn_Cerrar_coneccion();
                if (fechaPromo != null) { // la plaza fue promovida o reclasificada
                    Date inicioPromo = utils.getFechaOracle(fechaPromo.toString().trim());
                    consulta = 
                            " select MOV.SUELDO_BASE from sis_movimiento_plaza mov, sis_anexo anexo, sis_estado estado" + 
                            " where mov.ID_ANEXO = anexo.ID_ANEXO and anexo.ESTATUS = estado.ID_ESTADO" + 
                            " and estado.NOMBRE = 'AUTORIZADO'" + 
                            " and mov.ID_PARTIDA = " + 
                            utils.getNumberOracle(this.numPartida.getValue()) + 
                            " and mov.NUMERO_PLAZA = " + 
                            utils.getNumberOracle(this.plaza1.getValue()) + 
                            " and mov.CORRELATIVO = to_number(to_char(sysdate,'yyyy'))" + 
                            " and to_date('" + 
                            utils.getFechaFormato3("dd/MM/yyyy", 
                                                   this.fecha_inicio.getValue()) + 
                            " ','dd/mm/yyyy') between mov.FECHA_INICIO and mov.FECHA_FIN\n" + 
                            " and mov.ID_PUESTO != " + 
                            utils.getNumberOracle(this.puesto.getValue()) + 
                            " and anexo.ID_TIPO_MOV_PLAZA != 5 and anexo.ID_TIPO_MOV_PLAZA != 6";
                    Object auxSueldo = interfaz.getValorConsultaSimple("sueldo_base", consulta);
                    
                    if (inicioPromo.compareTo(utils.getFechaOracle(utils.getFechaFormato3("dd/MM/yyyy", 
                                                                                          this.fecha_inicio.getValue()))) <= 
                        0) { //fecha de inicio esta dentro de la promocion o reclasificacionif ( inicioPromo.compareTo(utils.getFechaOracle("dd/MM/yyyy",utils.getFechaFormato("dd/MM/yyyy", this.getFechaInicio())))<= 0 ){//fecha de inicio esta dentro de la promocion o reclasificacion                
                        if (auxSueldo != null) { //la plaza que se promovió habia sido bajada
                            consulta = 
                                    " select to_char(MOV.fecha_fin,'dd/mm/yyyy') as fecha_fin from sis_movimiento_plaza mov, sis_anexo anexo, sis_estado estado" + 
                                    " where mov.ID_ANEXO = anexo.ID_ANEXO and anexo.ESTATUS = estado.ID_ESTADO" + 
                                    " and estado.NOMBRE = 'AUTORIZADO'" + 
                                    " and mov.ID_PARTIDA = " + 
                                    utils.getNumberOracle(this.numPartida.getValue()) + 
                                    " and mov.NUMERO_PLAZA = " + 
                                    utils.getNumberOracle(this.plaza1.getValue()) + 
                                    " and mov.CORRELATIVO = to_number(to_char(sysdate,'yyyy'))" + 
                                    " and ( to_date('" + 
                                    utils.getFechaFormato3("dd/MM/yyyy", 
                                                           this.fecha_inicio.getValue()) + 
                                    " ','dd/mm/yyyy') between mov.FECHA_INICIO and mov.FECHA_FIN" + 
                                    " or to_date('" + 
                                    utils.getFechaFormato3("dd/MM/yyyy", 
                                                           this.fecha_fin.getValue()) + 
                                    " ','dd/mm/yyyy') between mov.FECHA_INICIO and mov.FECHA_FIN )" + 
                                    " and mov.ID_PUESTO != " + 
                                    utils.getNumberOracle(this.puesto.getValue()) + 
                                    " and anexo.ID_TIPO_MOV_PLAZA != 5 and anexo.ID_TIPO_MOV_PLAZA != 6";

                            Date finBaja = utils.getFechaOracle(interfaz.getValorConsultaSimple("fecha_fin", consulta).toString().trim());
                            interfaz.cn_Cerrar_coneccion();

                            if (finBaja.compareTo(utils.getFechaOracle(utils.getFechaFormato3("dd/MM/yyyy", 
                                                                                              this.fecha_fin.getValue()))) >= 0) { 
                                //el periodo a bajar esta dentro de la baja antes de la promocion
                                Double sueldoAnexo = new Double(auxSueldo.toString().trim());
                                if (sueldoAnexo > 0) {

                                    /* **** PLAZAS QUE TIENEN LICENCIAS PARCIALES  **** */
                                    if (auxiliar != null) { //existe una licencia parcial en la plaza a bajar
                                        Double hrParciales = new Double(auxiliar.toString().trim());
                                        //System.out.println("las horas parciales "+ hrParciales.doubleValue());
                                        if (hrParciales > 0) {
                                            sueldo = new Double(this.sueldoBase.getValue().toString().trim());
                                            hor = new Double(this.horas.getValue().toString().trim());
                                            sueldo = sueldo.doubleValue() / hor.doubleValue();
                                            sueldo = sueldo.doubleValue() * hrParciales.doubleValue();
                                            sueldo = sueldo.doubleValue() - sueldoAnexo.doubleValue();
                                            varsueldo = redondear.format(sueldo.doubleValue());
                                            sueldoBase.setSubmittedValue(null);
                                            sueldoBase.setValue(varsueldo);
                                            horas.setSubmittedValue(null);
                                            horas.setValue(hrParciales.doubleValue());
                                            /* if(auxHoraPlaza != null){
                                             horaPlaza = new Double(auxHoraPlaza.toString().trim());
                                        }*/
                                            if (this.getComplemenSalarial() != 
                                                null) { //calculamos proporcionalmente el complemento de acuerdo a las horas parciales
                                                complemento = new Double(this.getComplemenSalarial().getValue().toString().trim());
                                                if (complemento > 0) {
                                                    complemento = complemento.doubleValue() / hor.doubleValue();
                                                    complemento = complemento.doubleValue() * hrParciales.doubleValue();
                                                    varComplemento = redondear.format(complemento.doubleValue());
                                                }
                                            }
                                            if (this.getEscalafon() != null) { //calculamos proporcionalmente el escalafon de acuerdo a las horas parciales
                                                escalafon = new Double(this.getEscalafon().getValue().toString().trim());
                                                if (escalafon > 0) {
                                                    escalafon = escalafon.doubleValue() / hor.doubleValue();
                                                    escalafon = escalafon.doubleValue() * hrParciales.doubleValue();
                                                    varEscalafon = redondear.format(escalafon.doubleValue());
                                                }
                                            }
                                            this.complemenSalarial.setSubmittedValue(null);
                                            this.complemenSalarial.setValue(varComplemento);
                                            this.escalafon.setSubmittedValue(null);
                                            this.escalafon.setValue(varEscalafon);
                                            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                                                        "#{bindings.Escalafon.inputValue}", 
                                                                        utils.getNumberOracle(varEscalafon));
                                            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                                                        "#{bindings.ComplSalarial.inputValue}", 
                                                                        utils.getNumberOracle(varComplemento));

                                            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                                                        "#{bindings.SueldoBase.inputValue}", 
                                                                        utils.getNumberOracle(varsueldo));
                                            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                                                        "#{bindings.CantidadHoras.inputValue}", 
                                                                        utils.getNumberOracle(hrParciales.doubleValue()));
                                            sis_movimiento_plazaRowImpl varMovimiento = 
                                                (sis_movimiento_plazaRowImpl)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                                                                                        "#{bindings.sis_movimiento_plaza1Iterator.currentRow}");
                                            varMovimiento.setSueldoBase(utils.getNumberOracle(varsueldo));
                                            varMovimiento.setCantidadHoras(utils.getNumberOracle(hrParciales.doubleValue()));
                                            varMovimiento.setEscalafon(utils.getNumberOracle(varEscalafon));
                                            varMovimiento.setComplSalarial(utils.getNumberOracle(varComplemento));
                                            utils.setADFMensaje(new resulOp(resulOp.OPE_WARN, 
                                                                            "La plaza tiene una licencia parcial, el sueldo base y el no. de horas fueron modificadas"));

                                        } else { // por aquello de que agarre basura
                                            sueldo = new Double(this.sueldoBase.getValue().toString().trim());
                                            sueldo = sueldo.doubleValue() - sueldoAnexo.doubleValue();
                                            varsueldo = redondear.format(sueldo.doubleValue());
                                            sueldoBase.setSubmittedValue(null);
                                            sueldoBase.setValue(varsueldo);

                                            /* **************VERIFICAR ESTA PARTE CUANDO SE BAJO ANTES DE LA PROMOSION***************    */
                                            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                                                        "#{bindings.SueldoBase.inputValue}", 
                                                                        utils.getNumberOracle(varsueldo));
                                            sis_movimiento_plazaRowImpl varMovimiento = 
                                                (sis_movimiento_plazaRowImpl)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                                                                                        "#{bindings.sis_movimiento_plaza1Iterator.currentRow}");
                                            varMovimiento.setSueldoBase(utils.getNumberOracle(varsueldo));

                                            utils.setADFMensaje(new resulOp(resulOp.OPE_WARN, 
                                                                            "La plaza fue bajada antes de ser promovida, el sueldo base  fue modificado"));
                                        }

                                    } else { // la plaza no tiene ninguna licencia parcial
                                        sueldo = new Double(this.sueldoBase.getValue().toString().trim());
                                        sueldo = sueldo.doubleValue() - sueldoAnexo.doubleValue();
                                        varsueldo = redondear.format(sueldo.doubleValue());
                                        sueldoBase.setSubmittedValue(null);
                                        sueldoBase.setValue(varsueldo);

                                        /* **************VERIFICAR ESTA PARTE CUANDO SE BAJO ANTES DE LA PROMOSION***************    */

                                        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                                                    "#{bindings.SueldoBase.inputValue}", 
                                                                    utils.getNumberOracle(varsueldo));
                                        sis_movimiento_plazaRowImpl varMovimiento = 
                                            (sis_movimiento_plazaRowImpl)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                                                                                    "#{bindings.sis_movimiento_plaza1Iterator.currentRow}");
                                        varMovimiento.setSueldoBase(utils.getNumberOracle(varsueldo));
                                        utils.setADFMensaje(new resulOp(resulOp.OPE_WARN, 
                                                                        "La plaza fue bajada antes de ser promovida, el sueldo base  fue modificado"));
                                    }
                                    // FIN DE LAS LICENCIAS PARCIALES
                                } // fin sueldo anexo
                                else { // por aquello que haya agarrado basura, jejejee
                                    /* **** PLAZAS QUE TIENEN LICENCIAS PARCIALES  **** */
                                    if (auxiliar != null) { //existe una licencia parcial en la plaza a bajar
                                        Double hrParciales = new Double(auxiliar.toString().trim());
                                        //System.out.println("las horas parciales "+ hrParciales.doubleValue());
                                        if (hrParciales > 0) {
                                            sueldo = new Double(this.sueldoBase.getValue().toString().trim());
                                            hor = new Double(this.horas.getValue().toString().trim());
                                            sueldo = sueldo.doubleValue() / hor.doubleValue();
                                            sueldo = sueldo.doubleValue() * hrParciales.doubleValue();
                                            varsueldo = redondear.format(sueldo.doubleValue());
                                            sueldoBase.setSubmittedValue(null);
                                            sueldoBase.setValue(varsueldo);
                                            horas.setSubmittedValue(null);
                                            horas.setValue(hrParciales.doubleValue());

                                            if (this.getComplemenSalarial() != 
                                                null) { //calculamos proporcionalmente el complemento de acuerdo a las horas parciales
                                                complemento = new Double(this.getComplemenSalarial().getValue().toString().trim());
                                                if (complemento > 0) {
                                                    complemento = complemento.doubleValue() / hor.doubleValue();
                                                    complemento = complemento.doubleValue() * hrParciales.doubleValue();
                                                    varComplemento = redondear.format(complemento.doubleValue());
                                                }
                                            }
                                            if (this.getEscalafon() != null) { //calculamos proporcionalmente el escalafon de acuerdo a las horas parciales
                                                escalafon = new Double(this.getEscalafon().getValue().toString().trim());
                                                if (escalafon > 0) {
                                                    escalafon = escalafon.doubleValue() / hor.doubleValue();
                                                    escalafon = escalafon.doubleValue() * hrParciales.doubleValue();
                                                    varEscalafon = redondear.format(escalafon.doubleValue());
                                                }
                                            }
                                            this.complemenSalarial.setSubmittedValue(null);
                                            this.complemenSalarial.setValue(varComplemento);
                                            this.escalafon.setSubmittedValue(null);
                                            this.escalafon.setValue(varEscalafon);

                                            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                                                        "#{bindings.ComplSalarial.inputValue}", 
                                                                        utils.getNumberOracle(varComplemento));
                                            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                                                        "#{bindings.Escalafon.inputValue}", 
                                                                        utils.getNumberOracle(varEscalafon));
                                            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                                                        "#{bindings.SueldoBase.inputValue}", 
                                                                        utils.getNumberOracle(varsueldo));
                                            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                                                        "#{bindings.CantidadHoras.inputValue}", 
                                                                        utils.getNumberOracle(hrParciales.doubleValue()));
                                            sis_movimiento_plazaRowImpl varMovimiento = 
                                                (sis_movimiento_plazaRowImpl)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                                                                                        "#{bindings.sis_movimiento_plaza1Iterator.currentRow}");
                                            varMovimiento.setSueldoBase(utils.getNumberOracle(varsueldo));
                                            varMovimiento.setCantidadHoras(utils.getNumberOracle(hrParciales.doubleValue()));

                                            varMovimiento.setEscalafon(utils.getNumberOracle(varEscalafon));
                                            varMovimiento.setComplSalarial(utils.getNumberOracle(varComplemento));
                                            utils.setADFMensaje(new resulOp(resulOp.OPE_WARN, 
                                                                            "La plaza tiene una licencia parcial, el sueldo base y el No. De horas fueron modificadas"));

                                        }
                                    } // FIN DE LAS LICENCIAS PARCIALES

                                } /// fin else  sueldoAnexo
                            } // finBaja(la fecha a bajar esta dentro del rango aceptado 
                            else { // la fecha a bajar no esta dentro del rango de la fecha de la plaza que se promovio o reclasifico
                                interfaz.cn_Cerrar_coneccion();
                                utils.setADFMensaje(new resulOp(resulOp.OPE_WARN, 
                                                                "No se puede bajar la plaza porque fue bajada y luego promovida, el rango de fechas es invalido. Si desea utilizar la diferencia entre el puesto anterior y el actual utilice un periodo dentro del rango del   " + 
                                                                utils.getFechaFormato("dd/MM/yyyy", 
                                                                                      inicioPromo.getValue()) + 
                                                                "  al  " + 
                                                                utils.getFechaFormato("dd/MM/yyyy", 
                                                                                      finBaja.getValue())));
                            } // fin else de finBaja
                        } // fin auxSueldo(la plaza estaba bajada cuando se promovio)

                        else { // la plaza no fue dado de baja antes de su promocion o reclasificacion
                            /* **** PLAZAS QUE TIENEN LICENCIAS PARCIALES  **** */
                            if (auxiliar != null) { //existe una licencia parcial en la plaza a bajar
                                Double hrParciales = new Double(auxiliar.toString().trim());
                                //System.out.println("las horas parciales "+ hrParciales.doubleValue());
                                if (hrParciales > 0) {
                                    sueldo = new Double(this.sueldoBase.getValue().toString().trim());
                                    hor = new Double(this.horas.getValue().toString().trim());
                                    sueldo = sueldo.doubleValue() / hor.doubleValue();
                                    sueldo = sueldo.doubleValue() * hrParciales.doubleValue();
                                    varsueldo = redondear.format(sueldo.doubleValue());
                                    sueldoBase.setSubmittedValue(null);
                                    sueldoBase.setValue(varsueldo);
                                    horas.setSubmittedValue(null);
                                    horas.setValue(hrParciales.doubleValue());

                                    if (this.getComplemenSalarial() != null) { //calculamos proporcionalmente el complemento de acuerdo a las horas parciales
                                        complemento = new Double(this.getComplemenSalarial().getValue().toString().trim());
                                        
                                        if (complemento > 0) {
                                            complemento = complemento.doubleValue() / hor.doubleValue();
                                            complemento = complemento.doubleValue() * hrParciales.doubleValue();
                                            varComplemento = redondear.format(complemento.doubleValue());
                                        }
                                    }
                                    if (this.getEscalafon() != null) { //calculamos proporcionalmente el escalafon de acuerdo a las horas parciales
                                        escalafon = new Double(this.getEscalafon().getValue().toString().trim());
                                        if (escalafon > 0) {
                                            escalafon = escalafon.doubleValue() / hor.doubleValue();
                                            escalafon = escalafon.doubleValue() * hrParciales.doubleValue();
                                            varEscalafon = redondear.format(escalafon.doubleValue());
                                        }
                                    }
                                    this.complemenSalarial.setSubmittedValue(null);
                                    this.complemenSalarial.setValue(varComplemento);
                                    this.escalafon.setSubmittedValue(null);
                                    this.escalafon.setValue(varEscalafon);

                                    JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                                                "#{bindings.ComplSalarial.inputValue}", 
                                                                utils.getNumberOracle(varComplemento));
                                    JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                                                "#{bindings.Escalafon.inputValue}", 
                                                                utils.getNumberOracle(varEscalafon));

                                    JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                                                "#{bindings.SueldoBase.inputValue}", 
                                                                utils.getNumberOracle(varsueldo));
                                    JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                                                "#{bindings.CantidadHoras.inputValue}", 
                                                                utils.getNumberOracle(hrParciales.doubleValue()));
                                    sis_movimiento_plazaRowImpl varMovimiento = 
                                        (sis_movimiento_plazaRowImpl)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                                                                                "#{bindings.sis_movimiento_plaza1Iterator.currentRow}");
                                    varMovimiento.setSueldoBase(utils.getNumberOracle(varsueldo));
                                    varMovimiento.setCantidadHoras(utils.getNumberOracle(hrParciales.doubleValue()));

                                    varMovimiento.setEscalafon(utils.getNumberOracle(varEscalafon));
                                    varMovimiento.setComplSalarial(utils.getNumberOracle(varComplemento));
                                    utils.setADFMensaje(new resulOp(resulOp.OPE_WARN, 
                                                                    "La plaza tiene una licencia parcial, el sueldo base y el No. De horas fueron modificadas "));

                                }
                            } // FIN DE LAS LICENCIAS PARCIALES

                        } //fin else
                    } // fin inicioPromo (La fecha de inicio de la baja esta dentro del rango de la fecha de inicio de la promocion)
                    else { // la plaza fue promovida o reclasificada y se esta bajando con una fecha antes de su promocion
                        interfaz.cn_Cerrar_coneccion();
                        utils.setADFMensaje(new resulOp(resulOp.OPE_WARN, 
                                                        "El rango de fechas es invalido debido a que fue promovida o reclasificada, la fecha de inicio debe ser igual o mayor al   " + 
                                                        utils.getFechaFormato("dd/MM/yyyy", 
                                                                              inicioPromo.getValue())));
                    }
                } //fin fechaPromo(hubo una promocion o reclasificacion)
                else { //la plaza no fue promovida ni reclasificada
                    interfaz.cn_Cerrar_coneccion();
                    
                    if (auxiliar != null) { //existe una licencia parcial en la plaza a bajar
                        Double hrParciales = new Double(auxiliar.toString().trim());
                        //System.out.println("las horas parciales "+ hrParciales.doubleValue());
                        if (hrParciales > 0) {
                            sueldo = new Double(this.sueldoBase.getValue().toString().trim());
                            hor = new Double(this.horas.getValue().toString().trim());
                            sueldo = sueldo.doubleValue() / hor.doubleValue();
                            sueldo = sueldo.doubleValue() * hrParciales.doubleValue();
                            varsueldo = redondear.format(sueldo.doubleValue());
                            sueldoBase.setSubmittedValue(null);
                            sueldoBase.setValue(varsueldo);
                            horas.setSubmittedValue(null);
                            horas.setValue(hrParciales.doubleValue());

                            if (this.getComplemenSalarial() != 
                                null) { //calculamos proporcionalmente el complemento de acuerdo a las horas parciales
                                complemento = new Double(this.getComplemenSalarial().getValue().toString().trim());
                                if (complemento > 0) {
                                    complemento = complemento.doubleValue() / hor.doubleValue();
                                    complemento = complemento.doubleValue() * hrParciales.doubleValue();
                                    varComplemento = redondear.format(complemento.doubleValue());
                                }
                            }
                            if (this.getEscalafon() != null) { //calculamos proporcionalmente el escalafon de acuerdo a las horas parciales
                                escalafon = new Double(this.getEscalafon().getValue().toString().trim());
                                if (escalafon > 0) {
                                    escalafon = escalafon.doubleValue() / hor.doubleValue();
                                    escalafon = escalafon.doubleValue() * hrParciales.doubleValue();
                                    varEscalafon = redondear.format(escalafon.doubleValue());
                                }
                            }
                            this.complemenSalarial.setSubmittedValue(null);
                            this.complemenSalarial.setValue(varComplemento);
                            this.escalafon.setSubmittedValue(null);
                            this.escalafon.setValue(varEscalafon);

                            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                                        "#{bindings.ComplSalarial.inputValue}", 
                                                        utils.getNumberOracle(varComplemento));
                            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                                        "#{bindings.Escalafon.inputValue}", 
                                                        utils.getNumberOracle(varEscalafon));

                            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                                        "#{bindings.SueldoBase.inputValue}", 
                                                        utils.getNumberOracle(varsueldo));
                            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                                        "#{bindings.CantidadHoras.inputValue}", 
                                                        utils.getNumberOracle(hrParciales.doubleValue()));
                            sis_movimiento_plazaRowImpl varMovimiento = 
                                (sis_movimiento_plazaRowImpl)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                                                                        "#{bindings.sis_movimiento_plaza1Iterator.currentRow}");
                            varMovimiento.setSueldoBase(utils.getNumberOracle(varsueldo));
                            varMovimiento.setCantidadHoras(utils.getNumberOracle(hrParciales.doubleValue()));

                            varMovimiento.setEscalafon(utils.getNumberOracle(varEscalafon));
                            varMovimiento.setComplSalarial(utils.getNumberOracle(varComplemento));
                            utils.setADFMensaje(new resulOp(resulOp.OPE_WARN, 
                                                            "La plaza tiene una licencia parcial, el sueldo base y el no. De horas fueron modificadas"));

                        }
                    } // FIN DE LAS LICENCIAS PARCIALES
                } // fin else de inicio promocion
            } //fin else de bajas por ampliacion de horario

            botonEjecutar.setDisabled(true);
            botonGuardar.setDisabled(false);
            botonCrear.setDisabled(false);
            this.listPartida.setDisabled(true);
            this.listPuesto.setDisabled(true);

            this.listPeriodo.setDisabled(true);
            this.tipOperacion.setDisabled(true);
            interfaz.cn_Cerrar_coneccion();
        }
        /*  BindingContainer bindings = getBindings();
        OperationBinding operationBinding =
            bindings.getOperationBinding("Execute");
        Object result = operationBinding.execute();

        //sueldoBase.setValue();

        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }*/
        //  refreshCurrentPage();
        //verificando que la fecha de inicio no sea mayor a la fecha de finalizacion
        Date aux = utils.getFechaOracle(utils.getFechaFormato3("dd/MM/yyyy", this.getFecha_inicio().getValue()));
        Date aux1 = utils.getFechaOracle(utils.getFechaFormato3("dd/MM/yyyy", this.getFecha_fin().getValue()));
        if (aux.compareTo(aux1) > 0) {
            botonEjecutar.setDisabled(false);
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR, "La fecha de inicio es mayor que la fecha fin "));
            return null;
        }
        botonGuardar.setDisabled(false); // agregado para la actualizacion

        //codigo para la validadcion de la ampliacion de horario
        //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Execute");
        //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Commit");
        boolean resultado;
        resultado = JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(), "Commit");
        /* BindingContainer bindings = getBindings();
          OperationBinding operationBinding =
              bindings.getOperationBinding("Commit");
          Object result = operationBinding.execute();
        */
        if (resultado == true) {
            //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ExeDocPagoAnualdo");
            botonReporte.setDisabled(false);
            botonCrear.setDisabled(false);
            botonAnexo_autorizar.setDisabled(false);

            horas.setDisabled(true);
            // correlativo.setDisabled(true);
            sueldoBase.setDisabled(true);
            escalafon.setDisabled(true);
            complemenSalarial.setDisabled(true);
            plaza1.setDisabled(true);
            listPeriodo.setDisabled(true);
            // dictamen.setRendered(true);
            nombrePlaza.setRendered(true);
            tipOperacion.setDisabled(true);
            listPartida.setDisabled(true);
            listPuesto.setDisabled(true);

            listPlaza.setDisabled(true);
            //botonEjecutar.setDisabled(false);
            dictamen.setDisabled(true);
            nombrePlaza.setDisabled(true);
            regEmpleado.setRendered(false);
            facTiempo.setDisabled(true);
            this.dictamenAnio.setDisabled(false);
            this.dictamenEmitido.setDisabled(false);
            this.dictamenNumero.setDisabled(false);
            this.fecha_inicio.setDisabled(true);
            this.fecha_fin.setDisabled(true);
            this.lisTipDoc.setDisabled(true);
            this.botonGuardar.setDisabled(true);
            utils.setADFMensaje(new resulOp(resulOp.OPE_OK, "Datos guardados correctamente."));
            //this.cmd_link_sis_22.setDisabled(false);
        } else {
            this.botonGuardar.setDisabled(false);
        }
        // Add event code here...
        return null;
    }

    public void setListPuesto(CoreSelectOneChoice listPuesto) {
        this.listPuesto = listPuesto;
    }

    public CoreSelectOneChoice getListPuesto() {
        return listPuesto;
    }

    public void setPuesto(CoreInputText puesto) {
        this.puesto = puesto;
    }

    public CoreInputText getPuesto() {
        return puesto;
    }


    public void setEscalaMin(CoreInputText escalaMin) {
        this.escalaMin = escalaMin;
    }

    public CoreInputText getEscalaMin() {
        return escalaMin;
    }

    public BindingContainer getBindings() {
        return this.bindings;
    }

    public void setBindings(BindingContainer bindings) {
        this.bindings = bindings;
    }

    public String btn_actualizar() {
        //System.out.println("entre al boton actulizar");
        //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"NomEmitidoPor");
        Double sueldo;
        Double hor;

        DecimalFormat redondear = new DecimalFormat("0.00");
        Object varsueldo;
        //verificando que no este en blaco la fecha inicio y la fecha fin 
        if ((fecha_inicio.getValue() == null || (fecha_inicio.getValue() != null && 
              fecha_inicio.getValue().equals(""))) || (fecha_fin.getValue() == null) || 
            (fecha_fin.getValue() != null && fecha_fin.getValue().equals(""))) {
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR, "DEBE INGRESAR LAS FECHAS CORRESPONDIENTES"));
            return null;
        }

        if (this.tipOperacion.getValue().equals("A") && this.listPuesto.getValue() == null) {
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR, "DEBE SELECCIONAR EL PUESTO"));
            return null;
        }

        if (this.tipOperacion.getValue().equals("A")) {
            interfaz_DB interfaz = new interfaz_DB();
            String Consulta = 
                "select id_programa from sis_partida where id_partida =  " + 
                utils.getNumberOracle(this.numPartida.getValue());

            Object varPlan = interfaz.getValorConsultaSimple("id_programa", Consulta);
            interfaz.cn_Cerrar_coneccion();

            if ((varPlan.toString().trim().equals("48") || varPlan.toString().trim().equals("49")) && 
                this.listPuestoEscala.getValue() == null) {

                utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR, "DEBE SELECCIONAR LA ESCALA SALARIAL PARA EL PUESTO"));
                return null;
            }
        }

        /* Este codigo es para verificar que se haya seleccionado una partida de SICOIN */
        //Se deshabilita este bloque por no continuar SICOIN, 13/01/2022
        /*if (this.tipOperacion.getValue().equals("A")) {
            Object cmbPartidaSicoin = this.partidaSicoin.getValue();
            if (cmbPartidaSicoin == null) {
                utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR, "Debe seleccionar una PARTIDA DE SICOIN"));
                return null;
            }
        }*/

        // calculo el sueldo de la plaza nueva de acuerdo a la escala minima
        if (tipOperacion.getValue().equals("A") && varMinimo.getValue() != null) {
            //Object varsueldo = varMinimo.getValue();
            // Integer sueldo =  Integer.parseInt(varsueldo.toString().trim());
            interfaz_DB interfaz = new interfaz_DB();
            String Consulta = "select id_programa from sis_partida where id_partida =  " + utils.getNumberOracle(this.numPartida.getValue());

            Object varPlan = interfaz.getValorConsultaSimple("id_programa", Consulta);
            interfaz.cn_Cerrar_coneccion();

            sueldo = new Double(varMinimo.getValue().toString().trim());

            if (varPlan.toString().trim().equals("48") || varPlan.toString().trim().equals("49")) {
                if (this.varMinEscalaf.getValue() != null) {
                    sueldo = sueldo + new Double(this.varMinEscalaf.getValue().toString().trim());
                    //System.out.println("el sueldo es "+sueldo);
                }
            }

            //sueldo.valueOf( );
            // sueldo = (double)varMinimo.getValue();
            //calcula el sueldo base si la escala minima es mayor a 0
            //System.out.println("esto tiene sueldo" + sueldoBase.getValue());
            if (sueldo > 0) {
                //System.out.println("entre al ifff uuuuuuu");

                if (horas.getValue() == null) { //fue ingresada la cantidad de horas
                    utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR, "DEBE INGRESAR UNA CANTIDAD DE HORAS"));
                    botonEjecutar.setDisabled(false);
                    botonGuardar.setDisabled(true);
                    botonCrear.setDisabled(true);
                    return null;
                    // throw new JboException("DEBE INGRESAR UNA CANTIDAD DE HORAS");
                } else {
                    //Object varhora = horas.getValue();
                    //Integer hor = Integer.parseInt(varhora.toString().trim());
                    hor = new Double(horas.getValue().toString().trim());
                    sueldo = sueldo.doubleValue() * hor.doubleValue();
                    varsueldo = redondear.format(sueldo.doubleValue());
                    sueldoBase.setSubmittedValue(null);
                    sueldoBase.setValue(varsueldo);

                    JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                                "#{bindings.SueldoBase.inputValue}", 
                                                utils.getNumberOracle(varsueldo));
                    sis_movimiento_plazaRowImpl varMovimiento = 
                        (sis_movimiento_plazaRowImpl)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                                                                "#{bindings.sis_movimiento_plaza1Iterator.currentRow}");
                    varMovimiento.setSueldoBase(utils.getNumberOracle(varsueldo));

                    botonGuardar.setDisabled(false);

                    botonCrear.setDisabled(false);
                    sueldoBase.setPartialTriggers(new String[] { });
                    botonEjecutar.setDisabled(true);
                    // System.out.println("imprimiendoo execute con " + sueldo);
                }
            } else { //el puesto tiene escala minima = 0
                utils.setADFMensaje(new resulOp(resulOp.OPE_WARN, "EL PUESTO SELECCIONADO TIENE 0 EN ESCALA SALARIAL, EL SUELDO BASE ES EL INGRESADO"));

                botonEjecutar.setDisabled(true);
                botonGuardar.setDisabled(false);
                botonCrear.setDisabled(false);
                //return null;
            }

            //utils.getFechaOracle(this.fecha_inicio.getValue().toString()).compareTo(utils.getFechaOracle(this.fecha_fin.getValue().toString()));
        } else if (tipOperacion.getValue().equals("B")) { //bajaremos una plaza
            interfaz_DB interfaz = new interfaz_DB();
            Double complemento;
            Double escalafon;
            //Double horaPlaza ;
            Object varComplemento = 0;
            Object varEscalafon = 0;
            /*
            String consulta = "select cont.ID_CONTRATO from sis_contrato cont\n" +
            "where cont.ID_PARTIDA = " +utils.getNumberOracle(this.numPartida.getValue()) +
            "and cont.NUMERO_PLAZA = "+utils.getNumberOracle(this.plaza1.getValue())  +
            "and cont.ID_PUESTO = " +utils.getNumberOracle(this.puesto.getValue()) +
            "and cont.CORRELATIVO = to_number(to_char(sysdate,'yyyy'))";
            Object contrato = interfaz.getValorConsultaSimple("id_contrato",consulta );//buscando licencias parciales sobre la baja
            */
            //System.out.println("LA FECHA ES "+ this.fecha_inicio.getValue().toString().trim());
            //System.out.println("LA FECHA  "+ this.fecha_inicio.getValue());
            //System.out.println("LA clase es  "+ this.fecha_inicio.getValue().getClass());
            String consulta =
                //+" and to_date('"+ utils.getFechaFormato("dd/MM/yyyy", utils.getFechaOracle(this.fecha_inicio.getValue().toString().trim()))+" ','dd/mm/yyyy') between det.FECHA_INICIO and det.FECHA_FIN";  //buscando licencias parciales sobre la baja
                "select det.HORAS_BAJA from sis_solicitud s, sis_det_licencia det, sis_estado_solicitud_vw est, sis_contrato cont " + 
                " where s.ID_SOLICITUD = det.ID_SOLICITUD  and s.ID_ESTADO = est.ID_ESTADO and est.NOMBRE = 'AUTORIZADO'" + 
                " and s.ID_CONTRATO = cont.ID_CONTRATO" + 
                " and cont.ID_PARTIDA = " + 
                utils.getNumberOracle(this.numPartida.getValue()) + 
                " and cont.NUMERO_PLAZA = " + 
                utils.getNumberOracle(this.plaza1.getValue()) + 
                " and cont.ID_PUESTO = " + 
                utils.getNumberOracle(this.puesto.getValue()) + 
                " and cont.CORRELATIVO = to_number(to_char(sysdate,'yyyy'))" + 
                " and to_date('" + 
                utils.getFechaFormato3("dd/MM/yyyy", this.fecha_inicio.getValue()) + 
                " ','dd/mm/yyyy') between det.FECHA_INICIO and nvl(det.FECHA_FIN,cont.fecha_fin)"; //buscando licencias parciales sobre la baja
            /* System.out.println("LA FECHA ES "+ this.fecha_inicio.getValue().toString().trim());
            System.out.println("LA FECHA  "+ this.fecha_inicio.getValue());
            System.out.println("LA clase es  "+ this.fecha_inicio.getClass()); */

            Object auxiliar = 
                interfaz.getValorConsultaSimple("horas_baja", consulta); //buscando licencias parciales sobre la baja
            /*
            //consulta para obtener el numero de horas de la plaza a bajar
            consulta = "select plaz.cantidad_horas from sis_plaza plaz"
            +"and plaz.ID_PARTIDA =  "+ utils.getNumberOracle(this.numPartida.getValue())+"  and plaz.ID_PUESTO = "+utils.getNumberOracle(this.puesto.getValue())
            +" and plaz.CORRELATIVO = to_number(to_char(to_date(' "+ this.fecha_inicio.getValue().toString()+"' ,'yyyy-mm-dd')" + " ,'YYYY'))" +" and plaz.NUMERO_PLAZA = "+ utils.getNumberOracle(this.plaza1.getValue());

            //obtengo el numero de horas de la plaza a bajar
            Object auxHoraPlaza = interfaz.getValorConsultaSimple("cantidad_horas",consulta);
           */
            //consulta para verificar si hubo una promosion en la plaza
            consulta = 
                    "select to_char(mov.FECHA_INICIO,'dd/mm/yyyy') as fecha_inicio from sis_movimiento_plaza mov, sis_anexo an, sis_estado est " + 
                    " where mov.ID_ANEXO = an.ID_ANEXO" + 
                    " and an.ESTATUS = est.ID_ESTADO" + 
                    " AND est.NOMBRE = 'AUTORIZADO'" + 
                    " and mov.ID_PARTIDA = " + 
                    utils.getNumberOracle(this.numPartida.getValue()) + 
                    " and mov.CORRELATIVO = to_number(to_char(sysdate,'yyyy'))" + 
                    " and mov.ID_PUESTO = " + 
                    utils.getNumberOracle(this.puesto.getValue()) + 
                    " and mov.NUMERO_PLAZA = " + 
                    utils.getNumberOracle(this.plaza1.getValue()) + 
                    " AND AN.ID_TIPO_MOV_PLAZA IN (5,6)";

            Object fechaPromo = interfaz.getValorConsultaSimple("fecha_inicio", consulta);

            if (this.dictamen.getValue() != null && 
                this.dictamenNumero.getValue() != null) { // la plaza se bajara para ampliación de horario
                consulta = 
                        "select to_char(dic.FECHA_INICIO,'dd/mm/yyyy') as fecha_inicio from sis_dictamen_detalle dic where dic.EMITIDO_POR =  '" + 
                        this.dictamen.getValue().toString().trim() + 
                        "' and dic.NUMERO =  " + 
                        utils.getNumberOracle(this.dictamenNumero.getValue()) + 
                        "  and dic.ANIO =  " + 
                        utils.getNumberOracle(this.dictamenAnio.getValue()) + 
                        " and dic.ID_PARTIDA =  " + 
                        utils.getNumberOracle(this.numPartida.getValue()) + 
                        " and dic.ID_PUESTO = " + 
                        utils.getNumberOracle(this.puesto.getValue()) + 
                        " and dic.tipo_operacion = 'A' ";

                Object fechaDictamen = interfaz.getValorConsultaSimple("fecha_inicio", consulta);

                //Date fechInicio = utils.getFechaOracle(this.fecha_inicio.getValue().toString());

                //verificamos que hayan ingresado un registro.
                if (this.regEmpleado.getValue() == null || this.regEmpleado.getValue().equals(" ")) { 
                    //verificamos que hayan ingresado el registro del empleado quien tiene actualmente la plaza
                    utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR, 
                                                    "La plaza se bajará por ampliación de horario, debe ingresar el registro del empleado que tiene actualmente la plaza "));
                    return null;
                } else { //buscamos si el registro de empleado ingresado esta contratado en la plaza que se ampliará
                    consulta = 
                            "select mov.registro_empleado from sis_contrato mov" + 
                            " where  mov.ID_PARTIDA =  " + 
                            utils.getNumberOracle(this.numPartida.getValue()) + 
                            "  and mov.ID_PUESTO = " + 
                            utils.getNumberOracle(this.puesto.getValue()) + 
                            " and mov.NUMERO_PLAZA = " + 
                            utils.getNumberOracle(this.plaza1.getValue()) + 
                            " and to_date('" + 
                            utils.getFechaFormato3("dd/MM/yyyy", 
                                                   this.fecha_inicio.getValue()) + 
                            " ','dd/mm/yyyy') between mov.FECHA_INICIO and mov.FECHA_FIN";

                    Object existRegistro = interfaz.getValorConsultaSimple("registro_empleado", 
                                                        consulta);
                    if (existRegistro == null || existRegistro.equals(" ")) { // el registro no esta contratado en la plaza a bajar
                        utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR, 
                                                        "El registro de empleado que ingresó no esta contratado en la plaza que esta bajando por ampliación de horario "));
                        return null;
                    }
                } //Fin verificacion del registro

                if (fechaDictamen == null || fechaDictamen.equals(" ")) {
                    utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR, 
                                                    "La plaza se bajará por ampliación de horario y los datos en el dictamen son incorrectos, verifiquelos. "));
                    return null;
                } else { // existe la plaza para ampliacion de horario en el dictamen..
                    //Consultamos para ver si ya existe una baja por ampliacion de horario
                    consulta = 
                            "select mov.ID_ANEXO from sis_anexo an, sis_movimiento_plaza mov, sis_estado estado" + 
                            " where an.ID_ANEXO = mov.ID_ANEXO and an.ESTATUS = estado.ID_ESTADO and estado.nombre != 'ANULADO'" + 
                            "and mov.ID_PARTIDA =  " + 
                            utils.getNumberOracle(this.numPartida.getValue()) + 
                            "  and mov.ID_PUESTO = " + 
                            utils.getNumberOracle(this.puesto.getValue()) + 
                            " and mov.CORRELATIVO = to_number(to_char(to_date(' " + 
                            this.fecha_inicio.getValue().toString() + 
                            "' ,'yyyy-mm-dd')" + " ,'YYYY'))" + 
                            " and mov.NUMERO_PLAZA = " + 
                            utils.getNumberOracle(this.plaza1.getValue()) + 
                            " and mov.operacion = 'B' and mov.dictamen is not null and mov.numero is not null";

                    Object auxAnexo = interfaz.getValorConsultaSimple("id_anexo", consulta);
                    Date fechDictamen = utils.getFechaOracle(fechaDictamen.toString()); // fecha de inicio de la plaza segun dictamen

                    if (auxAnexo != null) { //existe una baja por ampliacion de horario 
                        utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR, 
                                                        "No se puede bajar la plaza, debido a que ya fue bajada para Ampliacion de horario, CONSULTE EL ANEXO No. " + 
                                                        auxAnexo));
                        return null;
                    }else if (fechDictamen.compareTo((Date)this.fecha_inicio.getValue()) > 0) { //verificamos que la fecha de inicio sea mayor o igual a la fecha de inicio de la ampliacion en el dictamen.
                        utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR, 
                                                        "La Fecha de inicio a bajar es incorrecta, la fecha para ampliación de horario segun  dictamen es:  " + 
                                                        fechaDictamen));
                        return null;
                    }
                }
            }else { // LA PLAZA NO SE BAJARA POR AMPLIACION DE HORARIO--------------------------------------
                //interfaz.cn_Cerrar_coneccion();
                if (fechaPromo != null) { // la plaza fue promovida o reclasificada
                    Date inicioPromo = utils.getFechaOracle(fechaPromo.toString().trim());
                    consulta = 
                            " select MOV.SUELDO_BASE from sis_movimiento_plaza mov, sis_anexo anexo, sis_estado estado" + 
                            " where mov.ID_ANEXO = anexo.ID_ANEXO and anexo.ESTATUS = estado.ID_ESTADO" + 
                            " and estado.NOMBRE = 'AUTORIZADO'" + 
                            " and mov.ID_PARTIDA = " + 
                            utils.getNumberOracle(this.numPartida.getValue()) + 
                            " and mov.NUMERO_PLAZA = " + 
                            utils.getNumberOracle(this.plaza1.getValue()) + 
                            " and mov.CORRELATIVO = to_number(to_char(sysdate,'yyyy'))" + 
                            " and to_date('" + 
                            utils.getFechaFormato3("dd/MM/yyyy", 
                                                   this.fecha_inicio.getValue()) + 
                            " ','dd/mm/yyyy') between mov.FECHA_INICIO and mov.FECHA_FIN\n" + 
                            " and mov.ID_PUESTO != " + 
                            utils.getNumberOracle(this.puesto.getValue()) + 
                            " and anexo.ID_TIPO_MOV_PLAZA != 5 and anexo.ID_TIPO_MOV_PLAZA != 6";
                    Object auxSueldo = interfaz.getValorConsultaSimple("sueldo_base", 
                                                        consulta);
                    if (inicioPromo.compareTo(utils.getFechaOracle(utils.getFechaFormato3("dd/MM/yyyy", 
                                                                                          this.fecha_inicio.getValue()))) <= 
                        0) { //fecha de inicio esta dentro de la promocion o reclasificacionif ( inicioPromo.compareTo(utils.getFechaOracle("dd/MM/yyyy",utils.getFechaFormato("dd/MM/yyyy", this.getFechaInicio())))<= 0 ){//fecha de inicio esta dentro de la promocion o reclasificacion                
                        if (auxSueldo != null) { //la plaza que se promovió habia sido bajada
                            consulta = 
                                    " select to_char(MOV.fecha_fin,'dd/mm/yyyy') as fecha_fin from sis_movimiento_plaza mov, sis_anexo anexo, sis_estado estado" + 
                                    " where mov.ID_ANEXO = anexo.ID_ANEXO and anexo.ESTATUS = estado.ID_ESTADO" + 
                                    " and estado.NOMBRE = 'AUTORIZADO'" + 
                                    " and mov.ID_PARTIDA = " + 
                                    utils.getNumberOracle(this.numPartida.getValue()) + 
                                    " and mov.NUMERO_PLAZA = " + 
                                    utils.getNumberOracle(this.plaza1.getValue()) + 
                                    " and mov.CORRELATIVO = to_number(to_char(sysdate,'yyyy'))" + 
                                    " and ( to_date('" + 
                                    utils.getFechaFormato3("dd/MM/yyyy", 
                                                           this.fecha_inicio.getValue()) + 
                                    " ','dd/mm/yyyy') between mov.FECHA_INICIO and mov.FECHA_FIN" + 
                                    " or to_date('" + 
                                    utils.getFechaFormato3("dd/MM/yyyy", 
                                                           this.fecha_fin.getValue()) + 
                                    " ','dd/mm/yyyy') between mov.FECHA_INICIO and mov.FECHA_FIN )" + 
                                    " and mov.ID_PUESTO != " + 
                                    utils.getNumberOracle(this.puesto.getValue()) + 
                                    " and anexo.ID_TIPO_MOV_PLAZA != 5 and anexo.ID_TIPO_MOV_PLAZA != 6";

                            Date finBaja = utils.getFechaOracle(interfaz.getValorConsultaSimple("fecha_fin", consulta).toString().trim());
                            interfaz.cn_Cerrar_coneccion();

                            if (finBaja.compareTo(utils.getFechaOracle(utils.getFechaFormato3("dd/MM/yyyy", 
                                                                                              this.fecha_fin.getValue()))) >= 
                                0) { //el periodo a bajar esta dentro de la baja antes de la promocion
                                Double sueldoAnexo = new Double(auxSueldo.toString().trim());
                                if (sueldoAnexo > 0) {
                                    /* **** PLAZAS QUE TIENEN LICENCIAS PARCIALES  **** */
                                    if (auxiliar != null) { //existe una licencia parcial en la plaza a bajar
                                        Double hrParciales = new Double(auxiliar.toString().trim());
                                        //System.out.println("las horas parciales "+ hrParciales.doubleValue());
                                        if (hrParciales > 0) {
                                            sueldo = new Double(this.sueldoBase.getValue().toString().trim());
                                            hor = new Double(this.horas.getValue().toString().trim());
                                            sueldo = sueldo.doubleValue() / hor.doubleValue();
                                            sueldo = sueldo.doubleValue() * hrParciales.doubleValue();
                                            sueldo = sueldo.doubleValue() - sueldoAnexo.doubleValue();
                                            varsueldo = redondear.format(sueldo.doubleValue());
                                            sueldoBase.setSubmittedValue(null);
                                            sueldoBase.setValue(varsueldo);
                                            horas.setSubmittedValue(null);
                                            horas.setValue(hrParciales.doubleValue());
                                            /* if(auxHoraPlaza != null){
                                             horaPlaza = new Double(auxHoraPlaza.toString().trim());
                                        }*/
                                            if (this.getComplemenSalarial() != 
                                                null) { //calculamos proporcionalmente el complemento de acuerdo a las horas parciales
                                                complemento = new Double(this.getComplemenSalarial().getValue().toString().trim());
                                                if (complemento > 0) {
                                                    complemento = complemento.doubleValue() / hor.doubleValue();
                                                    complemento = complemento.doubleValue() * hrParciales.doubleValue();
                                                    varComplemento = redondear.format(complemento.doubleValue());
                                                }
                                            }
                                            
                                            if (this.getEscalafon() != null) { //calculamos proporcionalmente el escalafon de acuerdo a las horas parciales
                                                escalafon = new Double(this.getEscalafon().getValue().toString().trim());
                                                if (escalafon > 0) {
                                                    escalafon = escalafon.doubleValue() / hor.doubleValue();
                                                    escalafon = escalafon.doubleValue() * hrParciales.doubleValue();
                                                    varEscalafon = redondear.format(escalafon.doubleValue());
                                                }
                                            }
                                            this.complemenSalarial.setSubmittedValue(null);
                                            this.complemenSalarial.setValue(varComplemento);
                                            this.escalafon.setSubmittedValue(null);
                                            this.escalafon.setValue(varEscalafon);
                                            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                                                        "#{bindings.Escalafon.inputValue}", 
                                                                        utils.getNumberOracle(varEscalafon));
                                            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                                                        "#{bindings.ComplSalarial.inputValue}", 
                                                                        utils.getNumberOracle(varComplemento));

                                            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                                                        "#{bindings.SueldoBase.inputValue}", 
                                                                        utils.getNumberOracle(varsueldo));
                                            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                                                        "#{bindings.CantidadHoras.inputValue}", 
                                                                        utils.getNumberOracle(hrParciales.doubleValue()));
                                            sis_movimiento_plazaRowImpl varMovimiento = 
                                                (sis_movimiento_plazaRowImpl)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                                                                                        "#{bindings.sis_movimiento_plaza1Iterator.currentRow}");
                                            varMovimiento.setSueldoBase(utils.getNumberOracle(varsueldo));
                                            varMovimiento.setCantidadHoras(utils.getNumberOracle(hrParciales.doubleValue()));
                                            varMovimiento.setEscalafon(utils.getNumberOracle(varEscalafon));
                                            varMovimiento.setComplSalarial(utils.getNumberOracle(varComplemento));
                                            utils.setADFMensaje(new resulOp(resulOp.OPE_WARN, 
                                                                            "La plaza tiene una licencia parcial, el sueldo base y el no. de horas fueron modificadas"));

                                        } else { // por aquello de que agarre basura
                                            sueldo = new Double(this.sueldoBase.getValue().toString().trim());
                                            sueldo = sueldo.doubleValue() - sueldoAnexo.doubleValue();
                                            varsueldo = redondear.format(sueldo.doubleValue());
                                            sueldoBase.setSubmittedValue(null);
                                            sueldoBase.setValue(varsueldo);

                                            /* **************VERIFICAR ESTA PARTE CUANDO SE BAJO ANTES DE LA PROMOSION***************    */
                                            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                                                        "#{bindings.SueldoBase.inputValue}", 
                                                                        utils.getNumberOracle(varsueldo));
                                            sis_movimiento_plazaRowImpl varMovimiento = 
                                                (sis_movimiento_plazaRowImpl)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                                                                                        "#{bindings.sis_movimiento_plaza1Iterator.currentRow}");
                                            varMovimiento.setSueldoBase(utils.getNumberOracle(varsueldo));

                                            utils.setADFMensaje(new resulOp(resulOp.OPE_WARN, 
                                                                            "La plaza fue bajada antes de ser promovida, el sueldo base  fue modificado"));
                                        }

                                    } else { // la plaza no tiene ninguna licencia parcial
                                        sueldo = new Double(this.sueldoBase.getValue().toString().trim());
                                        sueldo = sueldo.doubleValue() - sueldoAnexo.doubleValue();
                                        varsueldo = redondear.format(sueldo.doubleValue());
                                        sueldoBase.setSubmittedValue(null);
                                        sueldoBase.setValue(varsueldo);

                                        /* **************VERIFICAR ESTA PARTE CUANDO SE BAJO ANTES DE LA PROMOSION***************    */

                                        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                                                    "#{bindings.SueldoBase.inputValue}", 
                                                                    utils.getNumberOracle(varsueldo));
                                        sis_movimiento_plazaRowImpl varMovimiento = 
                                            (sis_movimiento_plazaRowImpl)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                                                                                    "#{bindings.sis_movimiento_plaza1Iterator.currentRow}");
                                        varMovimiento.setSueldoBase(utils.getNumberOracle(varsueldo));
                                        utils.setADFMensaje(new resulOp(resulOp.OPE_WARN, 
                                                                        "La plaza fue bajada antes de ser promovida, el sueldo base  fue modificado"));
                                    }
                                    // FIN DE LAS LICENCIAS PARCIALES


                                } // fin sueldo anexo
                                else { // por aquello que haya agarrado basura, jejejee
                                    /* **** PLAZAS QUE TIENEN LICENCIAS PARCIALES  **** */
                                    if (auxiliar != null) { //existe una licencia parcial en la plaza a bajar
                                        Double hrParciales = new Double(auxiliar.toString().trim());
                                        //System.out.println("las horas parciales "+ hrParciales.doubleValue());
                                        if (hrParciales > 0) {
                                            sueldo = new Double(this.sueldoBase.getValue().toString().trim());
                                            hor = new Double(this.horas.getValue().toString().trim());
                                            sueldo = sueldo.doubleValue() / hor.doubleValue();
                                            sueldo = sueldo.doubleValue() * hrParciales.doubleValue();
                                            varsueldo = redondear.format(sueldo.doubleValue());
                                            sueldoBase.setSubmittedValue(null);
                                            sueldoBase.setValue(varsueldo);
                                            horas.setSubmittedValue(null);
                                            horas.setValue(hrParciales.doubleValue());

                                            if (this.getComplemenSalarial() != null) { //calculamos proporcionalmente el complemento de acuerdo a las horas parciales
                                                complemento = new Double(this.getComplemenSalarial().getValue().toString().trim());
                                                if (complemento > 0) {
                                                    complemento = complemento.doubleValue() / hor.doubleValue();
                                                    complemento = complemento.doubleValue() * hrParciales.doubleValue();
                                                    varComplemento = redondear.format(complemento.doubleValue());
                                                }
                                            }
                                            
                                            if (this.getEscalafon() != null) { //calculamos proporcionalmente el escalafon de acuerdo a las horas parciales
                                                escalafon = new Double(this.getEscalafon().getValue().toString().trim());
                                                if (escalafon > 0) {
                                                    escalafon = escalafon.doubleValue() / hor.doubleValue();
                                                    escalafon = escalafon.doubleValue() * hrParciales.doubleValue();
                                                    varEscalafon = redondear.format(escalafon.doubleValue());
                                                }
                                            }
                                            this.complemenSalarial.setSubmittedValue(null);
                                            this.complemenSalarial.setValue(varComplemento);
                                            this.escalafon.setSubmittedValue(null);
                                            this.escalafon.setValue(varEscalafon);

                                            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                                                        "#{bindings.ComplSalarial.inputValue}", 
                                                                        utils.getNumberOracle(varComplemento));
                                            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                                                        "#{bindings.Escalafon.inputValue}", 
                                                                        utils.getNumberOracle(varEscalafon));
                                            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                                                        "#{bindings.SueldoBase.inputValue}", 
                                                                        utils.getNumberOracle(varsueldo));
                                            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                                                        "#{bindings.CantidadHoras.inputValue}", 
                                                                        utils.getNumberOracle(hrParciales.doubleValue()));
                                            sis_movimiento_plazaRowImpl varMovimiento = 
                                                (sis_movimiento_plazaRowImpl)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                                                                                        "#{bindings.sis_movimiento_plaza1Iterator.currentRow}");
                                            varMovimiento.setSueldoBase(utils.getNumberOracle(varsueldo));
                                            varMovimiento.setCantidadHoras(utils.getNumberOracle(hrParciales.doubleValue()));

                                            varMovimiento.setEscalafon(utils.getNumberOracle(varEscalafon));
                                            varMovimiento.setComplSalarial(utils.getNumberOracle(varComplemento));
                                            utils.setADFMensaje(new resulOp(resulOp.OPE_WARN, 
                                                                            "La plaza tiene una licencia parcial, el sueldo base y el No. De horas fueron modificadas"));
                                        }
                                    } // FIN DE LAS LICENCIAS PARCIALES
                                } /// fin else  sueldoAnexo
                            } // finBaja(la fecha a bajar esta dentro del rango aceptado 
                            else { // la fecha a bajar no esta dentro del rango de la fecha de la plaza que se promovio o reclasifico
                                interfaz.cn_Cerrar_coneccion();
                                utils.setADFMensaje(new resulOp(resulOp.OPE_WARN, 
                                                                "No se puede bajar la plaza porque fue bajada y luego promovida, el rango de fechas es invalido. Si desea utilizar la diferencia entre el puesto anterior y el actual utilice un periodo dentro del rango del   " + 
                                                                utils.getFechaFormato("dd/MM/yyyy", 
                                                                                      inicioPromo.getValue()) + 
                                                                "  al  " + 
                                                                utils.getFechaFormato("dd/MM/yyyy", 
                                                                                      finBaja.getValue())));
                            } // fin else de finBaja
                        } // fin auxSueldo(la plaza estaba bajada cuando se promovio)
                        else { // la plaza no fue dado de baja antes de su promocion o reclasificacion
                            /* **** PLAZAS QUE TIENEN LICENCIAS PARCIALES  **** */
                            if (auxiliar != null) { //existe una licencia parcial en la plaza a bajar
                                Double hrParciales = new Double(auxiliar.toString().trim());
                                //System.out.println("las horas parciales "+ hrParciales.doubleValue());
                                if (hrParciales > 0) {
                                    sueldo = new Double(this.sueldoBase.getValue().toString().trim());
                                    hor = new Double(this.horas.getValue().toString().trim());
                                    sueldo = sueldo.doubleValue() / hor.doubleValue();
                                    sueldo = sueldo.doubleValue() * hrParciales.doubleValue();
                                    varsueldo = redondear.format(sueldo.doubleValue());
                                    sueldoBase.setSubmittedValue(null);
                                    sueldoBase.setValue(varsueldo);
                                    horas.setSubmittedValue(null);
                                    horas.setValue(hrParciales.doubleValue());

                                    if (this.getComplemenSalarial() != null) { //calculamos proporcionalmente el complemento de acuerdo a las horas parciales
                                        complemento = new Double(this.getComplemenSalarial().getValue().toString().trim());
                                        if (complemento > 0) {
                                            complemento = complemento.doubleValue() / hor.doubleValue();
                                            complemento = complemento.doubleValue() * hrParciales.doubleValue();
                                            varComplemento = redondear.format(complemento.doubleValue());
                                        }
                                    }
                                    
                                    if (this.getEscalafon() != null) { //calculamos proporcionalmente el escalafon de acuerdo a las horas parciales
                                        escalafon = new Double(this.getEscalafon().getValue().toString().trim());
                                        if (escalafon > 0) {
                                            escalafon = escalafon.doubleValue() / hor.doubleValue();
                                            escalafon = escalafon.doubleValue() * hrParciales.doubleValue();
                                            varEscalafon = redondear.format(escalafon.doubleValue());
                                        }
                                    }
                                    this.complemenSalarial.setSubmittedValue(null);
                                    this.complemenSalarial.setValue(varComplemento);
                                    this.escalafon.setSubmittedValue(null);
                                    this.escalafon.setValue(varEscalafon);

                                    JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                                                "#{bindings.ComplSalarial.inputValue}", 
                                                                utils.getNumberOracle(varComplemento));
                                    JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                                                "#{bindings.Escalafon.inputValue}", 
                                                                utils.getNumberOracle(varEscalafon));

                                    JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                                                "#{bindings.SueldoBase.inputValue}", 
                                                                utils.getNumberOracle(varsueldo));
                                    JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                                                "#{bindings.CantidadHoras.inputValue}", 
                                                                utils.getNumberOracle(hrParciales.doubleValue()));
                                    sis_movimiento_plazaRowImpl varMovimiento = 
                                        (sis_movimiento_plazaRowImpl)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                                                                                "#{bindings.sis_movimiento_plaza1Iterator.currentRow}");
                                    varMovimiento.setSueldoBase(utils.getNumberOracle(varsueldo));
                                    varMovimiento.setCantidadHoras(utils.getNumberOracle(hrParciales.doubleValue()));

                                    varMovimiento.setEscalafon(utils.getNumberOracle(varEscalafon));
                                    varMovimiento.setComplSalarial(utils.getNumberOracle(varComplemento));
                                    utils.setADFMensaje(new resulOp(resulOp.OPE_WARN, 
                                                                    "La plaza tiene una licencia parcial, el sueldo base y el No. De horas fueron modificadas "));

                                }
                            } // FIN DE LAS LICENCIAS PARCIALES

                        } //fin else
                    } // fin inicioPromo (La fecha de inicio de la baja esta dentro del rango de la fecha de inicio de la promocion)
                    else { // la plaza fue promovida o reclasificada y se esta bajando con una fecha antes de su promocion
                        interfaz.cn_Cerrar_coneccion();
                        utils.setADFMensaje(new resulOp(resulOp.OPE_WARN, 
                                                        "El rango de fechas es invalido debido a que fue promovida o reclasificada, la fecha de inicio debe ser igual o mayor al   " + 
                                                        utils.getFechaFormato("dd/MM/yyyy", 
                                                                              inicioPromo.getValue())));
                    }
                } //fin fechaPromo(hubo una promocion o reclasificacion)
                else { //la plaza no fue promovida ni reclasificada
                    interfaz.cn_Cerrar_coneccion();
                    if (auxiliar != null) { //existe una licencia parcial en la plaza a bajar
                        Double hrParciales = new Double(auxiliar.toString().trim());
                        //System.out.println("las horas parciales "+ hrParciales.doubleValue());
                        if (hrParciales > 0) {
                            sueldo = new Double(this.sueldoBase.getValue().toString().trim());
                            hor = new Double(this.horas.getValue().toString().trim());
                            sueldo = sueldo.doubleValue() / hor.doubleValue();
                            sueldo = sueldo.doubleValue() * hrParciales.doubleValue();
                            varsueldo = redondear.format(sueldo.doubleValue());
                            sueldoBase.setSubmittedValue(null);
                            sueldoBase.setValue(varsueldo);
                            horas.setSubmittedValue(null);
                            horas.setValue(hrParciales.doubleValue());

                            if (this.getComplemenSalarial() != null) { //calculamos proporcionalmente el complemento de acuerdo a las horas parciales
                                complemento = new Double(this.getComplemenSalarial().getValue().toString().trim());
                                if (complemento > 0) {
                                    complemento = complemento.doubleValue() / hor.doubleValue();
                                    complemento = complemento.doubleValue() * hrParciales.doubleValue();
                                    varComplemento = redondear.format(complemento.doubleValue());
                                }
                            }
                            
                            if (this.getEscalafon() != null) { //calculamos proporcionalmente el escalafon de acuerdo a las horas parciales
                                escalafon = new Double(this.getEscalafon().getValue().toString().trim());
                                if (escalafon > 0) {
                                    escalafon = escalafon.doubleValue() / hor.doubleValue();
                                    escalafon = escalafon.doubleValue() * hrParciales.doubleValue();
                                    varEscalafon = redondear.format(escalafon.doubleValue());
                                }
                            }
                            this.complemenSalarial.setSubmittedValue(null);
                            this.complemenSalarial.setValue(varComplemento);
                            this.escalafon.setSubmittedValue(null);
                            this.escalafon.setValue(varEscalafon);

                            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                                        "#{bindings.ComplSalarial.inputValue}", 
                                                        utils.getNumberOracle(varComplemento));
                            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                                        "#{bindings.Escalafon.inputValue}", 
                                                        utils.getNumberOracle(varEscalafon));

                            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                                        "#{bindings.SueldoBase.inputValue}", 
                                                        utils.getNumberOracle(varsueldo));
                            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                                        "#{bindings.CantidadHoras.inputValue}", 
                                                        utils.getNumberOracle(hrParciales.doubleValue()));
                            sis_movimiento_plazaRowImpl varMovimiento = 
                                (sis_movimiento_plazaRowImpl)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                                                                        "#{bindings.sis_movimiento_plaza1Iterator.currentRow}");
                            varMovimiento.setSueldoBase(utils.getNumberOracle(varsueldo));
                            varMovimiento.setCantidadHoras(utils.getNumberOracle(hrParciales.doubleValue()));

                            varMovimiento.setEscalafon(utils.getNumberOracle(varEscalafon));
                            varMovimiento.setComplSalarial(utils.getNumberOracle(varComplemento));
                            utils.setADFMensaje(new resulOp(resulOp.OPE_WARN, 
                                                            "La plaza tiene una licencia parcial, el sueldo base y el no. De horas fueron modificadas"));
                        }
                    } // FIN DE LAS LICENCIAS PARCIALES
                } // fin else de inicio promocion
            } //fin else de bajas por ampliacion de horario

            botonEjecutar.setDisabled(true);
            botonGuardar.setDisabled(false);
            botonCrear.setDisabled(false);
            this.listPartida.setDisabled(true);
            this.listPuesto.setDisabled(true);

            this.listPeriodo.setDisabled(true);
            this.tipOperacion.setDisabled(true);
            interfaz.cn_Cerrar_coneccion();
        }

        /*  BindingContainer bindings = getBindings();
        OperationBinding operationBinding =
            bindings.getOperationBinding("Execute");
        Object result = operationBinding.execute();

        //sueldoBase.setValue();

        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }*/
        //  refreshCurrentPage();
        //verificando que la fecha de inicio no sea mayor a la fecha de finalizacion
        Date aux = 
            utils.getFechaOracle(utils.getFechaFormato3("dd/MM/yyyy", this.getFecha_inicio().getValue()));
        Date aux1 = 
            utils.getFechaOracle(utils.getFechaFormato3("dd/MM/yyyy", this.getFecha_fin().getValue()));
        if (aux.compareTo(aux1) > 0) {
            botonEjecutar.setDisabled(false);
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR, 
                                            "La fecha de inicio es mayor que la fecha fin "));
            return null;
        }
        botonGuardar.setDisabled(false); // agregado para la actualizacion


        //codigo para la validadcion de la ampliacion de horario

        boolean resultado;
        resultado = JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(), "Commit");
        /* BindingContainer bindings = getBindings();
         OperationBinding operationBinding =
             bindings.getOperationBinding("Commit");
         Object result = operationBinding.execute();
        */
        if (resultado == true) {
            //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ExeDocPagoAnualdo");
            botonReporte.setDisabled(false);
            botonCrear.setDisabled(false);
            botonAnexo_autorizar.setDisabled(false);

            horas.setDisabled(true);
            //correlativo.setDisabled(true);
            sueldoBase.setDisabled(true);
            escalafon.setDisabled(true);
            complemenSalarial.setDisabled(true);
            plaza1.setDisabled(true);
            listPeriodo.setDisabled(true);
            // dictamen.setRendered(true);
            nombrePlaza.setRendered(true);
            tipOperacion.setDisabled(true);
            listPartida.setDisabled(true);
            listPuesto.setDisabled(true);

            listPlaza.setDisabled(true);
            //botonEjecutar.setDisabled(false);
            dictamen.setDisabled(true);
            nombrePlaza.setDisabled(true);
            regEmpleado.setRendered(false);
            facTiempo.setDisabled(true);
            this.dictamenAnio.setDisabled(false);
            this.dictamenEmitido.setDisabled(false);
            this.dictamenNumero.setDisabled(false);
            this.fecha_inicio.setDisabled(true);
            this.fecha_fin.setDisabled(true);
            this.lisTipDoc.setDisabled(true);
            this.botonGuardar.setDisabled(true);
            utils.setADFMensaje(new resulOp(resulOp.OPE_OK, "Datos guardados correctamente."));
            //this.cmd_link_sis_22.setDisabled(false);
        } else {
            this.botonGuardar.setDisabled(false);
        }

        return null;
    }


    public void calculo_sueldo(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        /* Object varsueldo = sueldoBase.getValue();
         Object varhora = horas.getValue();
         Integer sueldo =  Integer.parseInt(varsueldo.toString().trim());
         Integer hor = Integer.parseInt(varhora.toString().trim());
         sueldo = sueldo * hor;
         varsueldo = sueldo;
         sueldoBase.setSubmittedValue(null);
         sueldoBase.setValue(varsueldo);
         sueldoBase.setPartialTriggers(new String[]{"idHoras"});
         */
    }

    public void setVarMinimo(CoreInputText varMinimo) {
        this.varMinimo = varMinimo;
    }

    public CoreInputText getVarMinimo() {
        return varMinimo;
    }


    public void setBotonGuardar(CoreCommandButton botonGuardar) {
        this.botonGuardar = botonGuardar;
    }

    public CoreCommandButton getBotonGuardar() {
        return botonGuardar;
    }

    public void setBotonReporte(CoreCommandButton botonReporte) {
        this.botonReporte = botonReporte;
    }

    public CoreCommandButton getBotonReporte() {
        return botonReporte;
    }

    public void setBotonEjecutar(CoreCommandButton botonEjecutar) {
        this.botonEjecutar = botonEjecutar;
    }

    public CoreCommandButton getBotonEjecutar() {
        return botonEjecutar;
    }

    public void setBotonCrear(CoreCommandButton botonCrear) {
        this.botonCrear = botonCrear;
    }

    public CoreCommandButton getBotonCrear() {
        return botonCrear;
    }

    public String btn_crearDetalle_anexo() {

        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("Create1");
        Object result = operationBinding.execute();
        /*FiltraUnidad= accion que paso los parametros */
        // JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), "filtraUnidad");
        //   btnCrear_anexo.setDisabled(true);
        //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"filtraPartida");
        this.lisTipDoc.setDisabled(true);
        this.lisDependencia.setDisabled(true);
        this.listUnidad.setDisabled(true); //deshabilita el combo de los subprogramas
        formDetalle.setRendered(true); //muestra el formulario para llenar el detalle
        horas.setDisabled(false);
        //correlativo.setDisabled(false);
        sueldoBase.setDisabled(false);
        escalafon.setDisabled(false);
        complemenSalarial.setDisabled(false);
        plaza1.setDisabled(false);
        puesto.setDisabled(false);
        dictamen.setDisabled(false);
        nombrePlaza.setDisabled(false);
        tipOperacion.setDisabled(false);
        listPartida.setDisabled(false);
        listPuesto.setDisabled(false);

        listPlaza.setDisabled(false);
        fecha_inicio.setDisabled(false);
        fecha_fin.setDisabled(false);
        regEmpleado.setDisabled(false);
        facTiempo.setDisabled(false);
        regEmpleado.setRendered(true);
        this.dictamenEmitido.setDisabled(false);
        this.dictamenAnio.setDisabled(false);
        this.dictamenNumero.setDisabled(false);
        this.listPeriodo.setDisabled(false);
        this.lisTipDoc.setDisabled(false);

        botonEjecutar.setDisabled(false);
        //dictamen.setRendered(true);
        nombrePlaza.setRendered(true);
        botonEjecutar.setDisabled(false);
        botonCrear.setDisabled(true);
        botonGuardar.setDisabled(false);

        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }

        // System.out.println("selecccionar unidad tiene "+ selecUnidad);
        // Add event code here...
        this.plaza1.setSubmittedValue(null);
        this.plaza1.setValue("");
        this.correlativo.setSubmittedValue(null);
        this.correlativo.setValue("");
        return null;
    }

    public void setListPeriodo(CoreSelectOneChoice listPeriodo) {
        this.listPeriodo = listPeriodo;
    }

    public CoreSelectOneChoice getListPeriodo() {
        return listPeriodo;
    }
    //devuelve si fue o no seleccionado la unidad.

    public boolean getSelecUnidad() {

        return selecUnidad;
    }

    public void seleccionarDependencia(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        //System.out.println("estoy en selecccionar dependencia  "+ selecUnidad);
        selecUnidad = true;
        //System.out.println("sali de selecccionar dependencia  "+ selecUnidad);
    }
    // calula el No. de plaza correspondiente a la nueva plaza a crear
    //segun el No. maximo en la tabla sis_plaza y en la tabla sis_movimiento_plaza

    public void calculoNumPlaza(ValueChangeEvent valueChangeEvent) {
        interfaz_DB consulta = new interfaz_DB();
        ResultSet resultado;
        //int anio; modificado
        Number anio;
        int varPartida, varPartida2;
        int valActual;
        Integer ComboPartida;
        Object auxiliar;
        //Calendar varFecha = Calendar.getInstance();
        varPartida = -1;
        varPartida2 = -1;
        valActual = -1;
        Object varAnio = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), "#{flujo_usuario.anioActual}");
        //anio = varFecha.get(Calendar.YEAR); modificado
        anio = utils.getNumber(varAnio);
        varPartida = Integer.parseInt(numPartida.getValue().toString());
        ComboPartida = (Integer)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), "#{bindings.comboPartida1.inputValue}");
        this.correlativo.setSubmittedValue(anio);
        this.correlativo.setValue(anio);
        // traemos los No. maximos correspondientes 
        resultado = 
                consulta.Bol_ejecutar_sentencia("select (select nvl( max (numero_plaza),0) from sis_plaza where id_partida = " + 
                                                varPartida + " and correlativo = " + anio + " ) as plaza," + 
                                                "(select nvl(max (mov.numero_plaza),0) from sis_movimiento_plaza mov,sis_anexo anexo where mov.id_partida = " + 
                                                varPartida + 
                                                " and mov.id_anexo = anexo.id_anexo and anexo.estatus !=46 and mov.correlativo =" + 
                                                anio + " ) as movimiento_plaza from dual");
        //System.out.println("voy a entrar al tryyyy");  
        //asignamos el No. de la nueva plaza
        try {
            resultado.next();
            auxiliar = resultado.getObject("plaza");
            varPartida = 1 + Integer.parseInt(auxiliar.toString());
            auxiliar = resultado.getObject("movimiento_plaza");
            varPartida2 = 1 + Integer.parseInt(auxiliar.toString());
            valActual = this.plaza1.getValue() != null ? Integer.parseInt(this.plaza1.getValue().toString()) : 0;
            // System.out.println("la partida es " + varPartida);
        } catch (SQLException e) {
            // TODO
        }
        consulta.cn_Cerrar_coneccion();
        if (varPartida >= varPartida2) {
            if (valActual < varPartida || ComboPartida < 3) {
                plaza1.setSubmittedValue(varPartida);
                plaza1.setValue(varPartida);
                if (ComboPartida.intValue() < 3) {
                    if (valActual == 0) {
                        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                                    "#{bindings.comboPartida1.inputValue}", 
                                                    new Integer(3));
                    } else {
                        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                                    "#{bindings.comboPartida1.inputValue}", 
                                                    new Integer(ComboPartida.intValue() + 
                                                                1));
                    }
                }
            } else {
                plaza1.setSubmittedValue(valActual);
                plaza1.setValue(valActual);
            }
        } else {
            if (valActual < varPartida2 || ComboPartida < 3) {
                plaza1.setSubmittedValue(varPartida2);
                plaza1.setValue(varPartida2);
                if (ComboPartida.intValue() < 3) {
                    if (valActual == 0) {
                        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                                    "#{bindings.comboPartida1.inputValue}", 
                                                    new Integer(3));
                    } else {
                        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                                    "#{bindings.comboPartida1.inputValue}", 
                                                    new Integer(ComboPartida.intValue() + 
                                                                1));
                    }
                }
            } else {
                plaza1.setSubmittedValue(valActual);
                plaza1.setValue(valActual);
            }
        }
        this.correlativo.setSubmittedValue(anio);
        this.correlativo.setValue(anio);
    }


    public void setListPartida(CoreSelectOneChoice listPartida) {
        this.listPartida = listPartida;
    }

    public CoreSelectOneChoice getListPartida() {
        return listPartida;
    }

    public void setNumPartida(CoreInputText numPartida) {
        this.numPartida = numPartida;
    }

    public CoreInputText getNumPartida() {
        return numPartida;
    }
    //metodo que utiliza el boton autorizar para trasladar o autorizar un anexo.

    public String btn_autorizar() {
        // Add event code here...
        util_dialog_adf vDialog = new util_dialog_adf();
        Object vVariable, vEstado;
        vVariable = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), "#{bindings.IdAnexo.inputValue}");
        vEstado = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), "#{bindings.Estatus.inputValue}");

        interfaz_DB interfaz = new interfaz_DB();
        String Consulta = "select id_programa from sis_partida where id_partida =  " + utils.getNumberOracle(this.numPartida.getValue());

        Object varPlan = interfaz.getValorConsultaSimple("id_programa", Consulta);
        interfaz.cn_Cerrar_coneccion();
        // System.out.println("voy a entrar al dialogo");
        if (varPlan.toString().trim().equals("48") || varPlan.toString().trim().equals("49")) {
            //System.out.println("voy a entrar al dialogo " + varPlan);
            vDialog.abrir_dialogo_autorizacion(FacesContext.getCurrentInstance(), "ANEXO_A_INVESTIGACION", vVariable, vEstado, "innecesario");
        } else {
            vDialog.abrir_dialogo_autorizacion(FacesContext.getCurrentInstance(), "ANEXO_A", vVariable, vEstado, "innecesario");
        }

        return null;
    }

    public void autorizacion_return(ReturnEvent returnEvent) {
        //System.out.println("Ya sali autorizacion anexo");
    }
    // los siguientes 2 metodos son utilizados para manejar las propiedades del boton regresar que se encuenta en la pagina /gestiones/consul_detall_anexo.jspx

    public void setBotonRegresar(CoreCommandButton botonRegresar) {
        this.botonRegresar = botonRegresar;
    }

    public CoreCommandButton getBotonRegresar() {
        return botonRegresar;
    }
    //metodo asociado al boton regresar de la pagina /gestiones/consul_detall_anexo.jspx
    //basicamente sera utilizado para manipular la navegacion de la pagina hacia la pagina de busqueda del anexo dependiendo del rol del usuario.

    public String btn_regresar() {
        // Add event code here...
        Object varUsuario = "";
        //varUsuario = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{flujo_usuario.perfilesEmpleadoLogin}");
        varUsuario = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), "#{roles_usuario.profesionalPresupuesto}");
        //System.out.println("el usuario logueado es  " + varUsuario );
        if (varUsuario.equals(true)) {
            return "consul_presupuesto";
        } else {
            return "consul_anexo";
        }
    }
    //los siguientes 2 metodos son utilizados para manejar las propiedades del boton autorizar de la pagina /gestiones/anexo.jspx

    public void setBotonAnexo_autorizar(CoreCommandButton botonAnexo_autorizar) {
        this.botonAnexo_autorizar = botonAnexo_autorizar;
    }

    public CoreCommandButton getBotonAnexo_autorizar() {
        return botonAnexo_autorizar;
    }

    public void setDictamen(CoreInputText dictamen) {
        this.dictamen = dictamen;
    }

    public CoreInputText getDictamen() {
        return dictamen;
    }

    public void setNombrePlaza(CoreInputText nombrePlaza) {
        this.nombrePlaza = nombrePlaza;
    }

    public CoreInputText getNombrePlaza() {
        return nombrePlaza;
    }

    //metodo utilizado para el boton modificar de la pagina gestiones/consul_detall_anexo

    public String btn_modificar() {
        //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Rollback");

        Object varTipAnexo = 0;
        Object varPartida = 0;
        usuario.set_opciones(usuario.VISTA_OPERACION, 1);
        //obtengo el valor del tipo del documento, "transferencia, promocion, etc."
        varTipAnexo = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), "#{bindings.IdTipoMovPlaza.inputValue}");
        Integer valTipAnexo = Integer.parseInt(varTipAnexo.toString().trim());
        varPartida = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), "#{bindings.IdPartida.inputValue}");

        if (valTipAnexo < 5) { //es una anexo A
            interfaz_DB interfaz = new interfaz_DB();
            String Consulta = "select id_programa from sis_partida where id_partida =  " + varPartida;
            Object varPlan = interfaz.getValorConsultaSimple("id_programa", Consulta);
            interfaz.cn_Cerrar_coneccion();
            //System.out.println("el plan es "+ varPlan);
            if (varPlan.toString().trim().equals("48") || varPlan.toString().trim().equals("49")) {
                return "mod_plan48";
            } else {
                return "modificar";
            }
        } else { //es un anexo de promocion o reclasificacion
            return "modi_anexoPromocion";
        }
    }

    public String pruebaSetWithkey() {
        // Add event code here...
        unidades_ejecRowImpl auxVista;
        JUIteratorBinding vIterBinding;
        vIterBinding = 
                (JUIteratorBinding)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                                              "#{bindings.unidades_ejecIterator}");
        // vIterBinding.getViewObject().setCurrentRow( vIterBinding.getViewObject().getAllRowsInRange()[3]); 
        Object Var[] = vIterBinding.getViewObject().getAllRowsInRange();
        int tamano = 0;
        while (tamano < Var.length) {
            //System.out.println(" n se "+ Var[tamano].toString());
            auxVista = (unidades_ejecRowImpl)Var[tamano];
            if (auxVista.getIdDependencia().compareTo(8) == 0 && 
                auxVista.getIdPrograma().compareTo(41) == 0 && 
                auxVista.getIdUnidad().compareTo(202) == 0) {
                vIterBinding.getViewObject().setCurrentRow(vIterBinding.getViewObject().getAllRowsInRange()[tamano]);
                tamano = Var.length;
            }
            tamano = tamano + 1;
        }

        //System.out.println("tamaño de objetos " + Var.length);
        /*
             String vKeyRow= vIterBinding.getCurrentRowKeyString();
                  System.out.println(" llave " + vKeyRow);
                  System.out.println(" llave " + vIterBinding.getCurrentRowWithKeyValue());

         Key otros = new Key(new Object [] {new oracle.jbo.domain.Number(41),new oracle.jbo.domain.Number(8),new oracle.jbo.domain.Number(202)});
                 //otros.getKeyValues()
                 System.out.println(" llave 2 " + otros.toStringFormat(true));
                 vIterBinding.setCurrentRowWithKey(otros.toStringFormat(true));
                 */
        /*
         Key auxiliar = new Key(new Object[]{utils.getNumberOracle(41),utils.getNumberOracle(8),utils.getNumberOracle(202)});
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.valRowkey.inputValue}",auxiliar.toStringFormat(true));
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"setCurrentRowWithKey"); */
        // System.out.println("solo para parar jejeje");
        return null;

    }

    //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"obtenerUnidad");

    public String btn_modificarPlazas() {
        if (tipOperacion.getValue().equals("B")) {
            horas.setDisabled(true);
            //correlativo.setDisabled(true);
            sueldoBase.setDisabled(true);
            escalafon.setDisabled(true);
            complemenSalarial.setDisabled(true);
            plaza1.setDisabled(true);
            listPeriodo.setDisabled(true);
            // dictamen.setRendered(true); 
            nombrePlaza.setRendered(true);
            tipOperacion.setDisabled(true);
            listPartida.setDisabled(true);
            listPuesto.setDisabled(true);
            interfaz_DB interfaz = new interfaz_DB();

            listPlaza.setDisabled(true);
            botonEjecutar.setDisabled(false);
            dictamen.setDisabled(true);
            nombrePlaza.setDisabled(true);
            regEmpleado.setRendered(false);
            facTiempo.setDisabled(true);
            this.dictamenAnio.setDisabled(false);
            this.dictamenEmitido.setDisabled(false);
            this.dictamenNumero.setDisabled(false);
            this.fecha_inicio.setDisabled(true);
            this.fecha_fin.setDisabled(true);
        } else {
            horas.setDisabled(true);
            //correlativo.setDisabled(true);
            sueldoBase.setDisabled(true);
            escalafon.setDisabled(true);
            complemenSalarial.setDisabled(true);
            plaza1.setDisabled(false);
            puesto.setDisabled(true);
            dictamen.setDisabled(false);
            nombrePlaza.setDisabled(false);
            tipOperacion.setDisabled(true);
            listPartida.setDisabled(true);
            listPuesto.setDisabled(true);
            listPlaza.setDisabled(true);
            botonEjecutar.setDisabled(false);
            //dictamen.setRendered(true);
            nombrePlaza.setRendered(true);
            regEmpleado.setRendered(true);
            facTiempo.setDisabled(true);
            regEmpleado.setDisabled(false);
            
            this.dictamenAnio.setDisabled(false);
            this.dictamenEmitido.setDisabled(false);
            this.dictamenNumero.setDisabled(false);
            this.fecha_fin.setDisabled(true);
            this.fecha_inicio.setDisabled(true);
            this.listPeriodo.setDisabled(true);
            //this.partidaSicoin.setDisabled(false);    //Se deshabilita por no continuar SICOIN
        }
        formDetalle.setRendered(true); //muestra el formulario para llenar el detalle
        //this.botonGuardar.setDisabled(false);
        this.lisTipDoc.setDisabled(false);
        return null;
    }

    public String btn_borrar() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("Delete");
        Object result = operationBinding.execute();
        botonGuardar.setDisabled(false);

        horas.setDisabled(true);
        //correlativo.setDisabled(true);
        sueldoBase.setDisabled(true);
        escalafon.setDisabled(true);
        complemenSalarial.setDisabled(true);
        plaza1.setDisabled(true);
        listPeriodo.setDisabled(true);
        // dictamen.setRendered(true);
        nombrePlaza.setRendered(true);
        tipOperacion.setDisabled(true);
        listPartida.setDisabled(true);
        listPuesto.setDisabled(true);
        this.listPuesto.setDisabled(true);
        listPlaza.setDisabled(true);
        //botonEjecutar.setDisabled(false);
        dictamen.setDisabled(true);
        nombrePlaza.setDisabled(true);
        regEmpleado.setRendered(false);
        facTiempo.setDisabled(true);
        this.dictamenAnio.setDisabled(false);
        this.dictamenEmitido.setDisabled(false);
        this.dictamenNumero.setDisabled(false);
        this.fecha_inicio.setDisabled(true);
        this.fecha_fin.setDisabled(true);
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        return null;
    }

    public void setFormDetalle(CorePanelForm formDetalle) {
        this.formDetalle = formDetalle;
    }

    public CorePanelForm getFormDetalle() {
        return formDetalle;
    }

    public void setLisTipDoc(CoreSelectOneChoice lisTipDoc) {
        this.lisTipDoc = lisTipDoc;
    }

    public CoreSelectOneChoice getLisTipDoc() {
        return lisTipDoc;
    }

    public void setLisDependencia(CoreSelectOneChoice lisDependencia) {
        this.lisDependencia = lisDependencia;
    }

    public CoreSelectOneChoice getLisDependencia() {
        return lisDependencia;
    }

    public void btn_autorizar_anexo(LaunchEvent launchEvent) {
        // Add event code here...
        Object vVariable, idAnexo;
        interfaz_DB interfaz = new interfaz_DB();
        String Consulta = 
            "select id_programa from sis_partida where id_partida =  " + 
            utils.getNumberOracle(JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                                             "#{bindings.IdPartida.inputValue}"));

        Object varPlan = interfaz.getValorConsultaSimple("id_programa", Consulta);
        interfaz.cn_Cerrar_coneccion();

        idAnexo = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), "#{bindings.IdAnexo.inputValue}");
        vVariable = idAnexo;
        //System.out.println("voy a entrar al dialogo 1");
        if (varPlan.toString().trim().equals("48") || varPlan.toString().trim().equals("49")) {
            //System.out.println("voy a entrar al dialogo1 " + varPlan);          
            launchEvent.getDialogParameters().put("Gestion", "ANEXO_A_INVESTIGACION");
        } else {
            launchEvent.getDialogParameters().put("Gestion", "ANEXO_A");
        }

        //launchEvent.getDialogParameters().put("Gestion","ANEXO_A");
        launchEvent.getDialogParameters().put("IdAnexo", idAnexo);
        launchEvent.getDialogParameters().put("IdGestionX", vVariable);
        
        Consulta = "select estatus from sis_anexo where id_anexo = "+idAnexo.toString();
        Object vEstatus = interfaz.getValorConsultaSimple("estatus", Consulta);
        interfaz.cn_Cerrar_coneccion();
       //vVariable = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), "#{bindings.Estatus.inputValue}");
        
        launchEvent.getDialogParameters().put("Estado", vEstatus);
        launchEvent.getDialogParameters().put("RefreshVw", "innecesario");
    }

    public void setListUnidad(CoreSelectOneChoice listUnidad) {
        this.listUnidad = listUnidad;
    }

    public CoreSelectOneChoice getListUnidad() {
        return listUnidad;
    }

    public void setFecha_inicio(CoreSelectInputDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public CoreSelectInputDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_fin(CoreSelectInputDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public CoreSelectInputDate getFecha_fin() {
        return fecha_fin;
    }

    public void setRegEmpleado(CoreInputText regEmpleado) {
        this.regEmpleado = regEmpleado;
    }

    public CoreInputText getRegEmpleado() {
        return regEmpleado;
    }

    public void setFacTiempo(CoreInputText facTiempo) {
        this.facTiempo = facTiempo;
    }

    public CoreInputText getFacTiempo() {
        return facTiempo;
    }

    public void setDictamenNumero(CoreInputText dictamenNumero) {
        this.dictamenNumero = dictamenNumero;
    }

    public CoreInputText getDictamenNumero() {
        return dictamenNumero;
    }

    public void setDictamenAnio(CoreInputText dictamenAnio) {
        this.dictamenAnio = dictamenAnio;
    }

    public CoreInputText getDictamenAnio() {
        return dictamenAnio;
    }

    public void setDictamenEmitido(CoreSelectOneChoice dictamenEmitido) {
        this.dictamenEmitido = dictamenEmitido;
    }

    public CoreSelectOneChoice getDictamenEmitido() {
        return dictamenEmitido;
    }

    public void setListPuestoEscala(CoreSelectOneChoice listPuestoEscala) {
        this.listPuestoEscala = listPuestoEscala;
    }

    public CoreSelectOneChoice getListPuestoEscala() {
        return listPuestoEscala;
    }

    public void setVarMinEscalaf(CoreInputText varMinEscalaf) {
        this.varMinEscalaf = varMinEscalaf;
    }

    public CoreInputText getVarMinEscalaf() {
        return varMinEscalaf;
    }

    public void setVCambioPartida(boolean vCambioPartida) {
        this.vCambioPartida = vCambioPartida;
    }

    public boolean isVCambioPartida() {
        return vCambioPartida;
    }

    public void setPartidaSicoin(CoreSelectOneChoice partidaSicoin) {
        this.partidaSicoin = partidaSicoin;
    }

    public CoreSelectOneChoice getPartidaSicoin() {
        return partidaSicoin;
    }
}
