package enlace_datos.consultas.reportes.client;

import enlace_datos.consultas.reportes.common.SisDetProcesos;

import oracle.jbo.client.remote.ViewUsageImpl;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SisDetProcesosClient extends ViewUsageImpl implements SisDetProcesos {
    /**This is the default constructor (do not remove)
     */
    public SisDetProcesosClient() {
    }

    public void generarSis24(Number pIdProceso, String vDesc, 
                             String pUsuario) {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"generarSis24",new String [] {"oracle.jbo.domain.Number","java.lang.String","java.lang.String"},new Object[] {pIdProceso, vDesc, pUsuario});
        return;
    }
}
