package interfaz_usuario;

import enlace_datos.util.encription;

import java.util.HashMap;

import enlace_datos.util.utils;
import interfaz_usuario.util.JSFUtils;

import java.sql.ResultSet;

import java.util.Enumeration;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import oracle.security.jazn.sso.util.JSSOUtil;

import pkg_util_base_datos.interfaz_DB;


public class usuario {
    private HashMap vHmp_opciones;
    private String idBitacora;
    public static final short SEL_REGEMPLEADO=0;
    public static final short SEL_DEPTO=1;
    public static final short SEL_ORDEN=2;
    public static final short SEL_CONTRATO=3;
    public static final short VISTA_CONTRATO=4;
    public static final short VISTA_EMPLEADO=5;
    public static final short REG_EMPLEADO_LOGIN=6;
    public static final short NUEVA_SOL_REG_EMPLEADO=7;
    public static final short NUEVA_SOL_ID_CONTRATO=8;
    public static final short VISTA_SOLICITUD=9;
    public static final short EMPLSEL=10;
    public static final short SEL_CONTRATO_PARTIDA=11;
    public static final short SEL_CONTRATO_PLAZA=12;
    public static final short VISTA_ORDEN_JUDICIAL=13;
    public static final short VISTA_SUSP_IGSS=14;
    public static final short CURRENTSOLICITUD=15;
    public static final short CURRENT_ITEM_MENU=16;
    public static final short NOMBREEMPLEADOSEL=17;
    public static final short PERFILES_USUARIO_LOGIN=18;
    public static final short REG_EMPLEADO_REV_NOM=19;
    public static final short VISTA_PROC_AUMENTO_SAL=20;
    public static final short VISTA_OPERACION=21;
    public static final short NOMUSUARIOLOGUEADO=22;
    public static final short VISTA_FICHAEMPLEADO=23;
    public static final short PROCESO_SEL_OPE=24;
    public static final short VISTA_AUXILIAR=25;
    public static final short LOGUOUT=26;
    public static final short ANIOTRABAJO=27;
    public static final short ACTUALIZA_DATOS=28;
    public static final short ACTUALIZA_DATOS_CONFRONTA=29;
    public static final short ESTADO_EMPLEADO=30;
    public static final short CENSO_LABORAL_RESET=31;
    public static final short CENSO_LABORAL_VISTA=32;
    public static final short VISTA_RETIRO=33;
    public static final short VISTA_RESCISION=34;
    public static final short VISTA_FALLECIMIENTO=35;    
    public static final short VISTA_LIQUIDACION=36;
    public static final short VISTA_RENUNCIA_PARCIAL=37;
    public static final short SEL_CUI=38;
    public static final short VISTA_SUSP_LAB=39;
    public static final String vPrefUsuario="T";
    public static final String vDominio="Nomina";
    private String vAcceso="SI";
    public boolean validarClave=false;
    private boolean vShowMensajeCuenta=false;
    private String vListadoAniosTrabajo="";
    private String vIdCargaArchivo="";
    private long vTiempoMensajes;
    private String vMensajesPendientes;
    private String vMensajesHabil=null;
    private String vIdReplyMensaje="0";
    private String vDestinatario="";
    private String vAsunto="";
    private String vIdBitacora;
    private encription ecrip=new encription();
    private String vPaginaDocs;
    private String vCrearCorreo;
  
    public boolean getShowMensajeCuenta(){
        boolean vTemp=vShowMensajeCuenta;
        vShowMensajeCuenta=false;
        return vTemp;
    }
  
  
    public void setShowMensajeCuenta(boolean vValor){
        vShowMensajeCuenta=vValor;
        
    }
    
    public void insertarBitacora(){
        
        interfaz_DB vCone=new interfaz_DB();
        HttpServletRequest b;
        String headerName;
        String vIpCliente;
        String vAgente;
        
        try
        {
        b=(HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        vIpCliente="";
        
        Enumeration headerNames = b.getHeaderNames();
            
           while(headerNames.hasMoreElements()) 
           {

               headerName = (String)headerNames.nextElement();
                   if (headerName.equals("X-FORWARDED-FOR"))
                   {
                       vIpCliente=b.getHeader(headerName);  
                       
                   }else if (headerName.equals("USER-AGENT")){
                   
                       vAgente=b.getHeader(headerName);  
                       
                   }
                  
            }
          
        if (vIpCliente.equals(""))
        {
            vIpCliente=b.getRemoteAddr();  
        }
        
        idBitacora=vCone.getValorSequencia("bitacora_acceso_sq");
        
        if (idBitacora!=null)
        {
        vCone.Crear_sentencia("insert into bitacora_acceso(id_bitacora,usuario,tipo_usuario,aplicacion,ip) values(?,?,?,?,?)");
        vCone.setParametrosSentencia(1,new Long(idBitacora));
        vCone.setParametrosSentencia(2,this.getSelRegEmpleado_login());
        vCone.setParametrosSentencia(3,"TRABAJADOR");
        vCone.setParametrosSentencia(4,"SIS");
        vCone.setParametrosSentencia(5,vIpCliente);
        vCone.ejecutar_update(true);
        
        }
        
        vIdBitacora=idBitacora;
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("idBitacora",idBitacora);
        
        }catch(Exception exep){
            vCone.cn_Cerrar_coneccion();
            exep.printStackTrace();
            
        }
    }

    public String getLogOut(){
      
        interfaz_DB vCone=new interfaz_DB();
        vCone.ejecutar_update("update bitacora_acceso set fecha_logout=sysdate where id_bitacora="+this.idBitacora,true);
    
        return "ok";
    }


    public String getActualizaDatos(){
        String vActualiza,vQuerry;
        Object vResultado;
        interfaz_DB vCone=new interfaz_DB();
        try{
         // 0= nueva  aumento  1 = modif aumento
        vActualiza = (String)vHmp_opciones.get(ACTUALIZA_DATOS);
        
        if (vActualiza==null){
            throw new Exception();
        }
        
        }catch(Exception eas){
        
            vQuerry="select count(0) actualiza from sis_ficha_empleado  where no_formulario is not null";
            vQuerry=vQuerry+" and registro_empleado="+ this.getSelRegEmpleado_login() + "";
            vResultado=vCone.getValorConsultaSimple("actualiza",vQuerry);
            vCone.cn_Cerrar_coneccion();          
            vActualiza=(vResultado==null?"1":vResultado.toString());
            setActualizaDatos(vActualiza);
        }
        return vActualiza;
    }


    public void getAniosTrabajoBD(){
        String vQuerry,vAnios;
        Object vResultado;
        interfaz_DB vCone=new interfaz_DB();

        
            vQuerry="select valor_cadena\n" + 
            "from sis_parametros_aplicacion\n" + 
            "where nom_parametro='LISTADO_ANIO_TRABAJO'";                        
            vResultado=vCone.getValorConsultaSimple("valor_cadena",vQuerry);
            
            vCone.cn_Cerrar_coneccion();          
            vAnios=(vResultado==null?"2011":vResultado.toString());
            this.vListadoAniosTrabajo=vAnios;

    }

    
    public void setActualizaDatos(String pValor){
        vHmp_opciones.put( ACTUALIZA_DATOS,pValor);    
    }
    
    public String getActualizaDatosConfronta()
    {
        String vActualiza,vQuerry;
        Object vResultado;
        interfaz_DB vCone=new interfaz_DB();
        try{
         // 0= nueva  aumento  1 = modif aumento
        vActualiza = (String)vHmp_opciones.get(ACTUALIZA_DATOS_CONFRONTA);
        
        if (vActualiza==null || (vActualiza!=null && vActualiza.equals(""))) {
            throw new Exception();
        }
        
        }catch(Exception eas){
        
            vQuerry="select count(0) actualiza from sis_ficha_empleado  where no_formulario is not null";
            vQuerry=vQuerry+" and registro_empleado="+ this.getSelRegEmpleado_login() + " and estado=2";
            vResultado=vCone.getValorConsultaSimple("actualiza",vQuerry);
            vCone.cn_Cerrar_coneccion();          
            vActualiza=(vResultado==null?"1":vResultado.toString());
            setActualizaDatosConfronta(vActualiza);
        }
        return vActualiza;

        
    }
    
    public void setActualizaDatosConfronta(String pValor)
    {
        vHmp_opciones.put( ACTUALIZA_DATOS_CONFRONTA,pValor); 
    
    }

    public usuario() {
      
      vHmp_opciones=new HashMap(1);
      interfaz_DB vCone=new interfaz_DB();
      String vQuerry;
      String vPagina,vContexto;
      Object vResultado;
      vQuerry="select count(0) as Logueado from usuario where";
      vQuerry=vQuerry+" usuario='"+ this.getSelRegEmpleado_login() + "' and tipo_usuario='TRABAJADOR' and activo=1 and primer_login=1";
      vResultado=vCone.getValorConsultaSimple("Logueado",vQuerry);
      vCone.cn_Cerrar_coneccion(); 
      
       // temporal para desabilitar el cambio de clave en otra pagina, mientras se incluye uno interno
       //vResultado="0";
        if (vResultado!=null && !vResultado.toString().equals("0")){
           try{
           
              vPagina=FacesContext.getCurrentInstance().getViewRoot().getViewId();  
              vContexto=FacesContext.getCurrentInstance().getExternalContext().getInitParameter("ContextApp");
             
              vPagina=FacesContext.getCurrentInstance().getExternalContext().getInitParameter("PaginaCambioClave");//+"?prvUrl="+vContexto+vPagina;           
              FacesContext.getCurrentInstance().getExternalContext().redirect(vPagina);    
              // FacesContext.getCurrentInstance().getExternalContext().redirect("http://www.google.com.gt/?asdad=asdad");    
              validarClave=true;
             
           }catch(Exception exep){
               
           }
         }

    //  System.out.println("session del usuario");
      insertarBitacora();  
     
     //borrando los cookies 
     try{ 
        Cookie[] cookies = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getCookies();
          if(cookies!=null)
          {
              for (int i = 0; i < cookies.length; i++) 
              {
                if (cookies[i].getName().equals("_ux") || cookies[i].getName().equals("_px") )
                {
                   cookies[i].setValue("1");
                   cookies[i].setMaxAge(0);
                   ((HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse()).addCookie(cookies[i]);
                   
                }
                  
              }
          }

     }catch(Exception exep){
         
     }
      
     
     verificarAccesoAplicacion(); 
     
     try{
         
         if (this.vAcceso.equals("NO"))
         {
             
             ExternalContext vExterna = FacesContext.getCurrentInstance().getExternalContext();
             HttpServletResponse vSrvltResponse=(HttpServletResponse)vExterna.getResponse();
             String urlRedirect;
             vSrvltResponse.sendRedirect("/"+vDominio+"/no_autorizado.jsp");
             salir(); 
             //new logout(false).salir_action();
             
         }
            
         
         
     }catch(Exception exep)
     {
         
     }
     
      
      this.getAniosTrabajoBD();
      checkIdCargaArchivo();      
      vTiempoMensajes=0;  
      vMensajesPendientes="0";
      getPaginaDocs();
    }
    
    
   /*
    * Metodo para colocar la vista para proceso aumento salarial
    */
   
   public void setAumentoSalarial(int vVista){
      vHmp_opciones.put(VISTA_PROC_AUMENTO_SAL,vVista);     
   }
   
   public int getAumentoSalarial(){
       int vistaAumento;
       try{
        // 0= nueva  aumento  1 = modif aumento
       vistaAumento = (Integer)vHmp_opciones.get(VISTA_PROC_AUMENTO_SAL);
       
       }catch(Exception eas){
        vistaAumento = 0;
       }
       return vistaAumento;
   }
   
   /*
    * Variables para las opciones de procesos de operador.
    */
   
   public void setProcesoSelOpe(oracle.jbo.domain.Number pValor){
       vHmp_opciones.put(PROCESO_SEL_OPE,pValor);  
   }
   
   public oracle.jbo.domain.Number getProcesoSelOpe(){
       oracle.jbo.domain.Number vValor;
       try{
        
       vValor = (oracle.jbo.domain.Number)vHmp_opciones.get(PROCESO_SEL_OPE);
       
       }catch(Exception eas){
        vValor= new oracle.jbo.domain.Number(0);
       }
       return vValor;
       
   }
   
   
   /*
    * Metodos para el modo de vista de la forma de la ficha del empleado
    */
    
    public void setVistaFichaEmpl(Number vValor){
        vHmp_opciones.put(VISTA_FICHAEMPLEADO,vValor);     
    }
    
    public Number getVistaFichaEmpl(){
        Number vValor;
        try{
         vValor = (Number)vHmp_opciones.get(VISTA_FICHAEMPLEADO);   
         if (vValor==null){
             vValor=0;
         }
        }catch(Exception exep){
            vValor=0;
        }
        
        return vValor;
    } 
      
    
   /*
    * Metodo para colocar el registro de empleado seleccionado en rev nombramiento
    */
   
   public void setRegEmpleadoRvNom(Number vRegEmpleado){
       vHmp_opciones.put(REG_EMPLEADO_REV_NOM,vRegEmpleado);     
   }
   
   public Number getRegEmpleadoRvNom(){
       Number reg_empleado = (Number)vHmp_opciones.get(REG_EMPLEADO_REV_NOM);   
       return reg_empleado;
   } 
    
   /*
    * Metodos para el perfil del usuario
    */
   
   public void setPerfilesEmpleadoLogin(String vPerfil){
      vHmp_opciones.put(PERFILES_USUARIO_LOGIN,vPerfil);     
   }
   
   public String getPerfilesEmpleadoLogin(){
       String vNombre;
       try{
    
       vNombre = (String)vHmp_opciones.get(PERFILES_USUARIO_LOGIN);
       
       }catch(Exception eas){
        vNombre = "";
       }
       return vNombre;
   }
   
    /*
    * Metodo para el nombre del USUARIO seleccionado
    */
    
    public void setNombreUsuarioLogueado(String vNombre){
      vHmp_opciones.put(NOMUSUARIOLOGUEADO,vNombre);     
    }
    
    public String getNombreUsuarioLogueado(){
       String vNombre;
       try{
    
       vNombre = (String)vHmp_opciones.get(NOMUSUARIOLOGUEADO);
       
       }catch(Exception eas){
        vNombre = "";
       }
       return vNombre;
    }

   /*
    * Metodo para el nombre del empleado seleccionado
    */
   
   public void setNombreEmpleadoSel(String vNombre){
      vHmp_opciones.put(NOMBREEMPLEADOSEL,vNombre);     
   }
   
   public String getNombreEmpleadoSel(){
       String vNombre;
       try{
    
       vNombre = (String)vHmp_opciones.get(NOMBREEMPLEADOSEL);
       
       }catch(Exception eas){
        vNombre = "";
       }
       return vNombre;
   }
    
    
  /*
   * Metodo para obtener los datos del empleado seleccionado
   */
  public String getDatosEmpleadoSel(){
     String vCadena="";
     oracle.jbo.domain.Number vRegActual;
     
     if (!(this.getSelRegEmpleado()==null || this.getSelRegEmpleado().equals(0))){
             vCadena="Empleado Actual: " + this.getNombreEmpleadoSel() + " - "+this.getSelRegEmpleado().toString();    
         
         vRegActual=utils.getNumberOracle(this.getSelRegEmpleado().toString());
         
         if (vRegActual.equals(0) || vRegActual.compareTo(90000000)>=0)
            vCadena="Empleado Actual: " + this.getNombreEmpleadoSel() + " - "+this.getSelCui().toString(); 
         
     }
    return vCadena;  
  }
  
  
    public void setDatosEmpleadoSel(String pValor){
       
    }
    
  
   /*
    * Metodo para verificar la opcion del menu
    */
   
   public void setCurrent_Item(String vItem){
      vHmp_opciones.put(CURRENT_ITEM_MENU,vItem);     
   }
   
   public String getCurrent_Item(){
       String CurrentItem;
       try{
    
       CurrentItem = (String)vHmp_opciones.get(CURRENT_ITEM_MENU);
       
       }catch(Exception eas){
        CurrentItem = "";
       }
       return CurrentItem;
   }
   
   
  
  
   /*
    * Metodo para verificar la solicitud seleccionada en el menu
    */
   
   public void setCurrentSol(String vSol){
      vHmp_opciones.put(CURRENTSOLICITUD,vSol);     
   }
   
   public String getCurrentSol(){
       String CurrentSol;
       try{
    
       CurrentSol = (String)vHmp_opciones.get(CURRENTSOLICITUD);
       
       }catch(Exception eas){
        CurrentSol = "";
       }
       return CurrentSol;
   }
   
   
    
   /*
    * Metodo para colocar la vista para la solicitudes
    */
   
   public void setVistaSuspIgss(int vVista){
      vHmp_opciones.put(VISTA_SUSP_IGSS,vVista);     
   }
   
   public int getVistaSuspIgss(){
       int vistaSolicitud;
       try{
        // 0= nueva susp Igss  1 = modif susp IGSS
       vistaSolicitud = (Integer)vHmp_opciones.get(VISTA_SUSP_IGSS);
       
       }catch(Exception eas){
        vistaSolicitud = 0;
       }
       return vistaSolicitud;
   }
   
    public void setVistaSuspLab(int vVista){
       vHmp_opciones.put(VISTA_SUSP_LAB,vVista);     
    }
    
    public int getVistaSuspLab(){
        int vistaSolicitud;
        try{
         // 0= nueva susp Igss  1 = modif susp IGSS
        vistaSolicitud = (Integer)vHmp_opciones.get(VISTA_SUSP_LAB);
        
        }catch(Exception eas){
         vistaSolicitud = 0;
        }
        return vistaSolicitud;
    }
    /*
     * Metodo para colocar la vista para la solicitudes, lo utiliza Rolando Anona
     */
    
    public void setVistaRetObligatorio(int vVista){
       vHmp_opciones.put(VISTA_RETIRO,vVista);     
    }
    
    public int getVistaRetObligatorio(){
        int vistaSolicitud;
        try{
         // 0= nuevo retiro  1 = Modificar retiro
        vistaSolicitud = (Integer)vHmp_opciones.get(VISTA_RETIRO);
        
        }catch(Exception eas){
         vistaSolicitud = 0;
        }
        return vistaSolicitud;
    }
  
    /*
       * Metodo para colocar la vista para fallecimiento
       */
      
      public void setVistaFallecimiento(int vVista){
         vHmp_opciones.put(VISTA_FALLECIMIENTO,vVista);     
      }
      
      public int getVistaFallecimiento(){
          int vistaSolicitud;
          try{
           // 0= ingreso de fallecimiento  1 = Modificar fallecimiento
          vistaSolicitud = (Integer)vHmp_opciones.get(VISTA_FALLECIMIENTO);
          
          }catch(Exception eas){
           vistaSolicitud = 0;
          }
          return vistaSolicitud;
      }

  
   
    /*
     * Metodo para colocar la vista para la solicitudes, lo utiliza Rolando Anona
     */
    
    public void setVistaRescision(int vVista){
       vHmp_opciones.put(VISTA_RESCISION,vVista);     
    }
    
    public int getVistaRescision(){
        int vistaSolicitud;
        try{
         // 0= nueva Rescision  1 = Modificar Rescision
        vistaSolicitud = (Integer)vHmp_opciones.get(VISTA_RESCISION);
        
        }catch(Exception eas){
         vistaSolicitud = 0;
        }
        return vistaSolicitud;
    }

  
  /*
   *  Metodos para colocar la plaza del contrato seleccionado
   */
  public void setSelContratoPlaza(int pPlaza){
      vHmp_opciones.put(SEL_CONTRATO_PLAZA,pPlaza);         
  }
  
  public int getSelContratoPlaza(){
      Integer vPlaza;
      try{
      vPlaza = (Integer)vHmp_opciones.get(SEL_CONTRATO_PLAZA);
      if (vPlaza==null)
          vPlaza = 0;
      
      }catch(Exception eas){
       vPlaza = 0;
      }
      return vPlaza;
  }
  
  /*
   * Metodos para colocar la partida del contrato seleccionado
   */
  
   public void setSelContratoPartida(String pPartida){
       vHmp_opciones.put(SEL_CONTRATO_PARTIDA,pPartida);       
       
   }
  
    public String getSelContratoPartida(){
        String vPartida;
        try{
        vPartida = (String)vHmp_opciones.get(SEL_CONTRATO_PARTIDA);
            if (vPartida==null)
                vPartida = "";
        }catch(Exception eas){
         vPartida = "";
        }
        return vPartida;
    }
    
  
    /*
     * Metodo para colocar la vista para la solicitudes
     */
    
    public void setVistaSolicitud(int vVista){
       vHmp_opciones.put(VISTA_SOLICITUD,vVista);     
    }
    
    public int getVistaSolicitud(){
        int vistaSolicitud;
        try{
         // 0= nueva  solicitud  1 = modif solicitud
        vistaSolicitud = (Integer)vHmp_opciones.get(VISTA_SOLICITUD);
        
        }catch(Exception eas){
         vistaSolicitud = 0;
        }
        return vistaSolicitud;
    }
    
    /*
     * Metodo para colocar el registro de empleado seleccionado en la nueva solicitud
     */
    
    public void setNuevaSolRegEmpleado(Number vRegEmpleado){
        vHmp_opciones.put(NUEVA_SOL_REG_EMPLEADO,vRegEmpleado);     
    }
    
    public Number getNuevaSolRegEmpleado(){
        Number reg_empleado = (Number)vHmp_opciones.get(NUEVA_SOL_REG_EMPLEADO);   
        return reg_empleado;
    }
    
   /*
    * Metodo para colocar el idContrato seleccionado en la nueva solicitud
    */
   public void setNuevaSolIdContrato(Number vIdContrato){
       vHmp_opciones.put(NUEVA_SOL_ID_CONTRATO,vIdContrato);    
   }
    
   public Number getNuevaSolIdContrato(){
       Number IdContrato = (Number)vHmp_opciones.get(NUEVA_SOL_ID_CONTRATO);   
       return IdContrato;
   }
    
 /*
  * Metodo para obtener el usuario logueado con formato
  */
   public String getUsuarioLogueado(){
      String vResultado; 
      String vRegEmpleado,vPagina;
      vRegEmpleado=getSelRegEmpleado_login();
      Object vPaginas;
      HashMap vPaginasTemp;
      
      
      vPagina=FacesContext.getCurrentInstance().getViewRoot().getViewId();  
     
     
     if (validarClave==true)
     {
         
         if (!vPagina.equals("/cambio_password.jspx")){
           try{  
           
             vPagina=FacesContext.getCurrentInstance().getExternalContext().getInitParameter("PaginaCambioClave");          
             FacesContext.getCurrentInstance().getExternalContext().redirect(vPagina);    
             
           }catch(Exception exep){
               
               
           }
             
         }
         
     }
     
     
     
      vPaginas=JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"modeloMenu.listadoPagina");  
     
      //System.out.println("pagina " + vPagina);
     
     
      if (vPaginas!=null)
      {
          vPaginasTemp=(HashMap)vPaginas;
          if (!vPaginasTemp.containsKey(vPagina))
          {
            try
            {
              if (!vPagina.startsWith("/mensajes/")){
              
                FacesContext.getCurrentInstance().getExternalContext().redirect("/Nomina/no_autorizado_opcion.jsp");      
              }
                
            }catch(Exception exep)
            {
                
            }
              
          }
          
          
      }
      
      
      
      // vPagina=FacesContext.getCurrentInstance().getViewRoot().getViewId();
      // FacesContext.getCurrentInstance().getExternalContext().getContext()
       //System.out.println("pagina " + vPagina);
      
       //FacesContext ctx = FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
       // FacesContext.getCurrentInstance().getApplication().getUserPrincipal();
      //  Principal uno;
       
       if (vRegEmpleado!=null){
             //vResultado="<b>Rol:</b> " +this.getPerfilesEmpleadoLogin()+"   <b>Usuario:</b> "+vRegEmpleado.toString()+ "<b> Nombre:</b> "+this.getNombreUsuarioLogueado();
              vResultado="<i><b>Usuario: </b></i> "+vRegEmpleado.toString()+ "<i><b> Nombre: </b></i> "+this.getNombreUsuarioLogueado();
       }else {
             vResultado="Usuario: <b> No logueado </b>";
       }
       
     return vResultado;  
   }
    
/*
 * Metodo para eliminar el prefijo del usuario logueado
 */

   public String getUsuarioSinPrefijo(String pUsuarioOrig){
       String vUsuarioMod;
       if (pUsuarioOrig.startsWith(this.vPrefUsuario)){
           vUsuarioMod=pUsuarioOrig.substring(vPrefUsuario.length(),pUsuarioOrig.length()); 
       }else{
           vUsuarioMod=pUsuarioOrig.trim();
       }
       
     return vUsuarioMod;  
   }
    
/*
 * Metodo para obtener el registro del empleado que se ha logueado
 */
    public String getSelRegEmpleado_login(){
        String reg_empleado = (String)vHmp_opciones.get(REG_EMPLEADO_LOGIN);
        String vusuario;
        String Vusuario2;
            
        Vusuario2=FacesContext.getCurrentInstance().getExternalContext().getRemoteUser().toString().trim();
        Vusuario2=getUsuarioSinPrefijo(Vusuario2);
        
        if (reg_empleado!=null&&!Vusuario2.equals(reg_empleado)){
            try{
            ((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false)).invalidate();
            FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getInitParameter("PaginaInicio")); 
            }catch(Exception exep){
                exep.printStackTrace();
            }
        
        }
        
     //   System.out.println("debug ususario" + FacesContext.getCurrentInstance().getExternalContext().getRemoteUser());
        try{
                if (reg_empleado == null) {
                    FacesContext ctx = FacesContext.getCurrentInstance();
                    ExternalContext ectx = ctx.getExternalContext();
                    vusuario = ectx.getRemoteUser();
                    
                    
                    if (vusuario == null || vusuario.length()==0) {
                              //  vusuario = "No autenticado";
                                reg_empleado = "";
                      }else {                     
                         reg_empleado=getUsuarioSinPrefijo(vusuario);
                         vHmp_opciones.put(REG_EMPLEADO_LOGIN,reg_empleado);
                      }
                
                  //reg_empleado = 20080264;
                }
        }catch(Exception excep){
            reg_empleado="";
        }
        return reg_empleado;
    }

/*  METODOS PARA OBTENER Y COLOCAR EL REGISTRO DE
  * EMPLEADO SELECCIONADO EN LA LA PAGINA list_empleado.jspx PARA MOSTRAR
  * EL DETALLE DE LA INFORMACION */
  
    public Number getSelRegEmpleado(){
        Number reg_empleado = (Number)vHmp_opciones.get(SEL_REGEMPLEADO);
        if (reg_empleado == null) {
          reg_empleado = 0;
        }
        return reg_empleado;
    }
    
   public void setSelRegEmpleado(Number reg_empleado){
       vHmp_opciones.put(SEL_REGEMPLEADO,reg_empleado); 
   }
   
    /*  METODOS PARA OBTENER Y COLOCAR EL CUI
      * SELECCIONADO EN LA LA PAGINA list_empleado.jspx 
      * PARA HACER CONTRATOS 029 */
      
        public Number getSelCui(){
            Number cui = (Number)vHmp_opciones.get(SEL_CUI);
            if (cui == null) {
              cui = 0;
            }
            return cui;
        }
        
       public void setSelCui(Number cui){
           vHmp_opciones.put(SEL_CUI,cui); 
       }

    /*  METODOS PARA OBTENER Y COLOCAR EL DEPTO SELECCIONADO Y ORDEN SELECCIONADO
      * EN LA PAGINA empleado.jspx PARA MOSTRAR
      * EL DETALLE DE LOS COMBOS ASOCIADOS */
   
    public void setSelDepto(String sel_depto){
        vHmp_opciones.put(SEL_DEPTO,sel_depto); 
    }
    
    public void setSelOrden(String sel_orden){
        vHmp_opciones.put(SEL_ORDEN,sel_orden); 
    }
    
    public String getSelDepto(){
        String sel_depto = (String)vHmp_opciones.get(SEL_DEPTO);
        if (sel_depto == null) {
          sel_depto = "XXXX";
        }
        return sel_depto;
    }
    
    public String getSelOrden(){
        String sel_orden = (String)vHmp_opciones.get(SEL_ORDEN);
        if (sel_orden == null) {
          sel_orden = "00";
        }
        return sel_orden;
    }
    
 /*
  * Metodos para obtener y colocar el numero de contrato.
  */
 public void setSelContrato(Number numContrato){
     vHmp_opciones.put(SEL_CONTRATO,numContrato); 
 }
    
 public Number getSelContrato(){
     Number numContrato = (Number)vHmp_opciones.get(SEL_CONTRATO);
     if (numContrato == null) {
       numContrato = 0;
     }
     return numContrato;
 }
 
 /*
  *  Metodos para obtener y colocar el modo de vista del contrato
  */
public void setVistaContrato(int intVista){
        vHmp_opciones.put(VISTA_CONTRATO,intVista); 
    }
       
public int getVistaContrato(){
        int vistaContrato ;
     try{
        vistaContrato = (Integer)vHmp_opciones.get(VISTA_CONTRATO);
        if (vistaContrato == 0) {
          vistaContrato = 0;  // 0= nuevo contrato  1 = modif contrato
        }
     }catch(Exception eas){
         vistaContrato = 0;
     }
        return vistaContrato;
    }

    /*
     *  Metodos para obtener y colocar el modo de vista de la orden judicial
     */
    public void setVistaOrdenJudicial(int intVistaOrden){
           vHmp_opciones.put(VISTA_ORDEN_JUDICIAL,intVistaOrden); 
       }
          
    public int getVistaOrdenJudicial(){
           int vistaOrdenJudi ;
        try{
          vistaOrdenJudi = (Integer)vHmp_opciones.get(VISTA_ORDEN_JUDICIAL);
           if (vistaOrdenJudi == 0) {
             vistaOrdenJudi = 0;  // 0= nuevo contrato  1 = modif contrato
           }
        }catch(Exception eas){
            vistaOrdenJudi = 0;
        }
           return vistaOrdenJudi;
       }

    /*
     *  Metodos para obtener y colocar el modo de VISTA_RENUNCIA_PARCIAL
     */
    public void setVistaRenunciaParcial(int intRenunciaParcial){
           vHmp_opciones.put(VISTA_RENUNCIA_PARCIAL,intRenunciaParcial); 
       }
          
    public int getVistaRenunciaParcial(){
           int vistaRenunciaParcial;
        try{
          vistaRenunciaParcial = (Integer)vHmp_opciones.get(VISTA_RENUNCIA_PARCIAL);
           if (vistaRenunciaParcial == 0) {
             vistaRenunciaParcial = 0;  // 0= nuevo contrato  1 = modif contrato
           }
        }catch(Exception eas){
            vistaRenunciaParcial = 0;
        }
           return vistaRenunciaParcial;
       }



/*
 *  Metodos para obtener si se ha seleccionado un empleado en la busqueda
 */
 public void setIsSelEmpleado(int vIsSel){
        vHmp_opciones.put(EMPLSEL,vIsSel); 
 }
               
 public int getIsSelEmpleado(){
         int IsSelEmpleado;
             try{
                 // 0= Ninguno Seleccionado  1 = Seleccionado
                IsSelEmpleado = (Integer)vHmp_opciones.get(EMPLSEL);
        
             }catch(Exception eas){
                 IsSelEmpleado = 0;
                 //System.out.println("excep");
             }
  return IsSelEmpleado;
}

/*
 *  Metodos para obtener el modo de visualizacion para la opcion de empleado
 */
 
public void setVistaEmpleado(int intVista){
            vHmp_opciones.put(VISTA_EMPLEADO,intVista); 
        }
           
 public int getVistaEmpleado(){
            int vistaEmpleado ;
         try{
             // 0= nuevo empleado  1 = modif empleado
            vistaEmpleado = (Integer)vHmp_opciones.get(VISTA_EMPLEADO);
    
         }catch(Exception eas){
             vistaEmpleado = 0;
             //System.out.println("excep");
         }
            return vistaEmpleado;
        }
 
    /*
   public static void setSelRegEmpleado_bean(Number reg_empleado){
       FacesContext ctx = FacesContext.getCurrentInstance();
       JSFUtils.setManagedBeanValue(ctx,"flujo_usuario.selRegEmpleado",reg_empleado);
       
   }
*/    
    /*
     * Metodo para cambiar el valor de una variable en Bean desde codigo* 
     */
   public static void set_opciones(int pInt_opcion,Object pValue){
        FacesContext ctx = FacesContext.getCurrentInstance();
        
        switch(pInt_opcion){
            case SEL_REGEMPLEADO:
            JSFUtils.setManagedBeanValue(ctx,"flujo_usuario.selRegEmpleado",(Number)pValue);  
            break;
            case SEL_CUI:
            JSFUtils.setManagedBeanValue(ctx,"flujo_usuario.selCui",(Number)pValue);  
            break;
            case SEL_DEPTO:
            JSFUtils.setManagedBeanValue(ctx,"flujo_usuario.selDepto",(String)pValue);  
            break;
            case SEL_ORDEN:
            JSFUtils.setManagedBeanValue(ctx,"flujo_usuario.selOrden",(String)pValue);  
            break;
            case SEL_CONTRATO:
            JSFUtils.setManagedBeanValue(ctx,"flujo_usuario.selContrato",(Number)pValue);  
            break;
            case VISTA_CONTRATO:
            JSFUtils.setManagedBeanValue(ctx,"flujo_usuario.vistaContrato",(Integer)pValue);  
            break;
            case VISTA_EMPLEADO:
            JSFUtils.setManagedBeanValue(ctx,"flujo_usuario.vistaEmpleado",(Integer)pValue);  
            break;
            case NUEVA_SOL_ID_CONTRATO:
            JSFUtils.setManagedBeanValue(ctx,"flujo_usuario.nuevaSolIdContrato",(Number)pValue);  
            break;
            case NUEVA_SOL_REG_EMPLEADO:
            JSFUtils.setManagedBeanValue(ctx,"flujo_usuario.nuevaSolRegEmpleado",(Number)pValue);  
            break;
            case  VISTA_SOLICITUD:
            JSFUtils.setManagedBeanValue(ctx,"flujo_usuario.vistaSolicitud",(Number)pValue);  
            break;
            case EMPLSEL:
            JSFUtils.setManagedBeanValue(ctx,"flujo_usuario.isSelEmpleado",(Integer)pValue);  
            break;
            case SEL_CONTRATO_PARTIDA:
            JSFUtils.setManagedBeanValue(ctx,"flujo_usuario.selContratoPartida",(String)pValue);  
            break;
            case SEL_CONTRATO_PLAZA:
            JSFUtils.setManagedBeanValue(ctx,"flujo_usuario.selContratoPlaza",(Integer)pValue);  
            break;
            case  VISTA_ORDEN_JUDICIAL:
            JSFUtils.setManagedBeanValue(ctx,"flujo_usuario.vistaOrdenJudicial",(Number)pValue);  
            break;
            case  VISTA_RENUNCIA_PARCIAL: 
            JSFUtils.setManagedBeanValue(ctx,"flujo_usuario.vistaRenunciaParcial",(Number)pValue);  
            break;
            case VISTA_SUSP_IGSS:
            JSFUtils.setManagedBeanValue(ctx,"flujo_usuario.vistaSuspIgss",(Number)pValue);          
            break;
            case VISTA_SUSP_LAB:
            JSFUtils.setManagedBeanValue(ctx,"flujo_usuario.vistaSuspLab",(Number)pValue);          
            break;
            case VISTA_RETIRO:
            JSFUtils.setManagedBeanValue(ctx,"flujo_usuario.vistaRetObligatorio",(Number)pValue);          
            break;
            case VISTA_FALLECIMIENTO:
            JSFUtils.setManagedBeanValue(ctx,"flujo_usuario.vistaFallecimiento",(Number)pValue);          
            break;
            case VISTA_RESCISION:
            JSFUtils.setManagedBeanValue(ctx,"flujo_usuario.vistaRescision",(Number)pValue);          
            break;
            case CURRENTSOLICITUD:
            JSFUtils.setManagedBeanValue(ctx,"flujo_usuario.currentSol",(String)pValue);          
            break;
            case CURRENT_ITEM_MENU:
            JSFUtils.setManagedBeanValue(ctx,"flujo_usuario.current_Item",(String)pValue);          
            break;
            case NOMBREEMPLEADOSEL:
            JSFUtils.setManagedBeanValue(ctx,"flujo_usuario.nombreEmpleadoSel",(String)pValue);          
            break;
            case PERFILES_USUARIO_LOGIN:
            JSFUtils.setManagedBeanValue(ctx,"flujo_usuario.perfilesEmpleadoLogin",(String)pValue);          
            break;
            case REG_EMPLEADO_REV_NOM:
            JSFUtils.setManagedBeanValue(ctx,"flujo_usuario.regEmpleadoRvNom",(Number)pValue);          
            break;
            case VISTA_PROC_AUMENTO_SAL:
            JSFUtils.setManagedBeanValue(ctx,"flujo_usuario.aumentoSalarial",(Integer)pValue);          
            break;
            case VISTA_OPERACION:
            JSFUtils.setManagedBeanValue(ctx,"flujo_usuario.operacion",(Integer)pValue);  
            break;
            case NOMUSUARIOLOGUEADO:
            JSFUtils.setManagedBeanValue(ctx,"flujo_usuario.nombreUsuarioLogueado",(String)pValue);  
            break;
            case VISTA_FICHAEMPLEADO:
            JSFUtils.setManagedBeanValue(ctx,"flujo_usuario.vistaFichaEmpl",(Number)pValue);  
            break;
            case VISTA_AUXILIAR:
            JSFUtils.setManagedBeanValue(ctx,"flujo_usuario.auxiliar",(Integer)pValue);  
            break;
            case LOGUOUT:
            JSFUtils.getManagedBeanValue(ctx,"flujo_usuario.logOut");  
            break;
            case ESTADO_EMPLEADO:
            JSFUtils.setManagedBeanValue(ctx,"flujo_usuario.estadoEmpleado",(String)pValue);  
            break;
            
        }
                     
    }
/*
    public void setInpt_hidden_creado_por(CoreInputHidden inpt_hidden_creado_por) {
        this.inpt_hidden_creado_por = inpt_hidden_creado_por;
    }

    public CoreInputHidden getInpt_hidden_creado_por() {
        return inpt_hidden_creado_por;
    }
    */
    
    // metodo utilizado para colocar la operacion que se utilizara 
    // 0 = nuevo 1 = modificar
     public void setOperacion(int ValOperacion){
        vHmp_opciones.put(VISTA_OPERACION,ValOperacion);     
     }
     
     public int getOperacion(){
         int vistaOperacion;
        try{
            vistaOperacion = (Integer)vHmp_opciones.get(VISTA_OPERACION);
            //   System.out.println("estoy en el getOperacion  " + vistaOperacion);
        }
        catch(NullPointerException e) {
            vistaOperacion = 0;
        }
        return vistaOperacion;
     }

   public boolean isUsuarioLogueadoNumber(){      
    return utils.isNumber(this.getSelRegEmpleado_login());   
   }
//metodo utilizado para ingresar un valor a la variable auxiliar}
// auxiliar = 0 la variable no ha sido utilizada.
    public void setAuxiliar(int ValAuxiliar){
       vHmp_opciones.put(VISTA_AUXILIAR,ValAuxiliar);     
    }
    
    public int getAuxiliar(){
        int vistaAuxiliar;
       try{
           vistaAuxiliar = (Integer)vHmp_opciones.get(VISTA_AUXILIAR);
           //   System.out.println("estoy en el getauxiliar " + vistaAuxiliar);
       }
       catch(NullPointerException e) {
           vistaAuxiliar = 0;
           System.out.println("estoy en el catch  getauxiliar " + vistaAuxiliar);
       }
       return vistaAuxiliar;
    }
 
    public String getDominioApp(){
        return this.vDominio;
    }
    
       
    public String getAnioActual(){
       String vAnioActual;
       
       try{
           
          vAnioActual= (String)vHmp_opciones.get(ANIOTRABAJO);
          
          if (vAnioActual==null || (vAnioActual!=null && vAnioActual.equals(""))){
              vAnioActual=utils.getAnioActual(); 
              vHmp_opciones.put(ANIOTRABAJO,vAnioActual);
          }
           
       }catch(Exception exep){
           vAnioActual=utils.getAnioActual(); 
           vHmp_opciones.put(ANIOTRABAJO,vAnioActual);
          
       }
      return vAnioActual;      
    }
    
    public void setAnioActual(String pAnio){
        vHmp_opciones.put(ANIOTRABAJO,pAnio);
    }
    
    
    public boolean getIsAnioActual(){
        
       if (this.getAnioActual().equals(utils.getAnioActual())){
          return true; 
       }
     return false;  
    }
    
 
   public void setValidarPassword(boolean pValor){
       
       this.validarClave=pValor;
       
   }
 
 
/*
 * Metodo para obtener los permisos del usuario segun la aplicacion
*/
 public void verificarAccesoAplicacion(){
    interfaz_DB vCone=new interfaz_DB();
    String sqlString;
    ResultSet vFilas;
    Object vResulCon;
    sqlString="select distinct aplicacion, acceso \n" + 
        "from usuario_modulo_siif where aplicacion in ('SIS') \n" + 
        "and modulo is null and tipo_usuario='TRABAJADOR' \n" + 
        "and usuario='"+this.getSelRegEmpleado_login()+"'";
    vAcceso="";
    try {
        vFilas=vCone.Bol_ejecutar_sentencia(sqlString);
        if (vFilas !=null && vFilas.next()) { //No hubo error y hay filas
            if (vFilas.getString(2).equals("1")) {
                vAcceso="SI";
            } else {
                vAcceso="NO";
            }
        } else { //Hubo error o no hay filas
            vResulCon = vCone.getValorConsultaSimple("conteo","select count(0) as conteo from usuario_perfil where usuario='" + this.getSelRegEmpleado_login() + "' and tipo_usuario='TRABAJADOR' and perfil='trabajador_usac'");
            if (vResulCon!=null && vResulCon.toString().equals("1")) {
                vAcceso="SI"; //tiene perfil trabajador_usac puede entrar al siif                  
            } else {
                vAcceso="NO";
            }
        }
    } catch(Exception ex){
        System.out.println(ex.getMessage());
        ex.printStackTrace();
    } finally {
        vCone.cn_Cerrar_coneccion();   
    }  
} 
 
public void salir2() 
{
               
    HttpServletResponse response=null;
    ExternalContext ectx = FacesContext.getCurrentInstance().getExternalContext();
        
    // System.out.println("debug sesion " +FacesContext.getCurrentInstance().getExternalContext().getRequestCookieMap());
    
    try{
       response = (HttpServletResponse)ectx.getResponse();
                       
        if (ectx.getAuthType()!=null && ectx.getAuthType().equals("FORM")){
             HttpSession session = (HttpSession)ectx.getSession(false);
             response.sendRedirect(ectx.getInitParameter("PaginaInicio"));
             session.invalidate();  
             FacesContext.getCurrentInstance().responseComplete();
             //System.out.println("debug sesion  salida");
         }else{
            HttpSession session = (HttpSession)ectx.getSession(false);
            JSSOUtil.logout(response,ectx.getInitParameter("PaginaInicio"));
            session.invalidate();  
            FacesContext.getCurrentInstance().responseComplete();
           // response.sendRedirect(ectx.getInitParameter("PaginaInicio"));
           // response.sendRedirect(ectx.getInitParameter("PaginaSalida")+"?url="+ectx.getInitParameter("PaginaInicio"));     
        }
       
    }catch(Exception exep) {
        exep.printStackTrace();
        try{
        response.sendRedirect(ectx.getInitParameter("PaginaInicio"));
        
        }catch(Exception exep2){
            exep2.printStackTrace();
        }
    }
  
}

    public void salir() 
    {
                   
    HttpServletResponse response=null;
    ExternalContext ectx = FacesContext.getCurrentInstance().getExternalContext();
    //System.out.println("saliendo ");
              
       try{
          response = (HttpServletResponse)ectx.getResponse();
                                 
           if (ectx.getAuthType()!=null && ectx.getAuthType().equals("FORM")){
                  HttpSession session = (HttpSession)ectx.getSession(false);
                  //response.sendRedirect(ectx.getInitParameter("PaginaInicio"));
                  session.invalidate();  
                  FacesContext.getCurrentInstance().responseComplete();
                       //System.out.println("debug sesion  salida");
            }else{
                  HttpSession session = (HttpSession)ectx.getSession(false);
               //   JSSOUtil.logout(response,ectx.getInitParameter("PaginaInicio"));
                   session.invalidate();  
                  FacesContext.getCurrentInstance().responseComplete();
                     // response.sendRedirect(ectx.getInitParameter("PaginaInicio"));
                     // response.sendRedirect(ectx.getInitParameter("PaginaSalida")+"?url="+ectx.getInitParameter("PaginaInicio"));     
             }
                 
              }catch(Exception exep) 
              {
                 exep.printStackTrace();
                  try{
                  response.sendRedirect(ectx.getInitParameter("PaginaInicio"));
                  
                  }catch(Exception exep2){
                      exep2.printStackTrace();
                  }
              }         

    }

public void setEstadoEmpleado(String vNombre){
       vHmp_opciones.put(ESTADO_EMPLEADO,vNombre);     
}
    
public String getEstadoEmpleado(){
        String vNombre;
        try{
     
        vNombre = (String)vHmp_opciones.get(ESTADO_EMPLEADO);
        
        }catch(Exception eas){
         vNombre = "";
        }
        return vNombre;
 }



public boolean getCensoReset()
{
   String vQuerry,vRegistros[],vUsuarioLogueado;
   Boolean vReset=null;
   Object vResultado;
   interfaz_DB vCone=new interfaz_DB();
   try{
        // 0= nueva  aumento  1 = modif aumento
    vReset = (Boolean)vHmp_opciones.get(CENSO_LABORAL_RESET);
        
     if (vReset==null) {
            throw new Exception();
      }
        
     }catch(Exception eas){
        
         vQuerry="select valor_cadena from sis_parametros_aplicacion where nom_parametro='CENSO_TRABAJADOR_RESET'";
         vResultado=vCone.getValorConsultaSimple("valor_cadena",vQuerry);
         vCone.cn_Cerrar_coneccion();          
         vResultado=(vResultado==null?"":vResultado.toString());
         
         if (vResultado.toString().length()>1){
             vRegistros=vResultado.toString().split("\\|");
             vUsuarioLogueado=getSelRegEmpleado_login();
             
             for (int vCont=0;vCont<vRegistros.length;vCont++)
             {
                if (vRegistros[vCont].equals(vUsuarioLogueado)){
                    vHmp_opciones.put(CENSO_LABORAL_RESET,true); 
                    vReset=true;
                    break;
                }
                 
             }
             
            if (vReset==null){
                vHmp_opciones.put(CENSO_LABORAL_RESET,false);  
                vReset=false;
            }
         }else {
                vReset=false;
                vHmp_opciones.put(CENSO_LABORAL_RESET,false);  
         }
         
        }
    return vReset;
        
}


    public void setCensoReset(boolean vValor){
    
           vHmp_opciones.put(CENSO_LABORAL_RESET,vValor);     
    }

 
public void setCensoLaboralVista(Number vValor)
{

vHmp_opciones.put(CENSO_LABORAL_VISTA,vValor);     

}
        
public Number getCensoLaboralVista()
{
  Number vVista;
  try{
         
    vVista = (Number)vHmp_opciones.get(CENSO_LABORAL_VISTA);
     if (vVista==null)
     {
         
        vVista=0;
        
     }         
         
     }
     catch(Exception eas){
     
     vVista = 0;
     
   }
return vVista;
}


public String getAniosTrabajo(){
    
 return this.vListadoAniosTrabajo;
 
}

public String getAnioformato(){
    
    return "[Año "+this.getAnioActual()+"]";
}


public void checkIdCargaArchivo()
{
        String vQuerry;
        Object vResultado;
        interfaz_DB vCone=new interfaz_DB();

        
            vQuerry="select id_origen_carga_archivo\n" + 
            "from sis_usuarios_externos_conf\n" + 
            "where tipo_usuario='TRABAJADOR'\n" + 
            "and usuario='" + getSelRegEmpleado_login()+"'"+" \n"+
            "and activo=1";                        
            
            vResultado=vCone.getValorConsultaSimple("id_origen_carga_archivo",vQuerry);            
            vCone.cn_Cerrar_coneccion();          
    
            if (vResultado!=null){
                
                vIdCargaArchivo=vResultado.toString();  
            }                    

}

public String getIdCargaArchivo(){
    return vIdCargaArchivo;
}

 
public String getMesActual(){ 
return utils.getMesActual();    
} 
     

public String getMensajesNuevos(){
    
    String vQuerry;
    Object vResultado;
    interfaz_DB vCone=new interfaz_DB();

     if (System.currentTimeMillis()-vTiempoMensajes>57200)
     {
        vQuerry="SELECT count(0) as mensajes\n" + 
        "FROM SIS_MENSAJE_ENTRANTE\n" + 
        "WHERE "+
        " usuario='" + getSelRegEmpleado_login()+"'"+" "+
        " AND ESTADO='0'";
    
        vResultado=vCone.getValorConsultaSimple("mensajes",vQuerry);            
        vCone.cn_Cerrar_coneccion();          
        vTiempoMensajes=System.currentTimeMillis();
        //System.out.println("consulta Mensajes "+ vTiempoMensajes);
    
        if (vResultado!=null){
            
            vMensajesPendientes=vResultado.toString();  
        }else{
            vMensajesPendientes="0";
        }
     }   
        
 return vMensajesPendientes;   
}


public void setMensajesNuevos(String pMessg){
    vMensajesPendientes=pMessg;
    vTiempoMensajes=0;    
}

public String getMsgHabilitado(){
    String vQuerry;
    Object vResultado;
    interfaz_DB vCone=new interfaz_DB();

    if (vMensajesHabil==null)
    {
       vQuerry="select \n" + 
        "count(0) as mensajes \n" + 
        "from\n" + 
        "usuario_perfil usrf, permiso_menu pme\n" + 
        "where usrf.usuario='" + getSelRegEmpleado_login()+"'"+" "+
        "and usrf.tipo_usuario='TRABAJADOR'\n" + 
        "and activo='1'\n" + 
        "and pme.perfil=usrf.perfil\n" + 
        "and aplicacion='SIS'\n" + 
        "and id_opcion_menu=55\n";
    
        vResultado=vCone.getValorConsultaSimple("mensajes",vQuerry);            
        vCone.cn_Cerrar_coneccion();                 
        //System.out.println("consulta Mensajes "+ vTiempoMensajes);
    
        if (vResultado!=null){            
            vMensajesHabil=vResultado.toString();  
            if (!vMensajesHabil.equals("0")){
                vMensajesHabil="1";
            }
            
        }else{
            vMensajesHabil="0";
        }
     }
    return vMensajesHabil;
    
}

    public void setReplyMensaje(String vIdReplyMensaje) {
        this.vIdReplyMensaje = vIdReplyMensaje;
    }

    public String getReplyMensaje() {
        return vIdReplyMensaje;
    }

    public void setDestinatario(String vDestinatario) {
        this.vDestinatario = vDestinatario;
    }

    public String getDestinatario() {
        return vDestinatario;
    }

    public void setAsunto(String vAsunto) {
        this.vAsunto = vAsunto;
    }

    public String getAsunto() {
        return vAsunto;
    }
    
    public String getAnioActualReal(){
        
      return utils.getAnioActual();  
    }

    public void setIdBitacora(String vIdBitacora) {
        this.vIdBitacora = vIdBitacora;
    }

    public String getIdBitacora() {
        return vIdBitacora;
    }
    
    /*
       * Metodo para colocar la vista para fallecimiento
       */
      
      public void setVistaLiquidacion(int vVista){
         vHmp_opciones.put(VISTA_LIQUIDACION,vVista);     
      }
      
public int getVistaLiquidacion()
{
          int vistaSolicitud;
          try{
           // 0= ingreso de fallecimiento  1 = Modificar fallecimiento
          vistaSolicitud = (Integer)vHmp_opciones.get(VISTA_LIQUIDACION);
          
          }catch(Exception eas){
           vistaSolicitud = 0;
          }
          return vistaSolicitud;
}
 
public String getUsuarioMD5(){    
    return ecrip.encriptarMD5(this.getSelRegEmpleado_login());
}
 
 
 
 public void getPaginaDocs()
 {
    String vQuerry;
    Object vResultado;
    interfaz_DB vCone=new interfaz_DB();

        
      vQuerry="select valor_cadena\n" + 
       "from sis_parametros_aplicacion\n" + 
       "where nom_parametro='PAGINA_DOC_NOMINA'";                        
      vResultado=vCone.getValorConsultaSimple("valor_cadena",vQuerry);
            
       vCone.cn_Cerrar_coneccion();          
       vPaginaDocs=(vResultado==null?"":vResultado.toString());
  

}

    public void setPaginaDoc(String vPaginaDocs) {
        this.vPaginaDocs = vPaginaDocs;
    }

    public String getPaginaDoc() {
        return vPaginaDocs;
    }
    
    public boolean isPlanPresta(){
       boolean vResultado=false; 
        
       if (this.getSelRegEmpleado_login().equals("PLANPRESTA") ) 
       {
           
           vResultado=true;
           
       }
     return vResultado;   
    }

 public String getCreaCorreo()
 {
       String vQuerry;
       Object vResultado;
       interfaz_DB vCone;

        if (vCrearCorreo==null)
        {
         
         vCone=new interfaz_DB();  
         vQuerry="select valor_numerico\n" + 
          "from sis_parametros_aplicacion\n" + 
          "where nom_parametro='CREA_CORREO'";       
          
          vResultado=vCone.getValorConsultaSimple("valor_numerico",vQuerry);
               
          vCone.cn_Cerrar_coneccion();          
          vCrearCorreo=(vResultado==null?"0":vResultado.toString());
          
        }
        
    return vCrearCorreo;
 }


}
