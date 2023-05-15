package enlace_datos.util;

import java.security.MessageDigest;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import sun.misc.HexDumpEncoder;

public class encription {
    String vProveedor;
    String vTransformacion;
    String vClave;
    
    public static void main(String []args){
        encription prueba;
        prueba= new encription();
       // System.out.println(prueba.encriptarDES("esta es una prueba.",null));
        //System.out.println(prueba.desencriptarDES("581edb36e33529da3e22c5b2ffa1db7cce66e90a4c018fce",null));
         System.out.println(prueba.encriptarMD5("20090203"));
//        581edb36e33529da3e22c5b2ffa1db7cce66e90a4c018fce

    }
    
        
    public encription() {
        vProveedor="SunJCE";
        vTransformacion="DES/ECB/PKCS5Padding";
        vClave="_?GHiz85-78*(Yb";
    }
    
    public void setTransformacino(String pTransformacion){
        this.vTransformacion=pTransformacion;
    }
    
    public void setProveedor(String pProveedor){
        this.vProveedor=pProveedor;
    }
    
    public void setClave(String pClave){
        this.vClave=pClave;
    }
    
    /*
     * Metodo para encriptar una cadena con el alg DES
     */
    public String encriptarDES(String pCadena,String pClave){
        byte [] vTextoEncrip;
        DESKeySpec desKeySpec;
        SecretKeyFactory keyFactory;
        SecretKey secretKey;
        Cipher vEncriptador;
        String vResultado;
        try{       
                if (pClave!=null)
                    desKeySpec = new DESKeySpec(pClave.getBytes());
                else
                    desKeySpec = new DESKeySpec(this.vClave.getBytes());
                    
                   keyFactory= SecretKeyFactory.getInstance("DES");
                   secretKey = keyFactory.generateSecret(desKeySpec);
                   vEncriptador = Cipher.getInstance(this.vTransformacion, this.vProveedor);
                   vEncriptador.init(Cipher.ENCRYPT_MODE, secretKey);
                   vTextoEncrip = vEncriptador.doFinal(pCadena.getBytes()); 
                   vResultado=this.getCadenaHex(vTextoEncrip);
        }catch(Exception exep){
            vResultado="";
            exep.printStackTrace();
        }
      return vResultado;  
    }
    
    /*
     * Metodo para desencriptar una cadena en DES
     */
    
  public String desencriptarDES(String pCadena,String pClave){
      byte [] vTextoDesEncripSource;
      byte [] vTextoDesEncrip;
      DESKeySpec desKeySpec;
      SecretKeyFactory keyFactory;
      SecretKey secretKey;
      Cipher vEncriptador;
      String vResultado;
      try{       
      
              vTextoDesEncripSource=this.getBytesFromHex(pCadena);
      
              if (pClave!=null)
                  desKeySpec = new DESKeySpec(pClave.getBytes());
              else
                  desKeySpec = new DESKeySpec(this.vClave.getBytes());
                  
                 keyFactory= SecretKeyFactory.getInstance("DES");
                 secretKey = keyFactory.generateSecret(desKeySpec);
                 vEncriptador = Cipher.getInstance(this.vTransformacion, this.vProveedor);
                 vEncriptador.init(Cipher.DECRYPT_MODE, secretKey);
                 vTextoDesEncrip = vEncriptador.doFinal(vTextoDesEncripSource); 
                 vResultado=new String(vTextoDesEncrip);
                
      }catch(Exception exep){
          vResultado="";
          exep.printStackTrace();
      }
    return vResultado;  
  }
    
  /*
   * Metodo para devolver un array de bytes a partir de una cadena HEx
   */
    
   private byte[] getBytesFromHex(String cadena){
     int vTamCadena,vPosicion;
     String vTemp;
     byte [] vResultado=null;
     vTamCadena=cadena.length();
     if (vTamCadena>2){
         vTamCadena=vTamCadena/2;
        vResultado=new byte[vTamCadena];
        vPosicion=0;
        
     for (int i=0;i<vTamCadena;i++){
        vTemp=cadena.substring(vPosicion,vPosicion+2);
        vResultado[i]=(byte)Integer.parseInt(vTemp,16);
        vPosicion+=2;
     }
       
       }
    return vResultado;            
   }
    
  /*
   * Metodo para devolver una cadena en hex a partir de un array de bytes
   */
 private String getCadenaHex(byte[] pValores)   {
   String vResultado,vTemp;
   int vCantidad;
   vCantidad=pValores.length;
   vResultado="";
   vTemp= new String(pValores);
   char [] vValoresInt=vTemp.toCharArray();
   
   
     for (int i=0;i<vCantidad;i++){
        vTemp=Integer.toHexString(pValores[i]<0?256+pValores[i]:pValores[i]);
        if (vTemp.length()<=1){
           vTemp="0"+vTemp; 
        }
        vResultado=vResultado+vTemp;
     }
   return vResultado;  
 }
 
 /*
  * Metodo para encriptar una cadena con el algoritmo MD5
  */
 public String encriptarMD5(String pCadena){
     
     MessageDigest vMsgDigest;
     String vCadenaEncriptada;
     try{
     
         vMsgDigest= MessageDigest.getInstance("MD5");
         vMsgDigest.update(pCadena.getBytes());
         byte vTextoEcriptado[] = vMsgDigest.digest();
         vCadenaEncriptada=getCadenaHex(vTextoEcriptado);
    
     }catch(Exception exep){
         
         vCadenaEncriptada="";
     }
   return vCadenaEncriptada;
   
  }

}
