package enlace_datos.util;

import enlace_datos.entidades.gestiones.contrato.common.SisContratoImplMsgBundle;

import oracle.jbo.AttrValException;
    
public class MyException extends AttrValException {
    String vValor;
    
    public MyException(String errorCode, Object[] params,String pValor )
    {
    super(SisContratoImplMsgBundle.class, errorCode, params);
    vValor=pValor;
    }

    /**
    * When the message contains a semicolon, return the message
    * starting with the position after the semicolon and limit the
    * text to the message text from the resource bundle.
    *
    * @return the stripped message
    */
    public String getMessage()
    {
    String message = super.getMessage();
    // strip off product code and error code
    int semiColon = message.indexOf(":");
    if (semiColon > 0)
    {
    message = message.substring(semiColon + 2);
    }
    return message+vValor;
    }
}
