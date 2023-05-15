package pkg_carga_datos;

import enlace_datos.util.utils;

import java.math.BigDecimal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Types;

import org.xml.sax.Attributes;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class prestamo_xml_handler  extends DefaultHandler {
    private boolean vObtenerValor;
    private boolean vErrorCabecera;
    private int vBandera;
    private PreparedStatement vPst_sentencia;
    private PreparedStatement vPst_sentenciaUpdate;
    private PreparedStatement vPst_sentenciaNomBanco;
    private long vRegistro_empleado;
    private double vMonto;
    private String vCodPrestamo;
    private String vNumPrestamo;
    private long vCodArch;
    private String vError;
    private long vCantidadProc;
    private long vCantidadErrores;
    private String vTempVal;
    
    
    public prestamo_xml_handler(Connection pConexionDB,long vCodArch)throws Exception{
       
       this.vCodArch=vCodArch;
       vPst_sentencia=pConexionDB.prepareStatement("insert into sis_archivo_prestamo (ID_ARCHIVO_PRESTAMO,ID_CARGA_ARCHIVO_DATOS,REGISTRO_EMPLEADO,NO_PRESTAMO,MONTO,COD_PRESTAMO) values(sis_Archivo_prestamo_sq.nextval,?,?,?,?,?)");
       vPst_sentenciaUpdate=pConexionDB.prepareStatement("update sis_carga_Archivo_datos set periodo=?,anio=?,id_origen_carga_archivo=(select id_origen_carga_Archivo from sis_origen_carga_archivo where nombre=?) where id_carga_Archivo_datos=?");
       vPst_sentenciaNomBanco=pConexionDB.prepareStatement("select id_origen_carga_Archivo from sis_origen_carga_archivo where nombre=?");
       this.vError=""; 
       this.vTempVal="";
       vCantidadProc=0; 
       vCantidadErrores=0;
       vErrorCabecera=false;
    }
    
    /*
     * Inicio de etiqueta de doc XML
     */
    public void startElement(String uri, String localName,String qName, Attributes atts){
    
     int vNumMes;
    
     if (localName.equals("registro_empleado")){
         vObtenerValor=true;
         vBandera=1;
     }else  if (localName.equals("no_prestamo")){
         vObtenerValor=true;
         vBandera=2;
     }else  if (localName.equals("monto")){
         vObtenerValor=true;
         vBandera=3;
     }else  if (localName.equals("cod_prestamo")){
         vObtenerValor=true;
         vBandera=4;
     }else if (localName.equals("prestamos")){
        String vPeriodo;
        String vAnio;
        String vOrigenCarga;
        
         vOrigenCarga=atts.getValue("nombre_banco");
         vAnio=atts.getValue("anio");
         vPeriodo=atts.getValue("periodo");
         
         
        try{
        
        vError="Error en las propiedades de la etiqueta <prestamos>";
        
        if (vOrigenCarga==null ||vAnio==null ||vPeriodo==null){
            vPst_sentenciaUpdate.setNull(1,Types.NULL); 
            vPst_sentenciaUpdate.setNull(2,Types.NULL); 
            vPst_sentenciaUpdate.setString(3,vOrigenCarga); 
            vPst_sentenciaUpdate.setBigDecimal(4, new BigDecimal(this.vCodArch)); 
            vPst_sentenciaUpdate.executeUpdate();
            
            vError="La etiqueta <prestamos> no tiene todas las propiedades";
            throw new Exception(vError);
        }else{
         
            if (utils.isNumber(vPeriodo))
            {
               
                vNumMes=Integer.parseInt(vPeriodo);
                if (vNumMes<0 || vNumMes>12) vNumMes=-1;
                
            }else{
            
                vNumMes=utils.getNumMes(vPeriodo);
            }
         

            
            if (vNumMes!=-1)
            {
            
            vPst_sentenciaUpdate.setInt(1,vNumMes); 
            vPst_sentenciaUpdate.setInt(2,Integer.parseInt(vAnio)); 
            vPst_sentenciaUpdate.setString(3,vOrigenCarga); 
            vPst_sentenciaUpdate.setBigDecimal(4, new BigDecimal(this.vCodArch)); 
            vPst_sentenciaUpdate.executeUpdate();
            vError="";
            
            }else
            {
                vPst_sentenciaUpdate.setInt(1,Types.NULL); 
                vPst_sentenciaUpdate.setInt(2,Integer.parseInt(vAnio)); 
                vPst_sentenciaUpdate.setString(3,vOrigenCarga); 
                vPst_sentenciaUpdate.setBigDecimal(4, new BigDecimal(this.vCodArch)); 
                vPst_sentenciaUpdate.executeUpdate();
                
                vError="Valor inválido para la propiedad periodo de la etiqueta <prestamos>";
                throw new Exception(vError);
            }
            
            
        }
        
        }catch(Exception exep){
            
            
            vCantidadErrores++;
            vErrorCabecera=true;
          try{
          vPst_sentenciaUpdate.close();
         // vPst_sentenciaUpdate.getConnection().close();
          this.endDocument();
          }catch(Exception exep2){
              
          }
        }
     }
      
    }
    
    /*
     * fin de etiqueta del doc XML
     */
    public void endElement(String uri, String localName,String qName) {
         vObtenerValor=false;
         
        if (localName.equals("registro_empleado")||localName.equals("no_prestamo")||localName.equals("monto")||localName.equals("cod_prestamo")) {
        try{                   
             switch (vBandera){
                  case 1: //registro_empleado
                  vRegistro_empleado=new Long(this.vTempVal.trim());
                  break;
                  case 2://num_prestamo
                  vNumPrestamo=new String(this.vTempVal.trim());
                  break;
                  case 3://monto
                  vMonto=new Double(this.vTempVal.trim());
                  break;
                  case 4://cod_prestamo
                  vCodPrestamo=new String(this.vTempVal.trim());
                  break;
                               }
        }catch(Exception eas){
            vError=utils.getSQLMensaje(eas);
            vCantidadErrores++;
            eas.printStackTrace();
        }
        
        this.vTempVal="";
        
        }
        else if (localName.equals("fila")){ // insertar a base
         
         try{
           if (vNumPrestamo.length()>0&&vCodPrestamo.length()>0 && vErrorCabecera==false){
                 vCantidadProc++;
                vPst_sentencia.setLong(1,vCodArch);
                vPst_sentencia.setLong(2,this.vRegistro_empleado);  
                vPst_sentencia.setString(3,this.vNumPrestamo);
                vPst_sentencia.setDouble(4,this.vMonto);
                vPst_sentencia.setString(5,this.vCodPrestamo);

                vPst_sentencia.executeUpdate();
        
                this.vRegistro_empleado=0;
                this.vNumPrestamo="";
                this.vMonto=0;
                this.vCodPrestamo="";
              }
         }catch(Exception eas){
             vError="LINEA: "+ (vCantidadProc+2)+ ", registro_empleado: " +this.vRegistro_empleado+ "["+utils.getSQLMensaje(eas)+"]"; 
             vCantidadErrores++;
             eas.printStackTrace();  
           //  System.out.println(" ------- linea--------  "+vCantidadProc + " "+this.vRegistro_empleado+" "+this.vMonto);
             
         }
        }
    }
    
    /*
     *  Valor de las etiquetas se llama despues del inicio y fin de etiqueta o por algun token
     */
    public void characters(char[ ] chars, int start, int length) {
        if (vObtenerValor){
            vTempVal=vTempVal+new String(chars, start, length);
        }
    }
    
        public String getError(){
          return this.vError.length()>1?this.vError:null;  
        } 
        
        public long getNumInsertados(){
            return this.vCantidadProc; 
        }
        
        public long getNumErrores(){
            return this.vCantidadErrores; 
        }        
        
}
