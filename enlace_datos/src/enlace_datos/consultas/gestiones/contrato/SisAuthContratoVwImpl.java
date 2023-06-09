package enlace_datos.consultas.gestiones.contrato;

import enlace_datos.consultas.gestiones.contrato.common.SisAuthContratoVw;

import enlace_datos.util.utils;

import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SisAuthContratoVwImpl extends ViewObjectImpl implements SisAuthContratoVw {
    /**This is the default constructor (do not remove)
     */
    public SisAuthContratoVwImpl() {
    }

    /**Gets the bind variable value for usuario
     */
    public String getusuario() {
        return (String)getNamedWhereClauseParam("usuario");
    }

    /**Sets <code>value</code> for bind variable usuario
     */
    public void setusuario(String value) {
        setNamedWhereClauseParam("usuario", value);
    }
    
    public void darBaja(){
        
        
        ((SisAuthContratoVwRowImpl)this.getCurrentRow()).setFechaBaja(utils.getFechaActual());
        this.getDBTransaction().commit();
        
    }
    
}
