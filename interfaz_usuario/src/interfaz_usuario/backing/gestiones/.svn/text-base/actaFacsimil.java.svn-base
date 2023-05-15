package interfaz_usuario.backing.gestiones;

import enlace_datos.consultas.gestiones.anexo.consul_plazaXempleado_vwRowImpl;

import enlace_datos.consultas.gestiones.cheques.SisChequeDescartadoVwRowImpl;
import enlace_datos.consultas.gestiones.cheques.consul_cheque_descartado_vwRowImpl;

import enlace_datos.util.resulOp;

import interfaz_usuario.util.JSFUtils;

import interfaz_usuario.util.utils;

import java.util.Iterator;

import java.util.List;

import javax.faces.context.FacesContext;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.faces.component.core.data.CoreTable;
import oracle.adf.view.faces.component.core.input.CoreInputText;

import oracle.adf.view.faces.component.core.layout.CoreShowDetailItem;
import oracle.adf.view.faces.component.core.nav.CoreCommandButton;

import oracle.adf.view.faces.component.core.nav.CoreCommandLink;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.JboException;
import oracle.jbo.Key;
import oracle.jbo.NameValuePairs;
import oracle.jbo.RowSetIterator;
import oracle.jbo.uicli.binding.JUIteratorBinding;

public class actaFacsimil {
    private CoreInputText chequeInicial;
    private CoreInputText chequeFinal;
    private CoreTable varTablDescartado;
    public boolean sueldoCuenta = false;
    private BindingContainer bindings;
    private CoreCommandButton imprimir_acta;
    private CoreCommandButton crearComision;
    private CoreCommandButton aceptarComision;
    private CoreCommandButton borrarComision;
    private CoreCommandButton crear_cheqRevisar;
    private CoreCommandButton aceptaCheqRevisar;
    private CoreCommandButton btn_generarSis_22;
    private CoreCommandLink cmd_link_sis_22;
    private CoreShowDetailItem pnl_historico;
    private CoreShowDetailItem pnl_detalle;

    public actaFacsimil() {
        
    }

    public void setChequeInicial(CoreInputText chequeInicial) {
        this.chequeInicial = chequeInicial;
    }

    public CoreInputText getChequeInicial() {
        return chequeInicial;
    }

    public void setChequeFinal(CoreInputText chequeFinal) {
        this.chequeFinal = chequeFinal;
    }

    public CoreInputText getChequeFinal() {
        return chequeFinal;
    }

    public String bt_anular_cheque() {
        // Add event code here...
       // JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.PchequeInicial1.inputValue}",this.chequeInicial.getValue());
        //JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.PchequeFinal1.inputValue}",this.chequeInicial.getValue());
        List vErrores;
        JboException vError;
        if ((this.chequeInicial.getValue() == null) ||(this.chequeInicial.getValue() != null && this.chequeInicial.getValue().equals(""))){
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"DEBE INGRESAR UN NO. DE CHEQUE INICIAL"));
        }
        else{
            vErrores=JSFUtils.EjecutarAcccion3(FacesContext.getCurrentInstance(),"facsimil_anulacheque");
            if (vErrores.size()>0){ //existe errores en la ejecucion de la accion
             if (vErrores.get(0).getClass()==JboException.class){
                 vError=(JboException)vErrores.get(0);
                 utils.setADFMensajetoControl(new resulOp(resulOp.OPE_ERROR,vError.getMessage()),utils.getNomControlCliente(this.getChequeInicial())); 
                 
             }
                
            }
            
        }
        this.chequeInicial.setValue("");
        this.chequeFinal.setValue("");
        return null;
    }
//metodo utilizado para agregar los cheques anulados por problemas en el formulario 
//standard al acta facsimil.
    public String btn_chequeDescartado() {
        // Add event code here...
        Iterator valIterador;
        Key llave;        
        consul_cheque_descartado_vwRowImpl valFila;
        JUIteratorBinding vIterBinding;
        RowSetIterator vBinding;       
        valIterador = varTablDescartado.getSelectionState().getKeySet().iterator();
        vIterBinding=(JUIteratorBinding)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.consul_cheque_descartado_vw1Iterator}");
        vBinding=vIterBinding.getRowSetIterator();
        Object valIdacta = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdActaFacsimil.inputValue}");
        while(valIterador.hasNext()){
            llave =  (Key) valIterador.next();
            valFila=(consul_cheque_descartado_vwRowImpl)vBinding.getRow(llave);
            valFila.setIdActaFacsimil(utils.getNumberOracle(valIdacta));
           
            
            System.out.println("lo que tiene el select " + valFila.getIdChequeDescartado());
        }
        //JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"Execute");
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Execute");
        return null;
       
    }

    public void setVarTablDescartado(CoreTable varTablDescartado) {
        this.varTablDescartado = varTablDescartado;
    }

    public CoreTable getVarTablDescartado() {
        return varTablDescartado;
    }

    public String btn_borrar_cheqDescartado() {
        // Add event code here...
         Iterator valIterador;
         Key llave; 
         SisChequeDescartadoVwRowImpl valFila;
         JUIteratorBinding vIterBinding;
         RowSetIterator vBinding;       
         valIterador = varTablDescartado.getSelectionState().getKeySet().iterator();
         vIterBinding=(JUIteratorBinding)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.SisChequeDescartadoVw1Iterator}");
         vBinding=vIterBinding.getRowSetIterator();
         
         if(valIterador.hasNext()){
             llave =  (Key) valIterador.next();
             valFila=(SisChequeDescartadoVwRowImpl)vBinding.getRow(llave);
             valFila.setIdActaFacsimil(null);
             valFila.setAnio(null);
             
             
             System.out.println("lo que tiene el select " + valFila.getIdChequeDescartado());
         }
         //JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"Execute");
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Execute");
        return null;
    }

    public void cambia_banco(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        
         this.sueldoCuenta = true;
    }
    
    public boolean getSueldoCuenta ()
    { 
        return sueldoCuenta;
    }

    public BindingContainer getBindings() {
        return this.bindings;
    }

    public void setBindings(BindingContainer bindings) {
        this.bindings = bindings;
    }

    public String btn_guardar_acta() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = 
            bindings.getOperationBinding("Commit");
        Object result = operationBinding.execute();
       
        if (operationBinding.getErrors().isEmpty()) {
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ExeDocPagoAnualdo");
            this.imprimir_acta.setDisabled(false);
            this.getBtn_generarSis_22().setDisabled(false);
            utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Datos guardados correctamente."));
            //this.cmd_link_sis_22.setDisabled(false);
        }
        
        return null;
    }

    public void setImprimir_acta(CoreCommandButton imprimir_acta) {
        this.imprimir_acta = imprimir_acta;
    }

    public CoreCommandButton getImprimir_acta() {
        return imprimir_acta;
    }

    public void setCrearComision(CoreCommandButton crearComision) {
        this.crearComision = crearComision;
    }

    public CoreCommandButton getCrearComision() {
        return crearComision;
    }

    public void setAceptarComision(CoreCommandButton aceptarComision) {
        this.aceptarComision = aceptarComision;
    }

    public CoreCommandButton getAceptarComision() {
        return aceptarComision;
    }

    public void setBorrarComision(CoreCommandButton borrarComision) {
        this.borrarComision = borrarComision;
    }

    public CoreCommandButton getBorrarComision() {
        return borrarComision;
    }
//meto utilizado para agregar un miembro en la comision Facsimile
    public String btn_crear_comision() {        
        BindingContainer bindings = getBindings();        
        OperationBinding operationBinding = 
        bindings.getOperationBinding("Create2");        
        Object result = operationBinding.execute();
        this.crearComision.setDisabled(true);
        this.aceptarComision.setDisabled(false);
        this.borrarComision.setDisabled(true);
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        return null;
    }
//meto utilizado para establecer y aceptar un miembro en la comision facsimile
    public String btn_aceptar_comision() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = 
            bindings.getOperationBinding("Execute1");
        Object result = operationBinding.execute();
        this.crearComision.setDisabled(false);
        this.borrarComision.setDisabled(false);
        this.aceptarComision.setDisabled(true);
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        return null;
    }
//metodo utilizado para agregar los cheques que se observaron en la impresion facsimile
    public String bt_crearCheqRevisar() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = 
            bindings.getOperationBinding("Create1");
        Object result = operationBinding.execute();
        this.aceptaCheqRevisar.setDisabled(false);
        this.crear_cheqRevisar.setDisabled(true);
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        return null;
    }

    public void setCrear_cheqRevisar(CoreCommandButton crear_cheqRevisar) {
        this.crear_cheqRevisar = crear_cheqRevisar;
    }

    public CoreCommandButton getCrear_cheqRevisar() {
        return crear_cheqRevisar;
    }

    public void setAceptaCheqRevisar(CoreCommandButton aceptaCheqRevisar) {
        this.aceptaCheqRevisar = aceptaCheqRevisar;
    }

    public CoreCommandButton getAceptaCheqRevisar() {
        return aceptaCheqRevisar;
    }
//metodo utilizado para establecer los cheques revisados en la impresion facsimile
    public String bt_aceptarCheqRevisar() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = 
            bindings.getOperationBinding("Execute2");        
        Object result = operationBinding.execute();
        this.crear_cheqRevisar.setDisabled(false); 
        this.aceptaCheqRevisar.setDisabled(true);
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        return null;
    }

    public String btn_gensis_22_action() {
      
        boolean vResultado;
        Object vValor;
        vResultado=JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"generarSis_22");
    //    JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.FechaCreacion.inputValue}");
        vValor=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdSis_22.inputValue}");

            if (vResultado==true && vValor !=null){
               JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ExeDocPagoAnualdo"); 
               utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"SIS-22 generado.")); 
               this.cmd_link_sis_22.setDisabled(false);
            }else{
                utils.setADFMensaje(new resulOp(resulOp.OPE_WARN,"No se encontraron datos para generar el SIS-22."));   
            }
             
        return null;
    }

    public void setBtn_generarSis_22(CoreCommandButton btn_generarSis_22) {
        this.btn_generarSis_22 = btn_generarSis_22;
    }

    public CoreCommandButton getBtn_generarSis_22() {
        return btn_generarSis_22;
    }

    public void setCmd_link_sis_22(CoreCommandLink cmd_link_sis_22) {
        this.cmd_link_sis_22 = cmd_link_sis_22;
    }

    public CoreCommandLink getCmd_link_sis_22() {
        return cmd_link_sis_22;
    }

    public String btn_nuevo() {
        // Add event code here...
        Object vActa;
        
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"reset");
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Create"))
        {
           
          // vActa=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdActaFacsimil.inputValue}");
/*                    
          JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Execute2");
          JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Execute1");
          JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Execute");
          */  
          this.pnl_historico.setDisclosed(false);
          this.pnl_detalle.setDisclosed(true);
            
        }
        
        return null;
    }

    public void setPnl_historico(CoreShowDetailItem pnl_historico) {
        this.pnl_historico = pnl_historico;
    }

    public CoreShowDetailItem getPnl_historico() {
        return pnl_historico;
    }

    public void setPnl_detalle(CoreShowDetailItem pnl_detalle) {
        this.pnl_detalle = pnl_detalle;
    }

    public CoreShowDetailItem getPnl_detalle() {
        return pnl_detalle;
    }

    public String cmd_verDetalle() {
    
    
      if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"SetActa")){
          this.pnl_historico.setDisclosed(false);
          this.pnl_detalle.setDisclosed(true);  
          
      }
        // Add event code here...
        return null;
    }

    public String btn_cancelar() {
    
    
       JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Rollback");
       JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"quitarFiltros");
        this.pnl_detalle.setDisclosed(false);  
        this.pnl_historico.setDisclosed(true);
        
        return null;
    }

    public String btn_generarReposicion() {
        // Add event code here...
        
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"generarReposicion")){
            
            utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Reposicion generada exitosamente."));
        }
        
        return null;
    }
}
