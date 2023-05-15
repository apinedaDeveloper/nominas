package interfaz_usuario.backing.procesos;

import interfaz_usuario.util.JSFUtils;
import interfaz_usuario.util.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import oracle.adf.view.faces.component.core.CoreForm;
import oracle.adf.view.faces.component.core.data.CoreTable;
import oracle.adf.view.faces.component.core.data.CoreTableSelectOne;
import oracle.adf.view.faces.component.core.input.CoreInputText;
import oracle.adf.view.faces.component.core.input.CoreSelectOneChoice;
import oracle.adf.view.faces.component.core.layout.CoreShowDetailItem;
import oracle.adf.view.faces.component.core.nav.CoreCommandButton;
import oracle.adf.view.faces.component.core.nav.CoreCommandLink;
import oracle.adf.view.faces.component.core.nav.CoreCommandMenuItem;
import oracle.adf.view.faces.component.core.nav.CorePage;
import oracle.adf.view.faces.component.core.output.CoreMessages;
import oracle.adf.view.faces.component.core.output.CoreObjectImage;
import oracle.adf.view.faces.component.core.output.CoreOutputText;
import oracle.adf.view.faces.component.html.HtmlBody;
import oracle.adf.view.faces.component.html.HtmlHead;
import oracle.adf.view.faces.component.html.HtmlHtml;


public class Liquidacion_planilla_031 {
    private CoreShowDetailItem showDetIt_Historico;
    private CoreShowDetailItem showDetIt_DetalleHist;
    private HtmlHtml html1;
    private HtmlHead head1;
    private HtmlBody body1;
    private CoreMessages messages1;
    private CoreForm form1;
    private CorePage page1;
    private CoreCommandMenuItem commandMenuItem1;
    private CoreTable tbl_listadoDetallePlanilla;
    private CoreTableSelectOne tableSelectOne1;
    private CoreCommandLink cmdLink_editar;
    private CoreObjectImage objImg_editarFila;
    private CoreTable tbl_listadoDetalleDescuentos;
    private CoreInputText inptText_montoDescuento;
    private CoreSelectOneChoice selectOneCh_Descuento;
    private CoreCommandButton cmdBtn_liquidar_nomina;
    private CoreOutputText outputTxt_encabezadoHistorico;
    private CoreCommandButton cmdBtn_ver_liquidados;
    private CoreCommandButton cmdBtn_ver_autorizados;
    private CoreCommandButton cmdBtn_buscar_planillas;
    private CoreCommandButton cmdBtn_cancelar_busqueda;
    private CoreInputText inptText_idPlanilla_busqueda;
    private CoreInputText inptText_numCheque_busqueda;
    private CoreInputText inptText_anioPago_busqueda;
    private CoreSelectOneChoice slctOneCh_mesPago_busqueda;

    public void setShowDetIt_Historico(CoreShowDetailItem showDetIt_Historico) {
        this.showDetIt_Historico = showDetIt_Historico;
    }

    public CoreShowDetailItem getShowDetIt_Historico() {
        return showDetIt_Historico;
    }

    public String cmdLink_IdIsr_action() { //Seleccionó una Planilla 031 ISR
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                 "setCurrentRowWithKey");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                 "cambiarEstadoAFalseTodasFilas"); //contraemos la filas del detalle
        this.getShowDetIt_Historico().setDisclosed(false);
        this.getShowDetIt_DetalleHist().setDisclosed(true);
        this.getShowDetIt_Historico().setDisabled(true);
        this.getShowDetIt_DetalleHist().setDisabled(false);
        this.getCmdLink_editar().setDisabled(false);
        return null;
    }

    public String cmdLink_editar_action() { //Click en una de las filas Detalle
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(), 
                                      "cambiarEstadoAFalseTodasFilas")) {
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                     "cambiarEstadoATrueFilaActual");
            this.getCmdLink_editar().setDisabled(true);
        }
        return null;
    }

    public void setShowDetIt_DetalleHist(CoreShowDetailItem showDetIt_DetalleHist) {
        this.showDetIt_DetalleHist = showDetIt_DetalleHist;
    }

    public CoreShowDetailItem getShowDetIt_DetalleHist() {
        return showDetIt_DetalleHist;
    }

    //Función que verifica si el descuento ya existe en el listado de descuentos

    public boolean verificar_si_descuento_ya_existe() {
        String mensaje; //Para los mensajes de error
        boolean valido = false; //cambiará a true si los valores son válidos
        Object descuentoEncontrado; //Nos díra si se encontró o no el ajuste en el View Object Iterator
        descuentoEncontrado = 
                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                         "BuscarDescuentoDetalle");
        if (descuentoEncontrado != null && 
            descuentoEncontrado.toString().equals("false")) {
            valido = true;
        } else {
            mensaje = 
                    "El Descuento ya se existe en la lista, seleccione otro por favor!!";
            mensaje(mensaje, 3); // 3 = tipo ERROR
        }
        return valido;
    }

    //Función que valida el descuento a agregar

    public boolean validar_descuento_a_agregar() {
        boolean valido = false; //cambiará a true si el descuento es válido
        Object descuentoSeleccionado = 
            this.getSelectOneCh_Descuento().getValue();
        Object montoDescuento;
        if (descuentoSeleccionado != null) {
            montoDescuento = this.getInptText_montoDescuento().getValue();
            if (montoDescuento != null && 
                Double.valueOf(montoDescuento.toString()).doubleValue() > 0) {
                valido = verificar_si_descuento_ya_existe();
            } else {
                mensaje("Ingrese un monto mayor de 0 por favor!!", 
                        3); // 3 = ERROR
            }
        } else {
            mensaje("Seleccione un descuento por favor!!", 3); // 3 = ERROR
        }
        return valido;
    }

    public String cmdBtn_agregar_descuento_action() {
        String mensaje; //El mensaje de información
        if (validar_descuento_a_agregar()) {
            if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(), 
                                          "Confirmar")) {
                //Se grabó cualquier cambio pendiente
                if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(), 
                                              "AgregarDescuentoDetalle")) {
                    //Graba el descuento al detalle con commit incluido
                    JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                             "EjecutarDescDetallePlanilla"); //Refresca a la tabla de Descuentos
                    JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                             "setCurrentRowWithKeyDet"); //Apunta a última la fila seleccionada
                    mensaje = "Descuento agregado exitósamente!!";
                    mensaje(mensaje, 1); // 1 = tipo INFO
                } else {
                    JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                             "Rollback");
                }
            } else {
                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                         "Rollback");
            }
        }
        return null;
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

    public void setMessages1(CoreMessages messages1) {
        this.messages1 = messages1;
    }

    public CoreMessages getMessages1() {
        return messages1;
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

    public void setCommandMenuItem1(CoreCommandMenuItem commandMenuItem1) {
        this.commandMenuItem1 = commandMenuItem1;
    }

    public CoreCommandMenuItem getCommandMenuItem1() {
        return commandMenuItem1;
    }

    public void setTbl_listadoDetallePlanilla(CoreTable tbl_listadoDetallePlanilla) {
        this.tbl_listadoDetallePlanilla = tbl_listadoDetallePlanilla;
    }

    public CoreTable getTbl_listadoDetallePlanilla() {
        return tbl_listadoDetallePlanilla;
    }

    public void setTableSelectOne1(CoreTableSelectOne tableSelectOne1) {
        this.tableSelectOne1 = tableSelectOne1;
    }

    public CoreTableSelectOne getTableSelectOne1() {
        return tableSelectOne1;
    }

    public void setCmdLink_editar(CoreCommandLink cmdLink_editar) {
        this.cmdLink_editar = cmdLink_editar;
    }

    public CoreCommandLink getCmdLink_editar() {
        return cmdLink_editar;
    }

    public void setObjImg_editarFila(CoreObjectImage objImg_editarFila) {
        this.objImg_editarFila = objImg_editarFila;
    }

    public CoreObjectImage getObjImg_editarFila() {
        return objImg_editarFila;
    }

    //Método que muestra un mensaje en la pantalla. Tipos: 1=INFO, 2=ADVERTENCIA y 3=ERROR

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

    public String cmdBtn_grabar_action() {
        String mensaje = "Transacción grabada exitósamente!!";
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(), 
                                      "Confirmar")) {
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                     "ActualizarTotalesDetalle"); //actualiza los totales con commit incluido
            //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), "EjecutarDescDetalle"); //Refresh a los Descuentos del detalle actual
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                     "EjecutarDetallePlanilla"); //Refresh al Detalle Seleccionado
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                     "cambiarEstadoAFalseTodasFilas"); //Contrae todas las filas
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                     "setCurrentRowWithKeyDet"); //Apunta a última la fila seleccionada
            this.getCmdLink_editar().setDisabled(false);
            mensaje(mensaje, 1); // 1 = tipo INFO
        }
        return null;
    }

    public String cmdBtn_cancelar_action() {
        String mensaje = "Transacción cancelada exitósamente!!";
        //if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(), "Rollback")) {
        //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), "actualizarTotalesEnDetallePlani"); //actualiza totales con commit incluido
        //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), "EjecutarDescDetalle"); //Refresh a los Descuentos del detalle actual
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                 "EjecutarDetallePlanilla"); //Refresh al Detalle Seleccionado
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                 "cambiarEstadoAFalseTodasFilas"); //Contrae todas las filas
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                 "setCurrentRowWithKeyDet"); //Apunta a última la fila seleccionada
        this.getCmdLink_editar().setDisabled(false);
        mensaje(mensaje, 1); // 1 = tipo INFO
        //}
        return null;
    }

    public void setTbl_listadoDetalleDescuentos(CoreTable tbl_listadoDetalleDescuentos) {
        this.tbl_listadoDetalleDescuentos = tbl_listadoDetalleDescuentos;
    }

    public CoreTable getTbl_listadoDetalleDescuentos() {
        return tbl_listadoDetalleDescuentos;
    }

    public void setInptText_montoDescuento(CoreInputText inptText_montoDescuento) {
        this.inptText_montoDescuento = inptText_montoDescuento;
    }

    public CoreInputText getInptText_montoDescuento() {
        return inptText_montoDescuento;
    }

    public void setSelectOneCh_Descuento(CoreSelectOneChoice selectOneCh_Descuento) {
        this.selectOneCh_Descuento = selectOneCh_Descuento;
    }

    public CoreSelectOneChoice getSelectOneCh_Descuento() {
        return selectOneCh_Descuento;
    }

    public String cmdBtn_cancelar_global_action() { //Clic en Cancelar Global
        // Add event code here...
        this.getShowDetIt_DetalleHist().setDisclosed(false);
        this.getShowDetIt_Historico().setDisclosed(true);
        this.getShowDetIt_DetalleHist().setDisabled(true);
        this.getShowDetIt_Historico().setDisabled(false);
        return null;
    }

    public String cmdLink_eliminar_descuento_action() {
        String mensaje = "Descuento Suprimido Exitósamente!!";
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                 "setCurrentRowWithKeyDetDesc");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                 "SuprimirDescuento"); //Suprimimos del View Object
        //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), "Confirmar"); //Graba en la Base de Datos
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(), 
                                      "Confirmar")) {
            //Graba en la Base de Datos, y todos los cambios pendientes
            if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(), 
                                          "ActualizarTotalesDetalle")) {
                //actualiza totales con commit incluido
                mensaje(mensaje, 1); // 1 = tipo INFO
                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                         "EjecutarDescDetallePlanilla");
                //Refresca a la tabla de Descuentos
            } else {
                JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                         "Rollback");
            }
        } else {
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                     "Rollback");
        }
        return null;
    }

    public void setCmdBtn_liquidar_nomina(CoreCommandButton cmdBtn_liquidar_nomina) {
        this.cmdBtn_liquidar_nomina = cmdBtn_liquidar_nomina;
    }

    public CoreCommandButton getCmdBtn_liquidar_nomina() {
        return cmdBtn_liquidar_nomina;
    }

    public String cmdBtn_liquidar_nomina_action() {
        //System.out.println("hola");
        String mensaje = "Planilla ISR 031 liquidada exitósamente!!";
        /*JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),
                                 "EjecutarPlanilla");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),
                                 "setCurrentRowWithKey");*/
        mensaje(mensaje, 1); // 1 = tipo INFO
        return null;
    }

    //Procedimiento que filtra el listado de las planillas liquidadas

    private void filtrar_planillas_liquidadas(String mensaje) {
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                 "getFiltrar_Planillas_liquidados");
        this.getOutputTxt_encabezadoHistorico().setValue(mensaje);
        this.getCmdBtn_ver_liquidados().setDisabled(true); //deshabilita el botón Ver Liquidados
        this.getCmdBtn_ver_autorizados().setDisabled(false); //habilita el botón Ver Autorizados
        //this.getCmdBtn_cancelar_historico().setDisabled(false); //habilita el botón Cancelar
    }

    public String cmdBtn_ver_liquidados_action() {
        String mensaje = "Planillas ISR 031 Liquidadas";
        filtrar_planillas_liquidadas(mensaje);
        mensaje(mensaje, 1); // 1 = t---ipo INFO
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                    "#{bindings.pEstadoActualListadoPlanillas.inputValue}", 
                                    utils.getNumberOracle("2"));
        return null;
    }

    //Procedimiento que filtra el listado de las planillas autorizadas

    private void filtrar_planillas_autorizadas(String mensaje) {
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                 "getFiltrar_Planillas");
        this.getOutputTxt_encabezadoHistorico().setValue(mensaje);
        //this.getCmdBtn_cancelar_historico().setDisabled(true); //deshabilita el botón Cancelar
        this.getCmdBtn_ver_autorizados().setDisabled(true); //habilita el botón Ver Autorizados
        this.getCmdBtn_ver_liquidados().setDisabled(false); //habilita el botón Ver Liquidados
    }

    public String cmdBtn_ver_autorizados_action() {
        String mensaje = 
            "Planillas ISR 031 Autorizadas y Pendientes de Liquidar";
        filtrar_planillas_autorizadas(mensaje);
        mensaje(mensaje, 1); // 1 = tipo INFO
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(), 
                                    "#{bindings.pEstadoActualListadoPlanillas.inputValue}", 
                                    utils.getNumberOracle("1"));
        return null;
    }

    public void setOutputTxt_encabezadoHistorico(CoreOutputText outputTxt_encabezadoHistorico) {
        this.outputTxt_encabezadoHistorico = outputTxt_encabezadoHistorico;
    }

    public CoreOutputText getOutputTxt_encabezadoHistorico() {
        return outputTxt_encabezadoHistorico;
    }

    public void setCmdBtn_ver_liquidados(CoreCommandButton cmdBtn_ver_liquidados) {
        this.cmdBtn_ver_liquidados = cmdBtn_ver_liquidados;
    }

    public CoreCommandButton getCmdBtn_ver_liquidados() {
        return cmdBtn_ver_liquidados;
    }

    public void setCmdBtn_ver_autorizados(CoreCommandButton cmdBtn_ver_autorizados) {
        this.cmdBtn_ver_autorizados = cmdBtn_ver_autorizados;
    }

    public CoreCommandButton getCmdBtn_ver_autorizados() {
        return cmdBtn_ver_autorizados;
    }

    public void setCmdBtn_buscar_planillas(CoreCommandButton cmdBtn_buscar_planillas) {
        this.cmdBtn_buscar_planillas = cmdBtn_buscar_planillas;
    }

    public CoreCommandButton getCmdBtn_buscar_planillas() {
        return cmdBtn_buscar_planillas;
    }

    public void setCmdBtn_cancelar_busqueda(CoreCommandButton cmdBtn_cancelar_busqueda) {
        this.cmdBtn_cancelar_busqueda = cmdBtn_cancelar_busqueda;
    }

    public CoreCommandButton getCmdBtn_cancelar_busqueda() {
        return cmdBtn_cancelar_busqueda;
    }

    public String cmdBtn_buscar_planillas_action() {
        Object estadoActualListado; //1=Autorizadas, 2=Liquidadas
        Object registrosEncontrados; //número de registros encontrados
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                 "LimpiarIteratorPlanillas"); //primero limpiamos
        estadoActualListado = 
                JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                           "#{bindings.pEstadoActualListadoPlanillas.inputValue}");
        if (estadoActualListado.toString().compareToIgnoreCase("1") == 0) {
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                     "getFiltrar_Planillas_filtro_busqueda"); //filtramos las autorizadas
        } else {
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                     "getFiltrar_Planillas_liquidados_filtro"); //filtramos las liquidadas
        }
        registrosEncontrados = 
                JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                           "#{bindings.SisIsrproy031vwIterator.estimatedRowCount}");
        if (registrosEncontrados != null && 
            utils.getDouble1(registrosEncontrados).doubleValue() > 0) {
            //System.out.println("Número de Registros encontrados: " + registrosEncontrados);
            mensaje("Número de Registros encontrados: " + registrosEncontrados, 
                    1);
        } else {
            //System.out.println("No se encontraron registros con el filtro ingresado");
            mensaje("No se encontraron registros con el filtro de búsqueda ingresado", 
                    1);
        }
        return null;
    }

    public String cmdBtn_cancelar_busqueda_action() {
        Object estadoActualListadoPlanillas; //1=Autorizadas, 2=Liquidadas
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(), 
                                 "Rollback");
        this.getInptText_idPlanilla_busqueda().setValue("");
        this.getInptText_numCheque_busqueda().setValue("");
        this.getInptText_anioPago_busqueda().setValue("");
        this.getSlctOneCh_mesPago_busqueda().setSubmittedValue(null);
        this.getSlctOneCh_mesPago_busqueda().resetValue();
        this.getSlctOneCh_mesPago_busqueda().setValue("-1");
        mensaje("Búsqueda Cancelada exitósamente", 1); // 1 = tipo INFO
        estadoActualListadoPlanillas = 
                JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), 
                                           "#{bindings.pEstadoActualListadoPlanillas.inputValue}");
        if (estadoActualListadoPlanillas.toString().compareToIgnoreCase("1") == 
            0) {
            //System.out.println("El estado actual de listado es AUTORIZADOS");
            filtrar_planillas_autorizadas("Planillas ISR 031 Autorizadas y Pendientes de Liquidar");
        } else {
            //System.out.println("El estado actual del listado es LIQUIDADOS");
            filtrar_planillas_liquidadas("Planillas ISR 031 Liquidadas");
        }
        return null;
    }

    public void setInptText_idPlanilla_busqueda(CoreInputText inptText_idPlanilla_busqueda) {
        this.inptText_idPlanilla_busqueda = inptText_idPlanilla_busqueda;
    }

    public CoreInputText getInptText_idPlanilla_busqueda() {
        return inptText_idPlanilla_busqueda;
    }

    public void setInptText_numCheque_busqueda(CoreInputText inptText_numCheque_busqueda) {
        this.inptText_numCheque_busqueda = inptText_numCheque_busqueda;
    }

    public CoreInputText getInptText_numCheque_busqueda() {
        return inptText_numCheque_busqueda;
    }

    public void setInptText_anioPago_busqueda(CoreInputText inptText_anioPago_busqueda) {
        this.inptText_anioPago_busqueda = inptText_anioPago_busqueda;
    }

    public CoreInputText getInptText_anioPago_busqueda() {
        return inptText_anioPago_busqueda;
    }

    public void setSlctOneCh_mesPago_busqueda(CoreSelectOneChoice slctOneCh_mesPago_busqueda) {
        this.slctOneCh_mesPago_busqueda = slctOneCh_mesPago_busqueda;
    }

    public CoreSelectOneChoice getSlctOneCh_mesPago_busqueda() {
        return slctOneCh_mesPago_busqueda;
    }

}
