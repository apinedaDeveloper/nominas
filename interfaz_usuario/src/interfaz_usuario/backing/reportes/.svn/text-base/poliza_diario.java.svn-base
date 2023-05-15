package interfaz_usuario.backing.reportes;

import enlace_datos.util.resulOp;

import interfaz_usuario.util.JSFUtils;
import interfaz_usuario.util.utils;

import javax.faces.context.FacesContext;

public class poliza_diario {
    public poliza_diario() {
    }
    
    public String ejecutaGenerarPolizaConta(){
        String vPoliza = null;
        try{
            vPoliza = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{row.NoPolizaContable}").toString();
        }
        catch(Exception e){
            vPoliza = null;
        }
        
        if(vPoliza == null){
            utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Debe ingresar el número de la póliza contable."));
            return null;
        }
        
        utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Procesando generación de la póliza contable....."));
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"crear_poliza_conta"))
        {
              JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Confirmar");
              utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"La poliza contable se genero correctamente, por favor verifique en el Sistema de Contabilidad."));
              JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"Ejecutar");
        }

        return null;
    }
    
    public String ejecutaGenerarPolizaSis(){
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"insertar_datos_poliza_diario"))
        {
              utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"El proceso de generación termino correctamente."));
        }

        return null;
    }
    
    public String ejecutaGenerarPolizaAnul(){
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"insertar_datos_poliza_anulados"))
        {
              utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"El proceso de generación termino correctamente."));
        }

        return null;
    }
}
