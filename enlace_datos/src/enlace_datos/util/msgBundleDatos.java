package enlace_datos.util;

import java.util.ListResourceBundle;

public class msgBundleDatos extends ListResourceBundle {
    private static final Object[][] sMessageStrings = new String[][] {
    {"VAL_OBLIGATORIO","Por favor ingrese el valor."}
    };

    /**Return String Identifiers and corresponding Messages in a two-dimensional array.
     */
    protected Object[][] getContents() {
        return sMessageStrings;
    }
}
