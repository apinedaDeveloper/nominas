package enlace_datos.consultas.gestiones.revision;

import enlace_datos.ViewConsultaImpl;

import enlace_datos.consultas.gestiones.revision.common.SisContratosPendientesRev;

import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SisContratosPendientesRevImpl extends ViewConsultaImpl implements SisContratosPendientesRev {
    /**This is the default constructor (do not remove)
     */
    public SisContratosPendientesRevImpl() {
        super.setVerificarParam(true);
    }

    /**Gets the bind variable value for pUsuario
     */
    public String getpUsuario() {
        return (String)getNamedWhereClauseParam("pUsuario");
    }

    /**Sets <code>value</code> for bind variable pUsuario
     */
    public void setpUsuario(String value) {
        setNamedWhereClauseParam("pUsuario", value);
    }
    
public void filtrarIdcontrato(Number pIdContrato,Number pRegistroEmpleado, Number pCui){

 if (pIdContrato!=null)
  this.setWhereClause("id_contrato="+pIdContrato);  
 else if (pRegistroEmpleado!=null)
  this.setWhereClause("registro_empleado="+pRegistroEmpleado);
 else if (pCui!=null)
  this.setWhereClause("cui="+pCui);
 else
  this.setWhereClause("");  
    
 this.executeQuery();
 
}

public void quitarFiltros(){
    
    this.setWhereClause("");
    this.executeQuery();   
}

public void consultraSinFiltros(String pUsuario){
    this.setpUsuario(pUsuario);
    this.setWhereClause("");
    this.executeQuery();
}
    
}
