package enlace_datos.consultas.gestiones;

import enlace_datos.consultas.gestiones.common.SaldoAnualvw;

import enlace_datos.util.utils_DB;

import oracle.jbo.JboException;
import oracle.jbo.NameValuePairs;
import oracle.jbo.domain.Number;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SaldoAnualvwImpl extends ViewObjectImpl implements SaldoAnualvw {
    /**This is the default constructor (do not remove)
     */
    public SaldoAnualvwImpl() {
    }

    public void filtrarPartida(Number pAnio, Number pPartida){
        //System.out.println("llamando a filtrar partida de saldo anual, anio="+pAnio+", partida="+pPartida);
        this.setWhereClause("Anio = "+pAnio+" and Id_Partida="+pPartida);
        this.executeQuery();
    }

    public void setActualizarSaldoAnual(Number pAnio, Number pIdPartida, Number pValor){
        boolean vResultado; 
        NameValuePairs Parametros=new NameValuePairs();
        Parametros.setAttribute("1",pAnio);
        Parametros.setAttribute("2",pIdPartida);
        Parametros.setAttribute("3",pValor);
        System.out.println("Anio:="+pAnio+", partida:="+pIdPartida);
        vResultado=utils_DB.ejecutarProcedimiento(this.getDBTransaction(),"SIS_PKG_CALCULOS.ActualizarSaldoAnual(?,?,?)",Parametros); 
               
        if (vResultado==false){
          this.getDBTransaction().rollback();
          throw new JboException("Ha ocurrido un error al ACTUALIZAR LOS DATOS, por favor revisar");
        }else{
            //System.out.println("todo nais");
          this.getDBTransaction().commit();
        }
    }    

}
