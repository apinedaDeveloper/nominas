package enlace_datos.util;

import java.sql.SQLException;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import oracle.jbo.AttrValException;
import oracle.jbo.JboException;
import oracle.jbo.server.DBTransaction;
import oracle.jbo.server.SessionImpl;

import oracle.toplink.exceptions.DatabaseException;


public class utils {
    public static final String vPrefUsuario="T";

    public utils() {
    }
    
    public static String getSQLMensaje2(Exception excep){
        String str_mensaje="",str_codError,str_tokenI="<<";
        oracle.toplink.exceptions.DatabaseException dbaseExcep;
        int indice,indice2;
        
        if (excep.getClass()==DatabaseException.class){
            
            dbaseExcep=(DatabaseException)excep;
             if (dbaseExcep.getDatabaseErrorCode()>=20000){
                 str_codError="ORA-"+dbaseExcep.getDatabaseErrorCode();
                 indice=dbaseExcep.getMessage().indexOf("<<");
                 indice2=dbaseExcep.getMessage().indexOf(">>");
                  if (indice>0 &&indice2>0){
                      str_mensaje=dbaseExcep.getMessage().substring(indice+str_tokenI.length(),indice2);
                  }else {
                      str_mensaje=excep.getMessage().length()>150?excep.getMessage().substring(0,150):excep.getMessage();
                  }
             }
        }else {
            str_mensaje=excep.getMessage().length()>150?excep.getMessage().substring(0,150):excep.getMessage();
        }
      return str_mensaje;  
    }
    
    public static String getSQLMensaje(Exception excep){
        String str_mensaje="",str_Error="",str_tokenI="<<";
        oracle.toplink.exceptions.DatabaseException dbaseExcep;
        oracle.jbo.DMLException vExep2;
        int indice,indice2,vCodigoError=0;
        
        if (excep.getClass()==DatabaseException.class
             ||excep.getClass()==SQLException.class
            ||excep.getClass()==oracle.jbo.DMLException.class){
            
            if (excep.getClass()==DatabaseException.class){
                str_Error=excep.getMessage();
                vCodigoError=((DatabaseException)excep).getDatabaseErrorCode();
            }else if (excep.getClass()==SQLException.class){
               str_Error=excep.getMessage();
               vCodigoError=((SQLException)excep).getErrorCode();
            }else if (excep.getClass()==oracle.jbo.DMLException.class){
               vExep2=(oracle.jbo.DMLException)excep;
               str_Error=excep.getMessage();
               vCodigoError=20000;
                if (vExep2.getDetails().length>0){
                  str_Error=vExep2.getDetails()[0].toString();
                }
                     
            }
        if (vCodigoError>=20000){
                 indice=str_Error.indexOf("<<");
                 indice2=str_Error.indexOf(">>");
                  if (indice>0 &&indice2>0){
                      str_mensaje=str_Error.substring(indice+str_tokenI.length(),indice2);
                  }else {
                      str_mensaje=excep.getMessage();
                      str_mensaje=excep.getMessage().length()>150?excep.getMessage().substring(0,150):excep.getMessage();
                  }
             }
        else {
             //   str_mensaje=excep.getMessage();
                str_mensaje=excep.getMessage().length()>150?excep.getMessage().substring(0,150):excep.getMessage();
            }
        }else {
            str_mensaje=excep.getMessage().length()>150?excep.getMessage().substring(0,150):excep.getMessage();
        }
      return str_mensaje;  
    }   
    
    public static boolean isHora(String phora){
        int indice,minutos,horas;
        try{
        indice=phora.indexOf(":");
         if (indice>0){
            horas=Integer.valueOf(phora.substring(0,indice)); 
            minutos=Integer.valueOf(phora.substring(indice+1,phora.length())); 
             if (!(minutos>=0 &&minutos<=59 &&horas>=0&&horas<=23)){
                 return false;
             }
         }else {
             return false;
         }
        }catch(Exception exep){
            return false;
        }
       return true;  
    } 
     
     
    public static Number getNumber(Object valor){
      Number numValor= new Long (valor.toString());
      return numValor; 
    }   
    
    
    public static Double getNumberDouble(Object valor){
      Double numValor= new Double (valor.toString());
      return numValor; 
    }   
    
    public static oracle.jbo.domain.Number getNumberOracle(Object valor){
    oracle.jbo.domain.Number numValor=null;
     try{
      numValor= new oracle.jbo.domain.Number (valor.toString().replace(",",""));
     }catch(Exception exep){ }
      return numValor; 
    }   
    
    public static Date getFecha(String pValor){
        
        SimpleDateFormat formato =new SimpleDateFormat("dd/mm/yyyy");
        try{
            
            return formato.parse(pValor);    
        
        }catch(Exception exep){
            
        }
     return null;   
    }  
    
    public static String getFechaFormato(String pMascara,Date pFecha){
        String vFormato;
        SimpleDateFormat formato = new SimpleDateFormat(pMascara);
        vFormato=formato.format(pFecha);
        return vFormato;
        
    }
    
    public static String getFechaFormato(Date pFecha){
        String vFormato;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        vFormato=formato.format(pFecha);
        return vFormato;
        
    }
    
    public static oracle.jbo.domain.Date getFechaOracle(String pValor){
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        oracle.jbo.domain.Date vFecha1;
        java.sql.Date vFecha2;
        
        try{
        
            vFecha2 = new java.sql.Date(formato.parse(pValor).getTime());
            
            //  formato.parse(pValor);
            
            vFecha1=new oracle.jbo.domain.Date(vFecha2);
            return vFecha1;
         
        }catch(Exception exep){
            exep.printStackTrace();
        }
     return null;   
    }  
    
    
    public static oracle.jbo.domain.Date getFechaOracle(String pMascara,String pValor){
        
        SimpleDateFormat formato = new SimpleDateFormat(pMascara);
        oracle.jbo.domain.Date vFecha1;
        java.sql.Date vFecha2;
        
        try{
        
            vFecha2 = new java.sql.Date(formato.parse(pValor).getTime());
            //  formato.parse(pValor);
            
           // vFecha1=new oracle.jbo.domain.Date(vFecha2);
            vFecha1=new oracle.jbo.domain.Date(new java.sql.Timestamp(formato.parse(pValor).getTime()));
            return vFecha1;
         
        }catch(Exception exep){
            exep.printStackTrace();
        }
     return null;   
    }  
    
    public static int getNumMes(String vMes){
        int vNumMes;
        if (vMes.toUpperCase().equals("ENERO")){
            vNumMes=1;    
        }else if (vMes.toUpperCase().equals("FEBRERO")){
            vNumMes=2;    
        }else if (vMes.toUpperCase().equals("MARZO")){
            vNumMes=3;    
        }else if (vMes.toUpperCase().equals("ABRIL")){
            vNumMes=4;    
        }else if (vMes.toUpperCase().equals("MAYO")){
            vNumMes=5;    
        }else if (vMes.toUpperCase().equals("JUNIO")){
            vNumMes=6;    
        }else if (vMes.toUpperCase().equals("JULIO")){
            vNumMes=7;    
        }else if (vMes.toUpperCase().equals("AGOSTO")){
            vNumMes=8;    
        }else if (vMes.toUpperCase().equals("SEPTIEMBRE")){
            vNumMes=9;    
        }else if (vMes.toUpperCase().equals("OCTUBRE")){
            vNumMes=10;    
        }else if (vMes.toUpperCase().equals("NOVIEMBRE")){
            vNumMes=11;    
        }else if (vMes.toUpperCase().equals("DICIEMBRE")){
            vNumMes=12;    
        }else{
            vNumMes=-1;    
        }
        
      return vNumMes;  
    }

 public static String getAuthUser(DBTransaction pConec){
     String vUsuario;
     try{
     
     SessionImpl vSesion=(SessionImpl)pConec.getSession();
     vUsuario=vSesion.getUserPrincipalName();
     
         if (vUsuario.startsWith(vPrefUsuario)){
             vUsuario=vUsuario.substring(vPrefUsuario.length(),vUsuario.length()); 
         }else{
             vUsuario=vUsuario.trim();
         }
     
     }catch(Exception exep){
         vUsuario="";
     }
     return vUsuario;
 }

public static boolean IsUserInRole(DBTransaction pConec,String pRol){
    SessionImpl vSesion;
    
    vSesion=(SessionImpl)pConec.getSession();
    // System.out.println("debug: " + getAuthUser(pConec));
     return vSesion.isUserInRole(pRol);
  
}

public static boolean isNumber(String pValor){
    oracle.jbo.domain.Number numValor=null;
    boolean vResultado=true;
     try{
      numValor= new oracle.jbo.domain.Number (pValor.toString());
     }catch(Exception exep)
       {
        vResultado=false; 
        }
      return vResultado;  
    }

public static String getFormatoNumero(Object pValor,String pFormato){
    DecimalFormat formato= new DecimalFormat(pFormato);
    String vResultado;
      try{  
        vResultado=formato.format(utils.getNumber(pValor));
      }catch( Exception exep){
          vResultado="";
      }        
   return vResultado; 
}

    public static String getFechaFormato(String pMascara,oracle.jbo.domain.Date pFecha){
        String vFormato;
        SimpleDateFormat formato = new SimpleDateFormat(pMascara);
        vFormato=formato.format(pFecha.getValue());
        return vFormato;
        
    }

    /*
     *  Metodo para obtener el año actual
     */
    public static String getAnioActual(){
        String vResultado;
        SimpleDateFormat ab= new SimpleDateFormat("yyyy"); 
        vResultado=ab.format(new Date());
        return vResultado;
    }

    public static boolean isEmail(String pEmail){
     boolean vResultado;
     try{ 
        //vResultado=pEmail.matches("[A-Za-z0-9._()\\[\\]-]+@[A-Za-z0-9._]+");
        vResultado=pEmail.matches("[A-Za-z0-9][A-Za-z0-9._-]+@[A-Za-z0-9._-]+\\.[A-Za-z]{2,4}");
     }catch(Exception exep){
        vResultado=false;
     }
     return vResultado;
    }

    public static boolean isEmailInstitucional(String pEmail) {
        boolean vResultado = false;
        ArrayList<String> vDominios = new ArrayList<String>();
        vDominios.add("@usac.edu.gt");
        /*vDominios.add("@fahusac.edu.gt");
        vDominios.add("@cunoc.edu.gt");
        vDominios.add("@cunzac.edu.gt");
        vDominios.add("@psicousac.edu.gt");
        vDominios.add("@fausac.gt");
        vDominios.add("@farusac.edu.gt");
        vDominios.add("@alumno.usac.edu.gt");
        vDominios.add("@profesor.usac.edu.gt");
        vDominios.add("@plataformaecc.usac.edu.gt");*/
        try {
            /*System.out.println("EndsWith character 'usac.edu.gt': " + 
                               pEmail.endsWith("@usac.edu.gt"));*/
            Iterator<String> vIterator = vDominios.iterator();
            while (vIterator.hasNext()) {
                String elemento = vIterator.next();
                //System.out.print(elemento + " / ");
                if (pEmail.endsWith(elemento)) {
                    vResultado = true;
                    /*System.out.println("Se encontró coincidencia con: " + 
                                       elemento);*/
                    break;
                }
            }
        } catch (Exception exep) {
            vResultado = false;
        }
        return vResultado;
    }

    public static oracle.jbo.domain.Date getFechaActual(){
     return new oracle.jbo.domain.Date(new java.sql.Timestamp(System.currentTimeMillis()));   
    }
    
    /*
    public static AttrSetValException getAttributeException(String pNomEntidad,String pNomAtributo,String pCodigoError,Object pValor){
        AttrSetValException vException;
        vException= new AttrSetValException(121,msgBundleDatos.class,pCodigoError,pNomEntidad,pNomAtributo,pValor);
        vException.setAppendCodes(false);
        return vException;
    }
    */
    
     public static AttrValException getAttributeException(String pNomEntidad,String pNomAtributo,String pCodigoError,Object pValor){
         AttrValException vException;
         vException= new AttrValException(0,msgBundleDatos.class,pCodigoError,pNomEntidad,pNomAtributo);
         vException.setAppendCodes(false);
         return vException;
     }
     
     public static JboException getJboException(String pMensaje,String pCodigo,boolean showCode){
         JboException vError;
         vError=new JboException(pMensaje,pCodigo,null);
         vError.setAppendCodes(showCode);
         return vError;
     }
     
     
    
    public static String getHTMLCode(String pCadena){
        
        char[] vCaracteres;    
        String vNuevaCadena="";
        
        if (pCadena!=null)
        {
        vCaracteres=pCadena.toCharArray();
        
        for (int i=0;i<vCaracteres.length;i++){
            
            if (vCaracteres[i]=='Á'){
                vNuevaCadena+="&Aacute;";
            }else if (vCaracteres[i]=='É'){
                vNuevaCadena+="&Eacute;";
            }else if (vCaracteres[i]=='Í'){                
                vNuevaCadena+="&Iacute;";
            }else if (vCaracteres[i]=='Ó'){                
                vNuevaCadena+="&Oacute;";
            }else if (vCaracteres[i]=='Ú'){
                vNuevaCadena+="&Uacute;";
            }
            else if (vCaracteres[i]=='ó'){
                vNuevaCadena+="&oacute;";
            }else if (vCaracteres[i]=='á'){                
                 vNuevaCadena+="&aacute;";
            }else if (vCaracteres[i]=='é'){                
                 vNuevaCadena+="&eacute;";
            }else if (vCaracteres[i]=='í'){                
                 vNuevaCadena+="&iacute;";
            }else if (vCaracteres[i]=='ú'){                
                 vNuevaCadena+="&uacute;";
            }else if (vCaracteres[i]=='ñ'){
                vNuevaCadena+="&ntilde;";
            }else if (vCaracteres[i]=='Ñ'){
                vNuevaCadena+="&Ntilde;";
            }
            else{
                vNuevaCadena+=String.valueOf(vCaracteres[i]); 
            }            
        }
        
       return vNuevaCadena;
       }else{
           return null;
       }
    }


    public static String getHTMLDecode(String pCadena){
    String vCadena;
    
    if (pCadena!=null)
    {
    vCadena=pCadena;
    vCadena=vCadena.replace("&aacute;", "á");
    vCadena=vCadena.replace("&eacute;", "é");
    vCadena=vCadena.replace("&iacute;", "í");
    vCadena=vCadena.replace("&oacute;", "ó");
    vCadena=vCadena.replace("&uacute;", "ú");
    vCadena=vCadena.replace("&Aacute;", "Á");
    vCadena=vCadena.replace("&Eacute;", "É");
    vCadena=vCadena.replace("&Iacute;", "Í");
    vCadena=vCadena.replace("&Oacute;", "Ó");
    vCadena=vCadena.replace("&Uacute;", "Ú");
        
    vCadena=vCadena.replace("&ntilde;", "n");
    vCadena=vCadena.replace("&Ntilde;", "Ñ");        
   
    return vCadena;
    }else{
    return null;    
    }
    
}    
 /*
  *  Metodo para obtener el año actual
 */
 public static String getMesActual(){
String vResultado;
SimpleDateFormat ab= new SimpleDateFormat("MM"); 
vResultado=ab.format(new Date());
return vResultado;
 }
 
 
 /*
  * Devuelve la cadena sin acentos ni eñes 
  */
public static String getSimpleChar(String pCadena){
        
char[] vCaracteres;    
String vNuevaCadena="";
        
if (pCadena!=null)
{
   vCaracteres=pCadena.trim().toCharArray();
        
    for (int i=0;i<vCaracteres.length;i++){
            
            if (vCaracteres[i]=='Á'){
                vNuevaCadena+="A";
            }else if (vCaracteres[i]=='É'){
                vNuevaCadena+="E";
            }else if (vCaracteres[i]=='Í'){                
                vNuevaCadena+="I";
            }else if (vCaracteres[i]=='Ó'){                
                vNuevaCadena+="O";
            }else if (vCaracteres[i]=='Ú'){
                vNuevaCadena+="U";
            }
            else if (vCaracteres[i]=='ó'){
                vNuevaCadena+="o";
            }else if (vCaracteres[i]=='á'){                
                 vNuevaCadena+="a";
            }else if (vCaracteres[i]=='é'){                
                 vNuevaCadena+="e";
            }else if (vCaracteres[i]=='í'){                
                 vNuevaCadena+="i";
            }else if (vCaracteres[i]=='ú'){                
                 vNuevaCadena+="u";
            }else if (vCaracteres[i]=='ñ'){
                vNuevaCadena+="n";
            }else if (vCaracteres[i]=='Ñ'){
                vNuevaCadena+="N";
            }
            else{
                vNuevaCadena+=String.valueOf(vCaracteres[i]); 
            }            
        }
        
    return vNuevaCadena;
      }else{
      return null;
 }
}
 
    
}

