package enlace_datos.consultas.gestiones.contrato;

import enlace_datos.consultas.gestiones.contrato.common.SisPartida031_vw;

import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SisPartida031_vwImpl extends ViewObjectImpl implements SisPartida031_vw {
    /**This is the default constructor (do not remove)
     */
    public SisPartida031_vwImpl() {
    }

    public void filtrarxUnidad(oracle.jbo.domain.Number pIdUnidad){
        //System.out.println("filtrarxUnidad, dependencias, pIdUnidad:="+pIdUnidad);
        this.setWhereClause("d3d4=" + pIdUnidad);
        this.executeQuery();        
    }

}
