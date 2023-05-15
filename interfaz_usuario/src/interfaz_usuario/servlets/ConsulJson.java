package interfaz_usuario.servlets;

//import enlace_datos.util.utils;

import interfaz_usuario.util.generar_reporte;
import interfaz_usuario.util.util_zip;
import interfaz_usuario.util.utils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.*;
import javax.servlet.http.*;

import javax.xml.soap.SOAPElement;

import pkg_util_base_datos.interfaz_DB;

public class ConsulJson extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=windows-1252";
    private String vUsuario;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }



    public void doGet(HttpServletRequest request, 
                      HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();     
        String vCadena="",vPara,vNumCuenta,vCedula,vDPI;
        vPara=request.getParameter("codop");           
        String vStr_directorioRep, vStr_dirReporteTexto;
        
        vStr_directorioRep=request.getSession().getServletContext().getInitParameter("DIRECTORIO_REPORTES");
        vStr_dirReporteTexto = request.getSession().getServletContext().getInitParameter("DIRECTORIOREPORTESTEXTO");
        
        funcionEliminarCarpeta1 (new File (vStr_dirReporteTexto+'\\'), vStr_dirReporteTexto);
        
        vUsuario=utils.getUsuarioSinPrefijo(request.getRemoteUser());
        if (vPara!=null && vPara.equals("1")) { // consulta de firmas
            vCadena=getFirmas(utils.getInteger(request.getParameter("var1")).toString());
        } else if (vPara!=null && vPara.equals("2")) { //Para cambiar estado a una registro
            vCadena=getEstadosAutorizacion(request.getParameter("var1"),request.getParameter("var2"),request.getParameter("var3"));
        } else if (vPara!=null && vPara.equals("3")) {
           vCadena=getPendRegPer();
        } else if (vPara!=null && vPara.equals("4")){ // verficar numero cuenta empleado
          vNumCuenta=request.getParameter("var1");
          vNumCuenta=(vNumCuenta==null?"":vNumCuenta.trim());  
          vCedula=request.getParameter("var2");
          vCedula=(vCedula==null?"":vCedula.trim().replace(",",""));  
          vDPI=request.getParameter("var3");
          vDPI=(vDPI==null?"":vDPI.trim());  
          vCadena=VerificaNumCuenta(vNumCuenta,vCedula,vDPI,1);
        } else if (vPara!=null && vPara.equals("5")){ // verificar usuarios 
            vCadena=getUsuariosxNombre(request.getParameter("term")==null?"":request.getParameter("term"));
        } else if(vPara!=null && vPara.equals("6")){ // verifica que el complemento a trasladar lleve descuentos igss
            String vComplemento=request.getParameter("var1");
            vCadena = getValidacionDescIGSS(vComplemento);
        } else if(vPara!=null && vPara.equals("7")){
            //vCadena = this.getRemesasCompl(request.getParameter("var1"));
            vCadena = this.getRemesasCompl_Txt(request.getParameter("var1"),vStr_directorioRep, vStr_dirReporteTexto,request.getParameter("var2"));
            
        } else if(vPara!=null && vPara.equals("8")){ //verifica si hay empleados que tienen bono mensual mayor al establecido
            //vCadena = this.getValidaBonoProcNomina(request.getParameter("var1"));
        } else if(vPara!=null && vPara.equals("9")){ //realiza validaciones para que no hayan exceso en los montos
            vCadena = this.getValidaNomina(request.getParameter("var1"),request.getParameter("var3"),request.getParameter("var2"));
        } else if(vPara!=null && vPara.equals("10")){
            vCadena = this.getValidacionReintegro(request.getParameter("var1"));
        } else if(vPara!=null && vPara.equals("11")){
            vCadena = this.getRemesasCompl_Todo(request.getParameter("var1"),vStr_directorioRep, vStr_dirReporteTexto,request.getParameter("var2"));
        } else if(vPara!=null && vPara.equals("12")){
           
            vCadena = this.getRemesasCompl_EliminarArch(request.getParameter("var1"),vStr_directorioRep, vStr_dirReporteTexto, response);
        } else if(vPara!=null && vPara.equals("13")){
            vCadena = this.getRemesasCompl(request.getParameter("var1"));
            
        }
        out.println(vCadena);        
        out.flush();
        out.close();
    }

    //Función que obtiene el estado actual de la fila a operar
    private String getEstadosAutorizacion(String pTipo,String pTipoAuto,String pId){
        String vConsulta="";
        interfaz_DB datos;
        datos=new interfaz_DB();
        ResultSet vFilas;
        String vResultado;
        Object pEstadoActual;
        String columnaEstado="id_estado";
        if (pTipoAuto.equals("8")){
            vConsulta="select id_estado from sis_variacion_nomina where id_variacion_nomina=?";
        } else if (pTipoAuto.equals("12")){
            vConsulta="select id_estado from sis_complemento where id_complemento=?";
        } else if(pTipoAuto.equals("20")){
            vConsulta="select id_estado from sis_reintegro where id_reintegro=?";
        } else if(pTipoAuto.equals("19")){
            vConsulta="select estado from sis_liquidacion where id_liquidacion=?";
            columnaEstado="estado";
        } else if(pTipoAuto.equals("22")){
            vConsulta="select id_estado from sis_contrato031 where id_contrato=?";
            columnaEstado="id_estado";
        } else if(pTipoAuto.equals("23")){
            vConsulta="select id_estado from sis_isrproy_031 where id_isr=?";
            columnaEstado="id_estado";
        } else if(pTipoAuto.equals("25") || pTipoAuto.equals("27")){
            vConsulta="select id_estado from sis_indemnizacion where id_indemnizacion=?";
            columnaEstado="id_estado";
        }
        datos.Crear_sentencia(vConsulta);
        datos.setParametrosSentencia(1,"Int",pId);
        pEstadoActual=datos.getValorConsulta(columnaEstado);
        
        vConsulta="select distinct id_estado_origen,id_estado_destino,z.nombre as nombreEstadoDestino\n" + 
        "from sis_secuencia_estados x, usuario_perfil y, sis_estado z\n" + 
        "where x.perfil=y.perfil\n" + 
        "and y.usuario=?\n" + 
        "and z.id_estado=id_estado_destino\n" + 
        "and z.tipo=? \n" + 
        "and id_estado_origen=?\n" + 
        "and exists(\n" + 
        "    select 1\n" + 
        "    from sis_parametrizacion_auth a, sis_tipo_auth b\n" + 
        "    where a.id_tipo_auth=b.id_tipo_auth\n" + 
        "    and b.id_tipo_auth=?\n" + 
        "    AND a.fecha_baja is null\n" + 
        "    and x.id_param_auth=a.id_param_auth\n" + 
        "          )\n";
        //System.out.println("El usuario es: [" + vUsuario + "]");
        //System.out.println("El pTipo es: [" + pTipo + "]");
        //System.out.println("El estado Actual es: [" + pEstadoActual + "]");
        //System.out.println("El pTipoAuto (Tipo Autorización) es: [" + pTipoAuto + "]");
        //System.out.println("La consulta es: [" + vConsulta + "]");
        datos.Crear_sentencia(vConsulta);
        datos.setParametrosSentencia(1,"String",vUsuario);
        datos.setParametrosSentencia(2,"Int",pTipo);
        datos.setParametrosSentencia(3,"Int",pEstadoActual);
        datos.setParametrosSentencia(4,"Int",pTipoAuto);
        try{ 
            vFilas=datos.Bol_ejecutar_sentencia();
            vResultado="[";
            while (vFilas.next()) {            
                vResultado=vResultado+"{\"id\":\""+(vFilas.getString("id_estado_destino"))+"\",\"nom\":\""+vFilas.getString("nombreestadodestino")+"\"},";         
            }
            //datos.cn_Cerrar_coneccion();
            if (vResultado.length()>1) {
                vResultado=vResultado.substring(0,vResultado.length()-1)+"]";             
            } else {
                vResultado+="]";
            }
        } catch(Exception exep1) {
            vResultado="[]";
        } finally {
            datos.cn_Cerrar_coneccion();
        }
        //vResultado="[{\"id\":\"1\",\"nom\":\"Autorizado\"}]";
        return vResultado;
    }


/*
 * 
 *  Metodo para obtener los nombres de las firmas para el contrato
 */

private String getFirmas(String vOpcion){
    
    String vConsulta;
    interfaz_DB datos;
    datos=new interfaz_DB();
    ResultSet vFilas;
    String vResultado;
    
   
    vConsulta="select distinct nombre||'|'||trim(cargo) as firma,nombre from SIS_AUTH_CONTRATO_DATOS_VW\n" + 
    "where id_auth_contrato in \n" + 
    "(\n" + 
    "select id_auth_contrato from sis_auth_contrato auth\n" + 
    "where fecha_baja is null "+ "\n"+ 
    "and exists\n" + 
    "(\n" + 
    "        select 1 from partida part\n" + 
    "        where\n" + 
    "        d1=4 and d8 is null and d9d10 is null\n" + 
    "        and exists\n" + 
    "        (\n" + 
    "            select 1 from usuario_unidad b, partida c\n" + 
    "            where b.id_partida=c.id_partida\n" + 
    "            and usuario='" + vUsuario + "' \n"+
    "            and b.tipo_usuario='TRABAJADOR'\n" + 
    "            and sysdate between b.vigencia_de and nvl(b.vigencia_a,sysdate)\n" + 
    "            and part.aniomanual=c.aniomanual\n" + 
    "            and part.d1=c.d1\n" + 
    "            and part.d2=c.d2\n" + 
    "            and part.d3d4=c.d3d4\n" + 
    "            and \n" + 
    "            (\n" + 
    "                (\n" + 
    "                part.d7=c.d7\n" + 
    "                and part.d6=c.d6\n" + 
    "                and part.d5=c.d5\n" + 
    "                )\n" + 
    "                or\n" + 
    "                (\n" + 
    "                c.d5 is null\n" + 
    "                and c.d6 is null\n" + 
    "                and c.d7 is null \n" + 
    "                )\n" + 
    "            )\n" + 
    "        )\n" + 
    "and \n" + 
    "(\n" + 
    "    auth.id_dependencia=part.d3d4\n" + 
    "    or\n" + 
    "    (\n" + 
    "        auth.id_unidad_prog=to_number(part.d1||d2)\n" + 
    "        and auth.id_unidad_depen=part.d3d4\n" + 
    "        and auth.id_unidad=to_number(part.d5||d6||d7)\n" + 
    "    )\n" + 
    ")\n" + 
    ")        \n" + 
    ") order by nombre||'|'||trim(cargo) asc \n";
    
    try
    {
    
        vResultado="[";
        vFilas=datos.Bol_ejecutar_sentencia(vConsulta);
        while (vFilas.next())
        {            
            vResultado=vResultado+"{\"firma\":\""+enlace_datos.util.utils.getHTMLCode(vFilas.getString("firma").trim())+"\",\"nombre\":\""+vFilas.getString("nombre").trim()+"\"},";         
            
        }
        
        if (vResultado.length()>1)
        {
        
          vResultado=vResultado.substring(0,vResultado.length()-1)+"]";  
            
        }else{
            
            vResultado+="]";
        }
        
        datos.cn_Cerrar_coneccion();
        
    }catch(Exception exep)
    {
        datos.cn_Cerrar_coneccion();
        vResultado="[]";
        
    }
 
//System.out.println(" ------------ vusuario: "+vUsuario);   
//System.out.println(vConsulta);

return vResultado;    

}


    private String getPendRegPer(){
        String vConsulta="";
        interfaz_DB datos;
        datos=new interfaz_DB();
        ResultSet vFilas;
        String vResultado;

       
        vConsulta="select count(0) as cantidad from sis_empleado where id_estado IN (\n" + 
        "select id_estado from sis_estado_empleado_vw where nombre='ASIGNACION REGISTRO'\n" + 
        ")";
         
        vFilas=datos.Bol_ejecutar_sentencia(vConsulta);
       try{ 
       
            vResultado="[ ";
            while (vFilas.next())
            {            
               if (vFilas.getString("cantidad").equals("0"))
               {
                   
                vResultado=vResultado+"{\"resul\":\"no\",\"msg\":\"No hay registros de personal pendientes de revisar.\"},";         
                
               }else{
               
                vResultado=vResultado+"{\"resul\":\"ok\",\"msg\":\"Hay "+vFilas.getString("cantidad")+ " registros de personal pendientes de revisar.\"},";            
                   
               }
              
               
                
            }
        
           datos.cn_Cerrar_coneccion();
           
           if (vResultado.length()>1)
           {
           
             vResultado=vResultado.substring(0,vResultado.length()-1)+" ]";  
               
           }else
           {
               
               vResultado+="]";
           }
            
            
       }catch(Exception exep1)
       {
           datos.cn_Cerrar_coneccion();
           vResultado="[{ }]";
       
       }
        
        
        //vResultado="[{\"id\":\"1\",\"nom\":\"Autorizado\"}]";
        
        return vResultado;
    }


    private String VerificaNumCuenta2(String pCuenta){
        String vResultado,vResulWebService;
        webservices.PhoneVal.Phone3TSoapClient myPort;
        char v=13,x=44; 
        
        try{
            if (pCuenta == null || (pCuenta!=null && pCuenta.equals(""))){
                
                vResultado="{\"resul\":\"er\",\"msg\":\"" + "Ingrese el No. de cuenta."+"\"}";
            }
            else{
             
             if (utils.isNumber(pCuenta)) { // es numero
                 
              if (pCuenta.length()!=10){
                   
                   vResultado="{\"resul\":\"er\",\"msg\":\"" + "Ingrese el No. de cuenta monetaria de 10 digitos."+"\"}";
              
              }else{  // es numero 
                  
                  myPort = new webservices.PhoneVal.Phone3TSoapClient();
                  vResulWebService=myPort.phoneVerify(pCuenta).toString();
                  
                  vResulWebService=vResulWebService.replace("\"","");
                  vResulWebService=vResulWebService.replace(">","|");
                  vResulWebService=vResulWebService.replace("<","|");
                  vResulWebService=vResulWebService.replace("/","");
                  vResulWebService=vResulWebService.replace("=","");
                  vResulWebService=vResulWebService.replace("\n","");
                  
                  vResulWebService=vResulWebService.replace(v,x);
                  
                  if (vResulWebService.length()>180){
                     vResulWebService= vResulWebService.substring(0,180);
                      
                  }
                  
                  
                  vResultado="{\"resul\":\"ok\",\"msg\":\"" + vResulWebService+"\"}";

                  
              }
                 
             }else{ // no es numero
                 
                  vResultado="{\"resul\":\"er\",\"msg\":\"" + "Ingrese el No. de cuenta monetaria sin espacios ni guiones."+"\"}";
             }
               
            }
        
          //   vResultado="{\"resul\":\"ok\",\"msg\":\"" + "llamada ok"+"\"}";
            
        }catch(Exception  exep)
        {
        
            vResultado="{\"resul\":\"er\",\"msg\":\"" + " ** Error ****"+"\"}";
        }
        
        
      //  webservices.PhoneVal.Phone3TSoapClient myPort = new webservices.PhoneVal.Phone3TSoapClient();
      //  System.out.println("calling " + myPort.getEndpoint());
        //System.out.println("calling " + myPort.phoneVerify("305 5846985").toString());
        
        
      //  vResultado="[ ]"; 
        return vResultado;   
    }


private String VerificaNumCuenta3(String pCuenta){
    String vResultado,vResulWebService,vMensaje;
    webservices.ProxyBanrural.ValidarCuentaSoapHttpPortClient myPort;
    //webservices.PhoneVal.Phone3TSoapClient myPort;
    char v=13,x=44; 
    SOAPElement vBody;
    Iterator vChilds;
    SOAPElement vChild;
    boolean vResul;
    
    try{
        if (pCuenta == null || (pCuenta!=null && pCuenta.equals(""))){
            
            vResultado="{\"resul\":\"er\",\"msg\":\"" + "Ingrese el No. de cuenta."+"\"}";
        }
        else{
         
         if (utils.isNumber(pCuenta)) { // es numero
             
          if (pCuenta.length()!=10){
               
               vResultado="{\"resul\":\"er\",\"msg\":\"" + "Ingrese el No. de cuenta monetaria de 10 digitos."+"\"}";
          
          }else{  // es numero 
              
              myPort = new  webservices.ProxyBanrural.ValidarCuentaSoapHttpPortClient();
              vBody=myPort.validaCuenta2(pCuenta);
              
              vChilds=vBody.getChildElements();
              //vChild=
              vMensaje="NO HAY RESPUESTA DEL BANCO";
              vResultado="";
              vResul=false;
              
              while (vChilds.hasNext())
              {
                 
                  vChild=(SOAPElement)vChilds.next();
                  
                   if (vChild.getNodeName().equals("descripcion")){
                       vMensaje=vChild.getValue();
                       vResultado="{\"resul\":\"ok\",\"msg\":\"" + vMensaje+"\"}";
                       vResul=true;
                   }
              }
              
              if (vResul==false)
              {
              
                  vResultado="{\"resul\":\"er\",\"msg\":\"" + vMensaje+"\"}";
              }

              
          }
             
         }else{ // no es numero
             
              vResultado="{\"resul\":\"er\",\"msg\":\"" + "Ingrese el No. de cuenta monetaria sin espacios ni guiones."+"\"}";
         }
           
        }
    
      //   vResultado="{\"resul\":\"ok\",\"msg\":\"" + "llamada ok"+"\"}";
        
    }catch(Exception  exep)
    {
    
        vResultado="{\"resul\":\"er\",\"msg\":\"" + " ** Error ****"+"\"}";
    }
    
    
  //  webservices.PhoneVal.Phone3TSoapClient myPort = new webservices.PhoneVal.Phone3TSoapClient();
  //  System.out.println("calling " + myPort.getEndpoint());
    //System.out.println("calling " + myPort.phoneVerify("305 5846985").toString());
    
    
  //  vResultado="[ ]"; 
    return vResultado;   
}


    private String VerificaNumCuenta(String pCuenta,String pCedula,String pCUI,int opcion){
        String vResultado,vResulWebService,vMensaje;
        webservices.ProxyBanrural.ValidarCuentaSoapHttpPortClient myPort;
        //webservices.PhoneVal.Phone3TSoapClient myPort;
        char v=13,x=44; 
        SOAPElement vBody;
        Iterator vChilds;
        SOAPElement vChild;
        boolean vResul;
        
        //System.out.println(" "+pCuenta+ " "+pCedula+" "+pCUI);
        
        try{
            if (pCuenta == null || (pCuenta!=null && pCuenta.equals(""))){
                
                vResultado="{\"resul\":\"er\",\"msg\":\"" + "Ingrese el No. de cuenta."+"\"}";
            }
            else{
             
             if (utils.isNumber(pCuenta)) { // es numero
                 
              if (pCuenta.length()>14){ //la cuenta tenia un numero maximo de 10 digitos
                   
                   vResultado="{\"resul\":\"er\",\"msg\":\"" + "Ingrese el No. de cuenta monetaria de 10 digitos."+"\"}";
              
              }else{  // es numero 
                  
                  myPort = new  webservices.ProxyBanrural.ValidarCuentaSoapHttpPortClient();
                  if (opcion==1 && pCedula!=null && pCedula.length()>2)
                      vBody=myPort.validaCuentaBnrl(pCuenta,pCedula,"","","","123571113");
                  else
                      vBody=myPort.validaCuentaBnrl(pCuenta,"DPI "+pCUI,"","","","123571113");
                      
                  vChilds=vBody.getChildElements();
                  //vChild=
                  vMensaje="No hay respuesta del banco, intente nuevamente.";
                  vResultado="";
                  vResul=false;
                  vChild=(SOAPElement)vChilds.next();
                  vChilds=vChild.getChildElements();
                  
                  while (vChilds.hasNext())
                  {
                     
                      vChild=(SOAPElement)vChilds.next();
                      
                       if (vChild.getNodeName().equals("RESPUESTA")){
                           vMensaje=vChild.getValue();
                            if (vMensaje.equals("OK"))
                            {
                                vMensaje="Datos correctos!, Su Cuenta ha sido validada en Banrural";
                                vResultado="{\"resul\":\"ok\",\"msg\":\"" + vMensaje+"\"}";
                                vResul=true;     
                            }else if (vMensaje.equals("NO COINCIDE LA IDENTIFICACION")){
                                vMensaje=vMensaje+ ". Verifique por favor el No. de cuenta o su No. de DPI";
                                vResultado="{\"resul\":\"er\",\"msg\":\"" + vMensaje+"\"}"; 
                                if (opcion!=2)
                                vResultado=VerificaNumCuenta(pCuenta,null,pCUI.trim(),2);
                                
                                vResul=true;     
                            }else if (vMensaje.equals("CUENTA NO EXISTE")){
                                vMensaje=vMensaje+ ". Por favor verifique el No. de cuenta";
                                vResultado="{\"resul\":\"er\",\"msg\":\"" + vMensaje+"\"}"; 
                                vResul=true;     
                            }                            
                            else
                            {
                                vResul=true;     
                                vResultado="{\"resul\":\"er\",\"msg\":\"" + vMensaje+"\"}";
                                
                            }
                           
                       }
                  }
                  
                  if (vResul==false)
                  {
                  
                      vResultado="{\"resul\":\"er\",\"msg\":\"" + vMensaje+"\"}";
                  }

                  
              }
                 
             }else{ // no es numero
                 
                  vResultado="{\"resul\":\"er\",\"msg\":\"" + "Ingrese el No. de cuenta monetaria sin espacios ni guiones."+"\"}";
             }
               
            }
        
          //   vResultado="{\"resul\":\"ok\",\"msg\":\"" + "llamada ok"+"\"}";
            
        }catch(Exception  exep)
        {
        
            vResultado="{\"resul\":\"er\",\"msg\":\"" + " ** Error ****"+"\"}";
        }
        
        
      //  webservices.PhoneVal.Phone3TSoapClient myPort = new webservices.PhoneVal.Phone3TSoapClient();
      //  System.out.println("calling " + myPort.getEndpoint());
        //System.out.println("calling " + myPort.phoneVerify("305 5846985").toString());
        
        
      //  vResultado="[ ]"; 
        return vResultado;   
    }



private String getUsuariosxNombre(String  pUsuario){
        String vConsulta="";
        interfaz_DB datos;
        datos=new interfaz_DB();
        ResultSet vFilas;
        String vResultado="";

       
        vConsulta="select datos.nombre,datos.usuario from (\n" + 
        "select nombres ||' '||apellidos as nombre,usuario\n" + 
        "from\n" + 
        "usuario\n" + 
        "where\n" + 
        "tipo_usuario='TRABAJADOR'\n" + 
        "AND ACTIVO=1\n" + 
        ")datos\n" + 
        "where upper(nombre) like '%"+pUsuario.toUpperCase() +"%'\n" + 
        "AND rownum<=25\n" + 
        "ORDER BY NOMBRE";
        
       // System.out.println("consullll");
        
       if (pUsuario!=null && !pUsuario.equals(""))
       {
         
       vFilas=datos.Bol_ejecutar_sentencia(vConsulta);
       try{ 
       
                  
          while(vFilas.next())
           {
                        
             vResultado=vResultado+"{\"codigo\":\""+vFilas.getString("usuario")+"\",\"label\":\""+"["+vFilas.getString("nombre").trim()+"]"+vFilas.getString("usuario")+"\",\"cadenaDesti\":\""+vFilas.getString("usuario")+"\"}";
             vResultado=vResultado+",";
           }
                   
           if (!vResultado.equals("")){
            vResultado="["+vResultado.substring(0,vResultado.length()-1)+"]";
            }else{
             vResultado="[{}]";   
                       
              }
    
        
           datos.cn_Cerrar_coneccion();
           
            
       }catch(Exception exep1)
       {
           datos.cn_Cerrar_coneccion();
           vResultado="[{ }]";
       
       }
     }else {
         vResultado="[{ }]";
     }
        //vResultado="[{\"id\":\"1\",\"nom\":\"Autorizado\"}]";        
        return vResultado;
    }


public String getOrdenCedula(String pOrden) {
       String vOrdenCedula;
    
      vOrdenCedula="";
       if (pOrden!=null)
       {
       
         if (pOrden.equals("A1"))
           vOrdenCedula="A01";
         else if (pOrden.equals("B2"))  
           vOrdenCedula="B02";
         else if (pOrden.equals("C3"))  
           vOrdenCedula="C03";  
         else if (pOrden.equals("D4"))  
           vOrdenCedula="D04";    
         else if (pOrden.equals("E5"))  
           vOrdenCedula="E05";    
         else if (pOrden.equals("F6"))  
           vOrdenCedula="F06";
         else if (pOrden.equals("G7"))  
           vOrdenCedula="G07";  
         else if (pOrden.equals("H8"))  
           vOrdenCedula="H08";    
         else if (pOrden.equals("I9"))  
           vOrdenCedula="I09";      
         else
             vOrdenCedula=pOrden;        
           
       }    
    
        return vOrdenCedula;
    }
    
    
    
    public String getValidacionDescIGSS(String pIdComplemento){
        String vResultado="";
        interfaz_DB datos;
        datos = new interfaz_DB();
        ResultSet vFilas;
        
        String  vConsulta="select sis_complementos_pkg.validaCompDescIGSS("+pIdComplemento+") from dual";
        datos.Crear_sentencia(vConsulta);
        vFilas=datos.Bol_ejecutar_sentencia();
        try{ 
                    
            if (vFilas.next()){                            
                 vResultado="[{\"respuesta\":\""+vFilas.getString(1)+"\"}]";         
            }
            
            datos.cn_Cerrar_coneccion();
            }
            catch(Exception exep1){
                System.out.println(exep1.getStackTrace());
                datos.cn_Cerrar_coneccion();
                vResultado="[]";            
            }
        
        //vResultado="[{\"respuesta\":\""+"Comunicacion correcta "+pIdComplemento+"\"}]";         
        
        return vResultado;
    }


    public String getRemesasCompl(String pRemesa){
        String pPeriodoInicioIGSS = "01/08/2014"; // fecha a partir de que se empezo la planilla electronica
        String vResultado="";
        interfaz_DB datos;
        datos = new interfaz_DB();
        ResultSet vFilas;
        
        String vConsulta="select to_char(periodoPago,'mm')||'-'||to_char(periodoPago,'yyyy') periodo, periodoPago fecha_inicio, last_day(periodoPago) fecha_fin,\n" + 
        "(select r.id_remesa from sis_remesa r where r.periodo = to_char(periodoPago,'mm') and to_char(r.fecha_inicio,'yyyy')=to_char(periodoPago,'yyyy')) id_remesa\n" + 
        "from(\n" + 
        "select max((to_date(to_char((nom.periodo),'00')||'/'||(nom.correlativo),'mm/yyyy'))) periodoPago\n" + 
        "from sis_documento_banco doc, sis_pago pago, sis_nomina nom, \n" + 
        "sis_det_calculo_ajuste scal, sis_empleado ei\n" + 
        "where doc.id_documento_banco = pago.id_documento_banco\n" + 
        "and nom.id_nomina = pago.id_nomina\n" + 
        "and nom.registro_empleado= ei.registro_empleado\n" + 
        "and nom.id_tipo_nomina not in (2,3,5,6,8)\n" + 
        "and scal.id_nomina = nom.id_nomina\n" + 
        "and scal.id_ajuste in (21,25)\n" + 
        "and doc.id_remesa=" + pRemesa+" "+
        "and (\n" + 
        "  (doc.id_estado <> 17 and doc.fecha_anulacion is null)  \n" + 
        "  or\n" + 
        "  (doc.id_estado = 17 and  \n" + 
        "   (trunc(doc.fecha_anulacion) > trunc((select fecha_fin from sis_remesa where id_remesa="+pRemesa+")))\n" + 
        "  )\n" + 
        ")\n" + 
        "having (max((to_date(to_char((nom.periodo),'00')||'/'||(nom.correlativo),'mm/yyyy'))) >= to_date('"+pPeriodoInicioIGSS+"','dd/mm/yyyy')\n" + 
        "and max((to_date(to_char((nom.periodo),'00')||'/'||(nom.correlativo),'mm/yyyy'))) < (select to_date(to_char(periodo,'00')||'/'||to_char(fecha_inicio,'yyyy'),'mm/yyyy') from sis_remesa where id_remesa="+pRemesa+"))\n" + 
        "group by nom.periodo, nom.correlativo)\n" +
        "order by periodoPago";
        
        
        System.out.println(vConsulta);
        vFilas=datos.Bol_ejecutar_sentencia(vConsulta);
        try{ 
            
                   
            while(vFilas.next())
            {
                         
              vResultado=vResultado+vFilas.getString("id_remesa")+";"+vFilas.getString("periodo")+",";
            }
           
            if (!vResultado.equals("")){
                vResultado="[{\"respuesta\":\""+vResultado.substring(0,vResultado.length()-1)+"\"}]";
            }else{
                vResultado="[{}]";   
                        
            }            
         
            datos.cn_Cerrar_coneccion();
            
             
        }catch(Exception exep1)
        {
            datos.cn_Cerrar_coneccion();
            vResultado="[{ }]";
        
        }
        System.out.println(vResultado);
        return vResultado;
    }
    
    public String getRemesasCompl_Todo(String pRemesaActual, String dir, String dirReporteTexto, String pTipoCarga){
        String pPeriodoInicioIGSS = "01/08/2014"; // fecha a partir de que se empezo la planilla electronica
        String vResultado="";
        interfaz_DB datos;
        datos = new interfaz_DB();
        ResultSet vFilas;
        String nombre_archivo= "", pRemesa = "", pPeriodo = "", pInv = "inv", pCorrelativo = "";
        
        String vConsulta="select to_char(periodoPago,'mm') periodo,to_char(periodoPago,'yyyy') correlativo, periodoPago fecha_inicio, last_day(periodoPago) fecha_fin,\n" + 
        "(select r.id_remesa from sis_remesa r where r.periodo = to_char(periodoPago,'mm') and to_char(r.fecha_inicio,'yyyy')=to_char(periodoPago,'yyyy')) id_remesa\n" + 
        "from(\n" + 
        "select max((to_date(to_char((nom.periodo),'00')||'/'||(nom.correlativo),'mm/yyyy'))) periodoPago\n" + 
        "from sis_documento_banco doc, sis_pago pago, sis_nomina nom, \n" + 
        "sis_det_calculo_ajuste scal, sis_empleado ei\n" + 
        "where doc.id_documento_banco = pago.id_documento_banco\n" + 
        "and nom.id_nomina = pago.id_nomina\n" + 
        "and nom.registro_empleado= ei.registro_empleado\n" + 
        "and nom.id_tipo_nomina not in (2,3,5,6,8)\n" + 
        "and scal.id_nomina = nom.id_nomina\n" + 
        "and scal.id_ajuste in (21,25)\n" + 
        "and doc.id_remesa=" + pRemesaActual+" "+
        "and (\n" + 
        "  (doc.id_estado <> 17 and doc.fecha_anulacion is null)  \n" + 
        "  or\n" + 
        "  (doc.id_estado = 17 and  \n" + 
        "   (trunc(doc.fecha_anulacion) > trunc((select fecha_fin from sis_remesa where id_remesa="+pRemesaActual+")))\n" + 
        "  )\n" + 
        ")\n" + 
        "group by nom.periodo, nom.correlativo \n" +
        "having ( max((to_date(to_char((nom.periodo),'00')||'/'||(nom.correlativo),'mm/yyyy'))) "+
        "< (select to_date(to_char(periodo,'00')||'/'||to_char(fecha_inicio,'yyyy'),'mm/yyyy') from sis_remesa where id_remesa="+pRemesaActual+")))"+
        " order by periodoPago"
        ;
        
        
        //System.out.println(vConsulta);
        vFilas=datos.Bol_ejecutar_sentencia(vConsulta);
        
        boolean c1=false;    
        long vNumPaginasReporte;
        //String directorio =  getServletContext().getRealPath("")+"\\reportes\\reportes_texto\\";
        String directorio = dirReporteTexto;
         
        generar_reporte  reporteContrato=new generar_reporte();
        reporteContrato=new generar_reporte();
        
        HashMap parametrosReporte = new HashMap();
        reporteContrato.setParametros(parametrosReporte);
        
        util_zip salida= new util_zip();
        ArrayList archivos= new ArrayList();

        
        try{ 
            while(vFilas.next())
            {          
              vResultado=vResultado+vFilas.getString("id_remesa")+";"+vFilas.getString("periodo")+",";
                pRemesa = vFilas.getString("id_remesa");
                pPeriodo = vFilas.getString("periodo");
                pCorrelativo = vFilas.getString("correlativo");
                nombre_archivo="complementaria_"+pPeriodo+"-"+pCorrelativo+"_rem_"+pRemesaActual;
                if (pRemesa != null && pTipoCarga.equals("0")){
                 //   System.out.println(pPeriodo + " - "+pCorrelativo);
                    c1=reporteContrato.generarReportesRemesa(pRemesa, pRemesaActual, "reporte_igss_empleados_comp.jasper",dir, directorio, nombre_archivo+".txt",4,22);
                    if(c1){ archivos.add(directorio+nombre_archivo+".txt"); }
                    
                }else if (pRemesa == null && pTipoCarga.equals("1")){
                   // System.out.println(pPeriodo + " - "+pCorrelativo);
                    c1=reporteContrato.generarReportesRemesaInv(pRemesaActual, pPeriodo, pCorrelativo, "reporte_igss_empleados_compinv.jasper",dir, directorio, nombre_archivo+".txt",4,22);
                    if(c1){ archivos.add(directorio+nombre_archivo+".txt"); }
                }
               
                vNumPaginasReporte=reporteContrato.getNumPaginas();   
                System.out.println(nombre_archivo);
                
                
            }
            
           salida.setBorrarFuentes(true);
            nombre_archivo="complementaria_rem_"+pRemesaActual;
            if (archivos.size() > 0 && salida.crear_zip(directorio+nombre_archivo+".zip",archivos)){
                System.out.println(archivos.size());
                vResultado = nombre_archivo+".zip";
               //utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Reporte Generado: "+nombre_archivo+".zip [Numero de Archivos:" +archivos.size()+"]"));   
            }else{
                System.out.println("error de generar archivo");
            }
            
           
            if (vResultado.equals("")){
                vResultado = "error";
            }            
         
            datos.cn_Cerrar_coneccion();
            
             
        }catch(Exception exep1)
        {
            datos.cn_Cerrar_coneccion();
            vResultado="error";
        
        }
        
        vResultado="[{\"respuesta\":\""+vResultado+"\"}]";            
        //System.out.println(vResultado);
        return vResultado;
    }
    
    public String getRemesasCompl_Txt(String pRemesaActual, String dir, String dirReporteTexto, String pTipoCarga){
        String pPeriodoInicioIGSS = "01/08/2014"; // fecha a partir de que se empezo la planilla electronica
        String vResultado="";
        interfaz_DB datos;
        datos = new interfaz_DB();
        ResultSet vFilas;
        String nombre_archivo= "", pRemesa = "", pPeriodo = "", pInv = "inv", pCorrelativo = "";
        
        String vConsulta="select to_char(periodoPago,'mm')||'-'||to_char(periodoPago,'yyyy') periodo, to_char(periodoPago,'yyyy') correlativo, periodoPago fecha_inicio, last_day(periodoPago) fecha_fin,\n" + 
        "(select r.id_remesa from sis_remesa r where r.periodo = to_char(periodoPago,'mm') and to_char(r.fecha_inicio,'yyyy')=to_char(periodoPago,'yyyy')) id_remesa\n" + 
        "from(\n" + 
        "select max((to_date(to_char((nom.periodo),'00')||'/'||(nom.correlativo),'mm/yyyy'))) periodoPago\n" + 
        "from sis_documento_banco doc, sis_pago pago, sis_nomina nom, \n" + 
        "sis_det_calculo_ajuste scal, sis_empleado ei\n" + 
        "where doc.id_documento_banco = pago.id_documento_banco\n" + 
        "and nom.id_nomina = pago.id_nomina\n" + 
        "and nom.registro_empleado= ei.registro_empleado\n" + 
        "and nom.id_tipo_nomina not in (2,3,5,6,8)\n" + 
        "and scal.id_nomina = nom.id_nomina\n" + 
        "and scal.id_ajuste in (21,25)\n" + 
        "and doc.id_remesa=" + pRemesaActual+" "+
        "and (\n" + 
        "  (doc.id_estado <> 17 and doc.fecha_anulacion is null)  \n" + 
        "  or\n" + 
        "  (doc.id_estado = 17 and  \n" + 
        "   (trunc(doc.fecha_anulacion) > trunc((select fecha_fin from sis_remesa where id_remesa="+pRemesaActual+")))\n" + 
        "  )\n" + 
        ")\n" + 
        "having (max((to_date(to_char((nom.periodo),'00')||'/'||(nom.correlativo),'mm/yyyy'))) >= to_date('"+pPeriodoInicioIGSS+"','dd/mm/yyyy')\n" + 
        "and max((to_date(to_char((nom.periodo),'00')||'/'||(nom.correlativo),'mm/yyyy'))) < (select to_date(to_char(periodo,'00')||'/'||to_char(fecha_inicio,'yyyy'),'mm/yyyy') from sis_remesa where id_remesa="+pRemesaActual+"))\n" + 
     
        "group by nom.periodo, nom.correlativo)\n" + 
        "order by periodoPago";
        
        
          System.out.println(vConsulta);
        vFilas=datos.Bol_ejecutar_sentencia(vConsulta);
        
        boolean c1=false;    
        long vNumPaginasReporte;
        //String directorio =  getServletContext().getRealPath("")+"\\reportes\\reportes_texto\\";
        String directorio = dirReporteTexto;
         
        generar_reporte  reporteContrato=new generar_reporte();
        reporteContrato=new generar_reporte();
        
        HashMap parametrosReporte = new HashMap();
        reporteContrato.setParametros(parametrosReporte);
        
        util_zip salida= new util_zip();
        ArrayList archivos= new ArrayList();

        
        try{ 
            while(vFilas.next())
            {          
              vResultado=vResultado+vFilas.getString("id_remesa")+";"+vFilas.getString("periodo")+",";
                pRemesa = vFilas.getString("id_remesa");
                pPeriodo = vFilas.getString("periodo");
                pCorrelativo = vFilas.getString("correlativo");
                nombre_archivo="remesa_complementaria_"+pPeriodo+"-"+pCorrelativo+"_rem_"+pRemesaActual;
                if (pRemesa != null && pTipoCarga.equals("0")){
                 //   System.out.println(pPeriodo + " - "+pCorrelativo);
                    c1=reporteContrato.generarReportesRemesaTXT(pRemesa, pRemesaActual, "remesa_planilla_igss_complementaria_texto.jasper",dir, directorio, nombre_archivo+".txt",8,11, new Integer(pTipoCarga));
                    if(c1){ archivos.add(directorio+nombre_archivo+".txt"); }
                    
                }else if  (pRemesa != null && pTipoCarga.equals("2")){
                    nombre_archivo="complementaria_"+pRemesa+"_rem_"+pRemesaActual+".txt"; 
                    c1=reporteContrato.generarReportesRemesaTXT(pRemesa, pRemesaActual, "remesa_planilla_igss_complementaria.jasper",dir, directorio, nombre_archivo,8,11, new Integer(pTipoCarga));
                    if(c1){ archivos.add(directorio+nombre_archivo+".pdf"); }
                }
                vNumPaginasReporte=reporteContrato.getNumPaginas();                 
                
            }
            
           salida.setBorrarFuentes(true);
            nombre_archivo="complementaria_rem_"+pRemesaActual;
            if (archivos.size() > 0 && salida.crear_zip(directorio+nombre_archivo+".zip",archivos)){
             //   System.out.println(archivos.size());
                vResultado = nombre_archivo+".zip";  
            }else{
                System.out.println("error de generar archivo");
            }
            
           
            if (vResultado.equals("")){
                vResultado = "error";
            }            
         
            datos.cn_Cerrar_coneccion();
            
             
        }catch(Exception exep1)
        {
            datos.cn_Cerrar_coneccion();
            vResultado="error";
        
        }
        
        vResultado="[{\"respuesta\":\""+vResultado+"\"}]";            
        //System.out.println(vResultado);
        return vResultado;
    }
    
    public String getRemesasCompl_EliminarArch(String pRemesaActual, String dir, String dirReporteTexto,  HttpServletResponse response){
        String vResultado="0";
        //String directorio =  getServletContext().getRealPath("")+"\\reportes\\reportes_texto\\";
        String directorio = dirReporteTexto;
        String nombre_archivo="complementaria_rem_"+pRemesaActual;
        util_zip salida= new util_zip();
        
      
        try{      
            if (salida.eliminar_zip(directorio+nombre_archivo+".zip")){
                vResultado = "1";
            } else {
                vResultado = "0";
            }   
                
            vResultado="[{\"respuesta\":\""+vResultado+"\"}]";
            
        }catch(Exception exep1)
        {
            vResultado="[{\"respuesta\":\""+vResultado+"\"}]";
        
        }
        //System.out.println(vResultado);
        return vResultado;
    }
    
   

    private static void funcionEliminarCarpeta1(File pArchivo, String Folder) {
        String ruta ;
        if (!pArchivo.exists()) { return; }

        if (pArchivo.isDirectory()) {
            for (File f : pArchivo.listFiles()) {
                ruta = Folder + ".svn";
                if (!pArchivo.getPath().equals(ruta))
                    funcionEliminarCarpeta1(f, Folder);  
            }
        }
        
        ruta = pArchivo.getPath()+"\\";
        if (!ruta.equals(Folder))
            pArchivo.delete();
    } // Cerramos funcion. 
    
    
    public String getValidaNomina(String pIdValor, String pNominal, String pOpcion){
        String vResultado="";
        interfaz_DB datos;
        datos = new interfaz_DB();
        ResultSet vFilas;
        
        
        
        
        String  vConsulta="select sis_pkg_util.getSobrePagoNomina("+pIdValor+","+pNominal+",'"+pOpcion+"') from dual";
        datos.Crear_sentencia(vConsulta);
        vFilas=datos.Bol_ejecutar_sentencia();
        try{ 
                    
            if (vFilas.next()){                            
                 vResultado="[{\"respuesta\":\""+vFilas.getString(1)+"\"}]";         
            }
            
            datos.cn_Cerrar_coneccion();
        }
        catch(Exception exep1){
            System.out.println(exep1.getStackTrace());
            datos.cn_Cerrar_coneccion();
            vResultado="[]";            
        }   
        
        return vResultado;
    }
    
    public String getValidacionReintegro(String pIdReintegro){
        String vResultado="";
        interfaz_DB datos;
        datos = new interfaz_DB();
        ResultSet vFilas;
        
        String  vConsulta="select sis_pkg_pagos.validaReintegro("+pIdReintegro+") from dual";
        datos.Crear_sentencia(vConsulta);
        vFilas=datos.Bol_ejecutar_sentencia();
        try{ 
                    
            if (vFilas.next()){                            
                 vResultado="[{\"respuesta\":\""+vFilas.getString(1)+"\"}]";         
            }
            
            datos.cn_Cerrar_coneccion();
            }
            catch(Exception exep1){
                System.out.println(exep1.getStackTrace());
                datos.cn_Cerrar_coneccion();
                vResultado="[]";            
            }
        
        //vResultado="[{\"respuesta\":\""+"Comunicacion correcta "+pIdComplemento+"\"}]";         
        
        return vResultado;
    }
}
