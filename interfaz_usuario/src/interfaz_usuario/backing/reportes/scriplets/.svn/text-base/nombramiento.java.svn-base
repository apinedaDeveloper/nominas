package interfaz_usuario.backing.reportes.scriplets;

import net.sf.jasperreports.engine.JRDefaultScriptlet;
import net.sf.jasperreports.engine.JRScriptletException;

public class nombramiento extends JRDefaultScriptlet {
       String vgNomAuthNombramiento;
       String vgCargoAuthNombramiento;
       String VgNomAuthActaPosesion;
       String vgCargoAuthActaPosesion;
       String vgNomAuthTramite;
       String vgCargoAuthTramite;
       
        public nombramiento() {
            
        }
        
        public void afterReportInit() throws JRScriptletException{
            getDatosAuthNombramiento();
            getDatosAuthActaPosesion();
            getDatosAuthTramite();
        }
        
            
        public String getNomAuthNombramiento() throws JRScriptletException {
            return this.vgNomAuthNombramiento;
          
        }
        
        public String getCargoAuthNombramiento(){
            return this.vgCargoAuthNombramiento;
           
        }
        
        public String getNomAuthActaPosesion(){
           return this.VgNomAuthActaPosesion;
           
            
        }
        
        public String getCargoAuthActaPosesion(){
           return this.vgCargoAuthActaPosesion;
        }
        
        
        public String getNomAuthTramite(){
           return this.vgNomAuthTramite;   
        }
    
        public String getCargoAuthTramite(){
           return this.vgCargoAuthTramite;
        }
        
        /*
         * Metodo para desglosar el nombre y cargo de auth nombramiento
         */
        public void getDatosAuthNombramiento(){
          String vTemp;
          int vIndice;
                vgNomAuthNombramiento="";
                vgCargoAuthNombramiento="";
           try{
           vTemp=(String)this.getFieldValue("AUTH_NOMBRAMIENTO");
           
           if (vTemp!=null){
                vIndice=vTemp.indexOf("|"); 
                    if (vIndice>0){
                        vgNomAuthNombramiento=vTemp.substring(0,vIndice);
                        vgCargoAuthNombramiento=vTemp.substring(vIndice+1,vTemp.length());
                                  }else{
                                      vgNomAuthNombramiento=vTemp;    
                                      
                                  }
                                  
                            }
            }        
             catch(Exception exep){
                  exep.printStackTrace();
                  vgNomAuthNombramiento="";
                  vgCargoAuthNombramiento="";
               
                                   }
                            
            }
             
    /*
     * Metodo para desglosar el nombre y cargo de auth toma posesion
     */
        public void getDatosAuthActaPosesion(){
          String vTemp;
          int vIndice;
            VgNomAuthActaPosesion="";
            vgCargoAuthActaPosesion="";
           try{
           vTemp=(String)this.getFieldValue("AUTH_ACTA_TOMA_POS");
           if (vTemp!=null){
                vIndice=vTemp.indexOf("|"); 
                        if (vIndice>0){
                        VgNomAuthActaPosesion=vTemp.substring(0,vIndice);
                        vgCargoAuthActaPosesion=vTemp.substring(vIndice+1,vTemp.length());
                                    }else{
                                        VgNomAuthActaPosesion=vTemp;   
                                    }
                    }
           }catch(Exception exep){
               exep.printStackTrace();
               VgNomAuthActaPosesion="";
               vgCargoAuthActaPosesion="";
               
           }
        }
        
    /*
     * Metodo para desglosar el nombre y cargo de auth tramite
     */
        public void getDatosAuthTramite(){
          String vTemp;
          int vIndice;
            vgNomAuthTramite="";
            vgCargoAuthTramite="";
           try{
           vTemp=(String)this.getFieldValue("AUTH_ACTA_TRAMITE");
           if (vTemp!=null){
                vIndice=vTemp.indexOf("|"); 
                        if (vIndice>0){
                        vgNomAuthTramite=vTemp.substring(0,vIndice);
                        vgCargoAuthTramite=vTemp.substring(vIndice+1,vTemp.length());
                                    }else{
                                        vgNomAuthTramite=vTemp;   
                                    }
                    }else{
                        vgNomAuthTramite=(String)this.getFieldValue("CREADO_POR");
                    }
           }catch(Exception exep){
               exep.printStackTrace();
               vgNomAuthTramite="";
               vgCargoAuthTramite="";
               
           }
        }        
        
}
