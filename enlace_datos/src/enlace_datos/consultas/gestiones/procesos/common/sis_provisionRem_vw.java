package enlace_datos.consultas.gestiones.procesos.common;

import oracle.jbo.ViewObject;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---------------------------------------------------------------------
public interface sis_provisionRem_vw extends ViewObject {
    void generarPoliza(String pIdRemesa);

    void crear_poliza_contable(Number pIdRemesa, Number pNoPolizaConta);
}