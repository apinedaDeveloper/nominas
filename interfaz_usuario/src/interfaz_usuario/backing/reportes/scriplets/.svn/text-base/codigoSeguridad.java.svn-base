package interfaz_usuario.backing.reportes.scriplets;

import controller.Generador;

import java.math.BigDecimal;

import net.sf.jasperreports.engine.JRDefaultScriptlet;
import net.sf.jasperreports.engine.JRScriptletException;

public class codigoSeguridad extends JRDefaultScriptlet{
    public codigoSeguridad() {
    }
    
    public String getCodigoSeg(String pCheque,String pInventario, BigDecimal pMonto) throws JRScriptletException     
    {
        
        Generador vLlave;
        vLlave= new Generador();
        String pResultado;
        
        try{
        pResultado=vLlave.GenerarCodigo("3033343584",pCheque,pInventario,pMonto);
            
        }catch(Exception exep){
            
           pResultado="";
        }
        
        
     return pResultado;   
    }
 
 
 public static void main(String []args){
    try{ 
     System.out.println( new codigoSeguridad().getCodigoSeg("9123123","14555",new BigDecimal(45456)) );
     
    }catch(Exception exep){
        
        
    }
     
 }
    
}
