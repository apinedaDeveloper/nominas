package enlace_datos.consultas.empleado;

import oracle.jbo.domain.Number;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class Sis_list_dest_empleado_vwImpl extends ViewObjectImpl {
    /**This is the default constructor (do not remove)
     */
    public Sis_list_dest_empleado_vwImpl() {
    }

    /**Gets the bind variable value for pRegEmpleado
     */
    public Number getpRegEmpleado() {
        return (Number)getNamedWhereClauseParam("pRegEmpleado");
    }

    /**Sets <code>value</code> for bind variable pRegEmpleado
     */
    public void setpRegEmpleado(Number value) {
        setNamedWhereClauseParam("pRegEmpleado", value);
    }
}
