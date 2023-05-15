package interfaz_usuario.backing.gestiones;

import enlace_datos.consultas.QUERRYSImpl;

import enlace_datos.consultas.complementos.ListadoPuestoxTrabajadorVImpl;
import enlace_datos.consultas.complementos.ComplementoPersonalVImpl;

import enlace_datos.consultas.complementos.ListadoPlazasXUniDepImpl;
import enlace_datos.consultas.complementos.ListadoTipoNominaImpl;
import enlace_datos.consultas.complementos.TieneAlgunPagoImpl;

import enlace_datos.util.resulOp;

import interfaz_usuario.util.JSFUtils;
import interfaz_usuario.util.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;

import java.text.SimpleDateFormat;

import java.util.ArrayList;

import java.util.Date;

import javax.faces.application.Application;
import javax.faces.component.UINamingContainer;
import javax.faces.component.UISelectItems;
import javax.faces.component.html.HtmlForm;

import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.component.html.HtmlPanelGroup;

import javax.faces.context.FacesContext;

import javax.faces.el.ValueBinding;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCDataControl;
import oracle.adf.view.faces.component.core.data.CoreColumn;
import oracle.adf.view.faces.component.core.data.CoreTable;
import oracle.adf.view.faces.component.core.data.CoreTableSelectOne;
import oracle.adf.view.faces.component.core.input.CoreInputText;
import oracle.adf.view.faces.component.core.input.CoreSelectBooleanCheckbox;
import oracle.adf.view.faces.component.core.input.CoreSelectInputDate;
import oracle.adf.view.faces.component.core.input.CoreSelectItem;
import oracle.adf.view.faces.component.core.input.CoreSelectOneChoice;
import oracle.adf.view.faces.component.core.layout.CorePanelButtonBar;
import oracle.adf.view.faces.component.core.layout.CorePanelForm;
import oracle.adf.view.faces.component.core.layout.CorePanelGroup;
import oracle.adf.view.faces.component.core.layout.CorePanelHeader;
import oracle.adf.view.faces.component.core.layout.CorePanelHorizontal;
import oracle.adf.view.faces.component.core.layout.CoreShowDetailItem;
import oracle.adf.view.faces.component.core.layout.CoreShowOneTab;
import oracle.adf.view.faces.component.core.nav.CoreCommandButton;
import oracle.adf.view.faces.component.core.nav.CoreCommandLink;
import oracle.adf.view.faces.component.core.nav.CoreCommandMenuItem;
import oracle.adf.view.faces.component.core.nav.CorePage;
import oracle.adf.view.faces.component.core.output.CoreMessages;
import oracle.adf.view.faces.component.core.output.CoreObjectImage;
import oracle.adf.view.faces.component.core.output.CoreObjectSpacer;
import oracle.adf.view.faces.component.core.output.CoreOutputFormatted;
import oracle.adf.view.faces.component.core.output.CoreOutputText;
import oracle.adf.view.faces.component.html.HtmlBody;
import oracle.adf.view.faces.component.html.HtmlHead;
import oracle.adf.view.faces.component.html.HtmlHtml;

import oracle.binding.BindingContainer;

import enlace_datos.util.utils_DB;
import oracle.jbo.server.DBTransaction;

import oracle.jbo.ApplicationModule;
import oracle.jbo.JboException;
import oracle.jbo.NameValuePairs;
import oracle.jbo.Row;

import pkg_util_base_datos.interfaz_DB;

public class pago_comp_prest_x_reti {
    private CoreShowDetailItem showPrestaciones;
    private CorePanelHeader panelHeader1;
    private CorePanelHeader panelHeader2;
    private CoreShowDetailItem showBuscar;
    private CoreShowOneTab showOneTab1;
    private CoreOutputText outputText18;
    private UINamingContainer logo;
    private UINamingContainer menuSwt;
    private UINamingContainer info1;
    private CoreCommandMenuItem commandMenuItem1;
    private CorePage page1;
    private HtmlForm form1;
    private CoreMessages msgPago;
    private HtmlBody body1;
    private HtmlHead head1;
    private HtmlHtml html1;
    private BindingContainer bindings;
    private CorePanelHeader panelHeader3;
    private CorePanelHeader panelHeader4;
    private CorePanelForm panelForm2;
    private CoreInputText inpIdComplemento;
    private CoreInputText inpIdEstado;
    private CoreInputText inpIdTipo;
    private CoreInputText inpIdSubprograma;
    private CoreInputText inpPeriodo;
    private CoreInputText inpAnio;
    private CoreSelectInputDate selFechaPresentacion;
    private CoreInputText inpCreadoPor;
    private CoreSelectInputDate selFechaCreacion;
    private CoreInputText inputText10;
    private CoreSelectInputDate selectInputDate3;
    private CoreInputText inputText2;
    private CoreInputText inputText11;
    private CoreInputText inputText12;
    private CoreInputText inputText13;
    private CorePanelGroup panelGroup1;
    private CorePanelButtonBar panelButtonBar1;
    private CoreCommandButton commandButton4;
    private CoreCommandButton commandButton5;
    private CoreCommandButton commandButton6;
    private CoreCommandButton commandButton7;
    private CoreCommandButton commandButton8;
    private CoreTable table3;
    private CoreColumn column19;
    private CoreInputText inputText14;
    private CoreColumn column20;
    private CoreInputText inputText15;
    private CoreColumn column21;
    private CoreInputText inputText16;
    private CoreColumn column22;
    private CoreInputText inputText17;
    private CoreColumn column23;
    private CoreInputText inputText18;
    private CoreColumn column24;
    private CoreInputText inputText19;
    private CoreColumn column25;
    private CoreInputText inputText20;
    private CoreColumn column26;
    private CoreInputText inputText21;
    private CoreColumn column27;
    private CoreInputText inputText22;
    private CoreColumn column28;
    private CoreInputText inputText23;
    private CoreColumn column29;
    private CoreInputText inputText24;
    private CoreColumn colSueldoBase;
    private CoreInputText inpSueldoBase;
    private CoreColumn column31;
    private CoreInputText inputText26;
    private CoreColumn column32;
    private CoreInputText inputText27;
    private CoreColumn colNominal;
    private CoreInputText inpNominal;
    private CoreColumn column34;
    private CoreInputText inputText29;
    private CoreColumn column35;
    private CoreInputText inputText30;
    private CoreColumn colLiquido;
    private CoreInputText inpLiquido;
    private CoreColumn column37;
    private CoreInputText inpCantHoras;
    private CoreColumn column38;
    private CoreInputText inpDiasLab;
    private CoreColumn column39;
    private CoreInputText inputText34;
    private CoreColumn column40;
    private CoreInputText inputText35;
    private CoreColumn column41;
    private CoreInputText inputText36;
    private CoreColumn column42;
    private CoreInputText inputText37;
    private CoreColumn column44;
    private CoreInputText inputText39;
    private CoreTableSelectOne tableSelectOne3;
    private CoreCommandButton commandButton9;
    private CoreCommandButton btnIrPrestaciones;
    private CorePanelButtonBar panelButtonBar2;
    private CoreCommandLink lnkImprimir;
    private CoreObjectImage objectImage1;
    private CorePanelHorizontal panelHorizontal1;
    private CoreSelectOneChoice selMes;
    private CoreSelectItem selectItem1;
    private CoreSelectItem selectItem2;
    private CoreSelectItem selectItem3;
    private CoreSelectItem selectItem4;
    private CoreSelectItem selectItem5;
    private CoreSelectItem selectItem6;
    private CoreSelectItem selectItem7;
    private CoreSelectItem selectItem8;
    private CoreSelectItem selectItem9;
    private CoreSelectItem selectItem10;
    private CoreSelectItem selectItem11;
    private CoreSelectItem selectItem12;
    private CoreCommandButton btnEditarPrestacion;
    private CoreCommandButton btnGrabarCambios;
    private CoreCommandLink commandLink1;
    private CoreObjectImage objectImage2;
    private CoreCommandLink commandLink2;
    private CoreObjectImage objectImage3;
    private CoreCommandButton btnCancelarPrestacion;
    private CoreCommandButton btnParamComplemento;
    private CoreCommandButton btnBuscarComplemento;
    private CoreInputText inputText3;
    private CoreInputText inputText4;
    private CoreInputText inputText6;
    private CoreInputText inputText7;
    private CoreCommandButton btnEditarComplemento;
    private CoreCommandButton btnGuardarComplemento;
    private CoreSelectOneChoice selPeriodo;
    private CoreSelectItem selectItem13;
    private CoreSelectItem selectItem14;
    private CoreSelectItem selectItem15;
    private CoreSelectItem selectItem16;
    private CoreSelectItem selectItem17;
    private CoreSelectItem selectItem18;
    private CoreSelectItem selectItem19;
    private CoreSelectItem selectItem20;
    private CoreSelectItem selectItem21;
    private CoreSelectItem selectItem22;
    private CoreSelectItem selectItem23;
    private CoreSelectItem selectItem24;
    private CoreCommandButton btnCancelarComplemento;
    private CoreSelectItem selectItem25;
    private CoreColumn column48;
    private CoreInputText inputText5;
    private CoreCommandButton btnBorrarFilaDetalle;
    private CoreShowDetailItem showHistorico;
    private CorePanelHeader panelHeader5;
    private CorePanelHeader panelHeader6;
    private CorePanelForm panelForm3;
    private CoreSelectInputDate selectInputDate1;
    private CoreSelectInputDate selectInputDate2;
    private CoreCommandButton btnBuscarHist;
    private CoreTable table4;
    private CoreColumn column49;
    private CoreOutputText outputText3;
    private CoreColumn column50;
    private CoreOutputText outputText9;
    private CoreColumn column51;
    private CoreOutputText outputText12;
    private CoreColumn column52;
    private CoreOutputText outputText19;
    private CoreColumn column53;
    private CoreOutputText outputText26;
    private CoreColumn column54;
    private CoreOutputText outputText27;
    private CoreColumn column55;
    private CoreOutputText outputText28;
    private CoreColumn column56;
    private CoreOutputText outputText29;
    private CoreColumn column57;
    private CoreOutputText outputText30;
    private CoreColumn column58;
    private CoreOutputText outputText31;
    private CoreColumn column59;
    private CoreOutputText outputText32;
    private CoreColumn column60;
    private CoreOutputText outputText33;
    private CoreColumn column61;
    private CoreOutputText outputText34;
    private CoreColumn column63;
    private CoreOutputText outputText36;
    private CoreColumn column64;
    private CoreOutputText outputText37;
    private CoreColumn column65;
    private CoreOutputText outputText38;
    private CoreColumn column66;
    private CoreOutputText outputText39;
    private CoreColumn column67;
    private CoreOutputText outputText40;
    private CoreColumn column68;
    private CoreOutputText outputText41;
    private CoreColumn column69;
    private CoreOutputText outputText42;
    private CoreColumn column70;
    private CoreOutputText outputText43;
    private CoreTableSelectOne tableSelectOne4;
    private CoreCommandButton btnEditarCompl;
    private CoreColumn column62;
    private CoreOutputText outputText35;
    private CoreCommandLink commandLink3;
    private CoreObjectImage objectImage4;
    private CoreTable table1;
    private CoreColumn column1;
    private CoreOutputText outputText1;
    private CoreColumn column2;
    private CoreOutputText outputText2;
    private CoreColumn column3;
    private CoreOutputText outputText4;
    private CoreColumn column4;
    private CoreOutputText outputText5;
    private CoreColumn column5;
    private CoreOutputText outputText6;
    private CoreColumn column6;
    private CoreOutputText outputText7;
    private CoreColumn column7;
    private CoreOutputText outputText8;
    private CoreColumn column8;
    private CoreOutputText outputText10;
    private CoreColumn column9;
    private CoreOutputText outputText11;
    private CoreColumn column10;
    private CoreOutputText outputText13;
    private CoreColumn column11;
    private CoreOutputText outputText14;
    private CoreColumn column12;
    private CoreOutputText outputText15;
    private CoreTableSelectOne tableSelectOne1;
    private CoreCommandButton commandButton2;
    private CoreColumn column13;
    private CoreSelectBooleanCheckbox outputText16;
    private HtmlPanelGroup panelGroup2;
    private CoreCommandButton btnGenerarPrestaciones3;
    private CorePanelForm panelForm4;
    private CoreInputText inputText8;
    private CoreInputText inputText9;
    private CoreCommandButton btnFiltarRegistro;
    private CorePanelHeader panelHeader7;
    private HtmlPanelGrid panelGrid1;
    private CoreInputText inpRegPer;
    private CoreInputText inpPlaza;
    private CoreCommandButton btnBuscarYSel;
    private CoreShowDetailItem showConsultar;
    private CorePanelHeader panelHeader8;
    private CorePanelHeader panelHeader9;
    private CorePanelForm panelForm5;
    private CoreInputText inputText1;
    private CoreInputText inputText25;
    private CoreInputText inputText28;
    private CoreInputText inputText31;
    private CoreInputText inputText40;
    private CoreInputText inputText41;
    private CoreInputText inputText42;
    private CoreInputText inputText43;
    private CoreInputText inputText44;
    private CoreInputText inputText45;
    private CoreInputText inputText46;
    private CoreInputText inputText47;
    private CoreInputText inputText48;
    private CoreInputText inputText49;
    private CoreInputText inputText50;
    private CoreInputText inputText51;
    private CoreInputText inputText52;
    private CoreInputText inputText53;
    private CoreInputText inputText54;
    private CoreInputText inputText55;
    private CoreInputText inputText56;
    private CoreSelectInputDate selectInputDate4;
    private CoreInputText inputText57;
    private CoreSelectInputDate selectInputDate5;
    private CoreInputText inputText58;
    private CoreInputText inputText59;
    private CoreInputText inputText60;
    private CoreInputText inputText61;
    private CoreInputText inputText62;
    private CoreInputText inputText63;
    private CoreInputText inputText64;
    private CoreInputText inputText65;
    private CoreInputText inputText66;
    private CoreInputText inputText67;
    private CoreInputText inputText68;
    private CoreInputText inputText69;
    private CoreInputText inputText70;
    private CoreInputText inputText71;
    private CoreInputText inputText72;
    private CorePanelGroup panelGroup3;
    private CoreOutputText outputText17;
    private CorePanelButtonBar panelButtonBar3;
    private CoreCommandButton commandButton1;
    private CoreCommandButton commandButton3;
    private CoreTable table2;
    private CoreColumn column14;
    private CoreOutputText outputText20;
    private CoreColumn column15;
    private CoreOutputText outputText21;
    private CoreColumn column16;
    private CoreOutputText outputText22;
    private CoreColumn column17;
    private CoreOutputText outputText23;
    private CoreColumn column18;
    private CoreOutputText outputText24;
    private CoreColumn column30;
    private CoreOutputText outputText25;
    private CoreColumn column33;
    private CoreOutputText outputText44;
    private CoreColumn column36;
    private CoreOutputText outputText45;
    private CoreColumn column45;
    private CoreOutputText outputText46;
    private CoreColumn column46;
    private CoreOutputText outputText47;
    private CoreColumn column47;
    private CoreOutputText outputText48;
    private CoreColumn column71;
    private CoreOutputText outputText49;
    private CoreColumn column72;
    private CoreOutputText outputText50;
    private CoreColumn column73;
    private CoreOutputText outputText51;
    private CoreColumn column74;
    private CoreOutputText outputText52;
    private CoreColumn column75;
    private CoreOutputText outputText53;
    private CoreColumn column76;
    private CoreOutputText outputText54;
    private CoreColumn column77;
    private CoreOutputText outputText55;
    private CoreColumn column78;
    private CoreOutputText outputText56;
    private CoreColumn column79;
    private CoreOutputText outputText57;
    private CoreColumn column80;
    private CoreOutputText outputText58;
    private CoreColumn column81;
    private CoreOutputText outputText59;
    private CoreColumn column82;
    private CoreOutputText outputText60;
    private CoreColumn column83;
    private CoreOutputText outputText61;
    private CoreColumn column84;
    private CoreOutputText outputText62;
    private CoreColumn column85;
    private CoreOutputText outputText63;
    private CoreColumn column86;
    private CoreOutputText outputText64;
    private CoreColumn column87;
    private CoreOutputText outputText65;
    private CoreColumn column88;
    private CoreOutputText outputText66;
    private CoreColumn column89;
    private CoreOutputText outputText67;
    private CoreColumn column90;
    private CoreOutputText outputText68;
    private CoreColumn column91;
    private CoreOutputText outputText69;
    private CoreColumn column92;
    private CoreOutputText outputText70;
    private CoreColumn column93;
    private CoreOutputText outputText71;
    private CoreColumn column94;
    private CoreOutputText outputText72;
    private CoreColumn column95;
    private CoreOutputText outputText73;
    private CoreColumn column96;
    private CoreOutputText outputText74;
    private CoreColumn column97;
    private CoreOutputText outputText75;
    private CoreColumn column98;
    private CoreOutputText outputText76;
    private CoreTableSelectOne tableSelectOne2;
    private CoreCommandButton commandButton10;
    private CoreTable table5;
    private CoreColumn column99;
    private CoreOutputText outputText77;
    private CoreColumn column100;
    private CoreOutputText outputText78;
    private CoreColumn column101;
    private CoreOutputText outputText79;
    private CoreColumn column102;
    private CoreOutputText outputText80;
    private CoreColumn column103;
    private CoreOutputText outputText81;
    private CoreColumn column104;
    private CoreOutputText outputText82;
    private CoreColumn column105;
    private CoreOutputText outputText83;
    private CoreColumn column106;
    private CoreOutputText outputText84;
    private CoreColumn column107;
    private CoreOutputText outputText85;
    private CoreColumn column108;
    private CoreOutputText outputText86;
    private CoreColumn column109;
    private CoreOutputText outputText87;
    private CoreColumn column110;
    private CoreOutputText outputText88;
    private CoreColumn column111;
    private CoreOutputText outputText89;
    private CoreColumn column112;
    private CoreOutputText outputText90;
    private CoreColumn column113;
    private CoreOutputText outputText91;
    private CoreColumn column114;
    private CoreOutputText outputText92;
    private CoreTableSelectOne tableSelectOne5;
    private CoreCommandButton commandButton11;
    private CorePanelForm panelForm6;
    private CoreCommandButton commandButton12;
    private CorePanelForm panelForm1;
    private CoreInputText inputText74;
    private CoreSelectInputDate selectInputDate6;
    private CoreSelectInputDate selectInputDate7;
    private CoreCommandButton btnBuscar;
    private CoreOutputFormatted outMensaje;
    private CoreCommandLink cmdEditar;
    private CoreColumn column43;
    private CoreOutputText outputText93;
    private CoreOutputText outputText931;
    private CoreOutputText outputText932;
    private CoreOutputText outputText94;
    private CoreSelectOneChoice selectPartidaEgreso;
    private UISelectItems selectItems1;
    private CoreColumn column115;
    private CoreOutputText outputText95;
    private CoreColumn column116;
    private CoreOutputText outputText96;
    private CorePanelHorizontal panelHorizontal2;
    private CoreInputText inputText73;
    private CoreInputText inputText32;
    private CoreColumn column117;
    private CoreOutputText outputText97;
    private CoreCommandLink commandLink4;
    private CoreObjectImage objectImage5;
    private CoreObjectSpacer objectSpacer1;
    private CoreSelectBooleanCheckbox selAutofinanciable;
    private CoreOutputFormatted txtAutofinanciables;
    private CoreCommandButton commandButton13;

    public pago_comp_prest_x_reti() {
    }

    public void setShowPrestaciones(CoreShowDetailItem showDetailItem1) {
        this.showPrestaciones = showDetailItem1;
    }

    public CoreShowDetailItem getShowPrestaciones() {
        return showPrestaciones;
    }


    public void setPanelHeader1(CorePanelHeader panelHeader1) {
        this.panelHeader1 = panelHeader1;
    }

    public CorePanelHeader getPanelHeader1() {
        return panelHeader1;
    }


    public void setPanelHeader2(CorePanelHeader panelHeader2) {
        this.panelHeader2 = panelHeader2;
    }

    public CorePanelHeader getPanelHeader2() {
        return panelHeader2;
    }

    public void setShowBuscar(CoreShowDetailItem showDetailItem2) {
        this.showBuscar = showDetailItem2;
    }

    public CoreShowDetailItem getShowBuscar() {
        return showBuscar;
    }

    public void setShowOneTab1(CoreShowOneTab showOneTab1) {
        this.showOneTab1 = showOneTab1;
    }

    public CoreShowOneTab getShowOneTab1() {
        return showOneTab1;
    }

    public void setOutputText18(CoreOutputText outputText18) {
        this.outputText18 = outputText18;
    }

    public CoreOutputText getOutputText18() {
        return outputText18;
    }

    public void setLogo(UINamingContainer logo) {
        this.logo = logo;
    }

    public UINamingContainer getLogo() {
        return logo;
    }

    public void setMenuSwt(UINamingContainer menuSwt) {
        this.menuSwt = menuSwt;
    }

    public UINamingContainer getMenuSwt() {
        return menuSwt;
    }

    public void setInfo1(UINamingContainer info1) {
        this.info1 = info1;
    }

    public UINamingContainer getInfo1() {
        return info1;
    }

    public void setCommandMenuItem1(CoreCommandMenuItem commandMenuItem1) {
        this.commandMenuItem1 = commandMenuItem1;
    }

    public CoreCommandMenuItem getCommandMenuItem1() {
        return commandMenuItem1;
    }

    public void setPage1(CorePage page1) {
        this.page1 = page1;
    }

    public CorePage getPage1() {
        return page1;
    }

    public void setForm1(HtmlForm form1) {
        this.form1 = form1;
    }

    public HtmlForm getForm1() {
        return form1;
    }

    public void setMsgPago(CoreMessages messages1) {
        this.msgPago = messages1;
    }

    public CoreMessages getMsgPago() {
        return msgPago;
    }

    public void setBody1(HtmlBody body1) {
        this.body1 = body1;
    }

    public HtmlBody getBody1() {
        return body1;
    }

    public void setHead1(HtmlHead head1) {
        this.head1 = head1;
    }

    public HtmlHead getHead1() {
        return head1;
    }

    public void setHtml1(HtmlHtml html1) {
        this.html1 = html1;
    }

    public HtmlHtml getHtml1() {
        return html1;
    }


    public void setPanelHeader3(CorePanelHeader panelHeader3) {
        this.panelHeader3 = panelHeader3;
    }

    public CorePanelHeader getPanelHeader3() {
        return panelHeader3;
    }

    public void setPanelHeader4(CorePanelHeader panelHeader4) {
        this.panelHeader4 = panelHeader4;
    }

    public CorePanelHeader getPanelHeader4() {
        return panelHeader4;
    }

    /* ************************************************************************/
    /* ************************************************************************/
    /* ************************************************************************/
    public String btnBuscarHist_action() {
        boolean vRespuesta;
        if (vRespuesta = JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"ExecuteSisComplemento")){
            //Object pIdComple;
            //pIdComple=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdComplemento.inputValue}");
            //JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pIdVar1.inputValue}",pIdComple);
            //DeshabilitarSisComplemento();

        }
        return null;
    }

    public CoreInputText getInputText2() {

        return inputText2;
    }

    public String btnPuestos_action() {
        // Add event code here...
        boolean vRespuesta;
        vRespuesta = JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"ExecuteParamIngresados");
        return null;

    }

    public String btnEditarCompl_action() {
        // Add event code here...
        this.showHistorico.setDisclosed(false);
        this.showPrestaciones.setDisclosed(true);

        Boolean formaActiva = Boolean.parseBoolean(JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{!bindings.IsFormaActiva.inputValue}").toString());
        this.btnEditarPrestacion.setDisabled(formaActiva);
        this.btnBorrarFilaDetalle.setDisabled(formaActiva);
        this.commandLink2.setDisabled(formaActiva);
        this.commandLink1.setDisabled(formaActiva);
        this.btnCancelarPrestacion.setDisabled(true);
        this.btnGrabarCambios.setDisabled(true);
        return null;
    }

    public String btnAgregarAComplemento_action() throws SQLException {
        // Add event code here...
         Connection conn=null;
         PreparedStatement pstmt = null;
         ResultSet rset=null;
         int TieneUnSueldo=1; //Este se utiliza para saber si la plaza seleccionada ya tiene como minimo un pago generado en la nomina
         try {
             int Filas=0;
             //Creando el binding container
             FacesContext ctx = FacesContext.getCurrentInstance();
             HttpSession sesion = (HttpSession) ctx.getExternalContext().getSession(true);
             ValueBinding vb = ctx.getApplication().createValueBinding("#{data}");
             BindingContext bc = (BindingContext)vb.getValue(ctx);
             DCDataControl dc  = bc.findDataControl("QUERRYSDataControl");
             ApplicationModule am = (ApplicationModule)dc.getDataProvider();
             QUERRYSImpl service    = (QUERRYSImpl)am;

             //DataSource dataSource;
             //Context initContext = new InitialContext();
             //Data source para la conexion al servidor
             //dataSource = (DataSource)initContext.lookup("jdbc/sisDS"); //Al final de datasource, se tiene que agregar DS en mayusculas
             //conn = dataSource.getConnection();
             boolean YaExistePago=false;    //Este se utiliza para saber si una plaza que se intenta a gregar para genera complemento
                                            //ya esta agregada o no.

             ListadoPuestoxTrabajadorVImpl Puestos = service.getListadoPuestoxTrabajadorV();
             Row rPuesto=null;
             rPuesto = Puestos.getCurrentRow();

             TieneAlgunPagoImpl HayPago = service.getTieneAlgunPago();
             HayPago.setpRegPer(rPuesto.getAttribute("RegistroEmpleado").toString());
             HayPago.setpAnio(Integer.parseInt(rPuesto.getAttribute("Correlativo").toString()));
             HayPago.setpPuesto(Integer.parseInt(rPuesto.getAttribute("IdPuesto").toString()));
             HayPago.setpNoPlaza(Integer.parseInt(rPuesto.getAttribute("NumeroPlaza").toString()));
             HayPago.executeQuery();
             sesion.setAttribute("btnGenerarComple",1); //1=Boton genera cuando ya existen pagos en nomina, 2=Boton generar cuando no existe ningun pago en nomina, sino se consulta otro paquete en la base de datos
             if(HayPago.getRowCount() == 0)
                TieneUnSueldo=0;

            Row rCompl=null;
            ComplementoPersonalVImpl Compl = service.getComplementoPersonalV();
            int i=0;
                if (Compl.getRowCount() > 0) {
                    Filas = Compl.getRowCount();
                    int vRegPerPuesto=0;
                    int vIdPartidaPuesto=0;
                    int vIdPuestoPuesto=0;
                    int vCorrelativoPuesto=0;
                    int vNoPlazaPuesto=0;

                    int vRegPerCompl=0;
                    int vIdPartidaCompl=0;
                    int vIdPuestoCompl=0;
                    int vCorrelativoCompl=0;
                    int vNoPlazaCompl=0;

                    vRegPerPuesto=Integer.parseInt(rPuesto.getAttribute("RegistroEmpleado").toString());
                    vIdPartidaPuesto=Integer.parseInt(rPuesto.getAttribute("IdPartida").toString());
                    vIdPuestoPuesto=Integer.parseInt(rPuesto.getAttribute("IdPuesto").toString());
                    vCorrelativoPuesto=Integer.parseInt(rPuesto.getAttribute("Correlativo").toString());
                    vNoPlazaPuesto=Integer.parseInt(rPuesto.getAttribute("NumeroPlaza").toString());
                    Compl.first();
                    for (i=0; i<Filas; i++) {//Se recorre la vista ComplementoPersonalV, para verificar que el puesto que se desea
                     //agregar, no este ya incluido, si ya existe, mostrar mensaje y no hacer nada, de lo contrario se agrega
                        rCompl = Compl.getCurrentRow();

                        vRegPerCompl=Integer.parseInt(rCompl.getAttribute("RegistroEmpleado").toString());
                        vIdPartidaCompl=Integer.parseInt(rCompl.getAttribute("IdPartida").toString());
                        vIdPuestoCompl=Integer.parseInt(rCompl.getAttribute("IdPuesto").toString());
                        vCorrelativoCompl=Integer.parseInt(rCompl.getAttribute("Correlativo").toString());
                        vNoPlazaCompl=Integer.parseInt(rCompl.getAttribute("NumeroPlaza").toString());

                         if (vRegPerPuesto==vRegPerCompl && vIdPartidaPuesto==vIdPartidaCompl && vIdPuestoPuesto==vIdPuestoCompl && vCorrelativoPuesto==vCorrelativoCompl && vNoPlazaPuesto==vNoPlazaCompl) {
                            //Significa que la fila que se intenta agregar, ya estia en la vista ComplementoPersonalV
                             //utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Registro seleccionado, ya se encuentra agregado en la tabla, seleccione otro registro"));
                             i=Filas+1; //Esto con tal de salir del ciclo del recorrido de los registron dentro de la vista ComplemntoPersonalV
                             YaExistePago = true;
                         }
                         Compl.next();
                     }//Fin del for (i=0; i<Filas; i++)
                 }//Fin del if (Compl.getFetchedRowCount() > 0)
                 if(!YaExistePago){
                     rCompl = Compl.createRow();
                     rCompl.setAttribute("RegistroEmpleado",rPuesto.getAttribute("RegistroEmpleado"));
                     rCompl.setAttribute("NombreEmpleado",rPuesto.getAttribute("NombreEmpleado"));
                     rCompl.setAttribute("IdContrato",rPuesto.getAttribute("IdContrato"));
                     rCompl.setAttribute("NombreContrato",rPuesto.getAttribute("NombreContrato"));
                     rCompl.setAttribute("IdPuesto",rPuesto.getAttribute("IdPuesto"));
                     rCompl.setAttribute("NombrePuesto",rPuesto.getAttribute("NombrePuesto"));
                     rCompl.setAttribute("NumeroPlaza",rPuesto.getAttribute("NumeroPlaza"));
                     rCompl.setAttribute("Correlativo",rPuesto.getAttribute("Correlativo"));
                     rCompl.setAttribute("IdPartida",rPuesto.getAttribute("IdPartida"));
                     rCompl.setAttribute("FechaInicio",rPuesto.getAttribute("FechaInicio"));
                     rCompl.setAttribute("FechaFin",rPuesto.getAttribute("FechaFin"));
                     rCompl.setAttribute("Unidad",rPuesto.getAttribute("Unidad"));
                     rCompl.setAttribute("TienePago",TieneUnSueldo);
                     Compl.insertRow(rCompl);
                 }else{
                     utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Registro seleccionado, ya se encuentra agregado en la tabla, seleccione otro registro"));
                 }
             if(conn != null)
                 conn.close();
             if(pstmt != null)
                 pstmt.close();
             if(rset != null)
                 rset.close();
            return null;
         }
         catch (Exception e) {
             if(conn != null)
                 conn.close();
             if(pstmt != null)
                 pstmt.close();
             if(rset != null)
                 rset.close();
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Ocurrio algun error al procesador los datos"));
            return null;
         }
    }

    public String btnIrPrestaciones_action() {
        // Add event code here...
        IrAPrestaciones();
        return null;
    }

    public String btnGenerarComplemento_action() {
        // Add event code here...
         try {
             int Filas=0;
             int i=0;

             //Creando el binding container
             FacesContext ctx = FacesContext.getCurrentInstance();
             ValueBinding vb = ctx.getApplication().createValueBinding("#{data}");
             BindingContext bc = (BindingContext)vb.getValue(ctx);
             DCDataControl dc  = bc.findDataControl("QUERRYSDataControl");
             ApplicationModule am = (ApplicationModule)dc.getDataProvider();
             QUERRYSImpl service    = (QUERRYSImpl)am;

             ComplementoPersonalVImpl CompleDet = service.getComplementoPersonalV();
             Filas = CompleDet.getFetchedRowCount();
             if(Filas > 0){
                 Object pIdComple;
                 Row rCompleDet=null;
                 CompleDet.first();

                 rCompleDet = CompleDet.getCurrentRow();
                 JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"crearComplemento");
                 JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Commit");
                 pIdComple=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdComplemento.inputValue}");
                //Agregar validacion si pIdComple tiene valor o no

                 interfaz_DB conec;
                 conec= new interfaz_DB();

                 if (pIdComple != null) {

                     ArrayList vParametros;
                     for(i=0; i<Filas; i++){
                         rCompleDet = CompleDet.getCurrentRow();
                         vParametros= new ArrayList();
                         vParametros.add(rCompleDet.getAttribute("RegistroEmpleado"));
                         vParametros.add(rCompleDet.getAttribute("Correlativo"));
                         vParametros.add(rCompleDet.getAttribute("IdPuesto"));
                         vParametros.add(pIdComple);
                         vParametros.add(rCompleDet.getAttribute("NumeroPlaza"));
                         vParametros.add(rCompleDet.getAttribute("FechaFin"));
                         vParametros.add(rCompleDet.getAttribute("IdContrato"));
                         vParametros.add(rCompleDet.getAttribute("IdPartida"));
                             if (conec.Bol_ejecutar_procedimiento("SIS_COMPLEMENTOS_PKG.ComplementosXRetiro (?,?,?,?,?,?,?,?)",vParametros)){
                                 utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Se ha calculado exitosamente la operacion"));
                             }else{
                                 utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Ha ocurrido un error, por favor revisar."));
                             }
                         CompleDet.next();
                     }
                     CompleDet.executeQuery();
                     IrAPrestaciones();
                     JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"actualizaSubProgramaCompl");
                 }
                 else {
                     utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Ha ocurrido un error al intentar generar las prestaciones"));
                 }
                conec.cn_Cerrar_coneccion();
            }
            return null;
         }
         catch (Exception e) {
             e.printStackTrace();
             return null;
         }
    }

    public String btnBuscar_action() {
        Object vValor;
        Object vAuto2;
         //Este es el valor que se va asignar a la variable anterior
         if(this.getSelAutofinanciable().getValue().equals("true")){
             vValor="33";
             this.txtAutofinanciables.setValue("Contratos AUTOFINANCIABLES");
         }else{
             vValor="25";
             this.txtAutofinanciables.setValue("Contratos NO autofinanciables");
         }
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.vAutoInterno1.inputValue}",utils.getNumberOracle(vValor));         
        vAuto2=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vAutoInterno1.inputValue}");

        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"ExecListadoPlazas")){
            return null;
        }
        return null;
    }


    public String btnGenerarPrestaciones3_action() {
        // Add event code here...
         interfaz_DB conec;
         conec= new interfaz_DB();
        try {
            int FilasTrabajadores=0;
            int FilasNomina=0;
            int i=0;
            Object vPeriodo=0;
            int vMes=0;
            int vAnioPeriodo=0;
            int vTipoNomina=2;
            Date dFechaFin;
            boolean vNoEncontrado=false;
            String vRespuesta="";
            String vNominaFaltante="";
            String vNominaPagada="";
            //Creando el binding container
            FacesContext ctx = FacesContext.getCurrentInstance();
            ValueBinding vb = ctx.getApplication().createValueBinding("#{data}");
            BindingContext bc = (BindingContext)vb.getValue(ctx);
            DCDataControl dc  = bc.findDataControl("QUERRYSDataControl");
            ApplicationModule am = (ApplicationModule)dc.getDataProvider();
            QUERRYSImpl service    = (QUERRYSImpl)am;
            ListadoPlazasXUniDepImpl CompleDet = service.getListadoPlazasXUniDep();
            FilasTrabajadores = CompleDet.getFetchedRowCount();
            Row rCompleDet=null;
            Row rListadotn=null;

            Object pIdComple;
            
            JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"crearComplemento");
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Commit");
            pIdComple=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdComplemento.inputValue}");
            for(i=0; i<FilasTrabajadores; i++){
                rCompleDet = CompleDet.getCurrentRow();
                if(rCompleDet!=null && rCompleDet.getAttribute("Seleccionar").equals(true)){
                         
                    //Este bloque es utilizado para verificar si un pago ya se le genere, entonces ya no se genera de nuevo dicho pago.
                    ListadoTipoNominaImpl Listadotn = service.getListadoTipoNomina();
                    SimpleDateFormat FormatMes = new SimpleDateFormat("MM");
                    SimpleDateFormat FormatFecha = new SimpleDateFormat("yyyy-MM-dd");
                    dFechaFin = FormatFecha.parse(rCompleDet.getAttribute("FechaFin").toString());
                    vMes = Integer.parseInt(FormatMes.format(dFechaFin));
                    vRespuesta="Registro "+rCompleDet.getAttribute("RegistroEmpleado").toString();
                    for(i=0; i<5; i++){ //se recorre 5 veces, para buscar tipo de nomina (2,3,5,6 y 21)
                                        // Dif12%, Dif normal, Bono14, Aguinaldo y Vacaciones respectivamente
                        vAnioPeriodo = Integer.parseInt(rCompleDet.getAttribute("Correlativo").toString());
                        if(i==0){ //Para buscar el tipo de nomina de diferido 12%
                            vTipoNomina=2;
                            vNominaFaltante=", Hoy se gestionï¿½ DIFERIDO 12%";
                            vNominaPagada=", Diferido 12% ya gestionado en ";
                            if(vMes < 4){
                                vPeriodo= 3;
                            }else if(vMes >3 && vMes < 7){
                                vPeriodo= 6;
                            }else if(vMes > 6 && vMes < 10){
                                vPeriodo=9;
                            }else{
                                vPeriodo= 12;
                            }
                        }else if(i==1){ //Para buscar el tipo de nomina de diferido normal
                            vTipoNomina=3;
                            vNominaFaltante=", Hoy se gestionï¿½ DIFERIDO NORMAL";
                            vNominaPagada=", Diferido normal ya gestionado en ";
                            if(vMes < 7){
                                vPeriodo= 6;
                            }else{
                                vPeriodo= 12;
                            }
                        }else if(i==2){ //Para buscar el tipo de nomina de Bono14
                            vTipoNomina=5;
                            vPeriodo=7;
                            vNominaFaltante=", Hoy se gestionï¿½ BONO 14";
                            vNominaPagada=", BONO 14 ya gestionado en ";
                            if(vMes > 6){
                                vAnioPeriodo= vAnioPeriodo + 1;
                            }
                        }else if(i==3){ //Para buscar el tipo de nomina de Aguinaldo
                            vTipoNomina=6;
                            vPeriodo=12;
                            vNominaFaltante=", Hoy se gestionï¿½ AGUINALDO";
                            vNominaPagada=", AGUINALDO ya gestionado en ";
                        }else{ //Para buscar el tipo de nomina de Vacaciones
                            vTipoNomina=21;
                            vNominaFaltante=", Hoy se gestionï¿½ VACACIONES";
                            vNominaPagada=", VACACIONES ya gestionado en ";
                            vPeriodo= 6;
                            if(vMes > 6){
                                vPeriodo= 12;
                            }
                        }

                        Listadotn.setpAnioPeriodo(vAnioPeriodo);
                        Listadotn.setpCorrelativo(rCompleDet.getAttribute("Correlativo"));
                        Listadotn.setpIdContrato(rCompleDet.getAttribute("IdContrato"));
                        Listadotn.setpIdPartida(rCompleDet.getAttribute("IdPartida"));
                        Listadotn.setpNoPlaza(rCompleDet.getAttribute("NumeroPlaza"));
                        Listadotn.setpPeriodo(vPeriodo);
                        Listadotn.setpProceso(0);
                        Listadotn.setpPuesto(rCompleDet.getAttribute("IdPuesto"));
                        Listadotn.setpRegPer(rCompleDet.getAttribute("RegistroEmpleado"));
                        Listadotn.setpTipoNomina(vTipoNomina);
                        Listadotn.executeQuery();

                        FilasNomina = Listadotn.getFetchedRowCount();
                        FilasNomina=0; //Esto se hace para que omita la busqueda que si ya fue pagado la prestación, ya que por el momento está libre, es decir, que puede generarselo cuantas veces lo generen
                        if(FilasNomina == 0){//Indica que no se ha pagado la prestacion que se buscï¿½
                            vNoEncontrado=true;
                            vRespuesta= vRespuesta+vNominaFaltante;
                        }else{//Indica que si se le ha pagado la prestacion que se buscï¿½
                            Listadotn.first();
                            rListadotn = Listadotn.getCurrentRow();
                            if(Integer.parseInt(rListadotn.getAttribute("IdTipo").toString()) == 0 ){//indica que se ha pagado en la nomina
                                vNominaPagada = vNominaPagada +" IdNomina "+ rListadotn.getAttribute("Origen");
                            }else{
                                vNominaPagada = vNominaPagada +" IdComplemento "+ rListadotn.getAttribute("Origen");
                            }
                            vRespuesta= vRespuesta+vNominaPagada;
                        }//Fin del if(Filas > 0){
                    }//Fin del for(i=0; i<4; i++){

                    if(vNoEncontrado){ //Indica que por lo menos un pago no se le ha efectuado, por lo que se generarï¿½ el complemento
                        //JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"crearComplemento");
                        //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Commit");
                        //pIdComple=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdComplemento.inputValue}");
                        //Agregar validacion si pIdComple tiene valor o no
                        if (pIdComple != null) {
                            ArrayList vParametros;
                            //rCompleDet = CompleDet.getCurrentRow();
                            if(rCompleDet.getAttribute("Seleccionar").equals(true)){
                                vParametros= new ArrayList();
                                //vParametros.add(rCompleDet.getAttribute("RegistroEmpleado"));
                                //vParametros.add(rCompleDet.getAttribute("Correlativo"));
                                //vParametros.add(rCompleDet.getAttribute("IdPuesto"));
                                vParametros.add(pIdComple);
                                //vParametros.add(rCompleDet.getAttribute("NumeroPlaza"));
                                //vParametros.add(rCompleDet.getAttribute("FechaFin"));
                                vParametros.add(rCompleDet.getAttribute("IdContrato"));
                                //vParametros.add(rCompleDet.getAttribute("IdPartida"));
                                //if (conec.Bol_ejecutar_procedimiento("SIS_COMPLEMENTOS_PKG.ComplementosXRetiro (?,?,?,?,?,?,?,?)",vParametros)){
                                if (conec.Bol_ejecutar_procedimiento("SIS_COMPLEMENTOS_PKG.ComplementosXRetiro (?,?)",vParametros)){
                                   // CompleDet.executeQuery();
                                    JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"actualizaSubProgramaCompl");
                                    utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Se ha calculado exitosamente la operacion"));
                                }else{
                                    utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Ha ocurrido un error, por favor revisar, registro "+rCompleDet.getAttribute("RegistroEmpleado").toString()));
                                }
                            }   //Fin de if(rCompleDet.getAttribute("Seleccionar").equals(true))
                        }else {
                            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Ha ocurrido un error al intentar generar las prestaciones"));
                        }//Fin del if (pIdComple != null) {
                    }//Fin del if(vNoEncontrado){
                    utils.setADFMensaje(new resulOp(resulOp.OPE_OK,vRespuesta));
                }//Fin del if(rCompleDet.getAttribute("Seleccionar").equals(true)){
                CompleDet.next();
            }//Fin del for(i=0; i<FilasTrabajadores; i++){
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Commit");
            CompleDet.executeQuery();
            btnBuscarHist_action();
            IrAPrestaciones();
            
            conec.cn_Cerrar_coneccion();
            return null;
        }catch (Exception e) {
            e.printStackTrace();
            conec.cn_Cerrar_coneccion();
            return null;
        }
    }

    public String btnBuscarYSel_action() {
        // Add event code here...
        try{
            if(this.inpRegPer.getValue() == null ){
                utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Por Favor debre de ingresar un REGISTRO DE PERSONAL"));
            }else{
                FacesContext ctx = FacesContext.getCurrentInstance();
                ValueBinding vb = ctx.getApplication().createValueBinding("#{data}");
                BindingContext bc = (BindingContext)vb.getValue(ctx);
                DCDataControl dc  = bc.findDataControl("QUERRYSDataControl");
                ApplicationModule am = (ApplicationModule)dc.getDataProvider();
                QUERRYSImpl service    = (QUERRYSImpl)am;

                int Filas, i;
                boolean Encontrado=false;
                ListadoPlazasXUniDepImpl Puestos = service.getListadoPlazasXUniDep();
                Filas = Puestos.getRowCount();
                Row rPuesto=null;
                if(Filas > 0 ){
                    Puestos.first();
                    for(i=0; i<Filas; i++){
                        rPuesto = Puestos.getCurrentRow();
                        if(rPuesto.getAttribute("RegistroEmpleado").toString().compareTo(this.inpRegPer.getValue().toString())==0){
                            if(this.inpPlaza.getValue()==null){
                                rPuesto.setAttribute("Seleccionar",true);
                                Encontrado=true;
                                //break;
                            }else{
                                if(rPuesto.getAttribute("NumeroPlaza").toString().compareTo(this.inpPlaza.getValue().toString())==0){
                                    rPuesto.setAttribute("Seleccionar",true);
                                    Encontrado=true;
                                    break;
                                }
                            }
                        }//Fin del if de comparacion
                        Puestos.next();
                    }//Fin del for(i=0; i<Filas; i++){
                    if(!Encontrado){
                        utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"No se encontraron los datos que se han ingresado, revise de nuevo la informaciï¿½n"));
                    }//Fin del if(Encontrado){
                }//Fin del if(Filas > 0 ){
            }
            return null;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String btnParamComplemento_action() {
        // Add event code here...
        boolean vRespuesta;
        if (vRespuesta = JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"ParamComplemento")){
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ExecuteSisComplemento");
            HabilitarSisComplemento();
        }
        return null;
    }

    public String btnBuscarComplemento_action() {
        // Add event code here...
        boolean vRespuesta;
        if (vRespuesta = JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"BuscarComplemento")){
            Object pIdComple;
            pIdComple=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdComplemento.inputValue}");
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pIdVar1.inputValue}",pIdComple);
            DeshabilitarSisComplemento();
        }
        return null;
    }

    public String btnEditarComplemento_action() {
        // Add event code here...
        this.selPeriodo.setReadOnly(false);
        this.btnParamComplemento.setDisabled(true);     //Deshabilito el boton de Ingresar parametros
        this.btnBuscarComplemento.setDisabled(true);    //Deshabilito el boton de buscar
        this.btnEditarComplemento.setDisabled(true);    //Deshabilito el boton editar
        this.btnGuardarComplemento.setDisabled(false);  //Habilito el boton para guardar
        this.btnCancelarComplemento.setDisabled(false);            //Habilito el boton de cancelar
        return null;
    }

    public String btnGuardarComplemento_action() {
        // Add event code here...
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Commit");
        this.selPeriodo.setReadOnly(true);
        this.btnEditarComplemento.setDisabled(false);   //Habilito el boton editar
        this.btnGuardarComplemento.setDisabled(true);   //Deshabilito el boton para guardar
        this.btnCancelarComplemento.setDisabled(true);            //Desabilito el boton de cancelar
        return null;
    }

    public String btnCancelarComplemento_action() {
        // Add event code here...
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Rollback");
        this.btnParamComplemento.setDisabled(false);     //Habilito el boton de Ingresar parametros
        this.btnBuscarComplemento.setDisabled(false);    //Habilito el boton de buscar
        this.btnEditarComplemento.setDisabled(false);    //Habilito el boton editar
        this.btnGuardarComplemento.setDisabled(true);    //Deshabilito el boton Guardan
        this.btnCancelarComplemento.setDisabled(true);  //Deshabilito el boton Cancelar
        this.selPeriodo.setReadOnly(true);
        return null;
    }


    public String btnEditarPrestacion_action() {
        // Add event code here...
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"cambiarEstadoTodos")){
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"cambiarEstadoActual");
        }

        HabilitarPrestacion();
        return null;
    }

    public String btnGrabarCambios_action() {
        // Add event code here...
        NameValuePairs vParametros;
        vParametros=new NameValuePairs();
        Object vIdCodNomina;
        Object vRegPer;
        vIdCodNomina=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{row.Codigonomina}");
        vRegPer=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{row.RegistroEmpleado}");
        if( Integer.parseInt(vRegPer.toString()) > 20169999){ //Descuento plan de prestaciones en Diferido 50% aplica solamente a carnets 2017 hacia delante
            if(Integer.parseInt(vIdCodNomina.toString()) ==14 || Integer.parseInt(vIdCodNomina.toString()) ==15){ //diferido junio o diciembre
                if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"borrarDetAjuste")){
                    JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Commit");
                    JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Descuento_Diferido50");
                    this.btnGrabarCambios.setDisabled(false);
                }
            }
        }

        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit")){
             utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Datos guardados exitosamente"));    
         }
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarDet");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"cambiarEstadoTodos");
        DeshabilitarPrestacion();
        return null;
    }

    public String btnCancelarPrestacion_action() {
        // Add event code here...
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Rollback");
        DeshabilitarPrestacion();
        return null;
    }

    public String cmdRefresh_action() {
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"ExecuteSisComplemento")){
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"actualizarVW");

            Boolean formaActiva = Boolean.parseBoolean(JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{!bindings.IsFormaActiva.inputValue}").toString());
            this.btnEditarPrestacion.setDisabled(formaActiva);
            this.btnBorrarFilaDetalle.setDisabled(formaActiva);
            this.commandLink2.setDisabled(formaActiva);
            this.commandLink1.setDisabled(formaActiva);
            this.btnCancelarPrestacion.setDisabled(true);
            this.btnGrabarCambios.setDisabled(true);
        }
        // Add event code here...
        return null;
    }

    public String btnBorrarFilaDetalle_action() {
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"borrarDetComple")){
            this.btnGrabarCambios.setDisabled(false);
        }
        return null;
    }

    private void IrAPrestaciones(){
        this.showBuscar.setDisclosed(false);
        this.showPrestaciones.setDisabled(false);
        this.showPrestaciones.setDisclosed(true);
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ExecuteSisComplemento");
        Object pIdComple;
        pIdComple=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdComplemento.inputValue}");
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pIdVar1.inputValue}",pIdComple);
    }

    private void HabilitarSisComplemento(){
        this.inpIdComplemento.setReadOnly(false);
        this.selPeriodo.setReadOnly(false);
        this.inpAnio.setReadOnly(false);
        this.selFechaPresentacion.setReadOnly(false);
        this.inpCreadoPor.setReadOnly(false);
        this.selFechaCreacion.setReadOnly(false);
    }

    private void DeshabilitarSisComplemento(){
        this.inpIdComplemento.setReadOnly(true);
        this.selPeriodo.setReadOnly(true);
        this.inpAnio.setReadOnly(true);
        this.selFechaPresentacion.setReadOnly(true);
        this.inpCreadoPor.setReadOnly(true);
        this.selFechaCreacion.setReadOnly(true);
    }

    private void HabilitarPrestacion(){
        this.btnEditarPrestacion.setDisabled(true);
        this.tableSelectOne3.setDisabled(true);
        this.btnCancelarPrestacion.setDisabled(false);
        this.btnGrabarCambios.setDisabled(false);

    }

    private void DeshabilitarPrestacion(){
        this.btnCancelarPrestacion.setDisabled(true);
        this.btnEditarPrestacion.setDisabled(false);
        this.tableSelectOne3.setDisabled(false);
        this.btnGrabarCambios.setDisabled(true);
    }
    /* ************************************************************************/
    /* ************************************************************************/
    /* ************************************************************************/


    public void setPanelForm2(CorePanelForm panelForm2) {
        this.panelForm2 = panelForm2;
    }

    public CorePanelForm getPanelForm2() {
        return panelForm2;
    }

    public void setInpIdComplemento(CoreInputText inputText3) {
        this.inpIdComplemento = inputText3;
    }

    public CoreInputText getInpIdComplemento() {
        return inpIdComplemento;
    }

    public void setInpIdEstado(CoreInputText inputText4) {
        this.inpIdEstado = inputText4;
    }

    public CoreInputText getInpIdEstado() {
        return inpIdEstado;
    }

    public void setInpIdTipo(CoreInputText inputText5) {
        this.inpIdTipo = inputText5;
    }

    public CoreInputText getInpIdTipo() {
        return inpIdTipo;
    }

    public void setInpIdSubprograma(CoreInputText inputText6) {
        this.inpIdSubprograma = inputText6;
    }

    public CoreInputText getInpIdSubprograma() {
        return inpIdSubprograma;
    }

    public void setInpPeriodo(CoreInputText inputText7) {
        this.inpPeriodo = inputText7;
    }

    public CoreInputText getInpPeriodo() {
        return inpPeriodo;
    }

    public void setInpAnio(CoreInputText inputText8) {
        this.inpAnio = inputText8;
    }

    public CoreInputText getInpAnio() {
        return inpAnio;
    }

    public void setSelFechaPresentacion(CoreSelectInputDate selectInputDate1) {
        this.selFechaPresentacion = selectInputDate1;
    }

    public CoreSelectInputDate getSelFechaPresentacion() {
        return selFechaPresentacion;
    }

    public void setInpCreadoPor(CoreInputText inputText9) {
        this.inpCreadoPor = inputText9;
    }

    public CoreInputText getInpCreadoPor() {
        return inpCreadoPor;
    }

    public void setSelFechaCreacion(CoreSelectInputDate selectInputDate2) {
        this.selFechaCreacion = selectInputDate2;
    }

    public CoreSelectInputDate getSelFechaCreacion() {
        return selFechaCreacion;
    }

    public void setInputText10(CoreInputText inputText10) {
        this.inputText10 = inputText10;
    }

    public CoreInputText getInputText10() {
        return inputText10;
    }

    public void setSelectInputDate3(CoreSelectInputDate selectInputDate3) {
        this.selectInputDate3 = selectInputDate3;
    }

    public CoreSelectInputDate getSelectInputDate3() {
        return selectInputDate3;
    }

    public void setInputText11(CoreInputText inputText11) {
        this.inputText11 = inputText11;
    }

    public CoreInputText getInputText11() {
        return inputText11;
    }

    public void setInputText12(CoreInputText inputText12) {
        this.inputText12 = inputText12;
    }

    public CoreInputText getInputText12() {
        return inputText12;
    }

    public void setInputText13(CoreInputText inputText13) {
        this.inputText13 = inputText13;
    }

    public CoreInputText getInputText13() {
        return inputText13;
    }

    public void setPanelGroup1(CorePanelGroup panelGroup1) {
        this.panelGroup1 = panelGroup1;
    }

    public CorePanelGroup getPanelGroup1() {
        return panelGroup1;
    }

    public void setPanelButtonBar1(CorePanelButtonBar panelButtonBar1) {
        this.panelButtonBar1 = panelButtonBar1;
    }

    public CorePanelButtonBar getPanelButtonBar1() {
        return panelButtonBar1;
    }

    public void setCommandButton4(CoreCommandButton commandButton4) {
        this.commandButton4 = commandButton4;
    }

    public CoreCommandButton getCommandButton4() {
        return commandButton4;
    }

    public void setCommandButton5(CoreCommandButton commandButton5) {
        this.commandButton5 = commandButton5;
    }

    public CoreCommandButton getCommandButton5() {
        return commandButton5;
    }

    public void setCommandButton6(CoreCommandButton commandButton6) {
        this.commandButton6 = commandButton6;
    }

    public CoreCommandButton getCommandButton6() {
        return commandButton6;
    }

    public void setCommandButton7(CoreCommandButton commandButton7) {
        this.commandButton7 = commandButton7;
    }

    public CoreCommandButton getCommandButton7() {
        return commandButton7;
    }

    public void setCommandButton8(CoreCommandButton commandButton8) {
        this.commandButton8 = commandButton8;
    }

    public CoreCommandButton getCommandButton8() {
        return commandButton8;
    }

    public void setTable3(CoreTable table3) {
        this.table3 = table3;
    }

    public CoreTable getTable3() {
        return table3;
    }

    public void setColumn19(CoreColumn column19) {
        this.column19 = column19;
    }

    public CoreColumn getColumn19() {
        return column19;
    }

    public void setInputText14(CoreInputText inputText14) {
        this.inputText14 = inputText14;
    }

    public CoreInputText getInputText14() {
        return inputText14;
    }

    public void setColumn20(CoreColumn column20) {
        this.column20 = column20;
    }

    public CoreColumn getColumn20() {
        return column20;
    }

    public void setInputText15(CoreInputText inputText15) {
        this.inputText15 = inputText15;
    }

    public CoreInputText getInputText15() {
        return inputText15;
    }

    public void setColumn21(CoreColumn column21) {
        this.column21 = column21;
    }

    public CoreColumn getColumn21() {
        return column21;
    }

    public void setInputText16(CoreInputText inputText16) {
        this.inputText16 = inputText16;
    }

    public CoreInputText getInputText16() {
        return inputText16;
    }

    public void setColumn22(CoreColumn column22) {
        this.column22 = column22;
    }

    public CoreColumn getColumn22() {
        return column22;
    }

    public void setInputText17(CoreInputText inputText17) {
        this.inputText17 = inputText17;
    }

    public CoreInputText getInputText17() {
        return inputText17;
    }

    public void setColumn23(CoreColumn column23) {
        this.column23 = column23;
    }

    public CoreColumn getColumn23() {
        return column23;
    }

    public void setInputText18(CoreInputText inputText18) {
        this.inputText18 = inputText18;
    }

    public CoreInputText getInputText18() {
        return inputText18;
    }

    public void setColumn24(CoreColumn column24) {
        this.column24 = column24;
    }

    public CoreColumn getColumn24() {
        return column24;
    }

    public void setInputText19(CoreInputText inputText19) {
        this.inputText19 = inputText19;
    }

    public CoreInputText getInputText19() {
        return inputText19;
    }

    public void setColumn25(CoreColumn column25) {
        this.column25 = column25;
    }

    public CoreColumn getColumn25() {
        return column25;
    }

    public void setInputText20(CoreInputText inputText20) {
        this.inputText20 = inputText20;
    }

    public void setInputText2(CoreInputText inputText2) {
        this.inputText2 = inputText2;
    }

    public CoreInputText getInputText20() {
        return inputText20;
    }

    public void setColumn26(CoreColumn column26) {
        this.column26 = column26;
    }

    public CoreColumn getColumn26() {
        return column26;
    }

    public void setInputText21(CoreInputText inputText21) {
        this.inputText21 = inputText21;
    }

    public CoreInputText getInputText21() {
        return inputText21;
    }

    public void setColumn27(CoreColumn column27) {
        this.column27 = column27;
    }

    public CoreColumn getColumn27() {
        return column27;
    }

    public void setInputText22(CoreInputText inputText22) {
        this.inputText22 = inputText22;
    }

    public CoreInputText getInputText22() {
        return inputText22;
    }

    public void setColumn28(CoreColumn column28) {
        this.column28 = column28;
    }

    public CoreColumn getColumn28() {
        return column28;
    }

    public void setInputText23(CoreInputText inputText23) {
        this.inputText23 = inputText23;
    }

    public CoreInputText getInputText23() {
        return inputText23;
    }

    public void setColumn29(CoreColumn column29) {
        this.column29 = column29;
    }

    public CoreColumn getColumn29() {
        return column29;
    }

    public void setInputText24(CoreInputText inputText24) {
        this.inputText24 = inputText24;
    }

    public CoreInputText getInputText24() {
        return inputText24;
    }

    public void setColSueldoBase(CoreColumn column30) {
        this.colSueldoBase = column30;
    }

    public CoreColumn getColSueldoBase() {
        return colSueldoBase;
    }

    public void setInpSueldoBase(CoreInputText inputText25) {
        this.inpSueldoBase = inputText25;
    }

    public CoreInputText getInpSueldoBase() {
        return inpSueldoBase;
    }

    public void setColumn31(CoreColumn column31) {
        this.column31 = column31;
    }

    public CoreColumn getColumn31() {
        return column31;
    }

    public void setInputText26(CoreInputText inputText26) {
        this.inputText26 = inputText26;
    }

    public CoreInputText getInputText26() {
        return inputText26;
    }

    public void setColumn32(CoreColumn column32) {
        this.column32 = column32;
    }

    public CoreColumn getColumn32() {
        return column32;
    }

    public void setInputText27(CoreInputText inputText27) {
        this.inputText27 = inputText27;
    }

    public CoreInputText getInputText27() {
        return inputText27;
    }

    public void setColNominal(CoreColumn column33) {
        this.colNominal = column33;
    }

    public CoreColumn getColNominal() {
        return colNominal;
    }

    public void setInpNominal(CoreInputText inputText28) {
        this.inpNominal = inputText28;
    }

    public CoreInputText getInpNominal() {
        return inpNominal;
    }

    public void setColumn34(CoreColumn column34) {
        this.column34 = column34;
    }

    public CoreColumn getColumn34() {
        return column34;
    }

    public void setInputText29(CoreInputText inputText29) {
        this.inputText29 = inputText29;
    }

    public CoreInputText getInputText29() {
        return inputText29;
    }

    public void setColumn35(CoreColumn column35) {
        this.column35 = column35;
    }

    public CoreColumn getColumn35() {
        return column35;
    }

    public void setInputText30(CoreInputText inputText30) {
        this.inputText30 = inputText30;
    }

    public CoreInputText getInputText30() {
        return inputText30;
    }

    public void setColLiquido(CoreColumn column36) {
        this.colLiquido = column36;
    }

    public CoreColumn getColLiquido() {
        return colLiquido;
    }

    public void setInpLiquido(CoreInputText inputText31) {
        this.inpLiquido = inputText31;
    }

    public CoreInputText getInpLiquido() {
        return inpLiquido;
    }

    public void setColumn37(CoreColumn column37) {
        this.column37 = column37;
    }

    public CoreColumn getColumn37() {
        return column37;
    }

    public void setInpCantHoras(CoreInputText inpCantHoras) {
        this.inpCantHoras = inpCantHoras;
    }

    public CoreInputText getInpCantHoras() {
        return inpCantHoras;
    }

    public void setColumn38(CoreColumn column38) {
        this.column38 = column38;
    }

    public CoreColumn getColumn38() {
        return column38;
    }

    public void setInpDiasLab(CoreInputText inpDiasLab) {
        this.inpDiasLab = inpDiasLab;
    }

    public CoreInputText getInpDiasLab() {
        return inpDiasLab;
    }

    public void setColumn39(CoreColumn column39) {
        this.column39 = column39;
    }

    public CoreColumn getColumn39() {
        return column39;
    }

    public void setInputText34(CoreInputText inputText34) {
        this.inputText34 = inputText34;
    }

    public CoreInputText getInputText34() {
        return inputText34;
    }

    public void setColumn40(CoreColumn column40) {
        this.column40 = column40;
    }

    public CoreColumn getColumn40() {
        return column40;
    }

    public void setInputText35(CoreInputText inputText35) {
        this.inputText35 = inputText35;
    }

    public CoreInputText getInputText35() {
        return inputText35;
    }

    public void setColumn41(CoreColumn column41) {
        this.column41 = column41;
    }

    public CoreColumn getColumn41() {
        return column41;
    }

    public void setInputText36(CoreInputText inputText36) {
        this.inputText36 = inputText36;
    }

    public CoreInputText getInputText36() {
        return inputText36;
    }

    public void setColumn42(CoreColumn column42) {
        this.column42 = column42;
    }

    public CoreColumn getColumn42() {
        return column42;
    }

    public void setInputText37(CoreInputText inputText37) {
        this.inputText37 = inputText37;
    }

    public CoreInputText getInputText37() {
        return inputText37;
    }


    public void setColumn44(CoreColumn column44) {
        this.column44 = column44;
    }

    public CoreColumn getColumn44() {
        return column44;
    }

    public void setInputText39(CoreInputText inputText39) {
        this.inputText39 = inputText39;
    }

    public CoreInputText getInputText39() {
        return inputText39;
    }

    public void setTableSelectOne3(CoreTableSelectOne tableSelectOne3) {
        this.tableSelectOne3 = tableSelectOne3;
    }

    public CoreTableSelectOne getTableSelectOne3() {
        return tableSelectOne3;
    }

    public void setCommandButton9(CoreCommandButton commandButton9) {
        this.commandButton9 = commandButton9;
    }

    public CoreCommandButton getCommandButton9() {
        return commandButton9;
    }

    public void setBtnIrPrestaciones(CoreCommandButton commandButton1) {
        this.btnIrPrestaciones = commandButton1;
    }

    public CoreCommandButton getBtnIrPrestaciones() {
        return btnIrPrestaciones;
    }

    public void setPanelButtonBar2(CorePanelButtonBar panelButtonBar2) {
        this.panelButtonBar2 = panelButtonBar2;
    }

    public CorePanelButtonBar getPanelButtonBar2() {
        return panelButtonBar2;
    }


    public void setLnkImprimir(CoreCommandLink commandLink1) {
        this.lnkImprimir = commandLink1;
    }

    public CoreCommandLink getLnkImprimir() {
        return lnkImprimir;
    }

    public void setObjectImage1(CoreObjectImage objectImage1) {
        this.objectImage1 = objectImage1;
    }

    public CoreObjectImage getObjectImage1() {
        return objectImage1;
    }

    public void setPanelHorizontal1(CorePanelHorizontal panelHorizontal1) {
        this.panelHorizontal1 = panelHorizontal1;
    }

    public CorePanelHorizontal getPanelHorizontal1() {
        return panelHorizontal1;
    }

    public void setSelMes(CoreSelectOneChoice selectOneChoice1) {
        this.selMes = selectOneChoice1;
    }

    public CoreSelectOneChoice getSelMes() {
        return selMes;
    }


    public void setSelectItem1(CoreSelectItem selectItem1) {
        this.selectItem1 = selectItem1;
    }

    public CoreSelectItem getSelectItem1() {
        return selectItem1;
    }

    public void setSelectItem2(CoreSelectItem selectItem2) {
        this.selectItem2 = selectItem2;
    }

    public CoreSelectItem getSelectItem2() {
        return selectItem2;
    }

    public void setSelectItem3(CoreSelectItem selectItem3) {
        this.selectItem3 = selectItem3;
    }

    public CoreSelectItem getSelectItem3() {
        return selectItem3;
    }

    public void setSelectItem4(CoreSelectItem selectItem4) {
        this.selectItem4 = selectItem4;
    }

    public CoreSelectItem getSelectItem4() {
        return selectItem4;
    }

    public void setSelectItem5(CoreSelectItem selectItem5) {
        this.selectItem5 = selectItem5;
    }

    public CoreSelectItem getSelectItem5() {
        return selectItem5;
    }

    public void setSelectItem6(CoreSelectItem selectItem6) {
        this.selectItem6 = selectItem6;
    }

    public CoreSelectItem getSelectItem6() {
        return selectItem6;
    }

    public void setSelectItem7(CoreSelectItem selectItem7) {
        this.selectItem7 = selectItem7;
    }

    public CoreSelectItem getSelectItem7() {
        return selectItem7;
    }

    public void setSelectItem8(CoreSelectItem selectItem8) {
        this.selectItem8 = selectItem8;
    }

    public CoreSelectItem getSelectItem8() {
        return selectItem8;
    }

    public void setSelectItem9(CoreSelectItem selectItem9) {
        this.selectItem9 = selectItem9;
    }

    public CoreSelectItem getSelectItem9() {
        return selectItem9;
    }

    public void setSelectItem10(CoreSelectItem selectItem10) {
        this.selectItem10 = selectItem10;
    }

    public CoreSelectItem getSelectItem10() {
        return selectItem10;
    }

    public void setSelectItem11(CoreSelectItem selectItem11) {
        this.selectItem11 = selectItem11;
    }

    public CoreSelectItem getSelectItem11() {
        return selectItem11;
    }

    public void setSelectItem12(CoreSelectItem selectItem12) {
        this.selectItem12 = selectItem12;
    }

    public CoreSelectItem getSelectItem12() {
        return selectItem12;
    }


    /*public BindingContainer getBindings() {
        return this.bindings;
    }

    public void setBindings(BindingContainer bindings) {
        this.bindings = bindings;
    }*/

    public void setBtnEditarPrestacion(CoreCommandButton commandButton1) {
        this.btnEditarPrestacion = commandButton1;
    }

    public CoreCommandButton getBtnEditarPrestacion() {
        return btnEditarPrestacion;
    }

    public void setBtnGrabarCambios(CoreCommandButton btnGrabarCambios) {
        this.btnGrabarCambios = btnGrabarCambios;
    }

    public CoreCommandButton getBtnGrabarCambios() {
        return btnGrabarCambios;
    }

    public void setCommandLink1(CoreCommandLink commandLink1) {
        this.commandLink1 = commandLink1;
    }

    public CoreCommandLink getCommandLink1() {
        return commandLink1;
    }

    public void setObjectImage2(CoreObjectImage objectImage2) {
        this.objectImage2 = objectImage2;
    }

    public CoreObjectImage getObjectImage2() {
        return objectImage2;
    }

    public void setCommandLink2(CoreCommandLink commandLink2) {
        this.commandLink2 = commandLink2;
    }

    public CoreCommandLink getCommandLink2() {
        return commandLink2;
    }

    public void setObjectImage3(CoreObjectImage objectImage3) {
        this.objectImage3 = objectImage3;
    }

    public CoreObjectImage getObjectImage3() {
        return objectImage3;
    }


    public void setBtnCancelarPrestacion(CoreCommandButton commandButton1) {
        this.btnCancelarPrestacion = commandButton1;
    }

    public CoreCommandButton getBtnCancelarPrestacion() {
        return btnCancelarPrestacion;
    }


    public void setBtnParamComplemento(CoreCommandButton commandButton1) {
        this.btnParamComplemento = commandButton1;
    }

    public CoreCommandButton getBtnParamComplemento() {
        return btnParamComplemento;
    }

    public void setBtnBuscarComplemento(CoreCommandButton commandButton2) {
        this.btnBuscarComplemento = commandButton2;
    }

    public CoreCommandButton getBtnBuscarComplemento() {
        return btnBuscarComplemento;
    }


    public void setInputText3(CoreInputText inputText3) {
        this.inputText3 = inputText3;
    }

    public CoreInputText getInputText3() {
        return inputText3;
    }

    public void setInputText4(CoreInputText inputText4) {
        this.inputText4 = inputText4;
    }

    public CoreInputText getInputText4() {
        return inputText4;
    }


    public void setInputText6(CoreInputText inputText6) {
        this.inputText6 = inputText6;
    }

    public CoreInputText getInputText6() {
        return inputText6;
    }


    public void setInputText7(CoreInputText inputText7) {
        this.inputText7 = inputText7;
    }

    public CoreInputText getInputText7() {
        return inputText7;
    }

    public void setBtnEditarComplemento(CoreCommandButton commandButton1) {
        this.btnEditarComplemento = commandButton1;
    }

    public CoreCommandButton getBtnEditarComplemento() {
        return btnEditarComplemento;
    }

    public void setBtnGuardarComplemento(CoreCommandButton commandButton1) {
        this.btnGuardarComplemento = commandButton1;
    }

    public CoreCommandButton getBtnGuardarComplemento() {
        return btnGuardarComplemento;
    }

    public void setSelPeriodo(CoreSelectOneChoice selectOneChoice1) {
        this.selPeriodo = selectOneChoice1;
    }

    public CoreSelectOneChoice getSelPeriodo() {
        return selPeriodo;
    }

    public void setSelectItem13(CoreSelectItem selectItem13) {
        this.selectItem13 = selectItem13;
    }

    public CoreSelectItem getSelectItem13() {
        return selectItem13;
    }

    public void setSelectItem14(CoreSelectItem selectItem14) {
        this.selectItem14 = selectItem14;
    }

    public CoreSelectItem getSelectItem14() {
        return selectItem14;
    }

    public void setSelectItem15(CoreSelectItem selectItem15) {
        this.selectItem15 = selectItem15;
    }

    public CoreSelectItem getSelectItem15() {
        return selectItem15;
    }

    public void setSelectItem16(CoreSelectItem selectItem16) {
        this.selectItem16 = selectItem16;
    }

    public CoreSelectItem getSelectItem16() {
        return selectItem16;
    }

    public void setSelectItem17(CoreSelectItem selectItem17) {
        this.selectItem17 = selectItem17;
    }

    public CoreSelectItem getSelectItem17() {
        return selectItem17;
    }

    public void setSelectItem18(CoreSelectItem selectItem18) {
        this.selectItem18 = selectItem18;
    }

    public CoreSelectItem getSelectItem18() {
        return selectItem18;
    }

    public void setSelectItem19(CoreSelectItem selectItem19) {
        this.selectItem19 = selectItem19;
    }

    public CoreSelectItem getSelectItem19() {
        return selectItem19;
    }

    public void setSelectItem20(CoreSelectItem selectItem20) {
        this.selectItem20 = selectItem20;
    }

    public CoreSelectItem getSelectItem20() {
        return selectItem20;
    }

    public void setSelectItem21(CoreSelectItem selectItem21) {
        this.selectItem21 = selectItem21;
    }

    public CoreSelectItem getSelectItem21() {
        return selectItem21;
    }

    public void setSelectItem22(CoreSelectItem selectItem22) {
        this.selectItem22 = selectItem22;
    }

    public CoreSelectItem getSelectItem22() {
        return selectItem22;
    }

    public void setSelectItem23(CoreSelectItem selectItem23) {
        this.selectItem23 = selectItem23;
    }

    public CoreSelectItem getSelectItem23() {
        return selectItem23;
    }

    public void setSelectItem24(CoreSelectItem selectItem24) {
        this.selectItem24 = selectItem24;
    }

    public CoreSelectItem getSelectItem24() {
        return selectItem24;
    }


    public void setBtnCancelarComplemento(CoreCommandButton commandButton1) {
        this.btnCancelarComplemento = commandButton1;
    }

    public CoreCommandButton getBtnCancelarComplemento() {
        return btnCancelarComplemento;
    }

    public void setSelectItem25(CoreSelectItem selectItem25) {
        this.selectItem25 = selectItem25;
    }

    public CoreSelectItem getSelectItem25() {
        return selectItem25;
    }


    public void setColumn48(CoreColumn column48) {
        this.column48 = column48;
    }

    public CoreColumn getColumn48() {
        return column48;
    }

    public void setInputText5(CoreInputText inputText5) {
        this.inputText5 = inputText5;
    }

    public CoreInputText getInputText5() {
        return inputText5;
    }


    public void setBtnBorrarFilaDetalle(CoreCommandButton commandButton1) {
        this.btnBorrarFilaDetalle = commandButton1;
    }

    public CoreCommandButton getBtnBorrarFilaDetalle() {
        return btnBorrarFilaDetalle;
    }


    public void setShowHistorico(CoreShowDetailItem showDetailItem1) {
        this.showHistorico = showDetailItem1;
    }

    public CoreShowDetailItem getShowHistorico() {
        return showHistorico;
    }

    public void setPanelHeader5(CorePanelHeader panelHeader5) {
        this.panelHeader5 = panelHeader5;
    }

    public CorePanelHeader getPanelHeader5() {
        return panelHeader5;
    }

    public void setPanelHeader6(CorePanelHeader panelHeader6) {
        this.panelHeader6 = panelHeader6;
    }

    public CorePanelHeader getPanelHeader6() {
        return panelHeader6;
    }

    public void setPanelForm3(CorePanelForm panelForm3) {
        this.panelForm3 = panelForm3;
    }

    public CorePanelForm getPanelForm3() {
        return panelForm3;
    }

    public void setSelectInputDate1(CoreSelectInputDate selectInputDate1) {
        this.selectInputDate1 = selectInputDate1;
    }

    public CoreSelectInputDate getSelectInputDate1() {
        return selectInputDate1;
    }

    public void setSelectInputDate2(CoreSelectInputDate selectInputDate2) {
        this.selectInputDate2 = selectInputDate2;
    }

    public CoreSelectInputDate getSelectInputDate2() {
        return selectInputDate2;
    }


    public void setBtnBuscarHist(CoreCommandButton commandButton1) {
        this.btnBuscarHist = commandButton1;
    }

    public CoreCommandButton getBtnBuscarHist() {
        return btnBuscarHist;
    }

    public void setTable4(CoreTable table4) {
        this.table4 = table4;
    }

    public CoreTable getTable4() {
        return table4;
    }

    public void setColumn49(CoreColumn column49) {
        this.column49 = column49;
    }

    public CoreColumn getColumn49() {
        return column49;
    }

    public void setOutputText3(CoreOutputText outputText3) {
        this.outputText3 = outputText3;
    }

    public CoreOutputText getOutputText3() {
        return outputText3;
    }

    public void setColumn50(CoreColumn column50) {
        this.column50 = column50;
    }

    public CoreColumn getColumn50() {
        return column50;
    }

    public void setOutputText9(CoreOutputText outputText9) {
        this.outputText9 = outputText9;
    }

    public CoreOutputText getOutputText9() {
        return outputText9;
    }

    public void setColumn51(CoreColumn column51) {
        this.column51 = column51;
    }

    public CoreColumn getColumn51() {
        return column51;
    }

    public void setOutputText12(CoreOutputText outputText12) {
        this.outputText12 = outputText12;
    }

    public CoreOutputText getOutputText12() {
        return outputText12;
    }

    public void setColumn52(CoreColumn column52) {
        this.column52 = column52;
    }

    public CoreColumn getColumn52() {
        return column52;
    }

    public void setOutputText19(CoreOutputText outputText19) {
        this.outputText19 = outputText19;
    }

    public CoreOutputText getOutputText19() {
        return outputText19;
    }

    public void setColumn53(CoreColumn column53) {
        this.column53 = column53;
    }

    public CoreColumn getColumn53() {
        return column53;
    }

    public void setOutputText26(CoreOutputText outputText26) {
        this.outputText26 = outputText26;
    }

    public CoreOutputText getOutputText26() {
        return outputText26;
    }

    public void setColumn54(CoreColumn column54) {
        this.column54 = column54;
    }

    public CoreColumn getColumn54() {
        return column54;
    }

    public void setOutputText27(CoreOutputText outputText27) {
        this.outputText27 = outputText27;
    }

    public CoreOutputText getOutputText27() {
        return outputText27;
    }

    public void setColumn55(CoreColumn column55) {
        this.column55 = column55;
    }

    public CoreColumn getColumn55() {
        return column55;
    }

    public void setOutputText28(CoreOutputText outputText28) {
        this.outputText28 = outputText28;
    }

    public CoreOutputText getOutputText28() {
        return outputText28;
    }

    public void setColumn56(CoreColumn column56) {
        this.column56 = column56;
    }

    public CoreColumn getColumn56() {
        return column56;
    }

    public void setOutputText29(CoreOutputText outputText29) {
        this.outputText29 = outputText29;
    }

    public CoreOutputText getOutputText29() {
        return outputText29;
    }

    public void setColumn57(CoreColumn column57) {
        this.column57 = column57;
    }

    public CoreColumn getColumn57() {
        return column57;
    }

    public void setOutputText30(CoreOutputText outputText30) {
        this.outputText30 = outputText30;
    }

    public CoreOutputText getOutputText30() {
        return outputText30;
    }

    public void setColumn58(CoreColumn column58) {
        this.column58 = column58;
    }

    public CoreColumn getColumn58() {
        return column58;
    }

    public void setOutputText31(CoreOutputText outputText31) {
        this.outputText31 = outputText31;
    }

    public CoreOutputText getOutputText31() {
        return outputText31;
    }

    public void setColumn59(CoreColumn column59) {
        this.column59 = column59;
    }

    public CoreColumn getColumn59() {
        return column59;
    }

    public void setOutputText32(CoreOutputText outputText32) {
        this.outputText32 = outputText32;
    }

    public CoreOutputText getOutputText32() {
        return outputText32;
    }

    public void setColumn60(CoreColumn column60) {
        this.column60 = column60;
    }

    public CoreColumn getColumn60() {
        return column60;
    }

    public void setOutputText33(CoreOutputText outputText33) {
        this.outputText33 = outputText33;
    }

    public CoreOutputText getOutputText33() {
        return outputText33;
    }

    public void setColumn61(CoreColumn column61) {
        this.column61 = column61;
    }

    public CoreColumn getColumn61() {
        return column61;
    }

    public void setOutputText34(CoreOutputText outputText34) {
        this.outputText34 = outputText34;
    }

    public CoreOutputText getOutputText34() {
        return outputText34;
    }


    public void setColumn63(CoreColumn column63) {
        this.column63 = column63;
    }

    public CoreColumn getColumn63() {
        return column63;
    }

    public void setOutputText36(CoreOutputText outputText36) {
        this.outputText36 = outputText36;
    }

    public CoreOutputText getOutputText36() {
        return outputText36;
    }

    public void setColumn64(CoreColumn column64) {
        this.column64 = column64;
    }

    public CoreColumn getColumn64() {
        return column64;
    }

    public void setOutputText37(CoreOutputText outputText37) {
        this.outputText37 = outputText37;
    }

    public CoreOutputText getOutputText37() {
        return outputText37;
    }

    public void setColumn65(CoreColumn column65) {
        this.column65 = column65;
    }

    public CoreColumn getColumn65() {
        return column65;
    }

    public void setOutputText38(CoreOutputText outputText38) {
        this.outputText38 = outputText38;
    }

    public CoreOutputText getOutputText38() {
        return outputText38;
    }

    public void setColumn66(CoreColumn column66) {
        this.column66 = column66;
    }

    public CoreColumn getColumn66() {
        return column66;
    }

    public void setOutputText39(CoreOutputText outputText39) {
        this.outputText39 = outputText39;
    }

    public CoreOutputText getOutputText39() {
        return outputText39;
    }

    public void setColumn67(CoreColumn column67) {
        this.column67 = column67;
    }

    public CoreColumn getColumn67() {
        return column67;
    }

    public void setOutputText40(CoreOutputText outputText40) {
        this.outputText40 = outputText40;
    }

    public CoreOutputText getOutputText40() {
        return outputText40;
    }

    public void setColumn68(CoreColumn column68) {
        this.column68 = column68;
    }

    public CoreColumn getColumn68() {
        return column68;
    }

    public void setOutputText41(CoreOutputText outputText41) {
        this.outputText41 = outputText41;
    }

    public CoreOutputText getOutputText41() {
        return outputText41;
    }

    public void setColumn69(CoreColumn column69) {
        this.column69 = column69;
    }

    public CoreColumn getColumn69() {
        return column69;
    }

    public void setOutputText42(CoreOutputText outputText42) {
        this.outputText42 = outputText42;
    }

    public CoreOutputText getOutputText42() {
        return outputText42;
    }

    public void setColumn70(CoreColumn column70) {
        this.column70 = column70;
    }

    public CoreColumn getColumn70() {
        return column70;
    }

    public void setOutputText43(CoreOutputText outputText43) {
        this.outputText43 = outputText43;
    }

    public CoreOutputText getOutputText43() {
        return outputText43;
    }

    public void setTableSelectOne4(CoreTableSelectOne tableSelectOne4) {
        this.tableSelectOne4 = tableSelectOne4;
    }

    public CoreTableSelectOne getTableSelectOne4() {
        return tableSelectOne4;
    }

    public void setBtnEditarCompl(CoreCommandButton commandButton1) {
        this.btnEditarCompl = commandButton1;
    }

    public CoreCommandButton getBtnEditarCompl() {
        return btnEditarCompl;
    }

    public void setColumn62(CoreColumn column62) {
        this.column62 = column62;
    }

    public CoreColumn getColumn62() {
        return column62;
    }

    public void setOutputText35(CoreOutputText outputText35) {
        this.outputText35 = outputText35;
    }

    public CoreOutputText getOutputText35() {
        return outputText35;
    }

    public void setCommandLink3(CoreCommandLink commandLink3) {
        this.commandLink3 = commandLink3;
    }

    public CoreCommandLink getCommandLink3() {
        return commandLink3;
    }

    public void setObjectImage4(CoreObjectImage objectImage4) {
        this.objectImage4 = objectImage4;
    }

    public CoreObjectImage getObjectImage4() {
        return objectImage4;
    }


    public void setTable1(CoreTable table1) {
        this.table1 = table1;
    }

    public CoreTable getTable1() {
        return table1;
    }

    public void setColumn1(CoreColumn column1) {
        this.column1 = column1;
    }

    public CoreColumn getColumn1() {
        return column1;
    }

    public void setOutputText1(CoreOutputText outputText1) {
        this.outputText1 = outputText1;
    }

    public CoreOutputText getOutputText1() {
        return outputText1;
    }

    public void setColumn2(CoreColumn column2) {
        this.column2 = column2;
    }

    public CoreColumn getColumn2() {
        return column2;
    }

    public void setOutputText2(CoreOutputText outputText2) {
        this.outputText2 = outputText2;
    }

    public CoreOutputText getOutputText2() {
        return outputText2;
    }

    public void setColumn3(CoreColumn column3) {
        this.column3 = column3;
    }

    public CoreColumn getColumn3() {
        return column3;
    }

    public void setOutputText4(CoreOutputText outputText4) {
        this.outputText4 = outputText4;
    }

    public CoreOutputText getOutputText4() {
        return outputText4;
    }

    public void setColumn4(CoreColumn column4) {
        this.column4 = column4;
    }

    public CoreColumn getColumn4() {
        return column4;
    }

    public void setOutputText5(CoreOutputText outputText5) {
        this.outputText5 = outputText5;
    }

    public CoreOutputText getOutputText5() {
        return outputText5;
    }

    public void setColumn5(CoreColumn column5) {
        this.column5 = column5;
    }

    public CoreColumn getColumn5() {
        return column5;
    }

    public void setOutputText6(CoreOutputText outputText6) {
        this.outputText6 = outputText6;
    }

    public CoreOutputText getOutputText6() {
        return outputText6;
    }

    public void setColumn6(CoreColumn column6) {
        this.column6 = column6;
    }

    public CoreColumn getColumn6() {
        return column6;
    }

    public void setOutputText7(CoreOutputText outputText7) {
        this.outputText7 = outputText7;
    }

    public CoreOutputText getOutputText7() {
        return outputText7;
    }

    public void setColumn7(CoreColumn column7) {
        this.column7 = column7;
    }

    public CoreColumn getColumn7() {
        return column7;
    }

    public void setOutputText8(CoreOutputText outputText8) {
        this.outputText8 = outputText8;
    }

    public CoreOutputText getOutputText8() {
        return outputText8;
    }

    public void setColumn8(CoreColumn column8) {
        this.column8 = column8;
    }

    public CoreColumn getColumn8() {
        return column8;
    }

    public void setOutputText10(CoreOutputText outputText10) {
        this.outputText10 = outputText10;
    }

    public CoreOutputText getOutputText10() {
        return outputText10;
    }

    public void setColumn9(CoreColumn column9) {
        this.column9 = column9;
    }

    public CoreColumn getColumn9() {
        return column9;
    }

    public void setOutputText11(CoreOutputText outputText11) {
        this.outputText11 = outputText11;
    }

    public CoreOutputText getOutputText11() {
        return outputText11;
    }

    public void setColumn10(CoreColumn column10) {
        this.column10 = column10;
    }

    public CoreColumn getColumn10() {
        return column10;
    }

    public void setOutputText13(CoreOutputText outputText13) {
        this.outputText13 = outputText13;
    }

    public CoreOutputText getOutputText13() {
        return outputText13;
    }

    public void setColumn11(CoreColumn column11) {
        this.column11 = column11;
    }

    public CoreColumn getColumn11() {
        return column11;
    }

    public void setOutputText14(CoreOutputText outputText14) {
        this.outputText14 = outputText14;
    }

    public CoreOutputText getOutputText14() {
        return outputText14;
    }

    public void setColumn12(CoreColumn column12) {
        this.column12 = column12;
    }

    public CoreColumn getColumn12() {
        return column12;
    }

    public void setOutputText15(CoreOutputText outputText15) {
        this.outputText15 = outputText15;
    }

    public CoreOutputText getOutputText15() {
        return outputText15;
    }


    public void setTableSelectOne1(CoreTableSelectOne tableSelectOne1) {
        this.tableSelectOne1 = tableSelectOne1;
    }

    public CoreTableSelectOne getTableSelectOne1() {
        return tableSelectOne1;
    }

    public void setCommandButton2(CoreCommandButton commandButton2) {
        this.commandButton2 = commandButton2;
    }

    public CoreCommandButton getCommandButton2() {
        return commandButton2;
    }


    public void setColumn13(CoreColumn column13) {
        this.column13 = column13;
    }

    public CoreColumn getColumn13() {
        return column13;
    }


    public void setOutputText16(CoreSelectBooleanCheckbox outputText16) {
        this.outputText16 = outputText16;
    }

    public CoreSelectBooleanCheckbox getOutputText16() {
        return outputText16;
    }

    public void setPanelGroup2(HtmlPanelGroup panelGroup2) {
        this.panelGroup2 = panelGroup2;
    }

    public HtmlPanelGroup getPanelGroup2() {
        return panelGroup2;
    }

    public void setBtnGenerarPrestaciones3(CoreCommandButton commandButton10) {
        this.btnGenerarPrestaciones3 = commandButton10;
    }

    public CoreCommandButton getBtnGenerarPrestaciones3() {
        return btnGenerarPrestaciones3;
    }


    public void setPanelForm4(CorePanelForm panelForm4) {
        this.panelForm4 = panelForm4;
    }

    public CorePanelForm getPanelForm4() {
        return panelForm4;
    }

    public void setInputText8(CoreInputText inputText8) {
        this.inputText8 = inputText8;
    }

    public CoreInputText getInputText8() {
        return inputText8;
    }

    public void setInputText9(CoreInputText inputText9) {
        this.inputText9 = inputText9;
    }

    public CoreInputText getInputText9() {
        return inputText9;
    }

    public void setBtnFiltarRegistro(CoreCommandButton commandButton1) {
        this.btnFiltarRegistro = commandButton1;
    }

    public CoreCommandButton getBtnFiltarRegistro() {
        return btnFiltarRegistro;
    }


    public void setPanelHeader7(CorePanelHeader panelHeader7) {
        this.panelHeader7 = panelHeader7;
    }

    public CorePanelHeader getPanelHeader7() {
        return panelHeader7;
    }

    public void setPanelGrid1(HtmlPanelGrid panelGrid1) {
        this.panelGrid1 = panelGrid1;
    }

    public HtmlPanelGrid getPanelGrid1() {
        return panelGrid1;
    }

    public void setInpRegPer(CoreInputText inpRegPer) {
        this.inpRegPer = inpRegPer;
    }

    public CoreInputText getInpRegPer() {
        return inpRegPer;
    }

    public void setInpPlaza(CoreInputText inpPlaza) {
        this.inpPlaza = inpPlaza;
    }

    public CoreInputText getInpPlaza() {
        return inpPlaza;
    }

    public void setBtnBuscarYSel(CoreCommandButton btnBuscarYSel) {
        this.btnBuscarYSel = btnBuscarYSel;
    }

    public CoreCommandButton getBtnBuscarYSel() {
        return btnBuscarYSel;
    }


    public void setShowConsultar(CoreShowDetailItem showDetailItem1) {
        this.showConsultar = showDetailItem1;
    }

    public CoreShowDetailItem getShowConsultar() {
        return showConsultar;
    }

    public void setPanelHeader8(CorePanelHeader panelHeader8) {
        this.panelHeader8 = panelHeader8;
    }

    public CorePanelHeader getPanelHeader8() {
        return panelHeader8;
    }

    public void setPanelHeader9(CorePanelHeader panelHeader9) {
        this.panelHeader9 = panelHeader9;
    }

    public CorePanelHeader getPanelHeader9() {
        return panelHeader9;
    }


    public void setPanelForm5(CorePanelForm panelForm5) {
        this.panelForm5 = panelForm5;
    }

    public CorePanelForm getPanelForm5() {
        return panelForm5;
    }

    public void setInputText1(CoreInputText inputText1) {
        this.inputText1 = inputText1;
    }

    public CoreInputText getInputText1() {
        return inputText1;
    }

    public void setInputText25(CoreInputText inputText25) {
        this.inputText25 = inputText25;
    }

    public CoreInputText getInputText25() {
        return inputText25;
    }

    public void setInputText28(CoreInputText inputText28) {
        this.inputText28 = inputText28;
    }

    public CoreInputText getInputText28() {
        return inputText28;
    }

    public void setInputText31(CoreInputText inputText31) {
        this.inputText31 = inputText31;
    }

    public CoreInputText getInputText31() {
        return inputText31;
    }

    public void setInputText40(CoreInputText inputText40) {
        this.inputText40 = inputText40;
    }

    public CoreInputText getInputText40() {
        return inputText40;
    }

    public void setInputText41(CoreInputText inputText41) {
        this.inputText41 = inputText41;
    }

    public CoreInputText getInputText41() {
        return inputText41;
    }

    public void setInputText42(CoreInputText inputText42) {
        this.inputText42 = inputText42;
    }

    public CoreInputText getInputText42() {
        return inputText42;
    }

    public void setInputText43(CoreInputText inputText43) {
        this.inputText43 = inputText43;
    }

    public CoreInputText getInputText43() {
        return inputText43;
    }

    public void setInputText44(CoreInputText inputText44) {
        this.inputText44 = inputText44;
    }

    public CoreInputText getInputText44() {
        return inputText44;
    }

    public void setInputText45(CoreInputText inputText45) {
        this.inputText45 = inputText45;
    }

    public CoreInputText getInputText45() {
        return inputText45;
    }

    public void setInputText46(CoreInputText inputText46) {
        this.inputText46 = inputText46;
    }

    public CoreInputText getInputText46() {
        return inputText46;
    }

    public void setInputText47(CoreInputText inputText47) {
        this.inputText47 = inputText47;
    }

    public CoreInputText getInputText47() {
        return inputText47;
    }

    public void setInputText48(CoreInputText inputText48) {
        this.inputText48 = inputText48;
    }

    public CoreInputText getInputText48() {
        return inputText48;
    }

    public void setInputText49(CoreInputText inputText49) {
        this.inputText49 = inputText49;
    }

    public CoreInputText getInputText49() {
        return inputText49;
    }

    public void setInputText50(CoreInputText inputText50) {
        this.inputText50 = inputText50;
    }

    public CoreInputText getInputText50() {
        return inputText50;
    }

    public void setInputText51(CoreInputText inputText51) {
        this.inputText51 = inputText51;
    }

    public CoreInputText getInputText51() {
        return inputText51;
    }

    public void setInputText52(CoreInputText inputText52) {
        this.inputText52 = inputText52;
    }

    public CoreInputText getInputText52() {
        return inputText52;
    }

    public void setInputText53(CoreInputText inputText53) {
        this.inputText53 = inputText53;
    }

    public CoreInputText getInputText53() {
        return inputText53;
    }

    public void setInputText54(CoreInputText inputText54) {
        this.inputText54 = inputText54;
    }

    public CoreInputText getInputText54() {
        return inputText54;
    }

    public void setInputText55(CoreInputText inputText55) {
        this.inputText55 = inputText55;
    }

    public CoreInputText getInputText55() {
        return inputText55;
    }

    public void setInputText56(CoreInputText inputText56) {
        this.inputText56 = inputText56;
    }

    public CoreInputText getInputText56() {
        return inputText56;
    }

    public void setSelectInputDate4(CoreSelectInputDate selectInputDate4) {
        this.selectInputDate4 = selectInputDate4;
    }

    public CoreSelectInputDate getSelectInputDate4() {
        return selectInputDate4;
    }

    public void setInputText57(CoreInputText inputText57) {
        this.inputText57 = inputText57;
    }

    public CoreInputText getInputText57() {
        return inputText57;
    }

    public void setSelectInputDate5(CoreSelectInputDate selectInputDate5) {
        this.selectInputDate5 = selectInputDate5;
    }

    public CoreSelectInputDate getSelectInputDate5() {
        return selectInputDate5;
    }

    public void setInputText58(CoreInputText inputText58) {
        this.inputText58 = inputText58;
    }

    public CoreInputText getInputText58() {
        return inputText58;
    }

    public void setInputText59(CoreInputText inputText59) {
        this.inputText59 = inputText59;
    }

    public CoreInputText getInputText59() {
        return inputText59;
    }

    public void setInputText60(CoreInputText inputText60) {
        this.inputText60 = inputText60;
    }

    public CoreInputText getInputText60() {
        return inputText60;
    }

    public void setInputText61(CoreInputText inputText61) {
        this.inputText61 = inputText61;
    }

    public CoreInputText getInputText61() {
        return inputText61;
    }

    public void setInputText62(CoreInputText inputText62) {
        this.inputText62 = inputText62;
    }

    public CoreInputText getInputText62() {
        return inputText62;
    }

    public void setInputText63(CoreInputText inputText63) {
        this.inputText63 = inputText63;
    }

    public CoreInputText getInputText63() {
        return inputText63;
    }

    public void setInputText64(CoreInputText inputText64) {
        this.inputText64 = inputText64;
    }

    public CoreInputText getInputText64() {
        return inputText64;
    }

    public void setInputText65(CoreInputText inputText65) {
        this.inputText65 = inputText65;
    }

    public CoreInputText getInputText65() {
        return inputText65;
    }

    public void setInputText66(CoreInputText inputText66) {
        this.inputText66 = inputText66;
    }

    public CoreInputText getInputText66() {
        return inputText66;
    }

    public void setInputText67(CoreInputText inputText67) {
        this.inputText67 = inputText67;
    }

    public CoreInputText getInputText67() {
        return inputText67;
    }

    public void setInputText68(CoreInputText inputText68) {
        this.inputText68 = inputText68;
    }

    public CoreInputText getInputText68() {
        return inputText68;
    }

    public void setInputText69(CoreInputText inputText69) {
        this.inputText69 = inputText69;
    }

    public CoreInputText getInputText69() {
        return inputText69;
    }

    public void setInputText70(CoreInputText inputText70) {
        this.inputText70 = inputText70;
    }

    public CoreInputText getInputText70() {
        return inputText70;
    }

    public void setInputText71(CoreInputText inputText71) {
        this.inputText71 = inputText71;
    }

    public CoreInputText getInputText71() {
        return inputText71;
    }

    public void setInputText72(CoreInputText inputText72) {
        this.inputText72 = inputText72;
    }

    public CoreInputText getInputText72() {
        return inputText72;
    }

    public void setPanelGroup3(CorePanelGroup panelGroup3) {
        this.panelGroup3 = panelGroup3;
    }

    public CorePanelGroup getPanelGroup3() {
        return panelGroup3;
    }

    public void setOutputText17(CoreOutputText outputText17) {
        this.outputText17 = outputText17;
    }

    public CoreOutputText getOutputText17() {
        return outputText17;
    }

    public void setPanelButtonBar3(CorePanelButtonBar panelButtonBar3) {
        this.panelButtonBar3 = panelButtonBar3;
    }

    public CorePanelButtonBar getPanelButtonBar3() {
        return panelButtonBar3;
    }

    public void setCommandButton1(CoreCommandButton commandButton1) {
        this.commandButton1 = commandButton1;
    }

    public CoreCommandButton getCommandButton1() {
        return commandButton1;
    }

    public void setCommandButton3(CoreCommandButton commandButton3) {
        this.commandButton3 = commandButton3;
    }

    public CoreCommandButton getCommandButton3() {
        return commandButton3;
    }

    public void setTable2(CoreTable table2) {
        this.table2 = table2;
    }

    public CoreTable getTable2() {
        return table2;
    }

    public void setColumn14(CoreColumn column14) {
        this.column14 = column14;
    }

    public CoreColumn getColumn14() {
        return column14;
    }

    public void setOutputText20(CoreOutputText outputText20) {
        this.outputText20 = outputText20;
    }

    public CoreOutputText getOutputText20() {
        return outputText20;
    }

    public void setColumn15(CoreColumn column15) {
        this.column15 = column15;
    }

    public CoreColumn getColumn15() {
        return column15;
    }

    public void setOutputText21(CoreOutputText outputText21) {
        this.outputText21 = outputText21;
    }

    public CoreOutputText getOutputText21() {
        return outputText21;
    }

    public void setColumn16(CoreColumn column16) {
        this.column16 = column16;
    }

    public CoreColumn getColumn16() {
        return column16;
    }

    public void setOutputText22(CoreOutputText outputText22) {
        this.outputText22 = outputText22;
    }

    public CoreOutputText getOutputText22() {
        return outputText22;
    }

    public void setColumn17(CoreColumn column17) {
        this.column17 = column17;
    }

    public CoreColumn getColumn17() {
        return column17;
    }

    public void setOutputText23(CoreOutputText outputText23) {
        this.outputText23 = outputText23;
    }

    public CoreOutputText getOutputText23() {
        return outputText23;
    }

    public void setColumn18(CoreColumn column18) {
        this.column18 = column18;
    }

    public CoreColumn getColumn18() {
        return column18;
    }

    public void setOutputText24(CoreOutputText outputText24) {
        this.outputText24 = outputText24;
    }

    public CoreOutputText getOutputText24() {
        return outputText24;
    }

    public void setColumn30(CoreColumn column30) {
        this.column30 = column30;
    }

    public CoreColumn getColumn30() {
        return column30;
    }

    public void setOutputText25(CoreOutputText outputText25) {
        this.outputText25 = outputText25;
    }

    public CoreOutputText getOutputText25() {
        return outputText25;
    }

    public void setColumn33(CoreColumn column33) {
        this.column33 = column33;
    }

    public CoreColumn getColumn33() {
        return column33;
    }

    public void setOutputText44(CoreOutputText outputText44) {
        this.outputText44 = outputText44;
    }

    public CoreOutputText getOutputText44() {
        return outputText44;
    }

    public void setColumn36(CoreColumn column36) {
        this.column36 = column36;
    }

    public CoreColumn getColumn36() {
        return column36;
    }

    public void setOutputText45(CoreOutputText outputText45) {
        this.outputText45 = outputText45;
    }

    public CoreOutputText getOutputText45() {
        return outputText45;
    }

    public void setColumn45(CoreColumn column45) {
        this.column45 = column45;
    }

    public CoreColumn getColumn45() {
        return column45;
    }

    public void setOutputText46(CoreOutputText outputText46) {
        this.outputText46 = outputText46;
    }

    public CoreOutputText getOutputText46() {
        return outputText46;
    }

    public void setColumn46(CoreColumn column46) {
        this.column46 = column46;
    }

    public CoreColumn getColumn46() {
        return column46;
    }

    public void setOutputText47(CoreOutputText outputText47) {
        this.outputText47 = outputText47;
    }

    public CoreOutputText getOutputText47() {
        return outputText47;
    }

    public void setColumn47(CoreColumn column47) {
        this.column47 = column47;
    }

    public CoreColumn getColumn47() {
        return column47;
    }

    public void setOutputText48(CoreOutputText outputText48) {
        this.outputText48 = outputText48;
    }

    public CoreOutputText getOutputText48() {
        return outputText48;
    }

    public void setColumn71(CoreColumn column71) {
        this.column71 = column71;
    }

    public CoreColumn getColumn71() {
        return column71;
    }

    public void setOutputText49(CoreOutputText outputText49) {
        this.outputText49 = outputText49;
    }

    public CoreOutputText getOutputText49() {
        return outputText49;
    }

    public void setColumn72(CoreColumn column72) {
        this.column72 = column72;
    }

    public CoreColumn getColumn72() {
        return column72;
    }

    public void setOutputText50(CoreOutputText outputText50) {
        this.outputText50 = outputText50;
    }

    public CoreOutputText getOutputText50() {
        return outputText50;
    }

    public void setColumn73(CoreColumn column73) {
        this.column73 = column73;
    }

    public CoreColumn getColumn73() {
        return column73;
    }

    public void setOutputText51(CoreOutputText outputText51) {
        this.outputText51 = outputText51;
    }

    public CoreOutputText getOutputText51() {
        return outputText51;
    }

    public void setColumn74(CoreColumn column74) {
        this.column74 = column74;
    }

    public CoreColumn getColumn74() {
        return column74;
    }

    public void setOutputText52(CoreOutputText outputText52) {
        this.outputText52 = outputText52;
    }

    public CoreOutputText getOutputText52() {
        return outputText52;
    }

    public void setColumn75(CoreColumn column75) {
        this.column75 = column75;
    }

    public CoreColumn getColumn75() {
        return column75;
    }

    public void setOutputText53(CoreOutputText outputText53) {
        this.outputText53 = outputText53;
    }

    public CoreOutputText getOutputText53() {
        return outputText53;
    }

    public void setColumn76(CoreColumn column76) {
        this.column76 = column76;
    }

    public CoreColumn getColumn76() {
        return column76;
    }

    public void setOutputText54(CoreOutputText outputText54) {
        this.outputText54 = outputText54;
    }

    public CoreOutputText getOutputText54() {
        return outputText54;
    }

    public void setColumn77(CoreColumn column77) {
        this.column77 = column77;
    }

    public CoreColumn getColumn77() {
        return column77;
    }

    public void setOutputText55(CoreOutputText outputText55) {
        this.outputText55 = outputText55;
    }

    public CoreOutputText getOutputText55() {
        return outputText55;
    }

    public void setColumn78(CoreColumn column78) {
        this.column78 = column78;
    }

    public CoreColumn getColumn78() {
        return column78;
    }

    public void setOutputText56(CoreOutputText outputText56) {
        this.outputText56 = outputText56;
    }

    public CoreOutputText getOutputText56() {
        return outputText56;
    }

    public void setColumn79(CoreColumn column79) {
        this.column79 = column79;
    }

    public CoreColumn getColumn79() {
        return column79;
    }

    public void setOutputText57(CoreOutputText outputText57) {
        this.outputText57 = outputText57;
    }

    public CoreOutputText getOutputText57() {
        return outputText57;
    }

    public void setColumn80(CoreColumn column80) {
        this.column80 = column80;
    }

    public CoreColumn getColumn80() {
        return column80;
    }

    public void setOutputText58(CoreOutputText outputText58) {
        this.outputText58 = outputText58;
    }

    public CoreOutputText getOutputText58() {
        return outputText58;
    }

    public void setColumn81(CoreColumn column81) {
        this.column81 = column81;
    }

    public CoreColumn getColumn81() {
        return column81;
    }

    public void setOutputText59(CoreOutputText outputText59) {
        this.outputText59 = outputText59;
    }

    public CoreOutputText getOutputText59() {
        return outputText59;
    }

    public void setColumn82(CoreColumn column82) {
        this.column82 = column82;
    }

    public CoreColumn getColumn82() {
        return column82;
    }

    public void setOutputText60(CoreOutputText outputText60) {
        this.outputText60 = outputText60;
    }

    public CoreOutputText getOutputText60() {
        return outputText60;
    }

    public void setColumn83(CoreColumn column83) {
        this.column83 = column83;
    }

    public CoreColumn getColumn83() {
        return column83;
    }

    public void setOutputText61(CoreOutputText outputText61) {
        this.outputText61 = outputText61;
    }

    public CoreOutputText getOutputText61() {
        return outputText61;
    }

    public void setColumn84(CoreColumn column84) {
        this.column84 = column84;
    }

    public CoreColumn getColumn84() {
        return column84;
    }

    public void setOutputText62(CoreOutputText outputText62) {
        this.outputText62 = outputText62;
    }

    public CoreOutputText getOutputText62() {
        return outputText62;
    }

    public void setColumn85(CoreColumn column85) {
        this.column85 = column85;
    }

    public CoreColumn getColumn85() {
        return column85;
    }

    public void setOutputText63(CoreOutputText outputText63) {
        this.outputText63 = outputText63;
    }

    public CoreOutputText getOutputText63() {
        return outputText63;
    }

    public void setColumn86(CoreColumn column86) {
        this.column86 = column86;
    }

    public CoreColumn getColumn86() {
        return column86;
    }

    public void setOutputText64(CoreOutputText outputText64) {
        this.outputText64 = outputText64;
    }

    public CoreOutputText getOutputText64() {
        return outputText64;
    }

    public void setColumn87(CoreColumn column87) {
        this.column87 = column87;
    }

    public CoreColumn getColumn87() {
        return column87;
    }

    public void setOutputText65(CoreOutputText outputText65) {
        this.outputText65 = outputText65;
    }

    public CoreOutputText getOutputText65() {
        return outputText65;
    }

    public void setColumn88(CoreColumn column88) {
        this.column88 = column88;
    }

    public CoreColumn getColumn88() {
        return column88;
    }

    public void setOutputText66(CoreOutputText outputText66) {
        this.outputText66 = outputText66;
    }

    public CoreOutputText getOutputText66() {
        return outputText66;
    }

    public void setColumn89(CoreColumn column89) {
        this.column89 = column89;
    }

    public CoreColumn getColumn89() {
        return column89;
    }

    public void setOutputText67(CoreOutputText outputText67) {
        this.outputText67 = outputText67;
    }

    public CoreOutputText getOutputText67() {
        return outputText67;
    }

    public void setColumn90(CoreColumn column90) {
        this.column90 = column90;
    }

    public CoreColumn getColumn90() {
        return column90;
    }

    public void setOutputText68(CoreOutputText outputText68) {
        this.outputText68 = outputText68;
    }

    public CoreOutputText getOutputText68() {
        return outputText68;
    }

    public void setColumn91(CoreColumn column91) {
        this.column91 = column91;
    }

    public CoreColumn getColumn91() {
        return column91;
    }

    public void setOutputText69(CoreOutputText outputText69) {
        this.outputText69 = outputText69;
    }

    public CoreOutputText getOutputText69() {
        return outputText69;
    }

    public void setColumn92(CoreColumn column92) {
        this.column92 = column92;
    }

    public CoreColumn getColumn92() {
        return column92;
    }

    public void setOutputText70(CoreOutputText outputText70) {
        this.outputText70 = outputText70;
    }

    public CoreOutputText getOutputText70() {
        return outputText70;
    }

    public void setColumn93(CoreColumn column93) {
        this.column93 = column93;
    }

    public CoreColumn getColumn93() {
        return column93;
    }

    public void setOutputText71(CoreOutputText outputText71) {
        this.outputText71 = outputText71;
    }

    public CoreOutputText getOutputText71() {
        return outputText71;
    }

    public void setColumn94(CoreColumn column94) {
        this.column94 = column94;
    }

    public CoreColumn getColumn94() {
        return column94;
    }

    public void setOutputText72(CoreOutputText outputText72) {
        this.outputText72 = outputText72;
    }

    public CoreOutputText getOutputText72() {
        return outputText72;
    }

    public void setColumn95(CoreColumn column95) {
        this.column95 = column95;
    }

    public CoreColumn getColumn95() {
        return column95;
    }

    public void setOutputText73(CoreOutputText outputText73) {
        this.outputText73 = outputText73;
    }

    public CoreOutputText getOutputText73() {
        return outputText73;
    }

    public void setColumn96(CoreColumn column96) {
        this.column96 = column96;
    }

    public CoreColumn getColumn96() {
        return column96;
    }

    public void setOutputText74(CoreOutputText outputText74) {
        this.outputText74 = outputText74;
    }

    public CoreOutputText getOutputText74() {
        return outputText74;
    }

    public void setColumn97(CoreColumn column97) {
        this.column97 = column97;
    }

    public CoreColumn getColumn97() {
        return column97;
    }

    public void setOutputText75(CoreOutputText outputText75) {
        this.outputText75 = outputText75;
    }

    public CoreOutputText getOutputText75() {
        return outputText75;
    }

    public void setColumn98(CoreColumn column98) {
        this.column98 = column98;
    }

    public CoreColumn getColumn98() {
        return column98;
    }

    public void setOutputText76(CoreOutputText outputText76) {
        this.outputText76 = outputText76;
    }

    public CoreOutputText getOutputText76() {
        return outputText76;
    }

    public void setTableSelectOne2(CoreTableSelectOne tableSelectOne2) {
        this.tableSelectOne2 = tableSelectOne2;
    }

    public CoreTableSelectOne getTableSelectOne2() {
        return tableSelectOne2;
    }

    public void setCommandButton10(CoreCommandButton commandButton10) {
        this.commandButton10 = commandButton10;
    }

    public CoreCommandButton getCommandButton10() {
        return commandButton10;
    }

    public void setTable5(CoreTable table5) {
        this.table5 = table5;
    }

    public CoreTable getTable5() {
        return table5;
    }

    public void setColumn99(CoreColumn column99) {
        this.column99 = column99;
    }

    public CoreColumn getColumn99() {
        return column99;
    }

    public void setOutputText77(CoreOutputText outputText77) {
        this.outputText77 = outputText77;
    }

    public CoreOutputText getOutputText77() {
        return outputText77;
    }

    public void setColumn100(CoreColumn column100) {
        this.column100 = column100;
    }

    public CoreColumn getColumn100() {
        return column100;
    }

    public void setOutputText78(CoreOutputText outputText78) {
        this.outputText78 = outputText78;
    }

    public CoreOutputText getOutputText78() {
        return outputText78;
    }

    public void setColumn101(CoreColumn column101) {
        this.column101 = column101;
    }

    public CoreColumn getColumn101() {
        return column101;
    }

    public void setOutputText79(CoreOutputText outputText79) {
        this.outputText79 = outputText79;
    }

    public CoreOutputText getOutputText79() {
        return outputText79;
    }

    public void setColumn102(CoreColumn column102) {
        this.column102 = column102;
    }

    public CoreColumn getColumn102() {
        return column102;
    }

    public void setOutputText80(CoreOutputText outputText80) {
        this.outputText80 = outputText80;
    }

    public CoreOutputText getOutputText80() {
        return outputText80;
    }

    public void setColumn103(CoreColumn column103) {
        this.column103 = column103;
    }

    public CoreColumn getColumn103() {
        return column103;
    }

    public void setOutputText81(CoreOutputText outputText81) {
        this.outputText81 = outputText81;
    }

    public CoreOutputText getOutputText81() {
        return outputText81;
    }

    public void setColumn104(CoreColumn column104) {
        this.column104 = column104;
    }

    public CoreColumn getColumn104() {
        return column104;
    }

    public void setOutputText82(CoreOutputText outputText82) {
        this.outputText82 = outputText82;
    }

    public CoreOutputText getOutputText82() {
        return outputText82;
    }

    public void setColumn105(CoreColumn column105) {
        this.column105 = column105;
    }

    public CoreColumn getColumn105() {
        return column105;
    }

    public void setOutputText83(CoreOutputText outputText83) {
        this.outputText83 = outputText83;
    }

    public CoreOutputText getOutputText83() {
        return outputText83;
    }

    public void setColumn106(CoreColumn column106) {
        this.column106 = column106;
    }

    public CoreColumn getColumn106() {
        return column106;
    }

    public void setOutputText84(CoreOutputText outputText84) {
        this.outputText84 = outputText84;
    }

    public CoreOutputText getOutputText84() {
        return outputText84;
    }

    public void setColumn107(CoreColumn column107) {
        this.column107 = column107;
    }

    public CoreColumn getColumn107() {
        return column107;
    }

    public void setOutputText85(CoreOutputText outputText85) {
        this.outputText85 = outputText85;
    }

    public CoreOutputText getOutputText85() {
        return outputText85;
    }

    public void setColumn108(CoreColumn column108) {
        this.column108 = column108;
    }

    public CoreColumn getColumn108() {
        return column108;
    }

    public void setOutputText86(CoreOutputText outputText86) {
        this.outputText86 = outputText86;
    }

    public CoreOutputText getOutputText86() {
        return outputText86;
    }

    public void setColumn109(CoreColumn column109) {
        this.column109 = column109;
    }

    public CoreColumn getColumn109() {
        return column109;
    }

    public void setOutputText87(CoreOutputText outputText87) {
        this.outputText87 = outputText87;
    }

    public CoreOutputText getOutputText87() {
        return outputText87;
    }

    public void setColumn110(CoreColumn column110) {
        this.column110 = column110;
    }

    public CoreColumn getColumn110() {
        return column110;
    }

    public void setOutputText88(CoreOutputText outputText88) {
        this.outputText88 = outputText88;
    }

    public CoreOutputText getOutputText88() {
        return outputText88;
    }

    public void setColumn111(CoreColumn column111) {
        this.column111 = column111;
    }

    public CoreColumn getColumn111() {
        return column111;
    }

    public void setOutputText89(CoreOutputText outputText89) {
        this.outputText89 = outputText89;
    }

    public CoreOutputText getOutputText89() {
        return outputText89;
    }

    public void setColumn112(CoreColumn column112) {
        this.column112 = column112;
    }

    public CoreColumn getColumn112() {
        return column112;
    }

    public void setOutputText90(CoreOutputText outputText90) {
        this.outputText90 = outputText90;
    }

    public CoreOutputText getOutputText90() {
        return outputText90;
    }

    public void setColumn113(CoreColumn column113) {
        this.column113 = column113;
    }

    public CoreColumn getColumn113() {
        return column113;
    }

    public void setOutputText91(CoreOutputText outputText91) {
        this.outputText91 = outputText91;
    }

    public CoreOutputText getOutputText91() {
        return outputText91;
    }

    public void setColumn114(CoreColumn column114) {
        this.column114 = column114;
    }

    public CoreColumn getColumn114() {
        return column114;
    }

    public void setOutputText92(CoreOutputText outputText92) {
        this.outputText92 = outputText92;
    }

    public CoreOutputText getOutputText92() {
        return outputText92;
    }


    public void setTableSelectOne5(CoreTableSelectOne tableSelectOne5) {
        this.tableSelectOne5 = tableSelectOne5;
    }

    public CoreTableSelectOne getTableSelectOne5() {
        return tableSelectOne5;
    }

    public void setCommandButton11(CoreCommandButton commandButton11) {
        this.commandButton11 = commandButton11;
    }

    public CoreCommandButton getCommandButton11() {
        return commandButton11;
    }

    public void setPanelForm6(CorePanelForm panelForm6) {
        this.panelForm6 = panelForm6;
    }

    public CorePanelForm getPanelForm6() {
        return panelForm6;
    }


    public void setCommandButton12(CoreCommandButton commandButton12) {
        this.commandButton12 = commandButton12;
    }

    public CoreCommandButton getCommandButton12() {
        return commandButton12;
    }


    public void setPanelForm1(CorePanelForm panelForm1) {
        this.panelForm1 = panelForm1;
    }

    public CorePanelForm getPanelForm1() {
        return panelForm1;
    }

    public void setInputText74(CoreInputText inputText74) {
        this.inputText74 = inputText74;
    }

    public CoreInputText getInputText74() {
        return inputText74;
    }

    public void setSelectInputDate6(CoreSelectInputDate selectInputDate6) {
        this.selectInputDate6 = selectInputDate6;
    }

    public CoreSelectInputDate getSelectInputDate6() {
        return selectInputDate6;
    }

    public void setSelectInputDate7(CoreSelectInputDate selectInputDate7) {
        this.selectInputDate7 = selectInputDate7;
    }

    public CoreSelectInputDate getSelectInputDate7() {
        return selectInputDate7;
    }


    public void setBtnBuscar(CoreCommandButton commandButton13) {
        this.btnBuscar = commandButton13;
    }

    public CoreCommandButton getBtnBuscar() {
        return btnBuscar;
    }


    public void setOutMensaje(CoreOutputFormatted outputFormatted11) {
        this.outMensaje = outputFormatted11;
    }

    public CoreOutputFormatted getOutMensaje() {
        return outMensaje;
    }

    public void setCmdEditar(CoreCommandLink cmdRefresh) {
        this.cmdEditar = cmdRefresh;
    }

    public CoreCommandLink getCmdEditar() {
        return cmdEditar;
    }

    public void setColumn43(CoreColumn column43) {
        this.column43 = column43;
    }

    public CoreColumn getColumn43() {
        return column43;
    }


    public void setOutputText93(CoreOutputText outputText93) {
        this.outputText93 = outputText93;
    }

    public CoreOutputText getOutputText93() {
        return outputText93;
    }

    public void setOutputText931(CoreOutputText outputText931) {
        this.outputText931 = outputText931;
    }

    public CoreOutputText getOutputText931() {
        return outputText931;
    }

    public void setOutputText932(CoreOutputText outputText932) {
        this.outputText932 = outputText932;
    }

    public CoreOutputText getOutputText932() {
        return outputText932;
    }

    public void setOutputText94(CoreOutputText outputText94) {
        this.outputText94 = outputText94;
    }

    public CoreOutputText getOutputText94() {
        return outputText94;
    }


    public void setSelectPartidaEgreso(CoreSelectOneChoice selectOneChoice1) {
        this.selectPartidaEgreso = selectOneChoice1;
    }

    public CoreSelectOneChoice getSelectPartidaEgreso() {
        return selectPartidaEgreso;
    }

    public void setSelectItems1(UISelectItems selectItems1) {
        this.selectItems1 = selectItems1;
    }

    public UISelectItems getSelectItems1() {
        return selectItems1;
    }

    public void setColumn115(CoreColumn column115) {
        this.column115 = column115;
    }

    public CoreColumn getColumn115() {
        return column115;
    }

    public void setOutputText95(CoreOutputText outputText95) {
        this.outputText95 = outputText95;
    }

    public CoreOutputText getOutputText95() {
        return outputText95;
    }

    public void setColumn116(CoreColumn column116) {
        this.column116 = column116;
    }

    public CoreColumn getColumn116() {
        return column116;
    }

    public void setOutputText96(CoreOutputText outputText96) {
        this.outputText96 = outputText96;
    }

    public CoreOutputText getOutputText96() {
        return outputText96;
    }


    public void setPanelHorizontal2(CorePanelHorizontal panelHorizontal2) {
        this.panelHorizontal2 = panelHorizontal2;
    }

    public CorePanelHorizontal getPanelHorizontal2() {
        return panelHorizontal2;
    }

    public void setInputText73(CoreInputText inputText73) {
        this.inputText73 = inputText73;
    }

    public CoreInputText getInputText73() {
        return inputText73;
    }

    public void setInputText32(CoreInputText inputText32) {
        this.inputText32 = inputText32;
    }

    public CoreInputText getInputText32() {
        return inputText32;
    }

    public void setColumn117(CoreColumn column117) {
        this.column117 = column117;
    }

    public CoreColumn getColumn117() {
        return column117;
    }

    public void setOutputText97(CoreOutputText outputText97) {
        this.outputText97 = outputText97;
    }

    public CoreOutputText getOutputText97() {
        return outputText97;
    }


    public void setCommandLink4(CoreCommandLink commandLink4) {
        this.commandLink4 = commandLink4;
    }

    public CoreCommandLink getCommandLink4() {
        return commandLink4;
    }

    public void setObjectImage5(CoreObjectImage objectImage5) {
        this.objectImage5 = objectImage5;
    }

    public CoreObjectImage getObjectImage5() {
        return objectImage5;
    }


    public void setObjectSpacer1(CoreObjectSpacer objectSpacer1) {
        this.objectSpacer1 = objectSpacer1;
    }

    public CoreObjectSpacer getObjectSpacer1() {
        return objectSpacer1;
    }


    public void setSelAutofinanciable(CoreSelectBooleanCheckbox selectBooleanCheckbox1) {
        this.selAutofinanciable = selectBooleanCheckbox1;
    }

    public CoreSelectBooleanCheckbox getSelAutofinanciable() {
        return selAutofinanciable;
    }

    public BindingContainer getBindings() {
        return this.bindings;
    }

    public void setBindings(BindingContainer bindings) {
        this.bindings = bindings;
    }

    public void setTxtAutofinanciables(CoreOutputFormatted outputFormatted11) {
        this.txtAutofinanciables = outputFormatted11;
    }

    public CoreOutputFormatted getTxtAutofinanciables() {
        return txtAutofinanciables;
    }

    public void setCommandButton13(CoreCommandButton commandButton13) {
        this.commandButton13 = commandButton13;
    }

    public CoreCommandButton getCommandButton13() {
        return commandButton13;
    }
}
