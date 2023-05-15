package enlace_datos.consultas;

import java.sql.ResultSet;

import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.server.ViewRowImpl;
import oracle.jbo.server.ViewRowSetImpl;

public class valores_estaticos_querry extends ViewObjectImpl {
    private static final int CODIGO = 0;
    private static final int TEXTO = 1;
    int filas = -1;
    private String[][] str_data = null;
    
    public valores_estaticos_querry() {
    }
    /**executeQueryForCollection - overridden for custom java data source support.
     */
    protected void executeQueryForCollection(Object qc, Object params[], int noUserParams) 
    {
    //inicializando el valor inicial a cero
    setFetchPos(qc, 0);
    super.executeQueryForCollection(qc, params, noUserParams);
    }

    /**hasNextForCollection - overridden for custom java data source support.
     */
    protected boolean hasNextForCollection(Object qc) {
        // Verifica si existe alguna otra fila
        return getFetchPos(qc) < filas;
    }

    /**createRowFromResultSet - overridden for custom java data source support.
     */
    protected ViewRowImpl createRowFromResultSet(Object qc, 
                                                 ResultSet resultSet) {
        
        
        ViewRowImpl r = createNewRowForCollection(qc);
        //Obtiene la fila actual
        int pos = getFetchPos(qc);
        //Creacion de la la nueva fila
        populateAttributeForRow(r, 0, str_data[pos][CODIGO]);
        populateAttributeForRow(r, 1, str_data[pos][TEXTO]);
        setFetchPos(qc, pos + 1);
      return r;
    }

    /**getEstimatedRowCount - overridden for custom java data source support.
     */
    public long getEstimatedRowCount() {
        long value = super.getEstimatedRowCount();
        return value;
    }
    
    // Para guardar la posicion de la fila actual
    private void setFetchPos(Object rowset, int pos) {
    if (pos == filas) {
    setFetchCompleteForCollection(rowset, true);
    }
    setUserDataForCollection(rowset, new Integer(pos));
    }
    
    // Para obtener la posicion de la fila actual
    private int getFetchPos(Object rowset) {
    return ((Integer)getUserDataForCollection(rowset)).intValue();
    }

    protected void create() {
    super.create();
    filas = (str_data != null) ? str_data.length : 0;
    getViewDef().setQuery(null);
    getViewDef().setSelectClause(null);
    setQuery(null);
    }

    // Metodo para obtener los datos
    protected void inicializar_Datos_Querry(String[][] pdatos) {
    this.str_data = pdatos;
    }

    // Retorna la cantidad de filas
    public long getQueryHitCount(ViewRowSetImpl viewRowSet) {
    return filas;
    }
    
}
