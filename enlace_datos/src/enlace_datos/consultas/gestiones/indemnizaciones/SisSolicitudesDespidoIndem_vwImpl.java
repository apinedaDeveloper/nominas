package enlace_datos.consultas.gestiones.indemnizaciones;

import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SisSolicitudesDespidoIndem_vwImpl extends ViewObjectImpl {
    /**This is the default constructor (do not remove)
     */
    public SisSolicitudesDespidoIndem_vwImpl() {
    }

    /**Gets the bind variable value for vRegistroPersonal
     */
    public String getvRegistroPersonal() {
        return (String)getNamedWhereClauseParam("vRegistroPersonal");
    }

    /**Sets <code>value</code> for bind variable vRegistroPersonal
     */
    public void setvRegistroPersonal(String value) {
        setNamedWhereClauseParam("vRegistroPersonal", value);
    }
}