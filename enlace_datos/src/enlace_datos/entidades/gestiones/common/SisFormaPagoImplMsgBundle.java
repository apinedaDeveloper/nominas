package enlace_datos.entidades.gestiones.common;

import oracle.jbo.common.JboResourceBundle;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---------------------------------------------------------------------
public class SisFormaPagoImplMsgBundle extends JboResourceBundle {


    static final Object[][] sMessageStrings = 
    {
{ "FechaCreacion_FMT_FORMAT", "dd/MM/yyyy HH:mm" },
{ "FechaBaja_FMT_FORMATTER", "oracle.jbo.format.DefaultDateFormatter" },
{ "FechaBaja_FMT_FORMAT", "dd/MM/yyyy HH:mm" },
{ "FechaCreacion_FMT_FORMATTER", "oracle.jbo.format.DefaultDateFormatter" }};

    /**This is the default constructor (do not remove)
     */
    public SisFormaPagoImplMsgBundle() {
    }

    /**@return an array of key-value pairs.
     */
    public Object[][] getContents() {
        return super.getMergedArray(sMessageStrings, super.getContents());
    }
}
