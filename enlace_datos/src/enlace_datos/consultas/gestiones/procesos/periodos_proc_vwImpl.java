package enlace_datos.consultas.gestiones.procesos;

import java.sql.ResultSet;

import oracle.jbo.domain.Number;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class periodos_proc_vwImpl extends ViewObjectImpl {
    /**This is the default constructor (do not remove)
     */
    public periodos_proc_vwImpl() {
    }

    /**Gets the bind variable value for Restriccion
     */
    public String getRestriccion() {
        return (String)getNamedWhereClauseParam("Restriccion");
    }

    /**Sets <code>value</code> for bind variable Restriccion
     */
    public void setRestriccion(String value) {
        setNamedWhereClauseParam("Restriccion", value);
    }

    /**executeQueryForCollection - overridden for custom java data source support.
     */
    protected void executeQueryForCollection(Object qc, Object params[], int noUserParams) {
      if(this.getRestriccion()!=null){
         if (this.getRestriccion().equals("ACT")) {
             this.setWhereClause("id_periodo=to_char(sysdate,'mm')");
         }else if(this.getRestriccion().equals("DESDEACTUAL") || this.getRestriccion().equals("ACT+")){
             this.setWhereClause("id_periodo>=to_char(sysdate,'mm')");
         }
         else{
             //this.reset();
             this.setWhereClause("");
         }
          
      }
    
    super.executeQueryForCollection(qc, params, noUserParams);
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
}
