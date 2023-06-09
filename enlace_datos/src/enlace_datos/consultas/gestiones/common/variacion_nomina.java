package enlace_datos.consultas.gestiones.common;

import oracle.jbo.ViewObject;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---------------------------------------------------------------------
public interface variacion_nomina extends ViewObject {


    void insertar_det_renuncia(Number pRegistroEmpl, Number IdAjuste, 
                               Number pCorrelativo, Date pFechaUltimoProc, 
                               boolean pBaja, String pObservaciones);

    void cambiar_iggs(Number pRegistroEmpl, Number IdAjuste, Date pFechaDoc, 
                      boolean pJubilacionIVS, String pObservaciones);


    Number modificar_ajuste(Number pIdVariacion, Number pRegistroEmpl, 
                            Number pContrato, Number IdAjuste, 
                            Number pCorrelativo, Date pFechaUltimoProc, 
                            Number pValor, Number pPorcentaje, boolean pBaja, 
                            String pObservaciones, String pRemovible, 
                            String pMod, String pNivel);

    Number nuevo_ajuste(Number pIdVariacion, Number pRegistroEmpl, 
                        Number pContrato, Number IdAjuste, Date pFechaInicio, 
                        Date pFechaFin, Number pValor, Number pPorcentaje, 
                        String pObservaciones, String pNivelAjuste);

    void consultar_manual(String pUsuario, Number pRegistroEmpl);
}
