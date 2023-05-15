package enlace_datos.consultas;

import interfaz_usuario.util.JSFUtils;
import interfaz_usuario.util.utils;

import javax.faces.context.FacesContext;

import oracle.adf.view.faces.component.core.data.CoreTableSelectOne;
import oracle.adf.view.faces.component.core.input.CoreInputText;
import oracle.adf.view.faces.component.core.nav.CoreCommandButton;

import oracle.jbo.domain.Number;

public class Isr_Empl {
    private CoreInputText inpt_TotalPlanilla;
    private CoreInputText inpt_pagoImp;
    private CoreInputText inpt_impuestoT;
    private CoreInputText inpt_retencionE;
    private CoreInputText inpt_creditoF;
    private CoreInputText inpt_imp_devo;
    private CoreCommandButton btn_tblOp_crear;
    private CoreCommandButton btn_tblOp_edit;
    private CoreCommandButton btn_tblOp_del;
    private CoreCommandButton btn_tblOp_ok;
    private CoreTableSelectOne tblOP_selOne;

    public Isr_Empl() {
    }

public String btn_calcular_action() 
{
    
      try{
          
      
        Number vImpuestoTotal,vRetencionEfec,vTotalPlanilla,vIvaPlanilla,vPagar,vDiff;
        vImpuestoTotal=utils.getNumberOracleFormato(this.getInpt_impuestoT().getValue());
        vRetencionEfec=utils.getNumberOracleFormato(this.getInpt_retencionE().getValue());
        vTotalPlanilla=utils.getNumberOracleFormato(this.getInpt_TotalPlanilla().getValue());
        vTotalPlanilla=new Number(vTotalPlanilla.abs());
        vIvaPlanilla=vTotalPlanilla.divide(1.12).multiply(0.12);
        this.getInpt_creditoF().setValue(vIvaPlanilla);   
        vDiff=vImpuestoTotal.subtract(vIvaPlanilla);
         
        // vPagar=vImpuestoTotal.subtract(vRetencionEfec).subtract(vIvaPlanilla);
        
        if (vDiff.compareTo(0)<=0){
            this.getInpt_pagoImp().setValue("0");    
            this.getInpt_imp_devo().setValue(vRetencionEfec);        
        }else{
            vPagar=vRetencionEfec.subtract(vDiff);
            if (vPagar.compareTo(0)>=0){
                this.getInpt_pagoImp().setValue("0");    
                this.getInpt_imp_devo().setValue(vPagar);
                
            }else{
                this.getInpt_pagoImp().setValue(vPagar.abs());
                this.getInpt_imp_devo().setValue("0");
            }
            
        }
                
      }catch(Exception exep){
          
          
      }
        
    return null;
}

    public void setInpt_TotalPlanilla(CoreInputText inpt_TotalPlanilla) {
        this.inpt_TotalPlanilla = inpt_TotalPlanilla;
    }

    public CoreInputText getInpt_TotalPlanilla() {
        return inpt_TotalPlanilla;
    }

    public void setInpt_pagoImp(CoreInputText inpt_pagoImp) {
        this.inpt_pagoImp = inpt_pagoImp;
    }

    public CoreInputText getInpt_pagoImp() {
        return inpt_pagoImp;
    }

    public void setInpt_impuestoT(CoreInputText inpt_impuestoT) {
        this.inpt_impuestoT = inpt_impuestoT;
    }

    public CoreInputText getInpt_impuestoT() {
        return inpt_impuestoT;
    }

    public void setInpt_retencionE(CoreInputText inpt_retencionE) {
        this.inpt_retencionE = inpt_retencionE;
    }

    public CoreInputText getInpt_retencionE() {
        return inpt_retencionE;
    }

    public void setInpt_creditoF(CoreInputText inpt_creditoF) {
        this.inpt_creditoF = inpt_creditoF;
    }

    public CoreInputText getInpt_creditoF() {
        return inpt_creditoF;
    }


    public void setInpt_imp_devo(CoreInputText inpt_imp_devo) {
        this.inpt_imp_devo = inpt_imp_devo;
    }

    public CoreInputText getInpt_imp_devo() {
        return inpt_imp_devo;
    }

    public void setBtn_tblOp_crear(CoreCommandButton btn_tblOp_crear) {
        this.btn_tblOp_crear = btn_tblOp_crear;
    }

    public CoreCommandButton getBtn_tblOp_crear() {
        return btn_tblOp_crear;
    }

    public void setBtn_tblOp_edit(CoreCommandButton btn_tblOp_edit) {
        this.btn_tblOp_edit = btn_tblOp_edit;
    }

    public CoreCommandButton getBtn_tblOp_edit() {
        return btn_tblOp_edit;
    }

    public void setBtn_tblOp_del(CoreCommandButton btn_tblOp_del) {
        this.btn_tblOp_del = btn_tblOp_del;
    }

    public CoreCommandButton getBtn_tblOp_del() {
        return btn_tblOp_del;
    }

    public void setBtn_tblOp_ok(CoreCommandButton btn_tblOp_ok) {
        this.btn_tblOp_ok = btn_tblOp_ok;
    }

    public CoreCommandButton getBtn_tblOp_ok() {
        return btn_tblOp_ok;
    }

    public void setTblOP_selOne(CoreTableSelectOne tblOP_selOne) {
        this.tblOP_selOne = tblOP_selOne;
    }

    public CoreTableSelectOne getTblOP_selOne() {
        return tblOP_selOne;
    }

    public String btn_OP_crear() {
        
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"crearOtrosPatronos"))
        {
            this.btn_tblOp_crear.setDisabled(true);
           // this.btn_tblOp_del.setDisabled(true);
            this.btn_tblOp_edit.setDisabled(true);
            this.tblOP_selOne.setDisabled(true);
        }
        
        return null;
    }

    public String btn_OP_edit_action() {
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"HabilitaActual"))
        {
            this.btn_tblOp_crear.setDisabled(true);
            this.btn_tblOp_del.setDisabled(true);
            this.btn_tblOp_edit.setDisabled(true);
            this.tblOP_selOne.setDisabled(true);
        }
        
        return null;
    }

    public String btn_OP_del_action() {
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"BorrarOP"))
        {
           
           JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"verificarRentaNetaOtros"); 
        
            if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit"))
            {
            this.btn_tblOp_crear.setDisabled(false);
            this.btn_tblOp_del.setDisabled(false);
            this.btn_tblOp_edit.setDisabled(false);
            this.tblOP_selOne.setDisabled(false);
            }
        }
        
        return null;
    }

    public String btn_OP_ok_action() {
        Object vFilas;
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit"))
        {
            JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"DisableAll");
            
              
            vFilas=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.SisIsrForm1101OtrosptrnosVwIterator.estimatedRowCount}");
              if (vFilas!=null)
              {
                if (utils.getNumberOracle(vFilas).compareTo(2)<0){
                    this.btn_tblOp_crear.setDisabled(false);
                }
                  
              }
            this.btn_tblOp_del.setDisabled(false);
            this.btn_tblOp_edit.setDisabled(false);
            this.tblOP_selOne.setDisabled(false);
        }
      
      
        return null;
    }
}
