package pkg_carga_datos;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.io.Reader;

import java.io.Writer;

import java.nio.charset.Charset;

import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import sun.misc.HexDumpEncoder;

public class archivo {
        private FileOutputStream vFlout_Descript_archivo;
        private FileInputStream vFlint_Descript_archivo;
        private BufferedReader vBuff_lectura_archivo;
        private String vStr_NombreArchivo;
        private String vStr_PathArchivo;
        private String vStr_TipoArchivo;
        private String vStr_Extension;
        private String vStr_NombreArchivoAbr;
        private String v_Str_des_error;
        int vInt_modo_archivo;
        long vLng_linea_actual;
        private final int tam_buffer=1024;
        /*
        
    public static void main(String []args){
    
    String test = "C3P2MP2M";
         for ( int i = 0; i < test.length(); ++i ) {
           char c = test.charAt( i );
           int j = (int) c;
           System.out.print(j+",");
           }
    }*/
    

        /*public static void main(String []args){
            new archivo("c:\\nomina_sueldos.txt").concatenar("c:\\resumen_nomina_sueldos.TXT",true,false);
            
        }
        */
        
/*
        public static void main(String []args){
             
             archivo a;
             a=new archivo();
             String vCad;
            try{ 
            
            
               //System.out.println(System.getProperty("line.separator"));
                
            
                Charset utf8 = Charset.forName("UTF-8");
                Charset cp12 = Charset.forName("ISO-8859-1");
               //Cad=a.readFromFile(new File("c:\\c4.txt"),utf8); 
                
                vCad="αισ";
                
                
                a.writeToFile(new File("c:\\C22x.txt"),cp12,vCad);     
                
            }catch(Exception exep){
                
                
            }
                    
                     
           }
 
        */
        public archivo(){
            
        }
        
        public archivo(String vStr_NombreArchivo){
           int vPosicion;
            this.vStr_NombreArchivo=vStr_NombreArchivo;

        try{            
            // Obteniendo la extension del archivo
            vPosicion=vStr_NombreArchivo.lastIndexOf(".");
              if (vPosicion>0){
                 this.vStr_Extension= vStr_NombreArchivo.substring(vPosicion+1,vStr_NombreArchivo.length());
                 this.vStr_NombreArchivoAbr=vStr_NombreArchivo.substring(0,vPosicion);
              }
        }catch(Exception exep){
            this.vStr_Extension="";
            this.vStr_NombreArchivoAbr="";
                                }
           
        }
        
        
        public String getExtensionArchivo(){
            return this.vStr_Extension;
        }
        
        public String getNombreArchivo_Sin_Ext(){
            return this.vStr_NombreArchivoAbr;
        }
        
        public boolean Bol_AbrirArchivo(String pStr_NombreArchivo,String pStr_opcion) {
         try{
        vFlint_Descript_archivo=new FileInputStream(pStr_NombreArchivo);
        
        if (pStr_opcion.equals("BUFF_LINEA")){ //Para utilizar un buffer para leer el archivo y leerlo por lineas
        FileReader fileRead=new FileReader(vFlint_Descript_archivo.getFD());     
        vBuff_lectura_archivo=new BufferedReader(fileRead);       
        }
        
         }catch(Exception exep){
             exep.printStackTrace();
             return false;
         }
        return true;
        }

        public boolean Bol_Crear_archivo(String pStr_NombreArchivo) {
            return false;
        }

        
        public boolean Bol_CerrarArchivo() {
            try{
            if (this.vFlint_Descript_archivo!=null){
                vFlint_Descript_archivo.close();
            }
            if (this.vBuff_lectura_archivo!=null){
               this.vBuff_lectura_archivo.close(); 
            }
            if (this.vFlout_Descript_archivo!=null){
                this.vFlout_Descript_archivo.close(); 
            }
            }catch(Exception exep){
                return false;    
            }
            return true;
        }

        public void VD_Escribir_Archivo(String pStr_Mensaje) {
            
        }

        public String getLinea() {
            try{
            return vBuff_lectura_archivo.readLine();
            }catch(Exception exep){
                exep.printStackTrace();
                return null;
            }
        }
        
        
        public String Get_error_archivo(){
            return this.v_Str_des_error;
        }
        
        /*
         * Metodo para copiar un archivo reciendo el stream del fuente
         */
        public boolean Bol_copiar_archivo(InputStream pFlintsource,String pStr_destino){
            byte[] buffer;
            int cantidad_bytes;
            try{
            vFlout_Descript_archivo = new FileOutputStream(pStr_destino);
           
                
            buffer=new byte[tam_buffer];
           
             cantidad_bytes=pFlintsource.read(buffer);
                             
             while (cantidad_bytes>0){      
                vFlout_Descript_archivo.write(buffer,0,cantidad_bytes);
                cantidad_bytes=pFlintsource.read(buffer);
             }
             
            pFlintsource.close();
            vFlout_Descript_archivo.close();
            }catch(Exception excep){
                excep.printStackTrace();
                this.v_Str_des_error=excep.getMessage();
                return false;
            }
        return true;
        }

    /*
     * Metodo para concatenar un archivo al actual al final del archivo
     */
      public void concatenarInicioArchivo(String pNomArchivo,String pCadena,boolean borrarFuente){
        int tamBuffer=1024;
        byte buffer[]= new byte[tamBuffer];
        int vNumbytesLeidos;
        long vPosicion=0;
        FileInputStream vArchivoFuente;
        File vDescpArchivoFuente;
        
        try{
          RandomAccessFile vArchivoDestino=
          new RandomAccessFile(this.vStr_NombreArchivo, "rw") ;            
          //Posicionando al inicio del archivo
          vArchivoDestino.seek(0);
          
          // Concatenar archivo al inicio
          if (pNomArchivo!=null){
              vDescpArchivoFuente=new File(pNomArchivo);
              vArchivoFuente=
              new FileInputStream(vDescpArchivoFuente);
              while ((vNumbytesLeidos=vArchivoFuente.read(buffer,0,tamBuffer))!=-1){
                 vArchivoDestino.write(buffer,0,vNumbytesLeidos); 
              }
              
              vArchivoDestino.close();
              vArchivoFuente.close();
              
              if (borrarFuente){ // Borrando el archivo fuente
                  vDescpArchivoFuente.delete();
              }
              
          }else if (pCadena!=null){
              vArchivoDestino.write(pCadena.getBytes());
              vArchivoDestino.close();
          }
           
          
        }catch(Exception exep){
             exep.printStackTrace();
        }
          
      }


/*
 * Metodo para cocatenar un archivo al actual al final del archivo
 */
  public void concatenarFinArchivo(String pNomArchivo,boolean buscarCambioPagina,boolean borrarFuente){
    int tamBuffer=1024;
    byte buffer[]= new byte[tamBuffer];
    int vNumbytesLeidos;
    long vPosicion=0;
    FileInputStream vArchivoFuente;
    File vDescpArchivoFuente;
    
    try{
      RandomAccessFile vArchivoDestino=
      new RandomAccessFile(this.vStr_NombreArchivo, "rw") ;
      
      // Verificando que el tamanio del buffer no sea mayor que el tamanio del archivo
      if (vArchivoDestino.length()<tamBuffer&&vArchivoDestino.length()>0){
          tamBuffer=(int)vArchivoDestino.length()-1;
      }
      
      vPosicion=vArchivoDestino.length();
      if (buscarCambioPagina==true&&vPosicion>0){
       
            vArchivoDestino.seek(vArchivoDestino.length()-tamBuffer);
            vArchivoDestino.read(buffer);
       //Buscando el cambio de pagina
       for (int i=tamBuffer-1;i>=0;i--){
           if (buffer[i]==12){
              vPosicion=vArchivoDestino.length()-tamBuffer+i+1;
              break;
           }
       }
      
      if (vPosicion==0){
          vPosicion=vArchivoDestino.length();
                        }
      }
      
      vArchivoDestino.seek(vPosicion);
      
      vDescpArchivoFuente=new File(pNomArchivo);
      vArchivoFuente=
      new FileInputStream(vDescpArchivoFuente);
      
      while ((vNumbytesLeidos=vArchivoFuente.read(buffer,0,tamBuffer))!=-1){
         vArchivoDestino.write(buffer,0,vNumbytesLeidos); 
      }
    
      vArchivoDestino.close();
      vArchivoFuente.close();
      
      if (borrarFuente){ // Borrando el archivo fuente
          vDescpArchivoFuente.delete();
      }
      
    }catch(Exception exep){
         exep.printStackTrace();
    }
      
  }

  public boolean borrar(){
      File vArchivo;
      boolean vResultado=false;
      try{
          vArchivo=new File(vStr_NombreArchivo);   
           if (vArchivo.exists()){
               vResultado=vArchivo.delete();
           }

      }catch(Exception exep){
          exep.printStackTrace();
      }
          
   return vResultado;    
  }




    public  String readFromFile(File file,
          Charset charset) throws IOException {
        InputStream in = new FileInputStream(file);
        Closeable stream = in;
        try {
          Reader reader = new InputStreamReader(in, charset);
          stream = reader;
          StringBuilder inputBuilder = new StringBuilder();
          char[] buffer = new char[1024];
          while (true) {
            int readCount = reader.read(buffer);
            if (readCount < 0) {
              break;
            }
            inputBuilder.append(buffer, 0, readCount);
          }
          return inputBuilder.toString();
        } finally {
          stream.close();
        }
      }


public  void writeToFile(File file,
          Charset charset, String data) throws IOException {
        OutputStream out = new FileOutputStream(file);
        Closeable stream = out;
        try {
          Writer writer = new OutputStreamWriter(out, charset);
          stream = writer;
          writer.write(data);
        } finally {
          stream.close();
        }
      }

}
