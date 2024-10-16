package enlace_datos.consultas.procesos;

import enlace_datos.consultas.complementos.SisComplementoDetVwRowImpl;

import enlace_datos.consultas.procesos.common.complementos_isr_vw;

import enlace_datos.util.utils_DB;

import oracle.jbo.JboException;
import oracle.jbo.NameValuePairs;
import oracle.jbo.RowIterator;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class complementos_isr_vwImpl extends ViewObjectImpl implements complementos_isr_vw {
    /**This is the default constructor (do not remove)
     */
    public complementos_isr_vwImpl() {
    }


    /**Gets the bind variable value for pFechaI
     */
    public Date getpFechaI() {
        return (Date)getNamedWhereClauseParam("pFechaI");
    }

    /**Sets <code>value</code> for bind variable pFechaI
     */
    public void setpFechaI(Date value) {
        setNamedWhereClauseParam("pFechaI", value);
    }

    /**Gets the bind variable value for pFechaF
     */
    public Date getpFechaF() {
        return (Date)getNamedWhereClauseParam("pFechaF");
    }

    /**Sets <code>value</code> for bind variable pFechaF
     */
    public void setpFechaF(Date value) {
        setNamedWhereClauseParam("pFechaF", value);
    }
    
    public void aplicar_isr(Number pIdProceso, Number pAnio){
        
        System.out.println("print: "+pIdProceso); 
        System.out.println("print: "+pAnio);
        
        Object resultado = "CORRECTO";
        NameValuePairs vParametros;
        vParametros = new NameValuePairs();
        
        vParametros.setAttribute("1",pAnio);
        vParametros.setAttribute("2",pIdProceso); 
               
        //resultado=utils_DB.getValorFuncion(this.getDBTransaction(),"sis_pkg_calculos_isr.CALC_RETEREP_COMPL(?,?)",vParametros);
         
        if(resultado.equals("CORRECTO")){ 
            if (!utils_DB.ejecutarProcedimiento(this.getDBTransaction(),"sis_pkg_calculos_isr.CALC_RETEREP_COMPL(?,?)",vParametros)){
               throw new JboException("Ha ocurrido un error, por favor intente nuevamente","01",null);
            }else{
                this.getDBTransaction().commit();
            }
         }
         else{
             throw new JboException(resultado.toString());              
         }
        
    }
}
