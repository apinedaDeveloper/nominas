package enlace_datos.consultas.gestiones.post_mortem.common;

import oracle.jbo.ViewObject;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---------------------------------------------------------------------
public interface SisPostMortem_vw extends ViewObject {
    void RecuperarSolicitudes();

    void RecuperarSolicitud(Number pIdTipoPrestacion, Number pAnio, 
                            Number pCorrelativoAnio);
}