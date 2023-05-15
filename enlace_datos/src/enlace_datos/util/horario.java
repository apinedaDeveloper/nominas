package enlace_datos.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import java.text.DecimalFormat;
import java.text.NumberFormat;



public class horario {
     private int hora=0;
     private int minutos=0;
     
    public horario() {
    }
    
    public horario(String pHorario){
        this.setHorario(pHorario);
    }
    
    public void setHora(int pHora){
        if (pHora<23)
          this.hora=pHora;
        else
         this.hora=23;
    }
    
    public int getHora(){
        return this.hora;
    }
    public void setMinutos(int pMinutos){
        if (pMinutos<59)
         this.minutos=pMinutos;
        else
         this.minutos=59;
    }
    
    public int getMinutos(){
        return this.minutos;
    }
    
    /*
     *  Metodo para obtener el horario en la forma de intervalo
     */
    public String getHorarioInterval(){
      return "0 "+this.getHorario()+":00"; 
    }
    
    
    /*
     *  Metodo para obtener el horario en formato de cadena
     */
    public String getHorario(){
       String result;
       NumberFormat formato;
       formato= new DecimalFormat("00");
       result=formato.format(this.hora)+":"+formato.format(this.minutos);
       return result;
    }
    
    /*
     * Metodo para reemplazar el horario actual a partir de una cadena
     */
    public void setHorario(String pHorario){
     int indice;
        if (this.isHora(pHorario)){
            indice=pHorario.indexOf(":");
           this.hora= Integer.valueOf(pHorario.substring(0,indice));
           this.minutos=Integer.valueOf(pHorario.substring(indice+1,pHorario.length())); 
        }
    }
    
    /*
     *  Metodo para reemplazar el horario a partir de la cadena que recibe de la BD
     */
    public void setHorarioBase(String pHorario){
        int indice=0;
        String [] strPartes;
        strPartes=pHorario.split("[:\\s]");
        if (strPartes.length>=4){
        this.hora= Integer.valueOf(strPartes[1]);
        this.minutos=Integer.valueOf(strPartes[2]); 
        }
    }
    
    /*
     *  Metodo para obtener la diferencia de horas entre dos horas
     */
    public double getDiff_Horas(horario pHora){
       BigDecimal difHoras;
       double hora1,hora2;
       
       /*
       hora1=this.getHora()*60+this.getMinutos();
       hora2=pHora.getHora()*60+pHora.getMinutos();
       difHoras=new BigDecimal((hora1-hora2)/60);
       difHoras=difHoras.setScale(0,RoundingMode.UP);
       return difHoras.intValue();
       */
       
        hora1=this.getHora()*60+this.getMinutos();
        hora2=pHora.getHora()*60+pHora.getMinutos();
        
        if (hora1<hora2){
           hora1=hora1+(24*60); 
        }
        
        difHoras=new BigDecimal((hora1-hora2)/60);
        //difHoras=difHoras.setScale(4,RoundingMode.UP);
        // difHoras=difHoras.setScale(4);
        
        return difHoras.doubleValue();
       
    }
    

    /*
     *  Metodo para obtener la diferencia de horas entre dos horas
     */
    public int getDiff_minutos(horario pHora){
       
        int hora1,hora2;
       
        hora1=this.getHora()*60+this.getMinutos();
        hora2=pHora.getHora()*60+pHora.getMinutos();
        
        if (hora1<hora2){
           hora1=hora1+(24*60); 
        }
        
        
        return hora1-hora2;
       
    }


    /*
     *  Metodo para verificar si una cadena es de tipo hora
     */
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
    
}
