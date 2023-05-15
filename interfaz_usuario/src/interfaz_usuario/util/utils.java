package interfaz_usuario.util;

import enlace_datos.util.resulOp;
import java.lang.reflect.Method;

import java.math.BigDecimal;

import java.sql.Time;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;

import java.util.Iterator;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import oracle.adf.view.faces.util.LabeledFacesMessage;

import oracle.jbo.Row;
import oracle.jbo.uicli.binding.JUIteratorBinding;


public class utils {

    public utils() {
    
    }
    
    public static Double getDouble1(Object valor){
      try{
      return new Double(valor.toString());  
      }catch(Exception excep){
          excep.printStackTrace();
          return new Double(0);
      }
    }
    
    public static Integer getInteger(Object valor){
      return new Integer(valor.toString());  
    }
    
    public static Number getNumber(Object valor){
      Number numValor= null;
      try{
        numValor=new Long (valor.toString().trim());
      }catch(Exception exep){
          
      }
      return numValor; 
    }
    
    public static oracle.jbo.domain.Number getNumberOracle(Object valor){
    oracle.jbo.domain.Number numValor=null;
     try{
      numValor= new oracle.jbo.domain.Number (valor.toString().trim());
     }catch(Exception exep){ }
      return numValor; 
    }   
    

    public static oracle.jbo.domain.Number getNumberOracleFormato(Object valor){
    oracle.jbo.domain.Number numValor=null;
     try{
      numValor= new oracle.jbo.domain.Number (valor.toString().trim().replace(",",""));
     }catch(Exception exep){ }
      return numValor; 
    }   
    
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
    
  public static int diffHoras(String pHoraI,String pHoraF){
      Time horaI,horaF;
      int hora;
      horaI=Time.valueOf(pHoraI+":00");
      horaF=Time.valueOf(pHoraF+":00");
      hora=(int)((horaF.getTime()-horaI.getTime())/36000);
   return hora;   
  }
  
  /*
   * Metodo para agregar un mensaje global al componente "MESSAGES"
   */
 public static void setADFMensaje(Object pResultado){
     FacesMessage vMessage; 
     FacesContext.getCurrentInstance();
     resulOp vResultado=(resulOp)pResultado;
     if (vResultado.getCodigoResultado()==resulOp.OPE_ERROR)
     vMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,vResultado.getMensajeError(),null);
     else if (vResultado.getCodigoResultado()==resulOp.OPE_OK)
        vMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,vResultado.getMensajeError(),null);
     else
        vMessage = new FacesMessage(FacesMessage.SEVERITY_WARN,vResultado.getMensajeError(),null);
     FacesContext.getCurrentInstance().addMessage(null,vMessage);
     
 }
    /*
     * Metodo para agregar un mensaje a un control especifico y al componente "MESSAGES"
     */
    public static void setADFMensajetoControl(Object pResultado,String idControl){
        FacesMessage vMessage; 
        FacesContext.getCurrentInstance();
        resulOp vResultado=(resulOp)pResultado;
        if (vResultado.getCodigoResultado()==resulOp.OPE_ERROR)
        vMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,vResultado.getMensajeError(),null);
        else if (vResultado.getCodigoResultado()==resulOp.OPE_OK)
           vMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,vResultado.getMensajeError(),null);
        else
           vMessage = new FacesMessage(FacesMessage.SEVERITY_WARN,vResultado.getMensajeError(),null);
        FacesContext.getCurrentInstance().addMessage(idControl,vMessage);
        
    }  
  
  /*
   * Metodo para obtener el id de cualquier control
  */
  public static String getNomControlCliente(Object componente){
    Method vmetodo;
    Object [] vparametros=new Object[1];
    String vresultado="";
    
    try{
       vmetodo=componente.getClass().getMethod("getClientId",new Class[]{FacesContext.class });
            
       vparametros[0]=FacesContext.getCurrentInstance();
       vresultado=vmetodo.invoke(componente,vparametros).toString();
  
    }catch(Exception eas){
        eas.printStackTrace();
    }
     
   return vresultado; 
  }
  
  /*
   *  Metodo para obtener el año actual
   */
  public static String getAnioActual(){
      String vResultado;
      SimpleDateFormat ab= new SimpleDateFormat("yyyy"); 
      vResultado=ab.format(new Date());
      return vResultado;
  }
  
 public static Date getFecha(String pValor){
     
     SimpleDateFormat formato =new SimpleDateFormat("dd/MM/yyyy");
     try{
         
         return formato.parse(pValor);    
         
     }catch(Exception exep){
         
     }
     
  return null;   
 }
  
 public static int getNumMes(String vMes){
     int vNumMes;
     if (vMes.toUpperCase().equals("ENERO")){
         vNumMes=1;    
     }else if (vMes.toUpperCase().equals("FEBRERO")){
         vNumMes=2;    
     }else if (vMes.toUpperCase().equals("MARZO")){
         vNumMes=3;    
     }else if (vMes.toUpperCase().equals("ABRIL")){
         vNumMes=4;    
     }else if (vMes.toUpperCase().equals("MAYO")){
         vNumMes=5;    
     }else if (vMes.toUpperCase().equals("JUNIO")){
         vNumMes=6;    
     }else if (vMes.toUpperCase().equals("JULIO")){
         vNumMes=7;    
     }else if (vMes.toUpperCase().equals("AGOSTO")){
         vNumMes=8;    
     }else if (vMes.toUpperCase().equals("SEPTIEMBRE")){
         vNumMes=9;    
     }else if (vMes.toUpperCase().equals("OCTUBRE")){
         vNumMes=10;    
     }else if (vMes.toUpperCase().equals("NOVIEMBRE")){
         vNumMes=11;    
     }else if (vMes.toUpperCase().equals("DICIEMBRE")){
         vNumMes=12;    
     }else{
         vNumMes=-1;    
     }
     
   return vNumMes;  
 }
  
    public static oracle.jbo.domain.Date getFechaOracle(String pValor){
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        oracle.jbo.domain.Date vFecha1;
        java.sql.Date vFecha2;
        
        try{
        
            vFecha2 = new java.sql.Date(formato.parse(pValor).getTime());
            
            //  formato.parse(pValor);
            
            vFecha1=new oracle.jbo.domain.Date(vFecha2);
            return vFecha1;
         
        }catch(Exception exep){
            exep.printStackTrace();
        }
     return null;   
    }  
  
    public static String getFechaFormato(String pMascara,Date pFecha){
        String vFormato;
        SimpleDateFormat formato = new SimpleDateFormat(pMascara);
        vFormato=formato.format(pFecha);
        return vFormato;
        
    }
  
  
    public static String getFechaFormato(String pMascara,oracle.jbo.domain.Date pFecha){
        String vFormato;
        SimpleDateFormat formato = new SimpleDateFormat(pMascara);
        vFormato=formato.format(pFecha);
        return vFormato;
        
    }
    public static String getFechaFormato2(String pMascara,oracle.jbo.domain.Date pFecha){
        String vFormato;
        SimpleDateFormat formato;
        formato= new SimpleDateFormat(pMascara);
        vFormato=formato.format(pFecha.getValue());
        return vFormato;
        
    }
    
    public static String getFechaFormato3(String pMAscara,Object pFecha){
        String vFecha="";
       try{ 
        if (pFecha.getClass()==oracle.jbo.domain.Date.class){
            
            vFecha=utils.getFechaFormato2(pMAscara,(oracle.jbo.domain.Date)pFecha);
            
        }else if (pFecha.getClass()==java.lang.String.class){
            vFecha=pFecha.toString();
        }
       }catch(Exception exep){
           
       }
      return vFecha;  
    }
    

    public static void removeUselessErrors(){
        FacesContext context = FacesContext.getCurrentInstance();
        Iterator<String> clients = context.getClientIdsWithMessages();
        String vSummary="";
        while (clients.hasNext()) {
        String clientId = clients.next();
        Iterator<FacesMessage> messages = context.getMessages(clientId);
        FacesMessage vTemp;

        while (messages.hasNext()) {
        vTemp=messages.next();
        if (vTemp.getSummary().equals(vSummary))
            messages.remove();
        else
            vSummary=vTemp.getSummary();
                                    }
        }
    }
    
    public static void removeAllErrorADF(){
        FacesContext context = FacesContext.getCurrentInstance();
        Iterator<String> clients = context.getClientIdsWithMessages();
        while (clients.hasNext()) {
        String clientId = clients.next();
        Iterator<FacesMessage> messages = context.getMessages(clientId);

        while (messages.hasNext()) {
        messages.next();
        messages.remove();
        }
        }
        
    }
    
    
    public static void removeAllErrorADFLabelMessages(){
        FacesContext context = FacesContext.getCurrentInstance();
        Iterator<String> clients = context.getClientIdsWithMessages();
        Object vMensaje;
        while (clients.hasNext()) {
        String clientId = clients.next();
        Iterator  messages = context.getMessages(clientId);

        while (messages.hasNext()) {
        vMensaje=messages.next();
         if (vMensaje.getClass()==LabeledFacesMessage.class){
             messages.remove();     
                                                             }
                                    }
                        }
    }
    
   public static String getUsuario(){
      return JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"flujo_usuario.selRegEmpleado_login").toString();
   }
    
    public static List<SelectItem> crearListaManyCheck(String pNomIterador,String pValor,String pEtiqueta){
        Object vIterador,vValor,vEtiqueta;;
        JUIteratorBinding vIterador2;
        int vNumeroFilas;
        Row [] vFilas;
        List<SelectItem> vTemp=null;
        
        vIterador=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings."+pNomIterador + "}");
         if (vIterador!=null){
             vIterador2=(JUIteratorBinding)vIterador;
             vNumeroFilas=vIterador2.getViewObject().getRowCount();
             
             vTemp = new ArrayList<SelectItem>(vNumeroFilas);
             vFilas=vIterador2.getViewObject().getAllRowsInRange();
             for (int i=0;i<vNumeroFilas;i++){
             
                 vValor=vFilas[i].getAttribute(pValor);
                 vEtiqueta=vFilas[i].getAttribute(pEtiqueta);
                 vTemp.add(new SelectItem(vValor,vEtiqueta.toString()));
             }
         }
     return  vTemp;
    }

    public static String getListaComas(ArrayList pValores){
        String vLista=null;
        
        if (pValores != null){
          vLista=pValores.toString();
          vLista=vLista.replace("[","");
          vLista=vLista.replace("]","");
          
        }
        
      return vLista;  
    }


    public static BigDecimal getBigDecimal(Object pValor){
      BigDecimal vValor;
      try{
          vValor=new BigDecimal(pValor.toString());
          
      }catch(Exception exep){
          vValor=null;
      }
      return vValor;
    }
    
    
    /*
     * Metodo para eliminar el prefijo del usuario logueado
     */

       public static String getUsuarioSinPrefijo(String pUsuario){
           String vUsuarioMod;
           String vPrefUsuario="T";
           
           if (pUsuario.startsWith(vPrefUsuario)){
               vUsuarioMod=pUsuario.substring(vPrefUsuario.length(),pUsuario.length()); 
           }else{
               vUsuarioMod=pUsuario.trim();
           }
           
         return vUsuarioMod;  
       }
 
 public static boolean isNumber(String pValor){
        oracle.jbo.domain.Number numValor=null;
        boolean vResultado=true;
         try{
          numValor= new oracle.jbo.domain.Number (pValor.toString());
         }catch(Exception exep)
           {
            vResultado=false; 
            }
          return vResultado;  
  }

    public static List<SelectItem> crearListaCombo(String pNomIterador,String pValor,String pEtiqueta){
         return  utils.crearListaCombo(pNomIterador,pValor,pEtiqueta,0);
    }


public static List<SelectItem> crearListaCombo(String pNomIterador,String pValor,String pEtiqueta,int pOpcion){
        Object vIterador,vValor,vEtiqueta;;
        JUIteratorBinding vIterador2;
        int vNumeroFilas;
        Row [] vFilas;
        List<SelectItem> vTemp=null;
        
        vIterador=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings."+pNomIterador + "}");
         if (vIterador!=null){
             vIterador2=(JUIteratorBinding)vIterador;
             vNumeroFilas=vIterador2.getViewObject().getRowCount();
             
             vTemp = new ArrayList<SelectItem>(vNumeroFilas);
             vFilas=vIterador2.getViewObject().getAllRowsInRange();
             for (int i=0;i<vNumeroFilas;i++){
             
                 vValor=vFilas[i].getAttribute(pValor);
                 vEtiqueta=vFilas[i].getAttribute(pEtiqueta);
                 vTemp.add(new SelectItem(vValor,vEtiqueta.toString()));
             }
         }
         
     if (pOpcion==1 && vTemp!=null && vTemp.size()==0) {
         //vTemp.add(new SelectItem(utils.getNumberOracle("0")," ")); 
          vTemp.add(new SelectItem()); 
     }
         
     return  vTemp;
}

public static List<SelectItem> crearListaComboRangoNum(int pInicio,int pFin,String pEtiqueta,int pOpcion){

      List<SelectItem> vTemp=null;
      vTemp=new ArrayList<SelectItem>();

         for (int i=pInicio;i<=pFin;i++)
         {
         
                     vTemp.add(new SelectItem(i,i+" "+pEtiqueta));
         
          }
             
         if (pOpcion==1 && vTemp!=null && vTemp.size()==0) {
             //vTemp.add(new SelectItem(utils.getNumberOracle("0")," ")); 
              vTemp.add(new SelectItem()); 
         }
return  vTemp;
}

public static List<SelectItem> crearListaComboPrimeroVacio(String pNomIterador,String pValor,String pEtiqueta){
            
Object vIterador,vValor,vEtiqueta;;
JUIteratorBinding vIterador2;
int vNumeroFilas;
Row [] vFilas;
List<SelectItem> vTemp=null;
vTemp = new ArrayList<SelectItem>();       
vTemp.add(new SelectItem());

vIterador=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings."+pNomIterador + "}");
    if (vIterador!=null){
       vIterador2=(JUIteratorBinding)vIterador;
       vNumeroFilas=vIterador2.getViewObject().getRowCount();
                 
       //vTemp = new ArrayList<SelectItem>(vNumeroFilas);
       vFilas=vIterador2.getViewObject().getAllRowsInRange();
         for (int i=0;i<vNumeroFilas;i++){                
            vValor=vFilas[i].getAttribute(pValor);
            vEtiqueta=vFilas[i].getAttribute(pEtiqueta);
            vTemp.add(new SelectItem(vValor,vEtiqueta.toString()));
            }
      }
return  vTemp;
}
 
  
public static List<SelectItem> crearListaComboAniosTrabajo(){

   List<SelectItem> vTemp=null;
   vTemp=new ArrayList<SelectItem>();
   Object vAnios;
   String [] vAniosList;
   
   vAnios=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{flujo_usuario.aniosTrabajo}");

   if (vAnios!=null){
   
       vAniosList=vAnios.toString().split("\\,");
       
       for (int i=0;i<vAniosList.length;i++)
       {
       
            vTemp.add(new SelectItem(vAniosList[i],vAniosList[i]));
       
        }       
       
   }

                 
return  vTemp;
}
    public static oracle.jbo.domain.Date getFechaActual(){
     return new oracle.jbo.domain.Date(new java.sql.Timestamp(System.currentTimeMillis()));   
    }
  
  
    
}
