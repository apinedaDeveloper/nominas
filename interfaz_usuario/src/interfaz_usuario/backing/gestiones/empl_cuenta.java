package interfaz_usuario.backing.gestiones;

import enlace_datos.consultas.QUERRYSImpl;
import enlace_datos.consultas.gestiones.empleado.SisCuentaVwImpl;

import enlace_datos.util.resulOp;

import interfaz_usuario.servlets.ConsulJson;

import interfaz_usuario.usuario;

import interfaz_usuario.util.JSFUtils;
import interfaz_usuario.util.utils;

import javax.faces.context.FacesContext;

import javax.faces.el.ValueBinding;
import javax.faces.event.ActionEvent;

import javax.servlet.http.HttpServlet;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCDataControl;
import oracle.adf.view.faces.component.core.input.CoreInputText;
import oracle.adf.view.faces.component.core.input.CoreSelectInputDate;
import oracle.adf.view.faces.component.core.input.CoreSelectOneChoice;

import oracle.adf.view.faces.component.core.layout.CoreShowDetailItem;
import oracle.adf.view.faces.component.core.nav.CoreCommandButton;
import oracle.adf.view.faces.component.core.nav.CoreCommandLink;
import oracle.adf.view.faces.component.core.output.CoreOutputFormatted;
import oracle.adf.view.faces.event.AttributeChangeEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;

public class empl_cuenta {
    private CoreSelectOneChoice cmb_banco;
    private CoreInputText inpt_cuenta;
    private CoreSelectInputDate inpt_fecha_baja;
    private BindingContainer bindings;
    private CoreShowDetailItem shw_detail_cheque;
    private CoreShowDetailItem shw_datail_acred;
    private CoreOutputFormatted txtOK;
    private CoreCommandButton btn_guardar;
    private CoreOutputFormatted vvalidar;
    private CoreInputText txtOK2;
    private CoreCommandButton btn_actualizar;

    public empl_cuenta() {
    }

    public String getSeleccionado(){
     String vSeleccionado=null;
        if (this.getShw_detail_cheque().isDisclosed())
          vSeleccionado="CHEQUE";
        else if (this.getShw_datail_acred().isDisclosed())
          vSeleccionado="ACREDITACION";
      
     return vSeleccionado;     
    }

    public boolean getExisteCuentaActiva()
    {
        FacesContext fc = FacesContext.getCurrentInstance();
        ValueBinding vb = fc.getApplication().createValueBinding("#{data}");
        BindingContext bc = (BindingContext)vb.getValue(fc);
        // en la siguiente línea poner en el parámetro el nombre del application module más "DataControl", en este ejemplo el application module se llama: AppModule
        DCDataControl dc  = bc.findDataControl("QUERRYSDataControl");
        ApplicationModule am = (ApplicationModule)dc.getDataProvider();
        QUERRYSImpl sicAppModule = (QUERRYSImpl)am;   
        SisCuentaVwImpl vo = (SisCuentaVwImpl) am.findViewObject("SisCuentaVw");
        Row r = vo.first();
        int i=0;
        boolean encontrado=false;
        
        while (i<=vo.getEstimatedRowCount() && !encontrado)
        {
            if (r.getAttribute("FechaBaja").equals(null))
              encontrado = true;
            i++;
            r=vo.next();
        }
        return encontrado;
    }

   

    public void setCmb_banco(CoreSelectOneChoice cmb_banco) {
        this.cmb_banco = cmb_banco;
    }

    public CoreSelectOneChoice getCmb_banco() {
        return cmb_banco;
    }

    public void setInpt_cuenta(CoreInputText inpt_cuenta) {
        this.inpt_cuenta = inpt_cuenta;
    }

    public CoreInputText getInpt_cuenta() {
        return inpt_cuenta;
    }

    public void setInpt_fecha_baja(CoreSelectInputDate inpt_fecha_baja) {
        this.inpt_fecha_baja = inpt_fecha_baja;
    }

    public CoreSelectInputDate getInpt_fecha_baja() {
        return inpt_fecha_baja;
    }

    public String btn_agregar_cuenta() {
        // Add event code here...
       // this.cmb_banco.setDisabled(false);
       // this.inpt_cuenta.setDisabled(false);
        return null;
    }

    public BindingContainer getBindings() {
        return this.bindings;
    }

    public void setBindings(BindingContainer bindings) {
        this.bindings = bindings;
    }
    

    public String btn_guardar_Action() {
        BindingContainer vBnd_binding;
        OperationBinding operationBinding;
        Object result;
        resulOp vResultado=new resulOp();
        boolean vResultadoOp=false;
        ActualizarFormaPago();

        vBnd_binding=(BindingContainer)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings}");
        operationBinding=vBnd_binding.getOperationBinding("Commit");
        result=operationBinding.execute();  
        if (operationBinding.getErrors().isEmpty()){
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Execute");
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"EjeCuentasActivas");
            JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Execute1");
            vResultado.setMensajeError("Datos guardados correctamente");
            vResultado.setCodigoResultado(resulOp.OPE_OK);
            utils.setADFMensaje(vResultado);
            vResultadoOp=true;
        }
  /*      else
        {
            vResultado.setMensajeError("Error: No se pudieron guardar los datos.");
            vResultado.setCodigoResultado(resulOp.OPE_ERROR);
            utils.setADFMensaje(vResultado);
            
        }
   */     
        if (vResultadoOp){
            return null;
        }else{
            return null;
        }
        
    }


    public void setShw_detail_cheque(CoreShowDetailItem shw_detail_cheque) {
        this.shw_detail_cheque = shw_detail_cheque;
    }

    public CoreShowDetailItem getShw_detail_cheque() {
        return shw_detail_cheque;
    }

    public void setShw_datail_acred(CoreShowDetailItem shw_datail_acred) {
        this.shw_datail_acred = shw_datail_acred;
    }

    public CoreShowDetailItem getShw_datail_acred() {
        return shw_datail_acred;
    }

    public String btn_actualizar_formaPago() {
      //  System.out.println(this.getSeleccionado());
        ActualizarFormaPago();
        // Add event code here...
        return null;
    }
    
    public void ActualizarFormaPago(){
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.TipoPago.inputValue}",this.getSeleccionado());
        
    }

    public void agregar_Action(ActionEvent actionEvent) {
        // Add event code here...
         JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"CrearFormaPago");
         ActualizarFormaPago();
    }

    public String commandLink_action() {
        // Add event code here...
        
        
        return null;
    }

    public void setTxtOK(CoreOutputFormatted txtOK) {
        this.txtOK = txtOK;
    }

    public CoreOutputFormatted getTxtOK() {
        return txtOK;
    }

    public String activarGuardar()
    {
        this.btn_guardar.setDisabled(false);
        /*resulOp vResultado=new resulOp();
        vResultado.setMensajeError("Cuenta Validada Exitosamente !");
        vResultado.setCodigoResultado(resulOp.OPE_OK);
        utils.setADFMensaje(vResultado
        */
        return null;
    }

    public String desactivarGuardar()
    {
        this.btn_guardar.setDisabled(true);
        return null;
    }

    public String btn_actualizar_action() {
       
      //if (this.getTxtOK().getValue().equals("1"))
     // {
        try {
        
            BindingContainer bindings = getBindings();
            OperationBinding operationBinding = bindings.getOperationBinding("Execute");
            Object result = operationBinding.execute();
            if (operationBinding.getErrors().isEmpty())
            {
                this.btn_guardar.setDisabled(false);
                System.out.println("actualizacion con exito");
            }
            else
            {
                System.out.println("actualizacion con error");
                this.btn_guardar.setDisabled(true);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setBtn_guardar(CoreCommandButton btn_guardar) {
        this.btn_guardar = btn_guardar;
    }

    public CoreCommandButton getBtn_guardar() {
        return btn_guardar;
    }

    public void cuentaValidada(AttributeChangeEvent attributeChangeEvent) {
        // Add event code here...
    }

    public void setVvalidar(CoreOutputFormatted vvalidar) {
        this.vvalidar = vvalidar;
    }

    public CoreOutputFormatted getVvalidar() {
        return vvalidar;
    }

    public void setTxtOK2(CoreInputText txtOK2) {
        this.txtOK2 = txtOK2;
    }

    public CoreInputText getTxtOK2() {
        return txtOK2;
    }

    public void setBtn_actualizar(CoreCommandButton btn_actualizar) {
        this.btn_actualizar = btn_actualizar;
    }

    public CoreCommandButton getBtn_actualizar() {
        return btn_actualizar;
    }

}
