<%@ page isErrorPage="true" contentType="text/html;charset=utf-8"%>
<jsp:directive.page import="oracle.security.jazn.resources.FrameworkResourceBundle" />
<jsp:directive.page import="oracle.security.jazn.util.Resources" />
<jsp:directive.page import="oracle.security.jazn.JAZNException" />
<jsp:directive.page import="pkg_util_base_datos.interfaz_DB" />

<jsp:declaration>
public String getCookie(String pNombre,Cookie [] pValores)
   {
     String vValor="";
   
    for( int i=0;i<pValores.length;i++)
    {
            
          if ( pValores[i].getName().equals(pNombre))
          {
            vValor= pValores[i].getValue();
             break;
          }
    
   
   }
    return vValor;
  
   }

</jsp:declaration>

<jsp:scriptlet>

   String vMensaje;
   Boolean vResetearPassword;
   
   FrameworkResourceBundle _bundle = FrameworkResourceBundle.getResourceBundle(request.getLocales());
   interfaz_DB conexion = new interfaz_DB();
   Cookie vCookies[];
   Object vConsulta;
   String vUsuario,vPasss;
   String [] vRespuesta;
   vCookies=request.getCookies();
   vMensaje="Por favor revise su usuario y contraseña.";
   
   
   vUsuario=getCookie("_ux",vCookies);
   vPasss=getCookie("_px",vCookies);
   vResetearPassword=false;  
   request.getSession().setAttribute("pUsuario",vUsuario);
     
  conexion.Crear_sentencia("select (select count(0) from usuario where tipo_usuario='TRABAJADOR' and usuario=?)||','||  (select count(0) from usuario where tipo_usuario='TRABAJADOR' and usuario=? and password=? ) as argumento from dual");   
  conexion.setParametrosSentencia(1,"String",vUsuario);
  conexion.setParametrosSentencia(2,"String",vUsuario);
  conexion.setParametrosSentencia(3,"String",vPasss);  
  vConsulta=conexion.getValorConsulta("argumento");
  conexion.cn_Cerrar_coneccion();
  
   if (vConsulta!=null){
     
     vRespuesta=vConsulta.toString().split("\\,");
     
     if (vRespuesta[0].equals("0"))
     {
       vMensaje="Verifique el usuario, no existe!";
       
     }else if (vRespuesta[1].equals("0"))
     {
       vMensaje="Verifique el password, no es correcto!.";
       vResetearPassword=true;
     }
     
     
   }
  
  
  // borrando los cookies
  Cookie[] cookies = request.getCookies();
    if(cookies!=null)
    {
        for (int i = 0; i < cookies.length; i++) 
        {
          if (cookies[i].getName().equals("_ux") || cookies[i].getName().equals("_px") )
          {
             cookies[i].setValue("1");
             cookies[i].setMaxAge(0);
             response.addCookie(cookies[i]);        
          }
            
        }
    }
        
        
</jsp:scriptlet>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="<%=_bundle.getResourceLocale().getLanguage()%>">
  <head>
    <title><%= "Autenticar Usuario" %></title>
    <style type="text/css">
      .TableStyle { 
         background-color: #e8eefa;
         border-color: #C3D9FF;
         border-width: 1px;
         border-style: solid;
      }
      .AllText {
         font-family: Arial, Helvetica, Geneva, sans-serif times;
         font-size: 10pt;
      }
      .Form {
         background-color: #ffffff; 
         border-color: #C3D9FF;
         border-width: 1px;
      }
      .ErrorMsg { 
         font-family: Arial, Helvetica, Geneva, sans-serif; 
         font-size: 14pt;
         color: #ff0000;
      }
      .Title { 
         color: #336699; 
         font-family: Arial, Helvetica, Geneva, sans-serif times;
         font-size: 20pt;
      }
    </style>
  </head>
  <body class="AllText">
   <center>
    <br/><br/>
    <br/>

    <p/>
     <table cellspacing="0" cellpadding="0"
               border="0" align="center" width="50%">
      <tr align="center">
      <td>
      <img alt="Escudo USAC" src="/Nomina/imagenes/bannerprincipal.jpg" />
      </td>
      </tr>
      </table>
    <table class="TableStyle" width="640">
      <tr align="center">
         <td>&nbsp;&nbsp;</td>
      </tr>
      <tr>
         <td class="ErrorMsg" align="center">
         <%= "No Se Autentico El Usuario" %>
         </td>
      </tr>
      <tr align="center">
         <td>&nbsp;&nbsp;</td>
      </tr>
      <tr>
         <td>      
            <div align="center">
      <%= vMensaje   %>
            </div>
         </td>
      </tr>
      <tr align="center">
         <td>&nbsp;&nbsp;&nbsp;
            <a href="/Nomina/faces/inicio.jspx">
             Intentar nuevamente
            </a>           
          </td>
      </tr>
      <tr align="center">
         <td>&nbsp;&nbsp;</td>
      </tr>
      <tr>
     <%
       if (vResetearPassword==true) {
     %>
      
       <tr align="center">
         <td>&nbsp;&nbsp;&nbsp;
            <a href="/Nomina/verificar.jsp">
             Para resetear el password a CLV haga clic aqui!
            </a>           
          </td>
      </tr>
      <tr align="center">
         <td>&nbsp;&nbsp;</td>
      </tr>
      <tr align="center">
         <td>&nbsp;&nbsp;</td>
      </tr>
      <tr align="center">
         <td>&nbsp;&nbsp;</td>
      </tr>
      <%
       }
     %>
    </table>
   </center>
  </body>
</html>
