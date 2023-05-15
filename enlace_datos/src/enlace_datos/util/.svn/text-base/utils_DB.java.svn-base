package enlace_datos.util;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Types;

import java.util.ArrayList;

import oracle.jbo.NameValuePairs;
import oracle.jbo.domain.Number;
import oracle.jbo.server.DBTransaction;

public class utils_DB {
    public utils_DB() {
    }
    
   /*
    *  Funcion para obtener el valor de una sequencia
    */
   public static String getValorSequencia(DBTransaction pTransaccion,String strNombre){
       PreparedStatement sql_querry;
       ResultSet vResultado;
       String vValorConsulta=null;
       sql_querry=pTransaccion.createPreparedStatement("select "+strNombre+".nextval as codigo from dual",0);
       try{
       vResultado=sql_querry.executeQuery();
       vResultado.next();
       vValorConsulta=vResultado.getObject("codigo").toString();
       sql_querry.close();
       }catch(Exception exep){
           
       }
   return vValorConsulta;
   }
   
   /*
    * Metodo para obtener el estado de una det tabla
    */
    public static Number getIdEstado(DBTransaction pTransaccion,String strNombre,String vTabla){
        PreparedStatement sql_querry;
        ResultSet vResultado;
        Number id_estado=null;
        sql_querry=pTransaccion.createPreparedStatement("select id_estado from sis_estado where tabla=? and nombre=?",0);
        try{
        sql_querry.setString(1,vTabla);
        sql_querry.setString(2,strNombre);
        
        vResultado=sql_querry.executeQuery();
        vResultado.next();
        id_estado=new Number(vResultado.getBigDecimal("id_estado"));
        sql_querry.close();
        }catch(Exception exep){
            
        }
    return  id_estado;
    }
   
   /*
    * Obtener un valor simple de una consulta
    */
    public static Object getValorTabla(DBTransaction pTransaccion,String vTabla,String vColumna,NameValuePairs vRestriccion){
        PreparedStatement sql_querry;
        ResultSet vResultado;
        Object vValor=null;
        String str_querry="";
        String []nomColumnas=null;
        
       
        
        if (vRestriccion!=null){
            str_querry="select "+ vColumna +" from " + vTabla + " where ";
            nomColumnas = vRestriccion.getAttributeNames();
                    for (int i=0;i<nomColumnas.length;i++){
                      if (i==0 ){
                          if (vRestriccion.getAttribute(i)!=null)    
                                str_querry=str_querry+ nomColumnas[i]+" = ?" ;
                          else
                              str_querry=str_querry+ " and " + nomColumnas[i];
                      }
                      else{
                         if (vRestriccion.getAttribute(i)!=null)   
                           str_querry=str_querry+ " and " + nomColumnas[i]+" = ?" ;
                         else
                           str_querry=str_querry+ " and " + nomColumnas[i];
                         }
                    }
        }
        else
            str_querry="select "+ vColumna +" from " + vTabla;
        
        sql_querry=pTransaccion.createPreparedStatement(str_querry,0);
        try{
       
          if (nomColumnas!=null){    
                for (int i=0;i<nomColumnas.length;i++){
                      if (vRestriccion.getAttribute(i)!=null)   
                        sql_querry.setObject(i+1,vRestriccion.getAttribute(i)); 
                }
          }
    
        vResultado=sql_querry.executeQuery();
        vResultado.next();
        vValor=vResultado.getObject(vColumna);
        sql_querry.close();
        }catch(Exception exep){
            
        }
    return  vValor;
    }
   
 
    /*
     * Obtener un valor de una funcion
     */
     public static Object getValorFuncion(DBTransaction pTransaccion,String vFuncion,NameValuePairs vRestriccion){
              PreparedStatement sql_querry;
              ResultSet vResultado;
              Object vValor=null;
              String str_querry="";
              String []nomColumnas;
              
            
              str_querry="select "+ vFuncion +" from dual ";
              
              sql_querry=pTransaccion.createPreparedStatement(str_querry,0);
              try{
              if (vRestriccion!=null){
                  nomColumnas = vRestriccion.getAttributeNames();
                  for (int i=0;i<vRestriccion.getAttributeCount();i++){
                     sql_querry.setObject(i+1,vRestriccion.getAttribute(i)); 
                  }
              }    
          
              vResultado=sql_querry.executeQuery();
              vResultado.next();
              vValor=vResultado.getObject(1);
              sql_querry.close();
              }catch(Exception exep){
                exep.printStackTrace();   
              }
          return  vValor;
          }
             
 
    /*
     *  Metodo para llamar a un procedimiento
     */
     public static boolean ejecutarProcedimiento(DBTransaction pTransaccion,String vFuncion,NameValuePairs vRestriccion){
              CallableStatement sql_querry;
              boolean vResultado=false;
              String str_querry="";
              String []nomColumnas;
              
            
              str_querry="call "+ vFuncion;
              
              sql_querry=pTransaccion.createCallableStatement(str_querry,0);
              try{
              if (vRestriccion!=null){
                  nomColumnas = vRestriccion.getAttributeNames();
                  for (int i=0;i<vRestriccion.getAttributeCount();i++){
                     
                     if (vRestriccion.getAttribute(i)!=null)
                     sql_querry.setObject(i+1,vRestriccion.getAttribute(i)); 
                       else
                     sql_querry.setNull(i+1,Types.NULL); 
                     
                  }
              }    
          
              sql_querry.execute();
              vResultado=true;
              sql_querry.close();
              }catch(Exception exep){
                  vResultado=false;
                  exep.printStackTrace();
                  try{
                  sql_querry.close();
                  }catch(Exception exep2){
                      
                  }
              }
          return  vResultado;
          }
    
    /*
     * Obtener un valor de una funcion
     */
     public static Object getValorFuncion2(DBTransaction pTransaccion,String vFuncion,NameValuePairs vRestriccion,String pQuerryValor){
              PreparedStatement sql_querry;
              ResultSet vResultado;
              Object vValor=null;
              String str_querry="";
              String []nomColumnas;
              
//              declare id number; begin id:=sis_pkg_util.getNumeroAutorizacion(20080236,682,37,'LICENCIA','NO'); end;
            
              str_querry="declare id number; begin id:="+ vFuncion +"; end; ";
              
              sql_querry=pTransaccion.createPreparedStatement(str_querry,0);
              try{
              if (vRestriccion!=null){
                  nomColumnas = vRestriccion.getAttributeNames();
                  for (int i=0;i<vRestriccion.getAttributeCount();i++){
                     sql_querry.setObject(i+1,vRestriccion.getAttribute(i)); 
                  }
              }    
          
              vResultado=sql_querry.executeQuery();
              vResultado.next();
              vResultado.close();
              sql_querry=pTransaccion.createPreparedStatement(pQuerryValor,0);
              vResultado=sql_querry.executeQuery();
              vResultado.next();
              vValor=vResultado.getObject(1);
              sql_querry.close();
              }catch(Exception exep){
                exep.printStackTrace();   
              }
          return  vValor;
          }
    
    /*
     * Obtener un valor simple de una consulta
     */
     public static Object getEjecutarQuerry(DBTransaction pTransaccion,String psqlQuerry){
         PreparedStatement sql_querry;
         ResultSet vResultado;
         Object vValor=null;
    
         
         sql_querry=pTransaccion.createPreparedStatement(psqlQuerry,0);
         try{
        
         vResultado=sql_querry.executeQuery();
         vResultado.next();
         vValor=vResultado.getObject(1);
         sql_querry.close();
         
         
         }catch(Exception exep){
            try{
                sql_querry.close();
            }catch(Exception exep2){
                
            }
             
         }
     return  vValor;
     }
     
     
     
    /*
     * Metodo para ejecutar un update
     */
     public static int getEjecutarConsulta(DBTransaction pTransaccion,String psqlQuerry){
         PreparedStatement sql_querry;
         int vResultado=-1;
    
         
         sql_querry=pTransaccion.createPreparedStatement(psqlQuerry,0);
         try{
        
         vResultado=sql_querry.executeUpdate();
         sql_querry.close();
         }catch(Exception exep){
            try{
                sql_querry.close();
            }catch(Exception exep2){
                
            }
             
         }
     return  vResultado;
     }

     
 //metodo que retorna una tupla    
    public static ResultSet getEjecutarQuerry(DBTransaction pTransaccion,String psqlQuerry, int bandera){
        PreparedStatement sql_querry;
        ResultSet vResultado;
        vResultado = null;     
        sql_querry=pTransaccion.createPreparedStatement(psqlQuerry,0);
        
        try{
       
        vResultado=sql_querry.executeQuery();
        }catch(Exception exep){
            
        }
    return  vResultado;
    }
 
 
    /*
     *  Metodo para llamar a un procedimiento
     */
     public static boolean ejecutarProcedimiento2(DBTransaction pTransaccion,ArrayList vFuncion,ArrayList vRestriccion){
              CallableStatement sql_querry;
              boolean vResultado=false;
              String str_querry="";
              String []nomColumnas;
              
              for (int i2=0;i2<vFuncion.size();i2++)
              {
              
                  str_querry="call "+ vFuncion.get(i2); 
                  sql_querry=pTransaccion.createCallableStatement(str_querry,0);
                  try{
                  if (vRestriccion!=null){
                      nomColumnas = ((NameValuePairs)vRestriccion.get(i2)).getAttributeNames();
                      for (int i=0;i<((NameValuePairs)vRestriccion.get(i2)).getAttributeCount();i++){
                         sql_querry.setObject(i+1,((NameValuePairs)vRestriccion.get(i2)).getAttribute(i)); 
                      }
                  }    
              

                      sql_querry.execute();
                      vResultado=true;
                   
                  }catch(Exception exep){
                      vResultado=false;
                      exep.printStackTrace();
                  }
                  }
              
          //sql_querry.close();
          return  vResultado;
          }
    
public static String ejecutarProcedimiento3(DBTransaction pTransaccion,String vFuncion,NameValuePairs vRestriccion){
CallableStatement sql_querry;
String vResultado="";
String str_querry="";
String []nomColumnas;
             
           
str_querry="call "+ vFuncion;
             
sql_querry=pTransaccion.createCallableStatement(str_querry,0);
try{
    if (vRestriccion!=null){
         nomColumnas = vRestriccion.getAttributeNames();
        for (int i=0;i<vRestriccion.getAttributeCount();i++){
                    
          if (vRestriccion.getAttribute(i)!=null)
            sql_querry.setObject(i+1,vRestriccion.getAttribute(i)); 
          else
             sql_querry.setNull(i+1,Types.NULL); 
                  
               }
       }    
         
      sql_querry.execute();
      vResultado="OK";
      sql_querry.close();
      }catch(Exception exep){
           vResultado=utils.getSQLMensaje(exep);
           
           try{
               sql_querry.close();    
               
           }catch(Exception exep2){
            
           }
           
          exep.printStackTrace();
      }
return  vResultado;
}
    
}
