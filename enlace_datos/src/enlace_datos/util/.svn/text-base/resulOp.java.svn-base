package enlace_datos.util;

import java.io.Serializable;


public class resulOp  implements resulOpInter{
  public static final int OPE_ERROR=1;
  public static final int OPE_OK=2;
  public static final int OPE_WARN=3;
   private int codigoResultado;
   private String mensajeError;
    public resulOp(){
        
    }
    public resulOp(int pCodigoError,String pMensajeError) {
     this.codigoResultado=pCodigoError;
     this.mensajeError=pMensajeError;
    }
    
  public int getCodigoResultado(){ return this.codigoResultado;}
  public void setCodigoResultado(int pCodigoError){ this.codigoResultado=pCodigoError;}
  public String getMensajeError(){return this.mensajeError;}
  public void setMensajeError(String pMensajeError){this.mensajeError=pMensajeError;}
}
