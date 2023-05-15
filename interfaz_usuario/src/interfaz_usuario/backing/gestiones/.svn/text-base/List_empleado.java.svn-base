package interfaz_usuario.backing.gestiones;

import enlace_datos.util.resulOp;

import interfaz_usuario.usuario;

import interfaz_usuario.util.JSFUtils;

import interfaz_usuario.util.utils;

import java.math.BigDecimal;

import java.sql.ResultSet;

import java.util.ArrayList;

import java.util.List;

import javax.faces.component.UISelectItems;
import javax.faces.component.html.HtmlForm;

import javax.faces.component.html.HtmlPanelGroup;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import oracle.adf.view.faces.component.core.data.CoreColumn;
import oracle.adf.view.faces.component.core.data.CoreTable;
import oracle.adf.view.faces.component.core.data.CoreTableSelectOne;
import oracle.adf.view.faces.component.core.input.CoreInputHidden;
import oracle.adf.view.faces.component.core.input.CoreInputText;
import oracle.adf.view.faces.component.core.input.CoreSelectOneChoice;
import oracle.adf.view.faces.component.core.layout.CorePanelBox;
import oracle.adf.view.faces.component.core.layout.CorePanelGroup;
import oracle.adf.view.faces.component.core.layout.CorePanelHeader;
import oracle.adf.view.faces.component.core.layout.CorePanelHorizontal;
import oracle.adf.view.faces.component.core.layout.CoreShowDetailItem;
import oracle.adf.view.faces.component.core.layout.CoreShowOneRadio;
import oracle.adf.view.faces.component.core.layout.CoreShowOneTab;
import oracle.adf.view.faces.component.core.nav.CoreCommandButton;
import oracle.adf.view.faces.component.core.nav.CoreCommandLink;
import oracle.adf.view.faces.component.core.output.CoreMessages;
import oracle.adf.view.faces.component.core.output.CoreObjectSeparator;
import oracle.adf.view.faces.component.core.output.CoreObjectSpacer;
import oracle.adf.view.faces.component.core.output.CoreOutputFormatted;
import oracle.adf.view.faces.component.core.output.CoreOutputText;
import oracle.adf.view.faces.component.html.HtmlBody;
import oracle.adf.view.faces.component.html.HtmlHead;
import oracle.adf.view.faces.component.html.HtmlHtml;
import oracle.adf.view.faces.event.AttributeChangeEvent;

import oracle.adf.view.faces.event.SelectionEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import pkg_autenticacion.menu.MenuItem;
import pkg_autenticacion.menu.MenuModelAdapter;

import pkg_util_base_datos.interfaz_DB;


public class List_empleado {


    private HtmlHtml html1;
    private HtmlHead head1;
    private HtmlBody body1;
    private HtmlForm form1;
    private CorePanelBox panelBox1;
    private CoreMessages messages1;
    private CoreOutputFormatted optInfoUser;
    private HtmlPanelGroup panelGroup2;
    private HtmlPanelGroup panelGroup3;
    private CoreShowOneTab showOneTab1;
    private CoreShowDetailItem showDetailItem4;
    private CoreTable table1;
    private CoreColumn column10;
    private CoreOutputText outputText3;
    private CoreColumn column11;
    private CoreColumn column12;
    private CoreOutputText outputText5;
    private CoreColumn column15;
    private CoreOutputText outputText8;
    private CoreOutputText outputText18;
    private CoreObjectSeparator objectSeparator1;
    private CoreTable table2;
    private CoreColumn column18;
    private CoreOutputText outputText11;
    private CoreColumn column20;
    private CoreOutputText outputText13;
    private CoreColumn column23;
    private CoreOutputText outputText16;
    private CoreOutputText outputText19;
    private CoreColumn column9;
    private CoreOutputText outputText2;
    private CoreCommandLink cmdRegAsig;
    private CoreCommandLink cmdNuevo;
    private CoreShowDetailItem showDetailItem5;
    private CoreShowDetailItem showDetailItem1;
    private CorePanelHorizontal panelHorizontal3;
    private CoreInputText inptt_reg_empleado;
    private CoreCommandButton cmbtn_buscar;
    private CoreCommandButton btnNuevoReg;
    private HtmlPanelGroup panelGroup1;
    private CoreObjectSpacer objectSpacer5;
    private CoreCommandButton commandButton3;
    private CoreCommandButton commandButton2;
    private CoreShowOneRadio swrdio_tipoBusqueda;
    private CoreShowDetailItem showDetailItem2;
    private CoreShowDetailItem showDetailItem3;
    private CorePanelHeader panelHeader3;
    private CoreInputText inptt_cedula;
    private CorePanelHeader panelHeader1;
    private CorePanelHorizontal panelHorizontal1;
    private CoreInputText inptt_nombre1;
    private CoreInputText inptt_nombre2;
    private CoreObjectSpacer objectSpacer1;
    private CorePanelHeader panelHeader2;
    private CorePanelHorizontal panelHorizontal2;
    private CoreInputText inptt_apellido1;
    private CoreInputText inptt_apellido2;
    private CoreObjectSpacer objectSpacer2;
    private CoreObjectSpacer objectSpacer3;
    private CoreTable tbl_empleados;
    private CoreTableSelectOne tableSelectOne1;
    private CoreCommandButton btn_selEmpleado;
    private CoreColumn column1;
    private CoreCommandLink cmlnk_reg_empleado;
    private CoreColumn column8;
    private CoreOutputText outputText1;
    private CoreColumn column2;
    private CoreOutputText ouptxt_cedula;
    private CoreOutputText outputText4;
    private CoreColumn column3;
    private CoreOutputText ouptxt_estEmpl;
    private CoreColumn column4;
    private CoreOutputText ouptxt_nombre1;
    private CoreColumn column5;
    private CoreOutputText ouptxt_nombre2;
    private CoreColumn column6;
    private CoreOutputText ouptxt_ape1;
    private CoreColumn column7;
    private CoreOutputText ouptxt_ape2;
    private CoreObjectSpacer objectSpacer4;
    private CoreColumn column13;
    private CoreCommandButton commandButton1;
    private CoreObjectSpacer objectSpacer6;
    private CoreCommandButton btn_resete_password;
    private CoreInputHidden inpt_info1;
    private CoreOutputText outCLV;
    private CoreColumn column14;
    private CoreOutputText outputText6;
    private CoreColumn column16;
    private CoreOutputText outputText7;
    private CorePanelGroup panelHorarios;
    private CoreTableSelectOne tblSelContIndef;
    private CoreCommandButton buscaContIndef;
    private CorePanelGroup panelFechas;
    private CorePanelHorizontal panelBtnContIndf;
    private CoreSelectOneChoice cb_tipo_actualizacion;
    private CorePanelHorizontal panelObserCamHoraIndf;
    private CoreInputText inputText1;
    private CoreColumn column17;
    private CoreOutputText outputText9;
    private CoreColumn column19;
    private CoreOutputText outputText10;
    private CoreCommandButton commandButton4;

    public List_empleado(){
        Object vValor;
        vValor=JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.showMensajeCuenta");
    
        if (vValor.toString().equals("true"))
          utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"El trabajador no ha validado su cuenta monetaria para acreditamiento de su salario.\n El trabajador debe realizar la gestion en la Actualización de datos."));              
        
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

    public void setForm1(HtmlForm form1) {
        this.form1 = form1;
    }

    public HtmlForm getForm1() {
        return form1;
    }


    public void setPanelBox1(CorePanelBox panelBox1) {
        this.panelBox1 = panelBox1;
    }

    public CorePanelBox getPanelBox1() {
        return panelBox1;
    }


    public void setMessages1(CoreMessages messages1) {
        this.messages1 = messages1;
    }

    public CoreMessages getMessages1() {
        return messages1;
    }


    public String set_registro() {
       Object vValor,vEstadoRegistro;
       Object varOperacion = "",vRegistroSel;
       varOperacion = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{flujo_usuario.operacion}");
       oracle.jbo.domain.Number vRegActual;  
        
       JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"posListaEmpl");
       vRegistroSel = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.RegistroEmpleado.inputValue}");
        
        
       if (varOperacion.equals(1)){
           //btn_selEmpleado_action();
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.RegEmpleado1.inputValue}",utils.getNumberOracle(vRegistroSel));
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjeBusquedaEmpleado");
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"cambiarValidacion");
            return "analisis_empleado";
       
       } else{
        
       usuario.set_opciones(usuario.SEL_REGEMPLEADO,utils.getNumber(vRegistroSel)); 
       
       usuario.set_opciones(usuario.VISTA_EMPLEADO,1); 
       usuario.set_opciones(usuario.EMPLSEL,1);
       JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.RegEmpleado1.inputValue}",utils.getNumberOracle(vRegistroSel));
      // JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.RegEmpleado.inputValue}",utils.getNumberOracle(this.cmlnk_reg_empleado.getText()));
       JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjeBusquedaEmpleado");     
       vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.NombreCompleto.inputValue}");
       JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"cambiarValidacion");
       usuario.set_opciones(usuario.NOMBREEMPLEADOSEL,vValor); 
       usuario.set_opciones(usuario.VISTA_CONTRATO,3); 
       
       vRegActual=utils.getNumberOracle(vRegistroSel);
       vEstadoRegistro=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.Nomestado.inputValue}");
      
       usuario.set_opciones(usuario.ESTADO_EMPLEADO ,vEstadoRegistro); 
       if (vEstadoRegistro!=null && vEstadoRegistro.toString().equals("DESHABILITADO")){
             
            actualizarMenuDesabilita();
               
       }else {
       
          if (vRegActual.compareTo(90000000)>=0){
                   actualizarMenuDesabilita();
           }else{
                   actualizarMenu();    
           }
                
           
      }
    
    
       
      return "ver_empleado";
       }
    
    
    
    }


    public String btn_nuevo_action() {
        // Add event code here...
         //usuario.setSelRegEmpleado_bean(Long.parseLong(this.cmlnk_reg_empleado.getText()) ); 
         usuario.set_opciones(usuario.SEL_REGEMPLEADO,0 ); 
         usuario.set_opciones(usuario.VISTA_EMPLEADO,0); 
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Rollback");
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Resetear");
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"CrearEmpl");
         return "ver_empleado";
    }


    public String btn_selEmpleado_action() {
        // Add event code here...
        Object vValor,vRegTempo,vEstadoRegistro, vIs029, vCui;
        oracle.jbo.domain.Number vRegActual;
        
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjeBusquedaEmpleado");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"cambiarValidacion");
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.RegistroEmpleado.inputValue}");        
        usuario.set_opciones(usuario.SEL_REGEMPLEADO,utils.getNumber(vValor)); 
        this.inptt_reg_empleado.setValue(vValor);
        vRegTempo=vValor;
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.NombreCompleto.inputValue}");
        usuario.set_opciones(usuario.NOMBREEMPLEADOSEL,vValor); 
        usuario.set_opciones(usuario.EMPLSEL,1);
        usuario.set_opciones(usuario.SEL_CONTRATO,new Long(0) ); 
        usuario.set_opciones(usuario.VISTA_EMPLEADO,1); 
        usuario.set_opciones(usuario.VISTA_CONTRATO,3); 
        vCui=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.CuiList.inputValue}");
        if (vCui != null )
            usuario.set_opciones(usuario.SEL_CUI,utils.getNumber(vCui)); 
        
        vEstadoRegistro=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.Nomestado.inputValue}");
        vIs029=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.TipoOrigen.inputValue}");
        vRegActual=utils.getNumberOracle(vRegTempo);
        
        usuario.set_opciones(usuario.ESTADO_EMPLEADO ,vEstadoRegistro); 
        if (vEstadoRegistro!=null && vEstadoRegistro.toString().equals("DESHABILITADO")){
            
            actualizarMenuDesabilita();
            
        }else {
            
            if (vRegActual.compareTo(90000000)>=0 ){
                if (!vIs029.equals("029"))
                    actualizarMenuDesabilita();
                else 
                    if (vCui != null)
                        actualizarMenu029();   
            }else{
                actualizarMenu();    
            }
                
            
        }
        
      
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.RegistroEmpleado.inputValue}");
        
      //  System.out.println("reg actual:" + vValor);        
        
        return "refresh_lstEmpl";
    }

    public void setOptInfoUser(CoreOutputFormatted outputFormatted1) {
        this.optInfoUser = outputFormatted1;
    }

    public CoreOutputFormatted getOptInfoUser() {
        return optInfoUser;
    }

    public String cmbtn_buscar_action() {
        Object vValor;
        
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Rollback");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ConsultaEmpleado");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjeBusquedaEmpleado");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"cambiarValidacion");
                
        actualizarMenuDesabilita();
                
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.RegistroEmpleado.inputValue}");     
                
        if (vValor == null) {
            vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vCui1.inputValue}");
            usuario.set_opciones(usuario.SEL_CUI,utils.getNumber(vValor)); 
            usuario.set_opciones(usuario.NOMBREEMPLEADOSEL,""); 
            vValor = 0;
            usuario.set_opciones(usuario.SEL_REGEMPLEADO,utils.getNumber(vValor)); 
            usuario.set_opciones(usuario.EMPLSEL,1);
            usuario.set_opciones(usuario.SEL_CONTRATO,new Long(0) ); 
            usuario.set_opciones(usuario.VISTA_EMPLEADO,1); 
            usuario.set_opciones(usuario.VISTA_CONTRATO,3); 
                   
            actualizarMenu029();   
                    
            return "refresh_lstEmpl";
        }else {
            return null;
        }
    }


    public void setPanelGroup2(HtmlPanelGroup panelGroup2) {
        this.panelGroup2 = panelGroup2;
    }

    public HtmlPanelGroup getPanelGroup2() {
        return panelGroup2;
    }


    public void setPanelGroup3(HtmlPanelGroup panelGroup3) {
        this.panelGroup3 = panelGroup3;
    }

    public HtmlPanelGroup getPanelGroup3() {
        return panelGroup3;
    }

    private void actualizarMenu(){
        Object vValor;
        MenuModelAdapter vMenu;
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{modeloMenu}");
        vMenu=(MenuModelAdapter)vValor;
        vMenu.cambiarEstadoItem("Empleado",false);
        
    }
    
    private void actualizarMenu029(){
        Object vValor;
        MenuModelAdapter vMenu;
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{modeloMenu}");
        vMenu=(MenuModelAdapter)vValor;
        vMenu.cambiarEstadoItem("029",false);
        
    }


    private void actualizarMenuDesabilita(){
        Object vValor;
        MenuModelAdapter vMenu;
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{modeloMenu}");
        vMenu=(MenuModelAdapter)vValor;
        vMenu.cambiarEstadoItem("Empleado",true);
        
    }


    public String getValor(String pValor,int numCaracteres){
        String pResultado="";
        
      if (pValor==null || (pValor!=null && pValor.equals("null"))){
                pResultado="";
     
      }else{        
      
        if (numCaracteres>0){
            pResultado=pValor.length()>numCaracteres?pValor.substring(0,numCaracteres):pValor;   
        }
            pResultado=pValor; 
        }
        
      return pResultado.trim();  
    }
    
    
    public String getInicial(String pValor){
        String pIni;
        if (pValor!=null && pValor.length()>1)        
          pIni=pValor.substring(0,1);
        else
        pIni="";
        
        return pIni;
    }
    
    public String getNombreCasada(String pValor){
        String pIni;
        if (pValor!=null && pValor.length()>1)        
          pIni="DE " + pValor;
        else
        pIni="";
        
        return pIni;
    }    
    
    
    public String QuitarAcentos(String pCadena){
        String vModificado="";
        
        if (pCadena!=null){
        vModificado=pCadena.replace("Á","A");
        vModificado=vModificado.replace("É","E");
        vModificado=vModificado.replace("Í","I");
        vModificado=vModificado.replace("Ó","O");
        vModificado=vModificado.replace("Ú","U");
        }
       return vModificado;
       
    }
    
    
    public String getNombreCompleto(String pNombreCompleto,String pNom1,String pNom2,String pNom3,String pApe1, String pApe2,String pApe3){
      String pNombreCompleto2;    
      
      pNombreCompleto2=pNombreCompleto;
      
      if (pNombreCompleto.length()>=32){          
         pNombreCompleto2=pApe1+" "+getInicial(pApe2)+" "+getNombreCasada(pApe3)+" "+pNom1+" "+pNom2+ " "+pNom3; 
      }
        
        if (pNombreCompleto2.length()>=32){            
         pNombreCompleto2=pApe1+" "+getInicial(pApe2)+" "+getNombreCasada(pApe3)+" "+pNom1+" "+getInicial(pNom2)+ " "+pNom3; 
        }
     
     
     return pNombreCompleto2;   
    }

    public String GenerarArchivo() {
        HttpServletResponse vRespuesta;
        ServletOutputStream outstream=null;
        String vNombreArchivo="nuregper.txt";
        String vQuery;
        String vLinea;
        ResultSet vFilas;
        String vUsuarioLogueado;
        
        vUsuarioLogueado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{flujo_usuario.selRegEmpleado_login}").toString();
        
        vQuery="select distinct\n" + 
        "        registro_empleado,\n" + 
        "        nomcompletocheq as nombrecompleto,\n" + 
        "        nombre1,\n" + 
        "        nombre2,\n" + 
        "        nombre3,\n" + 
        "        apellido1,\n" + 
        "        apellido2,\n" + 
        "        apellidocasada,\n" + 
        "        decode(estadocivil,'S','SOLTERO','C','CASADO') as estadoCivil,\n" + 
        "        orden_cedula,\n" + 
        "        registro_cedula,\n" + 
        "        muni.nombre,\n" + 
        "        nit,\n" + 
        "        igss,\n" + 
        "        no_probidad,\n" + 
        "        genero,\n" + 
        "        to_char(fecha_ingreso,'dd/mm/yyyy') as fechaIngreso,\n" + 
        "        to_char(fecha_nacimiento,'dd/mm/yyyy') as fechaNacimiento,\n" + 
        "        CLV as CLV,\n" + 
        "        to_char(empl.fecha_creacion,'dd/mm/yyyy') as fecha_creacion,\n" + 
        "        to_char(empl.fecha_modificacion,'dd/mm/yyyy') as fecha_modif, \n" +
        "        (select count(0) from sis_ajuste_exclud_empleado\n" + 
        "        where registro_empleado=empl.registro_empleado\n" + 
        "        and fecha_baja is null \n" + 
        "        and id_ajuste=24 \n" + 
        "        and rownum<=1) as aplicaPlan \n" + 
        "        from sis_empleado empl left outer join sis_municipio muni\n" + 
        "        on empl.municipio_cedula=muni.id_municipio\n" + 
        "        where \n" + 
        "        (\n" + 
        "        empl.fecha_creacion>=trunc(sysdate)\n" + 
        "        or (fecha_modificacion>=trunc(sysdate) and empl.mod_por in (\n" + 
        "        select usuario from usuario_perfil\n" + 
        "         where tipo_usuario='TRABAJADOR'\n" + 
        "         and perfil='asist_recursos_hum_regper'\n" + 
        "         and activo=1))\n" + 
        "        ) \n" + 
        "         and empl.registro_empleado<90000000\n";
        interfaz_DB conexion = new interfaz_DB();
        
        try{
            vRespuesta=(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
            
           //  response.setContentType("text/html; charset=UTF-8");
           //  response.setCharacterEncoding("UTF-8");

            
            vRespuesta.setContentType("text/html; charset=windows-1252");
          //  vRespuesta.setContentType("text/html; charset=UTF-8");
          //  vRespuesta.setCharacterEncoding("UTF-8");
            vRespuesta.setHeader ("Content-Disposition", "attachment;filename=\"" + vNombreArchivo + "\""); 
            
            outstream=vRespuesta.getOutputStream();
            
            vFilas=conexion.Bol_ejecutar_sentencia(vQuery);
            
            while (vFilas.next()){
                vLinea="";
                vLinea="|"+vFilas.getString("registro_empleado")+"|";
                //vLinea=vLinea+","+"|"+getValor(vFilas.getString("nombrecompleto"),-1)+"|"; 
                vLinea=vLinea+","+"|"+QuitarAcentos(getNombreCompleto(getValor(vFilas.getString("nombrecompleto"),-1),getValor(vFilas.getString("nombre1"),-1),getValor(vFilas.getString("nombre2"),-1),getValor(vFilas.getString("nombre3"),-1),getValor(vFilas.getString("apellido1"),-1),getValor(vFilas.getString("apellido2"),-1),getValor(vFilas.getString("apellidocasada"),-1)))+"|"; 
                vLinea=vLinea+","+"|"+QuitarAcentos(getValor(vFilas.getString("nombre1"),-1))+"|";
                vLinea=vLinea+","+"|"+QuitarAcentos(getValor(vFilas.getString("nombre2"),-1))+"|";
                vLinea=vLinea+","+"|"+QuitarAcentos(getValor(vFilas.getString("nombre3"),-1))+"|";
                vLinea=vLinea+","+"|"+QuitarAcentos(getValor(vFilas.getString("apellido1"),-1))+"|";
                vLinea=vLinea+","+"|"+QuitarAcentos(getValor(vFilas.getString("apellido2"),-1))+"|";
                vLinea=vLinea+","+"|"+QuitarAcentos(getNombreCasada(getValor(vFilas.getString("apellidocasada"),-1)))+"|";
                vLinea=vLinea+","+"|"+getValor(vFilas.getString("estadocivil"),-1)+"|";
                vLinea=vLinea+","+"|"+getValor(vFilas.getString("orden_cedula"),-1)+"|";
                vLinea=vLinea+","+"|"+getValor(vFilas.getString("registro_cedula"),-1)+"|";
                vLinea=vLinea+","+"|"+getValor(vFilas.getString("nombre"),20)+"|";
                vLinea=vLinea+","+"|"+getValor(vFilas.getString("nit"),-1)+"|";
                vLinea=vLinea+","+"|"+getValor(vFilas.getString("igss"),-1)+"|";
                vLinea=vLinea+","+"|"+getValor(vFilas.getString("no_probidad"),-1)+"|";
                vLinea=vLinea+","+"|"+getValor(vFilas.getString("genero"),-1)+"|";
                vLinea=vLinea+","+"|"+getValor(vFilas.getString("fechaIngreso"),-1)+"|";
                vLinea=vLinea+","+"|"+getValor(vFilas.getString("fechanacimiento"),-1)+"|";
                vLinea=vLinea+","+"|"+getValor(vFilas.getString("clv"),-1)+"|";
                vLinea=vLinea+","+"|"+vUsuarioLogueado+"|";
                vLinea=vLinea+","+"|"+getValor(vFilas.getString("fecha_creacion"),-1)+"|";
                vLinea=vLinea+","+"|"+vUsuarioLogueado+"|";
                vLinea=vLinea+","+"|"+getValor(vFilas.getString("fecha_modif"),-1)+"|";
                vLinea=vLinea+","+"|"+getValor(vFilas.getString("aplicaPlan"),-1)+"|";
                vLinea=vLinea+"\n";
                outstream.write(vLinea.getBytes());
            }

        outstream.flush();
        outstream.close();    
        conexion.cn_Cerrar_coneccion();
        }catch(Exception exep){
             try{
               conexion.cn_Cerrar_coneccion();
               outstream.close();            
             }catch(Exception exep2) {
                 
             }
        }
        return null;
    }


    public String btn_nuevo029() {
        
        usuario.set_opciones(usuario.SEL_REGEMPLEADO,0 ); 
        usuario.set_opciones(usuario.VISTA_EMPLEADO,0); 
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Rollback");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Resetear");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"crearEmpleado");
        return "ver_empleado";
        
    }


    public void setShowOneTab1(CoreShowOneTab showOneTab1) {
        this.showOneTab1 = showOneTab1;
    }

    public CoreShowOneTab getShowOneTab1() {
        return showOneTab1;
    }


    public void setShowDetailItem4(CoreShowDetailItem showDetailItem4) {
        this.showDetailItem4 = showDetailItem4;
    }

    public CoreShowDetailItem getShowDetailItem4() {
        return showDetailItem4;
    }

    public void setTable1(CoreTable table1) {
        this.table1 = table1;
    }

    public CoreTable getTable1() {
        return table1;
    }


    public void setColumn10(CoreColumn column10) {
        this.column10 = column10;
    }

    public CoreColumn getColumn10() {
        return column10;
    }

    public void setOutputText3(CoreOutputText outputText3) {
        this.outputText3 = outputText3;
    }

    public CoreOutputText getOutputText3() {
        return outputText3;
    }

    public void setColumn11(CoreColumn column11) {
        this.column11 = column11;
    }

    public CoreColumn getColumn11() {
        return column11;
    }


    public void setColumn12(CoreColumn column12) {
        this.column12 = column12;
    }

    public CoreColumn getColumn12() {
        return column12;
    }

    public void setOutputText5(CoreOutputText outputText5) {
        this.outputText5 = outputText5;
    }

    public CoreOutputText getOutputText5() {
        return outputText5;
    }


    public void setColumn15(CoreColumn column15) {
        this.column15 = column15;
    }

    public CoreColumn getColumn15() {
        return column15;
    }

    public void setOutputText8(CoreOutputText outputText8) {
        this.outputText8 = outputText8;
    }

    public CoreOutputText getOutputText8() {
        return outputText8;
    }


    public void setOutputText18(CoreOutputText outputText18) {
        this.outputText18 = outputText18;
    }

    public CoreOutputText getOutputText18() {
        return outputText18;
    }

    public void setObjectSeparator1(CoreObjectSeparator objectSeparator1) {
        this.objectSeparator1 = objectSeparator1;
    }

    public CoreObjectSeparator getObjectSeparator1() {
        return objectSeparator1;
    }

    public void setTable2(CoreTable table2) {
        this.table2 = table2;
    }

    public CoreTable getTable2() {
        return table2;
    }


    public void setColumn18(CoreColumn column18) {
        this.column18 = column18;
    }

    public CoreColumn getColumn18() {
        return column18;
    }

    public void setOutputText11(CoreOutputText outputText11) {
        this.outputText11 = outputText11;
    }

    public CoreOutputText getOutputText11() {
        return outputText11;
    }


    public void setColumn20(CoreColumn column20) {
        this.column20 = column20;
    }

    public CoreColumn getColumn20() {
        return column20;
    }

    public void setOutputText13(CoreOutputText outputText13) {
        this.outputText13 = outputText13;
    }

    public CoreOutputText getOutputText13() {
        return outputText13;
    }


    public void setColumn23(CoreColumn column23) {
        this.column23 = column23;
    }

    public CoreColumn getColumn23() {
        return column23;
    }

    public void setOutputText16(CoreOutputText outputText16) {
        this.outputText16 = outputText16;
    }

    public CoreOutputText getOutputText16() {
        return outputText16;
    }


    public void setOutputText19(CoreOutputText outputText19) {
        this.outputText19 = outputText19;
    }

    public CoreOutputText getOutputText19() {
        return outputText19;
    }

    public void setColumn9(CoreColumn column9) {
        this.column9 = column9;
    }

    public CoreColumn getColumn9() {
        return column9;
    }

    public void setOutputText2(CoreOutputText outputText2) {
        this.outputText2 = outputText2;
    }

    public CoreOutputText getOutputText2() {
        return outputText2;
    }


    public void setCmdRegAsig(CoreCommandLink commandLink1) {
        this.cmdRegAsig = commandLink1;
    }

    public CoreCommandLink getCmdRegAsig() {
        return cmdRegAsig;
    }

    public String cmd_asignados_link() {
                
        String vRegistroSel;
        Object vValor;
        vRegistroSel=cmdRegAsig.getText();        
        usuario.set_opciones(usuario.SEL_REGEMPLEADO,utils.getNumber(vRegistroSel)); 
        
        usuario.set_opciones(usuario.VISTA_EMPLEADO,1); 
        usuario.set_opciones(usuario.EMPLSEL,1);
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.RegEmpleado1.inputValue}",utils.getNumberOracle(vRegistroSel));
        // JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.RegEmpleado.inputValue}",utils.getNumberOracle(this.cmlnk_reg_empleado.getText()));
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjeBusquedaEmpleado");     
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.NombreCompleto.inputValue}");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"cambiarValidacion");
        usuario.set_opciones(usuario.NOMBREEMPLEADOSEL,vValor); 
        usuario.set_opciones(usuario.VISTA_CONTRATO,3); 
        
        actualizarMenu();    
        
        return "ver_empleado";

       

    }


    public void setCmdNuevo(CoreCommandLink cmdNuevo) {
        this.cmdNuevo = cmdNuevo;
    }

    public CoreCommandLink getCmdNuevo() {
        return cmdNuevo;
    }

    public void setShowDetailItem5(CoreShowDetailItem showDetailItem5) {
        this.showDetailItem5 = showDetailItem5;
    }

    public CoreShowDetailItem getShowDetailItem5() {
        return showDetailItem5;
    }

    public void setShowDetailItem1(CoreShowDetailItem showDetailItem1) {
        this.showDetailItem1 = showDetailItem1;
    }

    public CoreShowDetailItem getShowDetailItem1() {
        return showDetailItem1;
    }

    public void setPanelHorizontal3(CorePanelHorizontal panelHorizontal3) {
        this.panelHorizontal3 = panelHorizontal3;
    }

    public CorePanelHorizontal getPanelHorizontal3() {
        return panelHorizontal3;
    }

    public void setInptt_reg_empleado(CoreInputText inptt_reg_empleado) {
        this.inptt_reg_empleado = inptt_reg_empleado;
    }

    public CoreInputText getInptt_reg_empleado() {
        return inptt_reg_empleado;
    }

    public void setCmbtn_buscar(CoreCommandButton cmbtn_buscar) {
        this.cmbtn_buscar = cmbtn_buscar;
    }

    public CoreCommandButton getCmbtn_buscar() {
        return cmbtn_buscar;
    }

    public void setBtnNuevoReg(CoreCommandButton btnNuevoReg) {
        this.btnNuevoReg = btnNuevoReg;
    }

    public CoreCommandButton getBtnNuevoReg() {
        return btnNuevoReg;
    }

    public void setPanelGroup1(HtmlPanelGroup panelGroup1) {
        this.panelGroup1 = panelGroup1;
    }

    public HtmlPanelGroup getPanelGroup1() {
        return panelGroup1;
    }

    public void setObjectSpacer5(CoreObjectSpacer objectSpacer5) {
        this.objectSpacer5 = objectSpacer5;
    }

    public CoreObjectSpacer getObjectSpacer5() {
        return objectSpacer5;
    }

    public void setCommandButton3(CoreCommandButton commandButton3) {
        this.commandButton3 = commandButton3;
    }

    public CoreCommandButton getCommandButton3() {
        return commandButton3;
    }

    public void setCommandButton2(CoreCommandButton commandButton2) {
        this.commandButton2 = commandButton2;
    }

    public CoreCommandButton getCommandButton2() {
        return commandButton2;
    }

    public void setSwrdio_tipoBusqueda(CoreShowOneRadio swrdio_tipoBusqueda) {
        this.swrdio_tipoBusqueda = swrdio_tipoBusqueda;
    }

    public CoreShowOneRadio getSwrdio_tipoBusqueda() {
        return swrdio_tipoBusqueda;
    }

    public void setShowDetailItem2(CoreShowDetailItem showDetailItem2) {
        this.showDetailItem2 = showDetailItem2;
    }

    public CoreShowDetailItem getShowDetailItem2() {
        return showDetailItem2;
    }

    public void setShowDetailItem3(CoreShowDetailItem showDetailItem3) {
        this.showDetailItem3 = showDetailItem3;
    }

    public CoreShowDetailItem getShowDetailItem3() {
        return showDetailItem3;
    }


    public void setPanelHeader3(CorePanelHeader panelHeader3) {
        this.panelHeader3 = panelHeader3;
    }

    public CorePanelHeader getPanelHeader3() {
        return panelHeader3;
    }

    public void setInptt_cedula(CoreInputText inptt_cedula) {
        this.inptt_cedula = inptt_cedula;
    }

    public CoreInputText getInptt_cedula() {
        return inptt_cedula;
    }

    public void setPanelHeader1(CorePanelHeader panelHeader1) {
        this.panelHeader1 = panelHeader1;
    }

    public CorePanelHeader getPanelHeader1() {
        return panelHeader1;
    }

    public void setPanelHorizontal1(CorePanelHorizontal panelHorizontal1) {
        this.panelHorizontal1 = panelHorizontal1;
    }

    public CorePanelHorizontal getPanelHorizontal1() {
        return panelHorizontal1;
    }

    public void setInptt_nombre1(CoreInputText inptt_nombre1) {
        this.inptt_nombre1 = inptt_nombre1;
    }

    public CoreInputText getInptt_nombre1() {
        return inptt_nombre1;
    }

    public void setInptt_nombre2(CoreInputText inptt_nombre2) {
        this.inptt_nombre2 = inptt_nombre2;
    }

    public CoreInputText getInptt_nombre2() {
        return inptt_nombre2;
    }

    public void setObjectSpacer1(CoreObjectSpacer objectSpacer1) {
        this.objectSpacer1 = objectSpacer1;
    }

    public CoreObjectSpacer getObjectSpacer1() {
        return objectSpacer1;
    }

    public void setPanelHeader2(CorePanelHeader panelHeader2) {
        this.panelHeader2 = panelHeader2;
    }

    public CorePanelHeader getPanelHeader2() {
        return panelHeader2;
    }

    public void setPanelHorizontal2(CorePanelHorizontal panelHorizontal2) {
        this.panelHorizontal2 = panelHorizontal2;
    }

    public CorePanelHorizontal getPanelHorizontal2() {
        return panelHorizontal2;
    }

    public void setInptt_apellido1(CoreInputText inptt_apellido1) {
        this.inptt_apellido1 = inptt_apellido1;
    }

    public CoreInputText getInptt_apellido1() {
        return inptt_apellido1;
    }

    public void setInptt_apellido2(CoreInputText inptt_apellido2) {
        this.inptt_apellido2 = inptt_apellido2;
    }

    public CoreInputText getInptt_apellido2() {
        return inptt_apellido2;
    }

    public void setObjectSpacer2(CoreObjectSpacer objectSpacer2) {
        this.objectSpacer2 = objectSpacer2;
    }

    public CoreObjectSpacer getObjectSpacer2() {
        return objectSpacer2;
    }

    public void setObjectSpacer3(CoreObjectSpacer objectSpacer3) {
        this.objectSpacer3 = objectSpacer3;
    }

    public CoreObjectSpacer getObjectSpacer3() {
        return objectSpacer3;
    }

    public void setTbl_empleados(CoreTable tbl_empleados) {
        this.tbl_empleados = tbl_empleados;
    }

    public CoreTable getTbl_empleados() {
        return tbl_empleados;
    }

    public void setTableSelectOne1(CoreTableSelectOne tableSelectOne1) {
        this.tableSelectOne1 = tableSelectOne1;
    }

    public CoreTableSelectOne getTableSelectOne1() {
        return tableSelectOne1;
    }

    public void setBtn_selEmpleado(CoreCommandButton btn_selEmpleado) {
        this.btn_selEmpleado = btn_selEmpleado;
    }

    public CoreCommandButton getBtn_selEmpleado() {
        return btn_selEmpleado;
    }

    public void setColumn1(CoreColumn column1) {
        this.column1 = column1;
    }

    public CoreColumn getColumn1() {
        return column1;
    }

    public void setCmlnk_reg_empleado(CoreCommandLink cmlnk_reg_empleado) {
        this.cmlnk_reg_empleado = cmlnk_reg_empleado;
    }

    public CoreCommandLink getCmlnk_reg_empleado() {
        return cmlnk_reg_empleado;
    }

    

    public void setColumn13(CoreColumn column13) {
        this.column13 = column13;
    }

    public CoreColumn getColumn13() {
        return column13;
    }


    public void setColumn8(CoreColumn column8) {
        this.column8 = column8;
    }

    public CoreColumn getColumn8() {
        return column8;
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

    public void setOuptxt_cedula(CoreOutputText ouptxt_cedula) {
        this.ouptxt_cedula = ouptxt_cedula;
    }

    public CoreOutputText getOuptxt_cedula() {
        return ouptxt_cedula;
    }

    public void setColumn3(CoreColumn column3) {
        this.column3 = column3;
    }

    public CoreColumn getColumn3() {
        return column3;
    }

    public void setOuptxt_estEmpl(CoreOutputText ouptxt_estEmpl) {
        this.ouptxt_estEmpl = ouptxt_estEmpl;
    }

    public CoreOutputText getOuptxt_estEmpl() {
        return ouptxt_estEmpl;
    }

    public void setColumn4(CoreColumn column4) {
        this.column4 = column4;
    }

    public CoreColumn getColumn4() {
        return column4;
    }

    public void setOuptxt_nombre1(CoreOutputText ouptxt_nombre1) {
        this.ouptxt_nombre1 = ouptxt_nombre1;
    }

    public CoreOutputText getOuptxt_nombre1() {
        return ouptxt_nombre1;
    }

    public void setColumn5(CoreColumn column5) {
        this.column5 = column5;
    }

    public CoreColumn getColumn5() {
        return column5;
    }

    public void setOuptxt_nombre2(CoreOutputText ouptxt_nombre2) {
        this.ouptxt_nombre2 = ouptxt_nombre2;
    }

    public CoreOutputText getOuptxt_nombre2() {
        return ouptxt_nombre2;
    }

    public void setColumn6(CoreColumn column6) {
        this.column6 = column6;
    }

    public CoreColumn getColumn6() {
        return column6;
    }

    public void setOuptxt_ape1(CoreOutputText ouptxt_ape1) {
        this.ouptxt_ape1 = ouptxt_ape1;
    }

    public CoreOutputText getOuptxt_ape1() {
        return ouptxt_ape1;
    }

    public void setColumn7(CoreColumn column7) {
        this.column7 = column7;
    }

    public CoreColumn getColumn7() {
        return column7;
    }

    public void setOuptxt_ape2(CoreOutputText ouptxt_ape2) {
        this.ouptxt_ape2 = ouptxt_ape2;
    }

    public CoreOutputText getOuptxt_ape2() {
        return ouptxt_ape2;
    }


    public void setOutputText4(CoreOutputText outputText4) {
        this.outputText4 = outputText4;
    }

    public CoreOutputText getOutputText4() {
        return outputText4;
    }


    
    public void setObjectSpacer4(CoreObjectSpacer objectSpacer4) {
        this.objectSpacer4 = objectSpacer4;
    }

    public CoreObjectSpacer getObjectSpacer4() {
        return objectSpacer4;
    }

    public void setCommandButton1(CoreCommandButton commandButton1) {
        this.commandButton1 = commandButton1;
    }

    public CoreCommandButton getCommandButton1() {
        return commandButton1;
    }

    public void setObjectSpacer6(CoreObjectSpacer objectSpacer6) {
        this.objectSpacer6 = objectSpacer6;
    }

    public CoreObjectSpacer getObjectSpacer6() {
        return objectSpacer6;
    }

    public String buscar_avanzada() {
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Rollback");
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ConsultaEmpleado");         
        return null;
    }

    public void setBtn_resete_password(CoreCommandButton commandButton4) {
        this.btn_resete_password = commandButton4;
    }

    public CoreCommandButton getBtn_resete_password() {
        return btn_resete_password;
    }

    public String btn_resetar_password() {
        interfaz_DB cone;
        cone=new interfaz_DB();
        ArrayList vParametros=new ArrayList();
        Object vRegistro,vUsuario;
        
        vUsuario=JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.selRegEmpleado_login");
        
        vRegistro=JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.selRegEmpleado");
        
        
        if (vRegistro!=null) {
            
        vParametros.add(new BigDecimal(vRegistro.toString()));
        vParametros.add(vUsuario.toString());
        
        if (cone.Bol_ejecutar_procedimiento("SIS_PKG_PROCS.resetearPassword(?,?)",vParametros)){
            cone.commit();    
            utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Se ha reseteado la contraseña del registro de personal: "+vRegistro));
        }else {
            
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Ha ocurrido un error, por favor intente nuevamente"));
        }
        
       }else{
           
           utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"No ha seleccionado a la persona."));
       }
        cone.cn_Cerrar_coneccion();
        
        
        return null;
    }

    public String commandButton4_action() {
        // Add event code here...
        return null;
    }

    public void setInpt_info1(CoreInputHidden inputHidden1) {
        this.inpt_info1 = inputHidden1;
    }

    public CoreInputHidden getInpt_info1() {
        return inpt_info1;
    }

    public String reset_empleado2() {
        // Add event code here...
        return null;
    }

    public String reset_clave2() {
        // Add event code here...
        interfaz_DB cone;
        cone=new interfaz_DB();
        Object vRegistroEmpleado,vUsuario;
        ArrayList vParametros=new ArrayList();
        
        vRegistroEmpleado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.RegistroEmpleado.inputValue}");
        vUsuario=JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.selRegEmpleado_login");
                
                
        if (vRegistroEmpleado!=null) {
            
        vParametros.add(new BigDecimal(vRegistroEmpleado.toString()));
        vParametros.add(vUsuario.toString());
        
        if (cone.Bol_ejecutar_procedimiento("SIS_PKG_PROCS.resetearPassword(?,?)",vParametros)){
        
            cone.commit();    
            utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Se ha reseteado la contraseña del registro de personal: "+vRegistroEmpleado));
        
        }else {
            
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Ha ocurrido un error, por favor intente nuevamente"));
        }
        
        }else{
           
           utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"No ha seleccionado a la persona."));
        }
        cone.cn_Cerrar_coneccion();                
                
                
        return null;
    }

    public String btn_consultarCLV() {
        Object vRegistroEmpleado,vNumCheque,vFechaE,vCLV;
        ArrayList vParametros=new ArrayList();
        interfaz_DB cone;
        cone=new interfaz_DB();
        vRegistroEmpleado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vRegistroEmpleado1.inputValue}");
        vNumCheque=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vNumeroC1.inputValue}");
        vFechaE=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.pFechaEmision1.inputValue}");
        if (vRegistroEmpleado == null || vRegistroEmpleado.toString().trim()=="") {
            this.outCLV.setValue("No ha ingresado Registro de Empleado");
        } else if (vNumCheque == null || vNumCheque.toString().trim()=="") {
            this.outCLV.setValue("No ha ingresado Número de Cheque");
        } else if (vFechaE==null || vFechaE.toString().trim()=="") {
            this.outCLV.setValue("No ha ingresado Fecha");
        } else {
            //System.out.println(vRegistroEmpleado +" "+ vNumCheque+ " "+vFechaE);
            cone.Crear_sentencia("SELECT sis_pkg_util.CONSULTARCLV(?,?,?) as clv FROM DUAL");
            cone.setParametrosSentencia(1,new BigDecimal(vRegistroEmpleado.toString()));
            cone.setParametrosSentencia(2,vNumCheque.toString());
            //cone.setParametrosSentencia(3,utils.getFechaFormato("dd/MM/yyyy",(oracle.jbo.domain.Date)vFechaE));
            cone.setParametrosSentencia(3,vFechaE.toString());
            vCLV=cone.getValorConsulta("clv");
            cone.cn_Cerrar_coneccion();
            this.outCLV.setValue(vCLV);
        }
        return null;
    }

    public void setOutCLV(CoreOutputText outCLV) {
        this.outCLV = outCLV;
    }

    public CoreOutputText getOutCLV() {
        return outCLV;
    }

    public void setColumn14(CoreColumn column14) {
        this.column14 = column14;
    }

    public CoreColumn getColumn14() {
        return column14;
    }

    public void setOutputText6(CoreOutputText outputText6) {
        this.outputText6 = outputText6;
    }

    public CoreOutputText getOutputText6() {
        return outputText6;
    }

    public void setColumn16(CoreColumn column16) {
        this.column16 = column16;
    }

    public CoreColumn getColumn16() {
        return column16;
    }

    public void setOutputText7(CoreOutputText outputText7) {
        this.outputText7 = outputText7;
    }

    public CoreOutputText getOutputText7() {
        return outputText7;
    }    

    public void setPanelHorarios(CorePanelGroup panelHorarios) {
        this.panelHorarios = panelHorarios;
    }

    public CorePanelGroup getPanelHorarios() {
        return panelHorarios;
    }

    public void setTblSelContIndef(CoreTableSelectOne tblSelContIndef) {
        this.tblSelContIndef = tblSelContIndef;
    }

    public CoreTableSelectOne getTblSelContIndef() {
        return tblSelContIndef;
    }

    public void setBuscaContIndef(CoreCommandButton buscaContIndef) {
        this.buscaContIndef = buscaContIndef;
    }

    public CoreCommandButton getBuscaContIndef() {
        return buscaContIndef;
    }
    
    public void setPanelFechas(CorePanelGroup panelFechas) {
        this.panelFechas = panelFechas;
    }

    public CorePanelGroup getPanelFechas() {
        return panelFechas;
    }
    
    public void setPanelBtnContIndf(CorePanelHorizontal panelBtnContIndf) {
        this.panelBtnContIndf = panelBtnContIndf;
    }

    public CorePanelHorizontal getPanelBtnContIndf() {
        return panelBtnContIndf;
    }
    
    public void setCb_tipo_actualizacion(CoreSelectOneChoice cb_tipo_actualizacion) {
        this.cb_tipo_actualizacion = cb_tipo_actualizacion;
    }

    public CoreSelectOneChoice getCb_tipo_actualizacion() {
        return cb_tipo_actualizacion;
    }
    
    public void setPanelObserCamHoraIndf(CorePanelHorizontal panelObserCamHoraIndf) {
        this.panelObserCamHoraIndf = panelObserCamHoraIndf;
    }

    public CorePanelHorizontal getPanelObserCamHoraIndf() {
        return panelObserCamHoraIndf;
    }

    public String selContratoIndef() {                
        this.getPanelFechas().setRendered(false);
        this.getPanelBtnContIndf().setRendered(true);
        this.getPanelHorarios().setRendered(true);
        this.getTblSelContIndef().setDisabled(true);
        this.getBuscaContIndef().setDisabled(true);
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ExecuteSelContrato");        
        return null;
    }
    
    public String cancelSelContIndef() {        
        this.getPanelHorarios().setRendered(false);
        this.getPanelBtnContIndf().setRendered(false);
        this.getTblSelContIndef().setDisabled(false);
        this.getBuscaContIndef().setDisabled(false);
        this.getPanelFechas().setRendered(false);        
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Rollback");
        return null;
    }
    
    public String btn_mod_indef() {        
        this.getPanelHorarios().setRendered(false);
        this.getPanelBtnContIndf().setRendered(true);
        this.getPanelFechas().setRendered(true);
        this.getTblSelContIndef().setDisabled(true);
        this.getBuscaContIndef().setDisabled(true);
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ExecuteSelContrato");
        return null;
    }
    
    public String btn_saveHorario() {
        OperationBinding operationBinding;
        BindingContainer vBnd_binding;
        Object result;
        resulOp vResultado=new resulOp();  
        
        if(this.getCb_tipo_actualizacion().getValue().equals("Por Actualizacion")){
            JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pTipo.inputValue}","1");
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"CrearHistActa");
        }
        
        vBnd_binding=(BindingContainer)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings}");
        operationBinding = vBnd_binding.getOperationBinding("Commit");
                  
        try {
            result = operationBinding.execute();

            if (operationBinding.getErrors().isEmpty()) {                                
                if(this.getPanelHorarios().isRendered()){                    
                    vResultado.setMensajeError("Horario actualizado correctamente");
                    
                    this.getPanelHorarios().setRendered(false);                    
                }
                else{
                    vResultado.setMensajeError("Fecha actualizada correctamente");                
                    this.getPanelFechas().setRendered(false);
                }
                
                this.getTblSelContIndef().setDisabled(false);
                this.getBuscaContIndef().setDisabled(false);
                this.getPanelBtnContIndf().setRendered(false);
                vResultado.setCodigoResultado(resulOp.OPE_OK);
                utils.setADFMensaje(vResultado);
            }
        } catch (Exception exep) {
            exep.printStackTrace();
        }
        return null;
    }
    
    public List<SelectItem> getListaComboActContIndef()
    {    
        
        List<SelectItem> vTemp=null;
        vTemp=new ArrayList<SelectItem>();
        Object valor = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.Historico.inputValue}");
        vTemp.add(new SelectItem("Por Actualizacion","Por Actualizacion"));
        if(valor.equals("0")){
            vTemp.add(new SelectItem("Por Migracion","Por Migracion"));
        }
        return vTemp;    
    }

    public void setInputText1(CoreInputText inputText1) {
        this.inputText1 = inputText1;
    }

    public CoreInputText getInputText1() {
        return inputText1;
    }

    public void setColumn17(CoreColumn column17) {
        this.column17 = column17;
    }

    public CoreColumn getColumn17() {
        return column17;
    }

    public void setOutputText9(CoreOutputText outputText9) {
        this.outputText9 = outputText9;
    }

    public CoreOutputText getOutputText9() {
        return outputText9;
    }

    public void setColumn19(CoreColumn column19) {
        this.column19 = column19;
    }

    public CoreColumn getColumn19() {
        return column19;
    }

    public void setOutputText10(CoreOutputText outputText10) {
        this.outputText10 = outputText10;
    }

    public CoreOutputText getOutputText10() {
        return outputText10;
    }

    public void setCommandButton4(CoreCommandButton commandButton4) {
        this.commandButton4 = commandButton4;
    }

    public CoreCommandButton getCommandButton4() {
        return commandButton4;
    }

    public String cmd_solisitarRegistro() {
        // Add event code here...
         String vOutcome=null;
         
          if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"asignacionRegPer"))
          {             
              JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ConsultaEmpleado");
              vOutcome="lst_empleado_nor";  
              utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Se ha enviado la solicitud para asignación de registro de empleado."));
          }
          
         
         return vOutcome;
    }
}

