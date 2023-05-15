package interfaz_usuario.backing.gestiones;

import enlace_datos.util.resulOp;

import interfaz_usuario.usuario;

import interfaz_usuario.util.JSFUtils;

import interfaz_usuario.util.utils;

import java.util.ArrayList;

import javax.faces.context.FacesContext;

import javax.faces.model.SelectItem;

import oracle.adf.view.faces.component.core.data.CoreTable;
import oracle.adf.view.faces.component.core.layout.CorePanelHeader;
import oracle.adf.view.faces.component.core.nav.CoreCommandButton;

import oracle.jbo.Row;
import oracle.jbo.domain.Date;
import oracle.jbo.uicli.binding.JUIteratorBinding;

public class listadoLicencias {
    private CoreTable tbl_plazas;
    private CoreCommandButton btn_seleccionar_plaza;
    private CoreCommandButton btn_ok_selPlaza;
    private CorePanelHeader pnl_header_det_pro;

    public listadoLicencias() {
    }

    public String btn_crearLicencia() {
        // Add event code here...
        String vOutcome;
        Object vIterador;
        JUIteratorBinding vIterador2;
        int vNumeroFilas;
        Row [] vFilas;
        Row vFilaDefault,vFilaNueva;
        
        vIterador=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.SisPlazasPerfil_Empleado_vwIterator}");
        
        vFilaDefault=null;
        
        if (vIterador!=null){
            
            vIterador2=(JUIteratorBinding)vIterador;
            vNumeroFilas=vIterador2.getViewObject().getRowCount();
            vFilas=vIterador2.getViewObject().getAllRowsInRange();
            
            for (int i=0;i<vNumeroFilas;i++){
            
             // System.out.println(" debug "+vFilas[i].getAttribute("Estado"));
            /*
              vFilas[i].getAttribute("IdPartida");
              vFilas[i].getAttribute("IdPuesto");
              vFilas[i].getAttribute("NumeroPlaza");
              vFilas[i].getAttribute("Estado");
            */    
               if (vFilas[i].getAttribute("Estado").equals("ACTIVO"))
               {
               
                   vFilaDefault=vFilas[i];
                   break;
                   
               }            
            }
            
            if (vFilaDefault==null)
            {
                vFilaDefault=vFilas[0];
            }
        }
        
        
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"crearSolicitud3")) 
        {
            
            vIterador=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.SisSolicitudVwIterator}");
            vIterador2=(JUIteratorBinding)vIterador;            
            vFilaNueva=vIterador2.getCurrentRow();
            
            vFilaNueva.setAttribute("IdContrato",vFilaDefault.getAttribute("IdContrato"));
            vFilaNueva.setAttribute("IdPartida",vFilaDefault.getAttribute("IdPartida"));
            vFilaNueva.setAttribute("IdPuesto",vFilaDefault.getAttribute("IdPuesto"));
            vFilaNueva.setAttribute("NumeroPlaza",vFilaDefault.getAttribute("NumeroPlaza"));
            vFilaNueva.setAttribute("Anio",vFilaDefault.getAttribute("Correlativo"));
            vFilaNueva.setAttribute("Partida",vFilaDefault.getAttribute("Partida").toString());            
            vFilaNueva.setAttribute("NomPuesto",vFilaDefault.getAttribute("NomPuesto").toString());   
            
            
            vOutcome="gestEmpl_sol_licencia";
            
        }else{
            vOutcome=null;
            
        }
        
        return vOutcome;
    }

    public String btn_guardar_licencia() {
        
        resulOp vResultado=new resulOp();
        boolean vResultadoOp=false;
        
        
        
        
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit")){
        
            //if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"actualizarEstado")){

            vResultado.setMensajeError("Datos guardados exitosamente");
            vResultado.setCodigoResultado(resulOp.OPE_OK);
            utils.setADFMensaje(vResultado);
            usuario.set_opciones(usuario.VISTA_SOLICITUD,1);
            vResultadoOp=true;
           // }
        }
            
        
        if (vResultadoOp){
            return null;
        }else{
            return null;
        }

    }

    public void setTbl_plazas(CoreTable tbl_plazas) {
        this.tbl_plazas = tbl_plazas;
    }

    public CoreTable getTbl_plazas() {
        return tbl_plazas;
    }

    public String btn_seleccionar_plaza() {
        
        this.tbl_plazas.setRendered(true);
        this.getBtn_seleccionar_plaza().setDisabled(true);
        this.getBtn_ok_selPlaza().setDisabled(false);
        
        return null;
    }

    public void setBtn_seleccionar_plaza(CoreCommandButton btn_seleccionar_plaza) {
        this.btn_seleccionar_plaza = btn_seleccionar_plaza;
    }

    public CoreCommandButton getBtn_seleccionar_plaza() {
        return btn_seleccionar_plaza;
    }

    public void setBtn_ok_selPlaza(CoreCommandButton btn_ok_selPlaza) {
        this.btn_ok_selPlaza = btn_ok_selPlaza;
    }

    public CoreCommandButton getBtn_ok_selPlaza() {
        return btn_ok_selPlaza;
    }

    public String btn_ok_sel_plaza() {
        // Add event code here...
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"CambiarPlaza");
        this.tbl_plazas.setRendered(false);
        this.getBtn_ok_selPlaza().setDisabled(true);
        this.getBtn_seleccionar_plaza().setDisabled(false);

        
        
        return null;
    }

    public String cmd_setLicencia() {
        // Add event code here...
        String vOutcome=null;
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"setRow"))
        {
            if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"ConsultaPorId"))
            {
                
                vOutcome="gestEmpl_sol_licencia";
                
            }
        
        
        } 
        
         
        
        return vOutcome;
    }

    public String btn_lic_prorroga_det() {
        // Add event code here...
        this.pnl_header_det_pro.setRendered(true);
        return null;
    }

    public void setPnl_header_det_pro(CorePanelHeader pnl_header_det_pro) {
        this.pnl_header_det_pro = pnl_header_det_pro;
    }

    public CorePanelHeader getPnl_header_det_pro() {
        return pnl_header_det_pro;
    }
}
