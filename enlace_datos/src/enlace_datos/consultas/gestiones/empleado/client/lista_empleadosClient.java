package enlace_datos.consultas.gestiones.empleado.client;

import enlace_datos.consultas.gestiones.empleado.common.lista_empleados;

import oracle.jbo.client.remote.ViewUsageImpl;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class lista_empleadosClient extends ViewUsageImpl implements lista_empleados {
    /**This is the default constructor (do not remove)
     */
    public lista_empleadosClient() {
    }

    public void ConsultaEmpleado(Number pRegEmpleado, String pNombre1, 
                                 String pNombre2, String pApellido1, 
                                 String pApellido2, Number pRegCedula, 
                                 Number pCui) {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"ConsultaEmpleado",new String [] {"oracle.jbo.domain.Number","java.lang.String","java.lang.String","java.lang.String","java.lang.String","oracle.jbo.domain.Number","oracle.jbo.domain.Number"},new Object[] {pRegEmpleado, pNombre1, pNombre2, pApellido1, pApellido2, pRegCedula, pCui});
        return;
    }

    public void asignacionRegPer() {
        Object _ret = 
            getApplicationModuleProxy().riInvokeExportedMethod(this,"asignacionRegPer",null,null);
        return;
    }
}
