package enlace_datos.consultas.gestiones.post_mortem.client;

import enlace_datos.consultas.gestiones.post_mortem.common.SisPostMortem_vw;

import oracle.jbo.client.remote.ViewUsageImpl;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SisPostMortem_vwClient extends ViewUsageImpl implements SisPostMortem_vw {
    /**This is the default constructor (do not remove)
     */
    public SisPostMortem_vwClient() {
    }


    public void RecuperarSolicitudesProfesionalCaja() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"RecuperarSolicitudesProfesionalCaja",null,null);
        return;
    }

    public void RecuperarSolicitud(Number pIdTipoPrestacion, Number pAnio, 
                                   Number pCorrelativoAnio) {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"RecuperarSolicitud",new String [] {"oracle.jbo.domain.Number","oracle.jbo.domain.Number","oracle.jbo.domain.Number"},new Object[] {pIdTipoPrestacion, pAnio, pCorrelativoAnio});
        return;
    }

    public void RecuperarSolicitudes() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"RecuperarSolicitudes",null,null);
        return;
    }
}
