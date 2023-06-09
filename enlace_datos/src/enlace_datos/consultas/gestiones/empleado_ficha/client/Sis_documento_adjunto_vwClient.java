package enlace_datos.consultas.gestiones.empleado_ficha.client;

import enlace_datos.consultas.gestiones.empleado_ficha.common.Sis_documento_adjunto_vw;

import oracle.jbo.client.remote.ViewUsageImpl;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class Sis_documento_adjunto_vwClient extends ViewUsageImpl implements Sis_documento_adjunto_vw {
    /**This is the default constructor (do not remove)
     */
    public Sis_documento_adjunto_vwClient() {
    }


    public void consultarConfirmados(Number pRegistroEmpleado, 
                                     Number pTipoInicial) {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"consultarConfirmados",new String [] {"oracle.jbo.domain.Number","oracle.jbo.domain.Number"},new Object[] {pRegistroEmpleado, pTipoInicial});
        return;
    }

    public void revertirValidacionDocumento(Number pIdDocumento) {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"revertirValidacionDocumento",new String [] {"oracle.jbo.domain.Number"},new Object[] {pIdDocumento});
        return;
    }

    public void validarDocumentoAdjunto(Number pIdArchivoAdjunto) {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"validarDocumentoAdjunto",new String [] {"oracle.jbo.domain.Number"},new Object[] {pIdArchivoAdjunto});
        return;
    }
}
