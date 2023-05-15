package pkg_carga_datos;

import interfaz_usuario.util.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import java.util.HashMap;
import java.util.List;

import oracle.adf.view.faces.model.UploadedFile;

import oracle.jbo.domain.BlobDomain;

import oracle.jdbc.OracleTypes;

import oracle.xml.parser.v2.SAXParser;

import pkg_util_base_datos.interfaz_DB;


public class carga_datos {

    private archivo vArchivo;
    archivo_log vArchivo_log;
    private interfaz_DB vInterfaz_DB;
    private String str_desError;
    private long cantidad_insertados;
    private long cantidad_error_proc;
    private long cantidad_error_par;
   
    public carga_datos(){
        vArchivo=new archivo();
        vInterfaz_DB=new interfaz_DB();
    }
    
    private List Lst_obtener_datos(String pStr_cadena) {
        return null;
    }
    
    //Método para subir un archivo adjunto.
    public boolean Bol_Cargar_Archivo_Adjunto2(UploadedFile  pfuente, HashMap pParametros){
        boolean vResultado = false; //valor inicial
        String vNombreFinalArchivo, idArchivoAdjunto;
        int vOpcion;
        PreparedStatement vPst_sentencia;
        vPst_sentencia=null;
        Object vTipoArchivo;
        BlobDomain vArchBlob;
        try{
            // Copiando el archivo seleccionado al servidor
            vOpcion=(Integer)pParametros.get("opcion");
            if (vOpcion==6) {
                //Foto del Empleado
                vTipoArchivo = 3; //Foto del empleado
            } else {
                vTipoArchivo=this.vInterfaz_DB.getValorConsultaSimple("id_tipo_archivo","select id_tipo_archivo from sis_tipo_archivo where upper(content_type) like '%"+((String)pParametros.get("contentType")).toUpperCase()+"%' order by id_tipo_archivo asc");
            }
            if (vTipoArchivo!=null){
                // Obteniendo el id del archivo
                idArchivoAdjunto=this.vInterfaz_DB.getValorSequencia("sis_archivo_adjunto_sq");
                // Obteniendo los datos del archivo
                this.vArchivo=new archivo((String)pParametros.get("nomArchivo")); 
                //vDirectorio=(String)pParametros.get("Directorio");
                vNombreFinalArchivo=(this.vArchivo.getNombreArchivo_Sin_Ext().length()<65?this.vArchivo.getNombreArchivo_Sin_Ext():this.vArchivo.getNombreArchivo_Sin_Ext().substring(0,65))+"."+this.vArchivo.getExtensionArchivo();
                vArchBlob = writeToBlobDomain(pfuente);
                vPst_sentencia=this.vInterfaz_DB.get_Coneccion().prepareStatement("insert into sis_archivo_adjunto(id_Archivo_adjunto,id_tipo_archivo,id_contrato,id_solicitud,registro_empleado,id_variacion_nomina,id_anexo,nom_Archivo,descripcion,creado_por,data,modulo) values(?,?,?,?,?,?,?,?,?,?,?,?)");
                vPst_sentencia.setLong(1,new Long(idArchivoAdjunto) );    
                vPst_sentencia.setInt(2, new Integer(vTipoArchivo.toString()));
                if (vOpcion==1){ //archivos Adjunto contrato
                    vPst_sentencia.setLong(3,new Long((String)pParametros.get("idContrato")));         
                    vPst_sentencia.setNull(4,Types.NULL);   
                    vPst_sentencia.setNull(5,Types.NULL);  
                    vPst_sentencia.setNull(6,Types.NULL);  
                    vPst_sentencia.setNull(7,Types.NULL); 
                } else if (vOpcion==2 || vOpcion==7){ //archivos Adjunto solicitud
                    vPst_sentencia.setNull(3,Types.NULL);     
                    vPst_sentencia.setLong(4,new Long((String)pParametros.get("idSolicitud")));         
                    vPst_sentencia.setNull(5,Types.NULL);   
                    vPst_sentencia.setNull(6,Types.NULL);
                    vPst_sentencia.setNull(7,Types.NULL);
                } else if (vOpcion==3){ //archivos Adjunto empleado
                    vPst_sentencia.setNull(3,Types.NULL);     
                    vPst_sentencia.setNull(4,Types.NULL);      
                    vPst_sentencia.setLong(5,new Long((String)pParametros.get("registro_empleado")));         
                    vPst_sentencia.setNull(6,Types.NULL);
                    vPst_sentencia.setNull(7,Types.NULL);
                } else if (vOpcion==4){ //archivos adjuntos de variacion nomina
                    vPst_sentencia.setNull(3,Types.NULL);     
                    vPst_sentencia.setNull(4,Types.NULL);      
                    vPst_sentencia.setNull(5,Types.NULL); 
                    vPst_sentencia.setLong(6,new Long((String)pParametros.get("idVariacionNomina")));         
                    vPst_sentencia.setNull(7,Types.NULL);
                } else if (vOpcion==5){ //archivos adjuntos del anexo
                    vPst_sentencia.setNull(3,Types.NULL);     
                    vPst_sentencia.setNull(4,Types.NULL);      
                    vPst_sentencia.setNull(5,Types.NULL); 
                    vPst_sentencia.setNull(6,Types.NULL);         
                    vPst_sentencia.setLong(7,new Long((String)pParametros.get("idAnexo")));
                } else if (vOpcion==6){ //Foto del Empleado
                    vPst_sentencia.setNull(3,Types.NULL);     
                    vPst_sentencia.setNull(4,Types.NULL);      
                    vPst_sentencia.setLong(5,new Long((String)pParametros.get("registro_empleado")));  
                    vPst_sentencia.setNull(6,Types.NULL);         
                    vPst_sentencia.setNull(7,Types.NULL);
                } else {
                    vPst_sentencia.setNull(3,Types.NULL);     
                    vPst_sentencia.setNull(4,Types.NULL);      
                    vPst_sentencia.setLong(5,Types.NULL);  
                    vPst_sentencia.setNull(6,Types.NULL);         
                    vPst_sentencia.setNull(7,Types.NULL);
                }
                vPst_sentencia.setString(8,vNombreFinalArchivo);
                vPst_sentencia.setString(9,(String)pParametros.get("Descripcion"));
                vPst_sentencia.setString(10,pParametros.get("CreadoPor").toString());
                vPst_sentencia.setBytes(11,vArchBlob.getStorageByteArray()); 
                vPst_sentencia.setString(12,(String)pParametros.get("Modulo")); 
                
                vPst_sentencia.executeUpdate();
                vPst_sentencia.close(); 
                pfuente.getInputStream().close();
                vResultado = true; //Todo fue exitoso
            } else {
                vResultado=false;
                str_desError="No se permite subir este tipo de archivo. Intente con otro por favor.";
                pfuente.getInputStream().close();
            }
        } catch(Exception eas) {
            eas.printStackTrace();
            vResultado=false;
            str_desError="ERROR AL CARGAR EL ARCHIVO, INTENTE DE NUEVO POR FAVOR!!";
            //vInterfaz_DB.cn_Cerrar_coneccion();
        } finally {
            vInterfaz_DB.cn_Cerrar_coneccion();
        }
        return vResultado;
    }
  
public  BlobDomain writeToBlobDomain(UploadedFile file) throws SQLException, 
                                                                                      IOException {
        InputStream in = file.getInputStream();
        BlobDomain blobDomain = new BlobDomain();
        OutputStream out = blobDomain.getBinaryOutputStream();
        byte[] buffer = new byte[8192];
        int bytesRead = 0;
        while ((bytesRead = in.read(buffer, 0, 8192)) != -1) {
            out.write(buffer, 0, bytesRead);
        }
        in.close();
        return blobDomain;
}
  
  
    
/*
* Metodo para grabar el archivo al servidor y carga del archivo XML a la base de datos
*/
    public boolean Bol_Cargar_ArchPrestamos(UploadedFile  pfuente, HashMap pParametros) {
        boolean vCopiaArchivo;
        PreparedStatement vPst_sentencia;
        ResultSet fila;
        long id_insercion=0;
        boolean vResultado=true;
        SAXParser vXMLParser;
        vPst_sentencia=null;
        String vBanco;
        // Copiando el archivo seleccionado al servidor
        try{
        
        
        if (pParametros.get("idBanco").toString()!=null && !pParametros.get("idBanco").toString().equals("")){
            
            vBanco="("+pParametros.get("idBanco").toString()+")";  
            
        }else{
        
            vBanco="(select id_origen_carga_Archivo from sis_origen_Carga_Archivo where nombre='BANCO NO DEFINIDO')";
            
        }
        
        
        
        vPst_sentencia=this.vInterfaz_DB.get_Coneccion().prepareStatement("insert into sis_carga_archivo_Datos(id_carga_archivo_datos,id_origen_carga_archivo,id_proceso,nom_archivo,periodo,anio,fecha_inicio,fecha_fin,error,creado_por) values(sis_carga_Archivo_datos_sq.nextval,"+vBanco+",null,?,?,?,sysdate,null,null,?)");
        //vPst_sentencia.setInt(1,Integer.valueOf(pParametros.get("idBanco").toString()));    
        vPst_sentencia.setString(1,pParametros.get("nombreArchivo").toString());
        vPst_sentencia.setInt(2,Integer.valueOf(pParametros.get("periodo").toString()));
        vPst_sentencia.setInt(3,Integer.valueOf(pParametros.get("anio").toString()));
        vPst_sentencia.setString(4,utils.getUsuario());
        vPst_sentencia.executeUpdate();
            
        // Obteniendo el id de la fila insertada
        vPst_sentencia=vPst_sentencia.getConnection().prepareStatement("select sis_carga_archivo_datos_sq.currval from dual");
        fila=vPst_sentencia.executeQuery();
        fila.next();
        id_insercion=fila.getLong("currval");
        
        vCopiaArchivo=vArchivo.Bol_copiar_archivo(pfuente.getInputStream(),(String)pParametros.get("nombreArchivo"));
        if (vCopiaArchivo==true){ // El archivo fue cargado correctamente
         
        vXMLParser = new SAXParser();
        prestamo_xml_handler vManejadorXML = new prestamo_xml_handler(vPst_sentencia.getConnection(),id_insercion);
        vXMLParser.setContentHandler(vManejadorXML);
        vXMLParser.parse(new FileInputStream(pParametros.get("nombreArchivo").toString()));            
        this.cantidad_error_par=vManejadorXML.getNumErrores();
        this.cantidad_insertados=vManejadorXML.getNumInsertados();
        
        // Si ocurrio algun error en el proceso del XML graba el error.
       if (vManejadorXML.getError()!=null){
            vPst_sentencia=vPst_sentencia.getConnection().prepareStatement("update sis_carga_archivo_datos set fecha_fin=sysdate,error=? where id_carga_archivo_datos=?");         
            vPst_sentencia.setString(1,vManejadorXML.getError());
            vPst_sentencia.setLong(2,id_insercion);
            vPst_sentencia.executeUpdate();
            vResultado=false;
            str_desError="HA OCURRIDO UN ERROR AL PROCESAR EL ARCHIVO.";
           
        }else if(cantidad_error_par==0&&cantidad_insertados>0) { // Solo si no se detecto algun error se procede a procesar los prestamos
         if (!this.Bol_Procesar_prestamos(id_insercion)){
                 vResultado=false;
         }
                                            
         }
         
        }  
                
        vPst_sentencia.close();
        this.vInterfaz_DB.cn_Cerrar_coneccion();
        }catch(Exception eas) {
            eas.printStackTrace();
            vResultado=false;
            str_desError="ERROR AL CARGAR EL ARCHIVO";
          try{
            vPst_sentencia=vPst_sentencia.getConnection().prepareStatement("update sis_carga_Archivo_Datos set fecha_fin=sysdate,error=? where id_carga_archivo_datos=?");         
            vPst_sentencia.setString(1,str_desError);
            vPst_sentencia.setLong(2,id_insercion);
            vPst_sentencia.executeUpdate();
            vPst_sentencia.close();    
            this.vInterfaz_DB.cn_Cerrar_coneccion();
          }catch(Exception excep){
              excep.printStackTrace();
          }
        }
      return vResultado;
    }

    private boolean Bol_Procesar_prestamos(long plng_IdCarga) {
        CallableStatement cs;
        cantidad_error_proc=0;
        try{
        
            cs =this.vInterfaz_DB.get_Coneccion().prepareCall("{CALL SIS_PKG_CARGA_DATOS_EXTERNOS.CargaPrestamosBancos(?,?)}"); 
            cs.setLong(1,plng_IdCarga);
            cs.registerOutParameter(2,OracleTypes.NUMBER);
            cs.execute();
            cantidad_error_proc=cs.getLong(2);  //Obteniendo la cantidad de registros con error no procesados
            cs.close();
        }catch(Exception exep){
          exep.printStackTrace(); 
          str_desError="ERROR AL CONECTARSE A LA BASE DE DATOS";
          return false;
        }
        return true;
    }

    private boolean Bol_Insertar_reg_prestamo(List pLst_valores) {
        return false;
    }

    private boolean Bol_Insertar_reg_apertura(List pLst_valores) {
        return false;
    }
    
/*
 * Metodo para obtener la cantidad de errores en el proc de los datos 
 */
  public long getCantErroresProc(){
      return this.cantidad_error_proc;
  }

/*
 *  Metodo para obtener la descripcion del error
 */
   public String getError(){
       return this.str_desError;
   }

/*
 * Metodo que retorna los registros insertados al cargar el archivo de entrada
 */
  public long get_insertados(){
     return this.cantidad_insertados; 
  }

/*
 * Metodo para copiar el archivo al servidor e insertar los valores a la tabla sis_archivo_apertura
 */

    public boolean Bol_Cargar_Arch_Aper_Presup(UploadedFile  pfuente,String pStr_NombreArchivo,Number pAnio) {
        boolean vCopiaArchivo;
        ResultSet fila;
        long id_insercion=0;
        String str_linea;
        int pos1;
        boolean resultado=true;
        cantidad_insertados=0;
        
        int plaza;
        String puesto;
        double horas;
        long registro_emp;
        double salario_b;
        double compl_sal;
        double escalafon;
        String partida;
        String fechaI;
        String fechaF;
        long numLinea=1;
        
        
        try{
        
            PreparedStatement vPst_sentencia;
            vPst_sentencia=this.vInterfaz_DB.get_Coneccion().prepareStatement("insert into sis_carga_archivo_Datos(id_carga_archivo_datos,id_origen_carga_archivo,id_proceso,nom_archivo,periodo,anio,fecha_inicio,fecha_fin,error) values(sis_carga_Archivo_datos_sq.nextval,(select id_origen_carga_Archivo from sis_origen_Carga_Archivo where nombre='APERTURA PRESUPUESTAL'),null,?,null,?,sysdate,null,?)");
            
            // Copiando el archivo seleccionado al servidor
            vCopiaArchivo=vArchivo.Bol_copiar_archivo(pfuente.getInputStream(),pStr_NombreArchivo);
            if (vCopiaArchivo==true){ // El archivo fue cargado correctamente
             try{
                  // Insertando el registro del archivo copiado                
                 vPst_sentencia.setString(1,pStr_NombreArchivo);
                 vPst_sentencia.setInt(2,pAnio.intValue());
                 vPst_sentencia.setNull(3,Types.NULL);
                 vPst_sentencia.executeUpdate();
                 
                 // Obteniendo el id de la fila insertada
                 vPst_sentencia=vPst_sentencia.getConnection().prepareStatement("select sis_carga_archivo_datos_sq.currval from dual");
                 fila=vPst_sentencia.executeQuery();
                 fila.next();
                 id_insercion=fila.getLong("currval");
                 
                 vArchivo.Bol_AbrirArchivo(pStr_NombreArchivo,"BUFF_LINEA");
                // System.out.println("id insertado "+ id_insercion+" linea leida "+vArchivo.getLinea());
                 vPst_sentencia=vPst_sentencia.getConnection().prepareStatement("insert into sis_archivo_apertura values(sis_archivo_apertura_sq.nextval,?,?,?,?,?,?,?,?,?,to_date(?,'dd-mm-yyyy'),to_date(?,'dd-mm-yyyy'),null)");
                
                 str_linea=vArchivo.getLinea().trim();
                 String [] valores;
                 
                  while (str_linea!=null){ 
                      str_linea=str_linea.trim();
                      valores=str_linea.split("\\s+");
                      if (valores.length>=6){
                      plaza=Integer.parseInt(valores[0]);
                      puesto=valores[1];
                      horas = Double.parseDouble(valores[2]);
                      registro_emp=Long.parseLong(valores[3]);
                      salario_b=Double.parseDouble(valores[4]);
                      //compl_sal=Double.parseDouble(valores[5]);
                      escalafon=Double.parseDouble(valores[5]);
                      pos1=valores[6].indexOf(".");
                      //escalafon=Double.parseDouble(valores[6].substring(0,pos1+2));
                      compl_sal=Double.parseDouble(valores[6].substring(0,pos1+3));
                      partida=valores[6].substring(pos1+3,pos1+13);
                      fechaI=valores[6].substring(pos1+13,pos1+23);
                      fechaF=valores[6].substring(pos1+23,pos1+33);
                      
                      vPst_sentencia.setLong(1,id_insercion);
                      vPst_sentencia.setInt(2,plaza);
                      vPst_sentencia.setString(3,puesto);
                      vPst_sentencia.setDouble(4,horas);
                      vPst_sentencia.setLong(5,registro_emp);
                      vPst_sentencia.setDouble(6,salario_b);
                      vPst_sentencia.setDouble(7,compl_sal);
                      vPst_sentencia.setDouble(8,escalafon);
                      vPst_sentencia.setString(9,partida);
                      vPst_sentencia.setString(10,fechaI);
                      vPst_sentencia.setString(11,fechaF);
                      vPst_sentencia.executeUpdate();
                      cantidad_insertados++;
                      }else{
                         // System.out.println("no tiene todos los datos");
                      }
                      str_linea=vArchivo.getLinea();
                      numLinea++;                  
                  }
                              
                 vArchivo.Bol_CerrarArchivo();
                 if (cantidad_insertados>0){  // Si se insertaron datos para procesar.
                 
                   if (Bol_Procesar_Aper_Presup(id_insercion)==false){  // Procesando los datos insertados
                      resultado=false; 
                    }
                    
                 vPst_sentencia=vPst_sentencia.getConnection().prepareStatement("update sis_carga_archivo_datos set fecha_fin=sysdate where id_carga_archivo_datos=?");         
                 vPst_sentencia.setLong(1,id_insercion);
                 
                 }else{
                     str_desError="NO TIENE DATOS VALIDOS";
                     vPst_sentencia=vPst_sentencia.getConnection().prepareStatement("update sis_carga_archivo_datos set fecha_fin=sysdate,error=? where id_carga_archivo_datos=?");         
                     vPst_sentencia.setString(1,str_desError);
                     vPst_sentencia.setLong(2,id_insercion);  
                 }
                 
                 vPst_sentencia.executeUpdate();
                 vPst_sentencia.close();    
                 this.vInterfaz_DB.cn_Cerrar_coneccion();
                 
             }catch(Exception eas){
                 eas.printStackTrace();
                 resultado=false;
                 str_desError="ERROR AL PARSEAR EL ARCHIVO. Linea No." + numLinea;
                 vPst_sentencia=vPst_sentencia.getConnection().prepareStatement("update sis_carga_archivo_datos set fecha_fin=sysdate,error=? where id_carga_archivo_datos=?");         
                 vPst_sentencia.setString(1,str_desError);
                 vPst_sentencia.setLong(2,id_insercion);
                 vPst_sentencia.executeUpdate();
                 vPst_sentencia.close();    
                 this.vInterfaz_DB.cn_Cerrar_coneccion();
             }
            }else{ //El archivo no fue cargado correctamente
             resultado=false;
             str_desError="EL ARCHIVO NO FUE TRANSFERIDO CORRECTAMENTE";
            }
        
        }catch(Exception exep){
            exep.printStackTrace();
            resultado=false;
            str_desError="ERROR AL CONECTARSE A LA BASE DE DATOS";
            this.vInterfaz_DB.cn_Cerrar_coneccion();
        }
        
        return resultado;
    }

/*
 *  Metodo para llamar al procedimiento que procesa los datos de la apertura presupuestal 
 */
    public boolean Bol_Procesar_Aper_Presup(long plng_Id_carga) {
        CallableStatement cs;
        cantidad_error_proc=0;
        try{
        
            cs =this.vInterfaz_DB.get_Coneccion().prepareCall("{CALL SIS_PKG_CARGA_DATOS_EXTERNOS.CARGAAPERTURA(?,?)}"); 
            cs.setLong(1,plng_Id_carga);
            cs.registerOutParameter(2,OracleTypes.NUMBER);
            cs.execute();
            cantidad_error_proc=cs.getLong(2);  //Obteniendo la cantidad de registros con error no procesados
            cs.close();
        }catch(Exception exep){
          exep.printStackTrace(); 
          str_desError="ERROR AL CONECTARSE A LA BASE DE DATOS";
          return false;
        }
        return true;
    }
    
    

    /*
     * Metodo para copiar el archivo al servidor e insertar los valores a la tabla sis_archivo_apertura
     */

     public boolean Bol_Cargar_ConciliacionBancaria(UploadedFile  pfuente,HashMap pParametros) {
            
            boolean vCopiaArchivo;
            ResultSet fila;
            long id_insercion=0;
            String str_linea;
            boolean resultado=true;
            cantidad_insertados=0;
            Object  vIdCuenta;
            
            String vNoCuenta;
            String vFechaCobro;
            String vNomDoc;
            Double vCobrado;
            long vIdcuentaDebito=0;
            
            long numLinea=1;
            HashMap vCuentasDebito=new HashMap();
            
            
            try{
            
                PreparedStatement vPst_sentencia;
                vPst_sentencia=this.vInterfaz_DB.get_Coneccion().prepareStatement("insert into sis_carga_archivo_Datos(id_carga_archivo_datos,id_origen_carga_archivo,id_proceso,nom_archivo,periodo,anio,fecha_inicio,fecha_fin,error) values(sis_carga_Archivo_datos_sq.nextval,(select id_origen_carga_Archivo from sis_origen_Carga_Archivo where nombre='CONCILIACION BANRURAL'),null,?,?,?,sysdate,null,?)");
                
                // Copiando el archivo seleccionado al servidor
                vCopiaArchivo=vArchivo.Bol_copiar_archivo(pfuente.getInputStream(),pParametros.get("nombreArchivo").toString());
                if (vCopiaArchivo==true){ // El archivo fue cargado correctamente
                 try{
                      // Insertando el registro del archivo copiado                
                     vPst_sentencia.setString(1,pParametros.get("nombreArchivoOrig").toString());
                     vPst_sentencia.setInt(2,new Integer(pParametros.get("periodo").toString()));
                     vPst_sentencia.setInt(3,new Integer(pParametros.get("anio").toString()));
                     vPst_sentencia.setNull(4,Types.NULL);
                     vPst_sentencia.executeUpdate();
                     
                     // Obteniendo el id de la fila insertada
                     vPst_sentencia=vPst_sentencia.getConnection().prepareStatement("select sis_carga_archivo_datos_sq.currval from dual");
                     fila=vPst_sentencia.executeQuery();
                     fila.next();
                     id_insercion=fila.getLong("currval");
                     
                     vArchivo.Bol_AbrirArchivo(pParametros.get("nombreArchivo").toString(),"BUFF_LINEA");
                    // System.out.println("id insertado "+ id_insercion+" linea leida "+vArchivo.getLinea());
                     vPst_sentencia=vPst_sentencia.getConnection().prepareStatement("insert into sis_conciliacion_bancaria(id_conciliacion_bancaria,id_carga_archivo_datos,id_cuenta_bancaria_debito,monto_cobrado,fecha_cobro,no_documento)\n" + 
                     "values(sis_conciliacion_bancaria_sq.nextval,?,?,?,to_date(?,'dd/mm/yyyy'),?)");
                    
                     str_linea=vArchivo.getLinea().trim();
                     
                     
                      while (str_linea!=null){ 
                          str_linea=str_linea.trim();
                          
                          vNoCuenta=str_linea.substring(0,10);
                          vFechaCobro=str_linea.substring(10,20);
                          vNomDoc=str_linea.substring(20,30);
                          vCobrado=new Double(str_linea.substring(30,40));
                          
                            if (!vCuentasDebito.containsKey(vNoCuenta)){
                                
                                vIdCuenta=this.vInterfaz_DB.getValorConsultaSimple("id_cuenta_bancaria","select id_cuenta_bancaria from cuenta_bancaria\n" + 
                                "where numero_cuenta='"+vNoCuenta+"'");
                                
                                if (vIdCuenta !=null){
                                    
                                    vCuentasDebito.put(vNoCuenta,new Long(vIdCuenta.toString()));
                                }
                                
                                vIdcuentaDebito=(Long)vCuentasDebito.get(vNoCuenta);
                            }else{
                                
                                vIdcuentaDebito=(Long)vCuentasDebito.get(vNoCuenta);
                            }
                          
                          
                          vPst_sentencia.setLong(1,id_insercion); // id_carga_archivo
                          vPst_sentencia.setLong(2,vIdcuentaDebito);  //cuenta
                          vPst_sentencia.setDouble(3,vCobrado); // cobrado
                          vPst_sentencia.setString(4,vFechaCobro);
                          vPst_sentencia.setString(5,getNumeroEntero(vNomDoc));
                          vPst_sentencia.executeUpdate();
                          cantidad_insertados++;
                         
                          str_linea=vArchivo.getLinea();
                          numLinea++;                  
                      }
                     
                     if (cantidad_insertados>0){  // Si se insertaron datos para procesar.
                     
                     resultado=true;  
                        
                     vPst_sentencia=vPst_sentencia.getConnection().prepareStatement("update sis_carga_archivo_datos set fecha_fin=sysdate where id_carga_archivo_datos=?");         
                     vPst_sentencia.setLong(1,id_insercion);
                     
                     }else{
                         str_desError="NO TIENE DATOS VALIDOS";
                         vPst_sentencia=vPst_sentencia.getConnection().prepareStatement("update sis_carga_archivo_datos set fecha_fin=sysdate,error=? where id_carga_archivo_datos=?");         
                         vPst_sentencia.setString(1,str_desError);
                         vPst_sentencia.setLong(2,id_insercion);  
                     }
                                  
                     vPst_sentencia.executeUpdate();
                     vPst_sentencia.close();                 
                     vArchivo.Bol_CerrarArchivo();
                     vPst_sentencia.close();    
                     this.vInterfaz_DB.cn_Cerrar_coneccion();
                     
                 }catch(Exception eas){
                     eas.printStackTrace();
                     resultado=false;
                     str_desError="ERROR AL PARSEAR EL ARCHIVO. Linea No." + numLinea;
                     vPst_sentencia=vPst_sentencia.getConnection().prepareStatement("update sis_carga_archivo_datos set fecha_fin=sysdate,error=? where id_carga_archivo_datos=?");         
                     vPst_sentencia.setString(1,str_desError);
                     vPst_sentencia.setLong(2,id_insercion);
                     vPst_sentencia.executeUpdate();
                     vPst_sentencia.close();    
                     this.vInterfaz_DB.cn_Cerrar_coneccion();
                 }
                }else{ //El archivo no fue cargado correctamente
                 resultado=false;
                 str_desError="EL ARCHIVO NO FUE TRANSFERIDO CORRECTAMENTE";
                }
            
            }catch(Exception exep){
                exep.printStackTrace();
                resultado=false;
                str_desError="ERROR AL CONECTARSE A LA BASE DE DATOS";
                this.vInterfaz_DB.cn_Cerrar_coneccion();
            }
            
            return resultado;
        }
   
   
private String getNumeroEntero(String pNumero){
   BigDecimal vTemp; 
   String vNumero;
   try{
   vTemp=new BigDecimal(pNumero);
   vNumero=vTemp.toString();
   return vNumero;
   }catch(Exception exep){
     return pNumero;  
   }
}

    //Método que actualiza la data de un archivo adjunto
    public boolean Bol_Actualizar_Data(UploadedFile  pfuente, HashMap pParametros){
        PreparedStatement vPst_sentencia;
        boolean vResultado=false;
        vPst_sentencia=null;
        String idArchivoAdjunto;
        String registroEmpleado;
        String tipoArchivo;
        BlobDomain vArchBlob;
        try{
            //obtenemos el id del archivo adjunto a actualizar
            registroEmpleado = (String)pParametros.get("registro_empleado");
            tipoArchivo = (String)pParametros.get("tipo_archivo");
            idArchivoAdjunto = (String)pParametros.get("id");
            //System.out.println("El id archivo adjunto es: " + idArchivoAdjunto);
            if (idArchivoAdjunto!=null){
                vArchBlob = writeToBlobDomain(pfuente);
                vPst_sentencia=this.vInterfaz_DB.get_Coneccion().prepareStatement("update sis_archivo_adjunto set data = ? where id_archivo_adjunto = ? and validado is null");
                vPst_sentencia.setBytes(1,vArchBlob.getStorageByteArray()); 
                vPst_sentencia.setLong(2,new Long(idArchivoAdjunto));    
                vPst_sentencia.executeUpdate();
                vPst_sentencia.close();          
                vInterfaz_DB.cn_Cerrar_coneccion();
                vResultado=true;
            } else {
                str_desError="No se encontro el ID Archivo Adjunto para insertar ó actualizar la data. Intente de nuevo por favor!!";
                vInterfaz_DB.cn_Cerrar_coneccion();
                pfuente.getInputStream().close();
            }
        }catch(Exception eas) {
            eas.printStackTrace();
            str_desError="Error al cargar el archivo: " + eas.getMessage();
            vInterfaz_DB.cn_Cerrar_coneccion();
        }
        return vResultado;
    }
    
    //Método que obtiene y retorna el nombre del Tipo de Documento Adjunto
    public String obtenerNombreTipoDocumentoAdjunto(int idTipoArchivo){
        String nombre=""; //valor inicial
        String consulta;
        Object nombreTipoArchivoObj;
        consulta = "select nombre from sis_tipo_archivo where id_tipo_archivo = " + idTipoArchivo;
        try{
            nombreTipoArchivoObj = this.vInterfaz_DB.getValorConsultaSimple("nombre", consulta);
            if (nombreTipoArchivoObj!=null){
                nombre = nombreTipoArchivoObj.toString();
            } else {
                str_desError="No se pudo obtener el nombre del Tipo de Archivo. Intente de nuevo por favor!!";
            }
            vInterfaz_DB.cn_Cerrar_coneccion();
        } catch (Exception e) {
            e.printStackTrace();
            str_desError="Error al obtener el nombre del Tipo de Archivo de la Base de Datos: " + e.getMessage();
            vInterfaz_DB.cn_Cerrar_coneccion();
        }
        return nombre;
    }
    
    //Método que nos dice si el tipo de archivo recibido como parámetro es permitido para el tipo de archivo recibido también como parámetro
    public boolean comprobarValidezTipoArchivoAdjunto(String extensionArchivo, int tipoArchivo) {
        boolean encontrado = false; //Cambiará su valor a true si la consulta devuelve un resultado positivo
        String consulta = "";
        Object vTipoArchivo;
        try {
            consulta = "select id_tipo_archivo from sis_tipo_archivo where upper(content_type) like '%"+extensionArchivo.toUpperCase()+"%' and id_tipo_archivo = " + tipoArchivo;
            vTipoArchivo = this.vInterfaz_DB.getValorConsultaSimple("id_tipo_archivo", consulta);
            if (vTipoArchivo!=null) {
                encontrado = true;
            } else {
                str_desError="No se permite este tipo de archivo. Seleccione otro por favor!!";
            }
        } catch (Exception e) {
            e.printStackTrace();
            str_desError="Error al comprobar validez del tipo de archivo seleccionado. Error técnico: " + e.getMessage();
        } finally { 
            vInterfaz_DB.cn_Cerrar_coneccion();
        } 
        return encontrado;
    }
}