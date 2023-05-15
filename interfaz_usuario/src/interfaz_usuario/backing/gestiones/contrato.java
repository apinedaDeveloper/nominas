package interfaz_usuario.backing.gestiones;



import enlace_datos.tablas.SisAjuste;
import enlace_datos.tablas.SisAjusteContrato;
import enlace_datos.tablas.SisAjusteEmpleado;
import enlace_datos.tablas.SisContrato;

import enlace_datos.util.resulOp;
//import enlace_datos.util.utils;

import interfaz_usuario.usuario;

import interfaz_usuario.util.JSFUtils;
import interfaz_usuario.util.reporteParams;
import interfaz_usuario.util.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import java.util.Vector;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import javax.faces.model.SelectItem;

import javax.faces.validator.ValidatorException;

import oracle.adf.view.faces.component.core.data.CoreTable;
import oracle.adf.view.faces.component.core.data.CoreTableSelectOne;
import oracle.adf.view.faces.component.core.input.CoreInputText;
import oracle.adf.view.faces.component.core.input.CoreSelectInputDate;
import oracle.adf.view.faces.component.core.input.CoreSelectOneChoice;
import oracle.adf.view.faces.component.core.layout.CoreShowDetailItem;

import oracle.adf.view.faces.component.core.output.CoreMessage;
import oracle.adf.view.faces.component.core.output.CoreOutputText;
import oracle.adf.view.faces.context.AdfFacesContext;
import oracle.adf.view.faces.event.AttributeChangeEvent;

import oracle.adf.view.faces.event.DisclosureEvent;

import oracle.adfinternal.view.faces.model.binding.FacesCtrlListBinding;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.uicli.binding.JUCtrlValueBindingRef;


public class contrato {
    int vInt_ComboPuesto=0;
    private CoreShowDetailItem pnl_detail_acta;
    private CoreShowDetailItem pnl_detail_puesto;
    private CoreSelectOneChoice cmb_departamento;
    private UISelectItems item_Departamento;
    private CoreShowDetailItem pnl_detail_tram_sueldo;
    private CoreShowDetailItem pnl_datos;
    private CoreInputText inp_sueldo_base;
    private CoreTable tbl_plazas;
    private ArrayList parametrosExtras;
    private Vector parametrosDesc;
    private CoreInputText inp_registro_empleado;
    private CoreInputText inp_horas_contratadas;
    private CoreInputText inp_sueldo_base2;
    private CoreSelectInputDate inpt_fecha_i;
    private CoreSelectInputDate inpt_fecha_f;
    private CoreTable tbl_descuentos;
    private CoreTableSelectOne select_one_prueba;
    private CoreOutputText outresultado;
    private CoreInputText inpt_horaE;
    private CoreInputText inpt_horaF;
    private CoreInputText inpHoraEntr;
    private CoreInputText inpHoraSal;
    private BindingContainer bindings;
    private CoreMessage mensaje1;


    public contrato() {
     if (!AdfFacesContext.getCurrentInstance().isPostback()){
         /*
         SisContrato vContrato;
         
         vContrato=(SisContrato)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.contrato_by_id.result['0']}");
            if (vContrato.getSisAjusteContratoCollection().size()>0){ //Si el contrato ya tiene ajustes se ingresan a la tabla
                JSFUtils.setManagedBeanValue(FacesContext.getCurrentInstance(),"tabla_ajustes.list",vContrato.getSisAjusteContratoCollection());
            } 
            if (vContrato.getSisEmpleado()!=null){
                if (vContrato.getSisEmpleado().getSisAjusteEmpleadoCollection().size()>0){
                 JSFUtils.setManagedBeanValue(FacesContext.getCurrentInstance(),"tabla_ajustes.listAg",vContrato.getSisEmpleado().getSisAjusteEmpleadoCollection());
                                                                                        }           
                                     }
                                     */
     }
    
    }

   public int getIdComboPuesto(){
       return vInt_ComboPuesto;
       
   }

 public Vector getParametrosDesc(){
     return this.parametrosDesc;
 }

  public ArrayList getParametros(){
      return parametrosExtras;
  }
    public void cmb_dependencia_action(ValueChangeEvent valueChangeEvent) {
        // Add event code here...       
        vInt_ComboPuesto=1;
        limpiar_descuentos_contrato();
    }

    public void cmb_unidad_action(ValueChangeEvent valueChangeEvent) {
        
         vInt_ComboPuesto=2;
        limpiar_descuentos_contrato();
    }

    public String tbl_action() {
        // Add event code here...
         vInt_ComboPuesto=3;
        return null;
    }



    public void setPnl_detail_acta(CoreShowDetailItem pnl_detail_acta) {
        this.pnl_detail_acta = pnl_detail_acta;
    }

    public CoreShowDetailItem getPnl_detail_acta() {
        return pnl_detail_acta;
    }

    public void setPnl_detail_puesto(CoreShowDetailItem pnl_detail_puesto) {
        this.pnl_detail_puesto = pnl_detail_puesto;
    }

    public CoreShowDetailItem getPnl_detail_puesto() {
        return pnl_detail_puesto;
    }

    public void cmb_departamentos_cambio(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        
        /*
         *  Obteniendo el departamento seleccionado
         */
        Object []vAryl_DatosCombo;
        List <FacesCtrlListBinding> vClb_itemsValue;
        vClb_itemsValue=(List <FacesCtrlListBinding>)this.item_Departamento.getValue();
        vAryl_DatosCombo=vClb_itemsValue.toArray();
         
        SelectItem vSlct_seleccionado;
        vSlct_seleccionado=(SelectItem)vAryl_DatosCombo[Integer.parseInt(this.cmb_departamento.getValue().toString())];       
        //System.out.println("cambiado el departamento" +vSlct_seleccionado.getLabel()); 
        usuario.set_opciones(usuario.SEL_DEPTO,vSlct_seleccionado.getLabel()); 
          
        /*
         * Ejecutando la consulta de municipios por el departamento
         */
        BindingContainer vBnd_binding;
        OperationBinding operationBinding;
        Object result;
                            
         vBnd_binding=(BindingContainer)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings}");
         operationBinding=vBnd_binding.getOperationBinding("muni_no_Post");
         result=operationBinding.execute();
    }

    public void setCmb_departamento(CoreSelectOneChoice cmb_departamento) {
        this.cmb_departamento = cmb_departamento;
    }

    public CoreSelectOneChoice getCmb_departamento() {
        return cmb_departamento;
    }

    public void setItem_Departamento(UISelectItems item_Departamento) {
        this.item_Departamento = item_Departamento;
    }

    public UISelectItems getItem_Departamento() {
        return item_Departamento;
    }

    public String btn_acta_sig_action() {
        // Add event code here...
         this.pnl_detail_acta.setDisclosed(false);
         this.pnl_detail_tram_sueldo.setDisclosed(true);
         obtenerDescuentos();
        return null;
    }

    public void setPnl_detail_tram_sueldo(CoreShowDetailItem pnl_detail_tram_sueldo) {
        this.pnl_detail_tram_sueldo = pnl_detail_tram_sueldo;
    }

    public CoreShowDetailItem getPnl_detail_tram_sueldo() {
        return pnl_detail_tram_sueldo;
    }

    public void setPnl_datos(CoreShowDetailItem pnl_datos) {
        this.pnl_datos = pnl_datos;
    }

    public CoreShowDetailItem getPnl_datos() {
        return pnl_datos;
    }

    public String btn_datos_sig() {
        // Add event code here...
         this.pnl_datos.setDisclosed(false);
         this.pnl_detail_puesto.setDisclosed(true);
        return null;
    }
/*
 * 
 * Metodo para guardar los datos del contrato
 */
    public String btn_guardar_action() {
        // Add event code here...
        
         int vistaCont,vHorasPlaza;
         SisContrato vContrato;
         long registro_empleado;
         vistaCont=(Integer)JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.vistaContrato");  
         JUCtrlValueBindingRef tableRowRef;
         Double vsal_base;
         if (vistaCont==0||vistaCont==3){
            vContrato=(SisContrato)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.contrato_by_id.result['0']}");
            tableRowRef =
            (JUCtrlValueBindingRef) this.tbl_plazas.getSelectedRowData();
           
             if (vContrato!=null && tableRowRef!=null){

                 vHorasPlaza=utils.getInteger(tableRowRef.getRow().getAttribute("CantidadHoras"));
                 vsal_base=utils.getDouble1(tableRowRef.getRow().getAttribute("SalarioBasepuesto"));
                 
                 /*
                  *  Verificando si las horas de la plaza y las definidadas en el horario coinciden
                  */
                 if (vHorasPlaza==vContrato.getNumHoras()){
                     
                     if (vsal_base.doubleValue()<=0){ // Si el sueldo base es cero
                         vsal_base=utils.getDouble1(this.inp_sueldo_base2.getValue());
                        
                        if (vsal_base<=0){
                            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR," EL SUELDO BASE NO PUEDE MENOR O IGUAL A CERO"));
                            return null;
                        }
                     }   
                     vContrato.setSueldobase(vsal_base);  
                    
                    if (inp_registro_empleado.getValue()!=null)
                         registro_empleado=new Long(inp_registro_empleado.getValue().toString());
                    else
                         registro_empleado=new Long(JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.selRegEmpleado").toString());
                 
                    vContrato.setRegistroEmpleado(registro_empleado);
                 
                    vContrato.setIdPartida(utils.getInteger(tableRowRef.getRow().getAttribute("IdPartida")));
                    vContrato.setIdPuesto(utils.getInteger(tableRowRef.getRow().getAttribute("IdPuesto")));
                    vContrato.setNumeroPlaza(utils.getInteger(tableRowRef.getRow().getAttribute("NumeroPlaza")));
                    vContrato.setCorrelativo(utils.getInteger(tableRowRef.getRow().getAttribute("Correlativo")));
                    //vContrato.setHorascontratadas(vContrato.getNumHoras());
                    
                    
                 }else {
                     utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"EL NUMERO DE HORAS DEL CONTRATO NO COINCIDE CON LA PLAZA"));
                     return null;
                 }
                 
             }
         parametrosExtras= new ArrayList();
         }
         BindingContainer vBnd_binding;
         OperationBinding operationBinding;
         Object result;
         resulOp vResultado;
                             
          vBnd_binding=(BindingContainer)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings}");
          operationBinding=vBnd_binding.getOperationBinding("crear_contrato");
          //result=operationBinding.execute();
          
          vResultado=(resulOp)operationBinding.execute();
          utils.setADFMensaje(vResultado);
           
            if (vResultado.getCodigoResultado()==resulOp.OPE_OK){
                usuario.set_opciones(usuario.VISTA_CONTRATO,1);
                vContrato=(SisContrato)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.contrato_by_id.result['0']}");
                usuario.set_opciones(usuario.SEL_CONTRATO,vContrato.getIdContrato()); 
               // System.out.println(vContrato.getIdContrato());
                return "ver_contrato";
            }
    return null;   
    }


/*
 * Metodo para calcular el sueldo de acuerdo a datos de plaza y horas por trabajar
 */
    private void calcular_sueldo(){
        Double vsal_base=null;
        Integer vhoras_cont,vhoras_plaza;
        double vsueldo_mensual;
        
        JUCtrlValueBindingRef tableRowRef =
        (JUCtrlValueBindingRef) this.tbl_plazas.getSelectedRowData();
        
        // Salario base
        vsal_base=utils.getDouble1(tableRowRef.getRow().getAttribute("SalarioBasepuesto"));
        // Horas Contratadas
         SisContrato vContrato;
         vContrato=(SisContrato)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.contrato_by_id.result['0']}");
        // vhoras_cont=vContrato.getNumHoras();
         vhoras_plaza=utils.getInteger(tableRowRef.getRow().getAttribute("CantidadHoras"));
        /*
        if (vhoras_cont>vhoras_plaza){
            vhoras_cont=vhoras_plaza;
            this.inp_horas_contratadas.setValue(vhoras_cont.toString());
        }
        */
        if (vsal_base.doubleValue()<=0){
            vsal_base=Double.parseDouble(this.inp_sueldo_base2.getValue().toString());
        }
        vsueldo_mensual=vsal_base.doubleValue();//(vsal_base.doubleValue()/vhoras_plaza.intValue())*vhoras_cont.intValue();
        
        this.inp_sueldo_base.setValue(vsueldo_mensual);
        
    }
    public void setInp_sueldo_base(CoreInputText inp_sueldo_base) {
        this.inp_sueldo_base = inp_sueldo_base;
    }

    public CoreInputText getInp_sueldo_base() {
        return inp_sueldo_base;
    }

    public void setTbl_plazas(CoreTable tbl_plazas) {
        this.tbl_plazas = tbl_plazas;
    }

    public CoreTable getTbl_plazas() {
        return tbl_plazas;
    }

    public void setInp_registro_empleado(CoreInputText inp_registro_empleado) {
        this.inp_registro_empleado = inp_registro_empleado;
    }

    public CoreInputText getInp_registro_empleado() {
        return inp_registro_empleado;
    }

    public void setInp_horas_contratadas(CoreInputText inp_horas_contratadas) {
        this.inp_horas_contratadas = inp_horas_contratadas;
    }

    public CoreInputText getInp_horas_contratadas() {
        return inp_horas_contratadas;
    }

    public void tbl_chg_selection_Action(AttributeChangeEvent attributeChangeEvent) {
        // Add event code here...
     
    }

    public void setInp_sueldo_base2(CoreInputText inp_sueldo_base2) {
        this.inp_sueldo_base2 = inp_sueldo_base2;
    }

    public CoreInputText getInp_sueldo_base2() {
        return inp_sueldo_base2;
    }

/*
 * Metodo para seleccionar los datos de la plaza seleccionada
 */
    public void btn_seleccionar_action(ActionEvent actionEvent) {
        // Add event code here...
         Double vsal_base;
         Integer vhoras_plaza;
         JUCtrlValueBindingRef tableRowRef =
         (JUCtrlValueBindingRef) this.tbl_plazas.getSelectedRowData();
         
         if (tableRowRef!=null){
         vsal_base=utils.getDouble1(tableRowRef.getRow().getAttribute("SalarioBasepuesto"));
         vhoras_plaza=utils.getInteger(tableRowRef.getRow().getAttribute("CantidadHoras"));
         /*
         if (this.inp_horas_contratadas.getValue()==null){
             this.inp_horas_contratadas.setValue(vhoras_plaza.toString());
         }
         */
         if (this.inpt_fecha_i.getValue()==null){
             this.inpt_fecha_i.setValue(tableRowRef.getRow().getAttribute("FechaInicio")); 
         }
         
        if (this.inpt_fecha_f.getValue()==null){
            this.inpt_fecha_f.setValue(tableRowRef.getRow().getAttribute("FechaFin")); 
        }
        
         
         if (vsal_base<=0){
             if (this.inp_sueldo_base2.getValue()==null){
                 this.inp_sueldo_base2.setRequired(true);
                 this.inp_sueldo_base2.setDisabled(false);        
             }else {
             this.inp_sueldo_base2.setRequired(true);
             this.inp_sueldo_base2.setDisabled(false);  
             calcular_sueldo();  
             }
         }else{
             
             this.inp_sueldo_base2.setDisabled(true);
             this.inp_sueldo_base2.setRequired(false);
             this.inp_sueldo_base2.setValue(vsal_base.toString());
             
           //  int hora=utils.diffHoras(this.inpt_horaE.getValue().toString(),this.inpt_horaF.getValue().toString());
           //  this.inp_horas_contratadas.setValue(hora);
             calcular_sueldo();
         }
       
        vInt_ComboPuesto=0; 
         }else {
             FacesMessage vMessage; 
             vMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,"Seleccione una plaza!!",null);
             FacesContext.getCurrentInstance().addMessage(null,vMessage);        
         }
         
    }
 
    public void setInpt_fecha_i(CoreSelectInputDate inpt_fecha_i) {
        this.inpt_fecha_i = inpt_fecha_i;
    }

    public CoreSelectInputDate getInpt_fecha_i() {
        return inpt_fecha_i;
    }

    public void setInpt_fecha_f(CoreSelectInputDate inpt_fecha_f) {
        this.inpt_fecha_f = inpt_fecha_f;
    }

    public CoreSelectInputDate getInpt_fecha_f() {
        return inpt_fecha_f;
    }

    
    public void shDetail_tramPuesto(AttributeChangeEvent attributeChangeEvent) {
        // Add event code here...
        System.out.println("tramite de puesto");
        
    }

/*
 * Metodo cuando se selecciona la pestaña de los descuentos
 */
    public void shItem_tramSueldo(DisclosureEvent disclosureEvent) {
          
         if (disclosureEvent.isExpanded()){ 
            obtenerDescuentos();            
                                            } 
    }

  private void obtenerDescuentos(){
      BindingContainer vBnd_binding;
      OperationBinding operationBinding;
      
      SisContrato vContrato;
      SisAjusteContrato vAjusteCont;
      SisAjusteEmpleado vAjusteEmpl;
      List <SisAjuste> vLista_ajustes;
      SisAjuste vAjuste=null;
      int vistaCont;
      
      vistaCont=(Integer)JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.vistaContrato");   
      if (vistaCont!=1){ //Se verifica que no sea la vista de modificacion.
       // Se obtienen los descuentos obligatorios del contrato                   
       vBnd_binding=(BindingContainer)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings}");
       operationBinding=vBnd_binding.getOperationBinding("ajuste_oblig_contrato");
      //  operationBinding=vBnd_binding.getOperationBinding("bonosydescuentos");
       vLista_ajustes=(List <SisAjuste>)operationBinding.execute();
      // result=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.ajuste_oblig_contrato.result}");
       
       vContrato=(SisContrato)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.contrato_by_id.result['0']}");
       if (vLista_ajustes!=null && vContrato!=null){
         if (vContrato.getSisAjusteContratoCollection().size()==0&&vContrato.getSisEmpleado().getSisAjusteEmpleadoCollection().size()==0){
            JSFUtils.setManagedBeanValue(FacesContext.getCurrentInstance(),"tabla_ajustes.remove",new ArrayList());                                                   
             for (Iterator iter= vLista_ajustes.iterator();iter.hasNext();){
         
                 vAjuste=(SisAjuste)iter.next();
                 if (vAjuste.getNivel().equals("C")){
                    vAjusteCont=new SisAjusteContrato();
                    vAjusteCont.setIdAjuste(vAjuste.getIdAjuste().longValue());
                    vAjusteCont.setnombreAjuste(vAjuste.getNombre());
                    vAjusteCont.setIdCorrelativo(new Double(1));
                    //vAjusteCont.setSisAjuste(vAjuste);
                    vAjuste.addSisAjusteContrato(vAjusteCont);
                    vAjusteCont.setSisContrato(vContrato);
                    vContrato.addSisAjusteContrato(vAjusteCont);
                    JSFUtils.setManagedBeanValue(FacesContext.getCurrentInstance(),"tabla_ajustes.agFila",vAjusteCont);                                                   
                    //System.out.println("contrato");
                 }else if (vAjuste.getNivel().equals("E")){
                     vAjusteEmpl=new SisAjusteEmpleado(); 
                     vAjusteEmpl.setIdCorrelativo(new Double(1));
                     vAjusteEmpl.setIdAjuste(vAjuste.getIdAjuste().longValue());
                     vAjusteEmpl.setnombreAjuste(vAjuste.getNombre());
                     vAjuste.addSisAjusteEmpleado(vAjusteEmpl);
                     vContrato.getSisEmpleado().addSisAjusteEmpleado(vAjusteEmpl);
                     JSFUtils.setManagedBeanValue(FacesContext.getCurrentInstance(),"tabla_ajustes.agFila",vAjusteEmpl);                                                   
                     //System.out.println("empleado");
                     //vAjusteEmpl.set
                     //vAjusteEmpl.set
                      // JSFUtils.setManagedBeanValue(FacesContext.getCurrentInstance(),"tabla_ajustes.agFila",vAjusteEmpl);                                                   
                 }
                                                                 }
               //  JSFUtils.setManagedBeanValue(FacesContext.getCurrentInstance(),"tabla_ajustes.list",vContrato.getSisAjusteContratoCollection());                                                   
                // JSFUtils.setManagedBeanValue(FacesContext.getCurrentInstance(),"tabla_ajustes.listAg", vContrato.getSisEmpleado().getSisAjusteEmpleadoCollection());                                                   
                                                         }
                                                }
      }
  }


    /*
     * Metodo para limpiar los descuentos del contrato
     */
    private void limpiar_descuentos_contrato(){
        SisContrato vContrato;
        vContrato=(SisContrato)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.contrato_by_id.result['0']}");
        System.out.println("Limpiar descuentos");
        if (vContrato!=null){
          if (vContrato.getSisAjusteContratoCollection().size()>0){
         vContrato.setSisAjusteContratoCollection(new ArrayList());
                                                                }
          if (vContrato.getSisEmpleado().getSisAjusteEmpleadoCollection().size()>0){
              vContrato.getSisEmpleado().setSisAjusteEmpleadoCollection(new ArrayList());
          }
        }
    }

    public void setTbl_descuentos(CoreTable tbl_descuentos) {
        this.tbl_descuentos = tbl_descuentos;
    }

    public CoreTable getTbl_descuentos() {
        return tbl_descuentos;
    }

    public String btn_puesto_sig_action() {
        // Add event code here...
         this.pnl_detail_puesto.setDisclosed(false);
         this.pnl_detail_acta.setDisclosed(true);
        return null;
    }

    public String btn_puesto_ant_action() {
        // Add event code here...
         this.pnl_detail_puesto.setDisclosed(false);
         this.pnl_datos.setDisclosed(true);
        return null;
    }

    public String btn_acta_pos_ant_action() {
        // Add event code here...
         this.pnl_detail_acta.setDisclosed(false);
         this.pnl_detail_puesto.setDisclosed(true);
        return null;
    }

    public String btn_tramSueldo_ant_action() {
        // Add event code here...
        this.pnl_detail_tram_sueldo.setDisclosed(false);
        this.pnl_detail_acta.setDisclosed(true);
        return null;
    }

    public void setOutresultado(CoreOutputText outresultado) {
        this.outresultado = outresultado;
    }

    public CoreOutputText getOutresultado() {
        return outresultado;
    }

    public void verificar_horaF(FacesContext facesContext, 
                                UIComponent uiComponent, Object object) {
                                
  //    System.out.println("Ejecutado la hora_F " +this.inpt_horaE.getValue().toString()+" "+object.toString() ); 
       if (utils.isHora(String.valueOf(object))){
         int hora=utils.diffHoras(this.inpt_horaE.getValue().toString(),object.toString());
          if (hora<=0){
              FacesMessage vMessage; 
              vMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,"Verifique la hora entrada y salida",null);
              throw new ValidatorException(vMessage);  
          }
       }else{
           FacesMessage vMessage; 
           vMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,"Ingrese una hora correcta. Formato HH:mm",null);
           throw new ValidatorException(vMessage);
       }
     
    }

    public void verificar_HoraI(FacesContext facesContext, 
                                UIComponent uiComponent, Object object) {
       // System.out.println("Ejecutado la hora_I"); 
        if (utils.isHora(String.valueOf(object))){
            
        }else{
            FacesMessage vMessage; 
            vMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,"Ingrese una hora correcta. Formato HH:mm",null);
            throw new ValidatorException(vMessage);
        }                          
    }

    public void setInpt_horaE(CoreInputText inpt_horaE) {
        this.inpt_horaE = inpt_horaE;
    }

    public CoreInputText getInpt_horaE() {
        return inpt_horaE;
    }

    public void setInpt_horaF(CoreInputText inpt_horaF) {
        this.inpt_horaF = inpt_horaF;
    }

    public CoreInputText getInpt_horaF() {
        return inpt_horaF;
    }

    public void inp_salida_action(ValueChangeEvent valueChangeEvent) {
    System.out.println("salida actino");
        // Add event code here...
    }

    public void verificar_fechaF(FacesContext facesContext, 
                                 UIComponent uiComponent, Object object) {
        // Add event code here...
         Date fechaF; 
         oracle.jbo.domain.Date fechafPlaza;
         
         JUCtrlValueBindingRef tableRowRef =
         (JUCtrlValueBindingRef) this.tbl_plazas.getSelectedRowData();
         
         if (tableRowRef!=null){
        
                fechafPlaza=(oracle.jbo.domain.Date)tableRowRef.getRow().getAttribute("FechaFin");
                fechaF=(Date)object;
                if (fechaF.after(fechafPlaza.getValue())){
                        FacesMessage vMessage; 
                        vMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,"La fecha no puede ser mayor a la de la plaza",null);
                        throw new ValidatorException(vMessage);
                    }
             
     
         }
    }

    public void verificar_fechaI(FacesContext facesContext, 
                                 UIComponent uiComponent, Object object) {
        Date fechaI; 
        oracle.jbo.domain.Date fechafPlaza,fechaFinal;
        
        JUCtrlValueBindingRef tableRowRef =
        (JUCtrlValueBindingRef) this.tbl_plazas.getSelectedRowData();
        
        if (tableRowRef!=null){
        
               fechafPlaza=(oracle.jbo.domain.Date)tableRowRef.getRow().getAttribute("FechaInicio");
               fechaI=(Date)object;
               if (fechaI.before(fechafPlaza.getValue())){
                       FacesMessage vMessage; 
                       vMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,"La fecha no puede ser menor a la de la plaza",null);
                       throw new ValidatorException(vMessage);
               }
               /*
             if (this.inpt_fecha_f.getValue()!=null&&this.inpt_fecha_f.getClass().equals(oracle.jbo.domain.Date.class)){  
                 fechaFinal=(oracle.jbo.domain.Date)this.inpt_fecha_f.getValue();
              if (fechaFinal!=null&&fechaI.after(fechaFinal.getValue())) {
                  FacesMessage vMessage; 
                  vMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,"La fecha Inicial no puede ser mayor a la final",null);
                  throw new ValidatorException(vMessage);
              }
              */
             }
        }
    //}

    
    public void setInpHoraEntr(CoreInputText inpHoraEntr) {
        this.inpHoraEntr = inpHoraEntr;
    }

    public CoreInputText getInpHoraEntr() {
        return inpHoraEntr;
    }

    public void setInpHoraSal(CoreInputText inpHoraSal) {
        this.inpHoraSal = inpHoraSal;
    }

    public CoreInputText getInpHoraSal() {
        return inpHoraSal;
    }

    public BindingContainer getBindings() {
        return this.bindings;
    }

    public void setBindings(BindingContainer bindings) {
        this.bindings = bindings;
    }

    public String btn_crear_horario_action() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = 
            bindings.getOperationBinding("Create");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        this.inpHoraEntr.setValue("");
        this.inpHoraSal.setValue("");
        return null;
    }

    public String btn_agregar_puesto() {
        // Add event code here...
         Integer vhoras_plaza=0;
         JUCtrlValueBindingRef tableRowRef =
         (JUCtrlValueBindingRef) this.tbl_plazas.getSelectedRowData();
         SisContrato vContrato;
         vContrato=(SisContrato)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.contrato_by_id.result['0']}");
        
         
         if (tableRowRef!=null){
         vhoras_plaza=utils.getInteger(tableRowRef.getRow().getAttribute("CantidadHoras"));
         }
         
         if (vContrato.getNumHoras()>vhoras_plaza){
             resulOp error=new resulOp(resulOp.OPE_ERROR,"El numero de horas actual es mayor a la de la plaza!!");
             utils.setADFMensaje(error);
         }
         
        return null;
    }

    public void setMensaje1(CoreMessage mensaje1) {
        this.mensaje1 = mensaje1;
    }

    public CoreMessage getMensaje1() {
        return mensaje1;
    }

    public String btn_actualizar_contrato_action() {
           
        Object vHorasPlaza;
        SisContrato vContrato;
        resulOp result;
        vContrato=(SisContrato)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.contrato_by_id.result['0']}");
        vHorasPlaza=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.contrato_det_puestoCantidadHoras}");
        
        if (vContrato.getNumHoras()!=utils.getInteger(vHorasPlaza)){
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"EL NUMERO DE HORAS DEL CONTRATO NO COINCIDE CON LA PLAZA"));
            return null;
        }
        
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = 
           bindings.getOperationBinding("mergeEntity");
        try{
         result = (resulOp)operationBinding.execute();
           
          utils.setADFMensaje(result);
                    
        }catch(Exception excep){
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,enlace_datos.util.utils.getSQLMensaje(excep)));
        }
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        return null;
    }

    public String btn_imprimir_action() {
        HashMap parametros=new HashMap();
        SisContrato vContrato ;
        vContrato=(SisContrato)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.contrato_by_id.result['0']}");
        parametros.put("contrato",vContrato.getIdContrato().toString());
        //System.out.println()
        reporteParams.set_opciones(reporteParams.AGREGAR_PARAMETROS,parametros);  
        return "dialog:imprimir_contrato";
    }
}

