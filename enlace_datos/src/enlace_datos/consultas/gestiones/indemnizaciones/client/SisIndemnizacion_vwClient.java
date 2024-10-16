package enlace_datos.consultas.gestiones.indemnizaciones.client;

import enlace_datos.consultas.gestiones.indemnizaciones.common.SisIndemnizacion_vw;

import oracle.jbo.client.remote.ViewUsageImpl;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SisIndemnizacion_vwClient extends ViewUsageImpl implements SisIndemnizacion_vw {
    /**This is the default constructor (do not remove)
     */
    public SisIndemnizacion_vwClient() {
    }


    public void ObtenerSolicitudesIndemnizacion() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"ObtenerSolicitudesIndemnizacion",null,null);
        return;
    }

    public void ObtenerSolicitudesProfesionalCaja() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"ObtenerSolicitudesProfesionalCaja",null,null);
        return;
    }

    public void ObtenerSolicitudesAuditor() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"ObtenerSolicitudesAuditor",null,null);
        return;
    }

    public void RecuperarSolicitud(Number pIdIndemnizacion) {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"RecuperarSolicitud",new String [] {"oracle.jbo.domain.Number"},new Object[] {pIdIndemnizacion});
        return;
    }
}
