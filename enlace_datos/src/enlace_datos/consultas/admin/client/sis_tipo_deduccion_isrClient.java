package enlace_datos.consultas.admin.client;

import enlace_datos.consultas.admin.common.sis_tipo_deduccion_isr;

import oracle.jbo.client.remote.ViewUsageImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class sis_tipo_deduccion_isrClient extends ViewUsageImpl implements sis_tipo_deduccion_isr {
    /**This is the default constructor (do not remove)
     */
    public sis_tipo_deduccion_isrClient() {
    }

    public void filtrar_activos() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"filtrar_activos",null,null);
        return;
    }

    public void reset() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"reset",null,null);
        return;
    }
}
