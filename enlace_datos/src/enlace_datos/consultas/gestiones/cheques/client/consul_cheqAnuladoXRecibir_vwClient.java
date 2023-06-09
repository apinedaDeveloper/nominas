package enlace_datos.consultas.gestiones.cheques.client;

import enlace_datos.consultas.gestiones.cheques.common.consul_cheqAnuladoXRecibir_vw;

import oracle.jbo.client.remote.ViewUsageImpl;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class consul_cheqAnuladoXRecibir_vwClient extends ViewUsageImpl implements consul_cheqAnuladoXRecibir_vw {
    /**This is the default constructor (do not remove)
     */
    public consul_cheqAnuladoXRecibir_vwClient() {
    }


    public void filtrarUnidad(Number pUnidad, Number varDependencia) {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"filtrarUnidad",new String [] {"oracle.jbo.domain.Number","oracle.jbo.domain.Number"},new Object[] {pUnidad, varDependencia});
        return;
    }

    public void filtrarXfechas(Date pFechaInicio, Date pFechaFin, 
                               Number varDependencia) {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"filtrarXfechas",new String [] {"oracle.jbo.domain.Date","oracle.jbo.domain.Date","oracle.jbo.domain.Number"},new Object[] {pFechaInicio, pFechaFin, varDependencia});
        return;
    }

    public void unidadFechas(Date pFechaInicio, Date pFechaFin, Number pUnidad, 
                             Number varDependencia) {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"unidadFechas",new String [] {"oracle.jbo.domain.Date","oracle.jbo.domain.Date","oracle.jbo.domain.Number","oracle.jbo.domain.Number"},new Object[] {pFechaInicio, pFechaFin, pUnidad, varDependencia});
        return;
    }

    public void limpiarwhere() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"limpiarwhere",null,null);
        return;
    }

    public void agregarIdRecibido(Number pIdRecibido) {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"agregarIdRecibido",new String [] {"oracle.jbo.domain.Number"},new Object[] {pIdRecibido});
        return;
    }
}
