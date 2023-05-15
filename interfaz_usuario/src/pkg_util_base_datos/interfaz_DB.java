package pkg_util_base_datos;

import enlace_datos.procedimientosImpl;

import enlace_datos.util.util_Debug;
import enlace_datos.util.utils;

import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.List;


import java.util.Properties;

import javax.naming.Context;

import javax.naming.InitialContext;

import javax.sql.DataSource;

import oracle.jbo.server.DBTransaction;

import oracle.jdbc.OracleResultSet;

import oracle.sql.CLOB;

import oracle.toplink.internal.security.JCEEncryptor;
import oracle.toplink.util.SessionFactory;

public class interfaz_DB {
    private Connection vCtn_coneccion_base;
    private SessionFactory sessionFactory;
    private String str_URL;
    private Properties prop_conexion;
    private JCEEncryptor encriptor;
    private PreparedStatement sentencia;
    private Statement vSentencia2;
    private String vError;
           
        
    public interfaz_DB(){
    try{
      //sessionFactory =  new SessionFactory("META-INF/sessions.xml", "default");
      //tr_URL=sessionFactory.acquireSession().getLogin().getDatabaseURL();
      //str_URL=sessionFactory.getSharedSession().getLogin().getDatabaseURL();
      //prop_conexion= sessionFactory.getSharedSession().getLogin().getProperties();
     // prop_conexion=sessionFactory.acquireSession().getLogin().getProperties();
     // encriptor=new JCEEncryptor();
    }catch(Exception exep){
        exep.printStackTrace();
    }
    }

   private void crear_conexion()throws Exception {
     //vCtn_coneccion_base = DriverManager.getConnection("jdbc:oracle:thin:@10.0.0.19:1521:dbsiif", prop_conexion.getProperty("user"),  encriptor.decryptPassword(prop_conexion.getProperty("password"))); 
    // vCtn_coneccion_base=sessionFactory.acquireSession().getLogin().getConnector().connect(prop_conexion);
    //  vCtn_coneccion_base = DriverManager.getConnection("jdbc:oracle:thin:@10.0.0.09:1521:dbsiif", "siif", "dbsiif4727"); 
      util_Debug vDeb=new util_Debug();
      
      try{
       Context initContext = new InitialContext();
       DataSource dataSource = (DataSource) initContext.lookup("jdbc/labDS");
     // DataSource dataSource = (DataSource) initContext.lookup("jdbc/sisprodDS");
       vCtn_coneccion_base = dataSource.getConnection();

      }catch(Exception exep){
          vDeb.DebugA("interfaz_DB",37,exep,true);          
       throw exep;   
      }
      
   }

    public Connection get_Coneccion() throws Exception { 
    
    if (vCtn_coneccion_base==null || vCtn_coneccion_base.isClosed()==true){
        crear_conexion();  
    }
    return vCtn_coneccion_base;
    }

    public void cn_Cerrar_coneccion() {
      try{
         if (vCtn_coneccion_base!=null && !vCtn_coneccion_base.isClosed())
        vCtn_coneccion_base.close();
      } catch(Exception eas){
          
      }
    }

    public boolean Bol_ejecutar_procedimiento(String pStr_Nom_proc, 
                                              List pLst_parametros) {
                                              
        CallableStatement sql_querry;
        boolean vResultado=false;
        String str_querry="";
        
        str_querry="call "+ pStr_Nom_proc;
        
        
        try{
        sql_querry=this.get_Coneccion().prepareCall(str_querry);
        
        if (pLst_parametros!=null){

            for (int i=0;i<pLst_parametros.size();i++){
               sql_querry.setObject(i+1,pLst_parametros.get(i)); 
            }
        }    
        
        sql_querry.execute();
        vResultado=true;
        sql_querry.close();
        }catch(Exception exep){
         
            this.vError=utils.getSQLMensaje(exep);
            
            this.cn_Cerrar_coneccion();
            vResultado=false;
           // exep.printStackTrace();
            
        }                                                                                            
                                              
    return vResultado;
    }

    public boolean Crear_sentencia(String pSentencia){
       boolean vResultado=true;
       try{
       sentencia=this.get_Coneccion().prepareStatement(pSentencia);
       }catch(Exception eas){
           vResultado=false;
           eas.printStackTrace();
       }
    return vResultado;
    }

    public boolean setParametrosSentencia(int pPosicion,String pTipo,Object pValor){
        boolean vResultado=true;
        try{
        if (pTipo.equals("String")){
            sentencia.setString(pPosicion,pValor.toString());    
        }else if (pTipo.equals("Int")){
            sentencia.setInt(pPosicion,new Integer(pValor.toString()));    
        }
        
        }catch(Exception eas){
            vResultado=false;
            eas.printStackTrace();
        }
       return vResultado; 
    }
   public boolean setParametrosSentencia(int pPosicion,Object pValor){
       boolean vResultado=true;
       try{
       sentencia.setObject(pPosicion,pValor);
       }catch(Exception eas){
           vResultado=false;
           eas.printStackTrace();
       }
      return vResultado; 
   }
 
  public int ejecutar_update(boolean vCerrarCone){
   int vResultado=0;
    try{
      vResultado=sentencia.executeUpdate();
      if (vCerrarCone)
        this.cn_Cerrar_coneccion();
    }catch(Exception exep){
        vResultado=-1;
        exep.printStackTrace();
    }
   return vResultado; 
  }

  
 public int ejecutar_update(String vSentencia,boolean vCerrarCone){
     int vResultado=0;
      try{
        this.Crear_sentencia(vSentencia);
        vResultado=sentencia.executeUpdate();
        if (vCerrarCone)
          this.cn_Cerrar_coneccion();
      }catch(Exception exep){
          vResultado=-1;
          exep.printStackTrace();
      }
     return vResultado; 
     
 }

    public ResultSet Bol_ejecutar_sentencia(String pStr_Sentencia) {
     ResultSet vResultado;
     try{
       if (vSentencia2==null){
           vSentencia2=this.get_Coneccion().createStatement();
       }
     
       vResultado=vSentencia2.executeQuery(pStr_Sentencia);    
         
     }catch(Exception exep){
       vResultado=null;
       exep.printStackTrace();
     }
    
    return vResultado;
    }
    
    
    public ResultSet Bol_ejecutar_sentencia() {
     ResultSet vResultado;
     try{
       vResultado=sentencia.executeQuery();    
         
     }catch(Exception exep){
       vResultado=null;
       exep.printStackTrace();
     }
    
    return vResultado;
    }
    
    
    /*
     *  Funcion para obtener el valor de una sequencia
     */
    public String getValorSequencia(String strNombre){
        PreparedStatement sql_querry;
        ResultSet vResultado;
        String vValorConsulta=null;
        try{
           sql_querry=get_Coneccion().prepareStatement("select "+strNombre+".nextval as codigo from dual");     
        
        
        vResultado=sql_querry.executeQuery();
        vResultado.next();
        vValorConsulta=vResultado.getObject("codigo").toString();
        sql_querry.close();
        }catch(Exception exep){
            
        }
    return vValorConsulta;
    } 
    
    
    public Object getValorConsultaSimple(String pColumna,String pQuerry){
        PreparedStatement sql_querry;
        ResultSet vResultado;
        Object vValorConsulta=null;
        try{

           sql_querry=get_Coneccion().prepareStatement(pQuerry);     
        
        vResultado=sql_querry.executeQuery();
        vResultado.next();
        vValorConsulta=vResultado.getObject(pColumna);
        sql_querry.close();
        }catch(Exception exep){
            
        }
    return vValorConsulta;
    } 
      
    public Object getValorConsultaSimpleBlob(String pColumna,String pQuerry){
        PreparedStatement sql_querry;
        ResultSet vResultado;
        Object vValorConsulta=null;
        try{

           sql_querry=get_Coneccion().prepareStatement(pQuerry);     
        
        vResultado=sql_querry.executeQuery();
        vResultado.next();
        vValorConsulta=vResultado.getBlob(pColumna);
        sql_querry.close();
        }catch(Exception exep){
            
        }
    return vValorConsulta;
    }   
    public boolean commit(){
       boolean vResultado=false;
        try{
          this.get_Coneccion().commit();
          vResultado=true;
        }catch(Exception exep){
            vResultado=false;
        }
      return vResultado;  
    }
    
    public void rollback(){

        try{
          this.get_Coneccion().rollback();
 
        }catch(Exception exep){

        }

    }
    
    
    public Object getValorConsulta(String pColumna){
        
        ResultSet vResultado;
        Object vValorConsulta=null;
        try{

        vResultado=sentencia.executeQuery();
        vResultado.next();
        vValorConsulta=vResultado.getObject(pColumna);
        sentencia.close();
        
        }catch(Exception exep){
          try{
          
              sentencia.close();   
              
          }catch(Exception exep2){
              
              
          }
            
        }
    return vValorConsulta;
    }   
    
  public void cerrarSentenciaActual(){
  try{
      this.vSentencia2.close();
      vSentencia2=null;
  }catch(Exception exep){
      
  }
  }
    
    
    public Object getValorConsultaSimpleClob(String pColumna,String pQuerry){
        PreparedStatement sql_querry;
        ResultSet vResultado;
        Clob vValorConsulta=null;
        long clobLength;
        int chunkSize;
        char[] textBuffer;
        String vValor;
        
        vValor="";
        sql_querry=null;
        try{
        
        sql_querry=get_Coneccion().prepareStatement(pQuerry);     
        
        vResultado=sql_querry.executeQuery();
        
         if (vResultado.next())
         {
        //vValorConsulta=((OracleResultSet) vResultado).getCLOB(pColumna);
        vValorConsulta=vResultado.getClob(pColumna);
        clobLength = vValorConsulta.length();
       // chunkSize = vValorConsulta.getChunkSize();
        chunkSize=1024;
        textBuffer = new char[(int)clobLength];
        vValorConsulta.getCharacterStream().read(textBuffer);
        vValor=new String(textBuffer);
         }  
         else{
             
            vValor=null; 
            
         }
        sql_querry.close();
        
        }catch(Exception exep){
          try{
            vValor=null;
            sql_querry.close();
            
          }catch(Exception exep2){
              
          }
        }
    return vValor;
    }

    public void setError(String vError) {
        this.vError = vError;
    }

    public String getError() {
        return vError;
    }
}
