package enlace_datos.consultas.gestiones.contrato.common;

import oracle.jbo.ViewObject;
import oracle.jbo.domain.DBSequence;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---------------------------------------------------------------------
public interface SisContrato031vw extends ViewObject {
    void buscarIdContrato(DBSequence pIdContrato);

    void list_Contratos031(String pRegistroEmpleado, String pCui);
}
