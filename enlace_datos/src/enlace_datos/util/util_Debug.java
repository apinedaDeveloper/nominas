package enlace_datos.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

import java.util.Date;

public class util_Debug {
   String vNomArchivo;
   PrintWriter vSalida;
    BufferedWriter bw;

    public util_Debug() {
        vNomArchivo="log_SIS.txt";
     try{
        FileWriter fw = new FileWriter(vNomArchivo, true);
        bw = new BufferedWriter(fw);
        vSalida = new PrintWriter(bw, true);
     }catch(Exception exp1){
         
     }
    
    }
    
    
    public void DebugA(String pClase,Integer pLinea,Exception exep,boolean pDetallado){
    try{
      
      vSalida.println("");
      
      if (pLinea!=null)
      vSalida.print("["+new Date()+":"+pClase+":"+pLinea+"] ");        
       else
      vSalida.print("["+new Date()+":"+pClase+"] ");        
      
      if (pDetallado)
       exep.printStackTrace(vSalida);        
      else
      vSalida.println(exep.getMessage());        
      
      bw.close();
      vSalida.close();
      
    }catch(Exception exep2){
        exep2.printStackTrace();
    }
    }

    public void DebugA(String pClase,Integer pLinea,String pMsg){
    try{
      
      vSalida.println("");
      
      if (pLinea!=null)
      vSalida.print("["+new Date()+":"+pClase+":"+pLinea+"] ");        
       else
      vSalida.print("["+new Date()+":"+pClase+"] ");        
      
      vSalida.println(pMsg);        
      
      bw.close();
      vSalida.close();
      
    }catch(Exception exep2){
        exep2.printStackTrace();
    }
  
 }

}