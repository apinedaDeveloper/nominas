package interfaz_usuario.backing.procesos;

import enlace_datos.util.resulOp;

import interfaz_usuario.backing.util.util_dialog_adf;

import interfaz_usuario.util.JSFUtils;

import interfaz_usuario.util.utils;

import javax.faces.component.html.HtmlForm;

import javax.faces.component.html.HtmlPanelGroup;
import javax.faces.context.FacesContext;

import oracle.adf.view.faces.component.core.data.CoreColumn;
import oracle.adf.view.faces.component.core.data.CoreTable;
import oracle.adf.view.faces.component.core.data.CoreTableSelectOne;
import oracle.adf.view.faces.component.core.input.CoreInputText;
import oracle.adf.view.faces.component.core.layout.CorePanelBox;
import oracle.adf.view.faces.component.core.layout.CorePanelButtonBar;
import oracle.adf.view.faces.component.core.layout.CorePanelForm;
import oracle.adf.view.faces.component.core.layout.CorePanelHeader;
import oracle.adf.view.faces.component.core.layout.CorePanelHorizontal;
import oracle.adf.view.faces.component.core.layout.CorePanelLabelAndMessage;
import oracle.adf.view.faces.component.core.layout.CoreShowDetailItem;
import oracle.adf.view.faces.component.core.layout.CoreShowOneTab;
import oracle.adf.view.faces.component.core.nav.CoreCommandButton;
import oracle.adf.view.faces.component.core.nav.CoreCommandLink;
import oracle.adf.view.faces.component.core.output.CoreMessages;
import oracle.adf.view.faces.component.core.output.CoreObjectImage;
import oracle.adf.view.faces.component.core.output.CoreObjectSeparator;
import oracle.adf.view.faces.component.core.output.CoreObjectSpacer;
import oracle.adf.view.faces.component.core.output.CoreOutputText;
import oracle.adf.view.faces.component.html.HtmlBody;
import oracle.adf.view.faces.component.html.HtmlHead;
import oracle.adf.view.faces.component.html.HtmlHtml;
import oracle.adf.view.faces.event.LaunchEvent;

public class Ver_proceso {


    private HtmlHtml html1;
    private HtmlHead head1;
    private HtmlBody body1;
    private HtmlForm form1;
    private CoreMessages messages1;
    private CorePanelHorizontal panelHorizontal1;
    private CorePanelBox panelBox1;
    private CorePanelHeader panelHeader1;
    private CoreCommandButton commandButton10;
    private CoreShowOneTab showOneTab1;
    private CoreShowDetailItem showDetailItem1;
    private CorePanelForm panelForm1;
    private CorePanelLabelAndMessage panelLabelAndMessage3;
    private CoreOutputText outputText3;
    private CorePanelLabelAndMessage panelLabelAndMessage4;
    private CoreOutputText outputText4;
    private CorePanelLabelAndMessage panelLabelAndMessage5;
    private CoreOutputText outputText8;
    private CorePanelLabelAndMessage panelLabelAndMessage6;
    private CoreOutputText outputText6;
    private CorePanelLabelAndMessage panelLabelAndMessage1;
    private CoreOutputText outputText1;
    private CorePanelLabelAndMessage panelLabelAndMessage2;
    private CoreOutputText outputText2;
    private CoreInputText inputText7;
    private CorePanelLabelAndMessage panelLabelAndMessage9;
    private CoreOutputText outputText26;
    private CorePanelLabelAndMessage panelLabelAndMessage10;
    private CoreOutputText outputText27;
    private CorePanelLabelAndMessage panelLabelAndMessage7;
    private CoreOutputText outputText7;
    private CorePanelLabelAndMessage panelLabelAndMessage8;
    private CoreCommandButton commandButton7;
    private CoreObjectSeparator objectSeparator1;
    private CorePanelHeader panelHeader2;
    private CoreTable table1;
    private CoreColumn column5;
    private CoreOutputText outputText12;
    private CoreColumn column1;
    private CoreOutputText outputText5;
    private CoreColumn column2;
    private CoreOutputText outputText9;
    private CoreColumn column3;
    private CoreOutputText outputText10;
    private CoreColumn column4;
    private CoreOutputText outputText11;
    private CoreObjectSpacer objectSpacer1;
    private CoreObjectSeparator objectSeparator2;
    private CorePanelHeader panelHeader3;
    private CoreTable tablaFolioEmi;
    private HtmlPanelGroup panelGroup1;
    private CorePanelButtonBar panelButtonBar1;
    private CoreCommandLink linkAgregar;
    private CoreCommandLink linkEjecutarLista;
    private CoreTableSelectOne tableSelectOne1;
    private CoreColumn column13;
    private CoreCommandLink linkBorrar;
    private CoreObjectImage objectImage3;
    private CoreColumn column12;
    private CoreCommandLink linkEditar;
    private CoreObjectImage objectImage1;
    private CoreCommandLink linkFinEditar;
    private CoreObjectImage objectImage2;
    private CoreColumn column6;
    private CoreInputText inputText1;
    private CoreOutputText outputText13;
    private CoreColumn column7;
    private CoreInputText inputText2;
    private CoreOutputText outputText17;
    private CoreColumn column9;
    private CoreOutputText outputText18;
    private CoreColumn column8;
    private CoreOutputText outputText15;
    private CoreColumn column10;
    private CoreOutputText outputText16;
    private CoreColumn column11;
    private CoreOutputText outputText14;
    private CorePanelHeader panelHeader4;
    private CorePanelHorizontal panelHorizontal3;
    private CoreTable tablaFolioAnu;
    private HtmlPanelGroup panelGroup2;
    private CorePanelButtonBar panelButtonBar2;
    private CoreCommandLink linkAgregarDetalle;
    private CoreCommandLink linkEjecutarDetalle;
    private CoreColumn column21;
    private CoreCommandLink linkBorrarDetalle;
    private CoreObjectImage objectImage4;
    private CoreColumn column22;
    private CoreCommandLink linkEditarDetalle;
    private CoreObjectImage objectImage5;
    private CoreCommandLink linkFinEditarDetalle;
    private CoreObjectImage objectImage6;
    private CoreColumn column14;
    private CoreOutputText outputText19;
    private CoreInputText inputText3;
    private CoreColumn column15;
    private CoreOutputText outputText20;
    private CoreInputText inputText4;
    private CoreColumn column16;
    private CoreOutputText outputText21;
    private CoreInputText inputText5;
    private CoreColumn column17;
    private CoreOutputText outputText22;
    private CoreColumn column18;
    private CoreOutputText outputText23;
    private CoreColumn column19;
    private CoreOutputText outputText24;
    private CoreColumn column20;
    private CoreOutputText outputText25;
    private CoreObjectSpacer objectSpacer3;
    private CorePanelHorizontal panelHorizontal2;
    private CoreCommandButton commandButton5;
    private CoreCommandButton commandButton8;
    private CoreCommandButton commandButton3;
    private CoreCommandButton commandButton6;
    private CoreCommandButton id_btn_reprocesar;
    private CoreCommandButton commandButton1;
    private CoreObjectSpacer objectSpacer2;
    private CoreCommandButton btn_autorizar;
    private CoreCommandButton commandButton2;
    private CoreCommandButton commandButton4;
    private CoreShowDetailItem showDetailItem2;
    private CoreTable table2;
    private CoreColumn column23;
    private CoreColumn column24;
    private CoreOutputText outputText29;
    private CoreColumn column25;
    private CoreOutputText outputText30;
    private CoreColumn column26;
    private CoreOutputText outputText31;
    private CoreColumn column28;
    private CoreOutputText outputText33;
    private CoreCommandLink commandLink1;
    private CoreOutputText outputText28;
    private CoreObjectSpacer objectSpacer4;
    private CorePanelHorizontal panelHorizontal4;
    private CoreCommandButton plan_presta;
    private CoreCommandButton commandButton9;
    private CoreCommandButton commandButton11;
    private CoreCommandButton commandButton12;
    private CoreCommandButton commandButton13;
    private CoreCommandButton commandButton14;

    /* Agregado por JM. 19-06-12
     *
     * */
     public String guardar() {
         if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit"))
         {
               utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Cambios guardados correctamente."));
               JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"cambiarEstadoTodos");
               JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarFolioEmision");
         }
         else{
             utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"No fue posible guardar los cambios realizados."));
         }
         return null;
     }     
     
     public String confirmarBorrar(){
         if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit"))
         {
               utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Fila borrada correctamente."));
         }
         else{
             JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Rollback");
             utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"No fue posible borrar la fila seleccionada."));
         }

         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarFolioEmision");
         
         return null;
     }
     
     
     public String cmd_editar_folioEmi() {
          if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"setCurrentRowFolioEmision"))
          {
          
              if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"cambiarEstadoTodos"))
              {
                  JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"cambiarEstadoActual");
              }
            
          }         
         return null;
     }


     public String cmd_cancelar_edicion_folioEmi() {
         // Add event code here...
         if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit"))
         {
               utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Cambios guardados correctamente."));
               JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"cambiarEstadoTodos");
               JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarFolioEmision");
               JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"posicionaSeleccionado");
               System.out.println("Llego hasta acá");
         }
         else{
             utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"No fue posible guardar los cambios realizados."));
         }         

         return null;
     } 


    public String guardarFolAnu() {
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit"))
        {
              utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Cambios guardados correctamente."));
              JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"cambiarEstadoTodosFolAnulado");
              JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarFolioAnulado");
        }
        else{
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"No fue posible guardar los cambios realizados."));
        }
        return null;
    }     
    
    public String confirmarBorrarFolAnu(){
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit"))
        {
              utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Fila borrada correctamente."));
        }
        else{
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Rollback");
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"No fue posible borrar la fila seleccionada."));
        }

        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarFolioAnulado");
        
        return null;
    }
    
    
    public String cmd_editar_folioAnu() {
         if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"setCurrentRowFolioAnulado"))
         {
         
             if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"cambiarEstadoTodosFolAnulado"))
             {
                 JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"cambiarEstadoActualFolAnulado");
             }
           
         }         
        return null;
    }


    public String cmd_cancelar_edicion_folioAnu() {
        // Add event code here...
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit"))
        {
              utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Cambios guardados correctamente."));
              JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"cambiarEstadoTodosFolAnulado");
              JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjecutarFolioAnulado");
              JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"posicionaSeleccionadoFolAnulado");
        }
        else{
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"No fue posible guardar los cambios realizados."));
        }         

        return null;
    } 

    /*  FIN DE CODIGO AGREGADO POR JM. 16-05-12  */

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


    public void setMessages1(CoreMessages messages1) {
        this.messages1 = messages1;
    }

    public CoreMessages getMessages1() {
        return messages1;
    }


    public void setPanelHorizontal1(CorePanelHorizontal panelHorizontal1) {
        this.panelHorizontal1 = panelHorizontal1;
    }

    public CorePanelHorizontal getPanelHorizontal1() {
        return panelHorizontal1;
    }

    public void setPanelBox1(CorePanelBox panelBox1) {
        this.panelBox1 = panelBox1;
    }

    public CorePanelBox getPanelBox1() {
        return panelBox1;
    }


    public void setPanelHeader1(CorePanelHeader panelHeader1) {
        this.panelHeader1 = panelHeader1;
    }

    public CorePanelHeader getPanelHeader1() {
        return panelHeader1;
    }


    public String id_btn_reprocesar_action() {
        Object vResultado,vTipoProceso;
       
        vResultado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.Nomestado.inputValue}");
        vTipoProceso=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.Nomtipoproceso.inputValue}");
            
       // if (vTipoProceso!=null&&(vTipoProceso.equals("PAGO")||vTipoProceso.equals("COMPLEMENTO AUTOMATICO"))){
        if (vTipoProceso!=null&&(vTipoProceso.equals("PAGO"))){
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"No se permite reprocesar un proceso de " + vTipoProceso.toString().toLowerCase())); 

        }else if(vTipoProceso!=null&&!vTipoProceso.equals("PAGO")){
                if (vResultado !=null && vResultado.equals("APROBADO")){
                    utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Proceso en estado aprobado no se permite reprocesar.")); 
                }
                else if(vResultado !=null && !vResultado.equals("ERROR")){
                    vResultado=JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"generar_proceso");
                    JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ActProceso");
                    
                    if (vResultado!=null){
                       utils.setADFMensaje(vResultado);
                    }    
                    
                }else{
                    
                   utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"No se permite reprocesar el proceso en estado con error.")); 
                    
                }
        }
       
        return null;
    }

    public void launch_btn_autorizar(LaunchEvent launchEvent) {
      
        Object vValor;
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdProceso.inputValue}");   
        launchEvent.getDialogParameters().put("IdProceso", vValor);
        launchEvent.getDialogParameters().put("IdGestionX", vValor); 
        launchEvent.getDialogParameters().put("Gestion", "PROC_NOMINA"); 
        launchEvent.getDialogParameters().put("RefreshVw", "Proceso"); 
        
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdEstado.inputValue}");
        launchEvent.getDialogParameters().put("Estado", vValor); 
                
        
        launchEvent.getDialogParameters().put("IdSolicitud", null); 
        launchEvent.getDialogParameters().put("IdContrato", null); 
        
        /*
        util_dialog_adf vDialog= new util_dialog_adf();
             Object vVariable,vEstado;
             vVariable=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdProceso.inputValue}");
             vEstado=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdEstado.inputValue}");
             vDialog.abrir_dialogo_autorizacion(FacesContext.getCurrentInstance(),"PROC_NOMINA",vVariable,vEstado,"Proceso");
          */   
          
      
    }


    public String btn_aplicar_Descuentos() {
        
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"cargarDescuentos")){
            
            utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Carga de descuentos ejecutado exitosamente."));
            
        }
        return null;
    }


    public String btn_cheque_circulacion() {
        // Add event code here...
        Object vNomProceso;
        
        vNomProceso=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.Nomtipoproceso.inputValue}");

        if (vNomProceso!=null && vNomProceso.equals("PAGO"))
        {
        
         if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"cambiaCheque")){
             
             utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Se ha cambiado el estado de los Cheques a Circulación."));
             
         }
        }else{
            
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Solo se puede cambiar el estado a un proceso de PAGO.")); 
        }
        return null;
    }


    public String btn_guardar() {
        // Add event code here...
        
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit")){
            
           utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Datos guardados exitosamente.")); 
        }
        
        return null;
    }


    public String btn_cambia_Acreditamientio() {
        // Add event code here...
         Object vNomProceso;
         
         vNomProceso=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.Nomtipoproceso.inputValue}");

         if (vNomProceso!=null && vNomProceso.equals("PAGO"))
         {

        
             if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"cambiaAcre")){
                 
                 utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Se ha cambiado el estado de los acreditamiento a Pagado."));
                 
             }
         }else {
             
               utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Solo se puede cambiar el estado a un proceso de PAGO."));   
         }
        return null;
    }


    public void setCommandButton10(CoreCommandButton commandButton10) {
        this.commandButton10 = commandButton10;
    }

    public CoreCommandButton getCommandButton10() {
        return commandButton10;
    }


    public void setShowOneTab1(CoreShowOneTab showOneTab1) {
        this.showOneTab1 = showOneTab1;
    }

    public CoreShowOneTab getShowOneTab1() {
        return showOneTab1;
    }

    public void setShowDetailItem1(CoreShowDetailItem showDetailItem1) {
        this.showDetailItem1 = showDetailItem1;
    }

    public CoreShowDetailItem getShowDetailItem1() {
        return showDetailItem1;
    }

    public void setPanelForm1(CorePanelForm panelForm1) {
        this.panelForm1 = panelForm1;
    }

    public CorePanelForm getPanelForm1() {
        return panelForm1;
    }

    public void setPanelLabelAndMessage3(CorePanelLabelAndMessage panelLabelAndMessage3) {
        this.panelLabelAndMessage3 = panelLabelAndMessage3;
    }

    public CorePanelLabelAndMessage getPanelLabelAndMessage3() {
        return panelLabelAndMessage3;
    }

    public void setOutputText3(CoreOutputText outputText3) {
        this.outputText3 = outputText3;
    }

    public CoreOutputText getOutputText3() {
        return outputText3;
    }

    public void setPanelLabelAndMessage4(CorePanelLabelAndMessage panelLabelAndMessage4) {
        this.panelLabelAndMessage4 = panelLabelAndMessage4;
    }

    public CorePanelLabelAndMessage getPanelLabelAndMessage4() {
        return panelLabelAndMessage4;
    }

    public void setOutputText4(CoreOutputText outputText4) {
        this.outputText4 = outputText4;
    }

    public CoreOutputText getOutputText4() {
        return outputText4;
    }

    public void setPanelLabelAndMessage5(CorePanelLabelAndMessage panelLabelAndMessage5) {
        this.panelLabelAndMessage5 = panelLabelAndMessage5;
    }

    public CorePanelLabelAndMessage getPanelLabelAndMessage5() {
        return panelLabelAndMessage5;
    }

    public void setOutputText8(CoreOutputText outputText8) {
        this.outputText8 = outputText8;
    }

    public CoreOutputText getOutputText8() {
        return outputText8;
    }

    public void setPanelLabelAndMessage6(CorePanelLabelAndMessage panelLabelAndMessage6) {
        this.panelLabelAndMessage6 = panelLabelAndMessage6;
    }

    public CorePanelLabelAndMessage getPanelLabelAndMessage6() {
        return panelLabelAndMessage6;
    }

    public void setOutputText6(CoreOutputText outputText6) {
        this.outputText6 = outputText6;
    }

    public CoreOutputText getOutputText6() {
        return outputText6;
    }

    public void setPanelLabelAndMessage1(CorePanelLabelAndMessage panelLabelAndMessage1) {
        this.panelLabelAndMessage1 = panelLabelAndMessage1;
    }

    public CorePanelLabelAndMessage getPanelLabelAndMessage1() {
        return panelLabelAndMessage1;
    }

    public void setOutputText1(CoreOutputText outputText1) {
        this.outputText1 = outputText1;
    }

    public CoreOutputText getOutputText1() {
        return outputText1;
    }

    public void setPanelLabelAndMessage2(CorePanelLabelAndMessage panelLabelAndMessage2) {
        this.panelLabelAndMessage2 = panelLabelAndMessage2;
    }

    public CorePanelLabelAndMessage getPanelLabelAndMessage2() {
        return panelLabelAndMessage2;
    }

    public void setOutputText2(CoreOutputText outputText2) {
        this.outputText2 = outputText2;
    }

    public CoreOutputText getOutputText2() {
        return outputText2;
    }

    public void setInputText7(CoreInputText inputText7) {
        this.inputText7 = inputText7;
    }

    public CoreInputText getInputText7() {
        return inputText7;
    }

    public void setPanelLabelAndMessage9(CorePanelLabelAndMessage panelLabelAndMessage9) {
        this.panelLabelAndMessage9 = panelLabelAndMessage9;
    }

    public CorePanelLabelAndMessage getPanelLabelAndMessage9() {
        return panelLabelAndMessage9;
    }

    public void setOutputText26(CoreOutputText outputText26) {
        this.outputText26 = outputText26;
    }

    public CoreOutputText getOutputText26() {
        return outputText26;
    }

    public void setPanelLabelAndMessage10(CorePanelLabelAndMessage panelLabelAndMessage10) {
        this.panelLabelAndMessage10 = panelLabelAndMessage10;
    }

    public CorePanelLabelAndMessage getPanelLabelAndMessage10() {
        return panelLabelAndMessage10;
    }

    public void setOutputText27(CoreOutputText outputText27) {
        this.outputText27 = outputText27;
    }

    public CoreOutputText getOutputText27() {
        return outputText27;
    }

    public void setPanelLabelAndMessage7(CorePanelLabelAndMessage panelLabelAndMessage7) {
        this.panelLabelAndMessage7 = panelLabelAndMessage7;
    }

    public CorePanelLabelAndMessage getPanelLabelAndMessage7() {
        return panelLabelAndMessage7;
    }

    public void setOutputText7(CoreOutputText outputText7) {
        this.outputText7 = outputText7;
    }

    public CoreOutputText getOutputText7() {
        return outputText7;
    }

    public void setPanelLabelAndMessage8(CorePanelLabelAndMessage panelLabelAndMessage8) {
        this.panelLabelAndMessage8 = panelLabelAndMessage8;
    }

    public CorePanelLabelAndMessage getPanelLabelAndMessage8() {
        return panelLabelAndMessage8;
    }

    public void setCommandButton7(CoreCommandButton commandButton7) {
        this.commandButton7 = commandButton7;
    }

    public CoreCommandButton getCommandButton7() {
        return commandButton7;
    }

    public void setObjectSeparator1(CoreObjectSeparator objectSeparator1) {
        this.objectSeparator1 = objectSeparator1;
    }

    public CoreObjectSeparator getObjectSeparator1() {
        return objectSeparator1;
    }

    public void setPanelHeader2(CorePanelHeader panelHeader2) {
        this.panelHeader2 = panelHeader2;
    }

    public CorePanelHeader getPanelHeader2() {
        return panelHeader2;
    }

    public void setTable1(CoreTable table1) {
        this.table1 = table1;
    }

    public CoreTable getTable1() {
        return table1;
    }

    public void setColumn5(CoreColumn column5) {
        this.column5 = column5;
    }

    public CoreColumn getColumn5() {
        return column5;
    }

    public void setOutputText12(CoreOutputText outputText12) {
        this.outputText12 = outputText12;
    }

    public CoreOutputText getOutputText12() {
        return outputText12;
    }

    public void setColumn1(CoreColumn column1) {
        this.column1 = column1;
    }

    public CoreColumn getColumn1() {
        return column1;
    }

    public void setOutputText5(CoreOutputText outputText5) {
        this.outputText5 = outputText5;
    }

    public CoreOutputText getOutputText5() {
        return outputText5;
    }

    public void setColumn2(CoreColumn column2) {
        this.column2 = column2;
    }

    public CoreColumn getColumn2() {
        return column2;
    }

    public void setOutputText9(CoreOutputText outputText9) {
        this.outputText9 = outputText9;
    }

    public CoreOutputText getOutputText9() {
        return outputText9;
    }

    public void setColumn3(CoreColumn column3) {
        this.column3 = column3;
    }

    public CoreColumn getColumn3() {
        return column3;
    }

    public void setOutputText10(CoreOutputText outputText10) {
        this.outputText10 = outputText10;
    }

    public CoreOutputText getOutputText10() {
        return outputText10;
    }

    public void setColumn4(CoreColumn column4) {
        this.column4 = column4;
    }

    public CoreColumn getColumn4() {
        return column4;
    }

    public void setOutputText11(CoreOutputText outputText11) {
        this.outputText11 = outputText11;
    }

    public CoreOutputText getOutputText11() {
        return outputText11;
    }

    public void setObjectSpacer1(CoreObjectSpacer objectSpacer1) {
        this.objectSpacer1 = objectSpacer1;
    }

    public CoreObjectSpacer getObjectSpacer1() {
        return objectSpacer1;
    }

    public void setObjectSeparator2(CoreObjectSeparator objectSeparator2) {
        this.objectSeparator2 = objectSeparator2;
    }

    public CoreObjectSeparator getObjectSeparator2() {
        return objectSeparator2;
    }

    public void setPanelHeader3(CorePanelHeader panelHeader3) {
        this.panelHeader3 = panelHeader3;
    }

    public CorePanelHeader getPanelHeader3() {
        return panelHeader3;
    }

    public void setTablaFolioEmi(CoreTable tablaFolioEmi) {
        this.tablaFolioEmi = tablaFolioEmi;
    }

    public CoreTable getTablaFolioEmi() {
        return tablaFolioEmi;
    }

    public void setPanelGroup1(HtmlPanelGroup panelGroup1) {
        this.panelGroup1 = panelGroup1;
    }

    public HtmlPanelGroup getPanelGroup1() {
        return panelGroup1;
    }

    public void setPanelButtonBar1(CorePanelButtonBar panelButtonBar1) {
        this.panelButtonBar1 = panelButtonBar1;
    }

    public CorePanelButtonBar getPanelButtonBar1() {
        return panelButtonBar1;
    }

    public void setLinkAgregar(CoreCommandLink linkAgregar) {
        this.linkAgregar = linkAgregar;
    }

    public CoreCommandLink getLinkAgregar() {
        return linkAgregar;
    }

    public void setLinkEjecutarLista(CoreCommandLink linkEjecutarLista) {
        this.linkEjecutarLista = linkEjecutarLista;
    }

    public CoreCommandLink getLinkEjecutarLista() {
        return linkEjecutarLista;
    }

    public void setTableSelectOne1(CoreTableSelectOne tableSelectOne1) {
        this.tableSelectOne1 = tableSelectOne1;
    }

    public CoreTableSelectOne getTableSelectOne1() {
        return tableSelectOne1;
    }

    public void setColumn13(CoreColumn column13) {
        this.column13 = column13;
    }

    public CoreColumn getColumn13() {
        return column13;
    }

    public void setLinkBorrar(CoreCommandLink linkBorrar) {
        this.linkBorrar = linkBorrar;
    }

    public CoreCommandLink getLinkBorrar() {
        return linkBorrar;
    }

    public void setObjectImage3(CoreObjectImage objectImage3) {
        this.objectImage3 = objectImage3;
    }

    public CoreObjectImage getObjectImage3() {
        return objectImage3;
    }

    public void setColumn12(CoreColumn column12) {
        this.column12 = column12;
    }

    public CoreColumn getColumn12() {
        return column12;
    }

    public void setLinkEditar(CoreCommandLink linkEditar) {
        this.linkEditar = linkEditar;
    }

    public CoreCommandLink getLinkEditar() {
        return linkEditar;
    }

    public void setObjectImage1(CoreObjectImage objectImage1) {
        this.objectImage1 = objectImage1;
    }

    public CoreObjectImage getObjectImage1() {
        return objectImage1;
    }

    public void setLinkFinEditar(CoreCommandLink linkFinEditar) {
        this.linkFinEditar = linkFinEditar;
    }

    public CoreCommandLink getLinkFinEditar() {
        return linkFinEditar;
    }

    public void setObjectImage2(CoreObjectImage objectImage2) {
        this.objectImage2 = objectImage2;
    }

    public CoreObjectImage getObjectImage2() {
        return objectImage2;
    }

    public void setColumn6(CoreColumn column6) {
        this.column6 = column6;
    }

    public CoreColumn getColumn6() {
        return column6;
    }

    public void setInputText1(CoreInputText inputText1) {
        this.inputText1 = inputText1;
    }

    public CoreInputText getInputText1() {
        return inputText1;
    }

    public void setOutputText13(CoreOutputText outputText13) {
        this.outputText13 = outputText13;
    }

    public CoreOutputText getOutputText13() {
        return outputText13;
    }

    public void setColumn7(CoreColumn column7) {
        this.column7 = column7;
    }

    public CoreColumn getColumn7() {
        return column7;
    }

    public void setInputText2(CoreInputText inputText2) {
        this.inputText2 = inputText2;
    }

    public CoreInputText getInputText2() {
        return inputText2;
    }

    public void setOutputText17(CoreOutputText outputText17) {
        this.outputText17 = outputText17;
    }

    public CoreOutputText getOutputText17() {
        return outputText17;
    }

    public void setColumn9(CoreColumn column9) {
        this.column9 = column9;
    }

    public CoreColumn getColumn9() {
        return column9;
    }

    public void setOutputText18(CoreOutputText outputText18) {
        this.outputText18 = outputText18;
    }

    public CoreOutputText getOutputText18() {
        return outputText18;
    }

    public void setColumn8(CoreColumn column8) {
        this.column8 = column8;
    }

    public CoreColumn getColumn8() {
        return column8;
    }

    public void setOutputText15(CoreOutputText outputText15) {
        this.outputText15 = outputText15;
    }

    public CoreOutputText getOutputText15() {
        return outputText15;
    }

    public void setColumn10(CoreColumn column10) {
        this.column10 = column10;
    }

    public CoreColumn getColumn10() {
        return column10;
    }

    public void setOutputText16(CoreOutputText outputText16) {
        this.outputText16 = outputText16;
    }

    public CoreOutputText getOutputText16() {
        return outputText16;
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

    public void setPanelHeader4(CorePanelHeader panelHeader4) {
        this.panelHeader4 = panelHeader4;
    }

    public CorePanelHeader getPanelHeader4() {
        return panelHeader4;
    }

    public void setPanelHorizontal3(CorePanelHorizontal panelHorizontal3) {
        this.panelHorizontal3 = panelHorizontal3;
    }

    public CorePanelHorizontal getPanelHorizontal3() {
        return panelHorizontal3;
    }

    public void setTablaFolioAnu(CoreTable tablaFolioAnu) {
        this.tablaFolioAnu = tablaFolioAnu;
    }

    public CoreTable getTablaFolioAnu() {
        return tablaFolioAnu;
    }

    public void setPanelGroup2(HtmlPanelGroup panelGroup2) {
        this.panelGroup2 = panelGroup2;
    }

    public HtmlPanelGroup getPanelGroup2() {
        return panelGroup2;
    }

    public void setPanelButtonBar2(CorePanelButtonBar panelButtonBar2) {
        this.panelButtonBar2 = panelButtonBar2;
    }

    public CorePanelButtonBar getPanelButtonBar2() {
        return panelButtonBar2;
    }

    public void setLinkAgregarDetalle(CoreCommandLink linkAgregarDetalle) {
        this.linkAgregarDetalle = linkAgregarDetalle;
    }

    public CoreCommandLink getLinkAgregarDetalle() {
        return linkAgregarDetalle;
    }

    public void setLinkEjecutarDetalle(CoreCommandLink linkEjecutarDetalle) {
        this.linkEjecutarDetalle = linkEjecutarDetalle;
    }

    public CoreCommandLink getLinkEjecutarDetalle() {
        return linkEjecutarDetalle;
    }

    public void setColumn21(CoreColumn column21) {
        this.column21 = column21;
    }

    public CoreColumn getColumn21() {
        return column21;
    }

    public void setLinkBorrarDetalle(CoreCommandLink linkBorrarDetalle) {
        this.linkBorrarDetalle = linkBorrarDetalle;
    }

    public CoreCommandLink getLinkBorrarDetalle() {
        return linkBorrarDetalle;
    }

    public void setObjectImage4(CoreObjectImage objectImage4) {
        this.objectImage4 = objectImage4;
    }

    public CoreObjectImage getObjectImage4() {
        return objectImage4;
    }

    public void setColumn22(CoreColumn column22) {
        this.column22 = column22;
    }

    public CoreColumn getColumn22() {
        return column22;
    }

    public void setLinkEditarDetalle(CoreCommandLink linkEditarDetalle) {
        this.linkEditarDetalle = linkEditarDetalle;
    }

    public CoreCommandLink getLinkEditarDetalle() {
        return linkEditarDetalle;
    }

    public void setObjectImage5(CoreObjectImage objectImage5) {
        this.objectImage5 = objectImage5;
    }

    public CoreObjectImage getObjectImage5() {
        return objectImage5;
    }

    public void setLinkFinEditarDetalle(CoreCommandLink linkFinEditarDetalle) {
        this.linkFinEditarDetalle = linkFinEditarDetalle;
    }

    public CoreCommandLink getLinkFinEditarDetalle() {
        return linkFinEditarDetalle;
    }

    public void setObjectImage6(CoreObjectImage objectImage6) {
        this.objectImage6 = objectImage6;
    }

    public CoreObjectImage getObjectImage6() {
        return objectImage6;
    }

    public void setColumn14(CoreColumn column14) {
        this.column14 = column14;
    }

    public CoreColumn getColumn14() {
        return column14;
    }

    public void setOutputText19(CoreOutputText outputText19) {
        this.outputText19 = outputText19;
    }

    public CoreOutputText getOutputText19() {
        return outputText19;
    }

    public void setInputText3(CoreInputText inputText3) {
        this.inputText3 = inputText3;
    }

    public CoreInputText getInputText3() {
        return inputText3;
    }

    public void setColumn15(CoreColumn column15) {
        this.column15 = column15;
    }

    public CoreColumn getColumn15() {
        return column15;
    }

    public void setOutputText20(CoreOutputText outputText20) {
        this.outputText20 = outputText20;
    }

    public CoreOutputText getOutputText20() {
        return outputText20;
    }

    public void setInputText4(CoreInputText inputText4) {
        this.inputText4 = inputText4;
    }

    public CoreInputText getInputText4() {
        return inputText4;
    }

    public void setColumn16(CoreColumn column16) {
        this.column16 = column16;
    }

    public CoreColumn getColumn16() {
        return column16;
    }

    public void setOutputText21(CoreOutputText outputText21) {
        this.outputText21 = outputText21;
    }

    public CoreOutputText getOutputText21() {
        return outputText21;
    }

    public void setInputText5(CoreInputText inputText5) {
        this.inputText5 = inputText5;
    }

    public CoreInputText getInputText5() {
        return inputText5;
    }

    public void setColumn17(CoreColumn column17) {
        this.column17 = column17;
    }

    public CoreColumn getColumn17() {
        return column17;
    }

    public void setOutputText22(CoreOutputText outputText22) {
        this.outputText22 = outputText22;
    }

    public CoreOutputText getOutputText22() {
        return outputText22;
    }

    public void setColumn18(CoreColumn column18) {
        this.column18 = column18;
    }

    public CoreColumn getColumn18() {
        return column18;
    }

    public void setOutputText23(CoreOutputText outputText23) {
        this.outputText23 = outputText23;
    }

    public CoreOutputText getOutputText23() {
        return outputText23;
    }

    public void setColumn19(CoreColumn column19) {
        this.column19 = column19;
    }

    public CoreColumn getColumn19() {
        return column19;
    }

    public void setOutputText24(CoreOutputText outputText24) {
        this.outputText24 = outputText24;
    }

    public CoreOutputText getOutputText24() {
        return outputText24;
    }

    public void setColumn20(CoreColumn column20) {
        this.column20 = column20;
    }

    public CoreColumn getColumn20() {
        return column20;
    }

    public void setOutputText25(CoreOutputText outputText25) {
        this.outputText25 = outputText25;
    }

    public CoreOutputText getOutputText25() {
        return outputText25;
    }

    public void setObjectSpacer3(CoreObjectSpacer objectSpacer3) {
        this.objectSpacer3 = objectSpacer3;
    }

    public CoreObjectSpacer getObjectSpacer3() {
        return objectSpacer3;
    }

    public void setPanelHorizontal2(CorePanelHorizontal panelHorizontal2) {
        this.panelHorizontal2 = panelHorizontal2;
    }

    public CorePanelHorizontal getPanelHorizontal2() {
        return panelHorizontal2;
    }

    public void setCommandButton5(CoreCommandButton commandButton5) {
        this.commandButton5 = commandButton5;
    }

    public CoreCommandButton getCommandButton5() {
        return commandButton5;
    }

    public void setCommandButton8(CoreCommandButton commandButton8) {
        this.commandButton8 = commandButton8;
    }

    public CoreCommandButton getCommandButton8() {
        return commandButton8;
    }

    public void setCommandButton3(CoreCommandButton commandButton3) {
        this.commandButton3 = commandButton3;
    }

    public CoreCommandButton getCommandButton3() {
        return commandButton3;
    }

    public void setCommandButton6(CoreCommandButton commandButton6) {
        this.commandButton6 = commandButton6;
    }

    public CoreCommandButton getCommandButton6() {
        return commandButton6;
    }

    public void setId_btn_reprocesar(CoreCommandButton id_btn_reprocesar) {
        this.id_btn_reprocesar = id_btn_reprocesar;
    }

    public CoreCommandButton getId_btn_reprocesar() {
        return id_btn_reprocesar;
    }

    public void setCommandButton1(CoreCommandButton commandButton1) {
        this.commandButton1 = commandButton1;
    }

    public CoreCommandButton getCommandButton1() {
        return commandButton1;
    }

    public void setObjectSpacer2(CoreObjectSpacer objectSpacer2) {
        this.objectSpacer2 = objectSpacer2;
    }

    public CoreObjectSpacer getObjectSpacer2() {
        return objectSpacer2;
    }

    public void setBtn_autorizar(CoreCommandButton btn_autorizar) {
        this.btn_autorizar = btn_autorizar;
    }

    public CoreCommandButton getBtn_autorizar() {
        return btn_autorizar;
    }

    public void setCommandButton2(CoreCommandButton commandButton2) {
        this.commandButton2 = commandButton2;
    }

    public CoreCommandButton getCommandButton2() {
        return commandButton2;
    }

    public void setCommandButton4(CoreCommandButton commandButton4) {
        this.commandButton4 = commandButton4;
    }

    public CoreCommandButton getCommandButton4() {
        return commandButton4;
    }

    public void setShowDetailItem2(CoreShowDetailItem showDetailItem2) {
        this.showDetailItem2 = showDetailItem2;
    }

    public CoreShowDetailItem getShowDetailItem2() {
        return showDetailItem2;
    }

    public void setTable2(CoreTable table2) {
        this.table2 = table2;
    }

    public CoreTable getTable2() {
        return table2;
    }

    public void setColumn23(CoreColumn column23) {
        this.column23 = column23;
    }

    public CoreColumn getColumn23() {
        return column23;
    }


    public void setColumn24(CoreColumn column24) {
        this.column24 = column24;
    }

    public CoreColumn getColumn24() {
        return column24;
    }

    public void setOutputText29(CoreOutputText outputText29) {
        this.outputText29 = outputText29;
    }

    public CoreOutputText getOutputText29() {
        return outputText29;
    }

    public void setColumn25(CoreColumn column25) {
        this.column25 = column25;
    }

    public CoreColumn getColumn25() {
        return column25;
    }

    public void setOutputText30(CoreOutputText outputText30) {
        this.outputText30 = outputText30;
    }

    public CoreOutputText getOutputText30() {
        return outputText30;
    }

    public void setColumn26(CoreColumn column26) {
        this.column26 = column26;
    }

    public CoreColumn getColumn26() {
        return column26;
    }

    public void setOutputText31(CoreOutputText outputText31) {
        this.outputText31 = outputText31;
    }

    public CoreOutputText getOutputText31() {
        return outputText31;
    }


    public void setColumn28(CoreColumn column28) {
        this.column28 = column28;
    }

    public CoreColumn getColumn28() {
        return column28;
    }

    public void setOutputText33(CoreOutputText outputText33) {
        this.outputText33 = outputText33;
    }

    public CoreOutputText getOutputText33() {
        return outputText33;
    }

    public void setCommandLink1(CoreCommandLink commandLink1) {
        this.commandLink1 = commandLink1;
    }

    public CoreCommandLink getCommandLink1() {
        return commandLink1;
    }

    public void setOutputText28(CoreOutputText outputText28) {
        this.outputText28 = outputText28;
    }

    public CoreOutputText getOutputText28() {
        return outputText28;
    }

    public void setObjectSpacer4(CoreObjectSpacer objectSpacer4) {
        this.objectSpacer4 = objectSpacer4;
    }

    public CoreObjectSpacer getObjectSpacer4() {
        return objectSpacer4;
    }


    public void setPanelHorizontal4(CorePanelHorizontal panelHorizontal4) {
        this.panelHorizontal4 = panelHorizontal4;
    }

    public CorePanelHorizontal getPanelHorizontal4() {
        return panelHorizontal4;
    }

    public void setPlan_presta(CoreCommandButton commandButton41) {
        this.plan_presta = commandButton41;
    }

    public CoreCommandButton getPlan_presta() {
        return plan_presta;
    }

    public void setCommandButton9(CoreCommandButton commandButton9) {
        this.commandButton9 = commandButton9;
    }

    public CoreCommandButton getCommandButton9() {
        return commandButton9;
    }

    public void setCommandButton11(CoreCommandButton commandButton11) {
        this.commandButton11 = commandButton11;
    }

    public CoreCommandButton getCommandButton11() {
        return commandButton11;
    }

    public void setCommandButton12(CoreCommandButton commandButton12) {
        this.commandButton12 = commandButton12;
    }

    public CoreCommandButton getCommandButton12() {
        return commandButton12;
    }

    public void setCommandButton13(CoreCommandButton commandButton13) {
        this.commandButton13 = commandButton13;
    }

    public CoreCommandButton getCommandButton13() {
        return commandButton13;
    }

    public void setCommandButton14(CoreCommandButton commandButton14) {
        this.commandButton14 = commandButton14;
    }

    public CoreCommandButton getCommandButton14() {
        return commandButton14;
    }
}
