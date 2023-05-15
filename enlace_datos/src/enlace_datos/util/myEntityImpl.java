package enlace_datos.util;

import enlace_datos.consultas.QUERRYSImpl;

import java.sql.CallableStatement;

import java.sql.SQLException;
import java.sql.Types;

import oracle.jbo.NameValuePairs;
import oracle.jbo.domain.Date;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;


public class myEntityImpl extends EntityImpl {
    public int[] vColumnasVerif; 
    
    public myEntityImpl() {
    }
    
    public String guardarCambiosBitacora(){
      String vCadena;
      vCadena="";
      Object vValorAnterior,vValorActual;
      
      try{
        if (vColumnasVerif!=null && vColumnasVerif.length>0)
        {
        
          for (int i=0;i<vColumnasVerif.length;i++)
          {
              vValorAnterior=this.getPostedAttribute(vColumnasVerif[i]);
              vValorActual=this.getAttribute(vColumnasVerif[i]);
              
              vValorAnterior=(vValorAnterior==null?"":vValorAnterior);
              vValorActual=(vValorActual==null?"":vValorActual);
              
              if (this.isAttributeChanged(vColumnasVerif[i]))
              {
               if(!vValorAnterior.equals(vValorActual))
               {
                 if (vValorAnterior.getClass()==Date.class){
                 
                     vValorAnterior=utils.getFechaFormato("dd/MM/yyyy",(Date)vValorAnterior);
                      vValorActual=utils.getFechaFormato("dd/MM/yyyy",(Date)vValorActual);
                     
                 }
                 
                  //vCadena=vCadena+"["+this.getAttributeNames()[vColumnasVerif[i]]+":"+vValorAnterior+"|"+vValorActual+"]";   
                   vCadena=vCadena+"["+i+":"+vValorAnterior+"|"+vValorActual+"]";   
               }
             }
          }
       
       }    
       
      }catch(Exception exep){
          
          
      }
       
       return vCadena;
   // System.out.println(" cambios" +vCadena);  
  }
  
  public Object[] getCambioAtributo(int pAtributo)
  {  
      Object [] pValores= {null,null};
      
      if (this.isAttributeChanged(pAtributo))
      {
      
          pValores[0]=this.getPostedAttribute(pAtributo);
          pValores[1]=this.getAttribute(pAtributo);
          
      }
     
    return pValores;  
  }
  
  
    public boolean verificaCambioColumnas(){
        if (vColumnasVerif!=null && vColumnasVerif.length>0)
        {
        
          for (int i=0;i<vColumnasVerif.length;i++)
          {
              if (this.isAttributeChanged(vColumnasVerif[i]))
              {
                 return true;
              }
          }
       
       }        
     return false;
    }
     
 
 
    /* Agregar el siguiente método:*/

        protected void registrarLogOperaciones(int operation, TransactionEvent e) {
            String entityName = getEntityDef().getName();
            int count = getEntityDef().getAttributeCount();
            String name = "";
            String associationAccessorName = "";
            String val = null;
            String oldval = null;
            String dmlAction = null;
            String vId_Bitacora_Tabla = null;
            String vIdBitacora = null;
            QUERRYSImpl vAPP;
            NameValuePairs vllave=new NameValuePairs();
            boolean isDet=false;

            if (operation == DML_INSERT) {
            dmlAction = "INSERT";
            } else if (operation == DML_UPDATE) {
            dmlAction = "UPDATE";
            } else if (operation == DML_DELETE) {
            dmlAction = "DELETE";
            }

            
             vAPP=(QUERRYSImpl)this.getDBTransaction().getRootApplicationModule();
             vIdBitacora=vAPP.getIdBitacora();

            try {
                String llamada = "BEGIN BITACORA_PK.registrarEventoTabla(?,?,?,?); END;";
                CallableStatement cs = getDBTransaction().createCallableStatement(llamada,0);
                cs.setString(1,entityName);
                cs.setString(2,dmlAction);
                cs.setString(3,vIdBitacora);
                cs.registerOutParameter(4,Types.NUMERIC);
                cs.execute();
                vId_Bitacora_Tabla = cs.getString(4);
                cs.close();

            }
            catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }


     try{
                for (int i = 0; i < count; i++) {
                    boolean isAssociationAccessor = false;
                    
                    try {
                    name = getEntityDef().getAttributeDef(i).getColumnName();

                    

                        associationAccessorName = getEntityDef().getAssociationDefImpl(name).getColumnName();
                        if (associationAccessorName.equals(name))
                            isAssociationAccessor = true;
                        else isAssociationAccessor = false;

                    }
                    catch (Exception ex) {
                       // ex.printStackTrace();
                        isAssociationAccessor = false;
                    }

                    if (operation == DML_INSERT) {
                        val = (getAttribute(i)!=null?getAttribute(i).toString():"");
                        oldval = "";
                    } else if (operation == DML_UPDATE) {
                        val = (getAttribute(i)!=null?getAttribute(i).toString():"");
                        oldval = (getPostedAttribute(i)!=null?getPostedAttribute(i).toString():"");
                    } else if (operation == DML_DELETE) {
                        val = "";
                        oldval = (getPostedAttribute(i)!=null?getPostedAttribute(i).toString():"");
                    }

                     if (getEntityDef().getAttributeDef(i).isPrimaryKey()){
                         
                         vllave.setAttribute(name,val); 
                     }


                    if ( (isAttributeChanged(i) || (operation == DML_DELETE)) && (!val.equals(oldval) && !isAssociationAccessor) && name!=null){

                        try {
                            String llamada = "BEGIN BITACORA_PK.registrarEventoColumna(?,?,?,?); END;";
                            CallableStatement cs = getDBTransaction().createCallableStatement(llamada,0);
                            cs.setObject(1,vId_Bitacora_Tabla);
                            cs.setString(2,name);
                            cs.setString(3,oldval);
                            cs.setString(4,val);
                            cs.execute();
                            isDet=true;
                            cs.close();
                            
                            if (vllave.getAttribute(name)!=null){
                            
                                vllave.setAttribute(name,null);
                            }
                            
                        }
                        catch (SQLException sqlException) {
                            sqlException.printStackTrace();
                        }

                    }
            }
            
        if (isDet==true && (operation == DML_UPDATE || operation == DML_DELETE))
        {    
         CallableStatement cs=null;
         for(int i2=0;i2<vllave.getAttributeCount();i2++)
         {
            if (vllave.getAttributeValues()[i2]!=null)
            {
                 try {
                     String llamada = "BEGIN BITACORA_PK.registrarEventoColumna(?,?,?,?); END;";
                     cs = getDBTransaction().createCallableStatement(llamada,0);
                     cs.setObject(1,vId_Bitacora_Tabla);
                     cs.setString(2,vllave.getAttributeNames()[i2]);
                     cs.setString(3,"");
                     cs.setString(4,vllave.getAttributeValues()[i2].toString());
                     cs.execute();
                     isDet=true;
                     cs.close();
                 }
                 catch (SQLException sqlException) 
                 {
                     cs.close();                 
                     sqlException.printStackTrace();
                 }    
            } 
         }
     }
     
     }catch(Exception exep2){
         exep2.printStackTrace();
         
     }
            
}
  
}
