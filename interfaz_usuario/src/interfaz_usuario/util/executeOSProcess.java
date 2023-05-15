package interfaz_usuario.util;

import java.io.DataInputStream;

public class executeOSProcess extends Thread {
   private String vRuta;
   private String vSalidaProc;

    public executeOSProcess(String pRuta) {
     this.vRuta=pRuta;
    }
    
    public executeOSProcess() {
     
    }
    
    public void setRuta(String pRuta){
        this.vRuta=pRuta;
    }
    
    
    public void ejecutarProceso(String pParametros){        
    
        byte buffer[];
        buffer = new byte[64];
        int vSize;
        String ls_str="";
        
        try{
        Runtime rt = Runtime.getRuntime();
        Process proc = rt.exec(vRuta+pParametros);
        //proc.exitValue();
         DataInputStream ls_in = new DataInputStream(proc.getInputStream());                
         
          while ((vSize=ls_in.read(buffer))==64)
          {
            ls_str=ls_str+ new String(buffer); 
          }
             
                       
          if (vSize>1)
          {          
           ls_str=ls_str+ new String(buffer,0,vSize-1);           
          }
                             
             //System.out.println(ls_str);
         this.vSalidaProc=ls_str;
        
        }catch (Exception exep)
        {
            exep.printStackTrace();
            vSalidaProc="";
        }
    }
    
    
    public void ejecutarProceso(String pParametros[]){        
    
        byte buffer[];
        buffer = new byte[64];
        int vSize;
        String ls_str="";
        
        try{
        Runtime rt = Runtime.getRuntime();
        Process proc = rt.exec(pParametros);
        //proc.exitValue();
         DataInputStream ls_in = new DataInputStream(proc.getInputStream());                
         
          while ((vSize=ls_in.read(buffer))==64)
          {
            ls_str=ls_str+ new String(buffer); 
          }
             
                       
          if (vSize>1)
          {          
           ls_str=ls_str+ new String(buffer,0,vSize-1);           
          }
                             
             //System.out.println(ls_str);
         this.vSalidaProc=ls_str;
        
        }catch (Exception exep)
        {
            exep.printStackTrace();
            vSalidaProc="";
        }
    }
    
    
    public void run() {
      try{
        Runtime rt = Runtime.getRuntime();
        Process proc = rt.exec(vRuta);
               
      }catch(Exception exep){
        exep.printStackTrace();  
          
      }                
 }

    
   public static void main(String args[]){
       
       new executeOSProcess("calc").ejecutarProceso("");
   }

    public String getSalidaProc() {
        return vSalidaProc;
    }
}
