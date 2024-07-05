package interfaz_usuario.backing.consultas;

import interfaz_usuario.servlets.verReporteExcel;

import interfaz_usuario.util.JSFUtils;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.adf.view.faces.component.core.input.CoreInputText;
import oracle.adf.view.faces.component.core.input.CoreSelectBooleanCheckbox;
import oracle.adf.view.faces.component.core.input.CoreSelectInputDate;
import oracle.adf.view.faces.component.core.input.CoreSelectOneChoice;
import oracle.adf.view.faces.component.core.nav.CoreCommandButton;

public class historial_empleado {

    private CoreCommandButton btnLimpiar;
    private CoreInputText inptCui;
    private CoreSelectInputDate slctInputDateFechaInicio;
    private CoreInputText inptRegistroEmpleado;
    private CoreSelectInputDate slctInputDateFechaFin;
    private CoreSelectOneChoice slcOneChoiceDependencias;
    private CoreSelectBooleanCheckbox slctBoolChkBoxFiltrarDependencia;
    private CoreSelectBooleanCheckbox slctBoolChkBoxContrataciones;

    public historial_empleado() {
    }

    public String btn_buscar() {
        Object pBinding,pEstado;
        String vConsultas,vParamEstados;
        //boolean vEspecifico=false;
        vConsultas="";
        
        pBinding=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.mostrarContr1.inputValue}");
        if (pBinding!=null&&pBinding.equals(true)){
            vConsultas="CONTRATOS";
            //vEspecifico=true;
        }
        
        pBinding=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.mostrarLic1.inputValue}");
        if (pBinding!=null&&pBinding.equals(true)){
            vConsultas=vConsultas+"|LICENCIAS";
            //vEspecifico=true;
        }
        
        pBinding=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.mostrarSuspIgss1.inputValue}");
        if (pBinding!=null&&pBinding.equals(true)){
            vConsultas=vConsultas+"|SUSPIGSS";
            //vEspecifico=true;
        }    
        
        pBinding=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.mostrarDescJud1.inputValue}");
        if (pBinding!=null&&pBinding.equals(true)){
            vConsultas=vConsultas+"|DESC_JUDICIAL";
            //vEspecifico=true;
        }
        
        pBinding=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.mostrarRenunDesp1.inputValue}");
        if (pBinding!=null&&pBinding.equals(true)){
            vConsultas=vConsultas+"|RENUNCIADESP";
            //vEspecifico=true;
        }
        
        pBinding=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.mostrarRenunParcial1.inputValue}");
        if (pBinding!=null&&pBinding.equals(true)){
            vConsultas=vConsultas+"|RENUNCIAPARCIAL";
            //vEspecifico=true;
        }
        
        pBinding=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.mostrarHoraExtra1.inputValue}");
        if (pBinding!=null&&pBinding.equals(true)){
            vConsultas=vConsultas+"|HORA_EXTRA";
            //vEspecifico=true;
        }
        
        if (JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.mostrarReclaf1.inputValue}").equals(true) 
        &&JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.mostrarPromDoc1.inputValue}").equals(true)){
            vConsultas=vConsultas+"|PROMRECLASIF";
            //vEspecifico=true;            
        } else{
            pBinding=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.mostrarReclaf1.inputValue}");
            if (pBinding!=null&&pBinding.equals(true)){
                vConsultas=vConsultas+"|RECLASIF";
                //vEspecifico=true;
            }
            pBinding=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.mostrarPromDoc1.inputValue}");
            if (pBinding!=null&&pBinding.equals(true)){
                vConsultas=vConsultas+"|PROMDOC";
                //vEspecifico=true;
            }
        }
        
        pBinding=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.mostrarFallec1.inputValue}");
        if (pBinding!=null&&pBinding.equals(true)){
            vConsultas=vConsultas+"|FALLE";
            //vEspecifico=true;
        }
        
        pBinding=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.mostrarRetiro1.inputValue}");
        if (pBinding!=null&&pBinding.equals(true)){
            vConsultas=vConsultas+"|RETIRO";
            //vEspecifico=true;
        }
        
        pBinding=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.mostrarReintegros1.inputValue}");
        if (pBinding!=null&&pBinding.equals(true)){
            vConsultas=vConsultas+"|REINTEGROS";
            //vEspecifico=true;
        }
        
        pBinding=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.mostrarSuspBajaLab1.inputValue}");
        if (pBinding!=null&&pBinding.equals(true)){
            vConsultas=vConsultas+"|BAJALABORAL";
            //vEspecifico=true;
        }
        
        pBinding=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.mostrarIndemnizaciones1.inputValue}");
        if (pBinding!=null&&pBinding.equals(true)){
            vConsultas=vConsultas+"|INDEMNIZACIONES";
        }
        
        vParamEstados="";
        pEstado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vEstadoContrato1.inputValue}");
        if (pEstado!=null){
            vParamEstados="C|"+pEstado; 
        }
        
        pEstado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vEstadoLic1.inputValue}");
        if (pEstado!=null){
            vParamEstados=vParamEstados+"|L|"+pEstado; 
        }
        
        pEstado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vSuspIgss1.inputValue}");
        if (pEstado!=null){
            vParamEstados=vParamEstados+"|G|"+pEstado; 
        }
        
        pEstado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vDescJud1.inputValue}");
        if (pEstado!=null){
            vParamEstados=vParamEstados+"|J|"+pEstado; 
        }
        
        pEstado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vRenun1.inputValue}");
        if (pEstado!=null){
            vParamEstados=vParamEstados+"|R|"+pEstado; 
        }
        
        pEstado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vRenunParcial1.inputValue}");
        if (pEstado!=null){
            vParamEstados=vParamEstados+"|R|"+pEstado; 
        }
        
        pEstado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vHoraE1.inputValue}");
        if (pEstado!=null){
            vParamEstados=vParamEstados+"|H|"+pEstado; 
        }

        pEstado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vEstFalle1.inputValue}");
        
        if (pEstado!=null){
            vParamEstados=vParamEstados+"|F|"+pEstado; 
        }
        
        pEstado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vEstReti1.inputValue}");
        if (pEstado!=null){
            vParamEstados=vParamEstados+"|B|"+pEstado; 
        }
        
        pEstado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vSuspBajaLab1.inputValue}");
        if (pEstado!=null){
            vParamEstados=vParamEstados+"|BL|"+pEstado; 
        }
        
        pEstado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vReintegros1.inputValue}");
        if (pEstado!=null){
            vParamEstados=vParamEstados+"|REI|"+pEstado; 
        }
        
        pEstado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vEstadoIndem1.inputValue}");
        
        if (pEstado!=null){
            vParamEstados=vParamEstados+"|IND|"+pEstado; 
        }
        
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.pConsulta.inputValue}",vConsultas);
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.vEstados1.inputValue}",vParamEstados);
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarConsulGestiones");
        return null;
    }

    public void setBtnLimpiar(CoreCommandButton btnLimpiar) {
        this.btnLimpiar = btnLimpiar;
    }

    public CoreCommandButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public String btnLimpiar_action() {
        this.getInptCui().setValue("");
        this.getInptRegistroEmpleado().setValue("");
        this.getSlctInputDateFechaInicio().setValue("");
        this.getSlctInputDateFechaFin().setValue("");
        this.getSlctBoolChkBoxFiltrarDependencia().setSelected(false);
        this.getSlcOneChoiceDependencias().setSubmittedValue(0);
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.mostrarContr1.inputValue}",false);
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.mostrarLic1.inputValue}",false);
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.mostrarSuspIgss1.inputValue}",false);
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.mostrarDescJud1.inputValue}",false);
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.mostrarRenunDesp1.inputValue}",false);
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.mostrarRenunParcial1.inputValue}",false);
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.mostrarHoraExtra1.inputValue}",false);
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.mostrarFallec1.inputValue}",false);
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.mostrarRetiro1.inputValue}",false);
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.mostrarPromDoc1.inputValue}",false);
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.mostrarReclaf1.inputValue}",false);
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.mostrarReintegros1.inputValue}",false);
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.mostrarTodoAux1.inputValue}",false);
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.mostrarSuspBajaLab1.inputValue}",false);
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.mostrarIndemnizaciones1.inputValue}",false);
        //JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.unaConsulta_buscaDep.inputValue}",false);
        //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarConsulGestiones");
        //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Rollback");
        return null;
    }

    public void setInptCui(CoreInputText inptCui) {
        this.inptCui = inptCui;
    }

    public CoreInputText getInptCui() {
        return inptCui;
    }

    public void setSlctInputDateFechaInicio(CoreSelectInputDate slctInputDateFechaInicio) {
        this.slctInputDateFechaInicio = slctInputDateFechaInicio;
    }

    public CoreSelectInputDate getSlctInputDateFechaInicio() {
        return slctInputDateFechaInicio;
    }

    public void setInptRegistroEmpleado(CoreInputText inptRegistroEmpleado) {
        this.inptRegistroEmpleado = inptRegistroEmpleado;
    }

    public CoreInputText getInptRegistroEmpleado() {
        return inptRegistroEmpleado;
    }

    public void setSlctInputDateFechaFin(CoreSelectInputDate slctInputDateFechaFin) {
        this.slctInputDateFechaFin = slctInputDateFechaFin;
    }

    public CoreSelectInputDate getSlctInputDateFechaFin() {
        return slctInputDateFechaFin;
    }

    public void setSlcOneChoiceDependencias(CoreSelectOneChoice slcOneChoiceDependencias) {
        this.slcOneChoiceDependencias = slcOneChoiceDependencias;
    }

    public CoreSelectOneChoice getSlcOneChoiceDependencias() {
        return slcOneChoiceDependencias;
    }

    public void setSlctBoolChkBoxFiltrarDependencia(CoreSelectBooleanCheckbox slctBoolChkBoxFiltrarDependencia) {
        this.slctBoolChkBoxFiltrarDependencia = slctBoolChkBoxFiltrarDependencia;
    }

    public CoreSelectBooleanCheckbox getSlctBoolChkBoxFiltrarDependencia() {
        return slctBoolChkBoxFiltrarDependencia;
    }

    public void setSlctBoolChkBoxContrataciones(CoreSelectBooleanCheckbox slctBoolChkBoxContrataciones) {
        this.slctBoolChkBoxContrataciones = slctBoolChkBoxContrataciones;
    }

    public CoreSelectBooleanCheckbox getSlctBoolChkBoxContrataciones() {
        return slctBoolChkBoxContrataciones;
    }

    public String cmd_excel(int tipoReporte) {
        // Add event code here...
         HttpServletRequest vRequest=((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest());
         HttpServletResponse vResponse; 
         vResponse=(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
         String vParametros = "";
         
         //-PARA OBTENER PARAMETRO 
          Object vValor, vAux;
          
          // Registro de empleado
          
         
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.pCui.inputValue}");
        vParametros += (vValor==null ? "0" : vValor) ; 
          
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.regEmpleado.inputValue}");
        vParametros += "|"+(vValor==null ? "0" : vValor) ; 
        
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.FechaI.inputValue}");
        vParametros += "|"+(vValor==null ? "0" : vValor) ; 
        
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.FechaF.inputValue}");
        vParametros += "|"+(vValor==null ? "0" : vValor) ; 
        
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.unaConsulta_buscaDep.inputValue}");
        if (Boolean.parseBoolean(vValor+""))
            vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.Dependencia.inputValue}");
        else 
            vValor = null;
        
        vParametros += "|"+(vValor==null ? "0" : vValor) ;
        
        verReporteExcel Excel;
        Excel = new verReporteExcel();
        try{
         
        if (tipoReporte == 1){
            vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vEstadoContrato1.inputValue}");
            vParametros += "|"+(vValor==null ? "0" : vValor) ; 
          vRequest.setAttribute("id",vParametros);                
          vRequest.setAttribute("rep","REPHISTEMPL_CONTRATOS");   
          
        }else if (tipoReporte == 2){
            vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vEstadoLic1.inputValue}");
            vParametros += "|"+(vValor==null ? "0" : vValor) ; 
          vRequest.setAttribute("id",vParametros);                
          vRequest.setAttribute("rep","REPHISTEMPL_LICENCIAS");   
          
        }else if (tipoReporte == 3){
            vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vSuspIgss1.inputValue}");
            vParametros += "|"+(vValor==null ? "0" : vValor) ; 
          vRequest.setAttribute("id",vParametros);                
          vRequest.setAttribute("rep","REPHISTEMPL_SUPIGSS");   
          
        }else if (tipoReporte == 4){
            vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vDescJud1.inputValue}");
            vParametros += "|"+(vValor==null ? "0" : vValor) ; 
          vRequest.setAttribute("id",vParametros);                
          vRequest.setAttribute("rep","REPHISTEMPL_DESCJUDICIAL");   
          
        }else if (tipoReporte == 5){
            vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vRenun1.inputValue}");
            vParametros += "|"+(vValor==null ? "0" : vValor) ; 
          vRequest.setAttribute("id",vParametros);                
          vRequest.setAttribute("rep","REPHISTEMPL_RENUNDESP");   
          
        }else if (tipoReporte == 6){
            vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vRenunParcial1.inputValue}");
            vParametros += "|"+(vValor==null ? "0" : vValor) ; 
          vRequest.setAttribute("id",vParametros);                
          vRequest.setAttribute("rep","REPHISTEMPL_RENUNPARC");   
          
        }else if (tipoReporte == 7){
            vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vHoraE1.inputValue}");
            vParametros += "|"+(vValor==null ? "0" : vValor) ; 
          vRequest.setAttribute("id",vParametros);                
          vRequest.setAttribute("rep","REPHISTEMPL_TIEMPEXT");   
          
        }else if (tipoReporte == 8){
            vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vEstFalle1.inputValue}");
            vParametros += "|"+(vValor==null ? "0" : vValor) ; 
          vRequest.setAttribute("id",vParametros);                
          vRequest.setAttribute("rep","REPHISTEMPL_FALLECIMIENTO");   
          
        }else if (tipoReporte == 9){
            vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vEstReti1.inputValue}");
            vParametros += "|"+(vValor==null ? "0" : vValor) ; 
          vRequest.setAttribute("id",vParametros);                
          vRequest.setAttribute("rep","REPHISTEMPL_RETIROOBL");   
          
        }else if (tipoReporte == 10){
            vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vReintegros1.inputValue}");
            vParametros += "|"+(vValor==null ? "0" : vValor) ; 
          vRequest.setAttribute("id",vParametros);                
          vRequest.setAttribute("rep","REPHISTEMPL_REINTEGROS");   
          
        }else if (tipoReporte == 11){
            vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.vSuspBajaLab1.inputValue}");
            vParametros += "|"+(vValor==null ? "0" : vValor) ; 
          vRequest.setAttribute("id",vParametros);                
          vRequest.setAttribute("rep","REPHISTEMPL_BAJALABORAL");   
          
        }else if (tipoReporte == 12){
            vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.mostrarReclaf1.inputValue}");
            vAux=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.mostrarPromDoc1.inputValue}");
            
           if ( (vValor!=null&&vValor.equals(true)) && (vAux!=null&&vAux.equals(true)) ){
                vValor = "-1";
           }else if (vValor!=null&&vValor.equals(true)) {
               vValor = "2";
           }else if (vAux!=null&&vAux.equals(true)){
               vValor = "1";
           }
            
            vParametros += "|"+(vValor==null ? "0" : vValor) ; 
          vRequest.setAttribute("id",vParametros);                
          vRequest.setAttribute("rep","REPHISTEMPL_PROMREC");   
          
        }
        
        
          Excel.doGet(vRequest,vResponse);
        
        
        }catch(Exception exep){
            exep.printStackTrace(); 
        }  
        
          //histEmpl_nombramiento
        return null;
    }


    public String cmd_excel() {
        // Add event code here...
        cmd_excel(1);
        return null;
    }

    public String cmd_excel_lic() {
        // Add event code here...
         cmd_excel(2);
        return null;
    }

    public String cmd_excel_suspIgss() {
        // Add event code here...
         cmd_excel(3);
        return null;
    }

    public String cmd_excel_descjudicial() {
        // Add event code here.
        cmd_excel(4);
        return null;
    }

    public String cmd_excel_renunDesp() {
        // Add event code here...
         cmd_excel(5);
        return null;
    }

    public String cmd_excel_renunParcial() {
        // Add event code here...
         cmd_excel(6);
        return null;
    }

    public String cmd_excel_tiempoExt() {
        // Add event code here...
         cmd_excel(7);
        return null;
    }

    public String cmd_excel_falleci() {
        // Add event code here...
         cmd_excel(8);
        return null;
    }

    public String cmd_excel_retObl() {
        // Add event code here...
         cmd_excel(9);
        return null;
    }

    public String cmd_excel_promo() {
        // Add event code here...
         cmd_excel(12);
        return null;
    }

    public String cmd_excel_reintegros() {
        // Add event code here...
         cmd_excel(10);
        return null;
    }

    public String cmd_excel_solbajalab() {
        // Add event code here...
         cmd_excel(11);
        return null;
    }
}
