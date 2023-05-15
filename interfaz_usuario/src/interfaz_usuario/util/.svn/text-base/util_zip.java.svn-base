package interfaz_usuario.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class util_zip {
   private static int tam_buffer=1024;
   private String vErrores;
   private boolean vBorrarFuentes;
   private int vNumArchivosCompr;
   public util_zip() {
      vBorrarFuentes=false;
    }
   
   /*
    * Establece si se borran los archivos que se comprimiran
    */
   public void setBorrarFuentes(boolean pBorrar){
       this.vBorrarFuentes=pBorrar;
   }
   /*
    * Metodo para definir el tamanio del buffer de lectura de archivos
    */
   public void setTamBuffer(int pTamBuffer){
     this.tam_buffer= pTamBuffer; 
   }
   /*
    * Metodo para obtener el mensaje de error al crear el Zip
    */
   
   public String getErrores(){
       return this.vErrores;
   }
   /*
    * Metodo para obtener el numero archivos que se agregaron al archivo zip
    */
   public int getNumArchAgregados(){
       return this.vNumArchivosCompr;
   }
   /*
    public static void main(String []args){
      
        util_zip salida= new util_zip();
       ArrayList archivos= new ArrayList();
        archivos.add("c:/pruebas/lan.log");
        archivos.add("c:\\pruebas\\realtek.log");
        archivos.add("c:\\pruebas\\RHDSetup.log");
        archivos.add("c:\\pruebas\\uno.txt");
      //salida.setBorrarFuentes(true);  
      salida.crear_zip("c:\\prueba.zip",archivos) ;
     
    }
    */
    /*
     *  Metodo para la crear de un archivo zip, recibe como parametro un array con 
     *  los nombres de los archivos a comprimir
     */
    public boolean crear_zip(String pNombreZip, ArrayList pArchivos){
        
        ZipOutputStream vZip;
        int vNumArchivos,vBytesLeidos;
        byte [] buffer=new byte[tam_buffer];
        File vArchivo;
        boolean vResultado=true;
        try{
            vNumArchivosCompr=0;
            vErrores="";
            vZip= new ZipOutputStream( new FileOutputStream(pNombreZip));    
            vNumArchivos=pArchivos.size();
                // Agregando uno por uno cada archivo
                for (int i=0; i<vNumArchivos;i++){
                   vArchivo= new File((String)pArchivos.get(i));
                   
                   if (vArchivo.exists()){ //Si el archivo existe se agrega al Zip
                    //Se crea la entrada zip 
                     ZipEntry vEntradaZip =  new ZipEntry(vArchivo.getName());
                     
                     // Se abre el archivo
                     FileInputStream vArchivoEntr = new FileInputStream(vArchivo);
                     
                     // Se agrega la entrada zip al archivo zip    
                     vZip.putNextEntry(vEntradaZip);                          
                        // Se lee el archivo que se desea comprimir y se escribe al archivo zip   
                         while ((vBytesLeidos=vArchivoEntr.read(buffer,0,tam_buffer))!=-1){
                           vZip.write(buffer,0,vBytesLeidos);
                              }
                      vArchivoEntr.close(); 
                      vNumArchivosCompr++;
                     
                     // Si esta habilitada la opcion de borrar los archivos
                      if (vBorrarFuentes==true){
                        if (!vArchivo.delete()){
                            vErrores=vErrores+vArchivo.getName()+" no se pudo borrar. ";   
                            vResultado=false;
                                              }
                                        } 
                      }else {
                     vErrores=vErrores+vArchivo.getName()+" no existe. ";
                     vResultado=false;
                    }
                }
            if (vNumArchivosCompr>0){
                vZip.flush();
                vZip.close();       
            }
        }catch(Exception eas){
            eas.printStackTrace();
            vResultado=false;
        }
    return vResultado;
    }
    
    
    public boolean eliminar_zip(String pNombreZip){
        File fichero = new File(pNombreZip);
             if(fichero.delete())
                return true;
             else
                return false;
    }
}
