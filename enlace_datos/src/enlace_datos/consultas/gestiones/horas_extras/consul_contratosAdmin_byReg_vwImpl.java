package enlace_datos.consultas.gestiones.horas_extras;

import java.sql.ResultSet;

import oracle.jbo.domain.Number;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class consul_contratosAdmin_byReg_vwImpl extends ViewObjectImpl {
    /**This is the default constructor (do not remove)
     */
    public consul_contratosAdmin_byReg_vwImpl() {
    }

    /**Gets the bind variable value for varEmpleado
     */
    public Number getvarEmpleado() {
        return (Number)getNamedWhereClauseParam("varEmpleado");
    }

    /**Sets <code>value</code> for bind variable varEmpleado
     */
    public void setvarEmpleado(Number value) {
        setNamedWhereClauseParam("varEmpleado", value);
    }

    /**executeQueryForCollection - overridden for custom java data source support.
     */
    protected void executeQueryForCollection(Object qc, Object params[], int noUserParams) {super.executeQueryForCollection(qc, params, noUserParams);
    }

    /**hasNextForCollection - overridden for custom java data source support.
     */
    protected boolean hasNextForCollection(Object qc) {
        boolean bRet = super.hasNextForCollection(qc);
        return bRet;
    }

    /**createRowFromResultSet - overridden for custom java data source support.
     */
    protected ViewRowImpl createRowFromResultSet(Object qc, 
                                                 ResultSet resultSet) {
        ViewRowImpl value = super.createRowFromResultSet(qc, resultSet);
        return value;
    }

    /**getEstimatedRowCount - overridden for custom java data source support.
     */
    public long getEstimatedRowCount() {
        long value = super.getEstimatedRowCount();
        return value;
    }

    /**Gets the bind variable value for varAnio
     */
    public Number getvarAnio() {
        return (Number)getNamedWhereClauseParam("varAnio");
    }

    /**Sets <code>value</code> for bind variable varAnio
     */
    public void setvarAnio(Number value) {
        setNamedWhereClauseParam("varAnio", value);
    }
}
