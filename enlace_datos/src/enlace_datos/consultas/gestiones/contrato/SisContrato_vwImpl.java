package enlace_datos.consultas.gestiones.contrato;


import enlace_datos.ViewConsultaImpl;

import enlace_datos.consultas.gestiones.contrato.common.SisContrato_vw;

import java.sql.ResultSet;

import oracle.jbo.RowIterator;
import oracle.jbo.domain.Number;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SisContrato_vwImpl extends ViewConsultaImpl implements SisContrato_vw {
    /**This is the default constructor (do not remove)
     */
    private boolean reseteado=false; 
    public SisContrato_vwImpl() {
        super.setVerificarParam(true);
    }

    /**Gets the bind variable value for numContrato
     */
    public Number getnumContrato() {
        return (Number)getNamedWhereClauseParam("numContrato");
    }

    /**Sets <code>value</code> for bind variable numContrato
     */
    public void setnumContrato(Number value) {
        setNamedWhereClauseParam("numContrato", value);
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
        reseteado=false;
        return value;
    }

    /**getEstimatedRowCount - overridden for custom java data source support.
     */
    public long getEstimatedRowCount() {
        long value = super.getEstimatedRowCount();
        return value;
    }
   public void Resetear(){   
       //this.clearViewCriterias();
      // this.clearCache(); 
       //this.reset();
       //this.cancelQuery();
       //this.
       if (reseteado==false){
       this.setnumContrato(new Number(-1));
       this.executeQuery();
       reseteado=true;
       System.out.println("Reset contrato");
       }
   }
   
   
   public void clonarActual(){
       SisContrato_vwRowImpl vFila,vFilaNueva;
       SisHorarioContratoRowImpl vNuevaFilaH,vFilaHorario;
       RowIterator vHorario;
       
       vFila=(SisContrato_vwRowImpl)this.getCurrentRow();
       vFilaNueva=(SisContrato_vwRowImpl)this.createRow();
       
       // Copiando los datos del contrato
       vFilaNueva.setIdTipoContrato(vFila.getIdTipoContrato());
       vFilaNueva.setRegistroEmpleado(vFila.getRegistroEmpleado());
       vFilaNueva.setBaseLegal(vFila.getBaseLegal());
       vFilaNueva.setNomPlaza(vFila.getNomPlaza());
       vFilaNueva.setObservhorario(vFila.getObservhorario());
       vFilaNueva.setIdFormaObtPuesto(vFila.getIdFormaObtPuesto());
       vFilaNueva.setObservFormaobtpuesto(vFila.getObservFormaobtpuesto());
       vFilaNueva.setAtribucion(vFila.getAtribucion());
       vFilaNueva.setAtribucionAnexo(vFila.getAtribucionAnexo());
       vFilaNueva.setLugarPosesion(vFila.getLugarPosesion());
       
       
       this.insertRow(vFilaNueva);
       vHorario=vFila.getSisHorarioContrato();
              
           while(vHorario.hasNext()){
               vFilaHorario=( SisHorarioContratoRowImpl)vHorario.next();
               vNuevaFilaH=(SisHorarioContratoRowImpl)vFilaNueva.getSisHorarioContrato().createRow();
               vNuevaFilaH.setnomDia(vFilaHorario.getnomDia());
               vNuevaFilaH.setIdDia(vFilaHorario.getIdDia());
               vNuevaFilaH.setHoraEntrada2(vFilaHorario.getHoraEntrada2());
               vNuevaFilaH.setHoraSalida2(vFilaHorario.getHoraSalida2());
               vFilaNueva.getSisHorarioContrato().insertRow(vNuevaFilaH);
               
           }
       
   }
   

}
